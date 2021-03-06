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

import java.util.Collections;
import java.util.List;

import org.ps.barebone.core.util.Utils;

/**
 * TODO (paulo 07/01/2011 15:53:23): escrever javadoc
 *
 * @author psales
 *
 */
public class Trigger extends AbstractMetadataObject {

	/** TODO (paulo 07/01/2011 19:07:29): escrever javadoc */
	private static final long serialVersionUID = 8826607341789323645L;
	
	/** TODO (paulo 15/02/2011 19:12:20): escrever javadoc */
	private static final Trigger NULL_INSTANCE = Trigger.newInstance("null", null);
	
	/** TODO (paulo 07/01/2011 16:17:48): escrever javadoc */
	private final String name;

	/**
	 * TODO (paulo 07/01/2011 16:17:43): escrever javadoc
	 *
	 * @param name
	 * @return
	 */
	public static Trigger newInstance(String name, List<SQLScript> scripts) {
		if (Utils.isEmpty(name)   ) throw new IllegalArgumentException("Property 'name' not must be empty!");
		if (Utils.isEmpty(scripts)) scripts = Collections.emptyList();
		
		return new Trigger(name, Collections.unmodifiableList(scripts));
	}

	/**
	 * TODO (paulo 15/02/2011 19:11:37): escrever javadoc
	 *
	 * @return
	 */
	public static Trigger getNullInstance() {
		return NULL_INSTANCE;
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:17:45): escrever javadoc
	 *
	 * @param name
	 */
	private Trigger(String name, List<SQLScript> scripts) {
		super(scripts);
		this.name = name;
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:30:18): escrever javadoc
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
		if (!(o instanceof Trigger)) return false;
		Trigger other = (Trigger) o;
		return other.name.equals(this.name);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int primeNumber = 227;
		int result = 65;
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
