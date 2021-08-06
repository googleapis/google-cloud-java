/*
 * Copyright 2021 Google LLC
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
import com.google.longrunning.OperationsClient;
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
 * EventarcSettings eventarcSettings =
 *     EventarcSettings.newBuilder().setEndpoint(myEndpoint).build();
 * EventarcClient eventarcClient = EventarcClient.create(eventarcSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class EventarcClient implements BackgroundResource {
  private final EventarcSettings settings;
  private final EventarcStub stub;
  private final OperationsClient operationsClient;

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
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
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
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected EventarcClient(EventarcStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final EventarcSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public EventarcStub getStub() {
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
   * Get a single trigger.
   *
   * <p>Sample code:
   *
   * <pre>{@code
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
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString();
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
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListTriggersRequest request =
   *       ListTriggersRequest.newBuilder()
   *           .setParent(TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString())
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
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListTriggersRequest request =
   *       ListTriggersRequest.newBuilder()
   *           .setParent(TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString())
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
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   ListTriggersRequest request =
   *       ListTriggersRequest.newBuilder()
   *           .setParent(TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListTriggersResponse response = eventarcClient.listTriggersCallable().call(request);
   *     for (Trigger element : response.getResponsesList()) {
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
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   String parent = TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString();
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
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateTriggerRequest request =
   *       CreateTriggerRequest.newBuilder()
   *           .setParent(TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString())
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
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateTriggerRequest request =
   *       CreateTriggerRequest.newBuilder()
   *           .setParent(TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString())
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
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   CreateTriggerRequest request =
   *       CreateTriggerRequest.newBuilder()
   *           .setParent(TriggerName.of("[PROJECT]", "[LOCATION]", "[TRIGGER]").toString())
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
   * try (EventarcClient eventarcClient = EventarcClient.create()) {
   *   Trigger trigger = Trigger.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   boolean allowMissing = true;
   *   Trigger response = eventarcClient.updateTriggerAsync(trigger, updateMask, allowMissing).get();
   * }
   * }</pre>
   *
   * @param trigger The trigger to be updated.
   * @param updateMask The fields to be updated; only fields explicitly provided will be updated. If
   *     no field mask is provided, all provided fields in the request will be updated. To update
   *     all fields, provide a field mask of "&#42;".
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
}
