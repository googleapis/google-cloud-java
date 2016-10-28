/*
 * Copyright 2016 Google Inc. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.google.cloud.logging.spi.v2;

import com.google.api.MonitoredResourceDescriptor;
import com.google.api.gax.core.ConnectionSettings;
import com.google.api.gax.core.RetrySettings;
import com.google.api.gax.grpc.ApiCallSettings;
import com.google.api.gax.grpc.PageStreamingCallSettings;
import com.google.api.gax.grpc.PageStreamingDescriptor;
import com.google.api.gax.grpc.ServiceApiSettings;
import com.google.api.gax.grpc.SimpleCallSettings;
import com.google.auth.Credentials;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.google.logging.v2.DeleteLogRequest;
import com.google.logging.v2.ListLogEntriesRequest;
import com.google.logging.v2.ListLogEntriesResponse;
import com.google.logging.v2.ListMonitoredResourceDescriptorsRequest;
import com.google.logging.v2.ListMonitoredResourceDescriptorsResponse;
import com.google.logging.v2.LogEntry;
import com.google.logging.v2.LoggingServiceV2Grpc;
import com.google.logging.v2.WriteLogEntriesRequest;
import com.google.logging.v2.WriteLogEntriesResponse;
import com.google.protobuf.Empty;
import io.grpc.ManagedChannel;
import io.grpc.Status;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.ScheduledExecutorService;
import org.joda.time.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link LoggingServiceV2Api}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (logging.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object. For
 * example, to set the total timeout of deleteLog to 30 seconds:
 *
 * <pre>
 * <code>
 * LoggingServiceV2Settings.Builder loggingServiceV2SettingsBuilder =
 *     LoggingServiceV2Settings.defaultBuilder();
 * loggingServiceV2SettingsBuilder.deleteLogSettings().getRetrySettingsBuilder()
 *     .setTotalTimeout(Duration.standardSeconds(30));
 * LoggingServiceV2Settings loggingServiceV2Settings = loggingServiceV2SettingsBuilder.build();
 * </code>
 * </pre>
 */
@javax.annotation.Generated("by GAPIC")
public class LoggingServiceV2Settings extends ServiceApiSettings {
  /** The default address of the service. */
  private static final String DEFAULT_SERVICE_ADDRESS = "logging.googleapis.com";

  /** The default port of the service. */
  private static final int DEFAULT_SERVICE_PORT = 443;

  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .add("https://www.googleapis.com/auth/logging.admin")
          .add("https://www.googleapis.com/auth/logging.read")
          .add("https://www.googleapis.com/auth/logging.write")
          .build();

  /** The default connection settings of the service. */
  public static final ConnectionSettings DEFAULT_CONNECTION_SETTINGS =
      ConnectionSettings.newBuilder()
          .setServiceAddress(DEFAULT_SERVICE_ADDRESS)
          .setPort(DEFAULT_SERVICE_PORT)
          .provideCredentialsWith(DEFAULT_SERVICE_SCOPES)
          .build();

  private final SimpleCallSettings<DeleteLogRequest, Empty> deleteLogSettings;
  private final SimpleCallSettings<WriteLogEntriesRequest, WriteLogEntriesResponse>
      writeLogEntriesSettings;
  private final PageStreamingCallSettings<ListLogEntriesRequest, ListLogEntriesResponse, LogEntry>
      listLogEntriesSettings;
  private final PageStreamingCallSettings<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
          MonitoredResourceDescriptor>
      listMonitoredResourceDescriptorsSettings;

  /** Returns the object with the settings used for calls to deleteLog. */
  public SimpleCallSettings<DeleteLogRequest, Empty> deleteLogSettings() {
    return deleteLogSettings;
  }

  /** Returns the object with the settings used for calls to writeLogEntries. */
  public SimpleCallSettings<WriteLogEntriesRequest, WriteLogEntriesResponse>
      writeLogEntriesSettings() {
    return writeLogEntriesSettings;
  }

  /** Returns the object with the settings used for calls to listLogEntries. */
  public PageStreamingCallSettings<ListLogEntriesRequest, ListLogEntriesResponse, LogEntry>
      listLogEntriesSettings() {
    return listLogEntriesSettings;
  }

  /** Returns the object with the settings used for calls to listMonitoredResourceDescriptors. */
  public PageStreamingCallSettings<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
          MonitoredResourceDescriptor>
      listMonitoredResourceDescriptorsSettings() {
    return listMonitoredResourceDescriptorsSettings;
  }

  /** Returns the default service address. */
  public static String getDefaultServiceAddress() {
    return DEFAULT_SERVICE_ADDRESS;
  }

  /** Returns the default service port. */
  public static int getDefaultServicePort() {
    return DEFAULT_SERVICE_PORT;
  }

  /** Returns the default service scopes. */
  public static ImmutableList<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for this class with recommended defaults. */
  public static Builder defaultBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return new Builder();
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  private LoggingServiceV2Settings(Builder settingsBuilder) throws IOException {
    super(
        settingsBuilder.getChannelProvider(),
        settingsBuilder.getExecutorProvider(),
        settingsBuilder.getGeneratorName(),
        settingsBuilder.getGeneratorVersion(),
        settingsBuilder.getClientLibName(),
        settingsBuilder.getClientLibVersion());

    deleteLogSettings = settingsBuilder.deleteLogSettings().build();
    writeLogEntriesSettings = settingsBuilder.writeLogEntriesSettings().build();
    listLogEntriesSettings = settingsBuilder.listLogEntriesSettings().build();
    listMonitoredResourceDescriptorsSettings =
        settingsBuilder.listMonitoredResourceDescriptorsSettings().build();
  }

  private static final PageStreamingDescriptor<
          ListLogEntriesRequest, ListLogEntriesResponse, LogEntry>
      LIST_LOG_ENTRIES_PAGE_STR_DESC =
          new PageStreamingDescriptor<ListLogEntriesRequest, ListLogEntriesResponse, LogEntry>() {
            @Override
            public Object emptyToken() {
              return "";
            }

            @Override
            public ListLogEntriesRequest injectToken(ListLogEntriesRequest payload, Object token) {
              return ListLogEntriesRequest.newBuilder(payload).setPageToken((String) token).build();
            }

            @Override
            public ListLogEntriesRequest injectPageSize(
                ListLogEntriesRequest payload, int pageSize) {
              return ListLogEntriesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLogEntriesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public Object extractNextToken(ListLogEntriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LogEntry> extractResources(ListLogEntriesResponse payload) {
              return payload.getEntriesList();
            }
          };

  private static final PageStreamingDescriptor<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
          MonitoredResourceDescriptor>
      LIST_MONITORED_RESOURCE_DESCRIPTORS_PAGE_STR_DESC =
          new PageStreamingDescriptor<
              ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
              MonitoredResourceDescriptor>() {
            @Override
            public Object emptyToken() {
              return "";
            }

            @Override
            public ListMonitoredResourceDescriptorsRequest injectToken(
                ListMonitoredResourceDescriptorsRequest payload, Object token) {
              return ListMonitoredResourceDescriptorsRequest.newBuilder(payload)
                  .setPageToken((String) token)
                  .build();
            }

            @Override
            public ListMonitoredResourceDescriptorsRequest injectPageSize(
                ListMonitoredResourceDescriptorsRequest payload, int pageSize) {
              return ListMonitoredResourceDescriptorsRequest.newBuilder(payload)
                  .setPageSize(pageSize)
                  .build();
            }

            @Override
            public Integer extractPageSize(ListMonitoredResourceDescriptorsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public Object extractNextToken(ListMonitoredResourceDescriptorsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MonitoredResourceDescriptor> extractResources(
                ListMonitoredResourceDescriptorsResponse payload) {
              return payload.getResourceDescriptorsList();
            }
          };

  /** Builder for LoggingServiceV2Settings. */
  public static class Builder extends ServiceApiSettings.Builder {
    private final ImmutableList<ApiCallSettings.Builder> methodSettingsBuilders;

    private final SimpleCallSettings.Builder<DeleteLogRequest, Empty> deleteLogSettings;
    private final SimpleCallSettings.Builder<WriteLogEntriesRequest, WriteLogEntriesResponse>
        writeLogEntriesSettings;
    private final PageStreamingCallSettings.Builder<
            ListLogEntriesRequest, ListLogEntriesResponse, LogEntry>
        listLogEntriesSettings;
    private final PageStreamingCallSettings.Builder<
            ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
            MonitoredResourceDescriptor>
        listMonitoredResourceDescriptorsSettings;

    private static final ImmutableMap<String, ImmutableSet<Status.Code>> RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<Status.Code>> definitions = ImmutableMap.builder();
      definitions.put(
          "idempotent",
          Sets.immutableEnumSet(
              Lists.<Status.Code>newArrayList(
                  Status.Code.DEADLINE_EXCEEDED, Status.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", Sets.immutableEnumSet(Lists.<Status.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings.Builder> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings.Builder> definitions = ImmutableMap.builder();
      RetrySettings.Builder settingsBuilder = null;
      settingsBuilder =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.millis(100L))
              .setRetryDelayMultiplier(1.2)
              .setMaxRetryDelay(Duration.millis(1000L))
              .setInitialRpcTimeout(Duration.millis(2000L))
              .setRpcTimeoutMultiplier(1.5)
              .setMaxRpcTimeout(Duration.millis(30000L))
              .setTotalTimeout(Duration.millis(45000L));
      definitions.put("default", settingsBuilder);
      settingsBuilder =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.millis(100L))
              .setRetryDelayMultiplier(1.2)
              .setMaxRetryDelay(Duration.millis(1000L))
              .setInitialRpcTimeout(Duration.millis(7000L))
              .setRpcTimeoutMultiplier(1.5)
              .setMaxRpcTimeout(Duration.millis(30000L))
              .setTotalTimeout(Duration.millis(45000L));
      definitions.put("list", settingsBuilder);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    private Builder() {
      super(DEFAULT_CONNECTION_SETTINGS);

      deleteLogSettings = SimpleCallSettings.newBuilder(LoggingServiceV2Grpc.METHOD_DELETE_LOG);

      writeLogEntriesSettings =
          SimpleCallSettings.newBuilder(LoggingServiceV2Grpc.METHOD_WRITE_LOG_ENTRIES);

      listLogEntriesSettings =
          PageStreamingCallSettings.newBuilder(
              LoggingServiceV2Grpc.METHOD_LIST_LOG_ENTRIES, LIST_LOG_ENTRIES_PAGE_STR_DESC);

      listMonitoredResourceDescriptorsSettings =
          PageStreamingCallSettings.newBuilder(
              LoggingServiceV2Grpc.METHOD_LIST_MONITORED_RESOURCE_DESCRIPTORS,
              LIST_MONITORED_RESOURCE_DESCRIPTORS_PAGE_STR_DESC);

      methodSettingsBuilders =
          ImmutableList.<ApiCallSettings.Builder>of(
              deleteLogSettings,
              writeLogEntriesSettings,
              listLogEntriesSettings,
              listMonitoredResourceDescriptorsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder();

      builder
          .deleteLogSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .writeLogEntriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listLogEntriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("list"));

      builder
          .listMonitoredResourceDescriptorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    private Builder(LoggingServiceV2Settings settings) {
      super(settings);

      deleteLogSettings = settings.deleteLogSettings.toBuilder();
      writeLogEntriesSettings = settings.writeLogEntriesSettings.toBuilder();
      listLogEntriesSettings = settings.listLogEntriesSettings.toBuilder();
      listMonitoredResourceDescriptorsSettings =
          settings.listMonitoredResourceDescriptorsSettings.toBuilder();

      methodSettingsBuilders =
          ImmutableList.<ApiCallSettings.Builder>of(
              deleteLogSettings,
              writeLogEntriesSettings,
              listLogEntriesSettings,
              listMonitoredResourceDescriptorsSettings);
    }

    @Override
    protected ConnectionSettings getDefaultConnectionSettings() {
      return DEFAULT_CONNECTION_SETTINGS;
    }

    @Override
    public Builder provideExecutorWith(ScheduledExecutorService executor, boolean shouldAutoClose) {
      super.provideExecutorWith(executor, shouldAutoClose);
      return this;
    }

    @Override
    public Builder provideChannelWith(ManagedChannel channel, boolean shouldAutoClose) {
      super.provideChannelWith(channel, shouldAutoClose);
      return this;
    }

    @Override
    public Builder provideChannelWith(ConnectionSettings settings) {
      super.provideChannelWith(settings);
      return this;
    }

    @Override
    public Builder provideChannelWith(Credentials credentials) {
      super.provideChannelWith(credentials);
      return this;
    }

    @Override
    public Builder provideChannelWith(List<String> scopes) {
      super.provideChannelWith(scopes);
      return this;
    }

    @Override
    public Builder setGeneratorHeader(String name, String version) {
      super.setGeneratorHeader(name, version);
      return this;
    }

    @Override
    public Builder setClientLibHeader(String name, String version) {
      super.setClientLibHeader(name, version);
      return this;
    }

    /**
     * Applies the given settings to all of the API methods in this service. Only values that are
     * non-null will be applied, so this method is not capable of un-setting any values.
     */
    public Builder applyToAllApiMethods(ApiCallSettings.Builder apiCallSettings) throws Exception {
      super.applyToAllApiMethods(methodSettingsBuilders, apiCallSettings);
      return this;
    }

    /** Returns the builder for the settings used for calls to deleteLog. */
    public SimpleCallSettings.Builder<DeleteLogRequest, Empty> deleteLogSettings() {
      return deleteLogSettings;
    }

    /** Returns the builder for the settings used for calls to writeLogEntries. */
    public SimpleCallSettings.Builder<WriteLogEntriesRequest, WriteLogEntriesResponse>
        writeLogEntriesSettings() {
      return writeLogEntriesSettings;
    }

    /** Returns the builder for the settings used for calls to listLogEntries. */
    public PageStreamingCallSettings.Builder<
            ListLogEntriesRequest, ListLogEntriesResponse, LogEntry>
        listLogEntriesSettings() {
      return listLogEntriesSettings;
    }

    /** Returns the builder for the settings used for calls to listMonitoredResourceDescriptors. */
    public PageStreamingCallSettings.Builder<
            ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
            MonitoredResourceDescriptor>
        listMonitoredResourceDescriptorsSettings() {
      return listMonitoredResourceDescriptorsSettings;
    }

    @Override
    public LoggingServiceV2Settings build() throws IOException {
      return new LoggingServiceV2Settings(this);
    }
  }
}
