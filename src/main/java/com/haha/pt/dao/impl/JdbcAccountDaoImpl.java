package com.haha.pt.dao.impl;

import com.haha.pt.dao.AccountDao;
import com.haha.pt.entity.Account;
import com.haha.pt.utils.ConnectionUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class JdbcAccountDaoImpl implements AccountDao {
    private ConnectionUtils connectionUtils;

    public void setConnectionUtils(ConnectionUtils connectionUtils){
        this.connectionUtils = connectionUtils;

    }

    @Override
    public Account queryAccountByCardNo(String cardNo) throws Exception {
        Connection conn = connectionUtils.getCurrentThreadConn();
        String sql = "select * from account where cardNo=?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setString(1,cardNo);
        ResultSet resultSet = preparedStatement.executeQuery();

        Account account = new Account();
        while (resultSet.next()){
            account.setCardNo(resultSet.getString("cardNo"));
            account.setMoney(resultSet.getInt("money"));
            account.setName(resultSet.getString("name"));
        }
        resultSet.close();
        preparedStatement.close();

        return account;
    }

    @Override
    public int updateAccountByCardNo(Account account) throws Exception {
        Connection conn = connectionUtils.getCurrentThreadConn();
        String sql = "update account set money=? where cardNo=?";
        PreparedStatement preparedStatement = conn.prepareStatement(sql);
        preparedStatement.setInt(1,account.getMoney());
        preparedStatement.setString(2,account.getCardNo());
        int i = preparedStatement.executeUpdate();
        preparedStatement.close();
        return i;
    }
}
