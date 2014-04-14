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

/**
 * TODO (paulo 21/01/2011 14:51:34): escrever javadoc
 *
 * @author psales
 *
 */
public class DatabaseConfigurationException extends RuntimeException {

	/** TODO (paulo 21/01/2011 14:52:18): escrever javadoc */
	private static final long serialVersionUID = -3595199643778108103L;

	/**
	 * TODO (paulo 21/01/2011 14:52:15): escrever javadoc
	 *
	 * @param m
	 * @param cause
	 */
	public DatabaseConfigurationException(String m, Throwable cause) {
		super(m, cause);
	}
	
}
