package com.haha.pt.service.impl;

import com.haha.pt.dao.AccountDao;
import com.haha.pt.entity.Account;
import com.haha.pt.service.TransferService;

public class TransferServiceImpl implements TransferService {

    private AccountDao accountDao;
    // 构造函数传值/set方法传值
    public void setAccountDao(AccountDao accountDao) {
        this.accountDao = accountDao;
    }


    @Override
    public void transfer(String fromCardNo, String toCardNo, int money) throws Exception {
        Account from = accountDao.queryAccountByCardNo(fromCardNo);
        Account to = accountDao.queryAccountByCardNo(toCardNo);

        from.setMoney(from.getMoney()-money);
        to.setMoney(to.getMoney()+money);

        accountDao.updateAccountByCardNo(to);
        int c = 1/0;
        accountDao.updateAccountByCardNo(from);
    }
}
