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
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.aiplatform.v1beta1.stub.ReasoningEngineServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.ReasoningEngineServiceStubSettings;
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
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service for managing Vertex AI's Reasoning Engines.
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
 * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
 *     ReasoningEngineServiceClient.create()) {
 *   ReasoningEngineName name =
 *       ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]");
 *   ReasoningEngine response = reasoningEngineServiceClient.getReasoningEngine(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ReasoningEngineServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateReasoningEngine</td>
 *      <td><p> Creates a reasoning engine.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createReasoningEngineAsync(CreateReasoningEngineRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createReasoningEngineAsync(LocationName parent, ReasoningEngine reasoningEngine)
 *           <li><p> createReasoningEngineAsync(String parent, ReasoningEngine reasoningEngine)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createReasoningEngineOperationCallable()
 *           <li><p> createReasoningEngineCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetReasoningEngine</td>
 *      <td><p> Gets a reasoning engine.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getReasoningEngine(GetReasoningEngineRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getReasoningEngine(ReasoningEngineName name)
 *           <li><p> getReasoningEngine(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getReasoningEngineCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListReasoningEngines</td>
 *      <td><p> Lists reasoning engines in a location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listReasoningEngines(ListReasoningEnginesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listReasoningEngines(LocationName parent)
 *           <li><p> listReasoningEngines(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listReasoningEnginesPagedCallable()
 *           <li><p> listReasoningEnginesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteReasoningEngine</td>
 *      <td><p> Deletes a reasoning engine.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteReasoningEngineAsync(DeleteReasoningEngineRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteReasoningEngineAsync(ReasoningEngineName name)
 *           <li><p> deleteReasoningEngineAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteReasoningEngineOperationCallable()
 *           <li><p> deleteReasoningEngineCallable()
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
 * <p>This class can be customized by passing in a custom instance of ReasoningEngineServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ReasoningEngineServiceSettings reasoningEngineServiceSettings =
 *     ReasoningEngineServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ReasoningEngineServiceClient reasoningEngineServiceClient =
 *     ReasoningEngineServiceClient.create(reasoningEngineServiceSettings);
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
 * ReasoningEngineServiceSettings reasoningEngineServiceSettings =
 *     ReasoningEngineServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ReasoningEngineServiceClient reasoningEngineServiceClient =
 *     ReasoningEngineServiceClient.create(reasoningEngineServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ReasoningEngineServiceClient implements BackgroundResource {
  private final ReasoningEngineServiceSettings settings;
  private final ReasoningEngineServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of ReasoningEngineServiceClient with default settings. */
  public static final ReasoningEngineServiceClient create() throws IOException {
    return create(ReasoningEngineServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ReasoningEngineServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ReasoningEngineServiceClient create(ReasoningEngineServiceSettings settings)
      throws IOException {
    return new ReasoningEngineServiceClient(settings);
  }

  /**
   * Constructs an instance of ReasoningEngineServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ReasoningEngineServiceSettings).
   */
  public static final ReasoningEngineServiceClient create(ReasoningEngineServiceStub stub) {
    return new ReasoningEngineServiceClient(stub);
  }

  /**
   * Constructs an instance of ReasoningEngineServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ReasoningEngineServiceClient(ReasoningEngineServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((ReasoningEngineServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected ReasoningEngineServiceClient(ReasoningEngineServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final ReasoningEngineServiceSettings getSettings() {
    return settings;
  }

  public ReasoningEngineServiceStub getStub() {
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
   * Creates a reasoning engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   ReasoningEngine reasoningEngine = ReasoningEngine.newBuilder().build();
   *   ReasoningEngine response =
   *       reasoningEngineServiceClient.createReasoningEngineAsync(parent, reasoningEngine).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the ReasoningEngine in.
   *     Format: `projects/{project}/locations/{location}`
   * @param reasoningEngine Required. The ReasoningEngine to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ReasoningEngine, CreateReasoningEngineOperationMetadata>
      createReasoningEngineAsync(LocationName parent, ReasoningEngine reasoningEngine) {
    CreateReasoningEngineRequest request =
        CreateReasoningEngineRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setReasoningEngine(reasoningEngine)
            .build();
    return createReasoningEngineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a reasoning engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   ReasoningEngine reasoningEngine = ReasoningEngine.newBuilder().build();
   *   ReasoningEngine response =
   *       reasoningEngineServiceClient.createReasoningEngineAsync(parent, reasoningEngine).get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the ReasoningEngine in.
   *     Format: `projects/{project}/locations/{location}`
   * @param reasoningEngine Required. The ReasoningEngine to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ReasoningEngine, CreateReasoningEngineOperationMetadata>
      createReasoningEngineAsync(String parent, ReasoningEngine reasoningEngine) {
    CreateReasoningEngineRequest request =
        CreateReasoningEngineRequest.newBuilder()
            .setParent(parent)
            .setReasoningEngine(reasoningEngine)
            .build();
    return createReasoningEngineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a reasoning engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   CreateReasoningEngineRequest request =
   *       CreateReasoningEngineRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setReasoningEngine(ReasoningEngine.newBuilder().build())
   *           .build();
   *   ReasoningEngine response =
   *       reasoningEngineServiceClient.createReasoningEngineAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ReasoningEngine, CreateReasoningEngineOperationMetadata>
      createReasoningEngineAsync(CreateReasoningEngineRequest request) {
    return createReasoningEngineOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a reasoning engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   CreateReasoningEngineRequest request =
   *       CreateReasoningEngineRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setReasoningEngine(ReasoningEngine.newBuilder().build())
   *           .build();
   *   OperationFuture<ReasoningEngine, CreateReasoningEngineOperationMetadata> future =
   *       reasoningEngineServiceClient.createReasoningEngineOperationCallable().futureCall(request);
   *   // Do something.
   *   ReasoningEngine response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateReasoningEngineRequest, ReasoningEngine, CreateReasoningEngineOperationMetadata>
      createReasoningEngineOperationCallable() {
    return stub.createReasoningEngineOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a reasoning engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   CreateReasoningEngineRequest request =
   *       CreateReasoningEngineRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setReasoningEngine(ReasoningEngine.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       reasoningEngineServiceClient.createReasoningEngineCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateReasoningEngineRequest, Operation>
      createReasoningEngineCallable() {
    return stub.createReasoningEngineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a reasoning engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   ReasoningEngineName name =
   *       ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]");
   *   ReasoningEngine response = reasoningEngineServiceClient.getReasoningEngine(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ReasoningEngine resource. Format:
   *     `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReasoningEngine getReasoningEngine(ReasoningEngineName name) {
    GetReasoningEngineRequest request =
        GetReasoningEngineRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getReasoningEngine(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a reasoning engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   String name =
   *       ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]").toString();
   *   ReasoningEngine response = reasoningEngineServiceClient.getReasoningEngine(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ReasoningEngine resource. Format:
   *     `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReasoningEngine getReasoningEngine(String name) {
    GetReasoningEngineRequest request =
        GetReasoningEngineRequest.newBuilder().setName(name).build();
    return getReasoningEngine(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a reasoning engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   GetReasoningEngineRequest request =
   *       GetReasoningEngineRequest.newBuilder()
   *           .setName(
   *               ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]")
   *                   .toString())
   *           .build();
   *   ReasoningEngine response = reasoningEngineServiceClient.getReasoningEngine(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReasoningEngine getReasoningEngine(GetReasoningEngineRequest request) {
    return getReasoningEngineCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a reasoning engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   GetReasoningEngineRequest request =
   *       GetReasoningEngineRequest.newBuilder()
   *           .setName(
   *               ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ReasoningEngine> future =
   *       reasoningEngineServiceClient.getReasoningEngineCallable().futureCall(request);
   *   // Do something.
   *   ReasoningEngine response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReasoningEngineRequest, ReasoningEngine>
      getReasoningEngineCallable() {
    return stub.getReasoningEngineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists reasoning engines in a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (ReasoningEngine element :
   *       reasoningEngineServiceClient.listReasoningEngines(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the ReasoningEngines from.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReasoningEnginesPagedResponse listReasoningEngines(LocationName parent) {
    ListReasoningEnginesRequest request =
        ListReasoningEnginesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReasoningEngines(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists reasoning engines in a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (ReasoningEngine element :
   *       reasoningEngineServiceClient.listReasoningEngines(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to list the ReasoningEngines from.
   *     Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReasoningEnginesPagedResponse listReasoningEngines(String parent) {
    ListReasoningEnginesRequest request =
        ListReasoningEnginesRequest.newBuilder().setParent(parent).build();
    return listReasoningEngines(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists reasoning engines in a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   ListReasoningEnginesRequest request =
   *       ListReasoningEnginesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ReasoningEngine element :
   *       reasoningEngineServiceClient.listReasoningEngines(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReasoningEnginesPagedResponse listReasoningEngines(
      ListReasoningEnginesRequest request) {
    return listReasoningEnginesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists reasoning engines in a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   ListReasoningEnginesRequest request =
   *       ListReasoningEnginesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ReasoningEngine> future =
   *       reasoningEngineServiceClient.listReasoningEnginesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ReasoningEngine element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReasoningEnginesRequest, ListReasoningEnginesPagedResponse>
      listReasoningEnginesPagedCallable() {
    return stub.listReasoningEnginesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists reasoning engines in a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   ListReasoningEnginesRequest request =
   *       ListReasoningEnginesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListReasoningEnginesResponse response =
   *         reasoningEngineServiceClient.listReasoningEnginesCallable().call(request);
   *     for (ReasoningEngine element : response.getReasoningEnginesList()) {
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
  public final UnaryCallable<ListReasoningEnginesRequest, ListReasoningEnginesResponse>
      listReasoningEnginesCallable() {
    return stub.listReasoningEnginesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a reasoning engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   ReasoningEngineName name =
   *       ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]");
   *   reasoningEngineServiceClient.deleteReasoningEngineAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the ReasoningEngine resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteReasoningEngineAsync(
      ReasoningEngineName name) {
    DeleteReasoningEngineRequest request =
        DeleteReasoningEngineRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteReasoningEngineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a reasoning engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   String name =
   *       ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]").toString();
   *   reasoningEngineServiceClient.deleteReasoningEngineAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the ReasoningEngine resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteReasoningEngineAsync(
      String name) {
    DeleteReasoningEngineRequest request =
        DeleteReasoningEngineRequest.newBuilder().setName(name).build();
    return deleteReasoningEngineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a reasoning engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   DeleteReasoningEngineRequest request =
   *       DeleteReasoningEngineRequest.newBuilder()
   *           .setName(
   *               ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]")
   *                   .toString())
   *           .build();
   *   reasoningEngineServiceClient.deleteReasoningEngineAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteReasoningEngineAsync(
      DeleteReasoningEngineRequest request) {
    return deleteReasoningEngineOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a reasoning engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   DeleteReasoningEngineRequest request =
   *       DeleteReasoningEngineRequest.newBuilder()
   *           .setName(
   *               ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       reasoningEngineServiceClient.deleteReasoningEngineOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteReasoningEngineRequest, Empty, DeleteOperationMetadata>
      deleteReasoningEngineOperationCallable() {
    return stub.deleteReasoningEngineOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a reasoning engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   DeleteReasoningEngineRequest request =
   *       DeleteReasoningEngineRequest.newBuilder()
   *           .setName(
   *               ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       reasoningEngineServiceClient.deleteReasoningEngineCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteReasoningEngineRequest, Operation>
      deleteReasoningEngineCallable() {
    return stub.deleteReasoningEngineCallable();
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
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : reasoningEngineServiceClient.listLocations(request).iterateAll()) {
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
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       reasoningEngineServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         reasoningEngineServiceClient.listLocationsCallable().call(request);
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
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = reasoningEngineServiceClient.getLocation(request);
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
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       reasoningEngineServiceClient.getLocationCallable().futureCall(request);
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
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = reasoningEngineServiceClient.setIamPolicy(request);
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
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
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
   *       reasoningEngineServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = reasoningEngineServiceClient.getIamPolicy(request);
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
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       reasoningEngineServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response =
   *       reasoningEngineServiceClient.testIamPermissions(request);
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
   * try (ReasoningEngineServiceClient reasoningEngineServiceClient =
   *     ReasoningEngineServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       reasoningEngineServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListReasoningEnginesPagedResponse
      extends AbstractPagedListResponse<
          ListReasoningEnginesRequest,
          ListReasoningEnginesResponse,
          ReasoningEngine,
          ListReasoningEnginesPage,
          ListReasoningEnginesFixedSizeCollection> {

    public static ApiFuture<ListReasoningEnginesPagedResponse> createAsync(
        PageContext<ListReasoningEnginesRequest, ListReasoningEnginesResponse, ReasoningEngine>
            context,
        ApiFuture<ListReasoningEnginesResponse> futureResponse) {
      ApiFuture<ListReasoningEnginesPage> futurePage =
          ListReasoningEnginesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListReasoningEnginesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListReasoningEnginesPagedResponse(ListReasoningEnginesPage page) {
      super(page, ListReasoningEnginesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReasoningEnginesPage
      extends AbstractPage<
          ListReasoningEnginesRequest,
          ListReasoningEnginesResponse,
          ReasoningEngine,
          ListReasoningEnginesPage> {

    private ListReasoningEnginesPage(
        PageContext<ListReasoningEnginesRequest, ListReasoningEnginesResponse, ReasoningEngine>
            context,
        ListReasoningEnginesResponse response) {
      super(context, response);
    }

    private static ListReasoningEnginesPage createEmptyPage() {
      return new ListReasoningEnginesPage(null, null);
    }

    @Override
    protected ListReasoningEnginesPage createPage(
        PageContext<ListReasoningEnginesRequest, ListReasoningEnginesResponse, ReasoningEngine>
            context,
        ListReasoningEnginesResponse response) {
      return new ListReasoningEnginesPage(context, response);
    }

    @Override
    public ApiFuture<ListReasoningEnginesPage> createPageAsync(
        PageContext<ListReasoningEnginesRequest, ListReasoningEnginesResponse, ReasoningEngine>
            context,
        ApiFuture<ListReasoningEnginesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReasoningEnginesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReasoningEnginesRequest,
          ListReasoningEnginesResponse,
          ReasoningEngine,
          ListReasoningEnginesPage,
          ListReasoningEnginesFixedSizeCollection> {

    private ListReasoningEnginesFixedSizeCollection(
        List<ListReasoningEnginesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReasoningEnginesFixedSizeCollection createEmptyCollection() {
      return new ListReasoningEnginesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReasoningEnginesFixedSizeCollection createCollection(
        List<ListReasoningEnginesPage> pages, int collectionSize) {
      return new ListReasoningEnginesFixedSizeCollection(pages, collectionSize);
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
