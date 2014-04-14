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
package org.zsis.barebone.core.metadata;

import java.util.List;

import org.zsis.barebone.core.configuration.DatabaseConfiguration;
import org.zsis.barebone.core.metadata.objects.Generator;
import org.zsis.barebone.core.metadata.objects.Relationship;
import org.zsis.barebone.core.metadata.objects.Table;
import org.zsis.barebone.core.metadata.objects.Trigger;
import org.zsis.barebone.core.metadata.objects.View;

/**
 * TODO (paulo 07/01/2011 15:22:46): escrever javadoc
 *
 * @author psales
 *
 */
class OracleDatabaseMetadata extends AbstractDatabaseMetadata {

	/**
	 * TODO (paulo 15/02/2011 19:14:09): escrever javadoc
	 *
	 * @param databaseConfiguration
	 */
	public OracleDatabaseMetadata(DatabaseConfiguration databaseConfiguration) {
		super(databaseConfiguration);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getTables()
	 */
	public List<Table> getTables() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getViews()
	 */
	public List<View> getViews() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getGenerators()
	 */
	public List<Generator> getGenerators() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getTriggers()
	 */
	public List<Trigger> getTriggers() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getRelationships()
	 */
	public List<Relationship> getRelationships() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getTable(java.lang.String)
	 */
	public Table getTable(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getView(java.lang.String)
	 */
	public View getView(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getGenerator(java.lang.String)
	 */
	public Generator getGenerator(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getTrigger(java.lang.String)
	 */
	public Trigger getTrigger(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}