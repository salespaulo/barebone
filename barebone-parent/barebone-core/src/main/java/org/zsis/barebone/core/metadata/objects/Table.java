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
 * TODO (paulo 07/01/2011 15:52:55): escrever javadoc
 *
 * @author psales
 *
 */
public final class Table extends AbstractMetadataObject {

	/** TODO (paulo 21/01/2011 15:52:19): escrever javadoc */
	private static final long serialVersionUID = -3394122205064974122L;
	
	/** TODO (paulo 15/02/2011 19:05:25): escrever javadoc */
	private static final Table NULL_INSTANCE = Table.newInstance("null", PrimaryKey.getNullInstance(), null, null, null);

	/** TODO (paulo 07/01/2011 16:04:31): escrever javadoc */
	private final String name;
	/** TODO (paulo 21/01/2011 15:52:04): escrever javadoc */
	private final PrimaryKey primaryKey;
	/** TODO (paulo 07/01/2011 16:04:32): escrever javadoc */
	private final List<Column> columns;
	/** TODO (paulo 07/01/2011 16:04:33): escrever javadoc */
	private final List<ForeignKey> foreignKeys;
	
	/**
	 * TODO (paulo 07/01/2011 16:04:20): escrever javadoc
	 *
	 * @param name
	 * @param columns
	 * @param foreignKeys
	 * @return
	 */
	public static Table newInstance(String name, PrimaryKey primaryKey, List<Column> columns, List<ForeignKey> foreignKeys, List<SQLScript> scripts) {
		if (Utils.isEmpty(name)       ) throw new IllegalArgumentException("Property 'name' not must be empty!");
		if (primaryKey == null        ) throw new IllegalArgumentException("Property 'primaryKey' not must be empty!");
		if (Utils.isEmpty(columns)    ) columns     = Collections.emptyList();
		if (Utils.isEmpty(foreignKeys)) foreignKeys = Collections.emptyList();
		if (Utils.isEmpty(scripts)    ) scripts     = Collections.emptyList();
		
		return new Table(name, primaryKey,
				Collections.unmodifiableList(columns),
				Collections.unmodifiableList(foreignKeys),
				Collections.unmodifiableList(scripts));
	}
	
	/**
	 * TODO (paulo 15/02/2011 19:04:12): escrever javadoc
	 *
	 * @return
	 */
	public static Table getNullInstance() {
		return NULL_INSTANCE;
	}
	
	/**
	 * TODO (paulo 07/01/2011 15:59:57): escrever javadoc
	 *
	 */
	private Table(String name, PrimaryKey primaryKey, List<Column> columns, List<ForeignKey> foreignKeys, List<SQLScript> scripts) {
		super(scripts);
		this.name = name;
		this.primaryKey = primaryKey;
		this.columns = columns;
		this.foreignKeys = foreignKeys;
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:02:32): escrever javadoc
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * TODO (paulo 21/01/2011 15:52:13): escrever javadoc
	 *
	 * @return the primaryKey
	 */
	public PrimaryKey getPrimaryKey() {
		return primaryKey;
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:02:23): escrever javadoc
	 *
	 * @return the columns
	 */
	public List<Column> getColumns() {
		return columns;
	}
	
	/**
	 * TODO (paulo 07/01/2011 16:02:27): escrever javadoc
	 *
	 * @return the foreignKeys
	 */
	public List<ForeignKey> getForeignKeys() {
		return foreignKeys;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof Table)) return false;
		Table other = (Table) o;
		return other.name.equals(this.name);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int primeNumber = 31;
		int result = 17;
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
