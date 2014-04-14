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

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * TODO (paulo 07/01/2011 19:47:45): escrever javadoc
 *
 * @author psales
 *
 */
public class SQLScriptTest {

	@Test public void testEquals() {
		SQLScript t1 = SQLScript.newInstance("TESTE", SQLScriptTypes.ALTER);
		SQLScript t2 = SQLScript.newInstance("TESTE", SQLScriptTypes.ALTER);
		
		assertArrayEquals("With same properties must be return true!", new Object[] {t1, t2}, new Object[] {t2, t1});
		assertNotSame("When is null the equals must be return false!!", t1, null);
	}
	
	@Test public void testHashCode() {
		SQLScript t1 = SQLScript.newInstance("TESTE", SQLScriptTypes.ALTER);
		SQLScript t2 = SQLScript.newInstance("TESTE", SQLScriptTypes.ALTER);
		
		assertTrue("When equals is true the hashCode must be return the same value!", t1.hashCode() == t2.hashCode());
	}
	
}
