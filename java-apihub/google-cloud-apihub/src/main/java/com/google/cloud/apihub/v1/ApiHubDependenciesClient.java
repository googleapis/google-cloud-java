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
import com.google.cloud.apihub.v1.stub.ApiHubDependenciesStub;
import com.google.cloud.apihub.v1.stub.ApiHubDependenciesStubSettings;
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
 * Service Description: This service provides methods for various operations related to a
 * [Dependency][google.cloud.apihub.v1.Dependency] in the API hub.
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
 * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Dependency dependency = Dependency.newBuilder().build();
 *   String dependencyId = "dependencyId503788998";
 *   Dependency response =
 *       apiHubDependenciesClient.createDependency(parent, dependency, dependencyId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ApiHubDependenciesClient object to clean up resources
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
 *      <td><p> CreateDependency</td>
 *      <td><p> Create a dependency between two entities in the API hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDependency(CreateDependencyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createDependency(LocationName parent, Dependency dependency, String dependencyId)
 *           <li><p> createDependency(String parent, Dependency dependency, String dependencyId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDependencyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDependency</td>
 *      <td><p> Get details about a dependency resource in the API hub.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDependency(GetDependencyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDependency(DependencyName name)
 *           <li><p> getDependency(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDependencyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDependency</td>
 *      <td><p> Update a dependency based on the [update_mask][google.cloud.apihub.v1.UpdateDependencyRequest.update_mask] provided in the request.
 * <p>  The following fields in the [dependency][google.cloud.apihub.v1.Dependency] can be updated:
 * <ul>
 * <li>  [description][google.cloud.apihub.v1.Dependency.description]
 * </ul></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDependency(UpdateDependencyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDependency(Dependency dependency, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDependencyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDependency</td>
 *      <td><p> Delete the dependency resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDependency(DeleteDependencyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteDependency(DependencyName name)
 *           <li><p> deleteDependency(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDependencyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDependencies</td>
 *      <td><p> List dependencies based on the provided filter and pagination parameters.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDependencies(ListDependenciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDependencies(LocationName parent)
 *           <li><p> listDependencies(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDependenciesPagedCallable()
 *           <li><p> listDependenciesCallable()
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
 * <p>This class can be customized by passing in a custom instance of ApiHubDependenciesSettings to
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
 * ApiHubDependenciesSettings apiHubDependenciesSettings =
 *     ApiHubDependenciesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ApiHubDependenciesClient apiHubDependenciesClient =
 *     ApiHubDependenciesClient.create(apiHubDependenciesSettings);
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
 * ApiHubDependenciesSettings apiHubDependenciesSettings =
 *     ApiHubDependenciesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ApiHubDependenciesClient apiHubDependenciesClient =
 *     ApiHubDependenciesClient.create(apiHubDependenciesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ApiHubDependenciesClient implements BackgroundResource {
  private final ApiHubDependenciesSettings settings;
  private final ApiHubDependenciesStub stub;

  /** Constructs an instance of ApiHubDependenciesClient with default settings. */
  public static final ApiHubDependenciesClient create() throws IOException {
    return create(ApiHubDependenciesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ApiHubDependenciesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ApiHubDependenciesClient create(ApiHubDependenciesSettings settings)
      throws IOException {
    return new ApiHubDependenciesClient(settings);
  }

  /**
   * Constructs an instance of ApiHubDependenciesClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(ApiHubDependenciesSettings).
   */
  public static final ApiHubDependenciesClient create(ApiHubDependenciesStub stub) {
    return new ApiHubDependenciesClient(stub);
  }

  /**
   * Constructs an instance of ApiHubDependenciesClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ApiHubDependenciesClient(ApiHubDependenciesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ApiHubDependenciesStubSettings) settings.getStubSettings()).createStub();
  }

  protected ApiHubDependenciesClient(ApiHubDependenciesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ApiHubDependenciesSettings getSettings() {
    return settings;
  }

  public ApiHubDependenciesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a dependency between two entities in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Dependency dependency = Dependency.newBuilder().build();
   *   String dependencyId = "dependencyId503788998";
   *   Dependency response =
   *       apiHubDependenciesClient.createDependency(parent, dependency, dependencyId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for the dependency resource. Format:
   *     `projects/{project}/locations/{location}`
   * @param dependency Required. The dependency resource to create.
   * @param dependencyId Optional. The ID to use for the dependency resource, which will become the
   *     final component of the dependency's resource name. This field is optional.
   *     <ul>
   *       <li>If provided, the same will be used. The service will throw an error if duplicate id
   *           is provided by the client.
   *       <li>If not provided, a system generated id will be used.
   *     </ul>
   *     <p>This value should be 4-500 characters, and valid characters are `[a-z][A-Z][0-9]-_`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dependency createDependency(
      LocationName parent, Dependency dependency, String dependencyId) {
    CreateDependencyRequest request =
        CreateDependencyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDependency(dependency)
            .setDependencyId(dependencyId)
            .build();
    return createDependency(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a dependency between two entities in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Dependency dependency = Dependency.newBuilder().build();
   *   String dependencyId = "dependencyId503788998";
   *   Dependency response =
   *       apiHubDependenciesClient.createDependency(parent, dependency, dependencyId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for the dependency resource. Format:
   *     `projects/{project}/locations/{location}`
   * @param dependency Required. The dependency resource to create.
   * @param dependencyId Optional. The ID to use for the dependency resource, which will become the
   *     final component of the dependency's resource name. This field is optional.
   *     <ul>
   *       <li>If provided, the same will be used. The service will throw an error if duplicate id
   *           is provided by the client.
   *       <li>If not provided, a system generated id will be used.
   *     </ul>
   *     <p>This value should be 4-500 characters, and valid characters are `[a-z][A-Z][0-9]-_`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dependency createDependency(
      String parent, Dependency dependency, String dependencyId) {
    CreateDependencyRequest request =
        CreateDependencyRequest.newBuilder()
            .setParent(parent)
            .setDependency(dependency)
            .setDependencyId(dependencyId)
            .build();
    return createDependency(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a dependency between two entities in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   CreateDependencyRequest request =
   *       CreateDependencyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDependencyId("dependencyId503788998")
   *           .setDependency(Dependency.newBuilder().build())
   *           .build();
   *   Dependency response = apiHubDependenciesClient.createDependency(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dependency createDependency(CreateDependencyRequest request) {
    return createDependencyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a dependency between two entities in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   CreateDependencyRequest request =
   *       CreateDependencyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDependencyId("dependencyId503788998")
   *           .setDependency(Dependency.newBuilder().build())
   *           .build();
   *   ApiFuture<Dependency> future =
   *       apiHubDependenciesClient.createDependencyCallable().futureCall(request);
   *   // Do something.
   *   Dependency response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDependencyRequest, Dependency> createDependencyCallable() {
    return stub.createDependencyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a dependency resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   DependencyName name = DependencyName.of("[PROJECT]", "[LOCATION]", "[DEPENDENCY]");
   *   Dependency response = apiHubDependenciesClient.getDependency(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the dependency resource to retrieve. Format:
   *     `projects/{project}/locations/{location}/dependencies/{dependency}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dependency getDependency(DependencyName name) {
    GetDependencyRequest request =
        GetDependencyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDependency(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a dependency resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   String name = DependencyName.of("[PROJECT]", "[LOCATION]", "[DEPENDENCY]").toString();
   *   Dependency response = apiHubDependenciesClient.getDependency(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the dependency resource to retrieve. Format:
   *     `projects/{project}/locations/{location}/dependencies/{dependency}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dependency getDependency(String name) {
    GetDependencyRequest request = GetDependencyRequest.newBuilder().setName(name).build();
    return getDependency(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a dependency resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   GetDependencyRequest request =
   *       GetDependencyRequest.newBuilder()
   *           .setName(DependencyName.of("[PROJECT]", "[LOCATION]", "[DEPENDENCY]").toString())
   *           .build();
   *   Dependency response = apiHubDependenciesClient.getDependency(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dependency getDependency(GetDependencyRequest request) {
    return getDependencyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get details about a dependency resource in the API hub.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   GetDependencyRequest request =
   *       GetDependencyRequest.newBuilder()
   *           .setName(DependencyName.of("[PROJECT]", "[LOCATION]", "[DEPENDENCY]").toString())
   *           .build();
   *   ApiFuture<Dependency> future =
   *       apiHubDependenciesClient.getDependencyCallable().futureCall(request);
   *   // Do something.
   *   Dependency response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDependencyRequest, Dependency> getDependencyCallable() {
    return stub.getDependencyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a dependency based on the
   * [update_mask][google.cloud.apihub.v1.UpdateDependencyRequest.update_mask] provided in the
   * request.
   *
   * <p>The following fields in the [dependency][google.cloud.apihub.v1.Dependency] can be updated:
   *
   * <ul>
   *   <li>[description][google.cloud.apihub.v1.Dependency.description]
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   Dependency dependency = Dependency.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Dependency response = apiHubDependenciesClient.updateDependency(dependency, updateMask);
   * }
   * }</pre>
   *
   * @param dependency Required. The dependency resource to update.
   *     <p>The dependency's `name` field is used to identify the dependency to update. Format:
   *     `projects/{project}/locations/{location}/dependencies/{dependency}`
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dependency updateDependency(Dependency dependency, FieldMask updateMask) {
    UpdateDependencyRequest request =
        UpdateDependencyRequest.newBuilder()
            .setDependency(dependency)
            .setUpdateMask(updateMask)
            .build();
    return updateDependency(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a dependency based on the
   * [update_mask][google.cloud.apihub.v1.UpdateDependencyRequest.update_mask] provided in the
   * request.
   *
   * <p>The following fields in the [dependency][google.cloud.apihub.v1.Dependency] can be updated:
   *
   * <ul>
   *   <li>[description][google.cloud.apihub.v1.Dependency.description]
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   UpdateDependencyRequest request =
   *       UpdateDependencyRequest.newBuilder()
   *           .setDependency(Dependency.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Dependency response = apiHubDependenciesClient.updateDependency(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Dependency updateDependency(UpdateDependencyRequest request) {
    return updateDependencyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a dependency based on the
   * [update_mask][google.cloud.apihub.v1.UpdateDependencyRequest.update_mask] provided in the
   * request.
   *
   * <p>The following fields in the [dependency][google.cloud.apihub.v1.Dependency] can be updated:
   *
   * <ul>
   *   <li>[description][google.cloud.apihub.v1.Dependency.description]
   * </ul>
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   UpdateDependencyRequest request =
   *       UpdateDependencyRequest.newBuilder()
   *           .setDependency(Dependency.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Dependency> future =
   *       apiHubDependenciesClient.updateDependencyCallable().futureCall(request);
   *   // Do something.
   *   Dependency response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDependencyRequest, Dependency> updateDependencyCallable() {
    return stub.updateDependencyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the dependency resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   DependencyName name = DependencyName.of("[PROJECT]", "[LOCATION]", "[DEPENDENCY]");
   *   apiHubDependenciesClient.deleteDependency(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the dependency resource to delete. Format:
   *     `projects/{project}/locations/{location}/dependencies/{dependency}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDependency(DependencyName name) {
    DeleteDependencyRequest request =
        DeleteDependencyRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteDependency(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the dependency resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   String name = DependencyName.of("[PROJECT]", "[LOCATION]", "[DEPENDENCY]").toString();
   *   apiHubDependenciesClient.deleteDependency(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the dependency resource to delete. Format:
   *     `projects/{project}/locations/{location}/dependencies/{dependency}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDependency(String name) {
    DeleteDependencyRequest request = DeleteDependencyRequest.newBuilder().setName(name).build();
    deleteDependency(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the dependency resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   DeleteDependencyRequest request =
   *       DeleteDependencyRequest.newBuilder()
   *           .setName(DependencyName.of("[PROJECT]", "[LOCATION]", "[DEPENDENCY]").toString())
   *           .build();
   *   apiHubDependenciesClient.deleteDependency(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDependency(DeleteDependencyRequest request) {
    deleteDependencyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete the dependency resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   DeleteDependencyRequest request =
   *       DeleteDependencyRequest.newBuilder()
   *           .setName(DependencyName.of("[PROJECT]", "[LOCATION]", "[DEPENDENCY]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       apiHubDependenciesClient.deleteDependencyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDependencyRequest, Empty> deleteDependencyCallable() {
    return stub.deleteDependencyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List dependencies based on the provided filter and pagination parameters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Dependency element : apiHubDependenciesClient.listDependencies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent which owns this collection of dependency resources. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDependenciesPagedResponse listDependencies(LocationName parent) {
    ListDependenciesRequest request =
        ListDependenciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDependencies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List dependencies based on the provided filter and pagination parameters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Dependency element : apiHubDependenciesClient.listDependencies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent which owns this collection of dependency resources. Format:
   *     `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDependenciesPagedResponse listDependencies(String parent) {
    ListDependenciesRequest request =
        ListDependenciesRequest.newBuilder().setParent(parent).build();
    return listDependencies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List dependencies based on the provided filter and pagination parameters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   ListDependenciesRequest request =
   *       ListDependenciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Dependency element : apiHubDependenciesClient.listDependencies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDependenciesPagedResponse listDependencies(ListDependenciesRequest request) {
    return listDependenciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List dependencies based on the provided filter and pagination parameters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   ListDependenciesRequest request =
   *       ListDependenciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Dependency> future =
   *       apiHubDependenciesClient.listDependenciesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Dependency element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDependenciesRequest, ListDependenciesPagedResponse>
      listDependenciesPagedCallable() {
    return stub.listDependenciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List dependencies based on the provided filter and pagination parameters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   ListDependenciesRequest request =
   *       ListDependenciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDependenciesResponse response =
   *         apiHubDependenciesClient.listDependenciesCallable().call(request);
   *     for (Dependency element : response.getDependenciesList()) {
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
  public final UnaryCallable<ListDependenciesRequest, ListDependenciesResponse>
      listDependenciesCallable() {
    return stub.listDependenciesCallable();
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
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : apiHubDependenciesClient.listLocations(request).iterateAll()) {
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
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       apiHubDependenciesClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         apiHubDependenciesClient.listLocationsCallable().call(request);
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
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = apiHubDependenciesClient.getLocation(request);
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
   * try (ApiHubDependenciesClient apiHubDependenciesClient = ApiHubDependenciesClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       apiHubDependenciesClient.getLocationCallable().futureCall(request);
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

  public static class ListDependenciesPagedResponse
      extends AbstractPagedListResponse<
          ListDependenciesRequest,
          ListDependenciesResponse,
          Dependency,
          ListDependenciesPage,
          ListDependenciesFixedSizeCollection> {

    public static ApiFuture<ListDependenciesPagedResponse> createAsync(
        PageContext<ListDependenciesRequest, ListDependenciesResponse, Dependency> context,
        ApiFuture<ListDependenciesResponse> futureResponse) {
      ApiFuture<ListDependenciesPage> futurePage =
          ListDependenciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDependenciesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDependenciesPagedResponse(ListDependenciesPage page) {
      super(page, ListDependenciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDependenciesPage
      extends AbstractPage<
          ListDependenciesRequest, ListDependenciesResponse, Dependency, ListDependenciesPage> {

    private ListDependenciesPage(
        PageContext<ListDependenciesRequest, ListDependenciesResponse, Dependency> context,
        ListDependenciesResponse response) {
      super(context, response);
    }

    private static ListDependenciesPage createEmptyPage() {
      return new ListDependenciesPage(null, null);
    }

    @Override
    protected ListDependenciesPage createPage(
        PageContext<ListDependenciesRequest, ListDependenciesResponse, Dependency> context,
        ListDependenciesResponse response) {
      return new ListDependenciesPage(context, response);
    }

    @Override
    public ApiFuture<ListDependenciesPage> createPageAsync(
        PageContext<ListDependenciesRequest, ListDependenciesResponse, Dependency> context,
        ApiFuture<ListDependenciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDependenciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDependenciesRequest,
          ListDependenciesResponse,
          Dependency,
          ListDependenciesPage,
          ListDependenciesFixedSizeCollection> {

    private ListDependenciesFixedSizeCollection(
        List<ListDependenciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDependenciesFixedSizeCollection createEmptyCollection() {
      return new ListDependenciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDependenciesFixedSizeCollection createCollection(
        List<ListDependenciesPage> pages, int collectionSize) {
      return new ListDependenciesFixedSizeCollection(pages, collectionSize);
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
