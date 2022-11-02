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

package com.google.cloud.eventarc.v1;

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
import com.google.cloud.eventarc.v1.stub.EventarcStub;
import com.google.cloud.eventarc.v1.stub.EventarcStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Eventarc allows users to subscribe to various events that are provided by
 * Google Cloud services and forward them to supported destinations.
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
 * try (EventarcClient eventarcClient = EventarcClient.create()) {
 *   TriggerName name = TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]");
 *   Trigger response = eventarcClient.getTrigger(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the EventarcClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of EventarcSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * EventarcSettings eventarcSettings =
 *     EventarcSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * EventarcClient eventarcClient = EventarcClient.create(eventarcSettings);
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
 * EventarcSettings eventarcSettings =
 *     EventarcSettings.newBuilder().setEndpoint(myEndpoint).build();
 * EventarcClient eventarcClient = EventarcClient.create(eventarcSettings);
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
 * EventarcSettings eventarcSettings = EventarcSettings.newHttpJsonBuilder().build();
 * EventarcClient eventarcClient = EventarcClient.create(eventarcSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class EventarcClient implements BackgroundResource {
  private final EventarcSettings settings;
  private final EventarcStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of EventarcClient with default settings. */
  public static final EventarcClient create() throws IOException {
    return create(EventarcSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of EventarcClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final EventarcClient create(EventarcSettings settings) throws IOException {
    return new EventarcClient(settings);
  }

  /**
   * Constructs an instance of EventarcClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(EventarcSettings).
   */
  public static final EventarcClient create(EventarcStub stub) {
    return new EventarcClient(stub);
  }

  /**
   * Constructs an instance of EventarcClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected EventarcClient(EventarcSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((EventarcStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected EventarcClient(EventarcStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final EventarcSettings getSettings() {
    return settings;
  }

  public EventarcStub getStub() {
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
   * Get a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   TriggerName name = TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]");
   *   Trigger response = eventarcClient.getTrigger(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the trigger to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trigger getTrigger(TriggerName name) {
    GetTriggerRequest request =
        GetTriggerRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTrigger(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String name = TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString();
   *   Trigger response = eventarcClient.getTrigger(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the trigger to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trigger getTrigger(String name) {
    GetTriggerRequest request = GetTriggerRequest.newBuilder().setName(name).build();
    return getTrigger(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetTriggerRequest request =
   *       GetTriggerRequest.newBuilder()
   *           .setName(TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString())
   *           .build();
   *   Trigger response = eventarcClient.getTrigger(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Trigger getTrigger(GetTriggerRequest request) {
    return getTriggerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetTriggerRequest request =
   *       GetTriggerRequest.newBuilder()
   *           .setName(TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString())
   *           .build();
   *   ApiFuture<Trigger> future = eventarcClient.getTriggerCallable().futureCall(request);
   *   // Do something.
   *   Trigger response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTriggerRequest, Trigger> getTriggerCallable() {
    return stub.getTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List triggers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Trigger element : eventarcClient.listTriggers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection to list triggers on.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTriggersPagedResponse listTriggers(LocationName parent) {
    ListTriggersRequest request =
        ListTriggersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTriggers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List triggers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Trigger element : eventarcClient.listTriggers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection to list triggers on.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTriggersPagedResponse listTriggers(String parent) {
    ListTriggersRequest request = ListTriggersRequest.newBuilder().setParent(parent).build();
    return listTriggers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List triggers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListTriggersRequest request =
   *       ListTriggersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Trigger element : eventarcClient.listTriggers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTriggersPagedResponse listTriggers(ListTriggersRequest request) {
    return listTriggersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List triggers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListTriggersRequest request =
   *       ListTriggersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Trigger> future = eventarcClient.listTriggersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Trigger element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTriggersRequest, ListTriggersPagedResponse>
      listTriggersPagedCallable() {
    return stub.listTriggersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List triggers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListTriggersRequest request =
   *       ListTriggersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListTriggersResponse response = eventarcClient.listTriggersCallable().call(request);
   *     for (Trigger element : response.getTriggersList()) {
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
  public final UnaryCallable<ListTriggersRequest, ListTriggersResponse> listTriggersCallable() {
    return stub.listTriggersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new trigger in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Trigger trigger = Trigger.newBuilder().build();
   *   String triggerId = "triggerId-648752909";
   *   Trigger response = eventarcClient.createTriggerAsync(parent, trigger, triggerId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which to add this trigger.
   * @param trigger Required. The trigger to create.
   * @param triggerId Required. The user-provided ID to be assigned to the trigger.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Trigger, OperationMetadata> createTriggerAsync(
      LocationName parent, Trigger trigger, String triggerId) {
    CreateTriggerRequest request =
        CreateTriggerRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTrigger(trigger)
            .setTriggerId(triggerId)
            .build();
    return createTriggerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new trigger in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Trigger trigger = Trigger.newBuilder().build();
   *   String triggerId = "triggerId-648752909";
   *   Trigger response = eventarcClient.createTriggerAsync(parent, trigger, triggerId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which to add this trigger.
   * @param trigger Required. The trigger to create.
   * @param triggerId Required. The user-provided ID to be assigned to the trigger.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Trigger, OperationMetadata> createTriggerAsync(
      String parent, Trigger trigger, String triggerId) {
    CreateTriggerRequest request =
        CreateTriggerRequest.newBuilder()
            .setParent(parent)
            .setTrigger(trigger)
            .setTriggerId(triggerId)
            .build();
    return createTriggerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new trigger in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateTriggerRequest request =
   *       CreateTriggerRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTrigger(Trigger.newBuilder().build())
   *           .setTriggerId("triggerId-648752909")
   *           .setValidateOnly(true)
   *           .build();
   *   Trigger response = eventarcClient.createTriggerAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Trigger, OperationMetadata> createTriggerAsync(
      CreateTriggerRequest request) {
    return createTriggerOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new trigger in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateTriggerRequest request =
   *       CreateTriggerRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTrigger(Trigger.newBuilder().build())
   *           .setTriggerId("triggerId-648752909")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Trigger, OperationMetadata> future =
   *       eventarcClient.createTriggerOperationCallable().futureCall(request);
   *   // Do something.
   *   Trigger response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateTriggerRequest, Trigger, OperationMetadata>
      createTriggerOperationCallable() {
    return stub.createTriggerOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new trigger in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateTriggerRequest request =
   *       CreateTriggerRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTrigger(Trigger.newBuilder().build())
   *           .setTriggerId("triggerId-648752909")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = eventarcClient.createTriggerCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTriggerRequest, Operation> createTriggerCallable() {
    return stub.createTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   Trigger trigger = Trigger.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   boolean allowMissing = true;
   *   Trigger response = eventarcClient.updateTriggerAsync(trigger, updateMask, allowMissing).get();
   * }
   * }</pre>
   *
   * @param trigger The trigger to be updated.
   * @param updateMask The fields to be updated; only fields explicitly provided are updated. If no
   *     field mask is provided, all provided fields in the request are updated. To update all
   *     fields, provide a field mask of "&#42;".
   * @param allowMissing If set to true, and the trigger is not found, a new trigger will be
   *     created. In this situation, `update_mask` is ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Trigger, OperationMetadata> updateTriggerAsync(
      Trigger trigger, FieldMask updateMask, boolean allowMissing) {
    UpdateTriggerRequest request =
        UpdateTriggerRequest.newBuilder()
            .setTrigger(trigger)
            .setUpdateMask(updateMask)
            .setAllowMissing(allowMissing)
            .build();
    return updateTriggerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdateTriggerRequest request =
   *       UpdateTriggerRequest.newBuilder()
   *           .setTrigger(Trigger.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   Trigger response = eventarcClient.updateTriggerAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Trigger, OperationMetadata> updateTriggerAsync(
      UpdateTriggerRequest request) {
    return updateTriggerOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdateTriggerRequest request =
   *       UpdateTriggerRequest.newBuilder()
   *           .setTrigger(Trigger.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Trigger, OperationMetadata> future =
   *       eventarcClient.updateTriggerOperationCallable().futureCall(request);
   *   // Do something.
   *   Trigger response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateTriggerRequest, Trigger, OperationMetadata>
      updateTriggerOperationCallable() {
    return stub.updateTriggerOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdateTriggerRequest request =
   *       UpdateTriggerRequest.newBuilder()
   *           .setTrigger(Trigger.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = eventarcClient.updateTriggerCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTriggerRequest, Operation> updateTriggerCallable() {
    return stub.updateTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   TriggerName name = TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]");
   *   boolean allowMissing = true;
   *   Trigger response = eventarcClient.deleteTriggerAsync(name, allowMissing).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the trigger to be deleted.
   * @param allowMissing If set to true, and the trigger is not found, the request will succeed but
   *     no action will be taken on the server.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Trigger, OperationMetadata> deleteTriggerAsync(
      TriggerName name, boolean allowMissing) {
    DeleteTriggerRequest request =
        DeleteTriggerRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setAllowMissing(allowMissing)
            .build();
    return deleteTriggerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String name = TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString();
   *   boolean allowMissing = true;
   *   Trigger response = eventarcClient.deleteTriggerAsync(name, allowMissing).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the trigger to be deleted.
   * @param allowMissing If set to true, and the trigger is not found, the request will succeed but
   *     no action will be taken on the server.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Trigger, OperationMetadata> deleteTriggerAsync(
      String name, boolean allowMissing) {
    DeleteTriggerRequest request =
        DeleteTriggerRequest.newBuilder().setName(name).setAllowMissing(allowMissing).build();
    return deleteTriggerAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteTriggerRequest request =
   *       DeleteTriggerRequest.newBuilder()
   *           .setName(TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString())
   *           .setEtag("etag3123477")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   Trigger response = eventarcClient.deleteTriggerAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Trigger, OperationMetadata> deleteTriggerAsync(
      DeleteTriggerRequest request) {
    return deleteTriggerOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteTriggerRequest request =
   *       DeleteTriggerRequest.newBuilder()
   *           .setName(TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString())
   *           .setEtag("etag3123477")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Trigger, OperationMetadata> future =
   *       eventarcClient.deleteTriggerOperationCallable().futureCall(request);
   *   // Do something.
   *   Trigger response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteTriggerRequest, Trigger, OperationMetadata>
      deleteTriggerOperationCallable() {
    return stub.deleteTriggerOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteTriggerRequest request =
   *       DeleteTriggerRequest.newBuilder()
   *           .setName(TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString())
   *           .setEtag("etag3123477")
   *           .setAllowMissing(true)
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = eventarcClient.deleteTriggerCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTriggerRequest, Operation> deleteTriggerCallable() {
    return stub.deleteTriggerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single Channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
   *   Channel response = eventarcClient.getChannel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Channel getChannel(ChannelName name) {
    GetChannelRequest request =
        GetChannelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getChannel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single Channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString();
   *   Channel response = eventarcClient.getChannel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Channel getChannel(String name) {
    GetChannelRequest request = GetChannelRequest.newBuilder().setName(name).build();
    return getChannel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single Channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetChannelRequest request =
   *       GetChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .build();
   *   Channel response = eventarcClient.getChannel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Channel getChannel(GetChannelRequest request) {
    return getChannelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single Channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetChannelRequest request =
   *       GetChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .build();
   *   ApiFuture<Channel> future = eventarcClient.getChannelCallable().futureCall(request);
   *   // Do something.
   *   Channel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetChannelRequest, Channel> getChannelCallable() {
    return stub.getChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List channels.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Channel element : eventarcClient.listChannels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection to list channels on.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChannelsPagedResponse listChannels(LocationName parent) {
    ListChannelsRequest request =
        ListChannelsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listChannels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List channels.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Channel element : eventarcClient.listChannels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection to list channels on.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChannelsPagedResponse listChannels(String parent) {
    ListChannelsRequest request = ListChannelsRequest.newBuilder().setParent(parent).build();
    return listChannels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List channels.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListChannelsRequest request =
   *       ListChannelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Channel element : eventarcClient.listChannels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChannelsPagedResponse listChannels(ListChannelsRequest request) {
    return listChannelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List channels.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListChannelsRequest request =
   *       ListChannelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Channel> future = eventarcClient.listChannelsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Channel element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListChannelsRequest, ListChannelsPagedResponse>
      listChannelsPagedCallable() {
    return stub.listChannelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List channels.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListChannelsRequest request =
   *       ListChannelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListChannelsResponse response = eventarcClient.listChannelsCallable().call(request);
   *     for (Channel element : response.getChannelsList()) {
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
  public final UnaryCallable<ListChannelsRequest, ListChannelsResponse> listChannelsCallable() {
    return stub.listChannelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new channel in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Channel channel = Channel.newBuilder().build();
   *   String channelId = "channelId1461735806";
   *   Channel response = eventarcClient.createChannelAsync(parent, channel, channelId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which to add this channel.
   * @param channel Required. The channel to create.
   * @param channelId Required. The user-provided ID to be assigned to the channel.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> createChannelAsync(
      LocationName parent, Channel channel, String channelId) {
    CreateChannelRequest request =
        CreateChannelRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setChannel(channel)
            .setChannelId(channelId)
            .build();
    return createChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new channel in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Channel channel = Channel.newBuilder().build();
   *   String channelId = "channelId1461735806";
   *   Channel response = eventarcClient.createChannelAsync(parent, channel, channelId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which to add this channel.
   * @param channel Required. The channel to create.
   * @param channelId Required. The user-provided ID to be assigned to the channel.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> createChannelAsync(
      String parent, Channel channel, String channelId) {
    CreateChannelRequest request =
        CreateChannelRequest.newBuilder()
            .setParent(parent)
            .setChannel(channel)
            .setChannelId(channelId)
            .build();
    return createChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new channel in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateChannelRequest request =
   *       CreateChannelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setChannel(Channel.newBuilder().build())
   *           .setChannelId("channelId1461735806")
   *           .setValidateOnly(true)
   *           .build();
   *   Channel response = eventarcClient.createChannelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> createChannelAsync(
      CreateChannelRequest request) {
    return createChannelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new channel in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateChannelRequest request =
   *       CreateChannelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setChannel(Channel.newBuilder().build())
   *           .setChannelId("channelId1461735806")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Channel, OperationMetadata> future =
   *       eventarcClient.createChannelOperationCallable().futureCall(request);
   *   // Do something.
   *   Channel response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateChannelRequest, Channel, OperationMetadata>
      createChannelOperationCallable() {
    return stub.createChannelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new channel in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateChannelRequest request =
   *       CreateChannelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setChannel(Channel.newBuilder().build())
   *           .setChannelId("channelId1461735806")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = eventarcClient.createChannelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateChannelRequest, Operation> createChannelCallable() {
    return stub.createChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   Channel channel = Channel.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Channel response = eventarcClient.updateChannelAsync(channel, updateMask).get();
   * }
   * }</pre>
   *
   * @param channel The channel to be updated.
   * @param updateMask The fields to be updated; only fields explicitly provided are updated. If no
   *     field mask is provided, all provided fields in the request are updated. To update all
   *     fields, provide a field mask of "&#42;".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> updateChannelAsync(
      Channel channel, FieldMask updateMask) {
    UpdateChannelRequest request =
        UpdateChannelRequest.newBuilder().setChannel(channel).setUpdateMask(updateMask).build();
    return updateChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdateChannelRequest request =
   *       UpdateChannelRequest.newBuilder()
   *           .setChannel(Channel.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   Channel response = eventarcClient.updateChannelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> updateChannelAsync(
      UpdateChannelRequest request) {
    return updateChannelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdateChannelRequest request =
   *       UpdateChannelRequest.newBuilder()
   *           .setChannel(Channel.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Channel, OperationMetadata> future =
   *       eventarcClient.updateChannelOperationCallable().futureCall(request);
   *   // Do something.
   *   Channel response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateChannelRequest, Channel, OperationMetadata>
      updateChannelOperationCallable() {
    return stub.updateChannelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a single channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   UpdateChannelRequest request =
   *       UpdateChannelRequest.newBuilder()
   *           .setChannel(Channel.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = eventarcClient.updateChannelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateChannelRequest, Operation> updateChannelCallable() {
    return stub.updateChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
   *   Channel response = eventarcClient.deleteChannelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel to be deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> deleteChannelAsync(ChannelName name) {
    DeleteChannelRequest request =
        DeleteChannelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString();
   *   Channel response = eventarcClient.deleteChannelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel to be deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> deleteChannelAsync(String name) {
    DeleteChannelRequest request = DeleteChannelRequest.newBuilder().setName(name).build();
    return deleteChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteChannelRequest request =
   *       DeleteChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setValidateOnly(true)
   *           .build();
   *   Channel response = eventarcClient.deleteChannelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> deleteChannelAsync(
      DeleteChannelRequest request) {
    return deleteChannelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteChannelRequest request =
   *       DeleteChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<Channel, OperationMetadata> future =
   *       eventarcClient.deleteChannelOperationCallable().futureCall(request);
   *   // Do something.
   *   Channel response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteChannelRequest, Channel, OperationMetadata>
      deleteChannelOperationCallable() {
    return stub.deleteChannelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteChannelRequest request =
   *       DeleteChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future = eventarcClient.deleteChannelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteChannelRequest, Operation> deleteChannelCallable() {
    return stub.deleteChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single Provider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ProviderName name = ProviderName.of("[PROJECT]", "[LOCATION]", "[PROVIDER]");
   *   Provider response = eventarcClient.getProvider(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the provider to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Provider getProvider(ProviderName name) {
    GetProviderRequest request =
        GetProviderRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single Provider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String name = ProviderName.of("[PROJECT]", "[LOCATION]", "[PROVIDER]").toString();
   *   Provider response = eventarcClient.getProvider(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the provider to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Provider getProvider(String name) {
    GetProviderRequest request = GetProviderRequest.newBuilder().setName(name).build();
    return getProvider(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single Provider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetProviderRequest request =
   *       GetProviderRequest.newBuilder()
   *           .setName(ProviderName.of("[PROJECT]", "[LOCATION]", "[PROVIDER]").toString())
   *           .build();
   *   Provider response = eventarcClient.getProvider(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Provider getProvider(GetProviderRequest request) {
    return getProviderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single Provider.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetProviderRequest request =
   *       GetProviderRequest.newBuilder()
   *           .setName(ProviderName.of("[PROJECT]", "[LOCATION]", "[PROVIDER]").toString())
   *           .build();
   *   ApiFuture<Provider> future = eventarcClient.getProviderCallable().futureCall(request);
   *   // Do something.
   *   Provider response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProviderRequest, Provider> getProviderCallable() {
    return stub.getProviderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List providers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Provider element : eventarcClient.listProviders(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the provider to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProvidersPagedResponse listProviders(LocationName parent) {
    ListProvidersRequest request =
        ListProvidersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listProviders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List providers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Provider element : eventarcClient.listProviders(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the provider to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProvidersPagedResponse listProviders(String parent) {
    ListProvidersRequest request = ListProvidersRequest.newBuilder().setParent(parent).build();
    return listProviders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List providers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListProvidersRequest request =
   *       ListProvidersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Provider element : eventarcClient.listProviders(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListProvidersPagedResponse listProviders(ListProvidersRequest request) {
    return listProvidersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List providers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListProvidersRequest request =
   *       ListProvidersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Provider> future = eventarcClient.listProvidersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Provider element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListProvidersRequest, ListProvidersPagedResponse>
      listProvidersPagedCallable() {
    return stub.listProvidersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List providers.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListProvidersRequest request =
   *       ListProvidersRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListProvidersResponse response = eventarcClient.listProvidersCallable().call(request);
   *     for (Provider element : response.getProvidersList()) {
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
  public final UnaryCallable<ListProvidersRequest, ListProvidersResponse> listProvidersCallable() {
    return stub.listProvidersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single ChannelConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ChannelConnectionName name =
   *       ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]");
   *   ChannelConnection response = eventarcClient.getChannelConnection(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel connection to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelConnection getChannelConnection(ChannelConnectionName name) {
    GetChannelConnectionRequest request =
        GetChannelConnectionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getChannelConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single ChannelConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String name =
   *       ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]").toString();
   *   ChannelConnection response = eventarcClient.getChannelConnection(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel connection to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelConnection getChannelConnection(String name) {
    GetChannelConnectionRequest request =
        GetChannelConnectionRequest.newBuilder().setName(name).build();
    return getChannelConnection(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single ChannelConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetChannelConnectionRequest request =
   *       GetChannelConnectionRequest.newBuilder()
   *           .setName(
   *               ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]")
   *                   .toString())
   *           .build();
   *   ChannelConnection response = eventarcClient.getChannelConnection(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChannelConnection getChannelConnection(GetChannelConnectionRequest request) {
    return getChannelConnectionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a single ChannelConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   GetChannelConnectionRequest request =
   *       GetChannelConnectionRequest.newBuilder()
   *           .setName(
   *               ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ChannelConnection> future =
   *       eventarcClient.getChannelConnectionCallable().futureCall(request);
   *   // Do something.
   *   ChannelConnection response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetChannelConnectionRequest, ChannelConnection>
      getChannelConnectionCallable() {
    return stub.getChannelConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List channel connections.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ChannelConnection element : eventarcClient.listChannelConnections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection from which to list channel connections.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChannelConnectionsPagedResponse listChannelConnections(LocationName parent) {
    ListChannelConnectionsRequest request =
        ListChannelConnectionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listChannelConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List channel connections.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ChannelConnection element : eventarcClient.listChannelConnections(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection from which to list channel connections.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChannelConnectionsPagedResponse listChannelConnections(String parent) {
    ListChannelConnectionsRequest request =
        ListChannelConnectionsRequest.newBuilder().setParent(parent).build();
    return listChannelConnections(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List channel connections.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListChannelConnectionsRequest request =
   *       ListChannelConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ChannelConnection element :
   *       eventarcClient.listChannelConnections(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChannelConnectionsPagedResponse listChannelConnections(
      ListChannelConnectionsRequest request) {
    return listChannelConnectionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List channel connections.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListChannelConnectionsRequest request =
   *       ListChannelConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ChannelConnection> future =
   *       eventarcClient.listChannelConnectionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ChannelConnection element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListChannelConnectionsRequest, ListChannelConnectionsPagedResponse>
      listChannelConnectionsPagedCallable() {
    return stub.listChannelConnectionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List channel connections.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListChannelConnectionsRequest request =
   *       ListChannelConnectionsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListChannelConnectionsResponse response =
   *         eventarcClient.listChannelConnectionsCallable().call(request);
   *     for (ChannelConnection element : response.getChannelConnectionsList()) {
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
  public final UnaryCallable<ListChannelConnectionsRequest, ListChannelConnectionsResponse>
      listChannelConnectionsCallable() {
    return stub.listChannelConnectionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new ChannelConnection in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ChannelConnection channelConnection = ChannelConnection.newBuilder().build();
   *   String channelConnectionId = "channelConnectionId-1246974660";
   *   ChannelConnection response =
   *       eventarcClient
   *           .createChannelConnectionAsync(parent, channelConnection, channelConnectionId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which to add this channel connection.
   * @param channelConnection Required. Channel connection to create.
   * @param channelConnectionId Required. The user-provided ID to be assigned to the channel
   *     connection.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelConnection, OperationMetadata> createChannelConnectionAsync(
      LocationName parent, ChannelConnection channelConnection, String channelConnectionId) {
    CreateChannelConnectionRequest request =
        CreateChannelConnectionRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setChannelConnection(channelConnection)
            .setChannelConnectionId(channelConnectionId)
            .build();
    return createChannelConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new ChannelConnection in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ChannelConnection channelConnection = ChannelConnection.newBuilder().build();
   *   String channelConnectionId = "channelConnectionId-1246974660";
   *   ChannelConnection response =
   *       eventarcClient
   *           .createChannelConnectionAsync(parent, channelConnection, channelConnectionId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent collection in which to add this channel connection.
   * @param channelConnection Required. Channel connection to create.
   * @param channelConnectionId Required. The user-provided ID to be assigned to the channel
   *     connection.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelConnection, OperationMetadata> createChannelConnectionAsync(
      String parent, ChannelConnection channelConnection, String channelConnectionId) {
    CreateChannelConnectionRequest request =
        CreateChannelConnectionRequest.newBuilder()
            .setParent(parent)
            .setChannelConnection(channelConnection)
            .setChannelConnectionId(channelConnectionId)
            .build();
    return createChannelConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new ChannelConnection in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateChannelConnectionRequest request =
   *       CreateChannelConnectionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setChannelConnection(ChannelConnection.newBuilder().build())
   *           .setChannelConnectionId("channelConnectionId-1246974660")
   *           .build();
   *   ChannelConnection response = eventarcClient.createChannelConnectionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelConnection, OperationMetadata> createChannelConnectionAsync(
      CreateChannelConnectionRequest request) {
    return createChannelConnectionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new ChannelConnection in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateChannelConnectionRequest request =
   *       CreateChannelConnectionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setChannelConnection(ChannelConnection.newBuilder().build())
   *           .setChannelConnectionId("channelConnectionId-1246974660")
   *           .build();
   *   OperationFuture<ChannelConnection, OperationMetadata> future =
   *       eventarcClient.createChannelConnectionOperationCallable().futureCall(request);
   *   // Do something.
   *   ChannelConnection response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateChannelConnectionRequest, ChannelConnection, OperationMetadata>
      createChannelConnectionOperationCallable() {
    return stub.createChannelConnectionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new ChannelConnection in a particular project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateChannelConnectionRequest request =
   *       CreateChannelConnectionRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setChannelConnection(ChannelConnection.newBuilder().build())
   *           .setChannelConnectionId("channelConnectionId-1246974660")
   *           .build();
   *   ApiFuture<Operation> future =
   *       eventarcClient.createChannelConnectionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateChannelConnectionRequest, Operation>
      createChannelConnectionCallable() {
    return stub.createChannelConnectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single ChannelConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ChannelConnectionName name =
   *       ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]");
   *   ChannelConnection response = eventarcClient.deleteChannelConnectionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel connection to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelConnection, OperationMetadata> deleteChannelConnectionAsync(
      ChannelConnectionName name) {
    DeleteChannelConnectionRequest request =
        DeleteChannelConnectionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteChannelConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single ChannelConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String name =
   *       ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]").toString();
   *   ChannelConnection response = eventarcClient.deleteChannelConnectionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel connection to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelConnection, OperationMetadata> deleteChannelConnectionAsync(
      String name) {
    DeleteChannelConnectionRequest request =
        DeleteChannelConnectionRequest.newBuilder().setName(name).build();
    return deleteChannelConnectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single ChannelConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteChannelConnectionRequest request =
   *       DeleteChannelConnectionRequest.newBuilder()
   *           .setName(
   *               ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]")
   *                   .toString())
   *           .build();
   *   ChannelConnection response = eventarcClient.deleteChannelConnectionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelConnection, OperationMetadata> deleteChannelConnectionAsync(
      DeleteChannelConnectionRequest request) {
    return deleteChannelConnectionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single ChannelConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteChannelConnectionRequest request =
   *       DeleteChannelConnectionRequest.newBuilder()
   *           .setName(
   *               ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]")
   *                   .toString())
   *           .build();
   *   OperationFuture<ChannelConnection, OperationMetadata> future =
   *       eventarcClient.deleteChannelConnectionOperationCallable().futureCall(request);
   *   // Do something.
   *   ChannelConnection response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteChannelConnectionRequest, ChannelConnection, OperationMetadata>
      deleteChannelConnectionOperationCallable() {
    return stub.deleteChannelConnectionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a single ChannelConnection.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   DeleteChannelConnectionRequest request =
   *       DeleteChannelConnectionRequest.newBuilder()
   *           .setName(
   *               ChannelConnectionName.of("[PROJECT]", "[LOCATION]", "[CHANNEL_CONNECTION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       eventarcClient.deleteChannelConnectionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteChannelConnectionRequest, Operation>
      deleteChannelConnectionCallable() {
    return stub.deleteChannelConnectionCallable();
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

  public static class ListTriggersPagedResponse
      extends AbstractPagedListResponse<
          ListTriggersRequest,
          ListTriggersResponse,
          Trigger,
          ListTriggersPage,
          ListTriggersFixedSizeCollection> {

    public static ApiFuture<ListTriggersPagedResponse> createAsync(
        PageContext<ListTriggersRequest, ListTriggersResponse, Trigger> context,
        ApiFuture<ListTriggersResponse> futureResponse) {
      ApiFuture<ListTriggersPage> futurePage =
          ListTriggersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTriggersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTriggersPagedResponse(ListTriggersPage page) {
      super(page, ListTriggersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTriggersPage
      extends AbstractPage<ListTriggersRequest, ListTriggersResponse, Trigger, ListTriggersPage> {

    private ListTriggersPage(
        PageContext<ListTriggersRequest, ListTriggersResponse, Trigger> context,
        ListTriggersResponse response) {
      super(context, response);
    }

    private static ListTriggersPage createEmptyPage() {
      return new ListTriggersPage(null, null);
    }

    @Override
    protected ListTriggersPage createPage(
        PageContext<ListTriggersRequest, ListTriggersResponse, Trigger> context,
        ListTriggersResponse response) {
      return new ListTriggersPage(context, response);
    }

    @Override
    public ApiFuture<ListTriggersPage> createPageAsync(
        PageContext<ListTriggersRequest, ListTriggersResponse, Trigger> context,
        ApiFuture<ListTriggersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTriggersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTriggersRequest,
          ListTriggersResponse,
          Trigger,
          ListTriggersPage,
          ListTriggersFixedSizeCollection> {

    private ListTriggersFixedSizeCollection(List<ListTriggersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTriggersFixedSizeCollection createEmptyCollection() {
      return new ListTriggersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTriggersFixedSizeCollection createCollection(
        List<ListTriggersPage> pages, int collectionSize) {
      return new ListTriggersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListChannelsPagedResponse
      extends AbstractPagedListResponse<
          ListChannelsRequest,
          ListChannelsResponse,
          Channel,
          ListChannelsPage,
          ListChannelsFixedSizeCollection> {

    public static ApiFuture<ListChannelsPagedResponse> createAsync(
        PageContext<ListChannelsRequest, ListChannelsResponse, Channel> context,
        ApiFuture<ListChannelsResponse> futureResponse) {
      ApiFuture<ListChannelsPage> futurePage =
          ListChannelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListChannelsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListChannelsPagedResponse(ListChannelsPage page) {
      super(page, ListChannelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListChannelsPage
      extends AbstractPage<ListChannelsRequest, ListChannelsResponse, Channel, ListChannelsPage> {

    private ListChannelsPage(
        PageContext<ListChannelsRequest, ListChannelsResponse, Channel> context,
        ListChannelsResponse response) {
      super(context, response);
    }

    private static ListChannelsPage createEmptyPage() {
      return new ListChannelsPage(null, null);
    }

    @Override
    protected ListChannelsPage createPage(
        PageContext<ListChannelsRequest, ListChannelsResponse, Channel> context,
        ListChannelsResponse response) {
      return new ListChannelsPage(context, response);
    }

    @Override
    public ApiFuture<ListChannelsPage> createPageAsync(
        PageContext<ListChannelsRequest, ListChannelsResponse, Channel> context,
        ApiFuture<ListChannelsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListChannelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListChannelsRequest,
          ListChannelsResponse,
          Channel,
          ListChannelsPage,
          ListChannelsFixedSizeCollection> {

    private ListChannelsFixedSizeCollection(List<ListChannelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListChannelsFixedSizeCollection createEmptyCollection() {
      return new ListChannelsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListChannelsFixedSizeCollection createCollection(
        List<ListChannelsPage> pages, int collectionSize) {
      return new ListChannelsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListProvidersPagedResponse
      extends AbstractPagedListResponse<
          ListProvidersRequest,
          ListProvidersResponse,
          Provider,
          ListProvidersPage,
          ListProvidersFixedSizeCollection> {

    public static ApiFuture<ListProvidersPagedResponse> createAsync(
        PageContext<ListProvidersRequest, ListProvidersResponse, Provider> context,
        ApiFuture<ListProvidersResponse> futureResponse) {
      ApiFuture<ListProvidersPage> futurePage =
          ListProvidersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListProvidersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListProvidersPagedResponse(ListProvidersPage page) {
      super(page, ListProvidersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListProvidersPage
      extends AbstractPage<
          ListProvidersRequest, ListProvidersResponse, Provider, ListProvidersPage> {

    private ListProvidersPage(
        PageContext<ListProvidersRequest, ListProvidersResponse, Provider> context,
        ListProvidersResponse response) {
      super(context, response);
    }

    private static ListProvidersPage createEmptyPage() {
      return new ListProvidersPage(null, null);
    }

    @Override
    protected ListProvidersPage createPage(
        PageContext<ListProvidersRequest, ListProvidersResponse, Provider> context,
        ListProvidersResponse response) {
      return new ListProvidersPage(context, response);
    }

    @Override
    public ApiFuture<ListProvidersPage> createPageAsync(
        PageContext<ListProvidersRequest, ListProvidersResponse, Provider> context,
        ApiFuture<ListProvidersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListProvidersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListProvidersRequest,
          ListProvidersResponse,
          Provider,
          ListProvidersPage,
          ListProvidersFixedSizeCollection> {

    private ListProvidersFixedSizeCollection(List<ListProvidersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListProvidersFixedSizeCollection createEmptyCollection() {
      return new ListProvidersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListProvidersFixedSizeCollection createCollection(
        List<ListProvidersPage> pages, int collectionSize) {
      return new ListProvidersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListChannelConnectionsPagedResponse
      extends AbstractPagedListResponse<
          ListChannelConnectionsRequest,
          ListChannelConnectionsResponse,
          ChannelConnection,
          ListChannelConnectionsPage,
          ListChannelConnectionsFixedSizeCollection> {

    public static ApiFuture<ListChannelConnectionsPagedResponse> createAsync(
        PageContext<
                ListChannelConnectionsRequest, ListChannelConnectionsResponse, ChannelConnection>
            context,
        ApiFuture<ListChannelConnectionsResponse> futureResponse) {
      ApiFuture<ListChannelConnectionsPage> futurePage =
          ListChannelConnectionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListChannelConnectionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListChannelConnectionsPagedResponse(ListChannelConnectionsPage page) {
      super(page, ListChannelConnectionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListChannelConnectionsPage
      extends AbstractPage<
          ListChannelConnectionsRequest,
          ListChannelConnectionsResponse,
          ChannelConnection,
          ListChannelConnectionsPage> {

    private ListChannelConnectionsPage(
        PageContext<
                ListChannelConnectionsRequest, ListChannelConnectionsResponse, ChannelConnection>
            context,
        ListChannelConnectionsResponse response) {
      super(context, response);
    }

    private static ListChannelConnectionsPage createEmptyPage() {
      return new ListChannelConnectionsPage(null, null);
    }

    @Override
    protected ListChannelConnectionsPage createPage(
        PageContext<
                ListChannelConnectionsRequest, ListChannelConnectionsResponse, ChannelConnection>
            context,
        ListChannelConnectionsResponse response) {
      return new ListChannelConnectionsPage(context, response);
    }

    @Override
    public ApiFuture<ListChannelConnectionsPage> createPageAsync(
        PageContext<
                ListChannelConnectionsRequest, ListChannelConnectionsResponse, ChannelConnection>
            context,
        ApiFuture<ListChannelConnectionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListChannelConnectionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListChannelConnectionsRequest,
          ListChannelConnectionsResponse,
          ChannelConnection,
          ListChannelConnectionsPage,
          ListChannelConnectionsFixedSizeCollection> {

    private ListChannelConnectionsFixedSizeCollection(
        List<ListChannelConnectionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListChannelConnectionsFixedSizeCollection createEmptyCollection() {
      return new ListChannelConnectionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListChannelConnectionsFixedSizeCollection createCollection(
        List<ListChannelConnectionsPage> pages, int collectionSize) {
      return new ListChannelConnectionsFixedSizeCollection(pages, collectionSize);
    }
  }
}
