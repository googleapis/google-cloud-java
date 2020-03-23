/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.recommendationengine.v1beta1;

import com.google.api.HttpBody;
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
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.recommendationengine.v1beta1.stub.UserEventServiceStub;
import com.google.cloud.recommendationengine.v1beta1.stub.UserEventServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Service for ingesting end user actions on the customer website.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
 *   String formattedParent = UserEventServiceClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
 *   UserEvent userEvent = UserEvent.newBuilder().build();
 *   UserEvent response = userEventServiceClient.writeUserEvent(formattedParent, userEvent);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the userEventServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of UserEventServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * UserEventServiceSettings userEventServiceSettings =
 *     UserEventServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * UserEventServiceClient userEventServiceClient =
 *     UserEventServiceClient.create(userEventServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * UserEventServiceSettings userEventServiceSettings =
 *     UserEventServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * UserEventServiceClient userEventServiceClient =
 *     UserEventServiceClient.create(userEventServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class UserEventServiceClient implements BackgroundResource {
  private final UserEventServiceSettings settings;
  private final UserEventServiceStub stub;
  private final OperationsClient operationsClient;

  private static final PathTemplate EVENT_STORE_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/catalogs/{catalog}/eventStores/{event_store}");

  /**
   * Formats a string containing the fully-qualified path to represent a event_store resource.
   *
   * @deprecated Use the {@link EventStoreName} class instead.
   */
  @Deprecated
  public static final String formatEventStoreName(
      String project, String location, String catalog, String eventStore) {
    return EVENT_STORE_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "catalog", catalog,
        "event_store", eventStore);
  }

  /**
   * Parses the project from the given fully-qualified path which represents a event_store resource.
   *
   * @deprecated Use the {@link EventStoreName} class instead.
   */
  @Deprecated
  public static final String parseProjectFromEventStoreName(String eventStoreName) {
    return EVENT_STORE_PATH_TEMPLATE.parse(eventStoreName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a event_store
   * resource.
   *
   * @deprecated Use the {@link EventStoreName} class instead.
   */
  @Deprecated
  public static final String parseLocationFromEventStoreName(String eventStoreName) {
    return EVENT_STORE_PATH_TEMPLATE.parse(eventStoreName).get("location");
  }

  /**
   * Parses the catalog from the given fully-qualified path which represents a event_store resource.
   *
   * @deprecated Use the {@link EventStoreName} class instead.
   */
  @Deprecated
  public static final String parseCatalogFromEventStoreName(String eventStoreName) {
    return EVENT_STORE_PATH_TEMPLATE.parse(eventStoreName).get("catalog");
  }

  /**
   * Parses the event_store from the given fully-qualified path which represents a event_store
   * resource.
   *
   * @deprecated Use the {@link EventStoreName} class instead.
   */
  @Deprecated
  public static final String parseEventStoreFromEventStoreName(String eventStoreName) {
    return EVENT_STORE_PATH_TEMPLATE.parse(eventStoreName).get("event_store");
  }

  /** Constructs an instance of UserEventServiceClient with default settings. */
  public static final UserEventServiceClient create() throws IOException {
    return create(UserEventServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of UserEventServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final UserEventServiceClient create(UserEventServiceSettings settings)
      throws IOException {
    return new UserEventServiceClient(settings);
  }

  /**
   * Constructs an instance of UserEventServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer to use UserEventServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final UserEventServiceClient create(UserEventServiceStub stub) {
    return new UserEventServiceClient(stub);
  }

  /**
   * Constructs an instance of UserEventServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected UserEventServiceClient(UserEventServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((UserEventServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected UserEventServiceClient(UserEventServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final UserEventServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public UserEventServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Writes a single user event.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   String formattedParent = UserEventServiceClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   UserEvent userEvent = UserEvent.newBuilder().build();
   *   UserEvent response = userEventServiceClient.writeUserEvent(formattedParent, userEvent);
   * }
   * </code></pre>
   *
   * @param parent Required. The parent eventStore resource name, such as
   *     "projects/1234/locations/global/catalogs/default_catalog/eventStores/default_event_store".
   * @param userEvent Required. User event to write.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserEvent writeUserEvent(String parent, UserEvent userEvent) {
    EVENT_STORE_PATH_TEMPLATE.validate(parent, "writeUserEvent");
    WriteUserEventRequest request =
        WriteUserEventRequest.newBuilder().setParent(parent).setUserEvent(userEvent).build();
    return writeUserEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Writes a single user event.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   String formattedParent = UserEventServiceClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   UserEvent userEvent = UserEvent.newBuilder().build();
   *   WriteUserEventRequest request = WriteUserEventRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setUserEvent(userEvent)
   *     .build();
   *   UserEvent response = userEventServiceClient.writeUserEvent(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UserEvent writeUserEvent(WriteUserEventRequest request) {
    return writeUserEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Writes a single user event.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   String formattedParent = UserEventServiceClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   UserEvent userEvent = UserEvent.newBuilder().build();
   *   WriteUserEventRequest request = WriteUserEventRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setUserEvent(userEvent)
   *     .build();
   *   ApiFuture&lt;UserEvent&gt; future = userEventServiceClient.writeUserEventCallable().futureCall(request);
   *   // Do something
   *   UserEvent response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<WriteUserEventRequest, UserEvent> writeUserEventCallable() {
    return stub.writeUserEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Writes a single user event from the browser. This uses a GET request to due to browser
   * restriction of POST-ing to a 3rd party domain.
   *
   * <p>This method is used only by the Recommendations AI JavaScript pixel. Users should not call
   * this method directly.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   String formattedParent = UserEventServiceClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   String userEvent = "";
   *   String uri = "";
   *   long ets = 0L;
   *   HttpBody response = userEventServiceClient.collectUserEvent(formattedParent, userEvent, uri, ets);
   * }
   * </code></pre>
   *
   * @param parent Required. The parent eventStore name, such as
   *     "projects/1234/locations/global/catalogs/default_catalog/eventStores/default_event_store".
   * @param userEvent Required. URL encoded UserEvent proto.
   * @param uri Optional. The url including cgi-parameters but excluding the hash fragment. The URL
   *     must be truncated to 1.5K bytes to conservatively be under the 2K bytes. This is often more
   *     useful than the referer url, because many browsers only send the domain for 3rd party
   *     requests.
   * @param ets Optional. The event timestamp in milliseconds. This prevents browser caching of
   *     otherwise identical get requests. The name is abbreviated to reduce the payload bytes.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpBody collectUserEvent(String parent, String userEvent, String uri, long ets) {
    EVENT_STORE_PATH_TEMPLATE.validate(parent, "collectUserEvent");
    CollectUserEventRequest request =
        CollectUserEventRequest.newBuilder()
            .setParent(parent)
            .setUserEvent(userEvent)
            .setUri(uri)
            .setEts(ets)
            .build();
    return collectUserEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Writes a single user event from the browser. This uses a GET request to due to browser
   * restriction of POST-ing to a 3rd party domain.
   *
   * <p>This method is used only by the Recommendations AI JavaScript pixel. Users should not call
   * this method directly.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   String formattedParent = UserEventServiceClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   String userEvent = "";
   *   CollectUserEventRequest request = CollectUserEventRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setUserEvent(userEvent)
   *     .build();
   *   HttpBody response = userEventServiceClient.collectUserEvent(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpBody collectUserEvent(CollectUserEventRequest request) {
    return collectUserEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Writes a single user event from the browser. This uses a GET request to due to browser
   * restriction of POST-ing to a 3rd party domain.
   *
   * <p>This method is used only by the Recommendations AI JavaScript pixel. Users should not call
   * this method directly.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   String formattedParent = UserEventServiceClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   String userEvent = "";
   *   CollectUserEventRequest request = CollectUserEventRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setUserEvent(userEvent)
   *     .build();
   *   ApiFuture&lt;HttpBody&gt; future = userEventServiceClient.collectUserEventCallable().futureCall(request);
   *   // Do something
   *   HttpBody response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CollectUserEventRequest, HttpBody> collectUserEventCallable() {
    return stub.collectUserEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a list of user events within a time range, with potential filtering.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   String formattedParent = UserEventServiceClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   String filter = "";
   *   for (UserEvent element : userEventServiceClient.listUserEvents(formattedParent, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The parent eventStore resource name, such as
   *     "projects/&#42;/locations/&#42;/catalogs/default_catalog/eventStores/default_event_store".
   * @param filter Optional. Filtering expression to specify restrictions over returned events. This
   *     is a sequence of terms, where each term applies some kind of a restriction to the returned
   *     user events. Use this expression to restrict results to a specific time range, or filter
   *     events by eventType. eg: eventTime &gt; "2012-04-23T18:25:43.511Z"
   *     eventsMissingCatalogItems eventTime&lt;"2012-04-23T18:25:43.511Z" eventType=search
   *     <p>We expect only 3 types of fields:
   *     <p>&#42; eventTime: this can be specified a maximum of 2 times, once with a less than
   *     operator and once with a greater than operator. The eventTime restrict should result in one
   *     contiguous valid eventTime range.
   *     <p>&#42; eventType: only 1 eventType restriction can be specified.
   *     <p>&#42; eventsMissingCatalogItems: specififying this will restrict results to events for
   *     which catalog items were not found in the catalog. The default behavior is to return only
   *     those events for which catalog items were found.
   *     <p>Some examples of valid filters expressions:
   *     <p>&#42; Example 1: eventTime &gt; "2012-04-23T18:25:43.511Z" eventTime &lt;
   *     "2012-04-23T18:30:43.511Z" &#42; Example 2: eventTime &gt; "2012-04-23T18:25:43.511Z"
   *     eventType = detail-page-view &#42; Example 3: eventsMissingCatalogItems eventType = search
   *     eventTime &lt; "2018-04-23T18:30:43.511Z" &#42; Example 4: eventTime &gt;
   *     "2012-04-23T18:25:43.511Z" &#42; Example 5: eventType = search &#42; Example 6:
   *     eventsMissingCatalogItems
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserEventsPagedResponse listUserEvents(String parent, String filter) {
    EVENT_STORE_PATH_TEMPLATE.validate(parent, "listUserEvents");
    ListUserEventsRequest request =
        ListUserEventsRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listUserEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a list of user events within a time range, with potential filtering.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   String formattedParent = UserEventServiceClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   ListUserEventsRequest request = ListUserEventsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   for (UserEvent element : userEventServiceClient.listUserEvents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListUserEventsPagedResponse listUserEvents(ListUserEventsRequest request) {
    return listUserEventsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a list of user events within a time range, with potential filtering.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   String formattedParent = UserEventServiceClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   ListUserEventsRequest request = ListUserEventsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ApiFuture&lt;ListUserEventsPagedResponse&gt; future = userEventServiceClient.listUserEventsPagedCallable().futureCall(request);
   *   // Do something
   *   for (UserEvent element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListUserEventsRequest, ListUserEventsPagedResponse>
      listUserEventsPagedCallable() {
    return stub.listUserEventsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a list of user events within a time range, with potential filtering.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   String formattedParent = UserEventServiceClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   ListUserEventsRequest request = ListUserEventsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   while (true) {
   *     ListUserEventsResponse response = userEventServiceClient.listUserEventsCallable().call(request);
   *     for (UserEvent element : response.getUserEventsList()) {
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
  public final UnaryCallable<ListUserEventsRequest, ListUserEventsResponse>
      listUserEventsCallable() {
    return stub.listUserEventsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes permanently all user events specified by the filter provided. Depending on the number
   * of events specified by the filter, this operation could take hours or days to complete. To test
   * a filter, use the list command first.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   String formattedParent = UserEventServiceClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   String filter = "";
   *   boolean force = false;
   *   PurgeUserEventsResponse response = userEventServiceClient.purgeUserEventsAsync(formattedParent, filter, force).get();
   * }
   * </code></pre>
   *
   * @param parent Required. The resource name of the event_store under which the events are
   *     created. The format is
   *     "projects/${projectId}/locations/global/catalogs/${catalogId}/eventStores/${eventStoreId}"
   * @param filter Required. The filter string to specify the events to be deleted. Empty string
   *     filter is not allowed. This filter can also be used with ListUserEvents API to list events
   *     that will be deleted. The eligible fields for filtering are: &#42; eventType -
   *     UserEvent.eventType field of type string. &#42; eventTime - in ISO 8601 "zulu" format.
   *     &#42; visitorId - field of type string. Specifying this will delete all events associated
   *     with a visitor. &#42; userId - field of type string. Specifying this will delete all events
   *     associated with a user. Example 1: Deleting all events in a time range. `eventTime &gt;
   *     "2012-04-23T18:25:43.511Z" eventTime &lt; "2012-04-23T18:30:43.511Z"` Example 2: Deleting
   *     specific eventType in time range. `eventTime &gt; "2012-04-23T18:25:43.511Z" eventType =
   *     "detail-page-view"` Example 3: Deleting all events for a specific visitor `visitorId =
   *     visitor1024` The filtering fields are assumed to have an implicit AND.
   * @param force Optional. The default value is false. Override this flag to true to actually
   *     perform the purge. If the field is not set to true, a sampling of events to be deleted will
   *     be returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<PurgeUserEventsResponse, PurgeUserEventsMetadata>
      purgeUserEventsAsync(String parent, String filter, boolean force) {
    EVENT_STORE_PATH_TEMPLATE.validate(parent, "purgeUserEvents");
    PurgeUserEventsRequest request =
        PurgeUserEventsRequest.newBuilder()
            .setParent(parent)
            .setFilter(filter)
            .setForce(force)
            .build();
    return purgeUserEventsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes permanently all user events specified by the filter provided. Depending on the number
   * of events specified by the filter, this operation could take hours or days to complete. To test
   * a filter, use the list command first.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   String formattedParent = UserEventServiceClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   String filter = "";
   *   PurgeUserEventsRequest request = PurgeUserEventsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setFilter(filter)
   *     .build();
   *   PurgeUserEventsResponse response = userEventServiceClient.purgeUserEventsAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<PurgeUserEventsResponse, PurgeUserEventsMetadata>
      purgeUserEventsAsync(PurgeUserEventsRequest request) {
    return purgeUserEventsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes permanently all user events specified by the filter provided. Depending on the number
   * of events specified by the filter, this operation could take hours or days to complete. To test
   * a filter, use the list command first.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   String formattedParent = UserEventServiceClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   String filter = "";
   *   PurgeUserEventsRequest request = PurgeUserEventsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setFilter(filter)
   *     .build();
   *   OperationFuture&lt;PurgeUserEventsResponse, PurgeUserEventsMetadata&gt; future = userEventServiceClient.purgeUserEventsOperationCallable().futureCall(request);
   *   // Do something
   *   PurgeUserEventsResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<
          PurgeUserEventsRequest, PurgeUserEventsResponse, PurgeUserEventsMetadata>
      purgeUserEventsOperationCallable() {
    return stub.purgeUserEventsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes permanently all user events specified by the filter provided. Depending on the number
   * of events specified by the filter, this operation could take hours or days to complete. To test
   * a filter, use the list command first.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   String formattedParent = UserEventServiceClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   String filter = "";
   *   PurgeUserEventsRequest request = PurgeUserEventsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setFilter(filter)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = userEventServiceClient.purgeUserEventsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PurgeUserEventsRequest, Operation> purgeUserEventsCallable() {
    return stub.purgeUserEventsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Bulk import of User events. Request processing might be synchronous. Events that already exist
   * are skipped. Use this method for backfilling historical user events.
   *
   * <p>Operation.response is of type ImportResponse. Note that it is possible for a subset of the
   * items to be successfully inserted. Operation.metadata is of type ImportMetadata.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   String formattedParent = UserEventServiceClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   String requestId = "";
   *   InputConfig inputConfig = InputConfig.newBuilder().build();
   *   ImportErrorsConfig errorsConfig = ImportErrorsConfig.newBuilder().build();
   *   ImportUserEventsResponse response = userEventServiceClient.importUserEventsAsync(formattedParent, requestId, inputConfig, errorsConfig).get();
   * }
   * </code></pre>
   *
   * @param parent Required.
   *     "projects/1234/locations/global/catalogs/default_catalog/eventStores/default_event_store"
   * @param requestId Optional. Unique identifier provided by client, within the ancestor dataset
   *     scope. Ensures idempotency for expensive long running operations. Server-generated if
   *     unspecified. Up to 128 characters long. This is returned as
   *     google.longrunning.Operation.name in the response. Note that this field must not be set if
   *     the desired input config is catalog_inline_source.
   * @param inputConfig Required. The desired input location of the data.
   * @param errorsConfig Optional. The desired location of errors incurred during the Import.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<ImportUserEventsResponse, ImportMetadata> importUserEventsAsync(
      String parent, String requestId, InputConfig inputConfig, ImportErrorsConfig errorsConfig) {
    EVENT_STORE_PATH_TEMPLATE.validate(parent, "importUserEvents");
    ImportUserEventsRequest request =
        ImportUserEventsRequest.newBuilder()
            .setParent(parent)
            .setRequestId(requestId)
            .setInputConfig(inputConfig)
            .setErrorsConfig(errorsConfig)
            .build();
    return importUserEventsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Bulk import of User events. Request processing might be synchronous. Events that already exist
   * are skipped. Use this method for backfilling historical user events.
   *
   * <p>Operation.response is of type ImportResponse. Note that it is possible for a subset of the
   * items to be successfully inserted. Operation.metadata is of type ImportMetadata.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   String formattedParent = UserEventServiceClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   InputConfig inputConfig = InputConfig.newBuilder().build();
   *   ImportUserEventsRequest request = ImportUserEventsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setInputConfig(inputConfig)
   *     .build();
   *   ImportUserEventsResponse response = userEventServiceClient.importUserEventsAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<ImportUserEventsResponse, ImportMetadata> importUserEventsAsync(
      ImportUserEventsRequest request) {
    return importUserEventsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Bulk import of User events. Request processing might be synchronous. Events that already exist
   * are skipped. Use this method for backfilling historical user events.
   *
   * <p>Operation.response is of type ImportResponse. Note that it is possible for a subset of the
   * items to be successfully inserted. Operation.metadata is of type ImportMetadata.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   String formattedParent = UserEventServiceClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   InputConfig inputConfig = InputConfig.newBuilder().build();
   *   ImportUserEventsRequest request = ImportUserEventsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setInputConfig(inputConfig)
   *     .build();
   *   OperationFuture&lt;ImportUserEventsResponse, ImportMetadata&gt; future = userEventServiceClient.importUserEventsOperationCallable().futureCall(request);
   *   // Do something
   *   ImportUserEventsResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<ImportUserEventsRequest, ImportUserEventsResponse, ImportMetadata>
      importUserEventsOperationCallable() {
    return stub.importUserEventsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Bulk import of User events. Request processing might be synchronous. Events that already exist
   * are skipped. Use this method for backfilling historical user events.
   *
   * <p>Operation.response is of type ImportResponse. Note that it is possible for a subset of the
   * items to be successfully inserted. Operation.metadata is of type ImportMetadata.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (UserEventServiceClient userEventServiceClient = UserEventServiceClient.create()) {
   *   String formattedParent = UserEventServiceClient.formatEventStoreName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[EVENT_STORE]");
   *   InputConfig inputConfig = InputConfig.newBuilder().build();
   *   ImportUserEventsRequest request = ImportUserEventsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setInputConfig(inputConfig)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = userEventServiceClient.importUserEventsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ImportUserEventsRequest, Operation> importUserEventsCallable() {
    return stub.importUserEventsCallable();
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

  public static class ListUserEventsPagedResponse
      extends AbstractPagedListResponse<
          ListUserEventsRequest,
          ListUserEventsResponse,
          UserEvent,
          ListUserEventsPage,
          ListUserEventsFixedSizeCollection> {

    public static ApiFuture<ListUserEventsPagedResponse> createAsync(
        PageContext<ListUserEventsRequest, ListUserEventsResponse, UserEvent> context,
        ApiFuture<ListUserEventsResponse> futureResponse) {
      ApiFuture<ListUserEventsPage> futurePage =
          ListUserEventsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListUserEventsPage, ListUserEventsPagedResponse>() {
            @Override
            public ListUserEventsPagedResponse apply(ListUserEventsPage input) {
              return new ListUserEventsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListUserEventsPagedResponse(ListUserEventsPage page) {
      super(page, ListUserEventsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListUserEventsPage
      extends AbstractPage<
          ListUserEventsRequest, ListUserEventsResponse, UserEvent, ListUserEventsPage> {

    private ListUserEventsPage(
        PageContext<ListUserEventsRequest, ListUserEventsResponse, UserEvent> context,
        ListUserEventsResponse response) {
      super(context, response);
    }

    private static ListUserEventsPage createEmptyPage() {
      return new ListUserEventsPage(null, null);
    }

    @Override
    protected ListUserEventsPage createPage(
        PageContext<ListUserEventsRequest, ListUserEventsResponse, UserEvent> context,
        ListUserEventsResponse response) {
      return new ListUserEventsPage(context, response);
    }

    @Override
    public ApiFuture<ListUserEventsPage> createPageAsync(
        PageContext<ListUserEventsRequest, ListUserEventsResponse, UserEvent> context,
        ApiFuture<ListUserEventsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListUserEventsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListUserEventsRequest,
          ListUserEventsResponse,
          UserEvent,
          ListUserEventsPage,
          ListUserEventsFixedSizeCollection> {

    private ListUserEventsFixedSizeCollection(List<ListUserEventsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListUserEventsFixedSizeCollection createEmptyCollection() {
      return new ListUserEventsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListUserEventsFixedSizeCollection createCollection(
        List<ListUserEventsPage> pages, int collectionSize) {
      return new ListUserEventsFixedSizeCollection(pages, collectionSize);
    }
  }
}
