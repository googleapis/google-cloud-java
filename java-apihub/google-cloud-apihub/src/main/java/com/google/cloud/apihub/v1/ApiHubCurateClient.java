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
import com.google.cloud.apihub.v1.stub.ApiHubCurateStub;
import com.google.cloud.apihub.v1.stub.ApiHubCurateStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: This service is used for managing curations for processing API data consumed
 * from collect layer.
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
 * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Curation curation = Curation.newBuilder().build();
 *   String curationId = "curationId1428017328";
 *   Curation response = apiHubCurateClient.createCuration(parent, curation, curationId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ApiHubCurateClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCuration</td>
 *      <td><p> Create a curation resource in the API hub. Once a curation resource is created, plugin instances can start using it.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCuration(CreateCurationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createCuration(LocationName parent, Curation curation, String curationId)
 *           <li><p> createCuration(String parent, Curation curation, String curationId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCurationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCuration</td>
 *      <td><p> Get curation resource details.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCuration(GetCurationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCuration(CurationName name)
 *           <li><p> getCuration(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCurationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCurations</td>
 *      <td><p> List curation resources in the API hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCurations(ListCurationsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCurations(LocationName parent)
 *           <li><p> listCurations(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCurationsPagedCallable()
 *           <li><p> listCurationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCuration</td>
 *      <td><p> Update a curation resource in the API hub. The following fields in the [curation][google.cloud.apihub.v1.Curation] can be updated:
 * <ul>
 * <li>  [display_name][google.cloud.apihub.v1.Curation.display_name]
 * <li>  [description][google.cloud.apihub.v1.Curation.description]
 * </ul>
 * <p>  The [update_mask][google.cloud.apihub.v1.UpdateApiRequest.update_mask] should be used to specify the fields being updated.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCuration(UpdateCurationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateCuration(Curation curation, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCurationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCuration</td>
 *      <td><p> Delete a curation resource in the API hub. A curation can only be deleted if it's not being used by any plugin instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteCuration(DeleteCurationRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteCuration(CurationName name)
 *           <li><p> deleteCuration(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCurationCallable()
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
 * <p>This class can be customized by passing in a custom instance of ApiHubCurateSettings to
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
 * ApiHubCurateSettings apiHubCurateSettings =
 *     ApiHubCurateSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create(apiHubCurateSettings);
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
 * ApiHubCurateSettings apiHubCurateSettings =
 *     ApiHubCurateSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create(apiHubCurateSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ApiHubCurateClient implements BackgroundResource {
  private final ApiHubCurateSettings settings;
  private final ApiHubCurateStub stub;

  /** Constructs an instance of ApiHubCurateClient with default settings. */
  public static final ApiHubCurateClient create() throws IOException {
    return create(ApiHubCurateSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ApiHubCurateClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ApiHubCurateClient create(ApiHubCurateSettings settings) throws IOException {
    return new ApiHubCurateClient(settings);
  }

  /**
   * Constructs an instance of ApiHubCurateClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ApiHubCurateSettings).
   */
  public static final ApiHubCurateClient create(ApiHubCurateStub stub) {
    return new ApiHubCurateClient(stub);
  }

  /**
   * Constructs an instance of ApiHubCurateClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ApiHubCurateClient(ApiHubCurateSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ApiHubCurateStubSettings) settings.getStubSettings()).createStub();
  }

  protected ApiHubCurateClient(ApiHubCurateStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ApiHubCurateSettings getSettings() {
    return settings;
  }

  public ApiHubCurateStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a curation resource in the API hub. Once a curation resource is created, plugin
   * instances can start using it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Curation curation = Curation.newBuilder().build();
   *   String curationId = "curationId1428017328";
   *   Curation response = apiHubCurateClient.createCuration(parent, curation, curationId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for the curation resource. Format:
   *     `projects/{project}/locations/{location}`
   * @param curation Required. The curation resource to create.
   * @param curationId Optional. The ID to use for the curation resource, which will become the
   *     final component of the curations's resource name. This field is optional.
   *     <ul>
   *       <li>If provided, the same will be used. The service will throw an error if the specified
   *           ID is already used by another curation resource in the API hub.
   *       <li>If not provided, a system generated ID will be used.
   *     </ul>
   *     <p>This value should be 4-500 characters, and valid characters are /[a-z][A-Z][0-9]-_/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Curation createCuration(LocationName parent, Curation curation, String curationId) {
    CreateCurationRequest request =
        CreateCurationRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCuration(curation)
            .setCurationId(curationId)
            .build();
    return createCuration(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a curation resource in the API hub. Once a curation resource is created, plugin
   * instances can start using it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Curation curation = Curation.newBuilder().build();
   *   String curationId = "curationId1428017328";
   *   Curation response = apiHubCurateClient.createCuration(parent, curation, curationId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for the curation resource. Format:
   *     `projects/{project}/locations/{location}`
   * @param curation Required. The curation resource to create.
   * @param curationId Optional. The ID to use for the curation resource, which will become the
   *     final component of the curations's resource name. This field is optional.
   *     <ul>
   *       <li>If provided, the same will be used. The service will throw an error if the specified
   *           ID is already used by another curation resource in the API hub.
   *       <li>If not provided, a system generated ID will be used.
   *     </ul>
   *     <p>This value should be 4-500 characters, and valid characters are /[a-z][A-Z][0-9]-_/.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Curation createCuration(String parent, Curation curation, String curationId) {
    CreateCurationRequest request =
        CreateCurationRequest.newBuilder()
            .setParent(parent)
            .setCuration(curation)
            .setCurationId(curationId)
            .build();
    return createCuration(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a curation resource in the API hub. Once a curation resource is created, plugin
   * instances can start using it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   CreateCurationRequest request =
   *       CreateCurationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCurationId("curationId1428017328")
   *           .setCuration(Curation.newBuilder().build())
   *           .build();
   *   Curation response = apiHubCurateClient.createCuration(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Curation createCuration(CreateCurationRequest request) {
    return createCurationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a curation resource in the API hub. Once a curation resource is created, plugin
   * instances can start using it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   CreateCurationRequest request =
   *       CreateCurationRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCurationId("curationId1428017328")
   *           .setCuration(Curation.newBuilder().build())
   *           .build();
   *   ApiFuture<Curation> future = apiHubCurateClient.createCurationCallable().futureCall(request);
   *   // Do something.
   *   Curation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCurationRequest, Curation> createCurationCallable() {
    return stub.createCurationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get curation resource details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   CurationName name = CurationName.of("[PROJECT]", "[LOCATION]", "[CURATION]");
   *   Curation response = apiHubCurateClient.getCuration(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the curation resource to retrieve. Format:
   *     `projects/{project}/locations/{location}/curations/{curation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Curation getCuration(CurationName name) {
    GetCurationRequest request =
        GetCurationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCuration(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get curation resource details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   String name = CurationName.of("[PROJECT]", "[LOCATION]", "[CURATION]").toString();
   *   Curation response = apiHubCurateClient.getCuration(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the curation resource to retrieve. Format:
   *     `projects/{project}/locations/{location}/curations/{curation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Curation getCuration(String name) {
    GetCurationRequest request = GetCurationRequest.newBuilder().setName(name).build();
    return getCuration(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get curation resource details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   GetCurationRequest request =
   *       GetCurationRequest.newBuilder()
   *           .setName(CurationName.of("[PROJECT]", "[LOCATION]", "[CURATION]").toString())
   *           .build();
   *   Curation response = apiHubCurateClient.getCuration(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Curation getCuration(GetCurationRequest request) {
    return getCurationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get curation resource details.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   GetCurationRequest request =
   *       GetCurationRequest.newBuilder()
   *           .setName(CurationName.of("[PROJECT]", "[LOCATION]", "[CURATION]").toString())
   *           .build();
   *   ApiFuture<Curation> future = apiHubCurateClient.getCurationCallable().futureCall(request);
   *   // Do something.
   *   Curation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCurationRequest, Curation> getCurationCallable() {
    return stub.getCurationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List curation resources in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Curation element : apiHubCurateClient.listCurations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of curation resources. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCurationsPagedResponse listCurations(LocationName parent) {
    ListCurationsRequest request =
        ListCurationsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCurations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List curation resources in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Curation element : apiHubCurateClient.listCurations(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of curation resources. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCurationsPagedResponse listCurations(String parent) {
    ListCurationsRequest request = ListCurationsRequest.newBuilder().setParent(parent).build();
    return listCurations(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List curation resources in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   ListCurationsRequest request =
   *       ListCurationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Curation element : apiHubCurateClient.listCurations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCurationsPagedResponse listCurations(ListCurationsRequest request) {
    return listCurationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List curation resources in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   ListCurationsRequest request =
   *       ListCurationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Curation> future =
   *       apiHubCurateClient.listCurationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Curation element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCurationsRequest, ListCurationsPagedResponse>
      listCurationsPagedCallable() {
    return stub.listCurationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List curation resources in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   ListCurationsRequest request =
   *       ListCurationsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListCurationsResponse response = apiHubCurateClient.listCurationsCallable().call(request);
   *     for (Curation element : response.getCurationsList()) {
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
  public final UnaryCallable<ListCurationsRequest, ListCurationsResponse> listCurationsCallable() {
    return stub.listCurationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a curation resource in the API hub. The following fields in the
   * [curation][google.cloud.apihub.v1.Curation] can be updated:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.Curation.display_name]
   *   <li>[description][google.cloud.apihub.v1.Curation.description]
   * </ul>
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdateApiRequest.update_mask] should be used to
   * specify the fields being updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   Curation curation = Curation.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Curation response = apiHubCurateClient.updateCuration(curation, updateMask);
   * }
   * }</pre>
   *
   * @param curation Required. The curation resource to update.
   *     <p>The curation resource's `name` field is used to identify the curation resource to
   *     update. Format: `projects/{project}/locations/{location}/curations/{curation}`
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Curation updateCuration(Curation curation, FieldMask updateMask) {
    UpdateCurationRequest request =
        UpdateCurationRequest.newBuilder().setCuration(curation).setUpdateMask(updateMask).build();
    return updateCuration(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a curation resource in the API hub. The following fields in the
   * [curation][google.cloud.apihub.v1.Curation] can be updated:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.Curation.display_name]
   *   <li>[description][google.cloud.apihub.v1.Curation.description]
   * </ul>
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdateApiRequest.update_mask] should be used to
   * specify the fields being updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   UpdateCurationRequest request =
   *       UpdateCurationRequest.newBuilder()
   *           .setCuration(Curation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Curation response = apiHubCurateClient.updateCuration(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Curation updateCuration(UpdateCurationRequest request) {
    return updateCurationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a curation resource in the API hub. The following fields in the
   * [curation][google.cloud.apihub.v1.Curation] can be updated:
   *
   * <ul>
   *   <li>[display_name][google.cloud.apihub.v1.Curation.display_name]
   *   <li>[description][google.cloud.apihub.v1.Curation.description]
   * </ul>
   *
   * <p>The [update_mask][google.cloud.apihub.v1.UpdateApiRequest.update_mask] should be used to
   * specify the fields being updated.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   UpdateCurationRequest request =
   *       UpdateCurationRequest.newBuilder()
   *           .setCuration(Curation.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Curation> future = apiHubCurateClient.updateCurationCallable().futureCall(request);
   *   // Do something.
   *   Curation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCurationRequest, Curation> updateCurationCallable() {
    return stub.updateCurationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a curation resource in the API hub. A curation can only be deleted if it's not being
   * used by any plugin instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   CurationName name = CurationName.of("[PROJECT]", "[LOCATION]", "[CURATION]");
   *   apiHubCurateClient.deleteCuration(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the curation resource to delete. Format:
   *     `projects/{project}/locations/{location}/curations/{curation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCuration(CurationName name) {
    DeleteCurationRequest request =
        DeleteCurationRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteCuration(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a curation resource in the API hub. A curation can only be deleted if it's not being
   * used by any plugin instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   String name = CurationName.of("[PROJECT]", "[LOCATION]", "[CURATION]").toString();
   *   apiHubCurateClient.deleteCuration(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the curation resource to delete. Format:
   *     `projects/{project}/locations/{location}/curations/{curation}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCuration(String name) {
    DeleteCurationRequest request = DeleteCurationRequest.newBuilder().setName(name).build();
    deleteCuration(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a curation resource in the API hub. A curation can only be deleted if it's not being
   * used by any plugin instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   DeleteCurationRequest request =
   *       DeleteCurationRequest.newBuilder()
   *           .setName(CurationName.of("[PROJECT]", "[LOCATION]", "[CURATION]").toString())
   *           .build();
   *   apiHubCurateClient.deleteCuration(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCuration(DeleteCurationRequest request) {
    deleteCurationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a curation resource in the API hub. A curation can only be deleted if it's not being
   * used by any plugin instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   DeleteCurationRequest request =
   *       DeleteCurationRequest.newBuilder()
   *           .setName(CurationName.of("[PROJECT]", "[LOCATION]", "[CURATION]").toString())
   *           .build();
   *   ApiFuture<Empty> future = apiHubCurateClient.deleteCurationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCurationRequest, Empty> deleteCurationCallable() {
    return stub.deleteCurationCallable();
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
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : apiHubCurateClient.listLocations(request).iterateAll()) {
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
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       apiHubCurateClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = apiHubCurateClient.listLocationsCallable().call(request);
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
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = apiHubCurateClient.getLocation(request);
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
   * try (ApiHubCurateClient apiHubCurateClient = ApiHubCurateClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = apiHubCurateClient.getLocationCallable().futureCall(request);
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

  public static class ListCurationsPagedResponse
      extends AbstractPagedListResponse<
          ListCurationsRequest,
          ListCurationsResponse,
          Curation,
          ListCurationsPage,
          ListCurationsFixedSizeCollection> {

    public static ApiFuture<ListCurationsPagedResponse> createAsync(
        PageContext<ListCurationsRequest, ListCurationsResponse, Curation> context,
        ApiFuture<ListCurationsResponse> futureResponse) {
      ApiFuture<ListCurationsPage> futurePage =
          ListCurationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCurationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCurationsPagedResponse(ListCurationsPage page) {
      super(page, ListCurationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCurationsPage
      extends AbstractPage<
          ListCurationsRequest, ListCurationsResponse, Curation, ListCurationsPage> {

    private ListCurationsPage(
        PageContext<ListCurationsRequest, ListCurationsResponse, Curation> context,
        ListCurationsResponse response) {
      super(context, response);
    }

    private static ListCurationsPage createEmptyPage() {
      return new ListCurationsPage(null, null);
    }

    @Override
    protected ListCurationsPage createPage(
        PageContext<ListCurationsRequest, ListCurationsResponse, Curation> context,
        ListCurationsResponse response) {
      return new ListCurationsPage(context, response);
    }

    @Override
    public ApiFuture<ListCurationsPage> createPageAsync(
        PageContext<ListCurationsRequest, ListCurationsResponse, Curation> context,
        ApiFuture<ListCurationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCurationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCurationsRequest,
          ListCurationsResponse,
          Curation,
          ListCurationsPage,
          ListCurationsFixedSizeCollection> {

    private ListCurationsFixedSizeCollection(List<ListCurationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCurationsFixedSizeCollection createEmptyCollection() {
      return new ListCurationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCurationsFixedSizeCollection createCollection(
        List<ListCurationsPage> pages, int collectionSize) {
      return new ListCurationsFixedSizeCollection(pages, collectionSize);
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
