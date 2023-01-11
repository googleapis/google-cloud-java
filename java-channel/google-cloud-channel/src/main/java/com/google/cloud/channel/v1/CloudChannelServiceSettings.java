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

package com.google.cloud.channel.v1;

import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListChannelPartnerLinksPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListChannelPartnerRepricingConfigsPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListCustomerRepricingConfigsPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListCustomersPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListEntitlementsPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListOffersPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListProductsPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListPurchasableOffersPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListPurchasableSkusPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListSkusPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListSubscribersPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListTransferableOffersPagedResponse;
import static com.google.cloud.channel.v1.CloudChannelServiceClient.ListTransferableSkusPagedResponse;

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
import com.google.cloud.channel.v1.stub.CloudChannelServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CloudChannelServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudchannel.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getCustomer to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudChannelServiceSettings.Builder cloudChannelServiceSettingsBuilder =
 *     CloudChannelServiceSettings.newBuilder();
 * cloudChannelServiceSettingsBuilder
 *     .getCustomerSettings()
 *     .setRetrySettings(
 *         cloudChannelServiceSettingsBuilder
 *             .getCustomerSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * CloudChannelServiceSettings cloudChannelServiceSettings =
 *     cloudChannelServiceSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CloudChannelServiceSettings extends ClientSettings<CloudChannelServiceSettings> {

  /** Returns the object with the settings used for calls to listCustomers. */
  public PagedCallSettings<ListCustomersRequest, ListCustomersResponse, ListCustomersPagedResponse>
      listCustomersSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).listCustomersSettings();
  }

  /** Returns the object with the settings used for calls to getCustomer. */
  public UnaryCallSettings<GetCustomerRequest, Customer> getCustomerSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).getCustomerSettings();
  }

  /** Returns the object with the settings used for calls to checkCloudIdentityAccountsExist. */
  public UnaryCallSettings<
          CheckCloudIdentityAccountsExistRequest, CheckCloudIdentityAccountsExistResponse>
      checkCloudIdentityAccountsExistSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings())
        .checkCloudIdentityAccountsExistSettings();
  }

  /** Returns the object with the settings used for calls to createCustomer. */
  public UnaryCallSettings<CreateCustomerRequest, Customer> createCustomerSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).createCustomerSettings();
  }

  /** Returns the object with the settings used for calls to updateCustomer. */
  public UnaryCallSettings<UpdateCustomerRequest, Customer> updateCustomerSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).updateCustomerSettings();
  }

  /** Returns the object with the settings used for calls to deleteCustomer. */
  public UnaryCallSettings<DeleteCustomerRequest, Empty> deleteCustomerSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).deleteCustomerSettings();
  }

  /** Returns the object with the settings used for calls to importCustomer. */
  public UnaryCallSettings<ImportCustomerRequest, Customer> importCustomerSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).importCustomerSettings();
  }

  /** Returns the object with the settings used for calls to provisionCloudIdentity. */
  public UnaryCallSettings<ProvisionCloudIdentityRequest, Operation>
      provisionCloudIdentitySettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).provisionCloudIdentitySettings();
  }

  /** Returns the object with the settings used for calls to provisionCloudIdentity. */
  public OperationCallSettings<ProvisionCloudIdentityRequest, Customer, OperationMetadata>
      provisionCloudIdentityOperationSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings())
        .provisionCloudIdentityOperationSettings();
  }

  /** Returns the object with the settings used for calls to listEntitlements. */
  public PagedCallSettings<
          ListEntitlementsRequest, ListEntitlementsResponse, ListEntitlementsPagedResponse>
      listEntitlementsSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).listEntitlementsSettings();
  }

  /** Returns the object with the settings used for calls to listTransferableSkus. */
  public PagedCallSettings<
          ListTransferableSkusRequest,
          ListTransferableSkusResponse,
          ListTransferableSkusPagedResponse>
      listTransferableSkusSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).listTransferableSkusSettings();
  }

  /** Returns the object with the settings used for calls to listTransferableOffers. */
  public PagedCallSettings<
          ListTransferableOffersRequest,
          ListTransferableOffersResponse,
          ListTransferableOffersPagedResponse>
      listTransferableOffersSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).listTransferableOffersSettings();
  }

  /** Returns the object with the settings used for calls to getEntitlement. */
  public UnaryCallSettings<GetEntitlementRequest, Entitlement> getEntitlementSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).getEntitlementSettings();
  }

  /** Returns the object with the settings used for calls to createEntitlement. */
  public UnaryCallSettings<CreateEntitlementRequest, Operation> createEntitlementSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).createEntitlementSettings();
  }

  /** Returns the object with the settings used for calls to createEntitlement. */
  public OperationCallSettings<CreateEntitlementRequest, Entitlement, OperationMetadata>
      createEntitlementOperationSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings())
        .createEntitlementOperationSettings();
  }

  /** Returns the object with the settings used for calls to changeParameters. */
  public UnaryCallSettings<ChangeParametersRequest, Operation> changeParametersSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).changeParametersSettings();
  }

  /** Returns the object with the settings used for calls to changeParameters. */
  public OperationCallSettings<ChangeParametersRequest, Entitlement, OperationMetadata>
      changeParametersOperationSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings())
        .changeParametersOperationSettings();
  }

  /** Returns the object with the settings used for calls to changeRenewalSettings. */
  public UnaryCallSettings<ChangeRenewalSettingsRequest, Operation>
      changeRenewalSettingsSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).changeRenewalSettingsSettings();
  }

  /** Returns the object with the settings used for calls to changeRenewalSettings. */
  public OperationCallSettings<ChangeRenewalSettingsRequest, Entitlement, OperationMetadata>
      changeRenewalSettingsOperationSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings())
        .changeRenewalSettingsOperationSettings();
  }

  /** Returns the object with the settings used for calls to changeOffer. */
  public UnaryCallSettings<ChangeOfferRequest, Operation> changeOfferSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).changeOfferSettings();
  }

  /** Returns the object with the settings used for calls to changeOffer. */
  public OperationCallSettings<ChangeOfferRequest, Entitlement, OperationMetadata>
      changeOfferOperationSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).changeOfferOperationSettings();
  }

  /** Returns the object with the settings used for calls to startPaidService. */
  public UnaryCallSettings<StartPaidServiceRequest, Operation> startPaidServiceSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).startPaidServiceSettings();
  }

  /** Returns the object with the settings used for calls to startPaidService. */
  public OperationCallSettings<StartPaidServiceRequest, Entitlement, OperationMetadata>
      startPaidServiceOperationSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings())
        .startPaidServiceOperationSettings();
  }

  /** Returns the object with the settings used for calls to suspendEntitlement. */
  public UnaryCallSettings<SuspendEntitlementRequest, Operation> suspendEntitlementSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).suspendEntitlementSettings();
  }

  /** Returns the object with the settings used for calls to suspendEntitlement. */
  public OperationCallSettings<SuspendEntitlementRequest, Entitlement, OperationMetadata>
      suspendEntitlementOperationSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings())
        .suspendEntitlementOperationSettings();
  }

  /** Returns the object with the settings used for calls to cancelEntitlement. */
  public UnaryCallSettings<CancelEntitlementRequest, Operation> cancelEntitlementSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).cancelEntitlementSettings();
  }

  /** Returns the object with the settings used for calls to cancelEntitlement. */
  public OperationCallSettings<CancelEntitlementRequest, Empty, OperationMetadata>
      cancelEntitlementOperationSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings())
        .cancelEntitlementOperationSettings();
  }

  /** Returns the object with the settings used for calls to activateEntitlement. */
  public UnaryCallSettings<ActivateEntitlementRequest, Operation> activateEntitlementSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).activateEntitlementSettings();
  }

  /** Returns the object with the settings used for calls to activateEntitlement. */
  public OperationCallSettings<ActivateEntitlementRequest, Entitlement, OperationMetadata>
      activateEntitlementOperationSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings())
        .activateEntitlementOperationSettings();
  }

  /** Returns the object with the settings used for calls to transferEntitlements. */
  public UnaryCallSettings<TransferEntitlementsRequest, Operation> transferEntitlementsSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).transferEntitlementsSettings();
  }

  /** Returns the object with the settings used for calls to transferEntitlements. */
  public OperationCallSettings<
          TransferEntitlementsRequest, TransferEntitlementsResponse, OperationMetadata>
      transferEntitlementsOperationSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings())
        .transferEntitlementsOperationSettings();
  }

  /** Returns the object with the settings used for calls to transferEntitlementsToGoogle. */
  public UnaryCallSettings<TransferEntitlementsToGoogleRequest, Operation>
      transferEntitlementsToGoogleSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings())
        .transferEntitlementsToGoogleSettings();
  }

  /** Returns the object with the settings used for calls to transferEntitlementsToGoogle. */
  public OperationCallSettings<TransferEntitlementsToGoogleRequest, Empty, OperationMetadata>
      transferEntitlementsToGoogleOperationSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings())
        .transferEntitlementsToGoogleOperationSettings();
  }

  /** Returns the object with the settings used for calls to listChannelPartnerLinks. */
  public PagedCallSettings<
          ListChannelPartnerLinksRequest,
          ListChannelPartnerLinksResponse,
          ListChannelPartnerLinksPagedResponse>
      listChannelPartnerLinksSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).listChannelPartnerLinksSettings();
  }

  /** Returns the object with the settings used for calls to getChannelPartnerLink. */
  public UnaryCallSettings<GetChannelPartnerLinkRequest, ChannelPartnerLink>
      getChannelPartnerLinkSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).getChannelPartnerLinkSettings();
  }

  /** Returns the object with the settings used for calls to createChannelPartnerLink. */
  public UnaryCallSettings<CreateChannelPartnerLinkRequest, ChannelPartnerLink>
      createChannelPartnerLinkSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).createChannelPartnerLinkSettings();
  }

  /** Returns the object with the settings used for calls to updateChannelPartnerLink. */
  public UnaryCallSettings<UpdateChannelPartnerLinkRequest, ChannelPartnerLink>
      updateChannelPartnerLinkSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).updateChannelPartnerLinkSettings();
  }

  /** Returns the object with the settings used for calls to getCustomerRepricingConfig. */
  public UnaryCallSettings<GetCustomerRepricingConfigRequest, CustomerRepricingConfig>
      getCustomerRepricingConfigSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings())
        .getCustomerRepricingConfigSettings();
  }

  /** Returns the object with the settings used for calls to listCustomerRepricingConfigs. */
  public PagedCallSettings<
          ListCustomerRepricingConfigsRequest,
          ListCustomerRepricingConfigsResponse,
          ListCustomerRepricingConfigsPagedResponse>
      listCustomerRepricingConfigsSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings())
        .listCustomerRepricingConfigsSettings();
  }

  /** Returns the object with the settings used for calls to createCustomerRepricingConfig. */
  public UnaryCallSettings<CreateCustomerRepricingConfigRequest, CustomerRepricingConfig>
      createCustomerRepricingConfigSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings())
        .createCustomerRepricingConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateCustomerRepricingConfig. */
  public UnaryCallSettings<UpdateCustomerRepricingConfigRequest, CustomerRepricingConfig>
      updateCustomerRepricingConfigSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings())
        .updateCustomerRepricingConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteCustomerRepricingConfig. */
  public UnaryCallSettings<DeleteCustomerRepricingConfigRequest, Empty>
      deleteCustomerRepricingConfigSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings())
        .deleteCustomerRepricingConfigSettings();
  }

  /** Returns the object with the settings used for calls to getChannelPartnerRepricingConfig. */
  public UnaryCallSettings<GetChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
      getChannelPartnerRepricingConfigSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings())
        .getChannelPartnerRepricingConfigSettings();
  }

  /** Returns the object with the settings used for calls to listChannelPartnerRepricingConfigs. */
  public PagedCallSettings<
          ListChannelPartnerRepricingConfigsRequest,
          ListChannelPartnerRepricingConfigsResponse,
          ListChannelPartnerRepricingConfigsPagedResponse>
      listChannelPartnerRepricingConfigsSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings())
        .listChannelPartnerRepricingConfigsSettings();
  }

  /** Returns the object with the settings used for calls to createChannelPartnerRepricingConfig. */
  public UnaryCallSettings<
          CreateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
      createChannelPartnerRepricingConfigSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings())
        .createChannelPartnerRepricingConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateChannelPartnerRepricingConfig. */
  public UnaryCallSettings<
          UpdateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
      updateChannelPartnerRepricingConfigSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings())
        .updateChannelPartnerRepricingConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteChannelPartnerRepricingConfig. */
  public UnaryCallSettings<DeleteChannelPartnerRepricingConfigRequest, Empty>
      deleteChannelPartnerRepricingConfigSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings())
        .deleteChannelPartnerRepricingConfigSettings();
  }

  /** Returns the object with the settings used for calls to lookupOffer. */
  public UnaryCallSettings<LookupOfferRequest, Offer> lookupOfferSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).lookupOfferSettings();
  }

  /** Returns the object with the settings used for calls to listProducts. */
  public PagedCallSettings<ListProductsRequest, ListProductsResponse, ListProductsPagedResponse>
      listProductsSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).listProductsSettings();
  }

  /** Returns the object with the settings used for calls to listSkus. */
  public PagedCallSettings<ListSkusRequest, ListSkusResponse, ListSkusPagedResponse>
      listSkusSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).listSkusSettings();
  }

  /** Returns the object with the settings used for calls to listOffers. */
  public PagedCallSettings<ListOffersRequest, ListOffersResponse, ListOffersPagedResponse>
      listOffersSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).listOffersSettings();
  }

  /** Returns the object with the settings used for calls to listPurchasableSkus. */
  public PagedCallSettings<
          ListPurchasableSkusRequest, ListPurchasableSkusResponse, ListPurchasableSkusPagedResponse>
      listPurchasableSkusSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).listPurchasableSkusSettings();
  }

  /** Returns the object with the settings used for calls to listPurchasableOffers. */
  public PagedCallSettings<
          ListPurchasableOffersRequest,
          ListPurchasableOffersResponse,
          ListPurchasableOffersPagedResponse>
      listPurchasableOffersSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).listPurchasableOffersSettings();
  }

  /** Returns the object with the settings used for calls to registerSubscriber. */
  public UnaryCallSettings<RegisterSubscriberRequest, RegisterSubscriberResponse>
      registerSubscriberSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).registerSubscriberSettings();
  }

  /** Returns the object with the settings used for calls to unregisterSubscriber. */
  public UnaryCallSettings<UnregisterSubscriberRequest, UnregisterSubscriberResponse>
      unregisterSubscriberSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).unregisterSubscriberSettings();
  }

  /** Returns the object with the settings used for calls to listSubscribers. */
  public PagedCallSettings<
          ListSubscribersRequest, ListSubscribersResponse, ListSubscribersPagedResponse>
      listSubscribersSettings() {
    return ((CloudChannelServiceStubSettings) getStubSettings()).listSubscribersSettings();
  }

  public static final CloudChannelServiceSettings create(CloudChannelServiceStubSettings stub)
      throws IOException {
    return new CloudChannelServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CloudChannelServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CloudChannelServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CloudChannelServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CloudChannelServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return CloudChannelServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CloudChannelServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CloudChannelServiceStubSettings.defaultTransportChannelProvider();
  }

  @BetaApi("The surface for customizing headers is not stable yet and may change in the future.")
  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CloudChannelServiceStubSettings.defaultApiClientHeaderProviderBuilder();
  }

  /** Returns a new gRPC builder for this class. */
  public static Builder newBuilder() {
    return Builder.createDefault();
  }

  /** Returns a new REST builder for this class. */
  @BetaApi
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

  protected CloudChannelServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CloudChannelServiceSettings. */
  public static class Builder extends ClientSettings.Builder<CloudChannelServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(CloudChannelServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(CloudChannelServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CloudChannelServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CloudChannelServiceStubSettings.newBuilder());
    }

    @BetaApi
    private static Builder createHttpJsonDefault() {
      return new Builder(CloudChannelServiceStubSettings.newHttpJsonBuilder());
    }

    public CloudChannelServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((CloudChannelServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listCustomers. */
    public PagedCallSettings.Builder<
            ListCustomersRequest, ListCustomersResponse, ListCustomersPagedResponse>
        listCustomersSettings() {
      return getStubSettingsBuilder().listCustomersSettings();
    }

    /** Returns the builder for the settings used for calls to getCustomer. */
    public UnaryCallSettings.Builder<GetCustomerRequest, Customer> getCustomerSettings() {
      return getStubSettingsBuilder().getCustomerSettings();
    }

    /** Returns the builder for the settings used for calls to checkCloudIdentityAccountsExist. */
    public UnaryCallSettings.Builder<
            CheckCloudIdentityAccountsExistRequest, CheckCloudIdentityAccountsExistResponse>
        checkCloudIdentityAccountsExistSettings() {
      return getStubSettingsBuilder().checkCloudIdentityAccountsExistSettings();
    }

    /** Returns the builder for the settings used for calls to createCustomer. */
    public UnaryCallSettings.Builder<CreateCustomerRequest, Customer> createCustomerSettings() {
      return getStubSettingsBuilder().createCustomerSettings();
    }

    /** Returns the builder for the settings used for calls to updateCustomer. */
    public UnaryCallSettings.Builder<UpdateCustomerRequest, Customer> updateCustomerSettings() {
      return getStubSettingsBuilder().updateCustomerSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCustomer. */
    public UnaryCallSettings.Builder<DeleteCustomerRequest, Empty> deleteCustomerSettings() {
      return getStubSettingsBuilder().deleteCustomerSettings();
    }

    /** Returns the builder for the settings used for calls to importCustomer. */
    public UnaryCallSettings.Builder<ImportCustomerRequest, Customer> importCustomerSettings() {
      return getStubSettingsBuilder().importCustomerSettings();
    }

    /** Returns the builder for the settings used for calls to provisionCloudIdentity. */
    public UnaryCallSettings.Builder<ProvisionCloudIdentityRequest, Operation>
        provisionCloudIdentitySettings() {
      return getStubSettingsBuilder().provisionCloudIdentitySettings();
    }

    /** Returns the builder for the settings used for calls to provisionCloudIdentity. */
    public OperationCallSettings.Builder<ProvisionCloudIdentityRequest, Customer, OperationMetadata>
        provisionCloudIdentityOperationSettings() {
      return getStubSettingsBuilder().provisionCloudIdentityOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listEntitlements. */
    public PagedCallSettings.Builder<
            ListEntitlementsRequest, ListEntitlementsResponse, ListEntitlementsPagedResponse>
        listEntitlementsSettings() {
      return getStubSettingsBuilder().listEntitlementsSettings();
    }

    /** Returns the builder for the settings used for calls to listTransferableSkus. */
    public PagedCallSettings.Builder<
            ListTransferableSkusRequest,
            ListTransferableSkusResponse,
            ListTransferableSkusPagedResponse>
        listTransferableSkusSettings() {
      return getStubSettingsBuilder().listTransferableSkusSettings();
    }

    /** Returns the builder for the settings used for calls to listTransferableOffers. */
    public PagedCallSettings.Builder<
            ListTransferableOffersRequest,
            ListTransferableOffersResponse,
            ListTransferableOffersPagedResponse>
        listTransferableOffersSettings() {
      return getStubSettingsBuilder().listTransferableOffersSettings();
    }

    /** Returns the builder for the settings used for calls to getEntitlement. */
    public UnaryCallSettings.Builder<GetEntitlementRequest, Entitlement> getEntitlementSettings() {
      return getStubSettingsBuilder().getEntitlementSettings();
    }

    /** Returns the builder for the settings used for calls to createEntitlement. */
    public UnaryCallSettings.Builder<CreateEntitlementRequest, Operation>
        createEntitlementSettings() {
      return getStubSettingsBuilder().createEntitlementSettings();
    }

    /** Returns the builder for the settings used for calls to createEntitlement. */
    public OperationCallSettings.Builder<CreateEntitlementRequest, Entitlement, OperationMetadata>
        createEntitlementOperationSettings() {
      return getStubSettingsBuilder().createEntitlementOperationSettings();
    }

    /** Returns the builder for the settings used for calls to changeParameters. */
    public UnaryCallSettings.Builder<ChangeParametersRequest, Operation>
        changeParametersSettings() {
      return getStubSettingsBuilder().changeParametersSettings();
    }

    /** Returns the builder for the settings used for calls to changeParameters. */
    public OperationCallSettings.Builder<ChangeParametersRequest, Entitlement, OperationMetadata>
        changeParametersOperationSettings() {
      return getStubSettingsBuilder().changeParametersOperationSettings();
    }

    /** Returns the builder for the settings used for calls to changeRenewalSettings. */
    public UnaryCallSettings.Builder<ChangeRenewalSettingsRequest, Operation>
        changeRenewalSettingsSettings() {
      return getStubSettingsBuilder().changeRenewalSettingsSettings();
    }

    /** Returns the builder for the settings used for calls to changeRenewalSettings. */
    public OperationCallSettings.Builder<
            ChangeRenewalSettingsRequest, Entitlement, OperationMetadata>
        changeRenewalSettingsOperationSettings() {
      return getStubSettingsBuilder().changeRenewalSettingsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to changeOffer. */
    public UnaryCallSettings.Builder<ChangeOfferRequest, Operation> changeOfferSettings() {
      return getStubSettingsBuilder().changeOfferSettings();
    }

    /** Returns the builder for the settings used for calls to changeOffer. */
    public OperationCallSettings.Builder<ChangeOfferRequest, Entitlement, OperationMetadata>
        changeOfferOperationSettings() {
      return getStubSettingsBuilder().changeOfferOperationSettings();
    }

    /** Returns the builder for the settings used for calls to startPaidService. */
    public UnaryCallSettings.Builder<StartPaidServiceRequest, Operation>
        startPaidServiceSettings() {
      return getStubSettingsBuilder().startPaidServiceSettings();
    }

    /** Returns the builder for the settings used for calls to startPaidService. */
    public OperationCallSettings.Builder<StartPaidServiceRequest, Entitlement, OperationMetadata>
        startPaidServiceOperationSettings() {
      return getStubSettingsBuilder().startPaidServiceOperationSettings();
    }

    /** Returns the builder for the settings used for calls to suspendEntitlement. */
    public UnaryCallSettings.Builder<SuspendEntitlementRequest, Operation>
        suspendEntitlementSettings() {
      return getStubSettingsBuilder().suspendEntitlementSettings();
    }

    /** Returns the builder for the settings used for calls to suspendEntitlement. */
    public OperationCallSettings.Builder<SuspendEntitlementRequest, Entitlement, OperationMetadata>
        suspendEntitlementOperationSettings() {
      return getStubSettingsBuilder().suspendEntitlementOperationSettings();
    }

    /** Returns the builder for the settings used for calls to cancelEntitlement. */
    public UnaryCallSettings.Builder<CancelEntitlementRequest, Operation>
        cancelEntitlementSettings() {
      return getStubSettingsBuilder().cancelEntitlementSettings();
    }

    /** Returns the builder for the settings used for calls to cancelEntitlement. */
    public OperationCallSettings.Builder<CancelEntitlementRequest, Empty, OperationMetadata>
        cancelEntitlementOperationSettings() {
      return getStubSettingsBuilder().cancelEntitlementOperationSettings();
    }

    /** Returns the builder for the settings used for calls to activateEntitlement. */
    public UnaryCallSettings.Builder<ActivateEntitlementRequest, Operation>
        activateEntitlementSettings() {
      return getStubSettingsBuilder().activateEntitlementSettings();
    }

    /** Returns the builder for the settings used for calls to activateEntitlement. */
    public OperationCallSettings.Builder<ActivateEntitlementRequest, Entitlement, OperationMetadata>
        activateEntitlementOperationSettings() {
      return getStubSettingsBuilder().activateEntitlementOperationSettings();
    }

    /** Returns the builder for the settings used for calls to transferEntitlements. */
    public UnaryCallSettings.Builder<TransferEntitlementsRequest, Operation>
        transferEntitlementsSettings() {
      return getStubSettingsBuilder().transferEntitlementsSettings();
    }

    /** Returns the builder for the settings used for calls to transferEntitlements. */
    public OperationCallSettings.Builder<
            TransferEntitlementsRequest, TransferEntitlementsResponse, OperationMetadata>
        transferEntitlementsOperationSettings() {
      return getStubSettingsBuilder().transferEntitlementsOperationSettings();
    }

    /** Returns the builder for the settings used for calls to transferEntitlementsToGoogle. */
    public UnaryCallSettings.Builder<TransferEntitlementsToGoogleRequest, Operation>
        transferEntitlementsToGoogleSettings() {
      return getStubSettingsBuilder().transferEntitlementsToGoogleSettings();
    }

    /** Returns the builder for the settings used for calls to transferEntitlementsToGoogle. */
    public OperationCallSettings.Builder<
            TransferEntitlementsToGoogleRequest, Empty, OperationMetadata>
        transferEntitlementsToGoogleOperationSettings() {
      return getStubSettingsBuilder().transferEntitlementsToGoogleOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listChannelPartnerLinks. */
    public PagedCallSettings.Builder<
            ListChannelPartnerLinksRequest,
            ListChannelPartnerLinksResponse,
            ListChannelPartnerLinksPagedResponse>
        listChannelPartnerLinksSettings() {
      return getStubSettingsBuilder().listChannelPartnerLinksSettings();
    }

    /** Returns the builder for the settings used for calls to getChannelPartnerLink. */
    public UnaryCallSettings.Builder<GetChannelPartnerLinkRequest, ChannelPartnerLink>
        getChannelPartnerLinkSettings() {
      return getStubSettingsBuilder().getChannelPartnerLinkSettings();
    }

    /** Returns the builder for the settings used for calls to createChannelPartnerLink. */
    public UnaryCallSettings.Builder<CreateChannelPartnerLinkRequest, ChannelPartnerLink>
        createChannelPartnerLinkSettings() {
      return getStubSettingsBuilder().createChannelPartnerLinkSettings();
    }

    /** Returns the builder for the settings used for calls to updateChannelPartnerLink. */
    public UnaryCallSettings.Builder<UpdateChannelPartnerLinkRequest, ChannelPartnerLink>
        updateChannelPartnerLinkSettings() {
      return getStubSettingsBuilder().updateChannelPartnerLinkSettings();
    }

    /** Returns the builder for the settings used for calls to getCustomerRepricingConfig. */
    public UnaryCallSettings.Builder<GetCustomerRepricingConfigRequest, CustomerRepricingConfig>
        getCustomerRepricingConfigSettings() {
      return getStubSettingsBuilder().getCustomerRepricingConfigSettings();
    }

    /** Returns the builder for the settings used for calls to listCustomerRepricingConfigs. */
    public PagedCallSettings.Builder<
            ListCustomerRepricingConfigsRequest,
            ListCustomerRepricingConfigsResponse,
            ListCustomerRepricingConfigsPagedResponse>
        listCustomerRepricingConfigsSettings() {
      return getStubSettingsBuilder().listCustomerRepricingConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to createCustomerRepricingConfig. */
    public UnaryCallSettings.Builder<CreateCustomerRepricingConfigRequest, CustomerRepricingConfig>
        createCustomerRepricingConfigSettings() {
      return getStubSettingsBuilder().createCustomerRepricingConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateCustomerRepricingConfig. */
    public UnaryCallSettings.Builder<UpdateCustomerRepricingConfigRequest, CustomerRepricingConfig>
        updateCustomerRepricingConfigSettings() {
      return getStubSettingsBuilder().updateCustomerRepricingConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteCustomerRepricingConfig. */
    public UnaryCallSettings.Builder<DeleteCustomerRepricingConfigRequest, Empty>
        deleteCustomerRepricingConfigSettings() {
      return getStubSettingsBuilder().deleteCustomerRepricingConfigSettings();
    }

    /** Returns the builder for the settings used for calls to getChannelPartnerRepricingConfig. */
    public UnaryCallSettings.Builder<
            GetChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
        getChannelPartnerRepricingConfigSettings() {
      return getStubSettingsBuilder().getChannelPartnerRepricingConfigSettings();
    }

    /**
     * Returns the builder for the settings used for calls to listChannelPartnerRepricingConfigs.
     */
    public PagedCallSettings.Builder<
            ListChannelPartnerRepricingConfigsRequest,
            ListChannelPartnerRepricingConfigsResponse,
            ListChannelPartnerRepricingConfigsPagedResponse>
        listChannelPartnerRepricingConfigsSettings() {
      return getStubSettingsBuilder().listChannelPartnerRepricingConfigsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to createChannelPartnerRepricingConfig.
     */
    public UnaryCallSettings.Builder<
            CreateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
        createChannelPartnerRepricingConfigSettings() {
      return getStubSettingsBuilder().createChannelPartnerRepricingConfigSettings();
    }

    /**
     * Returns the builder for the settings used for calls to updateChannelPartnerRepricingConfig.
     */
    public UnaryCallSettings.Builder<
            UpdateChannelPartnerRepricingConfigRequest, ChannelPartnerRepricingConfig>
        updateChannelPartnerRepricingConfigSettings() {
      return getStubSettingsBuilder().updateChannelPartnerRepricingConfigSettings();
    }

    /**
     * Returns the builder for the settings used for calls to deleteChannelPartnerRepricingConfig.
     */
    public UnaryCallSettings.Builder<DeleteChannelPartnerRepricingConfigRequest, Empty>
        deleteChannelPartnerRepricingConfigSettings() {
      return getStubSettingsBuilder().deleteChannelPartnerRepricingConfigSettings();
    }

    /** Returns the builder for the settings used for calls to lookupOffer. */
    public UnaryCallSettings.Builder<LookupOfferRequest, Offer> lookupOfferSettings() {
      return getStubSettingsBuilder().lookupOfferSettings();
    }

    /** Returns the builder for the settings used for calls to listProducts. */
    public PagedCallSettings.Builder<
            ListProductsRequest, ListProductsResponse, ListProductsPagedResponse>
        listProductsSettings() {
      return getStubSettingsBuilder().listProductsSettings();
    }

    /** Returns the builder for the settings used for calls to listSkus. */
    public PagedCallSettings.Builder<ListSkusRequest, ListSkusResponse, ListSkusPagedResponse>
        listSkusSettings() {
      return getStubSettingsBuilder().listSkusSettings();
    }

    /** Returns the builder for the settings used for calls to listOffers. */
    public PagedCallSettings.Builder<ListOffersRequest, ListOffersResponse, ListOffersPagedResponse>
        listOffersSettings() {
      return getStubSettingsBuilder().listOffersSettings();
    }

    /** Returns the builder for the settings used for calls to listPurchasableSkus. */
    public PagedCallSettings.Builder<
            ListPurchasableSkusRequest,
            ListPurchasableSkusResponse,
            ListPurchasableSkusPagedResponse>
        listPurchasableSkusSettings() {
      return getStubSettingsBuilder().listPurchasableSkusSettings();
    }

    /** Returns the builder for the settings used for calls to listPurchasableOffers. */
    public PagedCallSettings.Builder<
            ListPurchasableOffersRequest,
            ListPurchasableOffersResponse,
            ListPurchasableOffersPagedResponse>
        listPurchasableOffersSettings() {
      return getStubSettingsBuilder().listPurchasableOffersSettings();
    }

    /** Returns the builder for the settings used for calls to registerSubscriber. */
    public UnaryCallSettings.Builder<RegisterSubscriberRequest, RegisterSubscriberResponse>
        registerSubscriberSettings() {
      return getStubSettingsBuilder().registerSubscriberSettings();
    }

    /** Returns the builder for the settings used for calls to unregisterSubscriber. */
    public UnaryCallSettings.Builder<UnregisterSubscriberRequest, UnregisterSubscriberResponse>
        unregisterSubscriberSettings() {
      return getStubSettingsBuilder().unregisterSubscriberSettings();
    }

    /** Returns the builder for the settings used for calls to listSubscribers. */
    public PagedCallSettings.Builder<
            ListSubscribersRequest, ListSubscribersResponse, ListSubscribersPagedResponse>
        listSubscribersSettings() {
      return getStubSettingsBuilder().listSubscribersSettings();
    }

    @Override
    public CloudChannelServiceSettings build() throws IOException {
      return new CloudChannelServiceSettings(this);
    }
  }
}
