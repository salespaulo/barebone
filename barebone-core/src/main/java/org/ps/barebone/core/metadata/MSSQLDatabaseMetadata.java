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
package org.ps.barebone.core.metadata;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.ps.barebone.core.configuration.DatabaseConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.ps.barebone.core.metadata.objects.Column;
import org.ps.barebone.core.metadata.objects.ForeignKey;
import org.ps.barebone.core.metadata.objects.Generator;
import org.ps.barebone.core.metadata.objects.PrimaryKey;
import org.ps.barebone.core.metadata.objects.Relationship;
import org.ps.barebone.core.metadata.objects.SQLScript;
import org.ps.barebone.core.metadata.objects.SQLScriptTypes;
import org.ps.barebone.core.metadata.objects.Table;
import org.ps.barebone.core.metadata.objects.Trigger;
import org.ps.barebone.core.metadata.objects.View;

/**
 * TODO (paulo 07/01/2011 15:23:21): escrever javadoc
 *
 * @author psales
 *
 */
class MSSQLDatabaseMetadata extends AbstractDatabaseMetadata {

	/** TODO (paulo 15/02/2011 18:13:29): escrever javadoc */
	private static final Logger logger = LoggerFactory.getLogger(MSSQLDatabaseMetadata.class);
	
	/**
	 * TODO (paulo 07/01/2011 15:29:12): escrever javadoc
	 *
	 * @param databaseConfiguration
	 */
	public MSSQLDatabaseMetadata(DatabaseConfiguration databaseConfiguration) {
		super(databaseConfiguration);
	}

	/* (non-Javadoc)
	 * @see DatabaseMetadata#getTables()
	 */
	public List<Table> getTables() {

		Connection connection = null;
		DatabaseMetaData metaData = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = getDatabaseConfiguration().getConnection();
			metaData = connection.getMetaData();
			resultSet = metaData.getTables("IMS_IMESP", "dbo", null, new String[] {"TABLE"});

			final List<Table> tables = new ArrayList<Table>(); 
			
			while (resultSet.next()) {
				final String tableName = resultSet.getString("TABLE_NAME");

				final PrimaryKey primaryKey = getPrimaryKey(tableName);
				final List<Column> columns = getColumns(tableName);
				final List<ForeignKey> foreignKeys = getForeignKeys(tableName);

				final List<SQLScript> scripts = new ArrayList<SQLScript>();

				scripts.add(createTableSQLScript(tableName, columns, SQLScriptTypes.INSERT));
				scripts.add(createTableSQLScript(tableName, columns, SQLScriptTypes.DELETE));

				tables.add(Table.newInstance(tableName, primaryKey, columns, foreignKeys, scripts));
			}
			
			return tables;
			
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			throw new DatabaseMetadataException(e.getMessage(), e);
			
		} finally {
			ConnectionUtils.close(resultSet);
			ConnectionUtils.close(connection);
		}
		
//		Connection connection = null;
//		Statement statement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			final List<Table> tables = new ArrayList<Table>(); 
//			final StringBuilder sql = new StringBuilder();
//			
//			sql.append("SELECT NAME, XTYPE FROM SYSOBJECTS WHERE ");
//			sql.append("XTYPE = 'U' AND SYSOBJECTS.STATUS >= 0 ");
//			sql.append("ORDER BY XTYPE, NAME");
//			
//			connection = getDatabaseConfiguration().getConnection();
//			statement = connection.createStatement();
//			resultSet = statement.executeQuery(sql.toString());
//			
//			while(resultSet.next()) {
//				final String tableName = resultSet.getString(1).trim();
//
//				final PrimaryKey primaryKey = getPrimaryKey(tableName);
//				final List<Column> columns = getColumns(tableName);
//				final List<ForeignKey> foreignKeys = getForeignKeys(tableName);
//				
//				final List<SQLScript> scripts = new ArrayList<SQLScript>();
//				
//				scripts.add(createTableScript(tableName, columns, SQLScriptTypes.INSERT));
//				scripts.add(createTableScript(tableName, columns, SQLScriptTypes.DELETE));
//				
//				tables.add(Table.newInstance(tableName, primaryKey, columns, foreignKeys, scripts));
//			}
//			
//			return tables;
//			
//		} catch (SQLException e) {
//			logger.error(e.getMessage(), e);
//			throw new DatabaseMetadataException(e.getMessage(), e);
//
//		} finally {
//			ConnectionUtils.close(resultSet);
//			ConnectionUtils.close(statement);
//			ConnectionUtils.close(connection);
//		}
	}


	/* (non-Javadoc)
	 * @see DatabaseMetadata#getViews()
	 */
	public List<View> getViews() {

		Connection connection = null;
		DatabaseMetaData metaData = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = getDatabaseConfiguration().getConnection();
			metaData = connection.getMetaData();
			resultSet = metaData.getTables("IMS_IMESP", "dbo", null, new String[] {"VIEW"});

			final List<View> views = new ArrayList<View>(); 
			
			while (resultSet.next()) {
				final String tableName = resultSet.getString("TABLE_NAME");
				final List<Column> columns = getColumns(tableName);

				final List<SQLScript> scripts = new ArrayList<SQLScript>();

				scripts.add(createViewSQLScript(tableName, columns, SQLScriptTypes.INSERT));
				scripts.add(createViewSQLScript(tableName, columns, SQLScriptTypes.DELETE));

				views.add(View.newInstance(tableName, columns, scripts));
			}
			
			return views;
			
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			throw new DatabaseMetadataException(e.getMessage(), e);
			
		} finally {
			ConnectionUtils.close(resultSet);
			ConnectionUtils.close(connection);
		}

//		Connection connection = null;
//		Statement statement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			final StringBuilder sql = new StringBuilder();
//			
//			sql.append("SELECT NAME, XTYPE FROM SYSOBJECTS WHERE ");
//			sql.append("XTYPE='V' AND SYSOBJECTS.STATUS >= 0 ");
//			sql.append("ORDER BY XTYPE, NAME");
//			
//			connection = getDatabaseConfiguration().getConnection();
//			statement = connection.createStatement();
//			resultSet = statement.executeQuery(sql.toString());
//			
//			final List<View> views = new ArrayList<View>();
//			
//			while (resultSet.next()) {
//				final String name = resultSet.getString(1).trim();
//				final List<Column> columns = getColumns(name);
//				final List<SQLScript> scripts = new ArrayList<SQLScript>();
//				
//				scripts.add(createViewSQLScript(name, columns, SQLScriptTypes.INSERT));
//				scripts.add(createViewSQLScript(name, columns, SQLScriptTypes.DELETE));
//
//				views.add(View.newInstance(name, columns, scripts));
//			}
//			
//			return views;
//		} catch (SQLException e) {
//			logger.error(e.getMessage(), e);
//			throw new DatabaseMetadataException(e.getMessage(), e);
//
//		} finally {
//			ConnectionUtils.close(resultSet);
//			ConnectionUtils.close(statement);
//			ConnectionUtils.close(connection);
//		}

	}

	/* (non-Javadoc)
	 * @see DatabaseMetadata#getGenerators()
	 */
	public List<Generator> getGenerators() {
		logger.info("The database MSSQL does not allow generators!");
		return Collections.emptyList();
	}

	/* (non-Javadoc)
	 * @see DatabaseMetadata#getTrigger()
	 */
	public List<Trigger> getTriggers() {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			final StringBuilder sql = new StringBuilder();

			sql.append("SELECT O.NAME, C.TEXT FROM SYSOBJECTS AS O, SYSCOMMENTS AS C ");
			sql.append("WHERE O.ID = C.ID AND O.XTYPE='TR'");
			
			connection = getDatabaseConfiguration().getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql.toString());
			
			final List<Trigger> triggers = new ArrayList<Trigger>();
			
			while (resultSet.next()) {
				final String triggerName = resultSet.getString(1);
				final String insertScript = resultSet.getString(2);
				final List<SQLScript> scripts = new ArrayList<SQLScript>();
				
				scripts.add(SQLScript.newInstance(insertScript, SQLScriptTypes.INSERT));
				scripts.add(SQLScript.newInstance("DROP TRIGGER " + triggerName, SQLScriptTypes.DELETE));
				
				triggers.add(Trigger.newInstance(triggerName, scripts));
			}
			
			return triggers;
			
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			throw new DatabaseMetadataException(e.getMessage(), e);
			
		} finally {
			ConnectionUtils.close(resultSet);
			ConnectionUtils.close(statement);
			ConnectionUtils.close(connection);
		}

	}

	/* (non-Javadoc)
	 * @see DatabaseMetadata#getRelationship()
	 */
	public List<Relationship> getRelationships() {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			final StringBuilder sql = new StringBuilder();
			
			sql.append("SELECT O1.NAME AS DOMINANTES, ");
			sql.append("       O2.NAME AS DEPENDENTES ");
			sql.append("FROM   SYSOBJECTS AS O1, ");
			sql.append("       SYSOBJECTS AS O2,  ");
			sql.append("       SYSDEPENDS AS D ");
			sql.append("WHERE  O1.ID = D.DEPID AND O2.ID = D.ID ");
			sql.append("AND    (O1.XTYPE = 'U' OR O1.XTYPE = 'V') ");
			sql.append("AND    (O2.XTYPE = 'U' OR O2.XTYPE = 'V') ");
			sql.append("UNION ");
			sql.append("SELECT O1.NAME AS DOMINANTES, ");
			sql.append("       O3.NAME AS DEPENDENTES ");
			sql.append("FROM   SYSDEPENDS AS D ");
			sql.append("INNER JOIN SYSOBJECTS AS O1 ON (D.ID          = O1.ID) ");
			sql.append("INNER JOIN SYSOBJECTS AS O2 ON (D.DEPID       = O2.ID) ");
			sql.append("INNER JOIN SYSOBJECTS AS O3 ON (O1.PARENT_OBJ = O3.ID) ");
			sql.append("WHERE O1.XTYPE = 'TR' ");
			
			connection = getDatabaseConfiguration().getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql.toString());
			
			final List<Relationship> relationships = new ArrayList<Relationship>();
			
			while (resultSet.next()) {
				final String relationshipName = resultSet.getString(1);
				final String dependencyName = resultSet.getString(2);
				
				relationships.add(Relationship.newInstance(relationshipName, dependencyName));
			}
			
			return relationships;
			
		} catch(SQLException e) {
			logger.error(e.getMessage(), e);
			throw new DatabaseMetadataException(e.getMessage(), e);
			
		} finally {
			ConnectionUtils.close(resultSet);
			ConnectionUtils.close(statement);
			ConnectionUtils.close(connection);
		}
		
	}

	/* (non-Javadoc)
	 * @see DatabaseMetadata#getTable(java.lang.String)
	 */
	public Table getTable(String name) {
		Connection connection = null;
		DatabaseMetaData metaData = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = getDatabaseConfiguration().getConnection();
			metaData = connection.getMetaData();
			resultSet = metaData.getTables("IMS_IMESP", "dbo", name, new String[] {"TABLE"});

			if (resultSet.next()) {
				final String tableName = resultSet.getString("TABLE_NAME");

				final PrimaryKey primaryKey = getPrimaryKey(tableName);
				final List<Column> columns = getColumns(tableName);
				final List<ForeignKey> foreignKeys = getForeignKeys(tableName);

				final List<SQLScript> scripts = new ArrayList<SQLScript>();

				scripts.add(createTableSQLScript(tableName, columns, SQLScriptTypes.INSERT));
				scripts.add(createTableSQLScript(tableName, columns, SQLScriptTypes.DELETE));

				return Table.newInstance(tableName, primaryKey, columns, foreignKeys, scripts);
			}
			
			return Table.getNullInstance();
			
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			throw new DatabaseMetadataException(e.getMessage(), e);
			
		} finally {
			ConnectionUtils.close(resultSet);
			ConnectionUtils.close(connection);
		}

//		Connection connection = null;
//		Statement statement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			final StringBuilder sql = new StringBuilder();
//			
//			sql.append("SELECT NAME, XTYPE FROM SYSOBJECTS WHERE ");
//			sql.append("XTYPE = 'U' AND SYSOBJECTS.STATUS >= 0 ");
//			sql.append("AND NAME = '").append(name).append("' ");
//			sql.append("ORDER BY XTYPE, NAME");
//			
//			connection = getDatabaseConfiguration().getConnection();
//			statement = connection.createStatement();
//			resultSet = statement.executeQuery(sql.toString());
//			
//			if (resultSet.next()) {
//				final String tableName = resultSet.getString(1).trim();
//
//				final PrimaryKey primaryKey = getPrimaryKey(tableName);
//				final List<Column> columns = getColumns(tableName);
//				final List<ForeignKey> foreignKeys = getForeignKeys(tableName);
//				
//				final List<SQLScript> scripts = new ArrayList<SQLScript>();
//				
//				scripts.add(createTableScript(tableName, columns, SQLScriptTypes.INSERT));
//				scripts.add(createTableScript(tableName, columns, SQLScriptTypes.DELETE));
//				
//				return Table.newInstance(tableName, primaryKey, columns, foreignKeys, scripts);
//			}
//			
//			return Table.getNullInstance();
//			
//		} catch (SQLException e) {
//			logger.error(e.getMessage(), e);
//			throw new DatabaseMetadataException(e.getMessage(), e);
//
//		} finally {
//			ConnectionUtils.close(resultSet);
//			ConnectionUtils.close(statement);
//			ConnectionUtils.close(connection);
//		}
	}

	/* (non-Javadoc)
	 * @see DatabaseMetadata#getView(java.lang.String)
	 */
	public View getView(String name) {
		
		Connection connection = null;
		DatabaseMetaData metaData = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = getDatabaseConfiguration().getConnection();
			metaData = connection.getMetaData();
			resultSet = metaData.getTables("IMS_IMESP", "dbo", name, new String[] {"VIEW"});

			if (resultSet.next()) {
				final String tableName = resultSet.getString("TABLE_NAME");
				final List<Column> columns = getColumns(tableName);

				final List<SQLScript> scripts = new ArrayList<SQLScript>();

				scripts.add(createTableSQLScript(tableName, columns, SQLScriptTypes.INSERT));
				scripts.add(createTableSQLScript(tableName, columns, SQLScriptTypes.DELETE));

				return View.newInstance(tableName, columns, scripts);
			}
			
			return View.getNullInstance();
			
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			throw new DatabaseMetadataException(e.getMessage(), e);
			
		} finally {
			ConnectionUtils.close(resultSet);
			ConnectionUtils.close(connection);
		}

//		Connection connection = null;
//		Statement statement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			final StringBuilder sql = new StringBuilder();
//			
//			sql.append("SELECT NAME, XTYPE FROM SYSOBJECTS WHERE ");
//			sql.append("XTYPE='V' AND SYSOBJECTS.STATUS >= 0 ");
//			sql.append("AND NAME = '").append(name).append("' ");
//			sql.append("ORDER BY XTYPE, NAME");
//			
//			connection = getDatabaseConfiguration().getConnection();
//			statement = connection.createStatement();
//			resultSet = statement.executeQuery(sql.toString());
//			
//			if (resultSet.next()) {
//				final String viewName = resultSet.getString(1).trim();
//				final List<Column> columns = getColumns(name);
//				final List<SQLScript> scripts = new ArrayList<SQLScript>();
//				
//				scripts.add(createViewSQLScript(name, columns, SQLScriptTypes.INSERT));
//				scripts.add(createViewSQLScript(name, columns, SQLScriptTypes.DELETE));
//
//				return View.newInstance(viewName, columns, scripts);
//			}
//			
//			return View.getNullInstance();
//			
//		} catch (SQLException e) {
//			logger.error(e.getMessage(), e);
//			throw new DatabaseMetadataException(e.getMessage(), e);
//
//		} finally {
//			ConnectionUtils.close(resultSet);
//			ConnectionUtils.close(statement);
//			ConnectionUtils.close(connection);
//		}

	}

	/* (non-Javadoc)
	 * @see DatabaseMetadata#getGenerator(java.lang.String)
	 */
	public Generator getGenerator(String name) {
		logger.info("The database MSSQL does not allow generators!");
		return Generator.getNullInstance();
	}

	/* (non-Javadoc)
	 * @see DatabaseMetadata#getTrigger(java.lang.String)
	 */
	public Trigger getTrigger(String name) {
	
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			final StringBuilder sql = new StringBuilder();

			sql.append("SELECT O.NAME, C.TEXT FROM SYSOBJECTS AS O, SYSCOMMENTS AS C ");
			sql.append("WHERE O.ID = C.ID AND O.XTYPE='TR' ");
			sql.append("AND O.NAME = '").append(name).append("'");
			
			connection = getDatabaseConfiguration().getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql.toString());
			
			if (resultSet.next()) {
				final String triggerName = resultSet.getString(1);
				final String insertScript = resultSet.getString(2);
				final List<SQLScript> scripts = new ArrayList<SQLScript>();
				
				scripts.add(SQLScript.newInstance(insertScript, SQLScriptTypes.INSERT));
				scripts.add(SQLScript.newInstance("DROP TRIGGER " + triggerName, SQLScriptTypes.DELETE));
				
				return Trigger.newInstance(triggerName, scripts);
			}
			
			return Trigger.getNullInstance();
			
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			throw new DatabaseMetadataException(e.getMessage(), e);
			
		} finally {
			ConnectionUtils.close(resultSet);
			ConnectionUtils.close(statement);
			ConnectionUtils.close(connection);
		}

	}

	/** TODO (paulo 15/02/2011 14:54:16): escrever javadoc */
	private SQLScript createViewSQLScript(String name, List<Column> columns, SQLScriptTypes type) {
		
		if (type.equals(SQLScriptTypes.INSERT)) {
			Connection connection = null;
			Statement statement = null;
			ResultSet resultSet = null;
			
			try {
				final StringBuilder sql = new StringBuilder();
				
				sql.append("SELECT SYSOBJECTS.NAME, SYSCOMMENTS.COLID, ");
	            sql.append("SYSCOMMENTS.TEXT FROM SYSOBJECTS, SYSCOMMENTS ");
	            sql.append("WHERE SYSOBJECTS.ID = SYSCOMMENTS.ID ");
	            sql.append("AND (SYSOBJECTS.XTYPE = 'V') AND SYSOBJECTS.NAME = '").append(name).append("' ");
	            sql.append("ORDER BY SYSOBJECTS.NAME, SYSCOMMENTS.COLID ");            
	            
	            connection = getDatabaseConfiguration().getConnection();
	            statement = connection.createStatement();
	            resultSet = statement.executeQuery(sql.toString());
	            
	            if (resultSet.next()) {
	            	return SQLScript.newInstance(resultSet.getString(3), type); 
	            }
	            
	            return SQLScript.getNullInstance();
	            
	        } catch (SQLException e) {
				logger.error(e.getMessage(), e);
				throw new DatabaseMetadataException(e.getMessage(), e);
				
			} finally {
				ConnectionUtils.close(resultSet);
				ConnectionUtils.close(statement);
				ConnectionUtils.close(connection);
			}
			
		} else if (type.equals(SQLScriptTypes.DELETE)) {
			return SQLScript.newInstance("DROP VIEW " + name, type);
		}
		
		return SQLScript.getNullInstance();
	}

	/** TODO (paulo 11/02/2011 19:21:13): escrever javadoc */
	private SQLScript createForeignKeySQLScript(String name, String ownerName, String relationshipName, List<String> columnNames, List<String> relationshipColumnNames, SQLScriptTypes type) {
		final StringBuilder sb = new StringBuilder();
		List<String> lista = null;
		int tamCampos = 0;

		if (type.equals(SQLScriptTypes.INSERT)) {
			sb.append("ALTER TABLE ").append(ownerName).append(" ");
			sb.append("ADD CONSTRAINT ").append(name).append(" FOREIGN KEY ( ");
	
			lista = columnNames;
			tamCampos = lista.size();
	
			for (int i = 0; i < tamCampos; i++) {
				if (i + 1 >= tamCampos) {
					sb.append(lista.get(i)).append(") REFERENCES ");
					sb.append(relationshipName).append("( ");
				} else
					sb.append(lista.get(i)).append(", ");
			}
	
			lista = relationshipColumnNames;
			tamCampos = lista.size();
	
			for (int i = 0; i < tamCampos; i++) {
				if (i + 1 >= tamCampos)
					sb.append(lista.get(i)).append(") ");
				else
					sb.append(lista.get(i)).append(", ");
			}
	
	        return SQLScript.newInstance(sb.toString(), SQLScriptTypes.INSERT);
		} else if (type.equals(SQLScriptTypes.DELETE)) {
	        StringBuilder sql = new StringBuilder();
            sql.append("ALTER TABLE ").append(ownerName).append(" ");
            sql.append("DROP CONSTRAINT ").append(name);
	        return SQLScript.newInstance(sql.toString(), type);
		}
	
		return SQLScript.getNullInstance();
	}
	
	/** TODO (paulo 11/02/2011 16:57:29): escrever javadoc */
	private SQLScript createTableSQLScript(String tableName,
			List<Column> columns, SQLScriptTypes type) {

		if (type.equals(SQLScriptTypes.INSERT)) {

			final StringBuilder sql = new StringBuilder();
			sql.append("CREATE TABLE ").append(tableName).append("\n(\n");

			for (Column column : columns) {
				String columnType = column.getType();

				if (columnType.equalsIgnoreCase("VARCHAR") || columnType.equalsIgnoreCase("CHAR")) {
					columnType += "(" + column.getLength() + ")";
				}

				if (!column.isNullable()) {
					columnType += " NOT NULL";
				}

				if (columns.indexOf(column) < columns.size() - 1) {
					sql.append(column.getName()).append(" ").append(columnType).append(",\n");
				} else {
					sql.append(column.getName()).append(" ").append(columnType).append("\n");
				}
			}

			sql.append(") ");

			return SQLScript.newInstance(sql.toString(), type);
			
		} else if (type.equals(SQLScriptTypes.DELETE)) {
	        return SQLScript.newInstance("DROP TABLE " + tableName, type);
		}
		
		return SQLScript.getNullInstance();
	}

	/** TODO (paulo 11/02/2011 16:57:08): escrever javadoc */
	private List<ForeignKey> getForeignKeys(String tableName) {
		
		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		try {
			final StringBuilder sql = new StringBuilder();
			final List<ForeignKey> foreignKeys = new ArrayList<ForeignKey>();

            sql.append("SELECT COBJECT.NAME FOREIGN_KEY, ");
            sql.append("ROBJECT.NAME REFERENCIA, RCOLUMN.NAME COL_REF, ");
            sql.append("FCOLUMN.NAME COL_FK, SYSFOREIGNKEYS.KEYNO COL_NUM ");
            sql.append("FROM SYSFOREIGNKEYS INNER JOIN ");
            sql.append("SYSOBJECTS COBJECT ON (SYSFOREIGNKEYS.CONSTID=COBJECT.ID) ");
            sql.append("INNER JOIN SYSOBJECTS FOBJECT ON (SYSFOREIGNKEYS.FKEYID=FOBJECT.ID) ");
            sql.append("INNER JOIN SYSOBJECTS ROBJECT ON (SYSFOREIGNKEYS.RKEYID=ROBJECT.ID) ");
            sql.append("INNER JOIN SYSCOLUMNS FCOLUMN ON (SYSFOREIGNKEYS.FKEYID=FCOLUMN.ID ");
            sql.append("AND SYSFOREIGNKEYS.FKEY=FCOLUMN.COLID) ");
            sql.append("INNER JOIN SYSCOLUMNS RCOLUMN ON (SYSFOREIGNKEYS.RKEYID=RCOLUMN.ID AND ");
            sql.append("SYSFOREIGNKEYS.RKEY=RCOLUMN.COLID) ");
            sql.append("WHERE FOBJECT.NAME = '").append(tableName).append("' ");
            sql.append("ORDER BY COBJECT.NAME, SYSFOREIGNKEYS.KEYNO ");
			
			connection = getDatabaseConfiguration().getConnection();
			statement = connection.createStatement();
			resultSet = statement.executeQuery(sql.toString());

			String lastForeignKeyName = null;
            String foreignKeyName = null;
            String relationshipName = null;
			
            final List<String> relationshipColumnNames = new ArrayList<String>();
			final List<String> columnNames = new ArrayList<String>();
            final List<SQLScript> scripts = new ArrayList<SQLScript>();
			
			
			while(resultSet.next()) {
				final boolean isTheSameForeignKey = lastForeignKeyName == null || lastForeignKeyName.equals(resultSet.getString(1).trim());
				
				if (isTheSameForeignKey) {
					columnNames.add(resultSet.getString(3).trim());
					columnNames.add(resultSet.getString(4).trim());
					continue;
				} else {
					final SQLScript insertScript = createForeignKeySQLScript(foreignKeyName, tableName, relationshipName, columnNames, relationshipColumnNames, SQLScriptTypes.INSERT);
					final SQLScript deleteScript = createForeignKeySQLScript(foreignKeyName, tableName, relationshipName, columnNames, relationshipColumnNames, SQLScriptTypes.DELETE);

					scripts.add(insertScript);
					scripts.add(deleteScript);
					
					final ForeignKey foreignKey = ForeignKey.newInstance(foreignKeyName, tableName, relationshipName, columnNames, relationshipColumnNames, scripts);
					
					foreignKeys.add(foreignKey);
				}
			}
            
			return foreignKeys;
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			throw new DatabaseMetadataException(e.getMessage(), e);

		} finally {
			ConnectionUtils.close(resultSet);
			ConnectionUtils.close(statement);
			ConnectionUtils.close(connection);
		}
	}

	/** TODO (paulo 11/02/2011 16:57:06): escrever javadoc */
	private List<Column> getColumns(String tableName) {

		Connection connection = null;
		DatabaseMetaData metaData = null;
		ResultSet resultSet = null;
		
		try { 

			connection = getDatabaseConfiguration().getConnection();
			metaData = connection.getMetaData();
			resultSet = metaData.getColumns("IMS_IMESP", "dbo", tableName, null);

			final List<Column> columns = new ArrayList<Column>();
			
			while (resultSet.next()) {
				final String  columnName = resultSet.getString("COLUMN_NAME");
				final String  typeName   = resultSet.getString("TYPE_NAME");
				final int     length     = resultSet.getInt("COLUMN_SIZE");
				final boolean isNullable = (resultSet.getInt("NULLABLE") == DatabaseMetaData.columnNullable);
				
				final SQLScript insertScript = createColumnSQLScript(columnName, tableName, typeName, length, isNullable, SQLScriptTypes.INSERT);
				final SQLScript alterScript  = createColumnSQLScript(columnName, tableName, typeName, length, isNullable, SQLScriptTypes.ALTER);
				final SQLScript deleteScript = createColumnSQLScript(columnName, tableName, typeName, length, isNullable, SQLScriptTypes.DELETE);
				
				final List<SQLScript> scripts = new ArrayList<SQLScript>();

				scripts.add(insertScript);				
				scripts.add(alterScript);				
				scripts.add(deleteScript);				
	
				final Column column = Column.newInstance(columnName, tableName, typeName, length, isNullable, scripts);
				
				columns.add(column);
			}
			
			return columns;
			
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			throw new DatabaseMetadataException(e.getMessage(), e);

		} finally {
			ConnectionUtils.close(resultSet);
			ConnectionUtils.close(connection);
		}
		
//		Connection connection = null;
//		Statement statement = null;
//		ResultSet resultSet = null;
//		ResultSetMetaData resultSetMetaData = null;
//		
//		try {
//			final StringBuilder sql = new StringBuilder();
//			
//			sql.append("SELECT * FROM ").append(tableName);
//			
//			connection = getDatabaseConfiguration().getConnection();
//			connection.getCatalog();
//			statement = connection.createStatement();
//			statement.setMaxRows(1);
//			resultSet = statement.executeQuery(sql.toString());
//			resultSetMetaData = resultSet.getMetaData();
//
//			final List<Column> columns = new ArrayList<Column>();
//			
//			for (int i = 1; i <= resultSetMetaData.getColumnCount(); i++) {
//				final List<SQLScript> scripts = new ArrayList<SQLScript>();
//				final String columnName = resultSetMetaData.getColumnName(i);
//				final SQLScript insertScript = createColumnSQLScript(columnName, tableName, resultSetMetaData.getColumnTypeName(i), resultSetMetaData.getColumnDisplaySize(i), resultSetMetaData.isNullable(i) == ResultSetMetaData.columnNullable, SQLScriptTypes.INSERT);
//				final SQLScript alterScript = createColumnSQLScript(columnName, tableName, resultSetMetaData.getColumnTypeName(i), resultSetMetaData.getColumnDisplaySize(i), resultSetMetaData.isNullable(i) == ResultSetMetaData.columnNullable, SQLScriptTypes.ALTER);
//				final SQLScript deleteScript = createColumnSQLScript(columnName, tableName, resultSetMetaData.getColumnTypeName(i), resultSetMetaData.getColumnDisplaySize(i), resultSetMetaData.isNullable(i) == ResultSetMetaData.columnNullable, SQLScriptTypes.DELETE);
//
//				scripts.add(insertScript);				
//				scripts.add(alterScript);				
//				scripts.add(deleteScript);				
//
//				final Column column = Column.newInstance(
//								columnName,
//								tableName,
//								resultSetMetaData.getColumnTypeName(i),
//								resultSetMetaData.getColumnDisplaySize(i),
//								resultSetMetaData.isNullable(i) == ResultSetMetaData.columnNullable,
//								scripts);
//				
//				columns.add(column);
//			}
//			
//			return columns;
//			
//		} catch (SQLException e) {
//			logger.error(e.getMessage(), e);
//			throw new DatabaseMetadataException(e.getMessage(), e);
//
//		} finally {
//			ConnectionUtils.close(resultSet);
//			ConnectionUtils.close(statement);
//			ConnectionUtils.close(connection);
//		}
	}

	/** TODO (paulo 11/02/2011 20:15:23): escrever javadoc */
	private SQLScript createColumnSQLScript(String name, String ownerName, String columnType, int length, boolean nullable, SQLScriptTypes type) {

		final StringBuilder sb = new StringBuilder();
		
		if (type.equals(SQLScriptTypes.INSERT)) {
			sb.append("ALTER TABLE ").append(ownerName).append(" ADD ").append(name).append(" ").append(columnType);
			
			if (columnType.equals("VARCHAR") || columnType.equals("CHAR")) {
				sb.append("(").append(length).append(")");
			} 
			
			if (! nullable) {
				sb.append(" NOT NULL");
			}
			
		} else if (type.equals(SQLScriptTypes.DELETE)) {
			sb.append("ALTER TABLE ").append(ownerName).append(" DROP ").append(name);
			
		} else if (type.equals(SQLScriptTypes.ALTER)) {
			sb.append("ALTER TABLE ").append(ownerName).append(" ALTER ").append(name).append(" TYPE ").append(columnType);
			
			
			if (columnType.equals("VARCHAR") || columnType.equals("CHAR")) {
				sb.append("(").append(length).append(")");
			} 
			
			if (! nullable) {
				sb.append(" NOT NULL");
			}
		} else {
			return SQLScript.getNullInstance();
		}
		
		return SQLScript.newInstance(sb.toString(), type);
	}

	/** TODO (paulo 11/02/2011 16:57:03): escrever javadoc */
	private PrimaryKey getPrimaryKey(String tableName) {

		Connection connection = null;
		DatabaseMetaData metaData = null;
		ResultSet resultSet = null;
		
		try {
			
			connection = getDatabaseConfiguration().getConnection();
			metaData = connection.getMetaData();
			resultSet = metaData.getPrimaryKeys("IMS_IMESP", "dbo", tableName);

			final List<String> columnNames = new ArrayList<String>();
	        final List<SQLScript> scripts = new ArrayList<SQLScript>();

			boolean hasResultSet = false;
			String primaryKeyName = null;
			
	        while (resultSet.next()) {
	        	primaryKeyName = resultSet.getString("PK_NAME");
        		columnNames.add(resultSet.getString("COLUMN_NAME"));
				hasResultSet = true;
			}
	        
	        if (hasResultSet) {
		        final SQLScript insertScript = createPrimaryKeySQLScript(primaryKeyName, tableName, columnNames, SQLScriptTypes.INSERT);
				final SQLScript deleteScript = createPrimaryKeySQLScript(primaryKeyName, tableName, columnNames, SQLScriptTypes.DELETE);
	
				scripts.add(insertScript);
				scripts.add(deleteScript);

				return PrimaryKey.newInstance(primaryKeyName, tableName, columnNames, scripts);
	        }
	        
	        return PrimaryKey.getNullInstance();
				
		} catch (SQLException e) {
			logger.error(e.getMessage(), e);
			throw new DatabaseMetadataException(e.getMessage(), e);

		} finally {
			ConnectionUtils.close(resultSet);
			ConnectionUtils.close(connection);
		}

//		Connection connection = null;
//		Statement statement = null;
//		ResultSet resultSet = null;
//		
//		try {
//			final StringBuilder sql = new StringBuilder();
//			
//			sql.append("SELECT OBJ_1.NAME, SYSOBJECTS.NAME, ");
//	        sql.append("SYSCOLUMNS.NAME, SYSINDEXKEYS.COLID FROM SYSINDEXES ");
//	        sql.append("INNER JOIN SYSINDEXKEYS ON SYSINDEXKEYS.ID = SYSINDEXES.ID AND ");
//	        sql.append("SYSINDEXKEYS.INDID = SYSINDEXES.INDID INNER JOIN SYSCOLUMNS ");
//	        sql.append("ON  SYSINDEXKEYS.COLID = SYSCOLUMNS.COLID AND SYSINDEXKEYS.ID ");
//	        sql.append("= SYSCOLUMNS.ID INNER JOIN SYSCONSTRAINTS INNER JOIN ");
//	        sql.append("SYSOBJECTS OBJ_1 ON  SYSCONSTRAINTS.ID = OBJ_1.ID ");
//	        sql.append("INNER JOIN SYSOBJECTS ON  SYSCONSTRAINTS.CONSTID = SYSOBJECTS.ID ON ");
//	        sql.append("SYSINDEXES.NAME = SYSOBJECTS.NAME ");
//	        sql.append("WHERE OBJ_1.NAME = '").append(tableName).append("' ");
//	        sql.append("ORDER BY OBJ_1.NAME, SYSINDEXKEYS.COLID ");
//	        
//	        connection = getDatabaseConfiguration().getConnection();
//	        statement = connection.createStatement();
//	        resultSet = statement.executeQuery(sql.toString());
//	        
//	        String primaryKeyName = null;
//	        boolean hasResultSet = false;
//	        final List<String> columnNames = new ArrayList<String>();
//	        final List<SQLScript> scripts = new ArrayList<SQLScript>();
//	        
//	        while (resultSet.next()) {
//        		primaryKeyName = resultSet.getString(2).trim();
//    			columnNames.add(resultSet.getString(3));
//    			hasResultSet = true;
//	        }
//
//	        if (!hasResultSet) {
//	        	return PrimaryKey.getNullInstance();
//	        }
//	        
//	        final SQLScript insertScript = createPrimaryKeySQLScript(primaryKeyName, tableName, columnNames, SQLScriptTypes.INSERT);
//			final SQLScript deleteScript = createPrimaryKeySQLScript(primaryKeyName, tableName, columnNames, SQLScriptTypes.DELETE);
//
//			scripts.add(insertScript);
//			scripts.add(deleteScript);
//	        
//	        return PrimaryKey.newInstance(primaryKeyName, tableName, columnNames, scripts);
//	        
//		} catch (SQLException e) {
//			logger.error(e.getMessage(), e);
//			throw new DatabaseMetadataException(e.getMessage(), e);
//
//		} finally {
//			ConnectionUtils.close(resultSet);
//			ConnectionUtils.close(statement);
//			ConnectionUtils.close(connection);
//		}
	}

	/** TODO (paulo 15/02/2011 14:26:11): escrever javadoc */
	private SQLScript createPrimaryKeySQLScript(String name, String ownerName, List<String> columnNames, SQLScriptTypes type) {
		
		
		if (type.equals(SQLScriptTypes.INSERT)) {
			final StringBuilder sql = new StringBuilder();
			sql.append("ALTER TABLE ").append(ownerName).append(" ADD CONSTRAINT ").append(name).append(" PRIMARY KEY(");
			Iterator<String> columnNamesIterator = columnNames.iterator();
			
			while(columnNamesIterator.hasNext()) {
				final String columnName = columnNamesIterator.next();
				sql.append(columnName);
				
				if (columnNamesIterator.hasNext()) {
					sql.append(",");
				} else {
					sql.append(") ");
				}
			}
			
			return SQLScript.newInstance(sql.toString(), type);
			
		} else if (type.equals(SQLScriptTypes.DELETE)) {
			final StringBuilder sql = new StringBuilder();
			
			sql.append("ALTER TABLE ").append(ownerName).append(" DROP CONSTRAINT ").append(name);
			
			return SQLScript.newInstance(sql.toString(), type);
		} 

		return SQLScript.getNullInstance();
		
	}
	
}
