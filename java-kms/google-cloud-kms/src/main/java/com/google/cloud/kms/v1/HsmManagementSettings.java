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

package com.google.cloud.kms.v1;

import static com.google.cloud.kms.v1.HsmManagementClient.ListLocationsPagedResponse;
import static com.google.cloud.kms.v1.HsmManagementClient.ListSingleTenantHsmInstanceProposalsPagedResponse;
import static com.google.cloud.kms.v1.HsmManagementClient.ListSingleTenantHsmInstancesPagedResponse;

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
import com.google.cloud.kms.v1.stub.HsmManagementStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
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
 * Settings class to configure an instance of {@link HsmManagementClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (cloudkms.googleapis.com) and default port (443) are used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the
 * [RetrySettings](https://cloud.google.com/java/docs/reference/gax/latest/com.google.api.gax.retrying.RetrySettings)
 * of getSingleTenantHsmInstance:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * HsmManagementSettings.Builder hsmManagementSettingsBuilder = HsmManagementSettings.newBuilder();
 * hsmManagementSettingsBuilder
 *     .getSingleTenantHsmInstanceSettings()
 *     .setRetrySettings(
 *         hsmManagementSettingsBuilder
 *             .getSingleTenantHsmInstanceSettings()
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
 * HsmManagementSettings hsmManagementSettings = hsmManagementSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://docs.cloud.google.com/java/docs/client-retries) for additional support in setting
 * retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createSingleTenantHsmInstance:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * HsmManagementSettings.Builder hsmManagementSettingsBuilder = HsmManagementSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * hsmManagementSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class HsmManagementSettings extends ClientSettings<HsmManagementSettings> {

  /** Returns the object with the settings used for calls to listSingleTenantHsmInstances. */
  public PagedCallSettings<
          ListSingleTenantHsmInstancesRequest,
          ListSingleTenantHsmInstancesResponse,
          ListSingleTenantHsmInstancesPagedResponse>
      listSingleTenantHsmInstancesSettings() {
    return ((HsmManagementStubSettings) getStubSettings()).listSingleTenantHsmInstancesSettings();
  }

  /** Returns the object with the settings used for calls to getSingleTenantHsmInstance. */
  public UnaryCallSettings<GetSingleTenantHsmInstanceRequest, SingleTenantHsmInstance>
      getSingleTenantHsmInstanceSettings() {
    return ((HsmManagementStubSettings) getStubSettings()).getSingleTenantHsmInstanceSettings();
  }

  /** Returns the object with the settings used for calls to createSingleTenantHsmInstance. */
  public UnaryCallSettings<CreateSingleTenantHsmInstanceRequest, Operation>
      createSingleTenantHsmInstanceSettings() {
    return ((HsmManagementStubSettings) getStubSettings()).createSingleTenantHsmInstanceSettings();
  }

  /** Returns the object with the settings used for calls to createSingleTenantHsmInstance. */
  public OperationCallSettings<
          CreateSingleTenantHsmInstanceRequest,
          SingleTenantHsmInstance,
          CreateSingleTenantHsmInstanceMetadata>
      createSingleTenantHsmInstanceOperationSettings() {
    return ((HsmManagementStubSettings) getStubSettings())
        .createSingleTenantHsmInstanceOperationSettings();
  }

  /**
   * Returns the object with the settings used for calls to createSingleTenantHsmInstanceProposal.
   */
  public UnaryCallSettings<CreateSingleTenantHsmInstanceProposalRequest, Operation>
      createSingleTenantHsmInstanceProposalSettings() {
    return ((HsmManagementStubSettings) getStubSettings())
        .createSingleTenantHsmInstanceProposalSettings();
  }

  /**
   * Returns the object with the settings used for calls to createSingleTenantHsmInstanceProposal.
   */
  public OperationCallSettings<
          CreateSingleTenantHsmInstanceProposalRequest,
          SingleTenantHsmInstanceProposal,
          CreateSingleTenantHsmInstanceProposalMetadata>
      createSingleTenantHsmInstanceProposalOperationSettings() {
    return ((HsmManagementStubSettings) getStubSettings())
        .createSingleTenantHsmInstanceProposalOperationSettings();
  }

  /**
   * Returns the object with the settings used for calls to approveSingleTenantHsmInstanceProposal.
   */
  public UnaryCallSettings<
          ApproveSingleTenantHsmInstanceProposalRequest,
          ApproveSingleTenantHsmInstanceProposalResponse>
      approveSingleTenantHsmInstanceProposalSettings() {
    return ((HsmManagementStubSettings) getStubSettings())
        .approveSingleTenantHsmInstanceProposalSettings();
  }

  /**
   * Returns the object with the settings used for calls to executeSingleTenantHsmInstanceProposal.
   */
  public UnaryCallSettings<ExecuteSingleTenantHsmInstanceProposalRequest, Operation>
      executeSingleTenantHsmInstanceProposalSettings() {
    return ((HsmManagementStubSettings) getStubSettings())
        .executeSingleTenantHsmInstanceProposalSettings();
  }

  /**
   * Returns the object with the settings used for calls to executeSingleTenantHsmInstanceProposal.
   */
  public OperationCallSettings<
          ExecuteSingleTenantHsmInstanceProposalRequest,
          ExecuteSingleTenantHsmInstanceProposalResponse,
          ExecuteSingleTenantHsmInstanceProposalMetadata>
      executeSingleTenantHsmInstanceProposalOperationSettings() {
    return ((HsmManagementStubSettings) getStubSettings())
        .executeSingleTenantHsmInstanceProposalOperationSettings();
  }

  /** Returns the object with the settings used for calls to getSingleTenantHsmInstanceProposal. */
  public UnaryCallSettings<
          GetSingleTenantHsmInstanceProposalRequest, SingleTenantHsmInstanceProposal>
      getSingleTenantHsmInstanceProposalSettings() {
    return ((HsmManagementStubSettings) getStubSettings())
        .getSingleTenantHsmInstanceProposalSettings();
  }

  /**
   * Returns the object with the settings used for calls to listSingleTenantHsmInstanceProposals.
   */
  public PagedCallSettings<
          ListSingleTenantHsmInstanceProposalsRequest,
          ListSingleTenantHsmInstanceProposalsResponse,
          ListSingleTenantHsmInstanceProposalsPagedResponse>
      listSingleTenantHsmInstanceProposalsSettings() {
    return ((HsmManagementStubSettings) getStubSettings())
        .listSingleTenantHsmInstanceProposalsSettings();
  }

  /**
   * Returns the object with the settings used for calls to deleteSingleTenantHsmInstanceProposal.
   */
  public UnaryCallSettings<DeleteSingleTenantHsmInstanceProposalRequest, Empty>
      deleteSingleTenantHsmInstanceProposalSettings() {
    return ((HsmManagementStubSettings) getStubSettings())
        .deleteSingleTenantHsmInstanceProposalSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((HsmManagementStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((HsmManagementStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((HsmManagementStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((HsmManagementStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((HsmManagementStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final HsmManagementSettings create(HsmManagementStubSettings stub)
      throws IOException {
    return new HsmManagementSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return HsmManagementStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return HsmManagementStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return HsmManagementStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return HsmManagementStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return HsmManagementStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return HsmManagementStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return HsmManagementStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return HsmManagementStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected HsmManagementSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for HsmManagementSettings. */
  public static class Builder extends ClientSettings.Builder<HsmManagementSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(HsmManagementStubSettings.newBuilder(clientContext));
    }

    protected Builder(HsmManagementSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(HsmManagementStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(HsmManagementStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(HsmManagementStubSettings.newHttpJsonBuilder());
    }

    public HsmManagementStubSettings.Builder getStubSettingsBuilder() {
      return ((HsmManagementStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listSingleTenantHsmInstances. */
    public PagedCallSettings.Builder<
            ListSingleTenantHsmInstancesRequest,
            ListSingleTenantHsmInstancesResponse,
            ListSingleTenantHsmInstancesPagedResponse>
        listSingleTenantHsmInstancesSettings() {
      return getStubSettingsBuilder().listSingleTenantHsmInstancesSettings();
    }

    /** Returns the builder for the settings used for calls to getSingleTenantHsmInstance. */
    public UnaryCallSettings.Builder<GetSingleTenantHsmInstanceRequest, SingleTenantHsmInstance>
        getSingleTenantHsmInstanceSettings() {
      return getStubSettingsBuilder().getSingleTenantHsmInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to createSingleTenantHsmInstance. */
    public UnaryCallSettings.Builder<CreateSingleTenantHsmInstanceRequest, Operation>
        createSingleTenantHsmInstanceSettings() {
      return getStubSettingsBuilder().createSingleTenantHsmInstanceSettings();
    }

    /** Returns the builder for the settings used for calls to createSingleTenantHsmInstance. */
    public OperationCallSettings.Builder<
            CreateSingleTenantHsmInstanceRequest,
            SingleTenantHsmInstance,
            CreateSingleTenantHsmInstanceMetadata>
        createSingleTenantHsmInstanceOperationSettings() {
      return getStubSettingsBuilder().createSingleTenantHsmInstanceOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to createSingleTenantHsmInstanceProposal.
     */
    public UnaryCallSettings.Builder<CreateSingleTenantHsmInstanceProposalRequest, Operation>
        createSingleTenantHsmInstanceProposalSettings() {
      return getStubSettingsBuilder().createSingleTenantHsmInstanceProposalSettings();
    }

    /**
     * Returns the builder for the settings used for calls to createSingleTenantHsmInstanceProposal.
     */
    public OperationCallSettings.Builder<
            CreateSingleTenantHsmInstanceProposalRequest,
            SingleTenantHsmInstanceProposal,
            CreateSingleTenantHsmInstanceProposalMetadata>
        createSingleTenantHsmInstanceProposalOperationSettings() {
      return getStubSettingsBuilder().createSingleTenantHsmInstanceProposalOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * approveSingleTenantHsmInstanceProposal.
     */
    public UnaryCallSettings.Builder<
            ApproveSingleTenantHsmInstanceProposalRequest,
            ApproveSingleTenantHsmInstanceProposalResponse>
        approveSingleTenantHsmInstanceProposalSettings() {
      return getStubSettingsBuilder().approveSingleTenantHsmInstanceProposalSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * executeSingleTenantHsmInstanceProposal.
     */
    public UnaryCallSettings.Builder<ExecuteSingleTenantHsmInstanceProposalRequest, Operation>
        executeSingleTenantHsmInstanceProposalSettings() {
      return getStubSettingsBuilder().executeSingleTenantHsmInstanceProposalSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * executeSingleTenantHsmInstanceProposal.
     */
    public OperationCallSettings.Builder<
            ExecuteSingleTenantHsmInstanceProposalRequest,
            ExecuteSingleTenantHsmInstanceProposalResponse,
            ExecuteSingleTenantHsmInstanceProposalMetadata>
        executeSingleTenantHsmInstanceProposalOperationSettings() {
      return getStubSettingsBuilder().executeSingleTenantHsmInstanceProposalOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to getSingleTenantHsmInstanceProposal.
     */
    public UnaryCallSettings.Builder<
            GetSingleTenantHsmInstanceProposalRequest, SingleTenantHsmInstanceProposal>
        getSingleTenantHsmInstanceProposalSettings() {
      return getStubSettingsBuilder().getSingleTenantHsmInstanceProposalSettings();
    }

    /**
     * Returns the builder for the settings used for calls to listSingleTenantHsmInstanceProposals.
     */
    public PagedCallSettings.Builder<
            ListSingleTenantHsmInstanceProposalsRequest,
            ListSingleTenantHsmInstanceProposalsResponse,
            ListSingleTenantHsmInstanceProposalsPagedResponse>
        listSingleTenantHsmInstanceProposalsSettings() {
      return getStubSettingsBuilder().listSingleTenantHsmInstanceProposalsSettings();
    }

    /**
     * Returns the builder for the settings used for calls to deleteSingleTenantHsmInstanceProposal.
     */
    public UnaryCallSettings.Builder<DeleteSingleTenantHsmInstanceProposalRequest, Empty>
        deleteSingleTenantHsmInstanceProposalSettings() {
      return getStubSettingsBuilder().deleteSingleTenantHsmInstanceProposalSettings();
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
    public HsmManagementSettings build() throws IOException {
      return new HsmManagementSettings(this);
    }
  }
}
