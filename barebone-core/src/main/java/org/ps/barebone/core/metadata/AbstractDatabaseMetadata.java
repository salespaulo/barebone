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

import org.ps.barebone.core.configuration.DatabaseConfiguration;

/**
 * TODO (paulo 07/01/2011 15:26:11): escrever javadoc
 *
 * @author psales
 *
 */
abstract class AbstractDatabaseMetadata implements DatabaseMetadata {

	/** TODO (paulo 07/01/2011 15:25:12): escrever javadoc */
	private final DatabaseConfiguration databaseConfiguration;
	
	/**
	 * TODO (paulo 07/01/2011 15:27:24): escrever javadoc
	 *
	 * @param databaseConfiguration
	 */
	public AbstractDatabaseMetadata(DatabaseConfiguration databaseConfiguration) {
		this.databaseConfiguration = databaseConfiguration;
	}
	
	/* (non-Javadoc)
	 * @see org.zsis.barebone.core.configuration.DatabaseMetadata#getDatabaseConfiguration()
	 */
	public DatabaseConfiguration getDatabaseConfiguration() {
		return this.databaseConfiguration;
	}
}
