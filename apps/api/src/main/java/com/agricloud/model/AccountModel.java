package com.agricloud.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "account")
@Data
@NoArgsConstructor
public class AccountModel {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer accountID;

    @Column(name = "account_uid")
    private String accountUID;

}
