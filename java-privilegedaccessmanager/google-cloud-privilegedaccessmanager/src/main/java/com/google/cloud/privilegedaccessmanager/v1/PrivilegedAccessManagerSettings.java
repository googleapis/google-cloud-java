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

package com.google.cloud.privilegedaccessmanager.v1;

import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.ListEntitlementsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.ListGrantsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.ListLocationsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.SearchEntitlementsPagedResponse;
import static com.google.cloud.privilegedaccessmanager.v1.PrivilegedAccessManagerClient.SearchGrantsPagedResponse;

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
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.privilegedaccessmanager.v1.stub.PrivilegedAccessManagerStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link PrivilegedAccessManagerClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (privilegedaccessmanager.googleapis.com) and default port (443)
 *       are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of checkOnboardingStatus to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * PrivilegedAccessManagerSettings.Builder privilegedAccessManagerSettingsBuilder =
 *     PrivilegedAccessManagerSettings.newBuilder();
 * privilegedAccessManagerSettingsBuilder
 *     .checkOnboardingStatusSettings()
 *     .setRetrySettings(
 *         privilegedAccessManagerSettingsBuilder
 *             .checkOnboardingStatusSettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * PrivilegedAccessManagerSettings privilegedAccessManagerSettings =
 *     privilegedAccessManagerSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class PrivilegedAccessManagerSettings
    extends ClientSettings<PrivilegedAccessManagerSettings> {

  /** Returns the object with the settings used for calls to checkOnboardingStatus. */
  public UnaryCallSettings<CheckOnboardingStatusRequest, CheckOnboardingStatusResponse>
      checkOnboardingStatusSettings() {
    return ((PrivilegedAccessManagerStubSettings) getStubSettings())
        .checkOnboardingStatusSettings();
  }

  /** Returns the object with the settings used for calls to listEntitlements. */
  public PagedCallSettings<
          ListEntitlementsRequest, ListEntitlementsResponse, ListEntitlementsPagedResponse>
      listEntitlementsSettings() {
    return ((PrivilegedAccessManagerStubSettings) getStubSettings()).listEntitlementsSettings();
  }

  /** Returns the object with the settings used for calls to searchEntitlements. */
  public PagedCallSettings<
          SearchEntitlementsRequest, SearchEntitlementsResponse, SearchEntitlementsPagedResponse>
      searchEntitlementsSettings() {
    return ((PrivilegedAccessManagerStubSettings) getStubSettings()).searchEntitlementsSettings();
  }

  /** Returns the object with the settings used for calls to getEntitlement. */
  public UnaryCallSettings<GetEntitlementRequest, Entitlement> getEntitlementSettings() {
    return ((PrivilegedAccessManagerStubSettings) getStubSettings()).getEntitlementSettings();
  }

  /** Returns the object with the settings used for calls to createEntitlement. */
  public UnaryCallSettings<CreateEntitlementRequest, Operation> createEntitlementSettings() {
    return ((PrivilegedAccessManagerStubSettings) getStubSettings()).createEntitlementSettings();
  }

  /** Returns the object with the settings used for calls to createEntitlement. */
  public OperationCallSettings<CreateEntitlementRequest, Entitlement, OperationMetadata>
      createEntitlementOperationSettings() {
    return ((PrivilegedAccessManagerStubSettings) getStubSettings())
        .createEntitlementOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteEntitlement. */
  public UnaryCallSettings<DeleteEntitlementRequest, Operation> deleteEntitlementSettings() {
    return ((PrivilegedAccessManagerStubSettings) getStubSettings()).deleteEntitlementSettings();
  }

  /** Returns the object with the settings used for calls to deleteEntitlement. */
  public OperationCallSettings<DeleteEntitlementRequest, Entitlement, OperationMetadata>
      deleteEntitlementOperationSettings() {
    return ((PrivilegedAccessManagerStubSettings) getStubSettings())
        .deleteEntitlementOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateEntitlement. */
  public UnaryCallSettings<UpdateEntitlementRequest, Operation> updateEntitlementSettings() {
    return ((PrivilegedAccessManagerStubSettings) getStubSettings()).updateEntitlementSettings();
  }

  /** Returns the object with the settings used for calls to updateEntitlement. */
  public OperationCallSettings<UpdateEntitlementRequest, Entitlement, OperationMetadata>
      updateEntitlementOperationSettings() {
    return ((PrivilegedAccessManagerStubSettings) getStubSettings())
        .updateEntitlementOperationSettings();
  }

  /** Returns the object with the settings used for calls to listGrants. */
  public PagedCallSettings<ListGrantsRequest, ListGrantsResponse, ListGrantsPagedResponse>
      listGrantsSettings() {
    return ((PrivilegedAccessManagerStubSettings) getStubSettings()).listGrantsSettings();
  }

  /** Returns the object with the settings used for calls to searchGrants. */
  public PagedCallSettings<SearchGrantsRequest, SearchGrantsResponse, SearchGrantsPagedResponse>
      searchGrantsSettings() {
    return ((PrivilegedAccessManagerStubSettings) getStubSettings()).searchGrantsSettings();
  }

  /** Returns the object with the settings used for calls to getGrant. */
  public UnaryCallSettings<GetGrantRequest, Grant> getGrantSettings() {
    return ((PrivilegedAccessManagerStubSettings) getStubSettings()).getGrantSettings();
  }

  /** Returns the object with the settings used for calls to createGrant. */
  public UnaryCallSettings<CreateGrantRequest, Grant> createGrantSettings() {
    return ((PrivilegedAccessManagerStubSettings) getStubSettings()).createGrantSettings();
  }

  /** Returns the object with the settings used for calls to approveGrant. */
  public UnaryCallSettings<ApproveGrantRequest, Grant> approveGrantSettings() {
    return ((PrivilegedAccessManagerStubSettings) getStubSettings()).approveGrantSettings();
  }

  /** Returns the object with the settings used for calls to denyGrant. */
  public UnaryCallSettings<DenyGrantRequest, Grant> denyGrantSettings() {
    return ((PrivilegedAccessManagerStubSettings) getStubSettings()).denyGrantSettings();
  }

  /** Returns the object with the settings used for calls to revokeGrant. */
  public UnaryCallSettings<RevokeGrantRequest, Operation> revokeGrantSettings() {
    return ((PrivilegedAccessManagerStubSettings) getStubSettings()).revokeGrantSettings();
  }

  /** Returns the object with the settings used for calls to revokeGrant. */
  public OperationCallSettings<RevokeGrantRequest, Grant, OperationMetadata>
      revokeGrantOperationSettings() {
    return ((PrivilegedAccessManagerStubSettings) getStubSettings()).revokeGrantOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((PrivilegedAccessManagerStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((PrivilegedAccessManagerStubSettings) getStubSettings()).getLocationSettings();
  }

  public static final PrivilegedAccessManagerSettings create(
      PrivilegedAccessManagerStubSettings stub) throws IOException {
    return new PrivilegedAccessManagerSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return PrivilegedAccessManagerStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return PrivilegedAccessManagerStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return PrivilegedAccessManagerStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return PrivilegedAccessManagerStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return PrivilegedAccessManagerStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return PrivilegedAccessManagerStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return PrivilegedAccessManagerStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return PrivilegedAccessManagerStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected PrivilegedAccessManagerSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for PrivilegedAccessManagerSettings. */
  public static class Builder
      extends ClientSettings.Builder<PrivilegedAccessManagerSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(PrivilegedAccessManagerStubSettings.newBuilder(clientContext));
    }

    protected Builder(PrivilegedAccessManagerSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(PrivilegedAccessManagerStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(PrivilegedAccessManagerStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(PrivilegedAccessManagerStubSettings.newHttpJsonBuilder());
    }

    public PrivilegedAccessManagerStubSettings.Builder getStubSettingsBuilder() {
      return ((PrivilegedAccessManagerStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to checkOnboardingStatus. */
    public UnaryCallSettings.Builder<CheckOnboardingStatusRequest, CheckOnboardingStatusResponse>
        checkOnboardingStatusSettings() {
      return getStubSettingsBuilder().checkOnboardingStatusSettings();
    }

    /** Returns the builder for the settings used for calls to listEntitlements. */
    public PagedCallSettings.Builder<
            ListEntitlementsRequest, ListEntitlementsResponse, ListEntitlementsPagedResponse>
        listEntitlementsSettings() {
      return getStubSettingsBuilder().listEntitlementsSettings();
    }

    /** Returns the builder for the settings used for calls to searchEntitlements. */
    public PagedCallSettings.Builder<
            SearchEntitlementsRequest, SearchEntitlementsResponse, SearchEntitlementsPagedResponse>
        searchEntitlementsSettings() {
      return getStubSettingsBuilder().searchEntitlementsSettings();
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

    /** Returns the builder for the settings used for calls to deleteEntitlement. */
    public UnaryCallSettings.Builder<DeleteEntitlementRequest, Operation>
        deleteEntitlementSettings() {
      return getStubSettingsBuilder().deleteEntitlementSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEntitlement. */
    public OperationCallSettings.Builder<DeleteEntitlementRequest, Entitlement, OperationMetadata>
        deleteEntitlementOperationSettings() {
      return getStubSettingsBuilder().deleteEntitlementOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateEntitlement. */
    public UnaryCallSettings.Builder<UpdateEntitlementRequest, Operation>
        updateEntitlementSettings() {
      return getStubSettingsBuilder().updateEntitlementSettings();
    }

    /** Returns the builder for the settings used for calls to updateEntitlement. */
    public OperationCallSettings.Builder<UpdateEntitlementRequest, Entitlement, OperationMetadata>
        updateEntitlementOperationSettings() {
      return getStubSettingsBuilder().updateEntitlementOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listGrants. */
    public PagedCallSettings.Builder<ListGrantsRequest, ListGrantsResponse, ListGrantsPagedResponse>
        listGrantsSettings() {
      return getStubSettingsBuilder().listGrantsSettings();
    }

    /** Returns the builder for the settings used for calls to searchGrants. */
    public PagedCallSettings.Builder<
            SearchGrantsRequest, SearchGrantsResponse, SearchGrantsPagedResponse>
        searchGrantsSettings() {
      return getStubSettingsBuilder().searchGrantsSettings();
    }

    /** Returns the builder for the settings used for calls to getGrant. */
    public UnaryCallSettings.Builder<GetGrantRequest, Grant> getGrantSettings() {
      return getStubSettingsBuilder().getGrantSettings();
    }

    /** Returns the builder for the settings used for calls to createGrant. */
    public UnaryCallSettings.Builder<CreateGrantRequest, Grant> createGrantSettings() {
      return getStubSettingsBuilder().createGrantSettings();
    }

    /** Returns the builder for the settings used for calls to approveGrant. */
    public UnaryCallSettings.Builder<ApproveGrantRequest, Grant> approveGrantSettings() {
      return getStubSettingsBuilder().approveGrantSettings();
    }

    /** Returns the builder for the settings used for calls to denyGrant. */
    public UnaryCallSettings.Builder<DenyGrantRequest, Grant> denyGrantSettings() {
      return getStubSettingsBuilder().denyGrantSettings();
    }

    /** Returns the builder for the settings used for calls to revokeGrant. */
    public UnaryCallSettings.Builder<RevokeGrantRequest, Operation> revokeGrantSettings() {
      return getStubSettingsBuilder().revokeGrantSettings();
    }

    /** Returns the builder for the settings used for calls to revokeGrant. */
    public OperationCallSettings.Builder<RevokeGrantRequest, Grant, OperationMetadata>
        revokeGrantOperationSettings() {
      return getStubSettingsBuilder().revokeGrantOperationSettings();
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
    public PrivilegedAccessManagerSettings build() throws IOException {
      return new PrivilegedAccessManagerSettings(this);
    }
  }
}
