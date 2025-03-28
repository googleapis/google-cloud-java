/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.commerce.consumer.procurement.v1;

import static com.google.cloud.commerce.consumer.procurement.v1.ConsumerProcurementServiceClient.ListOrdersPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.commerce.consumer.procurement.v1.stub.ConsumerProcurementServiceStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link ConsumerProcurementServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudcommerceconsumerprocurement.googleapis.com) and default
 *       port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getOrder:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConsumerProcurementServiceSettings.Builder consumerProcurementServiceSettingsBuilder =
 *     ConsumerProcurementServiceSettings.newBuilder();
 * consumerProcurementServiceSettingsBuilder
 *     .getOrderSettings()
 *     .setRetrySettings(
 *         consumerProcurementServiceSettingsBuilder
 *             .getOrderSettings()
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
 * ConsumerProcurementServiceSettings consumerProcurementServiceSettings =
 *     consumerProcurementServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for placeOrder:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConsumerProcurementServiceSettings.Builder consumerProcurementServiceSettingsBuilder =
 *     ConsumerProcurementServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * consumerProcurementServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class ConsumerProcurementServiceSettings
    extends ClientSettings<ConsumerProcurementServiceSettings> {

  /** Returns the object with the settings used for calls to placeOrder. */
  public UnaryCallSettings<PlaceOrderRequest, Operation> placeOrderSettings() {
    return ((ConsumerProcurementServiceStubSettings) getStubSettings()).placeOrderSettings();
  }

  /** Returns the object with the settings used for calls to placeOrder. */
  public OperationCallSettings<PlaceOrderRequest, Order, PlaceOrderMetadata>
      placeOrderOperationSettings() {
    return ((ConsumerProcurementServiceStubSettings) getStubSettings())
        .placeOrderOperationSettings();
  }

  /** Returns the object with the settings used for calls to getOrder. */
  public UnaryCallSettings<GetOrderRequest, Order> getOrderSettings() {
    return ((ConsumerProcurementServiceStubSettings) getStubSettings()).getOrderSettings();
  }

  /** Returns the object with the settings used for calls to listOrders. */
  public PagedCallSettings<ListOrdersRequest, ListOrdersResponse, ListOrdersPagedResponse>
      listOrdersSettings() {
    return ((ConsumerProcurementServiceStubSettings) getStubSettings()).listOrdersSettings();
  }

  /** Returns the object with the settings used for calls to modifyOrder. */
  public UnaryCallSettings<ModifyOrderRequest, Operation> modifyOrderSettings() {
    return ((ConsumerProcurementServiceStubSettings) getStubSettings()).modifyOrderSettings();
  }

  /** Returns the object with the settings used for calls to modifyOrder. */
  public OperationCallSettings<ModifyOrderRequest, Order, ModifyOrderMetadata>
      modifyOrderOperationSettings() {
    return ((ConsumerProcurementServiceStubSettings) getStubSettings())
        .modifyOrderOperationSettings();
  }

  /** Returns the object with the settings used for calls to cancelOrder. */
  public UnaryCallSettings<CancelOrderRequest, Operation> cancelOrderSettings() {
    return ((ConsumerProcurementServiceStubSettings) getStubSettings()).cancelOrderSettings();
  }

  /** Returns the object with the settings used for calls to cancelOrder. */
  public OperationCallSettings<CancelOrderRequest, Order, CancelOrderMetadata>
      cancelOrderOperationSettings() {
    return ((ConsumerProcurementServiceStubSettings) getStubSettings())
        .cancelOrderOperationSettings();
  }

  public static final ConsumerProcurementServiceSettings create(
      ConsumerProcurementServiceStubSettings stub) throws IOException {
    return new ConsumerProcurementServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return ConsumerProcurementServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return ConsumerProcurementServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return ConsumerProcurementServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return ConsumerProcurementServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return ConsumerProcurementServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return ConsumerProcurementServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return ConsumerProcurementServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return ConsumerProcurementServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected ConsumerProcurementServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for ConsumerProcurementServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<ConsumerProcurementServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(ConsumerProcurementServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(ConsumerProcurementServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(ConsumerProcurementServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(ConsumerProcurementServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(ConsumerProcurementServiceStubSettings.newHttpJsonBuilder());
    }

    public ConsumerProcurementServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((ConsumerProcurementServiceStubSettings.Builder) getStubSettings());
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(
          getStubSettingsBuilder().unaryMethodSettingsBuilders(), settingsUpdater);
      return this;
    }

    /** Returns the builder for the settings used for calls to placeOrder. */
    public UnaryCallSettings.Builder<PlaceOrderRequest, Operation> placeOrderSettings() {
      return getStubSettingsBuilder().placeOrderSettings();
    }

    /** Returns the builder for the settings used for calls to placeOrder. */
    public OperationCallSettings.Builder<PlaceOrderRequest, Order, PlaceOrderMetadata>
        placeOrderOperationSettings() {
      return getStubSettingsBuilder().placeOrderOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getOrder. */
    public UnaryCallSettings.Builder<GetOrderRequest, Order> getOrderSettings() {
      return getStubSettingsBuilder().getOrderSettings();
    }

    /** Returns the builder for the settings used for calls to listOrders. */
    public PagedCallSettings.Builder<ListOrdersRequest, ListOrdersResponse, ListOrdersPagedResponse>
        listOrdersSettings() {
      return getStubSettingsBuilder().listOrdersSettings();
    }

    /** Returns the builder for the settings used for calls to modifyOrder. */
    public UnaryCallSettings.Builder<ModifyOrderRequest, Operation> modifyOrderSettings() {
      return getStubSettingsBuilder().modifyOrderSettings();
    }

    /** Returns the builder for the settings used for calls to modifyOrder. */
    public OperationCallSettings.Builder<ModifyOrderRequest, Order, ModifyOrderMetadata>
        modifyOrderOperationSettings() {
      return getStubSettingsBuilder().modifyOrderOperationSettings();
    }

    /** Returns the builder for the settings used for calls to cancelOrder. */
    public UnaryCallSettings.Builder<CancelOrderRequest, Operation> cancelOrderSettings() {
      return getStubSettingsBuilder().cancelOrderSettings();
    }

    /** Returns the builder for the settings used for calls to cancelOrder. */
    public OperationCallSettings.Builder<CancelOrderRequest, Order, CancelOrderMetadata>
        cancelOrderOperationSettings() {
      return getStubSettingsBuilder().cancelOrderOperationSettings();
    }

    @Override
    public ConsumerProcurementServiceSettings build() throws IOException {
      return new ConsumerProcurementServiceSettings(this);
    }
  }
}
