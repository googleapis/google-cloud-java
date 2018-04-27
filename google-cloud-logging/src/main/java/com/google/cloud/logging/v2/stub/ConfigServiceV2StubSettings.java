/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.logging.v2.stub;

import static com.google.cloud.logging.v2.ConfigClient.ListExclusionsPagedResponse;
import static com.google.cloud.logging.v2.ConfigClient.ListSinksPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.logging.v2.CreateExclusionRequest;
import com.google.logging.v2.CreateSinkRequest;
import com.google.logging.v2.DeleteExclusionRequest;
import com.google.logging.v2.DeleteSinkRequest;
import com.google.logging.v2.GetExclusionRequest;
import com.google.logging.v2.GetSinkRequest;
import com.google.logging.v2.ListExclusionsRequest;
import com.google.logging.v2.ListExclusionsResponse;
import com.google.logging.v2.ListSinksRequest;
import com.google.logging.v2.ListSinksResponse;
import com.google.logging.v2.LogExclusion;
import com.google.logging.v2.LogSink;
import com.google.logging.v2.UpdateExclusionRequest;
import com.google.logging.v2.UpdateSinkRequest;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS
/**
 * Settings class to configure an instance of {@link ConfigServiceV2Stub}.
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
 * example, to set the total timeout of getSink to 30 seconds:
 *
 * <pre>
 * <code>
 * ConfigServiceV2StubSettings.Builder configSettingsBuilder =
 *     ConfigServiceV2StubSettings.newBuilder();
 * configSettingsBuilder.getSinkSettings().getRetrySettings().toBuilder()
 *     .setTotalTimeout(Duration.ofSeconds(30));
 * ConfigServiceV2StubSettings configSettings = configSettingsBuilder.build();
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class ConfigServiceV2StubSettings extends StubSettings<ConfigServiceV2StubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder()
          .add("https://www.googleapis.com/auth/cloud-platform")
          .add("https://www.googleapis.com/auth/cloud-platform.read-only")
          .add("https://www.googleapis.com/auth/logging.admin")
          .add("https://www.googleapis.com/auth/logging.read")
          .add("https://www.googleapis.com/auth/logging.write")
          .build();

  private final PagedCallSettings<ListSinksRequest, ListSinksResponse, ListSinksPagedResponse>
      listSinksSettings;
  private final UnaryCallSettings<GetSinkRequest, LogSink> getSinkSettings;
  private final UnaryCallSettings<CreateSinkRequest, LogSink> createSinkSettings;
  private final UnaryCallSettings<UpdateSinkRequest, LogSink> updateSinkSettings;
  private final UnaryCallSettings<DeleteSinkRequest, Empty> deleteSinkSettings;
  private final PagedCallSettings<
          ListExclusionsRequest, ListExclusionsResponse, ListExclusionsPagedResponse>
      listExclusionsSettings;
  private final UnaryCallSettings<GetExclusionRequest, LogExclusion> getExclusionSettings;
  private final UnaryCallSettings<CreateExclusionRequest, LogExclusion> createExclusionSettings;
  private final UnaryCallSettings<UpdateExclusionRequest, LogExclusion> updateExclusionSettings;
  private final UnaryCallSettings<DeleteExclusionRequest, Empty> deleteExclusionSettings;

  /** Returns the object with the settings used for calls to listSinks. */
  public PagedCallSettings<ListSinksRequest, ListSinksResponse, ListSinksPagedResponse>
      listSinksSettings() {
    return listSinksSettings;
  }

  /** Returns the object with the settings used for calls to getSink. */
  public UnaryCallSettings<GetSinkRequest, LogSink> getSinkSettings() {
    return getSinkSettings;
  }

  /** Returns the object with the settings used for calls to createSink. */
  public UnaryCallSettings<CreateSinkRequest, LogSink> createSinkSettings() {
    return createSinkSettings;
  }

  /** Returns the object with the settings used for calls to updateSink. */
  public UnaryCallSettings<UpdateSinkRequest, LogSink> updateSinkSettings() {
    return updateSinkSettings;
  }

  /** Returns the object with the settings used for calls to deleteSink. */
  public UnaryCallSettings<DeleteSinkRequest, Empty> deleteSinkSettings() {
    return deleteSinkSettings;
  }

  /** Returns the object with the settings used for calls to listExclusions. */
  public PagedCallSettings<
          ListExclusionsRequest, ListExclusionsResponse, ListExclusionsPagedResponse>
      listExclusionsSettings() {
    return listExclusionsSettings;
  }

  /** Returns the object with the settings used for calls to getExclusion. */
  public UnaryCallSettings<GetExclusionRequest, LogExclusion> getExclusionSettings() {
    return getExclusionSettings;
  }

  /** Returns the object with the settings used for calls to createExclusion. */
  public UnaryCallSettings<CreateExclusionRequest, LogExclusion> createExclusionSettings() {
    return createExclusionSettings;
  }

  /** Returns the object with the settings used for calls to updateExclusion. */
  public UnaryCallSettings<UpdateExclusionRequest, LogExclusion> updateExclusionSettings() {
    return updateExclusionSettings;
  }

  /** Returns the object with the settings used for calls to deleteExclusion. */
  public UnaryCallSettings<DeleteExclusionRequest, Empty> deleteExclusionSettings() {
    return deleteExclusionSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ConfigServiceV2Stub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcConfigServiceV2Stub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
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
    return InstantiatingGrpcChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ConfigServiceV2StubSettings.class))
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

  protected ConfigServiceV2StubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listSinksSettings = settingsBuilder.listSinksSettings().build();
    getSinkSettings = settingsBuilder.getSinkSettings().build();
    createSinkSettings = settingsBuilder.createSinkSettings().build();
    updateSinkSettings = settingsBuilder.updateSinkSettings().build();
    deleteSinkSettings = settingsBuilder.deleteSinkSettings().build();
    listExclusionsSettings = settingsBuilder.listExclusionsSettings().build();
    getExclusionSettings = settingsBuilder.getExclusionSettings().build();
    createExclusionSettings = settingsBuilder.createExclusionSettings().build();
    updateExclusionSettings = settingsBuilder.updateExclusionSettings().build();
    deleteExclusionSettings = settingsBuilder.deleteExclusionSettings().build();
  }

  private static final PagedListDescriptor<ListSinksRequest, ListSinksResponse, LogSink>
      LIST_SINKS_PAGE_STR_DESC =
          new PagedListDescriptor<ListSinksRequest, ListSinksResponse, LogSink>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListSinksRequest injectToken(ListSinksRequest payload, String token) {
              return ListSinksRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListSinksRequest injectPageSize(ListSinksRequest payload, int pageSize) {
              return ListSinksRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListSinksRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListSinksResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LogSink> extractResources(ListSinksResponse payload) {
              return payload.getSinksList();
            }
          };

  private static final PagedListDescriptor<
          ListExclusionsRequest, ListExclusionsResponse, LogExclusion>
      LIST_EXCLUSIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListExclusionsRequest, ListExclusionsResponse, LogExclusion>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListExclusionsRequest injectToken(ListExclusionsRequest payload, String token) {
              return ListExclusionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListExclusionsRequest injectPageSize(
                ListExclusionsRequest payload, int pageSize) {
              return ListExclusionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListExclusionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListExclusionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<LogExclusion> extractResources(ListExclusionsResponse payload) {
              return payload.getExclusionsList();
            }
          };

  private static final PagedListResponseFactory<
          ListSinksRequest, ListSinksResponse, ListSinksPagedResponse>
      LIST_SINKS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListSinksRequest, ListSinksResponse, ListSinksPagedResponse>() {
            @Override
            public ApiFuture<ListSinksPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListSinksRequest, ListSinksResponse> callable,
                ListSinksRequest request,
                ApiCallContext context,
                ApiFuture<ListSinksResponse> futureResponse) {
              PageContext<ListSinksRequest, ListSinksResponse, LogSink> pageContext =
                  PageContext.create(callable, LIST_SINKS_PAGE_STR_DESC, request, context);
              return ListSinksPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListExclusionsRequest, ListExclusionsResponse, ListExclusionsPagedResponse>
      LIST_EXCLUSIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListExclusionsRequest, ListExclusionsResponse, ListExclusionsPagedResponse>() {
            @Override
            public ApiFuture<ListExclusionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListExclusionsRequest, ListExclusionsResponse> callable,
                ListExclusionsRequest request,
                ApiCallContext context,
                ApiFuture<ListExclusionsResponse> futureResponse) {
              PageContext<ListExclusionsRequest, ListExclusionsResponse, LogExclusion> pageContext =
                  PageContext.create(callable, LIST_EXCLUSIONS_PAGE_STR_DESC, request, context);
              return ListExclusionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Builder for ConfigServiceV2StubSettings. */
  public static class Builder extends StubSettings.Builder<ConfigServiceV2StubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final PagedCallSettings.Builder<
            ListSinksRequest, ListSinksResponse, ListSinksPagedResponse>
        listSinksSettings;
    private final UnaryCallSettings.Builder<GetSinkRequest, LogSink> getSinkSettings;
    private final UnaryCallSettings.Builder<CreateSinkRequest, LogSink> createSinkSettings;
    private final UnaryCallSettings.Builder<UpdateSinkRequest, LogSink> updateSinkSettings;
    private final UnaryCallSettings.Builder<DeleteSinkRequest, Empty> deleteSinkSettings;
    private final PagedCallSettings.Builder<
            ListExclusionsRequest, ListExclusionsResponse, ListExclusionsPagedResponse>
        listExclusionsSettings;
    private final UnaryCallSettings.Builder<GetExclusionRequest, LogExclusion> getExclusionSettings;
    private final UnaryCallSettings.Builder<CreateExclusionRequest, LogExclusion>
        createExclusionSettings;
    private final UnaryCallSettings.Builder<UpdateExclusionRequest, LogExclusion>
        updateExclusionSettings;
    private final UnaryCallSettings.Builder<DeleteExclusionRequest, Empty> deleteExclusionSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED,
                  StatusCode.Code.INTERNAL,
                  StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.2)
              .setMaxRetryDelay(Duration.ofMillis(1000L))
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.5)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(90000L))
              .build();
      definitions.put("default", settings);
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelay(Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.2)
              .setMaxRetryDelay(Duration.ofMillis(1000L))
              .setInitialRpcTimeout(Duration.ofMillis(30000L))
              .setRpcTimeoutMultiplier(1.5)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(120000L))
              .build();
      definitions.put("write_sink", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listSinksSettings = PagedCallSettings.newBuilder(LIST_SINKS_PAGE_STR_FACT);

      getSinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createSinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateSinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteSinkSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listExclusionsSettings = PagedCallSettings.newBuilder(LIST_EXCLUSIONS_PAGE_STR_FACT);

      getExclusionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      createExclusionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      updateExclusionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteExclusionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listSinksSettings,
              getSinkSettings,
              createSinkSettings,
              updateSinkSettings,
              deleteSinkSettings,
              listExclusionsSettings,
              getExclusionSettings,
              createExclusionSettings,
              updateExclusionSettings,
              deleteExclusionSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .listSinksSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getSinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createSinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateSinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteSinkSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listExclusionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .getExclusionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .createExclusionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .updateExclusionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("non_idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteExclusionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(ConfigServiceV2StubSettings settings) {
      super(settings);

      listSinksSettings = settings.listSinksSettings.toBuilder();
      getSinkSettings = settings.getSinkSettings.toBuilder();
      createSinkSettings = settings.createSinkSettings.toBuilder();
      updateSinkSettings = settings.updateSinkSettings.toBuilder();
      deleteSinkSettings = settings.deleteSinkSettings.toBuilder();
      listExclusionsSettings = settings.listExclusionsSettings.toBuilder();
      getExclusionSettings = settings.getExclusionSettings.toBuilder();
      createExclusionSettings = settings.createExclusionSettings.toBuilder();
      updateExclusionSettings = settings.updateExclusionSettings.toBuilder();
      deleteExclusionSettings = settings.deleteExclusionSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listSinksSettings,
              getSinkSettings,
              createSinkSettings,
              updateSinkSettings,
              deleteSinkSettings,
              listExclusionsSettings,
              getExclusionSettings,
              createExclusionSettings,
              updateExclusionSettings,
              deleteExclusionSettings);
    }

    // NEXT_MAJOR_VER: remove 'throws Exception'
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

    /** Returns the builder for the settings used for calls to listSinks. */
    public PagedCallSettings.Builder<ListSinksRequest, ListSinksResponse, ListSinksPagedResponse>
        listSinksSettings() {
      return listSinksSettings;
    }

    /** Returns the builder for the settings used for calls to getSink. */
    public UnaryCallSettings.Builder<GetSinkRequest, LogSink> getSinkSettings() {
      return getSinkSettings;
    }

    /** Returns the builder for the settings used for calls to createSink. */
    public UnaryCallSettings.Builder<CreateSinkRequest, LogSink> createSinkSettings() {
      return createSinkSettings;
    }

    /** Returns the builder for the settings used for calls to updateSink. */
    public UnaryCallSettings.Builder<UpdateSinkRequest, LogSink> updateSinkSettings() {
      return updateSinkSettings;
    }

    /** Returns the builder for the settings used for calls to deleteSink. */
    public UnaryCallSettings.Builder<DeleteSinkRequest, Empty> deleteSinkSettings() {
      return deleteSinkSettings;
    }

    /** Returns the builder for the settings used for calls to listExclusions. */
    public PagedCallSettings.Builder<
            ListExclusionsRequest, ListExclusionsResponse, ListExclusionsPagedResponse>
        listExclusionsSettings() {
      return listExclusionsSettings;
    }

    /** Returns the builder for the settings used for calls to getExclusion. */
    public UnaryCallSettings.Builder<GetExclusionRequest, LogExclusion> getExclusionSettings() {
      return getExclusionSettings;
    }

    /** Returns the builder for the settings used for calls to createExclusion. */
    public UnaryCallSettings.Builder<CreateExclusionRequest, LogExclusion>
        createExclusionSettings() {
      return createExclusionSettings;
    }

    /** Returns the builder for the settings used for calls to updateExclusion. */
    public UnaryCallSettings.Builder<UpdateExclusionRequest, LogExclusion>
        updateExclusionSettings() {
      return updateExclusionSettings;
    }

    /** Returns the builder for the settings used for calls to deleteExclusion. */
    public UnaryCallSettings.Builder<DeleteExclusionRequest, Empty> deleteExclusionSettings() {
      return deleteExclusionSettings;
    }

    @Override
    public ConfigServiceV2StubSettings build() throws IOException {
      return new ConfigServiceV2StubSettings(this);
    }
  }
}
