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
 * TODO (paulo 07/01/2011 15:53:48): escrever javadoc
 *
 * @author psales
 *
 */
public class PrimaryKey extends AbstractMetadataObject {

	/** TODO (paulo 07/01/2011 19:21:03): escrever javadoc */
	private static final long serialVersionUID = 8761296588028127859L;
	
	/** TODO (paulo 17/02/2011 15:22:12): escrever javadoc */
	private static final PrimaryKey NULL_INSTANCE = PrimaryKey.newInstance("null", "null", null, null);
	
	/** TODO (paulo 07/01/2011 16:30:05): escrever javadoc */
	private final String name;
	/** TODO (paulo 07/01/2011 16:51:39): escrever javadoc */
	private final String ownerName;
	/** TODO (paulo 07/01/2011 16:30:03): escrever javadoc */
	private final List<String> columnNames;
	
	/**
	 * TODO (paulo 07/01/2011 16:30:01): escrever javadoc
	 *
	 * @param name
	 * @param columnNames
	 * @return
	 */
	public static PrimaryKey newInstance(String name, String ownerName, List<String> columnNames, List<SQLScript> scripts) {
		if (Utils.isEmpty(ownerName)  ) throw new IllegalArgumentException("Property 'ownerName' not must be empty!");
		if (Utils.isEmpty(name)       ) throw new IllegalArgumentException("Property 'name' not must be empty!");
		if (Utils.isEmpty(columnNames)) columnNames = Collections.emptyList();
		if (Utils.isEmpty(scripts)    ) scripts     = Collections.emptyList();
		
		return new PrimaryKey(name, ownerName, Collections.unmodifiableList(columnNames), Collections.unmodifiableList(scripts));
	}
	
	/**
	 * TODO (paulo 17/02/2011 15:21:15): escrever javadoc
	 *
	 * @return
	 */
	public static PrimaryKey getNullInstance() {
		return NULL_INSTANCE;
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:29:58): escrever javadoc
	 *
	 * @param name
	 * @param columnNames
	 */
	private PrimaryKey(String name, String ownerName, List<String> columnNames, List<SQLScript> scripts) {
		super(scripts);
		this.name = name;
		this.ownerName = ownerName;
		this.columnNames = columnNames;
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:30:44): escrever javadoc
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * TODO (paulo 07/01/2011 17:02:01): escrever javadoc
	 *
	 * @return the ownerName
	 */
	public String getOwnerName() {
		return ownerName;
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:30:48): escrever javadoc
	 *
	 * @return the columnNames
	 */
	public List<String> getColumnNames() {
		return columnNames;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof PrimaryKey)) return false;
		PrimaryKey other = (PrimaryKey) o;
		return other.name.equals(this.name) && other.ownerName.equals(this.ownerName);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int primeNumber = 163;
		int result = 99;
		int hashCode = this.name.hashCode();
		hashCode += this.ownerName.hashCode();
		result += primeNumber * result + hashCode - this.name.codePointAt(0);
		result += primeNumber * result + hashCode - this.ownerName.codePointAt(0);
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s.%s", this.ownerName, this.name);
	}

}
