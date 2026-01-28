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

import com.google.cloud.bigquery.exception.BigQueryJdbcException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

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

  // Make sure the JDBC driver class is loaded.
  static {
    try {
      Class.forName("com.google.cloud.bigquery.jdbc.BigQueryDriver");
    } catch (ClassNotFoundException ex) {
      throw new IllegalStateException(
          "DataSource failed to load com.google.cloud.bigquery.jdbc.BigQueryDriver", ex);
    }
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
          BigQueryJdbcUrlUtility.QUERY_PROPERTIES_NAME, this.queryProperties.toString());
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
    return connectionProperties;
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
    return projectId;
  }

  public void setProjectId(String projectId) {
    this.projectId = projectId;
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

  public boolean getEnableHighThroughputAPI() {
    return enableHighThroughputAPI;
  }

  public void setEnableHighThroughputAPI(Boolean enableHighThroughputAPI) {
    this.enableHighThroughputAPI = enableHighThroughputAPI;
  }

  public int getHighThroughputMinTableSize() {
    return highThroughputMinTableSize;
  }

  public int getHighThroughputActivationRatio() {
    return highThroughputActivationRatio;
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
    this.queryProperties = queryProperties;
  }

  public Map<String, String> getQueryProperties() {
    return this.queryProperties;
  }

  public void setUnsupportedHTAPIFallback(Boolean unsupportedHTAPIFallback) {
    this.unsupportedHTAPIFallback = unsupportedHTAPIFallback;
  }

  public boolean getUnsupportedHTAPIFallback() {
    return this.unsupportedHTAPIFallback;
  }

  public boolean getEnableSession() {
    return enableSession;
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
    return universeDomain;
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

  public int getOAuthType() {
    return oAuthType;
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
    return useQueryCache;
  }

  public String getQueryDialect() {
    return queryDialect;
  }

  public Boolean getAllowLargeResults() {
    return allowLargeResults;
  }

  public String getDestinationTable() {
    return destinationTable;
  }

  public String getDestinationDataset() {
    return destinationDataset;
  }

  public Long getDestinationDatasetExpirationTime() {
    return destinationDatasetExpirationTime;
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
    return jobCreationMode;
  }

  public void setJobCreationMode(Integer jobCreationMode) {
    this.jobCreationMode = jobCreationMode;
  }

  public Boolean getEnableWriteAPI() {
    return enableWriteAPI;
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
    return filterTablesOnDefaultDataset;
  }

  public void setFilterTablesOnDefaultDataset(Boolean filterTablesOnDefaultDataset) {
    this.filterTablesOnDefaultDataset = filterTablesOnDefaultDataset;
  }

  public Integer getRequestGoogleDriveScope() {
    return requestGoogleDriveScope;
  }

  public void setRequestGoogleDriveScope(Integer requestGoogleDriveScope) {
    this.requestGoogleDriveScope = requestGoogleDriveScope;
  }

  public Integer getMetadataFetchThreadCount() {
    return metadataFetchThreadCount;
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
