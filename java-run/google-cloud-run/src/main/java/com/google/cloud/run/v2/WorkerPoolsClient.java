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

package com.google.cloud.run.v2;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.run.v2.stub.WorkerPoolsStub;
import com.google.cloud.run.v2.stub.WorkerPoolsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Cloud Run WorkerPool Control Plane API.
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
 * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
 *   WorkerPoolName name = WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]");
 *   WorkerPool response = workerPoolsClient.getWorkerPool(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the WorkerPoolsClient object to clean up resources such as
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
 *      <td><p> CreateWorkerPool</td>
 *      <td><p> Creates a new WorkerPool in a given project and location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createWorkerPoolAsync(CreateWorkerPoolRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createWorkerPoolAsync(LocationName parent, WorkerPool workerPool, String workerPoolId)
 *           <li><p> createWorkerPoolAsync(String parent, WorkerPool workerPool, String workerPoolId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createWorkerPoolOperationCallable()
 *           <li><p> createWorkerPoolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetWorkerPool</td>
 *      <td><p> Gets information about a WorkerPool.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getWorkerPool(GetWorkerPoolRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getWorkerPool(WorkerPoolName name)
 *           <li><p> getWorkerPool(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getWorkerPoolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListWorkerPools</td>
 *      <td><p> Lists WorkerPools. Results are sorted by creation time, descending.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listWorkerPools(ListWorkerPoolsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listWorkerPools(LocationName parent)
 *           <li><p> listWorkerPools(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listWorkerPoolsPagedCallable()
 *           <li><p> listWorkerPoolsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateWorkerPool</td>
 *      <td><p> Updates a WorkerPool.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateWorkerPoolAsync(UpdateWorkerPoolRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateWorkerPoolAsync(WorkerPool workerPool)
 *           <li><p> updateWorkerPoolAsync(WorkerPool workerPool, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateWorkerPoolOperationCallable()
 *           <li><p> updateWorkerPoolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteWorkerPool</td>
 *      <td><p> Deletes a WorkerPool.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteWorkerPoolAsync(DeleteWorkerPoolRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteWorkerPoolAsync(WorkerPoolName name)
 *           <li><p> deleteWorkerPoolAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteWorkerPoolOperationCallable()
 *           <li><p> deleteWorkerPoolCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the IAM Access Control policy currently in effect for the given Cloud Run WorkerPool. This result does not include any inherited policies.</td>
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
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the IAM Access control policy for the specified WorkerPool. Overwrites any existing policy.</td>
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
 *      <td><p> TestIamPermissions</td>
 *      <td><p> Returns permissions that a caller has on the specified Project.
 * <p>  There are no permissions required for making this API call.</td>
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
 * <p>This class can be customized by passing in a custom instance of WorkerPoolsSettings to
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
 * WorkerPoolsSettings workerPoolsSettings =
 *     WorkerPoolsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create(workerPoolsSettings);
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
 * WorkerPoolsSettings workerPoolsSettings =
 *     WorkerPoolsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create(workerPoolsSettings);
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
 * WorkerPoolsSettings workerPoolsSettings = WorkerPoolsSettings.newHttpJsonBuilder().build();
 * WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create(workerPoolsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class WorkerPoolsClient implements BackgroundResource {
  private final WorkerPoolsSettings settings;
  private final WorkerPoolsStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of WorkerPoolsClient with default settings. */
  public static final WorkerPoolsClient create() throws IOException {
    return create(WorkerPoolsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of WorkerPoolsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final WorkerPoolsClient create(WorkerPoolsSettings settings) throws IOException {
    return new WorkerPoolsClient(settings);
  }

  /**
   * Constructs an instance of WorkerPoolsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(WorkerPoolsSettings).
   */
  public static final WorkerPoolsClient create(WorkerPoolsStub stub) {
    return new WorkerPoolsClient(stub);
  }

  /**
   * Constructs an instance of WorkerPoolsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected WorkerPoolsClient(WorkerPoolsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((WorkerPoolsStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected WorkerPoolsClient(WorkerPoolsStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final WorkerPoolsSettings getSettings() {
    return settings;
  }

  public WorkerPoolsStub getStub() {
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
   * Creates a new WorkerPool in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   WorkerPool workerPool = WorkerPool.newBuilder().build();
   *   String workerPoolId = "workerPoolId-46320779";
   *   WorkerPool response =
   *       workerPoolsClient.createWorkerPoolAsync(parent, workerPool, workerPoolId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The location and project in which this worker pool should be created.
   *     Format: `projects/{project}/locations/{location}`, where `{project}` can be project id or
   *     number. Only lowercase characters, digits, and hyphens.
   * @param workerPool Required. The WorkerPool instance to create.
   * @param workerPoolId Required. The unique identifier for the WorkerPool. It must begin with
   *     letter, and cannot end with hyphen; must contain fewer than 50 characters. The name of the
   *     worker pool becomes `{parent}/workerPools/{worker_pool_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkerPool, WorkerPool> createWorkerPoolAsync(
      LocationName parent, WorkerPool workerPool, String workerPoolId) {
    CreateWorkerPoolRequest request =
        CreateWorkerPoolRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setWorkerPool(workerPool)
            .setWorkerPoolId(workerPoolId)
            .build();
    return createWorkerPoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new WorkerPool in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   WorkerPool workerPool = WorkerPool.newBuilder().build();
   *   String workerPoolId = "workerPoolId-46320779";
   *   WorkerPool response =
   *       workerPoolsClient.createWorkerPoolAsync(parent, workerPool, workerPoolId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The location and project in which this worker pool should be created.
   *     Format: `projects/{project}/locations/{location}`, where `{project}` can be project id or
   *     number. Only lowercase characters, digits, and hyphens.
   * @param workerPool Required. The WorkerPool instance to create.
   * @param workerPoolId Required. The unique identifier for the WorkerPool. It must begin with
   *     letter, and cannot end with hyphen; must contain fewer than 50 characters. The name of the
   *     worker pool becomes `{parent}/workerPools/{worker_pool_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkerPool, WorkerPool> createWorkerPoolAsync(
      String parent, WorkerPool workerPool, String workerPoolId) {
    CreateWorkerPoolRequest request =
        CreateWorkerPoolRequest.newBuilder()
            .setParent(parent)
            .setWorkerPool(workerPool)
            .setWorkerPoolId(workerPoolId)
            .build();
    return createWorkerPoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new WorkerPool in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   CreateWorkerPoolRequest request =
   *       CreateWorkerPoolRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setWorkerPool(WorkerPool.newBuilder().build())
   *           .setWorkerPoolId("workerPoolId-46320779")
   *           .setValidateOnly(true)
   *           .build();
   *   WorkerPool response = workerPoolsClient.createWorkerPoolAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkerPool, WorkerPool> createWorkerPoolAsync(
      CreateWorkerPoolRequest request) {
    return createWorkerPoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new WorkerPool in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   CreateWorkerPoolRequest request =
   *       CreateWorkerPoolRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setWorkerPool(WorkerPool.newBuilder().build())
   *           .setWorkerPoolId("workerPoolId-46320779")
   *           .setValidateOnly(true)
   *           .build();
   *   OperationFuture<WorkerPool, WorkerPool> future =
   *       workerPoolsClient.createWorkerPoolOperationCallable().futureCall(request);
   *   // Do something.
   *   WorkerPool response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateWorkerPoolRequest, WorkerPool, WorkerPool>
      createWorkerPoolOperationCallable() {
    return stub.createWorkerPoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new WorkerPool in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   CreateWorkerPoolRequest request =
   *       CreateWorkerPoolRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setWorkerPool(WorkerPool.newBuilder().build())
   *           .setWorkerPoolId("workerPoolId-46320779")
   *           .setValidateOnly(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       workerPoolsClient.createWorkerPoolCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateWorkerPoolRequest, Operation> createWorkerPoolCallable() {
    return stub.createWorkerPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a WorkerPool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   WorkerPoolName name = WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]");
   *   WorkerPool response = workerPoolsClient.getWorkerPool(name);
   * }
   * }</pre>
   *
   * @param name Required. The full name of the WorkerPool. Format:
   *     `projects/{project}/locations/{location}/workerPools/{worker_pool}`, where `{project}` can
   *     be project id or number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkerPool getWorkerPool(WorkerPoolName name) {
    GetWorkerPoolRequest request =
        GetWorkerPoolRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getWorkerPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a WorkerPool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   String name = WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString();
   *   WorkerPool response = workerPoolsClient.getWorkerPool(name);
   * }
   * }</pre>
   *
   * @param name Required. The full name of the WorkerPool. Format:
   *     `projects/{project}/locations/{location}/workerPools/{worker_pool}`, where `{project}` can
   *     be project id or number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkerPool getWorkerPool(String name) {
    GetWorkerPoolRequest request = GetWorkerPoolRequest.newBuilder().setName(name).build();
    return getWorkerPool(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a WorkerPool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   GetWorkerPoolRequest request =
   *       GetWorkerPoolRequest.newBuilder()
   *           .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
   *           .build();
   *   WorkerPool response = workerPoolsClient.getWorkerPool(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final WorkerPool getWorkerPool(GetWorkerPoolRequest request) {
    return getWorkerPoolCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a WorkerPool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   GetWorkerPoolRequest request =
   *       GetWorkerPoolRequest.newBuilder()
   *           .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
   *           .build();
   *   ApiFuture<WorkerPool> future = workerPoolsClient.getWorkerPoolCallable().futureCall(request);
   *   // Do something.
   *   WorkerPool response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetWorkerPoolRequest, WorkerPool> getWorkerPoolCallable() {
    return stub.getWorkerPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists WorkerPools. Results are sorted by creation time, descending.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (WorkerPool element : workerPoolsClient.listWorkerPools(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location and project to list resources on. Location must be a valid
   *     Google Cloud region, and cannot be the "-" wildcard. Format:
   *     `projects/{project}/locations/{location}`, where `{project}` can be project id or number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkerPoolsPagedResponse listWorkerPools(LocationName parent) {
    ListWorkerPoolsRequest request =
        ListWorkerPoolsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listWorkerPools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists WorkerPools. Results are sorted by creation time, descending.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (WorkerPool element : workerPoolsClient.listWorkerPools(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The location and project to list resources on. Location must be a valid
   *     Google Cloud region, and cannot be the "-" wildcard. Format:
   *     `projects/{project}/locations/{location}`, where `{project}` can be project id or number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkerPoolsPagedResponse listWorkerPools(String parent) {
    ListWorkerPoolsRequest request = ListWorkerPoolsRequest.newBuilder().setParent(parent).build();
    return listWorkerPools(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists WorkerPools. Results are sorted by creation time, descending.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   ListWorkerPoolsRequest request =
   *       ListWorkerPoolsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   for (WorkerPool element : workerPoolsClient.listWorkerPools(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListWorkerPoolsPagedResponse listWorkerPools(ListWorkerPoolsRequest request) {
    return listWorkerPoolsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists WorkerPools. Results are sorted by creation time, descending.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   ListWorkerPoolsRequest request =
   *       ListWorkerPoolsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<WorkerPool> future =
   *       workerPoolsClient.listWorkerPoolsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (WorkerPool element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListWorkerPoolsRequest, ListWorkerPoolsPagedResponse>
      listWorkerPoolsPagedCallable() {
    return stub.listWorkerPoolsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists WorkerPools. Results are sorted by creation time, descending.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   ListWorkerPoolsRequest request =
   *       ListWorkerPoolsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListWorkerPoolsResponse response =
   *         workerPoolsClient.listWorkerPoolsCallable().call(request);
   *     for (WorkerPool element : response.getWorkerPoolsList()) {
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
  public final UnaryCallable<ListWorkerPoolsRequest, ListWorkerPoolsResponse>
      listWorkerPoolsCallable() {
    return stub.listWorkerPoolsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a WorkerPool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   WorkerPool workerPool = WorkerPool.newBuilder().build();
   *   WorkerPool response = workerPoolsClient.updateWorkerPoolAsync(workerPool).get();
   * }
   * }</pre>
   *
   * @param workerPool Required. The WorkerPool to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkerPool, WorkerPool> updateWorkerPoolAsync(
      WorkerPool workerPool) {
    UpdateWorkerPoolRequest request =
        UpdateWorkerPoolRequest.newBuilder().setWorkerPool(workerPool).build();
    return updateWorkerPoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a WorkerPool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   WorkerPool workerPool = WorkerPool.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   WorkerPool response = workerPoolsClient.updateWorkerPoolAsync(workerPool, updateMask).get();
   * }
   * }</pre>
   *
   * @param workerPool Required. The WorkerPool to be updated.
   * @param updateMask Optional. The list of fields to be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkerPool, WorkerPool> updateWorkerPoolAsync(
      WorkerPool workerPool, FieldMask updateMask) {
    UpdateWorkerPoolRequest request =
        UpdateWorkerPoolRequest.newBuilder()
            .setWorkerPool(workerPool)
            .setUpdateMask(updateMask)
            .build();
    return updateWorkerPoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a WorkerPool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   UpdateWorkerPoolRequest request =
   *       UpdateWorkerPoolRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setWorkerPool(WorkerPool.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setForceNewRevision(true)
   *           .build();
   *   WorkerPool response = workerPoolsClient.updateWorkerPoolAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkerPool, WorkerPool> updateWorkerPoolAsync(
      UpdateWorkerPoolRequest request) {
    return updateWorkerPoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a WorkerPool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   UpdateWorkerPoolRequest request =
   *       UpdateWorkerPoolRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setWorkerPool(WorkerPool.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setForceNewRevision(true)
   *           .build();
   *   OperationFuture<WorkerPool, WorkerPool> future =
   *       workerPoolsClient.updateWorkerPoolOperationCallable().futureCall(request);
   *   // Do something.
   *   WorkerPool response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateWorkerPoolRequest, WorkerPool, WorkerPool>
      updateWorkerPoolOperationCallable() {
    return stub.updateWorkerPoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a WorkerPool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   UpdateWorkerPoolRequest request =
   *       UpdateWorkerPoolRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setWorkerPool(WorkerPool.newBuilder().build())
   *           .setValidateOnly(true)
   *           .setAllowMissing(true)
   *           .setForceNewRevision(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       workerPoolsClient.updateWorkerPoolCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateWorkerPoolRequest, Operation> updateWorkerPoolCallable() {
    return stub.updateWorkerPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a WorkerPool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   WorkerPoolName name = WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]");
   *   WorkerPool response = workerPoolsClient.deleteWorkerPoolAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The full name of the WorkerPool. Format:
   *     `projects/{project}/locations/{location}/workerPools/{worker_pool}`, where `{project}` can
   *     be project id or number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkerPool, WorkerPool> deleteWorkerPoolAsync(WorkerPoolName name) {
    DeleteWorkerPoolRequest request =
        DeleteWorkerPoolRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteWorkerPoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a WorkerPool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   String name = WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString();
   *   WorkerPool response = workerPoolsClient.deleteWorkerPoolAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The full name of the WorkerPool. Format:
   *     `projects/{project}/locations/{location}/workerPools/{worker_pool}`, where `{project}` can
   *     be project id or number.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkerPool, WorkerPool> deleteWorkerPoolAsync(String name) {
    DeleteWorkerPoolRequest request = DeleteWorkerPoolRequest.newBuilder().setName(name).build();
    return deleteWorkerPoolAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a WorkerPool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   DeleteWorkerPoolRequest request =
   *       DeleteWorkerPoolRequest.newBuilder()
   *           .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   WorkerPool response = workerPoolsClient.deleteWorkerPoolAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<WorkerPool, WorkerPool> deleteWorkerPoolAsync(
      DeleteWorkerPoolRequest request) {
    return deleteWorkerPoolOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a WorkerPool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   DeleteWorkerPoolRequest request =
   *       DeleteWorkerPoolRequest.newBuilder()
   *           .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   OperationFuture<WorkerPool, WorkerPool> future =
   *       workerPoolsClient.deleteWorkerPoolOperationCallable().futureCall(request);
   *   // Do something.
   *   WorkerPool response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteWorkerPoolRequest, WorkerPool, WorkerPool>
      deleteWorkerPoolOperationCallable() {
    return stub.deleteWorkerPoolOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a WorkerPool.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   DeleteWorkerPoolRequest request =
   *       DeleteWorkerPoolRequest.newBuilder()
   *           .setName(WorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
   *           .setValidateOnly(true)
   *           .setEtag("etag3123477")
   *           .build();
   *   ApiFuture<Operation> future =
   *       workerPoolsClient.deleteWorkerPoolCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteWorkerPoolRequest, Operation> deleteWorkerPoolCallable() {
    return stub.deleteWorkerPoolCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM Access Control policy currently in effect for the given Cloud Run WorkerPool. This
   * result does not include any inherited policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               BuildWorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = workerPoolsClient.getIamPolicy(request);
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
   * Gets the IAM Access Control policy currently in effect for the given Cloud Run WorkerPool. This
   * result does not include any inherited policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               BuildWorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = workerPoolsClient.getIamPolicyCallable().futureCall(request);
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
   * Sets the IAM Access control policy for the specified WorkerPool. Overwrites any existing
   * policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               BuildWorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = workerPoolsClient.setIamPolicy(request);
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
   * Sets the IAM Access control policy for the specified WorkerPool. Overwrites any existing
   * policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               BuildWorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = workerPoolsClient.setIamPolicyCallable().futureCall(request);
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
   * Returns permissions that a caller has on the specified Project.
   *
   * <p>There are no permissions required for making this API call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               BuildWorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = workerPoolsClient.testIamPermissions(request);
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
   * Returns permissions that a caller has on the specified Project.
   *
   * <p>There are no permissions required for making this API call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (WorkerPoolsClient workerPoolsClient = WorkerPoolsClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               BuildWorkerPoolName.of("[PROJECT]", "[LOCATION]", "[WORKER_POOL]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       workerPoolsClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListWorkerPoolsPagedResponse
      extends AbstractPagedListResponse<
          ListWorkerPoolsRequest,
          ListWorkerPoolsResponse,
          WorkerPool,
          ListWorkerPoolsPage,
          ListWorkerPoolsFixedSizeCollection> {

    public static ApiFuture<ListWorkerPoolsPagedResponse> createAsync(
        PageContext<ListWorkerPoolsRequest, ListWorkerPoolsResponse, WorkerPool> context,
        ApiFuture<ListWorkerPoolsResponse> futureResponse) {
      ApiFuture<ListWorkerPoolsPage> futurePage =
          ListWorkerPoolsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListWorkerPoolsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListWorkerPoolsPagedResponse(ListWorkerPoolsPage page) {
      super(page, ListWorkerPoolsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListWorkerPoolsPage
      extends AbstractPage<
          ListWorkerPoolsRequest, ListWorkerPoolsResponse, WorkerPool, ListWorkerPoolsPage> {

    private ListWorkerPoolsPage(
        PageContext<ListWorkerPoolsRequest, ListWorkerPoolsResponse, WorkerPool> context,
        ListWorkerPoolsResponse response) {
      super(context, response);
    }

    private static ListWorkerPoolsPage createEmptyPage() {
      return new ListWorkerPoolsPage(null, null);
    }

    @Override
    protected ListWorkerPoolsPage createPage(
        PageContext<ListWorkerPoolsRequest, ListWorkerPoolsResponse, WorkerPool> context,
        ListWorkerPoolsResponse response) {
      return new ListWorkerPoolsPage(context, response);
    }

    @Override
    public ApiFuture<ListWorkerPoolsPage> createPageAsync(
        PageContext<ListWorkerPoolsRequest, ListWorkerPoolsResponse, WorkerPool> context,
        ApiFuture<ListWorkerPoolsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListWorkerPoolsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListWorkerPoolsRequest,
          ListWorkerPoolsResponse,
          WorkerPool,
          ListWorkerPoolsPage,
          ListWorkerPoolsFixedSizeCollection> {

    private ListWorkerPoolsFixedSizeCollection(
        List<ListWorkerPoolsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListWorkerPoolsFixedSizeCollection createEmptyCollection() {
      return new ListWorkerPoolsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListWorkerPoolsFixedSizeCollection createCollection(
        List<ListWorkerPoolsPage> pages, int collectionSize) {
      return new ListWorkerPoolsFixedSizeCollection(pages, collectionSize);
    }
  }
}
