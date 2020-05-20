package lyc.java.SpringBoot.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;

@SpringBootTest
class TestMain {
    @Autowired
    DataSource dataSource;
    @Test
    void TestMainFun() throws Exception {
        Connection connection = dataSource.getConnection();
        System.out.println(dataSource.getClass());
        System.out.println(connection);
        System.out.println(dataSource);
    }
}