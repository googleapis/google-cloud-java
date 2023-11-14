/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.aiplatform.v1beta1;

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
import com.google.cloud.aiplatform.v1beta1.stub.ScheduleServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.ScheduleServiceStubSettings;
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
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service for creating and managing Vertex AI's Schedule resources to
 * periodically launch shceudled runs to make API calls.
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
 * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Schedule schedule = Schedule.newBuilder().build();
 *   Schedule response = scheduleServiceClient.createSchedule(parent, schedule);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ScheduleServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 * <p>This class can be customized by passing in a custom instance of ScheduleServiceSettings to
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
 * ScheduleServiceSettings scheduleServiceSettings =
 *     ScheduleServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ScheduleServiceClient scheduleServiceClient =
 *     ScheduleServiceClient.create(scheduleServiceSettings);
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
 * ScheduleServiceSettings scheduleServiceSettings =
 *     ScheduleServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ScheduleServiceClient scheduleServiceClient =
 *     ScheduleServiceClient.create(scheduleServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ScheduleServiceClient implements BackgroundResource {
  private final ScheduleServiceSettings settings;
  private final ScheduleServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of ScheduleServiceClient with default settings. */
  public static final ScheduleServiceClient create() throws IOException {
    return create(ScheduleServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ScheduleServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ScheduleServiceClient create(ScheduleServiceSettings settings)
      throws IOException {
    return new ScheduleServiceClient(settings);
  }

  /**
   * Constructs an instance of ScheduleServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ScheduleServiceSettings).
   */
  public static final ScheduleServiceClient create(ScheduleServiceStub stub) {
    return new ScheduleServiceClient(stub);
  }

  /**
   * Constructs an instance of ScheduleServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ScheduleServiceClient(ScheduleServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ScheduleServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected ScheduleServiceClient(ScheduleServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final ScheduleServiceSettings getSettings() {
    return settings;
  }

  public ScheduleServiceStub getStub() {
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
   * Creates a Schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Schedule schedule = Schedule.newBuilder().build();
   *   Schedule response = scheduleServiceClient.createSchedule(parent, schedule);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the Schedule in. Format:
   *     `projects/{project}/locations/{location}`
   * @param schedule Required. The Schedule to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schedule createSchedule(LocationName parent, Schedule schedule) {
    CreateScheduleRequest request =
        CreateScheduleRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSchedule(schedule)
            .build();
    return createSchedule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Schedule schedule = Schedule.newBuilder().build();
   *   Schedule response = scheduleServiceClient.createSchedule(parent, schedule);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the Schedule in. Format:
   *     `projects/{project}/locations/{location}`
   * @param schedule Required. The Schedule to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schedule createSchedule(String parent, Schedule schedule) {
    CreateScheduleRequest request =
        CreateScheduleRequest.newBuilder().setParent(parent).setSchedule(schedule).build();
    return createSchedule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   CreateScheduleRequest request =
   *       CreateScheduleRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSchedule(Schedule.newBuilder().build())
   *           .build();
   *   Schedule response = scheduleServiceClient.createSchedule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schedule createSchedule(CreateScheduleRequest request) {
    return createScheduleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   CreateScheduleRequest request =
   *       CreateScheduleRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSchedule(Schedule.newBuilder().build())
   *           .build();
   *   ApiFuture<Schedule> future =
   *       scheduleServiceClient.createScheduleCallable().futureCall(request);
   *   // Do something.
   *   Schedule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateScheduleRequest, Schedule> createScheduleCallable() {
    return stub.createScheduleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   ScheduleName name = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]");
   *   scheduleServiceClient.deleteScheduleAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Schedule resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/schedules/{schedule}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteScheduleAsync(
      ScheduleName name) {
    DeleteScheduleRequest request =
        DeleteScheduleRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteScheduleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   String name = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString();
   *   scheduleServiceClient.deleteScheduleAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Schedule resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/schedules/{schedule}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteScheduleAsync(String name) {
    DeleteScheduleRequest request = DeleteScheduleRequest.newBuilder().setName(name).build();
    return deleteScheduleAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   DeleteScheduleRequest request =
   *       DeleteScheduleRequest.newBuilder()
   *           .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
   *           .build();
   *   scheduleServiceClient.deleteScheduleAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteScheduleAsync(
      DeleteScheduleRequest request) {
    return deleteScheduleOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   DeleteScheduleRequest request =
   *       DeleteScheduleRequest.newBuilder()
   *           .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       scheduleServiceClient.deleteScheduleOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteScheduleRequest, Empty, DeleteOperationMetadata>
      deleteScheduleOperationCallable() {
    return stub.deleteScheduleOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a Schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   DeleteScheduleRequest request =
   *       DeleteScheduleRequest.newBuilder()
   *           .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       scheduleServiceClient.deleteScheduleCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteScheduleRequest, Operation> deleteScheduleCallable() {
    return stub.deleteScheduleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   ScheduleName name = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]");
   *   Schedule response = scheduleServiceClient.getSchedule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Schedule resource. Format:
   *     `projects/{project}/locations/{location}/schedules/{schedule}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schedule getSchedule(ScheduleName name) {
    GetScheduleRequest request =
        GetScheduleRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getSchedule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   String name = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString();
   *   Schedule response = scheduleServiceClient.getSchedule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Schedule resource. Format:
   *     `projects/{project}/locations/{location}/schedules/{schedule}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schedule getSchedule(String name) {
    GetScheduleRequest request = GetScheduleRequest.newBuilder().setName(name).build();
    return getSchedule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   GetScheduleRequest request =
   *       GetScheduleRequest.newBuilder()
   *           .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
   *           .build();
   *   Schedule response = scheduleServiceClient.getSchedule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schedule getSchedule(GetScheduleRequest request) {
    return getScheduleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a Schedule.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   GetScheduleRequest request =
   *       GetScheduleRequest.newBuilder()
   *           .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
   *           .build();
   *   ApiFuture<Schedule> future = scheduleServiceClient.getScheduleCallable().futureCall(request);
   *   // Do something.
   *   Schedule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetScheduleRequest, Schedule> getScheduleCallable() {
    return stub.getScheduleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Schedules in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Schedule element : scheduleServiceClient.listSchedules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the Schedules from. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSchedulesPagedResponse listSchedules(LocationName parent) {
    ListSchedulesRequest request =
        ListSchedulesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listSchedules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Schedules in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Schedule element : scheduleServiceClient.listSchedules(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the Schedules from. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSchedulesPagedResponse listSchedules(String parent) {
    ListSchedulesRequest request = ListSchedulesRequest.newBuilder().setParent(parent).build();
    return listSchedules(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Schedules in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   ListSchedulesRequest request =
   *       ListSchedulesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Schedule element : scheduleServiceClient.listSchedules(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListSchedulesPagedResponse listSchedules(ListSchedulesRequest request) {
    return listSchedulesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Schedules in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   ListSchedulesRequest request =
   *       ListSchedulesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Schedule> future =
   *       scheduleServiceClient.listSchedulesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Schedule element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListSchedulesRequest, ListSchedulesPagedResponse>
      listSchedulesPagedCallable() {
    return stub.listSchedulesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Schedules in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   ListSchedulesRequest request =
   *       ListSchedulesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListSchedulesResponse response =
   *         scheduleServiceClient.listSchedulesCallable().call(request);
   *     for (Schedule element : response.getSchedulesList()) {
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
  public final UnaryCallable<ListSchedulesRequest, ListSchedulesResponse> listSchedulesCallable() {
    return stub.listSchedulesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses a Schedule. Will mark [Schedule.state][google.cloud.aiplatform.v1beta1.Schedule.state]
   * to 'PAUSED'. If the schedule is paused, no new runs will be created. Already created runs will
   * NOT be paused or canceled.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   ScheduleName name = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]");
   *   scheduleServiceClient.pauseSchedule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Schedule resource to be paused. Format:
   *     `projects/{project}/locations/{location}/schedules/{schedule}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void pauseSchedule(ScheduleName name) {
    PauseScheduleRequest request =
        PauseScheduleRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    pauseSchedule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses a Schedule. Will mark [Schedule.state][google.cloud.aiplatform.v1beta1.Schedule.state]
   * to 'PAUSED'. If the schedule is paused, no new runs will be created. Already created runs will
   * NOT be paused or canceled.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   String name = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString();
   *   scheduleServiceClient.pauseSchedule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Schedule resource to be paused. Format:
   *     `projects/{project}/locations/{location}/schedules/{schedule}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void pauseSchedule(String name) {
    PauseScheduleRequest request = PauseScheduleRequest.newBuilder().setName(name).build();
    pauseSchedule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses a Schedule. Will mark [Schedule.state][google.cloud.aiplatform.v1beta1.Schedule.state]
   * to 'PAUSED'. If the schedule is paused, no new runs will be created. Already created runs will
   * NOT be paused or canceled.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   PauseScheduleRequest request =
   *       PauseScheduleRequest.newBuilder()
   *           .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
   *           .build();
   *   scheduleServiceClient.pauseSchedule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void pauseSchedule(PauseScheduleRequest request) {
    pauseScheduleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses a Schedule. Will mark [Schedule.state][google.cloud.aiplatform.v1beta1.Schedule.state]
   * to 'PAUSED'. If the schedule is paused, no new runs will be created. Already created runs will
   * NOT be paused or canceled.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   PauseScheduleRequest request =
   *       PauseScheduleRequest.newBuilder()
   *           .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
   *           .build();
   *   ApiFuture<Empty> future = scheduleServiceClient.pauseScheduleCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PauseScheduleRequest, Empty> pauseScheduleCallable() {
    return stub.pauseScheduleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a paused Schedule to start scheduling new runs. Will mark
   * [Schedule.state][google.cloud.aiplatform.v1beta1.Schedule.state] to 'ACTIVE'. Only paused
   * Schedule can be resumed.
   *
   * <p>When the Schedule is resumed, new runs will be scheduled starting from the next execution
   * time after the current time based on the time_specification in the Schedule. If
   * [Schedule.catchUp][] is set up true, all missed runs will be scheduled for backfill first.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   ScheduleName name = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]");
   *   scheduleServiceClient.resumeSchedule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Schedule resource to be resumed. Format:
   *     `projects/{project}/locations/{location}/schedules/{schedule}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void resumeSchedule(ScheduleName name) {
    ResumeScheduleRequest request =
        ResumeScheduleRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    resumeSchedule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a paused Schedule to start scheduling new runs. Will mark
   * [Schedule.state][google.cloud.aiplatform.v1beta1.Schedule.state] to 'ACTIVE'. Only paused
   * Schedule can be resumed.
   *
   * <p>When the Schedule is resumed, new runs will be scheduled starting from the next execution
   * time after the current time based on the time_specification in the Schedule. If
   * [Schedule.catchUp][] is set up true, all missed runs will be scheduled for backfill first.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   String name = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString();
   *   scheduleServiceClient.resumeSchedule(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Schedule resource to be resumed. Format:
   *     `projects/{project}/locations/{location}/schedules/{schedule}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void resumeSchedule(String name) {
    ResumeScheduleRequest request = ResumeScheduleRequest.newBuilder().setName(name).build();
    resumeSchedule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a paused Schedule to start scheduling new runs. Will mark
   * [Schedule.state][google.cloud.aiplatform.v1beta1.Schedule.state] to 'ACTIVE'. Only paused
   * Schedule can be resumed.
   *
   * <p>When the Schedule is resumed, new runs will be scheduled starting from the next execution
   * time after the current time based on the time_specification in the Schedule. If
   * [Schedule.catchUp][] is set up true, all missed runs will be scheduled for backfill first.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   ScheduleName name = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]");
   *   boolean catchUp = true;
   *   scheduleServiceClient.resumeSchedule(name, catchUp);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Schedule resource to be resumed. Format:
   *     `projects/{project}/locations/{location}/schedules/{schedule}`
   * @param catchUp Optional. Whether to backfill missed runs when the schedule is resumed from
   *     PAUSED state. If set to true, all missed runs will be scheduled. New runs will be scheduled
   *     after the backfill is complete. This will also update
   *     [Schedule.catch_up][google.cloud.aiplatform.v1beta1.Schedule.catch_up] field. Default to
   *     false.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void resumeSchedule(ScheduleName name, boolean catchUp) {
    ResumeScheduleRequest request =
        ResumeScheduleRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setCatchUp(catchUp)
            .build();
    resumeSchedule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a paused Schedule to start scheduling new runs. Will mark
   * [Schedule.state][google.cloud.aiplatform.v1beta1.Schedule.state] to 'ACTIVE'. Only paused
   * Schedule can be resumed.
   *
   * <p>When the Schedule is resumed, new runs will be scheduled starting from the next execution
   * time after the current time based on the time_specification in the Schedule. If
   * [Schedule.catchUp][] is set up true, all missed runs will be scheduled for backfill first.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   String name = ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString();
   *   boolean catchUp = true;
   *   scheduleServiceClient.resumeSchedule(name, catchUp);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Schedule resource to be resumed. Format:
   *     `projects/{project}/locations/{location}/schedules/{schedule}`
   * @param catchUp Optional. Whether to backfill missed runs when the schedule is resumed from
   *     PAUSED state. If set to true, all missed runs will be scheduled. New runs will be scheduled
   *     after the backfill is complete. This will also update
   *     [Schedule.catch_up][google.cloud.aiplatform.v1beta1.Schedule.catch_up] field. Default to
   *     false.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void resumeSchedule(String name, boolean catchUp) {
    ResumeScheduleRequest request =
        ResumeScheduleRequest.newBuilder().setName(name).setCatchUp(catchUp).build();
    resumeSchedule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a paused Schedule to start scheduling new runs. Will mark
   * [Schedule.state][google.cloud.aiplatform.v1beta1.Schedule.state] to 'ACTIVE'. Only paused
   * Schedule can be resumed.
   *
   * <p>When the Schedule is resumed, new runs will be scheduled starting from the next execution
   * time after the current time based on the time_specification in the Schedule. If
   * [Schedule.catchUp][] is set up true, all missed runs will be scheduled for backfill first.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   ResumeScheduleRequest request =
   *       ResumeScheduleRequest.newBuilder()
   *           .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
   *           .setCatchUp(true)
   *           .build();
   *   scheduleServiceClient.resumeSchedule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void resumeSchedule(ResumeScheduleRequest request) {
    resumeScheduleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes a paused Schedule to start scheduling new runs. Will mark
   * [Schedule.state][google.cloud.aiplatform.v1beta1.Schedule.state] to 'ACTIVE'. Only paused
   * Schedule can be resumed.
   *
   * <p>When the Schedule is resumed, new runs will be scheduled starting from the next execution
   * time after the current time based on the time_specification in the Schedule. If
   * [Schedule.catchUp][] is set up true, all missed runs will be scheduled for backfill first.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   ResumeScheduleRequest request =
   *       ResumeScheduleRequest.newBuilder()
   *           .setName(ScheduleName.of("[PROJECT]", "[LOCATION]", "[SCHEDULE]").toString())
   *           .setCatchUp(true)
   *           .build();
   *   ApiFuture<Empty> future = scheduleServiceClient.resumeScheduleCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResumeScheduleRequest, Empty> resumeScheduleCallable() {
    return stub.resumeScheduleCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an active or paused Schedule.
   *
   * <p>When the Schedule is updated, new runs will be scheduled starting from the updated next
   * execution time after the update time based on the time_specification in the updated Schedule.
   * All unstarted runs before the update time will be skipped while already created runs will NOT
   * be paused or canceled.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   Schedule schedule = Schedule.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Schedule response = scheduleServiceClient.updateSchedule(schedule, updateMask);
   * }
   * }</pre>
   *
   * @param schedule Required. The Schedule which replaces the resource on the server. The following
   *     restrictions will be applied:
   *     <p>&#42; The scheduled request type cannot be changed. &#42; The non-empty fields cannot be
   *     unset. &#42; The output_only fields will be ignored if specified.
   * @param updateMask Required. The update mask applies to the resource. See
   *     [google.protobuf.FieldMask][google.protobuf.FieldMask].
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schedule updateSchedule(Schedule schedule, FieldMask updateMask) {
    UpdateScheduleRequest request =
        UpdateScheduleRequest.newBuilder().setSchedule(schedule).setUpdateMask(updateMask).build();
    return updateSchedule(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an active or paused Schedule.
   *
   * <p>When the Schedule is updated, new runs will be scheduled starting from the updated next
   * execution time after the update time based on the time_specification in the updated Schedule.
   * All unstarted runs before the update time will be skipped while already created runs will NOT
   * be paused or canceled.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   UpdateScheduleRequest request =
   *       UpdateScheduleRequest.newBuilder()
   *           .setSchedule(Schedule.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Schedule response = scheduleServiceClient.updateSchedule(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Schedule updateSchedule(UpdateScheduleRequest request) {
    return updateScheduleCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an active or paused Schedule.
   *
   * <p>When the Schedule is updated, new runs will be scheduled starting from the updated next
   * execution time after the update time based on the time_specification in the updated Schedule.
   * All unstarted runs before the update time will be skipped while already created runs will NOT
   * be paused or canceled.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   UpdateScheduleRequest request =
   *       UpdateScheduleRequest.newBuilder()
   *           .setSchedule(Schedule.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Schedule> future =
   *       scheduleServiceClient.updateScheduleCallable().futureCall(request);
   *   // Do something.
   *   Schedule response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateScheduleRequest, Schedule> updateScheduleCallable() {
    return stub.updateScheduleCallable();
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
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : scheduleServiceClient.listLocations(request).iterateAll()) {
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
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       scheduleServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         scheduleServiceClient.listLocationsCallable().call(request);
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
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = scheduleServiceClient.getLocation(request);
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
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = scheduleServiceClient.getLocationCallable().futureCall(request);
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
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = scheduleServiceClient.setIamPolicy(request);
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
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = scheduleServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = scheduleServiceClient.getIamPolicy(request);
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
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = scheduleServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = scheduleServiceClient.testIamPermissions(request);
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
   * try (ScheduleServiceClient scheduleServiceClient = ScheduleServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       scheduleServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListSchedulesPagedResponse
      extends AbstractPagedListResponse<
          ListSchedulesRequest,
          ListSchedulesResponse,
          Schedule,
          ListSchedulesPage,
          ListSchedulesFixedSizeCollection> {

    public static ApiFuture<ListSchedulesPagedResponse> createAsync(
        PageContext<ListSchedulesRequest, ListSchedulesResponse, Schedule> context,
        ApiFuture<ListSchedulesResponse> futureResponse) {
      ApiFuture<ListSchedulesPage> futurePage =
          ListSchedulesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListSchedulesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListSchedulesPagedResponse(ListSchedulesPage page) {
      super(page, ListSchedulesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListSchedulesPage
      extends AbstractPage<
          ListSchedulesRequest, ListSchedulesResponse, Schedule, ListSchedulesPage> {

    private ListSchedulesPage(
        PageContext<ListSchedulesRequest, ListSchedulesResponse, Schedule> context,
        ListSchedulesResponse response) {
      super(context, response);
    }

    private static ListSchedulesPage createEmptyPage() {
      return new ListSchedulesPage(null, null);
    }

    @Override
    protected ListSchedulesPage createPage(
        PageContext<ListSchedulesRequest, ListSchedulesResponse, Schedule> context,
        ListSchedulesResponse response) {
      return new ListSchedulesPage(context, response);
    }

    @Override
    public ApiFuture<ListSchedulesPage> createPageAsync(
        PageContext<ListSchedulesRequest, ListSchedulesResponse, Schedule> context,
        ApiFuture<ListSchedulesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListSchedulesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListSchedulesRequest,
          ListSchedulesResponse,
          Schedule,
          ListSchedulesPage,
          ListSchedulesFixedSizeCollection> {

    private ListSchedulesFixedSizeCollection(List<ListSchedulesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListSchedulesFixedSizeCollection createEmptyCollection() {
      return new ListSchedulesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListSchedulesFixedSizeCollection createCollection(
        List<ListSchedulesPage> pages, int collectionSize) {
      return new ListSchedulesFixedSizeCollection(pages, collectionSize);
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
