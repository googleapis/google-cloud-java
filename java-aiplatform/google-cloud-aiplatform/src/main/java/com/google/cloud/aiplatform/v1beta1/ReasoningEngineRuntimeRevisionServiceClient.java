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
import com.google.cloud.aiplatform.v1beta1.stub.ReasoningEngineRuntimeRevisionServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.ReasoningEngineRuntimeRevisionServiceStubSettings;
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
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Manages Vertex AI's Reasoning Engine Revisions.
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
 * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
 *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
 *   ReasoningEngineRuntimeRevisionName name =
 *       ReasoningEngineRuntimeRevisionName.of(
 *           "[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[RUNTIME_REVISION]");
 *   ReasoningEngineRuntimeRevision response =
 *       reasoningEngineRuntimeRevisionServiceClient.getReasoningEngineRuntimeRevision(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ReasoningEngineRuntimeRevisionServiceClient object to
 * clean up resources such as threads. In the example above, try-with-resources is used, which
 * automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetReasoningEngineRuntimeRevision</td>
 *      <td><p> Gets a reasoning engine runtime revision.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getReasoningEngineRuntimeRevision(GetReasoningEngineRuntimeRevisionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getReasoningEngineRuntimeRevision(ReasoningEngineRuntimeRevisionName name)
 *           <li><p> getReasoningEngineRuntimeRevision(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getReasoningEngineRuntimeRevisionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListReasoningEngineRuntimeRevisions</td>
 *      <td><p> Lists runtime revisions in a reasoning engine.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listReasoningEngineRuntimeRevisions(ListReasoningEngineRuntimeRevisionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listReasoningEngineRuntimeRevisions(ReasoningEngineName parent)
 *           <li><p> listReasoningEngineRuntimeRevisions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listReasoningEngineRuntimeRevisionsPagedCallable()
 *           <li><p> listReasoningEngineRuntimeRevisionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteReasoningEngineRuntimeRevision</td>
 *      <td><p> Deletes a reasoning engine revision.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteReasoningEngineRuntimeRevisionAsync(DeleteReasoningEngineRuntimeRevisionRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteReasoningEngineRuntimeRevisionAsync(ReasoningEngineRuntimeRevisionName name)
 *           <li><p> deleteReasoningEngineRuntimeRevisionAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteReasoningEngineRuntimeRevisionOperationCallable()
 *           <li><p> deleteReasoningEngineRuntimeRevisionCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * ReasoningEngineRuntimeRevisionServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ReasoningEngineRuntimeRevisionServiceSettings reasoningEngineRuntimeRevisionServiceSettings =
 *     ReasoningEngineRuntimeRevisionServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
 *     ReasoningEngineRuntimeRevisionServiceClient.create(
 *         reasoningEngineRuntimeRevisionServiceSettings);
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
 * ReasoningEngineRuntimeRevisionServiceSettings reasoningEngineRuntimeRevisionServiceSettings =
 *     ReasoningEngineRuntimeRevisionServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
 *     ReasoningEngineRuntimeRevisionServiceClient.create(
 *         reasoningEngineRuntimeRevisionServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@BetaApi
@Generated("by gapic-generator-java")
public class ReasoningEngineRuntimeRevisionServiceClient implements BackgroundResource {
  private final ReasoningEngineRuntimeRevisionServiceSettings settings;
  private final ReasoningEngineRuntimeRevisionServiceStub stub;
  private final OperationsClient operationsClient;

  /**
   * Constructs an instance of ReasoningEngineRuntimeRevisionServiceClient with default settings.
   */
  public static final ReasoningEngineRuntimeRevisionServiceClient create() throws IOException {
    return create(ReasoningEngineRuntimeRevisionServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ReasoningEngineRuntimeRevisionServiceClient, using the given
   * settings. The channels are created based on the settings passed in, or defaults for any
   * settings that are not set.
   */
  public static final ReasoningEngineRuntimeRevisionServiceClient create(
      ReasoningEngineRuntimeRevisionServiceSettings settings) throws IOException {
    return new ReasoningEngineRuntimeRevisionServiceClient(settings);
  }

  /**
   * Constructs an instance of ReasoningEngineRuntimeRevisionServiceClient, using the given stub for
   * making calls. This is for advanced usage - prefer using
   * create(ReasoningEngineRuntimeRevisionServiceSettings).
   */
  public static final ReasoningEngineRuntimeRevisionServiceClient create(
      ReasoningEngineRuntimeRevisionServiceStub stub) {
    return new ReasoningEngineRuntimeRevisionServiceClient(stub);
  }

  /**
   * Constructs an instance of ReasoningEngineRuntimeRevisionServiceClient, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected ReasoningEngineRuntimeRevisionServiceClient(
      ReasoningEngineRuntimeRevisionServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub =
        ((ReasoningEngineRuntimeRevisionServiceStubSettings) settings.getStubSettings())
            .createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected ReasoningEngineRuntimeRevisionServiceClient(
      ReasoningEngineRuntimeRevisionServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final ReasoningEngineRuntimeRevisionServiceSettings getSettings() {
    return settings;
  }

  public ReasoningEngineRuntimeRevisionServiceStub getStub() {
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
   * Gets a reasoning engine runtime revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   ReasoningEngineRuntimeRevisionName name =
   *       ReasoningEngineRuntimeRevisionName.of(
   *           "[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[RUNTIME_REVISION]");
   *   ReasoningEngineRuntimeRevision response =
   *       reasoningEngineRuntimeRevisionServiceClient.getReasoningEngineRuntimeRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ReasoningEngineRuntimeRevision resource. Format:
   *     `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/runtimeRevisions/{runtimeRevision}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReasoningEngineRuntimeRevision getReasoningEngineRuntimeRevision(
      ReasoningEngineRuntimeRevisionName name) {
    GetReasoningEngineRuntimeRevisionRequest request =
        GetReasoningEngineRuntimeRevisionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getReasoningEngineRuntimeRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a reasoning engine runtime revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   String name =
   *       ReasoningEngineRuntimeRevisionName.of(
   *               "[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[RUNTIME_REVISION]")
   *           .toString();
   *   ReasoningEngineRuntimeRevision response =
   *       reasoningEngineRuntimeRevisionServiceClient.getReasoningEngineRuntimeRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the ReasoningEngineRuntimeRevision resource. Format:
   *     `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/runtimeRevisions/{runtimeRevision}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReasoningEngineRuntimeRevision getReasoningEngineRuntimeRevision(String name) {
    GetReasoningEngineRuntimeRevisionRequest request =
        GetReasoningEngineRuntimeRevisionRequest.newBuilder().setName(name).build();
    return getReasoningEngineRuntimeRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a reasoning engine runtime revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   GetReasoningEngineRuntimeRevisionRequest request =
   *       GetReasoningEngineRuntimeRevisionRequest.newBuilder()
   *           .setName(
   *               ReasoningEngineRuntimeRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[RUNTIME_REVISION]")
   *                   .toString())
   *           .build();
   *   ReasoningEngineRuntimeRevision response =
   *       reasoningEngineRuntimeRevisionServiceClient.getReasoningEngineRuntimeRevision(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReasoningEngineRuntimeRevision getReasoningEngineRuntimeRevision(
      GetReasoningEngineRuntimeRevisionRequest request) {
    return getReasoningEngineRuntimeRevisionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a reasoning engine runtime revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   GetReasoningEngineRuntimeRevisionRequest request =
   *       GetReasoningEngineRuntimeRevisionRequest.newBuilder()
   *           .setName(
   *               ReasoningEngineRuntimeRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[RUNTIME_REVISION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<ReasoningEngineRuntimeRevision> future =
   *       reasoningEngineRuntimeRevisionServiceClient
   *           .getReasoningEngineRuntimeRevisionCallable()
   *           .futureCall(request);
   *   // Do something.
   *   ReasoningEngineRuntimeRevision response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetReasoningEngineRuntimeRevisionRequest, ReasoningEngineRuntimeRevision>
      getReasoningEngineRuntimeRevisionCallable() {
    return stub.getReasoningEngineRuntimeRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists runtime revisions in a reasoning engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   ReasoningEngineName parent =
   *       ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]");
   *   for (ReasoningEngineRuntimeRevision element :
   *       reasoningEngineRuntimeRevisionServiceClient
   *           .listReasoningEngineRuntimeRevisions(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the ReasoningEngine to list the
   *     ReasoningEngineRuntimeRevisions from. Format:
   *     `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReasoningEngineRuntimeRevisionsPagedResponse listReasoningEngineRuntimeRevisions(
      ReasoningEngineName parent) {
    ListReasoningEngineRuntimeRevisionsRequest request =
        ListReasoningEngineRuntimeRevisionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReasoningEngineRuntimeRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists runtime revisions in a reasoning engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   String parent =
   *       ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]").toString();
   *   for (ReasoningEngineRuntimeRevision element :
   *       reasoningEngineRuntimeRevisionServiceClient
   *           .listReasoningEngineRuntimeRevisions(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the ReasoningEngine to list the
   *     ReasoningEngineRuntimeRevisions from. Format:
   *     `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReasoningEngineRuntimeRevisionsPagedResponse listReasoningEngineRuntimeRevisions(
      String parent) {
    ListReasoningEngineRuntimeRevisionsRequest request =
        ListReasoningEngineRuntimeRevisionsRequest.newBuilder().setParent(parent).build();
    return listReasoningEngineRuntimeRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists runtime revisions in a reasoning engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   ListReasoningEngineRuntimeRevisionsRequest request =
   *       ListReasoningEngineRuntimeRevisionsRequest.newBuilder()
   *           .setParent(
   *               ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ReasoningEngineRuntimeRevision element :
   *       reasoningEngineRuntimeRevisionServiceClient
   *           .listReasoningEngineRuntimeRevisions(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReasoningEngineRuntimeRevisionsPagedResponse listReasoningEngineRuntimeRevisions(
      ListReasoningEngineRuntimeRevisionsRequest request) {
    return listReasoningEngineRuntimeRevisionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists runtime revisions in a reasoning engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   ListReasoningEngineRuntimeRevisionsRequest request =
   *       ListReasoningEngineRuntimeRevisionsRequest.newBuilder()
   *           .setParent(
   *               ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ReasoningEngineRuntimeRevision> future =
   *       reasoningEngineRuntimeRevisionServiceClient
   *           .listReasoningEngineRuntimeRevisionsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (ReasoningEngineRuntimeRevision element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListReasoningEngineRuntimeRevisionsRequest,
          ListReasoningEngineRuntimeRevisionsPagedResponse>
      listReasoningEngineRuntimeRevisionsPagedCallable() {
    return stub.listReasoningEngineRuntimeRevisionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists runtime revisions in a reasoning engine.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   ListReasoningEngineRuntimeRevisionsRequest request =
   *       ListReasoningEngineRuntimeRevisionsRequest.newBuilder()
   *           .setParent(
   *               ReasoningEngineName.of("[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]")
   *                   .toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListReasoningEngineRuntimeRevisionsResponse response =
   *         reasoningEngineRuntimeRevisionServiceClient
   *             .listReasoningEngineRuntimeRevisionsCallable()
   *             .call(request);
   *     for (ReasoningEngineRuntimeRevision element :
   *         response.getReasoningEngineRuntimeRevisionsList()) {
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
  public final UnaryCallable<
          ListReasoningEngineRuntimeRevisionsRequest, ListReasoningEngineRuntimeRevisionsResponse>
      listReasoningEngineRuntimeRevisionsCallable() {
    return stub.listReasoningEngineRuntimeRevisionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a reasoning engine revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   ReasoningEngineRuntimeRevisionName name =
   *       ReasoningEngineRuntimeRevisionName.of(
   *           "[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[RUNTIME_REVISION]");
   *   reasoningEngineRuntimeRevisionServiceClient
   *       .deleteReasoningEngineRuntimeRevisionAsync(name)
   *       .get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the ReasoningEngineRuntimeRevision resource to be deleted.
   *     Format:
   *     `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/runtimeRevisions/{runtime_revision}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteReasoningEngineRuntimeRevisionOperationMetadata>
      deleteReasoningEngineRuntimeRevisionAsync(ReasoningEngineRuntimeRevisionName name) {
    DeleteReasoningEngineRuntimeRevisionRequest request =
        DeleteReasoningEngineRuntimeRevisionRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteReasoningEngineRuntimeRevisionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a reasoning engine revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   String name =
   *       ReasoningEngineRuntimeRevisionName.of(
   *               "[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[RUNTIME_REVISION]")
   *           .toString();
   *   reasoningEngineRuntimeRevisionServiceClient
   *       .deleteReasoningEngineRuntimeRevisionAsync(name)
   *       .get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the ReasoningEngineRuntimeRevision resource to be deleted.
   *     Format:
   *     `projects/{project}/locations/{location}/reasoningEngines/{reasoning_engine}/runtimeRevisions/{runtime_revision}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteReasoningEngineRuntimeRevisionOperationMetadata>
      deleteReasoningEngineRuntimeRevisionAsync(String name) {
    DeleteReasoningEngineRuntimeRevisionRequest request =
        DeleteReasoningEngineRuntimeRevisionRequest.newBuilder().setName(name).build();
    return deleteReasoningEngineRuntimeRevisionAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a reasoning engine revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   DeleteReasoningEngineRuntimeRevisionRequest request =
   *       DeleteReasoningEngineRuntimeRevisionRequest.newBuilder()
   *           .setName(
   *               ReasoningEngineRuntimeRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[RUNTIME_REVISION]")
   *                   .toString())
   *           .build();
   *   reasoningEngineRuntimeRevisionServiceClient
   *       .deleteReasoningEngineRuntimeRevisionAsync(request)
   *       .get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteReasoningEngineRuntimeRevisionOperationMetadata>
      deleteReasoningEngineRuntimeRevisionAsync(
          DeleteReasoningEngineRuntimeRevisionRequest request) {
    return deleteReasoningEngineRuntimeRevisionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a reasoning engine revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   DeleteReasoningEngineRuntimeRevisionRequest request =
   *       DeleteReasoningEngineRuntimeRevisionRequest.newBuilder()
   *           .setName(
   *               ReasoningEngineRuntimeRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[RUNTIME_REVISION]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteReasoningEngineRuntimeRevisionOperationMetadata> future =
   *       reasoningEngineRuntimeRevisionServiceClient
   *           .deleteReasoningEngineRuntimeRevisionOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteReasoningEngineRuntimeRevisionRequest,
          Empty,
          DeleteReasoningEngineRuntimeRevisionOperationMetadata>
      deleteReasoningEngineRuntimeRevisionOperationCallable() {
    return stub.deleteReasoningEngineRuntimeRevisionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a reasoning engine revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   DeleteReasoningEngineRuntimeRevisionRequest request =
   *       DeleteReasoningEngineRuntimeRevisionRequest.newBuilder()
   *           .setName(
   *               ReasoningEngineRuntimeRevisionName.of(
   *                       "[PROJECT]", "[LOCATION]", "[REASONING_ENGINE]", "[RUNTIME_REVISION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       reasoningEngineRuntimeRevisionServiceClient
   *           .deleteReasoningEngineRuntimeRevisionCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteReasoningEngineRuntimeRevisionRequest, Operation>
      deleteReasoningEngineRuntimeRevisionCallable() {
    return stub.deleteReasoningEngineRuntimeRevisionCallable();
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
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element :
   *       reasoningEngineRuntimeRevisionServiceClient.listLocations(request).iterateAll()) {
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
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       reasoningEngineRuntimeRevisionServiceClient
   *           .listLocationsPagedCallable()
   *           .futureCall(request);
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
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         reasoningEngineRuntimeRevisionServiceClient.listLocationsCallable().call(request);
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
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = reasoningEngineRuntimeRevisionServiceClient.getLocation(request);
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
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future =
   *       reasoningEngineRuntimeRevisionServiceClient.getLocationCallable().futureCall(request);
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
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = reasoningEngineRuntimeRevisionServiceClient.setIamPolicy(request);
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
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
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
   *       reasoningEngineRuntimeRevisionServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = reasoningEngineRuntimeRevisionServiceClient.getIamPolicy(request);
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
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       reasoningEngineRuntimeRevisionServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response =
   *       reasoningEngineRuntimeRevisionServiceClient.testIamPermissions(request);
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
   * try (ReasoningEngineRuntimeRevisionServiceClient reasoningEngineRuntimeRevisionServiceClient =
   *     ReasoningEngineRuntimeRevisionServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       reasoningEngineRuntimeRevisionServiceClient
   *           .testIamPermissionsCallable()
   *           .futureCall(request);
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

  public static class ListReasoningEngineRuntimeRevisionsPagedResponse
      extends AbstractPagedListResponse<
          ListReasoningEngineRuntimeRevisionsRequest,
          ListReasoningEngineRuntimeRevisionsResponse,
          ReasoningEngineRuntimeRevision,
          ListReasoningEngineRuntimeRevisionsPage,
          ListReasoningEngineRuntimeRevisionsFixedSizeCollection> {

    public static ApiFuture<ListReasoningEngineRuntimeRevisionsPagedResponse> createAsync(
        PageContext<
                ListReasoningEngineRuntimeRevisionsRequest,
                ListReasoningEngineRuntimeRevisionsResponse,
                ReasoningEngineRuntimeRevision>
            context,
        ApiFuture<ListReasoningEngineRuntimeRevisionsResponse> futureResponse) {
      ApiFuture<ListReasoningEngineRuntimeRevisionsPage> futurePage =
          ListReasoningEngineRuntimeRevisionsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListReasoningEngineRuntimeRevisionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListReasoningEngineRuntimeRevisionsPagedResponse(
        ListReasoningEngineRuntimeRevisionsPage page) {
      super(page, ListReasoningEngineRuntimeRevisionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReasoningEngineRuntimeRevisionsPage
      extends AbstractPage<
          ListReasoningEngineRuntimeRevisionsRequest,
          ListReasoningEngineRuntimeRevisionsResponse,
          ReasoningEngineRuntimeRevision,
          ListReasoningEngineRuntimeRevisionsPage> {

    private ListReasoningEngineRuntimeRevisionsPage(
        PageContext<
                ListReasoningEngineRuntimeRevisionsRequest,
                ListReasoningEngineRuntimeRevisionsResponse,
                ReasoningEngineRuntimeRevision>
            context,
        ListReasoningEngineRuntimeRevisionsResponse response) {
      super(context, response);
    }

    private static ListReasoningEngineRuntimeRevisionsPage createEmptyPage() {
      return new ListReasoningEngineRuntimeRevisionsPage(null, null);
    }

    @Override
    protected ListReasoningEngineRuntimeRevisionsPage createPage(
        PageContext<
                ListReasoningEngineRuntimeRevisionsRequest,
                ListReasoningEngineRuntimeRevisionsResponse,
                ReasoningEngineRuntimeRevision>
            context,
        ListReasoningEngineRuntimeRevisionsResponse response) {
      return new ListReasoningEngineRuntimeRevisionsPage(context, response);
    }

    @Override
    public ApiFuture<ListReasoningEngineRuntimeRevisionsPage> createPageAsync(
        PageContext<
                ListReasoningEngineRuntimeRevisionsRequest,
                ListReasoningEngineRuntimeRevisionsResponse,
                ReasoningEngineRuntimeRevision>
            context,
        ApiFuture<ListReasoningEngineRuntimeRevisionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReasoningEngineRuntimeRevisionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReasoningEngineRuntimeRevisionsRequest,
          ListReasoningEngineRuntimeRevisionsResponse,
          ReasoningEngineRuntimeRevision,
          ListReasoningEngineRuntimeRevisionsPage,
          ListReasoningEngineRuntimeRevisionsFixedSizeCollection> {

    private ListReasoningEngineRuntimeRevisionsFixedSizeCollection(
        List<ListReasoningEngineRuntimeRevisionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReasoningEngineRuntimeRevisionsFixedSizeCollection createEmptyCollection() {
      return new ListReasoningEngineRuntimeRevisionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReasoningEngineRuntimeRevisionsFixedSizeCollection createCollection(
        List<ListReasoningEngineRuntimeRevisionsPage> pages, int collectionSize) {
      return new ListReasoningEngineRuntimeRevisionsFixedSizeCollection(pages, collectionSize);
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
