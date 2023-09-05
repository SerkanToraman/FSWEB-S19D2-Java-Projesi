package com.workintechs23g2session.project.controller;

import com.workintechs23g2session.project.entity.Account;
import com.workintechs23g2session.project.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
public class AccountController {
    private AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/")
    public List<Account> findAll(){
        return accountService.findAll();
    }

    @GetMapping("/{id}")
    public Account findById(@PathVariable int id){
        return accountService.findById(id);
    }

    @PostMapping("/")
    public Account save(@RequestBody Account account){
        return accountService.save(account);
    }

    @PutMapping("/{id}")
    public Account save(@RequestBody Account account, @PathVariable int id){
        Account foundAccount = accountService.findById(id);
        if(foundAccount != null){
            account.setId(id);
            return accountService.save(account);
        }
        //throw Exception
        return null;
    }

    @DeleteMapping("/{id}")
    public Account delete(@PathVariable int id){
        return accountService.delete(id);
    }
}
