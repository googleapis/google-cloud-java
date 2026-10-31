/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.discoveryengine.v1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.discoveryengine.v1.stub.CollectionServiceStub;
import com.google.cloud.discoveryengine.v1.stub.CollectionServiceStubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing
 * [Collection][google.cloud.discoveryengine.v1.Collection]s.
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
 * try (CollectionServiceClient collectionServiceClient = CollectionServiceClient.create()) {
 *   ResourceName resource = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
 *   Policy response = collectionServiceClient.getIamPolicy(resource);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CollectionServiceClient object to clean up resources
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
 *      <td><p> DeleteCollection</td>
 *      <td><p> Deletes a [Collection][google.cloud.discoveryengine.v1.Collection].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteCollectionAsync(DeleteCollectionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteCollectionAsync(CollectionName name)
 *           <li><p> deleteCollectionAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCollectionOperationCallable()
 *           <li><p> deleteCollectionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the IAM access control policy for a [Collection][google.cloud.discoveryengine.v1.Collection]. A `NOT_FOUND` error is returned if the resource does not exist. An empty policy is returned if the resource exists but does not have a policy set on it.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getIamPolicy(ResourceName resource)
 *           <li><p> getIamPolicy(String resource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the IAM access control policy for a [Collection][google.cloud.discoveryengine.v1.Collection]. A `NOT_FOUND` error is returned if the resource does not exist.
 * <p>  &#42;&#42;Important:&#42;&#42; When setting a policy directly on a Collection resource, the only recommended roles in the bindings are: `roles/discoveryengine.admin` `roles/discoveryengine.agentspaceAdmin` `roles/discoveryengine.viewer` `roles/discoveryengine.agentspaceViewer` `roles/discoveryengine.user` `roles/discoveryengine.agentspaceUser` Attempting to grant any other role will result in a warning in logging.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> setIamPolicy(ResourceName resource, Policy policy)
 *           <li><p> setIamPolicy(String resource, Policy policy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setIamPolicyCallable()
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
 * <p>This class can be customized by passing in a custom instance of CollectionServiceSettings to
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
 * CollectionServiceSettings collectionServiceSettings =
 *     CollectionServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CollectionServiceClient collectionServiceClient =
 *     CollectionServiceClient.create(collectionServiceSettings);
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
 * CollectionServiceSettings collectionServiceSettings =
 *     CollectionServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CollectionServiceClient collectionServiceClient =
 *     CollectionServiceClient.create(collectionServiceSettings);
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
 * CollectionServiceSettings collectionServiceSettings =
 *     CollectionServiceSettings.newHttpJsonBuilder().build();
 * CollectionServiceClient collectionServiceClient =
 *     CollectionServiceClient.create(collectionServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class CollectionServiceClient implements BackgroundResource {
  private final @Nullable CollectionServiceSettings settings;
  private final CollectionServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of CollectionServiceClient with default settings. */
  public static final CollectionServiceClient create() throws IOException {
    return create(CollectionServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CollectionServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CollectionServiceClient create(CollectionServiceSettings settings)
      throws IOException {
    return new CollectionServiceClient(settings);
  }

  /**
   * Constructs an instance of CollectionServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(CollectionServiceSettings).
   */
  public static final CollectionServiceClient create(CollectionServiceStub stub) {
    return new CollectionServiceClient(stub);
  }

  /**
   * Constructs an instance of CollectionServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CollectionServiceClient(CollectionServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CollectionServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected CollectionServiceClient(CollectionServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final @Nullable CollectionServiceSettings getSettings() {
    return settings;
  }

  public CollectionServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Collection][google.cloud.discoveryengine.v1.Collection].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CollectionServiceClient collectionServiceClient = CollectionServiceClient.create()) {
   *   CollectionName name = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
   *   collectionServiceClient.deleteCollectionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The full resource name of the Collection, in the format of
   *     `projects/{project}/locations/{location}/collections/{collection}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteCollectionMetadata> deleteCollectionAsync(
      @Nullable CollectionName name) {
    DeleteCollectionRequest request =
        DeleteCollectionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteCollectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Collection][google.cloud.discoveryengine.v1.Collection].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CollectionServiceClient collectionServiceClient = CollectionServiceClient.create()) {
   *   String name = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString();
   *   collectionServiceClient.deleteCollectionAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The full resource name of the Collection, in the format of
   *     `projects/{project}/locations/{location}/collections/{collection}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteCollectionMetadata> deleteCollectionAsync(String name) {
    DeleteCollectionRequest request = DeleteCollectionRequest.newBuilder().setName(name).build();
    return deleteCollectionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Collection][google.cloud.discoveryengine.v1.Collection].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CollectionServiceClient collectionServiceClient = CollectionServiceClient.create()) {
   *   DeleteCollectionRequest request =
   *       DeleteCollectionRequest.newBuilder()
   *           .setName(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .build();
   *   collectionServiceClient.deleteCollectionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteCollectionMetadata> deleteCollectionAsync(
      DeleteCollectionRequest request) {
    return deleteCollectionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Collection][google.cloud.discoveryengine.v1.Collection].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CollectionServiceClient collectionServiceClient = CollectionServiceClient.create()) {
   *   DeleteCollectionRequest request =
   *       DeleteCollectionRequest.newBuilder()
   *           .setName(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .build();
   *   OperationFuture<Empty, DeleteCollectionMetadata> future =
   *       collectionServiceClient.deleteCollectionOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteCollectionRequest, Empty, DeleteCollectionMetadata>
      deleteCollectionOperationCallable() {
    return stub.deleteCollectionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Collection][google.cloud.discoveryengine.v1.Collection].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CollectionServiceClient collectionServiceClient = CollectionServiceClient.create()) {
   *   DeleteCollectionRequest request =
   *       DeleteCollectionRequest.newBuilder()
   *           .setName(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       collectionServiceClient.deleteCollectionCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCollectionRequest, Operation> deleteCollectionCallable() {
    return stub.deleteCollectionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM access control policy for a
   * [Collection][google.cloud.discoveryengine.v1.Collection]. A `NOT_FOUND` error is returned if
   * the resource does not exist. An empty policy is returned if the resource exists but does not
   * have a policy set on it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CollectionServiceClient collectionServiceClient = CollectionServiceClient.create()) {
   *   ResourceName resource = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
   *   Policy response = collectionServiceClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(@Nullable ResourceName resource) {
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM access control policy for a
   * [Collection][google.cloud.discoveryengine.v1.Collection]. A `NOT_FOUND` error is returned if
   * the resource does not exist. An empty policy is returned if the resource exists but does not
   * have a policy set on it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CollectionServiceClient collectionServiceClient = CollectionServiceClient.create()) {
   *   String resource = AclConfigName.of("[PROJECT]", "[LOCATION]").toString();
   *   Policy response = collectionServiceClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM access control policy for a
   * [Collection][google.cloud.discoveryengine.v1.Collection]. A `NOT_FOUND` error is returned if
   * the resource does not exist. An empty policy is returned if the resource exists but does not
   * have a policy set on it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CollectionServiceClient collectionServiceClient = CollectionServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = collectionServiceClient.getIamPolicy(request);
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
   * Gets the IAM access control policy for a
   * [Collection][google.cloud.discoveryengine.v1.Collection]. A `NOT_FOUND` error is returned if
   * the resource does not exist. An empty policy is returned if the resource exists but does not
   * have a policy set on it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CollectionServiceClient collectionServiceClient = CollectionServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = collectionServiceClient.getIamPolicyCallable().futureCall(request);
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
   * Sets the IAM access control policy for a
   * [Collection][google.cloud.discoveryengine.v1.Collection]. A `NOT_FOUND` error is returned if
   * the resource does not exist.
   *
   * <p>&#42;&#42;Important:&#42;&#42; When setting a policy directly on a Collection resource, the
   * only recommended roles in the bindings are: `roles/discoveryengine.admin`
   * `roles/discoveryengine.agentspaceAdmin` `roles/discoveryengine.viewer`
   * `roles/discoveryengine.agentspaceViewer` `roles/discoveryengine.user`
   * `roles/discoveryengine.agentspaceUser` Attempting to grant any other role will result in a
   * warning in logging.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CollectionServiceClient collectionServiceClient = CollectionServiceClient.create()) {
   *   ResourceName resource = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = collectionServiceClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(@Nullable ResourceName resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setPolicy(policy)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the IAM access control policy for a
   * [Collection][google.cloud.discoveryengine.v1.Collection]. A `NOT_FOUND` error is returned if
   * the resource does not exist.
   *
   * <p>&#42;&#42;Important:&#42;&#42; When setting a policy directly on a Collection resource, the
   * only recommended roles in the bindings are: `roles/discoveryengine.admin`
   * `roles/discoveryengine.agentspaceAdmin` `roles/discoveryengine.viewer`
   * `roles/discoveryengine.agentspaceViewer` `roles/discoveryengine.user`
   * `roles/discoveryengine.agentspaceUser` Attempting to grant any other role will result in a
   * warning in logging.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CollectionServiceClient collectionServiceClient = CollectionServiceClient.create()) {
   *   String resource = AclConfigName.of("[PROJECT]", "[LOCATION]").toString();
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = collectionServiceClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the IAM access control policy for a
   * [Collection][google.cloud.discoveryengine.v1.Collection]. A `NOT_FOUND` error is returned if
   * the resource does not exist.
   *
   * <p>&#42;&#42;Important:&#42;&#42; When setting a policy directly on a Collection resource, the
   * only recommended roles in the bindings are: `roles/discoveryengine.admin`
   * `roles/discoveryengine.agentspaceAdmin` `roles/discoveryengine.viewer`
   * `roles/discoveryengine.agentspaceViewer` `roles/discoveryengine.user`
   * `roles/discoveryengine.agentspaceUser` Attempting to grant any other role will result in a
   * warning in logging.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CollectionServiceClient collectionServiceClient = CollectionServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = collectionServiceClient.setIamPolicy(request);
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
   * Sets the IAM access control policy for a
   * [Collection][google.cloud.discoveryengine.v1.Collection]. A `NOT_FOUND` error is returned if
   * the resource does not exist.
   *
   * <p>&#42;&#42;Important:&#42;&#42; When setting a policy directly on a Collection resource, the
   * only recommended roles in the bindings are: `roles/discoveryengine.admin`
   * `roles/discoveryengine.agentspaceAdmin` `roles/discoveryengine.viewer`
   * `roles/discoveryengine.agentspaceViewer` `roles/discoveryengine.user`
   * `roles/discoveryengine.agentspaceUser` Attempting to grant any other role will result in a
   * warning in logging.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CollectionServiceClient collectionServiceClient = CollectionServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = collectionServiceClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
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
}
