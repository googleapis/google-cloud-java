/*
 * Copyright 2026 Google LLC
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

package com.google.ads.admanager.v1;

import static com.google.ads.admanager.v1.OrderServiceClient.ListOrdersPagedResponse;

import com.google.ads.admanager.v1.stub.OrderServiceStubSettings;
import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link OrderServiceClient}.
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
 * OrderServiceSettings.Builder orderServiceSettingsBuilder = OrderServiceSettings.newBuilder();
 * orderServiceSettingsBuilder
 *     .getOrderSettings()
 *     .setRetrySettings(
 *         orderServiceSettingsBuilder
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
 * OrderServiceSettings orderServiceSettings = orderServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class OrderServiceSettings extends ClientSettings<OrderServiceSettings> {

  /** Returns the object with the settings used for calls to getOrder. */
  public UnaryCallSettings<GetOrderRequest, Order> getOrderSettings() {
    return ((OrderServiceStubSettings) getStubSettings()).getOrderSettings();
  }

  /** Returns the object with the settings used for calls to listOrders. */
  public PagedCallSettings<ListOrdersRequest, ListOrdersResponse, ListOrdersPagedResponse>
      listOrdersSettings() {
    return ((OrderServiceStubSettings) getStubSettings()).listOrdersSettings();
  }

  /** Returns the object with the settings used for calls to batchCreateOrders. */
  public UnaryCallSettings<BatchCreateOrdersRequest, BatchCreateOrdersResponse>
      batchCreateOrdersSettings() {
    return ((OrderServiceStubSettings) getStubSettings()).batchCreateOrdersSettings();
  }

  /** Returns the object with the settings used for calls to batchUpdateOrders. */
  public UnaryCallSettings<BatchUpdateOrdersRequest, BatchUpdateOrdersResponse>
      batchUpdateOrdersSettings() {
    return ((OrderServiceStubSettings) getStubSettings()).batchUpdateOrdersSettings();
  }

  /** Returns the object with the settings used for calls to batchApproveOrders. */
  public UnaryCallSettings<BatchApproveOrdersRequest, BatchApproveOrdersResponse>
      batchApproveOrdersSettings() {
    return ((OrderServiceStubSettings) getStubSettings()).batchApproveOrdersSettings();
  }

  /** Returns the object with the settings used for calls to batchApproveAndOverbookOrders. */
  public UnaryCallSettings<
          BatchApproveAndOverbookOrdersRequest, BatchApproveAndOverbookOrdersResponse>
      batchApproveAndOverbookOrdersSettings() {
    return ((OrderServiceStubSettings) getStubSettings()).batchApproveAndOverbookOrdersSettings();
  }

  /** Returns the object with the settings used for calls to batchSubmitOrdersForApproval. */
  public UnaryCallSettings<
          BatchSubmitOrdersForApprovalRequest, BatchSubmitOrdersForApprovalResponse>
      batchSubmitOrdersForApprovalSettings() {
    return ((OrderServiceStubSettings) getStubSettings()).batchSubmitOrdersForApprovalSettings();
  }

  /**
   * Returns the object with the settings used for calls to batchSubmitOrdersForApprovalAndOverbook.
   */
  public UnaryCallSettings<
          BatchSubmitOrdersForApprovalAndOverbookRequest,
          BatchSubmitOrdersForApprovalAndOverbookResponse>
      batchSubmitOrdersForApprovalAndOverbookSettings() {
    return ((OrderServiceStubSettings) getStubSettings())
        .batchSubmitOrdersForApprovalAndOverbookSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * batchSubmitOrdersForApprovalWithoutReservationChanges.
   */
  public UnaryCallSettings<
          BatchSubmitOrdersForApprovalWithoutReservationChangesRequest,
          BatchSubmitOrdersForApprovalWithoutReservationChangesResponse>
      batchSubmitOrdersForApprovalWithoutReservationChangesSettings() {
    return ((OrderServiceStubSettings) getStubSettings())
        .batchSubmitOrdersForApprovalWithoutReservationChangesSettings();
  }

  /** Returns the object with the settings used for calls to batchPauseOrders. */
  public UnaryCallSettings<BatchPauseOrdersRequest, BatchPauseOrdersResponse>
      batchPauseOrdersSettings() {
    return ((OrderServiceStubSettings) getStubSettings()).batchPauseOrdersSettings();
  }

  /** Returns the object with the settings used for calls to batchResumeOrders. */
  public UnaryCallSettings<BatchResumeOrdersRequest, BatchResumeOrdersResponse>
      batchResumeOrdersSettings() {
    return ((OrderServiceStubSettings) getStubSettings()).batchResumeOrdersSettings();
  }

  /** Returns the object with the settings used for calls to batchResumeAndOverbookOrders. */
  public UnaryCallSettings<
          BatchResumeAndOverbookOrdersRequest, BatchResumeAndOverbookOrdersResponse>
      batchResumeAndOverbookOrdersSettings() {
    return ((OrderServiceStubSettings) getStubSettings()).batchResumeAndOverbookOrdersSettings();
  }

  /**
   * Returns the object with the settings used for calls to batchApproveOrdersWithoutReservation.
   */
  public UnaryCallSettings<
          BatchApproveOrdersWithoutReservationRequest, BatchApproveOrdersWithoutReservationResponse>
      batchApproveOrdersWithoutReservationSettings() {
    return ((OrderServiceStubSettings) getStubSettings())
        .batchApproveOrdersWithoutReservationSettings();
  }

  /** Returns the object with the settings used for calls to batchArchiveOrders. */
  public UnaryCallSettings<BatchArchiveOrdersRequest, BatchArchiveOrdersResponse>
      batchArchiveOrdersSettings() {
    return ((OrderServiceStubSettings) getStubSettings()).batchArchiveOrdersSettings();
  }

  /** Returns the object with the settings used for calls to batchUnarchiveOrders. */
  public UnaryCallSettings<BatchUnarchiveOrdersRequest, BatchUnarchiveOrdersResponse>
      batchUnarchiveOrdersSettings() {
    return ((OrderServiceStubSettings) getStubSettings()).batchUnarchiveOrdersSettings();
  }

  /** Returns the object with the settings used for calls to batchDeleteOrders. */
  public UnaryCallSettings<BatchDeleteOrdersRequest, BatchDeleteOrdersResponse>
      batchDeleteOrdersSettings() {
    return ((OrderServiceStubSettings) getStubSettings()).batchDeleteOrdersSettings();
  }

  /** Returns the object with the settings used for calls to batchDisapproveOrders. */
  public UnaryCallSettings<BatchDisapproveOrdersRequest, BatchDisapproveOrdersResponse>
      batchDisapproveOrdersSettings() {
    return ((OrderServiceStubSettings) getStubSettings()).batchDisapproveOrdersSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * batchDisapproveOrdersWithoutReservationChanges.
   */
  public UnaryCallSettings<
          BatchDisapproveOrdersWithoutReservationChangesRequest,
          BatchDisapproveOrdersWithoutReservationChangesResponse>
      batchDisapproveOrdersWithoutReservationChangesSettings() {
    return ((OrderServiceStubSettings) getStubSettings())
        .batchDisapproveOrdersWithoutReservationChangesSettings();
  }

  /** Returns the object with the settings used for calls to batchRetractOrders. */
  public UnaryCallSettings<BatchRetractOrdersRequest, BatchRetractOrdersResponse>
      batchRetractOrdersSettings() {
    return ((OrderServiceStubSettings) getStubSettings()).batchRetractOrdersSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * batchRetractOrdersWithoutReservationChanges.
   */
  public UnaryCallSettings<
          BatchRetractOrdersWithoutReservationChangesRequest,
          BatchRetractOrdersWithoutReservationChangesResponse>
      batchRetractOrdersWithoutReservationChangesSettings() {
    return ((OrderServiceStubSettings) getStubSettings())
        .batchRetractOrdersWithoutReservationChangesSettings();
  }

  public static final OrderServiceSettings create(OrderServiceStubSettings stub)
      throws IOException {
    return new OrderServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return OrderServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return OrderServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return OrderServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return OrderServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return OrderServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return OrderServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return OrderServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new builder for this class. */
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected OrderServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for OrderServiceSettings. */
  public static class Builder extends ClientSettings.Builder<OrderServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(OrderServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(OrderServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(OrderServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(OrderServiceStubSettings.newBuilder());
    }

    public OrderServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((OrderServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to getOrder. */
    public UnaryCallSettings.Builder<GetOrderRequest, Order> getOrderSettings() {
      return getStubSettingsBuilder().getOrderSettings();
    }

    /** Returns the builder for the settings used for calls to listOrders. */
    public PagedCallSettings.Builder<ListOrdersRequest, ListOrdersResponse, ListOrdersPagedResponse>
        listOrdersSettings() {
      return getStubSettingsBuilder().listOrdersSettings();
    }

    /** Returns the builder for the settings used for calls to batchCreateOrders. */
    public UnaryCallSettings.Builder<BatchCreateOrdersRequest, BatchCreateOrdersResponse>
        batchCreateOrdersSettings() {
      return getStubSettingsBuilder().batchCreateOrdersSettings();
    }

    /** Returns the builder for the settings used for calls to batchUpdateOrders. */
    public UnaryCallSettings.Builder<BatchUpdateOrdersRequest, BatchUpdateOrdersResponse>
        batchUpdateOrdersSettings() {
      return getStubSettingsBuilder().batchUpdateOrdersSettings();
    }

    /** Returns the builder for the settings used for calls to batchApproveOrders. */
    public UnaryCallSettings.Builder<BatchApproveOrdersRequest, BatchApproveOrdersResponse>
        batchApproveOrdersSettings() {
      return getStubSettingsBuilder().batchApproveOrdersSettings();
    }

    /** Returns the builder for the settings used for calls to batchApproveAndOverbookOrders. */
    public UnaryCallSettings.Builder<
            BatchApproveAndOverbookOrdersRequest, BatchApproveAndOverbookOrdersResponse>
        batchApproveAndOverbookOrdersSettings() {
      return getStubSettingsBuilder().batchApproveAndOverbookOrdersSettings();
    }

    /** Returns the builder for the settings used for calls to batchSubmitOrdersForApproval. */
    public UnaryCallSettings.Builder<
            BatchSubmitOrdersForApprovalRequest, BatchSubmitOrdersForApprovalResponse>
        batchSubmitOrdersForApprovalSettings() {
      return getStubSettingsBuilder().batchSubmitOrdersForApprovalSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * batchSubmitOrdersForApprovalAndOverbook.
     */
    public UnaryCallSettings.Builder<
            BatchSubmitOrdersForApprovalAndOverbookRequest,
            BatchSubmitOrdersForApprovalAndOverbookResponse>
        batchSubmitOrdersForApprovalAndOverbookSettings() {
      return getStubSettingsBuilder().batchSubmitOrdersForApprovalAndOverbookSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * batchSubmitOrdersForApprovalWithoutReservationChanges.
     */
    public UnaryCallSettings.Builder<
            BatchSubmitOrdersForApprovalWithoutReservationChangesRequest,
            BatchSubmitOrdersForApprovalWithoutReservationChangesResponse>
        batchSubmitOrdersForApprovalWithoutReservationChangesSettings() {
      return getStubSettingsBuilder()
          .batchSubmitOrdersForApprovalWithoutReservationChangesSettings();
    }

    /** Returns the builder for the settings used for calls to batchPauseOrders. */
    public UnaryCallSettings.Builder<BatchPauseOrdersRequest, BatchPauseOrdersResponse>
        batchPauseOrdersSettings() {
      return getStubSettingsBuilder().batchPauseOrdersSettings();
    }

    /** Returns the builder for the settings used for calls to batchResumeOrders. */
    public UnaryCallSettings.Builder<BatchResumeOrdersRequest, BatchResumeOrdersResponse>
        batchResumeOrdersSettings() {
      return getStubSettingsBuilder().batchResumeOrdersSettings();
    }

    /** Returns the builder for the settings used for calls to batchResumeAndOverbookOrders. */
    public UnaryCallSettings.Builder<
            BatchResumeAndOverbookOrdersRequest, BatchResumeAndOverbookOrdersResponse>
        batchResumeAndOverbookOrdersSettings() {
      return getStubSettingsBuilder().batchResumeAndOverbookOrdersSettings();
    }

    /**
     * Returns the builder for the settings used for calls to batchApproveOrdersWithoutReservation.
     */
    public UnaryCallSettings.Builder<
            BatchApproveOrdersWithoutReservationRequest,
            BatchApproveOrdersWithoutReservationResponse>
        batchApproveOrdersWithoutReservationSettings() {
      return getStubSettingsBuilder().batchApproveOrdersWithoutReservationSettings();
    }

    /** Returns the builder for the settings used for calls to batchArchiveOrders. */
    public UnaryCallSettings.Builder<BatchArchiveOrdersRequest, BatchArchiveOrdersResponse>
        batchArchiveOrdersSettings() {
      return getStubSettingsBuilder().batchArchiveOrdersSettings();
    }

    /** Returns the builder for the settings used for calls to batchUnarchiveOrders. */
    public UnaryCallSettings.Builder<BatchUnarchiveOrdersRequest, BatchUnarchiveOrdersResponse>
        batchUnarchiveOrdersSettings() {
      return getStubSettingsBuilder().batchUnarchiveOrdersSettings();
    }

    /** Returns the builder for the settings used for calls to batchDeleteOrders. */
    public UnaryCallSettings.Builder<BatchDeleteOrdersRequest, BatchDeleteOrdersResponse>
        batchDeleteOrdersSettings() {
      return getStubSettingsBuilder().batchDeleteOrdersSettings();
    }

    /** Returns the builder for the settings used for calls to batchDisapproveOrders. */
    public UnaryCallSettings.Builder<BatchDisapproveOrdersRequest, BatchDisapproveOrdersResponse>
        batchDisapproveOrdersSettings() {
      return getStubSettingsBuilder().batchDisapproveOrdersSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * batchDisapproveOrdersWithoutReservationChanges.
     */
    public UnaryCallSettings.Builder<
            BatchDisapproveOrdersWithoutReservationChangesRequest,
            BatchDisapproveOrdersWithoutReservationChangesResponse>
        batchDisapproveOrdersWithoutReservationChangesSettings() {
      return getStubSettingsBuilder().batchDisapproveOrdersWithoutReservationChangesSettings();
    }

    /** Returns the builder for the settings used for calls to batchRetractOrders. */
    public UnaryCallSettings.Builder<BatchRetractOrdersRequest, BatchRetractOrdersResponse>
        batchRetractOrdersSettings() {
      return getStubSettingsBuilder().batchRetractOrdersSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * batchRetractOrdersWithoutReservationChanges.
     */
    public UnaryCallSettings.Builder<
            BatchRetractOrdersWithoutReservationChangesRequest,
            BatchRetractOrdersWithoutReservationChangesResponse>
        batchRetractOrdersWithoutReservationChangesSettings() {
      return getStubSettingsBuilder().batchRetractOrdersWithoutReservationChangesSettings();
    }

    @Override
    public OrderServiceSettings build() throws IOException {
      return new OrderServiceSettings(this);
    }
  }
}
