/*
 * Copyright 2025 Google LLC
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

package com.google.cloud.maintenance.api.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
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
import com.google.cloud.maintenance.api.v1beta.stub.MaintenanceStub;
import com.google.cloud.maintenance.api.v1beta.stub.MaintenanceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Unified Maintenance service
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
 * try (MaintenanceClient maintenanceClient = MaintenanceClient.create()) {
 *   ResourceMaintenanceName name =
 *       ResourceMaintenanceName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_MAINTENANCE]");
 *   ResourceMaintenance response = maintenanceClient.getResourceMaintenance(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MaintenanceClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> SummarizeMaintenances</td>
 *      <td><p> Retrieves the statistics of a specific maintenance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> summarizeMaintenances(SummarizeMaintenancesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> summarizeMaintenances(LocationName parent)
 *           <li><p> summarizeMaintenances(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> summarizeMaintenancesPagedCallable()
 *           <li><p> summarizeMaintenancesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListResourceMaintenances</td>
 *      <td><p> Retrieve a collection of resource maintenances.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listResourceMaintenances(ListResourceMaintenancesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listResourceMaintenances(LocationName parent)
 *           <li><p> listResourceMaintenances(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listResourceMaintenancesPagedCallable()
 *           <li><p> listResourceMaintenancesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetResourceMaintenance</td>
 *      <td><p> Retrieve a single resource maintenance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getResourceMaintenance(GetResourceMaintenanceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getResourceMaintenance(ResourceMaintenanceName name)
 *           <li><p> getResourceMaintenance(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getResourceMaintenanceCallable()
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
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of MaintenanceSettings to
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
 * MaintenanceSettings maintenanceSettings =
 *     MaintenanceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MaintenanceClient maintenanceClient = MaintenanceClient.create(maintenanceSettings);
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
 * MaintenanceSettings maintenanceSettings =
 *     MaintenanceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MaintenanceClient maintenanceClient = MaintenanceClient.create(maintenanceSettings);
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
 * MaintenanceSettings maintenanceSettings = MaintenanceSettings.newHttpJsonBuilder().build();
 * MaintenanceClient maintenanceClient = MaintenanceClient.create(maintenanceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MaintenanceClient implements BackgroundResource {
  private final MaintenanceSettings settings;
  private final MaintenanceStub stub;

  /** Constructs an instance of MaintenanceClient with default settings. */
  public static final MaintenanceClient create() throws IOException {
    return create(MaintenanceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MaintenanceClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final MaintenanceClient create(MaintenanceSettings settings) throws IOException {
    return new MaintenanceClient(settings);
  }

  /**
   * Constructs an instance of MaintenanceClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(MaintenanceSettings).
   */
  public static final MaintenanceClient create(MaintenanceStub stub) {
    return new MaintenanceClient(stub);
  }

  /**
   * Constructs an instance of MaintenanceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected MaintenanceClient(MaintenanceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((MaintenanceStubSettings) settings.getStubSettings()).createStub();
  }

  protected MaintenanceClient(MaintenanceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final MaintenanceSettings getSettings() {
    return settings;
  }

  public MaintenanceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the statistics of a specific maintenance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MaintenanceClient maintenanceClient = MaintenanceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (MaintenanceSummary element :
   *       maintenanceClient.summarizeMaintenances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the resource maintenance. eg.
   *     `projects/123/locations/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SummarizeMaintenancesPagedResponse summarizeMaintenances(LocationName parent) {
    SummarizeMaintenancesRequest request =
        SummarizeMaintenancesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return summarizeMaintenances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the statistics of a specific maintenance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MaintenanceClient maintenanceClient = MaintenanceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (MaintenanceSummary element :
   *       maintenanceClient.summarizeMaintenances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the resource maintenance. eg.
   *     `projects/123/locations/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SummarizeMaintenancesPagedResponse summarizeMaintenances(String parent) {
    SummarizeMaintenancesRequest request =
        SummarizeMaintenancesRequest.newBuilder().setParent(parent).build();
    return summarizeMaintenances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the statistics of a specific maintenance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MaintenanceClient maintenanceClient = MaintenanceClient.create()) {
   *   SummarizeMaintenancesRequest request =
   *       SummarizeMaintenancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (MaintenanceSummary element :
   *       maintenanceClient.summarizeMaintenances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SummarizeMaintenancesPagedResponse summarizeMaintenances(
      SummarizeMaintenancesRequest request) {
    return summarizeMaintenancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the statistics of a specific maintenance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MaintenanceClient maintenanceClient = MaintenanceClient.create()) {
   *   SummarizeMaintenancesRequest request =
   *       SummarizeMaintenancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<MaintenanceSummary> future =
   *       maintenanceClient.summarizeMaintenancesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MaintenanceSummary element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SummarizeMaintenancesRequest, SummarizeMaintenancesPagedResponse>
      summarizeMaintenancesPagedCallable() {
    return stub.summarizeMaintenancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the statistics of a specific maintenance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MaintenanceClient maintenanceClient = MaintenanceClient.create()) {
   *   SummarizeMaintenancesRequest request =
   *       SummarizeMaintenancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     SummarizeMaintenancesResponse response =
   *         maintenanceClient.summarizeMaintenancesCallable().call(request);
   *     for (MaintenanceSummary element : response.getMaintenancesList()) {
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
  public final UnaryCallable<SummarizeMaintenancesRequest, SummarizeMaintenancesResponse>
      summarizeMaintenancesCallable() {
    return stub.summarizeMaintenancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of resource maintenances.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MaintenanceClient maintenanceClient = MaintenanceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ResourceMaintenance element :
   *       maintenanceClient.listResourceMaintenances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the resource maintenance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourceMaintenancesPagedResponse listResourceMaintenances(LocationName parent) {
    ListResourceMaintenancesRequest request =
        ListResourceMaintenancesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listResourceMaintenances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of resource maintenances.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MaintenanceClient maintenanceClient = MaintenanceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ResourceMaintenance element :
   *       maintenanceClient.listResourceMaintenances(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent of the resource maintenance.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourceMaintenancesPagedResponse listResourceMaintenances(String parent) {
    ListResourceMaintenancesRequest request =
        ListResourceMaintenancesRequest.newBuilder().setParent(parent).build();
    return listResourceMaintenances(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of resource maintenances.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MaintenanceClient maintenanceClient = MaintenanceClient.create()) {
   *   ListResourceMaintenancesRequest request =
   *       ListResourceMaintenancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (ResourceMaintenance element :
   *       maintenanceClient.listResourceMaintenances(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourceMaintenancesPagedResponse listResourceMaintenances(
      ListResourceMaintenancesRequest request) {
    return listResourceMaintenancesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of resource maintenances.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MaintenanceClient maintenanceClient = MaintenanceClient.create()) {
   *   ListResourceMaintenancesRequest request =
   *       ListResourceMaintenancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<ResourceMaintenance> future =
   *       maintenanceClient.listResourceMaintenancesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ResourceMaintenance element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListResourceMaintenancesRequest, ListResourceMaintenancesPagedResponse>
      listResourceMaintenancesPagedCallable() {
    return stub.listResourceMaintenancesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a collection of resource maintenances.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MaintenanceClient maintenanceClient = MaintenanceClient.create()) {
   *   ListResourceMaintenancesRequest request =
   *       ListResourceMaintenancesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListResourceMaintenancesResponse response =
   *         maintenanceClient.listResourceMaintenancesCallable().call(request);
   *     for (ResourceMaintenance element : response.getResourceMaintenancesList()) {
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
  public final UnaryCallable<ListResourceMaintenancesRequest, ListResourceMaintenancesResponse>
      listResourceMaintenancesCallable() {
    return stub.listResourceMaintenancesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single resource maintenance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MaintenanceClient maintenanceClient = MaintenanceClient.create()) {
   *   ResourceMaintenanceName name =
   *       ResourceMaintenanceName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_MAINTENANCE]");
   *   ResourceMaintenance response = maintenanceClient.getResourceMaintenance(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResourceMaintenance getResourceMaintenance(ResourceMaintenanceName name) {
    GetResourceMaintenanceRequest request =
        GetResourceMaintenanceRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getResourceMaintenance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single resource maintenance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MaintenanceClient maintenanceClient = MaintenanceClient.create()) {
   *   String name =
   *       ResourceMaintenanceName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_MAINTENANCE]")
   *           .toString();
   *   ResourceMaintenance response = maintenanceClient.getResourceMaintenance(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the resource within a service.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResourceMaintenance getResourceMaintenance(String name) {
    GetResourceMaintenanceRequest request =
        GetResourceMaintenanceRequest.newBuilder().setName(name).build();
    return getResourceMaintenance(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single resource maintenance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MaintenanceClient maintenanceClient = MaintenanceClient.create()) {
   *   GetResourceMaintenanceRequest request =
   *       GetResourceMaintenanceRequest.newBuilder()
   *           .setName(
   *               ResourceMaintenanceName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_MAINTENANCE]")
   *                   .toString())
   *           .build();
   *   ResourceMaintenance response = maintenanceClient.getResourceMaintenance(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ResourceMaintenance getResourceMaintenance(GetResourceMaintenanceRequest request) {
    return getResourceMaintenanceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve a single resource maintenance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MaintenanceClient maintenanceClient = MaintenanceClient.create()) {
   *   GetResourceMaintenanceRequest request =
   *       GetResourceMaintenanceRequest.newBuilder()
   *           .setName(
   *               ResourceMaintenanceName.of("[PROJECT]", "[LOCATION]", "[RESOURCE_MAINTENANCE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ResourceMaintenance> future =
   *       maintenanceClient.getResourceMaintenanceCallable().futureCall(request);
   *   // Do something.
   *   ResourceMaintenance response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetResourceMaintenanceRequest, ResourceMaintenance>
      getResourceMaintenanceCallable() {
    return stub.getResourceMaintenanceCallable();
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
   * try (MaintenanceClient maintenanceClient = MaintenanceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : maintenanceClient.listLocations(request).iterateAll()) {
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
   * try (MaintenanceClient maintenanceClient = MaintenanceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       maintenanceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (MaintenanceClient maintenanceClient = MaintenanceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = maintenanceClient.listLocationsCallable().call(request);
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
   * try (MaintenanceClient maintenanceClient = MaintenanceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = maintenanceClient.getLocation(request);
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
   * try (MaintenanceClient maintenanceClient = MaintenanceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = maintenanceClient.getLocationCallable().futureCall(request);
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

  public static class SummarizeMaintenancesPagedResponse
      extends AbstractPagedListResponse<
          SummarizeMaintenancesRequest,
          SummarizeMaintenancesResponse,
          MaintenanceSummary,
          SummarizeMaintenancesPage,
          SummarizeMaintenancesFixedSizeCollection> {

    public static ApiFuture<SummarizeMaintenancesPagedResponse> createAsync(
        PageContext<SummarizeMaintenancesRequest, SummarizeMaintenancesResponse, MaintenanceSummary>
            context,
        ApiFuture<SummarizeMaintenancesResponse> futureResponse) {
      ApiFuture<SummarizeMaintenancesPage> futurePage =
          SummarizeMaintenancesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SummarizeMaintenancesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SummarizeMaintenancesPagedResponse(SummarizeMaintenancesPage page) {
      super(page, SummarizeMaintenancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SummarizeMaintenancesPage
      extends AbstractPage<
          SummarizeMaintenancesRequest,
          SummarizeMaintenancesResponse,
          MaintenanceSummary,
          SummarizeMaintenancesPage> {

    private SummarizeMaintenancesPage(
        PageContext<SummarizeMaintenancesRequest, SummarizeMaintenancesResponse, MaintenanceSummary>
            context,
        SummarizeMaintenancesResponse response) {
      super(context, response);
    }

    private static SummarizeMaintenancesPage createEmptyPage() {
      return new SummarizeMaintenancesPage(null, null);
    }

    @Override
    protected SummarizeMaintenancesPage createPage(
        PageContext<SummarizeMaintenancesRequest, SummarizeMaintenancesResponse, MaintenanceSummary>
            context,
        SummarizeMaintenancesResponse response) {
      return new SummarizeMaintenancesPage(context, response);
    }

    @Override
    public ApiFuture<SummarizeMaintenancesPage> createPageAsync(
        PageContext<SummarizeMaintenancesRequest, SummarizeMaintenancesResponse, MaintenanceSummary>
            context,
        ApiFuture<SummarizeMaintenancesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SummarizeMaintenancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SummarizeMaintenancesRequest,
          SummarizeMaintenancesResponse,
          MaintenanceSummary,
          SummarizeMaintenancesPage,
          SummarizeMaintenancesFixedSizeCollection> {

    private SummarizeMaintenancesFixedSizeCollection(
        List<SummarizeMaintenancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SummarizeMaintenancesFixedSizeCollection createEmptyCollection() {
      return new SummarizeMaintenancesFixedSizeCollection(null, 0);
    }

    @Override
    protected SummarizeMaintenancesFixedSizeCollection createCollection(
        List<SummarizeMaintenancesPage> pages, int collectionSize) {
      return new SummarizeMaintenancesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListResourceMaintenancesPagedResponse
      extends AbstractPagedListResponse<
          ListResourceMaintenancesRequest,
          ListResourceMaintenancesResponse,
          ResourceMaintenance,
          ListResourceMaintenancesPage,
          ListResourceMaintenancesFixedSizeCollection> {

    public static ApiFuture<ListResourceMaintenancesPagedResponse> createAsync(
        PageContext<
                ListResourceMaintenancesRequest,
                ListResourceMaintenancesResponse,
                ResourceMaintenance>
            context,
        ApiFuture<ListResourceMaintenancesResponse> futureResponse) {
      ApiFuture<ListResourceMaintenancesPage> futurePage =
          ListResourceMaintenancesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListResourceMaintenancesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListResourceMaintenancesPagedResponse(ListResourceMaintenancesPage page) {
      super(page, ListResourceMaintenancesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListResourceMaintenancesPage
      extends AbstractPage<
          ListResourceMaintenancesRequest,
          ListResourceMaintenancesResponse,
          ResourceMaintenance,
          ListResourceMaintenancesPage> {

    private ListResourceMaintenancesPage(
        PageContext<
                ListResourceMaintenancesRequest,
                ListResourceMaintenancesResponse,
                ResourceMaintenance>
            context,
        ListResourceMaintenancesResponse response) {
      super(context, response);
    }

    private static ListResourceMaintenancesPage createEmptyPage() {
      return new ListResourceMaintenancesPage(null, null);
    }

    @Override
    protected ListResourceMaintenancesPage createPage(
        PageContext<
                ListResourceMaintenancesRequest,
                ListResourceMaintenancesResponse,
                ResourceMaintenance>
            context,
        ListResourceMaintenancesResponse response) {
      return new ListResourceMaintenancesPage(context, response);
    }

    @Override
    public ApiFuture<ListResourceMaintenancesPage> createPageAsync(
        PageContext<
                ListResourceMaintenancesRequest,
                ListResourceMaintenancesResponse,
                ResourceMaintenance>
            context,
        ApiFuture<ListResourceMaintenancesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListResourceMaintenancesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListResourceMaintenancesRequest,
          ListResourceMaintenancesResponse,
          ResourceMaintenance,
          ListResourceMaintenancesPage,
          ListResourceMaintenancesFixedSizeCollection> {

    private ListResourceMaintenancesFixedSizeCollection(
        List<ListResourceMaintenancesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListResourceMaintenancesFixedSizeCollection createEmptyCollection() {
      return new ListResourceMaintenancesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListResourceMaintenancesFixedSizeCollection createCollection(
        List<ListResourceMaintenancesPage> pages, int collectionSize) {
      return new ListResourceMaintenancesFixedSizeCollection(pages, collectionSize);
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
