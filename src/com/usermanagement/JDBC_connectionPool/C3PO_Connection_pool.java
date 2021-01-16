package com.usermanagement.JDBC_connectionPool;

import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class C3PO_Connection_pool {
	private static final String DB_DRIVER_CLASS="driver.class.name";
	 private static final String DB_USERNAME = "db.username";
	 private static final String DB_PASSWORD="db.password";
	 private static final String DB_URL ="db.myUrl";
	
	private static Properties properties = null;
	private static ComboPooledDataSource dataSource;
	static{
		try {
			properties = new Properties();
			properties.load(new FileInputStream("/Users/sandonasoro/Desktop/javaEE/User_management/db.properties"));
			
			System.out.println("connected.....");
			// creating source of connections.....
			dataSource = new ComboPooledDataSource();
			dataSource.setDriverClass(properties.getProperty(DB_DRIVER_CLASS));
			
			dataSource.setJdbcUrl(properties.getProperty(DB_URL));
			dataSource.setUser(properties.getProperty(DB_USERNAME));
			dataSource.setPassword(properties.getProperty(DB_PASSWORD));
			
			dataSource.setMinPoolSize(3);
			dataSource.setMaxPoolSize(10);
			dataSource.setAcquireIncrement(20);
			
		} catch (IOException | PropertyVetoException e) {
			e.printStackTrace();
		}
	}
	
	

	public static DataSource getDataSource() {
		// TODO Auto-generated method stub
		return dataSource;
	}

}
