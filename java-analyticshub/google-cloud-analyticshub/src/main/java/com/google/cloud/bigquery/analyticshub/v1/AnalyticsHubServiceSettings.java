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

package com.google.cloud.bigquery.analyticshub.v1;

import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListDataExchangesPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListListingsPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListOrgDataExchangesPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListQueryTemplatesPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListSharedResourceSubscriptionsPagedResponse;
import static com.google.cloud.bigquery.analyticshub.v1.AnalyticsHubServiceClient.ListSubscriptionsPagedResponse;

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
import com.google.cloud.bigquery.analyticshub.v1.stub.AnalyticsHubServiceStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link AnalyticsHubServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (analyticshub.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getDataExchange:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AnalyticsHubServiceSettings.Builder analyticsHubServiceSettingsBuilder =
 *     AnalyticsHubServiceSettings.newBuilder();
 * analyticsHubServiceSettingsBuilder
 *     .getDataExchangeSettings()
 *     .setRetrySettings(
 *         analyticsHubServiceSettingsBuilder
 *             .getDataExchangeSettings()
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
 * AnalyticsHubServiceSettings analyticsHubServiceSettings =
 *     analyticsHubServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for subscribeDataExchange:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AnalyticsHubServiceSettings.Builder analyticsHubServiceSettingsBuilder =
 *     AnalyticsHubServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * analyticsHubServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class AnalyticsHubServiceSettings extends ClientSettings<AnalyticsHubServiceSettings> {

  /** Returns the object with the settings used for calls to listDataExchanges. */
  public PagedCallSettings<
          ListDataExchangesRequest, ListDataExchangesResponse, ListDataExchangesPagedResponse>
      listDataExchangesSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).listDataExchangesSettings();
  }

  /** Returns the object with the settings used for calls to listOrgDataExchanges. */
  public PagedCallSettings<
          ListOrgDataExchangesRequest,
          ListOrgDataExchangesResponse,
          ListOrgDataExchangesPagedResponse>
      listOrgDataExchangesSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).listOrgDataExchangesSettings();
  }

  /** Returns the object with the settings used for calls to getDataExchange. */
  public UnaryCallSettings<GetDataExchangeRequest, DataExchange> getDataExchangeSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).getDataExchangeSettings();
  }

  /** Returns the object with the settings used for calls to createDataExchange. */
  public UnaryCallSettings<CreateDataExchangeRequest, DataExchange> createDataExchangeSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).createDataExchangeSettings();
  }

  /** Returns the object with the settings used for calls to updateDataExchange. */
  public UnaryCallSettings<UpdateDataExchangeRequest, DataExchange> updateDataExchangeSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).updateDataExchangeSettings();
  }

  /** Returns the object with the settings used for calls to deleteDataExchange. */
  public UnaryCallSettings<DeleteDataExchangeRequest, Empty> deleteDataExchangeSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).deleteDataExchangeSettings();
  }

  /** Returns the object with the settings used for calls to listListings. */
  public PagedCallSettings<ListListingsRequest, ListListingsResponse, ListListingsPagedResponse>
      listListingsSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).listListingsSettings();
  }

  /** Returns the object with the settings used for calls to getListing. */
  public UnaryCallSettings<GetListingRequest, Listing> getListingSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).getListingSettings();
  }

  /** Returns the object with the settings used for calls to createListing. */
  public UnaryCallSettings<CreateListingRequest, Listing> createListingSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).createListingSettings();
  }

  /** Returns the object with the settings used for calls to updateListing. */
  public UnaryCallSettings<UpdateListingRequest, Listing> updateListingSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).updateListingSettings();
  }

  /** Returns the object with the settings used for calls to deleteListing. */
  public UnaryCallSettings<DeleteListingRequest, Empty> deleteListingSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).deleteListingSettings();
  }

  /** Returns the object with the settings used for calls to subscribeListing. */
  public UnaryCallSettings<SubscribeListingRequest, SubscribeListingResponse>
      subscribeListingSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).subscribeListingSettings();
  }

  /** Returns the object with the settings used for calls to subscribeDataExchange. */
  public UnaryCallSettings<SubscribeDataExchangeRequest, Operation>
      subscribeDataExchangeSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).subscribeDataExchangeSettings();
  }

  /** Returns the object with the settings used for calls to subscribeDataExchange. */
  public OperationCallSettings<
          SubscribeDataExchangeRequest, SubscribeDataExchangeResponse, OperationMetadata>
      subscribeDataExchangeOperationSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings())
        .subscribeDataExchangeOperationSettings();
  }

  /** Returns the object with the settings used for calls to refreshSubscription. */
  public UnaryCallSettings<RefreshSubscriptionRequest, Operation> refreshSubscriptionSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).refreshSubscriptionSettings();
  }

  /** Returns the object with the settings used for calls to refreshSubscription. */
  public OperationCallSettings<
          RefreshSubscriptionRequest, RefreshSubscriptionResponse, OperationMetadata>
      refreshSubscriptionOperationSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings())
        .refreshSubscriptionOperationSettings();
  }

  /** Returns the object with the settings used for calls to getSubscription. */
  public UnaryCallSettings<GetSubscriptionRequest, Subscription> getSubscriptionSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).getSubscriptionSettings();
  }

  /** Returns the object with the settings used for calls to listSubscriptions. */
  public PagedCallSettings<
          ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
      listSubscriptionsSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).listSubscriptionsSettings();
  }

  /** Returns the object with the settings used for calls to listSharedResourceSubscriptions. */
  public PagedCallSettings<
          ListSharedResourceSubscriptionsRequest,
          ListSharedResourceSubscriptionsResponse,
          ListSharedResourceSubscriptionsPagedResponse>
      listSharedResourceSubscriptionsSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings())
        .listSharedResourceSubscriptionsSettings();
  }

  /** Returns the object with the settings used for calls to revokeSubscription. */
  public UnaryCallSettings<RevokeSubscriptionRequest, RevokeSubscriptionResponse>
      revokeSubscriptionSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).revokeSubscriptionSettings();
  }

  /** Returns the object with the settings used for calls to deleteSubscription. */
  public UnaryCallSettings<DeleteSubscriptionRequest, Operation> deleteSubscriptionSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).deleteSubscriptionSettings();
  }

  /** Returns the object with the settings used for calls to deleteSubscription. */
  public OperationCallSettings<DeleteSubscriptionRequest, Empty, OperationMetadata>
      deleteSubscriptionOperationSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings())
        .deleteSubscriptionOperationSettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  /** Returns the object with the settings used for calls to createQueryTemplate. */
  public UnaryCallSettings<CreateQueryTemplateRequest, QueryTemplate>
      createQueryTemplateSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).createQueryTemplateSettings();
  }

  /** Returns the object with the settings used for calls to getQueryTemplate. */
  public UnaryCallSettings<GetQueryTemplateRequest, QueryTemplate> getQueryTemplateSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).getQueryTemplateSettings();
  }

  /** Returns the object with the settings used for calls to listQueryTemplates. */
  public PagedCallSettings<
          ListQueryTemplatesRequest, ListQueryTemplatesResponse, ListQueryTemplatesPagedResponse>
      listQueryTemplatesSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).listQueryTemplatesSettings();
  }

  /** Returns the object with the settings used for calls to updateQueryTemplate. */
  public UnaryCallSettings<UpdateQueryTemplateRequest, QueryTemplate>
      updateQueryTemplateSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).updateQueryTemplateSettings();
  }

  /** Returns the object with the settings used for calls to deleteQueryTemplate. */
  public UnaryCallSettings<DeleteQueryTemplateRequest, Empty> deleteQueryTemplateSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).deleteQueryTemplateSettings();
  }

  /** Returns the object with the settings used for calls to submitQueryTemplate. */
  public UnaryCallSettings<SubmitQueryTemplateRequest, QueryTemplate>
      submitQueryTemplateSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).submitQueryTemplateSettings();
  }

  /** Returns the object with the settings used for calls to approveQueryTemplate. */
  public UnaryCallSettings<ApproveQueryTemplateRequest, QueryTemplate>
      approveQueryTemplateSettings() {
    return ((AnalyticsHubServiceStubSettings) getStubSettings()).approveQueryTemplateSettings();
  }

  public static final AnalyticsHubServiceSettings create(AnalyticsHubServiceStubSettings stub)
      throws IOException {
    return new AnalyticsHubServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return AnalyticsHubServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return AnalyticsHubServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return AnalyticsHubServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return AnalyticsHubServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return AnalyticsHubServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return AnalyticsHubServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return AnalyticsHubServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return AnalyticsHubServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected AnalyticsHubServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for AnalyticsHubServiceSettings. */
  public static class Builder extends ClientSettings.Builder<AnalyticsHubServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(AnalyticsHubServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(AnalyticsHubServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(AnalyticsHubServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(AnalyticsHubServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(AnalyticsHubServiceStubSettings.newHttpJsonBuilder());
    }

    public AnalyticsHubServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((AnalyticsHubServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listDataExchanges. */
    public PagedCallSettings.Builder<
            ListDataExchangesRequest, ListDataExchangesResponse, ListDataExchangesPagedResponse>
        listDataExchangesSettings() {
      return getStubSettingsBuilder().listDataExchangesSettings();
    }

    /** Returns the builder for the settings used for calls to listOrgDataExchanges. */
    public PagedCallSettings.Builder<
            ListOrgDataExchangesRequest,
            ListOrgDataExchangesResponse,
            ListOrgDataExchangesPagedResponse>
        listOrgDataExchangesSettings() {
      return getStubSettingsBuilder().listOrgDataExchangesSettings();
    }

    /** Returns the builder for the settings used for calls to getDataExchange. */
    public UnaryCallSettings.Builder<GetDataExchangeRequest, DataExchange>
        getDataExchangeSettings() {
      return getStubSettingsBuilder().getDataExchangeSettings();
    }

    /** Returns the builder for the settings used for calls to createDataExchange. */
    public UnaryCallSettings.Builder<CreateDataExchangeRequest, DataExchange>
        createDataExchangeSettings() {
      return getStubSettingsBuilder().createDataExchangeSettings();
    }

    /** Returns the builder for the settings used for calls to updateDataExchange. */
    public UnaryCallSettings.Builder<UpdateDataExchangeRequest, DataExchange>
        updateDataExchangeSettings() {
      return getStubSettingsBuilder().updateDataExchangeSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDataExchange. */
    public UnaryCallSettings.Builder<DeleteDataExchangeRequest, Empty>
        deleteDataExchangeSettings() {
      return getStubSettingsBuilder().deleteDataExchangeSettings();
    }

    /** Returns the builder for the settings used for calls to listListings. */
    public PagedCallSettings.Builder<
            ListListingsRequest, ListListingsResponse, ListListingsPagedResponse>
        listListingsSettings() {
      return getStubSettingsBuilder().listListingsSettings();
    }

    /** Returns the builder for the settings used for calls to getListing. */
    public UnaryCallSettings.Builder<GetListingRequest, Listing> getListingSettings() {
      return getStubSettingsBuilder().getListingSettings();
    }

    /** Returns the builder for the settings used for calls to createListing. */
    public UnaryCallSettings.Builder<CreateListingRequest, Listing> createListingSettings() {
      return getStubSettingsBuilder().createListingSettings();
    }

    /** Returns the builder for the settings used for calls to updateListing. */
    public UnaryCallSettings.Builder<UpdateListingRequest, Listing> updateListingSettings() {
      return getStubSettingsBuilder().updateListingSettings();
    }

    /** Returns the builder for the settings used for calls to deleteListing. */
    public UnaryCallSettings.Builder<DeleteListingRequest, Empty> deleteListingSettings() {
      return getStubSettingsBuilder().deleteListingSettings();
    }

    /** Returns the builder for the settings used for calls to subscribeListing. */
    public UnaryCallSettings.Builder<SubscribeListingRequest, SubscribeListingResponse>
        subscribeListingSettings() {
      return getStubSettingsBuilder().subscribeListingSettings();
    }

    /** Returns the builder for the settings used for calls to subscribeDataExchange. */
    public UnaryCallSettings.Builder<SubscribeDataExchangeRequest, Operation>
        subscribeDataExchangeSettings() {
      return getStubSettingsBuilder().subscribeDataExchangeSettings();
    }

    /** Returns the builder for the settings used for calls to subscribeDataExchange. */
    public OperationCallSettings.Builder<
            SubscribeDataExchangeRequest, SubscribeDataExchangeResponse, OperationMetadata>
        subscribeDataExchangeOperationSettings() {
      return getStubSettingsBuilder().subscribeDataExchangeOperationSettings();
    }

    /** Returns the builder for the settings used for calls to refreshSubscription. */
    public UnaryCallSettings.Builder<RefreshSubscriptionRequest, Operation>
        refreshSubscriptionSettings() {
      return getStubSettingsBuilder().refreshSubscriptionSettings();
    }

    /** Returns the builder for the settings used for calls to refreshSubscription. */
    public OperationCallSettings.Builder<
            RefreshSubscriptionRequest, RefreshSubscriptionResponse, OperationMetadata>
        refreshSubscriptionOperationSettings() {
      return getStubSettingsBuilder().refreshSubscriptionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getSubscription. */
    public UnaryCallSettings.Builder<GetSubscriptionRequest, Subscription>
        getSubscriptionSettings() {
      return getStubSettingsBuilder().getSubscriptionSettings();
    }

    /** Returns the builder for the settings used for calls to listSubscriptions. */
    public PagedCallSettings.Builder<
            ListSubscriptionsRequest, ListSubscriptionsResponse, ListSubscriptionsPagedResponse>
        listSubscriptionsSettings() {
      return getStubSettingsBuilder().listSubscriptionsSettings();
    }

    /** Returns the builder for the settings used for calls to listSharedResourceSubscriptions. */
    public PagedCallSettings.Builder<
            ListSharedResourceSubscriptionsRequest,
            ListSharedResourceSubscriptionsResponse,
            ListSharedResourceSubscriptionsPagedResponse>
        listSharedResourceSubscriptionsSettings() {
      return getStubSettingsBuilder().listSharedResourceSubscriptionsSettings();
    }

    /** Returns the builder for the settings used for calls to revokeSubscription. */
    public UnaryCallSettings.Builder<RevokeSubscriptionRequest, RevokeSubscriptionResponse>
        revokeSubscriptionSettings() {
      return getStubSettingsBuilder().revokeSubscriptionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSubscription. */
    public UnaryCallSettings.Builder<DeleteSubscriptionRequest, Operation>
        deleteSubscriptionSettings() {
      return getStubSettingsBuilder().deleteSubscriptionSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSubscription. */
    public OperationCallSettings.Builder<DeleteSubscriptionRequest, Empty, OperationMetadata>
        deleteSubscriptionOperationSettings() {
      return getStubSettingsBuilder().deleteSubscriptionOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    /** Returns the builder for the settings used for calls to createQueryTemplate. */
    public UnaryCallSettings.Builder<CreateQueryTemplateRequest, QueryTemplate>
        createQueryTemplateSettings() {
      return getStubSettingsBuilder().createQueryTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to getQueryTemplate. */
    public UnaryCallSettings.Builder<GetQueryTemplateRequest, QueryTemplate>
        getQueryTemplateSettings() {
      return getStubSettingsBuilder().getQueryTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to listQueryTemplates. */
    public PagedCallSettings.Builder<
            ListQueryTemplatesRequest, ListQueryTemplatesResponse, ListQueryTemplatesPagedResponse>
        listQueryTemplatesSettings() {
      return getStubSettingsBuilder().listQueryTemplatesSettings();
    }

    /** Returns the builder for the settings used for calls to updateQueryTemplate. */
    public UnaryCallSettings.Builder<UpdateQueryTemplateRequest, QueryTemplate>
        updateQueryTemplateSettings() {
      return getStubSettingsBuilder().updateQueryTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to deleteQueryTemplate. */
    public UnaryCallSettings.Builder<DeleteQueryTemplateRequest, Empty>
        deleteQueryTemplateSettings() {
      return getStubSettingsBuilder().deleteQueryTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to submitQueryTemplate. */
    public UnaryCallSettings.Builder<SubmitQueryTemplateRequest, QueryTemplate>
        submitQueryTemplateSettings() {
      return getStubSettingsBuilder().submitQueryTemplateSettings();
    }

    /** Returns the builder for the settings used for calls to approveQueryTemplate. */
    public UnaryCallSettings.Builder<ApproveQueryTemplateRequest, QueryTemplate>
        approveQueryTemplateSettings() {
      return getStubSettingsBuilder().approveQueryTemplateSettings();
    }

    @Override
    public AnalyticsHubServiceSettings build() throws IOException {
      return new AnalyticsHubServiceSettings(this);
    }
  }
}
