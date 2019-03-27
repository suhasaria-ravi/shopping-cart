package per.ravisu.rest.ws.shoppingcart.item.model;


import javax.sql.XADataSource;

import org.h2.jdbcx.JdbcDataSource;

public class DataBaseHelper {
	
	public static XADataSource getDataSource() {
		JdbcDataSource ds = new JdbcDataSource();
		ds.setURL("jdbc:h2:mem:testdb");
		ds.setUser("sa");
		ds.setPassword("");
		return ds;
	}

}
