/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.workflows.executions.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.workflows.executions.v1beta.stub.ExecutionsStub;
import com.google.cloud.workflows.executions.v1beta.stub.ExecutionsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Executions is used to start and manage running instances of
 * [Workflows][google.cloud.workflows.v1beta.Workflow] called executions.
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
 * try (ExecutionsClient executionsClient = ExecutionsClient.create()) {
 *   WorkflowName parent = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
 *   Execution execution = Execution.newBuilder().build();
 *   Execution response = executionsClient.createExecution(parent, execution);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ExecutionsClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of ExecutionsSettings to
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
 * ExecutionsSettings executionsSettings =
 *     ExecutionsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ExecutionsClient executionsClient = ExecutionsClient.create(executionsSettings);
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
 * ExecutionsSettings executionsSettings =
 *     ExecutionsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ExecutionsClient executionsClient = ExecutionsClient.create(executionsSettings);
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
 * ExecutionsSettings executionsSettings = ExecutionsSettings.newHttpJsonBuilder().build();
 * ExecutionsClient executionsClient = ExecutionsClient.create(executionsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ExecutionsClient implements BackgroundResource {
  private final ExecutionsSettings settings;
  private final ExecutionsStub stub;

  /** Constructs an instance of ExecutionsClient with default settings. */
  public static final ExecutionsClient create() throws IOException {
    return create(ExecutionsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ExecutionsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ExecutionsClient create(ExecutionsSettings settings) throws IOException {
    return new ExecutionsClient(settings);
  }

  /**
   * Constructs an instance of ExecutionsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(ExecutionsSettings).
   */
  public static final ExecutionsClient create(ExecutionsStub stub) {
    return new ExecutionsClient(stub);
  }

  /**
   * Constructs an instance of ExecutionsClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected ExecutionsClient(ExecutionsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ExecutionsStubSettings) settings.getStubSettings()).createStub();
  }

  protected ExecutionsClient(ExecutionsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ExecutionsSettings getSettings() {
    return settings;
  }

  public ExecutionsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of executions which belong to the workflow with the given name. The method
   * returns executions of all workflow revisions. Returned executions are ordered by their start
   * time (newest first).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExecutionsClient executionsClient = ExecutionsClient.create()) {
   *   WorkflowName parent = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
   *   for (Execution element : executionsClient.listExecutions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of the workflow for which the executions should be listed. Format:
   *     projects/{project}/locations/{location}/workflows/{workflow}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExecutionsPagedResponse listExecutions(WorkflowName parent) {
    ListExecutionsRequest request =
        ListExecutionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listExecutions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of executions which belong to the workflow with the given name. The method
   * returns executions of all workflow revisions. Returned executions are ordered by their start
   * time (newest first).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExecutionsClient executionsClient = ExecutionsClient.create()) {
   *   String parent = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString();
   *   for (Execution element : executionsClient.listExecutions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Name of the workflow for which the executions should be listed. Format:
   *     projects/{project}/locations/{location}/workflows/{workflow}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExecutionsPagedResponse listExecutions(String parent) {
    ListExecutionsRequest request = ListExecutionsRequest.newBuilder().setParent(parent).build();
    return listExecutions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of executions which belong to the workflow with the given name. The method
   * returns executions of all workflow revisions. Returned executions are ordered by their start
   * time (newest first).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExecutionsClient executionsClient = ExecutionsClient.create()) {
   *   ListExecutionsRequest request =
   *       ListExecutionsRequest.newBuilder()
   *           .setParent(WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(ExecutionView.forNumber(0))
   *           .build();
   *   for (Execution element : executionsClient.listExecutions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExecutionsPagedResponse listExecutions(ListExecutionsRequest request) {
    return listExecutionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of executions which belong to the workflow with the given name. The method
   * returns executions of all workflow revisions. Returned executions are ordered by their start
   * time (newest first).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExecutionsClient executionsClient = ExecutionsClient.create()) {
   *   ListExecutionsRequest request =
   *       ListExecutionsRequest.newBuilder()
   *           .setParent(WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(ExecutionView.forNumber(0))
   *           .build();
   *   ApiFuture<Execution> future =
   *       executionsClient.listExecutionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Execution element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListExecutionsRequest, ListExecutionsPagedResponse>
      listExecutionsPagedCallable() {
    return stub.listExecutionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of executions which belong to the workflow with the given name. The method
   * returns executions of all workflow revisions. Returned executions are ordered by their start
   * time (newest first).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExecutionsClient executionsClient = ExecutionsClient.create()) {
   *   ListExecutionsRequest request =
   *       ListExecutionsRequest.newBuilder()
   *           .setParent(WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(ExecutionView.forNumber(0))
   *           .build();
   *   while (true) {
   *     ListExecutionsResponse response = executionsClient.listExecutionsCallable().call(request);
   *     for (Execution element : response.getExecutionsList()) {
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
  public final UnaryCallable<ListExecutionsRequest, ListExecutionsResponse>
      listExecutionsCallable() {
    return stub.listExecutionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new execution using the latest revision of the given workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExecutionsClient executionsClient = ExecutionsClient.create()) {
   *   WorkflowName parent = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]");
   *   Execution execution = Execution.newBuilder().build();
   *   Execution response = executionsClient.createExecution(parent, execution);
   * }
   * }</pre>
   *
   * @param parent Required. Name of the workflow for which an execution should be created. Format:
   *     projects/{project}/locations/{location}/workflows/{workflow} The latest revision of the
   *     workflow will be used.
   * @param execution Required. Execution to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Execution createExecution(WorkflowName parent, Execution execution) {
    CreateExecutionRequest request =
        CreateExecutionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setExecution(execution)
            .build();
    return createExecution(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new execution using the latest revision of the given workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExecutionsClient executionsClient = ExecutionsClient.create()) {
   *   String parent = WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString();
   *   Execution execution = Execution.newBuilder().build();
   *   Execution response = executionsClient.createExecution(parent, execution);
   * }
   * }</pre>
   *
   * @param parent Required. Name of the workflow for which an execution should be created. Format:
   *     projects/{project}/locations/{location}/workflows/{workflow} The latest revision of the
   *     workflow will be used.
   * @param execution Required. Execution to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Execution createExecution(String parent, Execution execution) {
    CreateExecutionRequest request =
        CreateExecutionRequest.newBuilder().setParent(parent).setExecution(execution).build();
    return createExecution(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new execution using the latest revision of the given workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExecutionsClient executionsClient = ExecutionsClient.create()) {
   *   CreateExecutionRequest request =
   *       CreateExecutionRequest.newBuilder()
   *           .setParent(WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
   *           .setExecution(Execution.newBuilder().build())
   *           .build();
   *   Execution response = executionsClient.createExecution(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Execution createExecution(CreateExecutionRequest request) {
    return createExecutionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new execution using the latest revision of the given workflow.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExecutionsClient executionsClient = ExecutionsClient.create()) {
   *   CreateExecutionRequest request =
   *       CreateExecutionRequest.newBuilder()
   *           .setParent(WorkflowName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]").toString())
   *           .setExecution(Execution.newBuilder().build())
   *           .build();
   *   ApiFuture<Execution> future = executionsClient.createExecutionCallable().futureCall(request);
   *   // Do something.
   *   Execution response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateExecutionRequest, Execution> createExecutionCallable() {
    return stub.createExecutionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns an execution of the given name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExecutionsClient executionsClient = ExecutionsClient.create()) {
   *   ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]");
   *   Execution response = executionsClient.getExecution(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the execution to be retrieved. Format:
   *     projects/{project}/locations/{location}/workflows/{workflow}/executions/{execution}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Execution getExecution(ExecutionName name) {
    GetExecutionRequest request =
        GetExecutionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getExecution(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns an execution of the given name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExecutionsClient executionsClient = ExecutionsClient.create()) {
   *   String name =
   *       ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]").toString();
   *   Execution response = executionsClient.getExecution(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the execution to be retrieved. Format:
   *     projects/{project}/locations/{location}/workflows/{workflow}/executions/{execution}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Execution getExecution(String name) {
    GetExecutionRequest request = GetExecutionRequest.newBuilder().setName(name).build();
    return getExecution(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns an execution of the given name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExecutionsClient executionsClient = ExecutionsClient.create()) {
   *   GetExecutionRequest request =
   *       GetExecutionRequest.newBuilder()
   *           .setName(
   *               ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]")
   *                   .toString())
   *           .setView(ExecutionView.forNumber(0))
   *           .build();
   *   Execution response = executionsClient.getExecution(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Execution getExecution(GetExecutionRequest request) {
    return getExecutionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns an execution of the given name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExecutionsClient executionsClient = ExecutionsClient.create()) {
   *   GetExecutionRequest request =
   *       GetExecutionRequest.newBuilder()
   *           .setName(
   *               ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]")
   *                   .toString())
   *           .setView(ExecutionView.forNumber(0))
   *           .build();
   *   ApiFuture<Execution> future = executionsClient.getExecutionCallable().futureCall(request);
   *   // Do something.
   *   Execution response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetExecutionRequest, Execution> getExecutionCallable() {
    return stub.getExecutionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels an execution of the given name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExecutionsClient executionsClient = ExecutionsClient.create()) {
   *   ExecutionName name = ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]");
   *   Execution response = executionsClient.cancelExecution(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the execution to be cancelled. Format:
   *     projects/{project}/locations/{location}/workflows/{workflow}/executions/{execution}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Execution cancelExecution(ExecutionName name) {
    CancelExecutionRequest request =
        CancelExecutionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return cancelExecution(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels an execution of the given name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExecutionsClient executionsClient = ExecutionsClient.create()) {
   *   String name =
   *       ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]").toString();
   *   Execution response = executionsClient.cancelExecution(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the execution to be cancelled. Format:
   *     projects/{project}/locations/{location}/workflows/{workflow}/executions/{execution}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Execution cancelExecution(String name) {
    CancelExecutionRequest request = CancelExecutionRequest.newBuilder().setName(name).build();
    return cancelExecution(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels an execution of the given name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExecutionsClient executionsClient = ExecutionsClient.create()) {
   *   CancelExecutionRequest request =
   *       CancelExecutionRequest.newBuilder()
   *           .setName(
   *               ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]")
   *                   .toString())
   *           .build();
   *   Execution response = executionsClient.cancelExecution(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Execution cancelExecution(CancelExecutionRequest request) {
    return cancelExecutionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels an execution of the given name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExecutionsClient executionsClient = ExecutionsClient.create()) {
   *   CancelExecutionRequest request =
   *       CancelExecutionRequest.newBuilder()
   *           .setName(
   *               ExecutionName.of("[PROJECT]", "[LOCATION]", "[WORKFLOW]", "[EXECUTION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Execution> future = executionsClient.cancelExecutionCallable().futureCall(request);
   *   // Do something.
   *   Execution response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CancelExecutionRequest, Execution> cancelExecutionCallable() {
    return stub.cancelExecutionCallable();
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

  public static class ListExecutionsPagedResponse
      extends AbstractPagedListResponse<
          ListExecutionsRequest,
          ListExecutionsResponse,
          Execution,
          ListExecutionsPage,
          ListExecutionsFixedSizeCollection> {

    public static ApiFuture<ListExecutionsPagedResponse> createAsync(
        PageContext<ListExecutionsRequest, ListExecutionsResponse, Execution> context,
        ApiFuture<ListExecutionsResponse> futureResponse) {
      ApiFuture<ListExecutionsPage> futurePage =
          ListExecutionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListExecutionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListExecutionsPagedResponse(ListExecutionsPage page) {
      super(page, ListExecutionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListExecutionsPage
      extends AbstractPage<
          ListExecutionsRequest, ListExecutionsResponse, Execution, ListExecutionsPage> {

    private ListExecutionsPage(
        PageContext<ListExecutionsRequest, ListExecutionsResponse, Execution> context,
        ListExecutionsResponse response) {
      super(context, response);
    }

    private static ListExecutionsPage createEmptyPage() {
      return new ListExecutionsPage(null, null);
    }

    @Override
    protected ListExecutionsPage createPage(
        PageContext<ListExecutionsRequest, ListExecutionsResponse, Execution> context,
        ListExecutionsResponse response) {
      return new ListExecutionsPage(context, response);
    }

    @Override
    public ApiFuture<ListExecutionsPage> createPageAsync(
        PageContext<ListExecutionsRequest, ListExecutionsResponse, Execution> context,
        ApiFuture<ListExecutionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListExecutionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListExecutionsRequest,
          ListExecutionsResponse,
          Execution,
          ListExecutionsPage,
          ListExecutionsFixedSizeCollection> {

    private ListExecutionsFixedSizeCollection(List<ListExecutionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListExecutionsFixedSizeCollection createEmptyCollection() {
      return new ListExecutionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListExecutionsFixedSizeCollection createCollection(
        List<ListExecutionsPage> pages, int collectionSize) {
      return new ListExecutionsFixedSizeCollection(pages, collectionSize);
    }
  }
}
