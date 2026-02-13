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

package com.google.cloud.ces.v1;

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
import com.google.cloud.ces.v1.stub.AgentServiceStub;
import com.google.cloud.ces.v1.stub.AgentServiceStubSettings;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The service that manages agent-related resources in Gemini Enterprise for
 * Customer Engagement (CES).
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
 * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
 *   AppName name = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
 *   App response = agentServiceClient.getApp(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AgentServiceClient object to clean up resources such
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
 *      <td><p> ListApps</td>
 *      <td><p> Lists apps in the given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listApps(ListAppsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listApps(LocationName parent)
 *           <li><p> listApps(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAppsPagedCallable()
 *           <li><p> listAppsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetApp</td>
 *      <td><p> Gets details of the specified app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getApp(GetAppRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getApp(AppName name)
 *           <li><p> getApp(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAppCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateApp</td>
 *      <td><p> Creates a new app in the given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAppAsync(CreateAppRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createAppAsync(LocationName parent, App app)
 *           <li><p> createAppAsync(String parent, App app)
 *           <li><p> createAppAsync(LocationName parent, App app, String appId)
 *           <li><p> createAppAsync(String parent, App app, String appId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAppOperationCallable()
 *           <li><p> createAppCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateApp</td>
 *      <td><p> Updates the specified app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateApp(UpdateAppRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateApp(App app, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAppCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteApp</td>
 *      <td><p> Deletes the specified app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAppAsync(DeleteAppRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAppAsync(AppName name)
 *           <li><p> deleteAppAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAppOperationCallable()
 *           <li><p> deleteAppCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportApp</td>
 *      <td><p> Exports the specified app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportAppAsync(ExportAppRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> exportAppAsync(AppName name)
 *           <li><p> exportAppAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportAppOperationCallable()
 *           <li><p> exportAppCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportApp</td>
 *      <td><p> Imports the specified app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importAppAsync(ImportAppRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> importAppAsync(LocationName parent, String displayName, String appId)
 *           <li><p> importAppAsync(String parent, String displayName, String appId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importAppOperationCallable()
 *           <li><p> importAppCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAgents</td>
 *      <td><p> Lists agents in the given app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAgents(ListAgentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAgents(AppName parent)
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
 *      <td><p> GetAgent</td>
 *      <td><p> Gets details of the specified agent.</td>
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
 *      <td><p> CreateAgent</td>
 *      <td><p> Creates a new agent in the given app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAgent(CreateAgentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createAgent(AppName parent, Agent agent)
 *           <li><p> createAgent(String parent, Agent agent)
 *           <li><p> createAgent(AppName parent, Agent agent, String agentId)
 *           <li><p> createAgent(String parent, Agent agent, String agentId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAgentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAgent</td>
 *      <td><p> Updates the specified agent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAgent(UpdateAgentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateAgent(Agent agent, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAgentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAgent</td>
 *      <td><p> Deletes the specified agent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAgent(DeleteAgentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteAgent(AgentName name)
 *           <li><p> deleteAgent(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAgentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListExamples</td>
 *      <td><p> Lists examples in the given app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listExamples(ListExamplesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listExamples(AppName parent)
 *           <li><p> listExamples(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listExamplesPagedCallable()
 *           <li><p> listExamplesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetExample</td>
 *      <td><p> Gets details of the specified example.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getExample(GetExampleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getExample(ExampleName name)
 *           <li><p> getExample(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getExampleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateExample</td>
 *      <td><p> Creates a new example in the given app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createExample(CreateExampleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createExample(AppName parent, Example example)
 *           <li><p> createExample(String parent, Example example)
 *           <li><p> createExample(AppName parent, Example example, String exampleId)
 *           <li><p> createExample(String parent, Example example, String exampleId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createExampleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateExample</td>
 *      <td><p> Updates the specified example.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateExample(UpdateExampleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateExample(Example example, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateExampleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteExample</td>
 *      <td><p> Deletes the specified example.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteExample(DeleteExampleRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteExample(ExampleName name)
 *           <li><p> deleteExample(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteExampleCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTools</td>
 *      <td><p> Lists tools in the given app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTools(ListToolsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTools(AppName parent)
 *           <li><p> listTools(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listToolsPagedCallable()
 *           <li><p> listToolsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTool</td>
 *      <td><p> Gets details of the specified tool.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTool(GetToolRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTool(ToolName name)
 *           <li><p> getTool(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getToolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListConversations</td>
 *      <td><p> Lists conversations in the given app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listConversations(ListConversationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listConversations(AppName parent)
 *           <li><p> listConversations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listConversationsPagedCallable()
 *           <li><p> listConversationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetConversation</td>
 *      <td><p> Gets details of the specified conversation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getConversation(GetConversationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getConversation(ConversationName name)
 *           <li><p> getConversation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getConversationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteConversation</td>
 *      <td><p> Deletes the specified conversation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteConversation(DeleteConversationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteConversation(ConversationName name)
 *           <li><p> deleteConversation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteConversationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeleteConversations</td>
 *      <td><p> Batch deletes the specified conversations.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeleteConversationsAsync(BatchDeleteConversationsRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> batchDeleteConversationsAsync(AppName parent)
 *           <li><p> batchDeleteConversationsAsync(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeleteConversationsOperationCallable()
 *           <li><p> batchDeleteConversationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTool</td>
 *      <td><p> Creates a new tool in the given app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTool(CreateToolRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createTool(AppName parent, Tool tool)
 *           <li><p> createTool(String parent, Tool tool)
 *           <li><p> createTool(AppName parent, Tool tool, String toolId)
 *           <li><p> createTool(String parent, Tool tool, String toolId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createToolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTool</td>
 *      <td><p> Updates the specified tool.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTool(UpdateToolRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateTool(Tool tool, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateToolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTool</td>
 *      <td><p> Deletes the specified tool.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTool(DeleteToolRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteTool(ToolName name)
 *           <li><p> deleteTool(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteToolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListGuardrails</td>
 *      <td><p> Lists guardrails in the given app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listGuardrails(ListGuardrailsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listGuardrails(AppName parent)
 *           <li><p> listGuardrails(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listGuardrailsPagedCallable()
 *           <li><p> listGuardrailsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetGuardrail</td>
 *      <td><p> Gets details of the specified guardrail.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getGuardrail(GetGuardrailRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getGuardrail(GuardrailName name)
 *           <li><p> getGuardrail(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getGuardrailCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateGuardrail</td>
 *      <td><p> Creates a new guardrail in the given app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createGuardrail(CreateGuardrailRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createGuardrail(AppName parent, Guardrail guardrail)
 *           <li><p> createGuardrail(String parent, Guardrail guardrail)
 *           <li><p> createGuardrail(AppName parent, Guardrail guardrail, String guardrailId)
 *           <li><p> createGuardrail(String parent, Guardrail guardrail, String guardrailId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createGuardrailCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateGuardrail</td>
 *      <td><p> Updates the specified guardrail.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateGuardrail(UpdateGuardrailRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateGuardrail(Guardrail guardrail, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateGuardrailCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteGuardrail</td>
 *      <td><p> Deletes the specified guardrail.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteGuardrail(DeleteGuardrailRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteGuardrail(GuardrailName name)
 *           <li><p> deleteGuardrail(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteGuardrailCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDeployments</td>
 *      <td><p> Lists deployments in the given app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDeployments(ListDeploymentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDeployments(AppName parent)
 *           <li><p> listDeployments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDeploymentsPagedCallable()
 *           <li><p> listDeploymentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDeployment</td>
 *      <td><p> Gets details of the specified deployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDeployment(GetDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDeployment(DeploymentName name)
 *           <li><p> getDeployment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDeployment</td>
 *      <td><p> Creates a new deployment in the given app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDeployment(CreateDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createDeployment(AppName parent, Deployment deployment)
 *           <li><p> createDeployment(String parent, Deployment deployment)
 *           <li><p> createDeployment(AppName parent, Deployment deployment, String deploymentId)
 *           <li><p> createDeployment(String parent, Deployment deployment, String deploymentId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDeployment</td>
 *      <td><p> Updates the specified deployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDeployment(UpdateDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDeployment(Deployment deployment, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDeployment</td>
 *      <td><p> Deletes the specified deployment.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDeployment(DeleteDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteDeployment(DeploymentName name)
 *           <li><p> deleteDeployment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListToolsets</td>
 *      <td><p> Lists toolsets in the given app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listToolsets(ListToolsetsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listToolsets(AppName parent)
 *           <li><p> listToolsets(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listToolsetsPagedCallable()
 *           <li><p> listToolsetsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetToolset</td>
 *      <td><p> Gets details of the specified toolset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getToolset(GetToolsetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getToolset(ToolsetName name)
 *           <li><p> getToolset(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getToolsetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateToolset</td>
 *      <td><p> Creates a new toolset in the given app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createToolset(CreateToolsetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createToolset(AppName parent, Toolset toolset)
 *           <li><p> createToolset(String parent, Toolset toolset)
 *           <li><p> createToolset(AppName parent, Toolset toolset, String toolsetId)
 *           <li><p> createToolset(String parent, Toolset toolset, String toolsetId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createToolsetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateToolset</td>
 *      <td><p> Updates the specified toolset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateToolset(UpdateToolsetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateToolset(Toolset toolset, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateToolsetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteToolset</td>
 *      <td><p> Deletes the specified toolset.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteToolset(DeleteToolsetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteToolset(ToolsetName name)
 *           <li><p> deleteToolset(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteToolsetCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAppVersions</td>
 *      <td><p> Lists all app versions in the given app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAppVersions(ListAppVersionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAppVersions(AppName parent)
 *           <li><p> listAppVersions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAppVersionsPagedCallable()
 *           <li><p> listAppVersionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAppVersion</td>
 *      <td><p> Gets details of the specified app version.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAppVersion(GetAppVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAppVersion(AppVersionName name)
 *           <li><p> getAppVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAppVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAppVersion</td>
 *      <td><p> Creates a new app version in the given app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAppVersion(CreateAppVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createAppVersion(AppName parent, AppVersion appVersion)
 *           <li><p> createAppVersion(String parent, AppVersion appVersion)
 *           <li><p> createAppVersion(AppName parent, AppVersion appVersion, String appVersionId)
 *           <li><p> createAppVersion(String parent, AppVersion appVersion, String appVersionId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAppVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAppVersion</td>
 *      <td><p> Deletes the specified app version.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAppVersion(DeleteAppVersionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteAppVersion(AppVersionName name)
 *           <li><p> deleteAppVersion(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAppVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RestoreAppVersion</td>
 *      <td><p> Restores the specified app version. This will create a new app version from the current draft app and overwrite the current draft with the specified app version.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> restoreAppVersionAsync(RestoreAppVersionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> restoreAppVersionAsync(AppVersionName name)
 *           <li><p> restoreAppVersionAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> restoreAppVersionOperationCallable()
 *           <li><p> restoreAppVersionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListChangelogs</td>
 *      <td><p> Lists the changelogs of the specified app.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listChangelogs(ListChangelogsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listChangelogs(AppName parent)
 *           <li><p> listChangelogs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listChangelogsPagedCallable()
 *           <li><p> listChangelogsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetChangelog</td>
 *      <td><p> Gets the specified changelog.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getChangelog(GetChangelogRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getChangelog(ChangelogName name)
 *           <li><p> getChangelog(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getChangelogCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.This method can be called in two ways:
 * <p> &#42;   &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;   &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or other locations specifically visibleto the project.</td>
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
 * <p>This class can be customized by passing in a custom instance of AgentServiceSettings to
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
 * AgentServiceSettings agentServiceSettings =
 *     AgentServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AgentServiceClient agentServiceClient = AgentServiceClient.create(agentServiceSettings);
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
 * AgentServiceSettings agentServiceSettings =
 *     AgentServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AgentServiceClient agentServiceClient = AgentServiceClient.create(agentServiceSettings);
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
 * AgentServiceSettings agentServiceSettings = AgentServiceSettings.newHttpJsonBuilder().build();
 * AgentServiceClient agentServiceClient = AgentServiceClient.create(agentServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AgentServiceClient implements BackgroundResource {
  private final AgentServiceSettings settings;
  private final AgentServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of AgentServiceClient with default settings. */
  public static final AgentServiceClient create() throws IOException {
    return create(AgentServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AgentServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AgentServiceClient create(AgentServiceSettings settings) throws IOException {
    return new AgentServiceClient(settings);
  }

  /**
   * Constructs an instance of AgentServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(AgentServiceSettings).
   */
  public static final AgentServiceClient create(AgentServiceStub stub) {
    return new AgentServiceClient(stub);
  }

  /**
   * Constructs an instance of AgentServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AgentServiceClient(AgentServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AgentServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected AgentServiceClient(AgentServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final AgentServiceSettings getSettings() {
    return settings;
  }

  public AgentServiceStub getStub() {
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
   * Lists apps in the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (App element : agentServiceClient.listApps(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to list apps from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAppsPagedResponse listApps(LocationName parent) {
    ListAppsRequest request =
        ListAppsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listApps(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists apps in the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (App element : agentServiceClient.listApps(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to list apps from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAppsPagedResponse listApps(String parent) {
    ListAppsRequest request = ListAppsRequest.newBuilder().setParent(parent).build();
    return listApps(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists apps in the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListAppsRequest request =
   *       ListAppsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (App element : agentServiceClient.listApps(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAppsPagedResponse listApps(ListAppsRequest request) {
    return listAppsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists apps in the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListAppsRequest request =
   *       ListAppsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<App> future = agentServiceClient.listAppsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (App element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAppsRequest, ListAppsPagedResponse> listAppsPagedCallable() {
    return stub.listAppsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists apps in the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListAppsRequest request =
   *       ListAppsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListAppsResponse response = agentServiceClient.listAppsCallable().call(request);
   *     for (App element : response.getAppsList()) {
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
  public final UnaryCallable<ListAppsRequest, ListAppsResponse> listAppsCallable() {
    return stub.listAppsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName name = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   App response = agentServiceClient.getApp(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the app to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final App getApp(AppName name) {
    GetAppRequest request =
        GetAppRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getApp(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String name = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   App response = agentServiceClient.getApp(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the app to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final App getApp(String name) {
    GetAppRequest request = GetAppRequest.newBuilder().setName(name).build();
    return getApp(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GetAppRequest request =
   *       GetAppRequest.newBuilder()
   *           .setName(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .build();
   *   App response = agentServiceClient.getApp(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final App getApp(GetAppRequest request) {
    return getAppCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GetAppRequest request =
   *       GetAppRequest.newBuilder()
   *           .setName(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .build();
   *   ApiFuture<App> future = agentServiceClient.getAppCallable().futureCall(request);
   *   // Do something.
   *   App response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAppRequest, App> getAppCallable() {
    return stub.getAppCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new app in the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   App app = App.newBuilder().build();
   *   App response = agentServiceClient.createAppAsync(parent, app).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to create an app in.
   * @param app Required. The app to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<App, OperationMetadata> createAppAsync(
      LocationName parent, App app) {
    CreateAppRequest request =
        CreateAppRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setApp(app)
            .build();
    return createAppAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new app in the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   App app = App.newBuilder().build();
   *   App response = agentServiceClient.createAppAsync(parent, app).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to create an app in.
   * @param app Required. The app to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<App, OperationMetadata> createAppAsync(String parent, App app) {
    CreateAppRequest request = CreateAppRequest.newBuilder().setParent(parent).setApp(app).build();
    return createAppAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new app in the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   App app = App.newBuilder().build();
   *   String appId = "appId93028124";
   *   App response = agentServiceClient.createAppAsync(parent, app, appId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to create an app in.
   * @param app Required. The app to create.
   * @param appId Optional. The ID to use for the app, which will become the final component of the
   *     app's resource name. If not provided, a unique ID will be automatically assigned for the
   *     app.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<App, OperationMetadata> createAppAsync(
      LocationName parent, App app, String appId) {
    CreateAppRequest request =
        CreateAppRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setApp(app)
            .setAppId(appId)
            .build();
    return createAppAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new app in the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   App app = App.newBuilder().build();
   *   String appId = "appId93028124";
   *   App response = agentServiceClient.createAppAsync(parent, app, appId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the location to create an app in.
   * @param app Required. The app to create.
   * @param appId Optional. The ID to use for the app, which will become the final component of the
   *     app's resource name. If not provided, a unique ID will be automatically assigned for the
   *     app.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<App, OperationMetadata> createAppAsync(
      String parent, App app, String appId) {
    CreateAppRequest request =
        CreateAppRequest.newBuilder().setParent(parent).setApp(app).setAppId(appId).build();
    return createAppAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new app in the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   CreateAppRequest request =
   *       CreateAppRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAppId("appId93028124")
   *           .setApp(App.newBuilder().build())
   *           .build();
   *   App response = agentServiceClient.createAppAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<App, OperationMetadata> createAppAsync(CreateAppRequest request) {
    return createAppOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new app in the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   CreateAppRequest request =
   *       CreateAppRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAppId("appId93028124")
   *           .setApp(App.newBuilder().build())
   *           .build();
   *   OperationFuture<App, OperationMetadata> future =
   *       agentServiceClient.createAppOperationCallable().futureCall(request);
   *   // Do something.
   *   App response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateAppRequest, App, OperationMetadata>
      createAppOperationCallable() {
    return stub.createAppOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new app in the given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   CreateAppRequest request =
   *       CreateAppRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAppId("appId93028124")
   *           .setApp(App.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = agentServiceClient.createAppCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAppRequest, Operation> createAppCallable() {
    return stub.createAppCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   App app = App.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   App response = agentServiceClient.updateApp(app, updateMask);
   * }
   * }</pre>
   *
   * @param app Required. The app to update.
   * @param updateMask Optional. Field mask is used to control which fields get updated. If the mask
   *     is not present, all fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final App updateApp(App app, FieldMask updateMask) {
    UpdateAppRequest request =
        UpdateAppRequest.newBuilder().setApp(app).setUpdateMask(updateMask).build();
    return updateApp(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   UpdateAppRequest request =
   *       UpdateAppRequest.newBuilder()
   *           .setApp(App.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   App response = agentServiceClient.updateApp(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final App updateApp(UpdateAppRequest request) {
    return updateAppCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   UpdateAppRequest request =
   *       UpdateAppRequest.newBuilder()
   *           .setApp(App.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<App> future = agentServiceClient.updateAppCallable().futureCall(request);
   *   // Do something.
   *   App response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAppRequest, App> updateAppCallable() {
    return stub.updateAppCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName name = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   agentServiceClient.deleteAppAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the app to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAppAsync(AppName name) {
    DeleteAppRequest request =
        DeleteAppRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteAppAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String name = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   agentServiceClient.deleteAppAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the app to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAppAsync(String name) {
    DeleteAppRequest request = DeleteAppRequest.newBuilder().setName(name).build();
    return deleteAppAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   DeleteAppRequest request =
   *       DeleteAppRequest.newBuilder()
   *           .setName(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   agentServiceClient.deleteAppAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteAppAsync(DeleteAppRequest request) {
    return deleteAppOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   DeleteAppRequest request =
   *       DeleteAppRequest.newBuilder()
   *           .setName(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       agentServiceClient.deleteAppOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteAppRequest, Empty, OperationMetadata>
      deleteAppOperationCallable() {
    return stub.deleteAppOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   DeleteAppRequest request =
   *       DeleteAppRequest.newBuilder()
   *           .setName(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future = agentServiceClient.deleteAppCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAppRequest, Operation> deleteAppCallable() {
    return stub.deleteAppCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName name = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   ExportAppResponse response = agentServiceClient.exportAppAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the app to export.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportAppResponse, OperationMetadata> exportAppAsync(AppName name) {
    ExportAppRequest request =
        ExportAppRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return exportAppAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String name = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   ExportAppResponse response = agentServiceClient.exportAppAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the app to export.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportAppResponse, OperationMetadata> exportAppAsync(String name) {
    ExportAppRequest request = ExportAppRequest.newBuilder().setName(name).build();
    return exportAppAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ExportAppRequest request =
   *       ExportAppRequest.newBuilder()
   *           .setName(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setGcsUri("gcsUri-1251224875")
   *           .build();
   *   ExportAppResponse response = agentServiceClient.exportAppAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportAppResponse, OperationMetadata> exportAppAsync(
      ExportAppRequest request) {
    return exportAppOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ExportAppRequest request =
   *       ExportAppRequest.newBuilder()
   *           .setName(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setGcsUri("gcsUri-1251224875")
   *           .build();
   *   OperationFuture<ExportAppResponse, OperationMetadata> future =
   *       agentServiceClient.exportAppOperationCallable().futureCall(request);
   *   // Do something.
   *   ExportAppResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ExportAppRequest, ExportAppResponse, OperationMetadata>
      exportAppOperationCallable() {
    return stub.exportAppOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ExportAppRequest request =
   *       ExportAppRequest.newBuilder()
   *           .setName(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setGcsUri("gcsUri-1251224875")
   *           .build();
   *   ApiFuture<Operation> future = agentServiceClient.exportAppCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportAppRequest, Operation> exportAppCallable() {
    return stub.exportAppCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String displayName = "displayName1714148973";
   *   String appId = "appId93028124";
   *   ImportAppResponse response =
   *       agentServiceClient.importAppAsync(parent, displayName, appId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name with the location of the app to import.
   * @param displayName Optional. The display name of the app to import.
   *     <ul>
   *       <li>If the app is created on import, and the display name is specified, the imported app
   *           will use this display name. If a conflict is detected with an existing app, a
   *           timestamp will be appended to the display name to make it unique.
   *       <li>If the app is a reimport, this field should not be set. Providing a display name
   *           during reimport will result in an INVALID_ARGUMENT error.
   *     </ul>
   *
   * @param appId Optional. The ID to use for the imported app.
   *     <ul>
   *       <li>If not specified, a unique ID will be automatically assigned for the app.
   *       <li>Otherwise, the imported app will use this ID as the final component of its resource
   *           name. If an app with the same ID already exists at the specified location in the
   *           project, the content of the existing app will be replaced.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportAppResponse, OperationMetadata> importAppAsync(
      LocationName parent, String displayName, String appId) {
    ImportAppRequest request =
        ImportAppRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDisplayName(displayName)
            .setAppId(appId)
            .build();
    return importAppAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String displayName = "displayName1714148973";
   *   String appId = "appId93028124";
   *   ImportAppResponse response =
   *       agentServiceClient.importAppAsync(parent, displayName, appId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name with the location of the app to import.
   * @param displayName Optional. The display name of the app to import.
   *     <ul>
   *       <li>If the app is created on import, and the display name is specified, the imported app
   *           will use this display name. If a conflict is detected with an existing app, a
   *           timestamp will be appended to the display name to make it unique.
   *       <li>If the app is a reimport, this field should not be set. Providing a display name
   *           during reimport will result in an INVALID_ARGUMENT error.
   *     </ul>
   *
   * @param appId Optional. The ID to use for the imported app.
   *     <ul>
   *       <li>If not specified, a unique ID will be automatically assigned for the app.
   *       <li>Otherwise, the imported app will use this ID as the final component of its resource
   *           name. If an app with the same ID already exists at the specified location in the
   *           project, the content of the existing app will be replaced.
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportAppResponse, OperationMetadata> importAppAsync(
      String parent, String displayName, String appId) {
    ImportAppRequest request =
        ImportAppRequest.newBuilder()
            .setParent(parent)
            .setDisplayName(displayName)
            .setAppId(appId)
            .build();
    return importAppAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ImportAppRequest request =
   *       ImportAppRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDisplayName("displayName1714148973")
   *           .setAppId("appId93028124")
   *           .setImportOptions(ImportAppRequest.ImportOptions.newBuilder().build())
   *           .setIgnoreAppLock(true)
   *           .build();
   *   ImportAppResponse response = agentServiceClient.importAppAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ImportAppResponse, OperationMetadata> importAppAsync(
      ImportAppRequest request) {
    return importAppOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ImportAppRequest request =
   *       ImportAppRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDisplayName("displayName1714148973")
   *           .setAppId("appId93028124")
   *           .setImportOptions(ImportAppRequest.ImportOptions.newBuilder().build())
   *           .setIgnoreAppLock(true)
   *           .build();
   *   OperationFuture<ImportAppResponse, OperationMetadata> future =
   *       agentServiceClient.importAppOperationCallable().futureCall(request);
   *   // Do something.
   *   ImportAppResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ImportAppRequest, ImportAppResponse, OperationMetadata>
      importAppOperationCallable() {
    return stub.importAppOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ImportAppRequest request =
   *       ImportAppRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDisplayName("displayName1714148973")
   *           .setAppId("appId93028124")
   *           .setImportOptions(ImportAppRequest.ImportOptions.newBuilder().build())
   *           .setIgnoreAppLock(true)
   *           .build();
   *   ApiFuture<Operation> future = agentServiceClient.importAppCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportAppRequest, Operation> importAppCallable() {
    return stub.importAppCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists agents in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   for (Agent element : agentServiceClient.listAgents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list agents from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAgentsPagedResponse listAgents(AppName parent) {
    ListAgentsRequest request =
        ListAgentsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listAgents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists agents in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   for (Agent element : agentServiceClient.listAgents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list agents from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAgentsPagedResponse listAgents(String parent) {
    ListAgentsRequest request = ListAgentsRequest.newBuilder().setParent(parent).build();
    return listAgents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists agents in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListAgentsRequest request =
   *       ListAgentsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Agent element : agentServiceClient.listAgents(request).iterateAll()) {
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
   * Lists agents in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListAgentsRequest request =
   *       ListAgentsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Agent> future = agentServiceClient.listAgentsPagedCallable().futureCall(request);
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
   * Lists agents in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListAgentsRequest request =
   *       ListAgentsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListAgentsResponse response = agentServiceClient.listAgentsCallable().call(request);
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
   * Gets details of the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AgentName name = AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]");
   *   Agent response = agentServiceClient.getAgent(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the agent to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Agent getAgent(AgentName name) {
    GetAgentRequest request =
        GetAgentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String name = AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString();
   *   Agent response = agentServiceClient.getAgent(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the agent to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Agent getAgent(String name) {
    GetAgentRequest request = GetAgentRequest.newBuilder().setName(name).build();
    return getAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GetAgentRequest request =
   *       GetAgentRequest.newBuilder()
   *           .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
   *           .build();
   *   Agent response = agentServiceClient.getAgent(request);
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
   * Gets details of the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GetAgentRequest request =
   *       GetAgentRequest.newBuilder()
   *           .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
   *           .build();
   *   ApiFuture<Agent> future = agentServiceClient.getAgentCallable().futureCall(request);
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
   * Creates a new agent in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   Agent agent = Agent.newBuilder().build();
   *   Agent response = agentServiceClient.createAgent(parent, agent);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create an agent in.
   * @param agent Required. The agent to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Agent createAgent(AppName parent, Agent agent) {
    CreateAgentRequest request =
        CreateAgentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAgent(agent)
            .build();
    return createAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new agent in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   Agent agent = Agent.newBuilder().build();
   *   Agent response = agentServiceClient.createAgent(parent, agent);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create an agent in.
   * @param agent Required. The agent to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Agent createAgent(String parent, Agent agent) {
    CreateAgentRequest request =
        CreateAgentRequest.newBuilder().setParent(parent).setAgent(agent).build();
    return createAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new agent in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   Agent agent = Agent.newBuilder().build();
   *   String agentId = "agentId-1060987136";
   *   Agent response = agentServiceClient.createAgent(parent, agent, agentId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create an agent in.
   * @param agent Required. The agent to create.
   * @param agentId Optional. The ID to use for the agent, which will become the final component of
   *     the agent's resource name. If not provided, a unique ID will be automatically assigned for
   *     the agent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Agent createAgent(AppName parent, Agent agent, String agentId) {
    CreateAgentRequest request =
        CreateAgentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAgent(agent)
            .setAgentId(agentId)
            .build();
    return createAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new agent in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   Agent agent = Agent.newBuilder().build();
   *   String agentId = "agentId-1060987136";
   *   Agent response = agentServiceClient.createAgent(parent, agent, agentId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create an agent in.
   * @param agent Required. The agent to create.
   * @param agentId Optional. The ID to use for the agent, which will become the final component of
   *     the agent's resource name. If not provided, a unique ID will be automatically assigned for
   *     the agent.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Agent createAgent(String parent, Agent agent, String agentId) {
    CreateAgentRequest request =
        CreateAgentRequest.newBuilder()
            .setParent(parent)
            .setAgent(agent)
            .setAgentId(agentId)
            .build();
    return createAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new agent in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   CreateAgentRequest request =
   *       CreateAgentRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setAgentId("agentId-1060987136")
   *           .setAgent(Agent.newBuilder().build())
   *           .build();
   *   Agent response = agentServiceClient.createAgent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Agent createAgent(CreateAgentRequest request) {
    return createAgentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new agent in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   CreateAgentRequest request =
   *       CreateAgentRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setAgentId("agentId-1060987136")
   *           .setAgent(Agent.newBuilder().build())
   *           .build();
   *   ApiFuture<Agent> future = agentServiceClient.createAgentCallable().futureCall(request);
   *   // Do something.
   *   Agent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAgentRequest, Agent> createAgentCallable() {
    return stub.createAgentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   Agent agent = Agent.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Agent response = agentServiceClient.updateAgent(agent, updateMask);
   * }
   * }</pre>
   *
   * @param agent Required. The agent to update.
   * @param updateMask Optional. Field mask is used to control which fields get updated. If the mask
   *     is not present, all fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Agent updateAgent(Agent agent, FieldMask updateMask) {
    UpdateAgentRequest request =
        UpdateAgentRequest.newBuilder().setAgent(agent).setUpdateMask(updateMask).build();
    return updateAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   UpdateAgentRequest request =
   *       UpdateAgentRequest.newBuilder()
   *           .setAgent(Agent.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Agent response = agentServiceClient.updateAgent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Agent updateAgent(UpdateAgentRequest request) {
    return updateAgentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   UpdateAgentRequest request =
   *       UpdateAgentRequest.newBuilder()
   *           .setAgent(Agent.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Agent> future = agentServiceClient.updateAgentCallable().futureCall(request);
   *   // Do something.
   *   Agent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAgentRequest, Agent> updateAgentCallable() {
    return stub.updateAgentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AgentName name = AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]");
   *   agentServiceClient.deleteAgent(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the agent to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAgent(AgentName name) {
    DeleteAgentRequest request =
        DeleteAgentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String name = AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString();
   *   agentServiceClient.deleteAgent(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the agent to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAgent(String name) {
    DeleteAgentRequest request = DeleteAgentRequest.newBuilder().setName(name).build();
    deleteAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   DeleteAgentRequest request =
   *       DeleteAgentRequest.newBuilder()
   *           .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
   *           .setForce(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   agentServiceClient.deleteAgent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAgent(DeleteAgentRequest request) {
    deleteAgentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   DeleteAgentRequest request =
   *       DeleteAgentRequest.newBuilder()
   *           .setName(AgentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[AGENT]").toString())
   *           .setForce(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Empty> future = agentServiceClient.deleteAgentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAgentRequest, Empty> deleteAgentCallable() {
    return stub.deleteAgentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists examples in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   for (Example element : agentServiceClient.listExamples(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list examples from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExamplesPagedResponse listExamples(AppName parent) {
    ListExamplesRequest request =
        ListExamplesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listExamples(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists examples in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   for (Example element : agentServiceClient.listExamples(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list examples from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExamplesPagedResponse listExamples(String parent) {
    ListExamplesRequest request = ListExamplesRequest.newBuilder().setParent(parent).build();
    return listExamples(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists examples in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListExamplesRequest request =
   *       ListExamplesRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Example element : agentServiceClient.listExamples(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExamplesPagedResponse listExamples(ListExamplesRequest request) {
    return listExamplesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists examples in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListExamplesRequest request =
   *       ListExamplesRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Example> future =
   *       agentServiceClient.listExamplesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Example element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListExamplesRequest, ListExamplesPagedResponse>
      listExamplesPagedCallable() {
    return stub.listExamplesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists examples in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListExamplesRequest request =
   *       ListExamplesRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListExamplesResponse response = agentServiceClient.listExamplesCallable().call(request);
   *     for (Example element : response.getExamplesList()) {
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
  public final UnaryCallable<ListExamplesRequest, ListExamplesResponse> listExamplesCallable() {
    return stub.listExamplesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified example.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ExampleName name = ExampleName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EXAMPLE]");
   *   Example response = agentServiceClient.getExample(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the example to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Example getExample(ExampleName name) {
    GetExampleRequest request =
        GetExampleRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getExample(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified example.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String name = ExampleName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EXAMPLE]").toString();
   *   Example response = agentServiceClient.getExample(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the example to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Example getExample(String name) {
    GetExampleRequest request = GetExampleRequest.newBuilder().setName(name).build();
    return getExample(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified example.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GetExampleRequest request =
   *       GetExampleRequest.newBuilder()
   *           .setName(ExampleName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EXAMPLE]").toString())
   *           .build();
   *   Example response = agentServiceClient.getExample(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Example getExample(GetExampleRequest request) {
    return getExampleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified example.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GetExampleRequest request =
   *       GetExampleRequest.newBuilder()
   *           .setName(ExampleName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EXAMPLE]").toString())
   *           .build();
   *   ApiFuture<Example> future = agentServiceClient.getExampleCallable().futureCall(request);
   *   // Do something.
   *   Example response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetExampleRequest, Example> getExampleCallable() {
    return stub.getExampleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new example in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   Example example = Example.newBuilder().build();
   *   Example response = agentServiceClient.createExample(parent, example);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create an example in.
   * @param example Required. The example to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Example createExample(AppName parent, Example example) {
    CreateExampleRequest request =
        CreateExampleRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setExample(example)
            .build();
    return createExample(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new example in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   Example example = Example.newBuilder().build();
   *   Example response = agentServiceClient.createExample(parent, example);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create an example in.
   * @param example Required. The example to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Example createExample(String parent, Example example) {
    CreateExampleRequest request =
        CreateExampleRequest.newBuilder().setParent(parent).setExample(example).build();
    return createExample(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new example in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   Example example = Example.newBuilder().build();
   *   String exampleId = "exampleId-64591835";
   *   Example response = agentServiceClient.createExample(parent, example, exampleId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create an example in.
   * @param example Required. The example to create.
   * @param exampleId Optional. The ID to use for the example, which will become the final component
   *     of the example's resource name. If not provided, a unique ID will be automatically assigned
   *     for the example.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Example createExample(AppName parent, Example example, String exampleId) {
    CreateExampleRequest request =
        CreateExampleRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setExample(example)
            .setExampleId(exampleId)
            .build();
    return createExample(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new example in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   Example example = Example.newBuilder().build();
   *   String exampleId = "exampleId-64591835";
   *   Example response = agentServiceClient.createExample(parent, example, exampleId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create an example in.
   * @param example Required. The example to create.
   * @param exampleId Optional. The ID to use for the example, which will become the final component
   *     of the example's resource name. If not provided, a unique ID will be automatically assigned
   *     for the example.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Example createExample(String parent, Example example, String exampleId) {
    CreateExampleRequest request =
        CreateExampleRequest.newBuilder()
            .setParent(parent)
            .setExample(example)
            .setExampleId(exampleId)
            .build();
    return createExample(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new example in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   CreateExampleRequest request =
   *       CreateExampleRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setExampleId("exampleId-64591835")
   *           .setExample(Example.newBuilder().build())
   *           .build();
   *   Example response = agentServiceClient.createExample(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Example createExample(CreateExampleRequest request) {
    return createExampleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new example in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   CreateExampleRequest request =
   *       CreateExampleRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setExampleId("exampleId-64591835")
   *           .setExample(Example.newBuilder().build())
   *           .build();
   *   ApiFuture<Example> future = agentServiceClient.createExampleCallable().futureCall(request);
   *   // Do something.
   *   Example response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateExampleRequest, Example> createExampleCallable() {
    return stub.createExampleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified example.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   Example example = Example.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Example response = agentServiceClient.updateExample(example, updateMask);
   * }
   * }</pre>
   *
   * @param example Required. The example to update.
   * @param updateMask Optional. Field mask is used to control which fields get updated. If the mask
   *     is not present, all fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Example updateExample(Example example, FieldMask updateMask) {
    UpdateExampleRequest request =
        UpdateExampleRequest.newBuilder().setExample(example).setUpdateMask(updateMask).build();
    return updateExample(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified example.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   UpdateExampleRequest request =
   *       UpdateExampleRequest.newBuilder()
   *           .setExample(Example.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Example response = agentServiceClient.updateExample(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Example updateExample(UpdateExampleRequest request) {
    return updateExampleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified example.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   UpdateExampleRequest request =
   *       UpdateExampleRequest.newBuilder()
   *           .setExample(Example.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Example> future = agentServiceClient.updateExampleCallable().futureCall(request);
   *   // Do something.
   *   Example response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateExampleRequest, Example> updateExampleCallable() {
    return stub.updateExampleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified example.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ExampleName name = ExampleName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EXAMPLE]");
   *   agentServiceClient.deleteExample(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the example to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteExample(ExampleName name) {
    DeleteExampleRequest request =
        DeleteExampleRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteExample(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified example.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String name = ExampleName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EXAMPLE]").toString();
   *   agentServiceClient.deleteExample(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the example to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteExample(String name) {
    DeleteExampleRequest request = DeleteExampleRequest.newBuilder().setName(name).build();
    deleteExample(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified example.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   DeleteExampleRequest request =
   *       DeleteExampleRequest.newBuilder()
   *           .setName(ExampleName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EXAMPLE]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   agentServiceClient.deleteExample(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteExample(DeleteExampleRequest request) {
    deleteExampleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified example.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   DeleteExampleRequest request =
   *       DeleteExampleRequest.newBuilder()
   *           .setName(ExampleName.of("[PROJECT]", "[LOCATION]", "[APP]", "[EXAMPLE]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Empty> future = agentServiceClient.deleteExampleCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteExampleRequest, Empty> deleteExampleCallable() {
    return stub.deleteExampleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tools in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   for (Tool element : agentServiceClient.listTools(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list tools from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListToolsPagedResponse listTools(AppName parent) {
    ListToolsRequest request =
        ListToolsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listTools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tools in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   for (Tool element : agentServiceClient.listTools(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list tools from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListToolsPagedResponse listTools(String parent) {
    ListToolsRequest request = ListToolsRequest.newBuilder().setParent(parent).build();
    return listTools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tools in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListToolsRequest request =
   *       ListToolsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Tool element : agentServiceClient.listTools(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListToolsPagedResponse listTools(ListToolsRequest request) {
    return listToolsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tools in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListToolsRequest request =
   *       ListToolsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Tool> future = agentServiceClient.listToolsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Tool element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListToolsRequest, ListToolsPagedResponse> listToolsPagedCallable() {
    return stub.listToolsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tools in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListToolsRequest request =
   *       ListToolsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListToolsResponse response = agentServiceClient.listToolsCallable().call(request);
   *     for (Tool element : response.getToolsList()) {
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
  public final UnaryCallable<ListToolsRequest, ListToolsResponse> listToolsCallable() {
    return stub.listToolsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ToolName name = ToolName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOL]");
   *   Tool response = agentServiceClient.getTool(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the tool to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tool getTool(ToolName name) {
    GetToolRequest request =
        GetToolRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String name = ToolName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOL]").toString();
   *   Tool response = agentServiceClient.getTool(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the tool to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tool getTool(String name) {
    GetToolRequest request = GetToolRequest.newBuilder().setName(name).build();
    return getTool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GetToolRequest request =
   *       GetToolRequest.newBuilder()
   *           .setName(ToolName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOL]").toString())
   *           .build();
   *   Tool response = agentServiceClient.getTool(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tool getTool(GetToolRequest request) {
    return getToolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GetToolRequest request =
   *       GetToolRequest.newBuilder()
   *           .setName(ToolName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOL]").toString())
   *           .build();
   *   ApiFuture<Tool> future = agentServiceClient.getToolCallable().futureCall(request);
   *   // Do something.
   *   Tool response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetToolRequest, Tool> getToolCallable() {
    return stub.getToolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists conversations in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   for (Conversation element : agentServiceClient.listConversations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list conversations from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationsPagedResponse listConversations(AppName parent) {
    ListConversationsRequest request =
        ListConversationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listConversations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists conversations in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   for (Conversation element : agentServiceClient.listConversations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list conversations from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationsPagedResponse listConversations(String parent) {
    ListConversationsRequest request =
        ListConversationsRequest.newBuilder().setParent(parent).build();
    return listConversations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists conversations in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListConversationsRequest request =
   *       ListConversationsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .addAllSources(new ArrayList<Conversation.Source>())
   *           .build();
   *   for (Conversation element : agentServiceClient.listConversations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListConversationsPagedResponse listConversations(ListConversationsRequest request) {
    return listConversationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists conversations in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListConversationsRequest request =
   *       ListConversationsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .addAllSources(new ArrayList<Conversation.Source>())
   *           .build();
   *   ApiFuture<Conversation> future =
   *       agentServiceClient.listConversationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Conversation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListConversationsRequest, ListConversationsPagedResponse>
      listConversationsPagedCallable() {
    return stub.listConversationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists conversations in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListConversationsRequest request =
   *       ListConversationsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .addAllSources(new ArrayList<Conversation.Source>())
   *           .build();
   *   while (true) {
   *     ListConversationsResponse response =
   *         agentServiceClient.listConversationsCallable().call(request);
   *     for (Conversation element : response.getConversationsList()) {
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
  public final UnaryCallable<ListConversationsRequest, ListConversationsResponse>
      listConversationsCallable() {
    return stub.listConversationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ConversationName name =
   *       ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]");
   *   Conversation response = agentServiceClient.getConversation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the conversation to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation getConversation(ConversationName name) {
    GetConversationRequest request =
        GetConversationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String name =
   *       ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]").toString();
   *   Conversation response = agentServiceClient.getConversation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the conversation to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation getConversation(String name) {
    GetConversationRequest request = GetConversationRequest.newBuilder().setName(name).build();
    return getConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GetConversationRequest request =
   *       GetConversationRequest.newBuilder()
   *           .setName(
   *               ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]")
   *                   .toString())
   *           .build();
   *   Conversation response = agentServiceClient.getConversation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Conversation getConversation(GetConversationRequest request) {
    return getConversationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GetConversationRequest request =
   *       GetConversationRequest.newBuilder()
   *           .setName(
   *               ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Conversation> future =
   *       agentServiceClient.getConversationCallable().futureCall(request);
   *   // Do something.
   *   Conversation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetConversationRequest, Conversation> getConversationCallable() {
    return stub.getConversationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ConversationName name =
   *       ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]");
   *   agentServiceClient.deleteConversation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the conversation to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConversation(ConversationName name) {
    DeleteConversationRequest request =
        DeleteConversationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String name =
   *       ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]").toString();
   *   agentServiceClient.deleteConversation(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the conversation to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConversation(String name) {
    DeleteConversationRequest request =
        DeleteConversationRequest.newBuilder().setName(name).build();
    deleteConversation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   DeleteConversationRequest request =
   *       DeleteConversationRequest.newBuilder()
   *           .setName(
   *               ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]")
   *                   .toString())
   *           .build();
   *   agentServiceClient.deleteConversation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteConversation(DeleteConversationRequest request) {
    deleteConversationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified conversation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   DeleteConversationRequest request =
   *       DeleteConversationRequest.newBuilder()
   *           .setName(
   *               ConversationName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CONVERSATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = agentServiceClient.deleteConversationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteConversationRequest, Empty> deleteConversationCallable() {
    return stub.deleteConversationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch deletes the specified conversations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   BatchDeleteConversationsResponse response =
   *       agentServiceClient.batchDeleteConversationsAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to delete conversations from. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchDeleteConversationsResponse, OperationMetadata>
      batchDeleteConversationsAsync(AppName parent) {
    BatchDeleteConversationsRequest request =
        BatchDeleteConversationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return batchDeleteConversationsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch deletes the specified conversations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   BatchDeleteConversationsResponse response =
   *       agentServiceClient.batchDeleteConversationsAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to delete conversations from. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchDeleteConversationsResponse, OperationMetadata>
      batchDeleteConversationsAsync(String parent) {
    BatchDeleteConversationsRequest request =
        BatchDeleteConversationsRequest.newBuilder().setParent(parent).build();
    return batchDeleteConversationsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch deletes the specified conversations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   BatchDeleteConversationsRequest request =
   *       BatchDeleteConversationsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .addAllConversations(new ArrayList<String>())
   *           .build();
   *   BatchDeleteConversationsResponse response =
   *       agentServiceClient.batchDeleteConversationsAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<BatchDeleteConversationsResponse, OperationMetadata>
      batchDeleteConversationsAsync(BatchDeleteConversationsRequest request) {
    return batchDeleteConversationsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch deletes the specified conversations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   BatchDeleteConversationsRequest request =
   *       BatchDeleteConversationsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .addAllConversations(new ArrayList<String>())
   *           .build();
   *   OperationFuture<BatchDeleteConversationsResponse, OperationMetadata> future =
   *       agentServiceClient.batchDeleteConversationsOperationCallable().futureCall(request);
   *   // Do something.
   *   BatchDeleteConversationsResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          BatchDeleteConversationsRequest, BatchDeleteConversationsResponse, OperationMetadata>
      batchDeleteConversationsOperationCallable() {
    return stub.batchDeleteConversationsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch deletes the specified conversations.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   BatchDeleteConversationsRequest request =
   *       BatchDeleteConversationsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .addAllConversations(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       agentServiceClient.batchDeleteConversationsCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeleteConversationsRequest, Operation>
      batchDeleteConversationsCallable() {
    return stub.batchDeleteConversationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new tool in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   Tool tool = Tool.newBuilder().build();
   *   Tool response = agentServiceClient.createTool(parent, tool);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create a tool in.
   * @param tool Required. The tool to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tool createTool(AppName parent, Tool tool) {
    CreateToolRequest request =
        CreateToolRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTool(tool)
            .build();
    return createTool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new tool in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   Tool tool = Tool.newBuilder().build();
   *   Tool response = agentServiceClient.createTool(parent, tool);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create a tool in.
   * @param tool Required. The tool to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tool createTool(String parent, Tool tool) {
    CreateToolRequest request =
        CreateToolRequest.newBuilder().setParent(parent).setTool(tool).build();
    return createTool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new tool in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   Tool tool = Tool.newBuilder().build();
   *   String toolId = "toolId-868061997";
   *   Tool response = agentServiceClient.createTool(parent, tool, toolId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create a tool in.
   * @param tool Required. The tool to create.
   * @param toolId Optional. The ID to use for the tool, which will become the final component of
   *     the tool's resource name. If not provided, a unique ID will be automatically assigned for
   *     the tool.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tool createTool(AppName parent, Tool tool, String toolId) {
    CreateToolRequest request =
        CreateToolRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTool(tool)
            .setToolId(toolId)
            .build();
    return createTool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new tool in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   Tool tool = Tool.newBuilder().build();
   *   String toolId = "toolId-868061997";
   *   Tool response = agentServiceClient.createTool(parent, tool, toolId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create a tool in.
   * @param tool Required. The tool to create.
   * @param toolId Optional. The ID to use for the tool, which will become the final component of
   *     the tool's resource name. If not provided, a unique ID will be automatically assigned for
   *     the tool.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tool createTool(String parent, Tool tool, String toolId) {
    CreateToolRequest request =
        CreateToolRequest.newBuilder().setParent(parent).setTool(tool).setToolId(toolId).build();
    return createTool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new tool in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   CreateToolRequest request =
   *       CreateToolRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setToolId("toolId-868061997")
   *           .setTool(Tool.newBuilder().build())
   *           .build();
   *   Tool response = agentServiceClient.createTool(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tool createTool(CreateToolRequest request) {
    return createToolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new tool in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   CreateToolRequest request =
   *       CreateToolRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setToolId("toolId-868061997")
   *           .setTool(Tool.newBuilder().build())
   *           .build();
   *   ApiFuture<Tool> future = agentServiceClient.createToolCallable().futureCall(request);
   *   // Do something.
   *   Tool response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateToolRequest, Tool> createToolCallable() {
    return stub.createToolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   Tool tool = Tool.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Tool response = agentServiceClient.updateTool(tool, updateMask);
   * }
   * }</pre>
   *
   * @param tool Required. The tool to update.
   * @param updateMask Optional. Field mask is used to control which fields get updated. If the mask
   *     is not present, all fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tool updateTool(Tool tool, FieldMask updateMask) {
    UpdateToolRequest request =
        UpdateToolRequest.newBuilder().setTool(tool).setUpdateMask(updateMask).build();
    return updateTool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   UpdateToolRequest request =
   *       UpdateToolRequest.newBuilder()
   *           .setTool(Tool.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Tool response = agentServiceClient.updateTool(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tool updateTool(UpdateToolRequest request) {
    return updateToolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   UpdateToolRequest request =
   *       UpdateToolRequest.newBuilder()
   *           .setTool(Tool.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Tool> future = agentServiceClient.updateToolCallable().futureCall(request);
   *   // Do something.
   *   Tool response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateToolRequest, Tool> updateToolCallable() {
    return stub.updateToolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ToolName name = ToolName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOL]");
   *   agentServiceClient.deleteTool(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the tool to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTool(ToolName name) {
    DeleteToolRequest request =
        DeleteToolRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteTool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String name = ToolName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOL]").toString();
   *   agentServiceClient.deleteTool(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the tool to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTool(String name) {
    DeleteToolRequest request = DeleteToolRequest.newBuilder().setName(name).build();
    deleteTool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   DeleteToolRequest request =
   *       DeleteToolRequest.newBuilder()
   *           .setName(ToolName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOL]").toString())
   *           .setForce(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   agentServiceClient.deleteTool(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTool(DeleteToolRequest request) {
    deleteToolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified tool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   DeleteToolRequest request =
   *       DeleteToolRequest.newBuilder()
   *           .setName(ToolName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOL]").toString())
   *           .setForce(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Empty> future = agentServiceClient.deleteToolCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteToolRequest, Empty> deleteToolCallable() {
    return stub.deleteToolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists guardrails in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   for (Guardrail element : agentServiceClient.listGuardrails(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list guardrails from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGuardrailsPagedResponse listGuardrails(AppName parent) {
    ListGuardrailsRequest request =
        ListGuardrailsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listGuardrails(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists guardrails in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   for (Guardrail element : agentServiceClient.listGuardrails(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list guardrails from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGuardrailsPagedResponse listGuardrails(String parent) {
    ListGuardrailsRequest request = ListGuardrailsRequest.newBuilder().setParent(parent).build();
    return listGuardrails(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists guardrails in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListGuardrailsRequest request =
   *       ListGuardrailsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Guardrail element : agentServiceClient.listGuardrails(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListGuardrailsPagedResponse listGuardrails(ListGuardrailsRequest request) {
    return listGuardrailsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists guardrails in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListGuardrailsRequest request =
   *       ListGuardrailsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Guardrail> future =
   *       agentServiceClient.listGuardrailsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Guardrail element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGuardrailsRequest, ListGuardrailsPagedResponse>
      listGuardrailsPagedCallable() {
    return stub.listGuardrailsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists guardrails in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListGuardrailsRequest request =
   *       ListGuardrailsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListGuardrailsResponse response = agentServiceClient.listGuardrailsCallable().call(request);
   *     for (Guardrail element : response.getGuardrailsList()) {
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
  public final UnaryCallable<ListGuardrailsRequest, ListGuardrailsResponse>
      listGuardrailsCallable() {
    return stub.listGuardrailsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified guardrail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GuardrailName name = GuardrailName.of("[PROJECT]", "[LOCATION]", "[APP]", "[GUARDRAIL]");
   *   Guardrail response = agentServiceClient.getGuardrail(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the guardrail to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Guardrail getGuardrail(GuardrailName name) {
    GetGuardrailRequest request =
        GetGuardrailRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getGuardrail(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified guardrail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String name = GuardrailName.of("[PROJECT]", "[LOCATION]", "[APP]", "[GUARDRAIL]").toString();
   *   Guardrail response = agentServiceClient.getGuardrail(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the guardrail to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Guardrail getGuardrail(String name) {
    GetGuardrailRequest request = GetGuardrailRequest.newBuilder().setName(name).build();
    return getGuardrail(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified guardrail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GetGuardrailRequest request =
   *       GetGuardrailRequest.newBuilder()
   *           .setName(
   *               GuardrailName.of("[PROJECT]", "[LOCATION]", "[APP]", "[GUARDRAIL]").toString())
   *           .build();
   *   Guardrail response = agentServiceClient.getGuardrail(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Guardrail getGuardrail(GetGuardrailRequest request) {
    return getGuardrailCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified guardrail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GetGuardrailRequest request =
   *       GetGuardrailRequest.newBuilder()
   *           .setName(
   *               GuardrailName.of("[PROJECT]", "[LOCATION]", "[APP]", "[GUARDRAIL]").toString())
   *           .build();
   *   ApiFuture<Guardrail> future = agentServiceClient.getGuardrailCallable().futureCall(request);
   *   // Do something.
   *   Guardrail response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGuardrailRequest, Guardrail> getGuardrailCallable() {
    return stub.getGuardrailCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new guardrail in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   Guardrail guardrail = Guardrail.newBuilder().build();
   *   Guardrail response = agentServiceClient.createGuardrail(parent, guardrail);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create a guardrail in.
   * @param guardrail Required. The guardrail to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Guardrail createGuardrail(AppName parent, Guardrail guardrail) {
    CreateGuardrailRequest request =
        CreateGuardrailRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGuardrail(guardrail)
            .build();
    return createGuardrail(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new guardrail in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   Guardrail guardrail = Guardrail.newBuilder().build();
   *   Guardrail response = agentServiceClient.createGuardrail(parent, guardrail);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create a guardrail in.
   * @param guardrail Required. The guardrail to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Guardrail createGuardrail(String parent, Guardrail guardrail) {
    CreateGuardrailRequest request =
        CreateGuardrailRequest.newBuilder().setParent(parent).setGuardrail(guardrail).build();
    return createGuardrail(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new guardrail in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   Guardrail guardrail = Guardrail.newBuilder().build();
   *   String guardrailId = "guardrailId1875412786";
   *   Guardrail response = agentServiceClient.createGuardrail(parent, guardrail, guardrailId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create a guardrail in.
   * @param guardrail Required. The guardrail to create.
   * @param guardrailId Optional. The ID to use for the guardrail, which will become the final
   *     component of the guardrail's resource name. If not provided, a unique ID will be
   *     automatically assigned for the guardrail.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Guardrail createGuardrail(AppName parent, Guardrail guardrail, String guardrailId) {
    CreateGuardrailRequest request =
        CreateGuardrailRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setGuardrail(guardrail)
            .setGuardrailId(guardrailId)
            .build();
    return createGuardrail(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new guardrail in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   Guardrail guardrail = Guardrail.newBuilder().build();
   *   String guardrailId = "guardrailId1875412786";
   *   Guardrail response = agentServiceClient.createGuardrail(parent, guardrail, guardrailId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create a guardrail in.
   * @param guardrail Required. The guardrail to create.
   * @param guardrailId Optional. The ID to use for the guardrail, which will become the final
   *     component of the guardrail's resource name. If not provided, a unique ID will be
   *     automatically assigned for the guardrail.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Guardrail createGuardrail(String parent, Guardrail guardrail, String guardrailId) {
    CreateGuardrailRequest request =
        CreateGuardrailRequest.newBuilder()
            .setParent(parent)
            .setGuardrail(guardrail)
            .setGuardrailId(guardrailId)
            .build();
    return createGuardrail(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new guardrail in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   CreateGuardrailRequest request =
   *       CreateGuardrailRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setGuardrailId("guardrailId1875412786")
   *           .setGuardrail(Guardrail.newBuilder().build())
   *           .build();
   *   Guardrail response = agentServiceClient.createGuardrail(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Guardrail createGuardrail(CreateGuardrailRequest request) {
    return createGuardrailCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new guardrail in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   CreateGuardrailRequest request =
   *       CreateGuardrailRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setGuardrailId("guardrailId1875412786")
   *           .setGuardrail(Guardrail.newBuilder().build())
   *           .build();
   *   ApiFuture<Guardrail> future =
   *       agentServiceClient.createGuardrailCallable().futureCall(request);
   *   // Do something.
   *   Guardrail response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateGuardrailRequest, Guardrail> createGuardrailCallable() {
    return stub.createGuardrailCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified guardrail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   Guardrail guardrail = Guardrail.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Guardrail response = agentServiceClient.updateGuardrail(guardrail, updateMask);
   * }
   * }</pre>
   *
   * @param guardrail Required. The guardrail to update.
   * @param updateMask Optional. Field mask is used to control which fields get updated. If the mask
   *     is not present, all fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Guardrail updateGuardrail(Guardrail guardrail, FieldMask updateMask) {
    UpdateGuardrailRequest request =
        UpdateGuardrailRequest.newBuilder()
            .setGuardrail(guardrail)
            .setUpdateMask(updateMask)
            .build();
    return updateGuardrail(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified guardrail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   UpdateGuardrailRequest request =
   *       UpdateGuardrailRequest.newBuilder()
   *           .setGuardrail(Guardrail.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Guardrail response = agentServiceClient.updateGuardrail(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Guardrail updateGuardrail(UpdateGuardrailRequest request) {
    return updateGuardrailCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified guardrail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   UpdateGuardrailRequest request =
   *       UpdateGuardrailRequest.newBuilder()
   *           .setGuardrail(Guardrail.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Guardrail> future =
   *       agentServiceClient.updateGuardrailCallable().futureCall(request);
   *   // Do something.
   *   Guardrail response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGuardrailRequest, Guardrail> updateGuardrailCallable() {
    return stub.updateGuardrailCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified guardrail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GuardrailName name = GuardrailName.of("[PROJECT]", "[LOCATION]", "[APP]", "[GUARDRAIL]");
   *   agentServiceClient.deleteGuardrail(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the guardrail to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGuardrail(GuardrailName name) {
    DeleteGuardrailRequest request =
        DeleteGuardrailRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteGuardrail(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified guardrail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String name = GuardrailName.of("[PROJECT]", "[LOCATION]", "[APP]", "[GUARDRAIL]").toString();
   *   agentServiceClient.deleteGuardrail(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the guardrail to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGuardrail(String name) {
    DeleteGuardrailRequest request = DeleteGuardrailRequest.newBuilder().setName(name).build();
    deleteGuardrail(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified guardrail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   DeleteGuardrailRequest request =
   *       DeleteGuardrailRequest.newBuilder()
   *           .setName(
   *               GuardrailName.of("[PROJECT]", "[LOCATION]", "[APP]", "[GUARDRAIL]").toString())
   *           .setForce(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   agentServiceClient.deleteGuardrail(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteGuardrail(DeleteGuardrailRequest request) {
    deleteGuardrailCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified guardrail.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   DeleteGuardrailRequest request =
   *       DeleteGuardrailRequest.newBuilder()
   *           .setName(
   *               GuardrailName.of("[PROJECT]", "[LOCATION]", "[APP]", "[GUARDRAIL]").toString())
   *           .setForce(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Empty> future = agentServiceClient.deleteGuardrailCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGuardrailRequest, Empty> deleteGuardrailCallable() {
    return stub.deleteGuardrailCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists deployments in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   for (Deployment element : agentServiceClient.listDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent app. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeploymentsPagedResponse listDeployments(AppName parent) {
    ListDeploymentsRequest request =
        ListDeploymentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists deployments in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   for (Deployment element : agentServiceClient.listDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent app. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeploymentsPagedResponse listDeployments(String parent) {
    ListDeploymentsRequest request = ListDeploymentsRequest.newBuilder().setParent(parent).build();
    return listDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists deployments in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListDeploymentsRequest request =
   *       ListDeploymentsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Deployment element : agentServiceClient.listDeployments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeploymentsPagedResponse listDeployments(ListDeploymentsRequest request) {
    return listDeploymentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists deployments in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListDeploymentsRequest request =
   *       ListDeploymentsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Deployment> future =
   *       agentServiceClient.listDeploymentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Deployment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable() {
    return stub.listDeploymentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists deployments in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListDeploymentsRequest request =
   *       ListDeploymentsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDeploymentsResponse response =
   *         agentServiceClient.listDeploymentsCallable().call(request);
   *     for (Deployment element : response.getDeploymentsList()) {
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
  public final UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsCallable() {
    return stub.listDeploymentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]");
   *   Deployment response = agentServiceClient.getDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment. Format:
   *     `projects/{project}/locations/{location}/apps/{app}/deployments/{deployment}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment getDeployment(DeploymentName name) {
    GetDeploymentRequest request =
        GetDeploymentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String name =
   *       DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]").toString();
   *   Deployment response = agentServiceClient.getDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment. Format:
   *     `projects/{project}/locations/{location}/apps/{app}/deployments/{deployment}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment getDeployment(String name) {
    GetDeploymentRequest request = GetDeploymentRequest.newBuilder().setName(name).build();
    return getDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GetDeploymentRequest request =
   *       GetDeploymentRequest.newBuilder()
   *           .setName(
   *               DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]").toString())
   *           .build();
   *   Deployment response = agentServiceClient.getDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment getDeployment(GetDeploymentRequest request) {
    return getDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GetDeploymentRequest request =
   *       GetDeploymentRequest.newBuilder()
   *           .setName(
   *               DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]").toString())
   *           .build();
   *   ApiFuture<Deployment> future = agentServiceClient.getDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable() {
    return stub.getDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new deployment in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   Deployment deployment = Deployment.newBuilder().build();
   *   Deployment response = agentServiceClient.createDeployment(parent, deployment);
   * }
   * }</pre>
   *
   * @param parent Required. The parent app. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @param deployment Required. The deployment to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment createDeployment(AppName parent, Deployment deployment) {
    CreateDeploymentRequest request =
        CreateDeploymentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDeployment(deployment)
            .build();
    return createDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new deployment in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   Deployment deployment = Deployment.newBuilder().build();
   *   Deployment response = agentServiceClient.createDeployment(parent, deployment);
   * }
   * }</pre>
   *
   * @param parent Required. The parent app. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @param deployment Required. The deployment to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment createDeployment(String parent, Deployment deployment) {
    CreateDeploymentRequest request =
        CreateDeploymentRequest.newBuilder().setParent(parent).setDeployment(deployment).build();
    return createDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new deployment in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   Deployment deployment = Deployment.newBuilder().build();
   *   String deploymentId = "deploymentId-136894784";
   *   Deployment response = agentServiceClient.createDeployment(parent, deployment, deploymentId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent app. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @param deployment Required. The deployment to create.
   * @param deploymentId Optional. The ID to use for the deployment, which will become the final
   *     component of the deployment's resource name. If not provided, a unique ID will be
   *     automatically assigned for the deployment.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment createDeployment(
      AppName parent, Deployment deployment, String deploymentId) {
    CreateDeploymentRequest request =
        CreateDeploymentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDeployment(deployment)
            .setDeploymentId(deploymentId)
            .build();
    return createDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new deployment in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   Deployment deployment = Deployment.newBuilder().build();
   *   String deploymentId = "deploymentId-136894784";
   *   Deployment response = agentServiceClient.createDeployment(parent, deployment, deploymentId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent app. Format:
   *     `projects/{project}/locations/{location}/apps/{app}`
   * @param deployment Required. The deployment to create.
   * @param deploymentId Optional. The ID to use for the deployment, which will become the final
   *     component of the deployment's resource name. If not provided, a unique ID will be
   *     automatically assigned for the deployment.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment createDeployment(
      String parent, Deployment deployment, String deploymentId) {
    CreateDeploymentRequest request =
        CreateDeploymentRequest.newBuilder()
            .setParent(parent)
            .setDeployment(deployment)
            .setDeploymentId(deploymentId)
            .build();
    return createDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new deployment in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   CreateDeploymentRequest request =
   *       CreateDeploymentRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setDeploymentId("deploymentId-136894784")
   *           .setDeployment(Deployment.newBuilder().build())
   *           .build();
   *   Deployment response = agentServiceClient.createDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment createDeployment(CreateDeploymentRequest request) {
    return createDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new deployment in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   CreateDeploymentRequest request =
   *       CreateDeploymentRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setDeploymentId("deploymentId-136894784")
   *           .setDeployment(Deployment.newBuilder().build())
   *           .build();
   *   ApiFuture<Deployment> future =
   *       agentServiceClient.createDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDeploymentRequest, Deployment> createDeploymentCallable() {
    return stub.createDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   Deployment deployment = Deployment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Deployment response = agentServiceClient.updateDeployment(deployment, updateMask);
   * }
   * }</pre>
   *
   * @param deployment Required. The deployment to update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment updateDeployment(Deployment deployment, FieldMask updateMask) {
    UpdateDeploymentRequest request =
        UpdateDeploymentRequest.newBuilder()
            .setDeployment(deployment)
            .setUpdateMask(updateMask)
            .build();
    return updateDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   UpdateDeploymentRequest request =
   *       UpdateDeploymentRequest.newBuilder()
   *           .setDeployment(Deployment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Deployment response = agentServiceClient.updateDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment updateDeployment(UpdateDeploymentRequest request) {
    return updateDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   UpdateDeploymentRequest request =
   *       UpdateDeploymentRequest.newBuilder()
   *           .setDeployment(Deployment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Deployment> future =
   *       agentServiceClient.updateDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDeploymentRequest, Deployment> updateDeploymentCallable() {
    return stub.updateDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]");
   *   agentServiceClient.deleteDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment to delete. Format:
   *     `projects/{project}/locations/{location}/apps/{app}/deployments/{deployment}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDeployment(DeploymentName name) {
    DeleteDeploymentRequest request =
        DeleteDeploymentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String name =
   *       DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]").toString();
   *   agentServiceClient.deleteDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment to delete. Format:
   *     `projects/{project}/locations/{location}/apps/{app}/deployments/{deployment}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDeployment(String name) {
    DeleteDeploymentRequest request = DeleteDeploymentRequest.newBuilder().setName(name).build();
    deleteDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   DeleteDeploymentRequest request =
   *       DeleteDeploymentRequest.newBuilder()
   *           .setName(
   *               DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   agentServiceClient.deleteDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDeployment(DeleteDeploymentRequest request) {
    deleteDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   DeleteDeploymentRequest request =
   *       DeleteDeploymentRequest.newBuilder()
   *           .setName(
   *               DeploymentName.of("[PROJECT]", "[LOCATION]", "[APP]", "[DEPLOYMENT]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Empty> future = agentServiceClient.deleteDeploymentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDeploymentRequest, Empty> deleteDeploymentCallable() {
    return stub.deleteDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists toolsets in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   for (Toolset element : agentServiceClient.listToolsets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list toolsets from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListToolsetsPagedResponse listToolsets(AppName parent) {
    ListToolsetsRequest request =
        ListToolsetsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listToolsets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists toolsets in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   for (Toolset element : agentServiceClient.listToolsets(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list toolsets from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListToolsetsPagedResponse listToolsets(String parent) {
    ListToolsetsRequest request = ListToolsetsRequest.newBuilder().setParent(parent).build();
    return listToolsets(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists toolsets in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListToolsetsRequest request =
   *       ListToolsetsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Toolset element : agentServiceClient.listToolsets(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListToolsetsPagedResponse listToolsets(ListToolsetsRequest request) {
    return listToolsetsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists toolsets in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListToolsetsRequest request =
   *       ListToolsetsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Toolset> future =
   *       agentServiceClient.listToolsetsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Toolset element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListToolsetsRequest, ListToolsetsPagedResponse>
      listToolsetsPagedCallable() {
    return stub.listToolsetsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists toolsets in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListToolsetsRequest request =
   *       ListToolsetsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListToolsetsResponse response = agentServiceClient.listToolsetsCallable().call(request);
   *     for (Toolset element : response.getToolsetsList()) {
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
  public final UnaryCallable<ListToolsetsRequest, ListToolsetsResponse> listToolsetsCallable() {
    return stub.listToolsetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified toolset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ToolsetName name = ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]");
   *   Toolset response = agentServiceClient.getToolset(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the toolset to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Toolset getToolset(ToolsetName name) {
    GetToolsetRequest request =
        GetToolsetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getToolset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified toolset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String name = ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]").toString();
   *   Toolset response = agentServiceClient.getToolset(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the toolset to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Toolset getToolset(String name) {
    GetToolsetRequest request = GetToolsetRequest.newBuilder().setName(name).build();
    return getToolset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified toolset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GetToolsetRequest request =
   *       GetToolsetRequest.newBuilder()
   *           .setName(ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]").toString())
   *           .build();
   *   Toolset response = agentServiceClient.getToolset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Toolset getToolset(GetToolsetRequest request) {
    return getToolsetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified toolset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GetToolsetRequest request =
   *       GetToolsetRequest.newBuilder()
   *           .setName(ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]").toString())
   *           .build();
   *   ApiFuture<Toolset> future = agentServiceClient.getToolsetCallable().futureCall(request);
   *   // Do something.
   *   Toolset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetToolsetRequest, Toolset> getToolsetCallable() {
    return stub.getToolsetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new toolset in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   Toolset toolset = Toolset.newBuilder().build();
   *   Toolset response = agentServiceClient.createToolset(parent, toolset);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create a toolset in.
   * @param toolset Required. The toolset to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Toolset createToolset(AppName parent, Toolset toolset) {
    CreateToolsetRequest request =
        CreateToolsetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setToolset(toolset)
            .build();
    return createToolset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new toolset in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   Toolset toolset = Toolset.newBuilder().build();
   *   Toolset response = agentServiceClient.createToolset(parent, toolset);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create a toolset in.
   * @param toolset Required. The toolset to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Toolset createToolset(String parent, Toolset toolset) {
    CreateToolsetRequest request =
        CreateToolsetRequest.newBuilder().setParent(parent).setToolset(toolset).build();
    return createToolset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new toolset in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   Toolset toolset = Toolset.newBuilder().build();
   *   String toolsetId = "toolsetId-397931899";
   *   Toolset response = agentServiceClient.createToolset(parent, toolset, toolsetId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create a toolset in.
   * @param toolset Required. The toolset to create.
   * @param toolsetId Optional. The ID to use for the toolset, which will become the final component
   *     of the toolset's resource name. If not provided, a unique ID will be automatically assigned
   *     for the toolset.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Toolset createToolset(AppName parent, Toolset toolset, String toolsetId) {
    CreateToolsetRequest request =
        CreateToolsetRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setToolset(toolset)
            .setToolsetId(toolsetId)
            .build();
    return createToolset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new toolset in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   Toolset toolset = Toolset.newBuilder().build();
   *   String toolsetId = "toolsetId-397931899";
   *   Toolset response = agentServiceClient.createToolset(parent, toolset, toolsetId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create a toolset in.
   * @param toolset Required. The toolset to create.
   * @param toolsetId Optional. The ID to use for the toolset, which will become the final component
   *     of the toolset's resource name. If not provided, a unique ID will be automatically assigned
   *     for the toolset.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Toolset createToolset(String parent, Toolset toolset, String toolsetId) {
    CreateToolsetRequest request =
        CreateToolsetRequest.newBuilder()
            .setParent(parent)
            .setToolset(toolset)
            .setToolsetId(toolsetId)
            .build();
    return createToolset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new toolset in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   CreateToolsetRequest request =
   *       CreateToolsetRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setToolsetId("toolsetId-397931899")
   *           .setToolset(Toolset.newBuilder().build())
   *           .build();
   *   Toolset response = agentServiceClient.createToolset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Toolset createToolset(CreateToolsetRequest request) {
    return createToolsetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new toolset in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   CreateToolsetRequest request =
   *       CreateToolsetRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setToolsetId("toolsetId-397931899")
   *           .setToolset(Toolset.newBuilder().build())
   *           .build();
   *   ApiFuture<Toolset> future = agentServiceClient.createToolsetCallable().futureCall(request);
   *   // Do something.
   *   Toolset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateToolsetRequest, Toolset> createToolsetCallable() {
    return stub.createToolsetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified toolset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   Toolset toolset = Toolset.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Toolset response = agentServiceClient.updateToolset(toolset, updateMask);
   * }
   * }</pre>
   *
   * @param toolset Required. The toolset to update.
   * @param updateMask Optional. Field mask is used to control which fields get updated. If the mask
   *     is not present, all fields will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Toolset updateToolset(Toolset toolset, FieldMask updateMask) {
    UpdateToolsetRequest request =
        UpdateToolsetRequest.newBuilder().setToolset(toolset).setUpdateMask(updateMask).build();
    return updateToolset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified toolset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   UpdateToolsetRequest request =
   *       UpdateToolsetRequest.newBuilder()
   *           .setToolset(Toolset.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Toolset response = agentServiceClient.updateToolset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Toolset updateToolset(UpdateToolsetRequest request) {
    return updateToolsetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified toolset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   UpdateToolsetRequest request =
   *       UpdateToolsetRequest.newBuilder()
   *           .setToolset(Toolset.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Toolset> future = agentServiceClient.updateToolsetCallable().futureCall(request);
   *   // Do something.
   *   Toolset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateToolsetRequest, Toolset> updateToolsetCallable() {
    return stub.updateToolsetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified toolset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ToolsetName name = ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]");
   *   agentServiceClient.deleteToolset(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the toolset to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteToolset(ToolsetName name) {
    DeleteToolsetRequest request =
        DeleteToolsetRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteToolset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified toolset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String name = ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]").toString();
   *   agentServiceClient.deleteToolset(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the toolset to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteToolset(String name) {
    DeleteToolsetRequest request = DeleteToolsetRequest.newBuilder().setName(name).build();
    deleteToolset(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified toolset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   DeleteToolsetRequest request =
   *       DeleteToolsetRequest.newBuilder()
   *           .setName(ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]").toString())
   *           .setForce(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   agentServiceClient.deleteToolset(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteToolset(DeleteToolsetRequest request) {
    deleteToolsetCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified toolset.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   DeleteToolsetRequest request =
   *       DeleteToolsetRequest.newBuilder()
   *           .setName(ToolsetName.of("[PROJECT]", "[LOCATION]", "[APP]", "[TOOLSET]").toString())
   *           .setForce(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Empty> future = agentServiceClient.deleteToolsetCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteToolsetRequest, Empty> deleteToolsetCallable() {
    return stub.deleteToolsetCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all app versions in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   for (AppVersion element : agentServiceClient.listAppVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list app versions from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAppVersionsPagedResponse listAppVersions(AppName parent) {
    ListAppVersionsRequest request =
        ListAppVersionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAppVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all app versions in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   for (AppVersion element : agentServiceClient.listAppVersions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list app versions from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAppVersionsPagedResponse listAppVersions(String parent) {
    ListAppVersionsRequest request = ListAppVersionsRequest.newBuilder().setParent(parent).build();
    return listAppVersions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all app versions in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListAppVersionsRequest request =
   *       ListAppVersionsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (AppVersion element : agentServiceClient.listAppVersions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAppVersionsPagedResponse listAppVersions(ListAppVersionsRequest request) {
    return listAppVersionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all app versions in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListAppVersionsRequest request =
   *       ListAppVersionsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<AppVersion> future =
   *       agentServiceClient.listAppVersionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AppVersion element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAppVersionsRequest, ListAppVersionsPagedResponse>
      listAppVersionsPagedCallable() {
    return stub.listAppVersionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all app versions in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListAppVersionsRequest request =
   *       ListAppVersionsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListAppVersionsResponse response =
   *         agentServiceClient.listAppVersionsCallable().call(request);
   *     for (AppVersion element : response.getAppVersionsList()) {
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
  public final UnaryCallable<ListAppVersionsRequest, ListAppVersionsResponse>
      listAppVersionsCallable() {
    return stub.listAppVersionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified app version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppVersionName name = AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]");
   *   AppVersion response = agentServiceClient.getAppVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the app version to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppVersion getAppVersion(AppVersionName name) {
    GetAppVersionRequest request =
        GetAppVersionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAppVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified app version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String name = AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString();
   *   AppVersion response = agentServiceClient.getAppVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the app version to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppVersion getAppVersion(String name) {
    GetAppVersionRequest request = GetAppVersionRequest.newBuilder().setName(name).build();
    return getAppVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified app version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GetAppVersionRequest request =
   *       GetAppVersionRequest.newBuilder()
   *           .setName(
   *               AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
   *           .build();
   *   AppVersion response = agentServiceClient.getAppVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppVersion getAppVersion(GetAppVersionRequest request) {
    return getAppVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of the specified app version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GetAppVersionRequest request =
   *       GetAppVersionRequest.newBuilder()
   *           .setName(
   *               AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
   *           .build();
   *   ApiFuture<AppVersion> future = agentServiceClient.getAppVersionCallable().futureCall(request);
   *   // Do something.
   *   AppVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAppVersionRequest, AppVersion> getAppVersionCallable() {
    return stub.getAppVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new app version in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   AppVersion appVersion = AppVersion.newBuilder().build();
   *   AppVersion response = agentServiceClient.createAppVersion(parent, appVersion);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create an app version in.
   * @param appVersion Required. The app version to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppVersion createAppVersion(AppName parent, AppVersion appVersion) {
    CreateAppVersionRequest request =
        CreateAppVersionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAppVersion(appVersion)
            .build();
    return createAppVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new app version in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   AppVersion appVersion = AppVersion.newBuilder().build();
   *   AppVersion response = agentServiceClient.createAppVersion(parent, appVersion);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create an app version in.
   * @param appVersion Required. The app version to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppVersion createAppVersion(String parent, AppVersion appVersion) {
    CreateAppVersionRequest request =
        CreateAppVersionRequest.newBuilder().setParent(parent).setAppVersion(appVersion).build();
    return createAppVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new app version in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   AppVersion appVersion = AppVersion.newBuilder().build();
   *   String appVersionId = "appVersionId303221490";
   *   AppVersion response = agentServiceClient.createAppVersion(parent, appVersion, appVersionId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create an app version in.
   * @param appVersion Required. The app version to create.
   * @param appVersionId Optional. The ID to use for the app version, which will become the final
   *     component of the app version's resource name. If not provided, a unique ID will be
   *     automatically assigned for the app version.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppVersion createAppVersion(
      AppName parent, AppVersion appVersion, String appVersionId) {
    CreateAppVersionRequest request =
        CreateAppVersionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAppVersion(appVersion)
            .setAppVersionId(appVersionId)
            .build();
    return createAppVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new app version in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   AppVersion appVersion = AppVersion.newBuilder().build();
   *   String appVersionId = "appVersionId303221490";
   *   AppVersion response = agentServiceClient.createAppVersion(parent, appVersion, appVersionId);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to create an app version in.
   * @param appVersion Required. The app version to create.
   * @param appVersionId Optional. The ID to use for the app version, which will become the final
   *     component of the app version's resource name. If not provided, a unique ID will be
   *     automatically assigned for the app version.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppVersion createAppVersion(
      String parent, AppVersion appVersion, String appVersionId) {
    CreateAppVersionRequest request =
        CreateAppVersionRequest.newBuilder()
            .setParent(parent)
            .setAppVersion(appVersion)
            .setAppVersionId(appVersionId)
            .build();
    return createAppVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new app version in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   CreateAppVersionRequest request =
   *       CreateAppVersionRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setAppVersionId("appVersionId303221490")
   *           .setAppVersion(AppVersion.newBuilder().build())
   *           .build();
   *   AppVersion response = agentServiceClient.createAppVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AppVersion createAppVersion(CreateAppVersionRequest request) {
    return createAppVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new app version in the given app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   CreateAppVersionRequest request =
   *       CreateAppVersionRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setAppVersionId("appVersionId303221490")
   *           .setAppVersion(AppVersion.newBuilder().build())
   *           .build();
   *   ApiFuture<AppVersion> future =
   *       agentServiceClient.createAppVersionCallable().futureCall(request);
   *   // Do something.
   *   AppVersion response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAppVersionRequest, AppVersion> createAppVersionCallable() {
    return stub.createAppVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified app version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppVersionName name = AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]");
   *   agentServiceClient.deleteAppVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the app version to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAppVersion(AppVersionName name) {
    DeleteAppVersionRequest request =
        DeleteAppVersionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteAppVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified app version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String name = AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString();
   *   agentServiceClient.deleteAppVersion(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the app version to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAppVersion(String name) {
    DeleteAppVersionRequest request = DeleteAppVersionRequest.newBuilder().setName(name).build();
    deleteAppVersion(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified app version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   DeleteAppVersionRequest request =
   *       DeleteAppVersionRequest.newBuilder()
   *           .setName(
   *               AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   agentServiceClient.deleteAppVersion(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAppVersion(DeleteAppVersionRequest request) {
    deleteAppVersionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified app version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   DeleteAppVersionRequest request =
   *       DeleteAppVersionRequest.newBuilder()
   *           .setName(
   *               AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Empty> future = agentServiceClient.deleteAppVersionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAppVersionRequest, Empty> deleteAppVersionCallable() {
    return stub.deleteAppVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores the specified app version. This will create a new app version from the current draft
   * app and overwrite the current draft with the specified app version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppVersionName name = AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]");
   *   RestoreAppVersionResponse response = agentServiceClient.restoreAppVersionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the app version to restore.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RestoreAppVersionResponse, OperationMetadata> restoreAppVersionAsync(
      AppVersionName name) {
    RestoreAppVersionRequest request =
        RestoreAppVersionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return restoreAppVersionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores the specified app version. This will create a new app version from the current draft
   * app and overwrite the current draft with the specified app version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String name = AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString();
   *   RestoreAppVersionResponse response = agentServiceClient.restoreAppVersionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the app version to restore.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RestoreAppVersionResponse, OperationMetadata> restoreAppVersionAsync(
      String name) {
    RestoreAppVersionRequest request = RestoreAppVersionRequest.newBuilder().setName(name).build();
    return restoreAppVersionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores the specified app version. This will create a new app version from the current draft
   * app and overwrite the current draft with the specified app version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   RestoreAppVersionRequest request =
   *       RestoreAppVersionRequest.newBuilder()
   *           .setName(
   *               AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
   *           .build();
   *   RestoreAppVersionResponse response = agentServiceClient.restoreAppVersionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RestoreAppVersionResponse, OperationMetadata> restoreAppVersionAsync(
      RestoreAppVersionRequest request) {
    return restoreAppVersionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores the specified app version. This will create a new app version from the current draft
   * app and overwrite the current draft with the specified app version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   RestoreAppVersionRequest request =
   *       RestoreAppVersionRequest.newBuilder()
   *           .setName(
   *               AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
   *           .build();
   *   OperationFuture<RestoreAppVersionResponse, OperationMetadata> future =
   *       agentServiceClient.restoreAppVersionOperationCallable().futureCall(request);
   *   // Do something.
   *   RestoreAppVersionResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          RestoreAppVersionRequest, RestoreAppVersionResponse, OperationMetadata>
      restoreAppVersionOperationCallable() {
    return stub.restoreAppVersionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Restores the specified app version. This will create a new app version from the current draft
   * app and overwrite the current draft with the specified app version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   RestoreAppVersionRequest request =
   *       RestoreAppVersionRequest.newBuilder()
   *           .setName(
   *               AppVersionName.of("[PROJECT]", "[LOCATION]", "[APP]", "[VERSION]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       agentServiceClient.restoreAppVersionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RestoreAppVersionRequest, Operation> restoreAppVersionCallable() {
    return stub.restoreAppVersionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the changelogs of the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   AppName parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]");
   *   for (Changelog element : agentServiceClient.listChangelogs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list changelogs from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChangelogsPagedResponse listChangelogs(AppName parent) {
    ListChangelogsRequest request =
        ListChangelogsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listChangelogs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the changelogs of the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String parent = AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString();
   *   for (Changelog element : agentServiceClient.listChangelogs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the app to list changelogs from.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChangelogsPagedResponse listChangelogs(String parent) {
    ListChangelogsRequest request = ListChangelogsRequest.newBuilder().setParent(parent).build();
    return listChangelogs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the changelogs of the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListChangelogsRequest request =
   *       ListChangelogsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Changelog element : agentServiceClient.listChangelogs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChangelogsPagedResponse listChangelogs(ListChangelogsRequest request) {
    return listChangelogsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the changelogs of the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListChangelogsRequest request =
   *       ListChangelogsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Changelog> future =
   *       agentServiceClient.listChangelogsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Changelog element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListChangelogsRequest, ListChangelogsPagedResponse>
      listChangelogsPagedCallable() {
    return stub.listChangelogsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the changelogs of the specified app.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListChangelogsRequest request =
   *       ListChangelogsRequest.newBuilder()
   *           .setParent(AppName.of("[PROJECT]", "[LOCATION]", "[APP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListChangelogsResponse response = agentServiceClient.listChangelogsCallable().call(request);
   *     for (Changelog element : response.getChangelogsList()) {
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
  public final UnaryCallable<ListChangelogsRequest, ListChangelogsResponse>
      listChangelogsCallable() {
    return stub.listChangelogsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified changelog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ChangelogName name = ChangelogName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CHANGELOG]");
   *   Changelog response = agentServiceClient.getChangelog(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the changelog to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Changelog getChangelog(ChangelogName name) {
    GetChangelogRequest request =
        GetChangelogRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getChangelog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified changelog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   String name = ChangelogName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CHANGELOG]").toString();
   *   Changelog response = agentServiceClient.getChangelog(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the changelog to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Changelog getChangelog(String name) {
    GetChangelogRequest request = GetChangelogRequest.newBuilder().setName(name).build();
    return getChangelog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified changelog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GetChangelogRequest request =
   *       GetChangelogRequest.newBuilder()
   *           .setName(
   *               ChangelogName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CHANGELOG]").toString())
   *           .build();
   *   Changelog response = agentServiceClient.getChangelog(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Changelog getChangelog(GetChangelogRequest request) {
    return getChangelogCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the specified changelog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GetChangelogRequest request =
   *       GetChangelogRequest.newBuilder()
   *           .setName(
   *               ChangelogName.of("[PROJECT]", "[LOCATION]", "[APP]", "[CHANGELOG]").toString())
   *           .build();
   *   ApiFuture<Changelog> future = agentServiceClient.getChangelogCallable().futureCall(request);
   *   // Do something.
   *   Changelog response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetChangelogRequest, Changelog> getChangelogCallable() {
    return stub.getChangelogCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : agentServiceClient.listLocations(request).iterateAll()) {
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
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       agentServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * Lists information about the supported locations for this service.This method can be called in
   * two ways:
   *
   * <p>&#42; &#42;&#42;List all public locations:&#42;&#42; Use the path `GET /v1/locations`.&#42;
   * &#42;&#42;List project-visible locations:&#42;&#42; Use the path`GET
   * /v1/projects/{project_id}/locations`. This may include publiclocations as well as private or
   * other locations specifically visibleto the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = agentServiceClient.listLocationsCallable().call(request);
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
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = agentServiceClient.getLocation(request);
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
   * try (AgentServiceClient agentServiceClient = AgentServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = agentServiceClient.getLocationCallable().futureCall(request);
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

  public static class ListAppsPagedResponse
      extends AbstractPagedListResponse<
          ListAppsRequest, ListAppsResponse, App, ListAppsPage, ListAppsFixedSizeCollection> {

    public static ApiFuture<ListAppsPagedResponse> createAsync(
        PageContext<ListAppsRequest, ListAppsResponse, App> context,
        ApiFuture<ListAppsResponse> futureResponse) {
      ApiFuture<ListAppsPage> futurePage =
          ListAppsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListAppsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListAppsPagedResponse(ListAppsPage page) {
      super(page, ListAppsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAppsPage
      extends AbstractPage<ListAppsRequest, ListAppsResponse, App, ListAppsPage> {

    private ListAppsPage(
        PageContext<ListAppsRequest, ListAppsResponse, App> context, ListAppsResponse response) {
      super(context, response);
    }

    private static ListAppsPage createEmptyPage() {
      return new ListAppsPage(null, null);
    }

    @Override
    protected ListAppsPage createPage(
        PageContext<ListAppsRequest, ListAppsResponse, App> context, ListAppsResponse response) {
      return new ListAppsPage(context, response);
    }

    @Override
    public ApiFuture<ListAppsPage> createPageAsync(
        PageContext<ListAppsRequest, ListAppsResponse, App> context,
        ApiFuture<ListAppsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAppsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAppsRequest, ListAppsResponse, App, ListAppsPage, ListAppsFixedSizeCollection> {

    private ListAppsFixedSizeCollection(List<ListAppsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAppsFixedSizeCollection createEmptyCollection() {
      return new ListAppsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAppsFixedSizeCollection createCollection(
        List<ListAppsPage> pages, int collectionSize) {
      return new ListAppsFixedSizeCollection(pages, collectionSize);
    }
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

  public static class ListExamplesPagedResponse
      extends AbstractPagedListResponse<
          ListExamplesRequest,
          ListExamplesResponse,
          Example,
          ListExamplesPage,
          ListExamplesFixedSizeCollection> {

    public static ApiFuture<ListExamplesPagedResponse> createAsync(
        PageContext<ListExamplesRequest, ListExamplesResponse, Example> context,
        ApiFuture<ListExamplesResponse> futureResponse) {
      ApiFuture<ListExamplesPage> futurePage =
          ListExamplesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListExamplesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListExamplesPagedResponse(ListExamplesPage page) {
      super(page, ListExamplesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListExamplesPage
      extends AbstractPage<ListExamplesRequest, ListExamplesResponse, Example, ListExamplesPage> {

    private ListExamplesPage(
        PageContext<ListExamplesRequest, ListExamplesResponse, Example> context,
        ListExamplesResponse response) {
      super(context, response);
    }

    private static ListExamplesPage createEmptyPage() {
      return new ListExamplesPage(null, null);
    }

    @Override
    protected ListExamplesPage createPage(
        PageContext<ListExamplesRequest, ListExamplesResponse, Example> context,
        ListExamplesResponse response) {
      return new ListExamplesPage(context, response);
    }

    @Override
    public ApiFuture<ListExamplesPage> createPageAsync(
        PageContext<ListExamplesRequest, ListExamplesResponse, Example> context,
        ApiFuture<ListExamplesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListExamplesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListExamplesRequest,
          ListExamplesResponse,
          Example,
          ListExamplesPage,
          ListExamplesFixedSizeCollection> {

    private ListExamplesFixedSizeCollection(List<ListExamplesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListExamplesFixedSizeCollection createEmptyCollection() {
      return new ListExamplesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListExamplesFixedSizeCollection createCollection(
        List<ListExamplesPage> pages, int collectionSize) {
      return new ListExamplesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListToolsPagedResponse
      extends AbstractPagedListResponse<
          ListToolsRequest, ListToolsResponse, Tool, ListToolsPage, ListToolsFixedSizeCollection> {

    public static ApiFuture<ListToolsPagedResponse> createAsync(
        PageContext<ListToolsRequest, ListToolsResponse, Tool> context,
        ApiFuture<ListToolsResponse> futureResponse) {
      ApiFuture<ListToolsPage> futurePage =
          ListToolsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListToolsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListToolsPagedResponse(ListToolsPage page) {
      super(page, ListToolsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListToolsPage
      extends AbstractPage<ListToolsRequest, ListToolsResponse, Tool, ListToolsPage> {

    private ListToolsPage(
        PageContext<ListToolsRequest, ListToolsResponse, Tool> context,
        ListToolsResponse response) {
      super(context, response);
    }

    private static ListToolsPage createEmptyPage() {
      return new ListToolsPage(null, null);
    }

    @Override
    protected ListToolsPage createPage(
        PageContext<ListToolsRequest, ListToolsResponse, Tool> context,
        ListToolsResponse response) {
      return new ListToolsPage(context, response);
    }

    @Override
    public ApiFuture<ListToolsPage> createPageAsync(
        PageContext<ListToolsRequest, ListToolsResponse, Tool> context,
        ApiFuture<ListToolsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListToolsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListToolsRequest, ListToolsResponse, Tool, ListToolsPage, ListToolsFixedSizeCollection> {

    private ListToolsFixedSizeCollection(List<ListToolsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListToolsFixedSizeCollection createEmptyCollection() {
      return new ListToolsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListToolsFixedSizeCollection createCollection(
        List<ListToolsPage> pages, int collectionSize) {
      return new ListToolsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListConversationsPagedResponse
      extends AbstractPagedListResponse<
          ListConversationsRequest,
          ListConversationsResponse,
          Conversation,
          ListConversationsPage,
          ListConversationsFixedSizeCollection> {

    public static ApiFuture<ListConversationsPagedResponse> createAsync(
        PageContext<ListConversationsRequest, ListConversationsResponse, Conversation> context,
        ApiFuture<ListConversationsResponse> futureResponse) {
      ApiFuture<ListConversationsPage> futurePage =
          ListConversationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListConversationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListConversationsPagedResponse(ListConversationsPage page) {
      super(page, ListConversationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListConversationsPage
      extends AbstractPage<
          ListConversationsRequest,
          ListConversationsResponse,
          Conversation,
          ListConversationsPage> {

    private ListConversationsPage(
        PageContext<ListConversationsRequest, ListConversationsResponse, Conversation> context,
        ListConversationsResponse response) {
      super(context, response);
    }

    private static ListConversationsPage createEmptyPage() {
      return new ListConversationsPage(null, null);
    }

    @Override
    protected ListConversationsPage createPage(
        PageContext<ListConversationsRequest, ListConversationsResponse, Conversation> context,
        ListConversationsResponse response) {
      return new ListConversationsPage(context, response);
    }

    @Override
    public ApiFuture<ListConversationsPage> createPageAsync(
        PageContext<ListConversationsRequest, ListConversationsResponse, Conversation> context,
        ApiFuture<ListConversationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListConversationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListConversationsRequest,
          ListConversationsResponse,
          Conversation,
          ListConversationsPage,
          ListConversationsFixedSizeCollection> {

    private ListConversationsFixedSizeCollection(
        List<ListConversationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListConversationsFixedSizeCollection createEmptyCollection() {
      return new ListConversationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListConversationsFixedSizeCollection createCollection(
        List<ListConversationsPage> pages, int collectionSize) {
      return new ListConversationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListGuardrailsPagedResponse
      extends AbstractPagedListResponse<
          ListGuardrailsRequest,
          ListGuardrailsResponse,
          Guardrail,
          ListGuardrailsPage,
          ListGuardrailsFixedSizeCollection> {

    public static ApiFuture<ListGuardrailsPagedResponse> createAsync(
        PageContext<ListGuardrailsRequest, ListGuardrailsResponse, Guardrail> context,
        ApiFuture<ListGuardrailsResponse> futureResponse) {
      ApiFuture<ListGuardrailsPage> futurePage =
          ListGuardrailsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListGuardrailsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListGuardrailsPagedResponse(ListGuardrailsPage page) {
      super(page, ListGuardrailsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListGuardrailsPage
      extends AbstractPage<
          ListGuardrailsRequest, ListGuardrailsResponse, Guardrail, ListGuardrailsPage> {

    private ListGuardrailsPage(
        PageContext<ListGuardrailsRequest, ListGuardrailsResponse, Guardrail> context,
        ListGuardrailsResponse response) {
      super(context, response);
    }

    private static ListGuardrailsPage createEmptyPage() {
      return new ListGuardrailsPage(null, null);
    }

    @Override
    protected ListGuardrailsPage createPage(
        PageContext<ListGuardrailsRequest, ListGuardrailsResponse, Guardrail> context,
        ListGuardrailsResponse response) {
      return new ListGuardrailsPage(context, response);
    }

    @Override
    public ApiFuture<ListGuardrailsPage> createPageAsync(
        PageContext<ListGuardrailsRequest, ListGuardrailsResponse, Guardrail> context,
        ApiFuture<ListGuardrailsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListGuardrailsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGuardrailsRequest,
          ListGuardrailsResponse,
          Guardrail,
          ListGuardrailsPage,
          ListGuardrailsFixedSizeCollection> {

    private ListGuardrailsFixedSizeCollection(List<ListGuardrailsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListGuardrailsFixedSizeCollection createEmptyCollection() {
      return new ListGuardrailsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListGuardrailsFixedSizeCollection createCollection(
        List<ListGuardrailsPage> pages, int collectionSize) {
      return new ListGuardrailsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDeploymentsPagedResponse
      extends AbstractPagedListResponse<
          ListDeploymentsRequest,
          ListDeploymentsResponse,
          Deployment,
          ListDeploymentsPage,
          ListDeploymentsFixedSizeCollection> {

    public static ApiFuture<ListDeploymentsPagedResponse> createAsync(
        PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> context,
        ApiFuture<ListDeploymentsResponse> futureResponse) {
      ApiFuture<ListDeploymentsPage> futurePage =
          ListDeploymentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDeploymentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDeploymentsPagedResponse(ListDeploymentsPage page) {
      super(page, ListDeploymentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDeploymentsPage
      extends AbstractPage<
          ListDeploymentsRequest, ListDeploymentsResponse, Deployment, ListDeploymentsPage> {

    private ListDeploymentsPage(
        PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> context,
        ListDeploymentsResponse response) {
      super(context, response);
    }

    private static ListDeploymentsPage createEmptyPage() {
      return new ListDeploymentsPage(null, null);
    }

    @Override
    protected ListDeploymentsPage createPage(
        PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> context,
        ListDeploymentsResponse response) {
      return new ListDeploymentsPage(context, response);
    }

    @Override
    public ApiFuture<ListDeploymentsPage> createPageAsync(
        PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> context,
        ApiFuture<ListDeploymentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDeploymentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDeploymentsRequest,
          ListDeploymentsResponse,
          Deployment,
          ListDeploymentsPage,
          ListDeploymentsFixedSizeCollection> {

    private ListDeploymentsFixedSizeCollection(
        List<ListDeploymentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDeploymentsFixedSizeCollection createEmptyCollection() {
      return new ListDeploymentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDeploymentsFixedSizeCollection createCollection(
        List<ListDeploymentsPage> pages, int collectionSize) {
      return new ListDeploymentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListToolsetsPagedResponse
      extends AbstractPagedListResponse<
          ListToolsetsRequest,
          ListToolsetsResponse,
          Toolset,
          ListToolsetsPage,
          ListToolsetsFixedSizeCollection> {

    public static ApiFuture<ListToolsetsPagedResponse> createAsync(
        PageContext<ListToolsetsRequest, ListToolsetsResponse, Toolset> context,
        ApiFuture<ListToolsetsResponse> futureResponse) {
      ApiFuture<ListToolsetsPage> futurePage =
          ListToolsetsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListToolsetsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListToolsetsPagedResponse(ListToolsetsPage page) {
      super(page, ListToolsetsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListToolsetsPage
      extends AbstractPage<ListToolsetsRequest, ListToolsetsResponse, Toolset, ListToolsetsPage> {

    private ListToolsetsPage(
        PageContext<ListToolsetsRequest, ListToolsetsResponse, Toolset> context,
        ListToolsetsResponse response) {
      super(context, response);
    }

    private static ListToolsetsPage createEmptyPage() {
      return new ListToolsetsPage(null, null);
    }

    @Override
    protected ListToolsetsPage createPage(
        PageContext<ListToolsetsRequest, ListToolsetsResponse, Toolset> context,
        ListToolsetsResponse response) {
      return new ListToolsetsPage(context, response);
    }

    @Override
    public ApiFuture<ListToolsetsPage> createPageAsync(
        PageContext<ListToolsetsRequest, ListToolsetsResponse, Toolset> context,
        ApiFuture<ListToolsetsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListToolsetsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListToolsetsRequest,
          ListToolsetsResponse,
          Toolset,
          ListToolsetsPage,
          ListToolsetsFixedSizeCollection> {

    private ListToolsetsFixedSizeCollection(List<ListToolsetsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListToolsetsFixedSizeCollection createEmptyCollection() {
      return new ListToolsetsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListToolsetsFixedSizeCollection createCollection(
        List<ListToolsetsPage> pages, int collectionSize) {
      return new ListToolsetsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAppVersionsPagedResponse
      extends AbstractPagedListResponse<
          ListAppVersionsRequest,
          ListAppVersionsResponse,
          AppVersion,
          ListAppVersionsPage,
          ListAppVersionsFixedSizeCollection> {

    public static ApiFuture<ListAppVersionsPagedResponse> createAsync(
        PageContext<ListAppVersionsRequest, ListAppVersionsResponse, AppVersion> context,
        ApiFuture<ListAppVersionsResponse> futureResponse) {
      ApiFuture<ListAppVersionsPage> futurePage =
          ListAppVersionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAppVersionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAppVersionsPagedResponse(ListAppVersionsPage page) {
      super(page, ListAppVersionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAppVersionsPage
      extends AbstractPage<
          ListAppVersionsRequest, ListAppVersionsResponse, AppVersion, ListAppVersionsPage> {

    private ListAppVersionsPage(
        PageContext<ListAppVersionsRequest, ListAppVersionsResponse, AppVersion> context,
        ListAppVersionsResponse response) {
      super(context, response);
    }

    private static ListAppVersionsPage createEmptyPage() {
      return new ListAppVersionsPage(null, null);
    }

    @Override
    protected ListAppVersionsPage createPage(
        PageContext<ListAppVersionsRequest, ListAppVersionsResponse, AppVersion> context,
        ListAppVersionsResponse response) {
      return new ListAppVersionsPage(context, response);
    }

    @Override
    public ApiFuture<ListAppVersionsPage> createPageAsync(
        PageContext<ListAppVersionsRequest, ListAppVersionsResponse, AppVersion> context,
        ApiFuture<ListAppVersionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAppVersionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAppVersionsRequest,
          ListAppVersionsResponse,
          AppVersion,
          ListAppVersionsPage,
          ListAppVersionsFixedSizeCollection> {

    private ListAppVersionsFixedSizeCollection(
        List<ListAppVersionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAppVersionsFixedSizeCollection createEmptyCollection() {
      return new ListAppVersionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAppVersionsFixedSizeCollection createCollection(
        List<ListAppVersionsPage> pages, int collectionSize) {
      return new ListAppVersionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListChangelogsPagedResponse
      extends AbstractPagedListResponse<
          ListChangelogsRequest,
          ListChangelogsResponse,
          Changelog,
          ListChangelogsPage,
          ListChangelogsFixedSizeCollection> {

    public static ApiFuture<ListChangelogsPagedResponse> createAsync(
        PageContext<ListChangelogsRequest, ListChangelogsResponse, Changelog> context,
        ApiFuture<ListChangelogsResponse> futureResponse) {
      ApiFuture<ListChangelogsPage> futurePage =
          ListChangelogsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListChangelogsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListChangelogsPagedResponse(ListChangelogsPage page) {
      super(page, ListChangelogsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListChangelogsPage
      extends AbstractPage<
          ListChangelogsRequest, ListChangelogsResponse, Changelog, ListChangelogsPage> {

    private ListChangelogsPage(
        PageContext<ListChangelogsRequest, ListChangelogsResponse, Changelog> context,
        ListChangelogsResponse response) {
      super(context, response);
    }

    private static ListChangelogsPage createEmptyPage() {
      return new ListChangelogsPage(null, null);
    }

    @Override
    protected ListChangelogsPage createPage(
        PageContext<ListChangelogsRequest, ListChangelogsResponse, Changelog> context,
        ListChangelogsResponse response) {
      return new ListChangelogsPage(context, response);
    }

    @Override
    public ApiFuture<ListChangelogsPage> createPageAsync(
        PageContext<ListChangelogsRequest, ListChangelogsResponse, Changelog> context,
        ApiFuture<ListChangelogsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListChangelogsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListChangelogsRequest,
          ListChangelogsResponse,
          Changelog,
          ListChangelogsPage,
          ListChangelogsFixedSizeCollection> {

    private ListChangelogsFixedSizeCollection(List<ListChangelogsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListChangelogsFixedSizeCollection createEmptyCollection() {
      return new ListChangelogsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListChangelogsFixedSizeCollection createCollection(
        List<ListChangelogsPage> pages, int collectionSize) {
      return new ListChangelogsFixedSizeCollection(pages, collectionSize);
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
