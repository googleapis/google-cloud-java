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

package com.google.cloud.compute.v1;

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
import com.google.cloud.compute.v1.stub.BackendBucketsStub;
import com.google.cloud.compute.v1.stub.BackendBucketsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The BackendBuckets API.
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
 * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
 *   String project = "project-309310695";
 *   String backendBucket = "backendBucket713751966";
 *   BackendBucket response = backendBucketsClient.get(project, backendBucket);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the BackendBucketsClient object to clean up resources such
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
 *      <td><p> AddSignedUrlKey</td>
 *      <td><p> Adds a key for validating requests with signed URLs for this backend bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> addSignedUrlKeyAsync(AddSignedUrlKeyBackendBucketRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> addSignedUrlKeyAsync(String project, String backendBucket, SignedUrlKey signedUrlKeyResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> addSignedUrlKeyOperationCallable()
 *           <li><p> addSignedUrlKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Delete</td>
 *      <td><p> Deletes the specified BackendBucket resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAsync(DeleteBackendBucketRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAsync(String project, String backendBucket)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteOperationCallable()
 *           <li><p> deleteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteSignedUrlKey</td>
 *      <td><p> Deletes a key for validating requests with signed URLs for this backend bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteSignedUrlKeyAsync(DeleteSignedUrlKeyBackendBucketRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteSignedUrlKeyAsync(String project, String backendBucket, String keyName)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteSignedUrlKeyOperationCallable()
 *           <li><p> deleteSignedUrlKeyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Get</td>
 *      <td><p> Returns the specified BackendBucket resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetBackendBucketRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String backendBucket)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the access control policy for a resource. May be empty if no such policy or resource exists.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyBackendBucketRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIamPolicy(String project, String resource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Insert</td>
 *      <td><p> Creates a BackendBucket resource in the specified project using the data included in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertAsync(InsertBackendBucketRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> insertAsync(String project, BackendBucket backendBucketResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> insertOperationCallable()
 *           <li><p> insertCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> List</td>
 *      <td><p> Retrieves the list of BackendBucket resources available to the specified project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(ListBackendBucketsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> list(String project)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPagedCallable()
 *           <li><p> listCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Patch</td>
 *      <td><p> Updates the specified BackendBucket resource with the data included in the request. This method supports PATCH semantics and uses the JSON merge patch format and processing rules.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> patchAsync(PatchBackendBucketRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> patchAsync(String project, String backendBucket, BackendBucket backendBucketResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> patchOperationCallable()
 *           <li><p> patchCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetEdgeSecurityPolicy</td>
 *      <td><p> Sets the edge security policy for the specified backend bucket.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setEdgeSecurityPolicyAsync(SetEdgeSecurityPolicyBackendBucketRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> setEdgeSecurityPolicyAsync(String project, String backendBucket, SecurityPolicyReference securityPolicyReferenceResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setEdgeSecurityPolicyOperationCallable()
 *           <li><p> setEdgeSecurityPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy on the specified resource. Replaces any existing policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyBackendBucketRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setIamPolicy(String project, String resource, GlobalSetPolicyRequest globalSetPolicyRequestResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> testIamPermissions(TestIamPermissionsBackendBucketRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> testIamPermissions(String project, String resource, TestPermissionsRequest testPermissionsRequestResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> testIamPermissionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Update</td>
 *      <td><p> Updates the specified BackendBucket resource with the data included in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAsync(UpdateBackendBucketRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateAsync(String project, String backendBucket, BackendBucket backendBucketResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateOperationCallable()
 *           <li><p> updateCallable()
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
 * <p>This class can be customized by passing in a custom instance of BackendBucketsSettings to
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
 * BackendBucketsSettings backendBucketsSettings =
 *     BackendBucketsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BackendBucketsClient backendBucketsClient = BackendBucketsClient.create(backendBucketsSettings);
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
 * BackendBucketsSettings backendBucketsSettings =
 *     BackendBucketsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BackendBucketsClient backendBucketsClient = BackendBucketsClient.create(backendBucketsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class BackendBucketsClient implements BackgroundResource {
  private final BackendBucketsSettings settings;
  private final BackendBucketsStub stub;

  /** Constructs an instance of BackendBucketsClient with default settings. */
  public static final BackendBucketsClient create() throws IOException {
    return create(BackendBucketsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BackendBucketsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BackendBucketsClient create(BackendBucketsSettings settings)
      throws IOException {
    return new BackendBucketsClient(settings);
  }

  /**
   * Constructs an instance of BackendBucketsClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(BackendBucketsSettings).
   */
  public static final BackendBucketsClient create(BackendBucketsStub stub) {
    return new BackendBucketsClient(stub);
  }

  /**
   * Constructs an instance of BackendBucketsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected BackendBucketsClient(BackendBucketsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BackendBucketsStubSettings) settings.getStubSettings()).createStub();
  }

  protected BackendBucketsClient(BackendBucketsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final BackendBucketsSettings getSettings() {
    return settings;
  }

  public BackendBucketsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a key for validating requests with signed URLs for this backend bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   String project = "project-309310695";
   *   String backendBucket = "backendBucket713751966";
   *   SignedUrlKey signedUrlKeyResource = SignedUrlKey.newBuilder().build();
   *   Operation response =
   *       backendBucketsClient
   *           .addSignedUrlKeyAsync(project, backendBucket, signedUrlKeyResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param backendBucket Name of the BackendBucket resource to which the Signed URL Key should be
   *     added. The name should conform to RFC1035.
   * @param signedUrlKeyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> addSignedUrlKeyAsync(
      String project, String backendBucket, SignedUrlKey signedUrlKeyResource) {
    AddSignedUrlKeyBackendBucketRequest request =
        AddSignedUrlKeyBackendBucketRequest.newBuilder()
            .setProject(project)
            .setBackendBucket(backendBucket)
            .setSignedUrlKeyResource(signedUrlKeyResource)
            .build();
    return addSignedUrlKeyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a key for validating requests with signed URLs for this backend bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   AddSignedUrlKeyBackendBucketRequest request =
   *       AddSignedUrlKeyBackendBucketRequest.newBuilder()
   *           .setBackendBucket("backendBucket713751966")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSignedUrlKeyResource(SignedUrlKey.newBuilder().build())
   *           .build();
   *   Operation response = backendBucketsClient.addSignedUrlKeyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> addSignedUrlKeyAsync(
      AddSignedUrlKeyBackendBucketRequest request) {
    return addSignedUrlKeyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a key for validating requests with signed URLs for this backend bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   AddSignedUrlKeyBackendBucketRequest request =
   *       AddSignedUrlKeyBackendBucketRequest.newBuilder()
   *           .setBackendBucket("backendBucket713751966")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSignedUrlKeyResource(SignedUrlKey.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       backendBucketsClient.addSignedUrlKeyOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<AddSignedUrlKeyBackendBucketRequest, Operation, Operation>
      addSignedUrlKeyOperationCallable() {
    return stub.addSignedUrlKeyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds a key for validating requests with signed URLs for this backend bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   AddSignedUrlKeyBackendBucketRequest request =
   *       AddSignedUrlKeyBackendBucketRequest.newBuilder()
   *           .setBackendBucket("backendBucket713751966")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSignedUrlKeyResource(SignedUrlKey.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       backendBucketsClient.addSignedUrlKeyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddSignedUrlKeyBackendBucketRequest, Operation>
      addSignedUrlKeyCallable() {
    return stub.addSignedUrlKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified BackendBucket resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   String project = "project-309310695";
   *   String backendBucket = "backendBucket713751966";
   *   Operation response = backendBucketsClient.deleteAsync(project, backendBucket).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param backendBucket Name of the BackendBucket resource to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String backendBucket) {
    DeleteBackendBucketRequest request =
        DeleteBackendBucketRequest.newBuilder()
            .setProject(project)
            .setBackendBucket(backendBucket)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified BackendBucket resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   DeleteBackendBucketRequest request =
   *       DeleteBackendBucketRequest.newBuilder()
   *           .setBackendBucket("backendBucket713751966")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = backendBucketsClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteBackendBucketRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified BackendBucket resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   DeleteBackendBucketRequest request =
   *       DeleteBackendBucketRequest.newBuilder()
   *           .setBackendBucket("backendBucket713751966")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       backendBucketsClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteBackendBucketRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified BackendBucket resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   DeleteBackendBucketRequest request =
   *       DeleteBackendBucketRequest.newBuilder()
   *           .setBackendBucket("backendBucket713751966")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = backendBucketsClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteBackendBucketRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a key for validating requests with signed URLs for this backend bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   String project = "project-309310695";
   *   String backendBucket = "backendBucket713751966";
   *   String keyName = "keyName-815643254";
   *   Operation response =
   *       backendBucketsClient.deleteSignedUrlKeyAsync(project, backendBucket, keyName).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param backendBucket Name of the BackendBucket resource to which the Signed URL Key should be
   *     added. The name should conform to RFC1035.
   * @param keyName The name of the Signed URL Key to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteSignedUrlKeyAsync(
      String project, String backendBucket, String keyName) {
    DeleteSignedUrlKeyBackendBucketRequest request =
        DeleteSignedUrlKeyBackendBucketRequest.newBuilder()
            .setProject(project)
            .setBackendBucket(backendBucket)
            .setKeyName(keyName)
            .build();
    return deleteSignedUrlKeyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a key for validating requests with signed URLs for this backend bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   DeleteSignedUrlKeyBackendBucketRequest request =
   *       DeleteSignedUrlKeyBackendBucketRequest.newBuilder()
   *           .setBackendBucket("backendBucket713751966")
   *           .setKeyName("keyName-815643254")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = backendBucketsClient.deleteSignedUrlKeyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> deleteSignedUrlKeyAsync(
      DeleteSignedUrlKeyBackendBucketRequest request) {
    return deleteSignedUrlKeyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a key for validating requests with signed URLs for this backend bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   DeleteSignedUrlKeyBackendBucketRequest request =
   *       DeleteSignedUrlKeyBackendBucketRequest.newBuilder()
   *           .setBackendBucket("backendBucket713751966")
   *           .setKeyName("keyName-815643254")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       backendBucketsClient.deleteSignedUrlKeyOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteSignedUrlKeyBackendBucketRequest, Operation, Operation>
      deleteSignedUrlKeyOperationCallable() {
    return stub.deleteSignedUrlKeyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a key for validating requests with signed URLs for this backend bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   DeleteSignedUrlKeyBackendBucketRequest request =
   *       DeleteSignedUrlKeyBackendBucketRequest.newBuilder()
   *           .setBackendBucket("backendBucket713751966")
   *           .setKeyName("keyName-815643254")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       backendBucketsClient.deleteSignedUrlKeyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteSignedUrlKeyBackendBucketRequest, Operation>
      deleteSignedUrlKeyCallable() {
    return stub.deleteSignedUrlKeyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified BackendBucket resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   String project = "project-309310695";
   *   String backendBucket = "backendBucket713751966";
   *   BackendBucket response = backendBucketsClient.get(project, backendBucket);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param backendBucket Name of the BackendBucket resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackendBucket get(String project, String backendBucket) {
    GetBackendBucketRequest request =
        GetBackendBucketRequest.newBuilder()
            .setProject(project)
            .setBackendBucket(backendBucket)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified BackendBucket resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   GetBackendBucketRequest request =
   *       GetBackendBucketRequest.newBuilder()
   *           .setBackendBucket("backendBucket713751966")
   *           .setProject("project-309310695")
   *           .build();
   *   BackendBucket response = backendBucketsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BackendBucket get(GetBackendBucketRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified BackendBucket resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   GetBackendBucketRequest request =
   *       GetBackendBucketRequest.newBuilder()
   *           .setBackendBucket("backendBucket713751966")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<BackendBucket> future = backendBucketsClient.getCallable().futureCall(request);
   *   // Do something.
   *   BackendBucket response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetBackendBucketRequest, BackendBucket> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   String project = "project-309310695";
   *   String resource = "resource-341064690";
   *   Policy response = backendBucketsClient.getIamPolicy(project, resource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String project, String resource) {
    GetIamPolicyBackendBucketRequest request =
        GetIamPolicyBackendBucketRequest.newBuilder()
            .setProject(project)
            .setResource(resource)
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   GetIamPolicyBackendBucketRequest request =
   *       GetIamPolicyBackendBucketRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   Policy response = backendBucketsClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyBackendBucketRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a resource. May be empty if no such policy or resource
   * exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   GetIamPolicyBackendBucketRequest request =
   *       GetIamPolicyBackendBucketRequest.newBuilder()
   *           .setOptionsRequestedPolicyVersion(-574521795)
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Policy> future = backendBucketsClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyBackendBucketRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a BackendBucket resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   String project = "project-309310695";
   *   BackendBucket backendBucketResource = BackendBucket.newBuilder().build();
   *   Operation response = backendBucketsClient.insertAsync(project, backendBucketResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param backendBucketResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, BackendBucket backendBucketResource) {
    InsertBackendBucketRequest request =
        InsertBackendBucketRequest.newBuilder()
            .setProject(project)
            .setBackendBucketResource(backendBucketResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a BackendBucket resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   InsertBackendBucketRequest request =
   *       InsertBackendBucketRequest.newBuilder()
   *           .setBackendBucketResource(BackendBucket.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = backendBucketsClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertBackendBucketRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a BackendBucket resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   InsertBackendBucketRequest request =
   *       InsertBackendBucketRequest.newBuilder()
   *           .setBackendBucketResource(BackendBucket.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       backendBucketsClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertBackendBucketRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a BackendBucket resource in the specified project using the data included in the
   * request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   InsertBackendBucketRequest request =
   *       InsertBackendBucketRequest.newBuilder()
   *           .setBackendBucketResource(BackendBucket.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = backendBucketsClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertBackendBucketRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of BackendBucket resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   String project = "project-309310695";
   *   for (BackendBucket element : backendBucketsClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListBackendBucketsRequest request =
        ListBackendBucketsRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of BackendBucket resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   ListBackendBucketsRequest request =
   *       ListBackendBucketsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (BackendBucket element : backendBucketsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListBackendBucketsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of BackendBucket resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   ListBackendBucketsRequest request =
   *       ListBackendBucketsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<BackendBucket> future =
   *       backendBucketsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (BackendBucket element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListBackendBucketsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of BackendBucket resources available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   ListBackendBucketsRequest request =
   *       ListBackendBucketsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     BackendBucketList response = backendBucketsClient.listCallable().call(request);
   *     for (BackendBucket element : response.getItemsList()) {
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
  public final UnaryCallable<ListBackendBucketsRequest, BackendBucketList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified BackendBucket resource with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   String project = "project-309310695";
   *   String backendBucket = "backendBucket713751966";
   *   BackendBucket backendBucketResource = BackendBucket.newBuilder().build();
   *   Operation response =
   *       backendBucketsClient.patchAsync(project, backendBucket, backendBucketResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param backendBucket Name of the BackendBucket resource to patch.
   * @param backendBucketResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> patchAsync(
      String project, String backendBucket, BackendBucket backendBucketResource) {
    PatchBackendBucketRequest request =
        PatchBackendBucketRequest.newBuilder()
            .setProject(project)
            .setBackendBucket(backendBucket)
            .setBackendBucketResource(backendBucketResource)
            .build();
    return patchAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified BackendBucket resource with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   PatchBackendBucketRequest request =
   *       PatchBackendBucketRequest.newBuilder()
   *           .setBackendBucket("backendBucket713751966")
   *           .setBackendBucketResource(BackendBucket.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = backendBucketsClient.patchAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> patchAsync(PatchBackendBucketRequest request) {
    return patchOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified BackendBucket resource with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   PatchBackendBucketRequest request =
   *       PatchBackendBucketRequest.newBuilder()
   *           .setBackendBucket("backendBucket713751966")
   *           .setBackendBucketResource(BackendBucket.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       backendBucketsClient.patchOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<PatchBackendBucketRequest, Operation, Operation>
      patchOperationCallable() {
    return stub.patchOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified BackendBucket resource with the data included in the request. This method
   * supports PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   PatchBackendBucketRequest request =
   *       PatchBackendBucketRequest.newBuilder()
   *           .setBackendBucket("backendBucket713751966")
   *           .setBackendBucketResource(BackendBucket.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = backendBucketsClient.patchCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PatchBackendBucketRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the edge security policy for the specified backend bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   String project = "project-309310695";
   *   String backendBucket = "backendBucket713751966";
   *   SecurityPolicyReference securityPolicyReferenceResource =
   *       SecurityPolicyReference.newBuilder().build();
   *   Operation response =
   *       backendBucketsClient
   *           .setEdgeSecurityPolicyAsync(project, backendBucket, securityPolicyReferenceResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param backendBucket Name of the BackendBucket resource to which the security policy should be
   *     set. The name should conform to RFC1035.
   * @param securityPolicyReferenceResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setEdgeSecurityPolicyAsync(
      String project,
      String backendBucket,
      SecurityPolicyReference securityPolicyReferenceResource) {
    SetEdgeSecurityPolicyBackendBucketRequest request =
        SetEdgeSecurityPolicyBackendBucketRequest.newBuilder()
            .setProject(project)
            .setBackendBucket(backendBucket)
            .setSecurityPolicyReferenceResource(securityPolicyReferenceResource)
            .build();
    return setEdgeSecurityPolicyAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the edge security policy for the specified backend bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   SetEdgeSecurityPolicyBackendBucketRequest request =
   *       SetEdgeSecurityPolicyBackendBucketRequest.newBuilder()
   *           .setBackendBucket("backendBucket713751966")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicyReferenceResource(SecurityPolicyReference.newBuilder().build())
   *           .build();
   *   Operation response = backendBucketsClient.setEdgeSecurityPolicyAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setEdgeSecurityPolicyAsync(
      SetEdgeSecurityPolicyBackendBucketRequest request) {
    return setEdgeSecurityPolicyOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the edge security policy for the specified backend bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   SetEdgeSecurityPolicyBackendBucketRequest request =
   *       SetEdgeSecurityPolicyBackendBucketRequest.newBuilder()
   *           .setBackendBucket("backendBucket713751966")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicyReferenceResource(SecurityPolicyReference.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       backendBucketsClient.setEdgeSecurityPolicyOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetEdgeSecurityPolicyBackendBucketRequest, Operation, Operation>
      setEdgeSecurityPolicyOperationCallable() {
    return stub.setEdgeSecurityPolicyOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the edge security policy for the specified backend bucket.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   SetEdgeSecurityPolicyBackendBucketRequest request =
   *       SetEdgeSecurityPolicyBackendBucketRequest.newBuilder()
   *           .setBackendBucket("backendBucket713751966")
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setSecurityPolicyReferenceResource(SecurityPolicyReference.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       backendBucketsClient.setEdgeSecurityPolicyCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetEdgeSecurityPolicyBackendBucketRequest, Operation>
      setEdgeSecurityPolicyCallable() {
    return stub.setEdgeSecurityPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   String project = "project-309310695";
   *   String resource = "resource-341064690";
   *   GlobalSetPolicyRequest globalSetPolicyRequestResource =
   *       GlobalSetPolicyRequest.newBuilder().build();
   *   Policy response =
   *       backendBucketsClient.setIamPolicy(project, resource, globalSetPolicyRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @param globalSetPolicyRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(
      String project, String resource, GlobalSetPolicyRequest globalSetPolicyRequestResource) {
    SetIamPolicyBackendBucketRequest request =
        SetIamPolicyBackendBucketRequest.newBuilder()
            .setProject(project)
            .setResource(resource)
            .setGlobalSetPolicyRequestResource(globalSetPolicyRequestResource)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   SetIamPolicyBackendBucketRequest request =
   *       SetIamPolicyBackendBucketRequest.newBuilder()
   *           .setGlobalSetPolicyRequestResource(GlobalSetPolicyRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   Policy response = backendBucketsClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyBackendBucketRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on the specified resource. Replaces any existing policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   SetIamPolicyBackendBucketRequest request =
   *       SetIamPolicyBackendBucketRequest.newBuilder()
   *           .setGlobalSetPolicyRequestResource(GlobalSetPolicyRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .build();
   *   ApiFuture<Policy> future = backendBucketsClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyBackendBucketRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   String project = "project-309310695";
   *   String resource = "resource-341064690";
   *   TestPermissionsRequest testPermissionsRequestResource =
   *       TestPermissionsRequest.newBuilder().build();
   *   TestPermissionsResponse response =
   *       backendBucketsClient.testIamPermissions(
   *           project, resource, testPermissionsRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param resource Name or id of the resource for this request.
   * @param testPermissionsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      String project, String resource, TestPermissionsRequest testPermissionsRequestResource) {
    TestIamPermissionsBackendBucketRequest request =
        TestIamPermissionsBackendBucketRequest.newBuilder()
            .setProject(project)
            .setResource(resource)
            .setTestPermissionsRequestResource(testPermissionsRequestResource)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   TestIamPermissionsBackendBucketRequest request =
   *       TestIamPermissionsBackendBucketRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .build();
   *   TestPermissionsResponse response = backendBucketsClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestPermissionsResponse testIamPermissions(
      TestIamPermissionsBackendBucketRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   TestIamPermissionsBackendBucketRequest request =
   *       TestIamPermissionsBackendBucketRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setResource("resource-341064690")
   *           .setTestPermissionsRequestResource(TestPermissionsRequest.newBuilder().build())
   *           .build();
   *   ApiFuture<TestPermissionsResponse> future =
   *       backendBucketsClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsBackendBucketRequest, TestPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified BackendBucket resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   String project = "project-309310695";
   *   String backendBucket = "backendBucket713751966";
   *   BackendBucket backendBucketResource = BackendBucket.newBuilder().build();
   *   Operation response =
   *       backendBucketsClient.updateAsync(project, backendBucket, backendBucketResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param backendBucket Name of the BackendBucket resource to update.
   * @param backendBucketResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> updateAsync(
      String project, String backendBucket, BackendBucket backendBucketResource) {
    UpdateBackendBucketRequest request =
        UpdateBackendBucketRequest.newBuilder()
            .setProject(project)
            .setBackendBucket(backendBucket)
            .setBackendBucketResource(backendBucketResource)
            .build();
    return updateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified BackendBucket resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   UpdateBackendBucketRequest request =
   *       UpdateBackendBucketRequest.newBuilder()
   *           .setBackendBucket("backendBucket713751966")
   *           .setBackendBucketResource(BackendBucket.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = backendBucketsClient.updateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> updateAsync(
      UpdateBackendBucketRequest request) {
    return updateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified BackendBucket resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   UpdateBackendBucketRequest request =
   *       UpdateBackendBucketRequest.newBuilder()
   *           .setBackendBucket("backendBucket713751966")
   *           .setBackendBucketResource(BackendBucket.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       backendBucketsClient.updateOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateBackendBucketRequest, Operation, Operation>
      updateOperationCallable() {
    return stub.updateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified BackendBucket resource with the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BackendBucketsClient backendBucketsClient = BackendBucketsClient.create()) {
   *   UpdateBackendBucketRequest request =
   *       UpdateBackendBucketRequest.newBuilder()
   *           .setBackendBucket("backendBucket713751966")
   *           .setBackendBucketResource(BackendBucket.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = backendBucketsClient.updateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateBackendBucketRequest, Operation> updateCallable() {
    return stub.updateCallable();
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

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListBackendBucketsRequest,
          BackendBucketList,
          BackendBucket,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListBackendBucketsRequest, BackendBucketList, BackendBucket> context,
        ApiFuture<BackendBucketList> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage
      extends AbstractPage<ListBackendBucketsRequest, BackendBucketList, BackendBucket, ListPage> {

    private ListPage(
        PageContext<ListBackendBucketsRequest, BackendBucketList, BackendBucket> context,
        BackendBucketList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListBackendBucketsRequest, BackendBucketList, BackendBucket> context,
        BackendBucketList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListBackendBucketsRequest, BackendBucketList, BackendBucket> context,
        ApiFuture<BackendBucketList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListBackendBucketsRequest,
          BackendBucketList,
          BackendBucket,
          ListPage,
          ListFixedSizeCollection> {

    private ListFixedSizeCollection(List<ListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFixedSizeCollection createEmptyCollection() {
      return new ListFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFixedSizeCollection createCollection(List<ListPage> pages, int collectionSize) {
      return new ListFixedSizeCollection(pages, collectionSize);
    }
  }
}
