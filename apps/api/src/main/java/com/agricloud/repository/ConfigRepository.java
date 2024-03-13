package com.agricloud.repository;

import com.agricloud.model.ConfigModel;
import org.springframework.data.repository.CrudRepository;

public interface ConfigRepository extends CrudRepository<ConfigModel, Integer> {

    ConfigModel findConfigByConfigID(Integer configID);
}