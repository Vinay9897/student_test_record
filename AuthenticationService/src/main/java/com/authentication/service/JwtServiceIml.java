package com.authentication.service;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

@Service
public class JwtServiceIml {
	
	@Value("${jwt.secret}")
	private String secret;

	private String generateToken(UserDetails userDetails) {
		return Jwts.builder().setSubject(userDetails.getUsername())
				.setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 6))
				.signWith(getSignKey(), SignatureAlgorithm.RS256).compact();
	}
	
	private String extractUserName(String token) {
		return  extractClaims(token, Claims::getSubject);
	}
	
	private <T> T extractClaims(String token, Function<Claims, T> claimsResolver){
		final Claims claims= extractAllClaims(token);
		return claimsResolver.apply(claims);
	}

	private Claims extractAllClaims(String token) {
		return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
	}

	private Key getSignKey() {
		byte[] key = Decoders.BASE64.decode(secret);
		return Keys.hmacShaKeyFor(key);
	}
	
	public boolean isTokenValid(String token, UserDetails userDetails) {
		final String username  = extractUserName(token);
		return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	}

	private boolean isTokenExpired(String token) {
		return extractClaims(token, Claims::getExpiration).before(new Date());
	}
}
