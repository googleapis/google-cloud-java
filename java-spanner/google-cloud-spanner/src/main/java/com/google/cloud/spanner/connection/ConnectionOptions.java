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

package com.google.cloud.spanner.connection;

import static com.google.cloud.spanner.connection.ConnectionProperties.AUTOCOMMIT;
import static com.google.cloud.spanner.connection.ConnectionProperties.AUTO_CONFIG_EMULATOR;
import static com.google.cloud.spanner.connection.ConnectionProperties.AUTO_PARTITION_MODE;
import static com.google.cloud.spanner.connection.ConnectionProperties.CHANNEL_PROVIDER;
import static com.google.cloud.spanner.connection.ConnectionProperties.CLIENT_CERTIFICATE;
import static com.google.cloud.spanner.connection.ConnectionProperties.CLIENT_KEY;
import static com.google.cloud.spanner.connection.ConnectionProperties.CREDENTIALS_PROVIDER;
import static com.google.cloud.spanner.connection.ConnectionProperties.CREDENTIALS_URL;
import static com.google.cloud.spanner.connection.ConnectionProperties.DATABASE_ROLE;
import static com.google.cloud.spanner.connection.ConnectionProperties.DATA_BOOST_ENABLED;
import static com.google.cloud.spanner.connection.ConnectionProperties.DCP_INITIAL_CHANNELS;
import static com.google.cloud.spanner.connection.ConnectionProperties.DCP_MAX_CHANNELS;
import static com.google.cloud.spanner.connection.ConnectionProperties.DCP_MIN_CHANNELS;
import static com.google.cloud.spanner.connection.ConnectionProperties.DIALECT;
import static com.google.cloud.spanner.connection.ConnectionProperties.ENABLE_API_TRACING;
import static com.google.cloud.spanner.connection.ConnectionProperties.ENABLE_DIRECT_ACCESS;
import static com.google.cloud.spanner.connection.ConnectionProperties.ENABLE_DYNAMIC_CHANNEL_POOL;
import static com.google.cloud.spanner.connection.ConnectionProperties.ENABLE_END_TO_END_TRACING;
import static com.google.cloud.spanner.connection.ConnectionProperties.ENABLE_EXTENDED_TRACING;
import static com.google.cloud.spanner.connection.ConnectionProperties.ENCODED_CREDENTIALS;
import static com.google.cloud.spanner.connection.ConnectionProperties.ENDPOINT;
import static com.google.cloud.spanner.connection.ConnectionProperties.GRPC_INTERCEPTOR_PROVIDER;
import static com.google.cloud.spanner.connection.ConnectionProperties.IS_EXPERIMENTAL_HOST;
import static com.google.cloud.spanner.connection.ConnectionProperties.LENIENT;
import static com.google.cloud.spanner.connection.ConnectionProperties.MAX_COMMIT_DELAY;
import static com.google.cloud.spanner.connection.ConnectionProperties.MAX_PARTITIONED_PARALLELISM;
import static com.google.cloud.spanner.connection.ConnectionProperties.MAX_PARTITIONS;
import static com.google.cloud.spanner.connection.ConnectionProperties.MAX_SESSIONS;
import static com.google.cloud.spanner.connection.ConnectionProperties.MIN_SESSIONS;
import static com.google.cloud.spanner.connection.ConnectionProperties.NUM_CHANNELS;
import static com.google.cloud.spanner.connection.ConnectionProperties.OAUTH_TOKEN;
import static com.google.cloud.spanner.connection.ConnectionProperties.READONLY;
import static com.google.cloud.spanner.connection.ConnectionProperties.RETRY_ABORTS_INTERNALLY;
import static com.google.cloud.spanner.connection.ConnectionProperties.RETURN_COMMIT_STATS;
import static com.google.cloud.spanner.connection.ConnectionProperties.ROUTE_TO_LEADER;
import static com.google.cloud.spanner.connection.ConnectionProperties.TRACING_PREFIX;
import static com.google.cloud.spanner.connection.ConnectionProperties.TRACK_CONNECTION_LEAKS;
import static com.google.cloud.spanner.connection.ConnectionProperties.TRACK_SESSION_LEAKS;
import static com.google.cloud.spanner.connection.ConnectionProperties.UNIVERSE_DOMAIN;
import static com.google.cloud.spanner.connection.ConnectionProperties.USER_AGENT;
import static com.google.cloud.spanner.connection.ConnectionProperties.USE_AUTO_SAVEPOINTS_FOR_EMULATOR;
import static com.google.cloud.spanner.connection.ConnectionProperties.USE_PLAIN_TEXT;
import static com.google.cloud.spanner.connection.ConnectionProperties.USE_VIRTUAL_GRPC_TRANSPORT_THREADS;
import static com.google.cloud.spanner.connection.ConnectionProperties.USE_VIRTUAL_THREADS;
import static com.google.cloud.spanner.connection.ConnectionPropertyValue.cast;

import com.google.api.core.InternalApi;
import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.grpc.GrpcInterceptorProvider;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.auth.Credentials;
import com.google.auth.oauth2.AccessToken;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.auth.oauth2.ServiceAccountCredentials;
import com.google.cloud.NoCredentials;
import com.google.cloud.ServiceOptions;
import com.google.cloud.spanner.DatabaseId;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.ErrorCode;
import com.google.cloud.spanner.Options.RpcPriority;
import com.google.cloud.spanner.SessionPoolOptions;
import com.google.cloud.spanner.Spanner;
import com.google.cloud.spanner.SpannerException;
import com.google.cloud.spanner.SpannerExceptionFactory;
import com.google.cloud.spanner.SpannerOptions;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.GrpcInterceptorProviderConverter;
import com.google.cloud.spanner.connection.StatementExecutor.StatementExecutorType;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.base.Suppliers;
import com.google.common.collect.ImmutableMap;
import io.grpc.Deadline;
import io.grpc.Deadline.Ticker;
import io.opentelemetry.api.OpenTelemetry;
import java.io.IOException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;
import javax.annotation.Nullable;

/**
 * Internal connection API for Google Cloud Spanner. This class may introduce breaking changes
 * without prior notice.
 *
 * <p>Options for creating a {@link Connection} to a Google Cloud Spanner database.
 *
 * <p>Usage:
 *
 * <pre>
 * <!--SNIPPET {@link ConnectionOptions} usage-->
 * {@code
 * ConnectionOptions options = ConnectionOptions.newBuilder()
 *       .setUri("cloudspanner:/projects/my_project_id/instances/my_instance_id/databases/my_database_name?autocommit=false")
 *       .setCredentialsUrl("/home/cloudspanner-keys/my-key.json")
 *       .build();
 * try(Connection connection = options.getConnection()) {
 *   try(ResultSet rs = connection.executeQuery(Statement.of("SELECT SingerId, AlbumId, MarketingBudget FROM Albums"))) {
 *     while(rs.next()) {
 *       // do something
 *     }
 *   }
 * }
 * }
 * <!--SNIPPET {@link ConnectionOptions} usage-->
 * </pre>
 */
@InternalApi
public class ConnectionOptions {

  /**
   * Set this system property to true to enable transactional connection state by default for
   * PostgreSQL-dialect databases. The default is currently false.
   */
  public static String ENABLE_TRANSACTIONAL_CONNECTION_STATE_FOR_POSTGRESQL_PROPERTY =
      "spanner.enable_transactional_connection_state_for_postgresql";

  private static final LocalConnectionChecker LOCAL_CONNECTION_CHECKER =
      new LocalConnectionChecker();
  static final boolean DEFAULT_USE_PLAIN_TEXT = false;
  static final boolean DEFAULT_IS_EXPERIMENTAL_HOST = false;
  static final boolean DEFAULT_AUTOCOMMIT = true;
  static final boolean DEFAULT_READONLY = false;
  static final boolean DEFAULT_RETRY_ABORTS_INTERNALLY = true;
  static final boolean DEFAULT_USE_VIRTUAL_THREADS = false;
  static final boolean DEFAULT_USE_VIRTUAL_GRPC_TRANSPORT_THREADS = false;
  static final String DEFAULT_CREDENTIALS = null;
  static final String DEFAULT_CLIENT_CERTIFICATE = null;
  static final String DEFAULT_CLIENT_KEY = null;
  static final String DEFAULT_OAUTH_TOKEN = null;
  static final Integer DEFAULT_MIN_SESSIONS = null;
  static final Integer DEFAULT_MAX_SESSIONS = null;
  static final Integer DEFAULT_NUM_CHANNELS = null;
  static final Boolean DEFAULT_ENABLE_DYNAMIC_CHANNEL_POOL = null;
  static final Integer DEFAULT_DCP_MIN_CHANNELS = null;
  static final Integer DEFAULT_DCP_MAX_CHANNELS = null;
  static final Integer DEFAULT_DCP_INITIAL_CHANNELS = null;
  static final String DEFAULT_ENDPOINT = null;
  static final String DEFAULT_CHANNEL_PROVIDER = null;
  static final String DEFAULT_DATABASE_ROLE = null;
  static final String DEFAULT_USER_AGENT = null;
  static final String DEFAULT_OPTIMIZER_VERSION = "";
  static final String DEFAULT_OPTIMIZER_STATISTICS_PACKAGE = "";
  static final RpcPriority DEFAULT_RPC_PRIORITY = null;
  static final DdlInTransactionMode DEFAULT_DDL_IN_TRANSACTION_MODE =
      DdlInTransactionMode.ALLOW_IN_EMPTY_TRANSACTION;
  static final String DEFAULT_DEFAULT_SEQUENCE_KIND = null;
  static final boolean DEFAULT_RETURN_COMMIT_STATS = false;
  static final boolean DEFAULT_LENIENT = false;
  static final boolean DEFAULT_ROUTE_TO_LEADER = true;
  static final boolean DEFAULT_DELAY_TRANSACTION_START_UNTIL_FIRST_WRITE = false;
  static final boolean DEFAULT_KEEP_TRANSACTION_ALIVE = false;
  static final boolean DEFAULT_TRACK_SESSION_LEAKS = true;
  static final boolean DEFAULT_TRACK_CONNECTION_LEAKS = true;
  static final boolean DEFAULT_DATA_BOOST_ENABLED = false;
  static final boolean DEFAULT_AUTO_PARTITION_MODE = false;
  static final int DEFAULT_MAX_PARTITIONS = 0;
  static final int DEFAULT_MAX_PARTITIONED_PARALLELISM = 1;
  static final Boolean DEFAULT_ENABLE_EXTENDED_TRACING = null;
  static final Boolean DEFAULT_ENABLE_API_TRACING = null;
  static final boolean DEFAULT_ENABLE_END_TO_END_TRACING = false;
  static final boolean DEFAULT_AUTO_BATCH_DML = false;
  static final long DEFAULT_AUTO_BATCH_DML_UPDATE_COUNT = 1L;
  static final long DEFAULT_BATCH_DML_UPDATE_COUNT = -1L;
  static final boolean DEFAULT_AUTO_BATCH_DML_UPDATE_COUNT_VERIFICATION = true;
  private static final String EXPERIMENTAL_HOST_PROJECT_ID = "default";
  private static final String DEFAULT_EXPERIMENTAL_HOST_INSTANCE_ID = "default";

  private static final String PLAIN_TEXT_PROTOCOL = "http:";
  private static final String HOST_PROTOCOL = "https:";
  private static final String DEFAULT_HOST = "https://spanner.googleapis.com";
  private static final String SPANNER_EMULATOR_HOST_ENV_VAR = "SPANNER_EMULATOR_HOST";
  private static final String DEFAULT_EMULATOR_HOST = "http://localhost:9010";

  /** Use plain text is only for local testing purposes. */
  static final String USE_PLAIN_TEXT_PROPERTY_NAME = "usePlainText";

  /** Connect to a Experimental Host * */
  static final String IS_EXPERIMENTAL_HOST_PROPERTY_NAME = "isExperimentalHost";

  /** Client certificate path to establish mTLS */
  static final String CLIENT_CERTIFICATE_PROPERTY_NAME = "clientCertificate";

  /** Client key path to establish mTLS */
  static final String CLIENT_KEY_PROPERTY_NAME = "clientKey";

  /** Name of the 'autocommit' connection property. */
  public static final String AUTOCOMMIT_PROPERTY_NAME = "autocommit";

  /** Name of the 'readonly' connection property. */
  public static final String READONLY_PROPERTY_NAME = "readonly";

  /** Name of the 'routeToLeader' connection property. */
  public static final String ROUTE_TO_LEADER_PROPERTY_NAME = "routeToLeader";

  /** Name of the 'retry aborts internally' connection property. */
  public static final String RETRY_ABORTS_INTERNALLY_PROPERTY_NAME = "retryAbortsInternally";

  /** Name of the property to enable/disable virtual threads for the statement executor. */
  public static final String USE_VIRTUAL_THREADS_PROPERTY_NAME = "useVirtualThreads";

  /** Name of the property to enable/disable virtual threads for gRPC transport. */
  public static final String USE_VIRTUAL_GRPC_TRANSPORT_THREADS_PROPERTY_NAME =
      "useVirtualGrpcTransportThreads";

  /** Name of the 'credentials' connection property. */
  public static final String CREDENTIALS_PROPERTY_NAME = "credentials";

  /** Name of the 'encodedCredentials' connection property. */
  public static final String ENCODED_CREDENTIALS_PROPERTY_NAME = "encodedCredentials";

  public static final String ENABLE_ENCODED_CREDENTIALS_SYSTEM_PROPERTY =
      "ENABLE_ENCODED_CREDENTIALS";

  /** Name of the 'credentialsProvider' connection property. */
  public static final String CREDENTIALS_PROVIDER_PROPERTY_NAME = "credentialsProvider";

  public static final String ENABLE_CREDENTIALS_PROVIDER_SYSTEM_PROPERTY =
      "ENABLE_CREDENTIALS_PROVIDER";

  /**
   * OAuth token to use for authentication. Cannot be used in combination with a credentials file.
   */
  public static final String OAUTH_TOKEN_PROPERTY_NAME = "oauthToken";

  /** Name of the 'minSessions' connection property. */
  public static final String MIN_SESSIONS_PROPERTY_NAME = "minSessions";

  /** Name of the 'maxSessions' connection property. */
  public static final String MAX_SESSIONS_PROPERTY_NAME = "maxSessions";

  /** Name of the 'numChannels' connection property. */
  public static final String NUM_CHANNELS_PROPERTY_NAME = "numChannels";

  /** Name of the 'enableDynamicChannelPool' connection property. */
  public static final String ENABLE_DYNAMIC_CHANNEL_POOL_PROPERTY_NAME = "enableDynamicChannelPool";

  /** Name of the 'dcpMinChannels' connection property. */
  public static final String DCP_MIN_CHANNELS_PROPERTY_NAME = "dcpMinChannels";

  /** Name of the 'dcpMaxChannels' connection property. */
  public static final String DCP_MAX_CHANNELS_PROPERTY_NAME = "dcpMaxChannels";

  /** Name of the 'dcpInitialChannels' connection property. */
  public static final String DCP_INITIAL_CHANNELS_PROPERTY_NAME = "dcpInitialChannels";

  /** Name of the 'endpoint' connection property. */
  public static final String ENDPOINT_PROPERTY_NAME = "endpoint";

  /** Name of the 'channelProvider' connection property. */
  public static final String CHANNEL_PROVIDER_PROPERTY_NAME = "channelProvider";

  public static final String ENABLE_CHANNEL_PROVIDER_SYSTEM_PROPERTY = "ENABLE_CHANNEL_PROVIDER";

  public static final String ENABLE_GRPC_INTERCEPTOR_PROVIDER_SYSTEM_PROPERTY =
      "ENABLE_GRPC_INTERCEPTOR_PROVIDER";

  /** Custom user agent string is only for other Google libraries. */
  static final String USER_AGENT_PROPERTY_NAME = "userAgent";

  /** Query optimizer version to use for a connection. */
  static final String OPTIMIZER_VERSION_PROPERTY_NAME = "optimizerVersion";

  /** Query optimizer statistics package to use for a connection. */
  static final String OPTIMIZER_STATISTICS_PACKAGE_PROPERTY_NAME = "optimizerStatisticsPackage";

  /** Name of the 'lenientMode' connection property. */
  public static final String LENIENT_PROPERTY_NAME = "lenient";

  /** Name of the 'rpcPriority' connection property. */
  public static final String RPC_PRIORITY_NAME = "rpcPriority";

  public static final String DDL_IN_TRANSACTION_MODE_PROPERTY_NAME = "ddlInTransactionMode";
  public static final String DEFAULT_SEQUENCE_KIND_PROPERTY_NAME = "defaultSequenceKind";

  /** Dialect to use for a connection. */
  static final String DIALECT_PROPERTY_NAME = "dialect";

  /** Name of the 'databaseRole' connection property. */
  public static final String DATABASE_ROLE_PROPERTY_NAME = "databaseRole";

  /** Name of the 'delay transaction start until first write' property. */
  public static final String DELAY_TRANSACTION_START_UNTIL_FIRST_WRITE_NAME =
      "delayTransactionStartUntilFirstWrite";

  /** Name of the 'keep transaction alive' property. */
  public static final String KEEP_TRANSACTION_ALIVE_PROPERTY_NAME = "keepTransactionAlive";

  /** Name of the 'trackStackTraceOfSessionCheckout' connection property. */
  public static final String TRACK_SESSION_LEAKS_PROPERTY_NAME = "trackSessionLeaks";

  /** Name of the 'trackStackTraceOfConnectionCreation' connection property. */
  public static final String TRACK_CONNECTION_LEAKS_PROPERTY_NAME = "trackConnectionLeaks";

  public static final String DATA_BOOST_ENABLED_PROPERTY_NAME = "dataBoostEnabled";
  public static final String AUTO_PARTITION_MODE_PROPERTY_NAME = "autoPartitionMode";
  public static final String MAX_PARTITIONS_PROPERTY_NAME = "maxPartitions";
  public static final String MAX_PARTITIONED_PARALLELISM_PROPERTY_NAME =
      "maxPartitionedParallelism";

  public static final String ENABLE_EXTENDED_TRACING_PROPERTY_NAME = "enableExtendedTracing";
  public static final String ENABLE_API_TRACING_PROPERTY_NAME = "enableApiTracing";
  public static final String ENABLE_END_TO_END_TRACING_PROPERTY_NAME = "enableEndToEndTracing";

  public static final String AUTO_BATCH_DML_PROPERTY_NAME = "auto_batch_dml";
  public static final String AUTO_BATCH_DML_UPDATE_COUNT_PROPERTY_NAME =
      "auto_batch_dml_update_count";
  public static final String AUTO_BATCH_DML_UPDATE_COUNT_VERIFICATION_PROPERTY_NAME =
      "auto_batch_dml_update_count_verification";
  public static final String BATCH_DML_UPDATE_COUNT_PROPERTY_NAME = "batch_dml_update_count";

  private static final String GUARDED_CONNECTION_PROPERTY_ERROR_MESSAGE =
      "%s can only be used if the system property %s has been set to true. "
          + "Start the application with the JVM command line option -D%s=true";

  private static String generateGuardedConnectionPropertyError(
      String systemPropertyName, String connectionPropertyName) {
    return String.format(
        GUARDED_CONNECTION_PROPERTY_ERROR_MESSAGE,
        connectionPropertyName,
        systemPropertyName,
        systemPropertyName);
  }

  static boolean isEnableTransactionalConnectionStateForPostgreSQL() {
    return Boolean.parseBoolean(
        System.getProperty(ENABLE_TRANSACTIONAL_CONNECTION_STATE_FOR_POSTGRESQL_PROPERTY, "false"));
  }

  /**
   * Gets the default project-id for the current environment as defined by {@link
   * ServiceOptions#getDefaultProjectId()}, and if none could be found, the project-id of the given
   * credentials if it contains any.
   *
   * @param credentials The credentials to use to get the default project-id if none could be found
   *     in the environment.
   * @return the default project-id.
   */
  public static String getDefaultProjectId(Credentials credentials) {
    String projectId = SpannerOptions.getDefaultProjectId();
    if (projectId == null
        && credentials != null
        && credentials instanceof ServiceAccountCredentials) {
      projectId = ((ServiceAccountCredentials) credentials).getProjectId();
    }
    return projectId;
  }

  /**
   * Closes <strong>all</strong> {@link Spanner} instances that have been opened by connections
   * during the lifetime of this JVM. Call this method at the end of your application to free up
   * resources. You must close all {@link Connection}s that have been opened by your application
   * before calling this method. Failing to do so, will cause this method to throw a {@link
   * SpannerException}.
   *
   * <p>This method is also automatically called by a shutdown hook (see {@link
   * Runtime#addShutdownHook(Thread)}) when the JVM is shutdown gracefully.
   */
  public static void closeSpanner() {
    SpannerPool.INSTANCE.checkAndCloseSpanners();
  }

  /**
   * {@link SpannerOptionsConfigurator} can be used to add additional configuration for a {@link
   * Spanner} instance. Intended for tests.
   */
  @VisibleForTesting
  interface SpannerOptionsConfigurator {
    void configure(SpannerOptions.Builder options);
  }

  /**
   * {@link ExternalChannelProvider} can be used for to specify an external channel provider. This
   * is needed if you require different certificates than those provided by the standard grpc
   * channel provider.
   */
  public interface ExternalChannelProvider {
    TransportChannelProvider getChannelProvider(String host, int port);
  }

  /** Builder for {@link ConnectionOptions} instances. */
  public static class Builder {
    private final Map<String, ConnectionPropertyValue<?>> connectionPropertyValues =
        new HashMap<>();
    private String uri;
    private Credentials credentials;
    private StatementExecutorType statementExecutorType;
    private SessionPoolOptions sessionPoolOptions;
    private List<StatementExecutionInterceptor> statementExecutionInterceptors =
        Collections.emptyList();
    private SpannerOptionsConfigurator configurator;
    private OpenTelemetry openTelemetry;
    private Ticker ticker = Deadline.getSystemTicker();

    private Builder() {}

    /** Spanner {@link ConnectionOptions} URI format. */
    public static final String SPANNER_URI_FORMAT =
        "(?:(?:spanner|cloudspanner):)(?<HOSTGROUP>//[\\w.-]+(?:\\.[\\w\\.-]+)*[\\w\\-\\._~:/?#\\[\\]@!\\$&'\\(\\)\\*\\+,;=.]+)?/projects/(?<PROJECTGROUP>(([a-z]|[-.:]|[0-9])+|(DEFAULT_PROJECT_ID)))(/instances/(?<INSTANCEGROUP>([a-z]|[-]|[0-9])+)(/databases/(?<DATABASEGROUP>([a-z]|[-]|[_]|[0-9])+))?)?(?:[?|;].*)?";

    public static final String EXTERNAL_HOST_FORMAT =
        "(?:(?:spanner|cloudspanner):)(?<HOSTGROUP>//[\\w.-]+(?::\\d+)?)(/instances/(?<INSTANCEGROUP>[a-z0-9-]+))?(/databases/(?<DATABASEGROUP>[a-z0-9_-]+))(?:[?;].*)?";
    private static final String SPANNER_URI_REGEX = "(?is)^" + SPANNER_URI_FORMAT + "$";

    @VisibleForTesting
    static final Pattern SPANNER_URI_PATTERN = Pattern.compile(SPANNER_URI_REGEX);

    @VisibleForTesting
    static final Pattern EXTERNAL_HOST_PATTERN = Pattern.compile(EXTERNAL_HOST_FORMAT);

    private static final String HOST_GROUP = "HOSTGROUP";
    private static final String PROJECT_GROUP = "PROJECTGROUP";
    private static final String INSTANCE_GROUP = "INSTANCEGROUP";
    private static final String DATABASE_GROUP = "DATABASEGROUP";
    private static final String DEFAULT_PROJECT_ID_PLACEHOLDER = "DEFAULT_PROJECT_ID";

    private boolean isValidUri(String uri) {
      return SPANNER_URI_PATTERN.matcher(uri).matches();
    }

    private boolean isValidExperimentalHostUri(String uri) {
      return EXTERNAL_HOST_PATTERN.matcher(uri).matches();
    }

    /**
     * Sets the URI of the Cloud Spanner database to connect to. A connection URI must be specified
     * in this format:
     *
     * <pre>
     * cloudspanner:[//host[:port]]/projects/project-id[/instances/instance-id[/databases/database-name]][\?property-name=property-value[;property-name=property-value]*]?
     * </pre>
     *
     * The property-value strings should be url-encoded.
     *
     * <p>The project-id part of the URI may be filled with the placeholder DEFAULT_PROJECT_ID. This
     * placeholder will be replaced by the default project id of the environment that is requesting
     * a connection.
     *
     * <p>The supported properties are:
     *
     * <ul>
     *   <li>credentials (String): URL for the credentials file to use for the connection. This
     *       property is only used if no credentials have been specified using the {@link
     *       ConnectionOptions.Builder#setCredentialsUrl(String)} method. If you do not specify any
     *       credentials at all, the default credentials of the environment as returned by {@link
     *       GoogleCredentials#getApplicationDefault()} will be used.
     *   <li>encodedCredentials (String): A Base64 encoded string containing the Google credentials
     *       to use. You should only set either this property or the `credentials` (file location)
     *       property, but not both at the same time.
     *   <li>credentialsProvider (String): Class name of the {@link
     *       com.google.api.gax.core.CredentialsProvider} that should be used to get credentials for
     *       a connection that is created by this {@link ConnectionOptions}. The credentials will be
     *       retrieved from the {@link com.google.api.gax.core.CredentialsProvider} when a new
     *       connection is created. A connection will use the credentials that were obtained at
     *       creation during its lifetime.
     *   <li>autocommit (boolean): Sets the initial autocommit mode for the connection. Default is
     *       true.
     *   <li>readonly (boolean): Sets the initial readonly mode for the connection. Default is
     *       false.
     *   <li>minSessions (int): Sets the minimum number of sessions in the backing session pool.
     *   <li>maxSessions (int): Sets the maximum number of sessions in the backing session pool.
     *   <li>numChannels (int): Sets the number of gRPC channels to use for the connection.
     *   <li>retryAbortsInternally (boolean): Sets the initial retryAbortsInternally mode for the
     *       connection. Default is true.
     *   <li>optimizerVersion (string): Sets the query optimizer version to use for the connection.
     *   <li>autoConfigEmulator (boolean): Automatically configures the connection to connect to the
     *       Cloud Spanner emulator. If no host and port is specified in the connection string, the
     *       connection will automatically use the default emulator host/port combination
     *       (localhost:9010). Plain text communication will be enabled and authentication will be
     *       disabled. The instance and database in the connection string will automatically be
     *       created on the emulator if any of them do not yet exist. Any existing instance or
     *       database on the emulator will remain untouched. No other configuration is needed in
     *       order to connect to the emulator than setting this property.
     *   <li>routeToLeader (boolean): Sets the routeToLeader flag to route requests to leader (true)
     *       or any region (false) in read/write transactions and Partitioned DML. Default is true.
     * </ul>
     *
     * @param uri The URI of the Spanner database to connect to.
     * @return this builder
     */
    public Builder setUri(String uri) {
      if (!isValidExperimentalHostUri(uri)) {
        Preconditions.checkArgument(
            isValidUri(uri),
            "The specified URI is not a valid Cloud Spanner connection URI. Please specify a URI in"
                + " the format"
                + " \"cloudspanner:[//host[:port]]/projects/project-id[/instances/instance-id[/databases/database-name]][\\?property-name=property-value[;property-name=property-value]*]?\"");
      }
      ConnectionPropertyValue<Boolean> value =
          cast(ConnectionProperties.parseValues(uri).get(LENIENT.getKey()));
      checkValidProperties(value != null && value.getValue(), uri);
      this.uri = uri;
      return this;
    }

    <T> Builder setConnectionPropertyValue(
        com.google.cloud.spanner.connection.ConnectionProperty<T> property, T value) {
      this.connectionPropertyValues.put(
          property.getKey(), new ConnectionPropertyValue<>(property, value, value));
      return this;
    }

    /** Sets the {@link SessionPoolOptions} to use for the connection. */
    public Builder setSessionPoolOptions(SessionPoolOptions sessionPoolOptions) {
      Preconditions.checkNotNull(sessionPoolOptions);
      this.sessionPoolOptions = sessionPoolOptions;
      return this;
    }

    /**
     * Sets the URL of the credentials file to use for this connection. The URL may be a reference
     * to a file on the local file system, or to a file on Google Cloud Storage. References to
     * Google Cloud Storage files are only allowed when the application is running on Google Cloud
     * and the environment has access to the specified storage location. It also requires that the
     * Google Cloud Storage client library is present on the class path. The Google Cloud Storage
     * library is not automatically added as a dependency by the JDBC driver.
     *
     * <p>If you do not specify a credentialsUrl (either by using this setter, or by specifying on
     * the connection URI), the credentials returned by {@link
     * GoogleCredentials#getApplicationDefault()} will be used for the connection.
     *
     * @param credentialsUrl A valid file or Google Cloud Storage URL for the credentials file to be
     *     used.
     * @return this builder
     */
    public Builder setCredentialsUrl(String credentialsUrl) {
      setConnectionPropertyValue(CREDENTIALS_URL, credentialsUrl);
      return this;
    }

    /**
     * Sets the OAuth token to use with this connection. The token must be a valid token with access
     * to the resources (project/instance/database) that the connection will be accessing. This
     * authentication method cannot be used in combination with a credentials file. If both an OAuth
     * token and a credentials file is specified, the {@link #build()} method will throw an
     * exception.
     *
     * @param oauthToken A valid OAuth token for the Google Cloud project that is used by this
     *     connection.
     * @return this builder
     */
    public Builder setOAuthToken(String oauthToken) {
      setConnectionPropertyValue(OAUTH_TOKEN, oauthToken);
      return this;
    }

    @VisibleForTesting
    Builder setStatementExecutionInterceptors(List<StatementExecutionInterceptor> interceptors) {
      this.statementExecutionInterceptors = interceptors;
      return this;
    }

    @VisibleForTesting
    Builder setConfigurator(SpannerOptionsConfigurator configurator) {
      this.configurator = Preconditions.checkNotNull(configurator);
      return this;
    }

    @VisibleForTesting
    Builder setCredentials(Credentials credentials) {
      this.credentials = credentials;
      return this;
    }

    @VisibleForTesting
    Builder setTicker(Ticker ticker) {
      this.ticker = Preconditions.checkNotNull(ticker);
      return this;
    }

    /**
     * Sets the executor type to use for connections. See {@link StatementExecutorType} for more
     * information on what the different options mean.
     */
    public Builder setStatementExecutorType(StatementExecutorType statementExecutorType) {
      this.statementExecutorType = statementExecutorType;
      return this;
    }

    public Builder setOpenTelemetry(OpenTelemetry openTelemetry) {
      this.openTelemetry = openTelemetry;
      return this;
    }

    public Builder setTracingPrefix(String tracingPrefix) {
      setConnectionPropertyValue(TRACING_PREFIX, tracingPrefix);
      return this;
    }

    /**
     * @return the {@link ConnectionOptions}
     */
    public ConnectionOptions build() {
      Preconditions.checkState(this.uri != null, "Connection URI is required");
      return new ConnectionOptions(this);
    }
  }

  /**
   * Create a {@link Builder} for {@link ConnectionOptions}. Use this method to create {@link
   * ConnectionOptions} that can be used to obtain a {@link Connection}.
   *
   * @return a new {@link Builder}
   */
  public static Builder newBuilder() {
    return new Builder();
  }

  private final ConnectionState initialConnectionState;
  private final String uri;
  private final String warnings;
  private final Credentials fixedCredentials;

  private final String host;
  private final String projectId;
  private final String instanceId;
  private final String databaseName;
  private final Credentials credentials;
  private final StatementExecutorType statementExecutorType;
  private final SessionPoolOptions sessionPoolOptions;

  private final OpenTelemetry openTelemetry;
  private final List<StatementExecutionInterceptor> statementExecutionInterceptors;
  private final SpannerOptionsConfigurator configurator;
  private final Ticker ticker;

  private ConnectionOptions(Builder builder) {
    Matcher matcher;
    boolean isExperimentalHostPattern = false;
    if (builder.isValidExperimentalHostUri(builder.uri)) {
      matcher = Builder.EXTERNAL_HOST_PATTERN.matcher(builder.uri);
      isExperimentalHostPattern = true;
    } else {
      matcher = Builder.SPANNER_URI_PATTERN.matcher(builder.uri);
    }
    Preconditions.checkArgument(
        matcher.find(), String.format("Invalid connection URI specified: %s", builder.uri));

    ImmutableMap<String, ConnectionPropertyValue<?>> connectionPropertyValues =
        ImmutableMap.<String, ConnectionPropertyValue<?>>builder()
            .putAll(ConnectionProperties.parseValues(builder.uri))
            .putAll(builder.connectionPropertyValues)
            .buildKeepingLast();
    this.uri = builder.uri;
    ConnectionPropertyValue<Boolean> value = cast(connectionPropertyValues.get(LENIENT.getKey()));
    this.warnings = checkValidProperties(value != null && value.getValue(), uri);
    this.fixedCredentials = builder.credentials;
    this.statementExecutorType = builder.statementExecutorType;

    this.openTelemetry = builder.openTelemetry;
    this.statementExecutionInterceptors =
        Collections.unmodifiableList(builder.statementExecutionInterceptors);
    this.configurator = builder.configurator;
    this.ticker = builder.ticker;

    // Create the initial connection state from the parsed properties in the connection URL.
    this.initialConnectionState = new ConnectionState(connectionPropertyValues);

    checkGuardedProperty(
        getInitialConnectionPropertyValue(ENCODED_CREDENTIALS),
        ENABLE_ENCODED_CREDENTIALS_SYSTEM_PROPERTY,
        ENCODED_CREDENTIALS_PROPERTY_NAME);
    checkGuardedProperty(
        getInitialConnectionPropertyValue(CREDENTIALS_PROVIDER) == null
            ? null
            : getInitialConnectionPropertyValue(CREDENTIALS_PROVIDER).getClass().getName(),
        ENABLE_CREDENTIALS_PROVIDER_SYSTEM_PROPERTY,
        CREDENTIALS_PROVIDER_PROPERTY_NAME);
    checkGuardedProperty(
        getInitialConnectionPropertyValue(CHANNEL_PROVIDER),
        ENABLE_CHANNEL_PROVIDER_SYSTEM_PROPERTY,
        CHANNEL_PROVIDER_PROPERTY_NAME);
    checkGuardedProperty(
        getInitialConnectionPropertyValue(GRPC_INTERCEPTOR_PROVIDER),
        ENABLE_GRPC_INTERCEPTOR_PROVIDER_SYSTEM_PROPERTY,
        GRPC_INTERCEPTOR_PROVIDER.getName());
    // Check that at most one of credentials location, encoded credentials, credentials provider and
    // OUAuth token has been specified in the connection URI.
    Preconditions.checkArgument(
        Stream.of(
                    getInitialConnectionPropertyValue(CREDENTIALS_URL),
                    getInitialConnectionPropertyValue(ENCODED_CREDENTIALS),
                    getInitialConnectionPropertyValue(CREDENTIALS_PROVIDER),
                    getInitialConnectionPropertyValue(OAUTH_TOKEN))
                .filter(Objects::nonNull)
                .count()
            <= 1,
        "Specify only one of credentialsUrl, encodedCredentials, credentialsProvider and OAuth"
            + " token");

    boolean usePlainText =
        getInitialConnectionPropertyValue(AUTO_CONFIG_EMULATOR)
            || getInitialConnectionPropertyValue(USE_PLAIN_TEXT);
    this.host =
        determineHost(
            matcher,
            getInitialConnectionPropertyValue(ENDPOINT),
            getInitialConnectionPropertyValue(AUTO_CONFIG_EMULATOR),
            usePlainText,
            System.getenv());
    GoogleCredentials defaultExperimentalHostCredentials =
        SpannerOptions.getDefaultExperimentalCredentialsFromSysEnv();
    // Using credentials on a plain text connection is not allowed, so if the user has not specified
    // any credentials and is using a plain text connection, we should not try to get the
    // credentials from the environment, but default to NoCredentials.
    if (this.fixedCredentials == null
        && getInitialConnectionPropertyValue(CREDENTIALS_URL) == null
        && getInitialConnectionPropertyValue(ENCODED_CREDENTIALS) == null
        && getInitialConnectionPropertyValue(CREDENTIALS_PROVIDER) == null
        && getInitialConnectionPropertyValue(OAUTH_TOKEN) == null
        && usePlainText) {
      this.credentials = NoCredentials.getInstance();
    } else if (getInitialConnectionPropertyValue(OAUTH_TOKEN) != null) {
      this.credentials =
          new GoogleCredentials(
              new AccessToken(getInitialConnectionPropertyValue(OAUTH_TOKEN), null));
    } else if ((isExperimentalHostPattern || isExperimentalHost())
        && defaultExperimentalHostCredentials != null) {
      this.credentials = defaultExperimentalHostCredentials;
    } else if (getInitialConnectionPropertyValue(CREDENTIALS_PROVIDER) != null) {
      try {
        this.credentials = getInitialConnectionPropertyValue(CREDENTIALS_PROVIDER).getCredentials();
      } catch (IOException exception) {
        throw SpannerExceptionFactory.newSpannerException(
            ErrorCode.INVALID_ARGUMENT,
            "Failed to get credentials from CredentialsProvider: " + exception.getMessage(),
            exception);
      }
    } else if (this.fixedCredentials != null) {
      this.credentials = fixedCredentials;
    } else if (getInitialConnectionPropertyValue(ENCODED_CREDENTIALS) != null) {
      this.credentials =
          getCredentialsService()
              .decodeCredentials(getInitialConnectionPropertyValue(ENCODED_CREDENTIALS));
    } else {
      this.credentials =
          getCredentialsService()
              .createCredentials(getInitialConnectionPropertyValue(CREDENTIALS_URL));
    }

    if (getInitialConnectionPropertyValue(MIN_SESSIONS) != null
        || getInitialConnectionPropertyValue(MAX_SESSIONS) != null
        || !getInitialConnectionPropertyValue(TRACK_SESSION_LEAKS)) {
      SessionPoolOptions.Builder sessionPoolOptionsBuilder =
          builder.sessionPoolOptions == null
              ? SessionPoolOptions.newBuilder()
              : builder.sessionPoolOptions.toBuilder();
      sessionPoolOptionsBuilder.setTrackStackTraceOfSessionCheckout(
          getInitialConnectionPropertyValue(TRACK_SESSION_LEAKS));
      sessionPoolOptionsBuilder.setAutoDetectDialect(true);
      if (getInitialConnectionPropertyValue(MIN_SESSIONS) != null) {
        sessionPoolOptionsBuilder.setMinSessions(getInitialConnectionPropertyValue(MIN_SESSIONS));
      }
      if (getInitialConnectionPropertyValue(MAX_SESSIONS) != null) {
        sessionPoolOptionsBuilder.setMaxSessions(getInitialConnectionPropertyValue(MAX_SESSIONS));
      }
      this.sessionPoolOptions = sessionPoolOptionsBuilder.build();
    } else if (builder.sessionPoolOptions != null) {
      this.sessionPoolOptions = builder.sessionPoolOptions;
    } else if (isExperimentalHostPattern || isExperimentalHost()) {
      this.sessionPoolOptions =
          SessionPoolOptions.newBuilder().setExperimentalHost().setAutoDetectDialect(true).build();
    } else {
      this.sessionPoolOptions = SessionPoolOptions.newBuilder().setAutoDetectDialect(true).build();
    }

    String projectId = EXPERIMENTAL_HOST_PROJECT_ID;
    String instanceId = matcher.group(Builder.INSTANCE_GROUP);
    if (!isExperimentalHost() && !isExperimentalHostPattern) {
      projectId = matcher.group(Builder.PROJECT_GROUP);
    } else if (instanceId == null && isExperimentalHost()) {
      instanceId = DEFAULT_EXPERIMENTAL_HOST_INSTANCE_ID;
    }
    if (Builder.DEFAULT_PROJECT_ID_PLACEHOLDER.equalsIgnoreCase(projectId)) {
      projectId = getDefaultProjectId(this.credentials);
    }
    this.projectId = projectId;
    this.instanceId = instanceId;
    this.databaseName = matcher.group(Builder.DATABASE_GROUP);
  }

  @VisibleForTesting
  static String determineHost(
      Matcher matcher,
      String endpoint,
      boolean autoConfigEmulator,
      boolean usePlainText,
      Map<String, String> environment) {
    String host = null;
    if (Objects.equals(endpoint, DEFAULT_ENDPOINT) && matcher.group(Builder.HOST_GROUP) == null) {
      if (autoConfigEmulator) {
        if (Strings.isNullOrEmpty(environment.get(SPANNER_EMULATOR_HOST_ENV_VAR))) {
          return DEFAULT_EMULATOR_HOST;
        } else {
          return PLAIN_TEXT_PROTOCOL + "//" + environment.get(SPANNER_EMULATOR_HOST_ENV_VAR);
        }
      }
    } else if (!Objects.equals(endpoint, DEFAULT_ENDPOINT)) {
      // Add '//' at the start of the endpoint to conform to the standard URL specification.
      host = "//" + endpoint;
    } else {
      // The leading '//' is already included in the regex for the connection URL, so we don't need
      // to add the leading '//' to the host name here.
      host = matcher.group(Builder.HOST_GROUP);
      if (Builder.EXTERNAL_HOST_FORMAT.equals(matcher.pattern().pattern())
          && !host.matches(".*:\\d+$")) {
        host = String.format("%s:15000", host);
      }
    }
    if (host == null) {
      return null;
    }
    if (usePlainText) {
      return PLAIN_TEXT_PROTOCOL + host;
    }
    return HOST_PROTOCOL + host;
  }

  /**
   * @return an instance of OpenTelemetry. If OpenTelemetry object is not set then <code>null</code>
   *     will be returned.
   */
  OpenTelemetry getOpenTelemetry() {
    return this.openTelemetry;
  }

  SpannerOptionsConfigurator getConfigurator() {
    return configurator;
  }

  Ticker getTicker() {
    return ticker;
  }

  @VisibleForTesting
  CredentialsService getCredentialsService() {
    return CredentialsService.INSTANCE;
  }

  private static void checkGuardedProperty(
      String value, String systemPropertyName, String connectionPropertyName) {
    if (!Strings.isNullOrEmpty(value)
        && !Boolean.parseBoolean(System.getProperty(systemPropertyName))) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.FAILED_PRECONDITION,
          generateGuardedConnectionPropertyError(systemPropertyName, connectionPropertyName));
    }
  }

  @VisibleForTesting
  static String parseUriProperty(String uri, String property) {
    Pattern pattern = Pattern.compile(String.format("(?is)(?:;|\\?)%s=(.*?)(?:;|$)", property));
    Matcher matcher = pattern.matcher(uri);
    if (matcher.find() && matcher.groupCount() == 1) {
      return matcher.group(1);
    }
    return null;
  }

  /** Check that only valid properties have been specified. */
  @VisibleForTesting
  static String checkValidProperties(boolean lenient, String uri) {
    StringBuilder invalidProperties = new StringBuilder();
    List<String> properties = parseProperties(uri);
    for (String property : properties) {
      if (!ConnectionProperties.CONNECTION_PROPERTIES.containsKey(
          property.toLowerCase(Locale.ENGLISH))) {
        if (invalidProperties.length() > 0) {
          invalidProperties.append(", ");
        }
        invalidProperties.append(property);
      }
    }
    if (lenient) {
      return String.format("Invalid properties found in connection URI: %s", invalidProperties);
    } else {
      Preconditions.checkArgument(
          invalidProperties.length() == 0,
          String.format(
              "Invalid properties found in connection URI. Add lenient=true to the connection"
                  + " string to ignore unknown properties. Invalid properties: %s",
              invalidProperties));
      return null;
    }
  }

  @VisibleForTesting
  static List<String> parseProperties(String uri) {
    Pattern pattern = Pattern.compile("(?is)(?:\\?|;)(?<PROPERTY>.*?)=(?:.*?)");
    Matcher matcher = pattern.matcher(uri);
    List<String> res = new ArrayList<>();
    while (matcher.find() && matcher.group("PROPERTY") != null) {
      res.add(matcher.group("PROPERTY"));
    }
    return res;
  }

  static long tryParseLong(String value, long defaultValue) {
    try {
      return Long.parseLong(value);
    } catch (NumberFormatException ignore) {
      return defaultValue;
    }
  }

  /**
   * Create a new {@link Connection} from this {@link ConnectionOptions}. Calling this method
   * multiple times for the same {@link ConnectionOptions} will return multiple instances of {@link
   * Connection}s to the same database.
   *
   * @return a new {@link Connection} to the database referenced by this {@link ConnectionOptions}
   */
  public Connection getConnection() {
    LOCAL_CONNECTION_CHECKER.checkLocalConnection(this);
    return new ConnectionImpl(this);
  }

  /** The URI of this {@link ConnectionOptions} */
  public String getUri() {
    return uri;
  }

  /** The connection properties that have been pre-set for this {@link ConnectionOptions}. */
  Map<String, ConnectionPropertyValue<?>> getInitialConnectionPropertyValues() {
    return this.initialConnectionState.getAllValues();
  }

  <T> T getInitialConnectionPropertyValue(
      com.google.cloud.spanner.connection.ConnectionProperty<T> property) {
    return this.initialConnectionState.getValue(property).getValue();
  }

  /** The credentials URL of this {@link ConnectionOptions} */
  public String getCredentialsUrl() {
    return getInitialConnectionPropertyValue(CREDENTIALS_URL);
  }

  String getOAuthToken() {
    return getInitialConnectionPropertyValue(OAUTH_TOKEN);
  }

  Credentials getFixedCredentials() {
    return this.fixedCredentials;
  }

  CredentialsProvider getCredentialsProvider() {
    return getInitialConnectionPropertyValue(CREDENTIALS_PROVIDER);
  }

  /**
   * Returns the executor type that is used by connections that are created from this {@link
   * ConnectionOptions} instance.
   */
  public StatementExecutorType getStatementExecutorType() {
    return this.statementExecutorType;
  }

  /** The {@link SessionPoolOptions} of this {@link ConnectionOptions}. */
  public SessionPoolOptions getSessionPoolOptions() {
    return sessionPoolOptions;
  }

  /**
   * The minimum number of sessions in the backing session pool of this connection. The session pool
   * is shared between all connections in the same JVM that connect to the same Cloud Spanner
   * database using the same connection settings.
   */
  public Integer getMinSessions() {
    return getInitialConnectionPropertyValue(MIN_SESSIONS);
  }

  /**
   * The maximum number of sessions in the backing session pool of this connection. The session pool
   * is shared between all connections in the same JVM that connect to the same Cloud Spanner
   * database using the same connection settings.
   */
  public Integer getMaxSessions() {
    return getInitialConnectionPropertyValue(MAX_SESSIONS);
  }

  /** The number of channels to use for the connection. */
  public Integer getNumChannels() {
    return getInitialConnectionPropertyValue(NUM_CHANNELS);
  }

  /** Whether dynamic channel pooling is enabled for this connection. */
  public Boolean isEnableDynamicChannelPool() {
    return getInitialConnectionPropertyValue(ENABLE_DYNAMIC_CHANNEL_POOL);
  }

  /** The minimum number of channels in the dynamic channel pool. */
  public Integer getDcpMinChannels() {
    return getInitialConnectionPropertyValue(DCP_MIN_CHANNELS);
  }

  /** The maximum number of channels in the dynamic channel pool. */
  public Integer getDcpMaxChannels() {
    return getInitialConnectionPropertyValue(DCP_MAX_CHANNELS);
  }

  /** The initial number of channels in the dynamic channel pool. */
  public Integer getDcpInitialChannels() {
    return getInitialConnectionPropertyValue(DCP_INITIAL_CHANNELS);
  }

  /** Calls the getChannelProvider() method from the supplied class. */
  public TransportChannelProvider getChannelProvider() {
    String channelProvider = getInitialConnectionPropertyValue(CHANNEL_PROVIDER);
    if (channelProvider == null) {
      return null;
    }
    try {
      URL url = new URL(MoreObjects.firstNonNull(host, DEFAULT_HOST));
      ExternalChannelProvider provider =
          ExternalChannelProvider.class.cast(Class.forName(channelProvider).newInstance());
      return provider.getChannelProvider(url.getHost(), url.getPort());
    } catch (Exception e) {
      throw SpannerExceptionFactory.newSpannerException(
          ErrorCode.INVALID_ARGUMENT,
          String.format(
              "%s : Failed to create channel with external provider: %s",
              e.toString(), channelProvider));
    }
  }

  String getGrpcInterceptorProviderName() {
    return getInitialConnectionPropertyValue(GRPC_INTERCEPTOR_PROVIDER);
  }

  /** Returns the gRPC interceptor provider that has been configured. */
  public GrpcInterceptorProvider getGrpcInterceptorProvider() {
    String interceptorProvider = getInitialConnectionPropertyValue(GRPC_INTERCEPTOR_PROVIDER);
    if (interceptorProvider == null) {
      return null;
    }
    return GrpcInterceptorProviderConverter.INSTANCE.convert(interceptorProvider);
  }

  /**
   * The database role that is used for this connection. Assigning a role to a connection can be
   * used to for example restrict the access of a connection to a specific set of tables.
   */
  public String getDatabaseRole() {
    return getInitialConnectionPropertyValue(DATABASE_ROLE);
  }

  /** The host and port number that this {@link ConnectionOptions} will connect to */
  public String getHost() {
    return host;
  }

  /** The Google Project ID that this {@link ConnectionOptions} will connect to */
  public String getProjectId() {
    return projectId;
  }

  /** The Spanner Instance ID that this {@link ConnectionOptions} will connect to */
  public String getInstanceId() {
    return instanceId;
  }

  /** The Spanner database name that this {@link ConnectionOptions} will connect to */
  public String getDatabaseName() {
    return databaseName;
  }

  /** The Spanner {@link DatabaseId} that this {@link ConnectionOptions} will connect to */
  public DatabaseId getDatabaseId() {
    Preconditions.checkState(projectId != null, "Project ID is not specified");
    Preconditions.checkState(instanceId != null, "Instance ID is not specified");
    Preconditions.checkState(databaseName != null, "Database name is not specified");
    return DatabaseId.of(projectId, instanceId, databaseName);
  }

  /**
   * The {@link Credentials} of this {@link ConnectionOptions}. This is either the credentials
   * specified in the credentialsUrl or the default Google application credentials
   */
  public Credentials getCredentials() {
    return credentials;
  }

  /** The initial autocommit value for connections created by this {@link ConnectionOptions} */
  public boolean isAutocommit() {
    return getInitialConnectionPropertyValue(AUTOCOMMIT);
  }

  /** The initial readonly value for connections created by this {@link ConnectionOptions} */
  public boolean isReadOnly() {
    return getInitialConnectionPropertyValue(READONLY);
  }

  /**
   * Whether read/write transactions and partitioned DML are preferred to be routed to the leader
   * region.
   */
  public boolean isRouteToLeader() {
    return getInitialConnectionPropertyValue(ROUTE_TO_LEADER);
  }

  /** Whether end-to-end tracing is enabled. */
  public boolean isEndToEndTracingEnabled() {
    return getInitialConnectionPropertyValue(ENABLE_END_TO_END_TRACING);
  }

  /**
   * The initial retryAbortsInternally value for connections created by this {@link
   * ConnectionOptions}
   */
  public boolean isRetryAbortsInternally() {
    return getInitialConnectionPropertyValue(RETRY_ABORTS_INTERNALLY);
  }

  /** Whether connections should use virtual threads for connection executors. */
  public boolean isUseVirtualThreads() {
    return getInitialConnectionPropertyValue(USE_VIRTUAL_THREADS);
  }

  /** Whether virtual threads should be used for gRPC transport. */
  public boolean isUseVirtualGrpcTransportThreads() {
    return getInitialConnectionPropertyValue(USE_VIRTUAL_GRPC_TRANSPORT_THREADS);
  }

  /** Any warnings that were generated while creating the {@link ConnectionOptions} instance. */
  @Nullable
  public String getWarnings() {
    return warnings;
  }

  /** Use http instead of https. Only valid for (local) test servers. */
  boolean isUsePlainText() {
    return getInitialConnectionPropertyValue(AUTO_CONFIG_EMULATOR)
        || getInitialConnectionPropertyValue(USE_PLAIN_TEXT);
  }

  boolean isExperimentalHost() {
    return getInitialConnectionPropertyValue(IS_EXPERIMENTAL_HOST);
  }

  Boolean isEnableDirectAccess() {
    return getInitialConnectionPropertyValue(ENABLE_DIRECT_ACCESS);
  }

  String getUniverseDomain() {
    return getInitialConnectionPropertyValue(UNIVERSE_DOMAIN);
  }

  String getClientCertificate() {
    return getInitialConnectionPropertyValue(CLIENT_CERTIFICATE);
  }

  String getClientCertificateKey() {
    return getInitialConnectionPropertyValue(CLIENT_KEY);
  }

  /**
   * The (custom) user agent string to use for this connection. If <code>null</code>, then the
   * default JDBC user agent string will be used.
   */
  String getUserAgent() {
    return getInitialConnectionPropertyValue(USER_AGENT);
  }

  /** Whether connections created by this {@link ConnectionOptions} return commit stats. */
  public boolean isReturnCommitStats() {
    return getInitialConnectionPropertyValue(RETURN_COMMIT_STATS);
  }

  /** The max_commit_delay that should be applied to commit operations on this connection. */
  public Duration getMaxCommitDelay() {
    return getInitialConnectionPropertyValue(MAX_COMMIT_DELAY);
  }

  boolean usesEmulator() {
    return Suppliers.memoize(
            () ->
                isAutoConfigEmulator()
                    || !Strings.isNullOrEmpty(System.getenv("SPANNER_EMULATOR_HOST")))
        .get();
  }

  /**
   * Whether connections created by this {@link ConnectionOptions} will automatically try to connect
   * to the emulator using the default host/port of the emulator, and automatically create the
   * instance and database that is specified in the connection string if these do not exist on the
   * emulator instance.
   */
  public boolean isAutoConfigEmulator() {
    return getInitialConnectionPropertyValue(AUTO_CONFIG_EMULATOR);
  }

  /**
   * Returns true if a connection should generate auto-savepoints for retrying transactions on the
   * emulator. This allows some more concurrent transactions on the emulator.
   *
   * <p>This is no longer needed since version 1.5.23 of the emulator.
   */
  boolean useAutoSavepointsForEmulator() {
    return getInitialConnectionPropertyValue(USE_AUTO_SAVEPOINTS_FOR_EMULATOR);
  }

  public Dialect getDialect() {
    return getInitialConnectionPropertyValue(DIALECT);
  }

  boolean isTrackConnectionLeaks() {
    return getInitialConnectionPropertyValue(TRACK_CONNECTION_LEAKS);
  }

  boolean isDataBoostEnabled() {
    return getInitialConnectionPropertyValue(DATA_BOOST_ENABLED);
  }

  boolean isAutoPartitionMode() {
    return getInitialConnectionPropertyValue(AUTO_PARTITION_MODE);
  }

  int getMaxPartitions() {
    return getInitialConnectionPropertyValue(MAX_PARTITIONS);
  }

  int getMaxPartitionedParallelism() {
    return getInitialConnectionPropertyValue(MAX_PARTITIONED_PARALLELISM);
  }

  Boolean isEnableExtendedTracing() {
    return getInitialConnectionPropertyValue(ENABLE_EXTENDED_TRACING);
  }

  Boolean isEnableApiTracing() {
    return getInitialConnectionPropertyValue(ENABLE_API_TRACING);
  }

  /** Interceptors that should be executed after each statement */
  List<StatementExecutionInterceptor> getStatementExecutionInterceptors() {
    return statementExecutionInterceptors;
  }

  @Override
  public String toString() {
    return getUri();
  }
}
