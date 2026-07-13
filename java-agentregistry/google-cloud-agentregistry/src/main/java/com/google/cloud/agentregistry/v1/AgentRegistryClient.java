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

package com.google.cloud.agentregistry.v1;

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
import com.google.cloud.agentregistry.v1.stub.AgentRegistryStub;
import com.google.cloud.agentregistry.v1.stub.AgentRegistryStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing Agents, Endpoints, McpServers, Services, and Bindings.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
 *   AgentName name = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
 *   Agent response = agentRegistryClient.getAgent(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AgentRegistryClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListAgents</td>
 *      <td><p> Lists Agents in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAgents(ListAgentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAgents(LocationName parent)
 *           <li><p> listAgents(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAgentsPagedCallable()
 *           <li><p> listAgentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchAgents</td>
 *      <td><p> Searches Agents in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchAgents(SearchAgentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> searchAgents(LocationName parent)
 *           <li><p> searchAgents(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchAgentsPagedCallable()
 *           <li><p> searchAgentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAgent</td>
 *      <td><p> Gets details of a single Agent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAgent(GetAgentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAgent(AgentName name)
 *           <li><p> getAgent(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAgentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEndpoints</td>
 *      <td><p> Lists Endpoints in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEndpoints(ListEndpointsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEndpoints(LocationName parent)
 *           <li><p> listEndpoints(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEndpointsPagedCallable()
 *           <li><p> listEndpointsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEndpoint</td>
 *      <td><p> Gets details of a single Endpoint.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEndpoint(GetEndpointRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEndpoint(EndpointName name)
 *           <li><p> getEndpoint(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEndpointCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMcpServers</td>
 *      <td><p> Lists McpServers in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMcpServers(ListMcpServersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMcpServers(LocationName parent)
 *           <li><p> listMcpServers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMcpServersPagedCallable()
 *           <li><p> listMcpServersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchMcpServers</td>
 *      <td><p> Searches McpServers in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchMcpServers(SearchMcpServersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> searchMcpServers(LocationName parent)
 *           <li><p> searchMcpServers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchMcpServersPagedCallable()
 *           <li><p> searchMcpServersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMcpServer</td>
 *      <td><p> Gets details of a single McpServer.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMcpServer(GetMcpServerRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMcpServer(McpServerName name)
 *           <li><p> getMcpServer(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMcpServerCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListServices</td>
 *      <td><p> Lists Services in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listServices(ListServicesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listServices(LocationName parent)
 *           <li><p> listServices(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listServicesPagedCallable()
 *           <li><p> listServicesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetService</td>
 *      <td><p> Gets details of a single Service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getService(GetServiceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getService(ServiceName name)
 *           <li><p> getService(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getServiceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateService</td>
 *      <td><p> Creates a new Service in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createServiceAsync(CreateServiceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createServiceAsync(LocationName parent, Service service, String serviceId)
 *           <li><p> createServiceAsync(String parent, Service service, String serviceId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createServiceOperationCallable()
 *           <li><p> createServiceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateService</td>
 *      <td><p> Updates the parameters of a single Service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateServiceAsync(UpdateServiceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateServiceAsync(Service service, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateServiceOperationCallable()
 *           <li><p> updateServiceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteService</td>
 *      <td><p> Deletes a single Service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteServiceAsync(DeleteServiceRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteServiceAsync(ServiceName name)
 *           <li><p> deleteServiceAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteServiceOperationCallable()
 *           <li><p> deleteServiceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListBindings</td>
 *      <td><p> Lists Bindings in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listBindings(ListBindingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listBindings(LocationName parent)
 *           <li><p> listBindings(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listBindingsPagedCallable()
 *           <li><p> listBindingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetBinding</td>
 *      <td><p> Gets details of a single Binding.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getBinding(GetBindingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getBinding(BindingName name)
 *           <li><p> getBinding(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateBinding</td>
 *      <td><p> Creates a new Binding in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createBindingAsync(CreateBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createBindingAsync(LocationName parent, Binding binding, String bindingId)
 *           <li><p> createBindingAsync(String parent, Binding binding, String bindingId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createBindingOperationCallable()
 *           <li><p> createBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateBinding</td>
 *      <td><p> Updates the parameters of a single Binding.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateBindingAsync(UpdateBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateBindingAsync(Binding binding, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateBindingOperationCallable()
 *           <li><p> updateBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteBinding</td>
 *      <td><p> Deletes a single Binding.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteBindingAsync(DeleteBindingRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteBindingAsync(BindingName name)
 *           <li><p> deleteBindingAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteBindingOperationCallable()
 *           <li><p> deleteBindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchAvailableBindings</td>
 *      <td><p> Fetches available Bindings.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchAvailableBindings(FetchAvailableBindingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> fetchAvailableBindings(LocationName parent)
 *           <li><p> fetchAvailableBindings(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchAvailableBindingsPagedCallable()
 *           <li><p> fetchAvailableBindingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.
 * <p> This method lists locations based on the resource scope provided inthe [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field: &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If `name` follows the format`projects/{project}`, the method lists locations visible to thatspecific project. This includes public, private, or otherproject-specific locations enabled for the project.
 * <p> For gRPC and client library implementations, the resource name ispassed as the `name` field. For direct service calls, the resourcename isincorporated into the request path based on the specific serviceimplementation and version.</td>
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
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of AgentRegistrySettings to
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
 * AgentRegistrySettings agentRegistrySettings =
 *     AgentRegistrySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AgentRegistryClient agentRegistryClient = AgentRegistryClient.create(agentRegistrySettings);
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
 * AgentRegistrySettings agentRegistrySettings =
 *     AgentRegistrySettings.newBuilder().setEndpoint(myEndpoint).build();
 * AgentRegistryClient agentRegistryClient = AgentRegistryClient.create(agentRegistrySettings);
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
 * AgentRegistrySettings agentRegistrySettings =
 *     AgentRegistrySettings.newHttpJsonBuilder().build();
 * AgentRegistryClient agentRegistryClient = AgentRegistryClient.create(agentRegistrySettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class AgentRegistryClient implements BackgroundResource {
  private final AgentRegistrySettings settings;
  private final AgentRegistryStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of AgentRegistryClient with default settings. */
  public static final AgentRegistryClient create() throws IOException {
    return create(AgentRegistrySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AgentRegistryClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AgentRegistryClient create(AgentRegistrySettings settings)
      throws IOException {
    return new AgentRegistryClient(settings);
  }

  /**
   * Constructs an instance of AgentRegistryClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(AgentRegistrySettings).
   */
  public static final AgentRegistryClient create(AgentRegistryStub stub) {
    return new AgentRegistryClient(stub);
  }

  /**
   * Constructs an instance of AgentRegistryClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AgentRegistryClient(AgentRegistrySettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AgentRegistryStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected AgentRegistryClient(AgentRegistryStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final AgentRegistrySettings getSettings() {
    return settings;
  }

  public AgentRegistryStub getStub() {
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
   * Lists Agents in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Agent element : agentRegistryClient.listAgents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListAgentsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAgentsPagedResponse listAgents(LocationName parent) {
    ListAgentsRequest request =
        ListAgentsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listAgents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Agents in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Agent element : agentRegistryClient.listAgents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListAgentsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAgentsPagedResponse listAgents(String parent) {
    ListAgentsRequest request = ListAgentsRequest.newBuilder().setParent(parent).build();
    return listAgents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Agents in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   ListAgentsRequest request =
   *       ListAgentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Agent element : agentRegistryClient.listAgents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAgentsPagedResponse listAgents(ListAgentsRequest request) {
    return listAgentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Agents in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   ListAgentsRequest request =
   *       ListAgentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Agent> future = agentRegistryClient.listAgentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Agent element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAgentsRequest, ListAgentsPagedResponse> listAgentsPagedCallable() {
    return stub.listAgentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Agents in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   ListAgentsRequest request =
   *       ListAgentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListAgentsResponse response = agentRegistryClient.listAgentsCallable().call(request);
   *     for (Agent element : response.getAgentsList()) {
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
  public final UnaryCallable<ListAgentsRequest, ListAgentsResponse> listAgentsCallable() {
    return stub.listAgentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches Agents in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Agent element : agentRegistryClient.searchAgents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for SearchAgentsRequest. Format:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAgentsPagedResponse searchAgents(LocationName parent) {
    SearchAgentsRequest request =
        SearchAgentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return searchAgents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches Agents in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Agent element : agentRegistryClient.searchAgents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for SearchAgentsRequest. Format:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAgentsPagedResponse searchAgents(String parent) {
    SearchAgentsRequest request = SearchAgentsRequest.newBuilder().setParent(parent).build();
    return searchAgents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches Agents in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   SearchAgentsRequest request =
   *       SearchAgentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSearchString("searchString120312793")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Agent element : agentRegistryClient.searchAgents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAgentsPagedResponse searchAgents(SearchAgentsRequest request) {
    return searchAgentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches Agents in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   SearchAgentsRequest request =
   *       SearchAgentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSearchString("searchString120312793")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Agent> future = agentRegistryClient.searchAgentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Agent element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchAgentsRequest, SearchAgentsPagedResponse>
      searchAgentsPagedCallable() {
    return stub.searchAgentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches Agents in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   SearchAgentsRequest request =
   *       SearchAgentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSearchString("searchString120312793")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchAgentsResponse response = agentRegistryClient.searchAgentsCallable().call(request);
   *     for (Agent element : response.getAgentsList()) {
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
  public final UnaryCallable<SearchAgentsRequest, SearchAgentsResponse> searchAgentsCallable() {
    return stub.searchAgentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   AgentName name = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
   *   Agent response = agentRegistryClient.getAgent(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Agent getAgent(AgentName name) {
    GetAgentRequest request =
        GetAgentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   String name = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString();
   *   Agent response = agentRegistryClient.getAgent(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Agent getAgent(String name) {
    GetAgentRequest request = GetAgentRequest.newBuilder().setName(name).build();
    return getAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   GetAgentRequest request =
   *       GetAgentRequest.newBuilder()
   *           .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .build();
   *   Agent response = agentRegistryClient.getAgent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Agent getAgent(GetAgentRequest request) {
    return getAgentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   GetAgentRequest request =
   *       GetAgentRequest.newBuilder()
   *           .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .build();
   *   ApiFuture<Agent> future = agentRegistryClient.getAgentCallable().futureCall(request);
   *   // Do something.
   *   Agent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAgentRequest, Agent> getAgentCallable() {
    return stub.getAgentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Endpoints in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Endpoint element : agentRegistryClient.listEndpoints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to list endpoints in. Expected format:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEndpointsPagedResponse listEndpoints(LocationName parent) {
    ListEndpointsRequest request =
        ListEndpointsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEndpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Endpoints in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Endpoint element : agentRegistryClient.listEndpoints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to list endpoints in. Expected format:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEndpointsPagedResponse listEndpoints(String parent) {
    ListEndpointsRequest request = ListEndpointsRequest.newBuilder().setParent(parent).build();
    return listEndpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Endpoints in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   ListEndpointsRequest request =
   *       ListEndpointsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Endpoint element : agentRegistryClient.listEndpoints(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEndpointsPagedResponse listEndpoints(ListEndpointsRequest request) {
    return listEndpointsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Endpoints in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   ListEndpointsRequest request =
   *       ListEndpointsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Endpoint> future =
   *       agentRegistryClient.listEndpointsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Endpoint element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEndpointsRequest, ListEndpointsPagedResponse>
      listEndpointsPagedCallable() {
    return stub.listEndpointsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Endpoints in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   ListEndpointsRequest request =
   *       ListEndpointsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListEndpointsResponse response = agentRegistryClient.listEndpointsCallable().call(request);
   *     for (Endpoint element : response.getEndpointsList()) {
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
  public final UnaryCallable<ListEndpointsRequest, ListEndpointsResponse> listEndpointsCallable() {
    return stub.listEndpointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   EndpointName name = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
   *   Endpoint response = agentRegistryClient.getEndpoint(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the endpoint to retrieve. Format:
   *     `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Endpoint getEndpoint(EndpointName name) {
    GetEndpointRequest request =
        GetEndpointRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   String name = EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString();
   *   Endpoint response = agentRegistryClient.getEndpoint(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the endpoint to retrieve. Format:
   *     `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Endpoint getEndpoint(String name) {
    GetEndpointRequest request = GetEndpointRequest.newBuilder().setName(name).build();
    return getEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   GetEndpointRequest request =
   *       GetEndpointRequest.newBuilder()
   *           .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
   *           .build();
   *   Endpoint response = agentRegistryClient.getEndpoint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Endpoint getEndpoint(GetEndpointRequest request) {
    return getEndpointCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Endpoint.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   GetEndpointRequest request =
   *       GetEndpointRequest.newBuilder()
   *           .setName(EndpointName.of("[PROJECT]", "[LOCATION]", "[ENDPOINT]").toString())
   *           .build();
   *   ApiFuture<Endpoint> future = agentRegistryClient.getEndpointCallable().futureCall(request);
   *   // Do something.
   *   Endpoint response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEndpointRequest, Endpoint> getEndpointCallable() {
    return stub.getEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists McpServers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (McpServer element : agentRegistryClient.listMcpServers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListMcpServersRequest. Format:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMcpServersPagedResponse listMcpServers(LocationName parent) {
    ListMcpServersRequest request =
        ListMcpServersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMcpServers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists McpServers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (McpServer element : agentRegistryClient.listMcpServers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListMcpServersRequest. Format:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMcpServersPagedResponse listMcpServers(String parent) {
    ListMcpServersRequest request = ListMcpServersRequest.newBuilder().setParent(parent).build();
    return listMcpServers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists McpServers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   ListMcpServersRequest request =
   *       ListMcpServersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (McpServer element : agentRegistryClient.listMcpServers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMcpServersPagedResponse listMcpServers(ListMcpServersRequest request) {
    return listMcpServersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists McpServers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   ListMcpServersRequest request =
   *       ListMcpServersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<McpServer> future =
   *       agentRegistryClient.listMcpServersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (McpServer element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMcpServersRequest, ListMcpServersPagedResponse>
      listMcpServersPagedCallable() {
    return stub.listMcpServersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists McpServers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   ListMcpServersRequest request =
   *       ListMcpServersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListMcpServersResponse response =
   *         agentRegistryClient.listMcpServersCallable().call(request);
   *     for (McpServer element : response.getMcpServersList()) {
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
  public final UnaryCallable<ListMcpServersRequest, ListMcpServersResponse>
      listMcpServersCallable() {
    return stub.listMcpServersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches McpServers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (McpServer element : agentRegistryClient.searchMcpServers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for SearchMcpServersRequest. Format:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchMcpServersPagedResponse searchMcpServers(LocationName parent) {
    SearchMcpServersRequest request =
        SearchMcpServersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return searchMcpServers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches McpServers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (McpServer element : agentRegistryClient.searchMcpServers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for SearchMcpServersRequest. Format:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchMcpServersPagedResponse searchMcpServers(String parent) {
    SearchMcpServersRequest request =
        SearchMcpServersRequest.newBuilder().setParent(parent).build();
    return searchMcpServers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches McpServers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   SearchMcpServersRequest request =
   *       SearchMcpServersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSearchString("searchString120312793")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (McpServer element : agentRegistryClient.searchMcpServers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchMcpServersPagedResponse searchMcpServers(SearchMcpServersRequest request) {
    return searchMcpServersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches McpServers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   SearchMcpServersRequest request =
   *       SearchMcpServersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSearchString("searchString120312793")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<McpServer> future =
   *       agentRegistryClient.searchMcpServersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (McpServer element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchMcpServersRequest, SearchMcpServersPagedResponse>
      searchMcpServersPagedCallable() {
    return stub.searchMcpServersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches McpServers in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   SearchMcpServersRequest request =
   *       SearchMcpServersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSearchString("searchString120312793")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchMcpServersResponse response =
   *         agentRegistryClient.searchMcpServersCallable().call(request);
   *     for (McpServer element : response.getMcpServersList()) {
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
  public final UnaryCallable<SearchMcpServersRequest, SearchMcpServersResponse>
      searchMcpServersCallable() {
    return stub.searchMcpServersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single McpServer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   McpServerName name = McpServerName.of("[PROJECT]", "[LOCATION]", "[MCP_SERVER]");
   *   McpServer response = agentRegistryClient.getMcpServer(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final McpServer getMcpServer(McpServerName name) {
    GetMcpServerRequest request =
        GetMcpServerRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getMcpServer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single McpServer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   String name = McpServerName.of("[PROJECT]", "[LOCATION]", "[MCP_SERVER]").toString();
   *   McpServer response = agentRegistryClient.getMcpServer(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final McpServer getMcpServer(String name) {
    GetMcpServerRequest request = GetMcpServerRequest.newBuilder().setName(name).build();
    return getMcpServer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single McpServer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   GetMcpServerRequest request =
   *       GetMcpServerRequest.newBuilder()
   *           .setName(McpServerName.of("[PROJECT]", "[LOCATION]", "[MCP_SERVER]").toString())
   *           .build();
   *   McpServer response = agentRegistryClient.getMcpServer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final McpServer getMcpServer(GetMcpServerRequest request) {
    return getMcpServerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single McpServer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   GetMcpServerRequest request =
   *       GetMcpServerRequest.newBuilder()
   *           .setName(McpServerName.of("[PROJECT]", "[LOCATION]", "[MCP_SERVER]").toString())
   *           .build();
   *   ApiFuture<McpServer> future = agentRegistryClient.getMcpServerCallable().futureCall(request);
   *   // Do something.
   *   McpServer response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMcpServerRequest, McpServer> getMcpServerCallable() {
    return stub.getMcpServerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Services in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Service element : agentRegistryClient.listServices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to list services in. Expected format:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServicesPagedResponse listServices(LocationName parent) {
    ListServicesRequest request =
        ListServicesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listServices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Services in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Service element : agentRegistryClient.listServices(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to list services in. Expected format:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServicesPagedResponse listServices(String parent) {
    ListServicesRequest request = ListServicesRequest.newBuilder().setParent(parent).build();
    return listServices(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Services in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   ListServicesRequest request =
   *       ListServicesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Service element : agentRegistryClient.listServices(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListServicesPagedResponse listServices(ListServicesRequest request) {
    return listServicesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Services in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   ListServicesRequest request =
   *       ListServicesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Service> future =
   *       agentRegistryClient.listServicesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Service element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListServicesRequest, ListServicesPagedResponse>
      listServicesPagedCallable() {
    return stub.listServicesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Services in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   ListServicesRequest request =
   *       ListServicesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListServicesResponse response = agentRegistryClient.listServicesCallable().call(request);
   *     for (Service element : response.getServicesList()) {
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
  public final UnaryCallable<ListServicesRequest, ListServicesResponse> listServicesCallable() {
    return stub.listServicesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
   *   Service response = agentRegistryClient.getService(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Service. Format:
   *     `projects/{project}/locations/{location}/services/{service}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Service getService(ServiceName name) {
    GetServiceRequest request =
        GetServiceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   String name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString();
   *   Service response = agentRegistryClient.getService(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Service. Format:
   *     `projects/{project}/locations/{location}/services/{service}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Service getService(String name) {
    GetServiceRequest request = GetServiceRequest.newBuilder().setName(name).build();
    return getService(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   GetServiceRequest request =
   *       GetServiceRequest.newBuilder()
   *           .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .build();
   *   Service response = agentRegistryClient.getService(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Service getService(GetServiceRequest request) {
    return getServiceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   GetServiceRequest request =
   *       GetServiceRequest.newBuilder()
   *           .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .build();
   *   ApiFuture<Service> future = agentRegistryClient.getServiceCallable().futureCall(request);
   *   // Do something.
   *   Service response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetServiceRequest, Service> getServiceCallable() {
    return stub.getServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Service in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Service service = Service.newBuilder().build();
   *   String serviceId = "serviceId-194185552";
   *   Service response = agentRegistryClient.createServiceAsync(parent, service, serviceId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to create the Service in. Expected format:
   *     `projects/{project}/locations/{location}`.
   * @param service Required. The Service resource that is being created. Format:
   *     `projects/{project}/locations/{location}/services/{service}`.
   * @param serviceId Required. The ID to use for the service, which will become the final component
   *     of the service's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are `/[a-z][0-9]-/`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Service, OperationMetadata> createServiceAsync(
      LocationName parent, Service service, String serviceId) {
    CreateServiceRequest request =
        CreateServiceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setService(service)
            .setServiceId(serviceId)
            .build();
    return createServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Service in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Service service = Service.newBuilder().build();
   *   String serviceId = "serviceId-194185552";
   *   Service response = agentRegistryClient.createServiceAsync(parent, service, serviceId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to create the Service in. Expected format:
   *     `projects/{project}/locations/{location}`.
   * @param service Required. The Service resource that is being created. Format:
   *     `projects/{project}/locations/{location}/services/{service}`.
   * @param serviceId Required. The ID to use for the service, which will become the final component
   *     of the service's resource name.
   *     <p>This value should be 4-63 characters, and valid characters are `/[a-z][0-9]-/`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Service, OperationMetadata> createServiceAsync(
      String parent, Service service, String serviceId) {
    CreateServiceRequest request =
        CreateServiceRequest.newBuilder()
            .setParent(parent)
            .setService(service)
            .setServiceId(serviceId)
            .build();
    return createServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Service in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   CreateServiceRequest request =
   *       CreateServiceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServiceId("serviceId-194185552")
   *           .setService(Service.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Service response = agentRegistryClient.createServiceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Service, OperationMetadata> createServiceAsync(
      CreateServiceRequest request) {
    return createServiceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Service in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   CreateServiceRequest request =
   *       CreateServiceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServiceId("serviceId-194185552")
   *           .setService(Service.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Service, OperationMetadata> future =
   *       agentRegistryClient.createServiceOperationCallable().futureCall(request);
   *   // Do something.
   *   Service response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateServiceRequest, Service, OperationMetadata>
      createServiceOperationCallable() {
    return stub.createServiceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Service in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   CreateServiceRequest request =
   *       CreateServiceRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setServiceId("serviceId-194185552")
   *           .setService(Service.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = agentRegistryClient.createServiceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateServiceRequest, Operation> createServiceCallable() {
    return stub.createServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   Service service = Service.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Service response = agentRegistryClient.updateServiceAsync(service, updateMask).get();
   * }
   * }</pre>
   *
   * @param service Required. The Service resource that is being updated. Format:
   *     `projects/{project}/locations/{location}/services/{service}`.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     Service resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields present in the request will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Service, OperationMetadata> updateServiceAsync(
      Service service, FieldMask updateMask) {
    UpdateServiceRequest request =
        UpdateServiceRequest.newBuilder().setService(service).setUpdateMask(updateMask).build();
    return updateServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   UpdateServiceRequest request =
   *       UpdateServiceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setService(Service.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Service response = agentRegistryClient.updateServiceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Service, OperationMetadata> updateServiceAsync(
      UpdateServiceRequest request) {
    return updateServiceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   UpdateServiceRequest request =
   *       UpdateServiceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setService(Service.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Service, OperationMetadata> future =
   *       agentRegistryClient.updateServiceOperationCallable().futureCall(request);
   *   // Do something.
   *   Service response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateServiceRequest, Service, OperationMetadata>
      updateServiceOperationCallable() {
    return stub.updateServiceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   UpdateServiceRequest request =
   *       UpdateServiceRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setService(Service.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = agentRegistryClient.updateServiceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateServiceRequest, Operation> updateServiceCallable() {
    return stub.updateServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   ServiceName name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]");
   *   agentRegistryClient.deleteServiceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Service. Format:
   *     `projects/{project}/locations/{location}/services/{service}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceAsync(ServiceName name) {
    DeleteServiceRequest request =
        DeleteServiceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   String name = ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString();
   *   agentRegistryClient.deleteServiceAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Service. Format:
   *     `projects/{project}/locations/{location}/services/{service}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceAsync(String name) {
    DeleteServiceRequest request = DeleteServiceRequest.newBuilder().setName(name).build();
    return deleteServiceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   DeleteServiceRequest request =
   *       DeleteServiceRequest.newBuilder()
   *           .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   agentRegistryClient.deleteServiceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteServiceAsync(
      DeleteServiceRequest request) {
    return deleteServiceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   DeleteServiceRequest request =
   *       DeleteServiceRequest.newBuilder()
   *           .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       agentRegistryClient.deleteServiceOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteServiceRequest, Empty, OperationMetadata>
      deleteServiceOperationCallable() {
    return stub.deleteServiceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   DeleteServiceRequest request =
   *       DeleteServiceRequest.newBuilder()
   *           .setName(ServiceName.of("[PROJECT]", "[LOCATION]", "[SERVICE]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = agentRegistryClient.deleteServiceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteServiceRequest, Operation> deleteServiceCallable() {
    return stub.deleteServiceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Bindings in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Binding element : agentRegistryClient.listBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to list bindings in. Expected format:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBindingsPagedResponse listBindings(LocationName parent) {
    ListBindingsRequest request =
        ListBindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Bindings in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Binding element : agentRegistryClient.listBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to list bindings in. Expected format:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBindingsPagedResponse listBindings(String parent) {
    ListBindingsRequest request = ListBindingsRequest.newBuilder().setParent(parent).build();
    return listBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Bindings in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   ListBindingsRequest request =
   *       ListBindingsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Binding element : agentRegistryClient.listBindings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListBindingsPagedResponse listBindings(ListBindingsRequest request) {
    return listBindingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Bindings in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   ListBindingsRequest request =
   *       ListBindingsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Binding> future =
   *       agentRegistryClient.listBindingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Binding element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBindingsRequest, ListBindingsPagedResponse>
      listBindingsPagedCallable() {
    return stub.listBindingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Bindings in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   ListBindingsRequest request =
   *       ListBindingsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListBindingsResponse response = agentRegistryClient.listBindingsCallable().call(request);
   *     for (Binding element : response.getBindingsList()) {
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
  public final UnaryCallable<ListBindingsRequest, ListBindingsResponse> listBindingsCallable() {
    return stub.listBindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   BindingName name = BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]");
   *   Binding response = agentRegistryClient.getBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Binding. Format:
   *     `projects/{project}/locations/{location}/bindings/{binding}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Binding getBinding(BindingName name) {
    GetBindingRequest request =
        GetBindingRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   String name = BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]").toString();
   *   Binding response = agentRegistryClient.getBinding(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Binding. Format:
   *     `projects/{project}/locations/{location}/bindings/{binding}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Binding getBinding(String name) {
    GetBindingRequest request = GetBindingRequest.newBuilder().setName(name).build();
    return getBinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   GetBindingRequest request =
   *       GetBindingRequest.newBuilder()
   *           .setName(BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]").toString())
   *           .build();
   *   Binding response = agentRegistryClient.getBinding(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Binding getBinding(GetBindingRequest request) {
    return getBindingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   GetBindingRequest request =
   *       GetBindingRequest.newBuilder()
   *           .setName(BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]").toString())
   *           .build();
   *   ApiFuture<Binding> future = agentRegistryClient.getBindingCallable().futureCall(request);
   *   // Do something.
   *   Binding response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBindingRequest, Binding> getBindingCallable() {
    return stub.getBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Binding in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Binding binding = Binding.newBuilder().build();
   *   String bindingId = "bindingId-920966528";
   *   Binding response = agentRegistryClient.createBindingAsync(parent, binding, bindingId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to create the Binding in. Expected format:
   *     `projects/{project}/locations/{location}`.
   * @param binding Required. The Binding resource that is being created.
   * @param bindingId Required. The ID to use for the binding, which will become the final component
   *     of the binding's resource name.
   *     <p>This value should be 4-63 characters, and must conform to RFC-1034. Specifically, it
   *     must match the regular expression `^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Binding, OperationMetadata> createBindingAsync(
      LocationName parent, Binding binding, String bindingId) {
    CreateBindingRequest request =
        CreateBindingRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setBinding(binding)
            .setBindingId(bindingId)
            .build();
    return createBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Binding in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Binding binding = Binding.newBuilder().build();
   *   String bindingId = "bindingId-920966528";
   *   Binding response = agentRegistryClient.createBindingAsync(parent, binding, bindingId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location to create the Binding in. Expected format:
   *     `projects/{project}/locations/{location}`.
   * @param binding Required. The Binding resource that is being created.
   * @param bindingId Required. The ID to use for the binding, which will become the final component
   *     of the binding's resource name.
   *     <p>This value should be 4-63 characters, and must conform to RFC-1034. Specifically, it
   *     must match the regular expression `^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Binding, OperationMetadata> createBindingAsync(
      String parent, Binding binding, String bindingId) {
    CreateBindingRequest request =
        CreateBindingRequest.newBuilder()
            .setParent(parent)
            .setBinding(binding)
            .setBindingId(bindingId)
            .build();
    return createBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Binding in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   CreateBindingRequest request =
   *       CreateBindingRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBindingId("bindingId-920966528")
   *           .setBinding(Binding.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Binding response = agentRegistryClient.createBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Binding, OperationMetadata> createBindingAsync(
      CreateBindingRequest request) {
    return createBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Binding in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   CreateBindingRequest request =
   *       CreateBindingRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBindingId("bindingId-920966528")
   *           .setBinding(Binding.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Binding, OperationMetadata> future =
   *       agentRegistryClient.createBindingOperationCallable().futureCall(request);
   *   // Do something.
   *   Binding response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateBindingRequest, Binding, OperationMetadata>
      createBindingOperationCallable() {
    return stub.createBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new Binding in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   CreateBindingRequest request =
   *       CreateBindingRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setBindingId("bindingId-920966528")
   *           .setBinding(Binding.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = agentRegistryClient.createBindingCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateBindingRequest, Operation> createBindingCallable() {
    return stub.createBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   Binding binding = Binding.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Binding response = agentRegistryClient.updateBindingAsync(binding, updateMask).get();
   * }
   * }</pre>
   *
   * @param binding Required. The Binding resource that is being updated.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     Binding resource by the update. The fields specified in the update_mask are relative to the
   *     resource, not the full request. A field will be overwritten if it is in the mask. If the
   *     user does not provide a mask then all fields present in the request will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Binding, OperationMetadata> updateBindingAsync(
      Binding binding, FieldMask updateMask) {
    UpdateBindingRequest request =
        UpdateBindingRequest.newBuilder().setBinding(binding).setUpdateMask(updateMask).build();
    return updateBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   UpdateBindingRequest request =
   *       UpdateBindingRequest.newBuilder()
   *           .setBinding(Binding.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Binding response = agentRegistryClient.updateBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Binding, OperationMetadata> updateBindingAsync(
      UpdateBindingRequest request) {
    return updateBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   UpdateBindingRequest request =
   *       UpdateBindingRequest.newBuilder()
   *           .setBinding(Binding.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Binding, OperationMetadata> future =
   *       agentRegistryClient.updateBindingOperationCallable().futureCall(request);
   *   // Do something.
   *   Binding response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateBindingRequest, Binding, OperationMetadata>
      updateBindingOperationCallable() {
    return stub.updateBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the parameters of a single Binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   UpdateBindingRequest request =
   *       UpdateBindingRequest.newBuilder()
   *           .setBinding(Binding.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = agentRegistryClient.updateBindingCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBindingRequest, Operation> updateBindingCallable() {
    return stub.updateBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   BindingName name = BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]");
   *   agentRegistryClient.deleteBindingAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Binding. Format:
   *     `projects/{project}/locations/{location}/bindings/{binding}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBindingAsync(BindingName name) {
    DeleteBindingRequest request =
        DeleteBindingRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   String name = BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]").toString();
   *   agentRegistryClient.deleteBindingAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Binding. Format:
   *     `projects/{project}/locations/{location}/bindings/{binding}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBindingAsync(String name) {
    DeleteBindingRequest request = DeleteBindingRequest.newBuilder().setName(name).build();
    return deleteBindingAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   DeleteBindingRequest request =
   *       DeleteBindingRequest.newBuilder()
   *           .setName(BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   agentRegistryClient.deleteBindingAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteBindingAsync(
      DeleteBindingRequest request) {
    return deleteBindingOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   DeleteBindingRequest request =
   *       DeleteBindingRequest.newBuilder()
   *           .setName(BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       agentRegistryClient.deleteBindingOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteBindingRequest, Empty, OperationMetadata>
      deleteBindingOperationCallable() {
    return stub.deleteBindingOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a single Binding.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   DeleteBindingRequest request =
   *       DeleteBindingRequest.newBuilder()
   *           .setName(BindingName.of("[PROJECT]", "[LOCATION]", "[BINDING]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = agentRegistryClient.deleteBindingCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBindingRequest, Operation> deleteBindingCallable() {
    return stub.deleteBindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches available Bindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Binding element : agentRegistryClient.fetchAvailableBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, in the format `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchAvailableBindingsPagedResponse fetchAvailableBindings(LocationName parent) {
    FetchAvailableBindingsRequest request =
        FetchAvailableBindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return fetchAvailableBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches available Bindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Binding element : agentRegistryClient.fetchAvailableBindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, in the format `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchAvailableBindingsPagedResponse fetchAvailableBindings(String parent) {
    FetchAvailableBindingsRequest request =
        FetchAvailableBindingsRequest.newBuilder().setParent(parent).build();
    return fetchAvailableBindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches available Bindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   FetchAvailableBindingsRequest request =
   *       FetchAvailableBindingsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Binding element : agentRegistryClient.fetchAvailableBindings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchAvailableBindingsPagedResponse fetchAvailableBindings(
      FetchAvailableBindingsRequest request) {
    return fetchAvailableBindingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches available Bindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   FetchAvailableBindingsRequest request =
   *       FetchAvailableBindingsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Binding> future =
   *       agentRegistryClient.fetchAvailableBindingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Binding element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchAvailableBindingsRequest, FetchAvailableBindingsPagedResponse>
      fetchAvailableBindingsPagedCallable() {
    return stub.fetchAvailableBindingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches available Bindings.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   FetchAvailableBindingsRequest request =
   *       FetchAvailableBindingsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     FetchAvailableBindingsResponse response =
   *         agentRegistryClient.fetchAvailableBindingsCallable().call(request);
   *     for (Binding element : response.getBindingsList()) {
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
  public final UnaryCallable<FetchAvailableBindingsRequest, FetchAvailableBindingsResponse>
      fetchAvailableBindingsCallable() {
    return stub.fetchAvailableBindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : agentRegistryClient.listLocations(request).iterateAll()) {
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
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       agentRegistryClient.listLocationsPagedCallable().futureCall(request);
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
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name][google.cloud.location.ListLocationsRequest.name] field:
   * &#42;&#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = agentRegistryClient.listLocationsCallable().call(request);
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
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = agentRegistryClient.getLocation(request);
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
   * try (AgentRegistryClient agentRegistryClient = AgentRegistryClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = agentRegistryClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class ListAgentsPagedResponse
      extends AbstractPagedListResponse<
          ListAgentsRequest,
          ListAgentsResponse,
          Agent,
          ListAgentsPage,
          ListAgentsFixedSizeCollection> {

    public static ApiFuture<ListAgentsPagedResponse> createAsync(
        PageContext<ListAgentsRequest, ListAgentsResponse, Agent> context,
        ApiFuture<ListAgentsResponse> futureResponse) {
      ApiFuture<ListAgentsPage> futurePage =
          ListAgentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListAgentsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListAgentsPagedResponse(ListAgentsPage page) {
      super(page, ListAgentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAgentsPage
      extends AbstractPage<ListAgentsRequest, ListAgentsResponse, Agent, ListAgentsPage> {

    private ListAgentsPage(
        PageContext<ListAgentsRequest, ListAgentsResponse, Agent> context,
        ListAgentsResponse response) {
      super(context, response);
    }

    private static ListAgentsPage createEmptyPage() {
      return new ListAgentsPage(null, null);
    }

    @Override
    protected ListAgentsPage createPage(
        PageContext<ListAgentsRequest, ListAgentsResponse, Agent> context,
        ListAgentsResponse response) {
      return new ListAgentsPage(context, response);
    }

    @Override
    public ApiFuture<ListAgentsPage> createPageAsync(
        PageContext<ListAgentsRequest, ListAgentsResponse, Agent> context,
        ApiFuture<ListAgentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAgentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAgentsRequest,
          ListAgentsResponse,
          Agent,
          ListAgentsPage,
          ListAgentsFixedSizeCollection> {

    private ListAgentsFixedSizeCollection(List<ListAgentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAgentsFixedSizeCollection createEmptyCollection() {
      return new ListAgentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAgentsFixedSizeCollection createCollection(
        List<ListAgentsPage> pages, int collectionSize) {
      return new ListAgentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchAgentsPagedResponse
      extends AbstractPagedListResponse<
          SearchAgentsRequest,
          SearchAgentsResponse,
          Agent,
          SearchAgentsPage,
          SearchAgentsFixedSizeCollection> {

    public static ApiFuture<SearchAgentsPagedResponse> createAsync(
        PageContext<SearchAgentsRequest, SearchAgentsResponse, Agent> context,
        ApiFuture<SearchAgentsResponse> futureResponse) {
      ApiFuture<SearchAgentsPage> futurePage =
          SearchAgentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchAgentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchAgentsPagedResponse(SearchAgentsPage page) {
      super(page, SearchAgentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchAgentsPage
      extends AbstractPage<SearchAgentsRequest, SearchAgentsResponse, Agent, SearchAgentsPage> {

    private SearchAgentsPage(
        PageContext<SearchAgentsRequest, SearchAgentsResponse, Agent> context,
        SearchAgentsResponse response) {
      super(context, response);
    }

    private static SearchAgentsPage createEmptyPage() {
      return new SearchAgentsPage(null, null);
    }

    @Override
    protected SearchAgentsPage createPage(
        PageContext<SearchAgentsRequest, SearchAgentsResponse, Agent> context,
        SearchAgentsResponse response) {
      return new SearchAgentsPage(context, response);
    }

    @Override
    public ApiFuture<SearchAgentsPage> createPageAsync(
        PageContext<SearchAgentsRequest, SearchAgentsResponse, Agent> context,
        ApiFuture<SearchAgentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchAgentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchAgentsRequest,
          SearchAgentsResponse,
          Agent,
          SearchAgentsPage,
          SearchAgentsFixedSizeCollection> {

    private SearchAgentsFixedSizeCollection(List<SearchAgentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchAgentsFixedSizeCollection createEmptyCollection() {
      return new SearchAgentsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchAgentsFixedSizeCollection createCollection(
        List<SearchAgentsPage> pages, int collectionSize) {
      return new SearchAgentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEndpointsPagedResponse
      extends AbstractPagedListResponse<
          ListEndpointsRequest,
          ListEndpointsResponse,
          Endpoint,
          ListEndpointsPage,
          ListEndpointsFixedSizeCollection> {

    public static ApiFuture<ListEndpointsPagedResponse> createAsync(
        PageContext<ListEndpointsRequest, ListEndpointsResponse, Endpoint> context,
        ApiFuture<ListEndpointsResponse> futureResponse) {
      ApiFuture<ListEndpointsPage> futurePage =
          ListEndpointsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListEndpointsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListEndpointsPagedResponse(ListEndpointsPage page) {
      super(page, ListEndpointsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEndpointsPage
      extends AbstractPage<
          ListEndpointsRequest, ListEndpointsResponse, Endpoint, ListEndpointsPage> {

    private ListEndpointsPage(
        PageContext<ListEndpointsRequest, ListEndpointsResponse, Endpoint> context,
        ListEndpointsResponse response) {
      super(context, response);
    }

    private static ListEndpointsPage createEmptyPage() {
      return new ListEndpointsPage(null, null);
    }

    @Override
    protected ListEndpointsPage createPage(
        PageContext<ListEndpointsRequest, ListEndpointsResponse, Endpoint> context,
        ListEndpointsResponse response) {
      return new ListEndpointsPage(context, response);
    }

    @Override
    public ApiFuture<ListEndpointsPage> createPageAsync(
        PageContext<ListEndpointsRequest, ListEndpointsResponse, Endpoint> context,
        ApiFuture<ListEndpointsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEndpointsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEndpointsRequest,
          ListEndpointsResponse,
          Endpoint,
          ListEndpointsPage,
          ListEndpointsFixedSizeCollection> {

    private ListEndpointsFixedSizeCollection(List<ListEndpointsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEndpointsFixedSizeCollection createEmptyCollection() {
      return new ListEndpointsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEndpointsFixedSizeCollection createCollection(
        List<ListEndpointsPage> pages, int collectionSize) {
      return new ListEndpointsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListMcpServersPagedResponse
      extends AbstractPagedListResponse<
          ListMcpServersRequest,
          ListMcpServersResponse,
          McpServer,
          ListMcpServersPage,
          ListMcpServersFixedSizeCollection> {

    public static ApiFuture<ListMcpServersPagedResponse> createAsync(
        PageContext<ListMcpServersRequest, ListMcpServersResponse, McpServer> context,
        ApiFuture<ListMcpServersResponse> futureResponse) {
      ApiFuture<ListMcpServersPage> futurePage =
          ListMcpServersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMcpServersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMcpServersPagedResponse(ListMcpServersPage page) {
      super(page, ListMcpServersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMcpServersPage
      extends AbstractPage<
          ListMcpServersRequest, ListMcpServersResponse, McpServer, ListMcpServersPage> {

    private ListMcpServersPage(
        PageContext<ListMcpServersRequest, ListMcpServersResponse, McpServer> context,
        ListMcpServersResponse response) {
      super(context, response);
    }

    private static ListMcpServersPage createEmptyPage() {
      return new ListMcpServersPage(null, null);
    }

    @Override
    protected ListMcpServersPage createPage(
        PageContext<ListMcpServersRequest, ListMcpServersResponse, McpServer> context,
        ListMcpServersResponse response) {
      return new ListMcpServersPage(context, response);
    }

    @Override
    public ApiFuture<ListMcpServersPage> createPageAsync(
        PageContext<ListMcpServersRequest, ListMcpServersResponse, McpServer> context,
        ApiFuture<ListMcpServersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMcpServersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMcpServersRequest,
          ListMcpServersResponse,
          McpServer,
          ListMcpServersPage,
          ListMcpServersFixedSizeCollection> {

    private ListMcpServersFixedSizeCollection(List<ListMcpServersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMcpServersFixedSizeCollection createEmptyCollection() {
      return new ListMcpServersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMcpServersFixedSizeCollection createCollection(
        List<ListMcpServersPage> pages, int collectionSize) {
      return new ListMcpServersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchMcpServersPagedResponse
      extends AbstractPagedListResponse<
          SearchMcpServersRequest,
          SearchMcpServersResponse,
          McpServer,
          SearchMcpServersPage,
          SearchMcpServersFixedSizeCollection> {

    public static ApiFuture<SearchMcpServersPagedResponse> createAsync(
        PageContext<SearchMcpServersRequest, SearchMcpServersResponse, McpServer> context,
        ApiFuture<SearchMcpServersResponse> futureResponse) {
      ApiFuture<SearchMcpServersPage> futurePage =
          SearchMcpServersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchMcpServersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchMcpServersPagedResponse(SearchMcpServersPage page) {
      super(page, SearchMcpServersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchMcpServersPage
      extends AbstractPage<
          SearchMcpServersRequest, SearchMcpServersResponse, McpServer, SearchMcpServersPage> {

    private SearchMcpServersPage(
        PageContext<SearchMcpServersRequest, SearchMcpServersResponse, McpServer> context,
        SearchMcpServersResponse response) {
      super(context, response);
    }

    private static SearchMcpServersPage createEmptyPage() {
      return new SearchMcpServersPage(null, null);
    }

    @Override
    protected SearchMcpServersPage createPage(
        PageContext<SearchMcpServersRequest, SearchMcpServersResponse, McpServer> context,
        SearchMcpServersResponse response) {
      return new SearchMcpServersPage(context, response);
    }

    @Override
    public ApiFuture<SearchMcpServersPage> createPageAsync(
        PageContext<SearchMcpServersRequest, SearchMcpServersResponse, McpServer> context,
        ApiFuture<SearchMcpServersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchMcpServersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchMcpServersRequest,
          SearchMcpServersResponse,
          McpServer,
          SearchMcpServersPage,
          SearchMcpServersFixedSizeCollection> {

    private SearchMcpServersFixedSizeCollection(
        List<SearchMcpServersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchMcpServersFixedSizeCollection createEmptyCollection() {
      return new SearchMcpServersFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchMcpServersFixedSizeCollection createCollection(
        List<SearchMcpServersPage> pages, int collectionSize) {
      return new SearchMcpServersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListServicesPagedResponse
      extends AbstractPagedListResponse<
          ListServicesRequest,
          ListServicesResponse,
          Service,
          ListServicesPage,
          ListServicesFixedSizeCollection> {

    public static ApiFuture<ListServicesPagedResponse> createAsync(
        PageContext<ListServicesRequest, ListServicesResponse, Service> context,
        ApiFuture<ListServicesResponse> futureResponse) {
      ApiFuture<ListServicesPage> futurePage =
          ListServicesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListServicesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListServicesPagedResponse(ListServicesPage page) {
      super(page, ListServicesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListServicesPage
      extends AbstractPage<ListServicesRequest, ListServicesResponse, Service, ListServicesPage> {

    private ListServicesPage(
        PageContext<ListServicesRequest, ListServicesResponse, Service> context,
        ListServicesResponse response) {
      super(context, response);
    }

    private static ListServicesPage createEmptyPage() {
      return new ListServicesPage(null, null);
    }

    @Override
    protected ListServicesPage createPage(
        PageContext<ListServicesRequest, ListServicesResponse, Service> context,
        ListServicesResponse response) {
      return new ListServicesPage(context, response);
    }

    @Override
    public ApiFuture<ListServicesPage> createPageAsync(
        PageContext<ListServicesRequest, ListServicesResponse, Service> context,
        ApiFuture<ListServicesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListServicesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListServicesRequest,
          ListServicesResponse,
          Service,
          ListServicesPage,
          ListServicesFixedSizeCollection> {

    private ListServicesFixedSizeCollection(List<ListServicesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListServicesFixedSizeCollection createEmptyCollection() {
      return new ListServicesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListServicesFixedSizeCollection createCollection(
        List<ListServicesPage> pages, int collectionSize) {
      return new ListServicesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListBindingsPagedResponse
      extends AbstractPagedListResponse<
          ListBindingsRequest,
          ListBindingsResponse,
          Binding,
          ListBindingsPage,
          ListBindingsFixedSizeCollection> {

    public static ApiFuture<ListBindingsPagedResponse> createAsync(
        PageContext<ListBindingsRequest, ListBindingsResponse, Binding> context,
        ApiFuture<ListBindingsResponse> futureResponse) {
      ApiFuture<ListBindingsPage> futurePage =
          ListBindingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListBindingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListBindingsPagedResponse(ListBindingsPage page) {
      super(page, ListBindingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListBindingsPage
      extends AbstractPage<ListBindingsRequest, ListBindingsResponse, Binding, ListBindingsPage> {

    private ListBindingsPage(
        PageContext<ListBindingsRequest, ListBindingsResponse, Binding> context,
        ListBindingsResponse response) {
      super(context, response);
    }

    private static ListBindingsPage createEmptyPage() {
      return new ListBindingsPage(null, null);
    }

    @Override
    protected ListBindingsPage createPage(
        PageContext<ListBindingsRequest, ListBindingsResponse, Binding> context,
        ListBindingsResponse response) {
      return new ListBindingsPage(context, response);
    }

    @Override
    public ApiFuture<ListBindingsPage> createPageAsync(
        PageContext<ListBindingsRequest, ListBindingsResponse, Binding> context,
        ApiFuture<ListBindingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListBindingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBindingsRequest,
          ListBindingsResponse,
          Binding,
          ListBindingsPage,
          ListBindingsFixedSizeCollection> {

    private ListBindingsFixedSizeCollection(List<ListBindingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBindingsFixedSizeCollection createEmptyCollection() {
      return new ListBindingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBindingsFixedSizeCollection createCollection(
        List<ListBindingsPage> pages, int collectionSize) {
      return new ListBindingsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class FetchAvailableBindingsPagedResponse
      extends AbstractPagedListResponse<
          FetchAvailableBindingsRequest,
          FetchAvailableBindingsResponse,
          Binding,
          FetchAvailableBindingsPage,
          FetchAvailableBindingsFixedSizeCollection> {

    public static ApiFuture<FetchAvailableBindingsPagedResponse> createAsync(
        PageContext<FetchAvailableBindingsRequest, FetchAvailableBindingsResponse, Binding> context,
        ApiFuture<FetchAvailableBindingsResponse> futureResponse) {
      ApiFuture<FetchAvailableBindingsPage> futurePage =
          FetchAvailableBindingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new FetchAvailableBindingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private FetchAvailableBindingsPagedResponse(FetchAvailableBindingsPage page) {
      super(page, FetchAvailableBindingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class FetchAvailableBindingsPage
      extends AbstractPage<
          FetchAvailableBindingsRequest,
          FetchAvailableBindingsResponse,
          Binding,
          FetchAvailableBindingsPage> {

    private FetchAvailableBindingsPage(
        PageContext<FetchAvailableBindingsRequest, FetchAvailableBindingsResponse, Binding> context,
        FetchAvailableBindingsResponse response) {
      super(context, response);
    }

    private static FetchAvailableBindingsPage createEmptyPage() {
      return new FetchAvailableBindingsPage(null, null);
    }

    @Override
    protected FetchAvailableBindingsPage createPage(
        PageContext<FetchAvailableBindingsRequest, FetchAvailableBindingsResponse, Binding> context,
        FetchAvailableBindingsResponse response) {
      return new FetchAvailableBindingsPage(context, response);
    }

    @Override
    public ApiFuture<FetchAvailableBindingsPage> createPageAsync(
        PageContext<FetchAvailableBindingsRequest, FetchAvailableBindingsResponse, Binding> context,
        ApiFuture<FetchAvailableBindingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class FetchAvailableBindingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          FetchAvailableBindingsRequest,
          FetchAvailableBindingsResponse,
          Binding,
          FetchAvailableBindingsPage,
          FetchAvailableBindingsFixedSizeCollection> {

    private FetchAvailableBindingsFixedSizeCollection(
        List<FetchAvailableBindingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FetchAvailableBindingsFixedSizeCollection createEmptyCollection() {
      return new FetchAvailableBindingsFixedSizeCollection(null, 0);
    }

    @Override
    protected FetchAvailableBindingsFixedSizeCollection createCollection(
        List<FetchAvailableBindingsPage> pages, int collectionSize) {
      return new FetchAvailableBindingsFixedSizeCollection(pages, collectionSize);
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
