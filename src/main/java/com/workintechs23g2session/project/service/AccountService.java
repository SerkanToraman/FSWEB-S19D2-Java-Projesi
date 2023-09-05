package com.workintechs23g2session.project.service;

import com.workintechs23g2session.project.entity.Account;

import java.util.List;

public interface AccountService {
    List<Account> findAll();
    Account findById(int id);
    Account save(Account account);
    Account delete(int id);
}
