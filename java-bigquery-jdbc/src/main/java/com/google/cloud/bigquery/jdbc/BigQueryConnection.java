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

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.FixedCredentialsProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.paging.Page;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.FixedHeaderProvider;
import com.google.api.gax.rpc.HeaderProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.auth.Credentials;
import com.google.auth.http.HttpTransportFactory;
import com.google.cloud.bigquery.BigQuery;
import com.google.cloud.bigquery.BigQueryException;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.ConnectionProperty;
import com.google.cloud.bigquery.DatasetId;
import com.google.cloud.bigquery.Job;
import com.google.cloud.bigquery.JobInfo;
import com.google.cloud.bigquery.Project;
import com.google.cloud.bigquery.QueryJobConfiguration;
import com.google.cloud.bigquery.QueryJobConfiguration.JobCreationMode;
import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import com.google.cloud.bigquery.exception.BigQueryJdbcSqlFeatureNotSupportedException;
import com.google.cloud.bigquery.storage.v1.BigQueryReadClient;
import com.google.cloud.bigquery.storage.v1.BigQueryReadSettings;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteClient;
import com.google.cloud.bigquery.storage.v1.BigQueryWriteSettings;
import com.google.cloud.http.HttpTransportOptions;
import com.google.cloud.logging.Logging;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSortedSet;
import io.grpc.ManagedChannelBuilder;
import io.grpc.opentelemetry.GrpcOpenTelemetry;
import io.opentelemetry.api.OpenTelemetry;
import io.opentelemetry.api.baggage.Baggage;
import io.opentelemetry.api.trace.Tracer;
import io.opentelemetry.context.Context;
import java.io.IOException;
import java.io.InputStream;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.Statement;
import java.time.Duration;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * An implementation of {@link java.sql.Connection} for establishing a connection with BigQuery and
 * executing SQL statements
 *
 * @see BigQueryStatement
 */
public class BigQueryConnection extends BigQueryNoOpsConnection {

  private final BigQueryJdbcCustomLogger LOG = new BigQueryJdbcCustomLogger(this.toString());
  String connectionClassName = this.toString();
  private final String connectionId;
  private static final String DEFAULT_JDBC_TOKEN_VALUE = "Google-BigQuery-JDBC-Driver";
  private static final String DEFAULT_VERSION = "0.0.0";
  private static final Set<String> SAFE_TO_LOG_PROPERTIES =
      ImmutableSortedSet.orderedBy(String.CASE_INSENSITIVE_ORDER)
          .add(
              BigQueryJdbcUrlUtility.PROJECT_ID_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.DEFAULT_DATASET_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.LOCATION_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.ENABLE_HTAPI_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.UNSUPPORTED_HTAPI_FALLBACK_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.HTAPI_MIN_TABLE_SIZE_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.HTAPI_ACTIVATION_RATIO_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.KMS_KEY_NAME_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.QUERY_PROPERTIES_NAME,
              BigQueryJdbcUrlUtility.ENABLE_SESSION_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.LOG_LEVEL_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.LOG_PATH_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.OAUTH_TYPE_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.OAUTH_ACCESS_TOKEN_READONLY_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.USE_QUERY_CACHE_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.QUERY_DIALECT_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.ALLOW_LARGE_RESULTS_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.LARGE_RESULTS_TABLE_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.LARGE_RESULTS_DATASET_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.DESTINATION_DATASET_EXPIRATION_TIME_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.PROXY_HOST_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.PROXY_PORT_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.JOB_CREATION_MODE_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.MAX_RESULTS_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.PARTNER_TOKEN_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.ENDPOINT_OVERRIDES_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.PRIVATE_SERVICE_CONNECT_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.METADATA_FETCH_THREAD_COUNT_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.RETRY_TIMEOUT_IN_SECS_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.JOB_TIMEOUT_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.RETRY_INITIAL_DELAY_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.RETRY_MAX_DELAY_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.ADDITIONAL_PROJECTS_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.CONNECTION_POOL_SIZE_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.LISTENER_POOL_SIZE_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.ENABLE_WRITE_API_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.SWA_APPEND_ROW_COUNT_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.SWA_ACTIVATION_ROW_COUNT_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.FILTER_TABLES_ON_DEFAULT_DATASET_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.ENABLE_PROJECT_DISCOVERY_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.REQUEST_GOOGLE_DRIVE_SCOPE_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.SSL_TRUST_STORE_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.MAX_BYTES_BILLED_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.LABELS_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.REQUEST_REASON_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.HTTP_CONNECT_TIMEOUT_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.HTTP_READ_TIMEOUT_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.BYOID_AUDIENCE_URI_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.BYOID_CREDENTIAL_SOURCE_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.BYOID_POOL_USER_PROJECT_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.BYOID_SA_IMPERSONATION_URI_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.BYOID_SUBJECT_TOKEN_TYPE_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.BYOID_TOKEN_URI_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_EMAIL_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_CHAIN_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_SCOPES_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_TOKEN_LIFETIME_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.OAUTH_SA_EMAIL_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PATH_PROPERTY_NAME,
              BigQueryJdbcUrlUtility.OAUTH_CLIENT_ID_PROPERTY_NAME)
          .build();
  private HeaderProvider headerProvider;
  BigQueryReadClient bigQueryReadClient = null;
  BigQueryWriteClient bigQueryWriteClient = null;
  BigQuery bigQuery;
  String connectionUrl;
  Set<Statement> openStatements;
  boolean autoCommit;
  int transactionIsolation;
  List<SQLWarning> sqlWarnings;
  String catalog;
  String gcpTelemetryCredentials;
  String gcpTelemetryProjectId;
  int holdability;
  long retryTimeoutInSeconds;
  Duration retryTimeoutDuration;
  long retryInitialDelayInSeconds;
  Duration retryInitialDelayDuration;
  long retryMaxDelayInSeconds;
  Duration retryMaxDelayDuration;
  // transactionStarted is false by default.
  // when autocommit is false transaction starts and session is initialized.
  boolean transactionStarted;
  ConnectionProperty sessionInfoConnectionProperty;
  boolean isClosed;
  DatasetId defaultDataset;
  String location;
  boolean enableHighThroughputAPI;
  int highThroughputMinTableSize;
  int highThroughputActivationRatio;
  boolean enableSession;
  boolean enableProjectDiscovery;
  private List<String> discoveredProjectsCache;
  boolean unsupportedHTAPIFallback;
  boolean useQueryCache;
  String queryDialect;
  int metadataFetchThreadCount;
  boolean allowLargeResults;
  String destinationTable;
  String destinationDataset;
  long destinationDatasetExpirationTime;
  String kmsKeyName;
  String universeDomain;
  List<ConnectionProperty> queryProperties;
  Map<String, String> authProperties;
  Map<String, String> overrideProperties;
  Credentials credentials;
  boolean useStatelessQueryMode;
  int numBufferedRows;
  HttpTransportOptions httpTransportOptions;
  TransportChannelProvider transportChannelProvider;
  long maxResults;
  long jobTimeoutInSeconds;
  boolean enableWriteAPI;
  int writeAPIActivationRowCount;
  int writeAPIAppendRowCount;
  int requestGoogleDriveScope;
  String additionalProjects;
  boolean filterTablesOnDefaultDataset;
  String sslTrustStorePath;
  String sslTrustStorePassword;
  String sslTrustStoreType;
  String sslTrustStoreProvider;
  long maxBytesBilled;
  Map<String, String> labels;
  Integer httpConnectTimeout;
  Integer httpReadTimeout;
  String requestReason;
  Long connectionPoolSize;
  Long listenerPoolSize;
  String partnerToken;
  boolean enableGcpTraceExporter;
  boolean enableGcpLogExporter;
  OpenTelemetry customOpenTelemetry;
  boolean useGlobalOpenTelemetry;
  private OpenTelemetry openTelemetry;
  private Context otelContext;
  Tracer tracer =
      OpenTelemetry.noop().getTracer(BigQueryJdbcOpenTelemetry.INSTRUMENTATION_SCOPE_NAME);
  DatabaseMetaData databaseMetaData;
  Boolean reqGoogleDriveScope;
  private final Properties clientInfo = new Properties();
  private boolean isReadOnlyTokenUsed = false;
  private final ExecutorService metadataExecutor;
  private final ExecutorService queryExecutor;

  BigQueryConnection(String url) throws IOException {
    this(url, DataSource.fromUrl(url));
  }

  BigQueryConnection(String url, DataSource ds) throws IOException {
    this.connectionId = UUID.randomUUID().toString();
    Baggage baggage =
        Baggage.builder()
            .put(BigQueryJdbcOpenTelemetry.CONNECTION_ID_BAGGAGE_KEY, this.connectionId)
            .build();
    this.otelContext = Context.current().with(baggage);
    try (BigQueryJdbcMdc.MdcCloseable mdc = BigQueryJdbcMdc.registerInstance(this.connectionId)) {
      this.connectionUrl = url;
      if (LOG.isLoggable(java.util.logging.Level.CONFIG)) {
        Properties connectionProps = ds.createProperties();
        Properties maskedProps = new Properties();
        for (String name : connectionProps.stringPropertyNames()) {
          String value = connectionProps.getProperty(name);
          if (!SAFE_TO_LOG_PROPERTIES.contains(name)) {
            value = "*****";
          }
          maskedProps.setProperty(name, value);
        }
        LOG.config("Connection properties: %s", maskedProps.toString());
      }
      this.openStatements = ConcurrentHashMap.newKeySet();
      this.autoCommit = true;
      this.sqlWarnings = new ArrayList<>();
      this.transactionStarted = false;
      this.isClosed = false;

      this.labels = ds.getLabels() != null ? ds.getLabels() : new java.util.HashMap<>();
      this.maxBytesBilled = ds.getMaximumBytesBilled();
      this.gcpTelemetryCredentials = ds.getGcpTelemetryCredentials();
      this.gcpTelemetryProjectId = ds.getGcpTelemetryProjectId();
      this.retryTimeoutInSeconds = ds.getTimeout();
      this.retryTimeoutDuration = Duration.ofMillis(retryTimeoutInSeconds * 1000L);
      this.retryInitialDelayInSeconds = ds.getRetryInitialDelay();
      this.retryInitialDelayDuration = Duration.ofMillis(retryInitialDelayInSeconds * 1000L);
      this.retryMaxDelayInSeconds = ds.getRetryMaxDelay();
      this.retryMaxDelayDuration = Duration.ofMillis(retryMaxDelayInSeconds * 1000L);
      this.jobTimeoutInSeconds = ds.getJobTimeout();
      this.authProperties =
          BigQueryJdbcOAuthUtility.parseOAuthProperties(ds, this.connectionClassName);
      this.isReadOnlyTokenUsed = checkIsReadOnlyTokenUsed(this.authProperties);
      this.catalog = ds.getProjectId();
      this.universeDomain = ds.getUniverseDomain();

      this.overrideProperties = ds.getOverrideProperties();
      if (this.universeDomain != null) {
        this.overrideProperties.put(
            BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME, this.universeDomain);
      }

      this.reqGoogleDriveScope =
          BigQueryJdbcUrlUtility.convertIntToBoolean(
              String.valueOf(ds.getRequestGoogleDriveScope()),
              BigQueryJdbcUrlUtility.REQUEST_GOOGLE_DRIVE_SCOPE_PROPERTY_NAME);

      Map<String, String> proxyProperties =
          BigQueryJdbcProxyUtility.parseProxyProperties(ds, this.connectionClassName);

      this.sslTrustStorePath = ds.getSSLTrustStorePath();
      this.sslTrustStorePassword = ds.getSSLTrustStorePassword();
      this.sslTrustStoreType = ds.getSSLTrustStoreType();
      this.sslTrustStoreProvider = ds.getSSLTrustStoreProvider();
      this.httpConnectTimeout = ds.getHttpConnectTimeout();
      this.httpReadTimeout = ds.getHttpReadTimeout();

      this.httpTransportOptions =
          BigQueryJdbcProxyUtility.getHttpTransportOptions(
              proxyProperties,
              this.sslTrustStorePath,
              this.sslTrustStorePassword,
              this.sslTrustStoreType,
              this.sslTrustStoreProvider,
              this.httpConnectTimeout,
              this.httpReadTimeout,
              this.connectionClassName);

      HttpTransportFactory httpTransportFactory =
          this.httpTransportOptions != null
              ? this.httpTransportOptions.getHttpTransportFactory()
              : null;

      this.credentials =
          BigQueryJdbcOAuthUtility.getCredentials(
              authProperties,
              overrideProperties,
              this.reqGoogleDriveScope,
              httpTransportFactory,
              this.connectionClassName);
      String defaultDatasetString = ds.getDefaultDataset();
      if (defaultDatasetString == null || defaultDatasetString.trim().isEmpty()) {
        this.defaultDataset = null;
      } else {
        String[] parts = defaultDatasetString.split("\\.");
        if (parts.length == 2) {
          this.defaultDataset = DatasetId.of(parts[0], parts[1]);
        } else if (parts.length == 1) {
          this.defaultDataset = DatasetId.of(parts[0]);
        } else {
          IllegalArgumentException ex =
              new IllegalArgumentException(
                  "DefaultDataset format is invalid. Supported options are datasetId or"
                      + " projectId.datasetId");
          LOG.severe(ex.getMessage(), ex);
          throw ex;
        }
      }
      this.location = ds.getLocation();
      this.enableHighThroughputAPI = ds.getEnableHighThroughputAPI();
      this.highThroughputMinTableSize = ds.getHighThroughputMinTableSize();
      this.highThroughputActivationRatio = ds.getHighThroughputActivationRatio();
      this.useQueryCache = ds.getUseQueryCache();
      this.useStatelessQueryMode = ds.getUseStatelessQueryMode();

      this.queryDialect = ds.getQueryDialect();
      this.allowLargeResults = ds.getAllowLargeResults();
      this.destinationTable = ds.getDestinationTable();
      this.destinationDataset = ds.getDestinationDataset();
      this.destinationDatasetExpirationTime = ds.getDestinationDatasetExpirationTime();
      this.kmsKeyName = ds.getKmsKeyName();
      this.transportChannelProvider =
          BigQueryJdbcProxyUtility.getTransportChannelProvider(
              proxyProperties,
              this.sslTrustStorePath,
              this.sslTrustStorePassword,
              this.sslTrustStoreType,
              this.sslTrustStoreProvider,
              this.connectionClassName);
      this.enableSession = ds.getEnableSession();
      this.unsupportedHTAPIFallback = ds.getUnsupportedHTAPIFallback();
      this.maxResults = ds.getMaxResults();
      Map<String, String> queryPropertiesMap = ds.getQueryProperties();
      this.sessionInfoConnectionProperty =
          getSessionPropertyFromQueryProperties(queryPropertiesMap);
      this.queryProperties = convertMapToConnectionPropertiesList(queryPropertiesMap);
      this.enableWriteAPI = ds.getEnableWriteAPI();
      this.writeAPIActivationRowCount = ds.getSwaActivationRowCount();
      this.writeAPIAppendRowCount = ds.getSwaAppendRowCount();

      this.additionalProjects = ds.getAdditionalProjects();

      this.filterTablesOnDefaultDataset = ds.getFilterTablesOnDefaultDataset();
      this.enableProjectDiscovery = ds.getEnableProjectDiscovery();
      this.requestGoogleDriveScope = ds.getRequestGoogleDriveScope();
      this.metadataFetchThreadCount = ds.getMetadataFetchThreadCount();
      this.requestReason = ds.getRequestReason();
      this.connectionPoolSize = ds.getConnectionPoolSize();
      this.listenerPoolSize = ds.getListenerPoolSize();
      this.partnerToken = ds.getPartnerToken();

      this.headerProvider = createHeaderProvider();
      this.enableGcpTraceExporter = ds.getEnableGcpTraceExporter();
      this.enableGcpLogExporter = ds.getEnableGcpLogExporter();
      this.customOpenTelemetry = ds.getCustomOpenTelemetry();
      this.useGlobalOpenTelemetry = ds.getUseGlobalOpenTelemetry();
      this.openTelemetry = getOpenTelemetryInstance();
      this.bigQuery = getBigQueryConnection();
      // Cached pool executes queries immediately without queueing and reclaims all idle threads
      // when inactive, minimizing resources.
      this.queryExecutor =
          BigQueryJdbcMdc.newCachedThreadPool(String.format("BQ-Query-%s", connectionId));
      this.metadataExecutor =
          BigQueryJdbcMdc.newFixedThreadPool(
              String.format("BQ-Metadata-%s", connectionId), this.metadataFetchThreadCount);
    }
  }

  String getLibraryVersion(Class<?> libraryClass) {
    LOG.finer("++enter++");
    String version = null;
    try (InputStream in =
        libraryClass.getResourceAsStream(
            "/com/google/cloud/bigquery/jdbc/dependencies.properties")) {
      if (in != null) {
        Properties props = new Properties();
        props.load(in);
        version = props.getProperty("version.jdbc");
      }
    } catch (IOException e) {
      LOG.warning("Failed to load dependencies.properties");
      return DEFAULT_VERSION;
    }

    return version != null ? version : DEFAULT_VERSION;
  }

  HeaderProvider createHeaderProvider() {
    String headerToken = DEFAULT_JDBC_TOKEN_VALUE + "/" + getLibraryVersion(this.getClass());
    if (this.partnerToken != null && !this.partnerToken.isEmpty()) {
      headerToken += this.partnerToken;
    }
    Map<String, String> headers = new java.util.HashMap<>();
    headers.put("user-agent", headerToken);
    if (this.requestReason != null) {
      headers.put("x-goog-request-reason", this.requestReason);
    }
    return FixedHeaderProvider.create(headers);
  }

  protected void addOpenStatements(Statement statement) {
    LOG.finer("Statement %s added to Connection %s.", statement, this);
    this.openStatements.add(statement);
  }

  BigQueryReadClient getBigQueryReadClient() {
    try {
      if (this.bigQueryReadClient == null) {
        this.bigQueryReadClient = getBigQueryReadClientConnection();
      }
    } catch (IOException e) {
      throw new BigQueryJdbcRuntimeException("Failed to initialize BigQueryReadClient", e);
    }
    return this.bigQueryReadClient;
  }

  BigQueryWriteClient getBigQueryWriteClient() {
    try {
      if (this.bigQueryWriteClient == null) {
        this.bigQueryWriteClient = getBigQueryWriteClientConnection();
      }
    } catch (IOException e) {
      throw new BigQueryJdbcRuntimeException("Failed to initialize BigQueryWriteClient", e);
    }
    return this.bigQueryWriteClient;
  }

  BigQuery getBigQuery() {
    return this.bigQuery;
  }

  String getConnectionUrl() {
    return connectionUrl;
  }

  @VisibleForTesting
  public String getConnectionId() {
    return this.connectionId;
  }

  /**
   * Creates and returns a new {@code Statement} object for executing BigQuery SQL queries
   *
   * @return a new {@code Statement} object
   * @see Connection#createStatement()
   */
  @Override
  public Statement createStatement() throws SQLException {
    checkClosed();
    BigQueryStatement currentStatement = new BigQueryStatement(this);
    LOG.fine("Statement %s created.", currentStatement);
    addOpenStatements(currentStatement);
    return currentStatement;
  }

  /**
   * Creates and returns a new {@code Statement} object for executing BigQuery SQL queries. This
   * method is similar to {@link BigQueryConnection#createStatement()}, but it overrides the type
   * and concurrency of the generated {@code ResultSet}.
   *
   * @throws SQLException if a BigQuery connection error occurs, if this method is called on a
   *     closed connection, or the given parameters are not {@code ResultSet} constants indicating
   *     type and concurrency.
   * @throws BigQueryJdbcSqlFeatureNotSupportedException if this method is not supported for the
   *     specified result set type and result set concurrency.
   * @see Connection#createStatement(int, int)
   * @see ResultSet
   */
  @Override
  public Statement createStatement(int resultSetType, int resultSetConcurrency)
      throws SQLException {
    checkClosed();
    if (resultSetType != ResultSet.TYPE_FORWARD_ONLY
        || resultSetConcurrency != ResultSet.CONCUR_READ_ONLY) {
      throw new BigQueryJdbcSqlFeatureNotSupportedException("Unsupported createStatement feature.");
    }
    return createStatement();
  }

  /**
   * Creates and returns a new {@code Statement} object for executing BigQuery SQL queries. This
   * method is similar to {@link BigQueryConnection#createStatement()}, but it overrides the type,
   * concurrency, and holdability of the generated {@code ResultSet}.
   *
   * @throws SQLException if a BigQuery connection error occurs, if this method is called on a
   *     closed connection, or the given parameters are not {@code ResultSet} constants indicating
   *     type, concurrency, and holdability.
   * @throws BigQueryJdbcSqlFeatureNotSupportedException if this method is not supported for the
   *     specified result set type, result set holdability and result set concurrency.
   * @see Connection#createStatement(int, int, int)
   * @see ResultSet
   */
  @Override
  public Statement createStatement(
      int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
    checkClosed();
    if (resultSetType != ResultSet.TYPE_FORWARD_ONLY
        || resultSetConcurrency != ResultSet.CONCUR_READ_ONLY
        || resultSetHoldability != ResultSet.CLOSE_CURSORS_AT_COMMIT) {
      throw new BigQueryJdbcSqlFeatureNotSupportedException("Unsupported createStatement feature");
    }
    return createStatement();
  }

  @Override
  public PreparedStatement prepareStatement(String sql) throws SQLException {
    checkClosed();
    PreparedStatement currentStatement = new BigQueryPreparedStatement(this, sql);
    LOG.fine("Prepared Statement %s created.", currentStatement);
    addOpenStatements(currentStatement);
    return currentStatement;
  }

  @Override
  public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
    if (autoGeneratedKeys != Statement.NO_GENERATED_KEYS) {
      throw new BigQueryJdbcSqlFeatureNotSupportedException("autoGeneratedKeys is not supported");
    }
    return prepareStatement(sql);
  }

  @Override
  public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
    throw new BigQueryJdbcSqlFeatureNotSupportedException("autoGeneratedKeys is not supported");
  }

  @Override
  public PreparedStatement prepareStatement(
      String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
      throws SQLException {
    if (resultSetType != ResultSet.TYPE_FORWARD_ONLY
        || resultSetConcurrency != ResultSet.CONCUR_READ_ONLY
        || resultSetHoldability != ResultSet.CLOSE_CURSORS_AT_COMMIT) {
      throw new BigQueryJdbcSqlFeatureNotSupportedException("Unsupported prepareStatement feature");
    }
    return prepareStatement(sql);
  }

  @Override
  public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency)
      throws SQLException {
    if (resultSetType != ResultSet.TYPE_FORWARD_ONLY
        || resultSetConcurrency != ResultSet.CONCUR_READ_ONLY) {
      throw new BigQueryJdbcSqlFeatureNotSupportedException("Unsupported prepareStatement feature");
    }
    return prepareStatement(sql);
  }

  public DatasetId getDefaultDataset() {
    checkClosed();
    return this.defaultDataset;
  }

  String getDestinationDataset() {
    return this.destinationDataset;
  }

  String getDestinationTable() {
    return this.destinationTable;
  }

  long getDestinationDatasetExpirationTime() {
    return this.destinationDatasetExpirationTime;
  }

  String getKmsKeyName() {
    return this.kmsKeyName;
  }

  List<ConnectionProperty> getQueryProperties() {
    return this.queryProperties;
  }

  public String getLocation() {
    checkClosed();
    return this.location;
  }

  public Map<String, String> getAuthProperties() {
    checkClosed();
    return this.authProperties;
  }

  long getMaxResults() {
    return maxResults;
  }

  long getRetryTimeoutInSeconds() {
    return this.retryTimeoutInSeconds;
  }

  Duration getRetryTimeoutDuration() {
    return this.retryTimeoutDuration;
  }

  long getRetryInitialDelayInSeconds() {
    return this.retryInitialDelayInSeconds;
  }

  Duration getRetryInitialDelayDuration() {
    return this.retryInitialDelayDuration;
  }

  long getRetryMaxDelayInSeconds() {
    return this.retryMaxDelayInSeconds;
  }

  Duration getRetryMaxDelayDuration() {
    return this.retryMaxDelayDuration;
  }

  long getJobTimeoutInSeconds() {
    return this.jobTimeoutInSeconds;
  }

  long getMaxBytesBilled() {
    return this.maxBytesBilled;
  }

  Map<String, String> getLabels() {
    return this.labels;
  }

  /**
   * Begins a transaction. <br>
   * The transaction ends when a {@link BigQueryConnection#commit()} or {@link
   * BigQueryConnection#rollback()} is made. <br>
   * For more information about transactions in BigQuery, see <a
   * href="https://cloud.google.com/bigquery/docs/transactions">Multi-statement transactions</a>.
   */
  private void beginTransaction() {
    LOG.finer("++enter++");
    QueryJobConfiguration.Builder transactionBeginJobConfig =
        QueryJobConfiguration.newBuilder("BEGIN TRANSACTION;");
    try {
      if (this.sessionInfoConnectionProperty != null) {
        transactionBeginJobConfig.setConnectionProperties(this.queryProperties);
      } else {
        transactionBeginJobConfig.setCreateSession(true);
      }
      Job job = this.bigQuery.create(JobInfo.of(transactionBeginJobConfig.build()));
      job = job.waitFor();
      Job transactionBeginJob = this.bigQuery.getJob(job.getJobId());
      if (this.sessionInfoConnectionProperty == null) {
        this.sessionInfoConnectionProperty =
            ConnectionProperty.newBuilder()
                .setKey("session_id")
                .setValue(transactionBeginJob.getStatistics().getSessionInfo().getSessionId())
                .build();
        this.queryProperties.add(this.sessionInfoConnectionProperty);
      }
      this.transactionStarted = true;
    } catch (InterruptedException ex) {
      throw new BigQueryJdbcRuntimeException("Failed to begin transaction", ex);
    }
  }

  public boolean isTransactionStarted() {
    return this.transactionStarted;
  }

  boolean isSessionEnabled() {
    return this.enableSession;
  }

  boolean isUnsupportedHTAPIFallback() {
    return this.unsupportedHTAPIFallback;
  }

  ConnectionProperty getSessionInfoConnectionProperty() {
    return this.sessionInfoConnectionProperty;
  }

  boolean isEnableHighThroughputAPI() {
    return this.enableHighThroughputAPI;
  }

  boolean isUseQueryCache() {
    return useQueryCache;
  }

  boolean getUseStatelessQueryMode() {
    return useStatelessQueryMode;
  }

  boolean isAllowLargeResults() {
    return allowLargeResults;
  }

  String getQueryDialect() {
    return queryDialect;
  }

  Integer getNumBufferedRows() {
    return numBufferedRows;
  }

  int getHighThroughputMinTableSize() {
    return highThroughputMinTableSize;
  }

  String getAdditionalProjects() {
    return this.additionalProjects;
  }

  int getHighThroughputActivationRatio() {
    return highThroughputActivationRatio;
  }

  boolean isFilterTablesOnDefaultDataset() {
    return this.filterTablesOnDefaultDataset;
  }

  int isRequestGoogleDriveScope() {
    return requestGoogleDriveScope;
  }

  int getMetadataFetchThreadCount() {
    return this.metadataFetchThreadCount;
  }

  boolean isEnableWriteAPI() {
    return enableWriteAPI;
  }

  int getWriteAPIActivationRowCount() {
    return writeAPIActivationRowCount;
  }

  int getWriteAPIAppendRowCount() {
    return writeAPIAppendRowCount;
  }

  String getSSLTrustStorePath() {
    return sslTrustStorePath;
  }

  String getSSLTrustStorePassword() {
    return sslTrustStorePassword;
  }

  Integer getHttpConnectTimeout() {
    return httpConnectTimeout;
  }

  Integer getHttpReadTimeout() {
    return httpReadTimeout;
  }

  Long getConnectionPoolSize() {
    return connectionPoolSize;
  }

  Long getListenerPoolSize() {
    return listenerPoolSize;
  }

  @Override
  public boolean isValid(int timeout) throws SQLException {
    if (timeout < 0) {
      throw new BigQueryJdbcException("timeout must be >= 0");
    }
    if (!isClosed()) {
      try (Statement statement = createStatement();
          ResultSet rs = statement.executeQuery("SELECT 1")) {
        LOG.finer("Running validation query");
        if (rs.next()) {
          if (rs.getInt(1) == 1) {
            return true;
          }
        }
      } catch (SQLException ex) {
        // Ignore
      }
    }
    return false;
  }

  @Override
  public void abort(Executor executor) throws SQLException {
    close();
  }

  @Override
  public void setClientInfo(String name, String value) {
    if (value == null) {
      this.clientInfo.remove(name);
    } else {
      this.clientInfo.setProperty(name, value);
    }
  }

  @Override
  public String getClientInfo(String name) {
    return this.clientInfo.getProperty(name);
  }

  @Override
  public String getCatalog() {
    return this.catalog;
  }

  @Override
  public String nativeSQL(String sql) throws SQLException {
    checkClosed();
    return sql;
  }

  @Override
  public Properties getClientInfo() {
    return this.clientInfo;
  }

  @Override
  public void setClientInfo(Properties properties) {
    this.clientInfo.clear();
    if (properties != null) {
      this.clientInfo.putAll(properties);
    }
  }

  @Override
  public SQLWarning getWarnings() {
    return this.sqlWarnings.isEmpty() ? null : this.sqlWarnings.get(0);
  }

  @Override
  public void clearWarnings() {
    this.sqlWarnings.clear();
  }

  @Override
  public boolean getAutoCommit() {
    checkClosed();
    return this.autoCommit;
  }

  @Override
  public void setAutoCommit(boolean autoCommit) throws SQLException {
    checkClosed();
    checkIfEnabledSession("setAutoCommit");
    if (this.autoCommit == autoCommit) {
      return;
    }

    if (isTransactionStarted()) {
      commitTransaction();
    }

    this.autoCommit = autoCommit;
    if (!this.autoCommit) {
      beginTransaction();
    }
  }

  @Override
  public void commit() {
    checkClosed();
    checkIfEnabledSession("commit");
    if (!isTransactionStarted()) {
      IllegalStateException ex =
          new IllegalStateException(
              "Cannot commit without an active transaction. Please set setAutoCommit to false to start"
                  + " a transaction.");
      LOG.severe(ex.getMessage(), ex);
      throw ex;
    }
    commitTransaction();
    if (!getAutoCommit()) {
      beginTransaction();
    }
  }

  @Override
  public void rollback() throws SQLException {
    checkClosed();
    checkIfEnabledSession("rollback");
    if (!isTransactionStarted()) {
      IllegalStateException ex =
          new IllegalStateException(
              "Cannot rollback without an active transaction. Please set setAutoCommit to false to"
                  + " start a transaction.");
      LOG.severe(ex.getMessage(), ex);
      throw ex;
    }
    rollbackImpl();
  }

  private void rollbackImpl() throws SQLException {
    try {
      QueryJobConfiguration transactionRollbackJobConfig =
          QueryJobConfiguration.newBuilder("ROLLBACK TRANSACTION;")
              .setConnectionProperties(this.queryProperties)
              .build();
      Job rollbackJob = this.bigQuery.create(JobInfo.of(transactionRollbackJobConfig));
      rollbackJob.waitFor();
      this.transactionStarted = false;
      if (!getAutoCommit()) {
        beginTransaction();
      }
    } catch (InterruptedException | BigQueryException ex) {
      throw new BigQueryJdbcException("Failed to rollback transaction", ex);
    }
  }

  @Override
  public DatabaseMetaData getMetaData() throws SQLException {
    if (databaseMetaData == null) {
      databaseMetaData = new BigQueryDatabaseMetaData(this);
    }
    return databaseMetaData;
  }

  @Override
  public int getTransactionIsolation() {
    return Connection.TRANSACTION_SERIALIZABLE;
  }

  @Override
  public void setTransactionIsolation(int level) throws SQLException {
    if (level != Connection.TRANSACTION_SERIALIZABLE) {
      throw new BigQueryJdbcSqlFeatureNotSupportedException(
          "Unsupported transaction isolation level");
    }
    this.transactionIsolation = level;
  }

  @Override
  public int getHoldability() {
    return this.holdability;
  }

  @Override
  public void setHoldability(int holdability) throws SQLException {
    if (holdability != ResultSet.CLOSE_CURSORS_AT_COMMIT) {
      throw new BigQueryJdbcSqlFeatureNotSupportedException(
          "CLOSE_CURSORS_AT_COMMIT not supported");
    }
    this.holdability = holdability;
  }

  /**
   * Releases this {@code BigQueryConnection} object's BigQuery resources immediately instead of
   * waiting for them to be automatically released.
   *
   * @throws SQLException if a BigQuery access error occurs
   * @see Connection#close()
   */
  @Override
  public void close() throws SQLException {
    if (isClosed()) {
      return;
    }

    LOG.fine("Closing Connection " + this);
    closeImpl();
  }

  private void closeImpl() throws SQLException {
    SQLException exceptionToThrow = null;
    try {
      if (this.bigQueryReadClient != null) {
        this.bigQueryReadClient.shutdown();
      }
      if (this.bigQueryWriteClient != null) {
        this.bigQueryWriteClient.shutdown();
      }
      if (this.metadataExecutor != null) {
        this.metadataExecutor.shutdown();
      }
      if (this.queryExecutor != null) {
        this.queryExecutor.shutdown();
      }

      for (Statement statement : this.openStatements) {
        try {
          statement.close();
        } catch (SQLException e) {
          if (exceptionToThrow == null) {
            exceptionToThrow = e;
          } else {
            exceptionToThrow.addSuppressed(e);
          }
        }
      }
      this.openStatements.clear();

      if (isTransactionStarted()) {
        try {
          // It looks like there's no need to start a new transaction after a rollback,
          // but the commit behavior is preserved since close() may still fail before isClosed is
          // updated.
          rollbackImpl();
        } catch (SQLException e) {
          if (exceptionToThrow == null) {
            exceptionToThrow = e;
          } else {
            exceptionToThrow.addSuppressed(e);
          }
        }
      }

      boolean interrupted = Thread.currentThread().isInterrupted();

      try {
        if (this.bigQueryReadClient != null) {
          if (interrupted) {
            this.bigQueryReadClient.shutdownNow();
          } else {
            this.bigQueryReadClient.awaitTermination(1, TimeUnit.MINUTES);
          }
        }
        if (this.bigQueryWriteClient != null) {
          if (interrupted) {
            this.bigQueryWriteClient.shutdownNow();
          } else {
            this.bigQueryWriteClient.awaitTermination(1, TimeUnit.MINUTES);
          }
        }
        if (this.metadataExecutor != null) {
          if (interrupted || !this.metadataExecutor.awaitTermination(10, TimeUnit.SECONDS)) {
            this.metadataExecutor.shutdownNow();
          }
        }
        if (this.queryExecutor != null) {
          if (interrupted || !this.queryExecutor.awaitTermination(10, TimeUnit.SECONDS)) {
            this.queryExecutor.shutdownNow();
          }
        }
      } catch (InterruptedException e) {
        interrupted = true;
        if (this.bigQueryReadClient != null) {
          this.bigQueryReadClient.shutdownNow();
        }
        if (this.bigQueryWriteClient != null) {
          this.bigQueryWriteClient.shutdownNow();
        }
        if (this.metadataExecutor != null) {
          this.metadataExecutor.shutdownNow();
        }
        if (this.queryExecutor != null) {
          this.queryExecutor.shutdownNow();
        }
      } finally {
        try {
          if (this.bigQueryReadClient != null) {
            this.bigQueryReadClient.close();
          }
        } finally {
          if (this.bigQueryWriteClient != null) {
            this.bigQueryWriteClient.close();
          }
        }
      }

      if (interrupted) {
        Thread.currentThread().interrupt();
        throw new InterruptedException("Interrupted awaiting executor termination");
      }
    } catch (ConcurrentModificationException ex) {
      throw new BigQueryJdbcException("Concurrent modification during close", ex);
    } catch (InterruptedException e) {
      throw new BigQueryJdbcRuntimeException("Interrupted during close", e);
    } finally {
      BigQueryJdbcMdc.clear();
      BigQueryJdbcRootLogger.closeConnectionHandler(this.connectionId);
      BigQueryJdbcOpenTelemetry.unregisterConnection(this.connectionId);
      BigQueryJdbcOpenTelemetry.releaseSdk(this.openTelemetry);
      this.openTelemetry = null;
    }
    if (exceptionToThrow != null) {
      throw exceptionToThrow;
    }
    this.isClosed = true;
  }

  ExecutorService getExecutorService() {
    return this.queryExecutor;
  }

  ExecutorService getMetadataExecutor() {
    return this.metadataExecutor;
  }

  @Override
  public boolean isClosed() {
    return this.isClosed;
  }

  private void checkClosed() {
    if (isClosed()) {
      IllegalStateException ex =
          new IllegalStateException("This " + getClass().getName() + " has been closed");
      LOG.severe(ex.getMessage(), ex);
      throw ex;
    }
  }

  private void checkIfEnabledSession(String methodName) {
    if (!this.enableSession) {
      IllegalStateException ex =
          new IllegalStateException(
              String.format("Session needs to be enabled to use %s method.", methodName));
      LOG.severe(ex.getMessage(), ex);
      throw ex;
    }
  }

  private ConnectionProperty getSessionPropertyFromQueryProperties(
      Map<String, String> queryPropertiesMap) {
    LOG.finer("++enter++");
    if (queryPropertiesMap != null) {
      if (queryPropertiesMap.containsKey("session_id")) {
        return ConnectionProperty.newBuilder()
            .setKey("session_id")
            .setValue(queryPropertiesMap.get("session_id"))
            .build();
      }
    }
    return null;
  }

  private List<ConnectionProperty> convertMapToConnectionPropertiesList(
      Map<String, String> queryPropertiesMap) {
    LOG.finer("++enter++");
    List<ConnectionProperty> connectionProperties = new ArrayList<ConnectionProperty>();
    if (queryPropertiesMap != null) {
      for (Map.Entry<String, String> entry : queryPropertiesMap.entrySet()) {
        connectionProperties.add(
            ConnectionProperty.newBuilder()
                .setKey(entry.getKey())
                .setValue(entry.getValue())
                .build());
      }
    }
    return connectionProperties;
  }

  void removeStatement(Statement statement) {
    this.openStatements.remove(statement);
  }

  private OpenTelemetry getOpenTelemetryInstance() {

    String effectiveProjectId =
        (this.gcpTelemetryProjectId != null) ? this.gcpTelemetryProjectId : this.catalog;

    validateTraceConfiguration(
        this.enableGcpTraceExporter,
        this.gcpTelemetryCredentials != null
            ? this.gcpTelemetryCredentials
            : resolveEffectiveCredentials());

    OpenTelemetry openTelemetry =
        BigQueryJdbcOpenTelemetry.getOpenTelemetry(
            this.useGlobalOpenTelemetry,
            this.enableGcpTraceExporter,
            this.enableGcpLogExporter,
            this.customOpenTelemetry,
            this.gcpTelemetryCredentials,
            effectiveProjectId,
            this.credentials);

    boolean hasExternalOtel = this.customOpenTelemetry != null || this.useGlobalOpenTelemetry;
    Logging localLoggingClient = null;
    if (this.enableGcpLogExporter && !hasExternalOtel) {
      localLoggingClient =
          BigQueryJdbcOpenTelemetry.createLoggingClient(
              true, null, this.gcpTelemetryCredentials, effectiveProjectId, this.credentials);
    }

    if (this.enableGcpLogExporter || hasExternalOtel) {
      BigQueryJdbcOpenTelemetry.registerConnection(
          this.connectionId,
          openTelemetry,
          localLoggingClient,
          this.enableGcpLogExporter && !hasExternalOtel);
    }

    return openTelemetry;
  }

  private String resolveEffectiveCredentials() {
    if (this.gcpTelemetryCredentials != null) {
      return this.gcpTelemetryCredentials;
    }

    String authTypeStr = this.authProperties.get(BigQueryJdbcUrlUtility.OAUTH_TYPE_PROPERTY_NAME);
    if (!BigQueryJdbcOAuthUtility.AuthType.GOOGLE_SERVICE_ACCOUNT.name().equals(authTypeStr)) {
      return null;
    }

    String pvtKey = this.authProperties.get(BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PROPERTY_NAME);
    if (pvtKey != null) {
      return pvtKey;
    }

    return this.authProperties.get(BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PATH_PROPERTY_NAME);
  }

  private void validateTraceConfiguration(boolean isTraceEnabled, String effectiveCredentials) {
    if (isTraceEnabled && effectiveCredentials == null) {
      String authTypeStr = this.authProperties.get(BigQueryJdbcUrlUtility.OAUTH_TYPE_PROPERTY_NAME);
      if (!BigQueryJdbcOAuthUtility.AuthType.GOOGLE_SERVICE_ACCOUNT.name().equals(authTypeStr)
          && !BigQueryJdbcOAuthUtility.AuthType.APPLICATION_DEFAULT_CREDENTIALS
              .name()
              .equals(authTypeStr)) {
        throw new BigQueryJdbcRuntimeException(
            "Exporting traces to Google Cloud is only supported when using Application Default Credentials (ADC) or Service Account authentication.");
      }
    }
  }

  private BigQuery getBigQueryConnection() {
    BigQueryOptions.Builder bigQueryOptions = BigQueryOptions.newBuilder();
    if (this.retryTimeoutInSeconds > 0L
        || (this.retryInitialDelayInSeconds > 0L && this.retryMaxDelayInSeconds > 0L)) {
      RetrySettings.Builder retry_settings_builder = RetrySettings.newBuilder();
      if (this.retryTimeoutInSeconds > 0L) {
        retry_settings_builder.setTotalTimeoutDuration(this.retryTimeoutDuration);
      }
      if (this.retryInitialDelayInSeconds > 0L && this.retryMaxDelayInSeconds > 0L) {
        retry_settings_builder.setInitialRetryDelayDuration(retryInitialDelayDuration);
        retry_settings_builder.setMaxRetryDelayDuration(retryMaxDelayDuration);
      }
      bigQueryOptions.setRetrySettings(retry_settings_builder.build());
    }

    if (this.catalog != null) {
      bigQueryOptions.setProjectId(this.catalog);
    }
    if (this.credentials != null) {
      bigQueryOptions.setCredentials(this.credentials);
    }
    if (this.location != null) {
      bigQueryOptions.setLocation(this.location);
    }
    if (this.overrideProperties.containsKey(
        BigQueryJdbcUrlUtility.BIGQUERY_ENDPOINT_OVERRIDE_PROPERTY_NAME)) {
      bigQueryOptions.setHost(
          this.overrideProperties.get(
              BigQueryJdbcUrlUtility.BIGQUERY_ENDPOINT_OVERRIDE_PROPERTY_NAME));
    }
    if (this.universeDomain != null) {
      bigQueryOptions.setUniverseDomain(this.universeDomain);
    }
    if (this.httpTransportOptions != null) {
      bigQueryOptions.setTransportOptions(this.httpTransportOptions);
    }
    if (this.enableGcpTraceExporter
        || this.customOpenTelemetry != null
        || this.useGlobalOpenTelemetry) {
      Tracer sdkTracer = this.openTelemetry.getTracer(BigQueryJdbcOpenTelemetry.BIGQUERY_NAMESPACE);
      bigQueryOptions.setOpenTelemetryTracer(sdkTracer);
      bigQueryOptions.setEnableOpenTelemetryTracing(true);
      this.tracer =
          this.openTelemetry.getTracer(BigQueryJdbcOpenTelemetry.INSTRUMENTATION_SCOPE_NAME);
    }

    BigQueryOptions options = bigQueryOptions.setHeaderProvider(this.headerProvider).build();
    options.setDefaultJobCreationMode(
        this.useStatelessQueryMode
            ? JobCreationMode.JOB_CREATION_OPTIONAL
            : JobCreationMode.JOB_CREATION_REQUIRED);

    return options.getService();
  }

  private BigQueryReadClient getBigQueryReadClientConnection() throws IOException {
    BigQueryReadSettings.Builder bigQueryReadSettings =
        BigQueryReadSettings.newBuilder().setHeaderProvider(this.headerProvider);
    if (getRetrySettings() != null) {
      bigQueryReadSettings.createReadSessionSettings().setRetrySettings(getRetrySettings());
    }
    if (this.catalog != null) {
      bigQueryReadSettings.setQuotaProjectId(this.catalog);
    }
    if (this.credentials != null) {
      CredentialsProvider fixedProvider = FixedCredentialsProvider.create(credentials);
      bigQueryReadSettings.setCredentialsProvider(fixedProvider);
    }
    if (this.overrideProperties.containsKey(
        BigQueryJdbcUrlUtility.HTAPI_ENDPOINT_OVERRIDE_PROPERTY_NAME)) {
      bigQueryReadSettings.setEndpoint(
          this.overrideProperties.get(
              BigQueryJdbcUrlUtility.HTAPI_ENDPOINT_OVERRIDE_PROPERTY_NAME));
    }
    if (this.universeDomain != null) {
      bigQueryReadSettings.setUniverseDomain(this.universeDomain);
    }
    TransportChannelProvider activeProvider = this.transportChannelProvider;
    if (activeProvider == null) {
      InstantiatingGrpcChannelProvider.Builder builder =
          BigQueryReadSettings.defaultGrpcTransportProviderBuilder();
      if (this.enableGcpTraceExporter
          || this.customOpenTelemetry != null
          || this.useGlobalOpenTelemetry) {
        GrpcOpenTelemetry grpcOpenTelemetry =
            GrpcOpenTelemetry.newBuilder().sdk(this.openTelemetry).build();
        builder.setChannelConfigurator(
            b -> {
              grpcOpenTelemetry.configureChannelBuilder((ManagedChannelBuilder) b);
              return b;
            });
      }
      activeProvider = builder.build();
    }

    if (activeProvider instanceof InstantiatingGrpcChannelProvider) {
      activeProvider =
          ((InstantiatingGrpcChannelProvider) activeProvider)
              .toBuilder()
                  .setKeepAliveTimeDuration(java.time.Duration.ofSeconds(10))
                  .setKeepAliveTimeoutDuration(java.time.Duration.ofSeconds(5))
                  .setKeepAliveWithoutCalls(true)
                  .build();
    }

    bigQueryReadSettings.setTransportChannelProvider(activeProvider);

    if (this.enableGcpTraceExporter
        || this.customOpenTelemetry != null
        || this.useGlobalOpenTelemetry) {
      bigQueryReadSettings.setOpenTelemetryTracerProvider(this.openTelemetry.getTracerProvider());
      bigQueryReadSettings.setEnableOpenTelemetryTracing(true);
    }

    return BigQueryReadClient.create(bigQueryReadSettings.build());
  }

  private BigQueryWriteClient getBigQueryWriteClientConnection() throws IOException {
    BigQueryWriteSettings.Builder bigQueryWriteSettings =
        BigQueryWriteSettings.newBuilder().setHeaderProvider(this.headerProvider);
    if (getRetrySettings() != null) {
      bigQueryWriteSettings.createWriteStreamSettings().setRetrySettings(getRetrySettings());
    }
    if (this.catalog != null) {
      bigQueryWriteSettings.setQuotaProjectId(this.catalog);
    }
    if (this.credentials != null) {
      CredentialsProvider fixedProvider = FixedCredentialsProvider.create(credentials);
      bigQueryWriteSettings.setCredentialsProvider(fixedProvider);
    }
    // Same endpoint as READ API
    if (this.overrideProperties.containsKey(
        BigQueryJdbcUrlUtility.HTAPI_ENDPOINT_OVERRIDE_PROPERTY_NAME)) {
      bigQueryWriteSettings.setEndpoint(
          this.overrideProperties.get(
              BigQueryJdbcUrlUtility.HTAPI_ENDPOINT_OVERRIDE_PROPERTY_NAME));
    }
    if (this.universeDomain != null) {
      bigQueryWriteSettings.setUniverseDomain(this.universeDomain);
    }
    if (this.transportChannelProvider != null) {
      bigQueryWriteSettings.setTransportChannelProvider(this.transportChannelProvider);
    }

    return BigQueryWriteClient.create(bigQueryWriteSettings.build());
  }

  RetrySettings getRetrySettings() {
    RetrySettings.Builder retrySettingsBuilder = null;

    if (this.retryTimeoutInSeconds > 0L
        || (this.retryInitialDelayInSeconds > 0L && this.retryMaxDelayInSeconds > 0L)) {
      retrySettingsBuilder = RetrySettings.newBuilder();
      if (this.retryTimeoutInSeconds > 0L) {
        retrySettingsBuilder.setTotalTimeoutDuration(this.retryTimeoutDuration);
      }
      if (this.retryInitialDelayInSeconds > 0L && this.retryMaxDelayInSeconds > 0L) {
        retrySettingsBuilder.setInitialRetryDelayDuration(retryInitialDelayDuration);
        retrySettingsBuilder.setMaxRetryDelayDuration(retryMaxDelayDuration);
      }
    }
    return retrySettingsBuilder == null ? null : retrySettingsBuilder.build();
  }

  private void commitTransaction() {
    try {
      QueryJobConfiguration transactionCommitJobConfig =
          QueryJobConfiguration.newBuilder("COMMIT TRANSACTION;")
              .setConnectionProperties(this.queryProperties)
              .build();
      Job commitJob = this.bigQuery.create(JobInfo.of(transactionCommitJobConfig));
      commitJob.waitFor();
      this.transactionStarted = false;
    } catch (InterruptedException ex) {
      throw new BigQueryJdbcRuntimeException("Interrupted during commitTransaction", ex);
    }
  }

  @Override
  public CallableStatement prepareCall(String sql) throws SQLException {
    checkClosed();
    CallableStatement currentStatement = new BigQueryCallableStatement(this, sql);
    LOG.fine("Callable Statement %s created.", currentStatement);
    addOpenStatements(currentStatement);
    return currentStatement;
  }

  @Override
  public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency)
      throws SQLException {
    checkClosed();
    if (resultSetType != ResultSet.TYPE_FORWARD_ONLY
        || resultSetConcurrency != ResultSet.CONCUR_READ_ONLY) {
      throw new BigQueryJdbcSqlFeatureNotSupportedException(
          "Unsupported CallableStatement feature");
    }
    return prepareCall(sql);
  }

  @Override
  public CallableStatement prepareCall(
      String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability)
      throws SQLException {
    checkClosed();
    if (resultSetType != ResultSet.TYPE_FORWARD_ONLY
        || resultSetConcurrency != ResultSet.CONCUR_READ_ONLY
        || resultSetHoldability != ResultSet.CLOSE_CURSORS_AT_COMMIT) {
      throw new BigQueryJdbcSqlFeatureNotSupportedException(
          "Unsupported CallableStatement feature");
    }
    return prepareCall(sql);
  }

  public Tracer getTracer() {
    return this.tracer;
  }

  public Context getOtelContext() {
    return this.otelContext;
  }

  public String getPartnerToken() {
    return this.partnerToken;
  }

  public boolean isReadOnlyTokenUsed() {
    return this.isReadOnlyTokenUsed;
  }

  private boolean checkIsReadOnlyTokenUsed(Map<String, String> authProps) {
    String readonlyValue =
        authProps.get(BigQueryJdbcUrlUtility.OAUTH_ACCESS_TOKEN_READONLY_PROPERTY_NAME);
    if (readonlyValue != null) {
      return BigQueryJdbcUrlUtility.convertIntToBoolean(
          readonlyValue, BigQueryJdbcUrlUtility.OAUTH_ACCESS_TOKEN_READONLY_PROPERTY_NAME);
    }
    return false;
  }

  public boolean isEnableProjectDiscovery() {
    return this.enableProjectDiscovery;
  }

  public synchronized List<String> getDiscoveredProjects() throws SQLException {
    if (this.discoveredProjectsCache != null) {
      return this.discoveredProjectsCache;
    }

    try {
      BigQuery bigQuery = getBigQuery();
      List<String> projects = new ArrayList<>();
      Page<Project> projectPage = bigQuery.listProjects();
      for (Project project : projectPage.iterateAll()) {
        projects.add(project.getProjectId());
      }
      this.discoveredProjectsCache = ImmutableList.copyOf(projects);
    } catch (Exception e) {
      throw new BigQueryJdbcException("Failed to list all accessible projects.", e);
    }
    return this.discoveredProjectsCache;
  }

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
