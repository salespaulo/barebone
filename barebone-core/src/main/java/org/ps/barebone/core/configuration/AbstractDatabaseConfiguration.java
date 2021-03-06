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

/**
 * TODO (paulo 07/01/2011 15:29:49): escrever javadoc
 *
 * @author psales
 *
 */
abstract class AbstractDatabaseConfiguration implements DatabaseConfiguration {

	/** TODO (paulo 07/01/2011 14:47:30): escrever javadoc */
	private final DatabaseTypes type;

	/**
	 * TODO (paulo 07/01/2011 15:31:49): escrever javadoc
	 *
	 * @param type
	 */
	public AbstractDatabaseConfiguration(DatabaseTypes type) {
		this.type = type;
	}
	
	/* (non-Javadoc)
	 * @see DatabaseConfiguration#getDatabaseType()
	 */
	public DatabaseTypes getDatabaseType() {
		return this.type;
	}
}
