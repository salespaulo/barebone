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
package org.ps.barebone.core.configuration;

import java.sql.Connection;


/**
 * TODO (paulo 07/01/2011 14:28:54): escrever javadoc
 *
 * @author psales
 *
 */
public interface DatabaseConfiguration {

	/**
	 * TODO (paulo 21/01/2011 14:52:38): escrever javadoc
	 *
	 * @return
	 */
	DatabaseTypes getDatabaseType();
	
	/**
	 * TODO (paulo 21/01/2011 14:52:40): escrever javadoc
	 *
	 * @return
	 * @throws DatabaseConfigurationException {@link RuntimeException} throw when not retrieve connection.
	 */
	Connection getConnection();
	
}
