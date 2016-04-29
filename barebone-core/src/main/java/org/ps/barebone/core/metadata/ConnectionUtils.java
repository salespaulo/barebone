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
package org.ps.barebone.core.metadata;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.slf4j.LoggerFactory;

/**
 * TODO (paulo 21/01/2011 15:16:12): escrever javadoc
 *
 * @author psales
 *
 */
class ConnectionUtils {

	/** TODO (paulo 21/01/2011 15:21:27): escrever javadoc */
	private ConnectionUtils() {
		throw new AssertionError();
	}
	
	/**
	 * TODO (paulo 21/01/2011 15:40:33): escrever javadoc
	 *
	 * @param connection
	 */
	public static void close(Connection connection) {
		try {
			if (connection != null && ! connection.isClosed()) {
				connection.close();
			}
		} catch (SQLException e) {
			LoggerFactory.getLogger(ConnectionUtils.class).warn(e.getMessage(), e);
		}
	}
	
	/**
	 * TODO (paulo 21/01/2011 15:40:35): escrever javadoc
	 *
	 * @param resultSet
	 */
	public static void close(ResultSet resultSet) {
		try {
			if (resultSet != null) {
				resultSet.close();
			}
		} catch (SQLException e) {
			LoggerFactory.getLogger(ConnectionUtils.class).warn(e.getMessage(), e);
		}
	}
	
	/**
	 * TODO (paulo 21/01/2011 15:40:38): escrever javadoc
	 *
	 * @param statement
	 */
	public static void close(Statement statement) {
		try {
			if (statement != null) {
				statement.close();
			}
		} catch (SQLException e) {
			LoggerFactory.getLogger(ConnectionUtils.class).warn(e.getMessage(), e);
		}
	}
}
