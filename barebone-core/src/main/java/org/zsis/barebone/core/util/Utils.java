/**
 * barebone-core
 *
 * Copyright [yyyy] [name of copyright owner]

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
package org.zsis.barebone.core.util;

import java.util.List;

/**
 * TODO (paulo 17/02/2011 15:25:48): escrever javadoc
 *
 * @author psales
 *
 */
public class Utils {

	/** TODO (paulo 17/02/2011 15:26:34): escrever javadoc */
	private Utils() {
		throw new AssertionError();
	}

	/**
	 * TODO (paulo 17/02/2011 15:27:35): escrever javadoc
	 *
	 * @param name
	 * @return
	 */
	public static boolean isEmpty(String name) {
		return (name == null || name.isEmpty());
	}
	
	/**
	 * TODO (paulo 17/02/2011 15:29:11): escrever javadoc
	 *
	 * @param list
	 * @return
	 */
	public static boolean isEmpty(List<?> list) {
		return (list == null || list.isEmpty());
	}
	
}
