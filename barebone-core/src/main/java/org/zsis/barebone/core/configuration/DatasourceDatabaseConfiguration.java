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
import java.sql.SQLException;

import javax.sql.DataSource;


/**
 * TODO (paulo 07/01/2011 14:30:52): escrever javadoc
 *
 * @author psales
 *
 */
class DatasourceDatabaseConfiguration extends AbstractDatabaseConfiguration {

	/** TODO (paulo 07/01/2011 14:33:41): escrever javadoc */
	private final DataSource datasource;
	
	/**
	 * TODO (paulo 07/01/2011 14:33:37): escrever javadoc
	 *
	 * @param datasource
	 */
	public DatasourceDatabaseConfiguration(DataSource datasource, DatabaseTypes type) {
		super(type);
		this.datasource = datasource;
	}

	/**
	 * TODO (paulo 07/01/2011 14:59:08): escrever javadoc
	 *
	 * @return the datasource
	 */
	public DataSource getDatasource() {
		return datasource;
	}

	/* (non-Javadoc)
	 * @see org.zsis.barebone.core.configuration.DatabaseConfiguration#getConnection()
	 */
	public Connection getConnection() {
		try {
			return datasource.getConnection();
		} catch (SQLException e) {
			throw new DatabaseConfigurationException("Not retrieve the connection in the datasource!", e);
		}
	}
	
}
