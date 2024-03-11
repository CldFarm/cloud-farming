package com.agricloud.repository;

import org.springframework.data.repository.CrudRepository;

import com.agricloud.model.PlotModel;

public interface PlotRepository extends CrudRepository<PlotModel, Integer> {}
