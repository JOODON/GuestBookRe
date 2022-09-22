package config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import javax.sql.DataSource;

@Configuration
@EnableTransactionManagement
public class DBConfig implements TransactionManagementConfigurer{
    private String driverClass="com.mysql.cj.jdbc.Driver";

    private String url="jdbc:mysql://localhost:3307/guestbook";

    private String username="root";

    private String password="kkjjss103@";
    @Bean
    public DataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(driverClass);

        dataSource.setUrl(url);

        dataSource.setUsername(username);

        dataSource.setPassword(password);

        return dataSource;
    }
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return transactionManger();
    }

    @Bean
    public PlatformTransactionManager transactionManger() {
        return new DataSourceTransactionManager(dataSource());
    }

}
