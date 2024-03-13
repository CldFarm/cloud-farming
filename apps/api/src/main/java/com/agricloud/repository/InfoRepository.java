package com.agricloud.repository;

import org.springframework.data.repository.CrudRepository;

import com.agricloud.model.RegionModel;

public interface InfoRepository extends CrudRepository<RegionModel, Integer> {}
