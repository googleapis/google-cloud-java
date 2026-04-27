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

import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
import java.util.function.BiConsumer;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * BigQuery JDBC implementation of {@link javax.sql.DataSource}
 *
 * <p>A factory for connections to the physical data source that this DataSource object represents.
 * An alternative to the DriverManager facility, a DataSource object is the preferred means of
 * getting a connection. An object that implements the DataSource interface will typically be
 * registered with a naming service based on the Java™ Naming and Directory (JNDI) API.
 */
public class DataSource implements javax.sql.DataSource {
  private final BigQueryJdbcCustomLogger LOG = new BigQueryJdbcCustomLogger(this.toString());
  private String URL;
  static final ImmutableSet<Integer> VALID_JOB_CREATION_MODES = ImmutableSet.of(1, 2);

  private String projectId;
  private String defaultDataset;
  private String location;
  private String userAgent;
  private Boolean enableHighThroughputAPI;
  private Integer highThroughputMinTableSize;
  private Integer highThroughputActivationRatio;
  private Boolean unsupportedHTAPIFallback;
  private String kmsKeyName;
  private Map<String, String> queryProperties;
  private String logLevel;
  private Boolean enableSession;
  private String logPath;
  private Integer oAuthType;
  private String oAuthServiceAcctEmail;
  private String oAuthPvtKeyPath;
  private String oAuthPvtKey;
  private String oAuthAccessToken;
  private String oAuthRefreshToken;
  private Boolean useQueryCache;
  private String queryDialect;
  private Boolean allowLargeResults;
  private String destinationTable;
  private String destinationDataset;
  private Long destinationDatasetExpirationTime;
  private String universeDomain;
  private String proxyHost;
  private String proxyPort;
  private String proxyUid;
  private String proxyPwd;
  private String oAuthClientId;
  private String oAuthClientSecret;
  private Integer jobCreationMode;
  private Long maxResults;
  private String partnerToken;
  private Boolean enableWriteAPI;
  private String additionalProjects;
  private Boolean filterTablesOnDefaultDataset;
  private Integer requestGoogleDriveScope;
  private Integer metadataFetchThreadCount;
  private String sslTrustStorePath;
  private String sslTrustStorePassword;
  private Map<String, String> labels;
  private String requestReason;
  private Integer timeout;
  private Integer jobTimeout;
  private Integer retryInitialDelay;
  private Integer retryMaxDelay;
  private Integer httpConnectTimeout;
  private Integer httpReadTimeout;
  private Long maximumBytesBilled;
  private Integer swaActivationRowCount;
  private Integer swaAppendRowCount;
  private String oAuthP12Password;
  private String oAuthSAImpersonationEmail;
  private String oAuthSAImpersonationChain;
  private String oAuthSAImpersonationScopes;
  private String oAuthSAImpersonationTokenLifetime;
  private String oAuth2TokenUri;
  private String byoidAudienceUri;
  private String byoidCredentialSource;
  private String byoidPoolUserProject;
  private String byoidSAImpersonationUri;
  private String byoidSubjectTokenType;
  private String byoidTokenUri;
  private String endpointOverrides;
  private String privateServiceConnect;
  private Long connectionPoolSize;
  private Long listenerPoolSize;

  // Make sure the JDBC driver class is loaded.
  static {
    try {
      Class.forName("com.google.cloud.bigquery.jdbc.BigQueryDriver");
    } catch (ClassNotFoundException ex) {
      throw new IllegalStateException(
          "DataSource failed to load com.google.cloud.bigquery.jdbc.BigQueryDriver", ex);
    }
  }

  private static final Map<String, BiConsumer<DataSource, String>> PROPERTY_SETTERS =
      ImmutableMap.<String, BiConsumer<DataSource, String>>builder()
          .put(BigQueryJdbcUrlUtility.PROJECT_ID_PROPERTY_NAME, DataSource::setProjectId)
          .put(BigQueryJdbcUrlUtility.DEFAULT_DATASET_PROPERTY_NAME, DataSource::setDefaultDataset)
          .put(BigQueryJdbcUrlUtility.LOCATION_PROPERTY_NAME, DataSource::setLocation)
          .put(
              BigQueryJdbcUrlUtility.ENABLE_HTAPI_PROPERTY_NAME,
              (ds, val) ->
                  ds.setEnableHighThroughputAPI(
                      BigQueryJdbcUrlUtility.convertIntToBoolean(
                          val, BigQueryJdbcUrlUtility.ENABLE_HTAPI_PROPERTY_NAME)))
          .put(
              BigQueryJdbcUrlUtility.UNSUPPORTED_HTAPI_FALLBACK_PROPERTY_NAME,
              (ds, val) ->
                  ds.setUnsupportedHTAPIFallback(
                      BigQueryJdbcUrlUtility.convertIntToBoolean(
                          val, BigQueryJdbcUrlUtility.UNSUPPORTED_HTAPI_FALLBACK_PROPERTY_NAME)))
          .put(
              BigQueryJdbcUrlUtility.HTAPI_MIN_TABLE_SIZE_PROPERTY_NAME,
              (ds, val) -> ds.setHighThroughputMinTableSize(Integer.parseInt(val)))
          .put(
              BigQueryJdbcUrlUtility.HTAPI_ACTIVATION_RATIO_PROPERTY_NAME,
              (ds, val) -> ds.setHighThroughputActivationRatio(Integer.parseInt(val)))
          .put(BigQueryJdbcUrlUtility.KMS_KEY_NAME_PROPERTY_NAME, DataSource::setKmsKeyName)
          .put(
              BigQueryJdbcUrlUtility.QUERY_PROPERTIES_NAME,
              (ds, val) ->
                  ds.setQueryProperties(
                      BigQueryJdbcUrlUtility.parsePropertiesMapFromValue(
                          val, BigQueryJdbcUrlUtility.QUERY_PROPERTIES_NAME, "DataSource")))
          .put(
              BigQueryJdbcUrlUtility.ENABLE_SESSION_PROPERTY_NAME,
              (ds, val) ->
                  ds.setEnableSession(
                      BigQueryJdbcUrlUtility.convertIntToBoolean(
                          val, BigQueryJdbcUrlUtility.ENABLE_SESSION_PROPERTY_NAME)))
          .put(BigQueryJdbcUrlUtility.LOG_LEVEL_PROPERTY_NAME, DataSource::setLogLevel)
          .put(BigQueryJdbcUrlUtility.LOG_PATH_PROPERTY_NAME, DataSource::setLogPath)
          .put(
              BigQueryJdbcUrlUtility.OAUTH_TYPE_PROPERTY_NAME,
              (ds, val) -> ds.setOAuthType(Integer.parseInt(val)))
          .put(
              BigQueryJdbcUrlUtility.OAUTH_SA_EMAIL_PROPERTY_NAME,
              DataSource::setOAuthServiceAcctEmail)
          .put(
              BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PATH_PROPERTY_NAME,
              DataSource::setOAuthPvtKeyPath)
          .put(BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PROPERTY_NAME, DataSource::setOAuthPvtKey)
          .put(
              BigQueryJdbcUrlUtility.OAUTH_ACCESS_TOKEN_PROPERTY_NAME,
              DataSource::setOAuthAccessToken)
          .put(
              BigQueryJdbcUrlUtility.OAUTH_REFRESH_TOKEN_PROPERTY_NAME,
              DataSource::setOAuthRefreshToken)
          .put(
              BigQueryJdbcUrlUtility.USE_QUERY_CACHE_PROPERTY_NAME,
              (ds, val) ->
                  ds.setUseQueryCache(
                      BigQueryJdbcUrlUtility.convertIntToBoolean(
                          val, BigQueryJdbcUrlUtility.USE_QUERY_CACHE_PROPERTY_NAME)))
          .put(BigQueryJdbcUrlUtility.QUERY_DIALECT_PROPERTY_NAME, DataSource::setQueryDialect)
          .put(
              BigQueryJdbcUrlUtility.ALLOW_LARGE_RESULTS_PROPERTY_NAME,
              (ds, val) ->
                  ds.setAllowLargeResults(
                      BigQueryJdbcUrlUtility.convertIntToBoolean(
                          val, BigQueryJdbcUrlUtility.ALLOW_LARGE_RESULTS_PROPERTY_NAME)))
          .put(
              BigQueryJdbcUrlUtility.LARGE_RESULTS_TABLE_PROPERTY_NAME,
              DataSource::setDestinationTable)
          .put(
              BigQueryJdbcUrlUtility.LARGE_RESULTS_DATASET_PROPERTY_NAME,
              DataSource::setDestinationDataset)
          .put(
              BigQueryJdbcUrlUtility.DESTINATION_DATASET_EXPIRATION_TIME_PROPERTY_NAME,
              (ds, val) -> ds.setDestinationDatasetExpirationTime(Long.parseLong(val)))
          .put(
              BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME,
              DataSource::setUniverseDomain)
          .put(BigQueryJdbcUrlUtility.PROXY_HOST_PROPERTY_NAME, DataSource::setProxyHost)
          .put(BigQueryJdbcUrlUtility.PROXY_PORT_PROPERTY_NAME, DataSource::setProxyPort)
          .put(BigQueryJdbcUrlUtility.PROXY_USER_ID_PROPERTY_NAME, DataSource::setProxyUid)
          .put(BigQueryJdbcUrlUtility.PROXY_PASSWORD_PROPERTY_NAME, DataSource::setProxyPwd)
          .put(BigQueryJdbcUrlUtility.OAUTH_CLIENT_ID_PROPERTY_NAME, DataSource::setOAuthClientId)
          .put(
              BigQueryJdbcUrlUtility.OAUTH_CLIENT_SECRET_PROPERTY_NAME,
              DataSource::setOAuthClientSecret)
          .put(
              BigQueryJdbcUrlUtility.JOB_CREATION_MODE_PROPERTY_NAME,
              (ds, val) -> ds.setJobCreationMode(Integer.parseInt(val)))
          .put(
              BigQueryJdbcUrlUtility.MAX_RESULTS_PROPERTY_NAME,
              (ds, val) -> ds.setMaxResults(Long.parseLong(val)))
          .put(BigQueryJdbcUrlUtility.PARTNER_TOKEN_PROPERTY_NAME, DataSource::setPartnerToken)
          .put(
              BigQueryJdbcUrlUtility.ENABLE_WRITE_API_PROPERTY_NAME,
              (ds, val) ->
                  ds.setEnableWriteAPI(
                      BigQueryJdbcUrlUtility.convertIntToBoolean(
                          val, BigQueryJdbcUrlUtility.ENABLE_WRITE_API_PROPERTY_NAME)))
          .put(
              BigQueryJdbcUrlUtility.ADDITIONAL_PROJECTS_PROPERTY_NAME,
              DataSource::setAdditionalProjects)
          .put(
              BigQueryJdbcUrlUtility.FILTER_TABLES_ON_DEFAULT_DATASET_PROPERTY_NAME,
              (ds, val) ->
                  ds.setFilterTablesOnDefaultDataset(
                      BigQueryJdbcUrlUtility.convertIntToBoolean(
                          val,
                          BigQueryJdbcUrlUtility.FILTER_TABLES_ON_DEFAULT_DATASET_PROPERTY_NAME)))
          .put(
              BigQueryJdbcUrlUtility.REQUEST_GOOGLE_DRIVE_SCOPE_PROPERTY_NAME,
              (ds, val) -> ds.setRequestGoogleDriveScope(Integer.parseInt(val)))
          .put(
              BigQueryJdbcUrlUtility.METADATA_FETCH_THREAD_COUNT_PROPERTY_NAME,
              (ds, val) -> ds.setMetadataFetchThreadCount(Integer.parseInt(val)))
          .put(
              BigQueryJdbcUrlUtility.SSL_TRUST_STORE_PROPERTY_NAME,
              DataSource::setSSLTrustStorePath)
          .put(
              BigQueryJdbcUrlUtility.SSL_TRUST_STORE_PWD_PROPERTY_NAME,
              DataSource::setSSLTrustStorePassword)
          .put(
              BigQueryJdbcUrlUtility.LABELS_PROPERTY_NAME,
              (ds, val) ->
                  ds.setLabels(
                      BigQueryJdbcUrlUtility.parsePropertiesMapFromValue(
                          val, BigQueryJdbcUrlUtility.LABELS_PROPERTY_NAME, "DataSource")))
          .put(BigQueryJdbcUrlUtility.REQUEST_REASON_PROPERTY_NAME, DataSource::setRequestReason)
          .put(
              BigQueryJdbcUrlUtility.RETRY_TIMEOUT_IN_SECS_PROPERTY_NAME,
              (ds, val) -> ds.setTimeout(Integer.parseInt(val)))
          .put(
              BigQueryJdbcUrlUtility.JOB_TIMEOUT_PROPERTY_NAME,
              (ds, val) -> ds.setJobTimeout(Integer.valueOf(val)))
          .put(
              BigQueryJdbcUrlUtility.RETRY_INITIAL_DELAY_PROPERTY_NAME,
              (ds, val) -> ds.setRetryInitialDelay(Integer.valueOf(val)))
          .put(
              BigQueryJdbcUrlUtility.RETRY_MAX_DELAY_PROPERTY_NAME,
              (ds, val) -> ds.setRetryMaxDelay(Integer.valueOf(val)))
          .put(
              BigQueryJdbcUrlUtility.HTTP_CONNECT_TIMEOUT_PROPERTY_NAME,
              (ds, val) -> ds.setHttpConnectTimeout(Integer.parseInt(val)))
          .put(
              BigQueryJdbcUrlUtility.HTTP_READ_TIMEOUT_PROPERTY_NAME,
              (ds, val) -> ds.setHttpReadTimeout(Integer.parseInt(val)))
          .put(
              BigQueryJdbcUrlUtility.OAUTH_P12_PASSWORD_PROPERTY_NAME,
              DataSource::setOAuthP12Password)
          .put(
              BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_EMAIL_PROPERTY_NAME,
              DataSource::setOAuthSAImpersonationEmail)
          .put(
              BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_CHAIN_PROPERTY_NAME,
              DataSource::setOAuthSAImpersonationChain)
          .put(
              BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_SCOPES_PROPERTY_NAME,
              DataSource::setOAuthSAImpersonationScopes)
          .put(
              BigQueryJdbcUrlUtility.OAUTH_SA_IMPERSONATION_TOKEN_LIFETIME_PROPERTY_NAME,
              DataSource::setOAuthSAImpersonationTokenLifetime)
          .put(BigQueryJdbcUrlUtility.OAUTH2_TOKEN_URI_PROPERTY_NAME, DataSource::setOAuth2TokenUri)
          .put(
              BigQueryJdbcUrlUtility.BYOID_AUDIENCE_URI_PROPERTY_NAME,
              DataSource::setByoidAudienceUri)
          .put(
              BigQueryJdbcUrlUtility.BYOID_CREDENTIAL_SOURCE_PROPERTY_NAME,
              DataSource::setByoidCredentialSource)
          .put(
              BigQueryJdbcUrlUtility.BYOID_POOL_USER_PROJECT_PROPERTY_NAME,
              DataSource::setByoidPoolUserProject)
          .put(
              BigQueryJdbcUrlUtility.BYOID_SA_IMPERSONATION_URI_PROPERTY_NAME,
              DataSource::setByoidSAImpersonationUri)
          .put(
              BigQueryJdbcUrlUtility.BYOID_SUBJECT_TOKEN_TYPE_PROPERTY_NAME,
              DataSource::setByoidSubjectTokenType)
          .put(BigQueryJdbcUrlUtility.BYOID_TOKEN_URI_PROPERTY_NAME, DataSource::setByoidTokenUri)
          .put(
              BigQueryJdbcUrlUtility.ENDPOINT_OVERRIDES_PROPERTY_NAME,
              DataSource::setEndpointOverrides)
          .put(
              BigQueryJdbcUrlUtility.PRIVATE_SERVICE_CONNECT_PROPERTY_NAME,
              DataSource::setPrivateServiceConnect)
          .put(
              BigQueryJdbcUrlUtility.MAX_BYTES_BILLED_PROPERTY_NAME,
              (ds, val) -> ds.setMaximumBytesBilled(Long.parseLong(val)))
          .put(
              BigQueryJdbcUrlUtility.SWA_ACTIVATION_ROW_COUNT_PROPERTY_NAME,
              (ds, val) -> ds.setSwaActivationRowCount(Integer.parseInt(val)))
          .put(
              BigQueryJdbcUrlUtility.SWA_APPEND_ROW_COUNT_PROPERTY_NAME,
              (ds, val) -> ds.setSwaAppendRowCount(Integer.parseInt(val)))
          .put(
              BigQueryJdbcUrlUtility.CONNECTION_POOL_SIZE_PROPERTY_NAME,
              (ds, val) -> ds.setConnectionPoolSize(Long.parseLong(val)))
          .put(
              BigQueryJdbcUrlUtility.LISTENER_POOL_SIZE_PROPERTY_NAME,
              (ds, val) -> ds.setListenerPoolSize(Long.parseLong(val)))
          .build();

  public static DataSource fromUrl(String url) {
    DataSource dataSource = new DataSource();
    dataSource.setURL(url);
    Map<String, String> properties = BigQueryJdbcUrlUtility.parseUrl(url);
    for (Map.Entry<String, String> entry : properties.entrySet()) {
      BiConsumer<DataSource, String> setter = PROPERTY_SETTERS.get(entry.getKey());
      if (setter != null) {
        setter.accept(dataSource, entry.getValue());
      }
    }
    return dataSource;
  }

  public Map<String, String> getOverrideProperties() {
    String overridePropertiesString = null;
    if (endpointOverrides != null && !endpointOverrides.isEmpty()) {
      overridePropertiesString = endpointOverrides;
    } else if (privateServiceConnect != null && !privateServiceConnect.isEmpty()) {
      overridePropertiesString = privateServiceConnect;
    }

    Map<String, String> overrideProps = new java.util.HashMap<>();
    if (overridePropertiesString == null || overridePropertiesString.isEmpty()) {
      return overrideProps;
    }

    for (String property : BigQueryJdbcUrlUtility.OVERRIDE_PROPERTIES) {
      Pattern propertyPattern = Pattern.compile(String.format("(?i)%s=(.*?)(?:[,;]|$)", property));
      Matcher propertyMatcher = propertyPattern.matcher(overridePropertiesString);
      if (propertyMatcher.find() && propertyMatcher.groupCount() >= 1) {
        overrideProps.put(property, propertyMatcher.group(1));
      }
    }
    return overrideProps;
  }

  /** An implementation of DataSource must include a public no-arg constructor. */
  public DataSource() {}

  @Override
  public Connection getConnection() throws SQLException {
    if (getURL() == null) {
      throw new BigQueryJdbcException(
          "Connection URL is null. Please specify a valid Connection URL to get Connection.");
    }
    if (!BigQueryDriver.getRegisteredDriver().acceptsURL(getURL())) {
      throw new BigQueryJdbcException(
          "The URL " + getURL() + " is invalid. Please specify a valid Connection URL. ");
    }
    return DriverManager.getConnection(getURL(), createProperties());
  }

  private Properties createProperties() {
    Properties connectionProperties = new Properties();
    if (this.projectId != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.PROJECT_ID_PROPERTY_NAME, this.projectId);
    }
    if (this.defaultDataset != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.DEFAULT_DATASET_PROPERTY_NAME, this.defaultDataset);
    }
    if (this.location != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.LOCATION_PROPERTY_NAME, this.location);
    }
    if (this.enableHighThroughputAPI != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.ENABLE_HTAPI_PROPERTY_NAME,
          String.valueOf(this.enableHighThroughputAPI));
    }
    if (this.unsupportedHTAPIFallback != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.UNSUPPORTED_HTAPI_FALLBACK_PROPERTY_NAME,
          String.valueOf(this.unsupportedHTAPIFallback));
    }
    if (this.highThroughputMinTableSize != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.HTAPI_MIN_TABLE_SIZE_PROPERTY_NAME,
          String.valueOf(this.highThroughputMinTableSize));
    }
    if (this.highThroughputActivationRatio != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.HTAPI_ACTIVATION_RATIO_PROPERTY_NAME,
          String.valueOf(this.highThroughputActivationRatio));
    }
    if (this.kmsKeyName != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.KMS_KEY_NAME_PROPERTY_NAME, this.kmsKeyName);
    }
    if (this.queryProperties != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.QUERY_PROPERTIES_NAME, serializeMap(this.queryProperties));
    }
    if (this.enableSession != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.ENABLE_SESSION_PROPERTY_NAME, String.valueOf(this.enableSession));
    }
    if (this.logLevel != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.LOG_LEVEL_PROPERTY_NAME, this.logLevel);
    }
    if (this.logPath != null) {
      connectionProperties.setProperty(BigQueryJdbcUrlUtility.LOG_PATH_PROPERTY_NAME, this.logPath);
    }
    if (this.oAuthType != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.OAUTH_TYPE_PROPERTY_NAME, String.valueOf(this.oAuthType));
    }
    if (this.oAuthServiceAcctEmail != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.OAUTH_SA_EMAIL_PROPERTY_NAME, this.oAuthServiceAcctEmail);
    }
    if (this.oAuthPvtKeyPath != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PATH_PROPERTY_NAME, this.oAuthPvtKeyPath);
    }
    if (this.oAuthPvtKey != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.OAUTH_PVT_KEY_PROPERTY_NAME, this.oAuthPvtKey);
    }
    if (this.oAuthAccessToken != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.OAUTH_ACCESS_TOKEN_PROPERTY_NAME, this.oAuthAccessToken);
    }
    if (this.oAuthRefreshToken != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.OAUTH_REFRESH_TOKEN_PROPERTY_NAME, this.oAuthRefreshToken);
    }
    if (this.useQueryCache != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.USE_QUERY_CACHE_PROPERTY_NAME, String.valueOf(this.useQueryCache));
    }
    if (this.queryDialect != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.QUERY_DIALECT_PROPERTY_NAME, this.queryDialect);
    }
    if (this.allowLargeResults != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.ALLOW_LARGE_RESULTS_PROPERTY_NAME,
          String.valueOf(this.allowLargeResults));
    }
    if (this.destinationTable != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.LARGE_RESULTS_TABLE_PROPERTY_NAME, this.destinationTable);
    }
    if (this.destinationDataset != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.LARGE_RESULTS_DATASET_PROPERTY_NAME, this.destinationDataset);
    }
    if (this.destinationDatasetExpirationTime != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.DESTINATION_DATASET_EXPIRATION_TIME_PROPERTY_NAME,
          String.valueOf(this.destinationDatasetExpirationTime));
    }
    if (this.universeDomain != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME, this.universeDomain);
    }
    if (this.proxyHost != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.PROXY_HOST_PROPERTY_NAME, this.proxyHost);
    }
    if (this.proxyPort != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.PROXY_PORT_PROPERTY_NAME, this.proxyPort);
    }
    if (this.proxyUid != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.PROXY_USER_ID_PROPERTY_NAME, this.proxyUid);
    }
    if (this.proxyPwd != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.PROXY_PASSWORD_PROPERTY_NAME, this.proxyPwd);
    }
    if (this.oAuthClientId != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.OAUTH_CLIENT_ID_PROPERTY_NAME, this.oAuthClientId);
    }
    if (this.oAuthClientSecret != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.OAUTH_CLIENT_SECRET_PROPERTY_NAME, this.oAuthClientSecret);
    }
    if (this.jobCreationMode != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.JOB_CREATION_MODE_PROPERTY_NAME,
          String.valueOf(this.jobCreationMode));
    }
    if (this.maxResults != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.MAX_RESULTS_PROPERTY_NAME, String.valueOf(this.maxResults));
    }
    if (this.partnerToken != null && !this.partnerToken.isEmpty()) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.PARTNER_TOKEN_PROPERTY_NAME, this.partnerToken);
    }
    if (this.enableWriteAPI != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.ENABLE_WRITE_API_PROPERTY_NAME,
          String.valueOf(this.enableWriteAPI));
    }
    if (this.additionalProjects != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.ADDITIONAL_PROJECTS_PROPERTY_NAME, this.additionalProjects);
    }
    if (this.filterTablesOnDefaultDataset != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.FILTER_TABLES_ON_DEFAULT_DATASET_PROPERTY_NAME,
          String.valueOf(this.filterTablesOnDefaultDataset));
    }
    if (this.requestGoogleDriveScope != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.REQUEST_GOOGLE_DRIVE_SCOPE_PROPERTY_NAME,
          String.valueOf(this.requestGoogleDriveScope));
    }
    if (this.metadataFetchThreadCount != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.METADATA_FETCH_THREAD_COUNT_PROPERTY_NAME,
          String.valueOf(this.metadataFetchThreadCount));
    }
    if (this.sslTrustStorePath != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.SSL_TRUST_STORE_PROPERTY_NAME,
          String.valueOf(this.sslTrustStorePath));
    }
    if (this.sslTrustStorePassword != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.SSL_TRUST_STORE_PWD_PROPERTY_NAME,
          String.valueOf(this.sslTrustStorePassword));
    }
    if (this.labels != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.LABELS_PROPERTY_NAME, serializeMap(this.labels));
    }
    if (this.requestReason != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.REQUEST_REASON_PROPERTY_NAME, this.requestReason);
    }
    if (this.timeout != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.RETRY_TIMEOUT_IN_SECS_PROPERTY_NAME, String.valueOf(this.timeout));
    }
    if (this.jobTimeout != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.JOB_TIMEOUT_PROPERTY_NAME, String.valueOf(this.jobTimeout));
    }
    if (this.retryInitialDelay != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.RETRY_INITIAL_DELAY_PROPERTY_NAME,
          String.valueOf(this.retryInitialDelay));
    }
    if (this.retryMaxDelay != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.RETRY_MAX_DELAY_PROPERTY_NAME, String.valueOf(this.retryMaxDelay));
    }
    if (this.httpConnectTimeout != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.HTTP_CONNECT_TIMEOUT_PROPERTY_NAME,
          String.valueOf(this.httpConnectTimeout));
    }
    if (this.httpReadTimeout != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.HTTP_READ_TIMEOUT_PROPERTY_NAME,
          String.valueOf(this.httpReadTimeout));
    }
    if (this.maximumBytesBilled != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.MAX_BYTES_BILLED_PROPERTY_NAME,
          String.valueOf(this.maximumBytesBilled));
    }
    if (this.swaActivationRowCount != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.SWA_ACTIVATION_ROW_COUNT_PROPERTY_NAME,
          String.valueOf(this.swaActivationRowCount));
    }
    if (this.swaAppendRowCount != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.SWA_APPEND_ROW_COUNT_PROPERTY_NAME,
          String.valueOf(this.swaAppendRowCount));
    }
    if (this.connectionPoolSize != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.CONNECTION_POOL_SIZE_PROPERTY_NAME,
          String.valueOf(this.connectionPoolSize));
    }
    if (this.listenerPoolSize != null) {
      connectionProperties.setProperty(
          BigQueryJdbcUrlUtility.LISTENER_POOL_SIZE_PROPERTY_NAME,
          String.valueOf(this.listenerPoolSize));
    }
    return connectionProperties;
  }

  private String serializeMap(Map<String, String> map) {
    if (map == null || map.isEmpty()) {
      return "";
    }
    return Joiner.on(",").withKeyValueSeparator("=").join(map);
  }

  @Override
  public Connection getConnection(String username, String password) throws SQLException {
    LOG.warning(
        "Username and Password is not supported in Bigquery JDBC Driver. Values discarded.");
    return getConnection();
  }

  public String getURL() {
    return URL;
  }

  public void setURL(String URL) {
    this.URL = URL;
  }

  public String getProjectId() {
    return projectId != null
        ? projectId
        : com.google.cloud.bigquery.BigQueryOptions.getDefaultProjectId();
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
  }

  public void setMaxResults(Long maxResults) {
    this.maxResults = maxResults;
  }

  public Long getMaxResults() {
    return this.maxResults != null
        ? this.maxResults
        : (Long) BigQueryJdbcUrlUtility.DEFAULT_MAX_RESULTS_VALUE;
  }

  public String getDefaultDataset() {
    return defaultDataset;
  }

  public void setDefaultDataset(String defaultDataset) {
    this.defaultDataset = defaultDataset;
  }

  public String getLocation() {
    return location;
  }

  public void setLocation(String location) {
    this.location = location;
  }

  public String getUserAgent() {
    return userAgent;
  }

  public void setUserAgent(String userAgent) {
    this.userAgent = userAgent;
  }

  public String getPartnerToken() {
    return partnerToken;
  }

  public void setPartnerToken(String partnerToken) {
    // This property is expected to be set by partners only. For more details on exact format
    // supported, refer b/396086960
    this.partnerToken = partnerToken;
  }

  public Boolean getEnableHighThroughputAPI() {
    return enableHighThroughputAPI != null
        ? enableHighThroughputAPI
        : BigQueryJdbcUrlUtility.DEFAULT_ENABLE_HTAPI_VALUE;
  }

  public void setEnableHighThroughputAPI(Boolean enableHighThroughputAPI) {
    this.enableHighThroughputAPI = enableHighThroughputAPI;
  }

  public Integer getHighThroughputMinTableSize() {
    return highThroughputMinTableSize != null
        ? highThroughputMinTableSize
        : (Integer) BigQueryJdbcUrlUtility.DEFAULT_HTAPI_MIN_TABLE_SIZE_VALUE;
  }

  public Integer getHighThroughputActivationRatio() {
    return highThroughputActivationRatio != null
        ? highThroughputActivationRatio
        : (Integer) BigQueryJdbcUrlUtility.DEFAULT_HTAPI_ACTIVATION_RATIO_VALUE;
  }

  public Long getConnectionPoolSize() {
    return connectionPoolSize != null
        ? connectionPoolSize
        : BigQueryJdbcUrlUtility.DEFAULT_CONNECTION_POOL_SIZE_VALUE;
  }

  public void setConnectionPoolSize(Long connectionPoolSize) {
    this.connectionPoolSize = connectionPoolSize;
  }

  public Long getListenerPoolSize() {
    return listenerPoolSize != null
        ? listenerPoolSize
        : BigQueryJdbcUrlUtility.DEFAULT_LISTENER_POOL_SIZE_VALUE;
  }

  public void setListenerPoolSize(Long listenerPoolSize) {
    this.listenerPoolSize = listenerPoolSize;
  }

  public void setHighThroughputMinTableSize(Integer highThroughputMinTableSize) {
    this.highThroughputMinTableSize = highThroughputMinTableSize;
  }

  public void setHighThroughputActivationRatio(Integer highThroughputActivationRatio) {
    this.highThroughputActivationRatio = highThroughputActivationRatio;
  }

  public void setKmsKeyName(String kmsKeyName) {
    this.kmsKeyName = kmsKeyName;
  }

  public String getKmsKeyName() {
    return this.kmsKeyName;
  }

  public void setQueryProperties(Map<String, String> queryProperties) {
    this.queryProperties = queryProperties == null ? null : ImmutableMap.copyOf(queryProperties);
  }

  public Map<String, String> getQueryProperties() {
    return this.queryProperties;
  }

  public void setUnsupportedHTAPIFallback(Boolean unsupportedHTAPIFallback) {
    this.unsupportedHTAPIFallback = unsupportedHTAPIFallback;
  }

  public Boolean getUnsupportedHTAPIFallback() {
    return this.unsupportedHTAPIFallback != null
        ? this.unsupportedHTAPIFallback
        : BigQueryJdbcUrlUtility.DEFAULT_UNSUPPORTED_HTAPI_FALLBACK_VALUE;
  }

  public Boolean getEnableSession() {
    return enableSession != null
        ? enableSession
        : BigQueryJdbcUrlUtility.DEFAULT_ENABLE_SESSION_VALUE;
  }

  public void setEnableSession(Boolean enableSession) {
    this.enableSession = enableSession;
  }

  public String getLogLevel() {
    return logLevel;
  }

  public void setLogLevel(String logLevel) {
    this.logLevel = logLevel;
  }

  public String getLogPath() {
    return logPath;
  }

  public void setLogPath(String logPath) {
    this.logPath = logPath;
  }

  public String getUniverseDomain() {
    return universeDomain != null
        ? universeDomain
        : BigQueryJdbcUrlUtility.DEFAULT_UNIVERSE_DOMAIN_VALUE;
  }

  public void setUniverseDomain(String universeDomain) {
    this.universeDomain = universeDomain;
  }

  public String getProxyHost() {
    return proxyHost;
  }

  public void setProxyHost(String proxyHost) {
    this.proxyHost = proxyHost;
  }

  public String getProxyPort() {
    return proxyPort;
  }

  public void setProxyPort(String proxyPort) {
    this.proxyPort = proxyPort;
  }

  public String getProxyUid() {
    return proxyUid;
  }

  public void setProxyUid(String proxyUid) {
    this.proxyUid = proxyUid;
  }

  public String getProxyPwd() {
    return proxyPwd;
  }

  public void setProxyPwd(String proxyPwd) {
    this.proxyPwd = proxyPwd;
  }

  public Integer getOAuthType() {
    return oAuthType != null ? oAuthType : BigQueryJdbcUrlUtility.DEFAULT_OAUTH_TYPE_VALUE;
  }

  public void setOAuthType(Integer oAuthType) {
    this.oAuthType = oAuthType;
  }

  public String getOAuthServiceAcctEmail() {
    return oAuthServiceAcctEmail;
  }

  public void setOAuthServiceAcctEmail(String oAuthServiceAcctEmail) {
    this.oAuthServiceAcctEmail = oAuthServiceAcctEmail;
  }

  public String getOAuthPvtKeyPath() {
    return oAuthPvtKeyPath;
  }

  public String getOAuthPvtKey() {
    return oAuthPvtKey;
  }

  public void setOAuthPvtKey(String oAuthPvtKey) {
    this.oAuthPvtKey = oAuthPvtKey;
  }

  public void setOAuthPvtKeyPath(String oAuthPvtKeyPath) {
    this.oAuthPvtKeyPath = oAuthPvtKeyPath;
  }

  public String getOAuthAccessToken() {
    return oAuthAccessToken;
  }

  public void setOAuthAccessToken(String oAuthAccessToken) {
    this.oAuthAccessToken = oAuthAccessToken;
  }

  public String getOAuthRefreshToken() {
    return oAuthRefreshToken;
  }

  public void setOAuthRefreshToken(String oAuthRefreshToken) {
    this.oAuthRefreshToken = oAuthRefreshToken;
  }

  public Boolean getUseQueryCache() {
    return useQueryCache != null ? useQueryCache : BigQueryJdbcUrlUtility.DEFAULT_USE_QUERY_CACHE;
  }

  public String getQueryDialect() {
    return queryDialect != null ? queryDialect : BigQueryJdbcUrlUtility.DEFAULT_QUERY_DIALECT_VALUE;
  }

  public Boolean getAllowLargeResults() {
    return allowLargeResults != null
        ? allowLargeResults
        : BigQueryJdbcUrlUtility.DEFAULT_ALLOW_LARGE_RESULTS;
  }

  public String getDestinationTable() {
    return destinationTable;
  }

  public String getDestinationDataset() {
    return destinationDataset;
  }

  public Long getDestinationDatasetExpirationTime() {
    return destinationDatasetExpirationTime != null
        ? destinationDatasetExpirationTime
        : (Long) BigQueryJdbcUrlUtility.DEFAULT_DESTINATION_DATASET_EXPIRATION_TIME_VALUE;
  }

  public void setUseQueryCache(Boolean useQueryCache) {
    this.useQueryCache = useQueryCache;
  }

  public void setQueryDialect(String queryDialect) {
    this.queryDialect = queryDialect;
  }

  public void setAllowLargeResults(Boolean allowLargeResults) {
    this.allowLargeResults = allowLargeResults;
  }

  public void setDestinationTable(String destinationTable) {
    this.destinationTable = destinationTable;
  }

  public void setDestinationDataset(String destinationDataset) {
    this.destinationDataset = destinationDataset;
  }

  public void setDestinationDatasetExpirationTime(long destinationDatasetExpirationTime) {
    this.destinationDatasetExpirationTime = destinationDatasetExpirationTime;
  }

  public String getOAuthClientId() {
    return oAuthClientId;
  }

  public void setOAuthClientId(String oAuthClientId) {
    this.oAuthClientId = oAuthClientId;
  }

  public String getOAuthClientSecret() {
    return oAuthClientSecret;
  }

  public void setOAuthClientSecret(String oAuthClientSecret) {
    this.oAuthClientSecret = oAuthClientSecret;
  }

  public Integer getJobCreationMode() {
    return jobCreationMode != null
        ? jobCreationMode
        : (Integer) BigQueryJdbcUrlUtility.DEFAULT_JOB_CREATION_MODE;
  }

  public Boolean getUseStatelessQueryMode() {
    return getJobCreationMode() == 2;
  }

  public void setJobCreationMode(Integer jobCreationMode) {
    if (jobCreationMode != null && !VALID_JOB_CREATION_MODES.contains(jobCreationMode)) {
      IllegalArgumentException ex =
          new IllegalArgumentException(
              String.format(
                  "Invalid value for %s. Use 1 for JOB_CREATION_REQUIRED and 2 for"
                      + " JOB_CREATION_OPTIONAL.",
                  BigQueryJdbcUrlUtility.JOB_CREATION_MODE_PROPERTY_NAME));
      LOG.severe(ex.getMessage(), ex);
      throw ex;
    }
    this.jobCreationMode = jobCreationMode;
  }

  public Boolean getEnableWriteAPI() {
    return enableWriteAPI != null
        ? enableWriteAPI
        : BigQueryJdbcUrlUtility.DEFAULT_ENABLE_WRITE_API_VALUE;
  }

  public void setEnableWriteAPI(Boolean enableWriteAPI) {
    this.enableWriteAPI = enableWriteAPI;
  }

  public String getAdditionalProjects() {
    return additionalProjects;
  }

  public void setAdditionalProjects(String additionalProjects) {
    this.additionalProjects = additionalProjects;
  }

  public Boolean getFilterTablesOnDefaultDataset() {
    return filterTablesOnDefaultDataset != null
        ? filterTablesOnDefaultDataset
        : BigQueryJdbcUrlUtility.DEFAULT_FILTER_TABLES_ON_DEFAULT_DATASET_VALUE;
  }

  public void setFilterTablesOnDefaultDataset(Boolean filterTablesOnDefaultDataset) {
    this.filterTablesOnDefaultDataset = filterTablesOnDefaultDataset;
  }

  public Integer getRequestGoogleDriveScope() {
    return requestGoogleDriveScope != null
        ? requestGoogleDriveScope
        : BigQueryJdbcUrlUtility.DEFAULT_REQUEST_GOOGLE_DRIVE_SCOPE_VALUE;
  }

  public void setRequestGoogleDriveScope(Integer requestGoogleDriveScope) {
    this.requestGoogleDriveScope = requestGoogleDriveScope;
  }

  public Integer getMetadataFetchThreadCount() {
    return metadataFetchThreadCount != null
        ? metadataFetchThreadCount
        : BigQueryJdbcUrlUtility.DEFAULT_METADATA_FETCH_THREAD_COUNT_VALUE;
  }

  public void setMetadataFetchThreadCount(Integer metadataFetchThreadCount) {
    this.metadataFetchThreadCount = metadataFetchThreadCount;
  }

  public String getSSLTrustStorePath() {
    return sslTrustStorePath;
  }

  public void setSSLTrustStorePath(String sslTrustStorePath) {
    this.sslTrustStorePath = sslTrustStorePath;
  }

  public String getSSLTrustStorePassword() {
    return sslTrustStorePassword;
  }

  public void setSSLTrustStorePassword(String sslTrustStorePassword) {
    this.sslTrustStorePassword = sslTrustStorePassword;
  }

  public Map<String, String> getLabels() {
    return labels;
  }

  public void setLabels(Map<String, String> labels) {
    this.labels = labels == null ? null : ImmutableMap.copyOf(labels);
  }

  public String getRequestReason() {
    return requestReason;
  }

  public void setRequestReason(String requestReason) {
    this.requestReason = requestReason;
  }

  public Integer getTimeout() {
    return timeout != null
        ? timeout
        : (int) BigQueryJdbcUrlUtility.DEFAULT_RETRY_TIMEOUT_IN_SECS_VALUE;
  }

  public Integer getJobTimeout() {
    return jobTimeout != null ? jobTimeout : (int) BigQueryJdbcUrlUtility.DEFAULT_JOB_TIMEOUT_VALUE;
  }

  public Integer getRetryInitialDelay() {
    return retryInitialDelay != null
        ? retryInitialDelay
        : (int) BigQueryJdbcUrlUtility.DEFAULT_RETRY_INITIAL_DELAY_VALUE;
  }

  public Integer getRetryMaxDelay() {
    return retryMaxDelay != null
        ? retryMaxDelay
        : (int) BigQueryJdbcUrlUtility.DEFAULT_RETRY_MAX_DELAY_VALUE;
  }

  public void setJobTimeout(Integer jobTimeout) {
    this.jobTimeout = jobTimeout;
  }

  public void setRetryInitialDelay(Integer retryInitialDelay) {
    this.retryInitialDelay = retryInitialDelay;
  }

  public void setRetryMaxDelay(Integer retryMaxDelay) {
    this.retryMaxDelay = retryMaxDelay;
  }

  public void setTimeout(Integer timeout) {
    this.timeout = timeout;
  }

  public Integer getHttpConnectTimeout() {
    return httpConnectTimeout;
  }

  public void setHttpConnectTimeout(Integer httpConnectTimeout) {
    this.httpConnectTimeout = httpConnectTimeout;
  }

  public Integer getHttpReadTimeout() {
    return httpReadTimeout;
  }

  public void setHttpReadTimeout(Integer httpReadTimeout) {
    this.httpReadTimeout = httpReadTimeout;
  }

  public Long getMaximumBytesBilled() {
    return maximumBytesBilled != null
        ? maximumBytesBilled
        : BigQueryJdbcUrlUtility.DEFAULT_MAX_BYTES_BILLED_VALUE;
  }

  public void setMaximumBytesBilled(Long maximumBytesBilled) {
    this.maximumBytesBilled = maximumBytesBilled;
  }

  public Integer getSwaActivationRowCount() {
    return swaActivationRowCount != null
        ? swaActivationRowCount
        : BigQueryJdbcUrlUtility.DEFAULT_SWA_ACTIVATION_ROW_COUNT_VALUE;
  }

  public void setSwaActivationRowCount(Integer swaActivationRowCount) {
    this.swaActivationRowCount = swaActivationRowCount;
  }

  public Integer getSwaAppendRowCount() {
    return swaAppendRowCount != null
        ? swaAppendRowCount
        : BigQueryJdbcUrlUtility.DEFAULT_SWA_APPEND_ROW_COUNT_VALUE;
  }

  public void setSwaAppendRowCount(Integer swaAppendRowCount) {
    this.swaAppendRowCount = swaAppendRowCount;
  }

  public String getOAuthP12Password() {
    return oAuthP12Password != null
        ? oAuthP12Password
        : BigQueryJdbcUrlUtility.DEFAULT_OAUTH_P12_PASSWORD_VALUE;
  }

  public void setOAuthP12Password(String oAuthP12Password) {
    this.oAuthP12Password = oAuthP12Password;
  }

  public String getOAuthSAImpersonationEmail() {
    return oAuthSAImpersonationEmail;
  }

  public void setOAuthSAImpersonationEmail(String oAuthSAImpersonationEmail) {
    this.oAuthSAImpersonationEmail = oAuthSAImpersonationEmail;
  }

  public String getOAuthSAImpersonationChain() {
    return oAuthSAImpersonationChain;
  }

  public void setOAuthSAImpersonationChain(String oAuthSAImpersonationChain) {
    this.oAuthSAImpersonationChain = oAuthSAImpersonationChain;
  }

  public String getOAuthSAImpersonationScopes() {
    return oAuthSAImpersonationScopes;
  }

  public void setOAuthSAImpersonationScopes(String oAuthSAImpersonationScopes) {
    this.oAuthSAImpersonationScopes = oAuthSAImpersonationScopes;
  }

  public String getOAuthSAImpersonationTokenLifetime() {
    return oAuthSAImpersonationTokenLifetime;
  }

  public void setOAuthSAImpersonationTokenLifetime(String oAuthSAImpersonationTokenLifetime) {
    this.oAuthSAImpersonationTokenLifetime = oAuthSAImpersonationTokenLifetime;
  }

  public String getOAuth2TokenUri() {
    return oAuth2TokenUri;
  }

  public void setOAuth2TokenUri(String oAuth2TokenUri) {
    this.oAuth2TokenUri = oAuth2TokenUri;
  }

  public String getByoidAudienceUri() {
    return byoidAudienceUri;
  }

  public void setByoidAudienceUri(String byoidAudienceUri) {
    this.byoidAudienceUri = byoidAudienceUri;
  }

  public String getByoidCredentialSource() {
    return byoidCredentialSource;
  }

  public void setByoidCredentialSource(String byoidCredentialSource) {
    this.byoidCredentialSource = byoidCredentialSource;
  }

  public String getByoidPoolUserProject() {
    return byoidPoolUserProject;
  }

  public void setByoidPoolUserProject(String byoidPoolUserProject) {
    this.byoidPoolUserProject = byoidPoolUserProject;
  }

  public String getByoidSAImpersonationUri() {
    return byoidSAImpersonationUri;
  }

  public void setByoidSAImpersonationUri(String byoidSAImpersonationUri) {
    this.byoidSAImpersonationUri = byoidSAImpersonationUri;
  }

  public String getByoidSubjectTokenType() {
    return byoidSubjectTokenType != null
        ? byoidSubjectTokenType
        : BigQueryJdbcUrlUtility.DEFAULT_BYOID_SUBJECT_TOKEN_TYPE_VALUE;
  }

  public void setByoidSubjectTokenType(String byoidSubjectTokenType) {
    this.byoidSubjectTokenType = byoidSubjectTokenType;
  }

  public String getByoidTokenUri() {
    return byoidTokenUri != null
        ? byoidTokenUri
        : BigQueryJdbcUrlUtility.DEFAULT_BYOID_TOKEN_URI_VALUE;
  }

  public void setByoidTokenUri(String byoidTokenUri) {
    this.byoidTokenUri = byoidTokenUri;
  }

  public String getEndpointOverrides() {
    return endpointOverrides;
  }

  public void setEndpointOverrides(String endpointOverrides) {
    this.endpointOverrides = endpointOverrides;
  }

  public String getPrivateServiceConnect() {
    return privateServiceConnect;
  }

  public void setPrivateServiceConnect(String privateServiceConnect) {
    this.privateServiceConnect = privateServiceConnect;
  }

  @Override
  public PrintWriter getLogWriter() {
    return null;
  }

  @Override
  public void setLogWriter(PrintWriter out) {}

  @Override
  public void setLoginTimeout(int seconds) {}

  @Override
  public int getLoginTimeout() {
    return 0;
  }

  @Override
  public Logger getParentLogger() {
    return BigQueryJdbcRootLogger.getRootLogger();
  }

  @Override
  public <T> T unwrap(Class<T> iface) {
    return null;
  }

  @Override
  public boolean isWrapperFor(Class<?> iface) {
    return false;
  }
}
