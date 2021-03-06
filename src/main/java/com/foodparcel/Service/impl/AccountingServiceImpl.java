package com.foodparcel.Service.impl;

import com.foodparcel.Repository.AccountingRepository;
//import com.foodparcel.Repository.impl.AccountingRepositoryImpl;
import com.foodparcel.Service.AccountingService;
import com.foodparcel.entity.Accounting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Author: Amy Johnston (218188773)
 * AccountingServiceImpl.java
 * Submission 8
 * Date: 1 September 2020
 * Edited: 25 October 2020
 */
@Service
public class AccountingServiceImpl implements AccountingService {
    @Autowired
    private AccountingRepository accountingRepository;

    @Override
    public Set<Accounting> getAll() {
        return this.accountingRepository.findAll().stream().collect(Collectors.toSet());
    }

    //unique business logic as per Accounting -> when we make a Profit
    //implementing it here is currently not expensive as we only have a few records (not like a million in the database)
    //must add this to the repository if it becomes expensive
    @Override
    public Set<Accounting> getAllProfits() {
        Set<Accounting> account = getAll();
        Set<Accounting> profit = new HashSet<>();
        for(Accounting accounting : account){
            if(accounting.getIncome() > accounting.getExpense()){
                profit.add(accounting);
            }
        }
        return profit;
    }

    @Override
    public Accounting create(Accounting accounting) {
        return this.accountingRepository.save(accounting);
    }

    @Override
    public Accounting read(String s) {
        return this.accountingRepository.findById(s).orElseGet(null);
    }

    @Override
    public Accounting update(Accounting accounting) {
        if(this.accountingRepository.existsById(accounting.getStatementId())){
            return this.accountingRepository.save(accounting);
        }
        return null;
    }

    @Override
    public void delete(String s) {
        this.accountingRepository.deleteById(s);
    }
}

