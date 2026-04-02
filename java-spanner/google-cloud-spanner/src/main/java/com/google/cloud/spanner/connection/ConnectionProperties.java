/*
 * Copyright 2024 Google LLC
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

import static com.google.cloud.spanner.connection.ConnectionOptions.AUTOCOMMIT_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.AUTO_BATCH_DML_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.AUTO_BATCH_DML_UPDATE_COUNT_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.AUTO_BATCH_DML_UPDATE_COUNT_VERIFICATION_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.AUTO_PARTITION_MODE_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.BATCH_DML_UPDATE_COUNT_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.CHANNEL_PROVIDER_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.CLIENT_CERTIFICATE_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.CLIENT_KEY_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.CREDENTIALS_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.CREDENTIALS_PROVIDER_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.DATABASE_ROLE_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.DATA_BOOST_ENABLED_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.DCP_INITIAL_CHANNELS_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.DCP_MAX_CHANNELS_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.DCP_MIN_CHANNELS_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.DDL_IN_TRANSACTION_MODE_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_AUTOCOMMIT;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_AUTO_BATCH_DML;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_AUTO_BATCH_DML_UPDATE_COUNT;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_AUTO_BATCH_DML_UPDATE_COUNT_VERIFICATION;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_AUTO_PARTITION_MODE;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_BATCH_DML_UPDATE_COUNT;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_CHANNEL_PROVIDER;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_CLIENT_CERTIFICATE;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_CLIENT_KEY;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_CREDENTIALS;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_DATABASE_ROLE;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_DATA_BOOST_ENABLED;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_DCP_INITIAL_CHANNELS;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_DCP_MAX_CHANNELS;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_DCP_MIN_CHANNELS;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_DDL_IN_TRANSACTION_MODE;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_DEFAULT_SEQUENCE_KIND;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_DELAY_TRANSACTION_START_UNTIL_FIRST_WRITE;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_ENABLE_API_TRACING;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_ENABLE_DYNAMIC_CHANNEL_POOL;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_ENABLE_END_TO_END_TRACING;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_ENABLE_EXTENDED_TRACING;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_ENDPOINT;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_IS_EXPERIMENTAL_HOST;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_KEEP_TRANSACTION_ALIVE;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_LENIENT;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_MAX_PARTITIONED_PARALLELISM;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_MAX_PARTITIONS;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_MAX_SESSIONS;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_MIN_SESSIONS;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_NUM_CHANNELS;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_OAUTH_TOKEN;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_OPTIMIZER_STATISTICS_PACKAGE;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_OPTIMIZER_VERSION;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_READONLY;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_RETRY_ABORTS_INTERNALLY;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_RETURN_COMMIT_STATS;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_ROUTE_TO_LEADER;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_RPC_PRIORITY;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_SEQUENCE_KIND_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_TRACK_CONNECTION_LEAKS;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_TRACK_SESSION_LEAKS;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_USER_AGENT;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_USE_PLAIN_TEXT;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_USE_VIRTUAL_GRPC_TRANSPORT_THREADS;
import static com.google.cloud.spanner.connection.ConnectionOptions.DEFAULT_USE_VIRTUAL_THREADS;
import static com.google.cloud.spanner.connection.ConnectionOptions.DELAY_TRANSACTION_START_UNTIL_FIRST_WRITE_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.DIALECT_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.ENABLE_API_TRACING_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.ENABLE_DYNAMIC_CHANNEL_POOL_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.ENABLE_END_TO_END_TRACING_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.ENABLE_EXTENDED_TRACING_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.ENABLE_GRPC_INTERCEPTOR_PROVIDER_SYSTEM_PROPERTY;
import static com.google.cloud.spanner.connection.ConnectionOptions.ENCODED_CREDENTIALS_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.ENDPOINT_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.IS_EXPERIMENTAL_HOST_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.KEEP_TRANSACTION_ALIVE_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.LENIENT_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.MAX_PARTITIONED_PARALLELISM_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.MAX_PARTITIONS_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.MAX_SESSIONS_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.MIN_SESSIONS_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.NUM_CHANNELS_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.OAUTH_TOKEN_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.OPTIMIZER_STATISTICS_PACKAGE_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.OPTIMIZER_VERSION_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.READONLY_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.RETRY_ABORTS_INTERNALLY_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.ROUTE_TO_LEADER_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.RPC_PRIORITY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.TRACK_CONNECTION_LEAKS_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.TRACK_SESSION_LEAKS_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.USER_AGENT_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.USE_PLAIN_TEXT_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.USE_VIRTUAL_GRPC_TRANSPORT_THREADS_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionOptions.USE_VIRTUAL_THREADS_PROPERTY_NAME;
import static com.google.cloud.spanner.connection.ConnectionProperty.castProperty;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.grpc.GrpcInterceptorProvider;
import com.google.cloud.spanner.Dialect;
import com.google.cloud.spanner.DmlBatchUpdateCountVerificationFailedException;
import com.google.cloud.spanner.Options.RpcPriority;
import com.google.cloud.spanner.TimestampBound;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.AutocommitDmlModeConverter;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.BooleanConverter;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.ConnectionStateTypeConverter;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.CredentialsProviderConverter;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.DdlInTransactionModeConverter;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.DialectConverter;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.DurationConverter;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.IsolationLevelConverter;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.LongConverter;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.NonNegativeIntegerConverter;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.ReadLockModeConverter;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.ReadOnlyStalenessConverter;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.RpcPriorityConverter;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.SavepointSupportConverter;
import com.google.cloud.spanner.connection.ClientSideStatementValueConverters.StringValueConverter;
import com.google.cloud.spanner.connection.ConnectionProperty.Context;
import com.google.cloud.spanner.connection.DirectedReadOptionsUtil.DirectedReadOptionsConverter;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.spanner.v1.DirectedReadOptions;
import com.google.spanner.v1.TransactionOptions.IsolationLevel;
import com.google.spanner.v1.TransactionOptions.ReadWrite.ReadLockMode;
import java.time.Duration;
import java.util.Arrays;
import java.util.stream.Collectors;

/** Utility class that defines all known connection properties. */
public class ConnectionProperties {
  private static final ImmutableMap.Builder<String, ConnectionProperty<?>>
      CONNECTION_PROPERTIES_BUILDER = ImmutableMap.builder();

  private static final Boolean[] BOOLEANS = new Boolean[] {Boolean.TRUE, Boolean.FALSE};

  static final ConnectionProperty<ConnectionState.Type> CONNECTION_STATE_TYPE =
      create(
          "connection_state_type",
          "The type of connection state to use for this connection. Can only be set at start up. "
              + "If no value is set, then the database dialect default will be used, "
              + "which is NON_TRANSACTIONAL for GoogleSQL and TRANSACTIONAL for PostgreSQL.",
          null,
          ConnectionState.Type.values(),
          ConnectionStateTypeConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<String> TRACING_PREFIX =
      create(
          "tracing_prefix",
          "The prefix that will be prepended to all OpenTelemetry traces that are "
              + "generated by a Connection.",
          "CloudSpanner",
          StringValueConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<Boolean> LENIENT =
      create(
          LENIENT_PROPERTY_NAME,
          "Silently ignore unknown properties in the connection string/properties (true/false)",
          DEFAULT_LENIENT,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<String> ENDPOINT =
      create(
          ENDPOINT_PROPERTY_NAME,
          "The endpoint that the JDBC driver should connect to. The default is the default Spanner"
              + " production endpoint when autoConfigEmulator=false, and the default Spanner"
              + " emulator endpoint (localhost:9010) when autoConfigEmulator=true. This property"
              + " takes precedence over any host name at the start of the connection URL.",
          DEFAULT_ENDPOINT,
          StringValueConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<Boolean> AUTO_CONFIG_EMULATOR =
      create(
          "autoConfigEmulator",
          "Automatically configure the connection to try to connect to the Cloud Spanner emulator"
              + " (true/false). The instance and database in the connection string will"
              + " automatically be created if these do not yet exist on the emulator. Add"
              + " dialect=postgresql to the connection string to make sure that the database that"
              + " is created uses the PostgreSQL dialect.",
          false,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<Boolean> ENABLE_DIRECT_ACCESS =
      create(
          "enableDirectAccess",
          "Configure the connection to try to connect to Spanner using "
              + "DirectPath (true/false). The client will try to connect to Spanner "
              + "using a direct Google network connection. DirectPath will work only "
              + "if the client is trying to establish a connection from a Google Cloud VM. "
              + "Otherwise it will automatically fallback to the standard network path. "
              + "NOTE: The default for this property is currently false, "
              + "but this could be changed in the future.",
          null,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<String> UNIVERSE_DOMAIN =
      create(
          "universeDomain",
          "Configure the connection to try to connect to Spanner using "
              + "a different partner Google Universe than GDU (googleapis.com).",
          "googleapis.com",
          StringValueConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<Boolean> USE_AUTO_SAVEPOINTS_FOR_EMULATOR =
      create(
          "useAutoSavepointsForEmulator",
          "Automatically creates savepoints for each statement in a read/write transaction when"
              + " using the Emulator. This is no longer needed when using Emulator version 1.5.23"
              + " or higher.",
          false,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<Boolean> USE_PLAIN_TEXT =
      create(
          USE_PLAIN_TEXT_PROPERTY_NAME,
          "Use a plain text communication channel (i.e. non-TLS) for communicating with the server"
              + " (true/false). Set this value to true for communication with the Cloud Spanner"
              + " emulator.",
          DEFAULT_USE_PLAIN_TEXT,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<Boolean> IS_EXPERIMENTAL_HOST =
      create(
          IS_EXPERIMENTAL_HOST_PROPERTY_NAME,
          "Set this value to true for communication with a Experimental Host.",
          DEFAULT_IS_EXPERIMENTAL_HOST,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<String> CLIENT_CERTIFICATE =
      create(
          CLIENT_CERTIFICATE_PROPERTY_NAME,
          "Specifies the file path to the client certificate required for establishing an mTLS"
              + " connection.",
          DEFAULT_CLIENT_CERTIFICATE,
          StringValueConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<String> CLIENT_KEY =
      create(
          CLIENT_KEY_PROPERTY_NAME,
          "Specifies the file path to the client private key required for establishing an mTLS"
              + " connection.",
          DEFAULT_CLIENT_KEY,
          StringValueConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<String> CREDENTIALS_URL =
      create(
          CREDENTIALS_PROPERTY_NAME,
          "The location of the credentials file to use for this connection. If neither this"
              + " property or encoded credentials are set, the connection will use the default"
              + " Google Cloud credentials for the runtime environment. WARNING: Using this"
              + " property without proper validation can expose the application to security risks."
              + " It is intended for use with credentials from a trusted source only, as it could"
              + " otherwise allow end-users to supply arbitrary credentials. For more information,"
              + " seehttps://cloud.google.com/docs/authentication/client-libraries#external-credentials",
          DEFAULT_CREDENTIALS,
          StringValueConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<String> ENCODED_CREDENTIALS =
      create(
          ENCODED_CREDENTIALS_PROPERTY_NAME,
          "Base64-encoded credentials to use for this connection. If neither this property or a"
              + " credentials location are set, the connection will use the default Google Cloud"
              + " credentials for the runtime environment. WARNING: Enabling this property without"
              + " proper validation can expose the application to security risks. It is intended"
              + " for use with credentials from a trusted source only, as it could otherwise allow"
              + " end-users to supply arbitrary credentials. For more information, see"
              + "https://cloud.google.com/docs/authentication/client-libraries#external-credentials",
          null,
          StringValueConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<String> OAUTH_TOKEN =
      create(
          OAUTH_TOKEN_PROPERTY_NAME,
          "A valid pre-existing OAuth token to use for authentication for this connection. Setting"
              + " this property will take precedence over any value set for a credentials file.",
          DEFAULT_OAUTH_TOKEN,
          StringValueConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<CredentialsProvider> CREDENTIALS_PROVIDER =
      create(
          CREDENTIALS_PROVIDER_PROPERTY_NAME,
          "The class name of the com.google.api.gax.core.CredentialsProvider implementation that"
              + " should be used to obtain credentials for connections.",
          null,
          CredentialsProviderConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<String> GRPC_INTERCEPTOR_PROVIDER =
      create(
          "grpc_interceptor_provider",
          "The class name of a "
              + GrpcInterceptorProvider.class.getName()
              + " implementation that should be used to provide interceptors for the underlying"
              + " Spanner client. This is a guarded property that can only be set if the Java"
              + " System Property "
              + ENABLE_GRPC_INTERCEPTOR_PROVIDER_SYSTEM_PROPERTY
              + " has been set to true. This property should only be set to true on systems where"
              + " an untrusted user cannot modify the connection URL, as using this property will"
              + " dynamically invoke the constructor of the class specified. This means that any"
              + " user that can modify the connection URL, can also dynamically invoke code on the"
              + " host where the application is running.",
          null,
          StringValueConverter.INSTANCE,
          Context.STARTUP);

  static final ConnectionProperty<String> USER_AGENT =
      create(
          USER_AGENT_PROPERTY_NAME,
          "The custom user-agent property name to use when communicating with Cloud Spanner. This"
              + " property is intended for internal library usage, and should not be set by"
              + " applications.",
          DEFAULT_USER_AGENT,
          StringValueConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<Dialect> DIALECT =
      create(
          DIALECT_PROPERTY_NAME,
          "Sets the dialect to use for new databases that are created by this connection.",
          Dialect.GOOGLE_STANDARD_SQL,
          Dialect.values(),
          DialectConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<Boolean> TRACK_SESSION_LEAKS =
      create(
          TRACK_SESSION_LEAKS_PROPERTY_NAME,
          "Capture the call stack of the thread that checked out a session of the session pool."
              + " This will pre-create a LeakedSessionException already when a session is checked"
              + " out. This can be disabled, for example if a monitoring system logs the"
              + " pre-created exception. If disabled, the LeakedSessionException will only be"
              + " created when an actual session leak is detected. The stack trace of the exception"
              + " will in that case not contain the call stack of when the session was checked"
              + " out.",
          DEFAULT_TRACK_SESSION_LEAKS,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<Boolean> TRACK_CONNECTION_LEAKS =
      create(
          TRACK_CONNECTION_LEAKS_PROPERTY_NAME,
          "Capture the call stack of the thread that created a connection. This will pre-create a"
              + " LeakedConnectionException already when a connection is created. This can be"
              + " disabled, for example if a monitoring system logs the pre-created exception. If"
              + " disabled, the LeakedConnectionException will only be created when an actual"
              + " connection leak is detected. The stack trace of the exception will in that case"
              + " not contain the call stack of when the connection was created.",
          DEFAULT_TRACK_CONNECTION_LEAKS,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<Boolean> ROUTE_TO_LEADER =
      create(
          ROUTE_TO_LEADER_PROPERTY_NAME,
          "Should read/write transactions and partitioned DML be routed to leader region"
              + " (true/false)",
          DEFAULT_ROUTE_TO_LEADER,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<Boolean> USE_VIRTUAL_THREADS =
      create(
          USE_VIRTUAL_THREADS_PROPERTY_NAME,
          "Use a virtual thread instead of a platform thread for each connection (true/false). This"
              + " option only has any effect if the application is running on Java 21 or higher. In"
              + " all other cases, the option is ignored.",
          DEFAULT_USE_VIRTUAL_THREADS,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<Boolean> USE_VIRTUAL_GRPC_TRANSPORT_THREADS =
      create(
          USE_VIRTUAL_GRPC_TRANSPORT_THREADS_PROPERTY_NAME,
          "Use a virtual thread instead of a platform thread for the gRPC executor (true/false)."
              + " This option only has any effect if the application is running on Java 21 or"
              + " higher. In all other cases, the option is ignored.",
          DEFAULT_USE_VIRTUAL_GRPC_TRANSPORT_THREADS,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<Boolean> ENABLE_EXTENDED_TRACING =
      create(
          ENABLE_EXTENDED_TRACING_PROPERTY_NAME,
          "Include the SQL string in the OpenTelemetry traces that are generated "
              + "by this connection. The SQL string is added as the standard OpenTelemetry "
              + "attribute 'db.statement'.",
          DEFAULT_ENABLE_EXTENDED_TRACING,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<Boolean> ENABLE_API_TRACING =
      create(
          ENABLE_API_TRACING_PROPERTY_NAME,
          "Add OpenTelemetry traces for each individual RPC call. Enable this "
              + "to get a detailed view of each RPC that is being executed by your application, "
              + "or if you want to debug potential latency problems caused by RPCs that are "
              + "being retried.",
          DEFAULT_ENABLE_API_TRACING,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<Boolean> ENABLE_END_TO_END_TRACING =
      create(
          ENABLE_END_TO_END_TRACING_PROPERTY_NAME,
          "Enable end-to-end tracing (true/false) to generate traces for both the time that is"
              + " spent in the client, as well as time that is spent in the Spanner server. Server"
              + " side traces can only go to Google Cloud Trace, so to see end to end traces, the"
              + " application should configure an exporter that exports the traces to Google Cloud"
              + " Trace.",
          DEFAULT_ENABLE_END_TO_END_TRACING,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<Integer> MIN_SESSIONS =
      create(
          MIN_SESSIONS_PROPERTY_NAME,
          "The minimum number of sessions in the backing session pool. The default is 100.",
          DEFAULT_MIN_SESSIONS,
          NonNegativeIntegerConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<Integer> MAX_SESSIONS =
      create(
          MAX_SESSIONS_PROPERTY_NAME,
          "The maximum number of sessions in the backing session pool. The default is 400.",
          DEFAULT_MAX_SESSIONS,
          NonNegativeIntegerConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<Integer> NUM_CHANNELS =
      create(
          NUM_CHANNELS_PROPERTY_NAME,
          "The number of gRPC channels to use to communicate with Cloud Spanner. The default is 4.",
          DEFAULT_NUM_CHANNELS,
          NonNegativeIntegerConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<Boolean> ENABLE_DYNAMIC_CHANNEL_POOL =
      create(
          ENABLE_DYNAMIC_CHANNEL_POOL_PROPERTY_NAME,
          "Enable dynamic channel pooling for automatic gRPC channel scaling. When enabled, the "
              + "client will automatically scale the number of channels based on load. Setting "
              + "numChannels will disable dynamic channel pooling even if this is set to true. "
              + "The default is currently false (disabled), but this may change to true in a "
              + "future version. Set this property explicitly to ensure consistent behavior.",
          DEFAULT_ENABLE_DYNAMIC_CHANNEL_POOL,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<Integer> DCP_MIN_CHANNELS =
      create(
          DCP_MIN_CHANNELS_PROPERTY_NAME,
          "The minimum number of channels in the dynamic channel pool. Only used when "
              + "enableDynamicChannelPool is true. The default is "
              + "SpannerOptions.DEFAULT_DYNAMIC_POOL_MIN_CHANNELS (2).",
          DEFAULT_DCP_MIN_CHANNELS,
          NonNegativeIntegerConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<Integer> DCP_MAX_CHANNELS =
      create(
          DCP_MAX_CHANNELS_PROPERTY_NAME,
          "The maximum number of channels in the dynamic channel pool. Only used when "
              + "enableDynamicChannelPool is true. The default is "
              + "SpannerOptions.DEFAULT_DYNAMIC_POOL_MAX_CHANNELS (10).",
          DEFAULT_DCP_MAX_CHANNELS,
          NonNegativeIntegerConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<Integer> DCP_INITIAL_CHANNELS =
      create(
          DCP_INITIAL_CHANNELS_PROPERTY_NAME,
          "The initial number of channels in the dynamic channel pool. Only used when "
              + "enableDynamicChannelPool is true. The default is "
              + "SpannerOptions.DEFAULT_DYNAMIC_POOL_INITIAL_SIZE (4).",
          DEFAULT_DCP_INITIAL_CHANNELS,
          NonNegativeIntegerConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<String> CHANNEL_PROVIDER =
      create(
          CHANNEL_PROVIDER_PROPERTY_NAME,
          "The name of the channel provider class. The name must reference an implementation of"
              + " ExternalChannelProvider. If this property is not set, the connection will use the"
              + " default grpc channel provider.",
          DEFAULT_CHANNEL_PROVIDER,
          StringValueConverter.INSTANCE,
          Context.STARTUP);
  static final ConnectionProperty<String> DATABASE_ROLE =
      create(
          DATABASE_ROLE_PROPERTY_NAME,
          "Sets the database role to use for this connection. The default is privileges assigned to"
              + " IAM role",
          DEFAULT_DATABASE_ROLE,
          StringValueConverter.INSTANCE,
          Context.STARTUP);

  static final ConnectionProperty<Boolean> AUTOCOMMIT =
      create(
          AUTOCOMMIT_PROPERTY_NAME,
          "Should the connection start in autocommit (true/false)",
          DEFAULT_AUTOCOMMIT,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<Boolean> READONLY =
      create(
          READONLY_PROPERTY_NAME,
          "Should the connection start in read-only mode (true/false)",
          DEFAULT_READONLY,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<IsolationLevel> DEFAULT_ISOLATION_LEVEL =
      create(
          "default_isolation_level",
          "The transaction isolation level that is used by default for read/write transactions. The"
              + " default is isolation_level_unspecified, which means that the connection will use"
              + " the default isolation level of the database that it is connected to.",
          IsolationLevel.ISOLATION_LEVEL_UNSPECIFIED,
          new IsolationLevel[] {
            IsolationLevel.ISOLATION_LEVEL_UNSPECIFIED,
            IsolationLevel.SERIALIZABLE,
            IsolationLevel.REPEATABLE_READ
          },
          IsolationLevelConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<ReadLockMode> READ_LOCK_MODE =
      create(
          "read_lock_mode",
          "This option controls the locking behavior for read operations and queries within a"
              + " read/write transaction. It works in conjunction with the transaction's isolation"
              + " level.\n\n"
              + "PESSIMISTIC: Read locks are acquired immediately on read. This mode only applies"
              + " to SERIALIZABLE isolation. This mode prevents concurrent modifications by locking"
              + " data throughout the transaction. This reduces commit-time aborts due to"
              + " conflicts, but can increase how long transactions wait for locks and the overall"
              + " contention.\n\n"
              + "OPTIMISTIC: Locks for reads within the transaction are not acquired on read."
              + " Instead, the locks are acquired on commit to validate that read/queried data has"
              + " not changed since the transaction started. If a conflict is detected, the"
              + " transaction will fail. This mode only applies to SERIALIZABLE isolation. This"
              + " mode defers locking until commit, which can reduce contention and improve"
              + " throughput. However, be aware that this increases the risk of transaction aborts"
              + " if there's significant write competition on the same data.\n\n"
              + "READ_LOCK_MODE_UNSPECIFIED: This is the default if no mode is set. The locking"
              + " behavior depends on the isolation level:\n\n"
              + "REPEATABLE_READ: Locking semantics default to OPTIMISTIC. However, validation"
              + " checks at commit are only performed for queries using SELECT FOR UPDATE,"
              + " statements with {@code LOCK_SCANNED_RANGES} hints, and DML statements.\n\n"
              + "For all other isolation levels: If the read lock mode is not set, it defaults to"
              + " PESSIMISTIC locking.",
          ReadLockMode.READ_LOCK_MODE_UNSPECIFIED,
          Arrays.stream(ReadLockMode.values())
              .filter(mode -> !mode.equals(ReadLockMode.UNRECOGNIZED))
              .collect(Collectors.toList())
              .toArray(new ReadLockMode[0]),
          ReadLockModeConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<Duration> STATEMENT_TIMEOUT =
      create(
          "statement_timeout",
          "Adds a timeout to all statements executed on this connection. "
              + "This property is only used when a statement timeout is specified.",
          null,
          null,
          DurationConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<Duration> TRANSACTION_TIMEOUT =
      create(
          "transaction_timeout",
          "Timeout for read/write transactions.",
          null,
          null,
          DurationConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<AutocommitDmlMode> AUTOCOMMIT_DML_MODE =
      create(
          "autocommit_dml_mode",
          "Determines the transaction type that is used to execute "
              + "DML statements when the connection is in auto-commit mode.",
          AutocommitDmlMode.TRANSACTIONAL,
          // Add 'null' as a valid value.
          Arrays.copyOf(AutocommitDmlMode.values(), AutocommitDmlMode.values().length + 1),
          AutocommitDmlModeConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<Boolean> RETRY_ABORTS_INTERNALLY =
      create(
          // TODO: Add support for synonyms for connection properties.
          //       retryAbortsInternally / retry_aborts_internally is currently not consistent.
          //       The connection URL property is retryAbortsInternally. The SET statement assumes
          //       that the property name is retry_aborts_internally. We should support both to be
          //       backwards compatible, but the standard should be snake_case.
          RETRY_ABORTS_INTERNALLY_PROPERTY_NAME,
          "Should the connection automatically retry Aborted errors (true/false)",
          DEFAULT_RETRY_ABORTS_INTERNALLY,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<Boolean> RETURN_COMMIT_STATS =
      create(
          "returnCommitStats",
          "Request that Spanner returns commit statistics for read/write transactions (true/false)",
          DEFAULT_RETURN_COMMIT_STATS,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<Boolean> DELAY_TRANSACTION_START_UNTIL_FIRST_WRITE =
      create(
          DELAY_TRANSACTION_START_UNTIL_FIRST_WRITE_NAME,
          "Enabling this option will delay the actual start of a read/write transaction until the"
              + " first write operation is seen in that transaction. All reads that happen before"
              + " the first write in a transaction will instead be executed as if the connection"
              + " was in auto-commit mode. Enabling this option will make read/write transactions"
              + " lose their SERIALIZABLE isolation level. Read operations that are executed after"
              + " the first write operation in a read/write transaction will be executed using the"
              + " read/write transaction. Enabling this mode can reduce locking and improve"
              + " performance for applications that can handle the lower transaction isolation"
              + " semantics.",
          DEFAULT_DELAY_TRANSACTION_START_UNTIL_FIRST_WRITE,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<Boolean> KEEP_TRANSACTION_ALIVE =
      create(
          KEEP_TRANSACTION_ALIVE_PROPERTY_NAME,
          "Enabling this option will trigger the connection to keep read/write transactions alive"
              + " by executing a SELECT 1 query once every 10 seconds if no other statements are"
              + " being executed. This option should be used with caution, as it can keep"
              + " transactions alive and hold on to locks longer than intended. This option should"
              + " typically be used for CLI-type application that might wait for user input for a"
              + " longer period of time.",
          DEFAULT_KEEP_TRANSACTION_ALIVE,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.USER);

  static final ConnectionProperty<TimestampBound> READ_ONLY_STALENESS =
      create(
          "read_only_staleness",
          "The read-only staleness to use for read-only transactions and single-use queries.",
          TimestampBound.strong(),
          ReadOnlyStalenessConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<Boolean> AUTO_PARTITION_MODE =
      create(
          AUTO_PARTITION_MODE_PROPERTY_NAME,
          "Execute all queries on this connection as partitioned queries. "
              + "Executing a query that cannot be partitioned will fail. "
              + "Executing a query in a read/write transaction will also fail.",
          DEFAULT_AUTO_PARTITION_MODE,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<Boolean> DATA_BOOST_ENABLED =
      create(
          DATA_BOOST_ENABLED_PROPERTY_NAME,
          "Enable data boost for all partitioned queries that are executed by this connection. This"
              + " setting is only used for partitioned queries and is ignored by all other"
              + " statements.",
          DEFAULT_DATA_BOOST_ENABLED,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<Integer> MAX_PARTITIONS =
      create(
          MAX_PARTITIONS_PROPERTY_NAME,
          "The max partitions hint value to use for partitioned queries. "
              + "Use 0 if you do not want to specify a hint.",
          DEFAULT_MAX_PARTITIONS,
          NonNegativeIntegerConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<Integer> MAX_PARTITIONED_PARALLELISM =
      create(
          MAX_PARTITIONED_PARALLELISM_PROPERTY_NAME,
          "The max partitions hint value to use for partitioned queries. "
              + "Use 0 if you do not want to specify a hint.",
          DEFAULT_MAX_PARTITIONED_PARALLELISM,
          NonNegativeIntegerConverter.INSTANCE,
          Context.USER);

  static final ConnectionProperty<DirectedReadOptions> DIRECTED_READ =
      create(
          "directed_read",
          "The directed read options to apply to read-only transactions.",
          null,
          DirectedReadOptionsConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<String> OPTIMIZER_VERSION =
      create(
          OPTIMIZER_VERSION_PROPERTY_NAME,
          "Sets the default query optimizer version to use for this connection.",
          DEFAULT_OPTIMIZER_VERSION,
          StringValueConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<String> OPTIMIZER_STATISTICS_PACKAGE =
      create(
          OPTIMIZER_STATISTICS_PACKAGE_PROPERTY_NAME,
          "Sets the query optimizer statistics package to use for this connection.",
          DEFAULT_OPTIMIZER_STATISTICS_PACKAGE,
          StringValueConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<RpcPriority> RPC_PRIORITY =
      create(
          RPC_PRIORITY_NAME,
          "Sets the priority for all RPC invocations from this connection (HIGH/MEDIUM/LOW). The"
              + " default is HIGH.",
          DEFAULT_RPC_PRIORITY,
          // Add 'null' as a valid value.
          Arrays.copyOf(RpcPriority.values(), RpcPriority.values().length + 1),
          RpcPriorityConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<SavepointSupport> SAVEPOINT_SUPPORT =
      create(
          "savepoint_support",
          "Determines the behavior of the connection when savepoints are used.",
          SavepointSupport.FAIL_AFTER_ROLLBACK,
          SavepointSupport.values(),
          SavepointSupportConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<DdlInTransactionMode> DDL_IN_TRANSACTION_MODE =
      create(
          DDL_IN_TRANSACTION_MODE_PROPERTY_NAME,
          "Determines how the connection should handle DDL statements in a read/write transaction.",
          DEFAULT_DDL_IN_TRANSACTION_MODE,
          DdlInTransactionMode.values(),
          DdlInTransactionModeConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<String> DEFAULT_SEQUENCE_KIND =
      create(
          DEFAULT_SEQUENCE_KIND_PROPERTY_NAME,
          "The default sequence kind that should be used for the database. "
              + "This property is only used when a DDL statement that requires a default "
              + "sequence kind is executed on this connection.",
          DEFAULT_DEFAULT_SEQUENCE_KIND,
          StringValueConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<Duration> MAX_COMMIT_DELAY =
      create(
          "maxCommitDelay",
          "The max delay that Spanner may apply to commit requests to improve throughput.",
          null,
          DurationConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<Boolean> AUTO_BATCH_DML =
      create(
          AUTO_BATCH_DML_PROPERTY_NAME,
          "Automatically buffer DML statements that are executed on this connection and execute"
              + " them as one batch when a non-DML statement is executed, or when the current"
              + " transaction is committed. The update count that is returned for DML statements"
              + " that are buffered is by default 1. This default can be changed by setting the"
              + " connection variable "
              + AUTO_BATCH_DML_UPDATE_COUNT_PROPERTY_NAME
              + " to value other than 1. This setting is only in read/write transactions. DML"
              + " statements in auto-commit mode are executed directly.",
          DEFAULT_AUTO_BATCH_DML,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<Long> AUTO_BATCH_DML_UPDATE_COUNT =
      create(
          AUTO_BATCH_DML_UPDATE_COUNT_PROPERTY_NAME,
          "DML statements that are executed when "
              + AUTO_BATCH_DML_PROPERTY_NAME
              + " is set to true, are not directly sent to Spanner, but are buffered in the client"
              + " until the batch is flushed. This property determines the update count that is"
              + " returned for these DML statements. The default is "
              + DEFAULT_AUTO_BATCH_DML_UPDATE_COUNT
              + ", as "
              + "that is the update count that is expected by most ORMs (e.g. Hibernate).",
          DEFAULT_AUTO_BATCH_DML_UPDATE_COUNT,
          LongConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<Boolean> AUTO_BATCH_DML_UPDATE_COUNT_VERIFICATION =
      create(
          AUTO_BATCH_DML_UPDATE_COUNT_VERIFICATION_PROPERTY_NAME,
          "The update count that is returned for DML statements that are buffered during "
              + "an automatic DML batch is by default "
              + DEFAULT_AUTO_BATCH_DML_UPDATE_COUNT
              + ". "
              + "This value can be changed by setting the connection variable "
              + AUTO_BATCH_DML_UPDATE_COUNT_PROPERTY_NAME
              + ". The update counts that are returned by Spanner when the DML statements are"
              + " actually executed are verified against the update counts that were returned when"
              + " they were buffered. If these do not match, a "
              + DmlBatchUpdateCountVerificationFailedException.class.getName()
              + " will be thrown. You can disable this verification by setting "
              + AUTO_BATCH_DML_UPDATE_COUNT_VERIFICATION_PROPERTY_NAME
              + " to false.",
          DEFAULT_AUTO_BATCH_DML_UPDATE_COUNT_VERIFICATION,
          BOOLEANS,
          BooleanConverter.INSTANCE,
          Context.USER);
  static final ConnectionProperty<Long> BATCH_DML_UPDATE_COUNT =
      create(
          BATCH_DML_UPDATE_COUNT_PROPERTY_NAME,
          "The update count that is returned for DML statements that are executed in an "
              + "explicit DML batch. The default is "
              + DEFAULT_BATCH_DML_UPDATE_COUNT,
          DEFAULT_BATCH_DML_UPDATE_COUNT,
          LongConverter.INSTANCE,
          Context.USER);
  public static final ConnectionProperty<Integer> UNKNOWN_LENGTH =
      create(
          "unknownLength",
          "Spanner does not return the length of the selected columns in query results. When"
              + " returning meta-data about these columns through functions like"
              + " ResultSetMetaData.getColumnDisplaySize and ResultSetMetaData.getPrecision, we"
              + " must provide a value. Various client tools and applications have different ideas"
              + " about what they would like to see. This property specifies the length to return"
              + " for types of unknown length.",
          /* defaultValue= */ 50,
          NonNegativeIntegerConverter.INSTANCE,
          Context.USER);

  static final ImmutableMap<String, ConnectionProperty<?>> CONNECTION_PROPERTIES =
      CONNECTION_PROPERTIES_BUILDER.build();

  /** The list of all supported connection properties. */
  public static ImmutableList<ConnectionProperty<?>> VALID_CONNECTION_PROPERTIES =
      ImmutableList.copyOf(ConnectionProperties.CONNECTION_PROPERTIES.values());

  /** Utility method for creating a new core {@link ConnectionProperty}. */
  private static <T> ConnectionProperty<T> create(
      String name,
      String description,
      T defaultValue,
      ClientSideStatementValueConverter<T> converter,
      Context context) {
    return create(name, description, defaultValue, null, converter, context);
  }

  /** Utility method for creating a new core {@link ConnectionProperty}. */
  private static <T> ConnectionProperty<T> create(
      String name,
      String description,
      T defaultValue,
      T[] validValues,
      ClientSideStatementValueConverter<T> converter,
      Context context) {
    ConnectionProperty<T> property =
        ConnectionProperty.create(name, description, defaultValue, validValues, converter, context);
    CONNECTION_PROPERTIES_BUILDER.put(property.getKey(), property);
    return property;
  }

  /** Parse the connection properties that can be found in the given connection URL. */
  static ImmutableMap<String, ConnectionPropertyValue<?>> parseValues(String url) {
    ImmutableMap.Builder<String, ConnectionPropertyValue<?>> builder = ImmutableMap.builder();
    for (ConnectionProperty<?> property : CONNECTION_PROPERTIES.values()) {
      ConnectionPropertyValue<?> value = parseValue(castProperty(property), url);
      if (value != null) {
        builder.put(property.getKey(), value);
      }
    }
    return builder.build();
  }

  /**
   * Parse and convert the value of the specific connection property from a connection URL (e.g.
   * readonly=true).
   */
  private static <T> ConnectionPropertyValue<T> parseValue(
      ConnectionProperty<T> property, String url) {
    String stringValue = ConnectionOptions.parseUriProperty(url, property.getKey());
    return property.convert(stringValue);
  }

  /** This class should not be instantiated. */
  private ConnectionProperties() {}
}
