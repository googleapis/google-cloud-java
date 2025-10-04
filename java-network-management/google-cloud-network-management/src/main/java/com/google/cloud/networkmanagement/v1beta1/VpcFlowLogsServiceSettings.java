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

import static com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsServiceClient.ListVpcFlowLogsConfigsPagedResponse;
import static com.google.cloud.networkmanagement.v1beta1.VpcFlowLogsServiceClient.QueryOrgVpcFlowLogsConfigsPagedResponse;

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
import com.google.cloud.networkmanagement.v1beta1.stub.VpcFlowLogsServiceStubSettings;
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
 * Settings class to configure an instance of {@link VpcFlowLogsServiceClient}.
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
 * VpcFlowLogsServiceSettings.Builder vpcFlowLogsServiceSettingsBuilder =
 *     VpcFlowLogsServiceSettings.newBuilder();
 * vpcFlowLogsServiceSettingsBuilder
 *     .getVpcFlowLogsConfigSettings()
 *     .setRetrySettings(
 *         vpcFlowLogsServiceSettingsBuilder
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
 * VpcFlowLogsServiceSettings vpcFlowLogsServiceSettings =
 *     vpcFlowLogsServiceSettingsBuilder.build();
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
 * VpcFlowLogsServiceSettings.Builder vpcFlowLogsServiceSettingsBuilder =
 *     VpcFlowLogsServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * vpcFlowLogsServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@BetaApi
@Generated("by gapic-generator-java")
public class VpcFlowLogsServiceSettings extends ClientSettings<VpcFlowLogsServiceSettings> {

  /** Returns the object with the settings used for calls to listVpcFlowLogsConfigs. */
  public PagedCallSettings<
          ListVpcFlowLogsConfigsRequest,
          ListVpcFlowLogsConfigsResponse,
          ListVpcFlowLogsConfigsPagedResponse>
      listVpcFlowLogsConfigsSettings() {
    return ((VpcFlowLogsServiceStubSettings) getStubSettings()).listVpcFlowLogsConfigsSettings();
  }

  /** Returns the object with the settings used for calls to getVpcFlowLogsConfig. */
  public UnaryCallSettings<GetVpcFlowLogsConfigRequest, VpcFlowLogsConfig>
      getVpcFlowLogsConfigSettings() {
    return ((VpcFlowLogsServiceStubSettings) getStubSettings()).getVpcFlowLogsConfigSettings();
  }

  /** Returns the object with the settings used for calls to createVpcFlowLogsConfig. */
  public UnaryCallSettings<CreateVpcFlowLogsConfigRequest, Operation>
      createVpcFlowLogsConfigSettings() {
    return ((VpcFlowLogsServiceStubSettings) getStubSettings()).createVpcFlowLogsConfigSettings();
  }

  /** Returns the object with the settings used for calls to createVpcFlowLogsConfig. */
  public OperationCallSettings<CreateVpcFlowLogsConfigRequest, VpcFlowLogsConfig, OperationMetadata>
      createVpcFlowLogsConfigOperationSettings() {
    return ((VpcFlowLogsServiceStubSettings) getStubSettings())
        .createVpcFlowLogsConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateVpcFlowLogsConfig. */
  public UnaryCallSettings<UpdateVpcFlowLogsConfigRequest, Operation>
      updateVpcFlowLogsConfigSettings() {
    return ((VpcFlowLogsServiceStubSettings) getStubSettings()).updateVpcFlowLogsConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateVpcFlowLogsConfig. */
  public OperationCallSettings<UpdateVpcFlowLogsConfigRequest, VpcFlowLogsConfig, OperationMetadata>
      updateVpcFlowLogsConfigOperationSettings() {
    return ((VpcFlowLogsServiceStubSettings) getStubSettings())
        .updateVpcFlowLogsConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteVpcFlowLogsConfig. */
  public UnaryCallSettings<DeleteVpcFlowLogsConfigRequest, Operation>
      deleteVpcFlowLogsConfigSettings() {
    return ((VpcFlowLogsServiceStubSettings) getStubSettings()).deleteVpcFlowLogsConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteVpcFlowLogsConfig. */
  public OperationCallSettings<DeleteVpcFlowLogsConfigRequest, Empty, OperationMetadata>
      deleteVpcFlowLogsConfigOperationSettings() {
    return ((VpcFlowLogsServiceStubSettings) getStubSettings())
        .deleteVpcFlowLogsConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to queryOrgVpcFlowLogsConfigs. */
  public PagedCallSettings<
          QueryOrgVpcFlowLogsConfigsRequest,
          QueryOrgVpcFlowLogsConfigsResponse,
          QueryOrgVpcFlowLogsConfigsPagedResponse>
      queryOrgVpcFlowLogsConfigsSettings() {
    return ((VpcFlowLogsServiceStubSettings) getStubSettings())
        .queryOrgVpcFlowLogsConfigsSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((VpcFlowLogsServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((VpcFlowLogsServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((VpcFlowLogsServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((VpcFlowLogsServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((VpcFlowLogsServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final VpcFlowLogsServiceSettings create(VpcFlowLogsServiceStubSettings stub)
      throws IOException {
    return new VpcFlowLogsServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return VpcFlowLogsServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return VpcFlowLogsServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return VpcFlowLogsServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return VpcFlowLogsServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return VpcFlowLogsServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return VpcFlowLogsServiceStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return VpcFlowLogsServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return VpcFlowLogsServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected VpcFlowLogsServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for VpcFlowLogsServiceSettings. */
  public static class Builder extends ClientSettings.Builder<VpcFlowLogsServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(VpcFlowLogsServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(VpcFlowLogsServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(VpcFlowLogsServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(VpcFlowLogsServiceStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(VpcFlowLogsServiceStubSettings.newHttpJsonBuilder());
    }

    public VpcFlowLogsServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((VpcFlowLogsServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to queryOrgVpcFlowLogsConfigs. */
    public PagedCallSettings.Builder<
            QueryOrgVpcFlowLogsConfigsRequest,
            QueryOrgVpcFlowLogsConfigsResponse,
            QueryOrgVpcFlowLogsConfigsPagedResponse>
        queryOrgVpcFlowLogsConfigsSettings() {
      return getStubSettingsBuilder().queryOrgVpcFlowLogsConfigsSettings();
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
    public VpcFlowLogsServiceSettings build() throws IOException {
      return new VpcFlowLogsServiceSettings(this);
    }
  }
}
