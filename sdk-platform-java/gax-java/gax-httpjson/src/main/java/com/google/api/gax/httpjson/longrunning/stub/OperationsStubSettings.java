/*
 * Copyright 2021 Google LLC
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are
 * met:
 *
 *     * Redistributions of source code must retain the above copyright
 * notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above
 * copyright notice, this list of conditions and the following disclaimer
 * in the documentation and/or other materials provided with the
 * distribution.
 *     * Neither the name of Google LLC nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
 * "AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
 * LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
 * A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
 * OWNER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 * DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 * THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
 * OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.google.api.gax.httpjson.longrunning.stub;

import static com.google.api.gax.httpjson.longrunning.OperationsClient.ListOperationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
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
import com.google.longrunning.CancelOperationRequest;
import com.google.longrunning.DeleteOperationRequest;
import com.google.longrunning.GetOperationRequest;
import com.google.longrunning.ListOperationsRequest;
import com.google.longrunning.ListOperationsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link OperationsStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (longrunning.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getOperation to 30 seconds:
 *
 * <pre>{@code
 * OperationsStubSettings.Builder operationsSettingsBuilder = OperationsStubSettings.newBuilder();
 * operationsSettingsBuilder
 *     .getOperationSettings()
 *     .setRetrySettings(
 *         operationsSettingsBuilder
 *             .getOperationSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * OperationsStubSettings operationsSettings = operationsSettingsBuilder.build();
 * }</pre>
 */
public class OperationsStubSettings extends StubSettings<OperationsStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().build();

  private final PagedCallSettings<
          ListOperationsRequest, ListOperationsResponse, ListOperationsPagedResponse>
      listOperationsSettings;
  private final UnaryCallSettings<GetOperationRequest, Operation> getOperationSettings;
  private final UnaryCallSettings<DeleteOperationRequest, Empty> deleteOperationSettings;
  private final UnaryCallSettings<CancelOperationRequest, Empty> cancelOperationSettings;

  private static final PagedListDescriptor<ListOperationsRequest, ListOperationsResponse, Operation>
      LIST_OPERATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListOperationsRequest, ListOperationsResponse, Operation>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListOperationsRequest injectToken(ListOperationsRequest payload, String token) {
              return ListOperationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListOperationsRequest injectPageSize(
                ListOperationsRequest payload, int pageSize) {
              return ListOperationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListOperationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListOperationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Operation> extractResources(ListOperationsResponse payload) {
              return payload.getOperationsList() == null
                  ? ImmutableList.<Operation>of()
                  : payload.getOperationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListOperationsRequest, ListOperationsResponse, ListOperationsPagedResponse>
      LIST_OPERATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListOperationsRequest, ListOperationsResponse, ListOperationsPagedResponse>() {
            @Override
            public ApiFuture<ListOperationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListOperationsRequest, ListOperationsResponse> callable,
                ListOperationsRequest request,
                ApiCallContext context,
                ApiFuture<ListOperationsResponse> futureResponse) {
              PageContext<ListOperationsRequest, ListOperationsResponse, Operation> pageContext =
                  PageContext.create(callable, LIST_OPERATIONS_PAGE_STR_DESC, request, context);
              return ListOperationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listOperations. */
  public PagedCallSettings<
          ListOperationsRequest, ListOperationsResponse, ListOperationsPagedResponse>
      listOperationsSettings() {
    return listOperationsSettings;
  }

  /** Returns the object with the settings used for calls to get. */
  public UnaryCallSettings<GetOperationRequest, Operation> getOperationSettings() {
    return getOperationSettings;
  }

  /** Returns the object with the settings used for calls to delete. */
  public UnaryCallSettings<DeleteOperationRequest, Empty> deleteOperationSettings() {
    return deleteOperationSettings;
  }

  /** Returns the object with the settings used for calls to cancel. */
  public UnaryCallSettings<CancelOperationRequest, Empty> cancelOperationSettings() {
    return cancelOperationSettings;
  }

  public OperationsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonOperationsStub.create(this);
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
    return "longrunning.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "longrunning.mtls.googleapis.com:443";
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
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultHttpJsonTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(OperationsStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
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

  protected OperationsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listOperationsSettings = settingsBuilder.listOperationsSettings().build();
    getOperationSettings = settingsBuilder.getOperationSettings().build();
    deleteOperationSettings = settingsBuilder.deleteOperationSettings().build();
    cancelOperationSettings = settingsBuilder.cancelOperationSettings().build();
  }

  /** Builder for OperationsStubSettings. */
  public static class Builder extends StubSettings.Builder<OperationsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListOperationsRequest, ListOperationsResponse, ListOperationsPagedResponse>
        listOperationsSettings;
    private final UnaryCallSettings.Builder<GetOperationRequest, Operation> getOperationSettings;
    private final UnaryCallSettings.Builder<DeleteOperationRequest, Empty> deleteOperationSettings;
    private final UnaryCallSettings.Builder<CancelOperationRequest, Empty> cancelOperationSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "retry_policy_0_codes",
          ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList(StatusCode.Code.UNAVAILABLE)));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(java.time.Duration.ofMillis(500L))
              .setRetryDelayMultiplier(2.0)
              .setMaxRetryDelayDuration(java.time.Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(10000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(java.time.Duration.ofMillis(10000L))
              .setTotalTimeoutDuration(java.time.Duration.ofMillis(10000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listOperationsSettings = PagedCallSettings.newBuilder(LIST_OPERATIONS_PAGE_STR_FACT);
      getOperationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteOperationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      cancelOperationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listOperationsSettings,
              getOperationSettings,
              deleteOperationSettings,
              cancelOperationSettings);
      initDefaults(this);
    }

    protected Builder(OperationsStubSettings settings) {
      super(settings);

      listOperationsSettings = settings.listOperationsSettings.toBuilder();
      getOperationSettings = settings.getOperationSettings.toBuilder();
      deleteOperationSettings = settings.deleteOperationSettings.toBuilder();
      cancelOperationSettings = settings.cancelOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listOperationsSettings,
              getOperationSettings,
              deleteOperationSettings,
              cancelOperationSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listOperationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getOperationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteOperationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .cancelOperationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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

    /** Returns the builder for the settings used for calls to listOperations. */
    public PagedCallSettings.Builder<
            ListOperationsRequest, ListOperationsResponse, ListOperationsPagedResponse>
        listOperationsSettings() {
      return listOperationsSettings;
    }

    /** Returns the builder for the settings used for calls to get. */
    public UnaryCallSettings.Builder<GetOperationRequest, Operation> getOperationSettings() {
      return getOperationSettings;
    }

    /** Returns the builder for the settings used for calls to delete. */
    public UnaryCallSettings.Builder<DeleteOperationRequest, Empty> deleteOperationSettings() {
      return deleteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to cancel. */
    public UnaryCallSettings.Builder<CancelOperationRequest, Empty> cancelOperationSettings() {
      return cancelOperationSettings;
    }

    @Override
    public OperationsStubSettings build() throws IOException {
      return new OperationsStubSettings(this);
    }
  }
}
