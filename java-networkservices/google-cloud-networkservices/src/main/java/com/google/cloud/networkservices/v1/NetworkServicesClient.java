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

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.networkservices.v1.stub.NetworkServicesStub;
import com.google.cloud.networkservices.v1.stub.NetworkServicesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * This class provides the ability to make remote calls to the backing service through method calls
 * that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
 *   EndpointPolicyName name =
 *       EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]");
 *   EndpointPolicy response = networkServicesClient.getEndpointPolicy(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the NetworkServicesClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListEndpointPolicies</td>
 *      <td><p> Lists EndpointPolicies in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEndpointPolicies(ListEndpointPoliciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEndpointPolicies(LocationName parent)
 *           <li><p> listEndpointPolicies(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEndpointPoliciesPagedCallable()
 *           <li><p> listEndpointPoliciesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEndpointPolicy</td>
 *      <td><p> Gets details of a single EndpointPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEndpointPolicy(GetEndpointPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEndpointPolicy(EndpointPolicyName name)
 *           <li><p> getEndpointPolicy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEndpointPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateEndpointPolicy</td>
 *      <td><p> Creates a new EndpointPolicy in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createEndpointPolicyAsync(CreateEndpointPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createEndpointPolicyAsync(LocationName parent, EndpointPolicy endpointPolicy, String endpointPolicyId)
 *           <li><p> createEndpointPolicyAsync(String parent, EndpointPolicy endpointPolicy, String endpointPolicyId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createEndpointPolicyOperationCallable()
 *           <li><p> createEndpointPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateEndpointPolicy</td>
 *      <td><p> Updates the parameters of a single EndpointPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateEndpointPolicyAsync(UpdateEndpointPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateEndpointPolicyAsync(EndpointPolicy endpointPolicy, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateEndpointPolicyOperationCallable()
 *           <li><p> updateEndpointPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteEndpointPolicy</td>
 *      <td><p> Deletes a single EndpointPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteEndpointPolicyAsync(DeleteEndpointPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteEndpointPolicyAsync(EndpointPolicyName name)
 *           <li><p> deleteEndpointPolicyAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteEndpointPolicyOperationCallable()
 *           <li><p> deleteEndpointPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListGateways</td>
 *      <td><p> Lists Gateways in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listGateways(ListGatewaysRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listGateways(LocationName parent)
 *           <li><p> listGateways(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listGatewaysPagedCallable()
 *           <li><p> listGatewaysCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetGateway</td>
 *      <td><p> Gets details of a single Gateway.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getGateway(GetGatewayRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getGateway(GatewayName name)
 *           <li><p> getGateway(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getGatewayCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateGateway</td>
 *      <td><p> Creates a new Gateway in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createGatewayAsync(CreateGatewayRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createGatewayAsync(LocationName parent, Gateway gateway, String gatewayId)
 *           <li><p> createGatewayAsync(String parent, Gateway gateway, String gatewayId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createGatewayOperationCallable()
 *           <li><p> createGatewayCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateGateway</td>
 *      <td><p> Updates the parameters of a single Gateway.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateGatewayAsync(UpdateGatewayRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateGatewayAsync(Gateway gateway, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateGatewayOperationCallable()
 *           <li><p> updateGatewayCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteGateway</td>
 *      <td><p> Deletes a single Gateway.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteGatewayAsync(DeleteGatewayRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteGatewayAsync(GatewayName name)
 *           <li><p> deleteGatewayAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteGatewayOperationCallable()
 *           <li><p> deleteGatewayCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListGrpcRoutes</td>
 *      <td><p> Lists GrpcRoutes in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listGrpcRoutes(ListGrpcRoutesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listGrpcRoutes(LocationName parent)
 *           <li><p> listGrpcRoutes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listGrpcRoutesPagedCallable()
 *           <li><p> listGrpcRoutesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetGrpcRoute</td>
 *      <td><p> Gets details of a single GrpcRoute.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getGrpcRoute(GetGrpcRouteRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getGrpcRoute(GrpcRouteName name)
 *           <li><p> getGrpcRoute(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getGrpcRouteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateGrpcRoute</td>
 *      <td><p> Creates a new GrpcRoute in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createGrpcRouteAsync(CreateGrpcRouteRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createGrpcRouteAsync(LocationName parent, GrpcRoute grpcRoute, String grpcRouteId)
 *           <li><p> createGrpcRouteAsync(String parent, GrpcRoute grpcRoute, String grpcRouteId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createGrpcRouteOperationCallable()
 *           <li><p> createGrpcRouteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateGrpcRoute</td>
 *      <td><p> Updates the parameters of a single GrpcRoute.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateGrpcRouteAsync(UpdateGrpcRouteRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateGrpcRouteAsync(GrpcRoute grpcRoute, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateGrpcRouteOperationCallable()
 *           <li><p> updateGrpcRouteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteGrpcRoute</td>
 *      <td><p> Deletes a single GrpcRoute.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteGrpcRouteAsync(DeleteGrpcRouteRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteGrpcRouteAsync(GrpcRouteName name)
 *           <li><p> deleteGrpcRouteAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteGrpcRouteOperationCallable()
 *           <li><p> deleteGrpcRouteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListHttpRoutes</td>
 *      <td><p> Lists HttpRoute in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listHttpRoutes(ListHttpRoutesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listHttpRoutes(LocationName parent)
 *           <li><p> listHttpRoutes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listHttpRoutesPagedCallable()
 *           <li><p> listHttpRoutesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetHttpRoute</td>
 *      <td><p> Gets details of a single HttpRoute.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getHttpRoute(GetHttpRouteRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getHttpRoute(HttpRouteName name)
 *           <li><p> getHttpRoute(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getHttpRouteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateHttpRoute</td>
 *      <td><p> Creates a new HttpRoute in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createHttpRouteAsync(CreateHttpRouteRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createHttpRouteAsync(LocationName parent, HttpRoute httpRoute, String httpRouteId)
 *           <li><p> createHttpRouteAsync(String parent, HttpRoute httpRoute, String httpRouteId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createHttpRouteOperationCallable()
 *           <li><p> createHttpRouteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateHttpRoute</td>
 *      <td><p> Updates the parameters of a single HttpRoute.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateHttpRouteAsync(UpdateHttpRouteRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateHttpRouteAsync(HttpRoute httpRoute, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateHttpRouteOperationCallable()
 *           <li><p> updateHttpRouteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteHttpRoute</td>
 *      <td><p> Deletes a single HttpRoute.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteHttpRouteAsync(DeleteHttpRouteRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteHttpRouteAsync(HttpRouteName name)
 *           <li><p> deleteHttpRouteAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteHttpRouteOperationCallable()
 *           <li><p> deleteHttpRouteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTcpRoutes</td>
 *      <td><p> Lists TcpRoute in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTcpRoutes(ListTcpRoutesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTcpRoutes(LocationName parent)
 *           <li><p> listTcpRoutes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTcpRoutesPagedCallable()
 *           <li><p> listTcpRoutesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTcpRoute</td>
 *      <td><p> Gets details of a single TcpRoute.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTcpRoute(GetTcpRouteRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTcpRoute(TcpRouteName name)
 *           <li><p> getTcpRoute(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTcpRouteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTcpRoute</td>
 *      <td><p> Creates a new TcpRoute in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTcpRouteAsync(CreateTcpRouteRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createTcpRouteAsync(LocationName parent, TcpRoute tcpRoute, String tcpRouteId)
 *           <li><p> createTcpRouteAsync(String parent, TcpRoute tcpRoute, String tcpRouteId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTcpRouteOperationCallable()
 *           <li><p> createTcpRouteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTcpRoute</td>
 *      <td><p> Updates the parameters of a single TcpRoute.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTcpRouteAsync(UpdateTcpRouteRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateTcpRouteAsync(TcpRoute tcpRoute, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateTcpRouteOperationCallable()
 *           <li><p> updateTcpRouteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTcpRoute</td>
 *      <td><p> Deletes a single TcpRoute.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTcpRouteAsync(DeleteTcpRouteRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteTcpRouteAsync(TcpRouteName name)
 *           <li><p> deleteTcpRouteAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteTcpRouteOperationCallable()
 *           <li><p> deleteTcpRouteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTlsRoutes</td>
 *      <td><p> Lists TlsRoute in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTlsRoutes(ListTlsRoutesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTlsRoutes(LocationName parent)
 *           <li><p> listTlsRoutes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTlsRoutesPagedCallable()
 *           <li><p> listTlsRoutesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTlsRoute</td>
 *      <td><p> Gets details of a single TlsRoute.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTlsRoute(GetTlsRouteRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTlsRoute(TlsRouteName name)
 *           <li><p> getTlsRoute(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTlsRouteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTlsRoute</td>
 *      <td><p> Creates a new TlsRoute in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTlsRouteAsync(CreateTlsRouteRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createTlsRouteAsync(LocationName parent, TlsRoute tlsRoute, String tlsRouteId)
 *           <li><p> createTlsRouteAsync(String parent, TlsRoute tlsRoute, String tlsRouteId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTlsRouteOperationCallable()
 *           <li><p> createTlsRouteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTlsRoute</td>
 *      <td><p> Updates the parameters of a single TlsRoute.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTlsRouteAsync(UpdateTlsRouteRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateTlsRouteAsync(TlsRoute tlsRoute, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateTlsRouteOperationCallable()
 *           <li><p> updateTlsRouteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTlsRoute</td>
 *      <td><p> Deletes a single TlsRoute.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTlsRouteAsync(DeleteTlsRouteRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteTlsRouteAsync(TlsRouteName name)
 *           <li><p> deleteTlsRouteAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteTlsRouteOperationCallable()
 *           <li><p> deleteTlsRouteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListServiceBindings</td>
 *      <td><p> Lists ServiceBinding in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listServiceBindings(ListServiceBindingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listServiceBindings(LocationName parent)
 *           <li><p> listServiceBindings(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listServiceBindingsPagedCallable()
 *           <li><p> listServiceBindingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetServiceBinding</td>
 *      <td><p> Gets details of a single ServiceBinding.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getServiceBinding(GetServiceBindingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getServiceBinding(ServiceBindingName name)
 *           <li><p> getServiceBinding(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getServiceBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateServiceBinding</td>
 *      <td><p> Creates a new ServiceBinding in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createServiceBindingAsync(CreateServiceBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createServiceBindingAsync(LocationName parent, ServiceBinding serviceBinding, String serviceBindingId)
 *           <li><p> createServiceBindingAsync(String parent, ServiceBinding serviceBinding, String serviceBindingId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createServiceBindingOperationCallable()
 *           <li><p> createServiceBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteServiceBinding</td>
 *      <td><p> Deletes a single ServiceBinding.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteServiceBindingAsync(DeleteServiceBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteServiceBindingAsync(ServiceBindingName name)
 *           <li><p> deleteServiceBindingAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteServiceBindingOperationCallable()
 *           <li><p> deleteServiceBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMeshes</td>
 *      <td><p> Lists Meshes in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMeshes(ListMeshesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMeshes(LocationName parent)
 *           <li><p> listMeshes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMeshesPagedCallable()
 *           <li><p> listMeshesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMesh</td>
 *      <td><p> Gets details of a single Mesh.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMesh(GetMeshRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMesh(MeshName name)
 *           <li><p> getMesh(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMeshCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateMesh</td>
 *      <td><p> Creates a new Mesh in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createMeshAsync(CreateMeshRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createMeshAsync(LocationName parent, Mesh mesh, String meshId)
 *           <li><p> createMeshAsync(String parent, Mesh mesh, String meshId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createMeshOperationCallable()
 *           <li><p> createMeshCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateMesh</td>
 *      <td><p> Updates the parameters of a single Mesh.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateMeshAsync(UpdateMeshRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateMeshAsync(Mesh mesh, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateMeshOperationCallable()
 *           <li><p> updateMeshCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteMesh</td>
 *      <td><p> Deletes a single Mesh.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteMeshAsync(DeleteMeshRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteMeshAsync(MeshName name)
 *           <li><p> deleteMeshAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteMeshOperationCallable()
 *           <li><p> deleteMeshCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLocationsPagedCallable()
 *           <li><p> listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified resource. Replacesany existing policy.
 * <p> Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a resource. Returns an empty policyif the resource exists and does not have a policy set.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified resource. If theresource does not exist, this will return an empty set ofpermissions, not a `NOT_FOUND` error.
 * <p> Note: This operation is designed to be used for buildingpermission-aware UIs and command-line tools, not for authorizationchecking. This operation may "fail open" without warning.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of NetworkServicesSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NetworkServicesSettings networkServicesSettings =
 *     NetworkServicesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NetworkServicesClient networkServicesClient =
 *     NetworkServicesClient.create(networkServicesSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NetworkServicesSettings networkServicesSettings =
 *     NetworkServicesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NetworkServicesClient networkServicesClient =
 *     NetworkServicesClient.create(networkServicesSettings);
 * }</pre>
 *
 * <p>To use REST (HTTP1.1/JSON) transport (instead of gRPC) for sending and receiving requests over
 * the wire:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * NetworkServicesSettings networkServicesSettings =
 *     NetworkServicesSettings.newHttpJsonBuilder().build();
 * NetworkServicesClient networkServicesClient =
 *     NetworkServicesClient.create(networkServicesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class NetworkServicesClient implements BackgroundResource {
  private final NetworkServicesSettings settings;
  private final NetworkServicesStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of NetworkServicesClient with default settings. */
  public static final NetworkServicesClient create() throws IOException {
    return create(NetworkServicesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NetworkServicesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final NetworkServicesClient create(NetworkServicesSettings settings)
      throws IOException {
    return new NetworkServicesClient(settings);
  }

  /**
   * Constructs an instance of NetworkServicesClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(NetworkServicesSettings).
   */
  public static final NetworkServicesClient create(NetworkServicesStub stub) {
    return new NetworkServicesClient(stub);
  }

  /**
   * Constructs an instance of NetworkServicesClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected NetworkServicesClient(NetworkServicesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((NetworkServicesStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected NetworkServicesClient(NetworkServicesStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final NetworkServicesSettings getSettings() {
    return settings;
  }

  public NetworkServicesStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EndpointPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (EndpointPolicy element :
   *       networkServicesClient.listEndpointPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the EndpointPolicies should be
   *     listed, specified in the format `projects/&#42;/locations/global`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEndpointPoliciesPagedResponse listEndpointPolicies(LocationName parent) {
    ListEndpointPoliciesRequest request =
        ListEndpointPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEndpointPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EndpointPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (EndpointPolicy element :
   *       networkServicesClient.listEndpointPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the EndpointPolicies should be
   *     listed, specified in the format `projects/&#42;/locations/global`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEndpointPoliciesPagedResponse listEndpointPolicies(String parent) {
    ListEndpointPoliciesRequest request =
        ListEndpointPoliciesRequest.newBuilder().setParent(parent).build();
    return listEndpointPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EndpointPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListEndpointPoliciesRequest request =
   *       ListEndpointPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (EndpointPolicy element :
   *       networkServicesClient.listEndpointPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEndpointPoliciesPagedResponse listEndpointPolicies(
      ListEndpointPoliciesRequest request) {
    return listEndpointPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EndpointPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListEndpointPoliciesRequest request =
   *       ListEndpointPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<EndpointPolicy> future =
   *       networkServicesClient.listEndpointPoliciesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (EndpointPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEndpointPoliciesRequest, ListEndpointPoliciesPagedResponse>
      listEndpointPoliciesPagedCallable() {
    return stub.listEndpointPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists EndpointPolicies in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListEndpointPoliciesRequest request =
   *       ListEndpointPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListEndpointPoliciesResponse response =
   *         networkServicesClient.listEndpointPoliciesCallable().call(request);
   *     for (EndpointPolicy element : response.getEndpointPoliciesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse>
      listEndpointPoliciesCallable() {
    return stub.listEndpointPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   EndpointPolicyName name =
   *       EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]");
   *   EndpointPolicy response = networkServicesClient.getEndpointPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the EndpointPolicy to get. Must be in the format
   *     `projects/&#42;/locations/global/endpointPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EndpointPolicy getEndpointPolicy(EndpointPolicyName name) {
    GetEndpointPolicyRequest request =
        GetEndpointPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getEndpointPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String name =
   *       EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString();
   *   EndpointPolicy response = networkServicesClient.getEndpointPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the EndpointPolicy to get. Must be in the format
   *     `projects/&#42;/locations/global/endpointPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EndpointPolicy getEndpointPolicy(String name) {
    GetEndpointPolicyRequest request = GetEndpointPolicyRequest.newBuilder().setName(name).build();
    return getEndpointPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetEndpointPolicyRequest request =
   *       GetEndpointPolicyRequest.newBuilder()
   *           .setName(
   *               EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
   *           .build();
   *   EndpointPolicy response = networkServicesClient.getEndpointPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EndpointPolicy getEndpointPolicy(GetEndpointPolicyRequest request) {
    return getEndpointPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetEndpointPolicyRequest request =
   *       GetEndpointPolicyRequest.newBuilder()
   *           .setName(
   *               EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
   *           .build();
   *   ApiFuture<EndpointPolicy> future =
   *       networkServicesClient.getEndpointPolicyCallable().futureCall(request);
   *   // Do something.
   *   EndpointPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEndpointPolicyRequest, EndpointPolicy> getEndpointPolicyCallable() {
    return stub.getEndpointPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new EndpointPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   EndpointPolicy endpointPolicy = EndpointPolicy.newBuilder().build();
   *   String endpointPolicyId = "endpointPolicyId-509458782";
   *   EndpointPolicy response =
   *       networkServicesClient
   *           .createEndpointPolicyAsync(parent, endpointPolicy, endpointPolicyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the EndpointPolicy. Must be in the format
   *     `projects/&#42;/locations/global`.
   * @param endpointPolicy Required. EndpointPolicy resource to be created.
   * @param endpointPolicyId Required. Short name of the EndpointPolicy resource to be created. E.g.
   *     "CustomECS".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EndpointPolicy, OperationMetadata> createEndpointPolicyAsync(
      LocationName parent, EndpointPolicy endpointPolicy, String endpointPolicyId) {
    CreateEndpointPolicyRequest request =
        CreateEndpointPolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEndpointPolicy(endpointPolicy)
            .setEndpointPolicyId(endpointPolicyId)
            .build();
    return createEndpointPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new EndpointPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   EndpointPolicy endpointPolicy = EndpointPolicy.newBuilder().build();
   *   String endpointPolicyId = "endpointPolicyId-509458782";
   *   EndpointPolicy response =
   *       networkServicesClient
   *           .createEndpointPolicyAsync(parent, endpointPolicy, endpointPolicyId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the EndpointPolicy. Must be in the format
   *     `projects/&#42;/locations/global`.
   * @param endpointPolicy Required. EndpointPolicy resource to be created.
   * @param endpointPolicyId Required. Short name of the EndpointPolicy resource to be created. E.g.
   *     "CustomECS".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EndpointPolicy, OperationMetadata> createEndpointPolicyAsync(
      String parent, EndpointPolicy endpointPolicy, String endpointPolicyId) {
    CreateEndpointPolicyRequest request =
        CreateEndpointPolicyRequest.newBuilder()
            .setParent(parent)
            .setEndpointPolicy(endpointPolicy)
            .setEndpointPolicyId(endpointPolicyId)
            .build();
    return createEndpointPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new EndpointPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateEndpointPolicyRequest request =
   *       CreateEndpointPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEndpointPolicyId("endpointPolicyId-509458782")
   *           .setEndpointPolicy(EndpointPolicy.newBuilder().build())
   *           .build();
   *   EndpointPolicy response = networkServicesClient.createEndpointPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EndpointPolicy, OperationMetadata> createEndpointPolicyAsync(
      CreateEndpointPolicyRequest request) {
    return createEndpointPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new EndpointPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateEndpointPolicyRequest request =
   *       CreateEndpointPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEndpointPolicyId("endpointPolicyId-509458782")
   *           .setEndpointPolicy(EndpointPolicy.newBuilder().build())
   *           .build();
   *   OperationFuture<EndpointPolicy, OperationMetadata> future =
   *       networkServicesClient.createEndpointPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   EndpointPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      createEndpointPolicyOperationCallable() {
    return stub.createEndpointPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new EndpointPolicy in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateEndpointPolicyRequest request =
   *       CreateEndpointPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setEndpointPolicyId("endpointPolicyId-509458782")
   *           .setEndpointPolicy(EndpointPolicy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkServicesClient.createEndpointPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEndpointPolicyRequest, Operation>
      createEndpointPolicyCallable() {
    return stub.createEndpointPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   EndpointPolicy endpointPolicy = EndpointPolicy.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   EndpointPolicy response =
   *       networkServicesClient.updateEndpointPolicyAsync(endpointPolicy, updateMask).get();
   * }
   * }</pre>
   *
   * @param endpointPolicy Required. Updated EndpointPolicy resource.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     EndpointPolicy resource by the update. The fields specified in the update_mask are relative
   *     to the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EndpointPolicy, OperationMetadata> updateEndpointPolicyAsync(
      EndpointPolicy endpointPolicy, FieldMask updateMask) {
    UpdateEndpointPolicyRequest request =
        UpdateEndpointPolicyRequest.newBuilder()
            .setEndpointPolicy(endpointPolicy)
            .setUpdateMask(updateMask)
            .build();
    return updateEndpointPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateEndpointPolicyRequest request =
   *       UpdateEndpointPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setEndpointPolicy(EndpointPolicy.newBuilder().build())
   *           .build();
   *   EndpointPolicy response = networkServicesClient.updateEndpointPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EndpointPolicy, OperationMetadata> updateEndpointPolicyAsync(
      UpdateEndpointPolicyRequest request) {
    return updateEndpointPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateEndpointPolicyRequest request =
   *       UpdateEndpointPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setEndpointPolicy(EndpointPolicy.newBuilder().build())
   *           .build();
   *   OperationFuture<EndpointPolicy, OperationMetadata> future =
   *       networkServicesClient.updateEndpointPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   EndpointPolicy response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateEndpointPolicyRequest, EndpointPolicy, OperationMetadata>
      updateEndpointPolicyOperationCallable() {
    return stub.updateEndpointPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateEndpointPolicyRequest request =
   *       UpdateEndpointPolicyRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setEndpointPolicy(EndpointPolicy.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkServicesClient.updateEndpointPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEndpointPolicyRequest, Operation>
      updateEndpointPolicyCallable() {
    return stub.updateEndpointPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   EndpointPolicyName name =
   *       EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]");
   *   networkServicesClient.deleteEndpointPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the EndpointPolicy to delete. Must be in the format
   *     `projects/&#42;/locations/global/endpointPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEndpointPolicyAsync(
      EndpointPolicyName name) {
    DeleteEndpointPolicyRequest request =
        DeleteEndpointPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteEndpointPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String name =
   *       EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString();
   *   networkServicesClient.deleteEndpointPolicyAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the EndpointPolicy to delete. Must be in the format
   *     `projects/&#42;/locations/global/endpointPolicies/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEndpointPolicyAsync(String name) {
    DeleteEndpointPolicyRequest request =
        DeleteEndpointPolicyRequest.newBuilder().setName(name).build();
    return deleteEndpointPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteEndpointPolicyRequest request =
   *       DeleteEndpointPolicyRequest.newBuilder()
   *           .setName(
   *               EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
   *           .build();
   *   networkServicesClient.deleteEndpointPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteEndpointPolicyAsync(
      DeleteEndpointPolicyRequest request) {
    return deleteEndpointPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteEndpointPolicyRequest request =
   *       DeleteEndpointPolicyRequest.newBuilder()
   *           .setName(
   *               EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       networkServicesClient.deleteEndpointPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteEndpointPolicyRequest, Empty, OperationMetadata>
      deleteEndpointPolicyOperationCallable() {
    return stub.deleteEndpointPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single EndpointPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteEndpointPolicyRequest request =
   *       DeleteEndpointPolicyRequest.newBuilder()
   *           .setName(
   *               EndpointPolicyName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT_POLICY]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkServicesClient.deleteEndpointPolicyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEndpointPolicyRequest, Operation>
      deleteEndpointPolicyCallable() {
    return stub.deleteEndpointPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Gateways in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Gateway element : networkServicesClient.listGateways(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the Gateways should be listed,
   *     specified in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGatewaysPagedResponse listGateways(LocationName parent) {
    ListGatewaysRequest request =
        ListGatewaysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGateways(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Gateways in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Gateway element : networkServicesClient.listGateways(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the Gateways should be listed,
   *     specified in the format `projects/&#42;/locations/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGatewaysPagedResponse listGateways(String parent) {
    ListGatewaysRequest request = ListGatewaysRequest.newBuilder().setParent(parent).build();
    return listGateways(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Gateways in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListGatewaysRequest request =
   *       ListGatewaysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Gateway element : networkServicesClient.listGateways(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGatewaysPagedResponse listGateways(ListGatewaysRequest request) {
    return listGatewaysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Gateways in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListGatewaysRequest request =
   *       ListGatewaysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Gateway> future =
   *       networkServicesClient.listGatewaysPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Gateway element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGatewaysRequest, ListGatewaysPagedResponse>
      listGatewaysPagedCallable() {
    return stub.listGatewaysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Gateways in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListGatewaysRequest request =
   *       ListGatewaysRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListGatewaysResponse response = networkServicesClient.listGatewaysCallable().call(request);
   *     for (Gateway element : response.getGatewaysList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGatewaysRequest, ListGatewaysResponse> listGatewaysCallable() {
    return stub.listGatewaysCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GatewayName name = GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]");
   *   Gateway response = networkServicesClient.getGateway(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the Gateway to get. Must be in the format
   *     `projects/&#42;/locations/&#42;/gateways/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Gateway getGateway(GatewayName name) {
    GetGatewayRequest request =
        GetGatewayRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String name = GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString();
   *   Gateway response = networkServicesClient.getGateway(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the Gateway to get. Must be in the format
   *     `projects/&#42;/locations/&#42;/gateways/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Gateway getGateway(String name) {
    GetGatewayRequest request = GetGatewayRequest.newBuilder().setName(name).build();
    return getGateway(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetGatewayRequest request =
   *       GetGatewayRequest.newBuilder()
   *           .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
   *           .build();
   *   Gateway response = networkServicesClient.getGateway(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Gateway getGateway(GetGatewayRequest request) {
    return getGatewayCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetGatewayRequest request =
   *       GetGatewayRequest.newBuilder()
   *           .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
   *           .build();
   *   ApiFuture<Gateway> future = networkServicesClient.getGatewayCallable().futureCall(request);
   *   // Do something.
   *   Gateway response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGatewayRequest, Gateway> getGatewayCallable() {
    return stub.getGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Gateway in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Gateway gateway = Gateway.newBuilder().build();
   *   String gatewayId = "gatewayId-1354641793";
   *   Gateway response = networkServicesClient.createGatewayAsync(parent, gateway, gatewayId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the Gateway. Must be in the format
   *     `projects/&#42;/locations/&#42;`.
   * @param gateway Required. Gateway resource to be created.
   * @param gatewayId Required. Short name of the Gateway resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Gateway, OperationMetadata> createGatewayAsync(
      LocationName parent, Gateway gateway, String gatewayId) {
    CreateGatewayRequest request =
        CreateGatewayRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGateway(gateway)
            .setGatewayId(gatewayId)
            .build();
    return createGatewayAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Gateway in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Gateway gateway = Gateway.newBuilder().build();
   *   String gatewayId = "gatewayId-1354641793";
   *   Gateway response = networkServicesClient.createGatewayAsync(parent, gateway, gatewayId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the Gateway. Must be in the format
   *     `projects/&#42;/locations/&#42;`.
   * @param gateway Required. Gateway resource to be created.
   * @param gatewayId Required. Short name of the Gateway resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Gateway, OperationMetadata> createGatewayAsync(
      String parent, Gateway gateway, String gatewayId) {
    CreateGatewayRequest request =
        CreateGatewayRequest.newBuilder()
            .setParent(parent)
            .setGateway(gateway)
            .setGatewayId(gatewayId)
            .build();
    return createGatewayAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Gateway in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateGatewayRequest request =
   *       CreateGatewayRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGatewayId("gatewayId-1354641793")
   *           .setGateway(Gateway.newBuilder().build())
   *           .build();
   *   Gateway response = networkServicesClient.createGatewayAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Gateway, OperationMetadata> createGatewayAsync(
      CreateGatewayRequest request) {
    return createGatewayOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Gateway in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateGatewayRequest request =
   *       CreateGatewayRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGatewayId("gatewayId-1354641793")
   *           .setGateway(Gateway.newBuilder().build())
   *           .build();
   *   OperationFuture<Gateway, OperationMetadata> future =
   *       networkServicesClient.createGatewayOperationCallable().futureCall(request);
   *   // Do something.
   *   Gateway response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateGatewayRequest, Gateway, OperationMetadata>
      createGatewayOperationCallable() {
    return stub.createGatewayOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Gateway in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateGatewayRequest request =
   *       CreateGatewayRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGatewayId("gatewayId-1354641793")
   *           .setGateway(Gateway.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkServicesClient.createGatewayCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGatewayRequest, Operation> createGatewayCallable() {
    return stub.createGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   Gateway gateway = Gateway.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Gateway response = networkServicesClient.updateGatewayAsync(gateway, updateMask).get();
   * }
   * }</pre>
   *
   * @param gateway Required. Updated Gateway resource.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     Gateway resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Gateway, OperationMetadata> updateGatewayAsync(
      Gateway gateway, FieldMask updateMask) {
    UpdateGatewayRequest request =
        UpdateGatewayRequest.newBuilder().setGateway(gateway).setUpdateMask(updateMask).build();
    return updateGatewayAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateGatewayRequest request =
   *       UpdateGatewayRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGateway(Gateway.newBuilder().build())
   *           .build();
   *   Gateway response = networkServicesClient.updateGatewayAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Gateway, OperationMetadata> updateGatewayAsync(
      UpdateGatewayRequest request) {
    return updateGatewayOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateGatewayRequest request =
   *       UpdateGatewayRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGateway(Gateway.newBuilder().build())
   *           .build();
   *   OperationFuture<Gateway, OperationMetadata> future =
   *       networkServicesClient.updateGatewayOperationCallable().futureCall(request);
   *   // Do something.
   *   Gateway response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateGatewayRequest, Gateway, OperationMetadata>
      updateGatewayOperationCallable() {
    return stub.updateGatewayOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateGatewayRequest request =
   *       UpdateGatewayRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGateway(Gateway.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkServicesClient.updateGatewayCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGatewayRequest, Operation> updateGatewayCallable() {
    return stub.updateGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GatewayName name = GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]");
   *   networkServicesClient.deleteGatewayAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the Gateway to delete. Must be in the format
   *     `projects/&#42;/locations/&#42;/gateways/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGatewayAsync(GatewayName name) {
    DeleteGatewayRequest request =
        DeleteGatewayRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteGatewayAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String name = GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString();
   *   networkServicesClient.deleteGatewayAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the Gateway to delete. Must be in the format
   *     `projects/&#42;/locations/&#42;/gateways/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGatewayAsync(String name) {
    DeleteGatewayRequest request = DeleteGatewayRequest.newBuilder().setName(name).build();
    return deleteGatewayAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteGatewayRequest request =
   *       DeleteGatewayRequest.newBuilder()
   *           .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
   *           .build();
   *   networkServicesClient.deleteGatewayAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGatewayAsync(
      DeleteGatewayRequest request) {
    return deleteGatewayOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteGatewayRequest request =
   *       DeleteGatewayRequest.newBuilder()
   *           .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       networkServicesClient.deleteGatewayOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteGatewayRequest, Empty, OperationMetadata>
      deleteGatewayOperationCallable() {
    return stub.deleteGatewayOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Gateway.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteGatewayRequest request =
   *       DeleteGatewayRequest.newBuilder()
   *           .setName(GatewayName.of("[PROJECT]", "[LOCATION]", "[GATEWAY]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkServicesClient.deleteGatewayCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGatewayRequest, Operation> deleteGatewayCallable() {
    return stub.deleteGatewayCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GrpcRoutes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (GrpcRoute element : networkServicesClient.listGrpcRoutes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the GrpcRoutes should be listed,
   *     specified in the format `projects/&#42;/locations/global`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGrpcRoutesPagedResponse listGrpcRoutes(LocationName parent) {
    ListGrpcRoutesRequest request =
        ListGrpcRoutesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGrpcRoutes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GrpcRoutes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (GrpcRoute element : networkServicesClient.listGrpcRoutes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the GrpcRoutes should be listed,
   *     specified in the format `projects/&#42;/locations/global`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGrpcRoutesPagedResponse listGrpcRoutes(String parent) {
    ListGrpcRoutesRequest request = ListGrpcRoutesRequest.newBuilder().setParent(parent).build();
    return listGrpcRoutes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GrpcRoutes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListGrpcRoutesRequest request =
   *       ListGrpcRoutesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (GrpcRoute element : networkServicesClient.listGrpcRoutes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGrpcRoutesPagedResponse listGrpcRoutes(ListGrpcRoutesRequest request) {
    return listGrpcRoutesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GrpcRoutes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListGrpcRoutesRequest request =
   *       ListGrpcRoutesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<GrpcRoute> future =
   *       networkServicesClient.listGrpcRoutesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (GrpcRoute element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGrpcRoutesRequest, ListGrpcRoutesPagedResponse>
      listGrpcRoutesPagedCallable() {
    return stub.listGrpcRoutesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists GrpcRoutes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListGrpcRoutesRequest request =
   *       ListGrpcRoutesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListGrpcRoutesResponse response =
   *         networkServicesClient.listGrpcRoutesCallable().call(request);
   *     for (GrpcRoute element : response.getGrpcRoutesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGrpcRoutesRequest, ListGrpcRoutesResponse>
      listGrpcRoutesCallable() {
    return stub.listGrpcRoutesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single GrpcRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GrpcRouteName name = GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]");
   *   GrpcRoute response = networkServicesClient.getGrpcRoute(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the GrpcRoute to get. Must be in the format
   *     `projects/&#42;/locations/global/grpcRoutes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GrpcRoute getGrpcRoute(GrpcRouteName name) {
    GetGrpcRouteRequest request =
        GetGrpcRouteRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getGrpcRoute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single GrpcRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String name = GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]").toString();
   *   GrpcRoute response = networkServicesClient.getGrpcRoute(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the GrpcRoute to get. Must be in the format
   *     `projects/&#42;/locations/global/grpcRoutes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GrpcRoute getGrpcRoute(String name) {
    GetGrpcRouteRequest request = GetGrpcRouteRequest.newBuilder().setName(name).build();
    return getGrpcRoute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single GrpcRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetGrpcRouteRequest request =
   *       GetGrpcRouteRequest.newBuilder()
   *           .setName(GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]").toString())
   *           .build();
   *   GrpcRoute response = networkServicesClient.getGrpcRoute(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GrpcRoute getGrpcRoute(GetGrpcRouteRequest request) {
    return getGrpcRouteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single GrpcRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetGrpcRouteRequest request =
   *       GetGrpcRouteRequest.newBuilder()
   *           .setName(GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]").toString())
   *           .build();
   *   ApiFuture<GrpcRoute> future =
   *       networkServicesClient.getGrpcRouteCallable().futureCall(request);
   *   // Do something.
   *   GrpcRoute response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGrpcRouteRequest, GrpcRoute> getGrpcRouteCallable() {
    return stub.getGrpcRouteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new GrpcRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   GrpcRoute grpcRoute = GrpcRoute.newBuilder().build();
   *   String grpcRouteId = "grpcRouteId1888295750";
   *   GrpcRoute response =
   *       networkServicesClient.createGrpcRouteAsync(parent, grpcRoute, grpcRouteId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the GrpcRoute. Must be in the format
   *     `projects/&#42;/locations/global`.
   * @param grpcRoute Required. GrpcRoute resource to be created.
   * @param grpcRouteId Required. Short name of the GrpcRoute resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GrpcRoute, OperationMetadata> createGrpcRouteAsync(
      LocationName parent, GrpcRoute grpcRoute, String grpcRouteId) {
    CreateGrpcRouteRequest request =
        CreateGrpcRouteRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGrpcRoute(grpcRoute)
            .setGrpcRouteId(grpcRouteId)
            .build();
    return createGrpcRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new GrpcRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   GrpcRoute grpcRoute = GrpcRoute.newBuilder().build();
   *   String grpcRouteId = "grpcRouteId1888295750";
   *   GrpcRoute response =
   *       networkServicesClient.createGrpcRouteAsync(parent, grpcRoute, grpcRouteId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the GrpcRoute. Must be in the format
   *     `projects/&#42;/locations/global`.
   * @param grpcRoute Required. GrpcRoute resource to be created.
   * @param grpcRouteId Required. Short name of the GrpcRoute resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GrpcRoute, OperationMetadata> createGrpcRouteAsync(
      String parent, GrpcRoute grpcRoute, String grpcRouteId) {
    CreateGrpcRouteRequest request =
        CreateGrpcRouteRequest.newBuilder()
            .setParent(parent)
            .setGrpcRoute(grpcRoute)
            .setGrpcRouteId(grpcRouteId)
            .build();
    return createGrpcRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new GrpcRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateGrpcRouteRequest request =
   *       CreateGrpcRouteRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGrpcRouteId("grpcRouteId1888295750")
   *           .setGrpcRoute(GrpcRoute.newBuilder().build())
   *           .build();
   *   GrpcRoute response = networkServicesClient.createGrpcRouteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GrpcRoute, OperationMetadata> createGrpcRouteAsync(
      CreateGrpcRouteRequest request) {
    return createGrpcRouteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new GrpcRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateGrpcRouteRequest request =
   *       CreateGrpcRouteRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGrpcRouteId("grpcRouteId1888295750")
   *           .setGrpcRoute(GrpcRoute.newBuilder().build())
   *           .build();
   *   OperationFuture<GrpcRoute, OperationMetadata> future =
   *       networkServicesClient.createGrpcRouteOperationCallable().futureCall(request);
   *   // Do something.
   *   GrpcRoute response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateGrpcRouteRequest, GrpcRoute, OperationMetadata>
      createGrpcRouteOperationCallable() {
    return stub.createGrpcRouteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new GrpcRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateGrpcRouteRequest request =
   *       CreateGrpcRouteRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setGrpcRouteId("grpcRouteId1888295750")
   *           .setGrpcRoute(GrpcRoute.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkServicesClient.createGrpcRouteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGrpcRouteRequest, Operation> createGrpcRouteCallable() {
    return stub.createGrpcRouteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single GrpcRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GrpcRoute grpcRoute = GrpcRoute.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   GrpcRoute response = networkServicesClient.updateGrpcRouteAsync(grpcRoute, updateMask).get();
   * }
   * }</pre>
   *
   * @param grpcRoute Required. Updated GrpcRoute resource.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     GrpcRoute resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GrpcRoute, OperationMetadata> updateGrpcRouteAsync(
      GrpcRoute grpcRoute, FieldMask updateMask) {
    UpdateGrpcRouteRequest request =
        UpdateGrpcRouteRequest.newBuilder()
            .setGrpcRoute(grpcRoute)
            .setUpdateMask(updateMask)
            .build();
    return updateGrpcRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single GrpcRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateGrpcRouteRequest request =
   *       UpdateGrpcRouteRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGrpcRoute(GrpcRoute.newBuilder().build())
   *           .build();
   *   GrpcRoute response = networkServicesClient.updateGrpcRouteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GrpcRoute, OperationMetadata> updateGrpcRouteAsync(
      UpdateGrpcRouteRequest request) {
    return updateGrpcRouteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single GrpcRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateGrpcRouteRequest request =
   *       UpdateGrpcRouteRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGrpcRoute(GrpcRoute.newBuilder().build())
   *           .build();
   *   OperationFuture<GrpcRoute, OperationMetadata> future =
   *       networkServicesClient.updateGrpcRouteOperationCallable().futureCall(request);
   *   // Do something.
   *   GrpcRoute response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateGrpcRouteRequest, GrpcRoute, OperationMetadata>
      updateGrpcRouteOperationCallable() {
    return stub.updateGrpcRouteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single GrpcRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateGrpcRouteRequest request =
   *       UpdateGrpcRouteRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setGrpcRoute(GrpcRoute.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkServicesClient.updateGrpcRouteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGrpcRouteRequest, Operation> updateGrpcRouteCallable() {
    return stub.updateGrpcRouteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single GrpcRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GrpcRouteName name = GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]");
   *   networkServicesClient.deleteGrpcRouteAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the GrpcRoute to delete. Must be in the format
   *     `projects/&#42;/locations/global/grpcRoutes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGrpcRouteAsync(GrpcRouteName name) {
    DeleteGrpcRouteRequest request =
        DeleteGrpcRouteRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteGrpcRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single GrpcRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String name = GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]").toString();
   *   networkServicesClient.deleteGrpcRouteAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the GrpcRoute to delete. Must be in the format
   *     `projects/&#42;/locations/global/grpcRoutes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGrpcRouteAsync(String name) {
    DeleteGrpcRouteRequest request = DeleteGrpcRouteRequest.newBuilder().setName(name).build();
    return deleteGrpcRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single GrpcRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteGrpcRouteRequest request =
   *       DeleteGrpcRouteRequest.newBuilder()
   *           .setName(GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]").toString())
   *           .build();
   *   networkServicesClient.deleteGrpcRouteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteGrpcRouteAsync(
      DeleteGrpcRouteRequest request) {
    return deleteGrpcRouteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single GrpcRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteGrpcRouteRequest request =
   *       DeleteGrpcRouteRequest.newBuilder()
   *           .setName(GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       networkServicesClient.deleteGrpcRouteOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteGrpcRouteRequest, Empty, OperationMetadata>
      deleteGrpcRouteOperationCallable() {
    return stub.deleteGrpcRouteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single GrpcRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteGrpcRouteRequest request =
   *       DeleteGrpcRouteRequest.newBuilder()
   *           .setName(GrpcRouteName.of("[PROJECT]", "[LOCATION]", "[GRPC_ROUTE]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkServicesClient.deleteGrpcRouteCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGrpcRouteRequest, Operation> deleteGrpcRouteCallable() {
    return stub.deleteGrpcRouteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists HttpRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (HttpRoute element : networkServicesClient.listHttpRoutes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the HttpRoutes should be listed,
   *     specified in the format `projects/&#42;/locations/global`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHttpRoutesPagedResponse listHttpRoutes(LocationName parent) {
    ListHttpRoutesRequest request =
        ListHttpRoutesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listHttpRoutes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists HttpRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (HttpRoute element : networkServicesClient.listHttpRoutes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the HttpRoutes should be listed,
   *     specified in the format `projects/&#42;/locations/global`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHttpRoutesPagedResponse listHttpRoutes(String parent) {
    ListHttpRoutesRequest request = ListHttpRoutesRequest.newBuilder().setParent(parent).build();
    return listHttpRoutes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists HttpRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListHttpRoutesRequest request =
   *       ListHttpRoutesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (HttpRoute element : networkServicesClient.listHttpRoutes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHttpRoutesPagedResponse listHttpRoutes(ListHttpRoutesRequest request) {
    return listHttpRoutesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists HttpRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListHttpRoutesRequest request =
   *       ListHttpRoutesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<HttpRoute> future =
   *       networkServicesClient.listHttpRoutesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (HttpRoute element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListHttpRoutesRequest, ListHttpRoutesPagedResponse>
      listHttpRoutesPagedCallable() {
    return stub.listHttpRoutesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists HttpRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListHttpRoutesRequest request =
   *       ListHttpRoutesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListHttpRoutesResponse response =
   *         networkServicesClient.listHttpRoutesCallable().call(request);
   *     for (HttpRoute element : response.getHttpRoutesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListHttpRoutesRequest, ListHttpRoutesResponse>
      listHttpRoutesCallable() {
    return stub.listHttpRoutesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single HttpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   HttpRouteName name = HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]");
   *   HttpRoute response = networkServicesClient.getHttpRoute(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the HttpRoute to get. Must be in the format
   *     `projects/&#42;/locations/global/httpRoutes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpRoute getHttpRoute(HttpRouteName name) {
    GetHttpRouteRequest request =
        GetHttpRouteRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getHttpRoute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single HttpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String name = HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]").toString();
   *   HttpRoute response = networkServicesClient.getHttpRoute(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the HttpRoute to get. Must be in the format
   *     `projects/&#42;/locations/global/httpRoutes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpRoute getHttpRoute(String name) {
    GetHttpRouteRequest request = GetHttpRouteRequest.newBuilder().setName(name).build();
    return getHttpRoute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single HttpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetHttpRouteRequest request =
   *       GetHttpRouteRequest.newBuilder()
   *           .setName(HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]").toString())
   *           .build();
   *   HttpRoute response = networkServicesClient.getHttpRoute(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpRoute getHttpRoute(GetHttpRouteRequest request) {
    return getHttpRouteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single HttpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetHttpRouteRequest request =
   *       GetHttpRouteRequest.newBuilder()
   *           .setName(HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]").toString())
   *           .build();
   *   ApiFuture<HttpRoute> future =
   *       networkServicesClient.getHttpRouteCallable().futureCall(request);
   *   // Do something.
   *   HttpRoute response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetHttpRouteRequest, HttpRoute> getHttpRouteCallable() {
    return stub.getHttpRouteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new HttpRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   HttpRoute httpRoute = HttpRoute.newBuilder().build();
   *   String httpRouteId = "httpRouteId-2054835300";
   *   HttpRoute response =
   *       networkServicesClient.createHttpRouteAsync(parent, httpRoute, httpRouteId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the HttpRoute. Must be in the format
   *     `projects/&#42;/locations/global`.
   * @param httpRoute Required. HttpRoute resource to be created.
   * @param httpRouteId Required. Short name of the HttpRoute resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<HttpRoute, OperationMetadata> createHttpRouteAsync(
      LocationName parent, HttpRoute httpRoute, String httpRouteId) {
    CreateHttpRouteRequest request =
        CreateHttpRouteRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setHttpRoute(httpRoute)
            .setHttpRouteId(httpRouteId)
            .build();
    return createHttpRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new HttpRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   HttpRoute httpRoute = HttpRoute.newBuilder().build();
   *   String httpRouteId = "httpRouteId-2054835300";
   *   HttpRoute response =
   *       networkServicesClient.createHttpRouteAsync(parent, httpRoute, httpRouteId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the HttpRoute. Must be in the format
   *     `projects/&#42;/locations/global`.
   * @param httpRoute Required. HttpRoute resource to be created.
   * @param httpRouteId Required. Short name of the HttpRoute resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<HttpRoute, OperationMetadata> createHttpRouteAsync(
      String parent, HttpRoute httpRoute, String httpRouteId) {
    CreateHttpRouteRequest request =
        CreateHttpRouteRequest.newBuilder()
            .setParent(parent)
            .setHttpRoute(httpRoute)
            .setHttpRouteId(httpRouteId)
            .build();
    return createHttpRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new HttpRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateHttpRouteRequest request =
   *       CreateHttpRouteRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setHttpRouteId("httpRouteId-2054835300")
   *           .setHttpRoute(HttpRoute.newBuilder().build())
   *           .build();
   *   HttpRoute response = networkServicesClient.createHttpRouteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<HttpRoute, OperationMetadata> createHttpRouteAsync(
      CreateHttpRouteRequest request) {
    return createHttpRouteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new HttpRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateHttpRouteRequest request =
   *       CreateHttpRouteRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setHttpRouteId("httpRouteId-2054835300")
   *           .setHttpRoute(HttpRoute.newBuilder().build())
   *           .build();
   *   OperationFuture<HttpRoute, OperationMetadata> future =
   *       networkServicesClient.createHttpRouteOperationCallable().futureCall(request);
   *   // Do something.
   *   HttpRoute response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateHttpRouteRequest, HttpRoute, OperationMetadata>
      createHttpRouteOperationCallable() {
    return stub.createHttpRouteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new HttpRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateHttpRouteRequest request =
   *       CreateHttpRouteRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setHttpRouteId("httpRouteId-2054835300")
   *           .setHttpRoute(HttpRoute.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkServicesClient.createHttpRouteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateHttpRouteRequest, Operation> createHttpRouteCallable() {
    return stub.createHttpRouteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single HttpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   HttpRoute httpRoute = HttpRoute.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   HttpRoute response = networkServicesClient.updateHttpRouteAsync(httpRoute, updateMask).get();
   * }
   * }</pre>
   *
   * @param httpRoute Required. Updated HttpRoute resource.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     HttpRoute resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<HttpRoute, OperationMetadata> updateHttpRouteAsync(
      HttpRoute httpRoute, FieldMask updateMask) {
    UpdateHttpRouteRequest request =
        UpdateHttpRouteRequest.newBuilder()
            .setHttpRoute(httpRoute)
            .setUpdateMask(updateMask)
            .build();
    return updateHttpRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single HttpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateHttpRouteRequest request =
   *       UpdateHttpRouteRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setHttpRoute(HttpRoute.newBuilder().build())
   *           .build();
   *   HttpRoute response = networkServicesClient.updateHttpRouteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<HttpRoute, OperationMetadata> updateHttpRouteAsync(
      UpdateHttpRouteRequest request) {
    return updateHttpRouteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single HttpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateHttpRouteRequest request =
   *       UpdateHttpRouteRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setHttpRoute(HttpRoute.newBuilder().build())
   *           .build();
   *   OperationFuture<HttpRoute, OperationMetadata> future =
   *       networkServicesClient.updateHttpRouteOperationCallable().futureCall(request);
   *   // Do something.
   *   HttpRoute response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateHttpRouteRequest, HttpRoute, OperationMetadata>
      updateHttpRouteOperationCallable() {
    return stub.updateHttpRouteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single HttpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateHttpRouteRequest request =
   *       UpdateHttpRouteRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setHttpRoute(HttpRoute.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkServicesClient.updateHttpRouteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateHttpRouteRequest, Operation> updateHttpRouteCallable() {
    return stub.updateHttpRouteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single HttpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   HttpRouteName name = HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]");
   *   networkServicesClient.deleteHttpRouteAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the HttpRoute to delete. Must be in the format
   *     `projects/&#42;/locations/global/httpRoutes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteHttpRouteAsync(HttpRouteName name) {
    DeleteHttpRouteRequest request =
        DeleteHttpRouteRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteHttpRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single HttpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String name = HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]").toString();
   *   networkServicesClient.deleteHttpRouteAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the HttpRoute to delete. Must be in the format
   *     `projects/&#42;/locations/global/httpRoutes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteHttpRouteAsync(String name) {
    DeleteHttpRouteRequest request = DeleteHttpRouteRequest.newBuilder().setName(name).build();
    return deleteHttpRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single HttpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteHttpRouteRequest request =
   *       DeleteHttpRouteRequest.newBuilder()
   *           .setName(HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]").toString())
   *           .build();
   *   networkServicesClient.deleteHttpRouteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteHttpRouteAsync(
      DeleteHttpRouteRequest request) {
    return deleteHttpRouteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single HttpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteHttpRouteRequest request =
   *       DeleteHttpRouteRequest.newBuilder()
   *           .setName(HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       networkServicesClient.deleteHttpRouteOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteHttpRouteRequest, Empty, OperationMetadata>
      deleteHttpRouteOperationCallable() {
    return stub.deleteHttpRouteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single HttpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteHttpRouteRequest request =
   *       DeleteHttpRouteRequest.newBuilder()
   *           .setName(HttpRouteName.of("[PROJECT]", "[LOCATION]", "[HTTP_ROUTE]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkServicesClient.deleteHttpRouteCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteHttpRouteRequest, Operation> deleteHttpRouteCallable() {
    return stub.deleteHttpRouteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TcpRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (TcpRoute element : networkServicesClient.listTcpRoutes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the TcpRoutes should be listed,
   *     specified in the format `projects/&#42;/locations/global`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTcpRoutesPagedResponse listTcpRoutes(LocationName parent) {
    ListTcpRoutesRequest request =
        ListTcpRoutesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTcpRoutes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TcpRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (TcpRoute element : networkServicesClient.listTcpRoutes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the TcpRoutes should be listed,
   *     specified in the format `projects/&#42;/locations/global`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTcpRoutesPagedResponse listTcpRoutes(String parent) {
    ListTcpRoutesRequest request = ListTcpRoutesRequest.newBuilder().setParent(parent).build();
    return listTcpRoutes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TcpRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListTcpRoutesRequest request =
   *       ListTcpRoutesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (TcpRoute element : networkServicesClient.listTcpRoutes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTcpRoutesPagedResponse listTcpRoutes(ListTcpRoutesRequest request) {
    return listTcpRoutesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TcpRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListTcpRoutesRequest request =
   *       ListTcpRoutesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<TcpRoute> future =
   *       networkServicesClient.listTcpRoutesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TcpRoute element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTcpRoutesRequest, ListTcpRoutesPagedResponse>
      listTcpRoutesPagedCallable() {
    return stub.listTcpRoutesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TcpRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListTcpRoutesRequest request =
   *       ListTcpRoutesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListTcpRoutesResponse response =
   *         networkServicesClient.listTcpRoutesCallable().call(request);
   *     for (TcpRoute element : response.getTcpRoutesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTcpRoutesRequest, ListTcpRoutesResponse> listTcpRoutesCallable() {
    return stub.listTcpRoutesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TcpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   TcpRouteName name = TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]");
   *   TcpRoute response = networkServicesClient.getTcpRoute(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the TcpRoute to get. Must be in the format
   *     `projects/&#42;/locations/global/tcpRoutes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TcpRoute getTcpRoute(TcpRouteName name) {
    GetTcpRouteRequest request =
        GetTcpRouteRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTcpRoute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TcpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String name = TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]").toString();
   *   TcpRoute response = networkServicesClient.getTcpRoute(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the TcpRoute to get. Must be in the format
   *     `projects/&#42;/locations/global/tcpRoutes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TcpRoute getTcpRoute(String name) {
    GetTcpRouteRequest request = GetTcpRouteRequest.newBuilder().setName(name).build();
    return getTcpRoute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TcpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetTcpRouteRequest request =
   *       GetTcpRouteRequest.newBuilder()
   *           .setName(TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]").toString())
   *           .build();
   *   TcpRoute response = networkServicesClient.getTcpRoute(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TcpRoute getTcpRoute(GetTcpRouteRequest request) {
    return getTcpRouteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TcpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetTcpRouteRequest request =
   *       GetTcpRouteRequest.newBuilder()
   *           .setName(TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]").toString())
   *           .build();
   *   ApiFuture<TcpRoute> future = networkServicesClient.getTcpRouteCallable().futureCall(request);
   *   // Do something.
   *   TcpRoute response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTcpRouteRequest, TcpRoute> getTcpRouteCallable() {
    return stub.getTcpRouteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TcpRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   TcpRoute tcpRoute = TcpRoute.newBuilder().build();
   *   String tcpRouteId = "tcpRouteId806467107";
   *   TcpRoute response =
   *       networkServicesClient.createTcpRouteAsync(parent, tcpRoute, tcpRouteId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the TcpRoute. Must be in the format
   *     `projects/&#42;/locations/global`.
   * @param tcpRoute Required. TcpRoute resource to be created.
   * @param tcpRouteId Required. Short name of the TcpRoute resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TcpRoute, OperationMetadata> createTcpRouteAsync(
      LocationName parent, TcpRoute tcpRoute, String tcpRouteId) {
    CreateTcpRouteRequest request =
        CreateTcpRouteRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTcpRoute(tcpRoute)
            .setTcpRouteId(tcpRouteId)
            .build();
    return createTcpRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TcpRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   TcpRoute tcpRoute = TcpRoute.newBuilder().build();
   *   String tcpRouteId = "tcpRouteId806467107";
   *   TcpRoute response =
   *       networkServicesClient.createTcpRouteAsync(parent, tcpRoute, tcpRouteId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the TcpRoute. Must be in the format
   *     `projects/&#42;/locations/global`.
   * @param tcpRoute Required. TcpRoute resource to be created.
   * @param tcpRouteId Required. Short name of the TcpRoute resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TcpRoute, OperationMetadata> createTcpRouteAsync(
      String parent, TcpRoute tcpRoute, String tcpRouteId) {
    CreateTcpRouteRequest request =
        CreateTcpRouteRequest.newBuilder()
            .setParent(parent)
            .setTcpRoute(tcpRoute)
            .setTcpRouteId(tcpRouteId)
            .build();
    return createTcpRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TcpRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateTcpRouteRequest request =
   *       CreateTcpRouteRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTcpRouteId("tcpRouteId806467107")
   *           .setTcpRoute(TcpRoute.newBuilder().build())
   *           .build();
   *   TcpRoute response = networkServicesClient.createTcpRouteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TcpRoute, OperationMetadata> createTcpRouteAsync(
      CreateTcpRouteRequest request) {
    return createTcpRouteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TcpRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateTcpRouteRequest request =
   *       CreateTcpRouteRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTcpRouteId("tcpRouteId806467107")
   *           .setTcpRoute(TcpRoute.newBuilder().build())
   *           .build();
   *   OperationFuture<TcpRoute, OperationMetadata> future =
   *       networkServicesClient.createTcpRouteOperationCallable().futureCall(request);
   *   // Do something.
   *   TcpRoute response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateTcpRouteRequest, TcpRoute, OperationMetadata>
      createTcpRouteOperationCallable() {
    return stub.createTcpRouteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TcpRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateTcpRouteRequest request =
   *       CreateTcpRouteRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTcpRouteId("tcpRouteId806467107")
   *           .setTcpRoute(TcpRoute.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkServicesClient.createTcpRouteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTcpRouteRequest, Operation> createTcpRouteCallable() {
    return stub.createTcpRouteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single TcpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   TcpRoute tcpRoute = TcpRoute.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TcpRoute response = networkServicesClient.updateTcpRouteAsync(tcpRoute, updateMask).get();
   * }
   * }</pre>
   *
   * @param tcpRoute Required. Updated TcpRoute resource.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     TcpRoute resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TcpRoute, OperationMetadata> updateTcpRouteAsync(
      TcpRoute tcpRoute, FieldMask updateMask) {
    UpdateTcpRouteRequest request =
        UpdateTcpRouteRequest.newBuilder().setTcpRoute(tcpRoute).setUpdateMask(updateMask).build();
    return updateTcpRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single TcpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateTcpRouteRequest request =
   *       UpdateTcpRouteRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTcpRoute(TcpRoute.newBuilder().build())
   *           .build();
   *   TcpRoute response = networkServicesClient.updateTcpRouteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TcpRoute, OperationMetadata> updateTcpRouteAsync(
      UpdateTcpRouteRequest request) {
    return updateTcpRouteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single TcpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateTcpRouteRequest request =
   *       UpdateTcpRouteRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTcpRoute(TcpRoute.newBuilder().build())
   *           .build();
   *   OperationFuture<TcpRoute, OperationMetadata> future =
   *       networkServicesClient.updateTcpRouteOperationCallable().futureCall(request);
   *   // Do something.
   *   TcpRoute response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateTcpRouteRequest, TcpRoute, OperationMetadata>
      updateTcpRouteOperationCallable() {
    return stub.updateTcpRouteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single TcpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateTcpRouteRequest request =
   *       UpdateTcpRouteRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTcpRoute(TcpRoute.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkServicesClient.updateTcpRouteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTcpRouteRequest, Operation> updateTcpRouteCallable() {
    return stub.updateTcpRouteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TcpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   TcpRouteName name = TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]");
   *   networkServicesClient.deleteTcpRouteAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the TcpRoute to delete. Must be in the format
   *     `projects/&#42;/locations/global/tcpRoutes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTcpRouteAsync(TcpRouteName name) {
    DeleteTcpRouteRequest request =
        DeleteTcpRouteRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteTcpRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TcpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String name = TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]").toString();
   *   networkServicesClient.deleteTcpRouteAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the TcpRoute to delete. Must be in the format
   *     `projects/&#42;/locations/global/tcpRoutes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTcpRouteAsync(String name) {
    DeleteTcpRouteRequest request = DeleteTcpRouteRequest.newBuilder().setName(name).build();
    return deleteTcpRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TcpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteTcpRouteRequest request =
   *       DeleteTcpRouteRequest.newBuilder()
   *           .setName(TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]").toString())
   *           .build();
   *   networkServicesClient.deleteTcpRouteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTcpRouteAsync(
      DeleteTcpRouteRequest request) {
    return deleteTcpRouteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TcpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteTcpRouteRequest request =
   *       DeleteTcpRouteRequest.newBuilder()
   *           .setName(TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       networkServicesClient.deleteTcpRouteOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTcpRouteRequest, Empty, OperationMetadata>
      deleteTcpRouteOperationCallable() {
    return stub.deleteTcpRouteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TcpRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteTcpRouteRequest request =
   *       DeleteTcpRouteRequest.newBuilder()
   *           .setName(TcpRouteName.of("[PROJECT]", "[LOCATION]", "[TCP_ROUTE]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkServicesClient.deleteTcpRouteCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTcpRouteRequest, Operation> deleteTcpRouteCallable() {
    return stub.deleteTcpRouteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TlsRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (TlsRoute element : networkServicesClient.listTlsRoutes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the TlsRoutes should be listed,
   *     specified in the format `projects/&#42;/locations/global`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTlsRoutesPagedResponse listTlsRoutes(LocationName parent) {
    ListTlsRoutesRequest request =
        ListTlsRoutesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTlsRoutes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TlsRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (TlsRoute element : networkServicesClient.listTlsRoutes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the TlsRoutes should be listed,
   *     specified in the format `projects/&#42;/locations/global`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTlsRoutesPagedResponse listTlsRoutes(String parent) {
    ListTlsRoutesRequest request = ListTlsRoutesRequest.newBuilder().setParent(parent).build();
    return listTlsRoutes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TlsRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListTlsRoutesRequest request =
   *       ListTlsRoutesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (TlsRoute element : networkServicesClient.listTlsRoutes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTlsRoutesPagedResponse listTlsRoutes(ListTlsRoutesRequest request) {
    return listTlsRoutesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TlsRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListTlsRoutesRequest request =
   *       ListTlsRoutesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<TlsRoute> future =
   *       networkServicesClient.listTlsRoutesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (TlsRoute element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTlsRoutesRequest, ListTlsRoutesPagedResponse>
      listTlsRoutesPagedCallable() {
    return stub.listTlsRoutesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists TlsRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListTlsRoutesRequest request =
   *       ListTlsRoutesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListTlsRoutesResponse response =
   *         networkServicesClient.listTlsRoutesCallable().call(request);
   *     for (TlsRoute element : response.getTlsRoutesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTlsRoutesRequest, ListTlsRoutesResponse> listTlsRoutesCallable() {
    return stub.listTlsRoutesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TlsRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   TlsRouteName name = TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]");
   *   TlsRoute response = networkServicesClient.getTlsRoute(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the TlsRoute to get. Must be in the format
   *     `projects/&#42;/locations/global/tlsRoutes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TlsRoute getTlsRoute(TlsRouteName name) {
    GetTlsRouteRequest request =
        GetTlsRouteRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTlsRoute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TlsRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String name = TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]").toString();
   *   TlsRoute response = networkServicesClient.getTlsRoute(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the TlsRoute to get. Must be in the format
   *     `projects/&#42;/locations/global/tlsRoutes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TlsRoute getTlsRoute(String name) {
    GetTlsRouteRequest request = GetTlsRouteRequest.newBuilder().setName(name).build();
    return getTlsRoute(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TlsRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetTlsRouteRequest request =
   *       GetTlsRouteRequest.newBuilder()
   *           .setName(TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]").toString())
   *           .build();
   *   TlsRoute response = networkServicesClient.getTlsRoute(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TlsRoute getTlsRoute(GetTlsRouteRequest request) {
    return getTlsRouteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single TlsRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetTlsRouteRequest request =
   *       GetTlsRouteRequest.newBuilder()
   *           .setName(TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]").toString())
   *           .build();
   *   ApiFuture<TlsRoute> future = networkServicesClient.getTlsRouteCallable().futureCall(request);
   *   // Do something.
   *   TlsRoute response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTlsRouteRequest, TlsRoute> getTlsRouteCallable() {
    return stub.getTlsRouteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TlsRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   TlsRoute tlsRoute = TlsRoute.newBuilder().build();
   *   String tlsRouteId = "tlsRouteId-1642257463";
   *   TlsRoute response =
   *       networkServicesClient.createTlsRouteAsync(parent, tlsRoute, tlsRouteId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the TlsRoute. Must be in the format
   *     `projects/&#42;/locations/global`.
   * @param tlsRoute Required. TlsRoute resource to be created.
   * @param tlsRouteId Required. Short name of the TlsRoute resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TlsRoute, OperationMetadata> createTlsRouteAsync(
      LocationName parent, TlsRoute tlsRoute, String tlsRouteId) {
    CreateTlsRouteRequest request =
        CreateTlsRouteRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTlsRoute(tlsRoute)
            .setTlsRouteId(tlsRouteId)
            .build();
    return createTlsRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TlsRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   TlsRoute tlsRoute = TlsRoute.newBuilder().build();
   *   String tlsRouteId = "tlsRouteId-1642257463";
   *   TlsRoute response =
   *       networkServicesClient.createTlsRouteAsync(parent, tlsRoute, tlsRouteId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the TlsRoute. Must be in the format
   *     `projects/&#42;/locations/global`.
   * @param tlsRoute Required. TlsRoute resource to be created.
   * @param tlsRouteId Required. Short name of the TlsRoute resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TlsRoute, OperationMetadata> createTlsRouteAsync(
      String parent, TlsRoute tlsRoute, String tlsRouteId) {
    CreateTlsRouteRequest request =
        CreateTlsRouteRequest.newBuilder()
            .setParent(parent)
            .setTlsRoute(tlsRoute)
            .setTlsRouteId(tlsRouteId)
            .build();
    return createTlsRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TlsRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateTlsRouteRequest request =
   *       CreateTlsRouteRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTlsRouteId("tlsRouteId-1642257463")
   *           .setTlsRoute(TlsRoute.newBuilder().build())
   *           .build();
   *   TlsRoute response = networkServicesClient.createTlsRouteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TlsRoute, OperationMetadata> createTlsRouteAsync(
      CreateTlsRouteRequest request) {
    return createTlsRouteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TlsRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateTlsRouteRequest request =
   *       CreateTlsRouteRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTlsRouteId("tlsRouteId-1642257463")
   *           .setTlsRoute(TlsRoute.newBuilder().build())
   *           .build();
   *   OperationFuture<TlsRoute, OperationMetadata> future =
   *       networkServicesClient.createTlsRouteOperationCallable().futureCall(request);
   *   // Do something.
   *   TlsRoute response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateTlsRouteRequest, TlsRoute, OperationMetadata>
      createTlsRouteOperationCallable() {
    return stub.createTlsRouteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TlsRoute in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateTlsRouteRequest request =
   *       CreateTlsRouteRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTlsRouteId("tlsRouteId-1642257463")
   *           .setTlsRoute(TlsRoute.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkServicesClient.createTlsRouteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTlsRouteRequest, Operation> createTlsRouteCallable() {
    return stub.createTlsRouteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single TlsRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   TlsRoute tlsRoute = TlsRoute.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TlsRoute response = networkServicesClient.updateTlsRouteAsync(tlsRoute, updateMask).get();
   * }
   * }</pre>
   *
   * @param tlsRoute Required. Updated TlsRoute resource.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     TlsRoute resource by the update. The fields specified in the update_mask are relative to
   *     the resource, not the full request. A field will be overwritten if it is in the mask. If
   *     the user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TlsRoute, OperationMetadata> updateTlsRouteAsync(
      TlsRoute tlsRoute, FieldMask updateMask) {
    UpdateTlsRouteRequest request =
        UpdateTlsRouteRequest.newBuilder().setTlsRoute(tlsRoute).setUpdateMask(updateMask).build();
    return updateTlsRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single TlsRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateTlsRouteRequest request =
   *       UpdateTlsRouteRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTlsRoute(TlsRoute.newBuilder().build())
   *           .build();
   *   TlsRoute response = networkServicesClient.updateTlsRouteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TlsRoute, OperationMetadata> updateTlsRouteAsync(
      UpdateTlsRouteRequest request) {
    return updateTlsRouteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single TlsRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateTlsRouteRequest request =
   *       UpdateTlsRouteRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTlsRoute(TlsRoute.newBuilder().build())
   *           .build();
   *   OperationFuture<TlsRoute, OperationMetadata> future =
   *       networkServicesClient.updateTlsRouteOperationCallable().futureCall(request);
   *   // Do something.
   *   TlsRoute response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateTlsRouteRequest, TlsRoute, OperationMetadata>
      updateTlsRouteOperationCallable() {
    return stub.updateTlsRouteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single TlsRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateTlsRouteRequest request =
   *       UpdateTlsRouteRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setTlsRoute(TlsRoute.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkServicesClient.updateTlsRouteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTlsRouteRequest, Operation> updateTlsRouteCallable() {
    return stub.updateTlsRouteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TlsRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   TlsRouteName name = TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]");
   *   networkServicesClient.deleteTlsRouteAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the TlsRoute to delete. Must be in the format
   *     `projects/&#42;/locations/global/tlsRoutes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTlsRouteAsync(TlsRouteName name) {
    DeleteTlsRouteRequest request =
        DeleteTlsRouteRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteTlsRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TlsRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String name = TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]").toString();
   *   networkServicesClient.deleteTlsRouteAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the TlsRoute to delete. Must be in the format
   *     `projects/&#42;/locations/global/tlsRoutes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTlsRouteAsync(String name) {
    DeleteTlsRouteRequest request = DeleteTlsRouteRequest.newBuilder().setName(name).build();
    return deleteTlsRouteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TlsRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteTlsRouteRequest request =
   *       DeleteTlsRouteRequest.newBuilder()
   *           .setName(TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]").toString())
   *           .build();
   *   networkServicesClient.deleteTlsRouteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteTlsRouteAsync(
      DeleteTlsRouteRequest request) {
    return deleteTlsRouteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TlsRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteTlsRouteRequest request =
   *       DeleteTlsRouteRequest.newBuilder()
   *           .setName(TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       networkServicesClient.deleteTlsRouteOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTlsRouteRequest, Empty, OperationMetadata>
      deleteTlsRouteOperationCallable() {
    return stub.deleteTlsRouteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single TlsRoute.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteTlsRouteRequest request =
   *       DeleteTlsRouteRequest.newBuilder()
   *           .setName(TlsRouteName.of("[PROJECT]", "[LOCATION]", "[TLS_ROUTE]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkServicesClient.deleteTlsRouteCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTlsRouteRequest, Operation> deleteTlsRouteCallable() {
    return stub.deleteTlsRouteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceBinding in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ServiceBinding element :
   *       networkServicesClient.listServiceBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the ServiceBindings should be
   *     listed, specified in the format `projects/&#42;/locations/global`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceBindingsPagedResponse listServiceBindings(LocationName parent) {
    ListServiceBindingsRequest request =
        ListServiceBindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listServiceBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceBinding in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ServiceBinding element :
   *       networkServicesClient.listServiceBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the ServiceBindings should be
   *     listed, specified in the format `projects/&#42;/locations/global`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceBindingsPagedResponse listServiceBindings(String parent) {
    ListServiceBindingsRequest request =
        ListServiceBindingsRequest.newBuilder().setParent(parent).build();
    return listServiceBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceBinding in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListServiceBindingsRequest request =
   *       ListServiceBindingsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ServiceBinding element :
   *       networkServicesClient.listServiceBindings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServiceBindingsPagedResponse listServiceBindings(
      ListServiceBindingsRequest request) {
    return listServiceBindingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceBinding in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListServiceBindingsRequest request =
   *       ListServiceBindingsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ServiceBinding> future =
   *       networkServicesClient.listServiceBindingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ServiceBinding element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListServiceBindingsRequest, ListServiceBindingsPagedResponse>
      listServiceBindingsPagedCallable() {
    return stub.listServiceBindingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists ServiceBinding in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListServiceBindingsRequest request =
   *       ListServiceBindingsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListServiceBindingsResponse response =
   *         networkServicesClient.listServiceBindingsCallable().call(request);
   *     for (ServiceBinding element : response.getServiceBindingsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListServiceBindingsRequest, ListServiceBindingsResponse>
      listServiceBindingsCallable() {
    return stub.listServiceBindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServiceBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ServiceBindingName name =
   *       ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]");
   *   ServiceBinding response = networkServicesClient.getServiceBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the ServiceBinding to get. Must be in the format
   *     `projects/&#42;/locations/global/serviceBindings/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceBinding getServiceBinding(ServiceBindingName name) {
    GetServiceBindingRequest request =
        GetServiceBindingRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getServiceBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServiceBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String name =
   *       ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]").toString();
   *   ServiceBinding response = networkServicesClient.getServiceBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the ServiceBinding to get. Must be in the format
   *     `projects/&#42;/locations/global/serviceBindings/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceBinding getServiceBinding(String name) {
    GetServiceBindingRequest request = GetServiceBindingRequest.newBuilder().setName(name).build();
    return getServiceBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServiceBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetServiceBindingRequest request =
   *       GetServiceBindingRequest.newBuilder()
   *           .setName(
   *               ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]").toString())
   *           .build();
   *   ServiceBinding response = networkServicesClient.getServiceBinding(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ServiceBinding getServiceBinding(GetServiceBindingRequest request) {
    return getServiceBindingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single ServiceBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetServiceBindingRequest request =
   *       GetServiceBindingRequest.newBuilder()
   *           .setName(
   *               ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]").toString())
   *           .build();
   *   ApiFuture<ServiceBinding> future =
   *       networkServicesClient.getServiceBindingCallable().futureCall(request);
   *   // Do something.
   *   ServiceBinding response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetServiceBindingRequest, ServiceBinding> getServiceBindingCallable() {
    return stub.getServiceBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServiceBinding in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ServiceBinding serviceBinding = ServiceBinding.newBuilder().build();
   *   String serviceBindingId = "serviceBindingId-1424670901";
   *   ServiceBinding response =
   *       networkServicesClient
   *           .createServiceBindingAsync(parent, serviceBinding, serviceBindingId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the ServiceBinding. Must be in the format
   *     `projects/&#42;/locations/global`.
   * @param serviceBinding Required. ServiceBinding resource to be created.
   * @param serviceBindingId Required. Short name of the ServiceBinding resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServiceBinding, OperationMetadata> createServiceBindingAsync(
      LocationName parent, ServiceBinding serviceBinding, String serviceBindingId) {
    CreateServiceBindingRequest request =
        CreateServiceBindingRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setServiceBinding(serviceBinding)
            .setServiceBindingId(serviceBindingId)
            .build();
    return createServiceBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServiceBinding in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ServiceBinding serviceBinding = ServiceBinding.newBuilder().build();
   *   String serviceBindingId = "serviceBindingId-1424670901";
   *   ServiceBinding response =
   *       networkServicesClient
   *           .createServiceBindingAsync(parent, serviceBinding, serviceBindingId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the ServiceBinding. Must be in the format
   *     `projects/&#42;/locations/global`.
   * @param serviceBinding Required. ServiceBinding resource to be created.
   * @param serviceBindingId Required. Short name of the ServiceBinding resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServiceBinding, OperationMetadata> createServiceBindingAsync(
      String parent, ServiceBinding serviceBinding, String serviceBindingId) {
    CreateServiceBindingRequest request =
        CreateServiceBindingRequest.newBuilder()
            .setParent(parent)
            .setServiceBinding(serviceBinding)
            .setServiceBindingId(serviceBindingId)
            .build();
    return createServiceBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServiceBinding in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateServiceBindingRequest request =
   *       CreateServiceBindingRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServiceBindingId("serviceBindingId-1424670901")
   *           .setServiceBinding(ServiceBinding.newBuilder().build())
   *           .build();
   *   ServiceBinding response = networkServicesClient.createServiceBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ServiceBinding, OperationMetadata> createServiceBindingAsync(
      CreateServiceBindingRequest request) {
    return createServiceBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServiceBinding in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateServiceBindingRequest request =
   *       CreateServiceBindingRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServiceBindingId("serviceBindingId-1424670901")
   *           .setServiceBinding(ServiceBinding.newBuilder().build())
   *           .build();
   *   OperationFuture<ServiceBinding, OperationMetadata> future =
   *       networkServicesClient.createServiceBindingOperationCallable().futureCall(request);
   *   // Do something.
   *   ServiceBinding response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateServiceBindingRequest, ServiceBinding, OperationMetadata>
      createServiceBindingOperationCallable() {
    return stub.createServiceBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new ServiceBinding in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateServiceBindingRequest request =
   *       CreateServiceBindingRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServiceBindingId("serviceBindingId-1424670901")
   *           .setServiceBinding(ServiceBinding.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkServicesClient.createServiceBindingCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateServiceBindingRequest, Operation>
      createServiceBindingCallable() {
    return stub.createServiceBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ServiceBindingName name =
   *       ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]");
   *   networkServicesClient.deleteServiceBindingAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the ServiceBinding to delete. Must be in the format
   *     `projects/&#42;/locations/global/serviceBindings/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceBindingAsync(
      ServiceBindingName name) {
    DeleteServiceBindingRequest request =
        DeleteServiceBindingRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteServiceBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String name =
   *       ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]").toString();
   *   networkServicesClient.deleteServiceBindingAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the ServiceBinding to delete. Must be in the format
   *     `projects/&#42;/locations/global/serviceBindings/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceBindingAsync(String name) {
    DeleteServiceBindingRequest request =
        DeleteServiceBindingRequest.newBuilder().setName(name).build();
    return deleteServiceBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteServiceBindingRequest request =
   *       DeleteServiceBindingRequest.newBuilder()
   *           .setName(
   *               ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]").toString())
   *           .build();
   *   networkServicesClient.deleteServiceBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceBindingAsync(
      DeleteServiceBindingRequest request) {
    return deleteServiceBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteServiceBindingRequest request =
   *       DeleteServiceBindingRequest.newBuilder()
   *           .setName(
   *               ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       networkServicesClient.deleteServiceBindingOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteServiceBindingRequest, Empty, OperationMetadata>
      deleteServiceBindingOperationCallable() {
    return stub.deleteServiceBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single ServiceBinding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteServiceBindingRequest request =
   *       DeleteServiceBindingRequest.newBuilder()
   *           .setName(
   *               ServiceBindingName.of("[PROJECT]", "[LOCATION]", "[SERVICE_BINDING]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       networkServicesClient.deleteServiceBindingCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteServiceBindingRequest, Operation>
      deleteServiceBindingCallable() {
    return stub.deleteServiceBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Meshes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Mesh element : networkServicesClient.listMeshes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the Meshes should be listed,
   *     specified in the format `projects/&#42;/locations/global`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMeshesPagedResponse listMeshes(LocationName parent) {
    ListMeshesRequest request =
        ListMeshesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listMeshes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Meshes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Mesh element : networkServicesClient.listMeshes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location from which the Meshes should be listed,
   *     specified in the format `projects/&#42;/locations/global`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMeshesPagedResponse listMeshes(String parent) {
    ListMeshesRequest request = ListMeshesRequest.newBuilder().setParent(parent).build();
    return listMeshes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Meshes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListMeshesRequest request =
   *       ListMeshesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Mesh element : networkServicesClient.listMeshes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMeshesPagedResponse listMeshes(ListMeshesRequest request) {
    return listMeshesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Meshes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListMeshesRequest request =
   *       ListMeshesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Mesh> future = networkServicesClient.listMeshesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Mesh element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMeshesRequest, ListMeshesPagedResponse> listMeshesPagedCallable() {
    return stub.listMeshesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Meshes in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListMeshesRequest request =
   *       ListMeshesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListMeshesResponse response = networkServicesClient.listMeshesCallable().call(request);
   *     for (Mesh element : response.getMeshesList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMeshesRequest, ListMeshesResponse> listMeshesCallable() {
    return stub.listMeshesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Mesh.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   MeshName name = MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]");
   *   Mesh response = networkServicesClient.getMesh(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the Mesh to get. Must be in the format
   *     `projects/&#42;/locations/global/meshes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Mesh getMesh(MeshName name) {
    GetMeshRequest request =
        GetMeshRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getMesh(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Mesh.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String name = MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]").toString();
   *   Mesh response = networkServicesClient.getMesh(name);
   * }
   * }</pre>
   *
   * @param name Required. A name of the Mesh to get. Must be in the format
   *     `projects/&#42;/locations/global/meshes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Mesh getMesh(String name) {
    GetMeshRequest request = GetMeshRequest.newBuilder().setName(name).build();
    return getMesh(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Mesh.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetMeshRequest request =
   *       GetMeshRequest.newBuilder()
   *           .setName(MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]").toString())
   *           .build();
   *   Mesh response = networkServicesClient.getMesh(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Mesh getMesh(GetMeshRequest request) {
    return getMeshCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Mesh.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetMeshRequest request =
   *       GetMeshRequest.newBuilder()
   *           .setName(MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]").toString())
   *           .build();
   *   ApiFuture<Mesh> future = networkServicesClient.getMeshCallable().futureCall(request);
   *   // Do something.
   *   Mesh response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMeshRequest, Mesh> getMeshCallable() {
    return stub.getMeshCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Mesh in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Mesh mesh = Mesh.newBuilder().build();
   *   String meshId = "meshId-1077585944";
   *   Mesh response = networkServicesClient.createMeshAsync(parent, mesh, meshId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the Mesh. Must be in the format
   *     `projects/&#42;/locations/global`.
   * @param mesh Required. Mesh resource to be created.
   * @param meshId Required. Short name of the Mesh resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Mesh, OperationMetadata> createMeshAsync(
      LocationName parent, Mesh mesh, String meshId) {
    CreateMeshRequest request =
        CreateMeshRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setMesh(mesh)
            .setMeshId(meshId)
            .build();
    return createMeshAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Mesh in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Mesh mesh = Mesh.newBuilder().build();
   *   String meshId = "meshId-1077585944";
   *   Mesh response = networkServicesClient.createMeshAsync(parent, mesh, meshId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource of the Mesh. Must be in the format
   *     `projects/&#42;/locations/global`.
   * @param mesh Required. Mesh resource to be created.
   * @param meshId Required. Short name of the Mesh resource to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Mesh, OperationMetadata> createMeshAsync(
      String parent, Mesh mesh, String meshId) {
    CreateMeshRequest request =
        CreateMeshRequest.newBuilder().setParent(parent).setMesh(mesh).setMeshId(meshId).build();
    return createMeshAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Mesh in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateMeshRequest request =
   *       CreateMeshRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMeshId("meshId-1077585944")
   *           .setMesh(Mesh.newBuilder().build())
   *           .build();
   *   Mesh response = networkServicesClient.createMeshAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Mesh, OperationMetadata> createMeshAsync(CreateMeshRequest request) {
    return createMeshOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Mesh in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateMeshRequest request =
   *       CreateMeshRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMeshId("meshId-1077585944")
   *           .setMesh(Mesh.newBuilder().build())
   *           .build();
   *   OperationFuture<Mesh, OperationMetadata> future =
   *       networkServicesClient.createMeshOperationCallable().futureCall(request);
   *   // Do something.
   *   Mesh response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateMeshRequest, Mesh, OperationMetadata>
      createMeshOperationCallable() {
    return stub.createMeshOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Mesh in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   CreateMeshRequest request =
   *       CreateMeshRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setMeshId("meshId-1077585944")
   *           .setMesh(Mesh.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = networkServicesClient.createMeshCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMeshRequest, Operation> createMeshCallable() {
    return stub.createMeshCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Mesh.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   Mesh mesh = Mesh.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Mesh response = networkServicesClient.updateMeshAsync(mesh, updateMask).get();
   * }
   * }</pre>
   *
   * @param mesh Required. Updated Mesh resource.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     Mesh resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Mesh, OperationMetadata> updateMeshAsync(
      Mesh mesh, FieldMask updateMask) {
    UpdateMeshRequest request =
        UpdateMeshRequest.newBuilder().setMesh(mesh).setUpdateMask(updateMask).build();
    return updateMeshAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Mesh.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateMeshRequest request =
   *       UpdateMeshRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMesh(Mesh.newBuilder().build())
   *           .build();
   *   Mesh response = networkServicesClient.updateMeshAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Mesh, OperationMetadata> updateMeshAsync(UpdateMeshRequest request) {
    return updateMeshOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Mesh.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateMeshRequest request =
   *       UpdateMeshRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMesh(Mesh.newBuilder().build())
   *           .build();
   *   OperationFuture<Mesh, OperationMetadata> future =
   *       networkServicesClient.updateMeshOperationCallable().futureCall(request);
   *   // Do something.
   *   Mesh response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateMeshRequest, Mesh, OperationMetadata>
      updateMeshOperationCallable() {
    return stub.updateMeshOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Mesh.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   UpdateMeshRequest request =
   *       UpdateMeshRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setMesh(Mesh.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = networkServicesClient.updateMeshCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMeshRequest, Operation> updateMeshCallable() {
    return stub.updateMeshCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Mesh.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   MeshName name = MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]");
   *   networkServicesClient.deleteMeshAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the Mesh to delete. Must be in the format
   *     `projects/&#42;/locations/global/meshes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMeshAsync(MeshName name) {
    DeleteMeshRequest request =
        DeleteMeshRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteMeshAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Mesh.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   String name = MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]").toString();
   *   networkServicesClient.deleteMeshAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. A name of the Mesh to delete. Must be in the format
   *     `projects/&#42;/locations/global/meshes/&#42;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMeshAsync(String name) {
    DeleteMeshRequest request = DeleteMeshRequest.newBuilder().setName(name).build();
    return deleteMeshAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Mesh.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteMeshRequest request =
   *       DeleteMeshRequest.newBuilder()
   *           .setName(MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]").toString())
   *           .build();
   *   networkServicesClient.deleteMeshAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteMeshAsync(
      DeleteMeshRequest request) {
    return deleteMeshOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Mesh.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteMeshRequest request =
   *       DeleteMeshRequest.newBuilder()
   *           .setName(MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]").toString())
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       networkServicesClient.deleteMeshOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteMeshRequest, Empty, OperationMetadata>
      deleteMeshOperationCallable() {
    return stub.deleteMeshOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Mesh.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   DeleteMeshRequest request =
   *       DeleteMeshRequest.newBuilder()
   *           .setName(MeshName.of("[PROJECT]", "[LOCATION]", "[MESH]").toString())
   *           .build();
   *   ApiFuture<Operation> future = networkServicesClient.deleteMeshCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMeshRequest, Operation> deleteMeshCallable() {
    return stub.deleteMeshCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : networkServicesClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       networkServicesClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         networkServicesClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
   *       // doThingsWith(element);
   *     }
   *     String nextPageToken = response.getNextPageToken();
   *     if (!Strings.isNullOrEmpty(nextPageToken)) {
   *       request = request.toBuilder().setPageToken(nextPageToken).build();
   *     } else {
   *       break;
   *     }
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = networkServicesClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = networkServicesClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = networkServicesClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replacesany existing policy.
   *
   * <p>Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = networkServicesClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = networkServicesClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. Returns an empty policyif the resource exists
   * and does not have a policy set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = networkServicesClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = networkServicesClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource. If theresource does not exist,
   * this will return an empty set ofpermissions, not a `NOT_FOUND` error.
   *
   * <p>Note: This operation is designed to be used for buildingpermission-aware UIs and
   * command-line tools, not for authorizationchecking. This operation may "fail open" without
   * warning.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NetworkServicesClient networkServicesClient = NetworkServicesClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       networkServicesClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  @Override
  public final void close() {
    stub.close();
  }

  @Override
  public void shutdown() {
    stub.shutdown();
  }

  @Override
  public boolean isShutdown() {
    return stub.isShutdown();
  }

  @Override
  public boolean isTerminated() {
    return stub.isTerminated();
  }

  @Override
  public void shutdownNow() {
    stub.shutdownNow();
  }

  @Override
  public boolean awaitTermination(long duration, TimeUnit unit) throws InterruptedException {
    return stub.awaitTermination(duration, unit);
  }

  public static class ListEndpointPoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListEndpointPoliciesRequest,
          ListEndpointPoliciesResponse,
          EndpointPolicy,
          ListEndpointPoliciesPage,
          ListEndpointPoliciesFixedSizeCollection> {

    public static ApiFuture<ListEndpointPoliciesPagedResponse> createAsync(
        PageContext<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse, EndpointPolicy>
            context,
        ApiFuture<ListEndpointPoliciesResponse> futureResponse) {
      ApiFuture<ListEndpointPoliciesPage> futurePage =
          ListEndpointPoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEndpointPoliciesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEndpointPoliciesPagedResponse(ListEndpointPoliciesPage page) {
      super(page, ListEndpointPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEndpointPoliciesPage
      extends AbstractPage<
          ListEndpointPoliciesRequest,
          ListEndpointPoliciesResponse,
          EndpointPolicy,
          ListEndpointPoliciesPage> {

    private ListEndpointPoliciesPage(
        PageContext<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse, EndpointPolicy>
            context,
        ListEndpointPoliciesResponse response) {
      super(context, response);
    }

    private static ListEndpointPoliciesPage createEmptyPage() {
      return new ListEndpointPoliciesPage(null, null);
    }

    @Override
    protected ListEndpointPoliciesPage createPage(
        PageContext<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse, EndpointPolicy>
            context,
        ListEndpointPoliciesResponse response) {
      return new ListEndpointPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListEndpointPoliciesPage> createPageAsync(
        PageContext<ListEndpointPoliciesRequest, ListEndpointPoliciesResponse, EndpointPolicy>
            context,
        ApiFuture<ListEndpointPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEndpointPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEndpointPoliciesRequest,
          ListEndpointPoliciesResponse,
          EndpointPolicy,
          ListEndpointPoliciesPage,
          ListEndpointPoliciesFixedSizeCollection> {

    private ListEndpointPoliciesFixedSizeCollection(
        List<ListEndpointPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEndpointPoliciesFixedSizeCollection createEmptyCollection() {
      return new ListEndpointPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEndpointPoliciesFixedSizeCollection createCollection(
        List<ListEndpointPoliciesPage> pages, int collectionSize) {
      return new ListEndpointPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListGatewaysPagedResponse
      extends AbstractPagedListResponse<
          ListGatewaysRequest,
          ListGatewaysResponse,
          Gateway,
          ListGatewaysPage,
          ListGatewaysFixedSizeCollection> {

    public static ApiFuture<ListGatewaysPagedResponse> createAsync(
        PageContext<ListGatewaysRequest, ListGatewaysResponse, Gateway> context,
        ApiFuture<ListGatewaysResponse> futureResponse) {
      ApiFuture<ListGatewaysPage> futurePage =
          ListGatewaysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListGatewaysPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListGatewaysPagedResponse(ListGatewaysPage page) {
      super(page, ListGatewaysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGatewaysPage
      extends AbstractPage<ListGatewaysRequest, ListGatewaysResponse, Gateway, ListGatewaysPage> {

    private ListGatewaysPage(
        PageContext<ListGatewaysRequest, ListGatewaysResponse, Gateway> context,
        ListGatewaysResponse response) {
      super(context, response);
    }

    private static ListGatewaysPage createEmptyPage() {
      return new ListGatewaysPage(null, null);
    }

    @Override
    protected ListGatewaysPage createPage(
        PageContext<ListGatewaysRequest, ListGatewaysResponse, Gateway> context,
        ListGatewaysResponse response) {
      return new ListGatewaysPage(context, response);
    }

    @Override
    public ApiFuture<ListGatewaysPage> createPageAsync(
        PageContext<ListGatewaysRequest, ListGatewaysResponse, Gateway> context,
        ApiFuture<ListGatewaysResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGatewaysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGatewaysRequest,
          ListGatewaysResponse,
          Gateway,
          ListGatewaysPage,
          ListGatewaysFixedSizeCollection> {

    private ListGatewaysFixedSizeCollection(List<ListGatewaysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGatewaysFixedSizeCollection createEmptyCollection() {
      return new ListGatewaysFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGatewaysFixedSizeCollection createCollection(
        List<ListGatewaysPage> pages, int collectionSize) {
      return new ListGatewaysFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListGrpcRoutesPagedResponse
      extends AbstractPagedListResponse<
          ListGrpcRoutesRequest,
          ListGrpcRoutesResponse,
          GrpcRoute,
          ListGrpcRoutesPage,
          ListGrpcRoutesFixedSizeCollection> {

    public static ApiFuture<ListGrpcRoutesPagedResponse> createAsync(
        PageContext<ListGrpcRoutesRequest, ListGrpcRoutesResponse, GrpcRoute> context,
        ApiFuture<ListGrpcRoutesResponse> futureResponse) {
      ApiFuture<ListGrpcRoutesPage> futurePage =
          ListGrpcRoutesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListGrpcRoutesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListGrpcRoutesPagedResponse(ListGrpcRoutesPage page) {
      super(page, ListGrpcRoutesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGrpcRoutesPage
      extends AbstractPage<
          ListGrpcRoutesRequest, ListGrpcRoutesResponse, GrpcRoute, ListGrpcRoutesPage> {

    private ListGrpcRoutesPage(
        PageContext<ListGrpcRoutesRequest, ListGrpcRoutesResponse, GrpcRoute> context,
        ListGrpcRoutesResponse response) {
      super(context, response);
    }

    private static ListGrpcRoutesPage createEmptyPage() {
      return new ListGrpcRoutesPage(null, null);
    }

    @Override
    protected ListGrpcRoutesPage createPage(
        PageContext<ListGrpcRoutesRequest, ListGrpcRoutesResponse, GrpcRoute> context,
        ListGrpcRoutesResponse response) {
      return new ListGrpcRoutesPage(context, response);
    }

    @Override
    public ApiFuture<ListGrpcRoutesPage> createPageAsync(
        PageContext<ListGrpcRoutesRequest, ListGrpcRoutesResponse, GrpcRoute> context,
        ApiFuture<ListGrpcRoutesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGrpcRoutesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGrpcRoutesRequest,
          ListGrpcRoutesResponse,
          GrpcRoute,
          ListGrpcRoutesPage,
          ListGrpcRoutesFixedSizeCollection> {

    private ListGrpcRoutesFixedSizeCollection(List<ListGrpcRoutesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGrpcRoutesFixedSizeCollection createEmptyCollection() {
      return new ListGrpcRoutesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGrpcRoutesFixedSizeCollection createCollection(
        List<ListGrpcRoutesPage> pages, int collectionSize) {
      return new ListGrpcRoutesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListHttpRoutesPagedResponse
      extends AbstractPagedListResponse<
          ListHttpRoutesRequest,
          ListHttpRoutesResponse,
          HttpRoute,
          ListHttpRoutesPage,
          ListHttpRoutesFixedSizeCollection> {

    public static ApiFuture<ListHttpRoutesPagedResponse> createAsync(
        PageContext<ListHttpRoutesRequest, ListHttpRoutesResponse, HttpRoute> context,
        ApiFuture<ListHttpRoutesResponse> futureResponse) {
      ApiFuture<ListHttpRoutesPage> futurePage =
          ListHttpRoutesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListHttpRoutesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListHttpRoutesPagedResponse(ListHttpRoutesPage page) {
      super(page, ListHttpRoutesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListHttpRoutesPage
      extends AbstractPage<
          ListHttpRoutesRequest, ListHttpRoutesResponse, HttpRoute, ListHttpRoutesPage> {

    private ListHttpRoutesPage(
        PageContext<ListHttpRoutesRequest, ListHttpRoutesResponse, HttpRoute> context,
        ListHttpRoutesResponse response) {
      super(context, response);
    }

    private static ListHttpRoutesPage createEmptyPage() {
      return new ListHttpRoutesPage(null, null);
    }

    @Override
    protected ListHttpRoutesPage createPage(
        PageContext<ListHttpRoutesRequest, ListHttpRoutesResponse, HttpRoute> context,
        ListHttpRoutesResponse response) {
      return new ListHttpRoutesPage(context, response);
    }

    @Override
    public ApiFuture<ListHttpRoutesPage> createPageAsync(
        PageContext<ListHttpRoutesRequest, ListHttpRoutesResponse, HttpRoute> context,
        ApiFuture<ListHttpRoutesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListHttpRoutesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListHttpRoutesRequest,
          ListHttpRoutesResponse,
          HttpRoute,
          ListHttpRoutesPage,
          ListHttpRoutesFixedSizeCollection> {

    private ListHttpRoutesFixedSizeCollection(List<ListHttpRoutesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListHttpRoutesFixedSizeCollection createEmptyCollection() {
      return new ListHttpRoutesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListHttpRoutesFixedSizeCollection createCollection(
        List<ListHttpRoutesPage> pages, int collectionSize) {
      return new ListHttpRoutesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTcpRoutesPagedResponse
      extends AbstractPagedListResponse<
          ListTcpRoutesRequest,
          ListTcpRoutesResponse,
          TcpRoute,
          ListTcpRoutesPage,
          ListTcpRoutesFixedSizeCollection> {

    public static ApiFuture<ListTcpRoutesPagedResponse> createAsync(
        PageContext<ListTcpRoutesRequest, ListTcpRoutesResponse, TcpRoute> context,
        ApiFuture<ListTcpRoutesResponse> futureResponse) {
      ApiFuture<ListTcpRoutesPage> futurePage =
          ListTcpRoutesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTcpRoutesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTcpRoutesPagedResponse(ListTcpRoutesPage page) {
      super(page, ListTcpRoutesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTcpRoutesPage
      extends AbstractPage<
          ListTcpRoutesRequest, ListTcpRoutesResponse, TcpRoute, ListTcpRoutesPage> {

    private ListTcpRoutesPage(
        PageContext<ListTcpRoutesRequest, ListTcpRoutesResponse, TcpRoute> context,
        ListTcpRoutesResponse response) {
      super(context, response);
    }

    private static ListTcpRoutesPage createEmptyPage() {
      return new ListTcpRoutesPage(null, null);
    }

    @Override
    protected ListTcpRoutesPage createPage(
        PageContext<ListTcpRoutesRequest, ListTcpRoutesResponse, TcpRoute> context,
        ListTcpRoutesResponse response) {
      return new ListTcpRoutesPage(context, response);
    }

    @Override
    public ApiFuture<ListTcpRoutesPage> createPageAsync(
        PageContext<ListTcpRoutesRequest, ListTcpRoutesResponse, TcpRoute> context,
        ApiFuture<ListTcpRoutesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTcpRoutesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTcpRoutesRequest,
          ListTcpRoutesResponse,
          TcpRoute,
          ListTcpRoutesPage,
          ListTcpRoutesFixedSizeCollection> {

    private ListTcpRoutesFixedSizeCollection(List<ListTcpRoutesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTcpRoutesFixedSizeCollection createEmptyCollection() {
      return new ListTcpRoutesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTcpRoutesFixedSizeCollection createCollection(
        List<ListTcpRoutesPage> pages, int collectionSize) {
      return new ListTcpRoutesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTlsRoutesPagedResponse
      extends AbstractPagedListResponse<
          ListTlsRoutesRequest,
          ListTlsRoutesResponse,
          TlsRoute,
          ListTlsRoutesPage,
          ListTlsRoutesFixedSizeCollection> {

    public static ApiFuture<ListTlsRoutesPagedResponse> createAsync(
        PageContext<ListTlsRoutesRequest, ListTlsRoutesResponse, TlsRoute> context,
        ApiFuture<ListTlsRoutesResponse> futureResponse) {
      ApiFuture<ListTlsRoutesPage> futurePage =
          ListTlsRoutesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTlsRoutesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTlsRoutesPagedResponse(ListTlsRoutesPage page) {
      super(page, ListTlsRoutesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTlsRoutesPage
      extends AbstractPage<
          ListTlsRoutesRequest, ListTlsRoutesResponse, TlsRoute, ListTlsRoutesPage> {

    private ListTlsRoutesPage(
        PageContext<ListTlsRoutesRequest, ListTlsRoutesResponse, TlsRoute> context,
        ListTlsRoutesResponse response) {
      super(context, response);
    }

    private static ListTlsRoutesPage createEmptyPage() {
      return new ListTlsRoutesPage(null, null);
    }

    @Override
    protected ListTlsRoutesPage createPage(
        PageContext<ListTlsRoutesRequest, ListTlsRoutesResponse, TlsRoute> context,
        ListTlsRoutesResponse response) {
      return new ListTlsRoutesPage(context, response);
    }

    @Override
    public ApiFuture<ListTlsRoutesPage> createPageAsync(
        PageContext<ListTlsRoutesRequest, ListTlsRoutesResponse, TlsRoute> context,
        ApiFuture<ListTlsRoutesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTlsRoutesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTlsRoutesRequest,
          ListTlsRoutesResponse,
          TlsRoute,
          ListTlsRoutesPage,
          ListTlsRoutesFixedSizeCollection> {

    private ListTlsRoutesFixedSizeCollection(List<ListTlsRoutesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTlsRoutesFixedSizeCollection createEmptyCollection() {
      return new ListTlsRoutesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTlsRoutesFixedSizeCollection createCollection(
        List<ListTlsRoutesPage> pages, int collectionSize) {
      return new ListTlsRoutesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListServiceBindingsPagedResponse
      extends AbstractPagedListResponse<
          ListServiceBindingsRequest,
          ListServiceBindingsResponse,
          ServiceBinding,
          ListServiceBindingsPage,
          ListServiceBindingsFixedSizeCollection> {

    public static ApiFuture<ListServiceBindingsPagedResponse> createAsync(
        PageContext<ListServiceBindingsRequest, ListServiceBindingsResponse, ServiceBinding>
            context,
        ApiFuture<ListServiceBindingsResponse> futureResponse) {
      ApiFuture<ListServiceBindingsPage> futurePage =
          ListServiceBindingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListServiceBindingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListServiceBindingsPagedResponse(ListServiceBindingsPage page) {
      super(page, ListServiceBindingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListServiceBindingsPage
      extends AbstractPage<
          ListServiceBindingsRequest,
          ListServiceBindingsResponse,
          ServiceBinding,
          ListServiceBindingsPage> {

    private ListServiceBindingsPage(
        PageContext<ListServiceBindingsRequest, ListServiceBindingsResponse, ServiceBinding>
            context,
        ListServiceBindingsResponse response) {
      super(context, response);
    }

    private static ListServiceBindingsPage createEmptyPage() {
      return new ListServiceBindingsPage(null, null);
    }

    @Override
    protected ListServiceBindingsPage createPage(
        PageContext<ListServiceBindingsRequest, ListServiceBindingsResponse, ServiceBinding>
            context,
        ListServiceBindingsResponse response) {
      return new ListServiceBindingsPage(context, response);
    }

    @Override
    public ApiFuture<ListServiceBindingsPage> createPageAsync(
        PageContext<ListServiceBindingsRequest, ListServiceBindingsResponse, ServiceBinding>
            context,
        ApiFuture<ListServiceBindingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListServiceBindingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListServiceBindingsRequest,
          ListServiceBindingsResponse,
          ServiceBinding,
          ListServiceBindingsPage,
          ListServiceBindingsFixedSizeCollection> {

    private ListServiceBindingsFixedSizeCollection(
        List<ListServiceBindingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListServiceBindingsFixedSizeCollection createEmptyCollection() {
      return new ListServiceBindingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListServiceBindingsFixedSizeCollection createCollection(
        List<ListServiceBindingsPage> pages, int collectionSize) {
      return new ListServiceBindingsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMeshesPagedResponse
      extends AbstractPagedListResponse<
          ListMeshesRequest,
          ListMeshesResponse,
          Mesh,
          ListMeshesPage,
          ListMeshesFixedSizeCollection> {

    public static ApiFuture<ListMeshesPagedResponse> createAsync(
        PageContext<ListMeshesRequest, ListMeshesResponse, Mesh> context,
        ApiFuture<ListMeshesResponse> futureResponse) {
      ApiFuture<ListMeshesPage> futurePage =
          ListMeshesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListMeshesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListMeshesPagedResponse(ListMeshesPage page) {
      super(page, ListMeshesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMeshesPage
      extends AbstractPage<ListMeshesRequest, ListMeshesResponse, Mesh, ListMeshesPage> {

    private ListMeshesPage(
        PageContext<ListMeshesRequest, ListMeshesResponse, Mesh> context,
        ListMeshesResponse response) {
      super(context, response);
    }

    private static ListMeshesPage createEmptyPage() {
      return new ListMeshesPage(null, null);
    }

    @Override
    protected ListMeshesPage createPage(
        PageContext<ListMeshesRequest, ListMeshesResponse, Mesh> context,
        ListMeshesResponse response) {
      return new ListMeshesPage(context, response);
    }

    @Override
    public ApiFuture<ListMeshesPage> createPageAsync(
        PageContext<ListMeshesRequest, ListMeshesResponse, Mesh> context,
        ApiFuture<ListMeshesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMeshesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMeshesRequest,
          ListMeshesResponse,
          Mesh,
          ListMeshesPage,
          ListMeshesFixedSizeCollection> {

    private ListMeshesFixedSizeCollection(List<ListMeshesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMeshesFixedSizeCollection createEmptyCollection() {
      return new ListMeshesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMeshesFixedSizeCollection createCollection(
        List<ListMeshesPage> pages, int collectionSize) {
      return new ListMeshesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
