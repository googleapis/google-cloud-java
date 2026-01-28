/*
 * Copyright 2026 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.Field.Mode;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.exception.BigQueryJdbcSqlFeatureNotSupportedException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

/** This class returns ResultSetMetadata for the JSON and the Arrow ResultSets */
class BigQueryResultSetMetadata implements ResultSetMetaData {
  private final BigQueryJdbcCustomLogger LOG = new BigQueryJdbcCustomLogger(this.toString());
  private final FieldList schemaFieldList;
  private final Statement statement;
  private final int columnCount;

  private static final int DEFAULT_DISPLAY_SIZE = 50;

  private BigQueryResultSetMetadata(FieldList schemaFieldList, Statement statement) {
    LOG.finest("++enter++");
    this.schemaFieldList = schemaFieldList;
    this.columnCount = schemaFieldList.size();
    this.statement = statement;
  }

  static BigQueryResultSetMetadata of(FieldList schemaFieldList, Statement statement) {
    return new BigQueryResultSetMetadata(schemaFieldList, statement);
  }

  private Field getField(int sqlColumn) {
    return this.schemaFieldList.get(sqlColumn - 1);
  }

  @Override
  public int getColumnCount() {
    return this.columnCount;
  }

  @Override
  public boolean isAutoIncrement(int column) {
    // BQ doesn't support auto increment
    return false;
  }

  @Override
  public boolean isCaseSensitive(int column) {
    int colType = getColumnType(column);
    return colType == Types.NVARCHAR;
  }

  @Override
  public boolean isSearchable(int column) {
    int colType = getColumnType(column);
    return colType != Types.OTHER;
  }

  @Override
  public boolean isCurrency(int column) {
    return false;
  }

  @Override
  public int isNullable(int column) {
    Mode colMode = getField(column).getMode();
    if (colMode == null) {
      return ResultSetMetaData.columnNullableUnknown;
    }
    return colMode == Mode.NULLABLE
        ? ResultSetMetaData.columnNullable
        : ResultSetMetaData.columnNoNulls;
  }

  @Override
  public boolean isSigned(int column) {
    int colType = getColumnType(column);
    return colType == Types.FLOAT
        || colType == Types.DOUBLE
        || colType == Types.BIGINT
        || colType == Types.NUMERIC;
  }

  @Override
  public int getColumnDisplaySize(int column) {
    int colType = getColumnType(column);
    switch (colType) {
      case Types.BOOLEAN:
        return 5;
      case Types.DATE:
      case Types.BIGINT:
        return 10;
      case Types.DOUBLE:
      case Types.DECIMAL:
      case Types.NUMERIC:
        return 14;
      case Types.TIMESTAMP:
        return 16;
      default:
        return DEFAULT_DISPLAY_SIZE;
    }
  }

  @Override
  public String getColumnLabel(int column) {
    return getField(column).getName();
  }

  @Override
  public String getColumnName(int column) {
    return getField(column).getName();
  }

  @Override
  public int getPrecision(int column) {
    return (int) (getField(column).getPrecision() != null ? getField(column).getPrecision() : 0);
  }

  @Override
  public int getScale(int column) {
    return (int) (getField(column).getScale() != null ? getField(column).getScale() : 0);
  }

  @Override
  public String getTableName(int column) {
    // returning "" as per the specs as there might be multiple tables involved, or we
    // might be reading from the temp table
    return "";
  }

  @Override
  public String getCatalogName(int column) {
    return ""; // not applicable
  }

  @Override
  public String getSchemaName(int column) {
    return ""; // not applicable
  }

  private StandardSQLTypeName getStandardSQLTypeName(int column) {
    Field field = getField(column);
    if (field.getMode() == Mode.REPEATED) {
      return StandardSQLTypeName.ARRAY;
    }
    return getField(column).getType().getStandardType();
  }

  @Override
  public int getColumnType(int column) {
    return BigQueryJdbcTypeMappings.standardSQLToJavaSqlTypesMapping.get(
        getStandardSQLTypeName(column));
  }

  @Override
  public String getColumnTypeName(int column) {
    return getStandardSQLTypeName(column).name();
  }

  @Override
  public boolean isReadOnly(int column) {
    return false;
  }

  @Override
  public boolean isWritable(int column) {
    return !isReadOnly(column);
  }

  @Override
  public boolean isDefinitelyWritable(int column) {
    return false;
  }

  @Override
  public String getColumnClassName(int column) {
    Field field = getField(column);
    if (field.getMode() == Mode.REPEATED) {
      return java.sql.Array.class.getName();
    }
    return BigQueryJdbcTypeMappings.standardSQLToJavaTypeMapping
        .get(field.getType().getStandardType())
        .getName();
  }

  // Unsupported methods:
  @Override
  public <T> T unwrap(Class<T> iface) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("unwrap is not implemented");
  }

  @Override
  public boolean isWrapperFor(Class<?> iface) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("isWrapperFor is not implemented");
  }
}
