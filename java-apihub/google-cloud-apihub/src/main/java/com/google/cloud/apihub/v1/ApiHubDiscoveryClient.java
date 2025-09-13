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

package com.google.cloud.apihub.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.apihub.v1.stub.ApiHubDiscoveryStub;
import com.google.cloud.apihub.v1.stub.ApiHubDiscoveryStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: This service exposes methods used to manage DiscoveredApiObservations and
 * DiscoveredApiOperations.
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
 * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
 *   DiscoveredApiObservationName name =
 *       DiscoveredApiObservationName.of(
 *           "[PROJECT]", "[LOCATION]", "[DISCOVERED_API_OBSERVATION]");
 *   DiscoveredApiObservation response = apiHubDiscoveryClient.getDiscoveredApiObservation(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ApiHubDiscoveryClient object to clean up resources
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
 *      <td><p> ListDiscoveredApiObservations</td>
 *      <td><p> Lists all the DiscoveredAPIObservations in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDiscoveredApiObservations(ListDiscoveredApiObservationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDiscoveredApiObservations(LocationName parent)
 *           <li><p> listDiscoveredApiObservations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDiscoveredApiObservationsPagedCallable()
 *           <li><p> listDiscoveredApiObservationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDiscoveredApiObservation</td>
 *      <td><p> Gets a DiscoveredAPIObservation in a given project, location and ApiObservation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDiscoveredApiObservation(GetDiscoveredApiObservationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDiscoveredApiObservation(DiscoveredApiObservationName name)
 *           <li><p> getDiscoveredApiObservation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDiscoveredApiObservationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDiscoveredApiOperations</td>
 *      <td><p> Lists all the DiscoveredAPIOperations in a given project, location and ApiObservation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDiscoveredApiOperations(ListDiscoveredApiOperationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDiscoveredApiOperations(DiscoveredApiObservationName parent)
 *           <li><p> listDiscoveredApiOperations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDiscoveredApiOperationsPagedCallable()
 *           <li><p> listDiscoveredApiOperationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDiscoveredApiOperation</td>
 *      <td><p> Gets a DiscoveredAPIOperation in a given project, location, ApiObservation and ApiOperation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDiscoveredApiOperation(GetDiscoveredApiOperationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDiscoveredApiOperation(DiscoveredApiOperationName name)
 *           <li><p> getDiscoveredApiOperation(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDiscoveredApiOperationCallable()
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
 * <p>This class can be customized by passing in a custom instance of ApiHubDiscoverySettings to
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
 * ApiHubDiscoverySettings apiHubDiscoverySettings =
 *     ApiHubDiscoverySettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ApiHubDiscoveryClient apiHubDiscoveryClient =
 *     ApiHubDiscoveryClient.create(apiHubDiscoverySettings);
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
 * ApiHubDiscoverySettings apiHubDiscoverySettings =
 *     ApiHubDiscoverySettings.newBuilder().setEndpoint(myEndpoint).build();
 * ApiHubDiscoveryClient apiHubDiscoveryClient =
 *     ApiHubDiscoveryClient.create(apiHubDiscoverySettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ApiHubDiscoveryClient implements BackgroundResource {
  private final ApiHubDiscoverySettings settings;
  private final ApiHubDiscoveryStub stub;

  /** Constructs an instance of ApiHubDiscoveryClient with default settings. */
  public static final ApiHubDiscoveryClient create() throws IOException {
    return create(ApiHubDiscoverySettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ApiHubDiscoveryClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ApiHubDiscoveryClient create(ApiHubDiscoverySettings settings)
      throws IOException {
    return new ApiHubDiscoveryClient(settings);
  }

  /**
   * Constructs an instance of ApiHubDiscoveryClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ApiHubDiscoverySettings).
   */
  public static final ApiHubDiscoveryClient create(ApiHubDiscoveryStub stub) {
    return new ApiHubDiscoveryClient(stub);
  }

  /**
   * Constructs an instance of ApiHubDiscoveryClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ApiHubDiscoveryClient(ApiHubDiscoverySettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ApiHubDiscoveryStubSettings) settings.getStubSettings()).createStub();
  }

  protected ApiHubDiscoveryClient(ApiHubDiscoveryStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ApiHubDiscoverySettings getSettings() {
    return settings;
  }

  public ApiHubDiscoveryStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the DiscoveredAPIObservations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (DiscoveredApiObservation element :
   *       apiHubDiscoveryClient.listDiscoveredApiObservations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of ApiObservations. Format:
   *     projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDiscoveredApiObservationsPagedResponse listDiscoveredApiObservations(
      LocationName parent) {
    ListDiscoveredApiObservationsRequest request =
        ListDiscoveredApiObservationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDiscoveredApiObservations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the DiscoveredAPIObservations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (DiscoveredApiObservation element :
   *       apiHubDiscoveryClient.listDiscoveredApiObservations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of ApiObservations. Format:
   *     projects/{project}/locations/{location}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDiscoveredApiObservationsPagedResponse listDiscoveredApiObservations(
      String parent) {
    ListDiscoveredApiObservationsRequest request =
        ListDiscoveredApiObservationsRequest.newBuilder().setParent(parent).build();
    return listDiscoveredApiObservations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the DiscoveredAPIObservations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
   *   ListDiscoveredApiObservationsRequest request =
   *       ListDiscoveredApiObservationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DiscoveredApiObservation element :
   *       apiHubDiscoveryClient.listDiscoveredApiObservations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDiscoveredApiObservationsPagedResponse listDiscoveredApiObservations(
      ListDiscoveredApiObservationsRequest request) {
    return listDiscoveredApiObservationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the DiscoveredAPIObservations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
   *   ListDiscoveredApiObservationsRequest request =
   *       ListDiscoveredApiObservationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DiscoveredApiObservation> future =
   *       apiHubDiscoveryClient.listDiscoveredApiObservationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DiscoveredApiObservation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListDiscoveredApiObservationsRequest, ListDiscoveredApiObservationsPagedResponse>
      listDiscoveredApiObservationsPagedCallable() {
    return stub.listDiscoveredApiObservationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the DiscoveredAPIObservations in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
   *   ListDiscoveredApiObservationsRequest request =
   *       ListDiscoveredApiObservationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDiscoveredApiObservationsResponse response =
   *         apiHubDiscoveryClient.listDiscoveredApiObservationsCallable().call(request);
   *     for (DiscoveredApiObservation element : response.getDiscoveredApiObservationsList()) {
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
  public final UnaryCallable<
          ListDiscoveredApiObservationsRequest, ListDiscoveredApiObservationsResponse>
      listDiscoveredApiObservationsCallable() {
    return stub.listDiscoveredApiObservationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a DiscoveredAPIObservation in a given project, location and ApiObservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
   *   DiscoveredApiObservationName name =
   *       DiscoveredApiObservationName.of(
   *           "[PROJECT]", "[LOCATION]", "[DISCOVERED_API_OBSERVATION]");
   *   DiscoveredApiObservation response = apiHubDiscoveryClient.getDiscoveredApiObservation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DiscoveredApiObservation to retrieve. Format:
   *     projects/{project}/locations/{location}/discoveredApiObservations/{discovered_api_observation}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiscoveredApiObservation getDiscoveredApiObservation(
      DiscoveredApiObservationName name) {
    GetDiscoveredApiObservationRequest request =
        GetDiscoveredApiObservationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDiscoveredApiObservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a DiscoveredAPIObservation in a given project, location and ApiObservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
   *   String name =
   *       DiscoveredApiObservationName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_API_OBSERVATION]")
   *           .toString();
   *   DiscoveredApiObservation response = apiHubDiscoveryClient.getDiscoveredApiObservation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DiscoveredApiObservation to retrieve. Format:
   *     projects/{project}/locations/{location}/discoveredApiObservations/{discovered_api_observation}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiscoveredApiObservation getDiscoveredApiObservation(String name) {
    GetDiscoveredApiObservationRequest request =
        GetDiscoveredApiObservationRequest.newBuilder().setName(name).build();
    return getDiscoveredApiObservation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a DiscoveredAPIObservation in a given project, location and ApiObservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
   *   GetDiscoveredApiObservationRequest request =
   *       GetDiscoveredApiObservationRequest.newBuilder()
   *           .setName(
   *               DiscoveredApiObservationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DISCOVERED_API_OBSERVATION]")
   *                   .toString())
   *           .build();
   *   DiscoveredApiObservation response =
   *       apiHubDiscoveryClient.getDiscoveredApiObservation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiscoveredApiObservation getDiscoveredApiObservation(
      GetDiscoveredApiObservationRequest request) {
    return getDiscoveredApiObservationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a DiscoveredAPIObservation in a given project, location and ApiObservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
   *   GetDiscoveredApiObservationRequest request =
   *       GetDiscoveredApiObservationRequest.newBuilder()
   *           .setName(
   *               DiscoveredApiObservationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DISCOVERED_API_OBSERVATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DiscoveredApiObservation> future =
   *       apiHubDiscoveryClient.getDiscoveredApiObservationCallable().futureCall(request);
   *   // Do something.
   *   DiscoveredApiObservation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDiscoveredApiObservationRequest, DiscoveredApiObservation>
      getDiscoveredApiObservationCallable() {
    return stub.getDiscoveredApiObservationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the DiscoveredAPIOperations in a given project, location and ApiObservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
   *   DiscoveredApiObservationName parent =
   *       DiscoveredApiObservationName.of(
   *           "[PROJECT]", "[LOCATION]", "[DISCOVERED_API_OBSERVATION]");
   *   for (DiscoveredApiOperation element :
   *       apiHubDiscoveryClient.listDiscoveredApiOperations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of DiscoveredApiOperations.
   *     Format:
   *     projects/{project}/locations/{location}/discoveredApiObservations/{discovered_api_observation}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDiscoveredApiOperationsPagedResponse listDiscoveredApiOperations(
      DiscoveredApiObservationName parent) {
    ListDiscoveredApiOperationsRequest request =
        ListDiscoveredApiOperationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDiscoveredApiOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the DiscoveredAPIOperations in a given project, location and ApiObservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
   *   String parent =
   *       DiscoveredApiObservationName.of("[PROJECT]", "[LOCATION]", "[DISCOVERED_API_OBSERVATION]")
   *           .toString();
   *   for (DiscoveredApiOperation element :
   *       apiHubDiscoveryClient.listDiscoveredApiOperations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of DiscoveredApiOperations.
   *     Format:
   *     projects/{project}/locations/{location}/discoveredApiObservations/{discovered_api_observation}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDiscoveredApiOperationsPagedResponse listDiscoveredApiOperations(String parent) {
    ListDiscoveredApiOperationsRequest request =
        ListDiscoveredApiOperationsRequest.newBuilder().setParent(parent).build();
    return listDiscoveredApiOperations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the DiscoveredAPIOperations in a given project, location and ApiObservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
   *   ListDiscoveredApiOperationsRequest request =
   *       ListDiscoveredApiOperationsRequest.newBuilder()
   *           .setParent(
   *               DiscoveredApiObservationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DISCOVERED_API_OBSERVATION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DiscoveredApiOperation element :
   *       apiHubDiscoveryClient.listDiscoveredApiOperations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDiscoveredApiOperationsPagedResponse listDiscoveredApiOperations(
      ListDiscoveredApiOperationsRequest request) {
    return listDiscoveredApiOperationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the DiscoveredAPIOperations in a given project, location and ApiObservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
   *   ListDiscoveredApiOperationsRequest request =
   *       ListDiscoveredApiOperationsRequest.newBuilder()
   *           .setParent(
   *               DiscoveredApiObservationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DISCOVERED_API_OBSERVATION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DiscoveredApiOperation> future =
   *       apiHubDiscoveryClient.listDiscoveredApiOperationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DiscoveredApiOperation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListDiscoveredApiOperationsRequest, ListDiscoveredApiOperationsPagedResponse>
      listDiscoveredApiOperationsPagedCallable() {
    return stub.listDiscoveredApiOperationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the DiscoveredAPIOperations in a given project, location and ApiObservation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
   *   ListDiscoveredApiOperationsRequest request =
   *       ListDiscoveredApiOperationsRequest.newBuilder()
   *           .setParent(
   *               DiscoveredApiObservationName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DISCOVERED_API_OBSERVATION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDiscoveredApiOperationsResponse response =
   *         apiHubDiscoveryClient.listDiscoveredApiOperationsCallable().call(request);
   *     for (DiscoveredApiOperation element : response.getDiscoveredApiOperationsList()) {
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
  public final UnaryCallable<
          ListDiscoveredApiOperationsRequest, ListDiscoveredApiOperationsResponse>
      listDiscoveredApiOperationsCallable() {
    return stub.listDiscoveredApiOperationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a DiscoveredAPIOperation in a given project, location, ApiObservation and ApiOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
   *   DiscoveredApiOperationName name =
   *       DiscoveredApiOperationName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[DISCOVERED_API_OBSERVATION]",
   *           "[DISCOVERED_API_OPERATION]");
   *   DiscoveredApiOperation response = apiHubDiscoveryClient.getDiscoveredApiOperation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DiscoveredApiOperation to retrieve. Format:
   *     projects/{project}/locations/{location}/discoveredApiObservations/{discovered_api_observation}/discoveredApiOperations/{discovered_api_operation}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiscoveredApiOperation getDiscoveredApiOperation(DiscoveredApiOperationName name) {
    GetDiscoveredApiOperationRequest request =
        GetDiscoveredApiOperationRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDiscoveredApiOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a DiscoveredAPIOperation in a given project, location, ApiObservation and ApiOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
   *   String name =
   *       DiscoveredApiOperationName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[DISCOVERED_API_OBSERVATION]",
   *               "[DISCOVERED_API_OPERATION]")
   *           .toString();
   *   DiscoveredApiOperation response = apiHubDiscoveryClient.getDiscoveredApiOperation(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the DiscoveredApiOperation to retrieve. Format:
   *     projects/{project}/locations/{location}/discoveredApiObservations/{discovered_api_observation}/discoveredApiOperations/{discovered_api_operation}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiscoveredApiOperation getDiscoveredApiOperation(String name) {
    GetDiscoveredApiOperationRequest request =
        GetDiscoveredApiOperationRequest.newBuilder().setName(name).build();
    return getDiscoveredApiOperation(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a DiscoveredAPIOperation in a given project, location, ApiObservation and ApiOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
   *   GetDiscoveredApiOperationRequest request =
   *       GetDiscoveredApiOperationRequest.newBuilder()
   *           .setName(
   *               DiscoveredApiOperationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DISCOVERED_API_OBSERVATION]",
   *                       "[DISCOVERED_API_OPERATION]")
   *                   .toString())
   *           .build();
   *   DiscoveredApiOperation response = apiHubDiscoveryClient.getDiscoveredApiOperation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DiscoveredApiOperation getDiscoveredApiOperation(
      GetDiscoveredApiOperationRequest request) {
    return getDiscoveredApiOperationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a DiscoveredAPIOperation in a given project, location, ApiObservation and ApiOperation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
   *   GetDiscoveredApiOperationRequest request =
   *       GetDiscoveredApiOperationRequest.newBuilder()
   *           .setName(
   *               DiscoveredApiOperationName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DISCOVERED_API_OBSERVATION]",
   *                       "[DISCOVERED_API_OPERATION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DiscoveredApiOperation> future =
   *       apiHubDiscoveryClient.getDiscoveredApiOperationCallable().futureCall(request);
   *   // Do something.
   *   DiscoveredApiOperation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDiscoveredApiOperationRequest, DiscoveredApiOperation>
      getDiscoveredApiOperationCallable() {
    return stub.getDiscoveredApiOperationCallable();
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
   * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : apiHubDiscoveryClient.listLocations(request).iterateAll()) {
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
   * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       apiHubDiscoveryClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         apiHubDiscoveryClient.listLocationsCallable().call(request);
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
   * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = apiHubDiscoveryClient.getLocation(request);
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
   * try (ApiHubDiscoveryClient apiHubDiscoveryClient = ApiHubDiscoveryClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = apiHubDiscoveryClient.getLocationCallable().futureCall(request);
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

  public static class ListDiscoveredApiObservationsPagedResponse
      extends AbstractPagedListResponse<
          ListDiscoveredApiObservationsRequest,
          ListDiscoveredApiObservationsResponse,
          DiscoveredApiObservation,
          ListDiscoveredApiObservationsPage,
          ListDiscoveredApiObservationsFixedSizeCollection> {

    public static ApiFuture<ListDiscoveredApiObservationsPagedResponse> createAsync(
        PageContext<
                ListDiscoveredApiObservationsRequest,
                ListDiscoveredApiObservationsResponse,
                DiscoveredApiObservation>
            context,
        ApiFuture<ListDiscoveredApiObservationsResponse> futureResponse) {
      ApiFuture<ListDiscoveredApiObservationsPage> futurePage =
          ListDiscoveredApiObservationsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDiscoveredApiObservationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDiscoveredApiObservationsPagedResponse(ListDiscoveredApiObservationsPage page) {
      super(page, ListDiscoveredApiObservationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDiscoveredApiObservationsPage
      extends AbstractPage<
          ListDiscoveredApiObservationsRequest,
          ListDiscoveredApiObservationsResponse,
          DiscoveredApiObservation,
          ListDiscoveredApiObservationsPage> {

    private ListDiscoveredApiObservationsPage(
        PageContext<
                ListDiscoveredApiObservationsRequest,
                ListDiscoveredApiObservationsResponse,
                DiscoveredApiObservation>
            context,
        ListDiscoveredApiObservationsResponse response) {
      super(context, response);
    }

    private static ListDiscoveredApiObservationsPage createEmptyPage() {
      return new ListDiscoveredApiObservationsPage(null, null);
    }

    @Override
    protected ListDiscoveredApiObservationsPage createPage(
        PageContext<
                ListDiscoveredApiObservationsRequest,
                ListDiscoveredApiObservationsResponse,
                DiscoveredApiObservation>
            context,
        ListDiscoveredApiObservationsResponse response) {
      return new ListDiscoveredApiObservationsPage(context, response);
    }

    @Override
    public ApiFuture<ListDiscoveredApiObservationsPage> createPageAsync(
        PageContext<
                ListDiscoveredApiObservationsRequest,
                ListDiscoveredApiObservationsResponse,
                DiscoveredApiObservation>
            context,
        ApiFuture<ListDiscoveredApiObservationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDiscoveredApiObservationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDiscoveredApiObservationsRequest,
          ListDiscoveredApiObservationsResponse,
          DiscoveredApiObservation,
          ListDiscoveredApiObservationsPage,
          ListDiscoveredApiObservationsFixedSizeCollection> {

    private ListDiscoveredApiObservationsFixedSizeCollection(
        List<ListDiscoveredApiObservationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDiscoveredApiObservationsFixedSizeCollection createEmptyCollection() {
      return new ListDiscoveredApiObservationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDiscoveredApiObservationsFixedSizeCollection createCollection(
        List<ListDiscoveredApiObservationsPage> pages, int collectionSize) {
      return new ListDiscoveredApiObservationsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDiscoveredApiOperationsPagedResponse
      extends AbstractPagedListResponse<
          ListDiscoveredApiOperationsRequest,
          ListDiscoveredApiOperationsResponse,
          DiscoveredApiOperation,
          ListDiscoveredApiOperationsPage,
          ListDiscoveredApiOperationsFixedSizeCollection> {

    public static ApiFuture<ListDiscoveredApiOperationsPagedResponse> createAsync(
        PageContext<
                ListDiscoveredApiOperationsRequest,
                ListDiscoveredApiOperationsResponse,
                DiscoveredApiOperation>
            context,
        ApiFuture<ListDiscoveredApiOperationsResponse> futureResponse) {
      ApiFuture<ListDiscoveredApiOperationsPage> futurePage =
          ListDiscoveredApiOperationsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDiscoveredApiOperationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDiscoveredApiOperationsPagedResponse(ListDiscoveredApiOperationsPage page) {
      super(page, ListDiscoveredApiOperationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDiscoveredApiOperationsPage
      extends AbstractPage<
          ListDiscoveredApiOperationsRequest,
          ListDiscoveredApiOperationsResponse,
          DiscoveredApiOperation,
          ListDiscoveredApiOperationsPage> {

    private ListDiscoveredApiOperationsPage(
        PageContext<
                ListDiscoveredApiOperationsRequest,
                ListDiscoveredApiOperationsResponse,
                DiscoveredApiOperation>
            context,
        ListDiscoveredApiOperationsResponse response) {
      super(context, response);
    }

    private static ListDiscoveredApiOperationsPage createEmptyPage() {
      return new ListDiscoveredApiOperationsPage(null, null);
    }

    @Override
    protected ListDiscoveredApiOperationsPage createPage(
        PageContext<
                ListDiscoveredApiOperationsRequest,
                ListDiscoveredApiOperationsResponse,
                DiscoveredApiOperation>
            context,
        ListDiscoveredApiOperationsResponse response) {
      return new ListDiscoveredApiOperationsPage(context, response);
    }

    @Override
    public ApiFuture<ListDiscoveredApiOperationsPage> createPageAsync(
        PageContext<
                ListDiscoveredApiOperationsRequest,
                ListDiscoveredApiOperationsResponse,
                DiscoveredApiOperation>
            context,
        ApiFuture<ListDiscoveredApiOperationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDiscoveredApiOperationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDiscoveredApiOperationsRequest,
          ListDiscoveredApiOperationsResponse,
          DiscoveredApiOperation,
          ListDiscoveredApiOperationsPage,
          ListDiscoveredApiOperationsFixedSizeCollection> {

    private ListDiscoveredApiOperationsFixedSizeCollection(
        List<ListDiscoveredApiOperationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDiscoveredApiOperationsFixedSizeCollection createEmptyCollection() {
      return new ListDiscoveredApiOperationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDiscoveredApiOperationsFixedSizeCollection createCollection(
        List<ListDiscoveredApiOperationsPage> pages, int collectionSize) {
      return new ListDiscoveredApiOperationsFixedSizeCollection(pages, collectionSize);
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
