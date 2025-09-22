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

package com.google.cloud.locationfinder.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.locationfinder.v1.stub.CloudLocationFinderStub;
import com.google.cloud.locationfinder.v1.stub.CloudLocationFinderStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service describing handlers for resources
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
 * try (CloudLocationFinderClient cloudLocationFinderClient = CloudLocationFinderClient.create()) {
 *   CloudLocationName name = CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]");
 *   CloudLocation response = cloudLocationFinderClient.getCloudLocation(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CloudLocationFinderClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> ListCloudLocations</td>
 *      <td><p> Lists cloud locations under a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCloudLocations(ListCloudLocationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCloudLocations(LocationName parent)
 *           <li><p> listCloudLocations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCloudLocationsPagedCallable()
 *           <li><p> listCloudLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCloudLocation</td>
 *      <td><p> Retrieves a resource containing information about a cloud location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCloudLocation(GetCloudLocationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCloudLocation(CloudLocationName name)
 *           <li><p> getCloudLocation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCloudLocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchCloudLocations</td>
 *      <td><p> Searches for cloud locations from a given source location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchCloudLocations(SearchCloudLocationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> searchCloudLocations(LocationName parent, CloudLocationName sourceCloudLocation, String query)
 *           <li><p> searchCloudLocations(LocationName parent, String sourceCloudLocation, String query)
 *           <li><p> searchCloudLocations(String parent, CloudLocationName sourceCloudLocation, String query)
 *           <li><p> searchCloudLocations(String parent, String sourceCloudLocation, String query)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchCloudLocationsPagedCallable()
 *           <li><p> searchCloudLocationsCallable()
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
 * <p>This class can be customized by passing in a custom instance of CloudLocationFinderSettings to
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
 * CloudLocationFinderSettings cloudLocationFinderSettings =
 *     CloudLocationFinderSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CloudLocationFinderClient cloudLocationFinderClient =
 *     CloudLocationFinderClient.create(cloudLocationFinderSettings);
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
 * CloudLocationFinderSettings cloudLocationFinderSettings =
 *     CloudLocationFinderSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CloudLocationFinderClient cloudLocationFinderClient =
 *     CloudLocationFinderClient.create(cloudLocationFinderSettings);
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
 * CloudLocationFinderSettings cloudLocationFinderSettings =
 *     CloudLocationFinderSettings.newHttpJsonBuilder().build();
 * CloudLocationFinderClient cloudLocationFinderClient =
 *     CloudLocationFinderClient.create(cloudLocationFinderSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CloudLocationFinderClient implements BackgroundResource {
  private final CloudLocationFinderSettings settings;
  private final CloudLocationFinderStub stub;

  /** Constructs an instance of CloudLocationFinderClient with default settings. */
  public static final CloudLocationFinderClient create() throws IOException {
    return create(CloudLocationFinderSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CloudLocationFinderClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CloudLocationFinderClient create(CloudLocationFinderSettings settings)
      throws IOException {
    return new CloudLocationFinderClient(settings);
  }

  /**
   * Constructs an instance of CloudLocationFinderClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(CloudLocationFinderSettings).
   */
  public static final CloudLocationFinderClient create(CloudLocationFinderStub stub) {
    return new CloudLocationFinderClient(stub);
  }

  /**
   * Constructs an instance of CloudLocationFinderClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected CloudLocationFinderClient(CloudLocationFinderSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CloudLocationFinderStubSettings) settings.getStubSettings()).createStub();
  }

  protected CloudLocationFinderClient(CloudLocationFinderStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CloudLocationFinderSettings getSettings() {
    return settings;
  }

  public CloudLocationFinderStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists cloud locations under a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudLocationFinderClient cloudLocationFinderClient = CloudLocationFinderClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (CloudLocation element :
   *       cloudLocationFinderClient.listCloudLocations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of cloud locations. Format:
   *     projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCloudLocationsPagedResponse listCloudLocations(LocationName parent) {
    ListCloudLocationsRequest request =
        ListCloudLocationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCloudLocations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists cloud locations under a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudLocationFinderClient cloudLocationFinderClient = CloudLocationFinderClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (CloudLocation element :
   *       cloudLocationFinderClient.listCloudLocations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of cloud locations. Format:
   *     projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCloudLocationsPagedResponse listCloudLocations(String parent) {
    ListCloudLocationsRequest request =
        ListCloudLocationsRequest.newBuilder().setParent(parent).build();
    return listCloudLocations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists cloud locations under a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudLocationFinderClient cloudLocationFinderClient = CloudLocationFinderClient.create()) {
   *   ListCloudLocationsRequest request =
   *       ListCloudLocationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (CloudLocation element :
   *       cloudLocationFinderClient.listCloudLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCloudLocationsPagedResponse listCloudLocations(
      ListCloudLocationsRequest request) {
    return listCloudLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists cloud locations under a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudLocationFinderClient cloudLocationFinderClient = CloudLocationFinderClient.create()) {
   *   ListCloudLocationsRequest request =
   *       ListCloudLocationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<CloudLocation> future =
   *       cloudLocationFinderClient.listCloudLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CloudLocation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCloudLocationsRequest, ListCloudLocationsPagedResponse>
      listCloudLocationsPagedCallable() {
    return stub.listCloudLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists cloud locations under a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudLocationFinderClient cloudLocationFinderClient = CloudLocationFinderClient.create()) {
   *   ListCloudLocationsRequest request =
   *       ListCloudLocationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListCloudLocationsResponse response =
   *         cloudLocationFinderClient.listCloudLocationsCallable().call(request);
   *     for (CloudLocation element : response.getCloudLocationsList()) {
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
  public final UnaryCallable<ListCloudLocationsRequest, ListCloudLocationsResponse>
      listCloudLocationsCallable() {
    return stub.listCloudLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about a cloud location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudLocationFinderClient cloudLocationFinderClient = CloudLocationFinderClient.create()) {
   *   CloudLocationName name = CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]");
   *   CloudLocation response = cloudLocationFinderClient.getCloudLocation(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloudLocation getCloudLocation(CloudLocationName name) {
    GetCloudLocationRequest request =
        GetCloudLocationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCloudLocation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about a cloud location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudLocationFinderClient cloudLocationFinderClient = CloudLocationFinderClient.create()) {
   *   String name = CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]").toString();
   *   CloudLocation response = cloudLocationFinderClient.getCloudLocation(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloudLocation getCloudLocation(String name) {
    GetCloudLocationRequest request = GetCloudLocationRequest.newBuilder().setName(name).build();
    return getCloudLocation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about a cloud location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudLocationFinderClient cloudLocationFinderClient = CloudLocationFinderClient.create()) {
   *   GetCloudLocationRequest request =
   *       GetCloudLocationRequest.newBuilder()
   *           .setName(
   *               CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]").toString())
   *           .build();
   *   CloudLocation response = cloudLocationFinderClient.getCloudLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CloudLocation getCloudLocation(GetCloudLocationRequest request) {
    return getCloudLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a resource containing information about a cloud location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudLocationFinderClient cloudLocationFinderClient = CloudLocationFinderClient.create()) {
   *   GetCloudLocationRequest request =
   *       GetCloudLocationRequest.newBuilder()
   *           .setName(
   *               CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]").toString())
   *           .build();
   *   ApiFuture<CloudLocation> future =
   *       cloudLocationFinderClient.getCloudLocationCallable().futureCall(request);
   *   // Do something.
   *   CloudLocation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCloudLocationRequest, CloudLocation> getCloudLocationCallable() {
    return stub.getCloudLocationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for cloud locations from a given source location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudLocationFinderClient cloudLocationFinderClient = CloudLocationFinderClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   CloudLocationName sourceCloudLocation =
   *       CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]");
   *   String query = "query107944136";
   *   for (CloudLocation element :
   *       cloudLocationFinderClient
   *           .searchCloudLocations(parent, sourceCloudLocation, query)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of cloud locations. Format:
   *     projects/{project}/locations/{location}
   * @param sourceCloudLocation Required. The source cloud location to search from. Example search
   *     can be searching nearby cloud locations from the source cloud location by latency.
   * @param query Optional. The query string in search query syntax. While filter is used to filter
   *     the search results by attributes, query is used to specify the search requirements.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchCloudLocationsPagedResponse searchCloudLocations(
      LocationName parent, CloudLocationName sourceCloudLocation, String query) {
    SearchCloudLocationsRequest request =
        SearchCloudLocationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSourceCloudLocation(
                sourceCloudLocation == null ? null : sourceCloudLocation.toString())
            .setQuery(query)
            .build();
    return searchCloudLocations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for cloud locations from a given source location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudLocationFinderClient cloudLocationFinderClient = CloudLocationFinderClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String sourceCloudLocation =
   *       CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]").toString();
   *   String query = "query107944136";
   *   for (CloudLocation element :
   *       cloudLocationFinderClient
   *           .searchCloudLocations(parent, sourceCloudLocation, query)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of cloud locations. Format:
   *     projects/{project}/locations/{location}
   * @param sourceCloudLocation Required. The source cloud location to search from. Example search
   *     can be searching nearby cloud locations from the source cloud location by latency.
   * @param query Optional. The query string in search query syntax. While filter is used to filter
   *     the search results by attributes, query is used to specify the search requirements.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchCloudLocationsPagedResponse searchCloudLocations(
      LocationName parent, String sourceCloudLocation, String query) {
    SearchCloudLocationsRequest request =
        SearchCloudLocationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSourceCloudLocation(sourceCloudLocation)
            .setQuery(query)
            .build();
    return searchCloudLocations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for cloud locations from a given source location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudLocationFinderClient cloudLocationFinderClient = CloudLocationFinderClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   CloudLocationName sourceCloudLocation =
   *       CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]");
   *   String query = "query107944136";
   *   for (CloudLocation element :
   *       cloudLocationFinderClient
   *           .searchCloudLocations(parent, sourceCloudLocation, query)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of cloud locations. Format:
   *     projects/{project}/locations/{location}
   * @param sourceCloudLocation Required. The source cloud location to search from. Example search
   *     can be searching nearby cloud locations from the source cloud location by latency.
   * @param query Optional. The query string in search query syntax. While filter is used to filter
   *     the search results by attributes, query is used to specify the search requirements.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchCloudLocationsPagedResponse searchCloudLocations(
      String parent, CloudLocationName sourceCloudLocation, String query) {
    SearchCloudLocationsRequest request =
        SearchCloudLocationsRequest.newBuilder()
            .setParent(parent)
            .setSourceCloudLocation(
                sourceCloudLocation == null ? null : sourceCloudLocation.toString())
            .setQuery(query)
            .build();
    return searchCloudLocations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for cloud locations from a given source location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudLocationFinderClient cloudLocationFinderClient = CloudLocationFinderClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String sourceCloudLocation =
   *       CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]").toString();
   *   String query = "query107944136";
   *   for (CloudLocation element :
   *       cloudLocationFinderClient
   *           .searchCloudLocations(parent, sourceCloudLocation, query)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of cloud locations. Format:
   *     projects/{project}/locations/{location}
   * @param sourceCloudLocation Required. The source cloud location to search from. Example search
   *     can be searching nearby cloud locations from the source cloud location by latency.
   * @param query Optional. The query string in search query syntax. While filter is used to filter
   *     the search results by attributes, query is used to specify the search requirements.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchCloudLocationsPagedResponse searchCloudLocations(
      String parent, String sourceCloudLocation, String query) {
    SearchCloudLocationsRequest request =
        SearchCloudLocationsRequest.newBuilder()
            .setParent(parent)
            .setSourceCloudLocation(sourceCloudLocation)
            .setQuery(query)
            .build();
    return searchCloudLocations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for cloud locations from a given source location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudLocationFinderClient cloudLocationFinderClient = CloudLocationFinderClient.create()) {
   *   SearchCloudLocationsRequest request =
   *       SearchCloudLocationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceCloudLocation(
   *               CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setQuery("query107944136")
   *           .build();
   *   for (CloudLocation element :
   *       cloudLocationFinderClient.searchCloudLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchCloudLocationsPagedResponse searchCloudLocations(
      SearchCloudLocationsRequest request) {
    return searchCloudLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for cloud locations from a given source location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudLocationFinderClient cloudLocationFinderClient = CloudLocationFinderClient.create()) {
   *   SearchCloudLocationsRequest request =
   *       SearchCloudLocationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceCloudLocation(
   *               CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setQuery("query107944136")
   *           .build();
   *   ApiFuture<CloudLocation> future =
   *       cloudLocationFinderClient.searchCloudLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CloudLocation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchCloudLocationsRequest, SearchCloudLocationsPagedResponse>
      searchCloudLocationsPagedCallable() {
    return stub.searchCloudLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for cloud locations from a given source location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudLocationFinderClient cloudLocationFinderClient = CloudLocationFinderClient.create()) {
   *   SearchCloudLocationsRequest request =
   *       SearchCloudLocationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setSourceCloudLocation(
   *               CloudLocationName.of("[PROJECT]", "[LOCATION]", "[CLOUD_LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setQuery("query107944136")
   *           .build();
   *   while (true) {
   *     SearchCloudLocationsResponse response =
   *         cloudLocationFinderClient.searchCloudLocationsCallable().call(request);
   *     for (CloudLocation element : response.getCloudLocationsList()) {
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
  public final UnaryCallable<SearchCloudLocationsRequest, SearchCloudLocationsResponse>
      searchCloudLocationsCallable() {
    return stub.searchCloudLocationsCallable();
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

  public static class ListCloudLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListCloudLocationsRequest,
          ListCloudLocationsResponse,
          CloudLocation,
          ListCloudLocationsPage,
          ListCloudLocationsFixedSizeCollection> {

    public static ApiFuture<ListCloudLocationsPagedResponse> createAsync(
        PageContext<ListCloudLocationsRequest, ListCloudLocationsResponse, CloudLocation> context,
        ApiFuture<ListCloudLocationsResponse> futureResponse) {
      ApiFuture<ListCloudLocationsPage> futurePage =
          ListCloudLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCloudLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCloudLocationsPagedResponse(ListCloudLocationsPage page) {
      super(page, ListCloudLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCloudLocationsPage
      extends AbstractPage<
          ListCloudLocationsRequest,
          ListCloudLocationsResponse,
          CloudLocation,
          ListCloudLocationsPage> {

    private ListCloudLocationsPage(
        PageContext<ListCloudLocationsRequest, ListCloudLocationsResponse, CloudLocation> context,
        ListCloudLocationsResponse response) {
      super(context, response);
    }

    private static ListCloudLocationsPage createEmptyPage() {
      return new ListCloudLocationsPage(null, null);
    }

    @Override
    protected ListCloudLocationsPage createPage(
        PageContext<ListCloudLocationsRequest, ListCloudLocationsResponse, CloudLocation> context,
        ListCloudLocationsResponse response) {
      return new ListCloudLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListCloudLocationsPage> createPageAsync(
        PageContext<ListCloudLocationsRequest, ListCloudLocationsResponse, CloudLocation> context,
        ApiFuture<ListCloudLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCloudLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCloudLocationsRequest,
          ListCloudLocationsResponse,
          CloudLocation,
          ListCloudLocationsPage,
          ListCloudLocationsFixedSizeCollection> {

    private ListCloudLocationsFixedSizeCollection(
        List<ListCloudLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCloudLocationsFixedSizeCollection createEmptyCollection() {
      return new ListCloudLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCloudLocationsFixedSizeCollection createCollection(
        List<ListCloudLocationsPage> pages, int collectionSize) {
      return new ListCloudLocationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchCloudLocationsPagedResponse
      extends AbstractPagedListResponse<
          SearchCloudLocationsRequest,
          SearchCloudLocationsResponse,
          CloudLocation,
          SearchCloudLocationsPage,
          SearchCloudLocationsFixedSizeCollection> {

    public static ApiFuture<SearchCloudLocationsPagedResponse> createAsync(
        PageContext<SearchCloudLocationsRequest, SearchCloudLocationsResponse, CloudLocation>
            context,
        ApiFuture<SearchCloudLocationsResponse> futureResponse) {
      ApiFuture<SearchCloudLocationsPage> futurePage =
          SearchCloudLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchCloudLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchCloudLocationsPagedResponse(SearchCloudLocationsPage page) {
      super(page, SearchCloudLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchCloudLocationsPage
      extends AbstractPage<
          SearchCloudLocationsRequest,
          SearchCloudLocationsResponse,
          CloudLocation,
          SearchCloudLocationsPage> {

    private SearchCloudLocationsPage(
        PageContext<SearchCloudLocationsRequest, SearchCloudLocationsResponse, CloudLocation>
            context,
        SearchCloudLocationsResponse response) {
      super(context, response);
    }

    private static SearchCloudLocationsPage createEmptyPage() {
      return new SearchCloudLocationsPage(null, null);
    }

    @Override
    protected SearchCloudLocationsPage createPage(
        PageContext<SearchCloudLocationsRequest, SearchCloudLocationsResponse, CloudLocation>
            context,
        SearchCloudLocationsResponse response) {
      return new SearchCloudLocationsPage(context, response);
    }

    @Override
    public ApiFuture<SearchCloudLocationsPage> createPageAsync(
        PageContext<SearchCloudLocationsRequest, SearchCloudLocationsResponse, CloudLocation>
            context,
        ApiFuture<SearchCloudLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchCloudLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchCloudLocationsRequest,
          SearchCloudLocationsResponse,
          CloudLocation,
          SearchCloudLocationsPage,
          SearchCloudLocationsFixedSizeCollection> {

    private SearchCloudLocationsFixedSizeCollection(
        List<SearchCloudLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchCloudLocationsFixedSizeCollection createEmptyCollection() {
      return new SearchCloudLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchCloudLocationsFixedSizeCollection createCollection(
        List<SearchCloudLocationsPage> pages, int collectionSize) {
      return new SearchCloudLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
