package org.cent.demo.mapper;

import org.cent.demo.entity.Account;

public interface AccountMapper {
    public Account getAccount(long number);

    public int addAccount(Account account);

    public int updateAccount(Account account);

    public int deleteAccount(Account account);
}
