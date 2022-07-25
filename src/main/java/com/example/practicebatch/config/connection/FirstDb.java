package com.example.practicebatch.config.connection;

import org.seasar.doma.jdbc.Config;
import org.seasar.doma.jdbc.dialect.Dialect;
import org.seasar.doma.jdbc.dialect.MysqlDialect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.datasource.TransactionAwareDataSourceProxy;

import javax.inject.Named;
import javax.sql.DataSource;

@Named("db1")
public class FirstDb implements Config {

    private DataSource dataSource;

    @Autowired
    public void setDataSource(@Qualifier("FirstDataSource")DataSource dataSource) {
        this.dataSource = new TransactionAwareDataSourceProxy(dataSource);
    }

    @Override
    public DataSource getDataSource() { return dataSource;}

    @Override
    public Dialect getDialect() { return new MysqlDialect();}

}