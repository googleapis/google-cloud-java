/*
 * Copyright 2023 Google LLC
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
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

/** This class returns ResultSetMetadata for the JSON and the Arrow ResultSets */
class BigQueryResultSetMetadata implements ResultSetMetaData {
  private final BigQueryJdbcResultSetLogger LOG =
      BigQueryJdbcResultSetLogger.getLogger(this.getClass());
  private final FieldList schemaFieldList;
  private final Statement statement;
  private final int columnCount;

  private static final int DEFAULT_DISPLAY_SIZE = 50;

  private BigQueryResultSetMetadata(FieldList schemaFieldList, Statement statement) {
    LOG.finestTrace("<init>");
    this.schemaFieldList = schemaFieldList;
    this.columnCount = schemaFieldList.size();
    this.statement = statement;
  }

  static BigQueryResultSetMetadata of(FieldList schemaFieldList, Statement statement) {
    return new BigQueryResultSetMetadata(schemaFieldList, statement);
  }

  Statement getStatement() {
    return this.statement;
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
    return true;
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
    Long precision = getField(column).getPrecision();
    if (precision != null) {
      return precision.intValue();
    }
    StandardSQLTypeName type = getStandardSQLTypeName(column);
    BigQueryJdbcTypeMappings.ColumnTypeInfo typeInfo =
        BigQueryJdbcTypeMappings.STANDARD_TYPE_INFO.get(type);
    if (typeInfo != null && typeInfo.columnSize != null) {
      return typeInfo.columnSize;
    }
    return 0;
  }

  @Override
  public int getScale(int column) {
    Long scale = getField(column).getScale();
    if (scale != null) {
      return scale.intValue();
    }
    StandardSQLTypeName type = getStandardSQLTypeName(column);
    BigQueryJdbcTypeMappings.ColumnTypeInfo typeInfo =
        BigQueryJdbcTypeMappings.STANDARD_TYPE_INFO.get(type);
    if (typeInfo != null && typeInfo.decimalDigits != null) {
      return typeInfo.decimalDigits;
    }
    return 0;
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

  // Wrapper methods:
  @Override
  public <T> T unwrap(Class<T> iface) throws SQLException {
    if (iface.isInstance(this)) {
      return iface.cast(this);
    }
    throw new BigQueryJdbcException("Cannot unwrap to " + iface.getName());
  }

  @Override
  public boolean isWrapperFor(Class<?> iface) throws SQLException {
    return iface != null && iface.isInstance(this);
  }
}
