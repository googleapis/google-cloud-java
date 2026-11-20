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
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing Agent Registry resources.
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
 *   AgentName name = AgentName.ofProjectLocationAgentName("[PROJECT]", "[LOCATION]", "[AGENT]");
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
 *      <td><p> CreateSkill</td>
 *      <td><p> ========================================================================= # Skills Collection APIs
 * <p>  Creates a Skill resource container, optionally publishing the initial SkillRevision inline in a single, atomic CRUD roundtrip.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSkillAsync(CreateSkillRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createSkillAsync(LocationName parent, Skill skill, String skillId)
 *           <li><p> createSkillAsync(String parent, Skill skill, String skillId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSkillOperationCallable()
 *           <li><p> createSkillCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSkill</td>
 *      <td><p> Fetches the active configuration and metadata of a Skill.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSkill(GetSkillRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSkill(SkillName name)
 *           <li><p> getSkill(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSkillCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSkill</td>
 *      <td><p> Updates Skill metadata or overrides active pointers/state using REST standard PATCH.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSkillAsync(UpdateSkillRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateSkillAsync(Skill skill, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSkillOperationCallable()
 *           <li><p> updateSkillCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSkill</td>
 *      <td><p> Deletes a Skill container along with all its revisions.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSkillAsync(DeleteSkillRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteSkillAsync(SkillName name)
 *           <li><p> deleteSkillAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSkillOperationCallable()
 *           <li><p> deleteSkillCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSkills</td>
 *      <td><p> Lists logical Skills available in a project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSkills(ListSkillsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSkills(LocationName parent)
 *           <li><p> listSkills(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSkillsPagedCallable()
 *           <li><p> listSkillsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchSkills</td>
 *      <td><p> Custom deep-search method to filter by frontmatter or query SKILL.md text blobs.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchSkills(SearchSkillsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchSkillsPagedCallable()
 *           <li><p> searchSkillsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateSkillRevision</td>
 *      <td><p> Creates a new immutable revision and triggers validation pipelines.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createSkillRevisionAsync(CreateSkillRevisionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createSkillRevisionAsync(SkillName parent, SkillRevision skillRevision, String skillRevisionId)
 *           <li><p> createSkillRevisionAsync(String parent, SkillRevision skillRevision, String skillRevisionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createSkillRevisionOperationCallable()
 *           <li><p> createSkillRevisionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSkillRevision</td>
 *      <td><p> Gets details of a single immutable Revision.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSkillRevision(GetSkillRevisionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSkillRevision(SkillRevisionName name)
 *           <li><p> getSkillRevision(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSkillRevisionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSkillRevision</td>
 *      <td><p> Deletes a specific revision (restricted to admins to purge accidentally committed secrets).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSkillRevisionAsync(DeleteSkillRevisionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteSkillRevisionAsync(SkillRevisionName name)
 *           <li><p> deleteSkillRevisionAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSkillRevisionOperationCallable()
 *           <li><p> deleteSkillRevisionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListSkillRevisions</td>
 *      <td><p> Lists all revisions belonging to a parent Skill.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listSkillRevisions(ListSkillRevisionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listSkillRevisions(SkillName parent)
 *           <li><p> listSkillRevisions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listSkillRevisionsPagedCallable()
 *           <li><p> listSkillRevisionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetPublisher</td>
 *      <td><p> Fetches details of a specific Publisher.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getPublisher(GetPublisherRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getPublisher(PublisherName name)
 *           <li><p> getPublisher(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getPublisherCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPublishers</td>
 *      <td><p> Lists all Publishers in a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listPublishers(ListPublishersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listPublishers(LocationName parent)
 *           <li><p> listPublishers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPublishersPagedCallable()
 *           <li><p> listPublishersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAiApplication</td>
 *      <td><p> Gets details of a single AI Application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAiApplication(GetAiApplicationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAiApplication(AiApplicationName name)
 *           <li><p> getAiApplication(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAiApplicationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAiApplications</td>
 *      <td><p> Lists AI Applications in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAiApplications(ListAiApplicationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAiApplications(LocationName parent)
 *           <li><p> listAiApplications(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAiApplicationsPagedCallable()
 *           <li><p> listAiApplicationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAiApplicationAgent</td>
 *      <td><p> Gets details of a single Agent under an AI Application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAiApplicationAgent(GetAiApplicationAgentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAiApplicationAgent(AgentName name)
 *           <li><p> getAiApplicationAgent(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAiApplicationAgentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAiApplicationAgents</td>
 *      <td><p> Lists Agents under an AI Application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAiApplicationAgents(ListAiApplicationAgentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAiApplicationAgents(AiApplicationName parent)
 *           <li><p> listAiApplicationAgents(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAiApplicationAgentsPagedCallable()
 *           <li><p> listAiApplicationAgentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAiApplicationMcpServer</td>
 *      <td><p> Gets details of a single McpServer under an AI Application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAiApplicationMcpServer(GetAiApplicationMcpServerRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAiApplicationMcpServer(McpServerName name)
 *           <li><p> getAiApplicationMcpServer(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAiApplicationMcpServerCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAiApplicationMcpServers</td>
 *      <td><p> Lists McpServers under an AI Application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAiApplicationMcpServers(ListAiApplicationMcpServersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAiApplicationMcpServers(AiApplicationName parent)
 *           <li><p> listAiApplicationMcpServers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAiApplicationMcpServersPagedCallable()
 *           <li><p> listAiApplicationMcpServersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetFinding</td>
 *      <td><p> Gets details of a single Finding.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getFinding(GetFindingRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getFinding(FindingName name)
 *           <li><p> getFinding(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getFindingCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListFindings</td>
 *      <td><p> Lists Findings in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listFindings(ListFindingsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listFindings(LocationName parent)
 *           <li><p> listFindings(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listFindingsPagedCallable()
 *           <li><p> listFindingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAiApplicationEndpoint</td>
 *      <td><p> Gets details of a single Endpoint under an AI Application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAiApplicationEndpoint(GetAiApplicationEndpointRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAiApplicationEndpoint(EndpointName name)
 *           <li><p> getAiApplicationEndpoint(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAiApplicationEndpointCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAiApplicationEndpoints</td>
 *      <td><p> Lists Endpoints under an AI Application.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAiApplicationEndpoints(ListAiApplicationEndpointsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAiApplicationEndpoints(AiApplicationName parent)
 *           <li><p> listAiApplicationEndpoints(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAiApplicationEndpointsPagedCallable()
 *           <li><p> listAiApplicationEndpointsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetSkillEncryptionSpec</td>
 *      <td><p> ========================================================================= # Skill Encryption Spec Service Methods
 * <p>  Gets the customer-managed encryption key (CMEK) configuration for Skills in a specific project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getSkillEncryptionSpec(GetSkillEncryptionSpecRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getSkillEncryptionSpec(SkillEncryptionSpecName name)
 *           <li><p> getSkillEncryptionSpec(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getSkillEncryptionSpecCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateSkillEncryptionSpec</td>
 *      <td><p> Updates the customer-managed encryption key (CMEK) configuration for Skills in a specific project and location.
 * <p>  This method is only allowed when no Skills exist in the target project and location. If any Skill already exists in the location, the request fails with `FAILED_PRECONDITION`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateSkillEncryptionSpecAsync(UpdateSkillEncryptionSpecRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateSkillEncryptionSpecAsync(SkillEncryptionSpec skillEncryptionSpec, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateSkillEncryptionSpecOperationCallable()
 *           <li><p> updateSkillEncryptionSpecCallable()
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
  private final @Nullable AgentRegistrySettings settings;
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

  public final @Nullable AgentRegistrySettings getSettings() {
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
  public final ListAgentsPagedResponse listAgents(@Nullable LocationName parent) {
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
  public final SearchAgentsPagedResponse searchAgents(@Nullable LocationName parent) {
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
   *   AgentName name = AgentName.ofProjectLocationAgentName("[PROJECT]", "[LOCATION]", "[AGENT]");
   *   Agent response = agentRegistryClient.getAgent(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Agent getAgent(@Nullable AgentName name) {
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
   *   String name =
   *       AgentName.ofProjectLocationAgentName("[PROJECT]", "[LOCATION]", "[AGENT]").toString();
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
   *           .setName(
   *               AgentName.ofProjectLocationAgentName("[PROJECT]", "[LOCATION]", "[AGENT]")
   *                   .toString())
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
   *           .setName(
   *               AgentName.ofProjectLocationAgentName("[PROJECT]", "[LOCATION]", "[AGENT]")
   *                   .toString())
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
  public final ListEndpointsPagedResponse listEndpoints(@Nullable LocationName parent) {
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
   *   EndpointName name =
   *       EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]");
   *   Endpoint response = agentRegistryClient.getEndpoint(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the endpoint to retrieve. Format:
   *     `projects/{project}/locations/{location}/endpoints/{endpoint}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Endpoint getEndpoint(@Nullable EndpointName name) {
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
   *   String name =
   *       EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *           .toString();
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
   *           .setName(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
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
   *           .setName(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
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
  public final ListMcpServersPagedResponse listMcpServers(@Nullable LocationName parent) {
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
  public final SearchMcpServersPagedResponse searchMcpServers(@Nullable LocationName parent) {
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
   *   McpServerName name =
   *       McpServerName.ofProjectLocationMcpServerName("[PROJECT]", "[LOCATION]", "[MCP_SERVER]");
   *   McpServer response = agentRegistryClient.getMcpServer(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final McpServer getMcpServer(@Nullable McpServerName name) {
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
   *   String name =
   *       McpServerName.ofProjectLocationMcpServerName("[PROJECT]", "[LOCATION]", "[MCP_SERVER]")
   *           .toString();
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
   *           .setName(
   *               McpServerName.ofProjectLocationMcpServerName(
   *                       "[PROJECT]", "[LOCATION]", "[MCP_SERVER]")
   *                   .toString())
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
   *           .setName(
   *               McpServerName.ofProjectLocationMcpServerName(
   *                       "[PROJECT]", "[LOCATION]", "[MCP_SERVER]")
   *                   .toString())
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
  public final ListServicesPagedResponse listServices(@Nullable LocationName parent) {
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
  public final Service getService(@Nullable ServiceName name) {
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
      @Nullable LocationName parent, Service service, String serviceId) {
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
  public final OperationFuture<Empty, OperationMetadata> deleteServiceAsync(
      @Nullable ServiceName name) {
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
  public final ListBindingsPagedResponse listBindings(@Nullable LocationName parent) {
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
  public final Binding getBinding(@Nullable BindingName name) {
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
      @Nullable LocationName parent, Binding binding, String bindingId) {
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
  public final OperationFuture<Empty, OperationMetadata> deleteBindingAsync(
      @Nullable BindingName name) {
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
  public final FetchAvailableBindingsPagedResponse fetchAvailableBindings(
      @Nullable LocationName parent) {
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
   * ========================================================================= # Skills Collection
   * APIs
   *
   * <p>Creates a Skill resource container, optionally publishing the initial SkillRevision inline
   * in a single, atomic CRUD roundtrip.
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
   *   Skill skill = Skill.newBuilder().build();
   *   String skillId = "skillId2147320652";
   *   Skill response = agentRegistryClient.createSkillAsync(parent, skill, skillId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location location to bootstrap.
   * @param skill Required. Skill container body config.
   * @param skillId Required. Custom, user-defined unique container identifier. Must be unique
   *     within the parent project and location. This value should be 4-64 characters, and valid
   *     characters are `/[a-z][0-9]-/`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Skill, OperationMetadata> createSkillAsync(
      @Nullable LocationName parent, Skill skill, String skillId) {
    CreateSkillRequest request =
        CreateSkillRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSkill(skill)
            .setSkillId(skillId)
            .build();
    return createSkillAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ========================================================================= # Skills Collection
   * APIs
   *
   * <p>Creates a Skill resource container, optionally publishing the initial SkillRevision inline
   * in a single, atomic CRUD roundtrip.
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
   *   Skill skill = Skill.newBuilder().build();
   *   String skillId = "skillId2147320652";
   *   Skill response = agentRegistryClient.createSkillAsync(parent, skill, skillId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The project and location location to bootstrap.
   * @param skill Required. Skill container body config.
   * @param skillId Required. Custom, user-defined unique container identifier. Must be unique
   *     within the parent project and location. This value should be 4-64 characters, and valid
   *     characters are `/[a-z][0-9]-/`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Skill, OperationMetadata> createSkillAsync(
      String parent, Skill skill, String skillId) {
    CreateSkillRequest request =
        CreateSkillRequest.newBuilder()
            .setParent(parent)
            .setSkill(skill)
            .setSkillId(skillId)
            .build();
    return createSkillAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ========================================================================= # Skills Collection
   * APIs
   *
   * <p>Creates a Skill resource container, optionally publishing the initial SkillRevision inline
   * in a single, atomic CRUD roundtrip.
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
   *   CreateSkillRequest request =
   *       CreateSkillRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSkillId("skillId2147320652")
   *           .setSkill(Skill.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Skill response = agentRegistryClient.createSkillAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Skill, OperationMetadata> createSkillAsync(
      CreateSkillRequest request) {
    return createSkillOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ========================================================================= # Skills Collection
   * APIs
   *
   * <p>Creates a Skill resource container, optionally publishing the initial SkillRevision inline
   * in a single, atomic CRUD roundtrip.
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
   *   CreateSkillRequest request =
   *       CreateSkillRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSkillId("skillId2147320652")
   *           .setSkill(Skill.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Skill, OperationMetadata> future =
   *       agentRegistryClient.createSkillOperationCallable().futureCall(request);
   *   // Do something.
   *   Skill response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateSkillRequest, Skill, OperationMetadata>
      createSkillOperationCallable() {
    return stub.createSkillOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ========================================================================= # Skills Collection
   * APIs
   *
   * <p>Creates a Skill resource container, optionally publishing the initial SkillRevision inline
   * in a single, atomic CRUD roundtrip.
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
   *   CreateSkillRequest request =
   *       CreateSkillRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSkillId("skillId2147320652")
   *           .setSkill(Skill.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = agentRegistryClient.createSkillCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSkillRequest, Operation> createSkillCallable() {
    return stub.createSkillCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches the active configuration and metadata of a Skill.
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
   *   SkillName name = SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]");
   *   Skill response = agentRegistryClient.getSkill(name);
   * }
   * }</pre>
   *
   * @param name Required. Target resource container name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Skill getSkill(@Nullable SkillName name) {
    GetSkillRequest request =
        GetSkillRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSkill(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches the active configuration and metadata of a Skill.
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
   *   String name = SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]").toString();
   *   Skill response = agentRegistryClient.getSkill(name);
   * }
   * }</pre>
   *
   * @param name Required. Target resource container name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Skill getSkill(String name) {
    GetSkillRequest request = GetSkillRequest.newBuilder().setName(name).build();
    return getSkill(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches the active configuration and metadata of a Skill.
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
   *   GetSkillRequest request =
   *       GetSkillRequest.newBuilder()
   *           .setName(SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]").toString())
   *           .build();
   *   Skill response = agentRegistryClient.getSkill(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Skill getSkill(GetSkillRequest request) {
    return getSkillCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches the active configuration and metadata of a Skill.
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
   *   GetSkillRequest request =
   *       GetSkillRequest.newBuilder()
   *           .setName(SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]").toString())
   *           .build();
   *   ApiFuture<Skill> future = agentRegistryClient.getSkillCallable().futureCall(request);
   *   // Do something.
   *   Skill response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSkillRequest, Skill> getSkillCallable() {
    return stub.getSkillCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates Skill metadata or overrides active pointers/state using REST standard PATCH.
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
   *   Skill skill = Skill.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Skill response = agentRegistryClient.updateSkillAsync(skill, updateMask).get();
   * }
   * }</pre>
   *
   * @param skill Required. Mutable Skill container config fields to write.
   * @param updateMask Optional. Standard update target mask mapping relative fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Skill, OperationMetadata> updateSkillAsync(
      Skill skill, FieldMask updateMask) {
    UpdateSkillRequest request =
        UpdateSkillRequest.newBuilder().setSkill(skill).setUpdateMask(updateMask).build();
    return updateSkillAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates Skill metadata or overrides active pointers/state using REST standard PATCH.
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
   *   UpdateSkillRequest request =
   *       UpdateSkillRequest.newBuilder()
   *           .setSkill(Skill.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Skill response = agentRegistryClient.updateSkillAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Skill, OperationMetadata> updateSkillAsync(
      UpdateSkillRequest request) {
    return updateSkillOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates Skill metadata or overrides active pointers/state using REST standard PATCH.
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
   *   UpdateSkillRequest request =
   *       UpdateSkillRequest.newBuilder()
   *           .setSkill(Skill.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Skill, OperationMetadata> future =
   *       agentRegistryClient.updateSkillOperationCallable().futureCall(request);
   *   // Do something.
   *   Skill response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateSkillRequest, Skill, OperationMetadata>
      updateSkillOperationCallable() {
    return stub.updateSkillOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates Skill metadata or overrides active pointers/state using REST standard PATCH.
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
   *   UpdateSkillRequest request =
   *       UpdateSkillRequest.newBuilder()
   *           .setSkill(Skill.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = agentRegistryClient.updateSkillCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSkillRequest, Operation> updateSkillCallable() {
    return stub.updateSkillCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Skill container along with all its revisions.
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
   *   SkillName name = SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]");
   *   agentRegistryClient.deleteSkillAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Target Skill container name to remove.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSkillAsync(
      @Nullable SkillName name) {
    DeleteSkillRequest request =
        DeleteSkillRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteSkillAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Skill container along with all its revisions.
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
   *   String name = SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]").toString();
   *   agentRegistryClient.deleteSkillAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Target Skill container name to remove.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSkillAsync(String name) {
    DeleteSkillRequest request = DeleteSkillRequest.newBuilder().setName(name).build();
    return deleteSkillAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Skill container along with all its revisions.
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
   *   DeleteSkillRequest request =
   *       DeleteSkillRequest.newBuilder()
   *           .setName(SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   agentRegistryClient.deleteSkillAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSkillAsync(
      DeleteSkillRequest request) {
    return deleteSkillOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Skill container along with all its revisions.
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
   *   DeleteSkillRequest request =
   *       DeleteSkillRequest.newBuilder()
   *           .setName(SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       agentRegistryClient.deleteSkillOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSkillRequest, Empty, OperationMetadata>
      deleteSkillOperationCallable() {
    return stub.deleteSkillOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Skill container along with all its revisions.
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
   *   DeleteSkillRequest request =
   *       DeleteSkillRequest.newBuilder()
   *           .setName(SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future = agentRegistryClient.deleteSkillCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSkillRequest, Operation> deleteSkillCallable() {
    return stub.deleteSkillCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists logical Skills available in a project.
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
   *   for (Skill element : agentRegistryClient.listSkills(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListSkillsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSkillsPagedResponse listSkills(@Nullable LocationName parent) {
    ListSkillsRequest request =
        ListSkillsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listSkills(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists logical Skills available in a project.
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
   *   for (Skill element : agentRegistryClient.listSkills(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListSkillsRequest
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSkillsPagedResponse listSkills(String parent) {
    ListSkillsRequest request = ListSkillsRequest.newBuilder().setParent(parent).build();
    return listSkills(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists logical Skills available in a project.
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
   *   ListSkillsRequest request =
   *       ListSkillsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Skill element : agentRegistryClient.listSkills(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSkillsPagedResponse listSkills(ListSkillsRequest request) {
    return listSkillsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists logical Skills available in a project.
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
   *   ListSkillsRequest request =
   *       ListSkillsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Skill> future = agentRegistryClient.listSkillsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Skill element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSkillsRequest, ListSkillsPagedResponse> listSkillsPagedCallable() {
    return stub.listSkillsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists logical Skills available in a project.
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
   *   ListSkillsRequest request =
   *       ListSkillsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListSkillsResponse response = agentRegistryClient.listSkillsCallable().call(request);
   *     for (Skill element : response.getSkillsList()) {
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
  public final UnaryCallable<ListSkillsRequest, ListSkillsResponse> listSkillsCallable() {
    return stub.listSkillsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Custom deep-search method to filter by frontmatter or query SKILL.md text blobs.
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
   *   SearchSkillsRequest request =
   *       SearchSkillsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSearchType(SearchType.forNumber(0))
   *           .setSearchString("searchString120312793")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Skill element : agentRegistryClient.searchSkills(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchSkillsPagedResponse searchSkills(SearchSkillsRequest request) {
    return searchSkillsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Custom deep-search method to filter by frontmatter or query SKILL.md text blobs.
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
   *   SearchSkillsRequest request =
   *       SearchSkillsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSearchType(SearchType.forNumber(0))
   *           .setSearchString("searchString120312793")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Skill> future = agentRegistryClient.searchSkillsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Skill element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchSkillsRequest, SearchSkillsPagedResponse>
      searchSkillsPagedCallable() {
    return stub.searchSkillsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Custom deep-search method to filter by frontmatter or query SKILL.md text blobs.
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
   *   SearchSkillsRequest request =
   *       SearchSkillsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSearchType(SearchType.forNumber(0))
   *           .setSearchString("searchString120312793")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     SearchSkillsResponse response = agentRegistryClient.searchSkillsCallable().call(request);
   *     for (Skill element : response.getSkillsList()) {
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
  public final UnaryCallable<SearchSkillsRequest, SearchSkillsResponse> searchSkillsCallable() {
    return stub.searchSkillsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new immutable revision and triggers validation pipelines.
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
   *   SkillName parent = SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]");
   *   SkillRevision skillRevision = SkillRevision.newBuilder().build();
   *   String skillRevisionId = "skillRevisionId-983110777";
   *   SkillRevision response =
   *       agentRegistryClient
   *           .createSkillRevisionAsync(parent, skillRevision, skillRevisionId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Parent logical container name.
   * @param skillRevision Required. Immutable SkillRevision snapshot definition schema.
   * @param skillRevisionId Optional. Custom, user-defined unique revision identifier. Format: 4-63
   *     characters, matching regex `^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SkillRevision, OperationMetadata> createSkillRevisionAsync(
      @Nullable SkillName parent, SkillRevision skillRevision, String skillRevisionId) {
    CreateSkillRevisionRequest request =
        CreateSkillRevisionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSkillRevision(skillRevision)
            .setSkillRevisionId(skillRevisionId)
            .build();
    return createSkillRevisionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new immutable revision and triggers validation pipelines.
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
   *   String parent = SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]").toString();
   *   SkillRevision skillRevision = SkillRevision.newBuilder().build();
   *   String skillRevisionId = "skillRevisionId-983110777";
   *   SkillRevision response =
   *       agentRegistryClient
   *           .createSkillRevisionAsync(parent, skillRevision, skillRevisionId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. Parent logical container name.
   * @param skillRevision Required. Immutable SkillRevision snapshot definition schema.
   * @param skillRevisionId Optional. Custom, user-defined unique revision identifier. Format: 4-63
   *     characters, matching regex `^[a-z]([a-z0-9-]{0,61}[a-z0-9])?$`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SkillRevision, OperationMetadata> createSkillRevisionAsync(
      String parent, SkillRevision skillRevision, String skillRevisionId) {
    CreateSkillRevisionRequest request =
        CreateSkillRevisionRequest.newBuilder()
            .setParent(parent)
            .setSkillRevision(skillRevision)
            .setSkillRevisionId(skillRevisionId)
            .build();
    return createSkillRevisionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new immutable revision and triggers validation pipelines.
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
   *   CreateSkillRevisionRequest request =
   *       CreateSkillRevisionRequest.newBuilder()
   *           .setParent(SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]").toString())
   *           .setSkillRevision(SkillRevision.newBuilder().build())
   *           .setSkillRevisionId("skillRevisionId-983110777")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   SkillRevision response = agentRegistryClient.createSkillRevisionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SkillRevision, OperationMetadata> createSkillRevisionAsync(
      CreateSkillRevisionRequest request) {
    return createSkillRevisionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new immutable revision and triggers validation pipelines.
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
   *   CreateSkillRevisionRequest request =
   *       CreateSkillRevisionRequest.newBuilder()
   *           .setParent(SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]").toString())
   *           .setSkillRevision(SkillRevision.newBuilder().build())
   *           .setSkillRevisionId("skillRevisionId-983110777")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<SkillRevision, OperationMetadata> future =
   *       agentRegistryClient.createSkillRevisionOperationCallable().futureCall(request);
   *   // Do something.
   *   SkillRevision response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateSkillRevisionRequest, SkillRevision, OperationMetadata>
      createSkillRevisionOperationCallable() {
    return stub.createSkillRevisionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new immutable revision and triggers validation pipelines.
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
   *   CreateSkillRevisionRequest request =
   *       CreateSkillRevisionRequest.newBuilder()
   *           .setParent(SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]").toString())
   *           .setSkillRevision(SkillRevision.newBuilder().build())
   *           .setSkillRevisionId("skillRevisionId-983110777")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       agentRegistryClient.createSkillRevisionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateSkillRevisionRequest, Operation> createSkillRevisionCallable() {
    return stub.createSkillRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single immutable Revision.
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
   *   SkillRevisionName name =
   *       SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]");
   *   SkillRevision response = agentRegistryClient.getSkillRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. Target revision name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SkillRevision getSkillRevision(@Nullable SkillRevisionName name) {
    GetSkillRevisionRequest request =
        GetSkillRevisionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSkillRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single immutable Revision.
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
   *   String name =
   *       SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]").toString();
   *   SkillRevision response = agentRegistryClient.getSkillRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. Target revision name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SkillRevision getSkillRevision(String name) {
    GetSkillRevisionRequest request = GetSkillRevisionRequest.newBuilder().setName(name).build();
    return getSkillRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single immutable Revision.
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
   *   GetSkillRevisionRequest request =
   *       GetSkillRevisionRequest.newBuilder()
   *           .setName(
   *               SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]")
   *                   .toString())
   *           .build();
   *   SkillRevision response = agentRegistryClient.getSkillRevision(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SkillRevision getSkillRevision(GetSkillRevisionRequest request) {
    return getSkillRevisionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single immutable Revision.
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
   *   GetSkillRevisionRequest request =
   *       GetSkillRevisionRequest.newBuilder()
   *           .setName(
   *               SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<SkillRevision> future =
   *       agentRegistryClient.getSkillRevisionCallable().futureCall(request);
   *   // Do something.
   *   SkillRevision response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSkillRevisionRequest, SkillRevision> getSkillRevisionCallable() {
    return stub.getSkillRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific revision (restricted to admins to purge accidentally committed secrets).
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
   *   SkillRevisionName name =
   *       SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]");
   *   agentRegistryClient.deleteSkillRevisionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Target revision name to remove.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSkillRevisionAsync(
      @Nullable SkillRevisionName name) {
    DeleteSkillRevisionRequest request =
        DeleteSkillRevisionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteSkillRevisionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific revision (restricted to admins to purge accidentally committed secrets).
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
   *   String name =
   *       SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]").toString();
   *   agentRegistryClient.deleteSkillRevisionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Target revision name to remove.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSkillRevisionAsync(String name) {
    DeleteSkillRevisionRequest request =
        DeleteSkillRevisionRequest.newBuilder().setName(name).build();
    return deleteSkillRevisionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific revision (restricted to admins to purge accidentally committed secrets).
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
   *   DeleteSkillRevisionRequest request =
   *       DeleteSkillRevisionRequest.newBuilder()
   *           .setName(
   *               SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   agentRegistryClient.deleteSkillRevisionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteSkillRevisionAsync(
      DeleteSkillRevisionRequest request) {
    return deleteSkillRevisionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific revision (restricted to admins to purge accidentally committed secrets).
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
   *   DeleteSkillRevisionRequest request =
   *       DeleteSkillRevisionRequest.newBuilder()
   *           .setName(
   *               SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       agentRegistryClient.deleteSkillRevisionOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSkillRevisionRequest, Empty, OperationMetadata>
      deleteSkillRevisionOperationCallable() {
    return stub.deleteSkillRevisionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific revision (restricted to admins to purge accidentally committed secrets).
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
   *   DeleteSkillRevisionRequest request =
   *       DeleteSkillRevisionRequest.newBuilder()
   *           .setName(
   *               SkillRevisionName.of("[PROJECT]", "[LOCATION]", "[SKILL]", "[REVISION]")
   *                   .toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       agentRegistryClient.deleteSkillRevisionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSkillRevisionRequest, Operation> deleteSkillRevisionCallable() {
    return stub.deleteSkillRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all revisions belonging to a parent Skill.
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
   *   SkillName parent = SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]");
   *   for (SkillRevision element : agentRegistryClient.listSkillRevisions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent logical container name to query.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSkillRevisionsPagedResponse listSkillRevisions(@Nullable SkillName parent) {
    ListSkillRevisionsRequest request =
        ListSkillRevisionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSkillRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all revisions belonging to a parent Skill.
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
   *   String parent = SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]").toString();
   *   for (SkillRevision element : agentRegistryClient.listSkillRevisions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent logical container name to query.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSkillRevisionsPagedResponse listSkillRevisions(String parent) {
    ListSkillRevisionsRequest request =
        ListSkillRevisionsRequest.newBuilder().setParent(parent).build();
    return listSkillRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all revisions belonging to a parent Skill.
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
   *   ListSkillRevisionsRequest request =
   *       ListSkillRevisionsRequest.newBuilder()
   *           .setParent(SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (SkillRevision element : agentRegistryClient.listSkillRevisions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSkillRevisionsPagedResponse listSkillRevisions(
      ListSkillRevisionsRequest request) {
    return listSkillRevisionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all revisions belonging to a parent Skill.
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
   *   ListSkillRevisionsRequest request =
   *       ListSkillRevisionsRequest.newBuilder()
   *           .setParent(SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<SkillRevision> future =
   *       agentRegistryClient.listSkillRevisionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SkillRevision element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSkillRevisionsRequest, ListSkillRevisionsPagedResponse>
      listSkillRevisionsPagedCallable() {
    return stub.listSkillRevisionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all revisions belonging to a parent Skill.
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
   *   ListSkillRevisionsRequest request =
   *       ListSkillRevisionsRequest.newBuilder()
   *           .setParent(SkillName.of("[PROJECT]", "[LOCATION]", "[SKILL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListSkillRevisionsResponse response =
   *         agentRegistryClient.listSkillRevisionsCallable().call(request);
   *     for (SkillRevision element : response.getSkillRevisionsList()) {
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
  public final UnaryCallable<ListSkillRevisionsRequest, ListSkillRevisionsResponse>
      listSkillRevisionsCallable() {
    return stub.listSkillRevisionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches details of a specific Publisher.
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
   *   PublisherName name = PublisherName.of("[PROJECT]", "[LOCATION]", "[PUBLISHER]");
   *   Publisher response = agentRegistryClient.getPublisher(name);
   * }
   * }</pre>
   *
   * @param name Required. Target publisher resource name. Format:
   *     `projects/{project}/locations/{location}/publishers/{publisher}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Publisher getPublisher(@Nullable PublisherName name) {
    GetPublisherRequest request =
        GetPublisherRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getPublisher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches details of a specific Publisher.
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
   *   String name = PublisherName.of("[PROJECT]", "[LOCATION]", "[PUBLISHER]").toString();
   *   Publisher response = agentRegistryClient.getPublisher(name);
   * }
   * }</pre>
   *
   * @param name Required. Target publisher resource name. Format:
   *     `projects/{project}/locations/{location}/publishers/{publisher}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Publisher getPublisher(String name) {
    GetPublisherRequest request = GetPublisherRequest.newBuilder().setName(name).build();
    return getPublisher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches details of a specific Publisher.
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
   *   GetPublisherRequest request =
   *       GetPublisherRequest.newBuilder()
   *           .setName(PublisherName.of("[PROJECT]", "[LOCATION]", "[PUBLISHER]").toString())
   *           .build();
   *   Publisher response = agentRegistryClient.getPublisher(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Publisher getPublisher(GetPublisherRequest request) {
    return getPublisherCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetches details of a specific Publisher.
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
   *   GetPublisherRequest request =
   *       GetPublisherRequest.newBuilder()
   *           .setName(PublisherName.of("[PROJECT]", "[LOCATION]", "[PUBLISHER]").toString())
   *           .build();
   *   ApiFuture<Publisher> future = agentRegistryClient.getPublisherCallable().futureCall(request);
   *   // Do something.
   *   Publisher response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPublisherRequest, Publisher> getPublisherCallable() {
    return stub.getPublisherCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Publishers in a location.
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
   *   for (Publisher element : agentRegistryClient.listPublishers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent location to query. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPublishersPagedResponse listPublishers(@Nullable LocationName parent) {
    ListPublishersRequest request =
        ListPublishersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listPublishers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Publishers in a location.
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
   *   for (Publisher element : agentRegistryClient.listPublishers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent location to query. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPublishersPagedResponse listPublishers(String parent) {
    ListPublishersRequest request = ListPublishersRequest.newBuilder().setParent(parent).build();
    return listPublishers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Publishers in a location.
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
   *   ListPublishersRequest request =
   *       ListPublishersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Publisher element : agentRegistryClient.listPublishers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPublishersPagedResponse listPublishers(ListPublishersRequest request) {
    return listPublishersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Publishers in a location.
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
   *   ListPublishersRequest request =
   *       ListPublishersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Publisher> future =
   *       agentRegistryClient.listPublishersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Publisher element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPublishersRequest, ListPublishersPagedResponse>
      listPublishersPagedCallable() {
    return stub.listPublishersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all Publishers in a location.
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
   *   ListPublishersRequest request =
   *       ListPublishersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListPublishersResponse response =
   *         agentRegistryClient.listPublishersCallable().call(request);
   *     for (Publisher element : response.getPublishersList()) {
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
  public final UnaryCallable<ListPublishersRequest, ListPublishersResponse>
      listPublishersCallable() {
    return stub.listPublishersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AI Application.
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
   *   AiApplicationName name = AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]");
   *   AiApplication response = agentRegistryClient.getAiApplication(name);
   * }
   * }</pre>
   *
   * @param name Required. Target AI Application resource name. Format:
   *     `projects/{project}/locations/{location}/aiApplications/{ai_application}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AiApplication getAiApplication(@Nullable AiApplicationName name) {
    GetAiApplicationRequest request =
        GetAiApplicationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAiApplication(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AI Application.
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
   *   String name = AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]").toString();
   *   AiApplication response = agentRegistryClient.getAiApplication(name);
   * }
   * }</pre>
   *
   * @param name Required. Target AI Application resource name. Format:
   *     `projects/{project}/locations/{location}/aiApplications/{ai_application}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AiApplication getAiApplication(String name) {
    GetAiApplicationRequest request = GetAiApplicationRequest.newBuilder().setName(name).build();
    return getAiApplication(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AI Application.
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
   *   GetAiApplicationRequest request =
   *       GetAiApplicationRequest.newBuilder()
   *           .setName(
   *               AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]").toString())
   *           .build();
   *   AiApplication response = agentRegistryClient.getAiApplication(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AiApplication getAiApplication(GetAiApplicationRequest request) {
    return getAiApplicationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single AI Application.
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
   *   GetAiApplicationRequest request =
   *       GetAiApplicationRequest.newBuilder()
   *           .setName(
   *               AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]").toString())
   *           .build();
   *   ApiFuture<AiApplication> future =
   *       agentRegistryClient.getAiApplicationCallable().futureCall(request);
   *   // Do something.
   *   AiApplication response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAiApplicationRequest, AiApplication> getAiApplicationCallable() {
    return stub.getAiApplicationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AI Applications in a given project and location.
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
   *   for (AiApplication element : agentRegistryClient.listAiApplications(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent project and location to query. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAiApplicationsPagedResponse listAiApplications(@Nullable LocationName parent) {
    ListAiApplicationsRequest request =
        ListAiApplicationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAiApplications(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AI Applications in a given project and location.
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
   *   for (AiApplication element : agentRegistryClient.listAiApplications(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent project and location to query. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAiApplicationsPagedResponse listAiApplications(String parent) {
    ListAiApplicationsRequest request =
        ListAiApplicationsRequest.newBuilder().setParent(parent).build();
    return listAiApplications(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AI Applications in a given project and location.
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
   *   ListAiApplicationsRequest request =
   *       ListAiApplicationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (AiApplication element : agentRegistryClient.listAiApplications(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAiApplicationsPagedResponse listAiApplications(
      ListAiApplicationsRequest request) {
    return listAiApplicationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AI Applications in a given project and location.
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
   *   ListAiApplicationsRequest request =
   *       ListAiApplicationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<AiApplication> future =
   *       agentRegistryClient.listAiApplicationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AiApplication element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAiApplicationsRequest, ListAiApplicationsPagedResponse>
      listAiApplicationsPagedCallable() {
    return stub.listAiApplicationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AI Applications in a given project and location.
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
   *   ListAiApplicationsRequest request =
   *       ListAiApplicationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListAiApplicationsResponse response =
   *         agentRegistryClient.listAiApplicationsCallable().call(request);
   *     for (AiApplication element : response.getAiApplicationsList()) {
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
  public final UnaryCallable<ListAiApplicationsRequest, ListAiApplicationsResponse>
      listAiApplicationsCallable() {
    return stub.listAiApplicationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Agent under an AI Application.
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
   *   AgentName name =
   *       AgentName.ofProjectLocationAiApplicationAgentName(
   *           "[PROJECT]", "[LOCATION]", "[AI_APPLICATION]", "[AGENT]");
   *   Agent response = agentRegistryClient.getAiApplicationAgent(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource. Format:
   *     `projects/{project}/locations/{location}/aiApplications/{ai_application}/agents/{agent}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Agent getAiApplicationAgent(@Nullable AgentName name) {
    GetAiApplicationAgentRequest request =
        GetAiApplicationAgentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAiApplicationAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Agent under an AI Application.
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
   *   String name =
   *       AgentName.ofProjectLocationAgentName("[PROJECT]", "[LOCATION]", "[AGENT]").toString();
   *   Agent response = agentRegistryClient.getAiApplicationAgent(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource. Format:
   *     `projects/{project}/locations/{location}/aiApplications/{ai_application}/agents/{agent}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Agent getAiApplicationAgent(String name) {
    GetAiApplicationAgentRequest request =
        GetAiApplicationAgentRequest.newBuilder().setName(name).build();
    return getAiApplicationAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Agent under an AI Application.
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
   *   GetAiApplicationAgentRequest request =
   *       GetAiApplicationAgentRequest.newBuilder()
   *           .setName(
   *               AgentName.ofProjectLocationAiApplicationAgentName(
   *                       "[PROJECT]", "[LOCATION]", "[AI_APPLICATION]", "[AGENT]")
   *                   .toString())
   *           .build();
   *   Agent response = agentRegistryClient.getAiApplicationAgent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Agent getAiApplicationAgent(GetAiApplicationAgentRequest request) {
    return getAiApplicationAgentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Agent under an AI Application.
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
   *   GetAiApplicationAgentRequest request =
   *       GetAiApplicationAgentRequest.newBuilder()
   *           .setName(
   *               AgentName.ofProjectLocationAiApplicationAgentName(
   *                       "[PROJECT]", "[LOCATION]", "[AI_APPLICATION]", "[AGENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Agent> future =
   *       agentRegistryClient.getAiApplicationAgentCallable().futureCall(request);
   *   // Do something.
   *   Agent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAiApplicationAgentRequest, Agent> getAiApplicationAgentCallable() {
    return stub.getAiApplicationAgentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Agents under an AI Application.
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
   *   AiApplicationName parent =
   *       AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]");
   *   for (Agent element : agentRegistryClient.listAiApplicationAgents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value (AI Application) for ListAiApplicationAgentsRequest.
   *     Format: `projects/{project}/locations/{location}/aiApplications/{ai_application}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAiApplicationAgentsPagedResponse listAiApplicationAgents(
      @Nullable AiApplicationName parent) {
    ListAiApplicationAgentsRequest request =
        ListAiApplicationAgentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAiApplicationAgents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Agents under an AI Application.
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
   *   String parent =
   *       AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]").toString();
   *   for (Agent element : agentRegistryClient.listAiApplicationAgents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value (AI Application) for ListAiApplicationAgentsRequest.
   *     Format: `projects/{project}/locations/{location}/aiApplications/{ai_application}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAiApplicationAgentsPagedResponse listAiApplicationAgents(String parent) {
    ListAiApplicationAgentsRequest request =
        ListAiApplicationAgentsRequest.newBuilder().setParent(parent).build();
    return listAiApplicationAgents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Agents under an AI Application.
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
   *   ListAiApplicationAgentsRequest request =
   *       ListAiApplicationAgentsRequest.newBuilder()
   *           .setParent(
   *               AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Agent element : agentRegistryClient.listAiApplicationAgents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAiApplicationAgentsPagedResponse listAiApplicationAgents(
      ListAiApplicationAgentsRequest request) {
    return listAiApplicationAgentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Agents under an AI Application.
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
   *   ListAiApplicationAgentsRequest request =
   *       ListAiApplicationAgentsRequest.newBuilder()
   *           .setParent(
   *               AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Agent> future =
   *       agentRegistryClient.listAiApplicationAgentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Agent element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAiApplicationAgentsRequest, ListAiApplicationAgentsPagedResponse>
      listAiApplicationAgentsPagedCallable() {
    return stub.listAiApplicationAgentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Agents under an AI Application.
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
   *   ListAiApplicationAgentsRequest request =
   *       ListAiApplicationAgentsRequest.newBuilder()
   *           .setParent(
   *               AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAiApplicationAgentsResponse response =
   *         agentRegistryClient.listAiApplicationAgentsCallable().call(request);
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
  public final UnaryCallable<ListAiApplicationAgentsRequest, ListAiApplicationAgentsResponse>
      listAiApplicationAgentsCallable() {
    return stub.listAiApplicationAgentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single McpServer under an AI Application.
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
   *   McpServerName name =
   *       McpServerName.ofProjectLocationAiApplicationMcpServerName(
   *           "[PROJECT]", "[LOCATION]", "[AI_APPLICATION]", "[MCP_SERVER]");
   *   McpServer response = agentRegistryClient.getAiApplicationMcpServer(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource. Format:
   *     `projects/{project}/locations/{location}/aiApplications/{ai_application}/mcpServers/{mcp_server}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final McpServer getAiApplicationMcpServer(@Nullable McpServerName name) {
    GetAiApplicationMcpServerRequest request =
        GetAiApplicationMcpServerRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAiApplicationMcpServer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single McpServer under an AI Application.
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
   *   String name =
   *       McpServerName.ofProjectLocationMcpServerName("[PROJECT]", "[LOCATION]", "[MCP_SERVER]")
   *           .toString();
   *   McpServer response = agentRegistryClient.getAiApplicationMcpServer(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource. Format:
   *     `projects/{project}/locations/{location}/aiApplications/{ai_application}/mcpServers/{mcp_server}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final McpServer getAiApplicationMcpServer(String name) {
    GetAiApplicationMcpServerRequest request =
        GetAiApplicationMcpServerRequest.newBuilder().setName(name).build();
    return getAiApplicationMcpServer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single McpServer under an AI Application.
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
   *   GetAiApplicationMcpServerRequest request =
   *       GetAiApplicationMcpServerRequest.newBuilder()
   *           .setName(
   *               McpServerName.ofProjectLocationAiApplicationMcpServerName(
   *                       "[PROJECT]", "[LOCATION]", "[AI_APPLICATION]", "[MCP_SERVER]")
   *                   .toString())
   *           .build();
   *   McpServer response = agentRegistryClient.getAiApplicationMcpServer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final McpServer getAiApplicationMcpServer(GetAiApplicationMcpServerRequest request) {
    return getAiApplicationMcpServerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single McpServer under an AI Application.
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
   *   GetAiApplicationMcpServerRequest request =
   *       GetAiApplicationMcpServerRequest.newBuilder()
   *           .setName(
   *               McpServerName.ofProjectLocationAiApplicationMcpServerName(
   *                       "[PROJECT]", "[LOCATION]", "[AI_APPLICATION]", "[MCP_SERVER]")
   *                   .toString())
   *           .build();
   *   ApiFuture<McpServer> future =
   *       agentRegistryClient.getAiApplicationMcpServerCallable().futureCall(request);
   *   // Do something.
   *   McpServer response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAiApplicationMcpServerRequest, McpServer>
      getAiApplicationMcpServerCallable() {
    return stub.getAiApplicationMcpServerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists McpServers under an AI Application.
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
   *   AiApplicationName parent =
   *       AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]");
   *   for (McpServer element :
   *       agentRegistryClient.listAiApplicationMcpServers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value (AI Application) for ListAiApplicationMcpServersRequest.
   *     Format: `projects/{project}/locations/{location}/aiApplications/{ai_application}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAiApplicationMcpServersPagedResponse listAiApplicationMcpServers(
      @Nullable AiApplicationName parent) {
    ListAiApplicationMcpServersRequest request =
        ListAiApplicationMcpServersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAiApplicationMcpServers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists McpServers under an AI Application.
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
   *   String parent =
   *       AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]").toString();
   *   for (McpServer element :
   *       agentRegistryClient.listAiApplicationMcpServers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value (AI Application) for ListAiApplicationMcpServersRequest.
   *     Format: `projects/{project}/locations/{location}/aiApplications/{ai_application}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAiApplicationMcpServersPagedResponse listAiApplicationMcpServers(String parent) {
    ListAiApplicationMcpServersRequest request =
        ListAiApplicationMcpServersRequest.newBuilder().setParent(parent).build();
    return listAiApplicationMcpServers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists McpServers under an AI Application.
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
   *   ListAiApplicationMcpServersRequest request =
   *       ListAiApplicationMcpServersRequest.newBuilder()
   *           .setParent(
   *               AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (McpServer element :
   *       agentRegistryClient.listAiApplicationMcpServers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAiApplicationMcpServersPagedResponse listAiApplicationMcpServers(
      ListAiApplicationMcpServersRequest request) {
    return listAiApplicationMcpServersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists McpServers under an AI Application.
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
   *   ListAiApplicationMcpServersRequest request =
   *       ListAiApplicationMcpServersRequest.newBuilder()
   *           .setParent(
   *               AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<McpServer> future =
   *       agentRegistryClient.listAiApplicationMcpServersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (McpServer element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListAiApplicationMcpServersRequest, ListAiApplicationMcpServersPagedResponse>
      listAiApplicationMcpServersPagedCallable() {
    return stub.listAiApplicationMcpServersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists McpServers under an AI Application.
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
   *   ListAiApplicationMcpServersRequest request =
   *       ListAiApplicationMcpServersRequest.newBuilder()
   *           .setParent(
   *               AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAiApplicationMcpServersResponse response =
   *         agentRegistryClient.listAiApplicationMcpServersCallable().call(request);
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
  public final UnaryCallable<
          ListAiApplicationMcpServersRequest, ListAiApplicationMcpServersResponse>
      listAiApplicationMcpServersCallable() {
    return stub.listAiApplicationMcpServersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Finding.
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
   *   FindingName name = FindingName.of("[PROJECT]", "[LOCATION]", "[FINDING]");
   *   Finding response = agentRegistryClient.getFinding(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Finding to retrieve. Format:
   *     `projects/{project}/locations/{location}/findings/{finding}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Finding getFinding(@Nullable FindingName name) {
    GetFindingRequest request =
        GetFindingRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getFinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Finding.
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
   *   String name = FindingName.of("[PROJECT]", "[LOCATION]", "[FINDING]").toString();
   *   Finding response = agentRegistryClient.getFinding(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Finding to retrieve. Format:
   *     `projects/{project}/locations/{location}/findings/{finding}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Finding getFinding(String name) {
    GetFindingRequest request = GetFindingRequest.newBuilder().setName(name).build();
    return getFinding(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Finding.
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
   *   GetFindingRequest request =
   *       GetFindingRequest.newBuilder()
   *           .setName(FindingName.of("[PROJECT]", "[LOCATION]", "[FINDING]").toString())
   *           .build();
   *   Finding response = agentRegistryClient.getFinding(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Finding getFinding(GetFindingRequest request) {
    return getFindingCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Finding.
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
   *   GetFindingRequest request =
   *       GetFindingRequest.newBuilder()
   *           .setName(FindingName.of("[PROJECT]", "[LOCATION]", "[FINDING]").toString())
   *           .build();
   *   ApiFuture<Finding> future = agentRegistryClient.getFindingCallable().futureCall(request);
   *   // Do something.
   *   Finding response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFindingRequest, Finding> getFindingCallable() {
    return stub.getFindingCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Findings in a given project and location.
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
   *   for (Finding element : agentRegistryClient.listFindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListFindingsRequest. Format:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFindingsPagedResponse listFindings(@Nullable LocationName parent) {
    ListFindingsRequest request =
        ListFindingsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Findings in a given project and location.
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
   *   for (Finding element : agentRegistryClient.listFindings(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value for ListFindingsRequest. Format:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFindingsPagedResponse listFindings(String parent) {
    ListFindingsRequest request = ListFindingsRequest.newBuilder().setParent(parent).build();
    return listFindings(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Findings in a given project and location.
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
   *   ListFindingsRequest request =
   *       ListFindingsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Finding element : agentRegistryClient.listFindings(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFindingsPagedResponse listFindings(ListFindingsRequest request) {
    return listFindingsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Findings in a given project and location.
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
   *   ListFindingsRequest request =
   *       ListFindingsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Finding> future =
   *       agentRegistryClient.listFindingsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Finding element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFindingsRequest, ListFindingsPagedResponse>
      listFindingsPagedCallable() {
    return stub.listFindingsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Findings in a given project and location.
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
   *   ListFindingsRequest request =
   *       ListFindingsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListFindingsResponse response = agentRegistryClient.listFindingsCallable().call(request);
   *     for (Finding element : response.getFindingsList()) {
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
  public final UnaryCallable<ListFindingsRequest, ListFindingsResponse> listFindingsCallable() {
    return stub.listFindingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Endpoint under an AI Application.
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
   *   EndpointName name =
   *       EndpointName.ofProjectLocationAiApplicationEndpointName(
   *           "[PROJECT]", "[LOCATION]", "[AI_APPLICATION]", "[ENDPOINT]");
   *   Endpoint response = agentRegistryClient.getAiApplicationEndpoint(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource. Format:
   *     `projects/{project}/locations/{location}/aiApplications/{ai_application}/endpoints/{endpoint}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Endpoint getAiApplicationEndpoint(@Nullable EndpointName name) {
    GetAiApplicationEndpointRequest request =
        GetAiApplicationEndpointRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAiApplicationEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Endpoint under an AI Application.
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
   *   String name =
   *       EndpointName.ofProjectLocationEndpointName("[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *           .toString();
   *   Endpoint response = agentRegistryClient.getAiApplicationEndpoint(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource. Format:
   *     `projects/{project}/locations/{location}/aiApplications/{ai_application}/endpoints/{endpoint}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Endpoint getAiApplicationEndpoint(String name) {
    GetAiApplicationEndpointRequest request =
        GetAiApplicationEndpointRequest.newBuilder().setName(name).build();
    return getAiApplicationEndpoint(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Endpoint under an AI Application.
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
   *   GetAiApplicationEndpointRequest request =
   *       GetAiApplicationEndpointRequest.newBuilder()
   *           .setName(
   *               EndpointName.ofProjectLocationAiApplicationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[AI_APPLICATION]", "[ENDPOINT]")
   *                   .toString())
   *           .build();
   *   Endpoint response = agentRegistryClient.getAiApplicationEndpoint(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Endpoint getAiApplicationEndpoint(GetAiApplicationEndpointRequest request) {
    return getAiApplicationEndpointCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a single Endpoint under an AI Application.
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
   *   GetAiApplicationEndpointRequest request =
   *       GetAiApplicationEndpointRequest.newBuilder()
   *           .setName(
   *               EndpointName.ofProjectLocationAiApplicationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[AI_APPLICATION]", "[ENDPOINT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Endpoint> future =
   *       agentRegistryClient.getAiApplicationEndpointCallable().futureCall(request);
   *   // Do something.
   *   Endpoint response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAiApplicationEndpointRequest, Endpoint>
      getAiApplicationEndpointCallable() {
    return stub.getAiApplicationEndpointCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Endpoints under an AI Application.
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
   *   AiApplicationName parent =
   *       AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]");
   *   for (Endpoint element : agentRegistryClient.listAiApplicationEndpoints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value (AI Application) for ListAiApplicationEndpointsRequest.
   *     Format: `projects/{project}/locations/{location}/aiApplications/{ai_application}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAiApplicationEndpointsPagedResponse listAiApplicationEndpoints(
      @Nullable AiApplicationName parent) {
    ListAiApplicationEndpointsRequest request =
        ListAiApplicationEndpointsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAiApplicationEndpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Endpoints under an AI Application.
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
   *   String parent =
   *       AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]").toString();
   *   for (Endpoint element : agentRegistryClient.listAiApplicationEndpoints(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value (AI Application) for ListAiApplicationEndpointsRequest.
   *     Format: `projects/{project}/locations/{location}/aiApplications/{ai_application}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAiApplicationEndpointsPagedResponse listAiApplicationEndpoints(String parent) {
    ListAiApplicationEndpointsRequest request =
        ListAiApplicationEndpointsRequest.newBuilder().setParent(parent).build();
    return listAiApplicationEndpoints(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Endpoints under an AI Application.
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
   *   ListAiApplicationEndpointsRequest request =
   *       ListAiApplicationEndpointsRequest.newBuilder()
   *           .setParent(
   *               AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Endpoint element :
   *       agentRegistryClient.listAiApplicationEndpoints(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAiApplicationEndpointsPagedResponse listAiApplicationEndpoints(
      ListAiApplicationEndpointsRequest request) {
    return listAiApplicationEndpointsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Endpoints under an AI Application.
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
   *   ListAiApplicationEndpointsRequest request =
   *       ListAiApplicationEndpointsRequest.newBuilder()
   *           .setParent(
   *               AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Endpoint> future =
   *       agentRegistryClient.listAiApplicationEndpointsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Endpoint element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListAiApplicationEndpointsRequest, ListAiApplicationEndpointsPagedResponse>
      listAiApplicationEndpointsPagedCallable() {
    return stub.listAiApplicationEndpointsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Endpoints under an AI Application.
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
   *   ListAiApplicationEndpointsRequest request =
   *       ListAiApplicationEndpointsRequest.newBuilder()
   *           .setParent(
   *               AiApplicationName.of("[PROJECT]", "[LOCATION]", "[AI_APPLICATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAiApplicationEndpointsResponse response =
   *         agentRegistryClient.listAiApplicationEndpointsCallable().call(request);
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
  public final UnaryCallable<ListAiApplicationEndpointsRequest, ListAiApplicationEndpointsResponse>
      listAiApplicationEndpointsCallable() {
    return stub.listAiApplicationEndpointsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ========================================================================= # Skill Encryption
   * Spec Service Methods
   *
   * <p>Gets the customer-managed encryption key (CMEK) configuration for Skills in a specific
   * project and location.
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
   *   SkillEncryptionSpecName name = SkillEncryptionSpecName.of("[PROJECT]", "[LOCATION]");
   *   SkillEncryptionSpec response = agentRegistryClient.getSkillEncryptionSpec(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the SkillEncryptionSpec to retrieve. Format:
   *     `projects/{project}/locations/{location}/skillEncryptionSpec`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SkillEncryptionSpec getSkillEncryptionSpec(@Nullable SkillEncryptionSpecName name) {
    GetSkillEncryptionSpecRequest request =
        GetSkillEncryptionSpecRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getSkillEncryptionSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ========================================================================= # Skill Encryption
   * Spec Service Methods
   *
   * <p>Gets the customer-managed encryption key (CMEK) configuration for Skills in a specific
   * project and location.
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
   *   String name = SkillEncryptionSpecName.of("[PROJECT]", "[LOCATION]").toString();
   *   SkillEncryptionSpec response = agentRegistryClient.getSkillEncryptionSpec(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the SkillEncryptionSpec to retrieve. Format:
   *     `projects/{project}/locations/{location}/skillEncryptionSpec`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SkillEncryptionSpec getSkillEncryptionSpec(String name) {
    GetSkillEncryptionSpecRequest request =
        GetSkillEncryptionSpecRequest.newBuilder().setName(name).build();
    return getSkillEncryptionSpec(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ========================================================================= # Skill Encryption
   * Spec Service Methods
   *
   * <p>Gets the customer-managed encryption key (CMEK) configuration for Skills in a specific
   * project and location.
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
   *   GetSkillEncryptionSpecRequest request =
   *       GetSkillEncryptionSpecRequest.newBuilder()
   *           .setName(SkillEncryptionSpecName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   SkillEncryptionSpec response = agentRegistryClient.getSkillEncryptionSpec(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SkillEncryptionSpec getSkillEncryptionSpec(GetSkillEncryptionSpecRequest request) {
    return getSkillEncryptionSpecCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * ========================================================================= # Skill Encryption
   * Spec Service Methods
   *
   * <p>Gets the customer-managed encryption key (CMEK) configuration for Skills in a specific
   * project and location.
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
   *   GetSkillEncryptionSpecRequest request =
   *       GetSkillEncryptionSpecRequest.newBuilder()
   *           .setName(SkillEncryptionSpecName.of("[PROJECT]", "[LOCATION]").toString())
   *           .build();
   *   ApiFuture<SkillEncryptionSpec> future =
   *       agentRegistryClient.getSkillEncryptionSpecCallable().futureCall(request);
   *   // Do something.
   *   SkillEncryptionSpec response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetSkillEncryptionSpecRequest, SkillEncryptionSpec>
      getSkillEncryptionSpecCallable() {
    return stub.getSkillEncryptionSpecCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the customer-managed encryption key (CMEK) configuration for Skills in a specific
   * project and location.
   *
   * <p>This method is only allowed when no Skills exist in the target project and location. If any
   * Skill already exists in the location, the request fails with `FAILED_PRECONDITION`.
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
   *   SkillEncryptionSpec skillEncryptionSpec = SkillEncryptionSpec.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   SkillEncryptionSpec response =
   *       agentRegistryClient.updateSkillEncryptionSpecAsync(skillEncryptionSpec, updateMask).get();
   * }
   * }</pre>
   *
   * @param skillEncryptionSpec Required. The SkillEncryptionSpec to update.
   * @param updateMask Optional. Field mask is used to specify the fields to be overwritten in the
   *     SkillEncryptionSpec resource by the update. The fields specified in the update_mask are
   *     relative to the resource, not the full request. A field will be overwritten if it is in the
   *     mask. If the user does not provide a mask then all fields present in the request will be
   *     overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SkillEncryptionSpec, OperationMetadata>
      updateSkillEncryptionSpecAsync(
          SkillEncryptionSpec skillEncryptionSpec, FieldMask updateMask) {
    UpdateSkillEncryptionSpecRequest request =
        UpdateSkillEncryptionSpecRequest.newBuilder()
            .setSkillEncryptionSpec(skillEncryptionSpec)
            .setUpdateMask(updateMask)
            .build();
    return updateSkillEncryptionSpecAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the customer-managed encryption key (CMEK) configuration for Skills in a specific
   * project and location.
   *
   * <p>This method is only allowed when no Skills exist in the target project and location. If any
   * Skill already exists in the location, the request fails with `FAILED_PRECONDITION`.
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
   *   UpdateSkillEncryptionSpecRequest request =
   *       UpdateSkillEncryptionSpecRequest.newBuilder()
   *           .setSkillEncryptionSpec(SkillEncryptionSpec.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   SkillEncryptionSpec response =
   *       agentRegistryClient.updateSkillEncryptionSpecAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<SkillEncryptionSpec, OperationMetadata>
      updateSkillEncryptionSpecAsync(UpdateSkillEncryptionSpecRequest request) {
    return updateSkillEncryptionSpecOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the customer-managed encryption key (CMEK) configuration for Skills in a specific
   * project and location.
   *
   * <p>This method is only allowed when no Skills exist in the target project and location. If any
   * Skill already exists in the location, the request fails with `FAILED_PRECONDITION`.
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
   *   UpdateSkillEncryptionSpecRequest request =
   *       UpdateSkillEncryptionSpecRequest.newBuilder()
   *           .setSkillEncryptionSpec(SkillEncryptionSpec.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<SkillEncryptionSpec, OperationMetadata> future =
   *       agentRegistryClient.updateSkillEncryptionSpecOperationCallable().futureCall(request);
   *   // Do something.
   *   SkillEncryptionSpec response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateSkillEncryptionSpecRequest, SkillEncryptionSpec, OperationMetadata>
      updateSkillEncryptionSpecOperationCallable() {
    return stub.updateSkillEncryptionSpecOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the customer-managed encryption key (CMEK) configuration for Skills in a specific
   * project and location.
   *
   * <p>This method is only allowed when no Skills exist in the target project and location. If any
   * Skill already exists in the location, the request fails with `FAILED_PRECONDITION`.
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
   *   UpdateSkillEncryptionSpecRequest request =
   *       UpdateSkillEncryptionSpecRequest.newBuilder()
   *           .setSkillEncryptionSpec(SkillEncryptionSpec.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       agentRegistryClient.updateSkillEncryptionSpecCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateSkillEncryptionSpecRequest, Operation>
      updateSkillEncryptionSpecCallable() {
    return stub.updateSkillEncryptionSpecCallable();
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
        @Nullable PageContext<ListAgentsRequest, ListAgentsResponse, Agent> context,
        @Nullable ListAgentsResponse response) {
      super(context, response);
    }

    private static ListAgentsPage createEmptyPage() {
      return new ListAgentsPage(null, null);
    }

    @Override
    protected ListAgentsPage createPage(
        @Nullable PageContext<ListAgentsRequest, ListAgentsResponse, Agent> context,
        @Nullable ListAgentsResponse response) {
      return new ListAgentsPage(context, response);
    }

    @Override
    public ApiFuture<ListAgentsPage> createPageAsync(
        @Nullable PageContext<ListAgentsRequest, ListAgentsResponse, Agent> context,
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

    private ListAgentsFixedSizeCollection(
        @Nullable List<ListAgentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAgentsFixedSizeCollection createEmptyCollection() {
      return new ListAgentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAgentsFixedSizeCollection createCollection(
        @Nullable List<ListAgentsPage> pages, int collectionSize) {
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
        @Nullable PageContext<SearchAgentsRequest, SearchAgentsResponse, Agent> context,
        @Nullable SearchAgentsResponse response) {
      super(context, response);
    }

    private static SearchAgentsPage createEmptyPage() {
      return new SearchAgentsPage(null, null);
    }

    @Override
    protected SearchAgentsPage createPage(
        @Nullable PageContext<SearchAgentsRequest, SearchAgentsResponse, Agent> context,
        @Nullable SearchAgentsResponse response) {
      return new SearchAgentsPage(context, response);
    }

    @Override
    public ApiFuture<SearchAgentsPage> createPageAsync(
        @Nullable PageContext<SearchAgentsRequest, SearchAgentsResponse, Agent> context,
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

    private SearchAgentsFixedSizeCollection(
        @Nullable List<SearchAgentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchAgentsFixedSizeCollection createEmptyCollection() {
      return new SearchAgentsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchAgentsFixedSizeCollection createCollection(
        @Nullable List<SearchAgentsPage> pages, int collectionSize) {
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
        @Nullable PageContext<ListEndpointsRequest, ListEndpointsResponse, Endpoint> context,
        @Nullable ListEndpointsResponse response) {
      super(context, response);
    }

    private static ListEndpointsPage createEmptyPage() {
      return new ListEndpointsPage(null, null);
    }

    @Override
    protected ListEndpointsPage createPage(
        @Nullable PageContext<ListEndpointsRequest, ListEndpointsResponse, Endpoint> context,
        @Nullable ListEndpointsResponse response) {
      return new ListEndpointsPage(context, response);
    }

    @Override
    public ApiFuture<ListEndpointsPage> createPageAsync(
        @Nullable PageContext<ListEndpointsRequest, ListEndpointsResponse, Endpoint> context,
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

    private ListEndpointsFixedSizeCollection(
        @Nullable List<ListEndpointsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEndpointsFixedSizeCollection createEmptyCollection() {
      return new ListEndpointsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEndpointsFixedSizeCollection createCollection(
        @Nullable List<ListEndpointsPage> pages, int collectionSize) {
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
        @Nullable PageContext<ListMcpServersRequest, ListMcpServersResponse, McpServer> context,
        @Nullable ListMcpServersResponse response) {
      super(context, response);
    }

    private static ListMcpServersPage createEmptyPage() {
      return new ListMcpServersPage(null, null);
    }

    @Override
    protected ListMcpServersPage createPage(
        @Nullable PageContext<ListMcpServersRequest, ListMcpServersResponse, McpServer> context,
        @Nullable ListMcpServersResponse response) {
      return new ListMcpServersPage(context, response);
    }

    @Override
    public ApiFuture<ListMcpServersPage> createPageAsync(
        @Nullable PageContext<ListMcpServersRequest, ListMcpServersResponse, McpServer> context,
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

    private ListMcpServersFixedSizeCollection(
        @Nullable List<ListMcpServersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMcpServersFixedSizeCollection createEmptyCollection() {
      return new ListMcpServersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMcpServersFixedSizeCollection createCollection(
        @Nullable List<ListMcpServersPage> pages, int collectionSize) {
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
        @Nullable PageContext<SearchMcpServersRequest, SearchMcpServersResponse, McpServer> context,
        @Nullable SearchMcpServersResponse response) {
      super(context, response);
    }

    private static SearchMcpServersPage createEmptyPage() {
      return new SearchMcpServersPage(null, null);
    }

    @Override
    protected SearchMcpServersPage createPage(
        @Nullable PageContext<SearchMcpServersRequest, SearchMcpServersResponse, McpServer> context,
        @Nullable SearchMcpServersResponse response) {
      return new SearchMcpServersPage(context, response);
    }

    @Override
    public ApiFuture<SearchMcpServersPage> createPageAsync(
        @Nullable PageContext<SearchMcpServersRequest, SearchMcpServersResponse, McpServer> context,
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
        @Nullable List<SearchMcpServersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchMcpServersFixedSizeCollection createEmptyCollection() {
      return new SearchMcpServersFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchMcpServersFixedSizeCollection createCollection(
        @Nullable List<SearchMcpServersPage> pages, int collectionSize) {
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
        @Nullable PageContext<ListServicesRequest, ListServicesResponse, Service> context,
        @Nullable ListServicesResponse response) {
      super(context, response);
    }

    private static ListServicesPage createEmptyPage() {
      return new ListServicesPage(null, null);
    }

    @Override
    protected ListServicesPage createPage(
        @Nullable PageContext<ListServicesRequest, ListServicesResponse, Service> context,
        @Nullable ListServicesResponse response) {
      return new ListServicesPage(context, response);
    }

    @Override
    public ApiFuture<ListServicesPage> createPageAsync(
        @Nullable PageContext<ListServicesRequest, ListServicesResponse, Service> context,
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

    private ListServicesFixedSizeCollection(
        @Nullable List<ListServicesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListServicesFixedSizeCollection createEmptyCollection() {
      return new ListServicesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListServicesFixedSizeCollection createCollection(
        @Nullable List<ListServicesPage> pages, int collectionSize) {
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
        @Nullable PageContext<ListBindingsRequest, ListBindingsResponse, Binding> context,
        @Nullable ListBindingsResponse response) {
      super(context, response);
    }

    private static ListBindingsPage createEmptyPage() {
      return new ListBindingsPage(null, null);
    }

    @Override
    protected ListBindingsPage createPage(
        @Nullable PageContext<ListBindingsRequest, ListBindingsResponse, Binding> context,
        @Nullable ListBindingsResponse response) {
      return new ListBindingsPage(context, response);
    }

    @Override
    public ApiFuture<ListBindingsPage> createPageAsync(
        @Nullable PageContext<ListBindingsRequest, ListBindingsResponse, Binding> context,
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

    private ListBindingsFixedSizeCollection(
        @Nullable List<ListBindingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListBindingsFixedSizeCollection createEmptyCollection() {
      return new ListBindingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListBindingsFixedSizeCollection createCollection(
        @Nullable List<ListBindingsPage> pages, int collectionSize) {
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
        @Nullable
            PageContext<FetchAvailableBindingsRequest, FetchAvailableBindingsResponse, Binding>
            context,
        @Nullable FetchAvailableBindingsResponse response) {
      super(context, response);
    }

    private static FetchAvailableBindingsPage createEmptyPage() {
      return new FetchAvailableBindingsPage(null, null);
    }

    @Override
    protected FetchAvailableBindingsPage createPage(
        @Nullable
            PageContext<FetchAvailableBindingsRequest, FetchAvailableBindingsResponse, Binding>
            context,
        @Nullable FetchAvailableBindingsResponse response) {
      return new FetchAvailableBindingsPage(context, response);
    }

    @Override
    public ApiFuture<FetchAvailableBindingsPage> createPageAsync(
        @Nullable
            PageContext<FetchAvailableBindingsRequest, FetchAvailableBindingsResponse, Binding>
            context,
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
        @Nullable List<FetchAvailableBindingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FetchAvailableBindingsFixedSizeCollection createEmptyCollection() {
      return new FetchAvailableBindingsFixedSizeCollection(null, 0);
    }

    @Override
    protected FetchAvailableBindingsFixedSizeCollection createCollection(
        @Nullable List<FetchAvailableBindingsPage> pages, int collectionSize) {
      return new FetchAvailableBindingsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSkillsPagedResponse
      extends AbstractPagedListResponse<
          ListSkillsRequest,
          ListSkillsResponse,
          Skill,
          ListSkillsPage,
          ListSkillsFixedSizeCollection> {

    public static ApiFuture<ListSkillsPagedResponse> createAsync(
        PageContext<ListSkillsRequest, ListSkillsResponse, Skill> context,
        ApiFuture<ListSkillsResponse> futureResponse) {
      ApiFuture<ListSkillsPage> futurePage =
          ListSkillsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListSkillsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListSkillsPagedResponse(ListSkillsPage page) {
      super(page, ListSkillsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSkillsPage
      extends AbstractPage<ListSkillsRequest, ListSkillsResponse, Skill, ListSkillsPage> {

    private ListSkillsPage(
        @Nullable PageContext<ListSkillsRequest, ListSkillsResponse, Skill> context,
        @Nullable ListSkillsResponse response) {
      super(context, response);
    }

    private static ListSkillsPage createEmptyPage() {
      return new ListSkillsPage(null, null);
    }

    @Override
    protected ListSkillsPage createPage(
        @Nullable PageContext<ListSkillsRequest, ListSkillsResponse, Skill> context,
        @Nullable ListSkillsResponse response) {
      return new ListSkillsPage(context, response);
    }

    @Override
    public ApiFuture<ListSkillsPage> createPageAsync(
        @Nullable PageContext<ListSkillsRequest, ListSkillsResponse, Skill> context,
        ApiFuture<ListSkillsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSkillsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSkillsRequest,
          ListSkillsResponse,
          Skill,
          ListSkillsPage,
          ListSkillsFixedSizeCollection> {

    private ListSkillsFixedSizeCollection(
        @Nullable List<ListSkillsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSkillsFixedSizeCollection createEmptyCollection() {
      return new ListSkillsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSkillsFixedSizeCollection createCollection(
        @Nullable List<ListSkillsPage> pages, int collectionSize) {
      return new ListSkillsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchSkillsPagedResponse
      extends AbstractPagedListResponse<
          SearchSkillsRequest,
          SearchSkillsResponse,
          Skill,
          SearchSkillsPage,
          SearchSkillsFixedSizeCollection> {

    public static ApiFuture<SearchSkillsPagedResponse> createAsync(
        PageContext<SearchSkillsRequest, SearchSkillsResponse, Skill> context,
        ApiFuture<SearchSkillsResponse> futureResponse) {
      ApiFuture<SearchSkillsPage> futurePage =
          SearchSkillsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchSkillsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchSkillsPagedResponse(SearchSkillsPage page) {
      super(page, SearchSkillsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchSkillsPage
      extends AbstractPage<SearchSkillsRequest, SearchSkillsResponse, Skill, SearchSkillsPage> {

    private SearchSkillsPage(
        @Nullable PageContext<SearchSkillsRequest, SearchSkillsResponse, Skill> context,
        @Nullable SearchSkillsResponse response) {
      super(context, response);
    }

    private static SearchSkillsPage createEmptyPage() {
      return new SearchSkillsPage(null, null);
    }

    @Override
    protected SearchSkillsPage createPage(
        @Nullable PageContext<SearchSkillsRequest, SearchSkillsResponse, Skill> context,
        @Nullable SearchSkillsResponse response) {
      return new SearchSkillsPage(context, response);
    }

    @Override
    public ApiFuture<SearchSkillsPage> createPageAsync(
        @Nullable PageContext<SearchSkillsRequest, SearchSkillsResponse, Skill> context,
        ApiFuture<SearchSkillsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchSkillsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchSkillsRequest,
          SearchSkillsResponse,
          Skill,
          SearchSkillsPage,
          SearchSkillsFixedSizeCollection> {

    private SearchSkillsFixedSizeCollection(
        @Nullable List<SearchSkillsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchSkillsFixedSizeCollection createEmptyCollection() {
      return new SearchSkillsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchSkillsFixedSizeCollection createCollection(
        @Nullable List<SearchSkillsPage> pages, int collectionSize) {
      return new SearchSkillsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListSkillRevisionsPagedResponse
      extends AbstractPagedListResponse<
          ListSkillRevisionsRequest,
          ListSkillRevisionsResponse,
          SkillRevision,
          ListSkillRevisionsPage,
          ListSkillRevisionsFixedSizeCollection> {

    public static ApiFuture<ListSkillRevisionsPagedResponse> createAsync(
        PageContext<ListSkillRevisionsRequest, ListSkillRevisionsResponse, SkillRevision> context,
        ApiFuture<ListSkillRevisionsResponse> futureResponse) {
      ApiFuture<ListSkillRevisionsPage> futurePage =
          ListSkillRevisionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSkillRevisionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSkillRevisionsPagedResponse(ListSkillRevisionsPage page) {
      super(page, ListSkillRevisionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSkillRevisionsPage
      extends AbstractPage<
          ListSkillRevisionsRequest,
          ListSkillRevisionsResponse,
          SkillRevision,
          ListSkillRevisionsPage> {

    private ListSkillRevisionsPage(
        @Nullable PageContext<ListSkillRevisionsRequest, ListSkillRevisionsResponse, SkillRevision>
            context,
        @Nullable ListSkillRevisionsResponse response) {
      super(context, response);
    }

    private static ListSkillRevisionsPage createEmptyPage() {
      return new ListSkillRevisionsPage(null, null);
    }

    @Override
    protected ListSkillRevisionsPage createPage(
        @Nullable PageContext<ListSkillRevisionsRequest, ListSkillRevisionsResponse, SkillRevision>
            context,
        @Nullable ListSkillRevisionsResponse response) {
      return new ListSkillRevisionsPage(context, response);
    }

    @Override
    public ApiFuture<ListSkillRevisionsPage> createPageAsync(
        @Nullable PageContext<ListSkillRevisionsRequest, ListSkillRevisionsResponse, SkillRevision>
            context,
        ApiFuture<ListSkillRevisionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSkillRevisionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSkillRevisionsRequest,
          ListSkillRevisionsResponse,
          SkillRevision,
          ListSkillRevisionsPage,
          ListSkillRevisionsFixedSizeCollection> {

    private ListSkillRevisionsFixedSizeCollection(
        @Nullable List<ListSkillRevisionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSkillRevisionsFixedSizeCollection createEmptyCollection() {
      return new ListSkillRevisionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSkillRevisionsFixedSizeCollection createCollection(
        @Nullable List<ListSkillRevisionsPage> pages, int collectionSize) {
      return new ListSkillRevisionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPublishersPagedResponse
      extends AbstractPagedListResponse<
          ListPublishersRequest,
          ListPublishersResponse,
          Publisher,
          ListPublishersPage,
          ListPublishersFixedSizeCollection> {

    public static ApiFuture<ListPublishersPagedResponse> createAsync(
        PageContext<ListPublishersRequest, ListPublishersResponse, Publisher> context,
        ApiFuture<ListPublishersResponse> futureResponse) {
      ApiFuture<ListPublishersPage> futurePage =
          ListPublishersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListPublishersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListPublishersPagedResponse(ListPublishersPage page) {
      super(page, ListPublishersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPublishersPage
      extends AbstractPage<
          ListPublishersRequest, ListPublishersResponse, Publisher, ListPublishersPage> {

    private ListPublishersPage(
        @Nullable PageContext<ListPublishersRequest, ListPublishersResponse, Publisher> context,
        @Nullable ListPublishersResponse response) {
      super(context, response);
    }

    private static ListPublishersPage createEmptyPage() {
      return new ListPublishersPage(null, null);
    }

    @Override
    protected ListPublishersPage createPage(
        @Nullable PageContext<ListPublishersRequest, ListPublishersResponse, Publisher> context,
        @Nullable ListPublishersResponse response) {
      return new ListPublishersPage(context, response);
    }

    @Override
    public ApiFuture<ListPublishersPage> createPageAsync(
        @Nullable PageContext<ListPublishersRequest, ListPublishersResponse, Publisher> context,
        ApiFuture<ListPublishersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListPublishersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPublishersRequest,
          ListPublishersResponse,
          Publisher,
          ListPublishersPage,
          ListPublishersFixedSizeCollection> {

    private ListPublishersFixedSizeCollection(
        @Nullable List<ListPublishersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListPublishersFixedSizeCollection createEmptyCollection() {
      return new ListPublishersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListPublishersFixedSizeCollection createCollection(
        @Nullable List<ListPublishersPage> pages, int collectionSize) {
      return new ListPublishersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAiApplicationsPagedResponse
      extends AbstractPagedListResponse<
          ListAiApplicationsRequest,
          ListAiApplicationsResponse,
          AiApplication,
          ListAiApplicationsPage,
          ListAiApplicationsFixedSizeCollection> {

    public static ApiFuture<ListAiApplicationsPagedResponse> createAsync(
        PageContext<ListAiApplicationsRequest, ListAiApplicationsResponse, AiApplication> context,
        ApiFuture<ListAiApplicationsResponse> futureResponse) {
      ApiFuture<ListAiApplicationsPage> futurePage =
          ListAiApplicationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAiApplicationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAiApplicationsPagedResponse(ListAiApplicationsPage page) {
      super(page, ListAiApplicationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAiApplicationsPage
      extends AbstractPage<
          ListAiApplicationsRequest,
          ListAiApplicationsResponse,
          AiApplication,
          ListAiApplicationsPage> {

    private ListAiApplicationsPage(
        @Nullable PageContext<ListAiApplicationsRequest, ListAiApplicationsResponse, AiApplication>
            context,
        @Nullable ListAiApplicationsResponse response) {
      super(context, response);
    }

    private static ListAiApplicationsPage createEmptyPage() {
      return new ListAiApplicationsPage(null, null);
    }

    @Override
    protected ListAiApplicationsPage createPage(
        @Nullable PageContext<ListAiApplicationsRequest, ListAiApplicationsResponse, AiApplication>
            context,
        @Nullable ListAiApplicationsResponse response) {
      return new ListAiApplicationsPage(context, response);
    }

    @Override
    public ApiFuture<ListAiApplicationsPage> createPageAsync(
        @Nullable PageContext<ListAiApplicationsRequest, ListAiApplicationsResponse, AiApplication>
            context,
        ApiFuture<ListAiApplicationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAiApplicationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAiApplicationsRequest,
          ListAiApplicationsResponse,
          AiApplication,
          ListAiApplicationsPage,
          ListAiApplicationsFixedSizeCollection> {

    private ListAiApplicationsFixedSizeCollection(
        @Nullable List<ListAiApplicationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAiApplicationsFixedSizeCollection createEmptyCollection() {
      return new ListAiApplicationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAiApplicationsFixedSizeCollection createCollection(
        @Nullable List<ListAiApplicationsPage> pages, int collectionSize) {
      return new ListAiApplicationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAiApplicationAgentsPagedResponse
      extends AbstractPagedListResponse<
          ListAiApplicationAgentsRequest,
          ListAiApplicationAgentsResponse,
          Agent,
          ListAiApplicationAgentsPage,
          ListAiApplicationAgentsFixedSizeCollection> {

    public static ApiFuture<ListAiApplicationAgentsPagedResponse> createAsync(
        PageContext<ListAiApplicationAgentsRequest, ListAiApplicationAgentsResponse, Agent> context,
        ApiFuture<ListAiApplicationAgentsResponse> futureResponse) {
      ApiFuture<ListAiApplicationAgentsPage> futurePage =
          ListAiApplicationAgentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAiApplicationAgentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAiApplicationAgentsPagedResponse(ListAiApplicationAgentsPage page) {
      super(page, ListAiApplicationAgentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAiApplicationAgentsPage
      extends AbstractPage<
          ListAiApplicationAgentsRequest,
          ListAiApplicationAgentsResponse,
          Agent,
          ListAiApplicationAgentsPage> {

    private ListAiApplicationAgentsPage(
        @Nullable
            PageContext<ListAiApplicationAgentsRequest, ListAiApplicationAgentsResponse, Agent>
            context,
        @Nullable ListAiApplicationAgentsResponse response) {
      super(context, response);
    }

    private static ListAiApplicationAgentsPage createEmptyPage() {
      return new ListAiApplicationAgentsPage(null, null);
    }

    @Override
    protected ListAiApplicationAgentsPage createPage(
        @Nullable
            PageContext<ListAiApplicationAgentsRequest, ListAiApplicationAgentsResponse, Agent>
            context,
        @Nullable ListAiApplicationAgentsResponse response) {
      return new ListAiApplicationAgentsPage(context, response);
    }

    @Override
    public ApiFuture<ListAiApplicationAgentsPage> createPageAsync(
        @Nullable
            PageContext<ListAiApplicationAgentsRequest, ListAiApplicationAgentsResponse, Agent>
            context,
        ApiFuture<ListAiApplicationAgentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAiApplicationAgentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAiApplicationAgentsRequest,
          ListAiApplicationAgentsResponse,
          Agent,
          ListAiApplicationAgentsPage,
          ListAiApplicationAgentsFixedSizeCollection> {

    private ListAiApplicationAgentsFixedSizeCollection(
        @Nullable List<ListAiApplicationAgentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAiApplicationAgentsFixedSizeCollection createEmptyCollection() {
      return new ListAiApplicationAgentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAiApplicationAgentsFixedSizeCollection createCollection(
        @Nullable List<ListAiApplicationAgentsPage> pages, int collectionSize) {
      return new ListAiApplicationAgentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAiApplicationMcpServersPagedResponse
      extends AbstractPagedListResponse<
          ListAiApplicationMcpServersRequest,
          ListAiApplicationMcpServersResponse,
          McpServer,
          ListAiApplicationMcpServersPage,
          ListAiApplicationMcpServersFixedSizeCollection> {

    public static ApiFuture<ListAiApplicationMcpServersPagedResponse> createAsync(
        PageContext<
                ListAiApplicationMcpServersRequest, ListAiApplicationMcpServersResponse, McpServer>
            context,
        ApiFuture<ListAiApplicationMcpServersResponse> futureResponse) {
      ApiFuture<ListAiApplicationMcpServersPage> futurePage =
          ListAiApplicationMcpServersPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAiApplicationMcpServersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAiApplicationMcpServersPagedResponse(ListAiApplicationMcpServersPage page) {
      super(page, ListAiApplicationMcpServersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAiApplicationMcpServersPage
      extends AbstractPage<
          ListAiApplicationMcpServersRequest,
          ListAiApplicationMcpServersResponse,
          McpServer,
          ListAiApplicationMcpServersPage> {

    private ListAiApplicationMcpServersPage(
        @Nullable
            PageContext<
                ListAiApplicationMcpServersRequest, ListAiApplicationMcpServersResponse, McpServer>
            context,
        @Nullable ListAiApplicationMcpServersResponse response) {
      super(context, response);
    }

    private static ListAiApplicationMcpServersPage createEmptyPage() {
      return new ListAiApplicationMcpServersPage(null, null);
    }

    @Override
    protected ListAiApplicationMcpServersPage createPage(
        @Nullable
            PageContext<
                ListAiApplicationMcpServersRequest, ListAiApplicationMcpServersResponse, McpServer>
            context,
        @Nullable ListAiApplicationMcpServersResponse response) {
      return new ListAiApplicationMcpServersPage(context, response);
    }

    @Override
    public ApiFuture<ListAiApplicationMcpServersPage> createPageAsync(
        @Nullable
            PageContext<
                ListAiApplicationMcpServersRequest, ListAiApplicationMcpServersResponse, McpServer>
            context,
        ApiFuture<ListAiApplicationMcpServersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAiApplicationMcpServersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAiApplicationMcpServersRequest,
          ListAiApplicationMcpServersResponse,
          McpServer,
          ListAiApplicationMcpServersPage,
          ListAiApplicationMcpServersFixedSizeCollection> {

    private ListAiApplicationMcpServersFixedSizeCollection(
        @Nullable List<ListAiApplicationMcpServersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAiApplicationMcpServersFixedSizeCollection createEmptyCollection() {
      return new ListAiApplicationMcpServersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAiApplicationMcpServersFixedSizeCollection createCollection(
        @Nullable List<ListAiApplicationMcpServersPage> pages, int collectionSize) {
      return new ListAiApplicationMcpServersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListFindingsPagedResponse
      extends AbstractPagedListResponse<
          ListFindingsRequest,
          ListFindingsResponse,
          Finding,
          ListFindingsPage,
          ListFindingsFixedSizeCollection> {

    public static ApiFuture<ListFindingsPagedResponse> createAsync(
        PageContext<ListFindingsRequest, ListFindingsResponse, Finding> context,
        ApiFuture<ListFindingsResponse> futureResponse) {
      ApiFuture<ListFindingsPage> futurePage =
          ListFindingsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListFindingsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListFindingsPagedResponse(ListFindingsPage page) {
      super(page, ListFindingsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFindingsPage
      extends AbstractPage<ListFindingsRequest, ListFindingsResponse, Finding, ListFindingsPage> {

    private ListFindingsPage(
        @Nullable PageContext<ListFindingsRequest, ListFindingsResponse, Finding> context,
        @Nullable ListFindingsResponse response) {
      super(context, response);
    }

    private static ListFindingsPage createEmptyPage() {
      return new ListFindingsPage(null, null);
    }

    @Override
    protected ListFindingsPage createPage(
        @Nullable PageContext<ListFindingsRequest, ListFindingsResponse, Finding> context,
        @Nullable ListFindingsResponse response) {
      return new ListFindingsPage(context, response);
    }

    @Override
    public ApiFuture<ListFindingsPage> createPageAsync(
        @Nullable PageContext<ListFindingsRequest, ListFindingsResponse, Finding> context,
        ApiFuture<ListFindingsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFindingsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFindingsRequest,
          ListFindingsResponse,
          Finding,
          ListFindingsPage,
          ListFindingsFixedSizeCollection> {

    private ListFindingsFixedSizeCollection(
        @Nullable List<ListFindingsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFindingsFixedSizeCollection createEmptyCollection() {
      return new ListFindingsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFindingsFixedSizeCollection createCollection(
        @Nullable List<ListFindingsPage> pages, int collectionSize) {
      return new ListFindingsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAiApplicationEndpointsPagedResponse
      extends AbstractPagedListResponse<
          ListAiApplicationEndpointsRequest,
          ListAiApplicationEndpointsResponse,
          Endpoint,
          ListAiApplicationEndpointsPage,
          ListAiApplicationEndpointsFixedSizeCollection> {

    public static ApiFuture<ListAiApplicationEndpointsPagedResponse> createAsync(
        PageContext<ListAiApplicationEndpointsRequest, ListAiApplicationEndpointsResponse, Endpoint>
            context,
        ApiFuture<ListAiApplicationEndpointsResponse> futureResponse) {
      ApiFuture<ListAiApplicationEndpointsPage> futurePage =
          ListAiApplicationEndpointsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAiApplicationEndpointsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAiApplicationEndpointsPagedResponse(ListAiApplicationEndpointsPage page) {
      super(page, ListAiApplicationEndpointsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAiApplicationEndpointsPage
      extends AbstractPage<
          ListAiApplicationEndpointsRequest,
          ListAiApplicationEndpointsResponse,
          Endpoint,
          ListAiApplicationEndpointsPage> {

    private ListAiApplicationEndpointsPage(
        @Nullable
            PageContext<
                ListAiApplicationEndpointsRequest, ListAiApplicationEndpointsResponse, Endpoint>
            context,
        @Nullable ListAiApplicationEndpointsResponse response) {
      super(context, response);
    }

    private static ListAiApplicationEndpointsPage createEmptyPage() {
      return new ListAiApplicationEndpointsPage(null, null);
    }

    @Override
    protected ListAiApplicationEndpointsPage createPage(
        @Nullable
            PageContext<
                ListAiApplicationEndpointsRequest, ListAiApplicationEndpointsResponse, Endpoint>
            context,
        @Nullable ListAiApplicationEndpointsResponse response) {
      return new ListAiApplicationEndpointsPage(context, response);
    }

    @Override
    public ApiFuture<ListAiApplicationEndpointsPage> createPageAsync(
        @Nullable
            PageContext<
                ListAiApplicationEndpointsRequest, ListAiApplicationEndpointsResponse, Endpoint>
            context,
        ApiFuture<ListAiApplicationEndpointsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAiApplicationEndpointsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAiApplicationEndpointsRequest,
          ListAiApplicationEndpointsResponse,
          Endpoint,
          ListAiApplicationEndpointsPage,
          ListAiApplicationEndpointsFixedSizeCollection> {

    private ListAiApplicationEndpointsFixedSizeCollection(
        @Nullable List<ListAiApplicationEndpointsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAiApplicationEndpointsFixedSizeCollection createEmptyCollection() {
      return new ListAiApplicationEndpointsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAiApplicationEndpointsFixedSizeCollection createCollection(
        @Nullable List<ListAiApplicationEndpointsPage> pages, int collectionSize) {
      return new ListAiApplicationEndpointsFixedSizeCollection(pages, collectionSize);
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
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        @Nullable ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        @Nullable PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
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

    private ListLocationsFixedSizeCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        @Nullable List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
