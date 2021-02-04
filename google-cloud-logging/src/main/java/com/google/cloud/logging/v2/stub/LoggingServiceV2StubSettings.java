/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.google.cloud.logging.v2.stub;

import static com.google.cloud.logging.v2.LoggingClient.ListLogEntriesPagedResponse;
import static com.google.cloud.logging.v2.LoggingClient.ListLogsPagedResponse;
import static com.google.cloud.logging.v2.LoggingClient.ListMonitoredResourceDescriptorsPagedResponse;

import com.google.api.MonitoredResourceDescriptor;
import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.batching.BatchingSettings;
import com.google.api.gax.batching.FlowControlSettings;
import com.google.api.gax.batching.FlowController;
import com.google.api.gax.batching.PartitionKey;
import com.google.api.gax.batching.RequestBuilder;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.BatchedRequestIssuer;
import com.google.api.gax.rpc.BatchingCallSettings;
import com.google.api.gax.rpc.BatchingDescriptor;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StreamingCallSettings;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.logging.v2.DeleteLogRequest;
import com.google.logging.v2.ListLogEntriesRequest;
import com.google.logging.v2.ListLogEntriesResponse;
import com.google.logging.v2.ListLogsRequest;
import com.google.logging.v2.ListLogsResponse;
import com.google.logging.v2.ListMonitoredResourceDescriptorsRequest;
import com.google.logging.v2.ListMonitoredResourceDescriptorsResponse;
import com.google.logging.v2.LogEntry;
import com.google.logging.v2.TailLogEntriesRequest;
import com.google.logging.v2.TailLogEntriesResponse;
import com.google.logging.v2.WriteLogEntriesRequest;
import com.google.logging.v2.WriteLogEntriesResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link LoggingServiceV2Stub}.
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
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of deleteLog to 30 seconds:
 *
 * <pre>{@code
 * LoggingServiceV2StubSettings.Builder loggingServiceV2SettingsBuilder =
 *     LoggingServiceV2StubSettings.newBuilder();
 * loggingServiceV2SettingsBuilder
 *     .deleteLogSettings()
 *     .setRetrySettings(
 *         loggingServiceV2SettingsBuilder
 *             .deleteLogSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * LoggingServiceV2StubSettings loggingServiceV2Settings = loggingServiceV2SettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class LoggingServiceV2StubSettings extends StubSettings<LoggingServiceV2StubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .add("https://www.googleapis.com/auth/logging.admin")
          .add("https://www.googleapis.com/auth/logging.read")
          .add("https://www.googleapis.com/auth/logging.write")
          .build();

  private final UnaryCallSettings<DeleteLogRequest, Empty> deleteLogSettings;
  private final BatchingCallSettings<WriteLogEntriesRequest, WriteLogEntriesResponse>
      writeLogEntriesSettings;
  private final PagedCallSettings<
          ListLogEntriesRequest, ListLogEntriesResponse, ListLogEntriesPagedResponse>
      listLogEntriesSettings;
  private final PagedCallSettings<
          ListMonitoredResourceDescriptorsRequest,
          ListMonitoredResourceDescriptorsResponse,
          ListMonitoredResourceDescriptorsPagedResponse>
      listMonitoredResourceDescriptorsSettings;
  private final PagedCallSettings<ListLogsRequest, ListLogsResponse, ListLogsPagedResponse>
      listLogsSettings;
  private final StreamingCallSettings<TailLogEntriesRequest, TailLogEntriesResponse>
      tailLogEntriesSettings;

  private static final PagedListDescriptor<ListLogEntriesRequest, ListLogEntriesResponse, LogEntry>
      LIST_LOG_ENTRIES_PAGE_STR_DESC =
          new PagedListDescriptor<ListLogEntriesRequest, ListLogEntriesResponse, LogEntry>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLogEntriesRequest injectToken(ListLogEntriesRequest payload, String token) {
              return ListLogEntriesRequest.newBuilder(payload).setPageToken(token).build();
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
            public String extractNextToken(ListLogEntriesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LogEntry> extractResources(ListLogEntriesResponse payload) {
              return payload.getEntriesList() == null
                  ? ImmutableList.<LogEntry>of()
                  : payload.getEntriesList();
            }
          };

  private static final PagedListDescriptor<
          ListMonitoredResourceDescriptorsRequest,
          ListMonitoredResourceDescriptorsResponse,
          MonitoredResourceDescriptor>
      LIST_MONITORED_RESOURCE_DESCRIPTORS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMonitoredResourceDescriptorsRequest,
              ListMonitoredResourceDescriptorsResponse,
              MonitoredResourceDescriptor>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMonitoredResourceDescriptorsRequest injectToken(
                ListMonitoredResourceDescriptorsRequest payload, String token) {
              return ListMonitoredResourceDescriptorsRequest.newBuilder(payload)
                  .setPageToken(token)
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
            public String extractNextToken(ListMonitoredResourceDescriptorsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MonitoredResourceDescriptor> extractResources(
                ListMonitoredResourceDescriptorsResponse payload) {
              return payload.getResourceDescriptorsList() == null
                  ? ImmutableList.<MonitoredResourceDescriptor>of()
                  : payload.getResourceDescriptorsList();
            }
          };

  private static final PagedListDescriptor<ListLogsRequest, ListLogsResponse, String>
      LIST_LOGS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLogsRequest, ListLogsResponse, String>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLogsRequest injectToken(ListLogsRequest payload, String token) {
              return ListLogsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLogsRequest injectPageSize(ListLogsRequest payload, int pageSize) {
              return ListLogsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLogsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLogsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<String> extractResources(ListLogsResponse payload) {
              return payload.getLogNamesList() == null
                  ? ImmutableList.<String>of()
                  : payload.getLogNamesList();
            }
          };

  private static final PagedListResponseFactory<
          ListLogEntriesRequest, ListLogEntriesResponse, ListLogEntriesPagedResponse>
      LIST_LOG_ENTRIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLogEntriesRequest, ListLogEntriesResponse, ListLogEntriesPagedResponse>() {
            @Override
            public ApiFuture<ListLogEntriesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLogEntriesRequest, ListLogEntriesResponse> callable,
                ListLogEntriesRequest request,
                ApiCallContext context,
                ApiFuture<ListLogEntriesResponse> futureResponse) {
              PageContext<ListLogEntriesRequest, ListLogEntriesResponse, LogEntry> pageContext =
                  PageContext.create(callable, LIST_LOG_ENTRIES_PAGE_STR_DESC, request, context);
              return ListLogEntriesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMonitoredResourceDescriptorsRequest,
          ListMonitoredResourceDescriptorsResponse,
          ListMonitoredResourceDescriptorsPagedResponse>
      LIST_MONITORED_RESOURCE_DESCRIPTORS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMonitoredResourceDescriptorsRequest,
              ListMonitoredResourceDescriptorsResponse,
              ListMonitoredResourceDescriptorsPagedResponse>() {
            @Override
            public ApiFuture<ListMonitoredResourceDescriptorsPagedResponse> getFuturePagedResponse(
                UnaryCallable<
                        ListMonitoredResourceDescriptorsRequest,
                        ListMonitoredResourceDescriptorsResponse>
                    callable,
                ListMonitoredResourceDescriptorsRequest request,
                ApiCallContext context,
                ApiFuture<ListMonitoredResourceDescriptorsResponse> futureResponse) {
              PageContext<
                      ListMonitoredResourceDescriptorsRequest,
                      ListMonitoredResourceDescriptorsResponse,
                      MonitoredResourceDescriptor>
                  pageContext =
                      PageContext.create(
                          callable,
                          LIST_MONITORED_RESOURCE_DESCRIPTORS_PAGE_STR_DESC,
                          request,
                          context);
              return ListMonitoredResourceDescriptorsPagedResponse.createAsync(
                  pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLogsRequest, ListLogsResponse, ListLogsPagedResponse>
      LIST_LOGS_PAGE_STR_FACT =
          new PagedListResponseFactory<ListLogsRequest, ListLogsResponse, ListLogsPagedResponse>() {
            @Override
            public ApiFuture<ListLogsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLogsRequest, ListLogsResponse> callable,
                ListLogsRequest request,
                ApiCallContext context,
                ApiFuture<ListLogsResponse> futureResponse) {
              PageContext<ListLogsRequest, ListLogsResponse, String> pageContext =
                  PageContext.create(callable, LIST_LOGS_PAGE_STR_DESC, request, context);
              return ListLogsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final BatchingDescriptor<WriteLogEntriesRequest, WriteLogEntriesResponse>
      WRITE_LOG_ENTRIES_BATCHING_DESC =
          new BatchingDescriptor<WriteLogEntriesRequest, WriteLogEntriesResponse>() {
            @Override
            public PartitionKey getBatchPartitionKey(WriteLogEntriesRequest request) {
              return new PartitionKey(
                  request.getLogName(), request.getResource(), request.getLabels());
            }

            @Override
            public RequestBuilder<WriteLogEntriesRequest> getRequestBuilder() {
              return new RequestBuilder<WriteLogEntriesRequest>() {
                private WriteLogEntriesRequest.Builder builder;

                @Override
                public void appendRequest(WriteLogEntriesRequest request) {
                  if (builder == null) {
                    builder = request.toBuilder();
                  } else {
                    builder.addAllEntries(request.getEntriesList());
                  }
                }

                @Override
                public WriteLogEntriesRequest build() {
                  return builder.build();
                }
              };
            }

            @Override
            public void splitResponse(
                WriteLogEntriesResponse batchResponse,
                Collection<? extends BatchedRequestIssuer<WriteLogEntriesResponse>> batch) {
              for (BatchedRequestIssuer<WriteLogEntriesResponse> responder : batch) {
                WriteLogEntriesResponse response = WriteLogEntriesResponse.newBuilder().build();
                responder.setResponse(response);
              }
            }

            @Override
            public void splitException(
                Throwable throwable,
                Collection<? extends BatchedRequestIssuer<WriteLogEntriesResponse>> batch) {
              for (BatchedRequestIssuer<WriteLogEntriesResponse> responder : batch) {
                responder.setException(throwable);
              }
            }

            @Override
            public long countElements(WriteLogEntriesRequest request) {
              return request.getEntriesCount();
            }

            @Override
            public long countBytes(WriteLogEntriesRequest request) {
              return request.getSerializedSize();
            }
          };

  /** Returns the object with the settings used for calls to deleteLog. */
  public UnaryCallSettings<DeleteLogRequest, Empty> deleteLogSettings() {
    return deleteLogSettings;
  }

  /** Returns the object with the settings used for calls to writeLogEntries. */
  public BatchingCallSettings<WriteLogEntriesRequest, WriteLogEntriesResponse>
      writeLogEntriesSettings() {
    return writeLogEntriesSettings;
  }

  /** Returns the object with the settings used for calls to listLogEntries. */
  public PagedCallSettings<
          ListLogEntriesRequest, ListLogEntriesResponse, ListLogEntriesPagedResponse>
      listLogEntriesSettings() {
    return listLogEntriesSettings;
  }

  /** Returns the object with the settings used for calls to listMonitoredResourceDescriptors. */
  public PagedCallSettings<
          ListMonitoredResourceDescriptorsRequest,
          ListMonitoredResourceDescriptorsResponse,
          ListMonitoredResourceDescriptorsPagedResponse>
      listMonitoredResourceDescriptorsSettings() {
    return listMonitoredResourceDescriptorsSettings;
  }

  /** Returns the object with the settings used for calls to listLogs. */
  public PagedCallSettings<ListLogsRequest, ListLogsResponse, ListLogsPagedResponse>
      listLogsSettings() {
    return listLogsSettings;
  }

  /** Returns the object with the settings used for calls to tailLogEntries. */
  public StreamingCallSettings<TailLogEntriesRequest, TailLogEntriesResponse>
      tailLogEntriesSettings() {
    return tailLogEntriesSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public LoggingServiceV2Stub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcLoggingServiceV2Stub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "logging.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder().setScopesToApply(DEFAULT_SERVICE_SCOPES);
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(LoggingServiceV2StubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected LoggingServiceV2StubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    deleteLogSettings = settingsBuilder.deleteLogSettings().build();
    writeLogEntriesSettings = settingsBuilder.writeLogEntriesSettings().build();
    listLogEntriesSettings = settingsBuilder.listLogEntriesSettings().build();
    listMonitoredResourceDescriptorsSettings =
        settingsBuilder.listMonitoredResourceDescriptorsSettings().build();
    listLogsSettings = settingsBuilder.listLogsSettings().build();
    tailLogEntriesSettings = settingsBuilder.tailLogEntriesSettings().build();
  }

  /** Builder for LoggingServiceV2StubSettings. */
  public static class Builder extends StubSettings.Builder<LoggingServiceV2StubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<DeleteLogRequest, Empty> deleteLogSettings;
    private final BatchingCallSettings.Builder<WriteLogEntriesRequest, WriteLogEntriesResponse>
        writeLogEntriesSettings;
    private final PagedCallSettings.Builder<
            ListLogEntriesRequest, ListLogEntriesResponse, ListLogEntriesPagedResponse>
        listLogEntriesSettings;
    private final PagedCallSettings.Builder<
            ListMonitoredResourceDescriptorsRequest,
            ListMonitoredResourceDescriptorsResponse,
            ListMonitoredResourceDescriptorsPagedResponse>
        listMonitoredResourceDescriptorsSettings;
    private final PagedCallSettings.Builder<
            ListLogsRequest, ListLogsResponse, ListLogsPagedResponse>
        listLogsSettings;
    private final StreamingCallSettings.Builder<TailLogEntriesRequest, TailLogEntriesResponse>
        tailLogEntriesSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_1_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED,
                  StatusCode.Code.INTERNAL,
                  StatusCode.Code.UNAVAILABLE)));
      definitions.put(
          "retry_policy_2_codes",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED,
                  StatusCode.Code.INTERNAL,
                  StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_1_params", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(60000L))
              .setInitialRpcTimeout(Duration.ofMillis(3600000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(3600000L))
              .setTotalTimeout(Duration.ofMillis(3600000L))
              .build();
      definitions.put("retry_policy_2_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      deleteLogSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      writeLogEntriesSettings =
          BatchingCallSettings.newBuilder(WRITE_LOG_ENTRIES_BATCHING_DESC)
              .setBatchingSettings(BatchingSettings.newBuilder().build());
      listLogEntriesSettings = PagedCallSettings.newBuilder(LIST_LOG_ENTRIES_PAGE_STR_FACT);
      listMonitoredResourceDescriptorsSettings =
          PagedCallSettings.newBuilder(LIST_MONITORED_RESOURCE_DESCRIPTORS_PAGE_STR_FACT);
      listLogsSettings = PagedCallSettings.newBuilder(LIST_LOGS_PAGE_STR_FACT);
      tailLogEntriesSettings = StreamingCallSettings.newBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteLogSettings,
              writeLogEntriesSettings,
              listLogEntriesSettings,
              listMonitoredResourceDescriptorsSettings,
              listLogsSettings);
      initDefaults(this);
    }

    protected Builder(LoggingServiceV2StubSettings settings) {
      super(settings);

      deleteLogSettings = settings.deleteLogSettings.toBuilder();
      writeLogEntriesSettings = settings.writeLogEntriesSettings.toBuilder();
      listLogEntriesSettings = settings.listLogEntriesSettings.toBuilder();
      listMonitoredResourceDescriptorsSettings =
          settings.listMonitoredResourceDescriptorsSettings.toBuilder();
      listLogsSettings = settings.listLogsSettings.toBuilder();
      tailLogEntriesSettings = settings.tailLogEntriesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              deleteLogSettings,
              writeLogEntriesSettings,
              listLogEntriesSettings,
              listMonitoredResourceDescriptorsSettings,
              listLogsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .deleteLogSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .writeLogEntriesSettings()
          .setBatchingSettings(
              BatchingSettings.newBuilder()
                  .setElementCountThreshold(1000L)
                  .setRequestByteThreshold(1048576L)
                  .setDelayThreshold(Duration.ofMillis(50L))
                  .setFlowControlSettings(
                      FlowControlSettings.newBuilder()
                          .setMaxOutstandingElementCount(100000L)
                          .setMaxOutstandingRequestBytes(10485760L)
                          .setLimitExceededBehavior(
                              FlowController.LimitExceededBehavior.ThrowException)
                          .build())
                  .build());

      builder
          .writeLogEntriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listLogEntriesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listMonitoredResourceDescriptorsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      builder
          .listLogsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_1_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_1_params"));

      return builder;
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'.
    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) throws Exception {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to deleteLog. */
    public UnaryCallSettings.Builder<DeleteLogRequest, Empty> deleteLogSettings() {
      return deleteLogSettings;
    }

    /** Returns the builder for the settings used for calls to writeLogEntries. */
    public BatchingCallSettings.Builder<WriteLogEntriesRequest, WriteLogEntriesResponse>
        writeLogEntriesSettings() {
      return writeLogEntriesSettings;
    }

    /** Returns the builder for the settings used for calls to listLogEntries. */
    public PagedCallSettings.Builder<
            ListLogEntriesRequest, ListLogEntriesResponse, ListLogEntriesPagedResponse>
        listLogEntriesSettings() {
      return listLogEntriesSettings;
    }

    /** Returns the builder for the settings used for calls to listMonitoredResourceDescriptors. */
    public PagedCallSettings.Builder<
            ListMonitoredResourceDescriptorsRequest,
            ListMonitoredResourceDescriptorsResponse,
            ListMonitoredResourceDescriptorsPagedResponse>
        listMonitoredResourceDescriptorsSettings() {
      return listMonitoredResourceDescriptorsSettings;
    }

    /** Returns the builder for the settings used for calls to listLogs. */
    public PagedCallSettings.Builder<ListLogsRequest, ListLogsResponse, ListLogsPagedResponse>
        listLogsSettings() {
      return listLogsSettings;
    }

    /** Returns the builder for the settings used for calls to tailLogEntries. */
    public StreamingCallSettings.Builder<TailLogEntriesRequest, TailLogEntriesResponse>
        tailLogEntriesSettings() {
      return tailLogEntriesSettings;
    }

    @Override
    public LoggingServiceV2StubSettings build() throws IOException {
      return new LoggingServiceV2StubSettings(this);
    }
  }
}
