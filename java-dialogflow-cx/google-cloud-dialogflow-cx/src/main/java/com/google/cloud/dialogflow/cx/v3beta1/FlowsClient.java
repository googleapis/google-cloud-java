/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.dialogflow.cx.v3beta1;

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
import com.google.cloud.dialogflow.cx.v3beta1.stub.FlowsStub;
import com.google.cloud.dialogflow.cx.v3beta1.stub.FlowsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing [Flows][google.cloud.dialogflow.cx.v3beta1.Flow].
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (FlowsClient flowsClient = FlowsClient.create()) {
 *   AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
 *   Flow flow = Flow.newBuilder().build();
 *   Flow response = flowsClient.createFlow(parent, flow);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the FlowsClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of FlowsSettings to create(). For
 * example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * FlowsSettings flowsSettings =
 *     FlowsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * FlowsClient flowsClient = FlowsClient.create(flowsSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * FlowsSettings flowsSettings = FlowsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * FlowsClient flowsClient = FlowsClient.create(flowsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class FlowsClient implements BackgroundResource {
  private final FlowsSettings settings;
  private final FlowsStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of FlowsClient with default settings. */
  public static final FlowsClient create() throws IOException {
    return create(FlowsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of FlowsClient, using the given settings. The channels are created based
   * on the settings passed in, or defaults for any settings that are not set.
   */
  public static final FlowsClient create(FlowsSettings settings) throws IOException {
    return new FlowsClient(settings);
  }

  /**
   * Constructs an instance of FlowsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(FlowsSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final FlowsClient create(FlowsStub stub) {
    return new FlowsClient(stub);
  }

  /**
   * Constructs an instance of FlowsClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected FlowsClient(FlowsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((FlowsStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected FlowsClient(FlowsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final FlowsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public FlowsStub getStub() {
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
   * Creates a flow in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
   *   Flow flow = Flow.newBuilder().build();
   *   Flow response = flowsClient.createFlow(parent, flow);
   * }
   * }</pre>
   *
   * @param parent Required. The agent to create a flow for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @param flow Required. The flow to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Flow createFlow(AgentName parent, Flow flow) {
    CreateFlowRequest request =
        CreateFlowRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFlow(flow)
            .build();
    return createFlow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a flow in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   String parent = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString();
   *   Flow flow = Flow.newBuilder().build();
   *   Flow response = flowsClient.createFlow(parent, flow);
   * }
   * }</pre>
   *
   * @param parent Required. The agent to create a flow for. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @param flow Required. The flow to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Flow createFlow(String parent, Flow flow) {
    CreateFlowRequest request =
        CreateFlowRequest.newBuilder().setParent(parent).setFlow(flow).build();
    return createFlow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a flow in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   CreateFlowRequest request =
   *       CreateFlowRequest.newBuilder()
   *           .setParent(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
   *           .setFlow(Flow.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   Flow response = flowsClient.createFlow(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Flow createFlow(CreateFlowRequest request) {
    return createFlowCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a flow in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   CreateFlowRequest request =
   *       CreateFlowRequest.newBuilder()
   *           .setParent(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
   *           .setFlow(Flow.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<Flow> future = flowsClient.createFlowCallable().futureCall(request);
   *   // Do something.
   *   Flow response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateFlowRequest, Flow> createFlowCallable() {
    return stub.createFlowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specified flow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   FlowName name = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]");
   *   flowsClient.deleteFlow(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the flow to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/flows/&lt;Flow ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteFlow(FlowName name) {
    DeleteFlowRequest request =
        DeleteFlowRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteFlow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specified flow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   String name = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString();
   *   flowsClient.deleteFlow(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the flow to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/flows/&lt;Flow ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteFlow(String name) {
    DeleteFlowRequest request = DeleteFlowRequest.newBuilder().setName(name).build();
    deleteFlow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specified flow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   DeleteFlowRequest request =
   *       DeleteFlowRequest.newBuilder()
   *           .setName(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
   *           .setForce(true)
   *           .build();
   *   flowsClient.deleteFlow(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteFlow(DeleteFlowRequest request) {
    deleteFlowCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a specified flow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   DeleteFlowRequest request =
   *       DeleteFlowRequest.newBuilder()
   *           .setName(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future = flowsClient.deleteFlowCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteFlowRequest, Empty> deleteFlowCallable() {
    return stub.deleteFlowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all flows in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
   *   for (Flow element : flowsClient.listFlows(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The agent containing the flows. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFlowsPagedResponse listFlows(AgentName parent) {
    ListFlowsRequest request =
        ListFlowsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listFlows(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all flows in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   String parent = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString();
   *   for (Flow element : flowsClient.listFlows(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The agent containing the flows. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFlowsPagedResponse listFlows(String parent) {
    ListFlowsRequest request = ListFlowsRequest.newBuilder().setParent(parent).build();
    return listFlows(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all flows in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   ListFlowsRequest request =
   *       ListFlowsRequest.newBuilder()
   *           .setParent(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   for (Flow element : flowsClient.listFlows(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFlowsPagedResponse listFlows(ListFlowsRequest request) {
    return listFlowsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all flows in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   ListFlowsRequest request =
   *       ListFlowsRequest.newBuilder()
   *           .setParent(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<Flow> future = flowsClient.listFlowsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Flow element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFlowsRequest, ListFlowsPagedResponse> listFlowsPagedCallable() {
    return stub.listFlowsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all flows in the specified agent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   while (true) {
   *     ListFlowsResponse response = flowsClient.listFlowsCallable().call(request);
   *     for (Flow element : response.getResponsesList()) {
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
  public final UnaryCallable<ListFlowsRequest, ListFlowsResponse> listFlowsCallable() {
    return stub.listFlowsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified flow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   FlowName name = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]");
   *   Flow response = flowsClient.getFlow(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the flow to get. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/flows/&lt;Flow ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Flow getFlow(FlowName name) {
    GetFlowRequest request =
        GetFlowRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getFlow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified flow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   String name = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString();
   *   Flow response = flowsClient.getFlow(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the flow to get. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/flows/&lt;Flow ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Flow getFlow(String name) {
    GetFlowRequest request = GetFlowRequest.newBuilder().setName(name).build();
    return getFlow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified flow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   GetFlowRequest request =
   *       GetFlowRequest.newBuilder()
   *           .setName(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   Flow response = flowsClient.getFlow(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Flow getFlow(GetFlowRequest request) {
    return getFlowCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified flow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   GetFlowRequest request =
   *       GetFlowRequest.newBuilder()
   *           .setName(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<Flow> future = flowsClient.getFlowCallable().futureCall(request);
   *   // Do something.
   *   Flow response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFlowRequest, Flow> getFlowCallable() {
    return stub.getFlowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified flow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   Flow flow = Flow.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Flow response = flowsClient.updateFlow(flow, updateMask);
   * }
   * }</pre>
   *
   * @param flow Required. The flow to update.
   * @param updateMask Required. The mask to control which fields get updated. If `update_mask` is
   *     not specified, an error will be returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Flow updateFlow(Flow flow, FieldMask updateMask) {
    UpdateFlowRequest request =
        UpdateFlowRequest.newBuilder().setFlow(flow).setUpdateMask(updateMask).build();
    return updateFlow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified flow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   UpdateFlowRequest request =
   *       UpdateFlowRequest.newBuilder()
   *           .setFlow(Flow.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   Flow response = flowsClient.updateFlow(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Flow updateFlow(UpdateFlowRequest request) {
    return updateFlowCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified flow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   UpdateFlowRequest request =
   *       UpdateFlowRequest.newBuilder()
   *           .setFlow(Flow.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<Flow> future = flowsClient.updateFlowCallable().futureCall(request);
   *   // Do something.
   *   Flow response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateFlowRequest, Flow> updateFlowCallable() {
    return stub.updateFlowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Trains the specified flow. Note that only the flow in 'draft' environment is trained.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   FlowName name = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]");
   *   flowsClient.trainFlowAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The flow to train. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/flows/&lt;Flow ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> trainFlowAsync(FlowName name) {
    TrainFlowRequest request =
        TrainFlowRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return trainFlowAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Trains the specified flow. Note that only the flow in 'draft' environment is trained.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   String name = FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString();
   *   flowsClient.trainFlowAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The flow to train. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/flows/&lt;Flow ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> trainFlowAsync(String name) {
    TrainFlowRequest request = TrainFlowRequest.newBuilder().setName(name).build();
    return trainFlowAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Trains the specified flow. Note that only the flow in 'draft' environment is trained.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   TrainFlowRequest request =
   *       TrainFlowRequest.newBuilder()
   *           .setName(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
   *           .build();
   *   flowsClient.trainFlowAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, Struct> trainFlowAsync(TrainFlowRequest request) {
    return trainFlowOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Trains the specified flow. Note that only the flow in 'draft' environment is trained.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   TrainFlowRequest request =
   *       TrainFlowRequest.newBuilder()
   *           .setName(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
   *           .build();
   *   OperationFuture<Empty, Struct> future =
   *       flowsClient.trainFlowOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<TrainFlowRequest, Empty, Struct> trainFlowOperationCallable() {
    return stub.trainFlowOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Trains the specified flow. Note that only the flow in 'draft' environment is trained.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   TrainFlowRequest request =
   *       TrainFlowRequest.newBuilder()
   *           .setName(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
   *           .build();
   *   ApiFuture<Operation> future = flowsClient.trainFlowCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TrainFlowRequest, Operation> trainFlowCallable() {
    return stub.trainFlowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Validates the specified flow and creates or updates validation results. Please call this API
   * after the training is completed to get the complete validation results.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   ValidateFlowRequest request =
   *       ValidateFlowRequest.newBuilder()
   *           .setName(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   FlowValidationResult response = flowsClient.validateFlow(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FlowValidationResult validateFlow(ValidateFlowRequest request) {
    return validateFlowCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Validates the specified flow and creates or updates validation results. Please call this API
   * after the training is completed to get the complete validation results.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   ValidateFlowRequest request =
   *       ValidateFlowRequest.newBuilder()
   *           .setName(FlowName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<FlowValidationResult> future =
   *       flowsClient.validateFlowCallable().futureCall(request);
   *   // Do something.
   *   FlowValidationResult response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ValidateFlowRequest, FlowValidationResult> validateFlowCallable() {
    return stub.validateFlowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the latest flow validation result. Flow validation is performed when ValidateFlow is
   * called.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   FlowValidationResultName name =
   *       FlowValidationResultName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]");
   *   FlowValidationResult response = flowsClient.getFlowValidationResult(name);
   * }
   * }</pre>
   *
   * @param name Required. The flow name. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/flows/&lt;Flow
   *     ID&gt;/validationResult`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FlowValidationResult getFlowValidationResult(FlowValidationResultName name) {
    GetFlowValidationResultRequest request =
        GetFlowValidationResultRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getFlowValidationResult(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the latest flow validation result. Flow validation is performed when ValidateFlow is
   * called.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   String name =
   *       FlowValidationResultName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]").toString();
   *   FlowValidationResult response = flowsClient.getFlowValidationResult(name);
   * }
   * }</pre>
   *
   * @param name Required. The flow name. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/flows/&lt;Flow
   *     ID&gt;/validationResult`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FlowValidationResult getFlowValidationResult(String name) {
    GetFlowValidationResultRequest request =
        GetFlowValidationResultRequest.newBuilder().setName(name).build();
    return getFlowValidationResult(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the latest flow validation result. Flow validation is performed when ValidateFlow is
   * called.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   GetFlowValidationResultRequest request =
   *       GetFlowValidationResultRequest.newBuilder()
   *           .setName(
   *               FlowValidationResultName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]")
   *                   .toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   FlowValidationResult response = flowsClient.getFlowValidationResult(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FlowValidationResult getFlowValidationResult(
      GetFlowValidationResultRequest request) {
    return getFlowValidationResultCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the latest flow validation result. Flow validation is performed when ValidateFlow is
   * called.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (FlowsClient flowsClient = FlowsClient.create()) {
   *   GetFlowValidationResultRequest request =
   *       GetFlowValidationResultRequest.newBuilder()
   *           .setName(
   *               FlowValidationResultName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[FLOW]")
   *                   .toString())
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<FlowValidationResult> future =
   *       flowsClient.getFlowValidationResultCallable().futureCall(request);
   *   // Do something.
   *   FlowValidationResult response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFlowValidationResultRequest, FlowValidationResult>
      getFlowValidationResultCallable() {
    return stub.getFlowValidationResultCallable();
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

  public static class ListFlowsPagedResponse
      extends AbstractPagedListResponse<
          ListFlowsRequest, ListFlowsResponse, Flow, ListFlowsPage, ListFlowsFixedSizeCollection> {

    public static ApiFuture<ListFlowsPagedResponse> createAsync(
        PageContext<ListFlowsRequest, ListFlowsResponse, Flow> context,
        ApiFuture<ListFlowsResponse> futureResponse) {
      ApiFuture<ListFlowsPage> futurePage =
          ListFlowsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListFlowsPage, ListFlowsPagedResponse>() {
            @Override
            public ListFlowsPagedResponse apply(ListFlowsPage input) {
              return new ListFlowsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListFlowsPagedResponse(ListFlowsPage page) {
      super(page, ListFlowsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFlowsPage
      extends AbstractPage<ListFlowsRequest, ListFlowsResponse, Flow, ListFlowsPage> {

    private ListFlowsPage(
        PageContext<ListFlowsRequest, ListFlowsResponse, Flow> context,
        ListFlowsResponse response) {
      super(context, response);
    }

    private static ListFlowsPage createEmptyPage() {
      return new ListFlowsPage(null, null);
    }

    @Override
    protected ListFlowsPage createPage(
        PageContext<ListFlowsRequest, ListFlowsResponse, Flow> context,
        ListFlowsResponse response) {
      return new ListFlowsPage(context, response);
    }

    @Override
    public ApiFuture<ListFlowsPage> createPageAsync(
        PageContext<ListFlowsRequest, ListFlowsResponse, Flow> context,
        ApiFuture<ListFlowsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFlowsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFlowsRequest, ListFlowsResponse, Flow, ListFlowsPage, ListFlowsFixedSizeCollection> {

    private ListFlowsFixedSizeCollection(List<ListFlowsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFlowsFixedSizeCollection createEmptyCollection() {
      return new ListFlowsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFlowsFixedSizeCollection createCollection(
        List<ListFlowsPage> pages, int collectionSize) {
      return new ListFlowsFixedSizeCollection(pages, collectionSize);
    }
  }
}
