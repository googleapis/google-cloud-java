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
import com.google.cloud.bigquery.exception.BigQueryJdbcSqlFeatureNotSupportedException;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;

/** This class returns ResultSetMetadata for the JSON and the Arrow ResultSets */
class BigQueryResultSetMetadata implements ResultSetMetaData {
  static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryResultSetMetadata.class.getName());
  private final FieldList schemaFieldList;
  private final Statement statement;
  private final BigQueryConnection connection;
  private final int columnCount;

  private static final int DEFAULT_DISPLAY_SIZE = 50;

  private BigQueryResultSetMetadata(FieldList schemaFieldList, Statement statement)
      throws SQLException {
    LOG.finest("++enter++");
    this.schemaFieldList = schemaFieldList;
    this.columnCount = schemaFieldList.size();
    this.statement = statement;
    this.connection =
        statement != null ? statement.getConnection().unwrap(BigQueryConnection.class) : null;
  }

  static BigQueryResultSetMetadata of(FieldList schemaFieldList, Statement statement)
      throws SQLException {
    LOG.finest("++enter++");
    return new BigQueryResultSetMetadata(schemaFieldList, statement);
  }

  private Field getField(int sqlColumn) {
    LOG.finest("++enter++");
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
  public boolean isCaseSensitive(int column) throws SQLException {
    try (BigQueryJdbcMdc.MdcCloseable mdc =
        BigQueryJdbcMdc.registerInstance(
            this.connection, this.connection != null ? this.connection.getConnectionId() : null)) {
      LOG.finest("++enter++");
      int colType = getColumnType(column);
      return colType == Types.NVARCHAR;
    }
  }

  @Override
  public boolean isSearchable(int column) throws SQLException {
    try (BigQueryJdbcMdc.MdcCloseable mdc =
        BigQueryJdbcMdc.registerInstance(
            this.connection, this.connection != null ? this.connection.getConnectionId() : null)) {
      LOG.finest("++enter++");
      int colType = getColumnType(column);
      return colType != Types.OTHER;
    }
  }

  @Override
  public boolean isCurrency(int column) {
    return false;
  }

  @Override
  public int isNullable(int column) throws SQLException {
    try (BigQueryJdbcMdc.MdcCloseable mdc =
        BigQueryJdbcMdc.registerInstance(
            this.connection, this.connection != null ? this.connection.getConnectionId() : null)) {
      LOG.finest("++enter++");
      Mode colMode = getField(column).getMode();
      if (colMode == null) {
        return ResultSetMetaData.columnNullableUnknown;
      }
      return colMode == Mode.NULLABLE
          ? ResultSetMetaData.columnNullable
          : ResultSetMetaData.columnNoNulls;
    }
  }

  @Override
  public boolean isSigned(int column) throws SQLException {
    try (BigQueryJdbcMdc.MdcCloseable mdc =
        BigQueryJdbcMdc.registerInstance(
            this.connection, this.connection != null ? this.connection.getConnectionId() : null)) {
      LOG.finest("++enter++");
      int colType = getColumnType(column);
      return colType == Types.FLOAT
          || colType == Types.DOUBLE
          || colType == Types.BIGINT
          || colType == Types.NUMERIC;
    }
  }

  @Override
  public int getColumnDisplaySize(int column) throws SQLException {
    try (BigQueryJdbcMdc.MdcCloseable mdc =
        BigQueryJdbcMdc.registerInstance(
            this.connection, this.connection != null ? this.connection.getConnectionId() : null)) {
      LOG.finest("++enter++");
      return getColumnDisplaySizeImpl(column);
    }
  }

  private int getColumnDisplaySizeImpl(int column) throws SQLException {
    LOG.finest("++enter++");
    LOG.info("getColumnDisplaySize called for column: %d", column);
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
  public String getColumnLabel(int column) throws SQLException {
    try (BigQueryJdbcMdc.MdcCloseable mdc =
        BigQueryJdbcMdc.registerInstance(
            this.connection, this.connection != null ? this.connection.getConnectionId() : null)) {
      LOG.finest("++enter++");
      return getField(column).getName();
    }
  }

  @Override
  public String getColumnName(int column) throws SQLException {
    try (BigQueryJdbcMdc.MdcCloseable mdc =
        BigQueryJdbcMdc.registerInstance(
            this.connection, this.connection != null ? this.connection.getConnectionId() : null)) {
      LOG.finest("++enter++");
      return getField(column).getName();
    }
  }

  @Override
  public int getPrecision(int column) throws SQLException {
    try (BigQueryJdbcMdc.MdcCloseable mdc =
        BigQueryJdbcMdc.registerInstance(
            this.connection, this.connection != null ? this.connection.getConnectionId() : null)) {
      LOG.finest("++enter++");
      return (int) (getField(column).getPrecision() != null ? getField(column).getPrecision() : 0);
    }
  }

  @Override
  public int getScale(int column) throws SQLException {
    try (BigQueryJdbcMdc.MdcCloseable mdc =
        BigQueryJdbcMdc.registerInstance(
            this.connection, this.connection != null ? this.connection.getConnectionId() : null)) {
      LOG.finest("++enter++");
      return (int) (getField(column).getScale() != null ? getField(column).getScale() : 0);
    }
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
    LOG.finest("++enter++");
    Field field = getField(column);
    if (field.getMode() == Mode.REPEATED) {
      return StandardSQLTypeName.ARRAY;
    }
    return getField(column).getType().getStandardType();
  }

  @Override
  public int getColumnType(int column) throws SQLException {
    try (BigQueryJdbcMdc.MdcCloseable mdc =
        BigQueryJdbcMdc.registerInstance(
            this.connection, this.connection != null ? this.connection.getConnectionId() : null)) {
      LOG.finest("++enter++");
      LOG.info("getColumnType called for column: %d", column);
      return BigQueryJdbcTypeMappings.standardSQLToJavaSqlTypesMapping.get(
          getStandardSQLTypeName(column));
    }
  }

  @Override
  public String getColumnTypeName(int column) throws SQLException {
    try (BigQueryJdbcMdc.MdcCloseable mdc =
        BigQueryJdbcMdc.registerInstance(
            this.connection, this.connection != null ? this.connection.getConnectionId() : null)) {
      LOG.finest("++enter++");
      return getStandardSQLTypeName(column).name();
    }
  }

  @Override
  public boolean isReadOnly(int column) {
    return false;
  }

  @Override
  public boolean isWritable(int column) throws SQLException {
    try (BigQueryJdbcMdc.MdcCloseable mdc =
        BigQueryJdbcMdc.registerInstance(
            this.connection, this.connection != null ? this.connection.getConnectionId() : null)) {
      LOG.finest("++enter++");
      return !isReadOnly(column);
    }
  }

  @Override
  public boolean isDefinitelyWritable(int column) {
    return false;
  }

  @Override
  public String getColumnClassName(int column) throws SQLException {
    try (BigQueryJdbcMdc.MdcCloseable mdc =
        BigQueryJdbcMdc.registerInstance(
            this.connection, this.connection != null ? this.connection.getConnectionId() : null)) {
      LOG.finest("++enter++");
      LOG.info("getColumnClassName called for column: %d", column);
      Field field = getField(column);
      if (field.getMode() == Mode.REPEATED) {
        return java.sql.Array.class.getName();
      }
      return BigQueryJdbcTypeMappings.standardSQLToJavaTypeMapping
          .get(field.getType().getStandardType())
          .getName();
    }
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
