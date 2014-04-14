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

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * TODO (paulo 07/01/2011 17:12:35): escrever javadoc
 *
 * @author psales
 *
 */
public class TableTest {

	@Test public void testEquals() {
		Table t1 = Table.newInstance("TESTE", null, null, null, null);
		Table t2 = Table.newInstance("TESTE", null, new ArrayList<Column>(), null, null);
		
		assertArrayEquals("With the same name must be return true!", new Object[] {t1, t2, t1}, new Object[] {t2, t1, t1});
		assertNotSame("When is null equals must be return false!", t1, null);
	}
	
	@Test public void testHashCode() {
		Table t1 = Table.newInstance("TESTE", null, null, null, null);
		Table t2 = Table.newInstance("TESTE", null, new ArrayList<Column>(), null, null);

		assertTrue("When equals return true the hashCode must be return the same value!", t1.hashCode() == t2.hashCode());
	}
	
}
