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

import java.io.Serializable;
import java.util.List;

/**
 * TODO (paulo 07/01/2011 16:43:47): escrever javadoc
 *
 * @author psales
 *
 */
interface MetadataObject extends Serializable {

	/**
	 * TODO (paulo 07/01/2011 19:37:12): escrever javadoc
	 *
	 * @return
	 */
	List<SQLScript> getScripts();
	
}
