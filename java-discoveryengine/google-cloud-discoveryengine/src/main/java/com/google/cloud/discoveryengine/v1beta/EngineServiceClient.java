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

package com.google.cloud.discoveryengine.v1beta;

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
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.discoveryengine.v1beta.stub.EngineServiceStub;
import com.google.cloud.discoveryengine.v1beta.stub.EngineServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing [Engine][google.cloud.discoveryengine.v1beta.Engine]
 * configuration.
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
 * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
 *   Engine engine = Engine.newBuilder().build();
 *   FieldMask updateMask = FieldMask.newBuilder().build();
 *   Engine response = engineServiceClient.updateEngine(engine, updateMask);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the EngineServiceClient object to clean up resources such
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
 *      <td><p> CreateEngine</td>
 *      <td><p> Creates an [Engine][google.cloud.discoveryengine.v1beta.Engine].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createEngineAsync(CreateEngineRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createEngineAsync(CollectionName parent, Engine engine, String engineId)
 *           <li><p> createEngineAsync(String parent, Engine engine, String engineId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createEngineOperationCallable()
 *           <li><p> createEngineCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteEngine</td>
 *      <td><p> Deletes an [Engine][google.cloud.discoveryengine.v1beta.Engine].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteEngineAsync(DeleteEngineRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteEngineAsync(EngineName name)
 *           <li><p> deleteEngineAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteEngineOperationCallable()
 *           <li><p> deleteEngineCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateEngine</td>
 *      <td><p> Updates an [Engine][google.cloud.discoveryengine.v1beta.Engine]</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateEngine(UpdateEngineRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateEngine(Engine engine, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateEngineCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetEngine</td>
 *      <td><p> Gets an [Engine][google.cloud.discoveryengine.v1beta.Engine].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getEngine(GetEngineRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getEngine(EngineName name)
 *           <li><p> getEngine(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getEngineCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEngines</td>
 *      <td><p> Lists all the [Engine][google.cloud.discoveryengine.v1beta.Engine]s associated with the project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEngines(ListEnginesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEngines(CollectionName parent)
 *           <li><p> listEngines(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEnginesPagedCallable()
 *           <li><p> listEnginesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> PauseEngine</td>
 *      <td><p> Pauses the training of an existing [Engine][google.cloud.discoveryengine.v1beta.Engine]. Only applicable if [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> pauseEngine(PauseEngineRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> pauseEngine(EngineName name)
 *           <li><p> pauseEngine(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> pauseEngineCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ResumeEngine</td>
 *      <td><p> Resumes the training of an existing [Engine][google.cloud.discoveryengine.v1beta.Engine]. Only applicable if [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> resumeEngine(ResumeEngineRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> resumeEngine(EngineName name)
 *           <li><p> resumeEngine(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> resumeEngineCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> TuneEngine</td>
 *      <td><p> Tunes an existing [Engine][google.cloud.discoveryengine.v1beta.Engine]. Only applicable if [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> tuneEngineAsync(TuneEngineRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> tuneEngineAsync(EngineName name)
 *           <li><p> tuneEngineAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> tuneEngineOperationCallable()
 *           <li><p> tuneEngineCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetIamPolicy</td>
 *      <td><p> Gets the IAM access control policy for an [Engine][google.cloud.discoveryengine.v1beta.Engine]. A `NOT_FOUND` error is returned if the resource does not exist. An empty policy is returned if the resource exists but does not have a policy set on it.</td>
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
 *      <td><p> Sets the IAM access control policy for an [Engine][google.cloud.discoveryengine.v1beta.Engine]. A `NOT_FOUND` error is returned if the resource does not exist.
 * <p>  &#42;&#42;Important:&#42;&#42; When setting a policy directly on an Engine resource, the only recommended roles in the bindings are: `roles/discoveryengine.admin`, `roles/discoveryengine.agentspaceAdmin`, `roles/discoveryengine.user`, `roles/discoveryengine.agentspaceUser`, `roles/discoveryengine.viewer`, `roles/discoveryengine.agentspaceViewer`. Attempting to grant any other role will result in a warning in logging.</td>
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
 * <p>This class can be customized by passing in a custom instance of EngineServiceSettings to
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
 * EngineServiceSettings engineServiceSettings =
 *     EngineServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * EngineServiceClient engineServiceClient = EngineServiceClient.create(engineServiceSettings);
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
 * EngineServiceSettings engineServiceSettings =
 *     EngineServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * EngineServiceClient engineServiceClient = EngineServiceClient.create(engineServiceSettings);
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
 * EngineServiceSettings engineServiceSettings =
 *     EngineServiceSettings.newHttpJsonBuilder().build();
 * EngineServiceClient engineServiceClient = EngineServiceClient.create(engineServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class EngineServiceClient implements BackgroundResource {
  private final @Nullable EngineServiceSettings settings;
  private final EngineServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of EngineServiceClient with default settings. */
  public static final EngineServiceClient create() throws IOException {
    return create(EngineServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of EngineServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final EngineServiceClient create(EngineServiceSettings settings)
      throws IOException {
    return new EngineServiceClient(settings);
  }

  /**
   * Constructs an instance of EngineServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(EngineServiceSettings).
   */
  public static final EngineServiceClient create(EngineServiceStub stub) {
    return new EngineServiceClient(stub);
  }

  /**
   * Constructs an instance of EngineServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected EngineServiceClient(EngineServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((EngineServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected EngineServiceClient(EngineServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final @Nullable EngineServiceSettings getSettings() {
    return settings;
  }

  public EngineServiceStub getStub() {
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
   * Creates an [Engine][google.cloud.discoveryengine.v1beta.Engine].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
   *   Engine engine = Engine.newBuilder().build();
   *   String engineId = "engineId1820490493";
   *   Engine response = engineServiceClient.createEngineAsync(parent, engine, engineId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, such as
   *     `projects/{project}/locations/{location}/collections/{collection}`.
   * @param engine Required. The [Engine][google.cloud.discoveryengine.v1beta.Engine] to create.
   * @param engineId Required. The ID to use for the
   *     [Engine][google.cloud.discoveryengine.v1beta.Engine], which will become the final component
   *     of the [Engine][google.cloud.discoveryengine.v1beta.Engine]'s resource name.
   *     <p>This field must conform to [RFC-1034](https://tools.ietf.org/html/rfc1034) standard with
   *     a length limit of 63 characters. Otherwise, an INVALID_ARGUMENT error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Engine, CreateEngineMetadata> createEngineAsync(
      @Nullable CollectionName parent, Engine engine, String engineId) {
    CreateEngineRequest request =
        CreateEngineRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEngine(engine)
            .setEngineId(engineId)
            .build();
    return createEngineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [Engine][google.cloud.discoveryengine.v1beta.Engine].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   String parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString();
   *   Engine engine = Engine.newBuilder().build();
   *   String engineId = "engineId1820490493";
   *   Engine response = engineServiceClient.createEngineAsync(parent, engine, engineId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, such as
   *     `projects/{project}/locations/{location}/collections/{collection}`.
   * @param engine Required. The [Engine][google.cloud.discoveryengine.v1beta.Engine] to create.
   * @param engineId Required. The ID to use for the
   *     [Engine][google.cloud.discoveryengine.v1beta.Engine], which will become the final component
   *     of the [Engine][google.cloud.discoveryengine.v1beta.Engine]'s resource name.
   *     <p>This field must conform to [RFC-1034](https://tools.ietf.org/html/rfc1034) standard with
   *     a length limit of 63 characters. Otherwise, an INVALID_ARGUMENT error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Engine, CreateEngineMetadata> createEngineAsync(
      String parent, Engine engine, String engineId) {
    CreateEngineRequest request =
        CreateEngineRequest.newBuilder()
            .setParent(parent)
            .setEngine(engine)
            .setEngineId(engineId)
            .build();
    return createEngineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [Engine][google.cloud.discoveryengine.v1beta.Engine].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   CreateEngineRequest request =
   *       CreateEngineRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setEngine(Engine.newBuilder().build())
   *           .setEngineId("engineId1820490493")
   *           .build();
   *   Engine response = engineServiceClient.createEngineAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Engine, CreateEngineMetadata> createEngineAsync(
      CreateEngineRequest request) {
    return createEngineOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [Engine][google.cloud.discoveryengine.v1beta.Engine].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   CreateEngineRequest request =
   *       CreateEngineRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setEngine(Engine.newBuilder().build())
   *           .setEngineId("engineId1820490493")
   *           .build();
   *   OperationFuture<Engine, CreateEngineMetadata> future =
   *       engineServiceClient.createEngineOperationCallable().futureCall(request);
   *   // Do something.
   *   Engine response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateEngineRequest, Engine, CreateEngineMetadata>
      createEngineOperationCallable() {
    return stub.createEngineOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an [Engine][google.cloud.discoveryengine.v1beta.Engine].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   CreateEngineRequest request =
   *       CreateEngineRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setEngine(Engine.newBuilder().build())
   *           .setEngineId("engineId1820490493")
   *           .build();
   *   ApiFuture<Operation> future = engineServiceClient.createEngineCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEngineRequest, Operation> createEngineCallable() {
    return stub.createEngineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an [Engine][google.cloud.discoveryengine.v1beta.Engine].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   EngineName name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
   *   engineServiceClient.deleteEngineAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [Engine][google.cloud.discoveryengine.v1beta.Engine], such as
   *     `projects/{project}/locations/{location}/collections/{collection_id}/engines/{engine_id}`.
   *     <p>If the caller does not have permission to delete the
   *     [Engine][google.cloud.discoveryengine.v1beta.Engine], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   *     <p>If the [Engine][google.cloud.discoveryengine.v1beta.Engine] to delete does not exist, a
   *     NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteEngineMetadata> deleteEngineAsync(
      @Nullable EngineName name) {
    DeleteEngineRequest request =
        DeleteEngineRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteEngineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an [Engine][google.cloud.discoveryengine.v1beta.Engine].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   String name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString();
   *   engineServiceClient.deleteEngineAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [Engine][google.cloud.discoveryengine.v1beta.Engine], such as
   *     `projects/{project}/locations/{location}/collections/{collection_id}/engines/{engine_id}`.
   *     <p>If the caller does not have permission to delete the
   *     [Engine][google.cloud.discoveryengine.v1beta.Engine], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   *     <p>If the [Engine][google.cloud.discoveryengine.v1beta.Engine] to delete does not exist, a
   *     NOT_FOUND error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteEngineMetadata> deleteEngineAsync(String name) {
    DeleteEngineRequest request = DeleteEngineRequest.newBuilder().setName(name).build();
    return deleteEngineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an [Engine][google.cloud.discoveryengine.v1beta.Engine].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   DeleteEngineRequest request =
   *       DeleteEngineRequest.newBuilder()
   *           .setName(
   *               EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
   *           .build();
   *   engineServiceClient.deleteEngineAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteEngineMetadata> deleteEngineAsync(
      DeleteEngineRequest request) {
    return deleteEngineOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an [Engine][google.cloud.discoveryengine.v1beta.Engine].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   DeleteEngineRequest request =
   *       DeleteEngineRequest.newBuilder()
   *           .setName(
   *               EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
   *           .build();
   *   OperationFuture<Empty, DeleteEngineMetadata> future =
   *       engineServiceClient.deleteEngineOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteEngineRequest, Empty, DeleteEngineMetadata>
      deleteEngineOperationCallable() {
    return stub.deleteEngineOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an [Engine][google.cloud.discoveryengine.v1beta.Engine].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   DeleteEngineRequest request =
   *       DeleteEngineRequest.newBuilder()
   *           .setName(
   *               EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
   *           .build();
   *   ApiFuture<Operation> future = engineServiceClient.deleteEngineCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEngineRequest, Operation> deleteEngineCallable() {
    return stub.deleteEngineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [Engine][google.cloud.discoveryengine.v1beta.Engine]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   Engine engine = Engine.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Engine response = engineServiceClient.updateEngine(engine, updateMask);
   * }
   * }</pre>
   *
   * @param engine Required. The [Engine][google.cloud.discoveryengine.v1beta.Engine] to update.
   *     <p>If the caller does not have permission to update the
   *     [Engine][google.cloud.discoveryengine.v1beta.Engine], regardless of whether or not it
   *     exists, a PERMISSION_DENIED error is returned.
   *     <p>If the [Engine][google.cloud.discoveryengine.v1beta.Engine] to update does not exist, a
   *     NOT_FOUND error is returned.
   * @param updateMask Indicates which fields in the provided
   *     [Engine][google.cloud.discoveryengine.v1beta.Engine] to update.
   *     <p>If an unsupported or unknown field is provided, an INVALID_ARGUMENT error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Engine updateEngine(Engine engine, FieldMask updateMask) {
    UpdateEngineRequest request =
        UpdateEngineRequest.newBuilder().setEngine(engine).setUpdateMask(updateMask).build();
    return updateEngine(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [Engine][google.cloud.discoveryengine.v1beta.Engine]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   UpdateEngineRequest request =
   *       UpdateEngineRequest.newBuilder()
   *           .setEngine(Engine.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Engine response = engineServiceClient.updateEngine(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Engine updateEngine(UpdateEngineRequest request) {
    return updateEngineCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an [Engine][google.cloud.discoveryengine.v1beta.Engine]
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   UpdateEngineRequest request =
   *       UpdateEngineRequest.newBuilder()
   *           .setEngine(Engine.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Engine> future = engineServiceClient.updateEngineCallable().futureCall(request);
   *   // Do something.
   *   Engine response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEngineRequest, Engine> updateEngineCallable() {
    return stub.updateEngineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an [Engine][google.cloud.discoveryengine.v1beta.Engine].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   EngineName name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
   *   Engine response = engineServiceClient.getEngine(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [Engine][google.cloud.discoveryengine.v1beta.Engine], such as
   *     `projects/{project}/locations/{location}/collections/{collection_id}/engines/{engine_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Engine getEngine(@Nullable EngineName name) {
    GetEngineRequest request =
        GetEngineRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEngine(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an [Engine][google.cloud.discoveryengine.v1beta.Engine].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   String name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString();
   *   Engine response = engineServiceClient.getEngine(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [Engine][google.cloud.discoveryengine.v1beta.Engine], such as
   *     `projects/{project}/locations/{location}/collections/{collection_id}/engines/{engine_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Engine getEngine(String name) {
    GetEngineRequest request = GetEngineRequest.newBuilder().setName(name).build();
    return getEngine(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an [Engine][google.cloud.discoveryengine.v1beta.Engine].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   GetEngineRequest request =
   *       GetEngineRequest.newBuilder()
   *           .setName(
   *               EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
   *           .build();
   *   Engine response = engineServiceClient.getEngine(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Engine getEngine(GetEngineRequest request) {
    return getEngineCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an [Engine][google.cloud.discoveryengine.v1beta.Engine].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   GetEngineRequest request =
   *       GetEngineRequest.newBuilder()
   *           .setName(
   *               EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
   *           .build();
   *   ApiFuture<Engine> future = engineServiceClient.getEngineCallable().futureCall(request);
   *   // Do something.
   *   Engine response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEngineRequest, Engine> getEngineCallable() {
    return stub.getEngineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [Engine][google.cloud.discoveryengine.v1beta.Engine]s associated with the
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   CollectionName parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]");
   *   for (Engine element : engineServiceClient.listEngines(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, such as
   *     `projects/{project}/locations/{location}/collections/{collection_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEnginesPagedResponse listEngines(@Nullable CollectionName parent) {
    ListEnginesRequest request =
        ListEnginesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEngines(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [Engine][google.cloud.discoveryengine.v1beta.Engine]s associated with the
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   String parent = CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString();
   *   for (Engine element : engineServiceClient.listEngines(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name, such as
   *     `projects/{project}/locations/{location}/collections/{collection_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEnginesPagedResponse listEngines(String parent) {
    ListEnginesRequest request = ListEnginesRequest.newBuilder().setParent(parent).build();
    return listEngines(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [Engine][google.cloud.discoveryengine.v1beta.Engine]s associated with the
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   ListEnginesRequest request =
   *       ListEnginesRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Engine element : engineServiceClient.listEngines(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEnginesPagedResponse listEngines(ListEnginesRequest request) {
    return listEnginesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [Engine][google.cloud.discoveryengine.v1beta.Engine]s associated with the
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   ListEnginesRequest request =
   *       ListEnginesRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Engine> future = engineServiceClient.listEnginesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Engine element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEnginesRequest, ListEnginesPagedResponse>
      listEnginesPagedCallable() {
    return stub.listEnginesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the [Engine][google.cloud.discoveryengine.v1beta.Engine]s associated with the
   * project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   ListEnginesRequest request =
   *       ListEnginesRequest.newBuilder()
   *           .setParent(CollectionName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListEnginesResponse response = engineServiceClient.listEnginesCallable().call(request);
   *     for (Engine element : response.getEnginesList()) {
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
  public final UnaryCallable<ListEnginesRequest, ListEnginesResponse> listEnginesCallable() {
    return stub.listEnginesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses the training of an existing [Engine][google.cloud.discoveryengine.v1beta.Engine]. Only
   * applicable if [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
   * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   EngineName name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
   *   Engine response = engineServiceClient.pauseEngine(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the engine to pause. Format:
   *     `projects/{project}/locations/{location}/collections/{collection_id}/engines/{engine_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Engine pauseEngine(@Nullable EngineName name) {
    PauseEngineRequest request =
        PauseEngineRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return pauseEngine(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses the training of an existing [Engine][google.cloud.discoveryengine.v1beta.Engine]. Only
   * applicable if [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
   * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   String name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString();
   *   Engine response = engineServiceClient.pauseEngine(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the engine to pause. Format:
   *     `projects/{project}/locations/{location}/collections/{collection_id}/engines/{engine_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Engine pauseEngine(String name) {
    PauseEngineRequest request = PauseEngineRequest.newBuilder().setName(name).build();
    return pauseEngine(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses the training of an existing [Engine][google.cloud.discoveryengine.v1beta.Engine]. Only
   * applicable if [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
   * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   PauseEngineRequest request =
   *       PauseEngineRequest.newBuilder()
   *           .setName(
   *               EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
   *           .build();
   *   Engine response = engineServiceClient.pauseEngine(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Engine pauseEngine(PauseEngineRequest request) {
    return pauseEngineCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Pauses the training of an existing [Engine][google.cloud.discoveryengine.v1beta.Engine]. Only
   * applicable if [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
   * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   PauseEngineRequest request =
   *       PauseEngineRequest.newBuilder()
   *           .setName(
   *               EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
   *           .build();
   *   ApiFuture<Engine> future = engineServiceClient.pauseEngineCallable().futureCall(request);
   *   // Do something.
   *   Engine response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<PauseEngineRequest, Engine> pauseEngineCallable() {
    return stub.pauseEngineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes the training of an existing [Engine][google.cloud.discoveryengine.v1beta.Engine]. Only
   * applicable if [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
   * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   EngineName name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
   *   Engine response = engineServiceClient.resumeEngine(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the engine to resume. Format:
   *     `projects/{project}/locations/{location}/collections/{collection_id}/engines/{engine_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Engine resumeEngine(@Nullable EngineName name) {
    ResumeEngineRequest request =
        ResumeEngineRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return resumeEngine(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes the training of an existing [Engine][google.cloud.discoveryengine.v1beta.Engine]. Only
   * applicable if [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
   * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   String name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString();
   *   Engine response = engineServiceClient.resumeEngine(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the engine to resume. Format:
   *     `projects/{project}/locations/{location}/collections/{collection_id}/engines/{engine_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Engine resumeEngine(String name) {
    ResumeEngineRequest request = ResumeEngineRequest.newBuilder().setName(name).build();
    return resumeEngine(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes the training of an existing [Engine][google.cloud.discoveryengine.v1beta.Engine]. Only
   * applicable if [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
   * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   ResumeEngineRequest request =
   *       ResumeEngineRequest.newBuilder()
   *           .setName(
   *               EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
   *           .build();
   *   Engine response = engineServiceClient.resumeEngine(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Engine resumeEngine(ResumeEngineRequest request) {
    return resumeEngineCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Resumes the training of an existing [Engine][google.cloud.discoveryengine.v1beta.Engine]. Only
   * applicable if [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
   * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   ResumeEngineRequest request =
   *       ResumeEngineRequest.newBuilder()
   *           .setName(
   *               EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
   *           .build();
   *   ApiFuture<Engine> future = engineServiceClient.resumeEngineCallable().futureCall(request);
   *   // Do something.
   *   Engine response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ResumeEngineRequest, Engine> resumeEngineCallable() {
    return stub.resumeEngineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tunes an existing [Engine][google.cloud.discoveryengine.v1beta.Engine]. Only applicable if
   * [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
   * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   EngineName name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
   *   TuneEngineResponse response = engineServiceClient.tuneEngineAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the engine to tune. Format:
   *     `projects/{project}/locations/{location}/collections/{collection_id}/engines/{engine_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TuneEngineResponse, TuneEngineMetadata> tuneEngineAsync(
      @Nullable EngineName name) {
    TuneEngineRequest request =
        TuneEngineRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return tuneEngineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tunes an existing [Engine][google.cloud.discoveryengine.v1beta.Engine]. Only applicable if
   * [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
   * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   String name = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString();
   *   TuneEngineResponse response = engineServiceClient.tuneEngineAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the engine to tune. Format:
   *     `projects/{project}/locations/{location}/collections/{collection_id}/engines/{engine_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TuneEngineResponse, TuneEngineMetadata> tuneEngineAsync(
      String name) {
    TuneEngineRequest request = TuneEngineRequest.newBuilder().setName(name).build();
    return tuneEngineAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tunes an existing [Engine][google.cloud.discoveryengine.v1beta.Engine]. Only applicable if
   * [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
   * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   TuneEngineRequest request =
   *       TuneEngineRequest.newBuilder()
   *           .setName(
   *               EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
   *           .build();
   *   TuneEngineResponse response = engineServiceClient.tuneEngineAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<TuneEngineResponse, TuneEngineMetadata> tuneEngineAsync(
      TuneEngineRequest request) {
    return tuneEngineOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tunes an existing [Engine][google.cloud.discoveryengine.v1beta.Engine]. Only applicable if
   * [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
   * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   TuneEngineRequest request =
   *       TuneEngineRequest.newBuilder()
   *           .setName(
   *               EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
   *           .build();
   *   OperationFuture<TuneEngineResponse, TuneEngineMetadata> future =
   *       engineServiceClient.tuneEngineOperationCallable().futureCall(request);
   *   // Do something.
   *   TuneEngineResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<TuneEngineRequest, TuneEngineResponse, TuneEngineMetadata>
      tuneEngineOperationCallable() {
    return stub.tuneEngineOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Tunes an existing [Engine][google.cloud.discoveryengine.v1beta.Engine]. Only applicable if
   * [SolutionType][google.cloud.discoveryengine.v1beta.SolutionType] is
   * [SOLUTION_TYPE_RECOMMENDATION][google.cloud.discoveryengine.v1beta.SolutionType.SOLUTION_TYPE_RECOMMENDATION].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   TuneEngineRequest request =
   *       TuneEngineRequest.newBuilder()
   *           .setName(
   *               EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
   *           .build();
   *   ApiFuture<Operation> future = engineServiceClient.tuneEngineCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TuneEngineRequest, Operation> tuneEngineCallable() {
    return stub.tuneEngineCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAM access control policy for an [Engine][google.cloud.discoveryengine.v1beta.Engine].
   * A `NOT_FOUND` error is returned if the resource does not exist. An empty policy is returned if
   * the resource exists but does not have a policy set on it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   ResourceName resource = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
   *   Policy response = engineServiceClient.getIamPolicy(resource);
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
   * Gets the IAM access control policy for an [Engine][google.cloud.discoveryengine.v1beta.Engine].
   * A `NOT_FOUND` error is returned if the resource does not exist. An empty policy is returned if
   * the resource exists but does not have a policy set on it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   String resource = AclConfigName.of("[PROJECT]", "[LOCATION]").toString();
   *   Policy response = engineServiceClient.getIamPolicy(resource);
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
   * Gets the IAM access control policy for an [Engine][google.cloud.discoveryengine.v1beta.Engine].
   * A `NOT_FOUND` error is returned if the resource does not exist. An empty policy is returned if
   * the resource exists but does not have a policy set on it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = engineServiceClient.getIamPolicy(request);
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
   * Gets the IAM access control policy for an [Engine][google.cloud.discoveryengine.v1beta.Engine].
   * A `NOT_FOUND` error is returned if the resource does not exist. An empty policy is returned if
   * the resource exists but does not have a policy set on it.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = engineServiceClient.getIamPolicyCallable().futureCall(request);
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
   * Sets the IAM access control policy for an [Engine][google.cloud.discoveryengine.v1beta.Engine].
   * A `NOT_FOUND` error is returned if the resource does not exist.
   *
   * <p>&#42;&#42;Important:&#42;&#42; When setting a policy directly on an Engine resource, the
   * only recommended roles in the bindings are: `roles/discoveryengine.admin`,
   * `roles/discoveryengine.agentspaceAdmin`, `roles/discoveryengine.user`,
   * `roles/discoveryengine.agentspaceUser`, `roles/discoveryengine.viewer`,
   * `roles/discoveryengine.agentspaceViewer`. Attempting to grant any other role will result in a
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
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   ResourceName resource = EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = engineServiceClient.setIamPolicy(resource, policy);
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
   * Sets the IAM access control policy for an [Engine][google.cloud.discoveryengine.v1beta.Engine].
   * A `NOT_FOUND` error is returned if the resource does not exist.
   *
   * <p>&#42;&#42;Important:&#42;&#42; When setting a policy directly on an Engine resource, the
   * only recommended roles in the bindings are: `roles/discoveryengine.admin`,
   * `roles/discoveryengine.agentspaceAdmin`, `roles/discoveryengine.user`,
   * `roles/discoveryengine.agentspaceUser`, `roles/discoveryengine.viewer`,
   * `roles/discoveryengine.agentspaceViewer`. Attempting to grant any other role will result in a
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
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   String resource = AclConfigName.of("[PROJECT]", "[LOCATION]").toString();
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = engineServiceClient.setIamPolicy(resource, policy);
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
   * Sets the IAM access control policy for an [Engine][google.cloud.discoveryengine.v1beta.Engine].
   * A `NOT_FOUND` error is returned if the resource does not exist.
   *
   * <p>&#42;&#42;Important:&#42;&#42; When setting a policy directly on an Engine resource, the
   * only recommended roles in the bindings are: `roles/discoveryengine.admin`,
   * `roles/discoveryengine.agentspaceAdmin`, `roles/discoveryengine.user`,
   * `roles/discoveryengine.agentspaceUser`, `roles/discoveryengine.viewer`,
   * `roles/discoveryengine.agentspaceViewer`. Attempting to grant any other role will result in a
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
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = engineServiceClient.setIamPolicy(request);
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
   * Sets the IAM access control policy for an [Engine][google.cloud.discoveryengine.v1beta.Engine].
   * A `NOT_FOUND` error is returned if the resource does not exist.
   *
   * <p>&#42;&#42;Important:&#42;&#42; When setting a policy directly on an Engine resource, the
   * only recommended roles in the bindings are: `roles/discoveryengine.admin`,
   * `roles/discoveryengine.agentspaceAdmin`, `roles/discoveryengine.user`,
   * `roles/discoveryengine.agentspaceUser`, `roles/discoveryengine.viewer`,
   * `roles/discoveryengine.agentspaceViewer`. Attempting to grant any other role will result in a
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
   * try (EngineServiceClient engineServiceClient = EngineServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EngineName.of("[PROJECT]", "[LOCATION]", "[COLLECTION]", "[ENGINE]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = engineServiceClient.setIamPolicyCallable().futureCall(request);
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

  public static class ListEnginesPagedResponse
      extends AbstractPagedListResponse<
          ListEnginesRequest,
          ListEnginesResponse,
          Engine,
          ListEnginesPage,
          ListEnginesFixedSizeCollection> {

    public static ApiFuture<ListEnginesPagedResponse> createAsync(
        PageContext<ListEnginesRequest, ListEnginesResponse, Engine> context,
        ApiFuture<ListEnginesResponse> futureResponse) {
      ApiFuture<ListEnginesPage> futurePage =
          ListEnginesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListEnginesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListEnginesPagedResponse(ListEnginesPage page) {
      super(page, ListEnginesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEnginesPage
      extends AbstractPage<ListEnginesRequest, ListEnginesResponse, Engine, ListEnginesPage> {

    private ListEnginesPage(
        @Nullable PageContext<ListEnginesRequest, ListEnginesResponse, Engine> context,
        @Nullable ListEnginesResponse response) {
      super(context, response);
    }

    private static ListEnginesPage createEmptyPage() {
      return new ListEnginesPage(null, null);
    }

    @Override
    protected ListEnginesPage createPage(
        @Nullable PageContext<ListEnginesRequest, ListEnginesResponse, Engine> context,
        @Nullable ListEnginesResponse response) {
      return new ListEnginesPage(context, response);
    }

    @Override
    public ApiFuture<ListEnginesPage> createPageAsync(
        @Nullable PageContext<ListEnginesRequest, ListEnginesResponse, Engine> context,
        ApiFuture<ListEnginesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEnginesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEnginesRequest,
          ListEnginesResponse,
          Engine,
          ListEnginesPage,
          ListEnginesFixedSizeCollection> {

    private ListEnginesFixedSizeCollection(
        @Nullable List<ListEnginesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEnginesFixedSizeCollection createEmptyCollection() {
      return new ListEnginesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEnginesFixedSizeCollection createCollection(
        @Nullable List<ListEnginesPage> pages, int collectionSize) {
      return new ListEnginesFixedSizeCollection(pages, collectionSize);
    }
  }
}
