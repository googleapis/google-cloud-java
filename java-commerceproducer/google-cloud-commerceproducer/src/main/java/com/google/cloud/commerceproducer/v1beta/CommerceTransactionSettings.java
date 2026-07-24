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

package com.google.cloud.commerceproducer.v1beta;

import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListLocationsPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListPrivateOfferDocumentsPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListPrivateOffersPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListServicesPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListSkuGroupsPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListSkusPagedResponse;
import static com.google.cloud.commerceproducer.v1beta.CommerceTransactionClient.ListStandardOffersPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.ClientSettings;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.cloud.commerceproducer.v1beta.stub.CommerceTransactionStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link CommerceTransactionClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (commerceproducer.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getService:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CommerceTransactionSettings.Builder commerceTransactionSettingsBuilder =
 *     CommerceTransactionSettings.newBuilder();
 * commerceTransactionSettingsBuilder
 *     .getServiceSettings()
 *     .setRetrySettings(
 *         commerceTransactionSettingsBuilder
 *             .getServiceSettings()
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
 * CommerceTransactionSettings commerceTransactionSettings =
 *     commerceTransactionSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class CommerceTransactionSettings extends ClientSettings<CommerceTransactionSettings> {

  /** Returns the object with the settings used for calls to listServices. */
  public PagedCallSettings<ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
      listServicesSettings() {
    return ((CommerceTransactionStubSettings) getStubSettings()).listServicesSettings();
  }

  /** Returns the object with the settings used for calls to getService. */
  public UnaryCallSettings<GetServiceRequest, Service> getServiceSettings() {
    return ((CommerceTransactionStubSettings) getStubSettings()).getServiceSettings();
  }

  /** Returns the object with the settings used for calls to listPrivateOffers. */
  public PagedCallSettings<
          ListPrivateOffersRequest, ListPrivateOffersResponse, ListPrivateOffersPagedResponse>
      listPrivateOffersSettings() {
    return ((CommerceTransactionStubSettings) getStubSettings()).listPrivateOffersSettings();
  }

  /** Returns the object with the settings used for calls to getPrivateOffer. */
  public UnaryCallSettings<GetPrivateOfferRequest, PrivateOffer> getPrivateOfferSettings() {
    return ((CommerceTransactionStubSettings) getStubSettings()).getPrivateOfferSettings();
  }

  /** Returns the object with the settings used for calls to resolveAmendmentTarget. */
  public UnaryCallSettings<ResolveAmendmentTargetRequest, ResolveAmendmentTargetResponse>
      resolveAmendmentTargetSettings() {
    return ((CommerceTransactionStubSettings) getStubSettings()).resolveAmendmentTargetSettings();
  }

  /** Returns the object with the settings used for calls to createPrivateOffer. */
  public UnaryCallSettings<CreatePrivateOfferRequest, PrivateOffer> createPrivateOfferSettings() {
    return ((CommerceTransactionStubSettings) getStubSettings()).createPrivateOfferSettings();
  }

  /** Returns the object with the settings used for calls to updatePrivateOffer. */
  public UnaryCallSettings<UpdatePrivateOfferRequest, PrivateOffer> updatePrivateOfferSettings() {
    return ((CommerceTransactionStubSettings) getStubSettings()).updatePrivateOfferSettings();
  }

  /** Returns the object with the settings used for calls to publishPrivateOffer. */
  public UnaryCallSettings<PublishPrivateOfferRequest, PrivateOffer> publishPrivateOfferSettings() {
    return ((CommerceTransactionStubSettings) getStubSettings()).publishPrivateOfferSettings();
  }

  /** Returns the object with the settings used for calls to cancelPrivateOffer. */
  public UnaryCallSettings<CancelPrivateOfferRequest, PrivateOffer> cancelPrivateOfferSettings() {
    return ((CommerceTransactionStubSettings) getStubSettings()).cancelPrivateOfferSettings();
  }

  /** Returns the object with the settings used for calls to deletePrivateOffer. */
  public UnaryCallSettings<DeletePrivateOfferRequest, Empty> deletePrivateOfferSettings() {
    return ((CommerceTransactionStubSettings) getStubSettings()).deletePrivateOfferSettings();
  }

  /** Returns the object with the settings used for calls to listPrivateOfferDocuments. */
  public PagedCallSettings<
          ListPrivateOfferDocumentsRequest,
          ListPrivateOfferDocumentsResponse,
          ListPrivateOfferDocumentsPagedResponse>
      listPrivateOfferDocumentsSettings() {
    return ((CommerceTransactionStubSettings) getStubSettings())
        .listPrivateOfferDocumentsSettings();
  }

  /** Returns the object with the settings used for calls to getPrivateOfferDocument. */
  public UnaryCallSettings<GetPrivateOfferDocumentRequest, PrivateOfferDocument>
      getPrivateOfferDocumentSettings() {
    return ((CommerceTransactionStubSettings) getStubSettings()).getPrivateOfferDocumentSettings();
  }

  /** Returns the object with the settings used for calls to createPrivateOfferDocument. */
  public UnaryCallSettings<CreatePrivateOfferDocumentRequest, PrivateOfferDocument>
      createPrivateOfferDocumentSettings() {
    return ((CommerceTransactionStubSettings) getStubSettings())
        .createPrivateOfferDocumentSettings();
  }

  /** Returns the object with the settings used for calls to updatePrivateOfferDocument. */
  public UnaryCallSettings<UpdatePrivateOfferDocumentRequest, PrivateOfferDocument>
      updatePrivateOfferDocumentSettings() {
    return ((CommerceTransactionStubSettings) getStubSettings())
        .updatePrivateOfferDocumentSettings();
  }

  /** Returns the object with the settings used for calls to deletePrivateOfferDocument. */
  public UnaryCallSettings<DeletePrivateOfferDocumentRequest, Empty>
      deletePrivateOfferDocumentSettings() {
    return ((CommerceTransactionStubSettings) getStubSettings())
        .deletePrivateOfferDocumentSettings();
  }

  /** Returns the object with the settings used for calls to listStandardOffers. */
  public PagedCallSettings<
          ListStandardOffersRequest, ListStandardOffersResponse, ListStandardOffersPagedResponse>
      listStandardOffersSettings() {
    return ((CommerceTransactionStubSettings) getStubSettings()).listStandardOffersSettings();
  }

  /** Returns the object with the settings used for calls to getStandardOffer. */
  public UnaryCallSettings<GetStandardOfferRequest, StandardOffer> getStandardOfferSettings() {
    return ((CommerceTransactionStubSettings) getStubSettings()).getStandardOfferSettings();
  }

  /** Returns the object with the settings used for calls to getSku. */
  public UnaryCallSettings<GetSkuRequest, Sku> getSkuSettings() {
    return ((CommerceTransactionStubSettings) getStubSettings()).getSkuSettings();
  }

  /** Returns the object with the settings used for calls to listSkus. */
  public PagedCallSettings<ListSkusRequest, ListSkusResponse, ListSkusPagedResponse>
      listSkusSettings() {
    return ((CommerceTransactionStubSettings) getStubSettings()).listSkusSettings();
  }

  /** Returns the object with the settings used for calls to getSkuGroup. */
  public UnaryCallSettings<GetSkuGroupRequest, SkuGroup> getSkuGroupSettings() {
    return ((CommerceTransactionStubSettings) getStubSettings()).getSkuGroupSettings();
  }

  /** Returns the object with the settings used for calls to listSkuGroups. */
  public PagedCallSettings<ListSkuGroupsRequest, ListSkuGroupsResponse, ListSkuGroupsPagedResponse>
      listSkuGroupsSettings() {
    return ((CommerceTransactionStubSettings) getStubSettings()).listSkuGroupsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((CommerceTransactionStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((CommerceTransactionStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final CommerceTransactionSettings create(CommerceTransactionStubSettings stub)
      throws IOException {
    return new CommerceTransactionSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CommerceTransactionStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CommerceTransactionStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CommerceTransactionStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CommerceTransactionStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return CommerceTransactionStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return CommerceTransactionStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CommerceTransactionStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CommerceTransactionStubSettings.defaultApiClientHeaderProviderBuilder();
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
  public static Builder newBuilder(@Nullable ClientContext clientContext) {
    return new Builder(clientContext);
  }

  /** Returns a builder containing all the values of this settings class. */
  public Builder toBuilder() {
    return new Builder(this);
  }

  protected CommerceTransactionSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CommerceTransactionSettings. */
  public static class Builder extends ClientSettings.Builder<CommerceTransactionSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(@Nullable ClientContext clientContext) {
      super(CommerceTransactionStubSettings.newBuilder(clientContext));
    }

    protected Builder(CommerceTransactionSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CommerceTransactionStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CommerceTransactionStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(CommerceTransactionStubSettings.newHttpJsonBuilder());
    }

    public CommerceTransactionStubSettings.Builder getStubSettingsBuilder() {
      return ((CommerceTransactionStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listServices. */
    public PagedCallSettings.Builder<
            ListServicesRequest, ListServicesResponse, ListServicesPagedResponse>
        listServicesSettings() {
      return getStubSettingsBuilder().listServicesSettings();
    }

    /** Returns the builder for the settings used for calls to getService. */
    public UnaryCallSettings.Builder<GetServiceRequest, Service> getServiceSettings() {
      return getStubSettingsBuilder().getServiceSettings();
    }

    /** Returns the builder for the settings used for calls to listPrivateOffers. */
    public PagedCallSettings.Builder<
            ListPrivateOffersRequest, ListPrivateOffersResponse, ListPrivateOffersPagedResponse>
        listPrivateOffersSettings() {
      return getStubSettingsBuilder().listPrivateOffersSettings();
    }

    /** Returns the builder for the settings used for calls to getPrivateOffer. */
    public UnaryCallSettings.Builder<GetPrivateOfferRequest, PrivateOffer>
        getPrivateOfferSettings() {
      return getStubSettingsBuilder().getPrivateOfferSettings();
    }

    /** Returns the builder for the settings used for calls to resolveAmendmentTarget. */
    public UnaryCallSettings.Builder<ResolveAmendmentTargetRequest, ResolveAmendmentTargetResponse>
        resolveAmendmentTargetSettings() {
      return getStubSettingsBuilder().resolveAmendmentTargetSettings();
    }

    /** Returns the builder for the settings used for calls to createPrivateOffer. */
    public UnaryCallSettings.Builder<CreatePrivateOfferRequest, PrivateOffer>
        createPrivateOfferSettings() {
      return getStubSettingsBuilder().createPrivateOfferSettings();
    }

    /** Returns the builder for the settings used for calls to updatePrivateOffer. */
    public UnaryCallSettings.Builder<UpdatePrivateOfferRequest, PrivateOffer>
        updatePrivateOfferSettings() {
      return getStubSettingsBuilder().updatePrivateOfferSettings();
    }

    /** Returns the builder for the settings used for calls to publishPrivateOffer. */
    public UnaryCallSettings.Builder<PublishPrivateOfferRequest, PrivateOffer>
        publishPrivateOfferSettings() {
      return getStubSettingsBuilder().publishPrivateOfferSettings();
    }

    /** Returns the builder for the settings used for calls to cancelPrivateOffer. */
    public UnaryCallSettings.Builder<CancelPrivateOfferRequest, PrivateOffer>
        cancelPrivateOfferSettings() {
      return getStubSettingsBuilder().cancelPrivateOfferSettings();
    }

    /** Returns the builder for the settings used for calls to deletePrivateOffer. */
    public UnaryCallSettings.Builder<DeletePrivateOfferRequest, Empty>
        deletePrivateOfferSettings() {
      return getStubSettingsBuilder().deletePrivateOfferSettings();
    }

    /** Returns the builder for the settings used for calls to listPrivateOfferDocuments. */
    public PagedCallSettings.Builder<
            ListPrivateOfferDocumentsRequest,
            ListPrivateOfferDocumentsResponse,
            ListPrivateOfferDocumentsPagedResponse>
        listPrivateOfferDocumentsSettings() {
      return getStubSettingsBuilder().listPrivateOfferDocumentsSettings();
    }

    /** Returns the builder for the settings used for calls to getPrivateOfferDocument. */
    public UnaryCallSettings.Builder<GetPrivateOfferDocumentRequest, PrivateOfferDocument>
        getPrivateOfferDocumentSettings() {
      return getStubSettingsBuilder().getPrivateOfferDocumentSettings();
    }

    /** Returns the builder for the settings used for calls to createPrivateOfferDocument. */
    public UnaryCallSettings.Builder<CreatePrivateOfferDocumentRequest, PrivateOfferDocument>
        createPrivateOfferDocumentSettings() {
      return getStubSettingsBuilder().createPrivateOfferDocumentSettings();
    }

    /** Returns the builder for the settings used for calls to updatePrivateOfferDocument. */
    public UnaryCallSettings.Builder<UpdatePrivateOfferDocumentRequest, PrivateOfferDocument>
        updatePrivateOfferDocumentSettings() {
      return getStubSettingsBuilder().updatePrivateOfferDocumentSettings();
    }

    /** Returns the builder for the settings used for calls to deletePrivateOfferDocument. */
    public UnaryCallSettings.Builder<DeletePrivateOfferDocumentRequest, Empty>
        deletePrivateOfferDocumentSettings() {
      return getStubSettingsBuilder().deletePrivateOfferDocumentSettings();
    }

    /** Returns the builder for the settings used for calls to listStandardOffers. */
    public PagedCallSettings.Builder<
            ListStandardOffersRequest, ListStandardOffersResponse, ListStandardOffersPagedResponse>
        listStandardOffersSettings() {
      return getStubSettingsBuilder().listStandardOffersSettings();
    }

    /** Returns the builder for the settings used for calls to getStandardOffer. */
    public UnaryCallSettings.Builder<GetStandardOfferRequest, StandardOffer>
        getStandardOfferSettings() {
      return getStubSettingsBuilder().getStandardOfferSettings();
    }

    /** Returns the builder for the settings used for calls to getSku. */
    public UnaryCallSettings.Builder<GetSkuRequest, Sku> getSkuSettings() {
      return getStubSettingsBuilder().getSkuSettings();
    }

    /** Returns the builder for the settings used for calls to listSkus. */
    public PagedCallSettings.Builder<ListSkusRequest, ListSkusResponse, ListSkusPagedResponse>
        listSkusSettings() {
      return getStubSettingsBuilder().listSkusSettings();
    }

    /** Returns the builder for the settings used for calls to getSkuGroup. */
    public UnaryCallSettings.Builder<GetSkuGroupRequest, SkuGroup> getSkuGroupSettings() {
      return getStubSettingsBuilder().getSkuGroupSettings();
    }

    /** Returns the builder for the settings used for calls to listSkuGroups. */
    public PagedCallSettings.Builder<
            ListSkuGroupsRequest, ListSkuGroupsResponse, ListSkuGroupsPagedResponse>
        listSkuGroupsSettings() {
      return getStubSettingsBuilder().listSkuGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return getStubSettingsBuilder().listLocationsSettings();
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getStubSettingsBuilder().getLocationSettings();
    }

    @Override
    public CommerceTransactionSettings build() throws IOException {
      return new CommerceTransactionSettings(this);
    }
  }
}
