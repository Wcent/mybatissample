package org.cent.demo;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.cent.demo.entity.Account;
import org.cent.demo.mapper.AccountMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;

/**
 * A demo of using mybatis
 *
 */
public class App 
{
    private static final Logger logger = LoggerFactory.getLogger(App.class);
    private static final String config_name = "mybatis-config.xml";
    private static SqlSessionFactory sqlSessionFactory;

    public static void main( String[] args ) throws IOException {
        logger.info("Go testing mybatis");

        InputStream inputStream = Resources.getResourceAsStream(config_name);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        try (SqlSession sqlSession = sqlSessionFactory.openSession()) {
            AccountMapper accountMapper = sqlSession.getMapper(AccountMapper.class);

            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            Account account = new Account();
            account.setId("acc#"+timestamp.getTime());
            account.setName("acc#name");
            account.setNumber(1234567890);
            account.setCreateAt(timestamp.toString());
            account.setUpdateAt(timestamp.toString());
            account.setVersion(0);
            accountMapper.addAccount(account);
            sqlSession.commit();
            logger.info("insert an account: "+account);

            Account sameAccount = accountMapper.getAccount(account.getNumber());
            logger.info("select the account: "+sameAccount);

            sameAccount.setName("acc#newname");
            sameAccount.setUpdateAt(new Timestamp(System.currentTimeMillis()).toString());
            sameAccount.setVersion(sameAccount.getVersion()+1);
            accountMapper.updateAccount(sameAccount);
            sqlSession.commit();
            logger.info("update the account");
            logger.info("before: "+account);
            logger.info("after: "+sameAccount);

            accountMapper.deleteAccount(account);
            sqlSession.commit();
            logger.info("delete the account: "+account);

            sameAccount = accountMapper.getAccount(account.getNumber());
            if (sameAccount==null) {
                logger.info("the account has been deleted");
            } else {
                logger.info("the account still exists");
            }

            logger.info("End testing and closing sql session");
        }
    }
}
