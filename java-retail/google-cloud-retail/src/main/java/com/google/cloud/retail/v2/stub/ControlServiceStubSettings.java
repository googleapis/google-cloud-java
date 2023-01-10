/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.retail.v2.stub;

import static com.google.cloud.retail.v2.ControlServiceClient.ListControlsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
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
import com.google.cloud.retail.v2.Control;
import com.google.cloud.retail.v2.CreateControlRequest;
import com.google.cloud.retail.v2.DeleteControlRequest;
import com.google.cloud.retail.v2.GetControlRequest;
import com.google.cloud.retail.v2.ListControlsRequest;
import com.google.cloud.retail.v2.ListControlsResponse;
import com.google.cloud.retail.v2.UpdateControlRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ControlServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (retail.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createControl to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ControlServiceStubSettings.Builder controlServiceSettingsBuilder =
 *     ControlServiceStubSettings.newBuilder();
 * controlServiceSettingsBuilder
 *     .createControlSettings()
 *     .setRetrySettings(
 *         controlServiceSettingsBuilder
 *             .createControlSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ControlServiceStubSettings controlServiceSettings = controlServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ControlServiceStubSettings extends StubSettings<ControlServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final UnaryCallSettings<CreateControlRequest, Control> createControlSettings;
  private final UnaryCallSettings<DeleteControlRequest, Empty> deleteControlSettings;
  private final UnaryCallSettings<UpdateControlRequest, Control> updateControlSettings;
  private final UnaryCallSettings<GetControlRequest, Control> getControlSettings;
  private final PagedCallSettings<
          ListControlsRequest, ListControlsResponse, ListControlsPagedResponse>
      listControlsSettings;

  private static final PagedListDescriptor<ListControlsRequest, ListControlsResponse, Control>
      LIST_CONTROLS_PAGE_STR_DESC =
          new PagedListDescriptor<ListControlsRequest, ListControlsResponse, Control>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListControlsRequest injectToken(ListControlsRequest payload, String token) {
              return ListControlsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListControlsRequest injectPageSize(ListControlsRequest payload, int pageSize) {
              return ListControlsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListControlsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListControlsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Control> extractResources(ListControlsResponse payload) {
              return payload.getControlsList() == null
                  ? ImmutableList.<Control>of()
                  : payload.getControlsList();
            }
          };

  private static final PagedListResponseFactory<
          ListControlsRequest, ListControlsResponse, ListControlsPagedResponse>
      LIST_CONTROLS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListControlsRequest, ListControlsResponse, ListControlsPagedResponse>() {
            @Override
            public ApiFuture<ListControlsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListControlsRequest, ListControlsResponse> callable,
                ListControlsRequest request,
                ApiCallContext context,
                ApiFuture<ListControlsResponse> futureResponse) {
              PageContext<ListControlsRequest, ListControlsResponse, Control> pageContext =
                  PageContext.create(callable, LIST_CONTROLS_PAGE_STR_DESC, request, context);
              return ListControlsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createControl. */
  public UnaryCallSettings<CreateControlRequest, Control> createControlSettings() {
    return createControlSettings;
  }

  /** Returns the object with the settings used for calls to deleteControl. */
  public UnaryCallSettings<DeleteControlRequest, Empty> deleteControlSettings() {
    return deleteControlSettings;
  }

  /** Returns the object with the settings used for calls to updateControl. */
  public UnaryCallSettings<UpdateControlRequest, Control> updateControlSettings() {
    return updateControlSettings;
  }

  /** Returns the object with the settings used for calls to getControl. */
  public UnaryCallSettings<GetControlRequest, Control> getControlSettings() {
    return getControlSettings;
  }

  /** Returns the object with the settings used for calls to listControls. */
  public PagedCallSettings<ListControlsRequest, ListControlsResponse, ListControlsPagedResponse>
      listControlsSettings() {
    return listControlsSettings;
  }

  public ControlServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcControlServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonControlServiceStub.create(this);
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
    return "retail.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "retail.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ControlServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ControlServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ControlServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  public static Builder newHttpJsonBuilder() {
    return Builder.createHttpJsonDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected ControlServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createControlSettings = settingsBuilder.createControlSettings().build();
    deleteControlSettings = settingsBuilder.deleteControlSettings().build();
    updateControlSettings = settingsBuilder.updateControlSettings().build();
    getControlSettings = settingsBuilder.getControlSettings().build();
    listControlsSettings = settingsBuilder.listControlsSettings().build();
  }

  /** Builder for ControlServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<ControlServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateControlRequest, Control> createControlSettings;
    private final UnaryCallSettings.Builder<DeleteControlRequest, Empty> deleteControlSettings;
    private final UnaryCallSettings.Builder<UpdateControlRequest, Control> updateControlSettings;
    private final UnaryCallSettings.Builder<GetControlRequest, Control> getControlSettings;
    private final PagedCallSettings.Builder<
            ListControlsRequest, ListControlsResponse, ListControlsPagedResponse>
        listControlsSettings;
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

      createControlSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteControlSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateControlSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getControlSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listControlsSettings = PagedCallSettings.newBuilder(LIST_CONTROLS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createControlSettings,
              deleteControlSettings,
              updateControlSettings,
              getControlSettings,
              listControlsSettings);
      initDefaults(this);
    }

    protected Builder(ControlServiceStubSettings settings) {
      super(settings);

      createControlSettings = settings.createControlSettings.toBuilder();
      deleteControlSettings = settings.deleteControlSettings.toBuilder();
      updateControlSettings = settings.updateControlSettings.toBuilder();
      getControlSettings = settings.getControlSettings.toBuilder();
      listControlsSettings = settings.listControlsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createControlSettings,
              deleteControlSettings,
              updateControlSettings,
              getControlSettings,
              listControlsSettings);
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

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setEndpoint(getDefaultEndpoint());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createControlSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .deleteControlSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .updateControlSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .getControlSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      builder
          .listControlsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_params"));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to createControl. */
    public UnaryCallSettings.Builder<CreateControlRequest, Control> createControlSettings() {
      return createControlSettings;
    }

    /** Returns the builder for the settings used for calls to deleteControl. */
    public UnaryCallSettings.Builder<DeleteControlRequest, Empty> deleteControlSettings() {
      return deleteControlSettings;
    }

    /** Returns the builder for the settings used for calls to updateControl. */
    public UnaryCallSettings.Builder<UpdateControlRequest, Control> updateControlSettings() {
      return updateControlSettings;
    }

    /** Returns the builder for the settings used for calls to getControl. */
    public UnaryCallSettings.Builder<GetControlRequest, Control> getControlSettings() {
      return getControlSettings;
    }

    /** Returns the builder for the settings used for calls to listControls. */
    public PagedCallSettings.Builder<
            ListControlsRequest, ListControlsResponse, ListControlsPagedResponse>
        listControlsSettings() {
      return listControlsSettings;
    }

    @Override
    public ControlServiceStubSettings build() throws IOException {
      return new ControlServiceStubSettings(this);
    }
  }
}
