/*
 * Copyright 2018 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.google.cloud.dialogflow.v2beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.stub.AgentsStub;
import com.google.cloud.dialogflow.v2beta1.stub.AgentsStubSettings;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Agents are best described as Natural Language Understanding (NLU) modules
 * that transform user requests into actionable data. You can include agents in your app, product,
 * or service to determine user intent and respond to the user in a natural way.
 *
 * <p>After you create an agent, you can add [Intents][google.cloud.dialogflow.v2beta1.Intents],
 * [Contexts][google.cloud.dialogflow.v2beta1.Contexts], [Entity
 * Types][google.cloud.dialogflow.v2beta1.EntityTypes],
 * [Webhooks][google.cloud.dialogflow.v2beta1.WebhookRequest], and so on to manage the flow of a
 * conversation and match user input to predefined intents and actions.
 *
 * <p>You can create an agent using both Dialogflow Standard Edition and Dialogflow Enterprise
 * Edition. For details, see [Dialogflow Editions](/dialogflow-enterprise/docs/editions).
 *
 * <p>You can save your agent for backup or versioning by exporting the agent by using the
 * [ExportAgent][google.cloud.dialogflow.v2beta1.Agents.ExportAgent] method. You can import a saved
 * agent by using the [ImportAgent][google.cloud.dialogflow.v2beta1.Agents.ImportAgent] method.
 *
 * <p>Dialogflow provides several [prebuilt agents](https://dialogflow.com/docs/prebuilt-agents) for
 * common conversation scenarios such as determining a date and time, converting currency, and so
 * on.
 *
 * <p>For more information about agents, see the [Dialogflow
 * documentation](https://dialogflow.com/docs/agents).
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (AgentsClient agentsClient = AgentsClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   Agent response = agentsClient.getAgent(parent);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the agentsClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of AgentsSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * AgentsSettings agentsSettings =
 *     AgentsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AgentsClient agentsClient =
 *     AgentsClient.create(agentsSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * AgentsSettings agentsSettings =
 *     AgentsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AgentsClient agentsClient =
 *     AgentsClient.create(agentsSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class AgentsClient implements BackgroundResource {
  private final AgentsSettings settings;
  private final AgentsStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of AgentsClient with default settings. */
  public static final AgentsClient create() throws IOException {
    return create(AgentsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AgentsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AgentsClient create(AgentsSettings settings) throws IOException {
    return new AgentsClient(settings);
  }

  /**
   * Constructs an instance of AgentsClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use AgentsSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final AgentsClient create(AgentsStub stub) {
    return new AgentsClient(stub);
  }

  /**
   * Constructs an instance of AgentsClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected AgentsClient(AgentsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AgentsStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected AgentsClient(AgentsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final AgentsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public AgentsStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified agent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AgentsClient agentsClient = AgentsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Agent response = agentsClient.getAgent(parent);
   * }
   * </code></pre>
   *
   * @param parent Required. The project that the agent to fetch is associated with. Format:
   *     `projects/&lt;Project ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Agent getAgent(ProjectName parent) {

    GetAgentRequest request =
        GetAgentRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return getAgent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified agent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AgentsClient agentsClient = AgentsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   GetAgentRequest request = GetAgentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   Agent response = agentsClient.getAgent(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final Agent getAgent(GetAgentRequest request) {
    return getAgentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified agent.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AgentsClient agentsClient = AgentsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   GetAgentRequest request = GetAgentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;Agent&gt; future = agentsClient.getAgentCallable().futureCall(request);
   *   // Do something
   *   Agent response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetAgentRequest, Agent> getAgentCallable() {
    return stub.getAgentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the list of agents.
   *
   * <p>Since there is at most one conversational agent per project, this method is useful primarily
   * for listing all agents across projects the caller has access to. One can achieve that with a
   * wildcard project collection id "-". Refer to [List
   * Sub-Collections](https://cloud.google.com/apis/design/design_patterns#list_sub-collections).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AgentsClient agentsClient = AgentsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (Agent element : agentsClient.searchAgents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The project to list agents from. Format: `projects/&lt;Project ID or
   *     '-'&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAgentsPagedResponse searchAgents(ProjectName parent) {
    SearchAgentsRequest request =
        SearchAgentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return searchAgents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the list of agents.
   *
   * <p>Since there is at most one conversational agent per project, this method is useful primarily
   * for listing all agents across projects the caller has access to. One can achieve that with a
   * wildcard project collection id "-". Refer to [List
   * Sub-Collections](https://cloud.google.com/apis/design/design_patterns#list_sub-collections).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AgentsClient agentsClient = AgentsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   SearchAgentsRequest request = SearchAgentsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (Agent element : agentsClient.searchAgents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAgentsPagedResponse searchAgents(SearchAgentsRequest request) {
    return searchAgentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the list of agents.
   *
   * <p>Since there is at most one conversational agent per project, this method is useful primarily
   * for listing all agents across projects the caller has access to. One can achieve that with a
   * wildcard project collection id "-". Refer to [List
   * Sub-Collections](https://cloud.google.com/apis/design/design_patterns#list_sub-collections).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AgentsClient agentsClient = AgentsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   SearchAgentsRequest request = SearchAgentsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;SearchAgentsPagedResponse&gt; future = agentsClient.searchAgentsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Agent element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<SearchAgentsRequest, SearchAgentsPagedResponse>
      searchAgentsPagedCallable() {
    return stub.searchAgentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the list of agents.
   *
   * <p>Since there is at most one conversational agent per project, this method is useful primarily
   * for listing all agents across projects the caller has access to. One can achieve that with a
   * wildcard project collection id "-". Refer to [List
   * Sub-Collections](https://cloud.google.com/apis/design/design_patterns#list_sub-collections).
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AgentsClient agentsClient = AgentsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   SearchAgentsRequest request = SearchAgentsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     SearchAgentsResponse response = agentsClient.searchAgentsCallable().call(request);
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
   * </code></pre>
   */
  public final UnaryCallable<SearchAgentsRequest, SearchAgentsResponse> searchAgentsCallable() {
    return stub.searchAgentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Trains the specified agent.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AgentsClient agentsClient = AgentsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   Empty response = agentsClient.trainAgentAsync(parent).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The project that the agent to train is associated with. Format:
   *     `projects/&lt;Project ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> trainAgentAsync(ProjectName parent) {

    TrainAgentRequest request =
        TrainAgentRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return trainAgentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Trains the specified agent.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AgentsClient agentsClient = AgentsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   TrainAgentRequest request = TrainAgentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   Empty response = agentsClient.trainAgentAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final OperationFuture<Empty, Struct> trainAgentAsync(TrainAgentRequest request) {
    return trainAgentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Trains the specified agent.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AgentsClient agentsClient = AgentsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   TrainAgentRequest request = TrainAgentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = agentsClient.trainAgentOperationCallable().futureCall(request);
   *   // Do something
   *   Empty response = future.get();
   * }
   * </code></pre>
   */
  public final OperationCallable<TrainAgentRequest, Empty, Struct> trainAgentOperationCallable() {
    return stub.trainAgentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Trains the specified agent.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AgentsClient agentsClient = AgentsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   TrainAgentRequest request = TrainAgentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = agentsClient.trainAgentCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<TrainAgentRequest, Operation> trainAgentCallable() {
    return stub.trainAgentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Exports the specified agent to a ZIP file.
   *
   * <p>Operation &lt;response:
   * [ExportAgentResponse][google.cloud.dialogflow.v2beta1.ExportAgentResponse], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AgentsClient agentsClient = AgentsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ExportAgentResponse response = agentsClient.exportAgentAsync(parent).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The project that the agent to export is associated with. Format:
   *     `projects/&lt;Project ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportAgentResponse, Struct> exportAgentAsync(ProjectName parent) {

    ExportAgentRequest request =
        ExportAgentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return exportAgentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Exports the specified agent to a ZIP file.
   *
   * <p>Operation &lt;response:
   * [ExportAgentResponse][google.cloud.dialogflow.v2beta1.ExportAgentResponse], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AgentsClient agentsClient = AgentsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ExportAgentRequest request = ExportAgentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ExportAgentResponse response = agentsClient.exportAgentAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportAgentResponse, Struct> exportAgentAsync(
      ExportAgentRequest request) {
    return exportAgentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Exports the specified agent to a ZIP file.
   *
   * <p>Operation &lt;response:
   * [ExportAgentResponse][google.cloud.dialogflow.v2beta1.ExportAgentResponse], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AgentsClient agentsClient = AgentsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ExportAgentRequest request = ExportAgentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = agentsClient.exportAgentOperationCallable().futureCall(request);
   *   // Do something
   *   ExportAgentResponse response = future.get();
   * }
   * </code></pre>
   */
  public final OperationCallable<ExportAgentRequest, ExportAgentResponse, Struct>
      exportAgentOperationCallable() {
    return stub.exportAgentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Exports the specified agent to a ZIP file.
   *
   * <p>Operation &lt;response:
   * [ExportAgentResponse][google.cloud.dialogflow.v2beta1.ExportAgentResponse], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AgentsClient agentsClient = AgentsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ExportAgentRequest request = ExportAgentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = agentsClient.exportAgentCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ExportAgentRequest, Operation> exportAgentCallable() {
    return stub.exportAgentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Imports the specified agent from a ZIP file.
   *
   * <p>Uploads new intents and entity types without deleting the existing ones. Intents and entity
   * types with the same name are replaced with the new versions from ImportAgentRequest.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AgentsClient agentsClient = AgentsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ImportAgentRequest request = ImportAgentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   Empty response = agentsClient.importAgentAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> importAgentAsync(ImportAgentRequest request) {
    return importAgentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Imports the specified agent from a ZIP file.
   *
   * <p>Uploads new intents and entity types without deleting the existing ones. Intents and entity
   * types with the same name are replaced with the new versions from ImportAgentRequest.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AgentsClient agentsClient = AgentsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ImportAgentRequest request = ImportAgentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = agentsClient.importAgentOperationCallable().futureCall(request);
   *   // Do something
   *   Empty response = future.get();
   * }
   * </code></pre>
   */
  public final OperationCallable<ImportAgentRequest, Empty, Struct> importAgentOperationCallable() {
    return stub.importAgentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Imports the specified agent from a ZIP file.
   *
   * <p>Uploads new intents and entity types without deleting the existing ones. Intents and entity
   * types with the same name are replaced with the new versions from ImportAgentRequest.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AgentsClient agentsClient = AgentsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ImportAgentRequest request = ImportAgentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = agentsClient.importAgentCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ImportAgentRequest, Operation> importAgentCallable() {
    return stub.importAgentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Restores the specified agent from a ZIP file.
   *
   * <p>Replaces the current agent version with a new one. All the intents and entity types in the
   * older version are deleted.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AgentsClient agentsClient = AgentsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   RestoreAgentRequest request = RestoreAgentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   Empty response = agentsClient.restoreAgentAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> restoreAgentAsync(RestoreAgentRequest request) {
    return restoreAgentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Restores the specified agent from a ZIP file.
   *
   * <p>Replaces the current agent version with a new one. All the intents and entity types in the
   * older version are deleted.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AgentsClient agentsClient = AgentsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   RestoreAgentRequest request = RestoreAgentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   OperationFuture&lt;Operation&gt; future = agentsClient.restoreAgentOperationCallable().futureCall(request);
   *   // Do something
   *   Empty response = future.get();
   * }
   * </code></pre>
   */
  public final OperationCallable<RestoreAgentRequest, Empty, Struct>
      restoreAgentOperationCallable() {
    return stub.restoreAgentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Restores the specified agent from a ZIP file.
   *
   * <p>Replaces the current agent version with a new one. All the intents and entity types in the
   * older version are deleted.
   *
   * <p>Operation &lt;response: [google.protobuf.Empty][google.protobuf.Empty], metadata:
   * [google.protobuf.Struct][google.protobuf.Struct]&gt;
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AgentsClient agentsClient = AgentsClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   RestoreAgentRequest request = RestoreAgentRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = agentsClient.restoreAgentCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RestoreAgentRequest, Operation> restoreAgentCallable() {
    return stub.restoreAgentCallable();
  }

  @Override
  public final void close() throws Exception {
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

  public static class SearchAgentsPagedResponse
      extends AbstractPagedListResponse<
          SearchAgentsRequest, SearchAgentsResponse, Agent, SearchAgentsPage,
          SearchAgentsFixedSizeCollection> {

    public static ApiFuture<SearchAgentsPagedResponse> createAsync(
        PageContext<SearchAgentsRequest, SearchAgentsResponse, Agent> context,
        ApiFuture<SearchAgentsResponse> futureResponse) {
      ApiFuture<SearchAgentsPage> futurePage =
          SearchAgentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<SearchAgentsPage, SearchAgentsPagedResponse>() {
            @Override
            public SearchAgentsPagedResponse apply(SearchAgentsPage input) {
              return new SearchAgentsPagedResponse(input);
            }
          });
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
          SearchAgentsRequest, SearchAgentsResponse, Agent, SearchAgentsPage,
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
}
