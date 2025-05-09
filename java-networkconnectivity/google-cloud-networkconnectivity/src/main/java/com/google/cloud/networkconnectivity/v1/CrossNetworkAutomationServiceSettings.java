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

import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListLocationsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListServiceClassesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListServiceConnectionMapsPagedResponse;
import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListServiceConnectionPoliciesPagedResponse;
import static com.google.cloud.networkconnectivity.v1.CrossNetworkAutomationServiceClient.ListServiceConnectionTokensPagedResponse;

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
import com.google.cloud.networkconnectivity.v1.stub.CrossNetworkAutomationServiceStubSettings;
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
 * Settings class to configure an instance of {@link CrossNetworkAutomationServiceClient}.
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
 * of getServiceConnectionMap:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CrossNetworkAutomationServiceSettings.Builder crossNetworkAutomationServiceSettingsBuilder =
 *     CrossNetworkAutomationServiceSettings.newBuilder();
 * crossNetworkAutomationServiceSettingsBuilder
 *     .getServiceConnectionMapSettings()
 *     .setRetrySettings(
 *         crossNetworkAutomationServiceSettingsBuilder
 *             .getServiceConnectionMapSettings()
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
 * CrossNetworkAutomationServiceSettings crossNetworkAutomationServiceSettings =
 *     crossNetworkAutomationServiceSettingsBuilder.build();
 * }</pre>
 *
 * Please refer to the [Client Side Retry
 * Guide](https://github.com/googleapis/google-cloud-java/blob/main/docs/client_retries.md) for
 * additional support in setting retries.
 *
 * <p>To configure the RetrySettings of a Long Running Operation method, create an
 * OperationTimedPollAlgorithm object and update the RPC's polling algorithm. For example, to
 * configure the RetrySettings for createServiceConnectionMap:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CrossNetworkAutomationServiceSettings.Builder crossNetworkAutomationServiceSettingsBuilder =
 *     CrossNetworkAutomationServiceSettings.newBuilder();
 * TimedRetryAlgorithm timedRetryAlgorithm =
 *     OperationalTimedPollAlgorithm.create(
 *         RetrySettings.newBuilder()
 *             .setInitialRetryDelayDuration(Duration.ofMillis(500))
 *             .setRetryDelayMultiplier(1.5)
 *             .setMaxRetryDelayDuration(Duration.ofMillis(5000))
 *             .setTotalTimeoutDuration(Duration.ofHours(24))
 *             .build());
 * crossNetworkAutomationServiceSettingsBuilder
 *     .createClusterOperationSettings()
 *     .setPollingAlgorithm(timedRetryAlgorithm)
 *     .build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class CrossNetworkAutomationServiceSettings
    extends ClientSettings<CrossNetworkAutomationServiceSettings> {

  /** Returns the object with the settings used for calls to listServiceConnectionMaps. */
  public PagedCallSettings<
          ListServiceConnectionMapsRequest,
          ListServiceConnectionMapsResponse,
          ListServiceConnectionMapsPagedResponse>
      listServiceConnectionMapsSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .listServiceConnectionMapsSettings();
  }

  /** Returns the object with the settings used for calls to getServiceConnectionMap. */
  public UnaryCallSettings<GetServiceConnectionMapRequest, ServiceConnectionMap>
      getServiceConnectionMapSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .getServiceConnectionMapSettings();
  }

  /** Returns the object with the settings used for calls to createServiceConnectionMap. */
  public UnaryCallSettings<CreateServiceConnectionMapRequest, Operation>
      createServiceConnectionMapSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .createServiceConnectionMapSettings();
  }

  /** Returns the object with the settings used for calls to createServiceConnectionMap. */
  public OperationCallSettings<
          CreateServiceConnectionMapRequest, ServiceConnectionMap, OperationMetadata>
      createServiceConnectionMapOperationSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .createServiceConnectionMapOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateServiceConnectionMap. */
  public UnaryCallSettings<UpdateServiceConnectionMapRequest, Operation>
      updateServiceConnectionMapSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .updateServiceConnectionMapSettings();
  }

  /** Returns the object with the settings used for calls to updateServiceConnectionMap. */
  public OperationCallSettings<
          UpdateServiceConnectionMapRequest, ServiceConnectionMap, OperationMetadata>
      updateServiceConnectionMapOperationSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .updateServiceConnectionMapOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteServiceConnectionMap. */
  public UnaryCallSettings<DeleteServiceConnectionMapRequest, Operation>
      deleteServiceConnectionMapSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .deleteServiceConnectionMapSettings();
  }

  /** Returns the object with the settings used for calls to deleteServiceConnectionMap. */
  public OperationCallSettings<DeleteServiceConnectionMapRequest, Empty, OperationMetadata>
      deleteServiceConnectionMapOperationSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .deleteServiceConnectionMapOperationSettings();
  }

  /** Returns the object with the settings used for calls to listServiceConnectionPolicies. */
  public PagedCallSettings<
          ListServiceConnectionPoliciesRequest,
          ListServiceConnectionPoliciesResponse,
          ListServiceConnectionPoliciesPagedResponse>
      listServiceConnectionPoliciesSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .listServiceConnectionPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to getServiceConnectionPolicy. */
  public UnaryCallSettings<GetServiceConnectionPolicyRequest, ServiceConnectionPolicy>
      getServiceConnectionPolicySettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .getServiceConnectionPolicySettings();
  }

  /** Returns the object with the settings used for calls to createServiceConnectionPolicy. */
  public UnaryCallSettings<CreateServiceConnectionPolicyRequest, Operation>
      createServiceConnectionPolicySettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .createServiceConnectionPolicySettings();
  }

  /** Returns the object with the settings used for calls to createServiceConnectionPolicy. */
  public OperationCallSettings<
          CreateServiceConnectionPolicyRequest, ServiceConnectionPolicy, OperationMetadata>
      createServiceConnectionPolicyOperationSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .createServiceConnectionPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateServiceConnectionPolicy. */
  public UnaryCallSettings<UpdateServiceConnectionPolicyRequest, Operation>
      updateServiceConnectionPolicySettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .updateServiceConnectionPolicySettings();
  }

  /** Returns the object with the settings used for calls to updateServiceConnectionPolicy. */
  public OperationCallSettings<
          UpdateServiceConnectionPolicyRequest, ServiceConnectionPolicy, OperationMetadata>
      updateServiceConnectionPolicyOperationSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .updateServiceConnectionPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteServiceConnectionPolicy. */
  public UnaryCallSettings<DeleteServiceConnectionPolicyRequest, Operation>
      deleteServiceConnectionPolicySettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .deleteServiceConnectionPolicySettings();
  }

  /** Returns the object with the settings used for calls to deleteServiceConnectionPolicy. */
  public OperationCallSettings<DeleteServiceConnectionPolicyRequest, Empty, OperationMetadata>
      deleteServiceConnectionPolicyOperationSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .deleteServiceConnectionPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to listServiceClasses. */
  public PagedCallSettings<
          ListServiceClassesRequest, ListServiceClassesResponse, ListServiceClassesPagedResponse>
      listServiceClassesSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .listServiceClassesSettings();
  }

  /** Returns the object with the settings used for calls to getServiceClass. */
  public UnaryCallSettings<GetServiceClassRequest, ServiceClass> getServiceClassSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .getServiceClassSettings();
  }

  /** Returns the object with the settings used for calls to updateServiceClass. */
  public UnaryCallSettings<UpdateServiceClassRequest, Operation> updateServiceClassSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .updateServiceClassSettings();
  }

  /** Returns the object with the settings used for calls to updateServiceClass. */
  public OperationCallSettings<UpdateServiceClassRequest, ServiceClass, OperationMetadata>
      updateServiceClassOperationSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .updateServiceClassOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteServiceClass. */
  public UnaryCallSettings<DeleteServiceClassRequest, Operation> deleteServiceClassSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .deleteServiceClassSettings();
  }

  /** Returns the object with the settings used for calls to deleteServiceClass. */
  public OperationCallSettings<DeleteServiceClassRequest, Empty, OperationMetadata>
      deleteServiceClassOperationSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .deleteServiceClassOperationSettings();
  }

  /** Returns the object with the settings used for calls to getServiceConnectionToken. */
  public UnaryCallSettings<GetServiceConnectionTokenRequest, ServiceConnectionToken>
      getServiceConnectionTokenSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .getServiceConnectionTokenSettings();
  }

  /** Returns the object with the settings used for calls to listServiceConnectionTokens. */
  public PagedCallSettings<
          ListServiceConnectionTokensRequest,
          ListServiceConnectionTokensResponse,
          ListServiceConnectionTokensPagedResponse>
      listServiceConnectionTokensSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .listServiceConnectionTokensSettings();
  }

  /** Returns the object with the settings used for calls to createServiceConnectionToken. */
  public UnaryCallSettings<CreateServiceConnectionTokenRequest, Operation>
      createServiceConnectionTokenSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .createServiceConnectionTokenSettings();
  }

  /** Returns the object with the settings used for calls to createServiceConnectionToken. */
  public OperationCallSettings<
          CreateServiceConnectionTokenRequest, ServiceConnectionToken, OperationMetadata>
      createServiceConnectionTokenOperationSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .createServiceConnectionTokenOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteServiceConnectionToken. */
  public UnaryCallSettings<DeleteServiceConnectionTokenRequest, Operation>
      deleteServiceConnectionTokenSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .deleteServiceConnectionTokenSettings();
  }

  /** Returns the object with the settings used for calls to deleteServiceConnectionToken. */
  public OperationCallSettings<DeleteServiceConnectionTokenRequest, Empty, OperationMetadata>
      deleteServiceConnectionTokenOperationSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .deleteServiceConnectionTokenOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((CrossNetworkAutomationServiceStubSettings) getStubSettings())
        .testIamPermissionsSettings();
  }

  public static final CrossNetworkAutomationServiceSettings create(
      CrossNetworkAutomationServiceStubSettings stub) throws IOException {
    return new CrossNetworkAutomationServiceSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return CrossNetworkAutomationServiceStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return CrossNetworkAutomationServiceStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return CrossNetworkAutomationServiceStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return CrossNetworkAutomationServiceStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return CrossNetworkAutomationServiceStubSettings.defaultGrpcTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return CrossNetworkAutomationServiceStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return CrossNetworkAutomationServiceStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected CrossNetworkAutomationServiceSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for CrossNetworkAutomationServiceSettings. */
  public static class Builder
      extends ClientSettings.Builder<CrossNetworkAutomationServiceSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(CrossNetworkAutomationServiceStubSettings.newBuilder(clientContext));
    }

    protected Builder(CrossNetworkAutomationServiceSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(CrossNetworkAutomationServiceStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(CrossNetworkAutomationServiceStubSettings.newBuilder());
    }

    public CrossNetworkAutomationServiceStubSettings.Builder getStubSettingsBuilder() {
      return ((CrossNetworkAutomationServiceStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listServiceConnectionMaps. */
    public PagedCallSettings.Builder<
            ListServiceConnectionMapsRequest,
            ListServiceConnectionMapsResponse,
            ListServiceConnectionMapsPagedResponse>
        listServiceConnectionMapsSettings() {
      return getStubSettingsBuilder().listServiceConnectionMapsSettings();
    }

    /** Returns the builder for the settings used for calls to getServiceConnectionMap. */
    public UnaryCallSettings.Builder<GetServiceConnectionMapRequest, ServiceConnectionMap>
        getServiceConnectionMapSettings() {
      return getStubSettingsBuilder().getServiceConnectionMapSettings();
    }

    /** Returns the builder for the settings used for calls to createServiceConnectionMap. */
    public UnaryCallSettings.Builder<CreateServiceConnectionMapRequest, Operation>
        createServiceConnectionMapSettings() {
      return getStubSettingsBuilder().createServiceConnectionMapSettings();
    }

    /** Returns the builder for the settings used for calls to createServiceConnectionMap. */
    public OperationCallSettings.Builder<
            CreateServiceConnectionMapRequest, ServiceConnectionMap, OperationMetadata>
        createServiceConnectionMapOperationSettings() {
      return getStubSettingsBuilder().createServiceConnectionMapOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateServiceConnectionMap. */
    public UnaryCallSettings.Builder<UpdateServiceConnectionMapRequest, Operation>
        updateServiceConnectionMapSettings() {
      return getStubSettingsBuilder().updateServiceConnectionMapSettings();
    }

    /** Returns the builder for the settings used for calls to updateServiceConnectionMap. */
    public OperationCallSettings.Builder<
            UpdateServiceConnectionMapRequest, ServiceConnectionMap, OperationMetadata>
        updateServiceConnectionMapOperationSettings() {
      return getStubSettingsBuilder().updateServiceConnectionMapOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteServiceConnectionMap. */
    public UnaryCallSettings.Builder<DeleteServiceConnectionMapRequest, Operation>
        deleteServiceConnectionMapSettings() {
      return getStubSettingsBuilder().deleteServiceConnectionMapSettings();
    }

    /** Returns the builder for the settings used for calls to deleteServiceConnectionMap. */
    public OperationCallSettings.Builder<
            DeleteServiceConnectionMapRequest, Empty, OperationMetadata>
        deleteServiceConnectionMapOperationSettings() {
      return getStubSettingsBuilder().deleteServiceConnectionMapOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listServiceConnectionPolicies. */
    public PagedCallSettings.Builder<
            ListServiceConnectionPoliciesRequest,
            ListServiceConnectionPoliciesResponse,
            ListServiceConnectionPoliciesPagedResponse>
        listServiceConnectionPoliciesSettings() {
      return getStubSettingsBuilder().listServiceConnectionPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to getServiceConnectionPolicy. */
    public UnaryCallSettings.Builder<GetServiceConnectionPolicyRequest, ServiceConnectionPolicy>
        getServiceConnectionPolicySettings() {
      return getStubSettingsBuilder().getServiceConnectionPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createServiceConnectionPolicy. */
    public UnaryCallSettings.Builder<CreateServiceConnectionPolicyRequest, Operation>
        createServiceConnectionPolicySettings() {
      return getStubSettingsBuilder().createServiceConnectionPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createServiceConnectionPolicy. */
    public OperationCallSettings.Builder<
            CreateServiceConnectionPolicyRequest, ServiceConnectionPolicy, OperationMetadata>
        createServiceConnectionPolicyOperationSettings() {
      return getStubSettingsBuilder().createServiceConnectionPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateServiceConnectionPolicy. */
    public UnaryCallSettings.Builder<UpdateServiceConnectionPolicyRequest, Operation>
        updateServiceConnectionPolicySettings() {
      return getStubSettingsBuilder().updateServiceConnectionPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updateServiceConnectionPolicy. */
    public OperationCallSettings.Builder<
            UpdateServiceConnectionPolicyRequest, ServiceConnectionPolicy, OperationMetadata>
        updateServiceConnectionPolicyOperationSettings() {
      return getStubSettingsBuilder().updateServiceConnectionPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteServiceConnectionPolicy. */
    public UnaryCallSettings.Builder<DeleteServiceConnectionPolicyRequest, Operation>
        deleteServiceConnectionPolicySettings() {
      return getStubSettingsBuilder().deleteServiceConnectionPolicySettings();
    }

    /** Returns the builder for the settings used for calls to deleteServiceConnectionPolicy. */
    public OperationCallSettings.Builder<
            DeleteServiceConnectionPolicyRequest, Empty, OperationMetadata>
        deleteServiceConnectionPolicyOperationSettings() {
      return getStubSettingsBuilder().deleteServiceConnectionPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listServiceClasses. */
    public PagedCallSettings.Builder<
            ListServiceClassesRequest, ListServiceClassesResponse, ListServiceClassesPagedResponse>
        listServiceClassesSettings() {
      return getStubSettingsBuilder().listServiceClassesSettings();
    }

    /** Returns the builder for the settings used for calls to getServiceClass. */
    public UnaryCallSettings.Builder<GetServiceClassRequest, ServiceClass>
        getServiceClassSettings() {
      return getStubSettingsBuilder().getServiceClassSettings();
    }

    /** Returns the builder for the settings used for calls to updateServiceClass. */
    public UnaryCallSettings.Builder<UpdateServiceClassRequest, Operation>
        updateServiceClassSettings() {
      return getStubSettingsBuilder().updateServiceClassSettings();
    }

    /** Returns the builder for the settings used for calls to updateServiceClass. */
    public OperationCallSettings.Builder<UpdateServiceClassRequest, ServiceClass, OperationMetadata>
        updateServiceClassOperationSettings() {
      return getStubSettingsBuilder().updateServiceClassOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteServiceClass. */
    public UnaryCallSettings.Builder<DeleteServiceClassRequest, Operation>
        deleteServiceClassSettings() {
      return getStubSettingsBuilder().deleteServiceClassSettings();
    }

    /** Returns the builder for the settings used for calls to deleteServiceClass. */
    public OperationCallSettings.Builder<DeleteServiceClassRequest, Empty, OperationMetadata>
        deleteServiceClassOperationSettings() {
      return getStubSettingsBuilder().deleteServiceClassOperationSettings();
    }

    /** Returns the builder for the settings used for calls to getServiceConnectionToken. */
    public UnaryCallSettings.Builder<GetServiceConnectionTokenRequest, ServiceConnectionToken>
        getServiceConnectionTokenSettings() {
      return getStubSettingsBuilder().getServiceConnectionTokenSettings();
    }

    /** Returns the builder for the settings used for calls to listServiceConnectionTokens. */
    public PagedCallSettings.Builder<
            ListServiceConnectionTokensRequest,
            ListServiceConnectionTokensResponse,
            ListServiceConnectionTokensPagedResponse>
        listServiceConnectionTokensSettings() {
      return getStubSettingsBuilder().listServiceConnectionTokensSettings();
    }

    /** Returns the builder for the settings used for calls to createServiceConnectionToken. */
    public UnaryCallSettings.Builder<CreateServiceConnectionTokenRequest, Operation>
        createServiceConnectionTokenSettings() {
      return getStubSettingsBuilder().createServiceConnectionTokenSettings();
    }

    /** Returns the builder for the settings used for calls to createServiceConnectionToken. */
    public OperationCallSettings.Builder<
            CreateServiceConnectionTokenRequest, ServiceConnectionToken, OperationMetadata>
        createServiceConnectionTokenOperationSettings() {
      return getStubSettingsBuilder().createServiceConnectionTokenOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteServiceConnectionToken. */
    public UnaryCallSettings.Builder<DeleteServiceConnectionTokenRequest, Operation>
        deleteServiceConnectionTokenSettings() {
      return getStubSettingsBuilder().deleteServiceConnectionTokenSettings();
    }

    /** Returns the builder for the settings used for calls to deleteServiceConnectionToken. */
    public OperationCallSettings.Builder<
            DeleteServiceConnectionTokenRequest, Empty, OperationMetadata>
        deleteServiceConnectionTokenOperationSettings() {
      return getStubSettingsBuilder().deleteServiceConnectionTokenOperationSettings();
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
    public CrossNetworkAutomationServiceSettings build() throws IOException {
      return new CrossNetworkAutomationServiceSettings(this);
    }
  }
}
