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

package com.google.cloud.servicehealth.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.cloud.servicehealth.v1.stub.ServiceHealthStub;
import com.google.cloud.servicehealth.v1.stub.ServiceHealthStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Request service health events relevant to your Google Cloud project.
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
 * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
 *   EventName name = EventName.of("[PROJECT]", "[LOCATION]", "[EVENT]");
 *   Event response = serviceHealthClient.getEvent(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ServiceHealthClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    <tr>
 *      <td>ListEvents</td>
 *      <td><p> Lists events under a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listEvents(ListEventsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listEvents(LocationName parent)
 *           <li>listEvents(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listEventsPagedCallable()
 *           <li>listEventsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetEvent</td>
 *      <td><p> Retrieves a resource containing information about an event.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getEvent(GetEventRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getEvent(EventName name)
 *           <li>getEvent(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getEventCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListOrganizationEvents</td>
 *      <td><p> Lists organization events under a given organization and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listOrganizationEvents(ListOrganizationEventsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listOrganizationEvents(OrganizationLocationName parent)
 *           <li>listOrganizationEvents(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listOrganizationEventsPagedCallable()
 *           <li>listOrganizationEventsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetOrganizationEvent</td>
 *      <td><p> Retrieves a resource containing information about an event affecting an organization .</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getOrganizationEvent(GetOrganizationEventRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getOrganizationEvent(OrganizationEventName name)
 *           <li>getOrganizationEvent(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getOrganizationEventCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListOrganizationImpacts</td>
 *      <td><p> Lists assets impacted by organization events under a given organization and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listOrganizationImpacts(ListOrganizationImpactsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listOrganizationImpacts(OrganizationLocationName parent)
 *           <li>listOrganizationImpacts(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listOrganizationImpactsPagedCallable()
 *           <li>listOrganizationImpactsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetOrganizationImpact</td>
 *      <td><p> Retrieves a resource containing information about impact to an asset under an organization affected by a service health event.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getOrganizationImpact(GetOrganizationImpactRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getOrganizationImpact(OrganizationImpactName name)
 *           <li>getOrganizationImpact(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getOrganizationImpactCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listLocationsPagedCallable()
 *           <li>listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetLocation</td>
 *      <td><p> Gets information about a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getLocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of ServiceHealthSettings to
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
 * ServiceHealthSettings serviceHealthSettings =
 *     ServiceHealthSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ServiceHealthClient serviceHealthClient = ServiceHealthClient.create(serviceHealthSettings);
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
 * ServiceHealthSettings serviceHealthSettings =
 *     ServiceHealthSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ServiceHealthClient serviceHealthClient = ServiceHealthClient.create(serviceHealthSettings);
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
 * ServiceHealthSettings serviceHealthSettings =
 *     ServiceHealthSettings.newHttpJsonBuilder().build();
 * ServiceHealthClient serviceHealthClient = ServiceHealthClient.create(serviceHealthSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ServiceHealthClient implements BackgroundResource {
  private final ServiceHealthSettings settings;
  private final ServiceHealthStub stub;

  /** Constructs an instance of ServiceHealthClient with default settings. */
  public static final ServiceHealthClient create() throws IOException {
    return create(ServiceHealthSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ServiceHealthClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ServiceHealthClient create(ServiceHealthSettings settings)
      throws IOException {
    return new ServiceHealthClient(settings);
  }

  /**
   * Constructs an instance of ServiceHealthClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ServiceHealthSettings).
   */
  public static final ServiceHealthClient create(ServiceHealthStub stub) {
    return new ServiceHealthClient(stub);
  }

  /**
   * Constructs an instance of ServiceHealthClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ServiceHealthClient(ServiceHealthSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ServiceHealthStubSettings) settings.getStubSettings()).createStub();
  }

  protected ServiceHealthClient(ServiceHealthStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ServiceHealthSettings getSettings() {
    return settings;
  }

  public ServiceHealthStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists events under a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Event element : serviceHealthClient.listEvents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value using the form
   *     `projects/{project_id}/locations/{location}/events`.
   *     <p>`project_id` - ID of the project for which to list service health events. `location` -
   *     The location to get the service health events from. To retrieve service health events of
   *     category = INCIDENT, use `location` = `global`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventsPagedResponse listEvents(LocationName parent) {
    ListEventsRequest request =
        ListEventsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists events under a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Event element : serviceHealthClient.listEvents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value using the form
   *     `projects/{project_id}/locations/{location}/events`.
   *     <p>`project_id` - ID of the project for which to list service health events. `location` -
   *     The location to get the service health events from. To retrieve service health events of
   *     category = INCIDENT, use `location` = `global`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventsPagedResponse listEvents(String parent) {
    ListEventsRequest request = ListEventsRequest.newBuilder().setParent(parent).build();
    return listEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists events under a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   ListEventsRequest request =
   *       ListEventsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setView(EventView.forNumber(0))
   *           .build();
   *   for (Event element : serviceHealthClient.listEvents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventsPagedResponse listEvents(ListEventsRequest request) {
    return listEventsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists events under a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   ListEventsRequest request =
   *       ListEventsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setView(EventView.forNumber(0))
   *           .build();
   *   ApiFuture<Event> future = serviceHealthClient.listEventsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Event element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEventsRequest, ListEventsPagedResponse> listEventsPagedCallable() {
    return stub.listEventsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists events under a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   ListEventsRequest request =
   *       ListEventsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setView(EventView.forNumber(0))
   *           .build();
   *   while (true) {
   *     ListEventsResponse response = serviceHealthClient.listEventsCallable().call(request);
   *     for (Event element : response.getEventsList()) {
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
  public final UnaryCallable<ListEventsRequest, ListEventsResponse> listEventsCallable() {
    return stub.listEventsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about an event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   EventName name = EventName.of("[PROJECT]", "[LOCATION]", "[EVENT]");
   *   Event response = serviceHealthClient.getEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. Unique name of the event in this scope including project and location
   *     using the form `projects/{project_id}/locations/{location}/events/{event_id}`.
   *     <p>`project_id` - Project ID of the project that contains the event. &lt;br&gt; `location`
   *     - The location to get the service health events from. &lt;br&gt; `event_id` - Event ID to
   *     retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Event getEvent(EventName name) {
    GetEventRequest request =
        GetEventRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about an event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   String name = EventName.of("[PROJECT]", "[LOCATION]", "[EVENT]").toString();
   *   Event response = serviceHealthClient.getEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. Unique name of the event in this scope including project and location
   *     using the form `projects/{project_id}/locations/{location}/events/{event_id}`.
   *     <p>`project_id` - Project ID of the project that contains the event. &lt;br&gt; `location`
   *     - The location to get the service health events from. &lt;br&gt; `event_id` - Event ID to
   *     retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Event getEvent(String name) {
    GetEventRequest request = GetEventRequest.newBuilder().setName(name).build();
    return getEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about an event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   GetEventRequest request =
   *       GetEventRequest.newBuilder()
   *           .setName(EventName.of("[PROJECT]", "[LOCATION]", "[EVENT]").toString())
   *           .build();
   *   Event response = serviceHealthClient.getEvent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Event getEvent(GetEventRequest request) {
    return getEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about an event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   GetEventRequest request =
   *       GetEventRequest.newBuilder()
   *           .setName(EventName.of("[PROJECT]", "[LOCATION]", "[EVENT]").toString())
   *           .build();
   *   ApiFuture<Event> future = serviceHealthClient.getEventCallable().futureCall(request);
   *   // Do something.
   *   Event response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEventRequest, Event> getEventCallable() {
    return stub.getEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists organization events under a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (OrganizationEvent element :
   *       serviceHealthClient.listOrganizationEvents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value using the form
   *     `organizations/{organization_id}/locations/{location}/organizationEvents`.
   *     <p>`organization_id` - ID (number) of the project that contains the event. To get your
   *     `organization_id`, see [Getting your organization resource
   *     ID](https://cloud.google.com/resource-manager/docs/creating-managing-organization#retrieving_your_organization_id).&lt;br&gt;
   *     `location` - The location to get the service health events from. To retrieve service health
   *     events of category = INCIDENT, use `location` = `global`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrganizationEventsPagedResponse listOrganizationEvents(
      OrganizationLocationName parent) {
    ListOrganizationEventsRequest request =
        ListOrganizationEventsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listOrganizationEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists organization events under a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (OrganizationEvent element :
   *       serviceHealthClient.listOrganizationEvents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value using the form
   *     `organizations/{organization_id}/locations/{location}/organizationEvents`.
   *     <p>`organization_id` - ID (number) of the project that contains the event. To get your
   *     `organization_id`, see [Getting your organization resource
   *     ID](https://cloud.google.com/resource-manager/docs/creating-managing-organization#retrieving_your_organization_id).&lt;br&gt;
   *     `location` - The location to get the service health events from. To retrieve service health
   *     events of category = INCIDENT, use `location` = `global`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrganizationEventsPagedResponse listOrganizationEvents(String parent) {
    ListOrganizationEventsRequest request =
        ListOrganizationEventsRequest.newBuilder().setParent(parent).build();
    return listOrganizationEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists organization events under a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   ListOrganizationEventsRequest request =
   *       ListOrganizationEventsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setView(OrganizationEventView.forNumber(0))
   *           .build();
   *   for (OrganizationEvent element :
   *       serviceHealthClient.listOrganizationEvents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrganizationEventsPagedResponse listOrganizationEvents(
      ListOrganizationEventsRequest request) {
    return listOrganizationEventsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists organization events under a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   ListOrganizationEventsRequest request =
   *       ListOrganizationEventsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setView(OrganizationEventView.forNumber(0))
   *           .build();
   *   ApiFuture<OrganizationEvent> future =
   *       serviceHealthClient.listOrganizationEventsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (OrganizationEvent element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListOrganizationEventsRequest, ListOrganizationEventsPagedResponse>
      listOrganizationEventsPagedCallable() {
    return stub.listOrganizationEventsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists organization events under a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   ListOrganizationEventsRequest request =
   *       ListOrganizationEventsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setView(OrganizationEventView.forNumber(0))
   *           .build();
   *   while (true) {
   *     ListOrganizationEventsResponse response =
   *         serviceHealthClient.listOrganizationEventsCallable().call(request);
   *     for (OrganizationEvent element : response.getOrganizationEventsList()) {
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
  public final UnaryCallable<ListOrganizationEventsRequest, ListOrganizationEventsResponse>
      listOrganizationEventsCallable() {
    return stub.listOrganizationEventsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about an event affecting an organization .
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   OrganizationEventName name =
   *       OrganizationEventName.of("[ORGANIZATION]", "[LOCATION]", "[EVENT]");
   *   OrganizationEvent response = serviceHealthClient.getOrganizationEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. Unique name of the event in this scope including organization and event
   *     ID using the form
   *     `organizations/{organization_id}/locations/locations/global/organizationEvents/{event_id}`.
   *     <p>`organization_id` - ID (number) of the project that contains the event. To get your
   *     `organization_id`, see [Getting your organization resource
   *     ID](https://cloud.google.com/resource-manager/docs/creating-managing-organization#retrieving_your_organization_id).&lt;br&gt;
   *     `event_id` - Organization event ID to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OrganizationEvent getOrganizationEvent(OrganizationEventName name) {
    GetOrganizationEventRequest request =
        GetOrganizationEventRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getOrganizationEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about an event affecting an organization .
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   String name = OrganizationEventName.of("[ORGANIZATION]", "[LOCATION]", "[EVENT]").toString();
   *   OrganizationEvent response = serviceHealthClient.getOrganizationEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. Unique name of the event in this scope including organization and event
   *     ID using the form
   *     `organizations/{organization_id}/locations/locations/global/organizationEvents/{event_id}`.
   *     <p>`organization_id` - ID (number) of the project that contains the event. To get your
   *     `organization_id`, see [Getting your organization resource
   *     ID](https://cloud.google.com/resource-manager/docs/creating-managing-organization#retrieving_your_organization_id).&lt;br&gt;
   *     `event_id` - Organization event ID to retrieve.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OrganizationEvent getOrganizationEvent(String name) {
    GetOrganizationEventRequest request =
        GetOrganizationEventRequest.newBuilder().setName(name).build();
    return getOrganizationEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about an event affecting an organization .
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   GetOrganizationEventRequest request =
   *       GetOrganizationEventRequest.newBuilder()
   *           .setName(
   *               OrganizationEventName.of("[ORGANIZATION]", "[LOCATION]", "[EVENT]").toString())
   *           .build();
   *   OrganizationEvent response = serviceHealthClient.getOrganizationEvent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OrganizationEvent getOrganizationEvent(GetOrganizationEventRequest request) {
    return getOrganizationEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about an event affecting an organization .
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   GetOrganizationEventRequest request =
   *       GetOrganizationEventRequest.newBuilder()
   *           .setName(
   *               OrganizationEventName.of("[ORGANIZATION]", "[LOCATION]", "[EVENT]").toString())
   *           .build();
   *   ApiFuture<OrganizationEvent> future =
   *       serviceHealthClient.getOrganizationEventCallable().futureCall(request);
   *   // Do something.
   *   OrganizationEvent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOrganizationEventRequest, OrganizationEvent>
      getOrganizationEventCallable() {
    return stub.getOrganizationEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists assets impacted by organization events under a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   OrganizationLocationName parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]");
   *   for (OrganizationImpact element :
   *       serviceHealthClient.listOrganizationImpacts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value using the form
   *     `organizations/{organization_id}/locations/{location}/organizationImpacts`.
   *     <p>`organization_id` - ID (number) of the project that contains the event. To get your
   *     `organization_id`, see [Getting your organization resource
   *     ID](https://cloud.google.com/resource-manager/docs/creating-managing-organization#retrieving_your_organization_id).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrganizationImpactsPagedResponse listOrganizationImpacts(
      OrganizationLocationName parent) {
    ListOrganizationImpactsRequest request =
        ListOrganizationImpactsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listOrganizationImpacts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists assets impacted by organization events under a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   String parent = OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString();
   *   for (OrganizationImpact element :
   *       serviceHealthClient.listOrganizationImpacts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Parent value using the form
   *     `organizations/{organization_id}/locations/{location}/organizationImpacts`.
   *     <p>`organization_id` - ID (number) of the project that contains the event. To get your
   *     `organization_id`, see [Getting your organization resource
   *     ID](https://cloud.google.com/resource-manager/docs/creating-managing-organization#retrieving_your_organization_id).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrganizationImpactsPagedResponse listOrganizationImpacts(String parent) {
    ListOrganizationImpactsRequest request =
        ListOrganizationImpactsRequest.newBuilder().setParent(parent).build();
    return listOrganizationImpacts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists assets impacted by organization events under a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   ListOrganizationImpactsRequest request =
   *       ListOrganizationImpactsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (OrganizationImpact element :
   *       serviceHealthClient.listOrganizationImpacts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListOrganizationImpactsPagedResponse listOrganizationImpacts(
      ListOrganizationImpactsRequest request) {
    return listOrganizationImpactsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists assets impacted by organization events under a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   ListOrganizationImpactsRequest request =
   *       ListOrganizationImpactsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<OrganizationImpact> future =
   *       serviceHealthClient.listOrganizationImpactsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (OrganizationImpact element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListOrganizationImpactsRequest, ListOrganizationImpactsPagedResponse>
      listOrganizationImpactsPagedCallable() {
    return stub.listOrganizationImpactsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists assets impacted by organization events under a given organization and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   ListOrganizationImpactsRequest request =
   *       ListOrganizationImpactsRequest.newBuilder()
   *           .setParent(OrganizationLocationName.of("[ORGANIZATION]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListOrganizationImpactsResponse response =
   *         serviceHealthClient.listOrganizationImpactsCallable().call(request);
   *     for (OrganizationImpact element : response.getOrganizationImpactsList()) {
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
  public final UnaryCallable<ListOrganizationImpactsRequest, ListOrganizationImpactsResponse>
      listOrganizationImpactsCallable() {
    return stub.listOrganizationImpactsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about impact to an asset under an organization
   * affected by a service health event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   OrganizationImpactName name =
   *       OrganizationImpactName.of("[ORGANIZATION]", "[LOCATION]", "[ORGANIZATION_IMPACT]");
   *   OrganizationImpact response = serviceHealthClient.getOrganizationImpact(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource using the form
   *     `organizations/{organization_id}/locations/global/organizationImpacts/{organization_impact_id}`.
   *     <p>`organization_id` - ID (number) of the organization that contains the event. To get your
   *     `organization_id`, see [Getting your organization resource
   *     ID](https://cloud.google.com/resource-manager/docs/creating-managing-organization#retrieving_your_organization_id).&lt;br&gt;
   *     `organization_impact_id` - ID of the [OrganizationImpact
   *     resource](/service-health/docs/reference/rest/v1beta/organizations.locations.organizationImpacts#OrganizationImpact).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OrganizationImpact getOrganizationImpact(OrganizationImpactName name) {
    GetOrganizationImpactRequest request =
        GetOrganizationImpactRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getOrganizationImpact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about impact to an asset under an organization
   * affected by a service health event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   String name =
   *       OrganizationImpactName.of("[ORGANIZATION]", "[LOCATION]", "[ORGANIZATION_IMPACT]")
   *           .toString();
   *   OrganizationImpact response = serviceHealthClient.getOrganizationImpact(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource using the form
   *     `organizations/{organization_id}/locations/global/organizationImpacts/{organization_impact_id}`.
   *     <p>`organization_id` - ID (number) of the organization that contains the event. To get your
   *     `organization_id`, see [Getting your organization resource
   *     ID](https://cloud.google.com/resource-manager/docs/creating-managing-organization#retrieving_your_organization_id).&lt;br&gt;
   *     `organization_impact_id` - ID of the [OrganizationImpact
   *     resource](/service-health/docs/reference/rest/v1beta/organizations.locations.organizationImpacts#OrganizationImpact).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OrganizationImpact getOrganizationImpact(String name) {
    GetOrganizationImpactRequest request =
        GetOrganizationImpactRequest.newBuilder().setName(name).build();
    return getOrganizationImpact(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about impact to an asset under an organization
   * affected by a service health event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   GetOrganizationImpactRequest request =
   *       GetOrganizationImpactRequest.newBuilder()
   *           .setName(
   *               OrganizationImpactName.of("[ORGANIZATION]", "[LOCATION]", "[ORGANIZATION_IMPACT]")
   *                   .toString())
   *           .build();
   *   OrganizationImpact response = serviceHealthClient.getOrganizationImpact(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OrganizationImpact getOrganizationImpact(GetOrganizationImpactRequest request) {
    return getOrganizationImpactCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about impact to an asset under an organization
   * affected by a service health event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   GetOrganizationImpactRequest request =
   *       GetOrganizationImpactRequest.newBuilder()
   *           .setName(
   *               OrganizationImpactName.of("[ORGANIZATION]", "[LOCATION]", "[ORGANIZATION_IMPACT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<OrganizationImpact> future =
   *       serviceHealthClient.getOrganizationImpactCallable().futureCall(request);
   *   // Do something.
   *   OrganizationImpact response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetOrganizationImpactRequest, OrganizationImpact>
      getOrganizationImpactCallable() {
    return stub.getOrganizationImpactCallable();
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
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : serviceHealthClient.listLocations(request).iterateAll()) {
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
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       serviceHealthClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = serviceHealthClient.listLocationsCallable().call(request);
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
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = serviceHealthClient.getLocation(request);
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
   * try (ServiceHealthClient serviceHealthClient = ServiceHealthClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = serviceHealthClient.getLocationCallable().futureCall(request);
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

  public static class ListEventsPagedResponse
      extends AbstractPagedListResponse<
          ListEventsRequest,
          ListEventsResponse,
          Event,
          ListEventsPage,
          ListEventsFixedSizeCollection> {

    public static ApiFuture<ListEventsPagedResponse> createAsync(
        PageContext<ListEventsRequest, ListEventsResponse, Event> context,
        ApiFuture<ListEventsResponse> futureResponse) {
      ApiFuture<ListEventsPage> futurePage =
          ListEventsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListEventsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListEventsPagedResponse(ListEventsPage page) {
      super(page, ListEventsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEventsPage
      extends AbstractPage<ListEventsRequest, ListEventsResponse, Event, ListEventsPage> {

    private ListEventsPage(
        PageContext<ListEventsRequest, ListEventsResponse, Event> context,
        ListEventsResponse response) {
      super(context, response);
    }

    private static ListEventsPage createEmptyPage() {
      return new ListEventsPage(null, null);
    }

    @Override
    protected ListEventsPage createPage(
        PageContext<ListEventsRequest, ListEventsResponse, Event> context,
        ListEventsResponse response) {
      return new ListEventsPage(context, response);
    }

    @Override
    public ApiFuture<ListEventsPage> createPageAsync(
        PageContext<ListEventsRequest, ListEventsResponse, Event> context,
        ApiFuture<ListEventsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEventsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEventsRequest,
          ListEventsResponse,
          Event,
          ListEventsPage,
          ListEventsFixedSizeCollection> {

    private ListEventsFixedSizeCollection(List<ListEventsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEventsFixedSizeCollection createEmptyCollection() {
      return new ListEventsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEventsFixedSizeCollection createCollection(
        List<ListEventsPage> pages, int collectionSize) {
      return new ListEventsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListOrganizationEventsPagedResponse
      extends AbstractPagedListResponse<
          ListOrganizationEventsRequest,
          ListOrganizationEventsResponse,
          OrganizationEvent,
          ListOrganizationEventsPage,
          ListOrganizationEventsFixedSizeCollection> {

    public static ApiFuture<ListOrganizationEventsPagedResponse> createAsync(
        PageContext<
                ListOrganizationEventsRequest, ListOrganizationEventsResponse, OrganizationEvent>
            context,
        ApiFuture<ListOrganizationEventsResponse> futureResponse) {
      ApiFuture<ListOrganizationEventsPage> futurePage =
          ListOrganizationEventsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListOrganizationEventsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListOrganizationEventsPagedResponse(ListOrganizationEventsPage page) {
      super(page, ListOrganizationEventsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListOrganizationEventsPage
      extends AbstractPage<
          ListOrganizationEventsRequest,
          ListOrganizationEventsResponse,
          OrganizationEvent,
          ListOrganizationEventsPage> {

    private ListOrganizationEventsPage(
        PageContext<
                ListOrganizationEventsRequest, ListOrganizationEventsResponse, OrganizationEvent>
            context,
        ListOrganizationEventsResponse response) {
      super(context, response);
    }

    private static ListOrganizationEventsPage createEmptyPage() {
      return new ListOrganizationEventsPage(null, null);
    }

    @Override
    protected ListOrganizationEventsPage createPage(
        PageContext<
                ListOrganizationEventsRequest, ListOrganizationEventsResponse, OrganizationEvent>
            context,
        ListOrganizationEventsResponse response) {
      return new ListOrganizationEventsPage(context, response);
    }

    @Override
    public ApiFuture<ListOrganizationEventsPage> createPageAsync(
        PageContext<
                ListOrganizationEventsRequest, ListOrganizationEventsResponse, OrganizationEvent>
            context,
        ApiFuture<ListOrganizationEventsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListOrganizationEventsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOrganizationEventsRequest,
          ListOrganizationEventsResponse,
          OrganizationEvent,
          ListOrganizationEventsPage,
          ListOrganizationEventsFixedSizeCollection> {

    private ListOrganizationEventsFixedSizeCollection(
        List<ListOrganizationEventsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOrganizationEventsFixedSizeCollection createEmptyCollection() {
      return new ListOrganizationEventsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOrganizationEventsFixedSizeCollection createCollection(
        List<ListOrganizationEventsPage> pages, int collectionSize) {
      return new ListOrganizationEventsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListOrganizationImpactsPagedResponse
      extends AbstractPagedListResponse<
          ListOrganizationImpactsRequest,
          ListOrganizationImpactsResponse,
          OrganizationImpact,
          ListOrganizationImpactsPage,
          ListOrganizationImpactsFixedSizeCollection> {

    public static ApiFuture<ListOrganizationImpactsPagedResponse> createAsync(
        PageContext<
                ListOrganizationImpactsRequest, ListOrganizationImpactsResponse, OrganizationImpact>
            context,
        ApiFuture<ListOrganizationImpactsResponse> futureResponse) {
      ApiFuture<ListOrganizationImpactsPage> futurePage =
          ListOrganizationImpactsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListOrganizationImpactsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListOrganizationImpactsPagedResponse(ListOrganizationImpactsPage page) {
      super(page, ListOrganizationImpactsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListOrganizationImpactsPage
      extends AbstractPage<
          ListOrganizationImpactsRequest,
          ListOrganizationImpactsResponse,
          OrganizationImpact,
          ListOrganizationImpactsPage> {

    private ListOrganizationImpactsPage(
        PageContext<
                ListOrganizationImpactsRequest, ListOrganizationImpactsResponse, OrganizationImpact>
            context,
        ListOrganizationImpactsResponse response) {
      super(context, response);
    }

    private static ListOrganizationImpactsPage createEmptyPage() {
      return new ListOrganizationImpactsPage(null, null);
    }

    @Override
    protected ListOrganizationImpactsPage createPage(
        PageContext<
                ListOrganizationImpactsRequest, ListOrganizationImpactsResponse, OrganizationImpact>
            context,
        ListOrganizationImpactsResponse response) {
      return new ListOrganizationImpactsPage(context, response);
    }

    @Override
    public ApiFuture<ListOrganizationImpactsPage> createPageAsync(
        PageContext<
                ListOrganizationImpactsRequest, ListOrganizationImpactsResponse, OrganizationImpact>
            context,
        ApiFuture<ListOrganizationImpactsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListOrganizationImpactsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListOrganizationImpactsRequest,
          ListOrganizationImpactsResponse,
          OrganizationImpact,
          ListOrganizationImpactsPage,
          ListOrganizationImpactsFixedSizeCollection> {

    private ListOrganizationImpactsFixedSizeCollection(
        List<ListOrganizationImpactsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListOrganizationImpactsFixedSizeCollection createEmptyCollection() {
      return new ListOrganizationImpactsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListOrganizationImpactsFixedSizeCollection createCollection(
        List<ListOrganizationImpactsPage> pages, int collectionSize) {
      return new ListOrganizationImpactsFixedSizeCollection(pages, collectionSize);
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
