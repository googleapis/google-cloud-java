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

package com.google.shopping.merchant.promotions.v1beta.stub;

import static com.google.shopping.merchant.promotions.v1beta.PromotionsServiceClient.ListPromotionsPagedResponse;

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
import com.google.shopping.merchant.promotions.v1beta.GetPromotionRequest;
import com.google.shopping.merchant.promotions.v1beta.InsertPromotionRequest;
import com.google.shopping.merchant.promotions.v1beta.ListPromotionsRequest;
import com.google.shopping.merchant.promotions.v1beta.ListPromotionsResponse;
import com.google.shopping.merchant.promotions.v1beta.Promotion;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PromotionsServiceStub}.
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
 * <p>For example, to set the total timeout of insertPromotion to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PromotionsServiceStubSettings.Builder promotionsServiceSettingsBuilder =
 *     PromotionsServiceStubSettings.newBuilder();
 * promotionsServiceSettingsBuilder
 *     .insertPromotionSettings()
 *     .setRetrySettings(
 *         promotionsServiceSettingsBuilder
 *             .insertPromotionSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PromotionsServiceStubSettings promotionsServiceSettings =
 *     promotionsServiceSettingsBuilder.build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class PromotionsServiceStubSettings extends StubSettings<PromotionsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/content").build();

  private final UnaryCallSettings<InsertPromotionRequest, Promotion> insertPromotionSettings;
  private final UnaryCallSettings<GetPromotionRequest, Promotion> getPromotionSettings;
  private final PagedCallSettings<
          ListPromotionsRequest, ListPromotionsResponse, ListPromotionsPagedResponse>
      listPromotionsSettings;

  private static final PagedListDescriptor<ListPromotionsRequest, ListPromotionsResponse, Promotion>
      LIST_PROMOTIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListPromotionsRequest, ListPromotionsResponse, Promotion>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListPromotionsRequest injectToken(ListPromotionsRequest payload, String token) {
              return ListPromotionsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListPromotionsRequest injectPageSize(
                ListPromotionsRequest payload, int pageSize) {
              return ListPromotionsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListPromotionsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListPromotionsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Promotion> extractResources(ListPromotionsResponse payload) {
              return payload.getPromotionsList() == null
                  ? ImmutableList.<Promotion>of()
                  : payload.getPromotionsList();
            }
          };

  private static final PagedListResponseFactory<
          ListPromotionsRequest, ListPromotionsResponse, ListPromotionsPagedResponse>
      LIST_PROMOTIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListPromotionsRequest, ListPromotionsResponse, ListPromotionsPagedResponse>() {
            @Override
            public ApiFuture<ListPromotionsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListPromotionsRequest, ListPromotionsResponse> callable,
                ListPromotionsRequest request,
                ApiCallContext context,
                ApiFuture<ListPromotionsResponse> futureResponse) {
              PageContext<ListPromotionsRequest, ListPromotionsResponse, Promotion> pageContext =
                  PageContext.create(callable, LIST_PROMOTIONS_PAGE_STR_DESC, request, context);
              return ListPromotionsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to insertPromotion. */
  public UnaryCallSettings<InsertPromotionRequest, Promotion> insertPromotionSettings() {
    return insertPromotionSettings;
  }

  /** Returns the object with the settings used for calls to getPromotion. */
  public UnaryCallSettings<GetPromotionRequest, Promotion> getPromotionSettings() {
    return getPromotionSettings;
  }

  /** Returns the object with the settings used for calls to listPromotions. */
  public PagedCallSettings<
          ListPromotionsRequest, ListPromotionsResponse, ListPromotionsPagedResponse>
      listPromotionsSettings() {
    return listPromotionsSettings;
  }

  public PromotionsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcPromotionsServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonPromotionsServiceStub.create(this);
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
            "gapic", GaxProperties.getLibraryVersion(PromotionsServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(PromotionsServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PromotionsServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected PromotionsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    insertPromotionSettings = settingsBuilder.insertPromotionSettings().build();
    getPromotionSettings = settingsBuilder.getPromotionSettings().build();
    listPromotionsSettings = settingsBuilder.listPromotionsSettings().build();
  }

  /** Builder for PromotionsServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<PromotionsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<InsertPromotionRequest, Promotion>
        insertPromotionSettings;
    private final UnaryCallSettings.Builder<GetPromotionRequest, Promotion> getPromotionSettings;
    private final PagedCallSettings.Builder<
            ListPromotionsRequest, ListPromotionsResponse, ListPromotionsPagedResponse>
        listPromotionsSettings;
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

      insertPromotionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getPromotionSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listPromotionsSettings = PagedCallSettings.newBuilder(LIST_PROMOTIONS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              insertPromotionSettings, getPromotionSettings, listPromotionsSettings);
      initDefaults(this);
    }

    protected Builder(PromotionsServiceStubSettings settings) {
      super(settings);

      insertPromotionSettings = settings.insertPromotionSettings.toBuilder();
      getPromotionSettings = settings.getPromotionSettings.toBuilder();
      listPromotionsSettings = settings.listPromotionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              insertPromotionSettings, getPromotionSettings, listPromotionsSettings);
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
          .insertPromotionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .getPromotionSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listPromotionsSettings()
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

    /** Returns the builder for the settings used for calls to insertPromotion. */
    public UnaryCallSettings.Builder<InsertPromotionRequest, Promotion> insertPromotionSettings() {
      return insertPromotionSettings;
    }

    /** Returns the builder for the settings used for calls to getPromotion. */
    public UnaryCallSettings.Builder<GetPromotionRequest, Promotion> getPromotionSettings() {
      return getPromotionSettings;
    }

    /** Returns the builder for the settings used for calls to listPromotions. */
    public PagedCallSettings.Builder<
            ListPromotionsRequest, ListPromotionsResponse, ListPromotionsPagedResponse>
        listPromotionsSettings() {
      return listPromotionsSettings;
    }

    @Override
    public PromotionsServiceStubSettings build() throws IOException {
      return new PromotionsServiceStubSettings(this);
    }
  }
}
