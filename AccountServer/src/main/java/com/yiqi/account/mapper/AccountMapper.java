package com.yiqi.account.mapper;

import com.yiqi.account.entity.Account;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountMapper {

    int insertAccount(Account account);
    int insertAccounts(List<Account> accounts);

    Account queryByNicknameAndPassword(String nickname, String password);
    List<Account> queryAll(int pageCount, int pageIndex);

    int updateAccount(Account account);
    void truncate();
}
