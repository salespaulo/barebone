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
package org.ps.barebone.core.metadata.objects;

import java.util.ArrayList;

import org.ps.barebone.core.util.Utils;

/**
 * TODO (paulo 07/01/2011 15:55:38): escrever javadoc
 *
 * @author psales
 *
 */
public class Relationship extends AbstractMetadataObject {
	
	/** TODO (paulo 07/01/2011 19:23:37): escrever javadoc */
	private static final long serialVersionUID = -4516626864090983554L;

	/** TODO (paulo 07/01/2011 16:42:49): escrever javadoc */
	private final String domainName;
	/** TODO (paulo 07/01/2011 16:42:48): escrever javadoc */
	private final String dependencyName;
	
	/**
	 * TODO (paulo 07/01/2011 16:42:46): escrever javadoc
	 *
	 * @param name
	 * @param dependencyName
	 * @return
	 */
	public static Relationship newInstance(String name, String dependencyName) {
		if (Utils.isEmpty(name)) throw new IllegalArgumentException("Property 'name' not must be empty!");
		
		return new Relationship(name, dependencyName);
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:42:43): escrever javadoc
	 *
	 * @param name
	 * @param dependencyName
	 */
	private Relationship(String domainName, String dependencyName) {
		super(new ArrayList<SQLScript>(0));
		this.domainName = domainName;
		this.dependencyName = dependencyName;
	}

	/**
	 * TODO (paulo 07/01/2011 16:45:53): escrever javadoc
	 *
	 * @return the domainName
	 */
	public String getDomainName() {
		return domainName;
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:42:40): escrever javadoc
	 *
	 * @return the dependencyName
	 */
	public String getDependencyName() {
		return dependencyName;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Relationship)) return false;
		Relationship other = (Relationship) o;
		return other.domainName.equals(this.domainName) && other.dependencyName.equals(this.dependencyName);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int primeNumber = 457;
		int result = 298;
		int hashCode = this.domainName.hashCode();
		hashCode += this.dependencyName.hashCode();
		result += primeNumber * result + hashCode - this.domainName.codePointAt(0);
		result += primeNumber * result + hashCode - this.dependencyName.codePointAt(0);
		return result;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return String.format("Domain=%s; Dependency=%s", this.domainName, this.dependencyName);
	}

	
}
