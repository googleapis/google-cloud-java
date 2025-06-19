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

package com.google.cloud.aiplatform.v1beta1;

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
import com.google.cloud.aiplatform.v1beta1.stub.MemoryBankServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.MemoryBankServiceStubSettings;
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
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service for managing memories for LLM applications.
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
 * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
 *   MemoryName name = MemoryName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[MEMORY]");
 *   Memory response = memoryBankServiceClient.getMemory(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MemoryBankServiceClient object to clean up resources
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
 *      <td><p> CreateMemory</td>
 *      <td><p> Create a Memory.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createMemoryAsync(CreateMemoryRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createMemoryOperationCallable()
 *           <li><p> createMemoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMemory</td>
 *      <td><p> Get a Memory.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMemory(GetMemoryRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMemory(MemoryName name)
 *           <li><p> getMemory(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMemoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateMemory</td>
 *      <td><p> Update a Memory.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateMemoryAsync(UpdateMemoryRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateMemoryAsync(Memory memory, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateMemoryOperationCallable()
 *           <li><p> updateMemoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMemories</td>
 *      <td><p> List Memories.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMemories(ListMemoriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMemories(ReasoningEngineName parent)
 *           <li><p> listMemories(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMemoriesPagedCallable()
 *           <li><p> listMemoriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteMemory</td>
 *      <td><p> Delete a Memory.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteMemoryAsync(DeleteMemoryRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteMemoryAsync(MemoryName name)
 *           <li><p> deleteMemoryAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteMemoryOperationCallable()
 *           <li><p> deleteMemoryCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateMemories</td>
 *      <td><p> Generate memories.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateMemoriesAsync(GenerateMemoriesRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> generateMemoriesAsync(ReasoningEngineName parent)
 *           <li><p> generateMemoriesAsync(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateMemoriesOperationCallable()
 *           <li><p> generateMemoriesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RetrieveMemories</td>
 *      <td><p> Retrieve memories.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> retrieveMemories(RetrieveMemoriesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> retrieveMemories(ReasoningEngineName parent)
 *           <li><p> retrieveMemories(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> retrieveMemoriesCallable()
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
 * <p>This class can be customized by passing in a custom instance of MemoryBankServiceSettings to
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
 * MemoryBankServiceSettings memoryBankServiceSettings =
 *     MemoryBankServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MemoryBankServiceClient memoryBankServiceClient =
 *     MemoryBankServiceClient.create(memoryBankServiceSettings);
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
 * MemoryBankServiceSettings memoryBankServiceSettings =
 *     MemoryBankServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MemoryBankServiceClient memoryBankServiceClient =
 *     MemoryBankServiceClient.create(memoryBankServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MemoryBankServiceClient implements BackgroundResource {
  private final MemoryBankServiceSettings settings;
  private final MemoryBankServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of MemoryBankServiceClient with default settings. */
  public static final MemoryBankServiceClient create() throws IOException {
    return create(MemoryBankServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MemoryBankServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final MemoryBankServiceClient create(MemoryBankServiceSettings settings)
      throws IOException {
    return new MemoryBankServiceClient(settings);
  }

  /**
   * Constructs an instance of MemoryBankServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(MemoryBankServiceSettings).
   */
  public static final MemoryBankServiceClient create(MemoryBankServiceStub stub) {
    return new MemoryBankServiceClient(stub);
  }

  /**
   * Constructs an instance of MemoryBankServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected MemoryBankServiceClient(MemoryBankServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((MemoryBankServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected MemoryBankServiceClient(MemoryBankServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final MemoryBankServiceSettings getSettings() {
    return settings;
  }

  public MemoryBankServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a Memory.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   CreateMemoryRequest request =
   *       CreateMemoryRequest.newBuilder()
   *           .setParent(
   *               ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]")
   *                   .toString())
   *           .setMemory(Memory.newBuilder().build())
   *           .build();
   *   Memory response = memoryBankServiceClient.createMemoryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Memory, CreateMemoryOperationMetadata> createMemoryAsync(
      CreateMemoryRequest request) {
    return createMemoryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a Memory.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   CreateMemoryRequest request =
   *       CreateMemoryRequest.newBuilder()
   *           .setParent(
   *               ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]")
   *                   .toString())
   *           .setMemory(Memory.newBuilder().build())
   *           .build();
   *   OperationFuture<Memory, CreateMemoryOperationMetadata> future =
   *       memoryBankServiceClient.createMemoryOperationCallable().futureCall(request);
   *   // Do something.
   *   Memory response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateMemoryRequest, Memory, CreateMemoryOperationMetadata>
      createMemoryOperationCallable() {
    return stub.createMemoryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a Memory.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   CreateMemoryRequest request =
   *       CreateMemoryRequest.newBuilder()
   *           .setParent(
   *               ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]")
   *                   .toString())
   *           .setMemory(Memory.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       memoryBankServiceClient.createMemoryCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateMemoryRequest, Operation> createMemoryCallable() {
    return stub.createMemoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a Memory.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   MemoryName name = MemoryName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[MEMORY]");
   *   Memory response = memoryBankServiceClient.getMemory(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Memory. Format:
   *     `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/memories/{memory}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Memory getMemory(MemoryName name) {
    GetMemoryRequest request =
        GetMemoryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getMemory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a Memory.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   String name =
   *       MemoryName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[MEMORY]").toString();
   *   Memory response = memoryBankServiceClient.getMemory(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Memory. Format:
   *     `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/memories/{memory}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Memory getMemory(String name) {
    GetMemoryRequest request = GetMemoryRequest.newBuilder().setName(name).build();
    return getMemory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a Memory.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   GetMemoryRequest request =
   *       GetMemoryRequest.newBuilder()
   *           .setName(
   *               MemoryName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[MEMORY]")
   *                   .toString())
   *           .build();
   *   Memory response = memoryBankServiceClient.getMemory(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Memory getMemory(GetMemoryRequest request) {
    return getMemoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a Memory.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   GetMemoryRequest request =
   *       GetMemoryRequest.newBuilder()
   *           .setName(
   *               MemoryName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[MEMORY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Memory> future = memoryBankServiceClient.getMemoryCallable().futureCall(request);
   *   // Do something.
   *   Memory response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMemoryRequest, Memory> getMemoryCallable() {
    return stub.getMemoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a Memory.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   Memory memory = Memory.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Memory response = memoryBankServiceClient.updateMemoryAsync(memory, updateMask).get();
   * }
   * }</pre>
   *
   * @param memory Required. The Memory which replaces the resource on the server.
   * @param updateMask Optional. Mask specifying which fields to update. Supported fields:
   *     <p>&#42; `display_name` &#42; `description` &#42; `fact`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Memory, UpdateMemoryOperationMetadata> updateMemoryAsync(
      Memory memory, FieldMask updateMask) {
    UpdateMemoryRequest request =
        UpdateMemoryRequest.newBuilder().setMemory(memory).setUpdateMask(updateMask).build();
    return updateMemoryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a Memory.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   UpdateMemoryRequest request =
   *       UpdateMemoryRequest.newBuilder()
   *           .setMemory(Memory.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Memory response = memoryBankServiceClient.updateMemoryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Memory, UpdateMemoryOperationMetadata> updateMemoryAsync(
      UpdateMemoryRequest request) {
    return updateMemoryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a Memory.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   UpdateMemoryRequest request =
   *       UpdateMemoryRequest.newBuilder()
   *           .setMemory(Memory.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Memory, UpdateMemoryOperationMetadata> future =
   *       memoryBankServiceClient.updateMemoryOperationCallable().futureCall(request);
   *   // Do something.
   *   Memory response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateMemoryRequest, Memory, UpdateMemoryOperationMetadata>
      updateMemoryOperationCallable() {
    return stub.updateMemoryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a Memory.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   UpdateMemoryRequest request =
   *       UpdateMemoryRequest.newBuilder()
   *           .setMemory(Memory.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       memoryBankServiceClient.updateMemoryCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateMemoryRequest, Operation> updateMemoryCallable() {
    return stub.updateMemoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Memories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   ReasoningEngineName parent =
   *       ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]");
   *   for (Memory element : memoryBankServiceClient.listMemories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the ReasoningEngine to list the Memories under.
   *     Format: `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMemoriesPagedResponse listMemories(ReasoningEngineName parent) {
    ListMemoriesRequest request =
        ListMemoriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMemories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Memories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   String parent =
   *       ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]").toString();
   *   for (Memory element : memoryBankServiceClient.listMemories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the ReasoningEngine to list the Memories under.
   *     Format: `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMemoriesPagedResponse listMemories(String parent) {
    ListMemoriesRequest request = ListMemoriesRequest.newBuilder().setParent(parent).build();
    return listMemories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Memories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   ListMemoriesRequest request =
   *       ListMemoriesRequest.newBuilder()
   *           .setParent(
   *               ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Memory element : memoryBankServiceClient.listMemories(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMemoriesPagedResponse listMemories(ListMemoriesRequest request) {
    return listMemoriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Memories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   ListMemoriesRequest request =
   *       ListMemoriesRequest.newBuilder()
   *           .setParent(
   *               ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Memory> future =
   *       memoryBankServiceClient.listMemoriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Memory element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMemoriesRequest, ListMemoriesPagedResponse>
      listMemoriesPagedCallable() {
    return stub.listMemoriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List Memories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   ListMemoriesRequest request =
   *       ListMemoriesRequest.newBuilder()
   *           .setParent(
   *               ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListMemoriesResponse response =
   *         memoryBankServiceClient.listMemoriesCallable().call(request);
   *     for (Memory element : response.getMemoriesList()) {
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
  public final UnaryCallable<ListMemoriesRequest, ListMemoriesResponse> listMemoriesCallable() {
    return stub.listMemoriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a Memory.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   MemoryName name = MemoryName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[MEMORY]");
   *   memoryBankServiceClient.deleteMemoryAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Memory to delete. Format:
   *     `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/memories/{memory}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteMemoryOperationMetadata> deleteMemoryAsync(
      MemoryName name) {
    DeleteMemoryRequest request =
        DeleteMemoryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteMemoryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a Memory.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   String name =
   *       MemoryName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[MEMORY]").toString();
   *   memoryBankServiceClient.deleteMemoryAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Memory to delete. Format:
   *     `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/memories/{memory}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteMemoryOperationMetadata> deleteMemoryAsync(
      String name) {
    DeleteMemoryRequest request = DeleteMemoryRequest.newBuilder().setName(name).build();
    return deleteMemoryAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a Memory.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   DeleteMemoryRequest request =
   *       DeleteMemoryRequest.newBuilder()
   *           .setName(
   *               MemoryName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[MEMORY]")
   *                   .toString())
   *           .build();
   *   memoryBankServiceClient.deleteMemoryAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteMemoryOperationMetadata> deleteMemoryAsync(
      DeleteMemoryRequest request) {
    return deleteMemoryOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a Memory.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   DeleteMemoryRequest request =
   *       DeleteMemoryRequest.newBuilder()
   *           .setName(
   *               MemoryName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[MEMORY]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteMemoryOperationMetadata> future =
   *       memoryBankServiceClient.deleteMemoryOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteMemoryRequest, Empty, DeleteMemoryOperationMetadata>
      deleteMemoryOperationCallable() {
    return stub.deleteMemoryOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a Memory.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   DeleteMemoryRequest request =
   *       DeleteMemoryRequest.newBuilder()
   *           .setName(
   *               MemoryName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[MEMORY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       memoryBankServiceClient.deleteMemoryCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMemoryRequest, Operation> deleteMemoryCallable() {
    return stub.deleteMemoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate memories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   ReasoningEngineName parent =
   *       ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]");
   *   GenerateMemoriesResponse response =
   *       memoryBankServiceClient.generateMemoriesAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the ReasoningEngine to generate memories for.
   *     Format: `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GenerateMemoriesResponse, GenerateMemoriesOperationMetadata>
      generateMemoriesAsync(ReasoningEngineName parent) {
    GenerateMemoriesRequest request =
        GenerateMemoriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return generateMemoriesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate memories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   String parent =
   *       ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]").toString();
   *   GenerateMemoriesResponse response =
   *       memoryBankServiceClient.generateMemoriesAsync(parent).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the ReasoningEngine to generate memories for.
   *     Format: `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GenerateMemoriesResponse, GenerateMemoriesOperationMetadata>
      generateMemoriesAsync(String parent) {
    GenerateMemoriesRequest request =
        GenerateMemoriesRequest.newBuilder().setParent(parent).build();
    return generateMemoriesAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate memories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   GenerateMemoriesRequest request =
   *       GenerateMemoriesRequest.newBuilder()
   *           .setParent(
   *               ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]")
   *                   .toString())
   *           .setDisableConsolidation(true)
   *           .putAllScope(new HashMap<String, String>())
   *           .build();
   *   GenerateMemoriesResponse response =
   *       memoryBankServiceClient.generateMemoriesAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<GenerateMemoriesResponse, GenerateMemoriesOperationMetadata>
      generateMemoriesAsync(GenerateMemoriesRequest request) {
    return generateMemoriesOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate memories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   GenerateMemoriesRequest request =
   *       GenerateMemoriesRequest.newBuilder()
   *           .setParent(
   *               ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]")
   *                   .toString())
   *           .setDisableConsolidation(true)
   *           .putAllScope(new HashMap<String, String>())
   *           .build();
   *   OperationFuture<GenerateMemoriesResponse, GenerateMemoriesOperationMetadata> future =
   *       memoryBankServiceClient.generateMemoriesOperationCallable().futureCall(request);
   *   // Do something.
   *   GenerateMemoriesResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          GenerateMemoriesRequest, GenerateMemoriesResponse, GenerateMemoriesOperationMetadata>
      generateMemoriesOperationCallable() {
    return stub.generateMemoriesOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generate memories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   GenerateMemoriesRequest request =
   *       GenerateMemoriesRequest.newBuilder()
   *           .setParent(
   *               ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]")
   *                   .toString())
   *           .setDisableConsolidation(true)
   *           .putAllScope(new HashMap<String, String>())
   *           .build();
   *   ApiFuture<Operation> future =
   *       memoryBankServiceClient.generateMemoriesCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateMemoriesRequest, Operation> generateMemoriesCallable() {
    return stub.generateMemoriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve memories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   ReasoningEngineName parent =
   *       ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]");
   *   RetrieveMemoriesResponse response = memoryBankServiceClient.retrieveMemories(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the ReasoningEngine to retrieve memories from.
   *     Format: `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetrieveMemoriesResponse retrieveMemories(ReasoningEngineName parent) {
    RetrieveMemoriesRequest request =
        RetrieveMemoriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return retrieveMemories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve memories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   String parent =
   *       ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]").toString();
   *   RetrieveMemoriesResponse response = memoryBankServiceClient.retrieveMemories(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the ReasoningEngine to retrieve memories from.
   *     Format: `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetrieveMemoriesResponse retrieveMemories(String parent) {
    RetrieveMemoriesRequest request =
        RetrieveMemoriesRequest.newBuilder().setParent(parent).build();
    return retrieveMemories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve memories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   RetrieveMemoriesRequest request =
   *       RetrieveMemoriesRequest.newBuilder()
   *           .setParent(
   *               ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]")
   *                   .toString())
   *           .putAllScope(new HashMap<String, String>())
   *           .build();
   *   RetrieveMemoriesResponse response = memoryBankServiceClient.retrieveMemories(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RetrieveMemoriesResponse retrieveMemories(RetrieveMemoriesRequest request) {
    return retrieveMemoriesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve memories.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   RetrieveMemoriesRequest request =
   *       RetrieveMemoriesRequest.newBuilder()
   *           .setParent(
   *               ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]")
   *                   .toString())
   *           .putAllScope(new HashMap<String, String>())
   *           .build();
   *   ApiFuture<RetrieveMemoriesResponse> future =
   *       memoryBankServiceClient.retrieveMemoriesCallable().futureCall(request);
   *   // Do something.
   *   RetrieveMemoriesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RetrieveMemoriesRequest, RetrieveMemoriesResponse>
      retrieveMemoriesCallable() {
    return stub.retrieveMemoriesCallable();
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
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : memoryBankServiceClient.listLocations(request).iterateAll()) {
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
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       memoryBankServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         memoryBankServiceClient.listLocationsCallable().call(request);
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
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = memoryBankServiceClient.getLocation(request);
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
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       memoryBankServiceClient.getLocationCallable().futureCall(request);
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
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = memoryBankServiceClient.setIamPolicy(request);
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
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = memoryBankServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = memoryBankServiceClient.getIamPolicy(request);
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
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = memoryBankServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = memoryBankServiceClient.testIamPermissions(request);
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
   * try (MemoryBankServiceClient memoryBankServiceClient = MemoryBankServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       memoryBankServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListMemoriesPagedResponse
      extends AbstractPagedListResponse<
          ListMemoriesRequest,
          ListMemoriesResponse,
          Memory,
          ListMemoriesPage,
          ListMemoriesFixedSizeCollection> {

    public static ApiFuture<ListMemoriesPagedResponse> createAsync(
        PageContext<ListMemoriesRequest, ListMemoriesResponse, Memory> context,
        ApiFuture<ListMemoriesResponse> futureResponse) {
      ApiFuture<ListMemoriesPage> futurePage =
          ListMemoriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMemoriesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMemoriesPagedResponse(ListMemoriesPage page) {
      super(page, ListMemoriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMemoriesPage
      extends AbstractPage<ListMemoriesRequest, ListMemoriesResponse, Memory, ListMemoriesPage> {

    private ListMemoriesPage(
        PageContext<ListMemoriesRequest, ListMemoriesResponse, Memory> context,
        ListMemoriesResponse response) {
      super(context, response);
    }

    private static ListMemoriesPage createEmptyPage() {
      return new ListMemoriesPage(null, null);
    }

    @Override
    protected ListMemoriesPage createPage(
        PageContext<ListMemoriesRequest, ListMemoriesResponse, Memory> context,
        ListMemoriesResponse response) {
      return new ListMemoriesPage(context, response);
    }

    @Override
    public ApiFuture<ListMemoriesPage> createPageAsync(
        PageContext<ListMemoriesRequest, ListMemoriesResponse, Memory> context,
        ApiFuture<ListMemoriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMemoriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMemoriesRequest,
          ListMemoriesResponse,
          Memory,
          ListMemoriesPage,
          ListMemoriesFixedSizeCollection> {

    private ListMemoriesFixedSizeCollection(List<ListMemoriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMemoriesFixedSizeCollection createEmptyCollection() {
      return new ListMemoriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMemoriesFixedSizeCollection createCollection(
        List<ListMemoriesPage> pages, int collectionSize) {
      return new ListMemoriesFixedSizeCollection(pages, collectionSize);
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
