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

import java.util.List;

/**
 * TODO (paulo 07/01/2011 19:01:56): escrever javadoc
 *
 * @author psales
 *
 */
abstract class AbstractMetadataObject implements MetadataObject {

	/** TODO (paulo 07/01/2011 19:33:48): escrever javadoc */
	private static final long serialVersionUID = -7436506489392520220L;
	
	/** TODO (paulo 07/01/2011 19:00:44): escrever javadoc */
	private final List<SQLScript> scripts;

	/**
	 * TODO (paulo 07/01/2011 19:03:07): escrever javadoc
	 *
	 * @param scripts
	 */
	public AbstractMetadataObject(List<SQLScript> scripts) {
		this.scripts = scripts;
	}
	
	/* (non-Javadoc)
	 * @see MetadataObject#getScripts()
	 */
	public List<SQLScript> getScripts() {
		return this.scripts;
	}
	
	
}
