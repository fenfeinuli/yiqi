package com.yiqi.account.controller;

import com.alibaba.fastjson.JSONObject;
import com.yiqi.account.mapper.AccountMapper;
import com.yiqi.account.entity.Account;
import com.yiqi.account.model.Gender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v0/account")
public class AccountController {
    @Autowired
    private AccountMapper accountMapper;

    @PostMapping(value = "/demo", produces = "application/json;charset=UTF-8")
    public Map<String, Object> demo(@RequestBody JSONObject jsonParam){
        Map<String, Object> result = new HashMap<>();

        System.out.println("gender="+jsonParam.toJSONString());
        result.put("error", 200);
        result.put("message", "注册成功");
        result.put("data", 1);
        return result;
    }

    @PostMapping("/register")
    public Map<String, Object> register(
            @RequestParam String nickname,
            @RequestParam String password,
            @RequestParam(required = false) Integer gender,
            @RequestParam(required = false) String fullname
    ){
        Map<String, Object> result = new HashMap<>();
        Account account = new Account();
        account.setGender(Gender.values()[gender]);
        account.setNickname(nickname);
        account.setPassword(password);
        account.setFullname(fullname);

        accountMapper.insertAccount(account);

        result.put("error", 200);
        result.put("message", "注册成功");
        Map<String, Object> data = new HashMap<>();
        data.put("id", account.getId());
        result.put("data", data);
        return result;
    }

    @PostMapping("/login")
    public Map<String, Object> login(
            @RequestParam String nickname,
            @RequestParam String password
    ){
        Map<String, Object> result = new HashMap<>();
        Map<String, Object> data = new HashMap<>();
        Account account = accountMapper.queryByNicknameAndPassword(nickname, password);

        if (account != null) {
            result.put("error", 200);
            result.put("message", "登录成功");
            data.put("id", account.getId());
        } else {
            result.put("error", 200);
            result.put("message", "用户名或密码有误");
        }
        result.put("data", data);
        return result;
    }
}
