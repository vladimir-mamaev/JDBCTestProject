import com.configuration.JdbcDriverConnector;
import com.dto.User;

import java.sql.*;


import org.junit.Test;

import static com.utils.Helper.*;
import static java.util.Objects.isNull;
import static org.junit.Assert.*;

public class TestClass {
    @Test
    public void checkAddUserFlow() throws SQLException {
    final JdbcDriverConnector jdbcDriverConnector=new JdbcDriverConnector();
   jdbcDriverConnector.dbDriverSetUp();
    Connection connectionDb=jdbcDriverConnector.getConnection();

    assertNotNull(connectionDb);

    int amountOfUsersBeforeFlow=extractUsers(connectionDb).size();

        User newUser=new User("Tom","tom@gmail.com","15");

        insertUser(connectionDb,newUser);
        int amountOfUsersAfterFlow=extractUsers(connectionDb).size();
        assertTrue(amountOfUsersBeforeFlow<amountOfUsersAfterFlow);
    }
    @Test
    public void checkAmountOfDirectorsWithoutMovie() throws SQLException {
        final JdbcDriverConnector jdbcDriverConnector=new JdbcDriverConnector();
        jdbcDriverConnector.dbDriverSetUp();
        Connection connectionDb=jdbcDriverConnector.getConnection();
        int directorsWithoutMovies= (int) extractDirector(connectionDb).stream().filter(x->isNull(x.getMovieName())).count();
        assertEquals(3,directorsWithoutMovies);
    }


}
