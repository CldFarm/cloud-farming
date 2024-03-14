package com.agricloud.repository;

import org.springframework.data.repository.CrudRepository;

import com.agricloud.model.PlotModel;

import java.util.List;
import java.util.Optional;

public interface PlotRepository extends CrudRepository<PlotModel, Integer> {

    List<PlotModel> findPlotModelsByConfigID(Integer configID);

    Optional<PlotModel> findPlotModelByAccountIDAndPlotName(Integer accountID, String plotName);
}
