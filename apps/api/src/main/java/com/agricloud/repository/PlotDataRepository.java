package com.agricloud.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.agricloud.model.PlotDataModel;

public interface PlotDataRepository extends CrudRepository<PlotDataModel, Integer> {

    @Query("SELECT pd FROM PlotDataModel pd WHERE pd.plotID = ?1 AND pd.timeTaken >= ?2")
    public List<PlotDataModel> getPlotDataForPastHours(Integer plotID, Date timeFrom);

}
