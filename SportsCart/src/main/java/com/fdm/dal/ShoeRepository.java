package com.fdm.dal;

import org.springframework.data.repository.CrudRepository;

import com.fdm.models.Shoe;

public interface ShoeRepository extends CrudRepository<Shoe, Long> {

}
