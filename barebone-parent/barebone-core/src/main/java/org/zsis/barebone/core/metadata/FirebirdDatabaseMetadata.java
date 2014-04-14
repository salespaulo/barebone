/**
 * barebone-core
 *
 * Copyright 2011 Z Sistemas Ltda ME
 *
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
package org.zsis.barebone.core.metadata;

import java.util.List;

import org.zsis.barebone.core.configuration.DatabaseConfiguration;
import org.zsis.barebone.core.metadata.objects.Generator;
import org.zsis.barebone.core.metadata.objects.Relationship;
import org.zsis.barebone.core.metadata.objects.Table;
import org.zsis.barebone.core.metadata.objects.Trigger;
import org.zsis.barebone.core.metadata.objects.View;

/**
 * TODO (paulo 07/01/2011 15:22:07): escrever javadoc
 *
 * @author psales
 *
 */
class FirebirdDatabaseMetadata extends AbstractDatabaseMetadata {

	/**
	 * TODO (paulo 15/02/2011 18:33:47): escrever javadoc
	 *
	 * @param databaseConfiguration
	 */
	public FirebirdDatabaseMetadata(DatabaseConfiguration databaseConfiguration) {
		super(databaseConfiguration);
		// TODO Auto-generated constructor stub
	}

	/* (non-Javadoc)
	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getTables()
	 */
	public List<Table> getTables() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getViews()
	 */
	public List<View> getViews() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getGenerators()
	 */
	public List<Generator> getGenerators() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getTriggers()
	 */
	public List<Trigger> getTriggers() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getRelationship()
	 */
	public List<Relationship> getRelationships() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getTable(java.lang.String)
	 */
	public Table getTable(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getView(java.lang.String)
	 */
	public View getView(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getGenerator(java.lang.String)
	 */
	public Generator getGenerator(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getTrigger(java.lang.String)
	 */
	public Trigger getTrigger(String name) {
		// TODO Auto-generated method stub
		return null;
	}

//	private static final Logger logger = LoggerFactory.getLogger(FirebirdDatabaseMetadata.class);
//	
//	/**
//	 * TODO (paulo 07/01/2011 15:25:09): escrever javadoc
//	 *
//	 * @param databaseConfiguration
//	 */
//	public FirebirdDatabaseMetadata(DatabaseConfiguration databaseConfiguration) {
//		super(databaseConfiguration);
//	}
//
//	/*
//	 * (non-Javadoc)
//	 * 
//	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getTables()
//	 */
//	public List<Table> getTables() {
//		final List<Table> tables = new ArrayList<Table>();
//		final Connection connection = getDatabaseConfiguration().getConnection();;
//
//		Statement stm = null;
//		ResultSet rs = null;
//
//		try {
//			stm = connection.createStatement();
//
//			final StringBuilder sql = new StringBuilder();
//
//			sql.append("SELECT RDB$RELATION_NAME FROM RDB$RELATIONS WHERE ");
//			sql.append("(RDB$SYSTEM_FLAG = '0' OR RDB$SYSTEM_FLAG IS NULL) ");
//			sql.append("AND RDB$VIEW_BLR IS NULL ORDER BY RDB$RELATION_NAME ");
//			
//			rs = stm.executeQuery(sql.toString());
//
//			while (rs.next()) {
//				final String tableName = rs.getString(1).trim();
//				final PrimaryKey primaryKey = getPrimaryKey(tableName);
//				final List<Column> columns = getColumns(tableName);
//				final List<ForeignKey> foreignKeys = getForeignKeys(tableName);
////				final SQLScript script = getScript(table);
//				
//				// tabela.setPrimaryKey(getPrimaryKey(tabela));
//				// tabela.setForeignKeys(getForeignKeys(tabela));
//				// tabela.setCampos(getCampos(tabela));
//				// // script criação
//				// tabela.adicionarScript(scriptTabela(tabela));
//				// // script exclusão
//				// tabela.adicionarScript(scriptTabelaExclusao(tabela));
//				//lista.add(tabela);
//			}
//		} catch (SQLException eSQL) {
//			// throw new MetadadoException("ERRO: Lendo Metadados das Tabelas.",
//			// eSQL);
//		} finally {
//			ConnectionUtils.close(rs);
//			ConnectionUtils.close(stm);
//			ConnectionUtils.close(connection);
//		}
//
//		return tables;
//	}
//
//	/* (non-Javadoc)
//	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getViews()
//	 */
//	public List<View> getViews() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	/* (non-Javadoc)
//	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getGenerators()
//	 */
//	public List<Generator> getGenerators() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	/* (non-Javadoc)
//	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getTrigger()
//	 */
//	public List<Trigger> getTrigger() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	/* (non-Javadoc)
//	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getRelationship()
//	 */
//	public List<Relationship> getRelationship() {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	/* (non-Javadoc)
//	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getTable(java.lang.String)
//	 */
//	public Table getTable(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	/* (non-Javadoc)
//	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getView(java.lang.String)
//	 */
//	public View getView(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	/* (non-Javadoc)
//	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getGenerator(java.lang.String)
//	 */
//	public Generator getGenerator(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	/* (non-Javadoc)
//	 * @see org.zsis.barebone.core.metadata.DatabaseMetadata#getTrigger(java.lang.String)
//	 */
//	public Trigger getTrigger(String name) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	/** TODO (paulo 21/01/2011 15:54:40): escrever javadoc */
//	private PrimaryKey getPrimaryKey(String tableName) {
////        Statement stm = null;
////        ResultSet rs = null;
////        PrimaryKey primaryKey = null;
////        Campo campo = null;
////        StringBuilder sql = new StringBuilder("");
////        String ultimaPk = "";
////        Connection conn = null;
////        
////        try
////        {       
////            log.info("INFO: Consultando metadados da primary key p/ " + proprietario.getNome() + ".");
////            log.debug("DEBUG: Consultando metadados da primary key p/ " + proprietario.getNome() + ".");
////            conn = conexao.getConnection();
////            stm = conn.createStatement();
////            sql.append("SELECT RDB$RELATION_CONSTRAINTS.RDB$RELATION_NAME, "); 
////            sql.append("RDB$RELATION_CONSTRAINTS.RDB$CONSTRAINT_NAME, "); 
////            sql.append("RDB$INDEX_SEGMENTS.RDB$FIELD_NAME, "); 
////            sql.append("RDB$INDEX_SEGMENTS.RDB$FIELD_POSITION "); 
////            sql.append("FROM RDB$RELATION_CONSTRAINTS "); 
////            sql.append("INNER JOIN RDB$INDEX_SEGMENTS ON "); 
////            sql.append("(RDB$RELATION_CONSTRAINTS.RDB$INDEX_NAME=RDB$INDEX_SEGMENTS.RDB$INDEX_NAME) "); 
////            sql.append("WHERE RDB$RELATION_CONSTRAINTS.RDB$CONSTRAINT_TYPE='PRIMARY KEY' "); 
////            sql.append("AND RDB$RELATION_CONSTRAINTS.RDB$RELATION_NAME = '").append(proprietario.getNome());
////            sql.append("' ORDER BY RDB$RELATION_CONSTRAINTS.RDB$CONSTRAINT_NAME, "); 
////            sql.append("RDB$INDEX_SEGMENTS.RDB$FIELD_POSITION ");
////            rs =  stm.executeQuery(sql.toString());
////
////            while (rs.next() && proprietario instanceof Tabela)
////            {
////                if (!ultimaPk.equals(rs.getString(2).trim()))
////                {
////                    if (primaryKey != null)
////                    {
////                        primaryKey.adicionarScript(scriptPk(primaryKey));
////                      primaryKey.adicionarScript(scriptPkExclusao(primaryKey));
////                    }
////                        
////                    primaryKey = new PrimaryKey((Tabela)proprietario, rs.getString(2).trim());
////                    ultimaPk = rs.getString(2).trim();
////                }
////                
////                primaryKey.setNomeDosCampos(rs.getString(3).trim());
////            }
////        }catch(SQLException eSQL)
////        {
////            throw new MetadadoException("ERRO: Lendo Metadados da Primary Key.", eSQL);
////        }catch(ConexaoException eConexao)
////        {
////            throw new MetadadoException("ERRO: Lendo Metadados da Primaty Key.", eConexao);
////        }finally
////        {
////            ConexaoUtils.fechar(rs);
////            ConexaoUtils.fechar(stm);
////            ConexaoUtils.fechar(conn);
////        }
////        
////        if (primaryKey != null)
////        {
////            primaryKey.adicionarScript(scriptPk(primaryKey));
////            primaryKey.adicionarScript(scriptPkExclusao(primaryKey));
////        }
////        
////        return primaryKey;
//		return null;
//	}
//	
//	
//	/** TODO (paulo 21/01/2011 15:54:40): escrever javadoc */
//	private List<Column> getColumns(String tableName) {
//        Connection conn = null;
//        Statement stm = null;
//        ResultSet rs = null;
//        ResultSetMetaData rsmd = null;
//        final List<Column> columns = new ArrayList<Column>();
//        
//		try {
//			conn = getDatabaseConfiguration().getConnection();
//			stm = conn.createStatement();
//			stm.setMaxRows(1);
//			rs = stm.executeQuery("SELECT * FROM " + tableName);
//			rsmd = rs.getMetaData();
//
//			for (int i = 1; i <= rsmd.getColumnCount(); i++) {
//				final List<SQLScript> scripts = new ArrayList<SQLScript>();
//				final SQLScript insertScript = createColumnSQLScript(rsmd.getColumnName(i), tableName, rsmd.getColumnTypeName(i), rsmd.getColumnDisplaySize(i), rsmd.isNullable(i) == ResultSetMetaData.columnNullable, SQLScriptTypes.INSERT);
//				final SQLScript alterScript = createColumnSQLScript(rsmd.getColumnName(i), tableName, rsmd.getColumnTypeName(i), rsmd.getColumnDisplaySize(i), rsmd.isNullable(i) == ResultSetMetaData.columnNullable, SQLScriptTypes.ALTER);
//				final SQLScript deleteScript = createColumnSQLScript(rsmd.getColumnName(i), tableName, rsmd.getColumnTypeName(i), rsmd.getColumnDisplaySize(i), rsmd.isNullable(i) == ResultSetMetaData.columnNullable, SQLScriptTypes.DELETE);
//
//				scripts.add(insertScript);				
//				scripts.add(alterScript);				
//				scripts.add(deleteScript);				
//
//				final Column column = Column.newInstance(rsmd.getColumnName(i), tableName, rsmd.getColumnTypeName(i), rsmd.getColumnDisplaySize(i), rsmd.isNullable(i) == ResultSetMetaData.columnNullable, scripts);
//				
//				columns.add(column);
//			}
//
//		} catch (SQLException eSQL) {
//			// TODO (paulo_sales 27/01/2011) Tratar exceção
//		} finally {
//			ConnectionUtils.close(rs);
//			ConnectionUtils.close(stm);
//			ConnectionUtils.close(conn);
//		}
//        
//        return columns;
//	}
//	
//	private List<ForeignKey> getForeignKeys(String tableName) {
//        Statement stm = null;
//        ResultSet rs = null;
//        List<ForeignKey> foreignKeys = new ArrayList<ForeignKey>();
//        StringBuilder sql = new StringBuilder("");
//        Connection conn = null;
//        
//        try
//        {
//            conn = getDatabaseConfiguration().getConnection();
//            stm = conn.createStatement();
//            sql.append("SELECT RDB$RELATION_CONSTRAINTS1.RDB$CONSTRAINT_NAME NOME, "); 
//            sql.append("       RDB$RELATION_CONSTRAINTS2.RDB$RELATION_NAME REFERENCIA, "); 
//            sql.append("       RDB$INDEX_SEGMENTS1.RDB$FIELD_NAME COLUNA_TABELA, "); 
//            sql.append("       RDB$INDEX_SEGMENTS2.RDB$FIELD_NAME COLUNA_REFERENCIA "); 
//            sql.append("FROM RDB$RELATION_CONSTRAINTS RDB$RELATION_CONSTRAINTS1 "); 
//            sql.append("INNER JOIN RDB$INDICES ON "); 
//            sql.append("(RDB$RELATION_CONSTRAINTS1.RDB$INDEX_NAME=RDB$INDICES.RDB$INDEX_NAME) "); 
//            sql.append("INNER JOIN RDB$RELATION_CONSTRAINTS RDB$RELATION_CONSTRAINTS2 ON "); 
//            sql.append("(RDB$INDICES.RDB$FOREIGN_KEY=RDB$RELATION_CONSTRAINTS2.RDB$INDEX_NAME) "); 
//            sql.append("INNER JOIN RDB$INDEX_SEGMENTS RDB$INDEX_SEGMENTS1 ON "); 
//            sql.append("(RDB$INDICES.RDB$INDEX_NAME=RDB$INDEX_SEGMENTS1.RDB$INDEX_NAME) "); 
//            sql.append("INNER JOIN RDB$INDEX_SEGMENTS RDB$INDEX_SEGMENTS2 ON "); 
//            sql.append("(RDB$INDICES.RDB$FOREIGN_KEY=RDB$INDEX_SEGMENTS2.RDB$INDEX_NAME) "); 
//            sql.append("WHERE RDB$RELATION_CONSTRAINTS1.RDB$CONSTRAINT_TYPE='FOREIGN KEY' "); 
//            sql.append("AND RDB$INDEX_SEGMENTS1.RDB$FIELD_POSITION=RDB$INDEX_SEGMENTS2.RDB$FIELD_POSITION "); 
//            sql.append("AND RDB$RELATION_CONSTRAINTS1.RDB$RELATION_NAME = '"); 
//            sql.append(tableName).append("' ").append("ORDER BY ");
//            sql.append("RDB$RELATION_CONSTRAINTS1.RDB$CONSTRAINT_NAME, RDB$INDEX_SEGMENTS1.RDB$FIELD_POSITION ");
//            rs = stm.executeQuery(sql.toString());
//
//            String lastForeignKeyName = null;
//            String foreignKeyName = null;
//            String relationshipName = null;
//			final List<String> relationshipColumnNames = new ArrayList<String>();
//			final List<String> columnNames = new ArrayList<String>();
//            final List<SQLScript> scripts = new ArrayList<SQLScript>();
//			
//			while (rs.next()) {
//				final boolean isTheSameForeignKey = lastForeignKeyName != null && lastForeignKeyName.equals(rs.getString(1).trim());
//				
//				if (isTheSameForeignKey) {
//					columnNames.add(rs.getString(3).trim());
//					columnNames.add(rs.getString(4).trim());
//					continue;
//				} else {
//					final SQLScript insertScript = createForeignKeySQLScript(foreignKeyName, tableName, relationshipName, columnNames, relationshipColumnNames, SQLScriptTypes.INSERT);
//					final SQLScript deleteScript = createForeignKeySQLScript(foreignKeyName, tableName, relationshipName, columnNames, relationshipColumnNames, SQLScriptTypes.DELETE);
//
//					scripts.add(insertScript);
//					scripts.add(deleteScript);
//					
//					final ForeignKey foreignKey = ForeignKey.newInstance(foreignKeyName, tableName, relationshipName, columnNames, relationshipColumnNames, scripts);
//					
//					foreignKeys.add(foreignKey);
//				}
//			}
//		} catch (SQLException eSQL) {
//			// TODO (paulo_sales 27/01/2011) Tratar exceção
//		} finally {
//			ConnectionUtils.close(rs);
//			ConnectionUtils.close(stm);
//			ConnectionUtils.close(conn);
//		}
//        
//        return foreignKeys;
//	}
//	
//	private SQLScript createColumnSQLScript(String name, String ownerName, String columnType, int length, boolean nullable, SQLScriptTypes type) {
//		final StringBuilder sb = new StringBuilder();
//	
//		if (type.equals(SQLScriptTypes.INSERT)) {
//			sb.append("ALTER TABLE ").append(ownerName).append("ADD ").append(name).append(" ").append(columnType);
//			
//			if (columnType.equals("VARCHAR") || columnType.equals("CHAR")) {
//				sb.append("(").append(length).append(")");
//			} 
//			
//			if (! nullable) {
//				sb.append(" NOT NULL");
//			}
//			
//		} else if (type.equals(SQLScriptTypes.DELETE)) {
//			sb.append("ALTER TABLE ").append(ownerName).append("DROP ").append(name);
//			
//		} else if (type.equals(SQLScriptTypes.ALTER)) {
//			sb.append("ALTER TABLE ").append(ownerName).append("ALTER ").append(name).append(" TYPE ").append(columnType);
//			
//			
//			if (columnType.equals("VARCHAR") || columnType.equals("CHAR")) {
//				sb.append("(").append(length).append(")");
//			} 
//			
//			if (! nullable) {
//				sb.append(" NOT NULL");
//			}
//		}
//		
//		
//		return SQLScript.newInstance(sb.toString(), type);
//	}
//	
//	private SQLScript createForeignKeySQLScript(String name, String ownerName, String relationshipName, List<String> columnNames, List<String> relationshipColumnNames, SQLScriptTypes type) {
//		final StringBuilder sb = new StringBuilder();
//		List<String> lista = null;
//		int tamCampos = 0;
//
//		if (type.equals(SQLScriptTypes.INSERT)) {
//			sb.append("ALTER TABLE ").append(ownerName).append(" ");
//			sb.append("ADD CONSTRAINT ").append(name).append(" FOREIGN KEY ( ");
//	
//			lista = columnNames;
//			tamCampos = lista.size();
//	
//			for (int i = 0; i < tamCampos; i++) {
//				if (i + 1 >= tamCampos) {
//					sb.append(lista.get(i)).append(") REFERENCES ");
//					sb.append(relationshipName).append("( ");
//				} else
//					sb.append(lista.get(i)).append(", ");
//			}
//	
//			lista = relationshipColumnNames;
//			tamCampos = lista.size();
//	
//			for (int i = 0; i < tamCampos; i++) {
//				if (i + 1 >= tamCampos)
//					sb.append(lista.get(i)).append(") ");
//				else
//					sb.append(lista.get(i)).append(", ");
//			}
//	
//	        return SQLScript.newInstance(sb.toString(), SQLScriptTypes.INSERT);
//		} else if (type.equals(SQLScriptTypes.DELETE)) {
//	        StringBuilder sql = new StringBuilder();
//            sql.append("ALTER TABLE ").append(ownerName).append(" ");
//            sql.append("DROP CONSTRAINT ").append(name);
//	        return SQLScript.newInstance(sql.toString(), type);
//		}
//	
//		return null;
//	}
//	
//	private SQLScript createTableSQLScript(String tableName, List<Column> columns, SQLScriptTypes type) {
//
//		if (type.equals(SQLScriptTypes.INSERT)) {
//
//			final StringBuilder sql = new StringBuilder();
//			final StringBuilder sqlColumn = new StringBuilder();
//
//			for (Column column : columns) {
//				String columnType = column.getType();
//
//				if (columnType.equalsIgnoreCase("VARCHAR") || columnType.equalsIgnoreCase("CHAR")) {
//					columnType += "(" + column.getLength() + ")";
//				}
//
//				if (!column.isNullable()) {
//					columnType += " NOT NULL";
//				}
//
//				if (columns.indexOf(column) < columns.size() - 1) {
//					sqlColumn.append(column.getName()).append(" ").append(columnType).append(",\n");
//				} else {
//					sqlColumn.append(column.getName()).append(" ").append(columnType).append("\n");
//				}
//			}
//
//			sql.append("CREATE TABLE ").append(tableName).append("\n(\n");
//			sql.append(sqlColumn.toString()).append(") ");
//
//			return SQLScript.newInstance(sql.toString(), type);
//			
//		} else if (type.equals(SQLScriptTypes.DELETE)) {
//	        return SQLScript.newInstance("DROP TABLE " + tableName, type);
//		}
//		
//		return null;
//	}
	
}