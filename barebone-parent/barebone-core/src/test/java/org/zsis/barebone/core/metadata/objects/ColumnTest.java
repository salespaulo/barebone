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
 * TODO (paulo 07/01/2011 17:56:41): escrever javadoc
 *
 * @author psales
 *
 */
public class ColumnTest {

	@Test public void testEquals() {
		Column t1 = Column.newInstance("TESTE", "TESTE_OWNER", "TYPE", 0, true, null);
		Column t2 = Column.newInstance("TESTE", "TESTE_OWNER", "TYPE", 0, true, null);
		Column t3 = Column.newInstance("TESTE", "TESTE_OWNER", "TYPE", 0, false, null);
		Column t4 = Column.newInstance("TESTE", "TESTE_OWNER", "TYPE2", 0, true, null);
		
		assertArrayEquals("With same properties must be return true!", new Object[] {t1, t2}, new Object[] {t2, t1});
		assertNotSame("With not same properties must be return false!", t1, t3);
		assertNotSame("With not same properties must be return false!", t1, t4);
		assertNotSame("When is null the equals must be return false!!", t1, null);
	}
	
	@Test public void testHashCode() {
		Column t1 = Column.newInstance("TESTE", "TESTE_OWNER", "TYPE", 0, true, null);
		Column t2 = Column.newInstance("TESTE", "TESTE_OWNER", "TYPE", 0, true, null);
		
		assertTrue("When equals is true the hashCode must be return the same value!", t1.hashCode() == t2.hashCode());
	}
	
}
