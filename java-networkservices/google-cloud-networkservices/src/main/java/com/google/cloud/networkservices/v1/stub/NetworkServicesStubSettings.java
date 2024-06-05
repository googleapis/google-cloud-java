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

package com.google.cloud.networkservices.v1.stub;

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
import com.google.api.core.ApiFuture;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.GaxProperties;
import com.google.api.gax.core.GoogleCredentialsProvider;
import com.google.api.gax.core.InstantiatingExecutorProvider;
import com.google.api.gax.grpc.GaxGrpcProperties;
import com.google.api.gax.grpc.GrpcTransportChannel;
import com.google.api.gax.grpc.InstantiatingGrpcChannelProvider;
import com.google.api.gax.grpc.ProtoOperationTransformers;
import com.google.api.gax.httpjson.GaxHttpJsonProperties;
import com.google.api.gax.httpjson.HttpJsonTransportChannel;
import com.google.api.gax.httpjson.InstantiatingHttpJsonChannelProvider;
import com.google.api.gax.longrunning.OperationSnapshot;
import com.google.api.gax.longrunning.OperationTimedPollAlgorithm;
import com.google.api.gax.retrying.RetrySettings;
import com.google.api.gax.rpc.ApiCallContext;
import com.google.api.gax.rpc.ApiClientHeaderProvider;
import com.google.api.gax.rpc.ClientContext;
import com.google.api.gax.rpc.OperationCallSettings;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.PagedCallSettings;
import com.google.api.gax.rpc.PagedListDescriptor;
import com.google.api.gax.rpc.PagedListResponseFactory;
import com.google.api.gax.rpc.StatusCode;
import com.google.api.gax.rpc.StubSettings;
import com.google.api.gax.rpc.TransportChannelProvider;
import com.google.api.gax.rpc.UnaryCallSettings;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networkservices.v1.CreateEndpointPolicyRequest;
import com.google.cloud.networkservices.v1.CreateGatewayRequest;
import com.google.cloud.networkservices.v1.CreateGrpcRouteRequest;
import com.google.cloud.networkservices.v1.CreateHttpRouteRequest;
import com.google.cloud.networkservices.v1.CreateMeshRequest;
import com.google.cloud.networkservices.v1.CreateServiceBindingRequest;
import com.google.cloud.networkservices.v1.CreateTcpRouteRequest;
import com.google.cloud.networkservices.v1.CreateTlsRouteRequest;
import com.google.cloud.networkservices.v1.DeleteEndpointPolicyRequest;
import com.google.cloud.networkservices.v1.DeleteGatewayRequest;
import com.google.cloud.networkservices.v1.DeleteGrpcRouteRequest;
import com.google.cloud.networkservices.v1.DeleteHttpRouteRequest;
import com.google.cloud.networkservices.v1.DeleteMeshRequest;
import com.google.cloud.networkservices.v1.DeleteServiceBindingRequest;
import com.google.cloud.networkservices.v1.DeleteTcpRouteRequest;
import com.google.cloud.networkservices.v1.DeleteTlsRouteRequest;
import com.google.cloud.networkservices.v1.EndpointPolicy;
import com.google.cloud.networkservices.v1.Gateway;
import com.google.cloud.networkservices.v1.GetEndpointPolicyRequest;
import com.google.cloud.networkservices.v1.GetGatewayRequest;
import com.google.cloud.networkservices.v1.GetGrpcRouteRequest;
import com.google.cloud.networkservices.v1.GetHttpRouteRequest;
import com.google.cloud.networkservices.v1.GetMeshRequest;
import com.google.cloud.networkservices.v1.GetServiceBindingRequest;
import com.google.cloud.networkservices.v1.GetTcpRouteRequest;
import com.google.cloud.networkservices.v1.GetTlsRouteRequest;
import com.google.cloud.networkservices.v1.GrpcRoute;
import com.google.cloud.networkservices.v1.HttpRoute;
import com.google.cloud.networkservices.v1.ListEndpointPoliciesRequest;
import com.google.cloud.networkservices.v1.ListEndpointPoliciesResponse;
import com.google.cloud.networkservices.v1.ListGatewaysRequest;
import com.google.cloud.networkservices.v1.ListGatewaysResponse;
import com.google.cloud.networkservices.v1.ListGrpcRoutesRequest;
import com.google.cloud.networkservices.v1.ListGrpcRoutesResponse;
import com.google.cloud.networkservices.v1.ListHttpRoutesRequest;
import com.google.cloud.networkservices.v1.ListHttpRoutesResponse;
import com.google.cloud.networkservices.v1.ListMeshesRequest;
import com.google.cloud.networkservices.v1.ListMeshesResponse;
import com.google.cloud.networkservices.v1.ListServiceBindingsRequest;
import com.google.cloud.networkservices.v1.ListServiceBindingsResponse;
import com.google.cloud.networkservices.v1.ListTcpRoutesRequest;
import com.google.cloud.networkservices.v1.ListTcpRoutesResponse;
import com.google.cloud.networkservices.v1.ListTlsRoutesRequest;
import com.google.cloud.networkservices.v1.ListTlsRoutesResponse;
import com.google.cloud.networkservices.v1.Mesh;
import com.google.cloud.networkservices.v1.OperationMetadata;
import com.google.cloud.networkservices.v1.ServiceBinding;
import com.google.cloud.networkservices.v1.TcpRoute;
import com.google.cloud.networkservices.v1.TlsRoute;
import com.google.cloud.networkservices.v1.UpdateEndpointPolicyRequest;
import com.google.cloud.networkservices.v1.UpdateGatewayRequest;
import com.google.cloud.networkservices.v1.UpdateGrpcRouteRequest;
import com.google.cloud.networkservices.v1.UpdateHttpRouteRequest;
import com.google.cloud.networkservices.v1.UpdateMeshRequest;
import com.google.cloud.networkservices.v1.UpdateTcpRouteRequest;
import com.google.cloud.networkservices.v1.UpdateTlsRouteRequest;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.Lists;
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
import org.threeten.bp.Duration;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Settings class to configure an instance of {@link NetworkServicesStub}.
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
 * NetworkServicesStubSettings.Builder networkServicesSettingsBuilder =
 *     NetworkServicesStubSettings.newBuilder();
 * networkServicesSettingsBuilder
 *     .getEndpointPolicySettings()
 *     .setRetrySettings(
 *         networkServicesSettingsBuilder
 *             .getEndpointPolicySettings()
 *             .getRetrySettings()
 *             .toBuilder()
 *             .setTotalTimeout(Duration.ofSeconds(30))
 *             .build());
 * NetworkServicesStubSettings networkServicesSettings = networkServicesSettingsBuilder.build();
 * }</pre>
 */
@Generated("by gapic-generator-java")
public class NetworkServicesStubSettings extends StubSettings<NetworkServicesStubSettings> {
  /** The default scopes of the service. */
  private static final ImmutableList<String> DEFAULT_SERVICE_SCOPES =
      ImmutableList.<String>builder().add("https://www.googleapis.com/auth/cloud-platform").build();

  private final PagedCallSettings<
          ListEndpointPoliciesRequest,
          ListEndpointPoliciesResponse,
          ListEndpointPoliciesPagedResponse>
      listEndpointPoliciesSettings;
  private final UnaryCallSettings<GetEndpointPolicyRequest, EndpointPolicy>
      getEndpointPolicySettings;
  private final UnaryCallSettings<CreateEndpointPolicyRequest, Operation>
      createEndpointPolicySettings;
  private final OperationCallSettings<
          CreateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      createEndpointPolicyOperationSettings;
  private final UnaryCallSettings<UpdateEndpointPolicyRequest, Operation>
      updateEndpointPolicySettings;
  private final OperationCallSettings<
          UpdateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      updateEndpointPolicyOperationSettings;
  private final UnaryCallSettings<DeleteEndpointPolicyRequest, Operation>
      deleteEndpointPolicySettings;
  private final OperationCallSettings<DeleteEndpointPolicyRequest, Empty, OperationMetadata>
      deleteEndpointPolicyOperationSettings;
  private final PagedCallSettings<
          ListGatewaysRequest, ListGatewaysResponse, ListGatewaysPagedResponse>
      listGatewaysSettings;
  private final UnaryCallSettings<GetGatewayRequest, Gateway> getGatewaySettings;
  private final UnaryCallSettings<CreateGatewayRequest, Operation> createGatewaySettings;
  private final OperationCallSettings<CreateGatewayRequest, Gateway, OperationMetadata>
      createGatewayOperationSettings;
  private final UnaryCallSettings<UpdateGatewayRequest, Operation> updateGatewaySettings;
  private final OperationCallSettings<UpdateGatewayRequest, Gateway, OperationMetadata>
      updateGatewayOperationSettings;
  private final UnaryCallSettings<DeleteGatewayRequest, Operation> deleteGatewaySettings;
  private final OperationCallSettings<DeleteGatewayRequest, Empty, OperationMetadata>
      deleteGatewayOperationSettings;
  private final PagedCallSettings<
          ListGrpcRoutesRequest, ListGrpcRoutesResponse, ListGrpcRoutesPagedResponse>
      listGrpcRoutesSettings;
  private final UnaryCallSettings<GetGrpcRouteRequest, GrpcRoute> getGrpcRouteSettings;
  private final UnaryCallSettings<CreateGrpcRouteRequest, Operation> createGrpcRouteSettings;
  private final OperationCallSettings<CreateGrpcRouteRequest, GrpcRoute, OperationMetadata>
      createGrpcRouteOperationSettings;
  private final UnaryCallSettings<UpdateGrpcRouteRequest, Operation> updateGrpcRouteSettings;
  private final OperationCallSettings<UpdateGrpcRouteRequest, GrpcRoute, OperationMetadata>
      updateGrpcRouteOperationSettings;
  private final UnaryCallSettings<DeleteGrpcRouteRequest, Operation> deleteGrpcRouteSettings;
  private final OperationCallSettings<DeleteGrpcRouteRequest, Empty, OperationMetadata>
      deleteGrpcRouteOperationSettings;
  private final PagedCallSettings<
          ListHttpRoutesRequest, ListHttpRoutesResponse, ListHttpRoutesPagedResponse>
      listHttpRoutesSettings;
  private final UnaryCallSettings<GetHttpRouteRequest, HttpRoute> getHttpRouteSettings;
  private final UnaryCallSettings<CreateHttpRouteRequest, Operation> createHttpRouteSettings;
  private final OperationCallSettings<CreateHttpRouteRequest, HttpRoute, OperationMetadata>
      createHttpRouteOperationSettings;
  private final UnaryCallSettings<UpdateHttpRouteRequest, Operation> updateHttpRouteSettings;
  private final OperationCallSettings<UpdateHttpRouteRequest, HttpRoute, OperationMetadata>
      updateHttpRouteOperationSettings;
  private final UnaryCallSettings<DeleteHttpRouteRequest, Operation> deleteHttpRouteSettings;
  private final OperationCallSettings<DeleteHttpRouteRequest, Empty, OperationMetadata>
      deleteHttpRouteOperationSettings;
  private final PagedCallSettings<
          ListTcpRoutesRequest, ListTcpRoutesResponse, ListTcpRoutesPagedResponse>
      listTcpRoutesSettings;
  private final UnaryCallSettings<GetTcpRouteRequest, TcpRoute> getTcpRouteSettings;
  private final UnaryCallSettings<CreateTcpRouteRequest, Operation> createTcpRouteSettings;
  private final OperationCallSettings<CreateTcpRouteRequest, TcpRoute, OperationMetadata>
      createTcpRouteOperationSettings;
  private final UnaryCallSettings<UpdateTcpRouteRequest, Operation> updateTcpRouteSettings;
  private final OperationCallSettings<UpdateTcpRouteRequest, TcpRoute, OperationMetadata>
      updateTcpRouteOperationSettings;
  private final UnaryCallSettings<DeleteTcpRouteRequest, Operation> deleteTcpRouteSettings;
  private final OperationCallSettings<DeleteTcpRouteRequest, Empty, OperationMetadata>
      deleteTcpRouteOperationSettings;
  private final PagedCallSettings<
          ListTlsRoutesRequest, ListTlsRoutesResponse, ListTlsRoutesPagedResponse>
      listTlsRoutesSettings;
  private final UnaryCallSettings<GetTlsRouteRequest, TlsRoute> getTlsRouteSettings;
  private final UnaryCallSettings<CreateTlsRouteRequest, Operation> createTlsRouteSettings;
  private final OperationCallSettings<CreateTlsRouteRequest, TlsRoute, OperationMetadata>
      createTlsRouteOperationSettings;
  private final UnaryCallSettings<UpdateTlsRouteRequest, Operation> updateTlsRouteSettings;
  private final OperationCallSettings<UpdateTlsRouteRequest, TlsRoute, OperationMetadata>
      updateTlsRouteOperationSettings;
  private final UnaryCallSettings<DeleteTlsRouteRequest, Operation> deleteTlsRouteSettings;
  private final OperationCallSettings<DeleteTlsRouteRequest, Empty, OperationMetadata>
      deleteTlsRouteOperationSettings;
  private final PagedCallSettings<
          ListServiceBindingsRequest, ListServiceBindingsResponse, ListServiceBindingsPagedResponse>
      listServiceBindingsSettings;
  private final UnaryCallSettings<GetServiceBindingRequest, ServiceBinding>
      getServiceBindingSettings;
  private final UnaryCallSettings<CreateServiceBindingRequest, Operation>
      createServiceBindingSettings;
  private final OperationCallSettings<
          CreateServiceBindingRequest, ServiceBinding, OperationMetadata>
      createServiceBindingOperationSettings;
  private final UnaryCallSettings<DeleteServiceBindingRequest, Operation>
      deleteServiceBindingSettings;
  private final OperationCallSettings<DeleteServiceBindingRequest, Empty, OperationMetadata>
      deleteServiceBindingOperationSettings;
  private final PagedCallSettings<ListMeshesRequest, ListMeshesResponse, ListMeshesPagedResponse>
      listMeshesSettings;
  private final UnaryCallSettings<GetMeshRequest, Mesh> getMeshSettings;
  private final UnaryCallSettings<CreateMeshRequest, Operation> createMeshSettings;
  private final OperationCallSettings<CreateMeshRequest, Mesh, OperationMetadata>
      createMeshOperationSettings;
  private final UnaryCallSettings<UpdateMeshRequest, Operation> updateMeshSettings;
  private final OperationCallSettings<UpdateMeshRequest, Mesh, OperationMetadata>
      updateMeshOperationSettings;
  private final UnaryCallSettings<DeleteMeshRequest, Operation> deleteMeshSettings;
  private final OperationCallSettings<DeleteMeshRequest, Empty, OperationMetadata>
      deleteMeshOperationSettings;
  private final PagedCallSettings<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings;
  private final UnaryCallSettings<GetLocationRequest, Location> getLocationSettings;
  private final UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings;
  private final UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings;
  private final UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings;

  private static final PagedListDescriptor<
          ListEndpointPoliciesRequest, ListEndpointPoliciesResponse, EndpointPolicy>
      LIST_ENDPOINT_POLICIES_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListEndpointPoliciesRequest, ListEndpointPoliciesResponse, EndpointPolicy>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListEndpointPoliciesRequest injectToken(
                ListEndpointPoliciesRequest payload, String token) {
              return ListEndpointPoliciesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListEndpointPoliciesRequest injectPageSize(
                ListEndpointPoliciesRequest payload, int pageSize) {
              return ListEndpointPoliciesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListEndpointPoliciesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListEndpointPoliciesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<EndpointPolicy> extractResources(ListEndpointPoliciesResponse payload) {
              return payload.getEndpointPoliciesList() == null
                  ? ImmutableList.<EndpointPolicy>of()
                  : payload.getEndpointPoliciesList();
            }
          };

  private static final PagedListDescriptor<ListGatewaysRequest, ListGatewaysResponse, Gateway>
      LIST_GATEWAYS_PAGE_STR_DESC =
          new PagedListDescriptor<ListGatewaysRequest, ListGatewaysResponse, Gateway>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGatewaysRequest injectToken(ListGatewaysRequest payload, String token) {
              return ListGatewaysRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListGatewaysRequest injectPageSize(ListGatewaysRequest payload, int pageSize) {
              return ListGatewaysRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListGatewaysRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGatewaysResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Gateway> extractResources(ListGatewaysResponse payload) {
              return payload.getGatewaysList() == null
                  ? ImmutableList.<Gateway>of()
                  : payload.getGatewaysList();
            }
          };

  private static final PagedListDescriptor<ListGrpcRoutesRequest, ListGrpcRoutesResponse, GrpcRoute>
      LIST_GRPC_ROUTES_PAGE_STR_DESC =
          new PagedListDescriptor<ListGrpcRoutesRequest, ListGrpcRoutesResponse, GrpcRoute>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListGrpcRoutesRequest injectToken(ListGrpcRoutesRequest payload, String token) {
              return ListGrpcRoutesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListGrpcRoutesRequest injectPageSize(
                ListGrpcRoutesRequest payload, int pageSize) {
              return ListGrpcRoutesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListGrpcRoutesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListGrpcRoutesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<GrpcRoute> extractResources(ListGrpcRoutesResponse payload) {
              return payload.getGrpcRoutesList() == null
                  ? ImmutableList.<GrpcRoute>of()
                  : payload.getGrpcRoutesList();
            }
          };

  private static final PagedListDescriptor<ListHttpRoutesRequest, ListHttpRoutesResponse, HttpRoute>
      LIST_HTTP_ROUTES_PAGE_STR_DESC =
          new PagedListDescriptor<ListHttpRoutesRequest, ListHttpRoutesResponse, HttpRoute>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListHttpRoutesRequest injectToken(ListHttpRoutesRequest payload, String token) {
              return ListHttpRoutesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListHttpRoutesRequest injectPageSize(
                ListHttpRoutesRequest payload, int pageSize) {
              return ListHttpRoutesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListHttpRoutesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListHttpRoutesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<HttpRoute> extractResources(ListHttpRoutesResponse payload) {
              return payload.getHttpRoutesList() == null
                  ? ImmutableList.<HttpRoute>of()
                  : payload.getHttpRoutesList();
            }
          };

  private static final PagedListDescriptor<ListTcpRoutesRequest, ListTcpRoutesResponse, TcpRoute>
      LIST_TCP_ROUTES_PAGE_STR_DESC =
          new PagedListDescriptor<ListTcpRoutesRequest, ListTcpRoutesResponse, TcpRoute>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTcpRoutesRequest injectToken(ListTcpRoutesRequest payload, String token) {
              return ListTcpRoutesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTcpRoutesRequest injectPageSize(ListTcpRoutesRequest payload, int pageSize) {
              return ListTcpRoutesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTcpRoutesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTcpRoutesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TcpRoute> extractResources(ListTcpRoutesResponse payload) {
              return payload.getTcpRoutesList() == null
                  ? ImmutableList.<TcpRoute>of()
                  : payload.getTcpRoutesList();
            }
          };

  private static final PagedListDescriptor<ListTlsRoutesRequest, ListTlsRoutesResponse, TlsRoute>
      LIST_TLS_ROUTES_PAGE_STR_DESC =
          new PagedListDescriptor<ListTlsRoutesRequest, ListTlsRoutesResponse, TlsRoute>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListTlsRoutesRequest injectToken(ListTlsRoutesRequest payload, String token) {
              return ListTlsRoutesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListTlsRoutesRequest injectPageSize(ListTlsRoutesRequest payload, int pageSize) {
              return ListTlsRoutesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListTlsRoutesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListTlsRoutesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<TlsRoute> extractResources(ListTlsRoutesResponse payload) {
              return payload.getTlsRoutesList() == null
                  ? ImmutableList.<TlsRoute>of()
                  : payload.getTlsRoutesList();
            }
          };

  private static final PagedListDescriptor<
          ListServiceBindingsRequest, ListServiceBindingsResponse, ServiceBinding>
      LIST_SERVICE_BINDINGS_PAGE_STR_DESC =
          new PagedListDescriptor<
              ListServiceBindingsRequest, ListServiceBindingsResponse, ServiceBinding>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListServiceBindingsRequest injectToken(
                ListServiceBindingsRequest payload, String token) {
              return ListServiceBindingsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListServiceBindingsRequest injectPageSize(
                ListServiceBindingsRequest payload, int pageSize) {
              return ListServiceBindingsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListServiceBindingsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListServiceBindingsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<ServiceBinding> extractResources(ListServiceBindingsResponse payload) {
              return payload.getServiceBindingsList() == null
                  ? ImmutableList.<ServiceBinding>of()
                  : payload.getServiceBindingsList();
            }
          };

  private static final PagedListDescriptor<ListMeshesRequest, ListMeshesResponse, Mesh>
      LIST_MESHES_PAGE_STR_DESC =
          new PagedListDescriptor<ListMeshesRequest, ListMeshesResponse, Mesh>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListMeshesRequest injectToken(ListMeshesRequest payload, String token) {
              return ListMeshesRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListMeshesRequest injectPageSize(ListMeshesRequest payload, int pageSize) {
              return ListMeshesRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListMeshesRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListMeshesResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Mesh> extractResources(ListMeshesResponse payload) {
              return payload.getMeshesList() == null
                  ? ImmutableList.<Mesh>of()
                  : payload.getMeshesList();
            }
          };

  private static final PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>
      LIST_LOCATIONS_PAGE_STR_DESC =
          new PagedListDescriptor<ListLocationsRequest, ListLocationsResponse, Location>() {
            @Override
            public String emptyToken() {
              return "";
            }

            @Override
            public ListLocationsRequest injectToken(ListLocationsRequest payload, String token) {
              return ListLocationsRequest.newBuilder(payload).setPageToken(token).build();
            }

            @Override
            public ListLocationsRequest injectPageSize(ListLocationsRequest payload, int pageSize) {
              return ListLocationsRequest.newBuilder(payload).setPageSize(pageSize).build();
            }

            @Override
            public Integer extractPageSize(ListLocationsRequest payload) {
              return payload.getPageSize();
            }

            @Override
            public String extractNextToken(ListLocationsResponse payload) {
              return payload.getNextPageToken();
            }

            @Override
            public Iterable<Location> extractResources(ListLocationsResponse payload) {
              return payload.getLocationsList() == null
                  ? ImmutableList.<Location>of()
                  : payload.getLocationsList();
            }
          };

  private static final PagedListResponseFactory<
          ListEndpointPoliciesRequest,
          ListEndpointPoliciesResponse,
          ListEndpointPoliciesPagedResponse>
      LIST_ENDPOINT_POLICIES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListEndpointPoliciesRequest,
              ListEndpointPoliciesResponse,
              ListEndpointPoliciesPagedResponse>() {
            @Override
            public ApiFuture<ListEndpointPoliciesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse> callable,
                ListEndpointPoliciesRequest request,
                ApiCallContext context,
                ApiFuture<ListEndpointPoliciesResponse> futureResponse) {
              PageContext<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse, EndpointPolicy>
                  pageContext =
                      PageContext.create(
                          callable, LIST_ENDPOINT_POLICIES_PAGE_STR_DESC, request, context);
              return ListEndpointPoliciesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListGatewaysRequest, ListGatewaysResponse, ListGatewaysPagedResponse>
      LIST_GATEWAYS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGatewaysRequest, ListGatewaysResponse, ListGatewaysPagedResponse>() {
            @Override
            public ApiFuture<ListGatewaysPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGatewaysRequest, ListGatewaysResponse> callable,
                ListGatewaysRequest request,
                ApiCallContext context,
                ApiFuture<ListGatewaysResponse> futureResponse) {
              PageContext<ListGatewaysRequest, ListGatewaysResponse, Gateway> pageContext =
                  PageContext.create(callable, LIST_GATEWAYS_PAGE_STR_DESC, request, context);
              return ListGatewaysPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListGrpcRoutesRequest, ListGrpcRoutesResponse, ListGrpcRoutesPagedResponse>
      LIST_GRPC_ROUTES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListGrpcRoutesRequest, ListGrpcRoutesResponse, ListGrpcRoutesPagedResponse>() {
            @Override
            public ApiFuture<ListGrpcRoutesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListGrpcRoutesRequest, ListGrpcRoutesResponse> callable,
                ListGrpcRoutesRequest request,
                ApiCallContext context,
                ApiFuture<ListGrpcRoutesResponse> futureResponse) {
              PageContext<ListGrpcRoutesRequest, ListGrpcRoutesResponse, GrpcRoute> pageContext =
                  PageContext.create(callable, LIST_GRPC_ROUTES_PAGE_STR_DESC, request, context);
              return ListGrpcRoutesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListHttpRoutesRequest, ListHttpRoutesResponse, ListHttpRoutesPagedResponse>
      LIST_HTTP_ROUTES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListHttpRoutesRequest, ListHttpRoutesResponse, ListHttpRoutesPagedResponse>() {
            @Override
            public ApiFuture<ListHttpRoutesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListHttpRoutesRequest, ListHttpRoutesResponse> callable,
                ListHttpRoutesRequest request,
                ApiCallContext context,
                ApiFuture<ListHttpRoutesResponse> futureResponse) {
              PageContext<ListHttpRoutesRequest, ListHttpRoutesResponse, HttpRoute> pageContext =
                  PageContext.create(callable, LIST_HTTP_ROUTES_PAGE_STR_DESC, request, context);
              return ListHttpRoutesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTcpRoutesRequest, ListTcpRoutesResponse, ListTcpRoutesPagedResponse>
      LIST_TCP_ROUTES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTcpRoutesRequest, ListTcpRoutesResponse, ListTcpRoutesPagedResponse>() {
            @Override
            public ApiFuture<ListTcpRoutesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTcpRoutesRequest, ListTcpRoutesResponse> callable,
                ListTcpRoutesRequest request,
                ApiCallContext context,
                ApiFuture<ListTcpRoutesResponse> futureResponse) {
              PageContext<ListTcpRoutesRequest, ListTcpRoutesResponse, TcpRoute> pageContext =
                  PageContext.create(callable, LIST_TCP_ROUTES_PAGE_STR_DESC, request, context);
              return ListTcpRoutesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListTlsRoutesRequest, ListTlsRoutesResponse, ListTlsRoutesPagedResponse>
      LIST_TLS_ROUTES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListTlsRoutesRequest, ListTlsRoutesResponse, ListTlsRoutesPagedResponse>() {
            @Override
            public ApiFuture<ListTlsRoutesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListTlsRoutesRequest, ListTlsRoutesResponse> callable,
                ListTlsRoutesRequest request,
                ApiCallContext context,
                ApiFuture<ListTlsRoutesResponse> futureResponse) {
              PageContext<ListTlsRoutesRequest, ListTlsRoutesResponse, TlsRoute> pageContext =
                  PageContext.create(callable, LIST_TLS_ROUTES_PAGE_STR_DESC, request, context);
              return ListTlsRoutesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListServiceBindingsRequest, ListServiceBindingsResponse, ListServiceBindingsPagedResponse>
      LIST_SERVICE_BINDINGS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListServiceBindingsRequest,
              ListServiceBindingsResponse,
              ListServiceBindingsPagedResponse>() {
            @Override
            public ApiFuture<ListServiceBindingsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListServiceBindingsRequest, ListServiceBindingsResponse> callable,
                ListServiceBindingsRequest request,
                ApiCallContext context,
                ApiFuture<ListServiceBindingsResponse> futureResponse) {
              PageContext<ListServiceBindingsRequest, ListServiceBindingsResponse, ServiceBinding>
                  pageContext =
                      PageContext.create(
                          callable, LIST_SERVICE_BINDINGS_PAGE_STR_DESC, request, context);
              return ListServiceBindingsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListMeshesRequest, ListMeshesResponse, ListMeshesPagedResponse>
      LIST_MESHES_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListMeshesRequest, ListMeshesResponse, ListMeshesPagedResponse>() {
            @Override
            public ApiFuture<ListMeshesPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListMeshesRequest, ListMeshesResponse> callable,
                ListMeshesRequest request,
                ApiCallContext context,
                ApiFuture<ListMeshesResponse> futureResponse) {
              PageContext<ListMeshesRequest, ListMeshesResponse, Mesh> pageContext =
                  PageContext.create(callable, LIST_MESHES_PAGE_STR_DESC, request, context);
              return ListMeshesPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  private static final PagedListResponseFactory<
          ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      LIST_LOCATIONS_PAGE_STR_FACT =
          new PagedListResponseFactory<
              ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>() {
            @Override
            public ApiFuture<ListLocationsPagedResponse> getFuturePagedResponse(
                UnaryCallable<ListLocationsRequest, ListLocationsResponse> callable,
                ListLocationsRequest request,
                ApiCallContext context,
                ApiFuture<ListLocationsResponse> futureResponse) {
              PageContext<ListLocationsRequest, ListLocationsResponse, Location> pageContext =
                  PageContext.create(callable, LIST_LOCATIONS_PAGE_STR_DESC, request, context);
              return ListLocationsPagedResponse.createAsync(pageContext, futureResponse);
            }
          };

  /** Returns the object with the settings used for calls to listEndpointPolicies. */
  public PagedCallSettings<
          ListEndpointPoliciesRequest,
          ListEndpointPoliciesResponse,
          ListEndpointPoliciesPagedResponse>
      listEndpointPoliciesSettings() {
    return listEndpointPoliciesSettings;
  }

  /** Returns the object with the settings used for calls to getEndpointPolicy. */
  public UnaryCallSettings<GetEndpointPolicyRequest, EndpointPolicy> getEndpointPolicySettings() {
    return getEndpointPolicySettings;
  }

  /** Returns the object with the settings used for calls to createEndpointPolicy. */
  public UnaryCallSettings<CreateEndpointPolicyRequest, Operation> createEndpointPolicySettings() {
    return createEndpointPolicySettings;
  }

  /** Returns the object with the settings used for calls to createEndpointPolicy. */
  public OperationCallSettings<CreateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      createEndpointPolicyOperationSettings() {
    return createEndpointPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateEndpointPolicy. */
  public UnaryCallSettings<UpdateEndpointPolicyRequest, Operation> updateEndpointPolicySettings() {
    return updateEndpointPolicySettings;
  }

  /** Returns the object with the settings used for calls to updateEndpointPolicy. */
  public OperationCallSettings<UpdateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      updateEndpointPolicyOperationSettings() {
    return updateEndpointPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteEndpointPolicy. */
  public UnaryCallSettings<DeleteEndpointPolicyRequest, Operation> deleteEndpointPolicySettings() {
    return deleteEndpointPolicySettings;
  }

  /** Returns the object with the settings used for calls to deleteEndpointPolicy. */
  public OperationCallSettings<DeleteEndpointPolicyRequest, Empty, OperationMetadata>
      deleteEndpointPolicyOperationSettings() {
    return deleteEndpointPolicyOperationSettings;
  }

  /** Returns the object with the settings used for calls to listGateways. */
  public PagedCallSettings<ListGatewaysRequest, ListGatewaysResponse, ListGatewaysPagedResponse>
      listGatewaysSettings() {
    return listGatewaysSettings;
  }

  /** Returns the object with the settings used for calls to getGateway. */
  public UnaryCallSettings<GetGatewayRequest, Gateway> getGatewaySettings() {
    return getGatewaySettings;
  }

  /** Returns the object with the settings used for calls to createGateway. */
  public UnaryCallSettings<CreateGatewayRequest, Operation> createGatewaySettings() {
    return createGatewaySettings;
  }

  /** Returns the object with the settings used for calls to createGateway. */
  public OperationCallSettings<CreateGatewayRequest, Gateway, OperationMetadata>
      createGatewayOperationSettings() {
    return createGatewayOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateGateway. */
  public UnaryCallSettings<UpdateGatewayRequest, Operation> updateGatewaySettings() {
    return updateGatewaySettings;
  }

  /** Returns the object with the settings used for calls to updateGateway. */
  public OperationCallSettings<UpdateGatewayRequest, Gateway, OperationMetadata>
      updateGatewayOperationSettings() {
    return updateGatewayOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteGateway. */
  public UnaryCallSettings<DeleteGatewayRequest, Operation> deleteGatewaySettings() {
    return deleteGatewaySettings;
  }

  /** Returns the object with the settings used for calls to deleteGateway. */
  public OperationCallSettings<DeleteGatewayRequest, Empty, OperationMetadata>
      deleteGatewayOperationSettings() {
    return deleteGatewayOperationSettings;
  }

  /** Returns the object with the settings used for calls to listGrpcRoutes. */
  public PagedCallSettings<
          ListGrpcRoutesRequest, ListGrpcRoutesResponse, ListGrpcRoutesPagedResponse>
      listGrpcRoutesSettings() {
    return listGrpcRoutesSettings;
  }

  /** Returns the object with the settings used for calls to getGrpcRoute. */
  public UnaryCallSettings<GetGrpcRouteRequest, GrpcRoute> getGrpcRouteSettings() {
    return getGrpcRouteSettings;
  }

  /** Returns the object with the settings used for calls to createGrpcRoute. */
  public UnaryCallSettings<CreateGrpcRouteRequest, Operation> createGrpcRouteSettings() {
    return createGrpcRouteSettings;
  }

  /** Returns the object with the settings used for calls to createGrpcRoute. */
  public OperationCallSettings<CreateGrpcRouteRequest, GrpcRoute, OperationMetadata>
      createGrpcRouteOperationSettings() {
    return createGrpcRouteOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateGrpcRoute. */
  public UnaryCallSettings<UpdateGrpcRouteRequest, Operation> updateGrpcRouteSettings() {
    return updateGrpcRouteSettings;
  }

  /** Returns the object with the settings used for calls to updateGrpcRoute. */
  public OperationCallSettings<UpdateGrpcRouteRequest, GrpcRoute, OperationMetadata>
      updateGrpcRouteOperationSettings() {
    return updateGrpcRouteOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteGrpcRoute. */
  public UnaryCallSettings<DeleteGrpcRouteRequest, Operation> deleteGrpcRouteSettings() {
    return deleteGrpcRouteSettings;
  }

  /** Returns the object with the settings used for calls to deleteGrpcRoute. */
  public OperationCallSettings<DeleteGrpcRouteRequest, Empty, OperationMetadata>
      deleteGrpcRouteOperationSettings() {
    return deleteGrpcRouteOperationSettings;
  }

  /** Returns the object with the settings used for calls to listHttpRoutes. */
  public PagedCallSettings<
          ListHttpRoutesRequest, ListHttpRoutesResponse, ListHttpRoutesPagedResponse>
      listHttpRoutesSettings() {
    return listHttpRoutesSettings;
  }

  /** Returns the object with the settings used for calls to getHttpRoute. */
  public UnaryCallSettings<GetHttpRouteRequest, HttpRoute> getHttpRouteSettings() {
    return getHttpRouteSettings;
  }

  /** Returns the object with the settings used for calls to createHttpRoute. */
  public UnaryCallSettings<CreateHttpRouteRequest, Operation> createHttpRouteSettings() {
    return createHttpRouteSettings;
  }

  /** Returns the object with the settings used for calls to createHttpRoute. */
  public OperationCallSettings<CreateHttpRouteRequest, HttpRoute, OperationMetadata>
      createHttpRouteOperationSettings() {
    return createHttpRouteOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateHttpRoute. */
  public UnaryCallSettings<UpdateHttpRouteRequest, Operation> updateHttpRouteSettings() {
    return updateHttpRouteSettings;
  }

  /** Returns the object with the settings used for calls to updateHttpRoute. */
  public OperationCallSettings<UpdateHttpRouteRequest, HttpRoute, OperationMetadata>
      updateHttpRouteOperationSettings() {
    return updateHttpRouteOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteHttpRoute. */
  public UnaryCallSettings<DeleteHttpRouteRequest, Operation> deleteHttpRouteSettings() {
    return deleteHttpRouteSettings;
  }

  /** Returns the object with the settings used for calls to deleteHttpRoute. */
  public OperationCallSettings<DeleteHttpRouteRequest, Empty, OperationMetadata>
      deleteHttpRouteOperationSettings() {
    return deleteHttpRouteOperationSettings;
  }

  /** Returns the object with the settings used for calls to listTcpRoutes. */
  public PagedCallSettings<ListTcpRoutesRequest, ListTcpRoutesResponse, ListTcpRoutesPagedResponse>
      listTcpRoutesSettings() {
    return listTcpRoutesSettings;
  }

  /** Returns the object with the settings used for calls to getTcpRoute. */
  public UnaryCallSettings<GetTcpRouteRequest, TcpRoute> getTcpRouteSettings() {
    return getTcpRouteSettings;
  }

  /** Returns the object with the settings used for calls to createTcpRoute. */
  public UnaryCallSettings<CreateTcpRouteRequest, Operation> createTcpRouteSettings() {
    return createTcpRouteSettings;
  }

  /** Returns the object with the settings used for calls to createTcpRoute. */
  public OperationCallSettings<CreateTcpRouteRequest, TcpRoute, OperationMetadata>
      createTcpRouteOperationSettings() {
    return createTcpRouteOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateTcpRoute. */
  public UnaryCallSettings<UpdateTcpRouteRequest, Operation> updateTcpRouteSettings() {
    return updateTcpRouteSettings;
  }

  /** Returns the object with the settings used for calls to updateTcpRoute. */
  public OperationCallSettings<UpdateTcpRouteRequest, TcpRoute, OperationMetadata>
      updateTcpRouteOperationSettings() {
    return updateTcpRouteOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteTcpRoute. */
  public UnaryCallSettings<DeleteTcpRouteRequest, Operation> deleteTcpRouteSettings() {
    return deleteTcpRouteSettings;
  }

  /** Returns the object with the settings used for calls to deleteTcpRoute. */
  public OperationCallSettings<DeleteTcpRouteRequest, Empty, OperationMetadata>
      deleteTcpRouteOperationSettings() {
    return deleteTcpRouteOperationSettings;
  }

  /** Returns the object with the settings used for calls to listTlsRoutes. */
  public PagedCallSettings<ListTlsRoutesRequest, ListTlsRoutesResponse, ListTlsRoutesPagedResponse>
      listTlsRoutesSettings() {
    return listTlsRoutesSettings;
  }

  /** Returns the object with the settings used for calls to getTlsRoute. */
  public UnaryCallSettings<GetTlsRouteRequest, TlsRoute> getTlsRouteSettings() {
    return getTlsRouteSettings;
  }

  /** Returns the object with the settings used for calls to createTlsRoute. */
  public UnaryCallSettings<CreateTlsRouteRequest, Operation> createTlsRouteSettings() {
    return createTlsRouteSettings;
  }

  /** Returns the object with the settings used for calls to createTlsRoute. */
  public OperationCallSettings<CreateTlsRouteRequest, TlsRoute, OperationMetadata>
      createTlsRouteOperationSettings() {
    return createTlsRouteOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateTlsRoute. */
  public UnaryCallSettings<UpdateTlsRouteRequest, Operation> updateTlsRouteSettings() {
    return updateTlsRouteSettings;
  }

  /** Returns the object with the settings used for calls to updateTlsRoute. */
  public OperationCallSettings<UpdateTlsRouteRequest, TlsRoute, OperationMetadata>
      updateTlsRouteOperationSettings() {
    return updateTlsRouteOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteTlsRoute. */
  public UnaryCallSettings<DeleteTlsRouteRequest, Operation> deleteTlsRouteSettings() {
    return deleteTlsRouteSettings;
  }

  /** Returns the object with the settings used for calls to deleteTlsRoute. */
  public OperationCallSettings<DeleteTlsRouteRequest, Empty, OperationMetadata>
      deleteTlsRouteOperationSettings() {
    return deleteTlsRouteOperationSettings;
  }

  /** Returns the object with the settings used for calls to listServiceBindings. */
  public PagedCallSettings<
          ListServiceBindingsRequest, ListServiceBindingsResponse, ListServiceBindingsPagedResponse>
      listServiceBindingsSettings() {
    return listServiceBindingsSettings;
  }

  /** Returns the object with the settings used for calls to getServiceBinding. */
  public UnaryCallSettings<GetServiceBindingRequest, ServiceBinding> getServiceBindingSettings() {
    return getServiceBindingSettings;
  }

  /** Returns the object with the settings used for calls to createServiceBinding. */
  public UnaryCallSettings<CreateServiceBindingRequest, Operation> createServiceBindingSettings() {
    return createServiceBindingSettings;
  }

  /** Returns the object with the settings used for calls to createServiceBinding. */
  public OperationCallSettings<CreateServiceBindingRequest, ServiceBinding, OperationMetadata>
      createServiceBindingOperationSettings() {
    return createServiceBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteServiceBinding. */
  public UnaryCallSettings<DeleteServiceBindingRequest, Operation> deleteServiceBindingSettings() {
    return deleteServiceBindingSettings;
  }

  /** Returns the object with the settings used for calls to deleteServiceBinding. */
  public OperationCallSettings<DeleteServiceBindingRequest, Empty, OperationMetadata>
      deleteServiceBindingOperationSettings() {
    return deleteServiceBindingOperationSettings;
  }

  /** Returns the object with the settings used for calls to listMeshes. */
  public PagedCallSettings<ListMeshesRequest, ListMeshesResponse, ListMeshesPagedResponse>
      listMeshesSettings() {
    return listMeshesSettings;
  }

  /** Returns the object with the settings used for calls to getMesh. */
  public UnaryCallSettings<GetMeshRequest, Mesh> getMeshSettings() {
    return getMeshSettings;
  }

  /** Returns the object with the settings used for calls to createMesh. */
  public UnaryCallSettings<CreateMeshRequest, Operation> createMeshSettings() {
    return createMeshSettings;
  }

  /** Returns the object with the settings used for calls to createMesh. */
  public OperationCallSettings<CreateMeshRequest, Mesh, OperationMetadata>
      createMeshOperationSettings() {
    return createMeshOperationSettings;
  }

  /** Returns the object with the settings used for calls to updateMesh. */
  public UnaryCallSettings<UpdateMeshRequest, Operation> updateMeshSettings() {
    return updateMeshSettings;
  }

  /** Returns the object with the settings used for calls to updateMesh. */
  public OperationCallSettings<UpdateMeshRequest, Mesh, OperationMetadata>
      updateMeshOperationSettings() {
    return updateMeshOperationSettings;
  }

  /** Returns the object with the settings used for calls to deleteMesh. */
  public UnaryCallSettings<DeleteMeshRequest, Operation> deleteMeshSettings() {
    return deleteMeshSettings;
  }

  /** Returns the object with the settings used for calls to deleteMesh. */
  public OperationCallSettings<DeleteMeshRequest, Empty, OperationMetadata>
      deleteMeshOperationSettings() {
    return deleteMeshOperationSettings;
  }

  /** Returns the object with the settings used for calls to listLocations. */
  public PagedCallSettings<ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
      listLocationsSettings() {
    return listLocationsSettings;
  }

  /** Returns the object with the settings used for calls to getLocation. */
  public UnaryCallSettings<GetLocationRequest, Location> getLocationSettings() {
    return getLocationSettings;
  }

  /** Returns the object with the settings used for calls to setIamPolicy. */
  public UnaryCallSettings<SetIamPolicyRequest, Policy> setIamPolicySettings() {
    return setIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to getIamPolicy. */
  public UnaryCallSettings<GetIamPolicyRequest, Policy> getIamPolicySettings() {
    return getIamPolicySettings;
  }

  /** Returns the object with the settings used for calls to testIamPermissions. */
  public UnaryCallSettings<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsSettings() {
    return testIamPermissionsSettings;
  }

  public NetworkServicesStub createStub() throws IOException {
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(GrpcTransportChannel.getGrpcTransportName())) {
      return GrpcNetworkServicesStub.create(this);
    }
    if (getTransportChannelProvider()
        .getTransportName()
        .equals(HttpJsonTransportChannel.getHttpJsonTransportName())) {
      return HttpJsonNetworkServicesStub.create(this);
    }
    throw new UnsupportedOperationException(
        String.format(
            "Transport not supported: %s", getTransportChannelProvider().getTransportName()));
  }

  /** Returns the default service name. */
  @Override
  public String getServiceName() {
    return "networkservices";
  }

  /** Returns a builder for the default ExecutorProvider for this service. */
  public static InstantiatingExecutorProvider.Builder defaultExecutorProviderBuilder() {
    return InstantiatingExecutorProvider.newBuilder();
  }

  /** Returns the default service endpoint. */
  public static String getDefaultEndpoint() {
    return "networkservices.googleapis.com:443";
  }

  /** Returns the default mTLS service endpoint. */
  public static String getDefaultMtlsEndpoint() {
    return "networkservices.mtls.googleapis.com:443";
  }

  /** Returns the default service scopes. */
  public static List<String> getDefaultServiceScopes() {
    return DEFAULT_SERVICE_SCOPES;
  }

  /** Returns a builder for the default credentials for this service. */
  public static GoogleCredentialsProvider.Builder defaultCredentialsProviderBuilder() {
    return GoogleCredentialsProvider.newBuilder()
        .setScopesToApply(DEFAULT_SERVICE_SCOPES)
        .setUseJwtAccessWithScope(true);
  }

  /** Returns a builder for the default gRPC ChannelProvider for this service. */
  public static InstantiatingGrpcChannelProvider.Builder defaultGrpcTransportProviderBuilder() {
    return InstantiatingGrpcChannelProvider.newBuilder()
        .setMaxInboundMessageSize(Integer.MAX_VALUE);
  }

  /** Returns a builder for the default REST ChannelProvider for this service. */
  @BetaApi
  public static InstantiatingHttpJsonChannelProvider.Builder
      defaultHttpJsonTransportProviderBuilder() {
    return InstantiatingHttpJsonChannelProvider.newBuilder();
  }

  public static TransportChannelProvider defaultTransportChannelProvider() {
    return defaultGrpcTransportProviderBuilder().build();
  }

  public static ApiClientHeaderProvider.Builder defaultGrpcApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(NetworkServicesStubSettings.class))
        .setTransportToken(
            GaxGrpcProperties.getGrpcTokenName(), GaxGrpcProperties.getGrpcVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultHttpJsonApiClientHeaderProviderBuilder() {
    return ApiClientHeaderProvider.newBuilder()
        .setGeneratedLibToken(
            "gapic", GaxProperties.getLibraryVersion(NetworkServicesStubSettings.class))
        .setTransportToken(
            GaxHttpJsonProperties.getHttpJsonTokenName(),
            GaxHttpJsonProperties.getHttpJsonVersion());
  }

  public static ApiClientHeaderProvider.Builder defaultApiClientHeaderProviderBuilder() {
    return NetworkServicesStubSettings.defaultGrpcApiClientHeaderProviderBuilder();
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

  protected NetworkServicesStubSettings(Builder settingsBuilder) throws IOException {
    super(settingsBuilder);

    listEndpointPoliciesSettings = settingsBuilder.listEndpointPoliciesSettings().build();
    getEndpointPolicySettings = settingsBuilder.getEndpointPolicySettings().build();
    createEndpointPolicySettings = settingsBuilder.createEndpointPolicySettings().build();
    createEndpointPolicyOperationSettings =
        settingsBuilder.createEndpointPolicyOperationSettings().build();
    updateEndpointPolicySettings = settingsBuilder.updateEndpointPolicySettings().build();
    updateEndpointPolicyOperationSettings =
        settingsBuilder.updateEndpointPolicyOperationSettings().build();
    deleteEndpointPolicySettings = settingsBuilder.deleteEndpointPolicySettings().build();
    deleteEndpointPolicyOperationSettings =
        settingsBuilder.deleteEndpointPolicyOperationSettings().build();
    listGatewaysSettings = settingsBuilder.listGatewaysSettings().build();
    getGatewaySettings = settingsBuilder.getGatewaySettings().build();
    createGatewaySettings = settingsBuilder.createGatewaySettings().build();
    createGatewayOperationSettings = settingsBuilder.createGatewayOperationSettings().build();
    updateGatewaySettings = settingsBuilder.updateGatewaySettings().build();
    updateGatewayOperationSettings = settingsBuilder.updateGatewayOperationSettings().build();
    deleteGatewaySettings = settingsBuilder.deleteGatewaySettings().build();
    deleteGatewayOperationSettings = settingsBuilder.deleteGatewayOperationSettings().build();
    listGrpcRoutesSettings = settingsBuilder.listGrpcRoutesSettings().build();
    getGrpcRouteSettings = settingsBuilder.getGrpcRouteSettings().build();
    createGrpcRouteSettings = settingsBuilder.createGrpcRouteSettings().build();
    createGrpcRouteOperationSettings = settingsBuilder.createGrpcRouteOperationSettings().build();
    updateGrpcRouteSettings = settingsBuilder.updateGrpcRouteSettings().build();
    updateGrpcRouteOperationSettings = settingsBuilder.updateGrpcRouteOperationSettings().build();
    deleteGrpcRouteSettings = settingsBuilder.deleteGrpcRouteSettings().build();
    deleteGrpcRouteOperationSettings = settingsBuilder.deleteGrpcRouteOperationSettings().build();
    listHttpRoutesSettings = settingsBuilder.listHttpRoutesSettings().build();
    getHttpRouteSettings = settingsBuilder.getHttpRouteSettings().build();
    createHttpRouteSettings = settingsBuilder.createHttpRouteSettings().build();
    createHttpRouteOperationSettings = settingsBuilder.createHttpRouteOperationSettings().build();
    updateHttpRouteSettings = settingsBuilder.updateHttpRouteSettings().build();
    updateHttpRouteOperationSettings = settingsBuilder.updateHttpRouteOperationSettings().build();
    deleteHttpRouteSettings = settingsBuilder.deleteHttpRouteSettings().build();
    deleteHttpRouteOperationSettings = settingsBuilder.deleteHttpRouteOperationSettings().build();
    listTcpRoutesSettings = settingsBuilder.listTcpRoutesSettings().build();
    getTcpRouteSettings = settingsBuilder.getTcpRouteSettings().build();
    createTcpRouteSettings = settingsBuilder.createTcpRouteSettings().build();
    createTcpRouteOperationSettings = settingsBuilder.createTcpRouteOperationSettings().build();
    updateTcpRouteSettings = settingsBuilder.updateTcpRouteSettings().build();
    updateTcpRouteOperationSettings = settingsBuilder.updateTcpRouteOperationSettings().build();
    deleteTcpRouteSettings = settingsBuilder.deleteTcpRouteSettings().build();
    deleteTcpRouteOperationSettings = settingsBuilder.deleteTcpRouteOperationSettings().build();
    listTlsRoutesSettings = settingsBuilder.listTlsRoutesSettings().build();
    getTlsRouteSettings = settingsBuilder.getTlsRouteSettings().build();
    createTlsRouteSettings = settingsBuilder.createTlsRouteSettings().build();
    createTlsRouteOperationSettings = settingsBuilder.createTlsRouteOperationSettings().build();
    updateTlsRouteSettings = settingsBuilder.updateTlsRouteSettings().build();
    updateTlsRouteOperationSettings = settingsBuilder.updateTlsRouteOperationSettings().build();
    deleteTlsRouteSettings = settingsBuilder.deleteTlsRouteSettings().build();
    deleteTlsRouteOperationSettings = settingsBuilder.deleteTlsRouteOperationSettings().build();
    listServiceBindingsSettings = settingsBuilder.listServiceBindingsSettings().build();
    getServiceBindingSettings = settingsBuilder.getServiceBindingSettings().build();
    createServiceBindingSettings = settingsBuilder.createServiceBindingSettings().build();
    createServiceBindingOperationSettings =
        settingsBuilder.createServiceBindingOperationSettings().build();
    deleteServiceBindingSettings = settingsBuilder.deleteServiceBindingSettings().build();
    deleteServiceBindingOperationSettings =
        settingsBuilder.deleteServiceBindingOperationSettings().build();
    listMeshesSettings = settingsBuilder.listMeshesSettings().build();
    getMeshSettings = settingsBuilder.getMeshSettings().build();
    createMeshSettings = settingsBuilder.createMeshSettings().build();
    createMeshOperationSettings = settingsBuilder.createMeshOperationSettings().build();
    updateMeshSettings = settingsBuilder.updateMeshSettings().build();
    updateMeshOperationSettings = settingsBuilder.updateMeshOperationSettings().build();
    deleteMeshSettings = settingsBuilder.deleteMeshSettings().build();
    deleteMeshOperationSettings = settingsBuilder.deleteMeshOperationSettings().build();
    listLocationsSettings = settingsBuilder.listLocationsSettings().build();
    getLocationSettings = settingsBuilder.getLocationSettings().build();
    setIamPolicySettings = settingsBuilder.setIamPolicySettings().build();
    getIamPolicySettings = settingsBuilder.getIamPolicySettings().build();
    testIamPermissionsSettings = settingsBuilder.testIamPermissionsSettings().build();
  }

  /** Builder for NetworkServicesStubSettings. */
  public static class Builder extends StubSettings.Builder<NetworkServicesStubSettings, Builder> {
    private final ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders;
    private final PagedCallSettings.Builder<
            ListEndpointPoliciesRequest,
            ListEndpointPoliciesResponse,
            ListEndpointPoliciesPagedResponse>
        listEndpointPoliciesSettings;
    private final UnaryCallSettings.Builder<GetEndpointPolicyRequest, EndpointPolicy>
        getEndpointPolicySettings;
    private final UnaryCallSettings.Builder<CreateEndpointPolicyRequest, Operation>
        createEndpointPolicySettings;
    private final OperationCallSettings.Builder<
            CreateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
        createEndpointPolicyOperationSettings;
    private final UnaryCallSettings.Builder<UpdateEndpointPolicyRequest, Operation>
        updateEndpointPolicySettings;
    private final OperationCallSettings.Builder<
            UpdateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
        updateEndpointPolicyOperationSettings;
    private final UnaryCallSettings.Builder<DeleteEndpointPolicyRequest, Operation>
        deleteEndpointPolicySettings;
    private final OperationCallSettings.Builder<
            DeleteEndpointPolicyRequest, Empty, OperationMetadata>
        deleteEndpointPolicyOperationSettings;
    private final PagedCallSettings.Builder<
            ListGatewaysRequest, ListGatewaysResponse, ListGatewaysPagedResponse>
        listGatewaysSettings;
    private final UnaryCallSettings.Builder<GetGatewayRequest, Gateway> getGatewaySettings;
    private final UnaryCallSettings.Builder<CreateGatewayRequest, Operation> createGatewaySettings;
    private final OperationCallSettings.Builder<CreateGatewayRequest, Gateway, OperationMetadata>
        createGatewayOperationSettings;
    private final UnaryCallSettings.Builder<UpdateGatewayRequest, Operation> updateGatewaySettings;
    private final OperationCallSettings.Builder<UpdateGatewayRequest, Gateway, OperationMetadata>
        updateGatewayOperationSettings;
    private final UnaryCallSettings.Builder<DeleteGatewayRequest, Operation> deleteGatewaySettings;
    private final OperationCallSettings.Builder<DeleteGatewayRequest, Empty, OperationMetadata>
        deleteGatewayOperationSettings;
    private final PagedCallSettings.Builder<
            ListGrpcRoutesRequest, ListGrpcRoutesResponse, ListGrpcRoutesPagedResponse>
        listGrpcRoutesSettings;
    private final UnaryCallSettings.Builder<GetGrpcRouteRequest, GrpcRoute> getGrpcRouteSettings;
    private final UnaryCallSettings.Builder<CreateGrpcRouteRequest, Operation>
        createGrpcRouteSettings;
    private final OperationCallSettings.Builder<
            CreateGrpcRouteRequest, GrpcRoute, OperationMetadata>
        createGrpcRouteOperationSettings;
    private final UnaryCallSettings.Builder<UpdateGrpcRouteRequest, Operation>
        updateGrpcRouteSettings;
    private final OperationCallSettings.Builder<
            UpdateGrpcRouteRequest, GrpcRoute, OperationMetadata>
        updateGrpcRouteOperationSettings;
    private final UnaryCallSettings.Builder<DeleteGrpcRouteRequest, Operation>
        deleteGrpcRouteSettings;
    private final OperationCallSettings.Builder<DeleteGrpcRouteRequest, Empty, OperationMetadata>
        deleteGrpcRouteOperationSettings;
    private final PagedCallSettings.Builder<
            ListHttpRoutesRequest, ListHttpRoutesResponse, ListHttpRoutesPagedResponse>
        listHttpRoutesSettings;
    private final UnaryCallSettings.Builder<GetHttpRouteRequest, HttpRoute> getHttpRouteSettings;
    private final UnaryCallSettings.Builder<CreateHttpRouteRequest, Operation>
        createHttpRouteSettings;
    private final OperationCallSettings.Builder<
            CreateHttpRouteRequest, HttpRoute, OperationMetadata>
        createHttpRouteOperationSettings;
    private final UnaryCallSettings.Builder<UpdateHttpRouteRequest, Operation>
        updateHttpRouteSettings;
    private final OperationCallSettings.Builder<
            UpdateHttpRouteRequest, HttpRoute, OperationMetadata>
        updateHttpRouteOperationSettings;
    private final UnaryCallSettings.Builder<DeleteHttpRouteRequest, Operation>
        deleteHttpRouteSettings;
    private final OperationCallSettings.Builder<DeleteHttpRouteRequest, Empty, OperationMetadata>
        deleteHttpRouteOperationSettings;
    private final PagedCallSettings.Builder<
            ListTcpRoutesRequest, ListTcpRoutesResponse, ListTcpRoutesPagedResponse>
        listTcpRoutesSettings;
    private final UnaryCallSettings.Builder<GetTcpRouteRequest, TcpRoute> getTcpRouteSettings;
    private final UnaryCallSettings.Builder<CreateTcpRouteRequest, Operation>
        createTcpRouteSettings;
    private final OperationCallSettings.Builder<CreateTcpRouteRequest, TcpRoute, OperationMetadata>
        createTcpRouteOperationSettings;
    private final UnaryCallSettings.Builder<UpdateTcpRouteRequest, Operation>
        updateTcpRouteSettings;
    private final OperationCallSettings.Builder<UpdateTcpRouteRequest, TcpRoute, OperationMetadata>
        updateTcpRouteOperationSettings;
    private final UnaryCallSettings.Builder<DeleteTcpRouteRequest, Operation>
        deleteTcpRouteSettings;
    private final OperationCallSettings.Builder<DeleteTcpRouteRequest, Empty, OperationMetadata>
        deleteTcpRouteOperationSettings;
    private final PagedCallSettings.Builder<
            ListTlsRoutesRequest, ListTlsRoutesResponse, ListTlsRoutesPagedResponse>
        listTlsRoutesSettings;
    private final UnaryCallSettings.Builder<GetTlsRouteRequest, TlsRoute> getTlsRouteSettings;
    private final UnaryCallSettings.Builder<CreateTlsRouteRequest, Operation>
        createTlsRouteSettings;
    private final OperationCallSettings.Builder<CreateTlsRouteRequest, TlsRoute, OperationMetadata>
        createTlsRouteOperationSettings;
    private final UnaryCallSettings.Builder<UpdateTlsRouteRequest, Operation>
        updateTlsRouteSettings;
    private final OperationCallSettings.Builder<UpdateTlsRouteRequest, TlsRoute, OperationMetadata>
        updateTlsRouteOperationSettings;
    private final UnaryCallSettings.Builder<DeleteTlsRouteRequest, Operation>
        deleteTlsRouteSettings;
    private final OperationCallSettings.Builder<DeleteTlsRouteRequest, Empty, OperationMetadata>
        deleteTlsRouteOperationSettings;
    private final PagedCallSettings.Builder<
            ListServiceBindingsRequest,
            ListServiceBindingsResponse,
            ListServiceBindingsPagedResponse>
        listServiceBindingsSettings;
    private final UnaryCallSettings.Builder<GetServiceBindingRequest, ServiceBinding>
        getServiceBindingSettings;
    private final UnaryCallSettings.Builder<CreateServiceBindingRequest, Operation>
        createServiceBindingSettings;
    private final OperationCallSettings.Builder<
            CreateServiceBindingRequest, ServiceBinding, OperationMetadata>
        createServiceBindingOperationSettings;
    private final UnaryCallSettings.Builder<DeleteServiceBindingRequest, Operation>
        deleteServiceBindingSettings;
    private final OperationCallSettings.Builder<
            DeleteServiceBindingRequest, Empty, OperationMetadata>
        deleteServiceBindingOperationSettings;
    private final PagedCallSettings.Builder<
            ListMeshesRequest, ListMeshesResponse, ListMeshesPagedResponse>
        listMeshesSettings;
    private final UnaryCallSettings.Builder<GetMeshRequest, Mesh> getMeshSettings;
    private final UnaryCallSettings.Builder<CreateMeshRequest, Operation> createMeshSettings;
    private final OperationCallSettings.Builder<CreateMeshRequest, Mesh, OperationMetadata>
        createMeshOperationSettings;
    private final UnaryCallSettings.Builder<UpdateMeshRequest, Operation> updateMeshSettings;
    private final OperationCallSettings.Builder<UpdateMeshRequest, Mesh, OperationMetadata>
        updateMeshOperationSettings;
    private final UnaryCallSettings.Builder<DeleteMeshRequest, Operation> deleteMeshSettings;
    private final OperationCallSettings.Builder<DeleteMeshRequest, Empty, OperationMetadata>
        deleteMeshOperationSettings;
    private final PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings;
    private final UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings;
    private final UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings;
    private final UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings;
    private final UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings;
    private static final ImmutableMap<String, ImmutableSet<StatusCode.Code>>
        RETRYABLE_CODE_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, ImmutableSet<StatusCode.Code>> definitions =
          ImmutableMap.builder();
      definitions.put(
          "no_retry_0_codes", ImmutableSet.copyOf(Lists.<StatusCode.Code>newArrayList()));
      RETRYABLE_CODE_DEFINITIONS = definitions.build();
    }

    private static final ImmutableMap<String, RetrySettings> RETRY_PARAM_DEFINITIONS;

    static {
      ImmutableMap.Builder<String, RetrySettings> definitions = ImmutableMap.builder();
      RetrySettings settings = null;
      settings =
          RetrySettings.newBuilder()
              .setInitialRpcTimeout(Duration.ofMillis(60000L))
              .setRpcTimeoutMultiplier(1.0)
              .setMaxRpcTimeout(Duration.ofMillis(60000L))
              .setTotalTimeout(Duration.ofMillis(60000L))
              .build();
      definitions.put("no_retry_0_params", settings);
      RETRY_PARAM_DEFINITIONS = definitions.build();
    }

    protected Builder() {
      this(((ClientContext) null));
    }

    protected Builder(ClientContext clientContext) {
      super(clientContext);

      listEndpointPoliciesSettings =
          PagedCallSettings.newBuilder(LIST_ENDPOINT_POLICIES_PAGE_STR_FACT);
      getEndpointPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEndpointPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createEndpointPolicyOperationSettings = OperationCallSettings.newBuilder();
      updateEndpointPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateEndpointPolicyOperationSettings = OperationCallSettings.newBuilder();
      deleteEndpointPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteEndpointPolicyOperationSettings = OperationCallSettings.newBuilder();
      listGatewaysSettings = PagedCallSettings.newBuilder(LIST_GATEWAYS_PAGE_STR_FACT);
      getGatewaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGatewaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGatewayOperationSettings = OperationCallSettings.newBuilder();
      updateGatewaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateGatewayOperationSettings = OperationCallSettings.newBuilder();
      deleteGatewaySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteGatewayOperationSettings = OperationCallSettings.newBuilder();
      listGrpcRoutesSettings = PagedCallSettings.newBuilder(LIST_GRPC_ROUTES_PAGE_STR_FACT);
      getGrpcRouteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGrpcRouteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createGrpcRouteOperationSettings = OperationCallSettings.newBuilder();
      updateGrpcRouteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateGrpcRouteOperationSettings = OperationCallSettings.newBuilder();
      deleteGrpcRouteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteGrpcRouteOperationSettings = OperationCallSettings.newBuilder();
      listHttpRoutesSettings = PagedCallSettings.newBuilder(LIST_HTTP_ROUTES_PAGE_STR_FACT);
      getHttpRouteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createHttpRouteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createHttpRouteOperationSettings = OperationCallSettings.newBuilder();
      updateHttpRouteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateHttpRouteOperationSettings = OperationCallSettings.newBuilder();
      deleteHttpRouteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteHttpRouteOperationSettings = OperationCallSettings.newBuilder();
      listTcpRoutesSettings = PagedCallSettings.newBuilder(LIST_TCP_ROUTES_PAGE_STR_FACT);
      getTcpRouteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTcpRouteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTcpRouteOperationSettings = OperationCallSettings.newBuilder();
      updateTcpRouteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTcpRouteOperationSettings = OperationCallSettings.newBuilder();
      deleteTcpRouteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTcpRouteOperationSettings = OperationCallSettings.newBuilder();
      listTlsRoutesSettings = PagedCallSettings.newBuilder(LIST_TLS_ROUTES_PAGE_STR_FACT);
      getTlsRouteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTlsRouteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createTlsRouteOperationSettings = OperationCallSettings.newBuilder();
      updateTlsRouteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateTlsRouteOperationSettings = OperationCallSettings.newBuilder();
      deleteTlsRouteSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteTlsRouteOperationSettings = OperationCallSettings.newBuilder();
      listServiceBindingsSettings =
          PagedCallSettings.newBuilder(LIST_SERVICE_BINDINGS_PAGE_STR_FACT);
      getServiceBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createServiceBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createServiceBindingOperationSettings = OperationCallSettings.newBuilder();
      deleteServiceBindingSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteServiceBindingOperationSettings = OperationCallSettings.newBuilder();
      listMeshesSettings = PagedCallSettings.newBuilder(LIST_MESHES_PAGE_STR_FACT);
      getMeshSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMeshSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      createMeshOperationSettings = OperationCallSettings.newBuilder();
      updateMeshSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      updateMeshOperationSettings = OperationCallSettings.newBuilder();
      deleteMeshSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      deleteMeshOperationSettings = OperationCallSettings.newBuilder();
      listLocationsSettings = PagedCallSettings.newBuilder(LIST_LOCATIONS_PAGE_STR_FACT);
      getLocationSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      setIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      getIamPolicySettings = UnaryCallSettings.newUnaryCallSettingsBuilder();
      testIamPermissionsSettings = UnaryCallSettings.newUnaryCallSettingsBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listEndpointPoliciesSettings,
              getEndpointPolicySettings,
              createEndpointPolicySettings,
              updateEndpointPolicySettings,
              deleteEndpointPolicySettings,
              listGatewaysSettings,
              getGatewaySettings,
              createGatewaySettings,
              updateGatewaySettings,
              deleteGatewaySettings,
              listGrpcRoutesSettings,
              getGrpcRouteSettings,
              createGrpcRouteSettings,
              updateGrpcRouteSettings,
              deleteGrpcRouteSettings,
              listHttpRoutesSettings,
              getHttpRouteSettings,
              createHttpRouteSettings,
              updateHttpRouteSettings,
              deleteHttpRouteSettings,
              listTcpRoutesSettings,
              getTcpRouteSettings,
              createTcpRouteSettings,
              updateTcpRouteSettings,
              deleteTcpRouteSettings,
              listTlsRoutesSettings,
              getTlsRouteSettings,
              createTlsRouteSettings,
              updateTlsRouteSettings,
              deleteTlsRouteSettings,
              listServiceBindingsSettings,
              getServiceBindingSettings,
              createServiceBindingSettings,
              deleteServiceBindingSettings,
              listMeshesSettings,
              getMeshSettings,
              createMeshSettings,
              updateMeshSettings,
              deleteMeshSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
      initDefaults(this);
    }

    protected Builder(NetworkServicesStubSettings settings) {
      super(settings);

      listEndpointPoliciesSettings = settings.listEndpointPoliciesSettings.toBuilder();
      getEndpointPolicySettings = settings.getEndpointPolicySettings.toBuilder();
      createEndpointPolicySettings = settings.createEndpointPolicySettings.toBuilder();
      createEndpointPolicyOperationSettings =
          settings.createEndpointPolicyOperationSettings.toBuilder();
      updateEndpointPolicySettings = settings.updateEndpointPolicySettings.toBuilder();
      updateEndpointPolicyOperationSettings =
          settings.updateEndpointPolicyOperationSettings.toBuilder();
      deleteEndpointPolicySettings = settings.deleteEndpointPolicySettings.toBuilder();
      deleteEndpointPolicyOperationSettings =
          settings.deleteEndpointPolicyOperationSettings.toBuilder();
      listGatewaysSettings = settings.listGatewaysSettings.toBuilder();
      getGatewaySettings = settings.getGatewaySettings.toBuilder();
      createGatewaySettings = settings.createGatewaySettings.toBuilder();
      createGatewayOperationSettings = settings.createGatewayOperationSettings.toBuilder();
      updateGatewaySettings = settings.updateGatewaySettings.toBuilder();
      updateGatewayOperationSettings = settings.updateGatewayOperationSettings.toBuilder();
      deleteGatewaySettings = settings.deleteGatewaySettings.toBuilder();
      deleteGatewayOperationSettings = settings.deleteGatewayOperationSettings.toBuilder();
      listGrpcRoutesSettings = settings.listGrpcRoutesSettings.toBuilder();
      getGrpcRouteSettings = settings.getGrpcRouteSettings.toBuilder();
      createGrpcRouteSettings = settings.createGrpcRouteSettings.toBuilder();
      createGrpcRouteOperationSettings = settings.createGrpcRouteOperationSettings.toBuilder();
      updateGrpcRouteSettings = settings.updateGrpcRouteSettings.toBuilder();
      updateGrpcRouteOperationSettings = settings.updateGrpcRouteOperationSettings.toBuilder();
      deleteGrpcRouteSettings = settings.deleteGrpcRouteSettings.toBuilder();
      deleteGrpcRouteOperationSettings = settings.deleteGrpcRouteOperationSettings.toBuilder();
      listHttpRoutesSettings = settings.listHttpRoutesSettings.toBuilder();
      getHttpRouteSettings = settings.getHttpRouteSettings.toBuilder();
      createHttpRouteSettings = settings.createHttpRouteSettings.toBuilder();
      createHttpRouteOperationSettings = settings.createHttpRouteOperationSettings.toBuilder();
      updateHttpRouteSettings = settings.updateHttpRouteSettings.toBuilder();
      updateHttpRouteOperationSettings = settings.updateHttpRouteOperationSettings.toBuilder();
      deleteHttpRouteSettings = settings.deleteHttpRouteSettings.toBuilder();
      deleteHttpRouteOperationSettings = settings.deleteHttpRouteOperationSettings.toBuilder();
      listTcpRoutesSettings = settings.listTcpRoutesSettings.toBuilder();
      getTcpRouteSettings = settings.getTcpRouteSettings.toBuilder();
      createTcpRouteSettings = settings.createTcpRouteSettings.toBuilder();
      createTcpRouteOperationSettings = settings.createTcpRouteOperationSettings.toBuilder();
      updateTcpRouteSettings = settings.updateTcpRouteSettings.toBuilder();
      updateTcpRouteOperationSettings = settings.updateTcpRouteOperationSettings.toBuilder();
      deleteTcpRouteSettings = settings.deleteTcpRouteSettings.toBuilder();
      deleteTcpRouteOperationSettings = settings.deleteTcpRouteOperationSettings.toBuilder();
      listTlsRoutesSettings = settings.listTlsRoutesSettings.toBuilder();
      getTlsRouteSettings = settings.getTlsRouteSettings.toBuilder();
      createTlsRouteSettings = settings.createTlsRouteSettings.toBuilder();
      createTlsRouteOperationSettings = settings.createTlsRouteOperationSettings.toBuilder();
      updateTlsRouteSettings = settings.updateTlsRouteSettings.toBuilder();
      updateTlsRouteOperationSettings = settings.updateTlsRouteOperationSettings.toBuilder();
      deleteTlsRouteSettings = settings.deleteTlsRouteSettings.toBuilder();
      deleteTlsRouteOperationSettings = settings.deleteTlsRouteOperationSettings.toBuilder();
      listServiceBindingsSettings = settings.listServiceBindingsSettings.toBuilder();
      getServiceBindingSettings = settings.getServiceBindingSettings.toBuilder();
      createServiceBindingSettings = settings.createServiceBindingSettings.toBuilder();
      createServiceBindingOperationSettings =
          settings.createServiceBindingOperationSettings.toBuilder();
      deleteServiceBindingSettings = settings.deleteServiceBindingSettings.toBuilder();
      deleteServiceBindingOperationSettings =
          settings.deleteServiceBindingOperationSettings.toBuilder();
      listMeshesSettings = settings.listMeshesSettings.toBuilder();
      getMeshSettings = settings.getMeshSettings.toBuilder();
      createMeshSettings = settings.createMeshSettings.toBuilder();
      createMeshOperationSettings = settings.createMeshOperationSettings.toBuilder();
      updateMeshSettings = settings.updateMeshSettings.toBuilder();
      updateMeshOperationSettings = settings.updateMeshOperationSettings.toBuilder();
      deleteMeshSettings = settings.deleteMeshSettings.toBuilder();
      deleteMeshOperationSettings = settings.deleteMeshOperationSettings.toBuilder();
      listLocationsSettings = settings.listLocationsSettings.toBuilder();
      getLocationSettings = settings.getLocationSettings.toBuilder();
      setIamPolicySettings = settings.setIamPolicySettings.toBuilder();
      getIamPolicySettings = settings.getIamPolicySettings.toBuilder();
      testIamPermissionsSettings = settings.testIamPermissionsSettings.toBuilder();

      unaryMethodSettingsBuilders =
          ImmutableList.<UnaryCallSettings.Builder<?, ?>>of(
              listEndpointPoliciesSettings,
              getEndpointPolicySettings,
              createEndpointPolicySettings,
              updateEndpointPolicySettings,
              deleteEndpointPolicySettings,
              listGatewaysSettings,
              getGatewaySettings,
              createGatewaySettings,
              updateGatewaySettings,
              deleteGatewaySettings,
              listGrpcRoutesSettings,
              getGrpcRouteSettings,
              createGrpcRouteSettings,
              updateGrpcRouteSettings,
              deleteGrpcRouteSettings,
              listHttpRoutesSettings,
              getHttpRouteSettings,
              createHttpRouteSettings,
              updateHttpRouteSettings,
              deleteHttpRouteSettings,
              listTcpRoutesSettings,
              getTcpRouteSettings,
              createTcpRouteSettings,
              updateTcpRouteSettings,
              deleteTcpRouteSettings,
              listTlsRoutesSettings,
              getTlsRouteSettings,
              createTlsRouteSettings,
              updateTlsRouteSettings,
              deleteTlsRouteSettings,
              listServiceBindingsSettings,
              getServiceBindingSettings,
              createServiceBindingSettings,
              deleteServiceBindingSettings,
              listMeshesSettings,
              getMeshSettings,
              createMeshSettings,
              updateMeshSettings,
              deleteMeshSettings,
              listLocationsSettings,
              getLocationSettings,
              setIamPolicySettings,
              getIamPolicySettings,
              testIamPermissionsSettings);
    }

    private static Builder createDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultTransportChannelProvider());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder createHttpJsonDefault() {
      Builder builder = new Builder(((ClientContext) null));

      builder.setTransportChannelProvider(defaultHttpJsonTransportProviderBuilder().build());
      builder.setCredentialsProvider(defaultCredentialsProviderBuilder().build());
      builder.setInternalHeaderProvider(defaultHttpJsonApiClientHeaderProviderBuilder().build());
      builder.setMtlsEndpoint(getDefaultMtlsEndpoint());
      builder.setSwitchToMtlsEndpointAllowed(true);

      return initDefaults(builder);
    }

    private static Builder initDefaults(Builder builder) {
      builder
          .listEndpointPoliciesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getEndpointPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createEndpointPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateEndpointPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteEndpointPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listGatewaysSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getGatewaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createGatewaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateGatewaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteGatewaySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listGrpcRoutesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getGrpcRouteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createGrpcRouteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateGrpcRouteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteGrpcRouteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listHttpRoutesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getHttpRouteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createHttpRouteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateHttpRouteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteHttpRouteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listTcpRoutesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getTcpRouteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createTcpRouteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateTcpRouteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteTcpRouteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listTlsRoutesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getTlsRouteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createTlsRouteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateTlsRouteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteTlsRouteSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listServiceBindingsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getServiceBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createServiceBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteServiceBindingSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listMeshesSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getMeshSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createMeshSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .updateMeshSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .deleteMeshSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .listLocationsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getLocationSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .setIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .getIamPolicySettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .testIamPermissionsSettings()
          .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
          .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"));

      builder
          .createEndpointPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateEndpointPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(EndpointPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateEndpointPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateEndpointPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(EndpointPolicy.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteEndpointPolicyOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteEndpointPolicyRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createGatewayOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateGatewayRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Gateway.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateGatewayOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateGatewayRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Gateway.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteGatewayOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteGatewayRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createGrpcRouteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateGrpcRouteRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(GrpcRoute.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateGrpcRouteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateGrpcRouteRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(GrpcRoute.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteGrpcRouteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteGrpcRouteRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createHttpRouteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateHttpRouteRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(HttpRoute.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateHttpRouteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateHttpRouteRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(HttpRoute.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteHttpRouteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteHttpRouteRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createTcpRouteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateTcpRouteRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(TcpRoute.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateTcpRouteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateTcpRouteRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(TcpRoute.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteTcpRouteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteTcpRouteRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createTlsRouteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateTlsRouteRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(TlsRoute.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateTlsRouteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<UpdateTlsRouteRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(TlsRoute.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteTlsRouteOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteTlsRouteRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createServiceBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<CreateServiceBindingRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(ServiceBinding.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteServiceBindingOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings
                  .<DeleteServiceBindingRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .createMeshOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<CreateMeshRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Mesh.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .updateMeshOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<UpdateMeshRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(ProtoOperationTransformers.ResponseTransformer.create(Mesh.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      builder
          .deleteMeshOperationSettings()
          .setInitialCallSettings(
              UnaryCallSettings.<DeleteMeshRequest, OperationSnapshot>newUnaryCallSettingsBuilder()
                  .setRetryableCodes(RETRYABLE_CODE_DEFINITIONS.get("no_retry_0_codes"))
                  .setRetrySettings(RETRY_PARAM_DEFINITIONS.get("no_retry_0_params"))
                  .build())
          .setResponseTransformer(
              ProtoOperationTransformers.ResponseTransformer.create(Empty.class))
          .setMetadataTransformer(
              ProtoOperationTransformers.MetadataTransformer.create(OperationMetadata.class))
          .setPollingAlgorithm(
              OperationTimedPollAlgorithm.create(
                  RetrySettings.newBuilder()
                      .setInitialRetryDelay(Duration.ofMillis(5000L))
                      .setRetryDelayMultiplier(1.5)
                      .setMaxRetryDelay(Duration.ofMillis(45000L))
                      .setInitialRpcTimeout(Duration.ZERO)
                      .setRpcTimeoutMultiplier(1.0)
                      .setMaxRpcTimeout(Duration.ZERO)
                      .setTotalTimeout(Duration.ofMillis(300000L))
                      .build()));

      return builder;
    }

    /**
     * Applies the given settings updater function to all of the unary API methods in this service.
     *
     * <p>Note: This method does not support applying settings to streaming methods.
     */
    public Builder applyToAllUnaryMethods(
        ApiFunction<UnaryCallSettings.Builder<?, ?>, Void> settingsUpdater) {
      super.applyToAllUnaryMethods(unaryMethodSettingsBuilders, settingsUpdater);
      return this;
    }

    public ImmutableList<UnaryCallSettings.Builder<?, ?>> unaryMethodSettingsBuilders() {
      return unaryMethodSettingsBuilders;
    }

    /** Returns the builder for the settings used for calls to listEndpointPolicies. */
    public PagedCallSettings.Builder<
            ListEndpointPoliciesRequest,
            ListEndpointPoliciesResponse,
            ListEndpointPoliciesPagedResponse>
        listEndpointPoliciesSettings() {
      return listEndpointPoliciesSettings;
    }

    /** Returns the builder for the settings used for calls to getEndpointPolicy. */
    public UnaryCallSettings.Builder<GetEndpointPolicyRequest, EndpointPolicy>
        getEndpointPolicySettings() {
      return getEndpointPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createEndpointPolicy. */
    public UnaryCallSettings.Builder<CreateEndpointPolicyRequest, Operation>
        createEndpointPolicySettings() {
      return createEndpointPolicySettings;
    }

    /** Returns the builder for the settings used for calls to createEndpointPolicy. */
    public OperationCallSettings.Builder<
            CreateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
        createEndpointPolicyOperationSettings() {
      return createEndpointPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateEndpointPolicy. */
    public UnaryCallSettings.Builder<UpdateEndpointPolicyRequest, Operation>
        updateEndpointPolicySettings() {
      return updateEndpointPolicySettings;
    }

    /** Returns the builder for the settings used for calls to updateEndpointPolicy. */
    public OperationCallSettings.Builder<
            UpdateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
        updateEndpointPolicyOperationSettings() {
      return updateEndpointPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteEndpointPolicy. */
    public UnaryCallSettings.Builder<DeleteEndpointPolicyRequest, Operation>
        deleteEndpointPolicySettings() {
      return deleteEndpointPolicySettings;
    }

    /** Returns the builder for the settings used for calls to deleteEndpointPolicy. */
    public OperationCallSettings.Builder<DeleteEndpointPolicyRequest, Empty, OperationMetadata>
        deleteEndpointPolicyOperationSettings() {
      return deleteEndpointPolicyOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listGateways. */
    public PagedCallSettings.Builder<
            ListGatewaysRequest, ListGatewaysResponse, ListGatewaysPagedResponse>
        listGatewaysSettings() {
      return listGatewaysSettings;
    }

    /** Returns the builder for the settings used for calls to getGateway. */
    public UnaryCallSettings.Builder<GetGatewayRequest, Gateway> getGatewaySettings() {
      return getGatewaySettings;
    }

    /** Returns the builder for the settings used for calls to createGateway. */
    public UnaryCallSettings.Builder<CreateGatewayRequest, Operation> createGatewaySettings() {
      return createGatewaySettings;
    }

    /** Returns the builder for the settings used for calls to createGateway. */
    public OperationCallSettings.Builder<CreateGatewayRequest, Gateway, OperationMetadata>
        createGatewayOperationSettings() {
      return createGatewayOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateGateway. */
    public UnaryCallSettings.Builder<UpdateGatewayRequest, Operation> updateGatewaySettings() {
      return updateGatewaySettings;
    }

    /** Returns the builder for the settings used for calls to updateGateway. */
    public OperationCallSettings.Builder<UpdateGatewayRequest, Gateway, OperationMetadata>
        updateGatewayOperationSettings() {
      return updateGatewayOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGateway. */
    public UnaryCallSettings.Builder<DeleteGatewayRequest, Operation> deleteGatewaySettings() {
      return deleteGatewaySettings;
    }

    /** Returns the builder for the settings used for calls to deleteGateway. */
    public OperationCallSettings.Builder<DeleteGatewayRequest, Empty, OperationMetadata>
        deleteGatewayOperationSettings() {
      return deleteGatewayOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listGrpcRoutes. */
    public PagedCallSettings.Builder<
            ListGrpcRoutesRequest, ListGrpcRoutesResponse, ListGrpcRoutesPagedResponse>
        listGrpcRoutesSettings() {
      return listGrpcRoutesSettings;
    }

    /** Returns the builder for the settings used for calls to getGrpcRoute. */
    public UnaryCallSettings.Builder<GetGrpcRouteRequest, GrpcRoute> getGrpcRouteSettings() {
      return getGrpcRouteSettings;
    }

    /** Returns the builder for the settings used for calls to createGrpcRoute. */
    public UnaryCallSettings.Builder<CreateGrpcRouteRequest, Operation> createGrpcRouteSettings() {
      return createGrpcRouteSettings;
    }

    /** Returns the builder for the settings used for calls to createGrpcRoute. */
    public OperationCallSettings.Builder<CreateGrpcRouteRequest, GrpcRoute, OperationMetadata>
        createGrpcRouteOperationSettings() {
      return createGrpcRouteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateGrpcRoute. */
    public UnaryCallSettings.Builder<UpdateGrpcRouteRequest, Operation> updateGrpcRouteSettings() {
      return updateGrpcRouteSettings;
    }

    /** Returns the builder for the settings used for calls to updateGrpcRoute. */
    public OperationCallSettings.Builder<UpdateGrpcRouteRequest, GrpcRoute, OperationMetadata>
        updateGrpcRouteOperationSettings() {
      return updateGrpcRouteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGrpcRoute. */
    public UnaryCallSettings.Builder<DeleteGrpcRouteRequest, Operation> deleteGrpcRouteSettings() {
      return deleteGrpcRouteSettings;
    }

    /** Returns the builder for the settings used for calls to deleteGrpcRoute. */
    public OperationCallSettings.Builder<DeleteGrpcRouteRequest, Empty, OperationMetadata>
        deleteGrpcRouteOperationSettings() {
      return deleteGrpcRouteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listHttpRoutes. */
    public PagedCallSettings.Builder<
            ListHttpRoutesRequest, ListHttpRoutesResponse, ListHttpRoutesPagedResponse>
        listHttpRoutesSettings() {
      return listHttpRoutesSettings;
    }

    /** Returns the builder for the settings used for calls to getHttpRoute. */
    public UnaryCallSettings.Builder<GetHttpRouteRequest, HttpRoute> getHttpRouteSettings() {
      return getHttpRouteSettings;
    }

    /** Returns the builder for the settings used for calls to createHttpRoute. */
    public UnaryCallSettings.Builder<CreateHttpRouteRequest, Operation> createHttpRouteSettings() {
      return createHttpRouteSettings;
    }

    /** Returns the builder for the settings used for calls to createHttpRoute. */
    public OperationCallSettings.Builder<CreateHttpRouteRequest, HttpRoute, OperationMetadata>
        createHttpRouteOperationSettings() {
      return createHttpRouteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateHttpRoute. */
    public UnaryCallSettings.Builder<UpdateHttpRouteRequest, Operation> updateHttpRouteSettings() {
      return updateHttpRouteSettings;
    }

    /** Returns the builder for the settings used for calls to updateHttpRoute. */
    public OperationCallSettings.Builder<UpdateHttpRouteRequest, HttpRoute, OperationMetadata>
        updateHttpRouteOperationSettings() {
      return updateHttpRouteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteHttpRoute. */
    public UnaryCallSettings.Builder<DeleteHttpRouteRequest, Operation> deleteHttpRouteSettings() {
      return deleteHttpRouteSettings;
    }

    /** Returns the builder for the settings used for calls to deleteHttpRoute. */
    public OperationCallSettings.Builder<DeleteHttpRouteRequest, Empty, OperationMetadata>
        deleteHttpRouteOperationSettings() {
      return deleteHttpRouteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listTcpRoutes. */
    public PagedCallSettings.Builder<
            ListTcpRoutesRequest, ListTcpRoutesResponse, ListTcpRoutesPagedResponse>
        listTcpRoutesSettings() {
      return listTcpRoutesSettings;
    }

    /** Returns the builder for the settings used for calls to getTcpRoute. */
    public UnaryCallSettings.Builder<GetTcpRouteRequest, TcpRoute> getTcpRouteSettings() {
      return getTcpRouteSettings;
    }

    /** Returns the builder for the settings used for calls to createTcpRoute. */
    public UnaryCallSettings.Builder<CreateTcpRouteRequest, Operation> createTcpRouteSettings() {
      return createTcpRouteSettings;
    }

    /** Returns the builder for the settings used for calls to createTcpRoute. */
    public OperationCallSettings.Builder<CreateTcpRouteRequest, TcpRoute, OperationMetadata>
        createTcpRouteOperationSettings() {
      return createTcpRouteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateTcpRoute. */
    public UnaryCallSettings.Builder<UpdateTcpRouteRequest, Operation> updateTcpRouteSettings() {
      return updateTcpRouteSettings;
    }

    /** Returns the builder for the settings used for calls to updateTcpRoute. */
    public OperationCallSettings.Builder<UpdateTcpRouteRequest, TcpRoute, OperationMetadata>
        updateTcpRouteOperationSettings() {
      return updateTcpRouteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTcpRoute. */
    public UnaryCallSettings.Builder<DeleteTcpRouteRequest, Operation> deleteTcpRouteSettings() {
      return deleteTcpRouteSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTcpRoute. */
    public OperationCallSettings.Builder<DeleteTcpRouteRequest, Empty, OperationMetadata>
        deleteTcpRouteOperationSettings() {
      return deleteTcpRouteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listTlsRoutes. */
    public PagedCallSettings.Builder<
            ListTlsRoutesRequest, ListTlsRoutesResponse, ListTlsRoutesPagedResponse>
        listTlsRoutesSettings() {
      return listTlsRoutesSettings;
    }

    /** Returns the builder for the settings used for calls to getTlsRoute. */
    public UnaryCallSettings.Builder<GetTlsRouteRequest, TlsRoute> getTlsRouteSettings() {
      return getTlsRouteSettings;
    }

    /** Returns the builder for the settings used for calls to createTlsRoute. */
    public UnaryCallSettings.Builder<CreateTlsRouteRequest, Operation> createTlsRouteSettings() {
      return createTlsRouteSettings;
    }

    /** Returns the builder for the settings used for calls to createTlsRoute. */
    public OperationCallSettings.Builder<CreateTlsRouteRequest, TlsRoute, OperationMetadata>
        createTlsRouteOperationSettings() {
      return createTlsRouteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateTlsRoute. */
    public UnaryCallSettings.Builder<UpdateTlsRouteRequest, Operation> updateTlsRouteSettings() {
      return updateTlsRouteSettings;
    }

    /** Returns the builder for the settings used for calls to updateTlsRoute. */
    public OperationCallSettings.Builder<UpdateTlsRouteRequest, TlsRoute, OperationMetadata>
        updateTlsRouteOperationSettings() {
      return updateTlsRouteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTlsRoute. */
    public UnaryCallSettings.Builder<DeleteTlsRouteRequest, Operation> deleteTlsRouteSettings() {
      return deleteTlsRouteSettings;
    }

    /** Returns the builder for the settings used for calls to deleteTlsRoute. */
    public OperationCallSettings.Builder<DeleteTlsRouteRequest, Empty, OperationMetadata>
        deleteTlsRouteOperationSettings() {
      return deleteTlsRouteOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listServiceBindings. */
    public PagedCallSettings.Builder<
            ListServiceBindingsRequest,
            ListServiceBindingsResponse,
            ListServiceBindingsPagedResponse>
        listServiceBindingsSettings() {
      return listServiceBindingsSettings;
    }

    /** Returns the builder for the settings used for calls to getServiceBinding. */
    public UnaryCallSettings.Builder<GetServiceBindingRequest, ServiceBinding>
        getServiceBindingSettings() {
      return getServiceBindingSettings;
    }

    /** Returns the builder for the settings used for calls to createServiceBinding. */
    public UnaryCallSettings.Builder<CreateServiceBindingRequest, Operation>
        createServiceBindingSettings() {
      return createServiceBindingSettings;
    }

    /** Returns the builder for the settings used for calls to createServiceBinding. */
    public OperationCallSettings.Builder<
            CreateServiceBindingRequest, ServiceBinding, OperationMetadata>
        createServiceBindingOperationSettings() {
      return createServiceBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteServiceBinding. */
    public UnaryCallSettings.Builder<DeleteServiceBindingRequest, Operation>
        deleteServiceBindingSettings() {
      return deleteServiceBindingSettings;
    }

    /** Returns the builder for the settings used for calls to deleteServiceBinding. */
    public OperationCallSettings.Builder<DeleteServiceBindingRequest, Empty, OperationMetadata>
        deleteServiceBindingOperationSettings() {
      return deleteServiceBindingOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listMeshes. */
    public PagedCallSettings.Builder<ListMeshesRequest, ListMeshesResponse, ListMeshesPagedResponse>
        listMeshesSettings() {
      return listMeshesSettings;
    }

    /** Returns the builder for the settings used for calls to getMesh. */
    public UnaryCallSettings.Builder<GetMeshRequest, Mesh> getMeshSettings() {
      return getMeshSettings;
    }

    /** Returns the builder for the settings used for calls to createMesh. */
    public UnaryCallSettings.Builder<CreateMeshRequest, Operation> createMeshSettings() {
      return createMeshSettings;
    }

    /** Returns the builder for the settings used for calls to createMesh. */
    public OperationCallSettings.Builder<CreateMeshRequest, Mesh, OperationMetadata>
        createMeshOperationSettings() {
      return createMeshOperationSettings;
    }

    /** Returns the builder for the settings used for calls to updateMesh. */
    public UnaryCallSettings.Builder<UpdateMeshRequest, Operation> updateMeshSettings() {
      return updateMeshSettings;
    }

    /** Returns the builder for the settings used for calls to updateMesh. */
    public OperationCallSettings.Builder<UpdateMeshRequest, Mesh, OperationMetadata>
        updateMeshOperationSettings() {
      return updateMeshOperationSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMesh. */
    public UnaryCallSettings.Builder<DeleteMeshRequest, Operation> deleteMeshSettings() {
      return deleteMeshSettings;
    }

    /** Returns the builder for the settings used for calls to deleteMesh. */
    public OperationCallSettings.Builder<DeleteMeshRequest, Empty, OperationMetadata>
        deleteMeshOperationSettings() {
      return deleteMeshOperationSettings;
    }

    /** Returns the builder for the settings used for calls to listLocations. */
    public PagedCallSettings.Builder<
            ListLocationsRequest, ListLocationsResponse, ListLocationsPagedResponse>
        listLocationsSettings() {
      return listLocationsSettings;
    }

    /** Returns the builder for the settings used for calls to getLocation. */
    public UnaryCallSettings.Builder<GetLocationRequest, Location> getLocationSettings() {
      return getLocationSettings;
    }

    /** Returns the builder for the settings used for calls to setIamPolicy. */
    public UnaryCallSettings.Builder<SetIamPolicyRequest, Policy> setIamPolicySettings() {
      return setIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to getIamPolicy. */
    public UnaryCallSettings.Builder<GetIamPolicyRequest, Policy> getIamPolicySettings() {
      return getIamPolicySettings;
    }

    /** Returns the builder for the settings used for calls to testIamPermissions. */
    public UnaryCallSettings.Builder<TestIamPermissionsRequest, TestIamPermissionsResponse>
        testIamPermissionsSettings() {
      return testIamPermissionsSettings;
    }

    @Override
    public NetworkServicesStubSettings build() throws IOException {
      return new NetworkServicesStubSettings(this);
    }
  }
}
