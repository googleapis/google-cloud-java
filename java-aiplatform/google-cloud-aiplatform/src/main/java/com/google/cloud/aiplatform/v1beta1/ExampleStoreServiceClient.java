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
import com.google.cloud.aiplatform.v1beta1.stub.ExampleStoreServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.ExampleStoreServiceStubSettings;
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
 * Service Description: A service for managing and retrieving few-shot examples.
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
 * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
 *   ExampleStoreName name = ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]");
 *   ExampleStore response = exampleStoreServiceClient.getExampleStore(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ExampleStoreServiceClient object to clean up resources
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
 *      <td><p> CreateExampleStore</td>
 *      <td><p> Create an ExampleStore.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createExampleStoreAsync(CreateExampleStoreRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createExampleStoreAsync(LocationName parent, ExampleStore exampleStore)
 *           <li><p> createExampleStoreAsync(String parent, ExampleStore exampleStore)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createExampleStoreOperationCallable()
 *           <li><p> createExampleStoreCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetExampleStore</td>
 *      <td><p> Get an ExampleStore.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getExampleStore(GetExampleStoreRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getExampleStore(ExampleStoreName name)
 *           <li><p> getExampleStore(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getExampleStoreCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateExampleStore</td>
 *      <td><p> Update an ExampleStore.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateExampleStoreAsync(UpdateExampleStoreRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateExampleStoreAsync(ExampleStore exampleStore, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateExampleStoreOperationCallable()
 *           <li><p> updateExampleStoreCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteExampleStore</td>
 *      <td><p> Delete an ExampleStore.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteExampleStoreAsync(DeleteExampleStoreRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteExampleStoreAsync(ExampleStoreName name)
 *           <li><p> deleteExampleStoreAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteExampleStoreOperationCallable()
 *           <li><p> deleteExampleStoreCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListExampleStores</td>
 *      <td><p> List ExampleStores in a Location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listExampleStores(ListExampleStoresRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listExampleStores(LocationName parent)
 *           <li><p> listExampleStores(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listExampleStoresPagedCallable()
 *           <li><p> listExampleStoresCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpsertExamples</td>
 *      <td><p> Create or update Examples in the Example Store.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> upsertExamples(UpsertExamplesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> upsertExamplesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RemoveExamples</td>
 *      <td><p> Remove Examples from the Example Store.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> removeExamples(RemoveExamplesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> removeExamplesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SearchExamples</td>
 *      <td><p> Search for similar Examples for given selection criteria.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchExamples(SearchExamplesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchExamplesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchExamples</td>
 *      <td><p> Get Examples from the Example Store.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchExamples(FetchExamplesRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchExamplesPagedCallable()
 *           <li><p> fetchExamplesCallable()
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
 * <p>This class can be customized by passing in a custom instance of ExampleStoreServiceSettings to
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
 * ExampleStoreServiceSettings exampleStoreServiceSettings =
 *     ExampleStoreServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ExampleStoreServiceClient exampleStoreServiceClient =
 *     ExampleStoreServiceClient.create(exampleStoreServiceSettings);
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
 * ExampleStoreServiceSettings exampleStoreServiceSettings =
 *     ExampleStoreServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ExampleStoreServiceClient exampleStoreServiceClient =
 *     ExampleStoreServiceClient.create(exampleStoreServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ExampleStoreServiceClient implements BackgroundResource {
  private final ExampleStoreServiceSettings settings;
  private final ExampleStoreServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of ExampleStoreServiceClient with default settings. */
  public static final ExampleStoreServiceClient create() throws IOException {
    return create(ExampleStoreServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ExampleStoreServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ExampleStoreServiceClient create(ExampleStoreServiceSettings settings)
      throws IOException {
    return new ExampleStoreServiceClient(settings);
  }

  /**
   * Constructs an instance of ExampleStoreServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ExampleStoreServiceSettings).
   */
  public static final ExampleStoreServiceClient create(ExampleStoreServiceStub stub) {
    return new ExampleStoreServiceClient(stub);
  }

  /**
   * Constructs an instance of ExampleStoreServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ExampleStoreServiceClient(ExampleStoreServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ExampleStoreServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected ExampleStoreServiceClient(ExampleStoreServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final ExampleStoreServiceSettings getSettings() {
    return settings;
  }

  public ExampleStoreServiceStub getStub() {
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
   * Create an ExampleStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ExampleStore exampleStore = ExampleStore.newBuilder().build();
   *   ExampleStore response =
   *       exampleStoreServiceClient.createExampleStoreAsync(parent, exampleStore).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the ExampleStore in.
   *     Format: `projects/{project}/locations/{location}`
   * @param exampleStore Required. The Example Store to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExampleStore, CreateExampleStoreOperationMetadata>
      createExampleStoreAsync(LocationName parent, ExampleStore exampleStore) {
    CreateExampleStoreRequest request =
        CreateExampleStoreRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setExampleStore(exampleStore)
            .build();
    return createExampleStoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an ExampleStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ExampleStore exampleStore = ExampleStore.newBuilder().build();
   *   ExampleStore response =
   *       exampleStoreServiceClient.createExampleStoreAsync(parent, exampleStore).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the ExampleStore in.
   *     Format: `projects/{project}/locations/{location}`
   * @param exampleStore Required. The Example Store to be created.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExampleStore, CreateExampleStoreOperationMetadata>
      createExampleStoreAsync(String parent, ExampleStore exampleStore) {
    CreateExampleStoreRequest request =
        CreateExampleStoreRequest.newBuilder()
            .setParent(parent)
            .setExampleStore(exampleStore)
            .build();
    return createExampleStoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an ExampleStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   CreateExampleStoreRequest request =
   *       CreateExampleStoreRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setExampleStore(ExampleStore.newBuilder().build())
   *           .build();
   *   ExampleStore response = exampleStoreServiceClient.createExampleStoreAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExampleStore, CreateExampleStoreOperationMetadata>
      createExampleStoreAsync(CreateExampleStoreRequest request) {
    return createExampleStoreOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an ExampleStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   CreateExampleStoreRequest request =
   *       CreateExampleStoreRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setExampleStore(ExampleStore.newBuilder().build())
   *           .build();
   *   OperationFuture<ExampleStore, CreateExampleStoreOperationMetadata> future =
   *       exampleStoreServiceClient.createExampleStoreOperationCallable().futureCall(request);
   *   // Do something.
   *   ExampleStore response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateExampleStoreRequest, ExampleStore, CreateExampleStoreOperationMetadata>
      createExampleStoreOperationCallable() {
    return stub.createExampleStoreOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create an ExampleStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   CreateExampleStoreRequest request =
   *       CreateExampleStoreRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setExampleStore(ExampleStore.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       exampleStoreServiceClient.createExampleStoreCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateExampleStoreRequest, Operation> createExampleStoreCallable() {
    return stub.createExampleStoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an ExampleStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   ExampleStoreName name = ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]");
   *   ExampleStore response = exampleStoreServiceClient.getExampleStore(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ExampleStore. Format:
   *     `projects/{project}/locations/{location}/exampleStores/{example_store}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExampleStore getExampleStore(ExampleStoreName name) {
    GetExampleStoreRequest request =
        GetExampleStoreRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getExampleStore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an ExampleStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   String name = ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString();
   *   ExampleStore response = exampleStoreServiceClient.getExampleStore(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ExampleStore. Format:
   *     `projects/{project}/locations/{location}/exampleStores/{example_store}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExampleStore getExampleStore(String name) {
    GetExampleStoreRequest request = GetExampleStoreRequest.newBuilder().setName(name).build();
    return getExampleStore(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an ExampleStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   GetExampleStoreRequest request =
   *       GetExampleStoreRequest.newBuilder()
   *           .setName(ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
   *           .build();
   *   ExampleStore response = exampleStoreServiceClient.getExampleStore(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExampleStore getExampleStore(GetExampleStoreRequest request) {
    return getExampleStoreCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an ExampleStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   GetExampleStoreRequest request =
   *       GetExampleStoreRequest.newBuilder()
   *           .setName(ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
   *           .build();
   *   ApiFuture<ExampleStore> future =
   *       exampleStoreServiceClient.getExampleStoreCallable().futureCall(request);
   *   // Do something.
   *   ExampleStore response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetExampleStoreRequest, ExampleStore> getExampleStoreCallable() {
    return stub.getExampleStoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an ExampleStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   ExampleStore exampleStore = ExampleStore.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ExampleStore response =
   *       exampleStoreServiceClient.updateExampleStoreAsync(exampleStore, updateMask).get();
   * }
   * }</pre>
   *
   * @param exampleStore Required. The Example Store which replaces the resource on the server.
   * @param updateMask Optional. Mask specifying which fields to update. Supported fields:
   *     <p>&#42; `display_name` &#42; `description`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExampleStore, UpdateExampleStoreOperationMetadata>
      updateExampleStoreAsync(ExampleStore exampleStore, FieldMask updateMask) {
    UpdateExampleStoreRequest request =
        UpdateExampleStoreRequest.newBuilder()
            .setExampleStore(exampleStore)
            .setUpdateMask(updateMask)
            .build();
    return updateExampleStoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an ExampleStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   UpdateExampleStoreRequest request =
   *       UpdateExampleStoreRequest.newBuilder()
   *           .setExampleStore(ExampleStore.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ExampleStore response = exampleStoreServiceClient.updateExampleStoreAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExampleStore, UpdateExampleStoreOperationMetadata>
      updateExampleStoreAsync(UpdateExampleStoreRequest request) {
    return updateExampleStoreOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an ExampleStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   UpdateExampleStoreRequest request =
   *       UpdateExampleStoreRequest.newBuilder()
   *           .setExampleStore(ExampleStore.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<ExampleStore, UpdateExampleStoreOperationMetadata> future =
   *       exampleStoreServiceClient.updateExampleStoreOperationCallable().futureCall(request);
   *   // Do something.
   *   ExampleStore response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpdateExampleStoreRequest, ExampleStore, UpdateExampleStoreOperationMetadata>
      updateExampleStoreOperationCallable() {
    return stub.updateExampleStoreOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update an ExampleStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   UpdateExampleStoreRequest request =
   *       UpdateExampleStoreRequest.newBuilder()
   *           .setExampleStore(ExampleStore.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       exampleStoreServiceClient.updateExampleStoreCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateExampleStoreRequest, Operation> updateExampleStoreCallable() {
    return stub.updateExampleStoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an ExampleStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   ExampleStoreName name = ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]");
   *   exampleStoreServiceClient.deleteExampleStoreAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ExampleStore to be deleted. Format:
   *     `projects/{project}/locations/{location}/exampleStores/{example_store}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteExampleStoreOperationMetadata> deleteExampleStoreAsync(
      ExampleStoreName name) {
    DeleteExampleStoreRequest request =
        DeleteExampleStoreRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteExampleStoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an ExampleStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   String name = ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString();
   *   exampleStoreServiceClient.deleteExampleStoreAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the ExampleStore to be deleted. Format:
   *     `projects/{project}/locations/{location}/exampleStores/{example_store}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteExampleStoreOperationMetadata> deleteExampleStoreAsync(
      String name) {
    DeleteExampleStoreRequest request =
        DeleteExampleStoreRequest.newBuilder().setName(name).build();
    return deleteExampleStoreAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an ExampleStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   DeleteExampleStoreRequest request =
   *       DeleteExampleStoreRequest.newBuilder()
   *           .setName(ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
   *           .build();
   *   exampleStoreServiceClient.deleteExampleStoreAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteExampleStoreOperationMetadata> deleteExampleStoreAsync(
      DeleteExampleStoreRequest request) {
    return deleteExampleStoreOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an ExampleStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   DeleteExampleStoreRequest request =
   *       DeleteExampleStoreRequest.newBuilder()
   *           .setName(ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
   *           .build();
   *   OperationFuture<Empty, DeleteExampleStoreOperationMetadata> future =
   *       exampleStoreServiceClient.deleteExampleStoreOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteExampleStoreRequest, Empty, DeleteExampleStoreOperationMetadata>
      deleteExampleStoreOperationCallable() {
    return stub.deleteExampleStoreOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete an ExampleStore.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   DeleteExampleStoreRequest request =
   *       DeleteExampleStoreRequest.newBuilder()
   *           .setName(ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       exampleStoreServiceClient.deleteExampleStoreCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteExampleStoreRequest, Operation> deleteExampleStoreCallable() {
    return stub.deleteExampleStoreCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List ExampleStores in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ExampleStore element :
   *       exampleStoreServiceClient.listExampleStores(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the ExampleStores from.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExampleStoresPagedResponse listExampleStores(LocationName parent) {
    ListExampleStoresRequest request =
        ListExampleStoresRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listExampleStores(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List ExampleStores in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ExampleStore element :
   *       exampleStoreServiceClient.listExampleStores(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the ExampleStores from.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExampleStoresPagedResponse listExampleStores(String parent) {
    ListExampleStoresRequest request =
        ListExampleStoresRequest.newBuilder().setParent(parent).build();
    return listExampleStores(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List ExampleStores in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   ListExampleStoresRequest request =
   *       ListExampleStoresRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ExampleStore element :
   *       exampleStoreServiceClient.listExampleStores(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListExampleStoresPagedResponse listExampleStores(ListExampleStoresRequest request) {
    return listExampleStoresPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List ExampleStores in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   ListExampleStoresRequest request =
   *       ListExampleStoresRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ExampleStore> future =
   *       exampleStoreServiceClient.listExampleStoresPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ExampleStore element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListExampleStoresRequest, ListExampleStoresPagedResponse>
      listExampleStoresPagedCallable() {
    return stub.listExampleStoresPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List ExampleStores in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   ListExampleStoresRequest request =
   *       ListExampleStoresRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListExampleStoresResponse response =
   *         exampleStoreServiceClient.listExampleStoresCallable().call(request);
   *     for (ExampleStore element : response.getExampleStoresList()) {
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
  public final UnaryCallable<ListExampleStoresRequest, ListExampleStoresResponse>
      listExampleStoresCallable() {
    return stub.listExampleStoresCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create or update Examples in the Example Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   UpsertExamplesRequest request =
   *       UpsertExamplesRequest.newBuilder()
   *           .setExampleStore(
   *               ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
   *           .addAllExamples(new ArrayList<Example>())
   *           .setOverwrite(true)
   *           .build();
   *   UpsertExamplesResponse response = exampleStoreServiceClient.upsertExamples(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UpsertExamplesResponse upsertExamples(UpsertExamplesRequest request) {
    return upsertExamplesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create or update Examples in the Example Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   UpsertExamplesRequest request =
   *       UpsertExamplesRequest.newBuilder()
   *           .setExampleStore(
   *               ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
   *           .addAllExamples(new ArrayList<Example>())
   *           .setOverwrite(true)
   *           .build();
   *   ApiFuture<UpsertExamplesResponse> future =
   *       exampleStoreServiceClient.upsertExamplesCallable().futureCall(request);
   *   // Do something.
   *   UpsertExamplesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpsertExamplesRequest, UpsertExamplesResponse>
      upsertExamplesCallable() {
    return stub.upsertExamplesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove Examples from the Example Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   RemoveExamplesRequest request =
   *       RemoveExamplesRequest.newBuilder()
   *           .setExampleStore(
   *               ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
   *           .addAllExampleIds(new ArrayList<String>())
   *           .build();
   *   RemoveExamplesResponse response = exampleStoreServiceClient.removeExamples(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RemoveExamplesResponse removeExamples(RemoveExamplesRequest request) {
    return removeExamplesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove Examples from the Example Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   RemoveExamplesRequest request =
   *       RemoveExamplesRequest.newBuilder()
   *           .setExampleStore(
   *               ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
   *           .addAllExampleIds(new ArrayList<String>())
   *           .build();
   *   ApiFuture<RemoveExamplesResponse> future =
   *       exampleStoreServiceClient.removeExamplesCallable().futureCall(request);
   *   // Do something.
   *   RemoveExamplesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveExamplesRequest, RemoveExamplesResponse>
      removeExamplesCallable() {
    return stub.removeExamplesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search for similar Examples for given selection criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   SearchExamplesRequest request =
   *       SearchExamplesRequest.newBuilder()
   *           .setExampleStore(
   *               ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
   *           .setTopK(110545921)
   *           .build();
   *   SearchExamplesResponse response = exampleStoreServiceClient.searchExamples(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchExamplesResponse searchExamples(SearchExamplesRequest request) {
    return searchExamplesCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search for similar Examples for given selection criteria.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   SearchExamplesRequest request =
   *       SearchExamplesRequest.newBuilder()
   *           .setExampleStore(
   *               ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
   *           .setTopK(110545921)
   *           .build();
   *   ApiFuture<SearchExamplesResponse> future =
   *       exampleStoreServiceClient.searchExamplesCallable().futureCall(request);
   *   // Do something.
   *   SearchExamplesResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchExamplesRequest, SearchExamplesResponse>
      searchExamplesCallable() {
    return stub.searchExamplesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get Examples from the Example Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   FetchExamplesRequest request =
   *       FetchExamplesRequest.newBuilder()
   *           .setExampleStore(
   *               ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .addAllExampleIds(new ArrayList<String>())
   *           .build();
   *   for (Example element : exampleStoreServiceClient.fetchExamples(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchExamplesPagedResponse fetchExamples(FetchExamplesRequest request) {
    return fetchExamplesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get Examples from the Example Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   FetchExamplesRequest request =
   *       FetchExamplesRequest.newBuilder()
   *           .setExampleStore(
   *               ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .addAllExampleIds(new ArrayList<String>())
   *           .build();
   *   ApiFuture<Example> future =
   *       exampleStoreServiceClient.fetchExamplesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Example element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchExamplesRequest, FetchExamplesPagedResponse>
      fetchExamplesPagedCallable() {
    return stub.fetchExamplesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get Examples from the Example Store.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   FetchExamplesRequest request =
   *       FetchExamplesRequest.newBuilder()
   *           .setExampleStore(
   *               ExampleStoreName.of("[PROJECT]", "[LOCATION]", "[EXAMPLE_STORE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .addAllExampleIds(new ArrayList<String>())
   *           .build();
   *   while (true) {
   *     FetchExamplesResponse response =
   *         exampleStoreServiceClient.fetchExamplesCallable().call(request);
   *     for (Example element : response.getExamplesList()) {
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
  public final UnaryCallable<FetchExamplesRequest, FetchExamplesResponse> fetchExamplesCallable() {
    return stub.fetchExamplesCallable();
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
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : exampleStoreServiceClient.listLocations(request).iterateAll()) {
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
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       exampleStoreServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         exampleStoreServiceClient.listLocationsCallable().call(request);
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
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = exampleStoreServiceClient.getLocation(request);
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
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       exampleStoreServiceClient.getLocationCallable().futureCall(request);
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
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = exampleStoreServiceClient.setIamPolicy(request);
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
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       exampleStoreServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = exampleStoreServiceClient.getIamPolicy(request);
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
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       exampleStoreServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = exampleStoreServiceClient.testIamPermissions(request);
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
   * try (ExampleStoreServiceClient exampleStoreServiceClient = ExampleStoreServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       exampleStoreServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListExampleStoresPagedResponse
      extends AbstractPagedListResponse<
          ListExampleStoresRequest,
          ListExampleStoresResponse,
          ExampleStore,
          ListExampleStoresPage,
          ListExampleStoresFixedSizeCollection> {

    public static ApiFuture<ListExampleStoresPagedResponse> createAsync(
        PageContext<ListExampleStoresRequest, ListExampleStoresResponse, ExampleStore> context,
        ApiFuture<ListExampleStoresResponse> futureResponse) {
      ApiFuture<ListExampleStoresPage> futurePage =
          ListExampleStoresPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListExampleStoresPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListExampleStoresPagedResponse(ListExampleStoresPage page) {
      super(page, ListExampleStoresFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListExampleStoresPage
      extends AbstractPage<
          ListExampleStoresRequest,
          ListExampleStoresResponse,
          ExampleStore,
          ListExampleStoresPage> {

    private ListExampleStoresPage(
        PageContext<ListExampleStoresRequest, ListExampleStoresResponse, ExampleStore> context,
        ListExampleStoresResponse response) {
      super(context, response);
    }

    private static ListExampleStoresPage createEmptyPage() {
      return new ListExampleStoresPage(null, null);
    }

    @Override
    protected ListExampleStoresPage createPage(
        PageContext<ListExampleStoresRequest, ListExampleStoresResponse, ExampleStore> context,
        ListExampleStoresResponse response) {
      return new ListExampleStoresPage(context, response);
    }

    @Override
    public ApiFuture<ListExampleStoresPage> createPageAsync(
        PageContext<ListExampleStoresRequest, ListExampleStoresResponse, ExampleStore> context,
        ApiFuture<ListExampleStoresResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListExampleStoresFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListExampleStoresRequest,
          ListExampleStoresResponse,
          ExampleStore,
          ListExampleStoresPage,
          ListExampleStoresFixedSizeCollection> {

    private ListExampleStoresFixedSizeCollection(
        List<ListExampleStoresPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListExampleStoresFixedSizeCollection createEmptyCollection() {
      return new ListExampleStoresFixedSizeCollection(null, 0);
    }

    @Override
    protected ListExampleStoresFixedSizeCollection createCollection(
        List<ListExampleStoresPage> pages, int collectionSize) {
      return new ListExampleStoresFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class FetchExamplesPagedResponse
      extends AbstractPagedListResponse<
          FetchExamplesRequest,
          FetchExamplesResponse,
          Example,
          FetchExamplesPage,
          FetchExamplesFixedSizeCollection> {

    public static ApiFuture<FetchExamplesPagedResponse> createAsync(
        PageContext<FetchExamplesRequest, FetchExamplesResponse, Example> context,
        ApiFuture<FetchExamplesResponse> futureResponse) {
      ApiFuture<FetchExamplesPage> futurePage =
          FetchExamplesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new FetchExamplesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private FetchExamplesPagedResponse(FetchExamplesPage page) {
      super(page, FetchExamplesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class FetchExamplesPage
      extends AbstractPage<
          FetchExamplesRequest, FetchExamplesResponse, Example, FetchExamplesPage> {

    private FetchExamplesPage(
        PageContext<FetchExamplesRequest, FetchExamplesResponse, Example> context,
        FetchExamplesResponse response) {
      super(context, response);
    }

    private static FetchExamplesPage createEmptyPage() {
      return new FetchExamplesPage(null, null);
    }

    @Override
    protected FetchExamplesPage createPage(
        PageContext<FetchExamplesRequest, FetchExamplesResponse, Example> context,
        FetchExamplesResponse response) {
      return new FetchExamplesPage(context, response);
    }

    @Override
    public ApiFuture<FetchExamplesPage> createPageAsync(
        PageContext<FetchExamplesRequest, FetchExamplesResponse, Example> context,
        ApiFuture<FetchExamplesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class FetchExamplesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          FetchExamplesRequest,
          FetchExamplesResponse,
          Example,
          FetchExamplesPage,
          FetchExamplesFixedSizeCollection> {

    private FetchExamplesFixedSizeCollection(List<FetchExamplesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FetchExamplesFixedSizeCollection createEmptyCollection() {
      return new FetchExamplesFixedSizeCollection(null, 0);
    }

    @Override
    protected FetchExamplesFixedSizeCollection createCollection(
        List<FetchExamplesPage> pages, int collectionSize) {
      return new FetchExamplesFixedSizeCollection(pages, collectionSize);
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
