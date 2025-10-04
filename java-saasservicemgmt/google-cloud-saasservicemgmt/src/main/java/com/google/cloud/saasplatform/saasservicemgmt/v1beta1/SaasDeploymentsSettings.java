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

package com.google.cloud.saasplatform.saasservicemgmt.v1beta1;

import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListLocationsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListReleasesPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListSaasPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListTenantsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListUnitKindsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListUnitOperationsPagedResponse;
import static com.google.cloud.saasplatform.saasservicemgmt.v1beta1.SaasDeploymentsClient.ListUnitsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.saasplatform.saasservicemgmt.v1beta1.stub.SaasDeploymentsStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link SaasDeploymentsClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (saasservicemgmt.googleapis.com) and default port (443) are
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
 * of getSaas:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * SaasDeploymentsSettings.Builder saasDeploymentsSettingsBuilder =
 *     SaasDeploymentsSettings.newBuilder();
 * saasDeploymentsSettingsBuilder
 *     .getSaasSettings()
 *     .setRetrySettings(
 *         saasDeploymentsSettingsBuilder
 *             .getSaasSettings()
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
 * SaasDeploymentsSettings saasDeploymentsSettings = saasDeploymentsSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class SaasDeploymentsSettings extends ClientSettings<SaasDeploymentsSettings> {

  /** Returns the object with the settings used for calls to listSaas. */
  public PagedCallSettings<ListSaasRequest, ListSaasResponse, ListSaasPagedResponse>
      listSaasSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).listSaasSettings();
  }

  /** Returns the object with the settings used for calls to getSaas. */
  public UnaryCallSettings<GetSaasRequest, Saas> getSaasSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).getSaasSettings();
  }

  /** Returns the object with the settings used for calls to createSaas. */
  public UnaryCallSettings<CreateSaasRequest, Saas> createSaasSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).createSaasSettings();
  }

  /** Returns the object with the settings used for calls to updateSaas. */
  public UnaryCallSettings<UpdateSaasRequest, Saas> updateSaasSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).updateSaasSettings();
  }

  /** Returns the object with the settings used for calls to deleteSaas. */
  public UnaryCallSettings<DeleteSaasRequest, Empty> deleteSaasSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).deleteSaasSettings();
  }

  /** Returns the object with the settings used for calls to listTenants. */
  public PagedCallSettings<ListTenantsRequest, ListTenantsResponse, ListTenantsPagedResponse>
      listTenantsSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).listTenantsSettings();
  }

  /** Returns the object with the settings used for calls to getTenant. */
  public UnaryCallSettings<GetTenantRequest, Tenant> getTenantSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).getTenantSettings();
  }

  /** Returns the object with the settings used for calls to createTenant. */
  public UnaryCallSettings<CreateTenantRequest, Tenant> createTenantSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).createTenantSettings();
  }

  /** Returns the object with the settings used for calls to updateTenant. */
  public UnaryCallSettings<UpdateTenantRequest, Tenant> updateTenantSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).updateTenantSettings();
  }

  /** Returns the object with the settings used for calls to deleteTenant. */
  public UnaryCallSettings<DeleteTenantRequest, Empty> deleteTenantSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).deleteTenantSettings();
  }

  /** Returns the object with the settings used for calls to listUnitKinds. */
  public PagedCallSettings<ListUnitKindsRequest, ListUnitKindsResponse, ListUnitKindsPagedResponse>
      listUnitKindsSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).listUnitKindsSettings();
  }

  /** Returns the object with the settings used for calls to getUnitKind. */
  public UnaryCallSettings<GetUnitKindRequest, UnitKind> getUnitKindSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).getUnitKindSettings();
  }

  /** Returns the object with the settings used for calls to createUnitKind. */
  public UnaryCallSettings<CreateUnitKindRequest, UnitKind> createUnitKindSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).createUnitKindSettings();
  }

  /** Returns the object with the settings used for calls to updateUnitKind. */
  public UnaryCallSettings<UpdateUnitKindRequest, UnitKind> updateUnitKindSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).updateUnitKindSettings();
  }

  /** Returns the object with the settings used for calls to deleteUnitKind. */
  public UnaryCallSettings<DeleteUnitKindRequest, Empty> deleteUnitKindSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).deleteUnitKindSettings();
  }

  /** Returns the object with the settings used for calls to listUnits. */
  public PagedCallSettings<ListUnitsRequest, ListUnitsResponse, ListUnitsPagedResponse>
      listUnitsSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).listUnitsSettings();
  }

  /** Returns the object with the settings used for calls to getUnit. */
  public UnaryCallSettings<GetUnitRequest, Unit> getUnitSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).getUnitSettings();
  }

  /** Returns the object with the settings used for calls to createUnit. */
  public UnaryCallSettings<CreateUnitRequest, Unit> createUnitSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).createUnitSettings();
  }

  /** Returns the object with the settings used for calls to updateUnit. */
  public UnaryCallSettings<UpdateUnitRequest, Unit> updateUnitSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).updateUnitSettings();
  }

  /** Returns the object with the settings used for calls to deleteUnit. */
  public UnaryCallSettings<DeleteUnitRequest, Empty> deleteUnitSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).deleteUnitSettings();
  }

  /** Returns the object with the settings used for calls to listUnitOperations. */
  public PagedCallSettings<
          ListUnitOperationsRequest, ListUnitOperationsResponse, ListUnitOperationsPagedResponse>
      listUnitOperationsSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).listUnitOperationsSettings();
  }

  /** Returns the object with the settings used for calls to getUnit. */
  public UnaryCallSettings<GetUnitOperationRequest, UnitOperation> getUnitOperationSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).getUnitOperationSettings();
  }

  /** Returns the object with the settings used for calls to createUnit. */
  public UnaryCallSettings<CreateUnitOperationRequest, UnitOperation>
      createUnitOperationSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).createUnitOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateUnit. */
  public UnaryCallSettings<UpdateUnitOperationRequest, UnitOperation>
      updateUnitOperationSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).updateUnitOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteUnit. */
  public UnaryCallSettings<DeleteUnitOperationRequest, Empty> deleteUnitOperationSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).deleteUnitOperationSettings();
  }

  /** Returns the object with the settings used for calls to listReleases. */
  public PagedCallSettings<ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>
      listReleasesSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).listReleasesSettings();
  }

  /** Returns the object with the settings used for calls to getRelease. */
  public UnaryCallSettings<GetReleaseRequest, Release> getReleaseSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).getReleaseSettings();
  }

  /** Returns the object with the settings used for calls to createRelease. */
  public UnaryCallSettings<CreateReleaseRequest, Release> createReleaseSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).createReleaseSettings();
  }

  /** Returns the object with the settings used for calls to updateRelease. */
  public UnaryCallSettings<UpdateReleaseRequest, Release> updateReleaseSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).updateReleaseSettings();
  }

  /** Returns the object with the settings used for calls to deleteRelease. */
  public UnaryCallSettings<DeleteReleaseRequest, Empty> deleteReleaseSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).deleteReleaseSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((SaasDeploymentsStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final SaasDeploymentsSettings create(SaasDeploymentsStubSettings stub)
      throws IOException {
    return new SaasDeploymentsSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return SaasDeploymentsStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return SaasDeploymentsStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return SaasDeploymentsStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return SaasDeploymentsStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return SaasDeploymentsStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return SaasDeploymentsStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return SaasDeploymentsStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return SaasDeploymentsStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected SaasDeploymentsSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for SaasDeploymentsSettings. */
  public static class Builder extends ClientSettings.Builder<SaasDeploymentsSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(SaasDeploymentsStubSettings.newBuilder(clientContext));
    }

    protected Builder(SaasDeploymentsSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(SaasDeploymentsStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(SaasDeploymentsStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(SaasDeploymentsStubSettings.newHttpJsonBuilder());
    }

    public SaasDeploymentsStubSettings.Builder getStubSettingsBuilder() {
      return ((SaasDeploymentsStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listSaas. */
    public PagedCallSettings.Builder<ListSaasRequest, ListSaasResponse, ListSaasPagedResponse>
        listSaasSettings() {
      return getStubSettingsBuilder().listSaasSettings();
    }

    /** Returns the builder for the settings used for calls to getSaas. */
    public UnaryCallSettings.Builder<GetSaasRequest, Saas> getSaasSettings() {
      return getStubSettingsBuilder().getSaasSettings();
    }

    /** Returns the builder for the settings used for calls to createSaas. */
    public UnaryCallSettings.Builder<CreateSaasRequest, Saas> createSaasSettings() {
      return getStubSettingsBuilder().createSaasSettings();
    }

    /** Returns the builder for the settings used for calls to updateSaas. */
    public UnaryCallSettings.Builder<UpdateSaasRequest, Saas> updateSaasSettings() {
      return getStubSettingsBuilder().updateSaasSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSaas. */
    public UnaryCallSettings.Builder<DeleteSaasRequest, Empty> deleteSaasSettings() {
      return getStubSettingsBuilder().deleteSaasSettings();
    }

    /** Returns the builder for the settings used for calls to listTenants. */
    public PagedCallSettings.Builder<
            ListTenantsRequest, ListTenantsResponse, ListTenantsPagedResponse>
        listTenantsSettings() {
      return getStubSettingsBuilder().listTenantsSettings();
    }

    /** Returns the builder for the settings used for calls to getTenant. */
    public UnaryCallSettings.Builder<GetTenantRequest, Tenant> getTenantSettings() {
      return getStubSettingsBuilder().getTenantSettings();
    }

    /** Returns the builder for the settings used for calls to createTenant. */
    public UnaryCallSettings.Builder<CreateTenantRequest, Tenant> createTenantSettings() {
      return getStubSettingsBuilder().createTenantSettings();
    }

    /** Returns the builder for the settings used for calls to updateTenant. */
    public UnaryCallSettings.Builder<UpdateTenantRequest, Tenant> updateTenantSettings() {
      return getStubSettingsBuilder().updateTenantSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTenant. */
    public UnaryCallSettings.Builder<DeleteTenantRequest, Empty> deleteTenantSettings() {
      return getStubSettingsBuilder().deleteTenantSettings();
    }

    /** Returns the builder for the settings used for calls to listUnitKinds. */
    public PagedCallSettings.Builder<
            ListUnitKindsRequest, ListUnitKindsResponse, ListUnitKindsPagedResponse>
        listUnitKindsSettings() {
      return getStubSettingsBuilder().listUnitKindsSettings();
    }

    /** Returns the builder for the settings used for calls to getUnitKind. */
    public UnaryCallSettings.Builder<GetUnitKindRequest, UnitKind> getUnitKindSettings() {
      return getStubSettingsBuilder().getUnitKindSettings();
    }

    /** Returns the builder for the settings used for calls to createUnitKind. */
    public UnaryCallSettings.Builder<CreateUnitKindRequest, UnitKind> createUnitKindSettings() {
      return getStubSettingsBuilder().createUnitKindSettings();
    }

    /** Returns the builder for the settings used for calls to updateUnitKind. */
    public UnaryCallSettings.Builder<UpdateUnitKindRequest, UnitKind> updateUnitKindSettings() {
      return getStubSettingsBuilder().updateUnitKindSettings();
    }

    /** Returns the builder for the settings used for calls to deleteUnitKind. */
    public UnaryCallSettings.Builder<DeleteUnitKindRequest, Empty> deleteUnitKindSettings() {
      return getStubSettingsBuilder().deleteUnitKindSettings();
    }

    /** Returns the builder for the settings used for calls to listUnits. */
    public PagedCallSettings.Builder<ListUnitsRequest, ListUnitsResponse, ListUnitsPagedResponse>
        listUnitsSettings() {
      return getStubSettingsBuilder().listUnitsSettings();
    }

    /** Returns the builder for the settings used for calls to getUnit. */
    public UnaryCallSettings.Builder<GetUnitRequest, Unit> getUnitSettings() {
      return getStubSettingsBuilder().getUnitSettings();
    }

    /** Returns the builder for the settings used for calls to createUnit. */
    public UnaryCallSettings.Builder<CreateUnitRequest, Unit> createUnitSettings() {
      return getStubSettingsBuilder().createUnitSettings();
    }

    /** Returns the builder for the settings used for calls to updateUnit. */
    public UnaryCallSettings.Builder<UpdateUnitRequest, Unit> updateUnitSettings() {
      return getStubSettingsBuilder().updateUnitSettings();
    }

    /** Returns the builder for the settings used for calls to deleteUnit. */
    public UnaryCallSettings.Builder<DeleteUnitRequest, Empty> deleteUnitSettings() {
      return getStubSettingsBuilder().deleteUnitSettings();
    }

    /** Returns the builder for the settings used for calls to listUnitOperations. */
    public PagedCallSettings.Builder<
            ListUnitOperationsRequest, ListUnitOperationsResponse, ListUnitOperationsPagedResponse>
        listUnitOperationsSettings() {
      return getStubSettingsBuilder().listUnitOperationsSettings();
    }

    /** Returns the builder for the settings used for calls to getUnit. */
    public UnaryCallSettings.Builder<GetUnitOperationRequest, UnitOperation>
        getUnitOperationSettings() {
      return getStubSettingsBuilder().getUnitOperationSettings();
    }

    /** Returns the builder for the settings used for calls to createUnit. */
    public UnaryCallSettings.Builder<CreateUnitOperationRequest, UnitOperation>
        createUnitOperationSettings() {
      return getStubSettingsBuilder().createUnitOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateUnit. */
    public UnaryCallSettings.Builder<UpdateUnitOperationRequest, UnitOperation>
        updateUnitOperationSettings() {
      return getStubSettingsBuilder().updateUnitOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteUnit. */
    public UnaryCallSettings.Builder<DeleteUnitOperationRequest, Empty>
        deleteUnitOperationSettings() {
      return getStubSettingsBuilder().deleteUnitOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listReleases. */
    public PagedCallSettings.Builder<
            ListReleasesRequest, ListReleasesResponse, ListReleasesPagedResponse>
        listReleasesSettings() {
      return getStubSettingsBuilder().listReleasesSettings();
    }

    /** Returns the builder for the settings used for calls to getRelease. */
    public UnaryCallSettings.Builder<GetReleaseRequest, Release> getReleaseSettings() {
      return getStubSettingsBuilder().getReleaseSettings();
    }

    /** Returns the builder for the settings used for calls to createRelease. */
    public UnaryCallSettings.Builder<CreateReleaseRequest, Release> createReleaseSettings() {
      return getStubSettingsBuilder().createReleaseSettings();
    }

    /** Returns the builder for the settings used for calls to updateRelease. */
    public UnaryCallSettings.Builder<UpdateReleaseRequest, Release> updateReleaseSettings() {
      return getStubSettingsBuilder().updateReleaseSettings();
    }

    /** Returns the builder for the settings used for calls to deleteRelease. */
    public UnaryCallSettings.Builder<DeleteReleaseRequest, Empty> deleteReleaseSettings() {
      return getStubSettingsBuilder().deleteReleaseSettings();
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
    public SaasDeploymentsSettings build() throws IOException {
      return new SaasDeploymentsSettings(this);
    }
  }
}
