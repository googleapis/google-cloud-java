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

package com.google.cloud.workflows.executions.v1beta.stub;

import static com.google.cloud.workflows.executions.v1beta.ExecutionsClient.ListExecutionsPagedResponse;

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
import com.google.cloud.workflows.executions.v1beta.CancelExecutionRequest;
import com.google.cloud.workflows.executions.v1beta.CreateExecutionRequest;
import com.google.cloud.workflows.executions.v1beta.Execution;
import com.google.cloud.workflows.executions.v1beta.GetExecutionRequest;
import com.google.cloud.workflows.executions.v1beta.ListExecutionsRequest;
import com.google.cloud.workflows.executions.v1beta.ListExecutionsResponse;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ExecutionsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (workflowexecutions.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createExecution to 30 seconds:
 *
 * <pre>{@code
 * ExecutionsStubSettings.Builder executionsSettingsBuilder = ExecutionsStubSettings.newBuilder();
 * executionsSettingsBuilder
 *     .createExecutionSettings()
 *     .setRetrySettings(
 *         executionsSettingsBuilder
 *             .createExecutionSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ExecutionsStubSettings executionsSettings = executionsSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ExecutionsStubSettings extends StubSettings<ExecutionsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListExecutionsRequest, ListExecutionsResponse, ListExecutionsPagedResponse>
      listExecutionsSettings;
  private final UnaryCallSettings<CreateExecutionRequest, Execution> createExecutionSettings;
  private final UnaryCallSettings<GetExecutionRequest, Execution> getExecutionSettings;
  private final UnaryCallSettings<CancelExecutionRequest, Execution> cancelExecutionSettings;

  private static final PagedListDescriptor<ListExecutionsRequest, ListExecutionsResponse, Execution>
      LIST_EXECUTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListExecutionsRequest, ListExecutionsResponse, Execution>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListExecutionsRequest injectToken(ListExecutionsRequest payload, String token) {
              return ListExecutionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListExecutionsRequest injectPageSize(
                ListExecutionsRequest payload, int pageSize) {
              return ListExecutionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListExecutionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListExecutionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Execution> extractResources(ListExecutionsResponse payload) {
              return payload.getExecutionsList() == null
                  ? ImmutableList.<Execution>of()
                  : payload.getExecutionsList();
            }
          };

  private static final PagedListResponseFactory<
          ListExecutionsRequest, ListExecutionsResponse, ListExecutionsPagedResponse>
      LIST_EXECUTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListExecutionsRequest, ListExecutionsResponse, ListExecutionsPagedResponse>() {
            @Override
            public ApiFuture<ListExecutionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListExecutionsRequest, ListExecutionsResponse> callable,
                ListExecutionsRequest request,
                ApiCallContext context,
                ApiFuture<ListExecutionsResponse> futureResponse) {
              PageContext<ListExecutionsRequest, ListExecutionsResponse, Execution> pageContext =
                  PageContext.create(callable, LIST_EXECUTIONS_PAGE_STR_DESC, request, context);
              return ListExecutionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listExecutions. */
  public PagedCallSettings<
          ListExecutionsRequest, ListExecutionsResponse, ListExecutionsPagedResponse>
      listExecutionsSettings() {
    return listExecutionsSettings;
  }

  /** Returns the object with the settings used for calls to createExecution. */
  public UnaryCallSettings<CreateExecutionRequest, Execution> createExecutionSettings() {
    return createExecutionSettings;
  }

  /** Returns the object with the settings used for calls to getExecution. */
  public UnaryCallSettings<GetExecutionRequest, Execution> getExecutionSettings() {
    return getExecutionSettings;
  }

  /** Returns the object with the settings used for calls to cancelExecution. */
  public UnaryCallSettings<CancelExecutionRequest, Execution> cancelExecutionSettings() {
    return cancelExecutionSettings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ExecutionsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcExecutionsStub.create(this);
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
    return "workflowexecutions.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(ExecutionsStubSettings.class))
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

  protected ExecutionsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listExecutionsSettings = settingsBuilder.listExecutionsSettings().build();
    createExecutionSettings = settingsBuilder.createExecutionSettings().build();
    getExecutionSettings = settingsBuilder.getExecutionSettings().build();
    cancelExecutionSettings = settingsBuilder.cancelExecutionSettings().build();
  }

  /** Builder for ExecutionsStubSettings. */
  public static class Builder extends StubSettings.Builder<ExecutionsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListExecutionsRequest, ListExecutionsResponse, ListExecutionsPagedResponse>
        listExecutionsSettings;
    private final UnaryCallSettings.Builder<CreateExecutionRequest, Execution>
        createExecutionSettings;
    private final UnaryCallSettings.Builder<GetExecutionRequest, Execution> getExecutionSettings;
    private final UnaryCallSettings.Builder<CancelExecutionRequest, Execution>
        cancelExecutionSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put("no_retry_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings = RetrySettings.newBuilder().setRpcTimeoutMultiplier(1.0).build();
      definitions.put("no_retry_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listExecutionsSettings = PagedCallSettings.newBuilder(LIST_EXECUTIONS_PAGE_STR_FACT);
      createExecutionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getExecutionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      cancelExecutionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listExecutionsSettings,
              createExecutionSettings,
              getExecutionSettings,
              cancelExecutionSettings);
      initDefaults(this);
    }

    protected Builder(ExecutionsStubSettings settings) {
      super(settings);

      listExecutionsSettings = settings.listExecutionsSettings.toBuilder();
      createExecutionSettings = settings.createExecutionSettings.toBuilder();
      getExecutionSettings = settings.getExecutionSettings.toBuilder();
      cancelExecutionSettings = settings.cancelExecutionSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listExecutionsSettings,
              createExecutionSettings,
              getExecutionSettings,
              cancelExecutionSettings);
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
          .listExecutionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .createExecutionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getExecutionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .cancelExecutionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

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

    /** Returns the builder for the settings used for calls to listExecutions. */
    public PagedCallSettings.Builder<
            ListExecutionsRequest, ListExecutionsResponse, ListExecutionsPagedResponse>
        listExecutionsSettings() {
      return listExecutionsSettings;
    }

    /** Returns the builder for the settings used for calls to createExecution. */
    public UnaryCallSettings.Builder<CreateExecutionRequest, Execution> createExecutionSettings() {
      return createExecutionSettings;
    }

    /** Returns the builder for the settings used for calls to getExecution. */
    public UnaryCallSettings.Builder<GetExecutionRequest, Execution> getExecutionSettings() {
      return getExecutionSettings;
    }

    /** Returns the builder for the settings used for calls to cancelExecution. */
    public UnaryCallSettings.Builder<CancelExecutionRequest, Execution> cancelExecutionSettings() {
      return cancelExecutionSettings;
    }

    @Override
    public ExecutionsStubSettings build() throws IOException {
      return new ExecutionsStubSettings(this);
    }
  }
}
