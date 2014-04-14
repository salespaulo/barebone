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

import org.zsis.barebone.core.util.Utils;


/**
 * TODO (paulo 07/01/2011 18:53:29): escrever javadoc
 *
 * @author psales
 *
 */
public class SQLScript {

	/** TODO (paulo 11/02/2011 17:06:10): escrever javadoc */
	private static final SQLScript NULL_INSTANCE = new SQLScript("null", SQLScriptTypes.NULL);
	
	/** TODO (paulo 11/02/2011 17:04:37): escrever javadoc */
	private final String sql;
	
	/** TODO (paulo 11/02/2011 17:04:38): escrever javadoc */
	private final SQLScriptTypes type;
	
	/**
	 * TODO (paulo 11/02/2011 17:04:33): escrever javadoc
	 *
	 * @param sql
	 * @param type
	 * @return
	 */
	public static SQLScript newInstance(String sql, SQLScriptTypes type) {
		if (Utils.isEmpty(sql)) throw new IllegalArgumentException("Property 'sql' not must be empty!");
		
		return new SQLScript(sql, type);
	}

	/**
	 * TODO (paulo 11/02/2011 17:06:57): escrever javadoc
	 *
	 * @return
	 */
	public static SQLScript getNullInstance() {
		return NULL_INSTANCE; 
	}
	
	/** TODO (paulo 11/02/2011 17:04:44): escrever javadoc */
	private SQLScript(String sql, SQLScriptTypes type) {
		this.sql = sql;
		this.type = type;
	}
	
	/**
	 * TODO (paulo 07/01/2011 18:58:24): escrever javadoc
	 *
	 * @return the sql
	 */
	public String getSql() {
		return sql;
	}
	
	/**
	 * TODO (paulo 07/01/2011 18:58:28): escrever javadoc
	 *
	 * @return the type
	 */
	public SQLScriptTypes getType() {
		return type;
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this) return true;
		if (!(o instanceof SQLScript)) return false;
		SQLScript other = (SQLScript) o;
		return other.sql.equals(this.sql) && other.type.equals(this.type);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		int primeNumber = 523;
		int result = 827;
		int hashCode = this.sql.hashCode();
		hashCode += type.hashCode();
		return primeNumber * result + hashCode - this.sql.codePointAt(0);
	}
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return this.sql;
	}

}
