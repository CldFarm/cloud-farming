package com.agricloud.repository;

import org.springframework.data.repository.CrudRepository;

import com.agricloud.model.PlotModel;

import java.util.List;

public interface PlotRepository extends CrudRepository<PlotModel, Integer> {

    List<PlotModel> findPlotModelsByConfigID(Integer configID);
}
