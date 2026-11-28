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

package com.google.cloud.aiplatform.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1.stub.AgentAnomalyDetectionServiceStub;
import com.google.cloud.aiplatform.v1.stub.AgentAnomalyDetectionServiceStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service for managing Agent Anomaly Detection for monitored agents.
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
 * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
 *     AgentAnomalyDetectionServiceClient.create()) {
 *   AgentAnomalyDetectionScopeName name =
 *       AgentAnomalyDetectionScopeName.of(
 *           "[PROJECT]", "[LOCATION]", "[AGENT_ANOMALY_DETECTION_SCOPE]");
 *   AgentAnomalyDetectionScope response =
 *       agentAnomalyDetectionServiceClient.getAgentAnomalyDetectionScope(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AgentAnomalyDetectionServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetAgentAnomalyDetectionScope</td>
 *      <td><p> Gets the details of a specific AgentAnomalyDetectionScope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAgentAnomalyDetectionScope(GetAgentAnomalyDetectionScopeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAgentAnomalyDetectionScope(AgentAnomalyDetectionScopeName name)
 *           <li><p> getAgentAnomalyDetectionScope(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAgentAnomalyDetectionScopeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMonitoredAgent</td>
 *      <td><p> Gets the details of a specific MonitoredAgent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMonitoredAgent(GetMonitoredAgentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMonitoredAgent(MonitoredAgentName name)
 *           <li><p> getMonitoredAgent(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMonitoredAgentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMonitoredAgents</td>
 *      <td><p> Lists MonitoredAgents in a specific Location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMonitoredAgents(ListMonitoredAgentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMonitoredAgents(LocationName parent)
 *           <li><p> listMonitoredAgents(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMonitoredAgentsPagedCallable()
 *           <li><p> listMonitoredAgentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> EnableMonitoredAgent</td>
 *      <td><p> Enables a specific MonitoredAgent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> enableMonitoredAgentAsync(EnableMonitoredAgentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> enableMonitoredAgentAsync(MonitoredAgentName name)
 *           <li><p> enableMonitoredAgentAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> enableMonitoredAgentOperationCallable()
 *           <li><p> enableMonitoredAgentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DisableMonitoredAgent</td>
 *      <td><p> Disables a specific MonitoredAgent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> disableMonitoredAgentAsync(DisableMonitoredAgentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> disableMonitoredAgentAsync(MonitoredAgentName name)
 *           <li><p> disableMonitoredAgentAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> disableMonitoredAgentOperationCallable()
 *           <li><p> disableMonitoredAgentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAgentAnomalyDetectionScope</td>
 *      <td><p> Deletes a specific AgentAnomalyDetectionScope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAgentAnomalyDetectionScopeAsync(DeleteAgentAnomalyDetectionScopeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAgentAnomalyDetectionScopeAsync(AgentAnomalyDetectionScopeName name)
 *           <li><p> deleteAgentAnomalyDetectionScopeAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAgentAnomalyDetectionScopeOperationCallable()
 *           <li><p> deleteAgentAnomalyDetectionScopeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAgentAnomalyDetectionScope</td>
 *      <td><p> Creates a new AgentAnomalyDetectionScope.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAgentAnomalyDetectionScopeAsync(CreateAgentAnomalyDetectionScopeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createAgentAnomalyDetectionScopeAsync(LocationName parent, AgentAnomalyDetectionScope agentAnomalyDetectionScope, String agentAnomalyDetectionScopeId)
 *           <li><p> createAgentAnomalyDetectionScopeAsync(String parent, AgentAnomalyDetectionScope agentAnomalyDetectionScope, String agentAnomalyDetectionScopeId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAgentAnomalyDetectionScopeOperationCallable()
 *           <li><p> createAgentAnomalyDetectionScopeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAgentAnomalyDetectionScopes</td>
 *      <td><p> Lists AgentAnomalyDetectionScopes in a Location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAgentAnomalyDetectionScopes(ListAgentAnomalyDetectionScopesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAgentAnomalyDetectionScopes(LocationName parent)
 *           <li><p> listAgentAnomalyDetectionScopes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAgentAnomalyDetectionScopesPagedCallable()
 *           <li><p> listAgentAnomalyDetectionScopesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAnalyzedSessions</td>
 *      <td><p> Lists AnalyzedSessions in a MonitoredAgent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAnalyzedSessions(ListAnalyzedSessionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAnalyzedSessions(MonitoredAgentName parent)
 *           <li><p> listAnalyzedSessions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAnalyzedSessionsPagedCallable()
 *           <li><p> listAnalyzedSessionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAnalyzedSession</td>
 *      <td><p> Gets the details of a specific AnalyzedSession.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAnalyzedSession(GetAnalyzedSessionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAnalyzedSession(AnalyzedSessionName name)
 *           <li><p> getAnalyzedSession(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAnalyzedSessionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAnalyzedInvocations</td>
 *      <td><p> Lists AnalyzedInvocations in a MonitoredAgent's AnalyzedSession.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAnalyzedInvocations(ListAnalyzedInvocationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAnalyzedInvocations(AnalyzedSessionName parent)
 *           <li><p> listAnalyzedInvocations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAnalyzedInvocationsPagedCallable()
 *           <li><p> listAnalyzedInvocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAnalyzedInvocation</td>
 *      <td><p> Gets the details of a specific AnalyzedInvocation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAnalyzedInvocation(GetAnalyzedInvocationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAnalyzedInvocation(AnalyzedInvocationName name)
 *           <li><p> getAnalyzedInvocation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAnalyzedInvocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AggregateAnalyzedSessions</td>
 *      <td><p> Aggregates AnalyzedSessions across MonitoredAgents.
 * <p>  To aggregate across all MonitoredAgents in a location, use the following format for the parent field: `projects/{project}/locations/{location}/monitoredAgents/-`</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> aggregateAnalyzedSessions(AggregateAnalyzedSessionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> aggregateAnalyzedSessions(MonitoredAgentName parent)
 *           <li><p> aggregateAnalyzedSessions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> aggregateAnalyzedSessionsPagedCallable()
 *           <li><p> aggregateAnalyzedSessionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ClearTrainingData</td>
 *      <td><p> Clears (purges) the trained model artifacts derived from a MonitoredAgent's data. The purged model is rebuilt by the next scheduled training run.
 * <p>  To clear every MonitoredAgent in a location's scope, use the `-` wildcard agent segment for the name field: `projects/{project}/locations/{location}/monitoredAgents/-`
 * <p>  This is the on-demand data-deletion path for customers who have deleted the underlying logs / observability data a model was trained on. It deletes only the derived model artifacts (it does NOT delete the scope or stop monitoring). To stop monitoring an agent entirely, disable it via DisableMonitoredAgent.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> clearTrainingDataAsync(ClearTrainingDataRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> clearTrainingDataAsync(MonitoredAgentName name)
 *           <li><p> clearTrainingDataAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> clearTrainingDataOperationCallable()
 *           <li><p> clearTrainingDataCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * AgentAnomalyDetectionServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AgentAnomalyDetectionServiceSettings agentAnomalyDetectionServiceSettings =
 *     AgentAnomalyDetectionServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
 *     AgentAnomalyDetectionServiceClient.create(agentAnomalyDetectionServiceSettings);
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
 * AgentAnomalyDetectionServiceSettings agentAnomalyDetectionServiceSettings =
 *     AgentAnomalyDetectionServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
 *     AgentAnomalyDetectionServiceClient.create(agentAnomalyDetectionServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class AgentAnomalyDetectionServiceClient implements BackgroundResource {
  private final @Nullable AgentAnomalyDetectionServiceSettings settings;
  private final AgentAnomalyDetectionServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of AgentAnomalyDetectionServiceClient with default settings. */
  public static final AgentAnomalyDetectionServiceClient create() throws IOException {
    return create(AgentAnomalyDetectionServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AgentAnomalyDetectionServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final AgentAnomalyDetectionServiceClient create(
      AgentAnomalyDetectionServiceSettings settings) throws IOException {
    return new AgentAnomalyDetectionServiceClient(settings);
  }

  /**
   * Constructs an instance of AgentAnomalyDetectionServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(AgentAnomalyDetectionServiceSettings).
   */
  public static final AgentAnomalyDetectionServiceClient create(
      AgentAnomalyDetectionServiceStub stub) {
    return new AgentAnomalyDetectionServiceClient(stub);
  }

  /**
   * Constructs an instance of AgentAnomalyDetectionServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AgentAnomalyDetectionServiceClient(AgentAnomalyDetectionServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((AgentAnomalyDetectionServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected AgentAnomalyDetectionServiceClient(AgentAnomalyDetectionServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final @Nullable AgentAnomalyDetectionServiceSettings getSettings() {
    return settings;
  }

  public AgentAnomalyDetectionServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific AgentAnomalyDetectionScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   AgentAnomalyDetectionScopeName name =
   *       AgentAnomalyDetectionScopeName.of(
   *           "[PROJECT]", "[LOCATION]", "[AGENT_ANOMALY_DETECTION_SCOPE]");
   *   AgentAnomalyDetectionScope response =
   *       agentAnomalyDetectionServiceClient.getAgentAnomalyDetectionScope(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the AgentAnomalyDetectionScope resource. Format:
   *     `projects/{project}/locations/{location}/agentAnomalyDetectionScopes/{agent_anomaly_detection_scope}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AgentAnomalyDetectionScope getAgentAnomalyDetectionScope(
      @Nullable AgentAnomalyDetectionScopeName name) {
    GetAgentAnomalyDetectionScopeRequest request =
        GetAgentAnomalyDetectionScopeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAgentAnomalyDetectionScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific AgentAnomalyDetectionScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   String name =
   *       AgentAnomalyDetectionScopeName.of(
   *               "[PROJECT]", "[LOCATION]", "[AGENT_ANOMALY_DETECTION_SCOPE]")
   *           .toString();
   *   AgentAnomalyDetectionScope response =
   *       agentAnomalyDetectionServiceClient.getAgentAnomalyDetectionScope(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the AgentAnomalyDetectionScope resource. Format:
   *     `projects/{project}/locations/{location}/agentAnomalyDetectionScopes/{agent_anomaly_detection_scope}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AgentAnomalyDetectionScope getAgentAnomalyDetectionScope(String name) {
    GetAgentAnomalyDetectionScopeRequest request =
        GetAgentAnomalyDetectionScopeRequest.newBuilder().setName(name).build();
    return getAgentAnomalyDetectionScope(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific AgentAnomalyDetectionScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   GetAgentAnomalyDetectionScopeRequest request =
   *       GetAgentAnomalyDetectionScopeRequest.newBuilder()
   *           .setName(
   *               AgentAnomalyDetectionScopeName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AGENT_ANOMALY_DETECTION_SCOPE]")
   *                   .toString())
   *           .build();
   *   AgentAnomalyDetectionScope response =
   *       agentAnomalyDetectionServiceClient.getAgentAnomalyDetectionScope(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AgentAnomalyDetectionScope getAgentAnomalyDetectionScope(
      GetAgentAnomalyDetectionScopeRequest request) {
    return getAgentAnomalyDetectionScopeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific AgentAnomalyDetectionScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   GetAgentAnomalyDetectionScopeRequest request =
   *       GetAgentAnomalyDetectionScopeRequest.newBuilder()
   *           .setName(
   *               AgentAnomalyDetectionScopeName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AGENT_ANOMALY_DETECTION_SCOPE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<AgentAnomalyDetectionScope> future =
   *       agentAnomalyDetectionServiceClient
   *           .getAgentAnomalyDetectionScopeCallable()
   *           .futureCall(request);
   *   // Do something.
   *   AgentAnomalyDetectionScope response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAgentAnomalyDetectionScopeRequest, AgentAnomalyDetectionScope>
      getAgentAnomalyDetectionScopeCallable() {
    return stub.getAgentAnomalyDetectionScopeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific MonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   MonitoredAgentName name =
   *       MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]");
   *   MonitoredAgent response = agentAnomalyDetectionServiceClient.getMonitoredAgent(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the MonitoredAgent resource. Format:
   *     `projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MonitoredAgent getMonitoredAgent(@Nullable MonitoredAgentName name) {
    GetMonitoredAgentRequest request =
        GetMonitoredAgentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getMonitoredAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific MonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   String name =
   *       MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString();
   *   MonitoredAgent response = agentAnomalyDetectionServiceClient.getMonitoredAgent(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the MonitoredAgent resource. Format:
   *     `projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MonitoredAgent getMonitoredAgent(String name) {
    GetMonitoredAgentRequest request = GetMonitoredAgentRequest.newBuilder().setName(name).build();
    return getMonitoredAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific MonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   GetMonitoredAgentRequest request =
   *       GetMonitoredAgentRequest.newBuilder()
   *           .setName(
   *               MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString())
   *           .build();
   *   MonitoredAgent response = agentAnomalyDetectionServiceClient.getMonitoredAgent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MonitoredAgent getMonitoredAgent(GetMonitoredAgentRequest request) {
    return getMonitoredAgentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific MonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   GetMonitoredAgentRequest request =
   *       GetMonitoredAgentRequest.newBuilder()
   *           .setName(
   *               MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString())
   *           .build();
   *   ApiFuture<MonitoredAgent> future =
   *       agentAnomalyDetectionServiceClient.getMonitoredAgentCallable().futureCall(request);
   *   // Do something.
   *   MonitoredAgent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMonitoredAgentRequest, MonitoredAgent> getMonitoredAgentCallable() {
    return stub.getMonitoredAgentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MonitoredAgents in a specific Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (MonitoredAgent element :
   *       agentAnomalyDetectionServiceClient.listMonitoredAgents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the MonitoredAgents from.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMonitoredAgentsPagedResponse listMonitoredAgents(@Nullable LocationName parent) {
    ListMonitoredAgentsRequest request =
        ListMonitoredAgentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMonitoredAgents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MonitoredAgents in a specific Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (MonitoredAgent element :
   *       agentAnomalyDetectionServiceClient.listMonitoredAgents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the MonitoredAgents from.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMonitoredAgentsPagedResponse listMonitoredAgents(String parent) {
    ListMonitoredAgentsRequest request =
        ListMonitoredAgentsRequest.newBuilder().setParent(parent).build();
    return listMonitoredAgents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MonitoredAgents in a specific Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   ListMonitoredAgentsRequest request =
   *       ListMonitoredAgentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (MonitoredAgent element :
   *       agentAnomalyDetectionServiceClient.listMonitoredAgents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMonitoredAgentsPagedResponse listMonitoredAgents(
      ListMonitoredAgentsRequest request) {
    return listMonitoredAgentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MonitoredAgents in a specific Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   ListMonitoredAgentsRequest request =
   *       ListMonitoredAgentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<MonitoredAgent> future =
   *       agentAnomalyDetectionServiceClient.listMonitoredAgentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MonitoredAgent element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMonitoredAgentsRequest, ListMonitoredAgentsPagedResponse>
      listMonitoredAgentsPagedCallable() {
    return stub.listMonitoredAgentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists MonitoredAgents in a specific Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   ListMonitoredAgentsRequest request =
   *       ListMonitoredAgentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListMonitoredAgentsResponse response =
   *         agentAnomalyDetectionServiceClient.listMonitoredAgentsCallable().call(request);
   *     for (MonitoredAgent element : response.getMonitoredAgentsList()) {
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
  public final UnaryCallable<ListMonitoredAgentsRequest, ListMonitoredAgentsResponse>
      listMonitoredAgentsCallable() {
    return stub.listMonitoredAgentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a specific MonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   MonitoredAgentName name =
   *       MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]");
   *   MonitoredAgent response =
   *       agentAnomalyDetectionServiceClient.enableMonitoredAgentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the MonitoredAgent resource to be enabled. Format:
   *     `projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MonitoredAgent, EnableMonitoredAgentOperationMetadata>
      enableMonitoredAgentAsync(@Nullable MonitoredAgentName name) {
    EnableMonitoredAgentRequest request =
        EnableMonitoredAgentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return enableMonitoredAgentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a specific MonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   String name =
   *       MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString();
   *   MonitoredAgent response =
   *       agentAnomalyDetectionServiceClient.enableMonitoredAgentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the MonitoredAgent resource to be enabled. Format:
   *     `projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MonitoredAgent, EnableMonitoredAgentOperationMetadata>
      enableMonitoredAgentAsync(String name) {
    EnableMonitoredAgentRequest request =
        EnableMonitoredAgentRequest.newBuilder().setName(name).build();
    return enableMonitoredAgentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a specific MonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   EnableMonitoredAgentRequest request =
   *       EnableMonitoredAgentRequest.newBuilder()
   *           .setName(
   *               MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString())
   *           .build();
   *   MonitoredAgent response =
   *       agentAnomalyDetectionServiceClient.enableMonitoredAgentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MonitoredAgent, EnableMonitoredAgentOperationMetadata>
      enableMonitoredAgentAsync(EnableMonitoredAgentRequest request) {
    return enableMonitoredAgentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a specific MonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   EnableMonitoredAgentRequest request =
   *       EnableMonitoredAgentRequest.newBuilder()
   *           .setName(
   *               MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString())
   *           .build();
   *   OperationFuture<MonitoredAgent, EnableMonitoredAgentOperationMetadata> future =
   *       agentAnomalyDetectionServiceClient
   *           .enableMonitoredAgentOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   MonitoredAgent response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          EnableMonitoredAgentRequest, MonitoredAgent, EnableMonitoredAgentOperationMetadata>
      enableMonitoredAgentOperationCallable() {
    return stub.enableMonitoredAgentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables a specific MonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   EnableMonitoredAgentRequest request =
   *       EnableMonitoredAgentRequest.newBuilder()
   *           .setName(
   *               MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       agentAnomalyDetectionServiceClient.enableMonitoredAgentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EnableMonitoredAgentRequest, Operation>
      enableMonitoredAgentCallable() {
    return stub.enableMonitoredAgentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a specific MonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   MonitoredAgentName name =
   *       MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]");
   *   MonitoredAgent response =
   *       agentAnomalyDetectionServiceClient.disableMonitoredAgentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the MonitoredAgent resource to be disabled. Format:
   *     `projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MonitoredAgent, DisableMonitoredAgentOperationMetadata>
      disableMonitoredAgentAsync(@Nullable MonitoredAgentName name) {
    DisableMonitoredAgentRequest request =
        DisableMonitoredAgentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return disableMonitoredAgentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a specific MonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   String name =
   *       MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString();
   *   MonitoredAgent response =
   *       agentAnomalyDetectionServiceClient.disableMonitoredAgentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the MonitoredAgent resource to be disabled. Format:
   *     `projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MonitoredAgent, DisableMonitoredAgentOperationMetadata>
      disableMonitoredAgentAsync(String name) {
    DisableMonitoredAgentRequest request =
        DisableMonitoredAgentRequest.newBuilder().setName(name).build();
    return disableMonitoredAgentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a specific MonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   DisableMonitoredAgentRequest request =
   *       DisableMonitoredAgentRequest.newBuilder()
   *           .setName(
   *               MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString())
   *           .build();
   *   MonitoredAgent response =
   *       agentAnomalyDetectionServiceClient.disableMonitoredAgentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<MonitoredAgent, DisableMonitoredAgentOperationMetadata>
      disableMonitoredAgentAsync(DisableMonitoredAgentRequest request) {
    return disableMonitoredAgentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a specific MonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   DisableMonitoredAgentRequest request =
   *       DisableMonitoredAgentRequest.newBuilder()
   *           .setName(
   *               MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString())
   *           .build();
   *   OperationFuture<MonitoredAgent, DisableMonitoredAgentOperationMetadata> future =
   *       agentAnomalyDetectionServiceClient
   *           .disableMonitoredAgentOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   MonitoredAgent response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DisableMonitoredAgentRequest, MonitoredAgent, DisableMonitoredAgentOperationMetadata>
      disableMonitoredAgentOperationCallable() {
    return stub.disableMonitoredAgentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disables a specific MonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   DisableMonitoredAgentRequest request =
   *       DisableMonitoredAgentRequest.newBuilder()
   *           .setName(
   *               MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       agentAnomalyDetectionServiceClient.disableMonitoredAgentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DisableMonitoredAgentRequest, Operation>
      disableMonitoredAgentCallable() {
    return stub.disableMonitoredAgentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific AgentAnomalyDetectionScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   AgentAnomalyDetectionScopeName name =
   *       AgentAnomalyDetectionScopeName.of(
   *           "[PROJECT]", "[LOCATION]", "[AGENT_ANOMALY_DETECTION_SCOPE]");
   *   agentAnomalyDetectionServiceClient.deleteAgentAnomalyDetectionScopeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the AgentAnomalyDetectionScope resource to be deleted.
   *     Format:
   *     `projects/{project}/locations/{location}/agentAnomalyDetectionScopes/{agent_anomaly_detection_scope}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteAgentAnomalyDetectionScopeOperationMetadata>
      deleteAgentAnomalyDetectionScopeAsync(@Nullable AgentAnomalyDetectionScopeName name) {
    DeleteAgentAnomalyDetectionScopeRequest request =
        DeleteAgentAnomalyDetectionScopeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteAgentAnomalyDetectionScopeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific AgentAnomalyDetectionScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   String name =
   *       AgentAnomalyDetectionScopeName.of(
   *               "[PROJECT]", "[LOCATION]", "[AGENT_ANOMALY_DETECTION_SCOPE]")
   *           .toString();
   *   agentAnomalyDetectionServiceClient.deleteAgentAnomalyDetectionScopeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the AgentAnomalyDetectionScope resource to be deleted.
   *     Format:
   *     `projects/{project}/locations/{location}/agentAnomalyDetectionScopes/{agent_anomaly_detection_scope}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteAgentAnomalyDetectionScopeOperationMetadata>
      deleteAgentAnomalyDetectionScopeAsync(String name) {
    DeleteAgentAnomalyDetectionScopeRequest request =
        DeleteAgentAnomalyDetectionScopeRequest.newBuilder().setName(name).build();
    return deleteAgentAnomalyDetectionScopeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific AgentAnomalyDetectionScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   DeleteAgentAnomalyDetectionScopeRequest request =
   *       DeleteAgentAnomalyDetectionScopeRequest.newBuilder()
   *           .setName(
   *               AgentAnomalyDetectionScopeName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AGENT_ANOMALY_DETECTION_SCOPE]")
   *                   .toString())
   *           .build();
   *   agentAnomalyDetectionServiceClient.deleteAgentAnomalyDetectionScopeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteAgentAnomalyDetectionScopeOperationMetadata>
      deleteAgentAnomalyDetectionScopeAsync(DeleteAgentAnomalyDetectionScopeRequest request) {
    return deleteAgentAnomalyDetectionScopeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific AgentAnomalyDetectionScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   DeleteAgentAnomalyDetectionScopeRequest request =
   *       DeleteAgentAnomalyDetectionScopeRequest.newBuilder()
   *           .setName(
   *               AgentAnomalyDetectionScopeName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AGENT_ANOMALY_DETECTION_SCOPE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteAgentAnomalyDetectionScopeOperationMetadata> future =
   *       agentAnomalyDetectionServiceClient
   *           .deleteAgentAnomalyDetectionScopeOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteAgentAnomalyDetectionScopeRequest,
          Empty,
          DeleteAgentAnomalyDetectionScopeOperationMetadata>
      deleteAgentAnomalyDetectionScopeOperationCallable() {
    return stub.deleteAgentAnomalyDetectionScopeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specific AgentAnomalyDetectionScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   DeleteAgentAnomalyDetectionScopeRequest request =
   *       DeleteAgentAnomalyDetectionScopeRequest.newBuilder()
   *           .setName(
   *               AgentAnomalyDetectionScopeName.of(
   *                       "[PROJECT]", "[LOCATION]", "[AGENT_ANOMALY_DETECTION_SCOPE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       agentAnomalyDetectionServiceClient
   *           .deleteAgentAnomalyDetectionScopeCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAgentAnomalyDetectionScopeRequest, Operation>
      deleteAgentAnomalyDetectionScopeCallable() {
    return stub.deleteAgentAnomalyDetectionScopeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AgentAnomalyDetectionScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   AgentAnomalyDetectionScope agentAnomalyDetectionScope =
   *       AgentAnomalyDetectionScope.newBuilder().build();
   *   String agentAnomalyDetectionScopeId = "agentAnomalyDetectionScopeId-218530648";
   *   AgentAnomalyDetectionScope response =
   *       agentAnomalyDetectionServiceClient
   *           .createAgentAnomalyDetectionScopeAsync(
   *               parent, agentAnomalyDetectionScope, agentAnomalyDetectionScopeId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the
   *     AgentAnomalyDetectionScope in. Format: `projects/{project}/locations/{location}`
   * @param agentAnomalyDetectionScope Required. The AgentAnomalyDetectionScope to create.
   * @param agentAnomalyDetectionScopeId Required. The ID to use for the AgentAnomalyDetectionScope,
   *     which will become the final component of the AgentAnomalyDetectionScope's resource name.
   *     <p>This value should be 1-63 characters, and valid characters are
   *     /[a-z]([a-z0-9-]{0,61}[a-z0-9])?/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          AgentAnomalyDetectionScope, CreateAgentAnomalyDetectionScopeOperationMetadata>
      createAgentAnomalyDetectionScopeAsync(
          @Nullable LocationName parent,
          AgentAnomalyDetectionScope agentAnomalyDetectionScope,
          String agentAnomalyDetectionScopeId) {
    CreateAgentAnomalyDetectionScopeRequest request =
        CreateAgentAnomalyDetectionScopeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAgentAnomalyDetectionScope(agentAnomalyDetectionScope)
            .setAgentAnomalyDetectionScopeId(agentAnomalyDetectionScopeId)
            .build();
    return createAgentAnomalyDetectionScopeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AgentAnomalyDetectionScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   AgentAnomalyDetectionScope agentAnomalyDetectionScope =
   *       AgentAnomalyDetectionScope.newBuilder().build();
   *   String agentAnomalyDetectionScopeId = "agentAnomalyDetectionScopeId-218530648";
   *   AgentAnomalyDetectionScope response =
   *       agentAnomalyDetectionServiceClient
   *           .createAgentAnomalyDetectionScopeAsync(
   *               parent, agentAnomalyDetectionScope, agentAnomalyDetectionScopeId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the
   *     AgentAnomalyDetectionScope in. Format: `projects/{project}/locations/{location}`
   * @param agentAnomalyDetectionScope Required. The AgentAnomalyDetectionScope to create.
   * @param agentAnomalyDetectionScopeId Required. The ID to use for the AgentAnomalyDetectionScope,
   *     which will become the final component of the AgentAnomalyDetectionScope's resource name.
   *     <p>This value should be 1-63 characters, and valid characters are
   *     /[a-z]([a-z0-9-]{0,61}[a-z0-9])?/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          AgentAnomalyDetectionScope, CreateAgentAnomalyDetectionScopeOperationMetadata>
      createAgentAnomalyDetectionScopeAsync(
          String parent,
          AgentAnomalyDetectionScope agentAnomalyDetectionScope,
          String agentAnomalyDetectionScopeId) {
    CreateAgentAnomalyDetectionScopeRequest request =
        CreateAgentAnomalyDetectionScopeRequest.newBuilder()
            .setParent(parent)
            .setAgentAnomalyDetectionScope(agentAnomalyDetectionScope)
            .setAgentAnomalyDetectionScopeId(agentAnomalyDetectionScopeId)
            .build();
    return createAgentAnomalyDetectionScopeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AgentAnomalyDetectionScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   CreateAgentAnomalyDetectionScopeRequest request =
   *       CreateAgentAnomalyDetectionScopeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAgentAnomalyDetectionScope(AgentAnomalyDetectionScope.newBuilder().build())
   *           .setAgentAnomalyDetectionScopeId("agentAnomalyDetectionScopeId-218530648")
   *           .build();
   *   AgentAnomalyDetectionScope response =
   *       agentAnomalyDetectionServiceClient.createAgentAnomalyDetectionScopeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          AgentAnomalyDetectionScope, CreateAgentAnomalyDetectionScopeOperationMetadata>
      createAgentAnomalyDetectionScopeAsync(CreateAgentAnomalyDetectionScopeRequest request) {
    return createAgentAnomalyDetectionScopeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AgentAnomalyDetectionScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   CreateAgentAnomalyDetectionScopeRequest request =
   *       CreateAgentAnomalyDetectionScopeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAgentAnomalyDetectionScope(AgentAnomalyDetectionScope.newBuilder().build())
   *           .setAgentAnomalyDetectionScopeId("agentAnomalyDetectionScopeId-218530648")
   *           .build();
   *   OperationFuture<AgentAnomalyDetectionScope, CreateAgentAnomalyDetectionScopeOperationMetadata>
   *       future =
   *           agentAnomalyDetectionServiceClient
   *               .createAgentAnomalyDetectionScopeOperationCallable()
   *               .futureCall(request);
   *   // Do something.
   *   AgentAnomalyDetectionScope response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateAgentAnomalyDetectionScopeRequest,
          AgentAnomalyDetectionScope,
          CreateAgentAnomalyDetectionScopeOperationMetadata>
      createAgentAnomalyDetectionScopeOperationCallable() {
    return stub.createAgentAnomalyDetectionScopeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new AgentAnomalyDetectionScope.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   CreateAgentAnomalyDetectionScopeRequest request =
   *       CreateAgentAnomalyDetectionScopeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setAgentAnomalyDetectionScope(AgentAnomalyDetectionScope.newBuilder().build())
   *           .setAgentAnomalyDetectionScopeId("agentAnomalyDetectionScopeId-218530648")
   *           .build();
   *   ApiFuture<Operation> future =
   *       agentAnomalyDetectionServiceClient
   *           .createAgentAnomalyDetectionScopeCallable()
   *           .futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAgentAnomalyDetectionScopeRequest, Operation>
      createAgentAnomalyDetectionScopeCallable() {
    return stub.createAgentAnomalyDetectionScopeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AgentAnomalyDetectionScopes in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AgentAnomalyDetectionScope element :
   *       agentAnomalyDetectionServiceClient.listAgentAnomalyDetectionScopes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the
   *     AgentAnomalyDetectionScopes from. Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAgentAnomalyDetectionScopesPagedResponse listAgentAnomalyDetectionScopes(
      @Nullable LocationName parent) {
    ListAgentAnomalyDetectionScopesRequest request =
        ListAgentAnomalyDetectionScopesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAgentAnomalyDetectionScopes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AgentAnomalyDetectionScopes in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (AgentAnomalyDetectionScope element :
   *       agentAnomalyDetectionServiceClient.listAgentAnomalyDetectionScopes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the
   *     AgentAnomalyDetectionScopes from. Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAgentAnomalyDetectionScopesPagedResponse listAgentAnomalyDetectionScopes(
      String parent) {
    ListAgentAnomalyDetectionScopesRequest request =
        ListAgentAnomalyDetectionScopesRequest.newBuilder().setParent(parent).build();
    return listAgentAnomalyDetectionScopes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AgentAnomalyDetectionScopes in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   ListAgentAnomalyDetectionScopesRequest request =
   *       ListAgentAnomalyDetectionScopesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AgentAnomalyDetectionScope element :
   *       agentAnomalyDetectionServiceClient
   *           .listAgentAnomalyDetectionScopes(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAgentAnomalyDetectionScopesPagedResponse listAgentAnomalyDetectionScopes(
      ListAgentAnomalyDetectionScopesRequest request) {
    return listAgentAnomalyDetectionScopesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AgentAnomalyDetectionScopes in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   ListAgentAnomalyDetectionScopesRequest request =
   *       ListAgentAnomalyDetectionScopesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AgentAnomalyDetectionScope> future =
   *       agentAnomalyDetectionServiceClient
   *           .listAgentAnomalyDetectionScopesPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (AgentAnomalyDetectionScope element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListAgentAnomalyDetectionScopesRequest, ListAgentAnomalyDetectionScopesPagedResponse>
      listAgentAnomalyDetectionScopesPagedCallable() {
    return stub.listAgentAnomalyDetectionScopesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AgentAnomalyDetectionScopes in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   ListAgentAnomalyDetectionScopesRequest request =
   *       ListAgentAnomalyDetectionScopesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAgentAnomalyDetectionScopesResponse response =
   *         agentAnomalyDetectionServiceClient
   *             .listAgentAnomalyDetectionScopesCallable()
   *             .call(request);
   *     for (AgentAnomalyDetectionScope element : response.getAgentAnomalyDetectionScopesList()) {
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
          ListAgentAnomalyDetectionScopesRequest, ListAgentAnomalyDetectionScopesResponse>
      listAgentAnomalyDetectionScopesCallable() {
    return stub.listAgentAnomalyDetectionScopesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AnalyzedSessions in a MonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   MonitoredAgentName parent =
   *       MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]");
   *   for (AnalyzedSession element :
   *       agentAnomalyDetectionServiceClient.listAnalyzedSessions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent MonitoredAgent resource. Format:
   *     `projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnalyzedSessionsPagedResponse listAnalyzedSessions(
      @Nullable MonitoredAgentName parent) {
    ListAnalyzedSessionsRequest request =
        ListAnalyzedSessionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAnalyzedSessions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AnalyzedSessions in a MonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   String parent =
   *       MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString();
   *   for (AnalyzedSession element :
   *       agentAnomalyDetectionServiceClient.listAnalyzedSessions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent MonitoredAgent resource. Format:
   *     `projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnalyzedSessionsPagedResponse listAnalyzedSessions(String parent) {
    ListAnalyzedSessionsRequest request =
        ListAnalyzedSessionsRequest.newBuilder().setParent(parent).build();
    return listAnalyzedSessions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AnalyzedSessions in a MonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   ListAnalyzedSessionsRequest request =
   *       ListAnalyzedSessionsRequest.newBuilder()
   *           .setParent(
   *               MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setView(AnalyzedSessionView.forNumber(0))
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (AnalyzedSession element :
   *       agentAnomalyDetectionServiceClient.listAnalyzedSessions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnalyzedSessionsPagedResponse listAnalyzedSessions(
      ListAnalyzedSessionsRequest request) {
    return listAnalyzedSessionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AnalyzedSessions in a MonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   ListAnalyzedSessionsRequest request =
   *       ListAnalyzedSessionsRequest.newBuilder()
   *           .setParent(
   *               MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setView(AnalyzedSessionView.forNumber(0))
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<AnalyzedSession> future =
   *       agentAnomalyDetectionServiceClient
   *           .listAnalyzedSessionsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (AnalyzedSession element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAnalyzedSessionsRequest, ListAnalyzedSessionsPagedResponse>
      listAnalyzedSessionsPagedCallable() {
    return stub.listAnalyzedSessionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AnalyzedSessions in a MonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   ListAnalyzedSessionsRequest request =
   *       ListAnalyzedSessionsRequest.newBuilder()
   *           .setParent(
   *               MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setView(AnalyzedSessionView.forNumber(0))
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListAnalyzedSessionsResponse response =
   *         agentAnomalyDetectionServiceClient.listAnalyzedSessionsCallable().call(request);
   *     for (AnalyzedSession element : response.getAnalyzedSessionsList()) {
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
  public final UnaryCallable<ListAnalyzedSessionsRequest, ListAnalyzedSessionsResponse>
      listAnalyzedSessionsCallable() {
    return stub.listAnalyzedSessionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific AnalyzedSession.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   AnalyzedSessionName name =
   *       AnalyzedSessionName.of(
   *           "[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]", "[ANALYZED_SESSION]");
   *   AnalyzedSession response = agentAnomalyDetectionServiceClient.getAnalyzedSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the AnalyzedSession resource. Format:
   *     `projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}/analyzedSessions/{analyzed_session}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyzedSession getAnalyzedSession(@Nullable AnalyzedSessionName name) {
    GetAnalyzedSessionRequest request =
        GetAnalyzedSessionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAnalyzedSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific AnalyzedSession.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   String name =
   *       AnalyzedSessionName.of(
   *               "[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]", "[ANALYZED_SESSION]")
   *           .toString();
   *   AnalyzedSession response = agentAnomalyDetectionServiceClient.getAnalyzedSession(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the AnalyzedSession resource. Format:
   *     `projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}/analyzedSessions/{analyzed_session}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyzedSession getAnalyzedSession(String name) {
    GetAnalyzedSessionRequest request =
        GetAnalyzedSessionRequest.newBuilder().setName(name).build();
    return getAnalyzedSession(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific AnalyzedSession.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   GetAnalyzedSessionRequest request =
   *       GetAnalyzedSessionRequest.newBuilder()
   *           .setName(
   *               AnalyzedSessionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]", "[ANALYZED_SESSION]")
   *                   .toString())
   *           .setView(AnalyzedSessionView.forNumber(0))
   *           .build();
   *   AnalyzedSession response = agentAnomalyDetectionServiceClient.getAnalyzedSession(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyzedSession getAnalyzedSession(GetAnalyzedSessionRequest request) {
    return getAnalyzedSessionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific AnalyzedSession.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   GetAnalyzedSessionRequest request =
   *       GetAnalyzedSessionRequest.newBuilder()
   *           .setName(
   *               AnalyzedSessionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]", "[ANALYZED_SESSION]")
   *                   .toString())
   *           .setView(AnalyzedSessionView.forNumber(0))
   *           .build();
   *   ApiFuture<AnalyzedSession> future =
   *       agentAnomalyDetectionServiceClient.getAnalyzedSessionCallable().futureCall(request);
   *   // Do something.
   *   AnalyzedSession response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAnalyzedSessionRequest, AnalyzedSession>
      getAnalyzedSessionCallable() {
    return stub.getAnalyzedSessionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AnalyzedInvocations in a MonitoredAgent's AnalyzedSession.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   AnalyzedSessionName parent =
   *       AnalyzedSessionName.of(
   *           "[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]", "[ANALYZED_SESSION]");
   *   for (AnalyzedInvocation element :
   *       agentAnomalyDetectionServiceClient.listAnalyzedInvocations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent AnalyzedSession resource. Format:
   *     `projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}/analyzedSessions/{analyzed_session}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnalyzedInvocationsPagedResponse listAnalyzedInvocations(
      @Nullable AnalyzedSessionName parent) {
    ListAnalyzedInvocationsRequest request =
        ListAnalyzedInvocationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAnalyzedInvocations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AnalyzedInvocations in a MonitoredAgent's AnalyzedSession.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   String parent =
   *       AnalyzedSessionName.of(
   *               "[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]", "[ANALYZED_SESSION]")
   *           .toString();
   *   for (AnalyzedInvocation element :
   *       agentAnomalyDetectionServiceClient.listAnalyzedInvocations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent AnalyzedSession resource. Format:
   *     `projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}/analyzedSessions/{analyzed_session}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnalyzedInvocationsPagedResponse listAnalyzedInvocations(String parent) {
    ListAnalyzedInvocationsRequest request =
        ListAnalyzedInvocationsRequest.newBuilder().setParent(parent).build();
    return listAnalyzedInvocations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AnalyzedInvocations in a MonitoredAgent's AnalyzedSession.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   ListAnalyzedInvocationsRequest request =
   *       ListAnalyzedInvocationsRequest.newBuilder()
   *           .setParent(
   *               AnalyzedSessionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]", "[ANALYZED_SESSION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AnalyzedInvocation element :
   *       agentAnomalyDetectionServiceClient.listAnalyzedInvocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAnalyzedInvocationsPagedResponse listAnalyzedInvocations(
      ListAnalyzedInvocationsRequest request) {
    return listAnalyzedInvocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AnalyzedInvocations in a MonitoredAgent's AnalyzedSession.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   ListAnalyzedInvocationsRequest request =
   *       ListAnalyzedInvocationsRequest.newBuilder()
   *           .setParent(
   *               AnalyzedSessionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]", "[ANALYZED_SESSION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AnalyzedInvocation> future =
   *       agentAnomalyDetectionServiceClient
   *           .listAnalyzedInvocationsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (AnalyzedInvocation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAnalyzedInvocationsRequest, ListAnalyzedInvocationsPagedResponse>
      listAnalyzedInvocationsPagedCallable() {
    return stub.listAnalyzedInvocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists AnalyzedInvocations in a MonitoredAgent's AnalyzedSession.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   ListAnalyzedInvocationsRequest request =
   *       ListAnalyzedInvocationsRequest.newBuilder()
   *           .setParent(
   *               AnalyzedSessionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]", "[ANALYZED_SESSION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAnalyzedInvocationsResponse response =
   *         agentAnomalyDetectionServiceClient.listAnalyzedInvocationsCallable().call(request);
   *     for (AnalyzedInvocation element : response.getAnalyzedInvocationsList()) {
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
  public final UnaryCallable<ListAnalyzedInvocationsRequest, ListAnalyzedInvocationsResponse>
      listAnalyzedInvocationsCallable() {
    return stub.listAnalyzedInvocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific AnalyzedInvocation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   AnalyzedInvocationName name =
   *       AnalyzedInvocationName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[MONITORED_AGENT]",
   *           "[ANALYZED_SESSION]",
   *           "[ANALYZED_INVOCATION]");
   *   AnalyzedInvocation response = agentAnomalyDetectionServiceClient.getAnalyzedInvocation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the AnalyzedInvocation resource. Format:
   *     `projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}/analyzedSessions/{analyzed_session}/analyzedInvocations/{analyzed_invocation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyzedInvocation getAnalyzedInvocation(@Nullable AnalyzedInvocationName name) {
    GetAnalyzedInvocationRequest request =
        GetAnalyzedInvocationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAnalyzedInvocation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific AnalyzedInvocation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   String name =
   *       AnalyzedInvocationName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[MONITORED_AGENT]",
   *               "[ANALYZED_SESSION]",
   *               "[ANALYZED_INVOCATION]")
   *           .toString();
   *   AnalyzedInvocation response = agentAnomalyDetectionServiceClient.getAnalyzedInvocation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the AnalyzedInvocation resource. Format:
   *     `projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}/analyzedSessions/{analyzed_session}/analyzedInvocations/{analyzed_invocation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyzedInvocation getAnalyzedInvocation(String name) {
    GetAnalyzedInvocationRequest request =
        GetAnalyzedInvocationRequest.newBuilder().setName(name).build();
    return getAnalyzedInvocation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific AnalyzedInvocation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   GetAnalyzedInvocationRequest request =
   *       GetAnalyzedInvocationRequest.newBuilder()
   *           .setName(
   *               AnalyzedInvocationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[MONITORED_AGENT]",
   *                       "[ANALYZED_SESSION]",
   *                       "[ANALYZED_INVOCATION]")
   *                   .toString())
   *           .build();
   *   AnalyzedInvocation response =
   *       agentAnomalyDetectionServiceClient.getAnalyzedInvocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyzedInvocation getAnalyzedInvocation(GetAnalyzedInvocationRequest request) {
    return getAnalyzedInvocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details of a specific AnalyzedInvocation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   GetAnalyzedInvocationRequest request =
   *       GetAnalyzedInvocationRequest.newBuilder()
   *           .setName(
   *               AnalyzedInvocationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[MONITORED_AGENT]",
   *                       "[ANALYZED_SESSION]",
   *                       "[ANALYZED_INVOCATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<AnalyzedInvocation> future =
   *       agentAnomalyDetectionServiceClient.getAnalyzedInvocationCallable().futureCall(request);
   *   // Do something.
   *   AnalyzedInvocation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAnalyzedInvocationRequest, AnalyzedInvocation>
      getAnalyzedInvocationCallable() {
    return stub.getAnalyzedInvocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Aggregates AnalyzedSessions across MonitoredAgents.
   *
   * <p>To aggregate across all MonitoredAgents in a location, use the following format for the
   * parent field: `projects/{project}/locations/{location}/monitoredAgents/-`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   MonitoredAgentName parent =
   *       MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]");
   *   for (AggregateAnalyzedSessionsResponse.AgentAggregate element :
   *       agentAnomalyDetectionServiceClient.aggregateAnalyzedSessions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent MonitoredAgent resource. Use the `-` wildcard for the
   *     monitored_agent segment to aggregate across multiple agents in the location. Format:
   *     `projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregateAnalyzedSessionsPagedResponse aggregateAnalyzedSessions(
      @Nullable MonitoredAgentName parent) {
    AggregateAnalyzedSessionsRequest request =
        AggregateAnalyzedSessionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return aggregateAnalyzedSessions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Aggregates AnalyzedSessions across MonitoredAgents.
   *
   * <p>To aggregate across all MonitoredAgents in a location, use the following format for the
   * parent field: `projects/{project}/locations/{location}/monitoredAgents/-`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   String parent =
   *       MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString();
   *   for (AggregateAnalyzedSessionsResponse.AgentAggregate element :
   *       agentAnomalyDetectionServiceClient.aggregateAnalyzedSessions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent MonitoredAgent resource. Use the `-` wildcard for the
   *     monitored_agent segment to aggregate across multiple agents in the location. Format:
   *     `projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregateAnalyzedSessionsPagedResponse aggregateAnalyzedSessions(String parent) {
    AggregateAnalyzedSessionsRequest request =
        AggregateAnalyzedSessionsRequest.newBuilder().setParent(parent).build();
    return aggregateAnalyzedSessions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Aggregates AnalyzedSessions across MonitoredAgents.
   *
   * <p>To aggregate across all MonitoredAgents in a location, use the following format for the
   * parent field: `projects/{project}/locations/{location}/monitoredAgents/-`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   AggregateAnalyzedSessionsRequest request =
   *       AggregateAnalyzedSessionsRequest.newBuilder()
   *           .setParent(
   *               MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AggregateAnalyzedSessionsResponse.AgentAggregate element :
   *       agentAnomalyDetectionServiceClient.aggregateAnalyzedSessions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregateAnalyzedSessionsPagedResponse aggregateAnalyzedSessions(
      AggregateAnalyzedSessionsRequest request) {
    return aggregateAnalyzedSessionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Aggregates AnalyzedSessions across MonitoredAgents.
   *
   * <p>To aggregate across all MonitoredAgents in a location, use the following format for the
   * parent field: `projects/{project}/locations/{location}/monitoredAgents/-`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   AggregateAnalyzedSessionsRequest request =
   *       AggregateAnalyzedSessionsRequest.newBuilder()
   *           .setParent(
   *               MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AggregateAnalyzedSessionsResponse.AgentAggregate> future =
   *       agentAnomalyDetectionServiceClient
   *           .aggregateAnalyzedSessionsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (AggregateAnalyzedSessionsResponse.AgentAggregate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          AggregateAnalyzedSessionsRequest, AggregateAnalyzedSessionsPagedResponse>
      aggregateAnalyzedSessionsPagedCallable() {
    return stub.aggregateAnalyzedSessionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Aggregates AnalyzedSessions across MonitoredAgents.
   *
   * <p>To aggregate across all MonitoredAgents in a location, use the following format for the
   * parent field: `projects/{project}/locations/{location}/monitoredAgents/-`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   AggregateAnalyzedSessionsRequest request =
   *       AggregateAnalyzedSessionsRequest.newBuilder()
   *           .setParent(
   *               MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     AggregateAnalyzedSessionsResponse response =
   *         agentAnomalyDetectionServiceClient.aggregateAnalyzedSessionsCallable().call(request);
   *     for (AggregateAnalyzedSessionsResponse.AgentAggregate element :
   *         response.getAgentAggregatesList()) {
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
  public final UnaryCallable<AggregateAnalyzedSessionsRequest, AggregateAnalyzedSessionsResponse>
      aggregateAnalyzedSessionsCallable() {
    return stub.aggregateAnalyzedSessionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Clears (purges) the trained model artifacts derived from a MonitoredAgent's data. The purged
   * model is rebuilt by the next scheduled training run.
   *
   * <p>To clear every MonitoredAgent in a location's scope, use the `-` wildcard agent segment for
   * the name field: `projects/{project}/locations/{location}/monitoredAgents/-`
   *
   * <p>This is the on-demand data-deletion path for customers who have deleted the underlying logs
   * / observability data a model was trained on. It deletes only the derived model artifacts (it
   * does NOT delete the scope or stop monitoring). To stop monitoring an agent entirely, disable it
   * via DisableMonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   MonitoredAgentName name =
   *       MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]");
   *   ClearTrainingDataResponse response =
   *       agentAnomalyDetectionServiceClient.clearTrainingDataAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The MonitoredAgent whose trained model artifacts to purge. Use the `-`
   *     wildcard agent segment to purge every MonitoredAgent in the scope. Format:
   *     `projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ClearTrainingDataResponse, ClearTrainingDataOperationMetadata>
      clearTrainingDataAsync(@Nullable MonitoredAgentName name) {
    ClearTrainingDataRequest request =
        ClearTrainingDataRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return clearTrainingDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Clears (purges) the trained model artifacts derived from a MonitoredAgent's data. The purged
   * model is rebuilt by the next scheduled training run.
   *
   * <p>To clear every MonitoredAgent in a location's scope, use the `-` wildcard agent segment for
   * the name field: `projects/{project}/locations/{location}/monitoredAgents/-`
   *
   * <p>This is the on-demand data-deletion path for customers who have deleted the underlying logs
   * / observability data a model was trained on. It deletes only the derived model artifacts (it
   * does NOT delete the scope or stop monitoring). To stop monitoring an agent entirely, disable it
   * via DisableMonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   String name =
   *       MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString();
   *   ClearTrainingDataResponse response =
   *       agentAnomalyDetectionServiceClient.clearTrainingDataAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The MonitoredAgent whose trained model artifacts to purge. Use the `-`
   *     wildcard agent segment to purge every MonitoredAgent in the scope. Format:
   *     `projects/{project}/locations/{location}/monitoredAgents/{monitored_agent}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ClearTrainingDataResponse, ClearTrainingDataOperationMetadata>
      clearTrainingDataAsync(String name) {
    ClearTrainingDataRequest request = ClearTrainingDataRequest.newBuilder().setName(name).build();
    return clearTrainingDataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Clears (purges) the trained model artifacts derived from a MonitoredAgent's data. The purged
   * model is rebuilt by the next scheduled training run.
   *
   * <p>To clear every MonitoredAgent in a location's scope, use the `-` wildcard agent segment for
   * the name field: `projects/{project}/locations/{location}/monitoredAgents/-`
   *
   * <p>This is the on-demand data-deletion path for customers who have deleted the underlying logs
   * / observability data a model was trained on. It deletes only the derived model artifacts (it
   * does NOT delete the scope or stop monitoring). To stop monitoring an agent entirely, disable it
   * via DisableMonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   ClearTrainingDataRequest request =
   *       ClearTrainingDataRequest.newBuilder()
   *           .setName(
   *               MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString())
   *           .build();
   *   ClearTrainingDataResponse response =
   *       agentAnomalyDetectionServiceClient.clearTrainingDataAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ClearTrainingDataResponse, ClearTrainingDataOperationMetadata>
      clearTrainingDataAsync(ClearTrainingDataRequest request) {
    return clearTrainingDataOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Clears (purges) the trained model artifacts derived from a MonitoredAgent's data. The purged
   * model is rebuilt by the next scheduled training run.
   *
   * <p>To clear every MonitoredAgent in a location's scope, use the `-` wildcard agent segment for
   * the name field: `projects/{project}/locations/{location}/monitoredAgents/-`
   *
   * <p>This is the on-demand data-deletion path for customers who have deleted the underlying logs
   * / observability data a model was trained on. It deletes only the derived model artifacts (it
   * does NOT delete the scope or stop monitoring). To stop monitoring an agent entirely, disable it
   * via DisableMonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   ClearTrainingDataRequest request =
   *       ClearTrainingDataRequest.newBuilder()
   *           .setName(
   *               MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString())
   *           .build();
   *   OperationFuture<ClearTrainingDataResponse, ClearTrainingDataOperationMetadata> future =
   *       agentAnomalyDetectionServiceClient
   *           .clearTrainingDataOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ClearTrainingDataResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ClearTrainingDataRequest, ClearTrainingDataResponse, ClearTrainingDataOperationMetadata>
      clearTrainingDataOperationCallable() {
    return stub.clearTrainingDataOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Clears (purges) the trained model artifacts derived from a MonitoredAgent's data. The purged
   * model is rebuilt by the next scheduled training run.
   *
   * <p>To clear every MonitoredAgent in a location's scope, use the `-` wildcard agent segment for
   * the name field: `projects/{project}/locations/{location}/monitoredAgents/-`
   *
   * <p>This is the on-demand data-deletion path for customers who have deleted the underlying logs
   * / observability data a model was trained on. It deletes only the derived model artifacts (it
   * does NOT delete the scope or stop monitoring). To stop monitoring an agent entirely, disable it
   * via DisableMonitoredAgent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   ClearTrainingDataRequest request =
   *       ClearTrainingDataRequest.newBuilder()
   *           .setName(
   *               MonitoredAgentName.of("[PROJECT]", "[LOCATION]", "[MONITORED_AGENT]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       agentAnomalyDetectionServiceClient.clearTrainingDataCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ClearTrainingDataRequest, Operation> clearTrainingDataCallable() {
    return stub.clearTrainingDataCallable();
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
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element :
   *       agentAnomalyDetectionServiceClient.listLocations(request).iterateAll()) {
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
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       agentAnomalyDetectionServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         agentAnomalyDetectionServiceClient.listLocationsCallable().call(request);
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
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = agentAnomalyDetectionServiceClient.getLocation(request);
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
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       agentAnomalyDetectionServiceClient.getLocationCallable().futureCall(request);
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
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = agentAnomalyDetectionServiceClient.setIamPolicy(request);
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
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       agentAnomalyDetectionServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = agentAnomalyDetectionServiceClient.getIamPolicy(request);
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
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       agentAnomalyDetectionServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response =
   *       agentAnomalyDetectionServiceClient.testIamPermissions(request);
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
   * try (AgentAnomalyDetectionServiceClient agentAnomalyDetectionServiceClient =
   *     AgentAnomalyDetectionServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       agentAnomalyDetectionServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListMonitoredAgentsPagedResponse
      extends AbstractPagedListResponse<
          ListMonitoredAgentsRequest,
          ListMonitoredAgentsResponse,
          MonitoredAgent,
          ListMonitoredAgentsPage,
          ListMonitoredAgentsFixedSizeCollection> {

    public static ApiFuture<ListMonitoredAgentsPagedResponse> createAsync(
        PageContext<ListMonitoredAgentsRequest, ListMonitoredAgentsResponse, MonitoredAgent>
            context,
        ApiFuture<ListMonitoredAgentsResponse> futureResponse) {
      ApiFuture<ListMonitoredAgentsPage> futurePage =
          ListMonitoredAgentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMonitoredAgentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMonitoredAgentsPagedResponse(ListMonitoredAgentsPage page) {
      super(page, ListMonitoredAgentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMonitoredAgentsPage
      extends AbstractPage<
          ListMonitoredAgentsRequest,
          ListMonitoredAgentsResponse,
          MonitoredAgent,
          ListMonitoredAgentsPage> {

    private ListMonitoredAgentsPage(
        @Nullable
            PageContext<ListMonitoredAgentsRequest, ListMonitoredAgentsResponse, MonitoredAgent>
            context,
        @Nullable ListMonitoredAgentsResponse response) {
      super(context, response);
    }

    private static ListMonitoredAgentsPage createEmptyPage() {
      return new ListMonitoredAgentsPage(null, null);
    }

    @Override
    protected ListMonitoredAgentsPage createPage(
        @Nullable
            PageContext<ListMonitoredAgentsRequest, ListMonitoredAgentsResponse, MonitoredAgent>
            context,
        @Nullable ListMonitoredAgentsResponse response) {
      return new ListMonitoredAgentsPage(context, response);
    }

    @Override
    public ApiFuture<ListMonitoredAgentsPage> createPageAsync(
        @Nullable
            PageContext<ListMonitoredAgentsRequest, ListMonitoredAgentsResponse, MonitoredAgent>
            context,
        ApiFuture<ListMonitoredAgentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMonitoredAgentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMonitoredAgentsRequest,
          ListMonitoredAgentsResponse,
          MonitoredAgent,
          ListMonitoredAgentsPage,
          ListMonitoredAgentsFixedSizeCollection> {

    private ListMonitoredAgentsFixedSizeCollection(
        @Nullable List<ListMonitoredAgentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMonitoredAgentsFixedSizeCollection createEmptyCollection() {
      return new ListMonitoredAgentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMonitoredAgentsFixedSizeCollection createCollection(
        @Nullable List<ListMonitoredAgentsPage> pages, int collectionSize) {
      return new ListMonitoredAgentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAgentAnomalyDetectionScopesPagedResponse
      extends AbstractPagedListResponse<
          ListAgentAnomalyDetectionScopesRequest,
          ListAgentAnomalyDetectionScopesResponse,
          AgentAnomalyDetectionScope,
          ListAgentAnomalyDetectionScopesPage,
          ListAgentAnomalyDetectionScopesFixedSizeCollection> {

    public static ApiFuture<ListAgentAnomalyDetectionScopesPagedResponse> createAsync(
        PageContext<
                ListAgentAnomalyDetectionScopesRequest,
                ListAgentAnomalyDetectionScopesResponse,
                AgentAnomalyDetectionScope>
            context,
        ApiFuture<ListAgentAnomalyDetectionScopesResponse> futureResponse) {
      ApiFuture<ListAgentAnomalyDetectionScopesPage> futurePage =
          ListAgentAnomalyDetectionScopesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAgentAnomalyDetectionScopesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAgentAnomalyDetectionScopesPagedResponse(ListAgentAnomalyDetectionScopesPage page) {
      super(page, ListAgentAnomalyDetectionScopesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAgentAnomalyDetectionScopesPage
      extends AbstractPage<
          ListAgentAnomalyDetectionScopesRequest,
          ListAgentAnomalyDetectionScopesResponse,
          AgentAnomalyDetectionScope,
          ListAgentAnomalyDetectionScopesPage> {

    private ListAgentAnomalyDetectionScopesPage(
        @Nullable
            PageContext<
                ListAgentAnomalyDetectionScopesRequest,
                ListAgentAnomalyDetectionScopesResponse,
                AgentAnomalyDetectionScope>
            context,
        @Nullable ListAgentAnomalyDetectionScopesResponse response) {
      super(context, response);
    }

    private static ListAgentAnomalyDetectionScopesPage createEmptyPage() {
      return new ListAgentAnomalyDetectionScopesPage(null, null);
    }

    @Override
    protected ListAgentAnomalyDetectionScopesPage createPage(
        @Nullable
            PageContext<
                ListAgentAnomalyDetectionScopesRequest,
                ListAgentAnomalyDetectionScopesResponse,
                AgentAnomalyDetectionScope>
            context,
        @Nullable ListAgentAnomalyDetectionScopesResponse response) {
      return new ListAgentAnomalyDetectionScopesPage(context, response);
    }

    @Override
    public ApiFuture<ListAgentAnomalyDetectionScopesPage> createPageAsync(
        @Nullable
            PageContext<
                ListAgentAnomalyDetectionScopesRequest,
                ListAgentAnomalyDetectionScopesResponse,
                AgentAnomalyDetectionScope>
            context,
        ApiFuture<ListAgentAnomalyDetectionScopesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAgentAnomalyDetectionScopesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAgentAnomalyDetectionScopesRequest,
          ListAgentAnomalyDetectionScopesResponse,
          AgentAnomalyDetectionScope,
          ListAgentAnomalyDetectionScopesPage,
          ListAgentAnomalyDetectionScopesFixedSizeCollection> {

    private ListAgentAnomalyDetectionScopesFixedSizeCollection(
        @Nullable List<ListAgentAnomalyDetectionScopesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAgentAnomalyDetectionScopesFixedSizeCollection createEmptyCollection() {
      return new ListAgentAnomalyDetectionScopesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAgentAnomalyDetectionScopesFixedSizeCollection createCollection(
        @Nullable List<ListAgentAnomalyDetectionScopesPage> pages, int collectionSize) {
      return new ListAgentAnomalyDetectionScopesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAnalyzedSessionsPagedResponse
      extends AbstractPagedListResponse<
          ListAnalyzedSessionsRequest,
          ListAnalyzedSessionsResponse,
          AnalyzedSession,
          ListAnalyzedSessionsPage,
          ListAnalyzedSessionsFixedSizeCollection> {

    public static ApiFuture<ListAnalyzedSessionsPagedResponse> createAsync(
        PageContext<ListAnalyzedSessionsRequest, ListAnalyzedSessionsResponse, AnalyzedSession>
            context,
        ApiFuture<ListAnalyzedSessionsResponse> futureResponse) {
      ApiFuture<ListAnalyzedSessionsPage> futurePage =
          ListAnalyzedSessionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAnalyzedSessionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAnalyzedSessionsPagedResponse(ListAnalyzedSessionsPage page) {
      super(page, ListAnalyzedSessionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAnalyzedSessionsPage
      extends AbstractPage<
          ListAnalyzedSessionsRequest,
          ListAnalyzedSessionsResponse,
          AnalyzedSession,
          ListAnalyzedSessionsPage> {

    private ListAnalyzedSessionsPage(
        @Nullable
            PageContext<ListAnalyzedSessionsRequest, ListAnalyzedSessionsResponse, AnalyzedSession>
            context,
        @Nullable ListAnalyzedSessionsResponse response) {
      super(context, response);
    }

    private static ListAnalyzedSessionsPage createEmptyPage() {
      return new ListAnalyzedSessionsPage(null, null);
    }

    @Override
    protected ListAnalyzedSessionsPage createPage(
        @Nullable
            PageContext<ListAnalyzedSessionsRequest, ListAnalyzedSessionsResponse, AnalyzedSession>
            context,
        @Nullable ListAnalyzedSessionsResponse response) {
      return new ListAnalyzedSessionsPage(context, response);
    }

    @Override
    public ApiFuture<ListAnalyzedSessionsPage> createPageAsync(
        @Nullable
            PageContext<ListAnalyzedSessionsRequest, ListAnalyzedSessionsResponse, AnalyzedSession>
            context,
        ApiFuture<ListAnalyzedSessionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAnalyzedSessionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAnalyzedSessionsRequest,
          ListAnalyzedSessionsResponse,
          AnalyzedSession,
          ListAnalyzedSessionsPage,
          ListAnalyzedSessionsFixedSizeCollection> {

    private ListAnalyzedSessionsFixedSizeCollection(
        @Nullable List<ListAnalyzedSessionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAnalyzedSessionsFixedSizeCollection createEmptyCollection() {
      return new ListAnalyzedSessionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAnalyzedSessionsFixedSizeCollection createCollection(
        @Nullable List<ListAnalyzedSessionsPage> pages, int collectionSize) {
      return new ListAnalyzedSessionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListAnalyzedInvocationsPagedResponse
      extends AbstractPagedListResponse<
          ListAnalyzedInvocationsRequest,
          ListAnalyzedInvocationsResponse,
          AnalyzedInvocation,
          ListAnalyzedInvocationsPage,
          ListAnalyzedInvocationsFixedSizeCollection> {

    public static ApiFuture<ListAnalyzedInvocationsPagedResponse> createAsync(
        PageContext<
                ListAnalyzedInvocationsRequest, ListAnalyzedInvocationsResponse, AnalyzedInvocation>
            context,
        ApiFuture<ListAnalyzedInvocationsResponse> futureResponse) {
      ApiFuture<ListAnalyzedInvocationsPage> futurePage =
          ListAnalyzedInvocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAnalyzedInvocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAnalyzedInvocationsPagedResponse(ListAnalyzedInvocationsPage page) {
      super(page, ListAnalyzedInvocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAnalyzedInvocationsPage
      extends AbstractPage<
          ListAnalyzedInvocationsRequest,
          ListAnalyzedInvocationsResponse,
          AnalyzedInvocation,
          ListAnalyzedInvocationsPage> {

    private ListAnalyzedInvocationsPage(
        @Nullable
            PageContext<
                ListAnalyzedInvocationsRequest, ListAnalyzedInvocationsResponse, AnalyzedInvocation>
            context,
        @Nullable ListAnalyzedInvocationsResponse response) {
      super(context, response);
    }

    private static ListAnalyzedInvocationsPage createEmptyPage() {
      return new ListAnalyzedInvocationsPage(null, null);
    }

    @Override
    protected ListAnalyzedInvocationsPage createPage(
        @Nullable
            PageContext<
                ListAnalyzedInvocationsRequest, ListAnalyzedInvocationsResponse, AnalyzedInvocation>
            context,
        @Nullable ListAnalyzedInvocationsResponse response) {
      return new ListAnalyzedInvocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListAnalyzedInvocationsPage> createPageAsync(
        @Nullable
            PageContext<
                ListAnalyzedInvocationsRequest, ListAnalyzedInvocationsResponse, AnalyzedInvocation>
            context,
        ApiFuture<ListAnalyzedInvocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAnalyzedInvocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAnalyzedInvocationsRequest,
          ListAnalyzedInvocationsResponse,
          AnalyzedInvocation,
          ListAnalyzedInvocationsPage,
          ListAnalyzedInvocationsFixedSizeCollection> {

    private ListAnalyzedInvocationsFixedSizeCollection(
        @Nullable List<ListAnalyzedInvocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAnalyzedInvocationsFixedSizeCollection createEmptyCollection() {
      return new ListAnalyzedInvocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAnalyzedInvocationsFixedSizeCollection createCollection(
        @Nullable List<ListAnalyzedInvocationsPage> pages, int collectionSize) {
      return new ListAnalyzedInvocationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class AggregateAnalyzedSessionsPagedResponse
      extends AbstractPagedListResponse<
          AggregateAnalyzedSessionsRequest,
          AggregateAnalyzedSessionsResponse,
          AggregateAnalyzedSessionsResponse.AgentAggregate,
          AggregateAnalyzedSessionsPage,
          AggregateAnalyzedSessionsFixedSizeCollection> {

    public static ApiFuture<AggregateAnalyzedSessionsPagedResponse> createAsync(
        PageContext<
                AggregateAnalyzedSessionsRequest,
                AggregateAnalyzedSessionsResponse,
                AggregateAnalyzedSessionsResponse.AgentAggregate>
            context,
        ApiFuture<AggregateAnalyzedSessionsResponse> futureResponse) {
      ApiFuture<AggregateAnalyzedSessionsPage> futurePage =
          AggregateAnalyzedSessionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new AggregateAnalyzedSessionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private AggregateAnalyzedSessionsPagedResponse(AggregateAnalyzedSessionsPage page) {
      super(page, AggregateAnalyzedSessionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregateAnalyzedSessionsPage
      extends AbstractPage<
          AggregateAnalyzedSessionsRequest,
          AggregateAnalyzedSessionsResponse,
          AggregateAnalyzedSessionsResponse.AgentAggregate,
          AggregateAnalyzedSessionsPage> {

    private AggregateAnalyzedSessionsPage(
        @Nullable
            PageContext<
                AggregateAnalyzedSessionsRequest,
                AggregateAnalyzedSessionsResponse,
                AggregateAnalyzedSessionsResponse.AgentAggregate>
            context,
        @Nullable AggregateAnalyzedSessionsResponse response) {
      super(context, response);
    }

    private static AggregateAnalyzedSessionsPage createEmptyPage() {
      return new AggregateAnalyzedSessionsPage(null, null);
    }

    @Override
    protected AggregateAnalyzedSessionsPage createPage(
        @Nullable
            PageContext<
                AggregateAnalyzedSessionsRequest,
                AggregateAnalyzedSessionsResponse,
                AggregateAnalyzedSessionsResponse.AgentAggregate>
            context,
        @Nullable AggregateAnalyzedSessionsResponse response) {
      return new AggregateAnalyzedSessionsPage(context, response);
    }

    @Override
    public ApiFuture<AggregateAnalyzedSessionsPage> createPageAsync(
        @Nullable
            PageContext<
                AggregateAnalyzedSessionsRequest,
                AggregateAnalyzedSessionsResponse,
                AggregateAnalyzedSessionsResponse.AgentAggregate>
            context,
        ApiFuture<AggregateAnalyzedSessionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregateAnalyzedSessionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregateAnalyzedSessionsRequest,
          AggregateAnalyzedSessionsResponse,
          AggregateAnalyzedSessionsResponse.AgentAggregate,
          AggregateAnalyzedSessionsPage,
          AggregateAnalyzedSessionsFixedSizeCollection> {

    private AggregateAnalyzedSessionsFixedSizeCollection(
        @Nullable List<AggregateAnalyzedSessionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregateAnalyzedSessionsFixedSizeCollection createEmptyCollection() {
      return new AggregateAnalyzedSessionsFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregateAnalyzedSessionsFixedSizeCollection createCollection(
        @Nullable List<AggregateAnalyzedSessionsPage> pages, int collectionSize) {
      return new AggregateAnalyzedSessionsFixedSizeCollection(pages, collectionSize);
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
