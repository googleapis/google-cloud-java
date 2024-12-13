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

package com.google.shopping.merchant.reviews.v1beta.stub;

import static com.google.shopping.merchant.reviews.v1beta.MerchantReviewsServiceClient.ListMerchantReviewsPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.core.ObsoleteApi;
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
import com.google.shopping.merchant.reviews.v1beta.DeleteMerchantReviewRequest;
import com.google.shopping.merchant.reviews.v1beta.GetMerchantReviewRequest;
import com.google.shopping.merchant.reviews.v1beta.InsertMerchantReviewRequest;
import com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsRequest;
import com.google.shopping.merchant.reviews.v1beta.ListMerchantReviewsResponse;
import com.google.shopping.merchant.reviews.v1beta.MerchantReview;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link MerchantReviewsServiceStub}.
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
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getMerchantReview:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * MerchantReviewsServiceStubSettings.Builder merchantReviewsServiceSettingsBuilder =
 *     MerchantReviewsServiceStubSettings.newBuilder();
 * merchantReviewsServiceSettingsBuilder
 *     .getMerchantReviewSettings()
 *     .setRetrySettings(
 *         merchantReviewsServiceSettingsBuilder
 *             .getMerchantReviewSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofSeconds(1))
 *             .setInitialRpcTimeoutDuration(Duration.ofSeconds(5))
 *             .setMaxAttempts(5)
 *             .setMaxRetryDelayDuration(Duration.ofSeconds(30))
 *             .setMaxRpcTimeoutDuration(Duration.ofSeconds(60))
 *             .setRetryDelayMultiplier(1.3)
 *             .setRpcTimeoutMultiplier(1.5)
 *             .setTotalTimeoutDuration(Duration.ofSeconds(300))
 *             .build());
 * MerchantReviewsServiceStubSettings merchantReviewsServiceSettings =
 *     merchantReviewsServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MerchantReviewsServiceStubSettings
    extends StubSettings<MerchantReviewsServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/content").build();

  private final UnaryCallSettings<GetMerchantReviewRequest, MerchantReview>
      getMerchantReviewSettings;
  private final PagedCallSettings<
          ListMerchantReviewsRequest, ListMerchantReviewsResponse, ListMerchantReviewsPagedResponse>
      listMerchantReviewsSettings;
  private final UnaryCallSettings<InsertMerchantReviewRequest, MerchantReview>
      insertMerchantReviewSettings;
  private final UnaryCallSettings<DeleteMerchantReviewRequest, Empty> deleteMerchantReviewSettings;

  private static final PagedListDescriptor<
          ListMerchantReviewsRequest, ListMerchantReviewsResponse, MerchantReview>
      LIST_MERCHANT_REVIEWS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListMerchantReviewsRequest, ListMerchantReviewsResponse, MerchantReview>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMerchantReviewsRequest injectToken(
                ListMerchantReviewsRequest payload, String token) {
              return ListMerchantReviewsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMerchantReviewsRequest injectPageSize(
                ListMerchantReviewsRequest payload, int pageSize) {
              return ListMerchantReviewsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMerchantReviewsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMerchantReviewsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<MerchantReview> extractResources(ListMerchantReviewsResponse payload) {
              return payload.getMerchantReviewsList();
            }
          };

  private static final PagedListResponseFactory<
          ListMerchantReviewsRequest, ListMerchantReviewsResponse, ListMerchantReviewsPagedResponse>
      LIST_MERCHANT_REVIEWS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMerchantReviewsRequest,
              ListMerchantReviewsResponse,
              ListMerchantReviewsPagedResponse>() {
            @Override
            public ApiFuture<ListMerchantReviewsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMerchantReviewsRequest, ListMerchantReviewsResponse> callable,
                ListMerchantReviewsRequest request,
                ApiCallContext context,
                ApiFuture<ListMerchantReviewsResponse> futureResponse) {
              PageContext<ListMerchantReviewsRequest, ListMerchantReviewsResponse, MerchantReview>
                  pageContext =
                      PageContext.create(
                          callable, LIST_MERCHANT_REVIEWS_PAGE_STR_DESC, request, context);
              return ListMerchantReviewsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getMerchantReview. */
  public UnaryCallSettings<GetMerchantReviewRequest, MerchantReview> getMerchantReviewSettings() {
    return getMerchantReviewSettings;
  }

  /** Returns the object with the settings used for calls to listMerchantReviews. */
  public PagedCallSettings<
          ListMerchantReviewsRequest, ListMerchantReviewsResponse, ListMerchantReviewsPagedResponse>
      listMerchantReviewsSettings() {
    return listMerchantReviewsSettings;
  }

  /** Returns the object with the settings used for calls to insertMerchantReview. */
  public UnaryCallSettings<InsertMerchantReviewRequest, MerchantReview>
      insertMerchantReviewSettings() {
    return insertMerchantReviewSettings;
  }

  /** Returns the object with the settings used for calls to deleteMerchantReview. */
  public UnaryCallSettings<DeleteMerchantReviewRequest, Empty> deleteMerchantReviewSettings() {
    return deleteMerchantReviewSettings;
  }

  public MerchantReviewsServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcMerchantReviewsServiceStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonMerchantReviewsServiceStub.create(this);
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
  @ObsoleteApi("Use getEndpoint() instead")
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
            "gapic", GaxProperties.getLibraryVersion(MerchantReviewsServiceStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(MerchantReviewsServiceStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return MerchantReviewsServiceStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected MerchantReviewsServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getMerchantReviewSettings = settingsBuilder.getMerchantReviewSettings().build();
    listMerchantReviewsSettings = settingsBuilder.listMerchantReviewsSettings().build();
    insertMerchantReviewSettings = settingsBuilder.insertMerchantReviewSettings().build();
    deleteMerchantReviewSettings = settingsBuilder.deleteMerchantReviewSettings().build();
  }

  /** Builder for MerchantReviewsServiceStubSettings. */
  public static class Builder
      extends StubSettings.Builder<MerchantReviewsServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetMerchantReviewRequest, MerchantReview>
        getMerchantReviewSettings;
    private final PagedCallSettings.Builder<
            ListMerchantReviewsRequest,
            ListMerchantReviewsResponse,
            ListMerchantReviewsPagedResponse>
        listMerchantReviewsSettings;
    private final UnaryCallSettings.Builder<InsertMerchantReviewRequest, MerchantReview>
        insertMerchantReviewSettings;
    private final UnaryCallSettings.Builder<DeleteMerchantReviewRequest, Empty>
        deleteMerchantReviewSettings;
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
              .setInitialRetryDelayDuration(Duration.ofMillis(1000L))
              .setRetryDelayMultiplier(1.3)
              .setMaxRetryDelayDuration(Duration.ofMillis(10000L))
              .setInitialRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeoutDuration(Duration.ofMillis(60000L))
              .setTotalTimeoutDuration(Duration.ofMillis(60000L))
              .build();
      definitions.put("retry_policy_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      getMerchantReviewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listMerchantReviewsSettings =
          PagedCallSettings.newBuilder(LIST_MERCHANT_REVIEWS_PAGE_STR_FACT);
      insertMerchantReviewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMerchantReviewSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getMerchantReviewSettings,
              listMerchantReviewsSettings,
              insertMerchantReviewSettings,
              deleteMerchantReviewSettings);
      initDefaults(this);
    }

    protected Builder(MerchantReviewsServiceStubSettings settings) {
      super(settings);

      getMerchantReviewSettings = settings.getMerchantReviewSettings.toBuilder();
      listMerchantReviewsSettings = settings.listMerchantReviewsSettings.toBuilder();
      insertMerchantReviewSettings = settings.insertMerchantReviewSettings.toBuilder();
      deleteMerchantReviewSettings = settings.deleteMerchantReviewSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              getMerchantReviewSettings,
              listMerchantReviewsSettings,
              insertMerchantReviewSettings,
              deleteMerchantReviewSettings);
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
          .getMerchantReviewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listMerchantReviewsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .insertMerchantReviewSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .deleteMerchantReviewSettings()
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

    /** Returns the builder for the settings used for calls to getMerchantReview. */
    public UnaryCallSettings.Builder<GetMerchantReviewRequest, MerchantReview>
        getMerchantReviewSettings() {
      return getMerchantReviewSettings;
    }

    /** Returns the builder for the settings used for calls to listMerchantReviews. */
    public PagedCallSettings.Builder<
            ListMerchantReviewsRequest,
            ListMerchantReviewsResponse,
            ListMerchantReviewsPagedResponse>
        listMerchantReviewsSettings() {
      return listMerchantReviewsSettings;
    }

    /** Returns the builder for the settings used for calls to insertMerchantReview. */
    public UnaryCallSettings.Builder<InsertMerchantReviewRequest, MerchantReview>
        insertMerchantReviewSettings() {
      return insertMerchantReviewSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMerchantReview. */
    public UnaryCallSettings.Builder<DeleteMerchantReviewRequest, Empty>
        deleteMerchantReviewSettings() {
      return deleteMerchantReviewSettings;
    }

    @Override
    public MerchantReviewsServiceStubSettings build() throws IOException {
      return new MerchantReviewsServiceStubSettings(this);
    }
  }
}
