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
package org.zsis.barebone.core.metadata.objects;

import java.util.Collections;
import java.util.List;

import org.zsis.barebone.core.util.Utils;

/**
 * TODO (paulo 07/01/2011 15:53:08): escrever javadoc
 *
 * @author psales
 *
 */
public class View extends AbstractMetadataObject {

	/** TODO (paulo 07/01/2011 19:05:34): escrever javadoc */
	private static final long serialVersionUID = 5239112894075994102L;
	
	/** TODO (paulo 15/02/2011 19:08:43): escrever javadoc */
	private static final View NULL_INSTANCE = View.newInstance("null", null, null);
	
	/** TODO (paulo 07/01/2011 16:17:58): escrever javadoc */
	private final String name;
	/** TODO (paulo 07/01/2011 16:17:57): escrever javadoc */
	private final List<Column> columns;

	/**
	 * TODO (paulo 07/01/2011 16:17:55): escrever javadoc
	 *
	 * @param name
	 * @param columns
	 * @return
	 */
	public static View newInstance(String name, List<Column> columns, List<SQLScript> scripts) {
		if (Utils.isEmpty(name)   ) throw new IllegalArgumentException("Property 'name' not must be empty!");
		if (Utils.isEmpty(columns)) columns = Collections.emptyList();
		if (Utils.isEmpty(scripts)) scripts = Collections.emptyList();
		
		return new View(name, Collections.unmodifiableList(columns), Collections.unmodifiableList(scripts));
	}
	
	/**
	 * TODO (paulo 15/02/2011 19:08:05): escrever javadoc
	 *
	 * @return
	 */
	public static View getNullInstance() {
		return NULL_INSTANCE;
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:17:53): escrever javadoc
	 *
	 * @param name
	 * @param columns
	 */
	private View(String name, List<Column> columns, List<SQLScript> scripts) {
		super(scripts);
		this.name = name;
		this.columns = columns;
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:15:52): escrever javadoc
	 *
	 * @return the columns
	 */
	public List<Column> getColumns() {
		return columns;
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:15:55): escrever javadoc
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof View)) return false;
		View other = (View) o;
		return other.name.equals(this.name);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int primeNumber = 97;
		int result = 110;
		int nameHashCode = this.name.hashCode();
		return primeNumber * result + nameHashCode - this.name.codePointAt(0);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.name;
	}

}
