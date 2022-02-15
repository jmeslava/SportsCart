package com.fdm.dal;

import org.springframework.data.repository.CrudRepository;

import com.fdm.models.Ball;

public interface BallRepository extends CrudRepository<Ball, Long> {

}
