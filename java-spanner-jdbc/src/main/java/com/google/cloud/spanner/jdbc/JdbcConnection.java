/*
 * Copyright 2019 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.spanner.jdbc;

import static com.google.cloud.spanner.jdbc.JdbcStatement.ALL_COLUMNS;
import static com.google.cloud.spanner.jdbc.JdbcStatement.isNullOrEmpty;

import com.google.api.client.util.Preconditions;
import com.google.cloud.ByteArray;
import com.google.cloud.spanner.CommitResponse;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Mutation;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.connection.AutocommitDmlMode;
import com.google.cloud.spanner.connection.Connection;
import com.google.cloud.spanner.connection.ConnectionOptions;
import com.google.cloud.spanner.connection.ConnectionProperties;
import com.google.cloud.spanner.connection.SavepointSupport;
import com.google.cloud.spanner.connection.TransactionMode;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Strings;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.Iterators;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.common.Attributes;
import io.opentelemetry.api.common.AttributesBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.DatabaseMetaData;
import java.sql.NClob;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Function;
import javax.annotation.Nonnull;

/** Jdbc Connection class for Google Cloud Spanner */
class JdbcConnection extends AbstractJdbcConnection {
  private static final String ONLY_RS_FORWARD_ONLY =
      "Only result sets of type TYPE_FORWARD_ONLY are supported";
  private static final String ONLY_CONCUR_READ_ONLY =
      "Only result sets with concurrency CONCUR_READ_ONLY are supported";
  private static final String ONLY_CLOSE_CURSORS_AT_COMMIT =
      "Only result sets with holdability CLOSE_CURSORS_AT_COMMIT are supported";

  /**
   * This query is used to check the aliveness of the connection if legacy alive check has been
   * enabled. As Cloud Spanner JDBC connections do not maintain a physical or logical connection to
   * Cloud Spanner, there is also no point in repeatedly executing a simple query to check whether a
   * connection is alive. Instead, we rely on the result from the initial query to Spanner that
   * determines the dialect to determine whether the connection is alive or not. This result is
   * cached for all JDBC connections using the same {@link com.google.cloud.spanner.Spanner}
   * instance.
   *
   * <p>The legacy {@link #isValid(int)} check using a SELECT 1 statement can be enabled by setting
   * the System property spanner.jdbc.use_legacy_is_valid_check to true or setting the environment
   * variable SPANNER_JDBC_USE_LEGACY_IS_VALID_CHECK to true.
   */
  static final String LEGACY_IS_VALID_QUERY = "SELECT 1";

  static final ImmutableList<String> NO_GENERATED_KEY_COLUMNS = ImmutableList.of();

  private Map<String, Class<?>> typeMap = new HashMap<>();

  private final boolean useLegacyIsValidCheck;

  private final Metrics metrics;

  private final Attributes openTelemetryMetricsAttributes;

  JdbcConnection(String connectionUrl, ConnectionOptions options) throws SQLException {
    super(connectionUrl, options);
    this.useLegacyIsValidCheck = useLegacyValidCheck();
    OpenTelemetry openTelemetry = getSpanner().getOptions().getOpenTelemetry();
    this.openTelemetryMetricsAttributes =
        createOpenTelemetryAttributes(getConnectionOptions().getDatabaseId(), false);
    this.metrics = new Metrics(openTelemetry);
  }

  static boolean useLegacyValidCheck() {
    String value = System.getProperty("spanner.jdbc.use_legacy_is_valid_check");
    if (Strings.isNullOrEmpty(value)) {
      value = System.getenv("SPANNER_JDBC_USE_LEGACY_IS_VALID_CHECK");
    }
    if (!Strings.isNullOrEmpty(value)) {
      return Boolean.parseBoolean(value);
    }
    return false;
  }

  @VisibleForTesting
  static Attributes createOpenTelemetryAttributes(
      DatabaseId databaseId, boolean includeConnectionId) {
    AttributesBuilder attributesBuilder = Attributes.builder();
    // A unique connection ID should only be included for tracing and not for metrics.
    if (includeConnectionId) {
      attributesBuilder.put("connection_id", UUID.randomUUID().toString());
    }
    attributesBuilder.put("database", databaseId.getDatabase());
    attributesBuilder.put("instance_id", databaseId.getInstanceId().getInstance());
    attributesBuilder.put("project_id", databaseId.getInstanceId().getProject());
    return attributesBuilder.build();
  }

  public void recordClientLibLatencyMetric(long value) {
    metrics.recordClientLibLatency(value, openTelemetryMetricsAttributes);
  }

  @Override
  public Statement createStatement() throws SQLException {
    checkClosed();
    return new JdbcStatement(this);
  }

  @Override
  public JdbcPreparedStatement prepareStatement(String sql) throws SQLException {
    return prepareStatement(sql, NO_GENERATED_KEY_COLUMNS);
  }

  private JdbcPreparedStatement prepareStatement(
      String sql, ImmutableList<String> generatedKeyColumns) throws SQLException {
    checkClosed();
    return new JdbcPreparedStatement(this, sql, generatedKeyColumns);
  }

  @Override
  public String nativeSQL(String sql) throws SQLException {
    checkClosed();
    return getParser()
        .convertPositionalParametersToNamedParameters('?', getParser().removeCommentsAndTrim(sql))
        .sqlWithNamedParameters;
  }

  @Override
  public String getStatementTag() throws SQLException {
    checkClosed();
    return getSpannerConnection().getStatementTag();
  }

  @Override
  public void setStatementTag(String tag) throws SQLException {
    checkClosed();
    try {
      getSpannerConnection().setStatementTag(tag);
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public String getTransactionTag() throws SQLException {
    checkClosed();
    return getSpannerConnection().getTransactionTag();
  }

  @Override
  public void setTransactionTag(String tag) throws SQLException {
    checkClosed();
    try {
      getSpannerConnection().setTransactionTag(tag);
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public void setTransactionMode(TransactionMode mode) throws SQLException {
    checkClosed();
    getSpannerConnection().setTransactionMode(mode);
  }

  @Override
  public TransactionMode getTransactionMode() throws SQLException {
    checkClosed();
    return getSpannerConnection().getTransactionMode();
  }

  @Override
  public void setAutocommitDmlMode(AutocommitDmlMode mode) throws SQLException {
    checkClosed();
    getSpannerConnection().setAutocommitDmlMode(mode);
  }

  @Override
  public AutocommitDmlMode getAutocommitDmlMode() throws SQLException {
    checkClosed();
    return getSpannerConnection().getAutocommitDmlMode();
  }

  @Override
  public void setReadOnlyStaleness(TimestampBound staleness) throws SQLException {
    checkClosed();
    getSpannerConnection().setReadOnlyStaleness(staleness);
  }

  @Override
  public TimestampBound getReadOnlyStaleness() throws SQLException {
    checkClosed();
    return getSpannerConnection().getReadOnlyStaleness();
  }

  @Override
  public void setOptimizerVersion(String optimizerVersion) throws SQLException {
    checkClosed();
    getSpannerConnection().setOptimizerVersion(optimizerVersion);
  }

  @Override
  public String getOptimizerVersion() throws SQLException {
    checkClosed();
    return getSpannerConnection().getOptimizerVersion();
  }

  /** Returns the value that should be returned for column types with an unknown length. */
  int getColumnTypeUnknownLength() {
    return getSpannerConnection().getConnectionPropertyValue(ConnectionProperties.UNKNOWN_LENGTH);
  }

  @Override
  public boolean isInTransaction() throws SQLException {
    checkClosed();
    return getSpannerConnection().isInTransaction();
  }

  @Override
  public boolean isTransactionStarted() throws SQLException {
    checkClosed();
    return getSpannerConnection().isTransactionStarted();
  }

  @Override
  public void setAutoCommit(boolean autoCommit) throws SQLException {
    checkClosed();
    try {
      // According to the JDBC spec's we need to commit the current transaction when changing
      // autocommit mode.
      if (getSpannerConnection().isAutocommit() != autoCommit
          && getSpannerConnection().isTransactionStarted()) {
        commit();
      }
      getSpannerConnection().setAutocommit(autoCommit);
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public boolean getAutoCommit() throws SQLException {
    checkClosed();
    return getSpannerConnection().isAutocommit();
  }

  @Override
  public void commit() throws SQLException {
    checkClosed();
    try {
      getSpannerConnection().commit();
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public void rollback() throws SQLException {
    checkClosed();
    try {
      getSpannerConnection().rollback();
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public void close() throws SQLException {
    try {
      getSpannerConnection().close();
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public boolean isClosed() {
    return getSpannerConnection().isClosed();
  }

  @Override
  public DatabaseMetaData getMetaData() throws SQLException {
    checkClosed();
    return new JdbcDatabaseMetaData(this);
  }

  @Override
  public void setReadOnly(boolean readOnly) throws SQLException {
    checkClosed();
    try {
      getSpannerConnection().setReadOnly(readOnly);
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public boolean isReadOnly() throws SQLException {
    checkClosed();
    return getSpannerConnection().isReadOnly();
  }

  @Override
  public Statement createStatement(int resultSetType, int resultSetConcurrency)
      throws SQLException {
    checkClosed();
    JdbcPreconditions.checkSqlFeatureSupported(
        resultSetType == ResultSet.TYPE_FORWARD_ONLY, ONLY_RS_FORWARD_ONLY);
    JdbcPreconditions.checkSqlFeatureSupported(
        resultSetConcurrency == ResultSet.CONCUR_READ_ONLY, ONLY_CONCUR_READ_ONLY);
    return createStatement();
  }

  @Override
  public Statement createStatement(
      int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
    checkClosed();
    JdbcPreconditions.checkSqlFeatureSupported(
        resultSetType == ResultSet.TYPE_FORWARD_ONLY, ONLY_RS_FORWARD_ONLY);
    JdbcPreconditions.checkSqlFeatureSupported(
        resultSetConcurrency == ResultSet.CONCUR_READ_ONLY, ONLY_CONCUR_READ_ONLY);
    JdbcPreconditions.checkSqlFeatureSupported(
        resultSetHoldability == ResultSet.CLOSE_CURSORS_AT_COMMIT, ONLY_CLOSE_CURSORS_AT_COMMIT);
    return createStatement();
  }

  @Override
  public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
      throws SQLException {
    checkClosed();
    JdbcPreconditions.checkSqlFeatureSupported(
        resultSetType == ResultSet.TYPE_FORWARD_ONLY, ONLY_RS_FORWARD_ONLY);
    JdbcPreconditions.checkSqlFeatureSupported(
        resultSetConcurrency == ResultSet.CONCUR_READ_ONLY, ONLY_CONCUR_READ_ONLY);
    return prepareStatement(sql);
  }

  @Override
  public PreparedStatement prepareStatement(
      String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
      throws SQLException {
    checkClosed();
    JdbcPreconditions.checkSqlFeatureSupported(
        resultSetType == ResultSet.TYPE_FORWARD_ONLY, ONLY_RS_FORWARD_ONLY);
    JdbcPreconditions.checkSqlFeatureSupported(
        resultSetConcurrency == ResultSet.CONCUR_READ_ONLY, ONLY_CONCUR_READ_ONLY);
    JdbcPreconditions.checkSqlFeatureSupported(
        resultSetHoldability == ResultSet.CLOSE_CURSORS_AT_COMMIT, ONLY_CLOSE_CURSORS_AT_COMMIT);
    return prepareStatement(sql);
  }

  @Override
  public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
    return prepareStatement(
        sql,
        autoGeneratedKeys == Statement.RETURN_GENERATED_KEYS
            ? ALL_COLUMNS
            : NO_GENERATED_KEY_COLUMNS);
  }

  @Override
  public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
    // This should preferably have returned an error, but the initial version of the driver just
    // accepted and ignored this. Starting to throw an error now would be a breaking change.
    // TODO: Consider throwing an Unsupported error for the next major version bump.
    return prepareStatement(sql, NO_GENERATED_KEY_COLUMNS);
  }

  @Override
  public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
    return prepareStatement(
        sql,
        isNullOrEmpty(columnNames) ? NO_GENERATED_KEY_COLUMNS : ImmutableList.copyOf(columnNames));
  }

  @Override
  public Map<String, Class<?>> getTypeMap() throws SQLException {
    checkClosed();
    return new HashMap<>(typeMap);
  }

  @Override
  public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
    checkClosed();
    this.typeMap = new HashMap<>(map);
  }

  boolean isUseLegacyIsValidCheck() {
    return useLegacyIsValidCheck;
  }

  @Override
  public boolean isValid(int timeout) throws SQLException {
    JdbcPreconditions.checkArgument(timeout >= 0, "timeout must be >= 0");
    if (!isClosed()) {
      if (isUseLegacyIsValidCheck()) {
        return legacyIsValid(timeout);
      }
      try {
        return getDialect() != null;
      } catch (Exception ignore) {
        // ignore and fall through.
      }
    }
    return false;
  }

  private boolean legacyIsValid(int timeout) throws SQLException {
    try (Statement statement = createStatement()) {
      statement.setQueryTimeout(timeout);
      try (ResultSet rs = statement.executeQuery(LEGACY_IS_VALID_QUERY)) {
        if (rs.next()) {
          if (rs.getLong(1) == 1L) {
            return true;
          }
        }
      }
    } catch (SQLException e) {
      // ignore and fall through.
    }
    return false;
  }

  @Override
  public Blob createBlob() throws SQLException {
    checkClosed();
    return new JdbcBlob();
  }

  @Override
  public Clob createClob() throws SQLException {
    checkClosed();
    return new JdbcClob();
  }

  @Override
  public NClob createNClob() throws SQLException {
    checkClosed();
    return new JdbcClob();
  }

  @Override
  public Array createArrayOf(String typeName, Object[] elements) throws SQLException {
    checkClosed();
    return JdbcArray.createArray(typeName, elements);
  }

  @Override
  public void setCatalog(String catalog) throws SQLException {
    // This method could be changed to allow the user to change to another database.
    // For now, we only support setting the default catalog in order to support frameworks
    // and applications that set this when no catalog has been specified in the connection
    // URL.
    checkClosed();
    checkValidCatalog(catalog);
  }

  void checkValidCatalog(String catalog) throws SQLException {
    String defaultCatalog = getDefaultCatalog();
    JdbcPreconditions.checkArgument(
        defaultCatalog.equals(catalog),
        String.format("Only catalog %s is supported", defaultCatalog));
  }

  @Override
  public String getCatalog() throws SQLException {
    checkClosed();
    return getDefaultCatalog();
  }

  @Nonnull
  String getDefaultCatalog() {
    switch (getDialect()) {
      case POSTGRESQL:
        String database = getConnectionOptions().getDatabaseName();
        // It should not be possible that database is null, but it's better to be safe than sorry.
        return database == null ? "" : database;
      case GOOGLE_STANDARD_SQL:
      default:
        return "";
    }
  }

  @Override
  public void setSchema(String schema) throws SQLException {
    checkClosed();
    checkValidSchema(schema);
  }

  void checkValidSchema(String schema) throws SQLException {
    String defaultSchema = getDefaultSchema();
    JdbcPreconditions.checkArgument(
        defaultSchema.equals(schema), String.format("Only schema %s is supported", defaultSchema));
  }

  @Override
  public String getSchema() throws SQLException {
    checkClosed();
    return getDefaultSchema();
  }

  @Nonnull
  String getDefaultSchema() {
    return getDialect().getDefaultSchema();
  }

  @Override
  public SavepointSupport getSavepointSupport() throws SQLException {
    checkClosed();
    return getSpannerConnection().getSavepointSupport();
  }

  @Override
  public void setSavepointSupport(SavepointSupport savepointSupport) throws SQLException {
    checkClosed();
    try {
      getSpannerConnection().setSavepointSupport(savepointSupport);
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public Savepoint setSavepoint() throws SQLException {
    checkClosed();
    try {
      JdbcSavepoint savepoint = JdbcSavepoint.unnamed();
      getSpannerConnection().savepoint(savepoint.internalGetSavepointName());
      return savepoint;
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public Savepoint setSavepoint(String name) throws SQLException {
    checkClosed();
    try {
      JdbcSavepoint savepoint = JdbcSavepoint.named(name);
      getSpannerConnection().savepoint(savepoint.internalGetSavepointName());
      return savepoint;
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public void rollback(Savepoint savepoint) throws SQLException {
    checkClosed();
    JdbcPreconditions.checkArgument(savepoint instanceof JdbcSavepoint, savepoint);
    JdbcSavepoint jdbcSavepoint = (JdbcSavepoint) savepoint;
    try {
      getSpannerConnection().rollbackToSavepoint(jdbcSavepoint.internalGetSavepointName());
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public void releaseSavepoint(Savepoint savepoint) throws SQLException {
    checkClosed();
    JdbcPreconditions.checkArgument(savepoint instanceof JdbcSavepoint, savepoint);
    JdbcSavepoint jdbcSavepoint = (JdbcSavepoint) savepoint;
    try {
      getSpannerConnection().releaseSavepoint(jdbcSavepoint.internalGetSavepointName());
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public Timestamp getCommitTimestamp() throws SQLException {
    checkClosed();
    try {
      return getSpannerConnection().getCommitTimestamp().toSqlTimestamp();
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public CommitResponse getCommitResponse() throws SQLException {
    checkClosed();
    try {
      return getSpannerConnection().getCommitResponse();
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public void setReturnCommitStats(boolean returnCommitStats) throws SQLException {
    checkClosed();
    try {
      getSpannerConnection().setReturnCommitStats(returnCommitStats);
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public boolean isReturnCommitStats() throws SQLException {
    checkClosed();
    try {
      return getSpannerConnection().isReturnCommitStats();
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public Timestamp getReadTimestamp() throws SQLException {
    checkClosed();
    try {
      return getSpannerConnection().getReadTimestamp().toSqlTimestamp();
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public boolean isRetryAbortsInternally() throws SQLException {
    checkClosed();
    try {
      return getSpannerConnection().isRetryAbortsInternally();
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public void setRetryAbortsInternally(boolean retryAbortsInternally) throws SQLException {
    checkClosed();
    try {
      getSpannerConnection().setRetryAbortsInternally(retryAbortsInternally);
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public void write(Mutation mutation) throws SQLException {
    checkClosed();
    try {
      getSpannerConnection().write(mutation);
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public void write(Iterable<Mutation> mutations) throws SQLException {
    checkClosed();
    try {
      getSpannerConnection().write(mutations);
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public void bufferedWrite(Mutation mutation) throws SQLException {
    checkClosed();
    try {
      getSpannerConnection().bufferedWrite(mutation);
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public void bufferedWrite(Iterable<Mutation> mutations) throws SQLException {
    checkClosed();
    try {
      getSpannerConnection().bufferedWrite(mutations);
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  /**
   * Convenience method for calling a setter and translating any {@link SpannerException} to a
   * {@link SQLException}.
   */
  private <T> void set(BiConsumer<Connection, T> setter, T value) throws SQLException {
    checkClosed();
    try {
      setter.accept(getSpannerConnection(), value);
    } catch (SpannerException spannerException) {
      throw JdbcSqlExceptionFactory.of(spannerException);
    }
  }

  /**
   * Convenience method for calling a getter and translating any {@link SpannerException} to a
   * {@link SQLException}.
   */
  private <R> R get(Function<Connection, R> getter) throws SQLException {
    checkClosed();
    try {
      return getter.apply(getSpannerConnection());
    } catch (SpannerException spannerException) {
      throw JdbcSqlExceptionFactory.of(spannerException);
    }
  }

  @Override
  public void setDataBoostEnabled(boolean dataBoostEnabled) throws SQLException {
    set(Connection::setDataBoostEnabled, dataBoostEnabled);
  }

  @Override
  public boolean isDataBoostEnabled() throws SQLException {
    return get(Connection::isDataBoostEnabled);
  }

  @Override
  public void setAutoPartitionMode(boolean autoPartitionMode) throws SQLException {
    set(Connection::setAutoPartitionMode, autoPartitionMode);
  }

  @Override
  public boolean isAutoPartitionMode() throws SQLException {
    return get(Connection::isAutoPartitionMode);
  }

  @Override
  public void setMaxPartitions(int maxPartitions) throws SQLException {
    set(Connection::setMaxPartitions, maxPartitions);
  }

  @Override
  public int getMaxPartitions() throws SQLException {
    return get(Connection::getMaxPartitions);
  }

  @Override
  public void setMaxPartitionedParallelism(int maxThreads) throws SQLException {
    set(Connection::setMaxPartitionedParallelism, maxThreads);
  }

  @Override
  public int getMaxPartitionedParallelism() throws SQLException {
    return get(Connection::getMaxPartitionedParallelism);
  }

  @Override
  public void setAutoBatchDml(boolean autoBatchDml) throws SQLException {
    set(Connection::setAutoBatchDml, autoBatchDml);
  }

  @Override
  public boolean isAutoBatchDml() throws SQLException {
    return get(Connection::isAutoBatchDml);
  }

  @Override
  public void setAutoBatchDmlUpdateCount(long updateCount) throws SQLException {
    set(Connection::setAutoBatchDmlUpdateCount, updateCount);
  }

  @Override
  public long getAutoBatchDmlUpdateCount() throws SQLException {
    return get(Connection::getAutoBatchDmlUpdateCount);
  }

  @Override
  public void setAutoBatchDmlUpdateCountVerification(boolean verification) throws SQLException {
    set(Connection::setAutoBatchDmlUpdateCountVerification, verification);
  }

  @Override
  public boolean isAutoBatchDmlUpdateCountVerification() throws SQLException {
    return get(Connection::isAutoBatchDmlUpdateCountVerification);
  }

  @SuppressWarnings("deprecation")
  private static final class JdbcToSpannerTransactionRetryListener
      implements com.google.cloud.spanner.connection.TransactionRetryListener {
    private final TransactionRetryListener delegate;

    JdbcToSpannerTransactionRetryListener(TransactionRetryListener delegate) {
      this.delegate = Preconditions.checkNotNull(delegate);
    }

    @Override
    public void retryStarting(
        com.google.cloud.Timestamp transactionStarted, long transactionId, int retryAttempt) {
      delegate.retryStarting(transactionStarted, transactionId, retryAttempt);
    }

    @Override
    public void retryFinished(
        com.google.cloud.Timestamp transactionStarted,
        long transactionId,
        int retryAttempt,
        RetryResult result) {
      delegate.retryFinished(
          transactionStarted,
          transactionId,
          retryAttempt,
          TransactionRetryListener.RetryResult.valueOf(result.name()));
    }

    @Override
    public boolean equals(Object o) {
      if (!(o instanceof JdbcToSpannerTransactionRetryListener)) {
        return false;
      }
      JdbcToSpannerTransactionRetryListener other = (JdbcToSpannerTransactionRetryListener) o;
      return this.delegate.equals(other.delegate);
    }

    @Override
    public int hashCode() {
      return delegate.hashCode();
    }
  }

  @SuppressWarnings("deprecation")
  @Override
  public void addTransactionRetryListener(TransactionRetryListener listener) throws SQLException {
    checkClosed();
    getSpannerConnection()
        .addTransactionRetryListener(new JdbcToSpannerTransactionRetryListener(listener));
  }

  @Override
  public void addTransactionRetryListener(
      com.google.cloud.spanner.connection.TransactionRetryListener listener) throws SQLException {
    checkClosed();
    getSpannerConnection().addTransactionRetryListener(listener);
  }

  @SuppressWarnings("deprecation")
  @Override
  public boolean removeTransactionRetryListener(TransactionRetryListener listener)
      throws SQLException {
    checkClosed();
    return getSpannerConnection()
        .removeTransactionRetryListener(new JdbcToSpannerTransactionRetryListener(listener));
  }

  @Override
  public boolean removeTransactionRetryListener(
      com.google.cloud.spanner.connection.TransactionRetryListener listener) throws SQLException {
    checkClosed();
    return getSpannerConnection().removeTransactionRetryListener(listener);
  }

  @SuppressWarnings("deprecation")
  @Override
  public Iterator<TransactionRetryListener> getTransactionRetryListeners() throws SQLException {
    checkClosed();
    return Iterators.transform(
        getSpannerConnection().getTransactionRetryListeners(),
        input -> {
          if (input instanceof JdbcToSpannerTransactionRetryListener) {
            return ((JdbcToSpannerTransactionRetryListener) input).delegate;
          }
          return null;
        });
  }

  @Override
  public Iterator<com.google.cloud.spanner.connection.TransactionRetryListener>
      getTransactionRetryListenersFromConnection() throws SQLException {
    checkClosed();
    return getSpannerConnection().getTransactionRetryListeners();
  }

  @Override
  public void setProtoDescriptors(@Nonnull byte[] protoDescriptors) throws SQLException {
    Preconditions.checkNotNull(protoDescriptors);
    checkClosed();
    try {
      getSpannerConnection().setProtoDescriptors(protoDescriptors);
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public void setProtoDescriptors(@Nonnull InputStream protoDescriptors)
      throws SQLException, IOException {
    Preconditions.checkNotNull(protoDescriptors);
    checkClosed();
    try {
      getSpannerConnection()
          .setProtoDescriptors(ByteArray.copyFrom(protoDescriptors).toByteArray());
    } catch (SpannerException e) {
      throw JdbcSqlExceptionFactory.of(e);
    }
  }

  @Override
  public byte[] getProtoDescriptors() throws SQLException {
    checkClosed();
    return getSpannerConnection().getProtoDescriptors();
  }
}
