/**
 * barebone-core
 *
 * Copyright 2011 Z Sistemas Ltda ME
 *
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
package org.ps.barebone.core.metadata.objects;

import java.util.Collections;
import java.util.List;

import org.ps.barebone.core.util.Utils;

/**
 * TODO (paulo 07/01/2011 15:54:01): escrever javadoc
 *
 * @author psales
 *
 */
public class ForeignKey extends AbstractMetadataObject {

	/** TODO (paulo 07/01/2011 19:30:00): escrever javadoc */
	private static final long serialVersionUID = 4418087348739046634L;
	
	/** TODO (paulo 07/01/2011 16:37:06): escrever javadoc */
	private final String name;
	/** TODO (paulo 07/01/2011 17:02:51): escrever javadoc */
	private final String ownerName;
	/** TODO (paulo 07/01/2011 16:37:07): escrever javadoc */
	private final String relationshipName;
	/** TODO (paulo 07/01/2011 16:37:09): escrever javadoc */
	private final List<String> columnNames;
	/** TODO (paulo 07/01/2011 16:37:11): escrever javadoc */
	private final List<String> relationshipColumnNames;
	
	/**
	 * TODO (paulo 07/01/2011 16:37:02): escrever javadoc
	 *
	 * @param name
	 * @param relationshipName
	 * @param columnNames
	 * @param relationshipColumnNames
	 * @return
	 */
	public static ForeignKey newInstance(String name, String ownerName, String relationshipName, List<String> columnNames, List<String> relationshipColumnNames, List<SQLScript> scripts) {
		if (Utils.isEmpty(ownerName)       ) throw new IllegalArgumentException("Property 'ownerName' not must be empty!");
		if (Utils.isEmpty(name)            ) throw new IllegalArgumentException("Property 'name' not must be empty!");
		if (Utils.isEmpty(relationshipName)) throw new IllegalArgumentException("Property 'relationshipName' not must be empty!");
		if (Utils.isEmpty(columnNames)            ) columnNames             = Collections.emptyList();
		if (Utils.isEmpty(relationshipColumnNames)) relationshipColumnNames = Collections.emptyList();
		if (Utils.isEmpty(scripts)                ) scripts                 = Collections.emptyList();
		
		return new ForeignKey(name, ownerName, relationshipName,
				Collections.unmodifiableList(columnNames),
				Collections.unmodifiableList(relationshipColumnNames),
				Collections.unmodifiableList(scripts));
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:37:00): escrever javadoc
	 *
	 * @param name
	 * @param relationshipName
	 * @param columnNames
	 * @param relationshipColumnNames
	 */
	private ForeignKey(String name, String ownerName, String relationshipName, List<String> columnNames, List<String> relationshipColumnNames, List<SQLScript> scripts) {
		super(scripts);
		this.name = name;
		this.ownerName = ownerName;
		this.relationshipName = relationshipName;
		this.columnNames = columnNames;
		this.relationshipColumnNames = relationshipColumnNames;
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:37:17): escrever javadoc
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * TODO (paulo 07/01/2011 17:03:32): escrever javadoc
	 *
	 * @return the ownerName
	 */
	public String getOwnerName() {
		return ownerName;
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:37:22): escrever javadoc
	 *
	 * @return the relationshipName
	 */
	public String getRelationshipName() {
		return relationshipName;
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:37:26): escrever javadoc
	 *
	 * @return the columnNames
	 */
	public List<String> getColumnNames() {
		return columnNames;
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:37:28): escrever javadoc
	 *
	 * @return the relationshipColumnNames
	 */
	public List<String> getRelationshipColumnNames() {
		return relationshipColumnNames;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof ForeignKey)) return false;
		ForeignKey other = (ForeignKey) o;
		return other.name.equals(this.name) && other.ownerName.equals(this.ownerName) && other.relationshipName.equals(this.relationshipName);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int primeNumber = 173;
		int result = 236;
		int hashCode = this.name.hashCode();
		hashCode += this.ownerName.hashCode();
		hashCode += this.relationshipName.hashCode();
		result += primeNumber * result + hashCode - this.name.codePointAt(0);
		result += primeNumber * result + hashCode - this.ownerName.codePointAt(0);
		result += primeNumber * result + hashCode - this.relationshipName.codePointAt(0);
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s.%s [relationshipName=%s]", this.ownerName, this.name, this.relationshipName);
	}
	
}
