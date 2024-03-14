package com.agricloud.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.agricloud.model.AccountModel;


public interface AccountRepository extends CrudRepository<AccountModel, Integer> {
    
    Optional<AccountModel> findByAccountUID(String accountUID);

}
