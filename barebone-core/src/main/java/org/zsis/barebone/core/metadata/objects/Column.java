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
 * TODO (paulo 07/01/2011 15:53:36): escrever javadoc
 *
 * @author psales
 *
 */
public class Column extends AbstractMetadataObject {

	/** TODO (paulo 21/01/2011 16:34:05): escrever javadoc */
	private static final long serialVersionUID = -5305219537786456004L;

	/** TODO (paulo 07/01/2011 16:20:27): escrever javadoc */
	private final String name;
	/** TODO (paulo 07/01/2011 16:50:19): escrever javadoc */
	private final String ownerName;
	/** TODO (paulo 07/01/2011 16:20:29): escrever javadoc */
	private final String type;
	/** TODO (paulo 21/01/2011 16:33:03): escrever javadoc */
	private final int length;
	/** TODO (paulo 07/01/2011 16:20:30): escrever javadoc */
	private final boolean nullable;

	/**
	 * TODO (paulo 07/01/2011 16:20:24): escrever javadoc
	 *
	 * @param name
	 * @param type
	 * @param nullable
	 * @return
	 */
	public static Column newInstance(String name, String ownerName, String type, int length, boolean nullable, List<SQLScript> scripts) {
		if (Utils.isEmpty(ownerName)) throw new IllegalArgumentException("Property 'ownerName' not must be empty!");
		if (Utils.isEmpty(name)     ) throw new IllegalArgumentException("Property 'name' not must be empty!");
		if (Utils.isEmpty(type)     ) throw new IllegalArgumentException("Property 'type' not must be empty!");
		if (Utils.isEmpty(scripts)  ) scripts = Collections.emptyList();
		
		return new Column(name, ownerName, type, length, nullable, Collections.unmodifiableList(scripts));
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:20:21): escrever javadoc
	 *
	 * @param name
	 * @param ownerName 
	 * @param type
	 * @param nullable
	 */
	private Column(String name, String ownerName, String type, int length, boolean nullable, List<SQLScript> scripts) {
		super(scripts);
		this.name = name;
		this.ownerName = ownerName;
		this.type = type;
		this.length = length;
		this.nullable = nullable;
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:30:24): escrever javadoc
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * TODO (paulo 07/01/2011 17:02:13): escrever javadoc
	 *
	 * @return the ownerName
	 */
	public String getOwnerName() {
		return ownerName;
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:30:28): escrever javadoc
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	
	/**
	 * TODO (paulo 21/01/2011 16:34:01): escrever javadoc
	 *
	 * @return the length
	 */
	public int getLength() {
		return length;
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:30:33): escrever javadoc
	 *
	 * @return the nullable
	 */
	public boolean isNullable() {
		return nullable;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Column)) return false;
		Column other = (Column) o;
		return other.name.equals(this.name) && other.ownerName.equals(this.ownerName) && other.type.equals(this.type) && other.nullable == nullable;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int primeNumber = 487;
		int result = 47;
		int hashCode = this.name.hashCode();
		hashCode += this.ownerName.hashCode();
		hashCode += this.type.hashCode();
		result += primeNumber * result + hashCode - this.ownerName.codePointAt(0);
		result += primeNumber * result + hashCode - this.name.codePointAt(0);
		result += primeNumber * result + hashCode - this.type.codePointAt(0);
		result += primeNumber * result + hashCode - (this.nullable ? 11 : 22);
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("%s.%s [type=%s; nullable=%s]", this.ownerName, this.name, this.type, this.nullable);
	}
	

}
