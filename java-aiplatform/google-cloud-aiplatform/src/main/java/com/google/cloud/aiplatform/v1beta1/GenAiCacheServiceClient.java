/*
 * Copyright 2024 Google LLC
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
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.stub.GenAiCacheServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.GenAiCacheServiceStubSettings;
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
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing Vertex AI's CachedContent resource.
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
 * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   CachedContent cachedContent = CachedContent.newBuilder().build();
 *   CachedContent response = genAiCacheServiceClient.createCachedContent(parent, cachedContent);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GenAiCacheServiceClient object to clean up resources
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
 *      <td><p> CreateCachedContent</td>
 *      <td><p> Creates cached content, this call will initialize the cached content in the data storage, and users need to pay for the cache data storage.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCachedContent(CreateCachedContentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createCachedContent(LocationName parent, CachedContent cachedContent)
 *           <li><p> createCachedContent(String parent, CachedContent cachedContent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCachedContentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCachedContent</td>
 *      <td><p> Gets cached content configurations</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCachedContent(GetCachedContentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCachedContent(CachedContentName name)
 *           <li><p> getCachedContent(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCachedContentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateCachedContent</td>
 *      <td><p> Updates cached content configurations</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateCachedContent(UpdateCachedContentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateCachedContent(CachedContent cachedContent, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateCachedContentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCachedContent</td>
 *      <td><p> Deletes cached content</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteCachedContent(DeleteCachedContentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteCachedContent(CachedContentName name)
 *           <li><p> deleteCachedContent(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCachedContentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCachedContents</td>
 *      <td><p> Lists cached contents in a project</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCachedContents(ListCachedContentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCachedContents(LocationName parent)
 *           <li><p> listCachedContents(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCachedContentsPagedCallable()
 *           <li><p> listCachedContentsCallable()
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
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified resource. Replacesany existing policy.
 * <p> Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`errors.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a resource. Returns an empty policyif the resource exists and does not have a policy set.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified resource. If theresource does not exist, this will return an empty set ofpermissions, not a `NOT_FOUND` error.
 * <p> Note: This operation is designed to be used for buildingpermission-aware UIs and command-line tools, not for authorizationchecking. This operation may "fail open" without warning.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
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
 * <p>This class can be customized by passing in a custom instance of GenAiCacheServiceSettings to
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
 * GenAiCacheServiceSettings genAiCacheServiceSettings =
 *     GenAiCacheServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GenAiCacheServiceClient genAiCacheServiceClient =
 *     GenAiCacheServiceClient.create(genAiCacheServiceSettings);
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
 * GenAiCacheServiceSettings genAiCacheServiceSettings =
 *     GenAiCacheServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GenAiCacheServiceClient genAiCacheServiceClient =
 *     GenAiCacheServiceClient.create(genAiCacheServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class GenAiCacheServiceClient implements BackgroundResource {
  private final GenAiCacheServiceSettings settings;
  private final GenAiCacheServiceStub stub;

  /** Constructs an instance of GenAiCacheServiceClient with default settings. */
  public static final GenAiCacheServiceClient create() throws IOException {
    return create(GenAiCacheServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GenAiCacheServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final GenAiCacheServiceClient create(GenAiCacheServiceSettings settings)
      throws IOException {
    return new GenAiCacheServiceClient(settings);
  }

  /**
   * Constructs an instance of GenAiCacheServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(GenAiCacheServiceSettings).
   */
  public static final GenAiCacheServiceClient create(GenAiCacheServiceStub stub) {
    return new GenAiCacheServiceClient(stub);
  }

  /**
   * Constructs an instance of GenAiCacheServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected GenAiCacheServiceClient(GenAiCacheServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((GenAiCacheServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected GenAiCacheServiceClient(GenAiCacheServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GenAiCacheServiceSettings getSettings() {
    return settings;
  }

  public GenAiCacheServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates cached content, this call will initialize the cached content in the data storage, and
   * users need to pay for the cache data storage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   CachedContent cachedContent = CachedContent.newBuilder().build();
   *   CachedContent response = genAiCacheServiceClient.createCachedContent(parent, cachedContent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where the cached content will be created
   * @param cachedContent Required. The cached content to create
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CachedContent createCachedContent(LocationName parent, CachedContent cachedContent) {
    CreateCachedContentRequest request =
        CreateCachedContentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCachedContent(cachedContent)
            .build();
    return createCachedContent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates cached content, this call will initialize the cached content in the data storage, and
   * users need to pay for the cache data storage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   CachedContent cachedContent = CachedContent.newBuilder().build();
   *   CachedContent response = genAiCacheServiceClient.createCachedContent(parent, cachedContent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where the cached content will be created
   * @param cachedContent Required. The cached content to create
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CachedContent createCachedContent(String parent, CachedContent cachedContent) {
    CreateCachedContentRequest request =
        CreateCachedContentRequest.newBuilder()
            .setParent(parent)
            .setCachedContent(cachedContent)
            .build();
    return createCachedContent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates cached content, this call will initialize the cached content in the data storage, and
   * users need to pay for the cache data storage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   CreateCachedContentRequest request =
   *       CreateCachedContentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCachedContent(CachedContent.newBuilder().build())
   *           .build();
   *   CachedContent response = genAiCacheServiceClient.createCachedContent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CachedContent createCachedContent(CreateCachedContentRequest request) {
    return createCachedContentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates cached content, this call will initialize the cached content in the data storage, and
   * users need to pay for the cache data storage.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   CreateCachedContentRequest request =
   *       CreateCachedContentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCachedContent(CachedContent.newBuilder().build())
   *           .build();
   *   ApiFuture<CachedContent> future =
   *       genAiCacheServiceClient.createCachedContentCallable().futureCall(request);
   *   // Do something.
   *   CachedContent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCachedContentRequest, CachedContent>
      createCachedContentCallable() {
    return stub.createCachedContentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets cached content configurations
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   CachedContentName name = CachedContentName.of("[PROJECT]", "[LOCATION]", "[CACHED_CONTENT]");
   *   CachedContent response = genAiCacheServiceClient.getCachedContent(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name referring to the cached content
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CachedContent getCachedContent(CachedContentName name) {
    GetCachedContentRequest request =
        GetCachedContentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCachedContent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets cached content configurations
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   String name = CachedContentName.of("[PROJECT]", "[LOCATION]", "[CACHED_CONTENT]").toString();
   *   CachedContent response = genAiCacheServiceClient.getCachedContent(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name referring to the cached content
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CachedContent getCachedContent(String name) {
    GetCachedContentRequest request = GetCachedContentRequest.newBuilder().setName(name).build();
    return getCachedContent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets cached content configurations
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   GetCachedContentRequest request =
   *       GetCachedContentRequest.newBuilder()
   *           .setName(
   *               CachedContentName.of("[PROJECT]", "[LOCATION]", "[CACHED_CONTENT]").toString())
   *           .build();
   *   CachedContent response = genAiCacheServiceClient.getCachedContent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CachedContent getCachedContent(GetCachedContentRequest request) {
    return getCachedContentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets cached content configurations
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   GetCachedContentRequest request =
   *       GetCachedContentRequest.newBuilder()
   *           .setName(
   *               CachedContentName.of("[PROJECT]", "[LOCATION]", "[CACHED_CONTENT]").toString())
   *           .build();
   *   ApiFuture<CachedContent> future =
   *       genAiCacheServiceClient.getCachedContentCallable().futureCall(request);
   *   // Do something.
   *   CachedContent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCachedContentRequest, CachedContent> getCachedContentCallable() {
    return stub.getCachedContentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates cached content configurations
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   CachedContent cachedContent = CachedContent.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   CachedContent response =
   *       genAiCacheServiceClient.updateCachedContent(cachedContent, updateMask);
   * }
   * }</pre>
   *
   * @param cachedContent Required. The cached content to update
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CachedContent updateCachedContent(
      CachedContent cachedContent, FieldMask updateMask) {
    UpdateCachedContentRequest request =
        UpdateCachedContentRequest.newBuilder()
            .setCachedContent(cachedContent)
            .setUpdateMask(updateMask)
            .build();
    return updateCachedContent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates cached content configurations
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   UpdateCachedContentRequest request =
   *       UpdateCachedContentRequest.newBuilder()
   *           .setCachedContent(CachedContent.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   CachedContent response = genAiCacheServiceClient.updateCachedContent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CachedContent updateCachedContent(UpdateCachedContentRequest request) {
    return updateCachedContentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates cached content configurations
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   UpdateCachedContentRequest request =
   *       UpdateCachedContentRequest.newBuilder()
   *           .setCachedContent(CachedContent.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<CachedContent> future =
   *       genAiCacheServiceClient.updateCachedContentCallable().futureCall(request);
   *   // Do something.
   *   CachedContent response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateCachedContentRequest, CachedContent>
      updateCachedContentCallable() {
    return stub.updateCachedContentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes cached content
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   CachedContentName name = CachedContentName.of("[PROJECT]", "[LOCATION]", "[CACHED_CONTENT]");
   *   genAiCacheServiceClient.deleteCachedContent(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name referring to the cached content
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCachedContent(CachedContentName name) {
    DeleteCachedContentRequest request =
        DeleteCachedContentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteCachedContent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes cached content
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   String name = CachedContentName.of("[PROJECT]", "[LOCATION]", "[CACHED_CONTENT]").toString();
   *   genAiCacheServiceClient.deleteCachedContent(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name referring to the cached content
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCachedContent(String name) {
    DeleteCachedContentRequest request =
        DeleteCachedContentRequest.newBuilder().setName(name).build();
    deleteCachedContent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes cached content
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   DeleteCachedContentRequest request =
   *       DeleteCachedContentRequest.newBuilder()
   *           .setName(
   *               CachedContentName.of("[PROJECT]", "[LOCATION]", "[CACHED_CONTENT]").toString())
   *           .build();
   *   genAiCacheServiceClient.deleteCachedContent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCachedContent(DeleteCachedContentRequest request) {
    deleteCachedContentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes cached content
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   DeleteCachedContentRequest request =
   *       DeleteCachedContentRequest.newBuilder()
   *           .setName(
   *               CachedContentName.of("[PROJECT]", "[LOCATION]", "[CACHED_CONTENT]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       genAiCacheServiceClient.deleteCachedContentCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCachedContentRequest, Empty> deleteCachedContentCallable() {
    return stub.deleteCachedContentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists cached contents in a project
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (CachedContent element :
   *       genAiCacheServiceClient.listCachedContents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of cached contents.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCachedContentsPagedResponse listCachedContents(LocationName parent) {
    ListCachedContentsRequest request =
        ListCachedContentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCachedContents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists cached contents in a project
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (CachedContent element :
   *       genAiCacheServiceClient.listCachedContents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of cached contents.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCachedContentsPagedResponse listCachedContents(String parent) {
    ListCachedContentsRequest request =
        ListCachedContentsRequest.newBuilder().setParent(parent).build();
    return listCachedContents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists cached contents in a project
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   ListCachedContentsRequest request =
   *       ListCachedContentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (CachedContent element :
   *       genAiCacheServiceClient.listCachedContents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCachedContentsPagedResponse listCachedContents(
      ListCachedContentsRequest request) {
    return listCachedContentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists cached contents in a project
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   ListCachedContentsRequest request =
   *       ListCachedContentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<CachedContent> future =
   *       genAiCacheServiceClient.listCachedContentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CachedContent element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCachedContentsRequest, ListCachedContentsPagedResponse>
      listCachedContentsPagedCallable() {
    return stub.listCachedContentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists cached contents in a project
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   ListCachedContentsRequest request =
   *       ListCachedContentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListCachedContentsResponse response =
   *         genAiCacheServiceClient.listCachedContentsCallable().call(request);
   *     for (CachedContent element : response.getCachedContentsList()) {
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
  public final UnaryCallable<ListCachedContentsRequest, ListCachedContentsResponse>
      listCachedContentsCallable() {
    return stub.listCachedContentsCallable();
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
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : genAiCacheServiceClient.listLocations(request).iterateAll()) {
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
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       genAiCacheServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         genAiCacheServiceClient.listLocationsCallable().call(request);
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
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = genAiCacheServiceClient.getLocation(request);
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
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       genAiCacheServiceClient.getLocationCallable().futureCall(request);
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
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = genAiCacheServiceClient.setIamPolicy(request);
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
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = genAiCacheServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = genAiCacheServiceClient.getIamPolicy(request);
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
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = genAiCacheServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = genAiCacheServiceClient.testIamPermissions(request);
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
   * try (GenAiCacheServiceClient genAiCacheServiceClient = GenAiCacheServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       genAiCacheServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListCachedContentsPagedResponse
      extends AbstractPagedListResponse<
          ListCachedContentsRequest,
          ListCachedContentsResponse,
          CachedContent,
          ListCachedContentsPage,
          ListCachedContentsFixedSizeCollection> {

    public static ApiFuture<ListCachedContentsPagedResponse> createAsync(
        PageContext<ListCachedContentsRequest, ListCachedContentsResponse, CachedContent> context,
        ApiFuture<ListCachedContentsResponse> futureResponse) {
      ApiFuture<ListCachedContentsPage> futurePage =
          ListCachedContentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCachedContentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCachedContentsPagedResponse(ListCachedContentsPage page) {
      super(page, ListCachedContentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCachedContentsPage
      extends AbstractPage<
          ListCachedContentsRequest,
          ListCachedContentsResponse,
          CachedContent,
          ListCachedContentsPage> {

    private ListCachedContentsPage(
        PageContext<ListCachedContentsRequest, ListCachedContentsResponse, CachedContent> context,
        ListCachedContentsResponse response) {
      super(context, response);
    }

    private static ListCachedContentsPage createEmptyPage() {
      return new ListCachedContentsPage(null, null);
    }

    @Override
    protected ListCachedContentsPage createPage(
        PageContext<ListCachedContentsRequest, ListCachedContentsResponse, CachedContent> context,
        ListCachedContentsResponse response) {
      return new ListCachedContentsPage(context, response);
    }

    @Override
    public ApiFuture<ListCachedContentsPage> createPageAsync(
        PageContext<ListCachedContentsRequest, ListCachedContentsResponse, CachedContent> context,
        ApiFuture<ListCachedContentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCachedContentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCachedContentsRequest,
          ListCachedContentsResponse,
          CachedContent,
          ListCachedContentsPage,
          ListCachedContentsFixedSizeCollection> {

    private ListCachedContentsFixedSizeCollection(
        List<ListCachedContentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCachedContentsFixedSizeCollection createEmptyCollection() {
      return new ListCachedContentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCachedContentsFixedSizeCollection createCollection(
        List<ListCachedContentsPage> pages, int collectionSize) {
      return new ListCachedContentsFixedSizeCollection(pages, collectionSize);
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
