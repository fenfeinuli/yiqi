package com.yiqi.account.dao;

import com.yiqi.account.mapper.AccountMapper;
import com.yiqi.account.entity.Account;
import org.junit.jupiter.api.*;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Iterator;
import java.util.List;

@MapperScan("com.yiqi.account.mapper")
@SpringBootTest
public class AccountDaoTest {
    @Autowired
    private AccountMapper accountMapper;
    private Logger logger = LoggerFactory.getLogger(AccountDaoTest.class);

    @Test
    public void insertAccount(){
        Account account = new Account();
        account.setNickname("光阴的故事");
        account.setPassword("xiaoqi5615");

        accountMapper.insertAccount(account);
        logger.info(account.toString());
        logger.info("===============================");
        queryAll();
    }

    @Test
    public void queryAll(){
        List<Account> accounts = accountMapper.queryAll(100, 0);

        Iterator<Account> iter = accounts.iterator();
        while(iter.hasNext()){
            logger.info(iter.next().toString());
        }
    }

    @Test
    public void truncate(){
        accountMapper.truncate();
    }
}
