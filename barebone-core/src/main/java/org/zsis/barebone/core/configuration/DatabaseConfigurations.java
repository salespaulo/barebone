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

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * TODO (paulo 07/01/2011 14:52:08): escrever javadoc
 *
 * @author psales
 *
 */
public final class DatabaseConfigurations {

	/** TODO (paulo 07/01/2011 15:12:00): escrever javadoc */
	private static final Logger logger = LoggerFactory.getLogger(DatabaseConfigurations.class);
	
	/**
	 * TODO (paulo 07/01/2011 14:52:39): escrever javadoc
	 */
	private DatabaseConfigurations() {
		throw new AssertionError();
	}
	
	/**
	 * TODO (paulo 07/01/2011 14:54:25): escrever javadoc
	 *
	 * @param url
	 * @param driver
	 * @param type
	 * @return
	 */
	public static DatabaseConfiguration newJdbcDatabaseConfiguration(String url, String user, String password, Class<?> driver, DatabaseTypes type) {
		if (logger.isDebugEnabled()) {
			logger.debug("New JDBC database configuration: url={}; driver={}; type={}", new Object[] {url, driver, type});
		}

		return new JdbcDatabaseConfiguration(url, user, password, driver, type);
	}
	
	/**
	 * TODO (paulo 07/01/2011 14:55:16): escrever javadoc
	 *
	 * @param datasource
	 * @param type
	 * @return
	 */
	public static DatabaseConfiguration newDatasourceDatabaseConfiguration(DataSource datasource, DatabaseTypes type) {
		if (logger.isDebugEnabled()) {
			logger.debug("New DataSource database configuration: datasource={}; type={}", new Object[] {datasource, type});
		}

		return new DatasourceDatabaseConfiguration(datasource, type);
	}
	
}
