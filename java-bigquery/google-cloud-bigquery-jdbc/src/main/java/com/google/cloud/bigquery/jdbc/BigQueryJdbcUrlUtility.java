/*
 * Copyright 2026 Google LLC
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

import com.google.api.client.util.escape.CharEscapers;
import com.google.cloud.bigquery.BigQueryOptions;
import com.google.cloud.bigquery.exception.BigQueryJdbcRuntimeException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Properties;
import java.util.Set;
import java.util.logging.Level;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

/**
 * This class implements all the methods that parse Connection property values from the Connection
 * String.
 */
final class BigQueryJdbcUrlUtility {

  // TODO: Add all Connection options
  static final String ALLOW_LARGE_RESULTS_PROPERTY_NAME = "AllowLargeResults";
  static final String LARGE_RESULTS_TABLE_PROPERTY_NAME = "LargeResultTable";
  static final String LARGE_RESULTS_DATASET_PROPERTY_NAME = "LargeResultDataset";
  static final String UNSUPPORTED_HTAPI_FALLBACK_PROPERTY_NAME = "UnsupportedHTAPIFallback";
  static final boolean DEFAULT_UNSUPPORTED_HTAPI_FALLBACK_VALUE = true;
  static final String DESTINATION_DATASET_EXPIRATION_TIME_PROPERTY_NAME =
      "LargeResultsDatasetExpirationTime";
  static final long DEFAULT_DESTINATION_DATASET_EXPIRATION_TIME_VALUE = 3600000L;
  static final boolean DEFAULT_ALLOW_LARGE_RESULTS = true;
  static final String QUERY_DIALECT_PROPERTY_NAME = "QueryDialect";
  static final String DEFAULT_QUERY_DIALECT_VALUE = "SQL";
  static final String UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME = "universeDomain";
  static final String DEFAULT_UNIVERSE_DOMAIN_VALUE = "googleapis.com";
  static final String PROJECT_ID_PROPERTY_NAME = "ProjectId";
  static final String DEFAULT_DATASET_PROPERTY_NAME = "DefaultDataset";
  static final String OAUTH_TYPE_PROPERTY_NAME = "OAuthType";
  static final String HTAPI_ACTIVATION_RATIO_PROPERTY_NAME = "HighThroughputActivationRatio";
  static final String KMS_KEY_NAME_PROPERTY_NAME = "KMSKeyName";
  static final String QUERY_PROPERTIES_NAME = "QueryProperties";
  static final int DEFAULT_HTAPI_ACTIVATION_RATIO_VALUE =
      2; // TODO: to adjust this value before private preview based on performance testing.
  static final String HTAPI_MIN_TABLE_SIZE_PROPERTY_NAME = "HighThroughputMinTableSize";
  static final int DEFAULT_HTAPI_MIN_TABLE_SIZE_VALUE = 100;
  static final int DEFAULT_OAUTH_TYPE_VALUE = -1;
  static final String LOCATION_PROPERTY_NAME = "Location";
  static final String ENDPOINT_OVERRIDES_PROPERTY_NAME = "EndpointOverrides";
  static final String PRIVATE_SERVICE_CONNECT_PROPERTY_NAME = "PrivateServiceConnectUris";
  static final String OAUTH_SA_IMPERSONATION_EMAIL_PROPERTY_NAME =
      "ServiceAccountImpersonationEmail";
  static final String DEFAULT_OAUTH_SA_IMPERSONATION_EMAIL_VALUE = null;
  static final String OAUTH_SA_IMPERSONATION_CHAIN_PROPERTY_NAME =
      "ServiceAccountImpersonationChain";
  static final String DEFAULT_OAUTH_SA_IMPERSONATION_CHAIN_VALUE = null;
  static final String OAUTH_SA_IMPERSONATION_SCOPES_PROPERTY_NAME =
      "ServiceAccountImpersonationScopes";
  static final String DEFAULT_OAUTH_SA_IMPERSONATION_SCOPES_VALUE =
      "https://www.googleapis.com/auth/bigquery";
  static final String OAUTH_SA_IMPERSONATION_TOKEN_LIFETIME_PROPERTY_NAME =
      "ServiceAccountImpersonationTokenLifetime";
  static final String DEFAULT_OAUTH_SA_IMPERSONATION_TOKEN_LIFETIME_VALUE = "3600";
  static final String OAUTH_SA_EMAIL_PROPERTY_NAME = "OAuthServiceAcctEmail";
  static final String OAUTH_PVT_KEY_PATH_PROPERTY_NAME = "OAuthPvtKeyPath";
  static final String OAUTH_P12_PASSWORD_PROPERTY_NAME = "OAuthP12Password";
  static final String DEFAULT_OAUTH_P12_PASSWORD_VALUE = "notasecret";
  static final String OAUTH_PVT_KEY_PROPERTY_NAME = "OAuthPvtKey";
  static final String OAUTH2_TOKEN_URI_PROPERTY_NAME = "OAUTH2";
  static final String HTAPI_ENDPOINT_OVERRIDE_PROPERTY_NAME = "READ_API";
  static final String BIGQUERY_ENDPOINT_OVERRIDE_PROPERTY_NAME = "BIGQUERY";
  static final String STS_ENDPOINT_OVERRIDE_PROPERTY_NAME = "STS";
  static final String OAUTH_ACCESS_TOKEN_PROPERTY_NAME = "OAuthAccessToken";
  static final String OAUTH_REFRESH_TOKEN_PROPERTY_NAME = "OAuthRefreshToken";
  static final String OAUTH_CLIENT_ID_PROPERTY_NAME = "OAuthClientId";
  static final String OAUTH_CLIENT_SECRET_PROPERTY_NAME = "OAuthClientSecret";
  static final String ENABLE_HTAPI_PROPERTY_NAME = "EnableHighThroughputAPI";
  static final String PROXY_HOST_PROPERTY_NAME = "ProxyHost";
  static final String PROXY_PORT_PROPERTY_NAME = "ProxyPort";
  static final String PROXY_USER_ID_PROPERTY_NAME = "ProxyUid";
  static final String PROXY_PASSWORD_PROPERTY_NAME = "ProxyPwd";
  static final boolean DEFAULT_ENABLE_HTAPI_VALUE = false;
  static final boolean DEFAULT_ENABLE_SESSION_VALUE = false;
  static final int DEFAULT_LOG_LEVEL = 0;
  static final String LOG_LEVEL_PROPERTY_NAME = "LogLevel";
  static final String LOG_PATH_PROPERTY_NAME = "LogPath";
  static final String LOG_LEVEL_ENV_VAR = "BIGQUERY_JDBC_LOG_LEVEL";
  static final String LOG_PATH_ENV_VAR = "BIGQUERY_JDBC_LOG_PATH";
  static final String ENABLE_SESSION_PROPERTY_NAME = "EnableSession";
  static final String DEFAULT_LOG_PATH = "";
  static final String USE_QUERY_CACHE_PROPERTY_NAME = "UseQueryCache";
  static final boolean DEFAULT_USE_QUERY_CACHE = true;
  static final String JOB_CREATION_MODE_PROPERTY_NAME = "JobCreationMode";
  static final int DEFAULT_JOB_CREATION_MODE = 2;
  static final String MAX_RESULTS_PROPERTY_NAME = "MaxResults";
  static final long DEFAULT_MAX_RESULTS_VALUE = 10000;
  static final String BYOID_AUDIENCE_URI_PROPERTY_NAME = "BYOID_AudienceUri";
  static final String BYOID_CREDENTIAL_SOURCE_PROPERTY_NAME = "BYOID_CredentialSource";
  static final String BYOID_POOL_USER_PROJECT_PROPERTY_NAME = "BYOID_PoolUserProject";
  static final String BYOID_SA_IMPERSONATION_URI_PROPERTY_NAME = "BYOID_SA_Impersonation_Uri";
  static final String BYOID_SUBJECT_TOKEN_TYPE_PROPERTY_NAME = "BYOID_SubjectTokenType";
  static final String BYOID_TOKEN_URI_PROPERTY_NAME = "BYOID_TokenUri";
  static final String PARTNER_TOKEN_PROPERTY_NAME = "PartnerToken";
  static final String METADATA_FETCH_THREAD_COUNT_PROPERTY_NAME = "MetaDataFetchThreadCount";
  static final int DEFAULT_METADATA_FETCH_THREAD_COUNT_VALUE = 32;
  static final String RETRY_TIMEOUT_IN_SECS_PROPERTY_NAME = "Timeout";
  static final long DEFAULT_RETRY_TIMEOUT_IN_SECS_VALUE = 0L;
  static final String JOB_TIMEOUT_PROPERTY_NAME = "JobTimeout";
  static final long DEFAULT_JOB_TIMEOUT_VALUE = 0L;
  static final String RETRY_INITIAL_DELAY_PROPERTY_NAME = "RetryInitialDelay";
  static final long DEFAULT_RETRY_INITIAL_DELAY_VALUE = 0L;
  static final String RETRY_MAX_DELAY_PROPERTY_NAME = "RetryMaxDelay";
  static final long DEFAULT_RETRY_MAX_DELAY_VALUE = 0L;
  static final String ADDITIONAL_PROJECTS_PROPERTY_NAME = "AdditionalProjects";
  // Applicable only for connection pooling.
  static final String CONNECTION_POOL_SIZE_PROPERTY_NAME = "ConnectionPoolSize";
  static final long DEFAULT_CONNECTION_POOL_SIZE_VALUE = 10L;
  static final String LISTENER_POOL_SIZE_PROPERTY_NAME = "ListenerPoolSize";
  static final long DEFAULT_LISTENER_POOL_SIZE_VALUE = 10L;
  static final String ENABLE_WRITE_API_PROPERTY_NAME = "EnableWriteAPI";
  static final boolean DEFAULT_ENABLE_WRITE_API_VALUE = false;
  static final String SWA_APPEND_ROW_COUNT_PROPERTY_NAME = "SWA_AppendRowCount";
  static final int DEFAULT_SWA_APPEND_ROW_COUNT_VALUE = 1000;
  static final String SWA_ACTIVATION_ROW_COUNT_PROPERTY_NAME = "SWA_ActivationRowCount";
  static final int DEFAULT_SWA_ACTIVATION_ROW_COUNT_VALUE = 3;
  private static final BigQueryJdbcCustomLogger LOG =
      new BigQueryJdbcCustomLogger(BigQueryJdbcUrlUtility.class.getName());
  static final String FILTER_TABLES_ON_DEFAULT_DATASET_PROPERTY_NAME =
      "FilterTablesOnDefaultDataset";
  static final boolean DEFAULT_FILTER_TABLES_ON_DEFAULT_DATASET_VALUE = false;
  static final String REQUEST_GOOGLE_DRIVE_SCOPE_PROPERTY_NAME = "RequestGoogleDriveScope";
  static final String SSL_TRUST_STORE_PROPERTY_NAME = "SSLTrustStore";
  static final String SSL_TRUST_STORE_PWD_PROPERTY_NAME = "SSLTrustStorePwd";
  static final int DEFAULT_REQUEST_GOOGLE_DRIVE_SCOPE_VALUE = 0;
  static final String MAX_BYTES_BILLED_PROPERTY_NAME = "MaximumBytesBilled";
  static final Long DEFAULT_MAX_BYTES_BILLED_VALUE = 0L;
  static final String LABELS_PROPERTY_NAME = "Labels";
  static final List<String> OVERRIDE_PROPERTIES =
      Arrays.asList(
          BIGQUERY_ENDPOINT_OVERRIDE_PROPERTY_NAME,
          OAUTH2_TOKEN_URI_PROPERTY_NAME,
          HTAPI_ENDPOINT_OVERRIDE_PROPERTY_NAME,
          STS_ENDPOINT_OVERRIDE_PROPERTY_NAME);
  static final List<String> BYOID_PROPERTIES =
      Arrays.asList(
          BYOID_AUDIENCE_URI_PROPERTY_NAME,
          BYOID_CREDENTIAL_SOURCE_PROPERTY_NAME,
          BYOID_POOL_USER_PROJECT_PROPERTY_NAME,
          BYOID_SA_IMPERSONATION_URI_PROPERTY_NAME,
          BYOID_SUBJECT_TOKEN_TYPE_PROPERTY_NAME,
          BYOID_TOKEN_URI_PROPERTY_NAME);

  static Set<BigQueryConnectionProperty> PROXY_PROPERTIES =
      Collections.unmodifiableSet(
          new HashSet<>(
              Arrays.asList(
                  BigQueryConnectionProperty.newBuilder()
                      .setName(PROXY_HOST_PROPERTY_NAME)
                      .setDescription("The host name of the proxy server.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(PROXY_PORT_PROPERTY_NAME)
                      .setDescription(
                          "The port number of the proxy server to connect to. No defaulting"
                              + " behavior happens.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(PROXY_USER_ID_PROPERTY_NAME)
                      .setDescription("The user name for an authenticated proxy server.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(PROXY_PASSWORD_PROPERTY_NAME)
                      .setDescription("The password for an authenticated proxy server.")
                      .build())));

  static Set<BigQueryConnectionProperty> AUTH_PROPERTIES =
      Collections.unmodifiableSet(
          new HashSet<>(
              Arrays.asList(
                  BigQueryConnectionProperty.newBuilder()
                      .setName(OAUTH_TYPE_PROPERTY_NAME)
                      .setDescription(
                          "This option specifies how the connector obtains or provides the"
                              + " credentials for OAuth\n"
                              + "2.0 authentication")
                      .setDefaultValue(String.valueOf(DEFAULT_OAUTH_TYPE_VALUE))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(OAUTH_SA_EMAIL_PROPERTY_NAME)
                      .setDescription(
                          "The Service Account email use for Service Account Authentication.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(OAUTH_PVT_KEY_PATH_PROPERTY_NAME)
                      .setDescription(
                          "The location of the credentials file used for this connection.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(OAUTH_PVT_KEY_PROPERTY_NAME)
                      .setDescription("The OAuth private key used for this connection.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(OAUTH_REFRESH_TOKEN_PROPERTY_NAME)
                      .setDescription(
                          "The pre-generated refresh token to be used with BigQuery for"
                              + " authentication.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(OAUTH_ACCESS_TOKEN_PROPERTY_NAME)
                      .setDescription(
                          "The pre-generated access token to be used with BigQuery for"
                              + " authentication.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(OAUTH_CLIENT_ID_PROPERTY_NAME)
                      .setDescription(
                          "The client ID to be used for user authentication or to refresh"
                              + " pre-generated tokens.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(OAUTH_CLIENT_SECRET_PROPERTY_NAME)
                      .setDescription(
                          "The client secret to be used for user authentication or to refresh"
                              + " pre-generated tokens.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(OAUTH_SA_IMPERSONATION_EMAIL_PROPERTY_NAME)
                      .setDescription("The service account email to be impersonated.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(OAUTH_SA_IMPERSONATION_CHAIN_PROPERTY_NAME)
                      .setDescription(
                          "Comma separated list of service account emails in the impersonation chain.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(OAUTH_SA_IMPERSONATION_SCOPES_PROPERTY_NAME)
                      .setDescription(
                          "Comma separated list of OAuth2 scopes to use with impersonated account.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(OAUTH_SA_IMPERSONATION_TOKEN_LIFETIME_PROPERTY_NAME)
                      .setDescription("Impersonated account token lifetime.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(OAUTH_P12_PASSWORD_PROPERTY_NAME)
                      .setDescription("Password for p12 secret file.")
                      .build())));

  static Set<BigQueryConnectionProperty> VALID_PROPERTIES =
      Collections.unmodifiableSet(
          new HashSet<>(
              Arrays.asList(
                  BigQueryConnectionProperty.newBuilder()
                      .setName(MAX_BYTES_BILLED_PROPERTY_NAME)
                      .setDescription(
                          " Limits the bytes billed for this query. Queries with bytes billed above"
                              + " this limit will fail (without incurring a charge). If"
                              + " unspecified, the project default is used.")
                      .setDefaultValue(String.valueOf(DEFAULT_MAX_BYTES_BILLED_VALUE))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(CONNECTION_POOL_SIZE_PROPERTY_NAME)
                      .setDescription("Connection pool size if connection pooling is enabled.")
                      .setDefaultValue(String.valueOf(DEFAULT_CONNECTION_POOL_SIZE_VALUE))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(LISTENER_POOL_SIZE_PROPERTY_NAME)
                      .setDescription("Listener pool size if connection pooling is enabled.")
                      .setDefaultValue(String.valueOf(DEFAULT_LISTENER_POOL_SIZE_VALUE))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(RETRY_INITIAL_DELAY_PROPERTY_NAME)
                      .setDescription("Initial delay, in seconds, before the first retry.")
                      .setDefaultValue(String.valueOf(DEFAULT_RETRY_INITIAL_DELAY_VALUE))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(RETRY_MAX_DELAY_PROPERTY_NAME)
                      .setDescription("Max limit for the retry delay, in seconds.")
                      .setDefaultValue(String.valueOf(DEFAULT_RETRY_MAX_DELAY_VALUE))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(RETRY_TIMEOUT_IN_SECS_PROPERTY_NAME)
                      .setDescription(
                          "The length of time, in seconds, for which the connector retries a failed"
                              + " API call before timing out.")
                      .setDefaultValue(String.valueOf(DEFAULT_RETRY_TIMEOUT_IN_SECS_VALUE))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(JOB_TIMEOUT_PROPERTY_NAME)
                      .setDescription(
                          "Job timeout (in seconds) after which the job is cancelled on the server")
                      .setDefaultValue(String.valueOf(DEFAULT_JOB_TIMEOUT_VALUE))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(UNSUPPORTED_HTAPI_FALLBACK_PROPERTY_NAME)
                      .setDescription(
                          "This option determines whether the connector uses the REST API or"
                              + " returns an error when encountering fetch workflows unsupported by"
                              + " the High-Throughput API.")
                      .setDefaultValue(String.valueOf(DEFAULT_UNSUPPORTED_HTAPI_FALLBACK_VALUE))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(DESTINATION_DATASET_EXPIRATION_TIME_PROPERTY_NAME)
                      .setDescription(
                          "The expiration time (in milliseconds) for tables in a user-specified"
                              + " large result dataset.")
                      .setDefaultValue(
                          String.valueOf(DEFAULT_DESTINATION_DATASET_EXPIRATION_TIME_VALUE))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(UNIVERSE_DOMAIN_OVERRIDE_PROPERTY_NAME)
                      .setDescription(
                          "The name of the partner-operated cloud which is a new instance of Google"
                              + " production, known as a Trusted Partner Cloud universe.")
                      .setDefaultValue(DEFAULT_UNIVERSE_DOMAIN_VALUE)
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(PROJECT_ID_PROPERTY_NAME)
                      .setDescription("A globally unique identifier for your project.")
                      .setDefaultValue(BigQueryOptions.getDefaultProjectId())
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(LOG_PATH_PROPERTY_NAME)
                      .setDescription(
                          "The directory where the connector saves log files (when logging is"
                              + " enabled).")
                      .setDefaultValue(DEFAULT_LOG_PATH)
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(DEFAULT_DATASET_PROPERTY_NAME)
                      .setDescription(
                          "This default dataset for query execution. If this option is set, queries"
                              + " with unqualified \n"
                              + "table names will run against this dataset.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(LOCATION_PROPERTY_NAME)
                      .setDescription(
                          "The location where datasets are created/queried. The location will be"
                              + " determined\n"
                              + " automatically by BigQuery if not specified.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(ENABLE_HTAPI_PROPERTY_NAME)
                      .setDescription(
                          "Enables or disables Read API usage in the Driver. Disabled by default.")
                      .setDefaultValue(String.valueOf(DEFAULT_ENABLE_HTAPI_VALUE))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(HTAPI_ACTIVATION_RATIO_PROPERTY_NAME)
                      .setDescription(
                          "Connector switches to BigQuery Storage API when the number of pages"
                              + " exceed this value.")
                      .setDefaultValue(String.valueOf(DEFAULT_HTAPI_ACTIVATION_RATIO_VALUE))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(KMS_KEY_NAME_PROPERTY_NAME)
                      .setDescription(
                          "The KMS key name tells BigQuery which key to use when encrypting or"
                              + " decrypting your data.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(QUERY_PROPERTIES_NAME)
                      .setDescription(
                          "Connection-level properties to customize query behavior.") // TODO:
                      // Figure out
                      // a clean way
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(LABELS_PROPERTY_NAME)
                      .setDescription(
                          "Labels associated with the query to organize and group query jobs.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(HTAPI_MIN_TABLE_SIZE_PROPERTY_NAME)
                      .setDescription(
                          "If the number of total rows exceeds this value, the connector switches"
                              + " to the BigQuery Storage API for faster processing.")
                      .setDefaultValue(String.valueOf(DEFAULT_HTAPI_MIN_TABLE_SIZE_VALUE))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(ENABLE_SESSION_PROPERTY_NAME)
                      .setDescription(
                          "Enable to capture your SQL activities or enable multi statement"
                              + " transactions. Disabled by default.")
                      .setDefaultValue(String.valueOf(DEFAULT_ENABLE_SESSION_VALUE))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(LOG_LEVEL_PROPERTY_NAME)
                      .setDescription(
                          "Sets the Log Level for the Driver. Set to Level.OFF by default.")
                      .setDefaultValue(String.valueOf(DEFAULT_LOG_LEVEL))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(USE_QUERY_CACHE_PROPERTY_NAME)
                      .setDescription("Enables or disables Query caching. Set to true by default.")
                      .setDefaultValue(String.valueOf(DEFAULT_USE_QUERY_CACHE))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(QUERY_DIALECT_PROPERTY_NAME)
                      .setDescription(
                          "Parameter for selecting if the queries should use standard or legacy SQL"
                              + " syntax.")
                      .setDefaultValue(DEFAULT_QUERY_DIALECT_VALUE)
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(ALLOW_LARGE_RESULTS_PROPERTY_NAME)
                      .setDescription(
                          "Enabled by default, must be used with legacy SQL. Used for setting"
                              + " destination table & dataset.")
                      .setDefaultValue(String.valueOf(DEFAULT_ALLOW_LARGE_RESULTS))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(LARGE_RESULTS_TABLE_PROPERTY_NAME)
                      .setDescription("The destination table where queries are saved.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(LARGE_RESULTS_DATASET_PROPERTY_NAME)
                      .setDescription("The destination dataset where queries are saved.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(JOB_CREATION_MODE_PROPERTY_NAME)
                      .setDescription(
                          "Enables or disables Stateless Query mode. Set to false by default.")
                      .setDefaultValue(String.valueOf(DEFAULT_JOB_CREATION_MODE))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(MAX_RESULTS_PROPERTY_NAME)
                      .setDescription("Maximum number of results per page")
                      .setDefaultValue(String.valueOf(DEFAULT_MAX_RESULTS_VALUE))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(BYOID_AUDIENCE_URI_PROPERTY_NAME)
                      .setDescription(
                          "Used for External Account Authentication. Corresponds to the audience"
                              + " property\n"
                              + " in the external account configuration file.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(BYOID_CREDENTIAL_SOURCE_PROPERTY_NAME)
                      .setDescription(
                          "Used for External Account Authentication. The file location or the URI"
                              + " of\n"
                              + " the subject token. Corresponds to the credential_source property"
                              + " in\n"
                              + " the external account configuration file.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(BYOID_POOL_USER_PROJECT_PROPERTY_NAME)
                      .setDescription(
                          "Used for External Account Authentication. The project number associated"
                              + " with\n"
                              + " the workforce pool. Corresponds to the"
                              + " workforce_pool_user_project\n"
                              + " property in the external account configuration file.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(BYOID_SA_IMPERSONATION_URI_PROPERTY_NAME)
                      .setDescription(
                          "Used for External Account Authentication. The service account email."
                              + " Only\n"
                              + " present when service account impersonation is used. Corresponds"
                              + " to\n"
                              + " the service_account_impersonation_url property in the external"
                              + " account\n"
                              + " configuration file.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(BYOID_SUBJECT_TOKEN_TYPE_PROPERTY_NAME)
                      .setDescription(
                          "Used for External Account Authentication. The subject token type."
                              + " Corresponds\n"
                              + " to the subject_token_type property in the external account"
                              + " configuration file.")
                      .setDefaultValue("urn:ietf:params:oauth:tokentype:id_token")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(BYOID_TOKEN_URI_PROPERTY_NAME)
                      .setDescription(
                          "Used for External Account Authentication. The URI used to generate"
                              + " authentication\n"
                              + " tokens. Corresponds to the token_url property in the external"
                              + " account\n"
                              + " configuration file.")
                      .setDefaultValue("https://sts.googleapis.com/v1/token")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(PARTNER_TOKEN_PROPERTY_NAME)
                      .setDescription("The partner name and environment.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(METADATA_FETCH_THREAD_COUNT_PROPERTY_NAME)
                      .setDescription(
                          "The number of threads used to call a DatabaseMetaData method.")
                      .setDefaultValue(String.valueOf(DEFAULT_METADATA_FETCH_THREAD_COUNT_VALUE))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(ENABLE_WRITE_API_PROPERTY_NAME)
                      .setDescription(
                          "Enables or disables Write API usage for bulk inserts in the Driver."
                              + " Disabled by default.")
                      .setDefaultValue(String.valueOf(DEFAULT_ENABLE_WRITE_API_VALUE))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(SWA_ACTIVATION_ROW_COUNT_PROPERTY_NAME)
                      .setDescription(
                          "Connector switches to BigQuery Storage Write API when the number of rows"
                              + " for executeBatch insert exceed this value. Do not change unless"
                              + " necessary.")
                      .setDefaultValue(String.valueOf(DEFAULT_SWA_ACTIVATION_ROW_COUNT_VALUE))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(SWA_APPEND_ROW_COUNT_PROPERTY_NAME)
                      .setDescription("Size of the write stream. Do not change unless necessary.")
                      .setDefaultValue(String.valueOf(DEFAULT_SWA_APPEND_ROW_COUNT_VALUE))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(ADDITIONAL_PROJECTS_PROPERTY_NAME)
                      .setDescription(
                          "A comma-separated list of Google Cloud project IDs that can be accessed"
                              + " for querying, in addition to the primary project specified in the"
                              + " connection.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(FILTER_TABLES_ON_DEFAULT_DATASET_PROPERTY_NAME)
                      .setDescription(
                          "If true and DefaultDataset is set, DatabaseMetaData.getTables() and"
                              + " .getColumns() will filter results based on the DefaultDataset"
                              + " when catalog/schema patterns are null or wildcards.")
                      .setDefaultValue(
                          String.valueOf(DEFAULT_FILTER_TABLES_ON_DEFAULT_DATASET_VALUE))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(REQUEST_GOOGLE_DRIVE_SCOPE_PROPERTY_NAME)
                      .setDescription(
                          "Enables or disables whether the connector requests access to Google"
                              + " Drive. Set to false (0) by default.")
                      .setDefaultValue(String.valueOf(DEFAULT_REQUEST_GOOGLE_DRIVE_SCOPE_VALUE))
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(SSL_TRUST_STORE_PROPERTY_NAME)
                      .setDescription(
                          "The full path of the Java TrustStore containing the server certificate"
                              + " for one-way SSL authentication.\n"
                              + "If the trust store requires a password, provide it using the"
                              + " property SSLTrustStorePwd.")
                      .build(),
                  BigQueryConnectionProperty.newBuilder()
                      .setName(SSL_TRUST_STORE_PWD_PROPERTY_NAME)
                      .setDescription(
                          "The password for accessing the Java TrustStore that is specified using"
                              + " the property SSLTrustStore.")
                      .build())));

  private BigQueryJdbcUrlUtility() {}

  /**
   * Parses a URI property from the given URI.
   *
   * @param uri The URI to parse.
   * @param property The name of the property to parse.
   * @return The String value of the property, or the default value if the property is not found.
   */
  static String parseUriProperty(String uri, String property) {
    Pattern pattern = Pattern.compile(String.format("(?is)(?:;|\\?)%s=(.*?)(?:;|$)", property));
    Matcher matcher = pattern.matcher(uri);
    if (matcher.find() && matcher.groupCount() == 1) {
      return CharEscapers.decodeUriPath(matcher.group(1));
    }
    return null;
  }

  /**
   * Appends the given properties to the given URL.
   *
   * @param url The URL to append the properties to.
   * @param properties The properties to append.
   * @return The string value of the updated URL.
   */
  static String appendPropertiesToURL(String url, String callerClassName, Properties properties) {
    LOG.finest("++enter++  " + callerClassName);
    StringBuilder urlBuilder = new StringBuilder(url);
    for (Entry<Object, Object> entry : properties.entrySet()) {
      if (entry.getValue() != null && !"".equals(entry.getValue())) {
        LOG.info(
            String.format("Appending %s with value %s to URL", entry.getKey(), entry.getValue()));
        urlBuilder.append(";").append(entry.getKey()).append("=").append(entry.getValue());
      }
    }
    return urlBuilder.toString();
  }

  static boolean convertIntToBoolean(String value, String propertyName) {
    int integerValue;

    try {
      if (value.equalsIgnoreCase("true")) {
        integerValue = 1;
      } else if (value.equalsIgnoreCase("false")) {
        integerValue = 0;
      } else {
        integerValue = Integer.parseInt(value);
      }

    } catch (NumberFormatException ex) {
      throw new IllegalArgumentException(
          String.format(
              "Invalid value for %s. For Boolean connection properties, use 0 for false and 1 for"
                  + " true.",
              propertyName),
          ex);
    }
    if (integerValue == 1) {
      return true;
    } else if (integerValue == 0) {
      return false;
    } else {
      throw new IllegalArgumentException(
          String.format(
              "Invalid value for %s. For Boolean connection properties, use 0 for false and 1 for"
                  + " true.",
              propertyName));
    }
  }

  // todo just make it a map
  static Map<String, String> parseQueryProperties(String url, String callerClassName) {
    return parsePropertiesMap(url, QUERY_PROPERTIES_NAME, callerClassName);
  }

  static Map<String, String> parseLabels(String url, String callerClassName) {
    return parsePropertiesMap(url, LABELS_PROPERTY_NAME, callerClassName);
  }

  static String parseStringProperty(
      String url, String propertyName, String defaultValue, String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);
    String parsedValue = BigQueryJdbcUrlUtility.parseUriProperty(url, propertyName);
    if (parsedValue != null) {
      return parsedValue;
    }
    return defaultValue;
  }

  static List<String> parseStringListProperty(
      String url, String propertyName, String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);
    String rawValue = parseStringProperty(url, propertyName, null, callerClassName);
    if (rawValue == null || rawValue.trim().isEmpty()) {
      return Collections.emptyList();
    }
    return Arrays.stream(rawValue.split(","))
        .map(String::trim)
        .filter(s -> !s.isEmpty())
        .collect(Collectors.toList());
  }

  public static String parsePartnerTokenProperty(String url, String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);
    // This property is expected to be set by partners only. For more details on exact format
    // supported, refer b/396086960
    String regex =
        PARTNER_TOKEN_PROPERTY_NAME + "=\\s*\\(\\s*(GPN:[^;]*?)\\s*(?:;\\s*([^)]*?))?\\s*\\)";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(url);

    if (matcher.find()) {
      String gpnPart = matcher.group(1);
      String environmentPart = matcher.group(2);
      StringBuilder partnerToken = new StringBuilder(" (");
      partnerToken.append(gpnPart);
      if (environmentPart != null && !environmentPart.trim().isEmpty()) {
        partnerToken.append("; ");
        partnerToken.append(environmentPart);
      }
      partnerToken.append(")");
      return partnerToken.toString();
    }
    return null;
  }

  static Integer parseIntProperty(
      String url, String propertyName, Integer defaultValue, String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);
    String parsedValue = BigQueryJdbcUrlUtility.parseUriProperty(url, propertyName);
    if (parsedValue != null) {
      try {
        return Integer.parseInt(parsedValue);
      } catch (NumberFormatException e) {
        LOG.severe(
            String.format(
                "Invalid integer value '%s' for property '%s'. Please provide a valid integer.",
                parsedValue, propertyName));
        throw new IllegalArgumentException(
            String.format("Invalid integer value for property '%s': %s", propertyName, parsedValue),
            e);
      }
    }
    return defaultValue;
  }

  static Long parseLongProperty(
      String url, String propertyName, Long defaultValue, String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);
    String parsedValue = BigQueryJdbcUrlUtility.parseUriProperty(url, propertyName);
    if (parsedValue != null) {
      return Long.parseLong(parsedValue);
    }
    return defaultValue;
  }

  static Boolean parseBooleanProperty(
      String url, String propertyName, Boolean defaultValue, String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);
    String parsedValue = BigQueryJdbcUrlUtility.parseUriProperty(url, propertyName);
    if (parsedValue != null) {
      return convertIntToBoolean(parsedValue, propertyName);
    }
    return defaultValue;
  }

  public static Level parseLogLevel(String logLevelString) {
    int logLevel = logLevelString != null ? Integer.parseInt(logLevelString) : DEFAULT_LOG_LEVEL;
    switch (logLevel) {
      case 8:
        return Level.ALL;
      case 7:
        return Level.FINEST;
      case 6:
        return Level.FINER;
      case 5:
        return Level.FINE;
      case 4:
        return Level.CONFIG;
      case 3:
        return Level.INFO;
      case 2:
        return Level.WARNING;
      case 1:
        return Level.SEVERE;
      case 0:
      default:
        LOG.info(
            String.format(
                "%s value not provided, defaulting to %s.", LOG_LEVEL_PROPERTY_NAME, Level.OFF));
        return Level.OFF;
    }
  }

  static Map<String, String> parseOverrideProperties(String url, String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);
    Map<String, String> overrideProps = new HashMap<>();
    Pattern pattern =
        Pattern.compile(
            String.format(
                "(?is)(%s|%s)=([^;]+)",
                ENDPOINT_OVERRIDES_PROPERTY_NAME, PRIVATE_SERVICE_CONNECT_PROPERTY_NAME));
    Matcher matcher = pattern.matcher(url);
    String overridePropertiesString;
    if (matcher.find() && matcher.groupCount() >= 1) {
      overridePropertiesString = matcher.group(2);
    } else {
      return overrideProps;
    }
    for (String property : OVERRIDE_PROPERTIES) {
      Pattern propertyPattern = Pattern.compile(String.format("(?i)%s=(.*?)(?:[,;]|$)", property));
      Matcher propertyMatcher = propertyPattern.matcher(overridePropertiesString);
      if (propertyMatcher.find() && propertyMatcher.groupCount() >= 1) {
        overrideProps.put(property, propertyMatcher.group(1));
      }
    }
    return overrideProps;
  }

  public static boolean parseJobCreationMode(String url, String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);

    String jobCreationMode =
        BigQueryJdbcUrlUtility.parseUriProperty(url, JOB_CREATION_MODE_PROPERTY_NAME);

    if (jobCreationMode == null) {
      LOG.fine(
          String.format(
              "%s value not provided, defaulting to %s. Caller: %s",
              JOB_CREATION_MODE_PROPERTY_NAME, DEFAULT_JOB_CREATION_MODE, callerClassName));
      // Default Job creation mode is JOB_CREATION_OPTIONAL(2)
      // which translates to options.setQueryPreviewEnabled(true)
      return true;
    }
    if (jobCreationMode.equalsIgnoreCase("1")) {
      return false;
    } else if (jobCreationMode.equalsIgnoreCase("2")) {
      return true;
    } else {
      throw new NumberFormatException(
          String.format(
              "Invalid value for %s. Use 1 for JOB_CREATION_REQUIRED and 2 for"
                  + " JOB_CREATION_OPTIONAL.",
              JOB_CREATION_MODE_PROPERTY_NAME));
    }
  }

  public static String parseBYOIDProperty(String url, String property, String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);

    String value = BigQueryJdbcUrlUtility.parseUriProperty(url, property);
    String defaultValue = BigQueryJdbcUrlUtility.getConnectionPropertyDefaultValue(property);
    if (value != null) {
      return value;
    } else if (defaultValue != null) {
      return defaultValue;
    }
    return null;
  }

  public static String getConnectionPropertyDefaultValue(String propertyName) {
    // TODO: change how we store properties because this method has to go through all of them
    for (BigQueryConnectionProperty property : VALID_PROPERTIES) {
      if (property.getName().equals(propertyName)) {
        return property.getDefaultValue();
      }
    }
    return null;
  }

  public static long parseRetryTimeoutInSecs(String url, String callerClassName) {
    return BigQueryJdbcUrlUtility.parseLongProperty(
        url,
        RETRY_TIMEOUT_IN_SECS_PROPERTY_NAME,
        DEFAULT_RETRY_TIMEOUT_IN_SECS_VALUE,
        callerClassName);
  }

  public static long parseJobTimeout(String url, String callerClassName) {
    return parseLongProperty(
        url, JOB_TIMEOUT_PROPERTY_NAME, DEFAULT_JOB_TIMEOUT_VALUE, callerClassName);
  }

  public static long parseRetryInitialDelayInSecs(String url, String callerClassName) {
    return BigQueryJdbcUrlUtility.parseLongProperty(
        url, RETRY_INITIAL_DELAY_PROPERTY_NAME, DEFAULT_RETRY_INITIAL_DELAY_VALUE, callerClassName);
  }

  public static long parseRetryMaxDelayInSecs(String url, String callerClassName) {
    return BigQueryJdbcUrlUtility.parseLongProperty(
        url, RETRY_MAX_DELAY_PROPERTY_NAME, DEFAULT_RETRY_MAX_DELAY_VALUE, callerClassName);
  }

  // Convenience Helper Methods
  public static long parseConnectionPoolSize(String url, String callerClassName) {
    if (url == null || url.isEmpty()) {
      throw new BigQueryJdbcRuntimeException("Connection url is empty");
    }
    return parseLongProperty(
        url,
        CONNECTION_POOL_SIZE_PROPERTY_NAME,
        DEFAULT_CONNECTION_POOL_SIZE_VALUE,
        callerClassName);
  }

  public static long parseListenerPoolSize(String url, String callerClassName) {
    if (url == null || url.isEmpty()) {
      throw new BigQueryJdbcRuntimeException("Connection url is empty");
    }
    return parseLongProperty(
        url, LISTENER_POOL_SIZE_PROPERTY_NAME, DEFAULT_LISTENER_POOL_SIZE_VALUE, callerClassName);
  }

  public static long parseMaximumBytesBilled(String url, String callerClassName) {
    if (url == null || url.isEmpty()) {
      throw new BigQueryJdbcRuntimeException("Connection url is empty");
    }
    return parseLongProperty(
        url, MAX_BYTES_BILLED_PROPERTY_NAME, DEFAULT_MAX_BYTES_BILLED_VALUE, callerClassName);
  }

  private static Map<String, String> parsePropertiesMap(
      String url, String propertyName, String callerClassName) {
    LOG.finest("++enter++\t" + callerClassName);
    String propertiesString = BigQueryJdbcUrlUtility.parseUriProperty(url, propertyName);
    if (propertiesString == null || propertiesString.isEmpty()) {
      LOG.fine(String.format("Unable to parse property name: %s from url: %s", propertyName, url));
      return null;
    }
    Map<String, String> propertiesMap = new HashMap<>();
    String[] keyValuePairs = propertiesString.split(",");

    for (String keyValuePair : keyValuePairs) {
      String[] parts = keyValuePair.split("=");
      if (parts.length == 2) {
        propertiesMap.put(parts[0], parts[1]);
      } else {
        LOG.warning(
            String.format(
                "Invalid KeyValue pair: %s found in url: %s for property name: %s",
                keyValuePair, url, propertyName));
      }
    }
    return propertiesMap;
  }
}
