/**
 * barebone-core
 *
 * Copyright [yyyy] [name of copyright ownerName]

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
 * TODO (paulo 07/01/2011 15:54:14): escrever javadoc
 *
 * @author psales
 *
 */
public class Generator extends AbstractMetadataObject {

	/** TODO (paulo 07/01/2011 19:27:50): escrever javadoc */
	private static final long serialVersionUID = 2179235557108499788L;
	
	/** TODO (paulo 15/02/2011 19:10:15): escrever javadoc */
	private static final Generator NULL_INSTANCE = Generator.newInstance("null", "null", null);
	
	/** TODO (paulo 07/01/2011 16:39:46): escrever javadoc */
	private final String name;
	/** TODO (paulo 07/01/2011 16:39:45): escrever javadoc */
	private final String ownerName;
	
	/**
	 * TODO (paulo 07/01/2011 16:39:43): escrever javadoc
	 *
	 * @param name
	 * @param ownerName
	 * @return
	 */
	public static Generator newInstance(String name, String ownerName, List<SQLScript> scripts) {
		if (Utils.isEmpty(name)     ) throw new IllegalArgumentException("Property 'name' not must be empty!");
		if (Utils.isEmpty(ownerName)) throw new IllegalArgumentException("Property 'ownerName' not must be empty!");
		if (Utils.isEmpty(scripts)  ) scripts = Collections.emptyList();
		
		return new Generator(name, ownerName, Collections.unmodifiableList(scripts));
	}

	/**
	 * TODO (paulo 15/02/2011 19:09:31): escrever javadoc
	 *
	 * @return
	 */
	public static Generator getNullInstance() {
		return NULL_INSTANCE;
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:39:41): escrever javadoc
	 *
	 * @param name
	 * @param ownerName
	 */
	private Generator(String name, String ownerName, List<SQLScript> scripts) {
		super(scripts);
		this.name = name;
		this.ownerName = ownerName;
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:38:47): escrever javadoc
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:38:51): escrever javadoc
	 *
	 * @return the ownerName
	 */
	public String getOwnerName() {
		return ownerName;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Generator)) return false;
		Generator other = (Generator) o;
		return other.name.equals(this.name) && other.ownerName.equals(this.ownerName);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int primeNumber = 199;
		int result = 399;
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
