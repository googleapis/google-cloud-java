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

package com.google.cloud.networkservices.v1;

import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListEndpointPoliciesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListGatewaysPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListGrpcRoutesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListHttpRoutesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListLocationsPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListMeshesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListServiceBindingsPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListTcpRoutesPagedResponse;
import static com.google.cloud.networkservices.v1.NetworkServicesClient.ListTlsRoutesPagedResponse;

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
import com.google.cloud.networkservices.v1.stub.NetworkServicesStubSettings;
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
 * Settings class to configure an instance of {@link NetworkServicesClient}.
 *
 * <p>The default instance has everything set to sensible defaults:
 *
 * <ul>
 *   <li>The default service address (networkservices.googleapis.com) and default port (443) are
 *       used.
 *   <li>Credentials are acquired automatically through Application Default Credentials.
 *   <li>Retries are configured for idempotent methods but not for non-idempotent methods.
 * </ul>
 *
 * <p>The builder of this class is recursive, so contained classes are themselves builders. When
 * build() is called, the tree of builders is called to create the complete settings object.
 *
 * <p>For example, to set the total timeout of getEndpointPolicy to 30 seconds:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NetworkServicesSettings.Builder networkServicesSettingsBuilder =
 *     NetworkServicesSettings.newBuilder();
 * networkServicesSettingsBuilder
 *     .getEndpointPolicySettings()
 *     .setRetrySettings(
 *         networkServicesSettingsBuilder
 *             .getEndpointPolicySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * NetworkServicesSettings networkServicesSettings = networkServicesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class NetworkServicesSettings extends ClientSettings<NetworkServicesSettings> {

  /** Returns the object with the settings used for calls to listEndpointPolicies. */
  public PagedCallSettings<
          ListEndpointPoliciesRequest,
          ListEndpointPoliciesResponse,
          ListEndpointPoliciesPagedResponse>
      listEndpointPoliciesSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).listEndpointPoliciesSettings();
  }

  /** Returns the object with the settings used for calls to getEndpointPolicy. */
  public UnaryCallSettings<GetEndpointPolicyRequest, EndpointPolicy> getEndpointPolicySettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).getEndpointPolicySettings();
  }

  /** Returns the object with the settings used for calls to createEndpointPolicy. */
  public UnaryCallSettings<CreateEndpointPolicyRequest, Operation> createEndpointPolicySettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).createEndpointPolicySettings();
  }

  /** Returns the object with the settings used for calls to createEndpointPolicy. */
  public OperationCallSettings<CreateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      createEndpointPolicyOperationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings())
        .createEndpointPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateEndpointPolicy. */
  public UnaryCallSettings<UpdateEndpointPolicyRequest, Operation> updateEndpointPolicySettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).updateEndpointPolicySettings();
  }

  /** Returns the object with the settings used for calls to updateEndpointPolicy. */
  public OperationCallSettings<UpdateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      updateEndpointPolicyOperationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings())
        .updateEndpointPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteEndpointPolicy. */
  public UnaryCallSettings<DeleteEndpointPolicyRequest, Operation> deleteEndpointPolicySettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).deleteEndpointPolicySettings();
  }

  /** Returns the object with the settings used for calls to deleteEndpointPolicy. */
  public OperationCallSettings<DeleteEndpointPolicyRequest, Empty, OperationMetadata>
      deleteEndpointPolicyOperationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings())
        .deleteEndpointPolicyOperationSettings();
  }

  /** Returns the object with the settings used for calls to listGateways. */
  public PagedCallSettings<ListGatewaysRequest, ListGatewaysResponse, ListGatewaysPagedResponse>
      listGatewaysSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).listGatewaysSettings();
  }

  /** Returns the object with the settings used for calls to getGateway. */
  public UnaryCallSettings<GetGatewayRequest, Gateway> getGatewaySettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).getGatewaySettings();
  }

  /** Returns the object with the settings used for calls to createGateway. */
  public UnaryCallSettings<CreateGatewayRequest, Operation> createGatewaySettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).createGatewaySettings();
  }

  /** Returns the object with the settings used for calls to createGateway. */
  public OperationCallSettings<CreateGatewayRequest, Gateway, OperationMetadata>
      createGatewayOperationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).createGatewayOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateGateway. */
  public UnaryCallSettings<UpdateGatewayRequest, Operation> updateGatewaySettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).updateGatewaySettings();
  }

  /** Returns the object with the settings used for calls to updateGateway. */
  public OperationCallSettings<UpdateGatewayRequest, Gateway, OperationMetadata>
      updateGatewayOperationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).updateGatewayOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteGateway. */
  public UnaryCallSettings<DeleteGatewayRequest, Operation> deleteGatewaySettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).deleteGatewaySettings();
  }

  /** Returns the object with the settings used for calls to deleteGateway. */
  public OperationCallSettings<DeleteGatewayRequest, Empty, OperationMetadata>
      deleteGatewayOperationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).deleteGatewayOperationSettings();
  }

  /** Returns the object with the settings used for calls to listGrpcRoutes. */
  public PagedCallSettings<
          ListGrpcRoutesRequest, ListGrpcRoutesResponse, ListGrpcRoutesPagedResponse>
      listGrpcRoutesSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).listGrpcRoutesSettings();
  }

  /** Returns the object with the settings used for calls to getGrpcRoute. */
  public UnaryCallSettings<GetGrpcRouteRequest, GrpcRoute> getGrpcRouteSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).getGrpcRouteSettings();
  }

  /** Returns the object with the settings used for calls to createGrpcRoute. */
  public UnaryCallSettings<CreateGrpcRouteRequest, Operation> createGrpcRouteSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).createGrpcRouteSettings();
  }

  /** Returns the object with the settings used for calls to createGrpcRoute. */
  public OperationCallSettings<CreateGrpcRouteRequest, GrpcRoute, OperationMetadata>
      createGrpcRouteOperationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).createGrpcRouteOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateGrpcRoute. */
  public UnaryCallSettings<UpdateGrpcRouteRequest, Operation> updateGrpcRouteSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).updateGrpcRouteSettings();
  }

  /** Returns the object with the settings used for calls to updateGrpcRoute. */
  public OperationCallSettings<UpdateGrpcRouteRequest, GrpcRoute, OperationMetadata>
      updateGrpcRouteOperationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).updateGrpcRouteOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteGrpcRoute. */
  public UnaryCallSettings<DeleteGrpcRouteRequest, Operation> deleteGrpcRouteSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).deleteGrpcRouteSettings();
  }

  /** Returns the object with the settings used for calls to deleteGrpcRoute. */
  public OperationCallSettings<DeleteGrpcRouteRequest, Empty, OperationMetadata>
      deleteGrpcRouteOperationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).deleteGrpcRouteOperationSettings();
  }

  /** Returns the object with the settings used for calls to listHttpRoutes. */
  public PagedCallSettings<
          ListHttpRoutesRequest, ListHttpRoutesResponse, ListHttpRoutesPagedResponse>
      listHttpRoutesSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).listHttpRoutesSettings();
  }

  /** Returns the object with the settings used for calls to getHttpRoute. */
  public UnaryCallSettings<GetHttpRouteRequest, HttpRoute> getHttpRouteSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).getHttpRouteSettings();
  }

  /** Returns the object with the settings used for calls to createHttpRoute. */
  public UnaryCallSettings<CreateHttpRouteRequest, Operation> createHttpRouteSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).createHttpRouteSettings();
  }

  /** Returns the object with the settings used for calls to createHttpRoute. */
  public OperationCallSettings<CreateHttpRouteRequest, HttpRoute, OperationMetadata>
      createHttpRouteOperationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).createHttpRouteOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateHttpRoute. */
  public UnaryCallSettings<UpdateHttpRouteRequest, Operation> updateHttpRouteSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).updateHttpRouteSettings();
  }

  /** Returns the object with the settings used for calls to updateHttpRoute. */
  public OperationCallSettings<UpdateHttpRouteRequest, HttpRoute, OperationMetadata>
      updateHttpRouteOperationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).updateHttpRouteOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteHttpRoute. */
  public UnaryCallSettings<DeleteHttpRouteRequest, Operation> deleteHttpRouteSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).deleteHttpRouteSettings();
  }

  /** Returns the object with the settings used for calls to deleteHttpRoute. */
  public OperationCallSettings<DeleteHttpRouteRequest, Empty, OperationMetadata>
      deleteHttpRouteOperationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).deleteHttpRouteOperationSettings();
  }

  /** Returns the object with the settings used for calls to listTcpRoutes. */
  public PagedCallSettings<ListTcpRoutesRequest, ListTcpRoutesResponse, ListTcpRoutesPagedResponse>
      listTcpRoutesSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).listTcpRoutesSettings();
  }

  /** Returns the object with the settings used for calls to getTcpRoute. */
  public UnaryCallSettings<GetTcpRouteRequest, TcpRoute> getTcpRouteSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).getTcpRouteSettings();
  }

  /** Returns the object with the settings used for calls to createTcpRoute. */
  public UnaryCallSettings<CreateTcpRouteRequest, Operation> createTcpRouteSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).createTcpRouteSettings();
  }

  /** Returns the object with the settings used for calls to createTcpRoute. */
  public OperationCallSettings<CreateTcpRouteRequest, TcpRoute, OperationMetadata>
      createTcpRouteOperationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).createTcpRouteOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateTcpRoute. */
  public UnaryCallSettings<UpdateTcpRouteRequest, Operation> updateTcpRouteSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).updateTcpRouteSettings();
  }

  /** Returns the object with the settings used for calls to updateTcpRoute. */
  public OperationCallSettings<UpdateTcpRouteRequest, TcpRoute, OperationMetadata>
      updateTcpRouteOperationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).updateTcpRouteOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteTcpRoute. */
  public UnaryCallSettings<DeleteTcpRouteRequest, Operation> deleteTcpRouteSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).deleteTcpRouteSettings();
  }

  /** Returns the object with the settings used for calls to deleteTcpRoute. */
  public OperationCallSettings<DeleteTcpRouteRequest, Empty, OperationMetadata>
      deleteTcpRouteOperationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).deleteTcpRouteOperationSettings();
  }

  /** Returns the object with the settings used for calls to listTlsRoutes. */
  public PagedCallSettings<ListTlsRoutesRequest, ListTlsRoutesResponse, ListTlsRoutesPagedResponse>
      listTlsRoutesSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).listTlsRoutesSettings();
  }

  /** Returns the object with the settings used for calls to getTlsRoute. */
  public UnaryCallSettings<GetTlsRouteRequest, TlsRoute> getTlsRouteSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).getTlsRouteSettings();
  }

  /** Returns the object with the settings used for calls to createTlsRoute. */
  public UnaryCallSettings<CreateTlsRouteRequest, Operation> createTlsRouteSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).createTlsRouteSettings();
  }

  /** Returns the object with the settings used for calls to createTlsRoute. */
  public OperationCallSettings<CreateTlsRouteRequest, TlsRoute, OperationMetadata>
      createTlsRouteOperationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).createTlsRouteOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateTlsRoute. */
  public UnaryCallSettings<UpdateTlsRouteRequest, Operation> updateTlsRouteSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).updateTlsRouteSettings();
  }

  /** Returns the object with the settings used for calls to updateTlsRoute. */
  public OperationCallSettings<UpdateTlsRouteRequest, TlsRoute, OperationMetadata>
      updateTlsRouteOperationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).updateTlsRouteOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteTlsRoute. */
  public UnaryCallSettings<DeleteTlsRouteRequest, Operation> deleteTlsRouteSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).deleteTlsRouteSettings();
  }

  /** Returns the object with the settings used for calls to deleteTlsRoute. */
  public OperationCallSettings<DeleteTlsRouteRequest, Empty, OperationMetadata>
      deleteTlsRouteOperationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).deleteTlsRouteOperationSettings();
  }

  /** Returns the object with the settings used for calls to listServiceBindings. */
  public PagedCallSettings<
          ListServiceBindingsRequest, ListServiceBindingsResponse, ListServiceBindingsPagedResponse>
      listServiceBindingsSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).listServiceBindingsSettings();
  }

  /** Returns the object with the settings used for calls to getServiceBinding. */
  public UnaryCallSettings<GetServiceBindingRequest, ServiceBinding> getServiceBindingSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).getServiceBindingSettings();
  }

  /** Returns the object with the settings used for calls to createServiceBinding. */
  public UnaryCallSettings<CreateServiceBindingRequest, Operation> createServiceBindingSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).createServiceBindingSettings();
  }

  /** Returns the object with the settings used for calls to createServiceBinding. */
  public OperationCallSettings<CreateServiceBindingRequest, ServiceBinding, OperationMetadata>
      createServiceBindingOperationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings())
        .createServiceBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteServiceBinding. */
  public UnaryCallSettings<DeleteServiceBindingRequest, Operation> deleteServiceBindingSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).deleteServiceBindingSettings();
  }

  /** Returns the object with the settings used for calls to deleteServiceBinding. */
  public OperationCallSettings<DeleteServiceBindingRequest, Empty, OperationMetadata>
      deleteServiceBindingOperationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings())
        .deleteServiceBindingOperationSettings();
  }

  /** Returns the object with the settings used for calls to listMeshes. */
  public PagedCallSettings<ListMeshesRequest, ListMeshesResponse, ListMeshesPagedResponse>
      listMeshesSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).listMeshesSettings();
  }

  /** Returns the object with the settings used for calls to getMesh. */
  public UnaryCallSettings<GetMeshRequest, Mesh> getMeshSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).getMeshSettings();
  }

  /** Returns the object with the settings used for calls to createMesh. */
  public UnaryCallSettings<CreateMeshRequest, Operation> createMeshSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).createMeshSettings();
  }

  /** Returns the object with the settings used for calls to createMesh. */
  public OperationCallSettings<CreateMeshRequest, Mesh, OperationMetadata>
      createMeshOperationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).createMeshOperationSettings();
  }

  /** Returns the object with the settings used for calls to updateMesh. */
  public UnaryCallSettings<UpdateMeshRequest, Operation> updateMeshSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).updateMeshSettings();
  }

  /** Returns the object with the settings used for calls to updateMesh. */
  public OperationCallSettings<UpdateMeshRequest, Mesh, OperationMetadata>
      updateMeshOperationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).updateMeshOperationSettings();
  }

  /** Returns the object with the settings used for calls to deleteMesh. */
  public UnaryCallSettings<DeleteMeshRequest, Operation> deleteMeshSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).deleteMeshSettings();
  }

  /** Returns the object with the settings used for calls to deleteMesh. */
  public OperationCallSettings<DeleteMeshRequest, Empty, OperationMetadata>
      deleteMeshOperationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).deleteMeshOperationSettings();
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).listLocationsSettings();
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).getLocationSettings();
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).setIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).getIamPolicySettings();
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return ((NetworkServicesStubSettings) getStubSettings()).testIamPermissionsSettings();
  }

  public static final NetworkServicesSettings create(NetworkServicesStubSettings stub)
      throws IOException {
    return new NetworkServicesSettings.Builder(stub.toBuilder()).build();
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return NetworkServicesStubSettings.defaultExecutorProviderBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return NetworkServicesStubSettings.getDefaultEndpoint();
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return NetworkServicesStubSettings.getDefaultServiceScopes();
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return NetworkServicesStubSettings.defaultCredentialsProviderBuilder();
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return NetworkServicesStubSettings.defaultGrpcTransportProviderBuilder();
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return NetworkServicesStubSettings.defaultHttpJsonTransportProviderBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return NetworkServicesStubSettings.defaultTransportChannelProvider();
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NetworkServicesStubSettings.defaultApiClientHeaderProviderBuilder();
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

  protected NetworkServicesSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);
  }

  /** Builder for NetworkServicesSettings. */
  public static class Builder extends ClientSettings.Builder<NetworkServicesSettings, Builder> {

    protected Builder() throws IOException {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(NetworkServicesStubSettings.newBuilder(clientContext));
    }

    protected Builder(NetworkServicesSettings settings) {
      super(settings.getStubSettings().toBuilder());
    }

    protected Builder(NetworkServicesStubSettings.Builder stubSettings) {
      super(stubSettings);
    }

    private static Builder createDefault() {
      return new Builder(NetworkServicesStubSettings.newBuilder());
    }

    private static Builder createHttpJsonDefault() {
      return new Builder(NetworkServicesStubSettings.newHttpJsonBuilder());
    }

    public NetworkServicesStubSettings.Builder getStubSettingsBuilder() {
      return ((NetworkServicesStubSettings.Builder) getStubSettings());
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

    /** Returns the builder for the settings used for calls to listEndpointPolicies. */
    public PagedCallSettings.Builder<
            ListEndpointPoliciesRequest,
            ListEndpointPoliciesResponse,
            ListEndpointPoliciesPagedResponse>
        listEndpointPoliciesSettings() {
      return getStubSettingsBuilder().listEndpointPoliciesSettings();
    }

    /** Returns the builder for the settings used for calls to getEndpointPolicy. */
    public UnaryCallSettings.Builder<GetEndpointPolicyRequest, EndpointPolicy>
        getEndpointPolicySettings() {
      return getStubSettingsBuilder().getEndpointPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createEndpointPolicy. */
    public UnaryCallSettings.Builder<CreateEndpointPolicyRequest, Operation>
        createEndpointPolicySettings() {
      return getStubSettingsBuilder().createEndpointPolicySettings();
    }

    /** Returns the builder for the settings used for calls to createEndpointPolicy. */
    public OperationCallSettings.Builder<
            CreateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
        createEndpointPolicyOperationSettings() {
      return getStubSettingsBuilder().createEndpointPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateEndpointPolicy. */
    public UnaryCallSettings.Builder<UpdateEndpointPolicyRequest, Operation>
        updateEndpointPolicySettings() {
      return getStubSettingsBuilder().updateEndpointPolicySettings();
    }

    /** Returns the builder for the settings used for calls to updateEndpointPolicy. */
    public OperationCallSettings.Builder<
            UpdateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
        updateEndpointPolicyOperationSettings() {
      return getStubSettingsBuilder().updateEndpointPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteEndpointPolicy. */
    public UnaryCallSettings.Builder<DeleteEndpointPolicyRequest, Operation>
        deleteEndpointPolicySettings() {
      return getStubSettingsBuilder().deleteEndpointPolicySettings();
    }

    /** Returns the builder for the settings used for calls to deleteEndpointPolicy. */
    public OperationCallSettings.Builder<DeleteEndpointPolicyRequest, Empty, OperationMetadata>
        deleteEndpointPolicyOperationSettings() {
      return getStubSettingsBuilder().deleteEndpointPolicyOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listGateways. */
    public PagedCallSettings.Builder<
            ListGatewaysRequest, ListGatewaysResponse, ListGatewaysPagedResponse>
        listGatewaysSettings() {
      return getStubSettingsBuilder().listGatewaysSettings();
    }

    /** Returns the builder for the settings used for calls to getGateway. */
    public UnaryCallSettings.Builder<GetGatewayRequest, Gateway> getGatewaySettings() {
      return getStubSettingsBuilder().getGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to createGateway. */
    public UnaryCallSettings.Builder<CreateGatewayRequest, Operation> createGatewaySettings() {
      return getStubSettingsBuilder().createGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to createGateway. */
    public OperationCallSettings.Builder<CreateGatewayRequest, Gateway, OperationMetadata>
        createGatewayOperationSettings() {
      return getStubSettingsBuilder().createGatewayOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateGateway. */
    public UnaryCallSettings.Builder<UpdateGatewayRequest, Operation> updateGatewaySettings() {
      return getStubSettingsBuilder().updateGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to updateGateway. */
    public OperationCallSettings.Builder<UpdateGatewayRequest, Gateway, OperationMetadata>
        updateGatewayOperationSettings() {
      return getStubSettingsBuilder().updateGatewayOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGateway. */
    public UnaryCallSettings.Builder<DeleteGatewayRequest, Operation> deleteGatewaySettings() {
      return getStubSettingsBuilder().deleteGatewaySettings();
    }

    /** Returns the builder for the settings used for calls to deleteGateway. */
    public OperationCallSettings.Builder<DeleteGatewayRequest, Empty, OperationMetadata>
        deleteGatewayOperationSettings() {
      return getStubSettingsBuilder().deleteGatewayOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listGrpcRoutes. */
    public PagedCallSettings.Builder<
            ListGrpcRoutesRequest, ListGrpcRoutesResponse, ListGrpcRoutesPagedResponse>
        listGrpcRoutesSettings() {
      return getStubSettingsBuilder().listGrpcRoutesSettings();
    }

    /** Returns the builder for the settings used for calls to getGrpcRoute. */
    public UnaryCallSettings.Builder<GetGrpcRouteRequest, GrpcRoute> getGrpcRouteSettings() {
      return getStubSettingsBuilder().getGrpcRouteSettings();
    }

    /** Returns the builder for the settings used for calls to createGrpcRoute. */
    public UnaryCallSettings.Builder<CreateGrpcRouteRequest, Operation> createGrpcRouteSettings() {
      return getStubSettingsBuilder().createGrpcRouteSettings();
    }

    /** Returns the builder for the settings used for calls to createGrpcRoute. */
    public OperationCallSettings.Builder<CreateGrpcRouteRequest, GrpcRoute, OperationMetadata>
        createGrpcRouteOperationSettings() {
      return getStubSettingsBuilder().createGrpcRouteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateGrpcRoute. */
    public UnaryCallSettings.Builder<UpdateGrpcRouteRequest, Operation> updateGrpcRouteSettings() {
      return getStubSettingsBuilder().updateGrpcRouteSettings();
    }

    /** Returns the builder for the settings used for calls to updateGrpcRoute. */
    public OperationCallSettings.Builder<UpdateGrpcRouteRequest, GrpcRoute, OperationMetadata>
        updateGrpcRouteOperationSettings() {
      return getStubSettingsBuilder().updateGrpcRouteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGrpcRoute. */
    public UnaryCallSettings.Builder<DeleteGrpcRouteRequest, Operation> deleteGrpcRouteSettings() {
      return getStubSettingsBuilder().deleteGrpcRouteSettings();
    }

    /** Returns the builder for the settings used for calls to deleteGrpcRoute. */
    public OperationCallSettings.Builder<DeleteGrpcRouteRequest, Empty, OperationMetadata>
        deleteGrpcRouteOperationSettings() {
      return getStubSettingsBuilder().deleteGrpcRouteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listHttpRoutes. */
    public PagedCallSettings.Builder<
            ListHttpRoutesRequest, ListHttpRoutesResponse, ListHttpRoutesPagedResponse>
        listHttpRoutesSettings() {
      return getStubSettingsBuilder().listHttpRoutesSettings();
    }

    /** Returns the builder for the settings used for calls to getHttpRoute. */
    public UnaryCallSettings.Builder<GetHttpRouteRequest, HttpRoute> getHttpRouteSettings() {
      return getStubSettingsBuilder().getHttpRouteSettings();
    }

    /** Returns the builder for the settings used for calls to createHttpRoute. */
    public UnaryCallSettings.Builder<CreateHttpRouteRequest, Operation> createHttpRouteSettings() {
      return getStubSettingsBuilder().createHttpRouteSettings();
    }

    /** Returns the builder for the settings used for calls to createHttpRoute. */
    public OperationCallSettings.Builder<CreateHttpRouteRequest, HttpRoute, OperationMetadata>
        createHttpRouteOperationSettings() {
      return getStubSettingsBuilder().createHttpRouteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateHttpRoute. */
    public UnaryCallSettings.Builder<UpdateHttpRouteRequest, Operation> updateHttpRouteSettings() {
      return getStubSettingsBuilder().updateHttpRouteSettings();
    }

    /** Returns the builder for the settings used for calls to updateHttpRoute. */
    public OperationCallSettings.Builder<UpdateHttpRouteRequest, HttpRoute, OperationMetadata>
        updateHttpRouteOperationSettings() {
      return getStubSettingsBuilder().updateHttpRouteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteHttpRoute. */
    public UnaryCallSettings.Builder<DeleteHttpRouteRequest, Operation> deleteHttpRouteSettings() {
      return getStubSettingsBuilder().deleteHttpRouteSettings();
    }

    /** Returns the builder for the settings used for calls to deleteHttpRoute. */
    public OperationCallSettings.Builder<DeleteHttpRouteRequest, Empty, OperationMetadata>
        deleteHttpRouteOperationSettings() {
      return getStubSettingsBuilder().deleteHttpRouteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listTcpRoutes. */
    public PagedCallSettings.Builder<
            ListTcpRoutesRequest, ListTcpRoutesResponse, ListTcpRoutesPagedResponse>
        listTcpRoutesSettings() {
      return getStubSettingsBuilder().listTcpRoutesSettings();
    }

    /** Returns the builder for the settings used for calls to getTcpRoute. */
    public UnaryCallSettings.Builder<GetTcpRouteRequest, TcpRoute> getTcpRouteSettings() {
      return getStubSettingsBuilder().getTcpRouteSettings();
    }

    /** Returns the builder for the settings used for calls to createTcpRoute. */
    public UnaryCallSettings.Builder<CreateTcpRouteRequest, Operation> createTcpRouteSettings() {
      return getStubSettingsBuilder().createTcpRouteSettings();
    }

    /** Returns the builder for the settings used for calls to createTcpRoute. */
    public OperationCallSettings.Builder<CreateTcpRouteRequest, TcpRoute, OperationMetadata>
        createTcpRouteOperationSettings() {
      return getStubSettingsBuilder().createTcpRouteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateTcpRoute. */
    public UnaryCallSettings.Builder<UpdateTcpRouteRequest, Operation> updateTcpRouteSettings() {
      return getStubSettingsBuilder().updateTcpRouteSettings();
    }

    /** Returns the builder for the settings used for calls to updateTcpRoute. */
    public OperationCallSettings.Builder<UpdateTcpRouteRequest, TcpRoute, OperationMetadata>
        updateTcpRouteOperationSettings() {
      return getStubSettingsBuilder().updateTcpRouteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTcpRoute. */
    public UnaryCallSettings.Builder<DeleteTcpRouteRequest, Operation> deleteTcpRouteSettings() {
      return getStubSettingsBuilder().deleteTcpRouteSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTcpRoute. */
    public OperationCallSettings.Builder<DeleteTcpRouteRequest, Empty, OperationMetadata>
        deleteTcpRouteOperationSettings() {
      return getStubSettingsBuilder().deleteTcpRouteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listTlsRoutes. */
    public PagedCallSettings.Builder<
            ListTlsRoutesRequest, ListTlsRoutesResponse, ListTlsRoutesPagedResponse>
        listTlsRoutesSettings() {
      return getStubSettingsBuilder().listTlsRoutesSettings();
    }

    /** Returns the builder for the settings used for calls to getTlsRoute. */
    public UnaryCallSettings.Builder<GetTlsRouteRequest, TlsRoute> getTlsRouteSettings() {
      return getStubSettingsBuilder().getTlsRouteSettings();
    }

    /** Returns the builder for the settings used for calls to createTlsRoute. */
    public UnaryCallSettings.Builder<CreateTlsRouteRequest, Operation> createTlsRouteSettings() {
      return getStubSettingsBuilder().createTlsRouteSettings();
    }

    /** Returns the builder for the settings used for calls to createTlsRoute. */
    public OperationCallSettings.Builder<CreateTlsRouteRequest, TlsRoute, OperationMetadata>
        createTlsRouteOperationSettings() {
      return getStubSettingsBuilder().createTlsRouteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateTlsRoute. */
    public UnaryCallSettings.Builder<UpdateTlsRouteRequest, Operation> updateTlsRouteSettings() {
      return getStubSettingsBuilder().updateTlsRouteSettings();
    }

    /** Returns the builder for the settings used for calls to updateTlsRoute. */
    public OperationCallSettings.Builder<UpdateTlsRouteRequest, TlsRoute, OperationMetadata>
        updateTlsRouteOperationSettings() {
      return getStubSettingsBuilder().updateTlsRouteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTlsRoute. */
    public UnaryCallSettings.Builder<DeleteTlsRouteRequest, Operation> deleteTlsRouteSettings() {
      return getStubSettingsBuilder().deleteTlsRouteSettings();
    }

    /** Returns the builder for the settings used for calls to deleteTlsRoute. */
    public OperationCallSettings.Builder<DeleteTlsRouteRequest, Empty, OperationMetadata>
        deleteTlsRouteOperationSettings() {
      return getStubSettingsBuilder().deleteTlsRouteOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listServiceBindings. */
    public PagedCallSettings.Builder<
            ListServiceBindingsRequest,
            ListServiceBindingsResponse,
            ListServiceBindingsPagedResponse>
        listServiceBindingsSettings() {
      return getStubSettingsBuilder().listServiceBindingsSettings();
    }

    /** Returns the builder for the settings used for calls to getServiceBinding. */
    public UnaryCallSettings.Builder<GetServiceBindingRequest, ServiceBinding>
        getServiceBindingSettings() {
      return getStubSettingsBuilder().getServiceBindingSettings();
    }

    /** Returns the builder for the settings used for calls to createServiceBinding. */
    public UnaryCallSettings.Builder<CreateServiceBindingRequest, Operation>
        createServiceBindingSettings() {
      return getStubSettingsBuilder().createServiceBindingSettings();
    }

    /** Returns the builder for the settings used for calls to createServiceBinding. */
    public OperationCallSettings.Builder<
            CreateServiceBindingRequest, ServiceBinding, OperationMetadata>
        createServiceBindingOperationSettings() {
      return getStubSettingsBuilder().createServiceBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteServiceBinding. */
    public UnaryCallSettings.Builder<DeleteServiceBindingRequest, Operation>
        deleteServiceBindingSettings() {
      return getStubSettingsBuilder().deleteServiceBindingSettings();
    }

    /** Returns the builder for the settings used for calls to deleteServiceBinding. */
    public OperationCallSettings.Builder<DeleteServiceBindingRequest, Empty, OperationMetadata>
        deleteServiceBindingOperationSettings() {
      return getStubSettingsBuilder().deleteServiceBindingOperationSettings();
    }

    /** Returns the builder for the settings used for calls to listMeshes. */
    public PagedCallSettings.Builder<ListMeshesRequest, ListMeshesResponse, ListMeshesPagedResponse>
        listMeshesSettings() {
      return getStubSettingsBuilder().listMeshesSettings();
    }

    /** Returns the builder for the settings used for calls to getMesh. */
    public UnaryCallSettings.Builder<GetMeshRequest, Mesh> getMeshSettings() {
      return getStubSettingsBuilder().getMeshSettings();
    }

    /** Returns the builder for the settings used for calls to createMesh. */
    public UnaryCallSettings.Builder<CreateMeshRequest, Operation> createMeshSettings() {
      return getStubSettingsBuilder().createMeshSettings();
    }

    /** Returns the builder for the settings used for calls to createMesh. */
    public OperationCallSettings.Builder<CreateMeshRequest, Mesh, OperationMetadata>
        createMeshOperationSettings() {
      return getStubSettingsBuilder().createMeshOperationSettings();
    }

    /** Returns the builder for the settings used for calls to updateMesh. */
    public UnaryCallSettings.Builder<UpdateMeshRequest, Operation> updateMeshSettings() {
      return getStubSettingsBuilder().updateMeshSettings();
    }

    /** Returns the builder for the settings used for calls to updateMesh. */
    public OperationCallSettings.Builder<UpdateMeshRequest, Mesh, OperationMetadata>
        updateMeshOperationSettings() {
      return getStubSettingsBuilder().updateMeshOperationSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMesh. */
    public UnaryCallSettings.Builder<DeleteMeshRequest, Operation> deleteMeshSettings() {
      return getStubSettingsBuilder().deleteMeshSettings();
    }

    /** Returns the builder for the settings used for calls to deleteMesh. */
    public OperationCallSettings.Builder<DeleteMeshRequest, Empty, OperationMetadata>
        deleteMeshOperationSettings() {
      return getStubSettingsBuilder().deleteMeshOperationSettings();
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
    public NetworkServicesSettings build() throws IOException {
      return new NetworkServicesSettings(this);
    }
  }
}
