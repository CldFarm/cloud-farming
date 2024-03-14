package com.agricloud.repository;

import com.agricloud.model.ConfigModel;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ConfigRepository extends CrudRepository<ConfigModel, Integer> {
    List<ConfigModel> findAllByAccountIDOrAccountIDIsNull(Integer accountID);
    ConfigModel findConfigByConfigID(Integer configID);
}