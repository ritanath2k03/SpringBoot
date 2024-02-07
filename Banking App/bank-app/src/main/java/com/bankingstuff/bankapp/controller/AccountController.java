package com.bankingstuff.bankapp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankingstuff.bankapp.model.Account;
import com.bankingstuff.bankapp.service.MyAccountService;

import lombok.NoArgsConstructor;

@RestController
@RequestMapping("/bank")
@NoArgsConstructor
public class AccountController {

    @Autowired
    MyAccountService service;

    @Autowired
    public AccountController(MyAccountService service) {
        this.service = service;
    }

    @PostMapping("/create")
    public Account creation(@RequestBody Account account) {
        System.out.println(account);
        return service.createAccount(account);
    }

    @GetMapping("/fetch/{id}")
    public Account fetch(@PathVariable Long id) {
        return service.getAccount(id);
    }

    @DeleteMapping("/account/{id}")
    public ResponseEntity<String> deletion(@PathVariable Long id) {

        service.deleteAccount(id);
        return ResponseEntity.ok(id + "Deleted ");
    }

    @PutMapping("/{id}/deposite")
    public Account deposite(@PathVariable Long id, @RequestBody Map<String, Double> req) {
        Double amount = req.get("amount");
        System.out.println("amount in controller " + amount);
        System.out.println("req in controller " + req);
        return service.deposite(id, amount);

    }

}
