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

package com.google.cloud.run.v2;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.run.v2.stub.TasksStub;
import com.google.cloud.run.v2.stub.TasksStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Cloud Run Task Control Plane API.
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
 * try (TasksClient tasksClient = TasksClient.create()) {
 *   TaskName name = TaskName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]", "[TASK]");
 *   Task response = tasksClient.getTask(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TasksClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of TasksSettings to create(). For
 * example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TasksSettings tasksSettings =
 *     TasksSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TasksClient tasksClient = TasksClient.create(tasksSettings);
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
 * TasksSettings tasksSettings = TasksSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TasksClient tasksClient = TasksClient.create(tasksSettings);
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
 * TasksSettings tasksSettings = TasksSettings.newHttpJsonBuilder().build();
 * TasksClient tasksClient = TasksClient.create(tasksSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class TasksClient implements BackgroundResource {
  private final TasksSettings settings;
  private final TasksStub stub;

  /** Constructs an instance of TasksClient with default settings. */
  public static final TasksClient create() throws IOException {
    return create(TasksSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TasksClient, using the given settings. The channels are created based
   * on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TasksClient create(TasksSettings settings) throws IOException {
    return new TasksClient(settings);
  }

  /**
   * Constructs an instance of TasksClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(TasksSettings).
   */
  public static final TasksClient create(TasksStub stub) {
    return new TasksClient(stub);
  }

  /**
   * Constructs an instance of TasksClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected TasksClient(TasksSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TasksStubSettings) settings.getStubSettings()).createStub();
  }

  protected TasksClient(TasksStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TasksSettings getSettings() {
    return settings;
  }

  public TasksStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a Task.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TasksClient tasksClient = TasksClient.create()) {
   *   TaskName name = TaskName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]", "[TASK]");
   *   Task response = tasksClient.getTask(name);
   * }
   * }</pre>
   *
   * @param name Required. The full name of the Task. Format:
   *     projects/{project}/locations/{location}/jobs/{job}/executions/{execution}/tasks/{task}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Task getTask(TaskName name) {
    GetTaskRequest request =
        GetTaskRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTask(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a Task.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TasksClient tasksClient = TasksClient.create()) {
   *   String name =
   *       TaskName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]", "[TASK]").toString();
   *   Task response = tasksClient.getTask(name);
   * }
   * }</pre>
   *
   * @param name Required. The full name of the Task. Format:
   *     projects/{project}/locations/{location}/jobs/{job}/executions/{execution}/tasks/{task}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Task getTask(String name) {
    GetTaskRequest request = GetTaskRequest.newBuilder().setName(name).build();
    return getTask(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a Task.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TasksClient tasksClient = TasksClient.create()) {
   *   GetTaskRequest request =
   *       GetTaskRequest.newBuilder()
   *           .setName(
   *               TaskName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]", "[TASK]")
   *                   .toString())
   *           .build();
   *   Task response = tasksClient.getTask(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Task getTask(GetTaskRequest request) {
    return getTaskCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a Task.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TasksClient tasksClient = TasksClient.create()) {
   *   GetTaskRequest request =
   *       GetTaskRequest.newBuilder()
   *           .setName(
   *               TaskName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]", "[TASK]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Task> future = tasksClient.getTaskCallable().futureCall(request);
   *   // Do something.
   *   Task response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTaskRequest, Task> getTaskCallable() {
    return stub.getTaskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Tasks from an Execution of a Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TasksClient tasksClient = TasksClient.create()) {
   *   ExecutionName parent = ExecutionName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]");
   *   for (Task element : tasksClient.listTasks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Execution from which the Tasks should be listed. To list all Tasks
   *     across Executions of a Job, use "-" instead of Execution name. To list all Tasks across
   *     Jobs, use "-" instead of Job name. Format:
   *     projects/{project}/locations/{location}/jobs/{job}/executions/{execution}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTasksPagedResponse listTasks(ExecutionName parent) {
    ListTasksRequest request =
        ListTasksRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listTasks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Tasks from an Execution of a Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TasksClient tasksClient = TasksClient.create()) {
   *   String parent =
   *       ExecutionName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]").toString();
   *   for (Task element : tasksClient.listTasks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Execution from which the Tasks should be listed. To list all Tasks
   *     across Executions of a Job, use "-" instead of Execution name. To list all Tasks across
   *     Jobs, use "-" instead of Job name. Format:
   *     projects/{project}/locations/{location}/jobs/{job}/executions/{execution}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTasksPagedResponse listTasks(String parent) {
    ListTasksRequest request = ListTasksRequest.newBuilder().setParent(parent).build();
    return listTasks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Tasks from an Execution of a Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TasksClient tasksClient = TasksClient.create()) {
   *   ListTasksRequest request =
   *       ListTasksRequest.newBuilder()
   *           .setParent(
   *               ExecutionName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   for (Task element : tasksClient.listTasks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTasksPagedResponse listTasks(ListTasksRequest request) {
    return listTasksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Tasks from an Execution of a Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TasksClient tasksClient = TasksClient.create()) {
   *   ListTasksRequest request =
   *       ListTasksRequest.newBuilder()
   *           .setParent(
   *               ExecutionName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<Task> future = tasksClient.listTasksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Task element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTasksRequest, ListTasksPagedResponse> listTasksPagedCallable() {
    return stub.listTasksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Tasks from an Execution of a Job.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TasksClient tasksClient = TasksClient.create()) {
   *   ListTasksRequest request =
   *       ListTasksRequest.newBuilder()
   *           .setParent(
   *               ExecutionName.of("[PROJECT]", "[LOCATION]", "[JOB]", "[EXECUTION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListTasksResponse response = tasksClient.listTasksCallable().call(request);
   *     for (Task element : response.getTasksList()) {
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
  public final UnaryCallable<ListTasksRequest, ListTasksResponse> listTasksCallable() {
    return stub.listTasksCallable();
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

  public static class ListTasksPagedResponse
      extends AbstractPagedListResponse<
          ListTasksRequest, ListTasksResponse, Task, ListTasksPage, ListTasksFixedSizeCollection> {

    public static ApiFuture<ListTasksPagedResponse> createAsync(
        PageContext<ListTasksRequest, ListTasksResponse, Task> context,
        ApiFuture<ListTasksResponse> futureResponse) {
      ApiFuture<ListTasksPage> futurePage =
          ListTasksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListTasksPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListTasksPagedResponse(ListTasksPage page) {
      super(page, ListTasksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTasksPage
      extends AbstractPage<ListTasksRequest, ListTasksResponse, Task, ListTasksPage> {

    private ListTasksPage(
        PageContext<ListTasksRequest, ListTasksResponse, Task> context,
        ListTasksResponse response) {
      super(context, response);
    }

    private static ListTasksPage createEmptyPage() {
      return new ListTasksPage(null, null);
    }

    @Override
    protected ListTasksPage createPage(
        PageContext<ListTasksRequest, ListTasksResponse, Task> context,
        ListTasksResponse response) {
      return new ListTasksPage(context, response);
    }

    @Override
    public ApiFuture<ListTasksPage> createPageAsync(
        PageContext<ListTasksRequest, ListTasksResponse, Task> context,
        ApiFuture<ListTasksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTasksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTasksRequest, ListTasksResponse, Task, ListTasksPage, ListTasksFixedSizeCollection> {

    private ListTasksFixedSizeCollection(List<ListTasksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTasksFixedSizeCollection createEmptyCollection() {
      return new ListTasksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTasksFixedSizeCollection createCollection(
        List<ListTasksPage> pages, int collectionSize) {
      return new ListTasksFixedSizeCollection(pages, collectionSize);
    }
  }
}
