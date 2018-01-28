package org.zerock;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class App2ApplicationTests {

	@Autowired
	DataSource ds;
	
	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testConnection() throws SQLException {
		System.out.println("++++++++++++++++++++++");
		System.out.println(ds);
		
		Connection con = ds.getConnection();
		
		System.out.println("++++++++++++++++++++++");
		System.out.println(con);
		con.close();
	}

}
