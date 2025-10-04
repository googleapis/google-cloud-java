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

package com.google.cloud.networkmanagement.v1beta1;

import static com.google.cloud.networkmanagement.v1beta1.OrganizationVpcFlowLogsServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networkmanagement.v1beta1.OrganizationVpcFlowLogsServiceClient.ListVpcFlowLogsConfigsPagedResponse;

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
import com.google.cloud.networkmanagement.v1beta1.stub.OrganizationVpcFlowLogsServiceStubSettings;
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
 * Settings class to configure an instance of {@link OrganizationVpcFlowLogsServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networkmanagement.googleapis.com) and default port (443) are
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
 * of getVpcFlowLogsConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OrganizationVpcFlowLogsServiceSettings.Builder organizationVpcFlowLogsServiceSettingsBuilder =
 *     OrganizationVpcFlowLogsServiceSettings.newBuilder();
 * organizationVpcFlowLogsServiceSettingsBuilder
 *     .getVpcFlowLogsConfigSettings()
 *     .setRetrySettings(
 *         organizationVpcFlowLogsServiceSettingsBuilder
 *             .getVpcFlowLogsConfigSettings()
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
 * OrganizationVpcFlowLogsServiceSettings organizationVpcFlowLogsServiceSettings =
 *     organizationVpcFlowLogsServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createVpcFlowLogsConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * OrganizationVpcFlowLogsServiceSettings.Builder organizationVpcFlowLogsServiceSettingsBuilder =
 *     OrganizationVpcFlowLogsServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * organizationVpcFlowLogsServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class OrganizationVpcFlowLogsServiceSettings
    extends ClientSettings<OrganizationVpcFlowLogsServiceSettings> {

  /** Returns the object with the settings used for calls to listVpcFlowLogsConfigs. */
  public PagedCallSettings<
          ListVpcFlowLogsConfigsRequest,
          ListVpcFlowLogsConfigsResponse,
          ListVpcFlowLogsConfigsPagedResponse>
      listVpcFlowLogsConfigsSettings() {
    return ((OrganizationVpcFlowLogsServiceStubSettings) getStubSettings())
        .listVpcFlowLogsConfigsSettings();
  }

  /** Returns the object with the settings used for calls to getVpcFlowLogsConfig. */
  public UnaryCallSettings<GetVpcFlowLogsConfigRequest, VpcFlowLogsConfig>
      getVpcFlowLogsConfigSettings() {
    return ((OrganizationVpcFlowLogsServiceStubSettings) getStubSettings())
        .getVpcFlowLogsConfigSettings();
  }

  /** Returns the object with the settings used for calls to createVpcFlowLogsConfig. */
  public UnaryCallSettings<CreateVpcFlowLogsConfigRequest, Operation>
      createVpcFlowLogsConfigSettings() {
    return ((OrganizationVpcFlowLogsServiceStubSettings) getStubSettings())
        .createVpcFlowLogsConfigSettings();
  }

  /** Returns the object with the settings used for calls to createVpcFlowLogsConfig. */
  public OperationCallSettings<CreateVpcFlowLogsConfigRequest, VpcFlowLogsConfig, OperationMetadata>
      createVpcFlowLogsConfigOperationSettings() {
    return ((OrganizationVpcFlowLogsServiceStubSettings) getStubSettings())
        .createVpcFlowLogsConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateVpcFlowLogsConfig. */
  public UnaryCallSettings<UpdateVpcFlowLogsConfigRequest, Operation>
      updateVpcFlowLogsConfigSettings() {
    return ((OrganizationVpcFlowLogsServiceStubSettings) getStubSettings())
        .updateVpcFlowLogsConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateVpcFlowLogsConfig. */
  public OperationCallSettings<UpdateVpcFlowLogsConfigRequest, VpcFlowLogsConfig, OperationMetadata>
      updateVpcFlowLogsConfigOperationSettings() {
    return ((OrganizationVpcFlowLogsServiceStubSettings) getStubSettings())
        .updateVpcFlowLogsConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteVpcFlowLogsConfig. */
  public UnaryCallSettings<DeleteVpcFlowLogsConfigRequest, Operation>
      deleteVpcFlowLogsConfigSettings() {
    return ((OrganizationVpcFlowLogsServiceStubSettings) getStubSettings())
        .deleteVpcFlowLogsConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteVpcFlowLogsConfig. */
  public OperationCallSettings<DeleteVpcFlowLogsConfigRequest, Empty, OperationMetadata>
      deleteVpcFlowLogsConfigOperationSettings() {
    return ((OrganizationVpcFlowLogsServiceStubSettings) getStubSettings())
        .deleteVpcFlowLogsConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((OrganizationVpcFlowLogsServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((OrganizationVpcFlowLogsServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((OrganizationVpcFlowLogsServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((OrganizationVpcFlowLogsServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((OrganizationVpcFlowLogsServiceStubSettings) getStubSettings())
        .testIamPermissionsSettings();
  }

  public static final OrganizationVpcFlowLogsServiceSettings create(
      OrganizationVpcFlowLogsServiceStubSettings stub) throws IOException {
    return new OrganizationVpcFlowLogsServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return OrganizationVpcFlowLogsServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return OrganizationVpcFlowLogsServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return OrganizationVpcFlowLogsServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return OrganizationVpcFlowLogsServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return OrganizationVpcFlowLogsServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return OrganizationVpcFlowLogsServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return OrganizationVpcFlowLogsServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return OrganizationVpcFlowLogsServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected OrganizationVpcFlowLogsServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for OrganizationVpcFlowLogsServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<OrganizationVpcFlowLogsServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(OrganizationVpcFlowLogsServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(OrganizationVpcFlowLogsServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(OrganizationVpcFlowLogsServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(OrganizationVpcFlowLogsServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(OrganizationVpcFlowLogsServiceStubSettings.newHttpJsonBuilder());
    }

    public OrganizationVpcFlowLogsServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((OrganizationVpcFlowLogsServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listVpcFlowLogsConfigs. */
    public PagedCallSettings.Builder<
            ListVpcFlowLogsConfigsRequest,
            ListVpcFlowLogsConfigsResponse,
            ListVpcFlowLogsConfigsPagedResponse>
        listVpcFlowLogsConfigsSettings() {
      return getStubSettingsBuilder().listVpcFlowLogsConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to getVpcFlowLogsConfig. */
    public UnaryCallSettings.Builder<GetVpcFlowLogsConfigRequest, VpcFlowLogsConfig>
        getVpcFlowLogsConfigSettings() {
      return getStubSettingsBuilder().getVpcFlowLogsConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createVpcFlowLogsConfig. */
    public UnaryCallSettings.Builder<CreateVpcFlowLogsConfigRequest, Operation>
        createVpcFlowLogsConfigSettings() {
      return getStubSettingsBuilder().createVpcFlowLogsConfigSettings();
    }

    /** Returns the builder for the settings used for calls to createVpcFlowLogsConfig. */
    public OperationCallSettings.Builder<
            CreateVpcFlowLogsConfigRequest, VpcFlowLogsConfig, OperationMetadata>
        createVpcFlowLogsConfigOperationSettings() {
      return getStubSettingsBuilder().createVpcFlowLogsConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateVpcFlowLogsConfig. */
    public UnaryCallSettings.Builder<UpdateVpcFlowLogsConfigRequest, Operation>
        updateVpcFlowLogsConfigSettings() {
      return getStubSettingsBuilder().updateVpcFlowLogsConfigSettings();
    }

    /** Returns the builder for the settings used for calls to updateVpcFlowLogsConfig. */
    public OperationCallSettings.Builder<
            UpdateVpcFlowLogsConfigRequest, VpcFlowLogsConfig, OperationMetadata>
        updateVpcFlowLogsConfigOperationSettings() {
      return getStubSettingsBuilder().updateVpcFlowLogsConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteVpcFlowLogsConfig. */
    public UnaryCallSettings.Builder<DeleteVpcFlowLogsConfigRequest, Operation>
        deleteVpcFlowLogsConfigSettings() {
      return getStubSettingsBuilder().deleteVpcFlowLogsConfigSettings();
    }

    /** Returns the builder for the settings used for calls to deleteVpcFlowLogsConfig. */
    public OperationCallSettings.Builder<DeleteVpcFlowLogsConfigRequest, Empty, OperationMetadata>
        deleteVpcFlowLogsConfigOperationSettings() {
      return getStubSettingsBuilder().deleteVpcFlowLogsConfigOperationSettings();
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
    public OrganizationVpcFlowLogsServiceSettings build() throws IOException {
      return new OrganizationVpcFlowLogsServiceSettings(this);
    }
  }
}
