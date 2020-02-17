import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sql.DataSource;
import java.sql.SQLException;

public class TestMain {
    @Autowired
    DataSource dataSource;
    @Test
    void TestMain () throws SQLException {
        dataSource.getConnection();
    }
}

