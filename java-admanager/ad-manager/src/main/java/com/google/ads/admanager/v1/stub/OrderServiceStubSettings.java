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

package com.google.ads.admanager.v1.stub;

import static com.google.ads.admanager.v1.OrderServiceClient.ListOrdersPagedResponse;

import com.google.ads.admanager.v1.GetOrderRequest;
import com.google.ads.admanager.v1.ListOrdersRequest;
import com.google.ads.admanager.v1.ListOrdersResponse;
import com.google.ads.admanager.v1.Order;
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
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link OrderServiceStub}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (admanager.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getOrder to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OrderServiceStubSettings.Builder orderServiceSettingsBuilder =
 *     OrderServiceStubSettings.newBuilder();
 * orderServiceSettingsBuilder
 *     .getOrderSettings()
 *     .setRetrySettings(
 *         orderServiceSettingsBuilder
 *             .getOrderSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * OrderServiceStubSettings orderServiceSettings = orderServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class OrderServiceStubSettings extends StubSettings<OrderServiceStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().build();

  private final UnaryCallSettings<GetOrderRequest, Order> getOrderSettings;
  private final PagedCallSettings<ListOrdersRequest, ListOrdersResponse, ListOrdersPagedResponse>
      listOrdersSettings;

  private static final PagedListDescriptor<ListOrdersRequest, ListOrdersResponse, Order>
      LIST_ORDERS_PAGE_STR_DESC =
          new PagedListDescriptor<ListOrdersRequest, ListOrdersResponse, Order>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListOrdersRequest injectToken(ListOrdersRequest payload, String token) {
              return ListOrdersRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListOrdersRequest injectPageSize(ListOrdersRequest payload, int pageSize) {
              return ListOrdersRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListOrdersRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListOrdersResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Order> extractResources(ListOrdersResponse payload) {
              return payload.getOrdersList() == null
                  ? ImmutableList.<Order>of()
                  : payload.getOrdersList();
            }
          };

  private static final PagedListResponseFactory<
          ListOrdersRequest, ListOrdersResponse, ListOrdersPagedResponse>
      LIST_ORDERS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListOrdersRequest, ListOrdersResponse, ListOrdersPagedResponse>() {
            @Override
            public ApiFuture<ListOrdersPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListOrdersRequest, ListOrdersResponse> callable,
                ListOrdersRequest request,
                ApiCallContext context,
                ApiFuture<ListOrdersResponse> futureResponse) {
              PageContext<ListOrdersRequest, ListOrdersResponse, Order> pageContext =
                  PageContext.create(callable, LIST_ORDERS_PAGE_STR_DESC, request, context);
              return ListOrdersPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to getOrder. */
  public UnaryCallSettings<GetOrderRequest, Order> getOrderSettings() {
    return getOrderSettings;
  }

  /** Returns the object with the settings used for calls to listOrders. */
  public PagedCallSettings<ListOrdersRequest, ListOrdersResponse, ListOrdersPagedResponse>
      listOrdersSettings() {
    return listOrdersSettings;
  }

  public OrderServiceStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonOrderServiceStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "admanager";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "admanager.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "admanager.mtls.googleapis.com:443";
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
            "gapic", GaxProperties.getLibraryVersion(OrderServiceStubSettings.class))
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

  protected OrderServiceStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    getOrderSettings = settingsBuilder.getOrderSettings().build();
    listOrdersSettings = settingsBuilder.listOrdersSettings().build();
  }

  /** Builder for OrderServiceStubSettings. */
  public static class Builder extends StubSettings.Builder<OrderServiceStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final UnaryCallSettings.Builder<GetOrderRequest, Order> getOrderSettings;
    private final PagedCallSettings.Builder<
            ListOrdersRequest, ListOrdersResponse, ListOrdersPagedResponse>
        listOrdersSettings;
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

      getOrderSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      listOrdersSettings = PagedCallSettings.newBuilder(LIST_ORDERS_PAGE_STR_FACT);

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(getOrderSettings, listOrdersSettings);
      initDefaults(this);
    }

    protected Builder(OrderServiceStubSettings settings) {
      super(settings);

      getOrderSettings = settings.getOrderSettings.toBuilder();
      listOrdersSettings = settings.listOrdersSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(getOrderSettings, listOrdersSettings);
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

    private static Builder initDefaults(Builder builder) {
      builder
          .getOrderSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("retry_policy_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("retry_policy_0_params"));

      builder
          .listOrdersSettings()
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

    /** Returns the builder for the settings used for calls to getOrder. */
    public UnaryCallSettings.Builder<GetOrderRequest, Order> getOrderSettings() {
      return getOrderSettings;
    }

    /** Returns the builder for the settings used for calls to listOrders. */
    public PagedCallSettings.Builder<ListOrdersRequest, ListOrdersResponse, ListOrdersPagedResponse>
        listOrdersSettings() {
      return listOrdersSettings;
    }

    @Override
    public OrderServiceStubSettings build() throws IOException {
      return new OrderServiceStubSettings(this);
    }
  }
}
