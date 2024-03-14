package com.agricloud.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agricloud.model.AccountModel;
import com.agricloud.repository.AccountRepository;

@Service
public class AccountService {
    
    @Autowired
    private AccountRepository accountRepository;

    public Integer accountID(String accountUID) { 

        if (accountUID.length() != 21) {
            return null;
        }

        Integer accID = accountRepository.findByAccountUID(accountUID).map((acc) -> acc.getAccountID()).orElse(null);

        if (accID == null) {

            AccountModel accountModel = new AccountModel();
            accountModel.setAccountUID(accountUID);
            accountRepository.save(accountModel);
            accID = accountModel.getAccountID();

        }

        return accID;
    }

}
