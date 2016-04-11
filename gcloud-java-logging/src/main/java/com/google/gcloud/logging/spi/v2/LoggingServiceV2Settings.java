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

/*
 * EDITING INSTRUCTIONS
 * This file was generated from the file
 * https://github.com/google/googleapis/blob/master/google/logging/v2/logging.proto
 * and updates to that file get reflected here through a refresh process.
 * For the short term, the refresh process will only be runnable by Google engineers.
 * Manual additions are allowed because the refresh process performs
 * a 3-way merge in order to preserve those manual additions. In order to not
 * break the refresh process, only certain types of modifications are
 * allowed.
 *
 * Allowed modifications - currently these are the only types allowed:
 * 1. New methods (these should be added to the end of the class)
 * 2. New imports
 * 3. Additional documentation between "manual edit" demarcations
 *
 * Happy editing!
 */

package com.google.gcloud.logging.spi.v2;

import com.google.api.MonitoredResourceDescriptor;
import com.google.api.gax.core.ConnectionSettings;
import com.google.api.gax.core.RetrySettings;
import com.google.api.gax.grpc.ApiCallSettings;
import com.google.api.gax.grpc.PageStreamingCallSettings;
import com.google.api.gax.grpc.PageStreamingDescriptor;
import com.google.api.gax.grpc.ServiceApiSettings;
import com.google.api.gax.grpc.SimpleCallSettings;
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
import java.util.concurrent.ScheduledExecutorService;
import org.joda.time.Duration;

// Manually-added imports: add custom (non-generated) imports after this point.

// AUTO-GENERATED DOCUMENTATION AND CLASS - see instructions at the top of the file for editing.
@javax.annotation.Generated("by GAPIC")
public class LoggingServiceV2Settings extends ServiceApiSettings {

  /**
   * The default address of the service.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final String DEFAULT_SERVICE_ADDRESS = "logging.googleapis.com";

  /**
   * The default port of the service.
   *
   * <!-- manual edit -->
   * <!-- end manual edit -->
   */
  public static final int DEFAULT_SERVICE_PORT = 443;

  /**
   * The default scopes of the service.
   */
  public static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/logging.write")
          .add("https://www.googleapis.com/auth/logging.admin")
          .add("https://www.googleapis.com/auth/logging.read")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .add("https://www.googleapis.com/auth/cloud-platform")
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

  public SimpleCallSettings<DeleteLogRequest, Empty> deleteLogSettings() {
    return deleteLogSettings;
  }

  public SimpleCallSettings<WriteLogEntriesRequest, WriteLogEntriesResponse>
      writeLogEntriesSettings() {
    return writeLogEntriesSettings;
  }

  public PageStreamingCallSettings<ListLogEntriesRequest, ListLogEntriesResponse, LogEntry>
      listLogEntriesSettings() {
    return listLogEntriesSettings;
  }

  public PageStreamingCallSettings<
          ListMonitoredResourceDescriptorsRequest, ListMonitoredResourceDescriptorsResponse,
          MonitoredResourceDescriptor>
      listMonitoredResourceDescriptorsSettings() {
    return listMonitoredResourceDescriptorsSettings;
  }

  public static LoggingServiceV2Settings defaultInstance() throws IOException {
    return newBuilder().build();
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public Builder toBuilder() {
    return new Builder(this);
  }

  private LoggingServiceV2Settings(Builder settingsBuilder) throws IOException {
    super(
        settingsBuilder.getOrBuildChannel(),
        settingsBuilder.shouldAutoCloseChannel(),
        settingsBuilder.getOrBuildExecutor(),
        settingsBuilder.getConnectionSettings(),
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

  private static PageStreamingDescriptor<ListLogEntriesRequest, ListLogEntriesResponse, LogEntry>
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
            public Object extractNextToken(ListLogEntriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LogEntry> extractResources(ListLogEntriesResponse payload) {
              return payload.getEntriesList();
            }
          };

  private static PageStreamingDescriptor<
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
            public Object extractNextToken(ListMonitoredResourceDescriptorsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MonitoredResourceDescriptor> extractResources(
                ListMonitoredResourceDescriptorsResponse payload) {
              return payload.getResourceDescriptorsList();
            }
          };

  public static class Builder extends ServiceApiSettings.Builder {
    private final ImmutableList<ApiCallSettings.Builder> methodSettingsBuilders;

    private SimpleCallSettings.Builder<DeleteLogRequest, Empty> deleteLogSettings;
    private SimpleCallSettings.Builder<WriteLogEntriesRequest, WriteLogEntriesResponse>
        writeLogEntriesSettings;
    private PageStreamingCallSettings.Builder<
            ListLogEntriesRequest, ListLogEntriesResponse, LogEntry>
        listLogEntriesSettings;
    private PageStreamingCallSettings.Builder<
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
      super(
          ConnectionSettings.builder()
              .setServiceAddress(DEFAULT_SERVICE_ADDRESS)
              .setPort(DEFAULT_SERVICE_PORT)
              .provideCredentialsWith(DEFAULT_SERVICE_SCOPES)
              .build());

      deleteLogSettings =
          SimpleCallSettings.newBuilder(LoggingServiceV2Grpc.METHOD_DELETE_LOG)
              .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
              .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      writeLogEntriesSettings =
          SimpleCallSettings.newBuilder(LoggingServiceV2Grpc.METHOD_WRITE_LOG_ENTRIES)
              .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
              .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      listLogEntriesSettings =
          PageStreamingCallSettings.newBuilder(
                  LoggingServiceV2Grpc.METHOD_LIST_LOG_ENTRIES, LIST_LOG_ENTRIES_PAGE_STR_DESC)
              .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
              .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("list"));

      listMonitoredResourceDescriptorsSettings =
          PageStreamingCallSettings.newBuilder(
                  LoggingServiceV2Grpc.METHOD_LIST_MONITORED_RESOURCE_DESCRIPTORS,
                  LIST_MONITORED_RESOURCE_DESCRIPTORS_PAGE_STR_DESC)
              .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
              .setRetrySettingsBuilder(RETRY_PARAM_DEFINITIONS.get("default"));

      methodSettingsBuilders =
          ImmutableList.<ApiCallSettings.Builder>of(
              deleteLogSettings,
              writeLogEntriesSettings,
              listLogEntriesSettings,
              listMonitoredResourceDescriptorsSettings);
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
    public Builder setExecutor(ScheduledExecutorService executor) {
      super.setExecutor(executor);
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

    public Builder applyToAllApiMethods(ApiCallSettings.Builder apiCallSettings) throws Exception {
      super.applyToAllApiMethods(methodSettingsBuilders, apiCallSettings);
      return this;
    }

    public SimpleCallSettings.Builder<DeleteLogRequest, Empty> deleteLogSettings() {
      return deleteLogSettings;
    }

    public SimpleCallSettings.Builder<WriteLogEntriesRequest, WriteLogEntriesResponse>
        writeLogEntriesSettings() {
      return writeLogEntriesSettings;
    }

    public PageStreamingCallSettings.Builder<
            ListLogEntriesRequest, ListLogEntriesResponse, LogEntry>
        listLogEntriesSettings() {
      return listLogEntriesSettings;
    }

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
