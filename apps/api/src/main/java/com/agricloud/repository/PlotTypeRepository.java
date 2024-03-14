package com.agricloud.repository;

import com.agricloud.model.PlotTypeModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PlotTypeRepository extends CrudRepository<PlotTypeModel, Integer> {

    List<PlotTypeModel> findAllByDefaultConfigid(int defaultConfigID);
}
