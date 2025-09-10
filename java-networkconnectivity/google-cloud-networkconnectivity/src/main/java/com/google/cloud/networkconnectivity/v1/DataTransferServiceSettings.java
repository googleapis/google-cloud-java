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

package com.google.cloud.networkconnectivity.v1;

import static com.google.cloud.networkconnectivity.v1.DataTransferServiceClient.ListDestinationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.DataTransferServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.DataTransferServiceClient.ListMulticloudDataTransferConfigsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.DataTransferServiceClient.ListMulticloudDataTransferSupportedServicesPagedResponse;

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
import com.google.cloud.networkconnectivity.v1.stub.DataTransferServiceStubSettings;
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
 * Settings class to configure an instance of {@link DataTransferServiceClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networkconnectivity.googleapis.com) and default port (443) are
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
 * of getMulticloudDataTransferConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataTransferServiceSettings.Builder dataTransferServiceSettingsBuilder =
 *     DataTransferServiceSettings.newBuilder();
 * dataTransferServiceSettingsBuilder
 *     .getMulticloudDataTransferConfigSettings()
 *     .setRetrySettings(
 *         dataTransferServiceSettingsBuilder
 *             .getMulticloudDataTransferConfigSettings()
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
 * DataTransferServiceSettings dataTransferServiceSettings =
 *     dataTransferServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createMulticloudDataTransferConfig:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataTransferServiceSettings.Builder dataTransferServiceSettingsBuilder =
 *     DataTransferServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * dataTransferServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class DataTransferServiceSettings extends ClientSettings<DataTransferServiceSettings> {

  /** Returns the object with the settings used for calls to listMulticloudDataTransferConfigs. */
  public PagedCallSettings<
          ListMulticloudDataTransferConfigsRequest,
          ListMulticloudDataTransferConfigsResponse,
          ListMulticloudDataTransferConfigsPagedResponse>
      listMulticloudDataTransferConfigsSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings())
        .listMulticloudDataTransferConfigsSettings();
  }

  /** Returns the object with the settings used for calls to getMulticloudDataTransferConfig. */
  public UnaryCallSettings<GetMulticloudDataTransferConfigRequest, MulticloudDataTransferConfig>
      getMulticloudDataTransferConfigSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings())
        .getMulticloudDataTransferConfigSettings();
  }

  /** Returns the object with the settings used for calls to createMulticloudDataTransferConfig. */
  public UnaryCallSettings<CreateMulticloudDataTransferConfigRequest, Operation>
      createMulticloudDataTransferConfigSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings())
        .createMulticloudDataTransferConfigSettings();
  }

  /** Returns the object with the settings used for calls to createMulticloudDataTransferConfig. */
  public OperationCallSettings<
          CreateMulticloudDataTransferConfigRequest,
          MulticloudDataTransferConfig,
          OperationMetadata>
      createMulticloudDataTransferConfigOperationSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings())
        .createMulticloudDataTransferConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateMulticloudDataTransferConfig. */
  public UnaryCallSettings<UpdateMulticloudDataTransferConfigRequest, Operation>
      updateMulticloudDataTransferConfigSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings())
        .updateMulticloudDataTransferConfigSettings();
  }

  /** Returns the object with the settings used for calls to updateMulticloudDataTransferConfig. */
  public OperationCallSettings<
          UpdateMulticloudDataTransferConfigRequest,
          MulticloudDataTransferConfig,
          OperationMetadata>
      updateMulticloudDataTransferConfigOperationSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings())
        .updateMulticloudDataTransferConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteMulticloudDataTransferConfig. */
  public UnaryCallSettings<DeleteMulticloudDataTransferConfigRequest, Operation>
      deleteMulticloudDataTransferConfigSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings())
        .deleteMulticloudDataTransferConfigSettings();
  }

  /** Returns the object with the settings used for calls to deleteMulticloudDataTransferConfig. */
  public OperationCallSettings<DeleteMulticloudDataTransferConfigRequest, Empty, OperationMetadata>
      deleteMulticloudDataTransferConfigOperationSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings())
        .deleteMulticloudDataTransferConfigOperationSettings();
  }

  /** Returns the object with the settings used for calls to listDestinations. */
  public PagedCallSettings<
          ListDestinationsRequest, ListDestinationsResponse, ListDestinationsPagedResponse>
      listDestinationsSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).listDestinationsSettings();
  }

  /** Returns the object with the settings used for calls to getDestination. */
  public UnaryCallSettings<GetDestinationRequest, Destination> getDestinationSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).getDestinationSettings();
  }

  /** Returns the object with the settings used for calls to createDestination. */
  public UnaryCallSettings<CreateDestinationRequest, Operation> createDestinationSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).createDestinationSettings();
  }

  /** Returns the object with the settings used for calls to createDestination. */
  public OperationCallSettings<CreateDestinationRequest, Destination, OperationMetadata>
      createDestinationOperationSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings())
        .createDestinationOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateDestination. */
  public UnaryCallSettings<UpdateDestinationRequest, Operation> updateDestinationSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).updateDestinationSettings();
  }

  /** Returns the object with the settings used for calls to updateDestination. */
  public OperationCallSettings<UpdateDestinationRequest, Destination, OperationMetadata>
      updateDestinationOperationSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings())
        .updateDestinationOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteDestination. */
  public UnaryCallSettings<DeleteDestinationRequest, Operation> deleteDestinationSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).deleteDestinationSettings();
  }

  /** Returns the object with the settings used for calls to deleteDestination. */
  public OperationCallSettings<DeleteDestinationRequest, Empty, OperationMetadata>
      deleteDestinationOperationSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings())
        .deleteDestinationOperationSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * getMulticloudDataTransferSupportedService.
   */
  public UnaryCallSettings<
          GetMulticloudDataTransferSupportedServiceRequest, MulticloudDataTransferSupportedService>
      getMulticloudDataTransferSupportedServiceSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings())
        .getMulticloudDataTransferSupportedServiceSettings();
  }

  /**
   * Returns the object with the settings used for calls to
   * listMulticloudDataTransferSupportedServices.
   */
  public PagedCallSettings<
          ListMulticloudDataTransferSupportedServicesRequest,
          ListMulticloudDataTransferSupportedServicesResponse,
          ListMulticloudDataTransferSupportedServicesPagedResponse>
      listMulticloudDataTransferSupportedServicesSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings())
        .listMulticloudDataTransferSupportedServicesSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((DataTransferServiceStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final DataTransferServiceSettings create(DataTransferServiceStubSettings stub)
      throws IOException {
    return new DataTransferServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return DataTransferServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return DataTransferServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DataTransferServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return DataTransferServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return DataTransferServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return DataTransferServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return DataTransferServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected DataTransferServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for DataTransferServiceSettings. */
  public static class Builder extends ClientSettings.Builder<DataTransferServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(DataTransferServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(DataTransferServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(DataTransferServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(DataTransferServiceStubSettings.newBuilder());
    }

    public DataTransferServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((DataTransferServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listMulticloudDataTransferConfigs. */
    public PagedCallSettings.Builder<
            ListMulticloudDataTransferConfigsRequest,
            ListMulticloudDataTransferConfigsResponse,
            ListMulticloudDataTransferConfigsPagedResponse>
        listMulticloudDataTransferConfigsSettings() {
      return getStubSettingsBuilder().listMulticloudDataTransferConfigsSettings();
    }

    /** Returns the builder for the settings used for calls to getMulticloudDataTransferConfig. */
    public UnaryCallSettings.Builder<
            GetMulticloudDataTransferConfigRequest, MulticloudDataTransferConfig>
        getMulticloudDataTransferConfigSettings() {
      return getStubSettingsBuilder().getMulticloudDataTransferConfigSettings();
    }

    /**
     * Returns the builder for the settings used for calls to createMulticloudDataTransferConfig.
     */
    public UnaryCallSettings.Builder<CreateMulticloudDataTransferConfigRequest, Operation>
        createMulticloudDataTransferConfigSettings() {
      return getStubSettingsBuilder().createMulticloudDataTransferConfigSettings();
    }

    /**
     * Returns the builder for the settings used for calls to createMulticloudDataTransferConfig.
     */
    public OperationCallSettings.Builder<
            CreateMulticloudDataTransferConfigRequest,
            MulticloudDataTransferConfig,
            OperationMetadata>
        createMulticloudDataTransferConfigOperationSettings() {
      return getStubSettingsBuilder().createMulticloudDataTransferConfigOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to updateMulticloudDataTransferConfig.
     */
    public UnaryCallSettings.Builder<UpdateMulticloudDataTransferConfigRequest, Operation>
        updateMulticloudDataTransferConfigSettings() {
      return getStubSettingsBuilder().updateMulticloudDataTransferConfigSettings();
    }

    /**
     * Returns the builder for the settings used for calls to updateMulticloudDataTransferConfig.
     */
    public OperationCallSettings.Builder<
            UpdateMulticloudDataTransferConfigRequest,
            MulticloudDataTransferConfig,
            OperationMetadata>
        updateMulticloudDataTransferConfigOperationSettings() {
      return getStubSettingsBuilder().updateMulticloudDataTransferConfigOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to deleteMulticloudDataTransferConfig.
     */
    public UnaryCallSettings.Builder<DeleteMulticloudDataTransferConfigRequest, Operation>
        deleteMulticloudDataTransferConfigSettings() {
      return getStubSettingsBuilder().deleteMulticloudDataTransferConfigSettings();
    }

    /**
     * Returns the builder for the settings used for calls to deleteMulticloudDataTransferConfig.
     */
    public OperationCallSettings.Builder<
            DeleteMulticloudDataTransferConfigRequest, Empty, OperationMetadata>
        deleteMulticloudDataTransferConfigOperationSettings() {
      return getStubSettingsBuilder().deleteMulticloudDataTransferConfigOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listDestinations. */
    public PagedCallSettings.Builder<
            ListDestinationsRequest, ListDestinationsResponse, ListDestinationsPagedResponse>
        listDestinationsSettings() {
      return getStubSettingsBuilder().listDestinationsSettings();
    }

    /** Returns the builder for the settings used for calls to getDestination. */
    public UnaryCallSettings.Builder<GetDestinationRequest, Destination> getDestinationSettings() {
      return getStubSettingsBuilder().getDestinationSettings();
    }

    /** Returns the builder for the settings used for calls to createDestination. */
    public UnaryCallSettings.Builder<CreateDestinationRequest, Operation>
        createDestinationSettings() {
      return getStubSettingsBuilder().createDestinationSettings();
    }

    /** Returns the builder for the settings used for calls to createDestination. */
    public OperationCallSettings.Builder<CreateDestinationRequest, Destination, OperationMetadata>
        createDestinationOperationSettings() {
      return getStubSettingsBuilder().createDestinationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateDestination. */
    public UnaryCallSettings.Builder<UpdateDestinationRequest, Operation>
        updateDestinationSettings() {
      return getStubSettingsBuilder().updateDestinationSettings();
    }

    /** Returns the builder for the settings used for calls to updateDestination. */
    public OperationCallSettings.Builder<UpdateDestinationRequest, Destination, OperationMetadata>
        updateDestinationOperationSettings() {
      return getStubSettingsBuilder().updateDestinationOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDestination. */
    public UnaryCallSettings.Builder<DeleteDestinationRequest, Operation>
        deleteDestinationSettings() {
      return getStubSettingsBuilder().deleteDestinationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteDestination. */
    public OperationCallSettings.Builder<DeleteDestinationRequest, Empty, OperationMetadata>
        deleteDestinationOperationSettings() {
      return getStubSettingsBuilder().deleteDestinationOperationSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * getMulticloudDataTransferSupportedService.
     */
    public UnaryCallSettings.Builder<
            GetMulticloudDataTransferSupportedServiceRequest,
            MulticloudDataTransferSupportedService>
        getMulticloudDataTransferSupportedServiceSettings() {
      return getStubSettingsBuilder().getMulticloudDataTransferSupportedServiceSettings();
    }

    /**
     * Returns the builder for the settings used for calls to
     * listMulticloudDataTransferSupportedServices.
     */
    public PagedCallSettings.Builder<
            ListMulticloudDataTransferSupportedServicesRequest,
            ListMulticloudDataTransferSupportedServicesResponse,
            ListMulticloudDataTransferSupportedServicesPagedResponse>
        listMulticloudDataTransferSupportedServicesSettings() {
      return getStubSettingsBuilder().listMulticloudDataTransferSupportedServicesSettings();
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
    public DataTransferServiceSettings build() throws IOException {
      return new DataTransferServiceSettings(this);
    }
  }
}
