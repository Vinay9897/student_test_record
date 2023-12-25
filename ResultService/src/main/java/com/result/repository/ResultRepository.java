package com.result.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.result.entities.ResultEntity;

public interface ResultRepository extends JpaRepository<ResultEntity, Long> {

}
