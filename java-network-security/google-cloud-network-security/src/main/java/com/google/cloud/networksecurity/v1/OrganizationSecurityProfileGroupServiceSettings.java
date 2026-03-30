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

package com.google.cloud.networksecurity.v1;

import static com.google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupServiceClient.ListSecurityProfileGroupsPagedResponse;
import static com.google.cloud.networksecurity.v1.OrganizationSecurityProfileGroupServiceClient.ListSecurityProfilesPagedResponse;

import com.google.api.core.ApiFunction;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
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
import com.google.cloud.networksecurity.v1.stub.OrganizationSecurityProfileGroupServiceStubSettings;
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
 * Settings class to configure an instance of {@link OrganizationSecurityProfileGroupServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networksecurity.googleapis.com) and default port (443) are
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
 * of getSecurityProfileGroup:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OrganizationSecurityProfileGroupServiceSettings.Builder
 *     organizationSecurityProfileGroupServiceSettingsBuilder =
 *         OrganizationSecurityProfileGroupServiceSettings.newBuilder();
 * organizationSecurityProfileGroupServiceSettingsBuilder
 *     .getSecurityProfileGroupSettings()
 *     .setRetrySettings(
 *         organizationSecurityProfileGroupServiceSettingsBuilder
 *             .getSecurityProfileGroupSettings()
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
 * OrganizationSecurityProfileGroupServiceSettings
 *     organizationSecurityProfileGroupServiceSettings =
 *         organizationSecurityProfileGroupServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createSecurityProfileGroup:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OrganizationSecurityProfileGroupServiceSettings.Builder
 *     organizationSecurityProfileGroupServiceSettingsBuilder =
 *         OrganizationSecurityProfileGroupServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * organizationSecurityProfileGroupServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class OrganizationSecurityProfileGroupServiceSettings
    extends ClientSettings<OrganizationSecurityProfileGroupServiceSettings> {

  /** Returns the object with the settings used for calls to listSecurityProfileGroups. */
  public PagedCallSettings<
          ListSecurityProfileGroupsRequest,
          ListSecurityProfileGroupsResponse,
          ListSecurityProfileGroupsPagedResponse>
      listSecurityProfileGroupsSettings() {
    return ((OrganizationSecurityProfileGroupServiceStubSettings) getStubSettings())
        .listSecurityProfileGroupsSettings();
  }

  /** Returns the object with the settings used for calls to getSecurityProfileGroup. */
  public UnaryCallSettings<GetSecurityProfileGroupRequest, SecurityProfileGroup>
      getSecurityProfileGroupSettings() {
    return ((OrganizationSecurityProfileGroupServiceStubSettings) getStubSettings())
        .getSecurityProfileGroupSettings();
  }

  /** Returns the object with the settings used for calls to createSecurityProfileGroup. */
  public UnaryCallSettings<CreateSecurityProfileGroupRequest, Operation>
      createSecurityProfileGroupSettings() {
    return ((OrganizationSecurityProfileGroupServiceStubSettings) getStubSettings())
        .createSecurityProfileGroupSettings();
  }

  /** Returns the object with the settings used for calls to createSecurityProfileGroup. */
  public OperationCallSettings<
          CreateSecurityProfileGroupRequest, SecurityProfileGroup, OperationMetadata>
      createSecurityProfileGroupOperationSettings() {
    return ((OrganizationSecurityProfileGroupServiceStubSettings) getStubSettings())
        .createSecurityProfileGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateSecurityProfileGroup. */
  public UnaryCallSettings<UpdateSecurityProfileGroupRequest, Operation>
      updateSecurityProfileGroupSettings() {
    return ((OrganizationSecurityProfileGroupServiceStubSettings) getStubSettings())
        .updateSecurityProfileGroupSettings();
  }

  /** Returns the object with the settings used for calls to updateSecurityProfileGroup. */
  public OperationCallSettings<
          UpdateSecurityProfileGroupRequest, SecurityProfileGroup, OperationMetadata>
      updateSecurityProfileGroupOperationSettings() {
    return ((OrganizationSecurityProfileGroupServiceStubSettings) getStubSettings())
        .updateSecurityProfileGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteSecurityProfileGroup. */
  public UnaryCallSettings<DeleteSecurityProfileGroupRequest, Operation>
      deleteSecurityProfileGroupSettings() {
    return ((OrganizationSecurityProfileGroupServiceStubSettings) getStubSettings())
        .deleteSecurityProfileGroupSettings();
  }

  /** Returns the object with the settings used for calls to deleteSecurityProfileGroup. */
  public OperationCallSettings<DeleteSecurityProfileGroupRequest, Empty, OperationMetadata>
      deleteSecurityProfileGroupOperationSettings() {
    return ((OrganizationSecurityProfileGroupServiceStubSettings) getStubSettings())
        .deleteSecurityProfileGroupOperationSettings();
  }

  /** Returns the object with the settings used for calls to listSecurityProfiles. */
  public PagedCallSettings<
          ListSecurityProfilesRequest,
          ListSecurityProfilesResponse,
          ListSecurityProfilesPagedResponse>
      listSecurityProfilesSettings() {
    return ((OrganizationSecurityProfileGroupServiceStubSettings) getStubSettings())
        .listSecurityProfilesSettings();
  }

  /** Returns the object with the settings used for calls to getSecurityProfile. */
  public UnaryCallSettings<GetSecurityProfileRequest, SecurityProfile>
      getSecurityProfileSettings() {
    return ((OrganizationSecurityProfileGroupServiceStubSettings) getStubSettings())
        .getSecurityProfileSettings();
  }

  /** Returns the object with the settings used for calls to createSecurityProfile. */
  public UnaryCallSettings<CreateSecurityProfileRequest, Operation>
      createSecurityProfileSettings() {
    return ((OrganizationSecurityProfileGroupServiceStubSettings) getStubSettings())
        .createSecurityProfileSettings();
  }

  /** Returns the object with the settings used for calls to createSecurityProfile. */
  public OperationCallSettings<CreateSecurityProfileRequest, SecurityProfile, OperationMetadata>
      createSecurityProfileOperationSettings() {
    return ((OrganizationSecurityProfileGroupServiceStubSettings) getStubSettings())
        .createSecurityProfileOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateSecurityProfile. */
  public UnaryCallSettings<UpdateSecurityProfileRequest, Operation>
      updateSecurityProfileSettings() {
    return ((OrganizationSecurityProfileGroupServiceStubSettings) getStubSettings())
        .updateSecurityProfileSettings();
  }

  /** Returns the object with the settings used for calls to updateSecurityProfile. */
  public OperationCallSettings<UpdateSecurityProfileRequest, SecurityProfile, OperationMetadata>
      updateSecurityProfileOperationSettings() {
    return ((OrganizationSecurityProfileGroupServiceStubSettings) getStubSettings())
        .updateSecurityProfileOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteSecurityProfile. */
  public UnaryCallSettings<DeleteSecurityProfileRequest, Operation>
      deleteSecurityProfileSettings() {
    return ((OrganizationSecurityProfileGroupServiceStubSettings) getStubSettings())
        .deleteSecurityProfileSettings();
  }

  /** Returns the object with the settings used for calls to deleteSecurityProfile. */
  public OperationCallSettings<DeleteSecurityProfileRequest, Empty, OperationMetadata>
      deleteSecurityProfileOperationSettings() {
    return ((OrganizationSecurityProfileGroupServiceStubSettings) getStubSettings())
        .deleteSecurityProfileOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((OrganizationSecurityProfileGroupServiceStubSettings) getStubSettings())
        .listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((OrganizationSecurityProfileGroupServiceStubSettings) getStubSettings())
        .getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((OrganizationSecurityProfileGroupServiceStubSettings) getStubSettings())
        .setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((OrganizationSecurityProfileGroupServiceStubSettings) getStubSettings())
        .getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((OrganizationSecurityProfileGroupServiceStubSettings) getStubSettings())
        .testIamPermissionsSettings();
  }

  public static final OrganizationSecurityProfileGroupServiceSettings create(
      OrganizationSecurityProfileGroupServiceStubSettings stub) throws IOException {
    return new OrganizationSecurityProfileGroupServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return OrganizationSecurityProfileGroupServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return OrganizationSecurityProfileGroupServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return OrganizationSecurityProfileGroupServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return OrganizationSecurityProfileGroupServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return OrganizationSecurityProfileGroupServiceStubSettings
        .defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return OrganizationSecurityProfileGroupServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return OrganizationSecurityProfileGroupServiceStubSettings
        .defaultApiClientHeaderProviderBuilder();
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

  protected OrganizationSecurityProfileGroupServiceSettings(Builder settingsBuilder)
      throws IOException {
    super(settingsBuilder);
  }

  /** Builder for OrganizationSecurityProfileGroupServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<OrganizationSecurityProfileGroupServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(OrganizationSecurityProfileGroupServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(OrganizationSecurityProfileGroupServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(OrganizationSecurityProfileGroupServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(OrganizationSecurityProfileGroupServiceStubSettings.newBuilder());
    }

    public OrganizationSecurityProfileGroupServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((OrganizationSecurityProfileGroupServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listSecurityProfileGroups. */
    public PagedCallSettings.Builder<
            ListSecurityProfileGroupsRequest,
            ListSecurityProfileGroupsResponse,
            ListSecurityProfileGroupsPagedResponse>
        listSecurityProfileGroupsSettings() {
      return getStubSettingsBuilder().listSecurityProfileGroupsSettings();
    }

    /** Returns the builder for the settings used for calls to getSecurityProfileGroup. */
    public UnaryCallSettings.Builder<GetSecurityProfileGroupRequest, SecurityProfileGroup>
        getSecurityProfileGroupSettings() {
      return getStubSettingsBuilder().getSecurityProfileGroupSettings();
    }

    /** Returns the builder for the settings used for calls to createSecurityProfileGroup. */
    public UnaryCallSettings.Builder<CreateSecurityProfileGroupRequest, Operation>
        createSecurityProfileGroupSettings() {
      return getStubSettingsBuilder().createSecurityProfileGroupSettings();
    }

    /** Returns the builder for the settings used for calls to createSecurityProfileGroup. */
    public OperationCallSettings.Builder<
            CreateSecurityProfileGroupRequest, SecurityProfileGroup, OperationMetadata>
        createSecurityProfileGroupOperationSettings() {
      return getStubSettingsBuilder().createSecurityProfileGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateSecurityProfileGroup. */
    public UnaryCallSettings.Builder<UpdateSecurityProfileGroupRequest, Operation>
        updateSecurityProfileGroupSettings() {
      return getStubSettingsBuilder().updateSecurityProfileGroupSettings();
    }

    /** Returns the builder for the settings used for calls to updateSecurityProfileGroup. */
    public OperationCallSettings.Builder<
            UpdateSecurityProfileGroupRequest, SecurityProfileGroup, OperationMetadata>
        updateSecurityProfileGroupOperationSettings() {
      return getStubSettingsBuilder().updateSecurityProfileGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSecurityProfileGroup. */
    public UnaryCallSettings.Builder<DeleteSecurityProfileGroupRequest, Operation>
        deleteSecurityProfileGroupSettings() {
      return getStubSettingsBuilder().deleteSecurityProfileGroupSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSecurityProfileGroup. */
    public OperationCallSettings.Builder<
            DeleteSecurityProfileGroupRequest, Empty, OperationMetadata>
        deleteSecurityProfileGroupOperationSettings() {
      return getStubSettingsBuilder().deleteSecurityProfileGroupOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listSecurityProfiles. */
    public PagedCallSettings.Builder<
            ListSecurityProfilesRequest,
            ListSecurityProfilesResponse,
            ListSecurityProfilesPagedResponse>
        listSecurityProfilesSettings() {
      return getStubSettingsBuilder().listSecurityProfilesSettings();
    }

    /** Returns the builder for the settings used for calls to getSecurityProfile. */
    public UnaryCallSettings.Builder<GetSecurityProfileRequest, SecurityProfile>
        getSecurityProfileSettings() {
      return getStubSettingsBuilder().getSecurityProfileSettings();
    }

    /** Returns the builder for the settings used for calls to createSecurityProfile. */
    public UnaryCallSettings.Builder<CreateSecurityProfileRequest, Operation>
        createSecurityProfileSettings() {
      return getStubSettingsBuilder().createSecurityProfileSettings();
    }

    /** Returns the builder for the settings used for calls to createSecurityProfile. */
    public OperationCallSettings.Builder<
            CreateSecurityProfileRequest, SecurityProfile, OperationMetadata>
        createSecurityProfileOperationSettings() {
      return getStubSettingsBuilder().createSecurityProfileOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateSecurityProfile. */
    public UnaryCallSettings.Builder<UpdateSecurityProfileRequest, Operation>
        updateSecurityProfileSettings() {
      return getStubSettingsBuilder().updateSecurityProfileSettings();
    }

    /** Returns the builder for the settings used for calls to updateSecurityProfile. */
    public OperationCallSettings.Builder<
            UpdateSecurityProfileRequest, SecurityProfile, OperationMetadata>
        updateSecurityProfileOperationSettings() {
      return getStubSettingsBuilder().updateSecurityProfileOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSecurityProfile. */
    public UnaryCallSettings.Builder<DeleteSecurityProfileRequest, Operation>
        deleteSecurityProfileSettings() {
      return getStubSettingsBuilder().deleteSecurityProfileSettings();
    }

    /** Returns the builder for the settings used for calls to deleteSecurityProfile. */
    public OperationCallSettings.Builder<DeleteSecurityProfileRequest, Empty, OperationMetadata>
        deleteSecurityProfileOperationSettings() {
      return getStubSettingsBuilder().deleteSecurityProfileOperationSettings();
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

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return getStubSettingsBuilder().setIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getStubSettingsBuilder().getIamPolicySettings();
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return getStubSettingsBuilder().testIamPermissionsSettings();
    }

    @Override
    public OrganizationSecurityProfileGroupServiceSettings build() throws IOException {
      return new OrganizationSecurityProfileGroupServiceSettings(this);
    }
  }
}
