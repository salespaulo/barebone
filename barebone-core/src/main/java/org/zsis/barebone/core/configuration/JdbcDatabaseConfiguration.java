/**
 * barebone-core
 *
 * Copyright 2011 Z Sistemas Ltda ME

 *   Licensed under the Apache License, Version 2.0 (the "License");
 *   you may not use this file except in compliance with the License.
 *   You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *   Unless required by applicable law or agreed to in writing, software
 *   distributed under the License is distributed on an "AS IS" BASIS,
 *   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *   See the License for the specific language governing permissions and
 *   limitations under the License.
 */
package org.zsis.barebone.core.configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * TODO (paulo 07/01/2011 14:30:11): escrever javadoc
 *
 * @author psales
 *
 */
class JdbcDatabaseConfiguration extends AbstractDatabaseConfiguration {

	/** TODO (paulo 07/01/2011 14:40:19): escrever javadoc */
	private final String url;
	/** TODO (paulo 21/01/2011 15:04:20): escrever javadoc */
	private final String user;
	/** TODO (paulo 21/01/2011 15:04:17): escrever javadoc */
	private final String password;
	/** TODO (paulo 07/01/2011 14:40:20): escrever javadoc */
	private final Class<?> driver;
	
	/**
	 * TODO (paulo 07/01/2011 14:40:16): escrever javadoc
	 *
	 * @param url
	 * @param driver
	 */
	public JdbcDatabaseConfiguration(String url, String user, String password, Class<?> driver, DatabaseTypes type) {
		super(type);
		this.url = url;
		this.user = user;
		this.password = password;
		this.driver = driver;
	}
	
	/**
	 * TODO (paulo 07/01/2011 14:59:21): escrever javadoc
	 *
	 * @return the url
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * TODO (paulo 07/01/2011 14:59:25): escrever javadoc
	 *
	 * @return the driver
	 */
	public Class<?> getDriver() {
		return driver;
	}

	/* (non-Javadoc)
	 * @see org.zsis.barebone.core.configuration.DatabaseConfiguration#getConnection()
	 */
	public Connection getConnection() {
		try {
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			throw new DatabaseConfigurationException("Not retrieve the connection in the driver manager!", e);
		}
	}

}
