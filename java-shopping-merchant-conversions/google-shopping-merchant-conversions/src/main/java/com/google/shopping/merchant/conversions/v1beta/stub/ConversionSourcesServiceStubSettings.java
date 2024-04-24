/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.merchant.conversions.v1beta.stub;

import static com.google.shopping.merchant.conversions.v1beta.ConversionSourcesServiceClient.ListConversionSourcesPagedResponse;

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
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.conversions.v1beta.ConversionSource;
import com.google.shopping.merchant.conversions.v1beta.CreateConversionSourceRequest;
import com.google.shopping.merchant.conversions.v1beta.DeleteConversionSourceRequest;
import com.google.shopping.merchant.conversions.v1beta.GetConversionSourceRequest;
import com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesRequest;
import com.google.shopping.merchant.conversions.v1beta.ListConversionSourcesResponse;
import com.google.shopping.merchant.conversions.v1beta.UndeleteConversionSourceRequest;
import com.google.shopping.merchant.conversions.v1beta.UpdateConversionSourceRequest;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ConversionSourcesServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (merchantapi.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of createConversionSource to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConversionSourcesServiceStubSettings.Builder conversionSourcesServiceSettingsBuilder =
 *     ConversionSourcesServiceStubSettings.newBuilder();
 * conversionSourcesServiceSettingsBuilder
 *     .createConversionSourceSettings()
 *     .setRetrySettings(
 *         conversionSourcesServiceSettingsBuilder
 *             .createConversionSourceSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * ConversionSourcesServiceStubSettings conversionSourcesServiceSettings =
 *     conversionSourcesServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ConversionSourcesServiceStubSettings
    extends StubSettings<ConversionSourcesServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/content").build();

  private final UnaryCallSettings<CreateConversionSourceRequest, ConversionSource>
      createConversionSourceSettings;
  private final UnaryCallSettings<UpdateConversionSourceRequest, ConversionSource>
      updateConversionSourceSettings;
  private final UnaryCallSettings<DeleteConversionSourceRequest, Empty>
      deleteConversionSourceSettings;
  private final UnaryCallSettings<UndeleteConversionSourceRequest, ConversionSource>
      undeleteConversionSourceSettings;
  private final UnaryCallSettings<GetConversionSourceRequest, ConversionSource>
      getConversionSourceSettings;
  private final PagedCallSettings<
          ListConversionSourcesRequest,
          ListConversionSourcesResponse,
          ListConversionSourcesPagedResponse>
      listConversionSourcesSettings;

  private static final PagedListDescriptor<
          ListConversionSourcesRequest, ListConversionSourcesResponse, ConversionSource>
      LIST_CONVERSION_SOURCES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListConversionSourcesRequest, ListConversionSourcesResponse, ConversionSource>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListConversionSourcesRequest injectToken(
                ListConversionSourcesRequest payload, String token) {
              return ListConversionSourcesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListConversionSourcesRequest injectPageSize(
                ListConversionSourcesRequest payload, int pageSize) {
              return ListConversionSourcesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListConversionSourcesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListConversionSourcesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ConversionSource> extractResources(
                ListConversionSourcesResponse payload) {
              return payload.getConversionSourcesList() == null
                  ? ImmutableList.<ConversionSource>of()
                  : payload.getConversionSourcesList();
            }
          };

  private static final PagedListResponseFactory<
          ListConversionSourcesRequest,
          ListConversionSourcesResponse,
          ListConversionSourcesPagedResponse>
      LIST_CONVERSION_SOURCES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListConversionSourcesRequest,
              ListConversionSourcesResponse,
              ListConversionSourcesPagedResponse>() {
            @Override
            public ApiFuture<ListConversionSourcesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListConversionSourcesRequest, ListConversionSourcesResponse> callable,
                ListConversionSourcesRequest request,
                ApiCallContext context,
                ApiFuture<ListConversionSourcesResponse> futureResponse) {
              PageContext<
                      ListConversionSourcesRequest, ListConversionSourcesResponse, ConversionSource>
                  pageContext =
                      PageContext.create(
                          callable, LIST_CONVERSION_SOURCES_PAGE_STR_DESC, request, context);
              return ListConversionSourcesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to createConversionSource. */
  public UnaryCallSettings<CreateConversionSourceRequest, ConversionSource>
      createConversionSourceSettings() {
    return createConversionSourceSettings;
  }

  /** Returns the object with the settings used for calls to updateConversionSource. */
  public UnaryCallSettings<UpdateConversionSourceRequest, ConversionSource>
      updateConversionSourceSettings() {
    return updateConversionSourceSettings;
  }

  /** Returns the object with the settings used for calls to deleteConversionSource. */
  public UnaryCallSettings<DeleteConversionSourceRequest, Empty> deleteConversionSourceSettings() {
    return deleteConversionSourceSettings;
  }

  /** Returns the object with the settings used for calls to undeleteConversionSource. */
  public UnaryCallSettings<UndeleteConversionSourceRequest, ConversionSource>
      undeleteConversionSourceSettings() {
    return undeleteConversionSourceSettings;
  }

  /** Returns the object with the settings used for calls to getConversionSource. */
  public UnaryCallSettings<GetConversionSourceRequest, ConversionSource>
      getConversionSourceSettings() {
    return getConversionSourceSettings;
  }

  /** Returns the object with the settings used for calls to listConversionSources. */
  public PagedCallSettings<
          ListConversionSourcesRequest,
          ListConversionSourcesResponse,
          ListConversionSourcesPagedResponse>
      listConversionSourcesSettings() {
    return listConversionSourcesSettings;
  }

  public ConversionSourcesServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcConversionSourcesServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonConversionSourcesServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "merchantapi";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "merchantapi.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "merchantapi.mtls.googleapis.com:443";
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

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ConversionSourcesServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(ConversionSourcesServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ConversionSourcesServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected ConversionSourcesServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    createConversionSourceSettings = settingsBuilder.createConversionSourceSettings().build();
    updateConversionSourceSettings = settingsBuilder.updateConversionSourceSettings().build();
    deleteConversionSourceSettings = settingsBuilder.deleteConversionSourceSettings().build();
    undeleteConversionSourceSettings = settingsBuilder.undeleteConversionSourceSettings().build();
    getConversionSourceSettings = settingsBuilder.getConversionSourceSettings().build();
    listConversionSourcesSettings = settingsBuilder.listConversionSourcesSettings().build();
  }

  /** Builder for ConversionSourcesServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<ConversionSourcesServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<CreateConversionSourceRequest, ConversionSource>
        createConversionSourceSettings;
    private final UnaryCallSettings.Builder<UpdateConversionSourceRequest, ConversionSource>
        updateConversionSourceSettings;
    private final UnaryCallSettings.Builder<DeleteConversionSourceRequest, Empty>
        deleteConversionSourceSettings;
    private final UnaryCallSettings.Builder<UndeleteConversionSourceRequest, ConversionSource>
        undeleteConversionSourceSettings;
    private final UnaryCallSettings.Builder<GetConversionSourceRequest, ConversionSource>
        getConversionSourceSettings;
    private final PagedCallSettings.Builder<
            ListConversionSourcesRequest,
            ListConversionSourcesResponse,
            ListConversionSourcesPagedResponse>
        listConversionSourcesSettings;
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
              .setInitialRetryDelay(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelay(Duration.ofMillis(10000L))
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      createConversionSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateConversionSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteConversionSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      undeleteConversionSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getConversionSourceSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listConversionSourcesSettings =
          PagedCallSettings.newBuilder(LIST_CONVERSION_SOURCES_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createConversionSourceSettings,
              updateConversionSourceSettings,
              deleteConversionSourceSettings,
              undeleteConversionSourceSettings,
              getConversionSourceSettings,
              listConversionSourcesSettings);
      initDefaults(this);
    }

    protected Builder(ConversionSourcesServiceStubSettings settings) {
      super(settings);

      createConversionSourceSettings = settings.createConversionSourceSettings.toBuilder();
      updateConversionSourceSettings = settings.updateConversionSourceSettings.toBuilder();
      deleteConversionSourceSettings = settings.deleteConversionSourceSettings.toBuilder();
      undeleteConversionSourceSettings = settings.undeleteConversionSourceSettings.toBuilder();
      getConversionSourceSettings = settings.getConversionSourceSettings.toBuilder();
      listConversionSourcesSettings = settings.listConversionSourcesSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              createConversionSourceSettings,
              updateConversionSourceSettings,
              deleteConversionSourceSettings,
              undeleteConversionSourceSettings,
              getConversionSourceSettings,
              listConversionSourcesSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .createConversionSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .updateConversionSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteConversionSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .undeleteConversionSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getConversionSourceSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listConversionSourcesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

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

    /** Returns the builder for the settings used for calls to createConversionSource. */
    public UnaryCallSettings.Builder<CreateConversionSourceRequest, ConversionSource>
        createConversionSourceSettings() {
      return createConversionSourceSettings;
    }

    /** Returns the builder for the settings used for calls to updateConversionSource. */
    public UnaryCallSettings.Builder<UpdateConversionSourceRequest, ConversionSource>
        updateConversionSourceSettings() {
      return updateConversionSourceSettings;
    }

    /** Returns the builder for the settings used for calls to deleteConversionSource. */
    public UnaryCallSettings.Builder<DeleteConversionSourceRequest, Empty>
        deleteConversionSourceSettings() {
      return deleteConversionSourceSettings;
    }

    /** Returns the builder for the settings used for calls to undeleteConversionSource. */
    public UnaryCallSettings.Builder<UndeleteConversionSourceRequest, ConversionSource>
        undeleteConversionSourceSettings() {
      return undeleteConversionSourceSettings;
    }

    /** Returns the builder for the settings used for calls to getConversionSource. */
    public UnaryCallSettings.Builder<GetConversionSourceRequest, ConversionSource>
        getConversionSourceSettings() {
      return getConversionSourceSettings;
    }

    /** Returns the builder for the settings used for calls to listConversionSources. */
    public PagedCallSettings.Builder<
            ListConversionSourcesRequest,
            ListConversionSourcesResponse,
            ListConversionSourcesPagedResponse>
        listConversionSourcesSettings() {
      return listConversionSourcesSettings;
    }

    @Override
    public ConversionSourcesServiceStubSettings build() throws IOException {
      return new ConversionSourcesServiceStubSettings(this);
    }
  }
}
