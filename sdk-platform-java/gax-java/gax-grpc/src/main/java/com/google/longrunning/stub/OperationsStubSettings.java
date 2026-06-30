/*
 * Copyright 2018 Google LLC
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
package com.google.longrunning.stub;

import static com.google.longrunning.OperationsClient.ListOperationsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
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
import com.google.longrunning.WaitOperationRequest;
import com.google.protobuf.Empty;
import java.io.IOException;

/** Settings class to configure an instance of {@link OperationsStub}. */
public class OperationsStubSettings extends StubSettings<OperationsStubSettings> {

  private final UnaryCallSettings<GetOperationRequest, Operation> getOperationSettings;
  private final PagedCallSettings<
          ListOperationsRequest, ListOperationsResponse, ListOperationsPagedResponse>
      listOperationsSettings;
  private final UnaryCallSettings<CancelOperationRequest, Empty> cancelOperationSettings;
  private final UnaryCallSettings<DeleteOperationRequest, Empty> deleteOperationSettings;
  private final UnaryCallSettings<WaitOperationRequest, Operation> waitOperationSettings;

  /** Returns the object with the settings used for calls to getOperation. */
  public UnaryCallSettings<GetOperationRequest, Operation> getOperationSettings() {
    return getOperationSettings;
  }

  /** Returns the object with the settings used for calls to listOperations. */
  public PagedCallSettings<
          ListOperationsRequest, ListOperationsResponse, ListOperationsPagedResponse>
      listOperationsSettings() {
    return listOperationsSettings;
  }

  /** Returns the object with the settings used for calls to cancelOperation. */
  public UnaryCallSettings<CancelOperationRequest, Empty> cancelOperationSettings() {
    return cancelOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteOperation. */
  public UnaryCallSettings<DeleteOperationRequest, Empty> deleteOperationSettings() {
    return deleteOperationSettings;
  }

  /** Returns the object with the settings used for calls to waitOperation. */
  public UnaryCallSettings<WaitOperationRequest, Operation> waitOperationSettings() {
    return waitOperationSettings;
  }

  public OperationsStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcOperationsStub.create(this);
    } else {
      throw new UnsupportedOperationException(
          "Transport not supported: " + getTransportChannelProvider().getTransportName());
    }
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(OperationsStubSettings.class))
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

  protected OperationsStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getOperationSettings = settingsBuilder.getOperationSettings().build();
    listOperationsSettings = settingsBuilder.listOperationsSettings().build();
    cancelOperationSettings = settingsBuilder.cancelOperationSettings().build();
    deleteOperationSettings = settingsBuilder.deleteOperationSettings().build();
    waitOperationSettings = settingsBuilder.waitOperationSettings().build();
  }

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
              return payload.getOperationsList();
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

  /** Builder for OperationsStubSettings. */
  public static class Builder extends StubSettings.Builder<OperationsStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;

    private final UnaryCallSettings.Builder<GetOperationRequest, Operation> getOperationSettings;
    private final PagedCallSettings.Builder<
            ListOperationsRequest, ListOperationsResponse, ListOperationsPagedResponse>
        listOperationsSettings;
    private final UnaryCallSettings.Builder<CancelOperationRequest, Empty> cancelOperationSettings;
    private final UnaryCallSettings.Builder<DeleteOperationRequest, Empty> deleteOperationSettings;
    private final UnaryCallSettings.Builder<WaitOperationRequest, Operation> waitOperationSettings;

    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "idempotent",
          ImmutableSet.copyOf(
              Lists.<StatusCode.Code>newArrayList(
                  StatusCode.Code.DEADLINE_EXCEEDED, StatusCode.Code.UNAVAILABLE)));
      definitions.put("non_idempotent", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRetryDelayDuration(java.time.Duration.ofMillis(100L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(java.time.Duration.ofMillis(60000L))
              .setInitialRpcTimeoutDuration(java.time.Duration.ofMillis(90000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(java.time.Duration.ofMillis(90000L))
              .setTotalTimeoutDuration(java.time.Duration.ofMillis(600000L))
              .build();
      definitions.put("default", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this((ClientContext) null);
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getOperationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      listOperationsSettings = PagedCallSettings.newBuilder(LIST_OPERATIONS_PAGE_STR_FACT);

      cancelOperationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      deleteOperationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      waitOperationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getOperationSettings,
              listOperationsSettings,
              cancelOperationSettings,
              deleteOperationSettings);

      initDefaults(this);
    }

    private static Builder createDefault() {
      Builder builder = new Builder((ClientContext) null);
      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {

      builder
          .getOperationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .listOperationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .cancelOperationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .deleteOperationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      builder
          .waitOperationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("idempotent"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("default"));

      return builder;
    }

    protected Builder(OperationsStubSettings settings) {
      super(settings);

      getOperationSettings = settings.getOperationSettings.toBuilder();
      listOperationsSettings = settings.listOperationsSettings.toBuilder();
      cancelOperationSettings = settings.cancelOperationSettings.toBuilder();
      deleteOperationSettings = settings.deleteOperationSettings.toBuilder();
      waitOperationSettings = settings.waitOperationSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getOperationSettings,
              listOperationsSettings,
              cancelOperationSettings,
              deleteOperationSettings,
              waitOperationSettings);
    }

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

    /** Returns the builder for the settings used for calls to getOperation. */
    public UnaryCallSettings.Builder<GetOperationRequest, Operation> getOperationSettings() {
      return getOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listOperations. */
    public PagedCallSettings.Builder<
            ListOperationsRequest, ListOperationsResponse, ListOperationsPagedResponse>
        listOperationsSettings() {
      return listOperationsSettings;
    }

    /** Returns the builder for the settings used for calls to cancelOperation. */
    public UnaryCallSettings.Builder<CancelOperationRequest, Empty> cancelOperationSettings() {
      return cancelOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteOperation. */
    public UnaryCallSettings.Builder<DeleteOperationRequest, Empty> deleteOperationSettings() {
      return deleteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to waitOperation. */
    public UnaryCallSettings.Builder<WaitOperationRequest, Operation> waitOperationSettings() {
      return waitOperationSettings;
    }

    @Override
    public OperationsStubSettings build() throws IOException {
      return new OperationsStubSettings(this);
    }
  }
}
