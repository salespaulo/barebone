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

import java.util.List;

import org.ps.barebone.core.configuration.DatabaseConfiguration;
import org.ps.barebone.core.metadata.objects.Generator;
import org.ps.barebone.core.metadata.objects.Relationship;
import org.ps.barebone.core.metadata.objects.Table;
import org.ps.barebone.core.metadata.objects.Trigger;
import org.ps.barebone.core.metadata.objects.View;

/**
 * TODO (paulo 07/01/2011 14:29:05): escrever javadoc
 *
 * @author psales
 *
 */
public interface DatabaseMetadata {

	/**
	 * TODO (paulo 21/01/2011 14:05:24): escrever javadoc
	 *
	 * @return
	 */
	List<Table> getTables();
	
	/**
	 * TODO (paulo 21/01/2011 14:05:28): escrever javadoc
	 *
	 * @return
	 */
	List<View> getViews();
	
	/**
	 * TODO (paulo 21/01/2011 14:05:30): escrever javadoc
	 *
	 * @return
	 */
	List<Generator> getGenerators();
	
	/**
	 * TODO (paulo 21/01/2011 14:05:33): escrever javadoc
	 *
	 * @return
	 */
	List<Trigger> getTriggers();
	
	/**
	 * TODO (paulo 21/01/2011 14:05:35): escrever javadoc
	 *
	 * @return
	 */
	List<Relationship> getRelationships();
	
	/**
	 * TODO (paulo 21/01/2011 14:05:38): escrever javadoc
	 *
	 * @param name
	 * @return
	 */
	Table getTable(String name);
	
	/**
	 * TODO (paulo 21/01/2011 14:05:41): escrever javadoc
	 *
	 * @param name
	 * @return
	 */
	View getView(String name);
	
	/**
	 * TODO (paulo 21/01/2011 14:06:51): escrever javadoc
	 *
	 * @param name
	 * @return
	 */
	Generator getGenerator(String name);
	
	/**
	 * TODO (paulo 21/01/2011 14:07:34): escrever javadoc
	 *
	 * @param name
	 * @return
	 */
	Trigger getTrigger(String name);
	
	/**
	 * TODO (paulo 07/01/2011 14:31:52): escrever javadoc
	 *
	 * @return
	 */
	DatabaseConfiguration getDatabaseConfiguration();

}
