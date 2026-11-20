/*
 * Copyright 2024 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.bigquery.jdbc;

import com.google.api.gax.retrying.RetrySettings;
import com.google.api.services.bigquery.model.QueryParameter;
import com.google.cloud.Tuple;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.Field;
import com.google.cloud.bigquery.FieldList;
import com.google.cloud.bigquery.JobStatistics.QueryStatistics;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryParameterValue;
import com.google.cloud.bigquery.Schema;
import com.google.cloud.bigquery.StandardSQLTypeName;
import com.google.cloud.bigquery.TableId;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.exception.BigQueryJdbcSqlFeatureNotSupportedException;
import com.google.cloud.bigquery.jdbc.telemetry.v1.DriverFeature;
import com.google.cloud.bigquery.jdbc.telemetry.v1.QueryApiType;
import com.google.cloud.bigquery.jdbc.telemetry.v1.StatementExecution;
import com.google.cloud.bigquery.jdbc.telemetry.v1.StatementType;
import com.google.cloud.bigquery.jdbc.telemetry.v1.Status;
import com.google.cloud.bigquery.jdbc.telemetry.v1.TelemetryManager;
import com.google.cloud.bigquery.storage.v1.BatchCommitWriteStreamsRequest;
import com.google.cloud.bigquery.storage.v1.BatchCommitWriteStreamsResponse;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1.TableName;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.protobuf.Descriptors.DescriptorValidationException;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class BigQueryPreparedStatement extends BigQueryStatement implements PreparedStatement {
  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryPreparedStatement.class.getName());
  private static final char POSITIONAL_PARAMETER_CHAR = '?';
  // parameterHandler is inherited from BigQueryStatement
  protected final int parameterCount;
  protected final String currentQuery;
  private final DirectInsertShape directInsertShape;
  private boolean insertMetadataEvaluated = false;
  private Queue<ArrayList<BigQueryJdbcParameter>> batchParameters = new LinkedList<>();
  // resultSchema feeds getMetaData() for SELECT statements; insertSchema holds the target columns
  // in placeholder order for single-table direct-VALUES INSERT statements on the Storage Write API.
  Schema resultSchema = null; // Feeds getMetaData().
  Schema insertSchema = null; // Feeds the Storage Write API.
  private TableName insertTableName = null;

  BigQueryPreparedStatement(BigQueryConnection connection, String query) throws SQLException {
    super(connection);
    if (query == null) {
      throw new BigQueryJdbcException("SQL query cannot be null.");
    }
    this.currentQuery = query;
    this.directInsertShape = parseDirectInsertValues(query);
    QueryStatistics queryStatistics = describeQueryQuietly();
    this.parameterCount = resolveParameterCount(query, queryStatistics);
    this.parameterHandler =
        new BigQueryParameterHandler(this.parameterCount, this.isEnableTimestampPicos());
    if (queryStatistics != null) {
      applyInferredParameterTypes(queryStatistics);
      captureInsertMetadata(queryStatistics);
      captureResultSchema(queryStatistics);
    }
  }

  private int resolveParameterCount(String query, QueryStatistics queryStatistics) {
    if (queryStatistics != null) {
      return queryStatistics.getQueryParameters() == null
          ? 0
          : queryStatistics.getQueryParameters().size();
    }
    return (int) query.chars().filter(ch -> ch == POSITIONAL_PARAMETER_CHAR).count();
  }

  /**
   * Failures are logged and swallowed. Nothing a dry run supplies is required for correctness: the
   * types are defaults the caller's {@code setXxx} calls refine, and the count falls back to a scan
   * of the query text, so a statement stays usable against a service that refuses the dry run.
   */
  private QueryStatistics describeQueryQuietly() {
    if (this.currentQuery.indexOf(POSITIONAL_PARAMETER_CHAR) == -1 || getUseLegacySql()) {
      return null;
    }
    try {
      return describePositionalParameterQuery(this.currentQuery);
    } catch (SQLException | RuntimeException ex) {
      LOG.warning(
          ex,
          "Could not describe query via dry run; parameter types will be derived from the values"
              + " supplied by the caller, and the parameter count from the query text.");
      return null;
    }
  }

  private void applyInferredParameterTypes(QueryStatistics statistics) {
    List<QueryParameter> undeclaredParameters = statistics.getQueryParameters();
    if (undeclaredParameters == null) {
      return;
    }
    int index = 1;
    for (QueryParameter parameter : undeclaredParameters) {
      if (parameter.getParameterType() != null) {
        StandardSQLTypeName sqlType = toStandardSqlType(parameter.getParameterType().getType());
        if (sqlType != null) {
          this.parameterHandler.setInferredParameterType(index, sqlType);
        }
      }
      index++;
    }
  }

  // Returning null costs one parameter its inferred type; letting the exception propagate would
  // abandon inference for every parameter after it.
  private static StandardSQLTypeName toStandardSqlType(String typeName) {
    if (typeName == null) {
      return null;
    }
    try {
      return StandardSQLTypeName.valueOf(typeName);
    } catch (IllegalArgumentException ex) {
      return null;
    }
  }

  // Remembers the table and target column schema of direct single-table INSERT ... VALUES (?, ...)
  // statements for the Storage Write API. Statements with SQL expressions, partial column lists, or
  // unsupported column types leave insertSchema null so executeBatch uses standard SQL execution.
  private void captureInsertMetadata(QueryStatistics statistics) {
    if (statistics == null) {
      return;
    }
    this.insertMetadataEvaluated = true;
    Schema schema = statistics.getSchema();
    if (this.directInsertShape == null
        || !QueryStatistics.StatementType.INSERT.equals(statistics.getStatementType())
        || schema == null
        || statistics.getReferencedTables() == null
        || statistics.getReferencedTables().stream().distinct().count() != 1) {
      return;
    }
    TableId tableId = statistics.getReferencedTables().get(0);
    String project = resolveTargetProject(tableId);
    if (project == null || tableId.getDataset() == null || tableId.getTable() == null) {
      return;
    }
    Schema resolvedSchema =
        resolveInsertSchema(schema, this.directInsertShape, this.parameterCount);
    if (resolvedSchema == null) {
      LOG.fine(
          "INSERT target schema is incompatible with direct Storage Write API streaming;"
              + " falling back to standard SQL batch execution.");
      return;
    }
    this.insertSchema = resolvedSchema;
    this.insertTableName = TableName.of(project, tableId.getDataset(), tableId.getTable());
    LOG.finer("insertTableName: %s, insertSchema: %s", this.insertTableName, this.insertSchema);
  }

  private String resolveTargetProject(TableId tableId) {
    if (tableId.getProject() != null) {
      return tableId.getProject();
    }
    DatasetId defaultDataset = this.querySettings.getDefaultDataset();
    String catalog = this.connection != null ? this.connection.getCatalog() : null;
    if (defaultDataset != null
        && defaultDataset.getProject() != null
        && (catalog == null
            || (tableId.getDataset() != null
                && tableId.getDataset().equals(defaultDataset.getDataset())))) {
      return defaultDataset.getProject();
    }
    return catalog;
  }

  static Schema resolveInsertSchema(
      Schema tableSchema, DirectInsertShape shape, int parameterCount) {
    if (tableSchema == null || shape == null) {
      return null;
    }
    FieldList tableFields = tableSchema.getFields();
    if (tableFields == null
        || shape.placeholderCount == 0
        || shape.placeholderCount != parameterCount
        || tableFields.size() != shape.placeholderCount) {
      return null;
    }
    for (Field field : tableFields) {
      if (!BigQueryTypeRegistry.isSupportedWriteApiField(field)) {
        return null;
      }
    }
    if (shape.columnNames == null) {
      return tableSchema;
    }
    if (shape.columnNames.size() != tableFields.size()) {
      return null;
    }
    Map<String, Field> fieldsByLowerName = new HashMap<>(tableFields.size() * 2);
    for (Field field : tableFields) {
      fieldsByLowerName.put(field.getName().toLowerCase(Locale.ROOT), field);
    }
    List<Field> orderedFields = new ArrayList<>(shape.columnNames.size());
    Set<String> seenColumns = new HashSet<>(shape.columnNames.size() * 2);
    for (String columnName : shape.columnNames) {
      String normalized = columnName.toLowerCase(Locale.ROOT);
      Field matched = fieldsByLowerName.get(normalized);
      if (matched == null || !seenColumns.add(normalized)) {
        return null;
      }
      orderedFields.add(matched);
    }
    return Schema.of(orderedFields);
  }

  static final class DirectInsertShape {
    final int placeholderCount;
    final List<String> columnNames;

    DirectInsertShape(int placeholderCount, List<String> columnNames) {
      this.placeholderCount = placeholderCount;
      this.columnNames =
          columnNames == null ? null : Collections.unmodifiableList(new ArrayList<>(columnNames));
    }
  }

  /**
   * Recognizes single-row {@code INSERT [INTO] <table> [(<col1>, ...)] VALUES (?, ...) [;]}
   * statements whose {@code VALUES} tuple consists strictly of bare positional {@code ?}
   * placeholders. Returns {@code null} for any SQL expression, function/UDF call, cast, literal,
   * {@code DEFAULT}, {@code SELECT}, multi-row tuple list, or {@code _SESSION}-qualified temporary
   * table so the statement executes on BigQuery's SQL engine instead of the Storage Write API.
   */
  static DirectInsertShape parseDirectInsertValues(String sql) {
    if (sql == null) {
      return null;
    }
    int pos = skipTrivia(sql, 0);
    pos = pos < 0 ? -1 : matchKeyword(sql, pos, "INSERT");
    pos = pos < 0 ? -1 : skipTrivia(sql, pos);
    if (pos < 0) {
      return null;
    }
    int afterInto = matchKeyword(sql, pos, "INTO");
    if (afterInto >= 0) {
      pos = skipTrivia(sql, afterInto);
      if (pos < 0) {
        return null;
      }
    }
    pos = consumeTablePath(sql, pos);
    if (pos < 0 || pos >= sql.length()) {
      return null;
    }

    List<String> columnNames = null;
    if (sql.charAt(pos) == '(') {
      columnNames = new ArrayList<>();
      pos++;
      while (true) {
        pos = skipTrivia(sql, pos);
        Tuple<String, Integer> column = pos < 0 ? null : readIdentifier(sql, pos, false);
        if (column == null) {
          return null;
        }
        columnNames.add(column.x());
        pos = skipTrivia(sql, column.y());
        if (pos < 0 || pos >= sql.length()) {
          return null;
        }
        char sep = sql.charAt(pos++);
        if (sep == ')') {
          break;
        }
        if (sep != ',') {
          return null;
        }
      }
    }

    pos = skipTrivia(sql, pos);
    pos = pos < 0 ? -1 : matchKeyword(sql, pos, "VALUES");
    pos = pos < 0 ? -1 : skipTrivia(sql, pos);
    if (pos < 0 || pos >= sql.length() || sql.charAt(pos++) != '(') {
      return null;
    }

    int placeholderCount = 0;
    while (true) {
      pos = skipTrivia(sql, pos);
      if (pos < 0 || pos >= sql.length() || sql.charAt(pos) != POSITIONAL_PARAMETER_CHAR) {
        return null;
      }
      placeholderCount++;
      pos = skipTrivia(sql, pos + 1);
      if (pos < 0 || pos >= sql.length()) {
        return null;
      }
      char sep = sql.charAt(pos++);
      if (sep == ')') {
        break;
      }
      if (sep != ',') {
        return null;
      }
    }

    pos = skipTrivia(sql, pos);
    if (pos >= 0 && pos < sql.length() && sql.charAt(pos) == ';') {
      pos = skipTrivia(sql, pos + 1);
    }
    return pos == sql.length() ? new DirectInsertShape(placeholderCount, columnNames) : null;
  }

  private static int consumeTablePath(String sql, int pos) {
    Tuple<String, Integer> firstSegment = readIdentifier(sql, pos, true);
    if (firstSegment == null) {
      return -1;
    }
    String firstName = firstSegment.x();
    pos = firstSegment.y();
    int segmentCount = 1;
    while (true) {
      int next = skipTrivia(sql, pos);
      if (next < 0) {
        return -1;
      }
      if (next < sql.length() && (sql.charAt(next) == '.' || sql.charAt(next) == ':')) {
        pos = skipTrivia(sql, next + 1);
        Tuple<String, Integer> segment = pos < 0 ? null : readIdentifier(sql, pos, true);
        if (segment == null) {
          return -1;
        }
        pos = segment.y();
        segmentCount++;
      } else {
        pos = next;
        break;
      }
    }
    if ((segmentCount == 2 && "_session".equalsIgnoreCase(firstName))
        || (segmentCount == 1
            && firstName.length() > 9
            && firstName.regionMatches(true, 0, "_session.", 0, 9))) {
      return -1;
    }
    return pos;
  }

  private static Tuple<String, Integer> readIdentifier(String sql, int pos, boolean tableSegment) {
    if (pos >= sql.length()) {
      return null;
    }
    char first = sql.charAt(pos);
    if (first == '`') {
      return readBacktickIdentifier(sql, pos);
    }
    if (!(tableSegment ? isIdentPart(first) : isIdentStart(first))) {
      return null;
    }
    int i = pos + 1;
    while (i < sql.length()
        && (isIdentPart(sql.charAt(i)) || (tableSegment && sql.charAt(i) == '-'))) {
      i++;
    }
    return Tuple.of(sql.substring(pos, i), i);
  }

  private static Tuple<String, Integer> readBacktickIdentifier(String sql, int pos) {
    StringBuilder sb = new StringBuilder();
    int i = pos + 1;
    while (i < sql.length()) {
      char c = sql.charAt(i);
      if (c == '\\') {
        if (i + 1 >= sql.length()) {
          return null;
        }
        char escaped = sql.charAt(i + 1);
        if (escaped != '\\' && escaped != '`') {
          return null;
        }
        sb.append(escaped);
        i += 2;
      } else if (c == '`') {
        return sb.length() == 0 ? null : Tuple.of(sb.toString(), i + 1);
      } else {
        sb.append(c);
        i++;
      }
    }
    return null;
  }

  private static int matchKeyword(String sql, int pos, String keyword) {
    int end = pos + keyword.length();
    if (end > sql.length()
        || !sql.regionMatches(true, pos, keyword, 0, keyword.length())
        || (end < sql.length() && isIdentPart(sql.charAt(end)))) {
      return -1;
    }
    return end;
  }

  private static int skipTrivia(String sql, int pos) {
    int len = sql.length();
    while (pos < len) {
      char ch = sql.charAt(pos);
      if (Character.isWhitespace(ch)) {
        pos++;
      } else if (ch == '#') {
        pos = skipToLineEnd(sql, pos + 1);
      } else if (ch == '-' && pos + 1 < len && sql.charAt(pos + 1) == '-') {
        pos = skipToLineEnd(sql, pos + 2);
      } else if (ch == '/' && pos + 1 < len && sql.charAt(pos + 1) == '*') {
        int closeIdx = sql.indexOf("*/", pos + 2);
        if (closeIdx < 0) {
          return -1;
        }
        pos = closeIdx + 2;
      } else {
        break;
      }
    }
    return pos;
  }

  private static int skipToLineEnd(String sql, int pos) {
    while (pos < sql.length() && sql.charAt(pos) != '\n' && sql.charAt(pos) != '\r') {
      pos++;
    }
    return pos < sql.length() ? pos + 1 : pos;
  }

  private static boolean isIdentStart(char ch) {
    return (ch >= 'A' && ch <= 'Z') || (ch >= 'a' && ch <= 'z') || ch == '_';
  }

  private static boolean isIdentPart(char ch) {
    return isIdentStart(ch) || (ch >= '0' && ch <= '9');
  }

  // This populates the schema of the ResultSet that is being returned by the query.
  // The column names are as they are returned from the query dryRun and may not match the actual
  // table column names.
  private void captureResultSchema(QueryStatistics statistics) {
    if (QueryStatistics.StatementType.SELECT.equals(statistics.getStatementType())) {
      this.resultSchema = statistics.getSchema();
    }
  }

  @Override
  public ResultSet executeQuery() throws SQLException {
    validateExecution();
    return BigQueryJdbcOpenTelemetry.withTracing(
        "BigQueryPreparedStatement.executeQuery",
        this.connection,
        this.currentQuery,
        () -> super.executeQuery(this.currentQuery));
  }

  @Override
  public long executeLargeUpdate() throws SQLException {
    validateExecution();
    return BigQueryJdbcOpenTelemetry.withTracing(
        "BigQueryPreparedStatement.executeLargeUpdate",
        this.connection,
        this.currentQuery,
        () -> super.executeLargeUpdate(this.currentQuery));
  }

  @Override
  public int executeUpdate() throws SQLException {
    return super.executeUpdate(this.currentQuery);
  }

  @Override
  public boolean execute() throws SQLException {
    validateExecution();
    return BigQueryJdbcOpenTelemetry.withTracing(
        "BigQueryPreparedStatement.execute",
        this.connection,
        this.currentQuery,
        () -> super.execute(this.currentQuery));
  }

  @Override
  public void clearParameters() {
    this.parameterHandler.clearParameters();
  }

  @Override
  public void setNull(int parameterIndex, int sqlType) throws SQLException {
    checkClosed();
    this.parameterHandler.setNullParameter(parameterIndex, declaredJavaType(sqlType));
  }

  // Types.NULL is what setObject(index, null) synthesizes when the caller named no type, and
  // Types.OTHER names none either. Both defer to whatever the slot already knows.
  private static Class<?> declaredJavaType(int jdbcType)
      throws BigQueryJdbcSqlFeatureNotSupportedException {
    if (jdbcType == Types.NULL || jdbcType == Types.OTHER) {
      return null;
    }
    return BigQueryTypeRegistry.toJavaClass(jdbcType);
  }

  @Override
  public void setBoolean(int parameterIndex, boolean value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, Boolean.class);
  }

  @Override
  public void setByte(int parameterIndex, byte value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, Byte.class);
  }

  @Override
  public void setShort(int parameterIndex, short value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, Short.class);
  }

  @Override
  public void setInt(int parameterIndex, int value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, Integer.class);
  }

  @Override
  public void setLong(int parameterIndex, long value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, Long.class);
  }

  @Override
  public void setFloat(int parameterIndex, float value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, Float.class);
  }

  @Override
  public void setDouble(int parameterIndex, double value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, Double.class);
  }

  @Override
  public void setBigDecimal(int parameterIndex, BigDecimal value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, BigDecimal.class);
  }

  @Override
  public void setString(int parameterIndex, String value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, String.class);
  }

  @Override
  public void setBytes(int parameterIndex, byte[] value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, byte[].class);
  }

  @Override
  public void setDate(int parameterIndex, Date value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, Date.class);
  }

  @Override
  public void setTime(int parameterIndex, Time value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, Time.class);
  }

  @Override
  public void setTimestamp(int parameterIndex, Timestamp value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, Timestamp.class);
  }

  @Override
  public void setAsciiStream(int parameterIndex, InputStream value, int length)
      throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setAsciiStream is not supported.");
  }

  @Override
  @Deprecated
  @SuppressWarnings("deprecation")
  public void setUnicodeStream(int parameterIndex, InputStream value, int length)
      throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setUnicodeStream is not supported.");
  }

  @Override
  public void setBinaryStream(int parameterIndex, InputStream value, int length)
      throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setBinaryStream is not supported.");
  }

  @Override
  public void setObject(int parameterIndex, Object value, int targetSqlType) throws SQLException {
    checkClosed();
    if (value == null) {
      setNull(parameterIndex, targetSqlType);
      return;
    }
    if (setTemporalObject(parameterIndex, value)) {
      return;
    }
    Class<?> javaType = BigQueryTypeRegistry.toJavaClass(targetSqlType);
    this.parameterHandler.setParameter(parameterIndex, value, javaType);
  }

  @Override
  public void setObject(int parameterIndex, Object value) throws SQLException {
    checkClosed();
    if (value == null) {
      setNull(parameterIndex, Types.NULL);
      return;
    }
    if (setTemporalObject(parameterIndex, value)) {
      return;
    }
    this.parameterHandler.setParameter(parameterIndex, value, value.getClass());
  }

  private boolean setTemporalObject(int parameterIndex, Object value) {
    Tuple<Object, Class<?>> binding = BigQueryParameterHandler.bindingForJavaTime(value);
    if (binding == null) {
      return false;
    }
    this.parameterHandler.setParameter(parameterIndex, binding.x(), binding.y());
    return true;
  }

  @Override
  public void addBatch() {
    ArrayList<BigQueryJdbcParameter> currentParameterList =
        deepCopyParameterList(this.parameterHandler.parametersList);
    this.batchParameters.add(currentParameterList);
  }

  @Override
  public void clearBatch() {
    super.clearBatch();
    this.batchParameters.clear();
  }

  @Override
  public void close() throws SQLException {
    try {
      super.close();
    } finally {
      this.batchParameters.clear();
    }
  }

  private ArrayList<BigQueryJdbcParameter> deepCopyParameterList(
      ArrayList<BigQueryJdbcParameter> parametersList) {
    ArrayList<BigQueryJdbcParameter> copiedParameterList = new ArrayList<>(parametersList.size());
    for (BigQueryJdbcParameter parameter : parametersList) {
      copiedParameterList.add(parameter == null ? null : new BigQueryJdbcParameter(parameter));
    }
    return copiedParameterList;
  }

  private void validateBatchParameters() throws BigQueryJdbcException {
    for (ArrayList<BigQueryJdbcParameter> parameterList : this.batchParameters) {
      for (int i = 1; i <= this.parameterCount; i++) {
        int arrayIndex = i - 1;
        if (parameterList == null
            || parameterList.size() <= arrayIndex
            || parameterList.get(arrayIndex) == null
            || !parameterList.get(arrayIndex).isBound()) {
          throw new BigQueryJdbcException(
              String.format(
                  "One or more parameters missing in Prepared statement. No value was set for"
                      + " parameter %d of %d.",
                  i, this.parameterCount));
        }
      }
    }
  }

  @Override
  public int[] executeBatch() throws SQLException {
    validateExecution();
    int[] result = new int[this.batchParameters.size()];
    if (this.batchParameters.isEmpty()) {
      return result;
    }
    try {
      validateBatchParameters();
      return executeBatchInternal(result);
    } finally {
      this.batchParameters.clear();
    }
  }

  private int[] executeBatchInternal(int[] result) throws SQLException {
    // The constructor's dry run may have happened before the target table existed.
    if (!this.insertMetadataEvaluated
        && this.directInsertShape != null
        && this.querySettings.isUseWriteAPI()
        && !getUseLegacySql()
        && (this.connection == null || !this.connection.isTransactionStarted())
        && this.batchParameters.size() >= this.querySettings.getWriteAPIActivationRowCount()) {
      this.insertMetadataEvaluated = true;
      try {
        QueryStatistics statistics = describePositionalParameterQuery(this.currentQuery);
        if (statistics != null) {
          applyInferredParameterTypes(statistics);
          captureInsertMetadata(statistics);
        }
      } catch (SQLException | RuntimeException ex) {
        LOG.warning(ex, "Could not describe INSERT target; using the standard batch path.");
      }
    }

    if (useWriteAPI()) {
      long startTime = System.currentTimeMillis();
      int fallbackErrorCode = 1000;
      StatementExecution.Builder writeApiExecutionBuilder =
          StatementExecution.newBuilder()
              .setStatementType(StatementType.STATEMENT_TYPE_INSERT)
              .setQueryApiType(QueryApiType.QUERY_API_TYPE_WRITE_API);
      try {
        // Lifecycle of the cached BigQueryWriteClient belongs to BigQueryConnection.close().
        BigQueryWriteClient writeClient = this.connection.getBigQueryWriteClient();
        LOG.info("Using Write API for bulk INSERT operation.");

        long rowCount = bulkInsertWithWriteAPI(writeClient);
        int[] insertArray = new int[Math.toIntExact(rowCount)];
        Arrays.fill(insertArray, 1);

        writeApiExecutionBuilder.setStatus(Status.STATUS_SUCCESS);

        return insertArray;

      } catch (InterruptedException e) {
        Thread.currentThread().interrupt();
        fallbackErrorCode = TelemetryManager.extractErrorCode(e);
        writeApiExecutionBuilder.setStatus(Status.STATUS_ERROR).setErrorCode(fallbackErrorCode);
        throw new BigQueryJdbcException("Interrupted during Write API batch", e);
      } catch (BigQueryJdbcException e) {
        fallbackErrorCode = TelemetryManager.extractErrorCode(e);
        writeApiExecutionBuilder.setStatus(Status.STATUS_ERROR).setErrorCode(fallbackErrorCode);
        throw e;
      } catch (DescriptorValidationException | IOException | RuntimeException e) {
        fallbackErrorCode = TelemetryManager.extractErrorCode(e);
        writeApiExecutionBuilder.setStatus(Status.STATUS_ERROR).setErrorCode(fallbackErrorCode);
        throw new BigQueryJdbcException("Failed to execute batch with Write API", e);
      } finally {
        if (writeApiExecutionBuilder.getStatus() == Status.STATUS_UNSPECIFIED) {
          writeApiExecutionBuilder.setStatus(Status.STATUS_ERROR).setErrorCode(fallbackErrorCode);
        }
        long durationMs = System.currentTimeMillis() - startTime;
        TelemetryManager.recordStatementExecution(writeApiExecutionBuilder, durationMs);
        TelemetryManager.recordFeatureUsage(DriverFeature.DRIVER_FEATURE_BATCH_OPERATIONS);
      }

    } else {
      if (this.querySettings.isUseWriteAPI()
          && this.batchParameters.size() >= this.querySettings.getWriteAPIActivationRowCount()) {
        LOG.fine(
            "Batch query is not eligible for Storage Write API; falling back to standard SQL"
                + " batch execution.");
      }
      try {
        LOG.info("Using individual INSERT query runs.");
        int count = this.batchParameters.size();
        StringBuilder combinedQuery = new StringBuilder();
        for (int i = 0; i < count; i++) {

          if (this.currentQuery.trim().endsWith(";")) {
            combinedQuery.append(this.currentQuery);
          } else {
            combinedQuery.append(this.currentQuery).append(";");
          }
        }
        // executeBatch in PreparedStatement is used for BulkInsert/DML.
        // If not correct Type, fails later.
        runQuery(
            combinedQuery.toString(), getStandardBatchJobConfiguration(combinedQuery.toString()));
        int i = 0;
        while (getUpdateCount() != -1 && i < count) {
          result[i] = getUpdateCount();
          getMoreResults();
          i++;
        }
        return result;
      } catch (SQLException e) {
        throw new BigQueryJdbcException("SQL error during individual INSERT batch", e);
      } finally {
        TelemetryManager.recordFeatureUsage(DriverFeature.DRIVER_FEATURE_BATCH_OPERATIONS);
      }
    }
  }

  BigQueryJdbcBulkInsertWriter createBulkInsertWriter() {
    return new BigQueryJdbcBulkInsertWriter();
  }

  private long bulkInsertWithWriteAPI(BigQueryWriteClient bigQueryWriteClient)
      throws DescriptorValidationException,
          IOException,
          InterruptedException,
          BigQueryJdbcException {
    LOG.finer("++enter++");
    RetrySettings retrySettings = this.connection.getRetrySettings();

    BigQueryJdbcBulkInsertWriter bulkInsertWriter = createBulkInsertWriter();
    boolean cleanedUp = false;
    try {
      bulkInsertWriter.initialize(this.insertTableName, bigQueryWriteClient, retrySettings);

      long offset = 0;
      JsonArray jsonArray = new JsonArray();
      FieldList fieldLists = this.insertSchema.getFields();
      int count = this.batchParameters.size();
      boolean timestampPicos = this.isEnableTimestampPicos();
      for (int i = 0; i < count; i++) {
        ArrayList<BigQueryJdbcParameter> parameterList = this.batchParameters.poll();
        if (fieldLists.size() != parameterList.size()) {
          throw new BigQueryJdbcException("Mismatch between field count and parameter count.");
        }

        JsonObject rowObject = createJsonRow(fieldLists, parameterList, timestampPicos);
        jsonArray.add(rowObject);

        if (jsonArray.size() == this.querySettings.getWriteAPIAppendRowCount()
            || this.batchParameters.isEmpty()) {
          bulkInsertWriter.append(jsonArray, offset);
          LOG.finer("Append called ");
          offset += jsonArray.size();
          jsonArray = new JsonArray();
        }
      }

      long rowCount = bulkInsertWriter.cleanup(bigQueryWriteClient);
      cleanedUp = true;

      BatchCommitWriteStreamsRequest commitRequest =
          BatchCommitWriteStreamsRequest.newBuilder()
              .setParent(this.insertTableName.toString())
              .addWriteStreams(bulkInsertWriter.getStreamName())
              .build();
      BatchCommitWriteStreamsResponse commitResponse =
          bigQueryWriteClient.batchCommitWriteStreams(commitRequest);
      if (!commitResponse.hasCommitTime()) {
        throw new BigQueryJdbcException("Error committing the streams");
      }
      LOG.finer("Commit called.");
      return rowCount;
    } finally {
      if (!cleanedUp) {
        bulkInsertWriter.closeQuietly();
      }
    }
  }

  static JsonObject createJsonRow(
      FieldList fieldLists, List<BigQueryJdbcParameter> parameterList, Gson gson) {
    return createJsonRow(fieldLists, parameterList, false);
  }

  static JsonObject createJsonRow(
      FieldList fieldLists,
      List<BigQueryJdbcParameter> parameterList,
      boolean enableTimestampPicos) {
    return BigQueryParameterHandler.createWriteApiJsonRow(
        fieldLists, parameterList, enableTimestampPicos);
  }

  QueryJobConfiguration getWriteBatchJobConfiguration(
      ArrayList<BigQueryJdbcParameter> currentParameterList) throws SQLException {
    LOG.finer("++enter++");
    BigQueryParameterHandler batchHandler =
        new BigQueryParameterHandler(
            this.parameterCount, currentParameterList, this.isEnableTimestampPicos());
    QueryJobConfiguration.Builder jobConfiguration = getJobConfig(this.currentQuery);
    jobConfiguration.setParameterMode("POSITIONAL");
    jobConfiguration = batchHandler.configureParameters(jobConfiguration);
    return jobConfiguration.build();
  }

  QueryJobConfiguration getStandardBatchJobConfiguration(String query) throws SQLException {
    LOG.finer("++enter++");
    QueryJobConfiguration.Builder jobConfiguration = getJobConfig(query);
    jobConfiguration.setParameterMode("POSITIONAL");
    jobConfiguration.setPriority(QueryJobConfiguration.Priority.BATCH);
    boolean enableTimestampPicos = this.isEnableTimestampPicos();
    int index = 0;
    while (!this.batchParameters.isEmpty()) {
      ArrayList<BigQueryJdbcParameter> parameterList = this.batchParameters.poll();

      for (int i = 0; i < this.parameterCount; i++) {
        BigQueryJdbcParameter parameter = parameterList.get(i);
        QueryParameterValue queryParameter =
            BigQueryParameterHandler.toQueryParameterValue(parameter, enableTimestampPicos);
        LOG.finer(
            "Parameter %s of type %s at index %s added to QueryJobConfiguration",
            queryParameter.getValue(), queryParameter.getType(), index++);
        jobConfiguration.addPositionalParameter(queryParameter);
      }
    }
    return jobConfiguration.build();
  }

  Boolean useWriteAPI() {
    LOG.finer("++enter++");
    return this.querySettings.isUseWriteAPI()
        && this.insertSchema != null
        && this.batchParameters.size() >= this.querySettings.getWriteAPIActivationRowCount()
        && isWriteApiAllowedBySessionAndTransaction()
        && BigQueryParameterHandler.areBatchParametersCompatibleWithWriteApi(
            this.insertSchema.getFields(), this.batchParameters);
  }

  private boolean isWriteApiAllowedBySessionAndTransaction() {
    if (this.connection == null) {
      return true;
    }
    if (this.connection.isTransactionStarted()) {
      return false;
    }
    if (this.insertTableName != null && this.insertTableName.getDataset().startsWith("_")) {
      BigQueryConnection.SessionState snapshot = this.connection.getSessionStateSnapshot();
      boolean sessionActive =
          this.connection.isSessionEnabled() || (snapshot != null && snapshot.sessionInfo != null);
      DatasetId defaultDataset = this.querySettings.getDefaultDataset();
      if (sessionActive
          && (defaultDataset == null
              || !this.insertTableName.getDataset().equals(defaultDataset.getDataset()))) {
        return false;
      }
    }
    return true;
  }

  @Override
  public void setCharacterStream(int parameterIndex, Reader reader, int length)
      throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setCharacterStream is not supported.");
  }

  @Override
  public void setRef(int parameterIndex, Ref x) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setRef is not supported.");
  }

  @Override
  public void setBlob(int parameterIndex, Blob x) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setBlob is not supported.");
  }

  @Override
  public void setClob(int parameterIndex, Clob x) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setClob is not supported.");
  }

  @Override
  public void setArray(int parameterIndex, Array value) throws SQLException {
    checkClosed();
    this.parameterHandler.setParameter(parameterIndex, value, Array.class);
  }

  @Override
  public ResultSetMetaData getMetaData() throws SQLException {
    checkClosed();
    // Null is the spec's answer for a statement that returns no rows.
    if (this.resultSchema == null) {
      return null;
    }

    TelemetryManager.recordFeatureUsage(
        DriverFeature.DRIVER_FEATURE_METADATA_RETRIEVAL,
        "DRIVER_FEATURE_RESULTSET_METADATA_RETRIEVAL");

    return BigQueryResultSetMetadata.of(this.resultSchema.getFields(), this);
  }

  @Override
  public void setDate(int parameterIndex, Date value, Calendar calendar) throws SQLException {
    checkClosed();
    setDate(parameterIndex, BigQueryTemporalUtility.convertDateToCalendar(value, calendar));
  }

  @Override
  public void setTime(int parameterIndex, Time value, Calendar calendar) throws SQLException {
    checkClosed();
    setTime(parameterIndex, BigQueryTemporalUtility.convertTimeToCalendar(value, calendar));
  }

  @Override
  public void setTimestamp(int parameterIndex, Timestamp value, Calendar calendar)
      throws SQLException {
    checkClosed();
    setTimestamp(parameterIndex, value);
  }

  @Override
  public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
    setNull(parameterIndex, sqlType);
  }

  @Override
  public void setURL(int parameterIndex, URL x) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setURL is not supported.");
  }

  @Override
  public ParameterMetaData getParameterMetaData() throws SQLException {
    checkClosed();
    return new BigQueryParameterMetaData(this.parameterCount, this.parameterHandler);
  }

  @Override
  public void setRowId(int parameterIndex, RowId x) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setRowId is not supported.");
  }

  @Override
  public void setNString(int parameterIndex, String value) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setNString is not supported.");
  }

  @Override
  public void setNCharacterStream(int parameterIndex, Reader value, long length)
      throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setNCharacterStream is not supported.");
  }

  @Override
  public void setNClob(int parameterIndex, NClob value) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setNClob is not supported.");
  }

  @Override
  public void setClob(int parameterIndex, Reader reader, long length) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setClob is not supported.");
  }

  @Override
  public void setBlob(int parameterIndex, InputStream inputStream, long length)
      throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setBlob is not supported.");
  }

  @Override
  public void setNClob(int parameterIndex, Reader reader, long length) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setNClob is not supported.");
  }

  @Override
  public void setSQLXML(int parameterIndex, SQLXML xmlObject) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setSQLXML is not supported.");
  }

  /**
   * Note: BigQuery handles numeric scale and precision dynamically for NUMERIC (DECIMAL) and
   * BIGNUMERIC data types. The scaleOrLength parameter is ignored and delegates directly to {@link
   * #setObject(int, Object, int)}.
   */
  @Override
  public void setObject(int parameterIndex, Object value, int targetSqlType, int scaleOrLength)
      throws SQLException {
    checkClosed();
    setObject(parameterIndex, value, targetSqlType);
  }

  @Override
  public void setAsciiStream(int parameterIndex, InputStream x, long length) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setAsciiStream is not supported.");
  }

  @Override
  public void setBinaryStream(int parameterIndex, InputStream x, long length) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setBinaryStream is not supported.");
  }

  @Override
  public void setCharacterStream(int parameterIndex, Reader reader, long length)
      throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setCharacterStream is not supported.");
  }

  @Override
  public void setAsciiStream(int parameterIndex, InputStream x) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setAsciiStream is not supported.");
  }

  @Override
  public void setBinaryStream(int parameterIndex, InputStream x) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setBinaryStream is not supported.");
  }

  @Override
  public void setCharacterStream(int parameterIndex, Reader reader) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setCharacterStream is not supported.");
  }

  @Override
  public void setNCharacterStream(int parameterIndex, Reader value) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setNCharacterStream is not supported.");
  }

  @Override
  public void setClob(int parameterIndex, Reader reader) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setClob is not supported.");
  }

  @Override
  public void setBlob(int parameterIndex, InputStream inputStream) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setBlob is not supported.");
  }

  @Override
  public void setNClob(int parameterIndex, Reader reader) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("setNClob is not supported.");
  }
}
