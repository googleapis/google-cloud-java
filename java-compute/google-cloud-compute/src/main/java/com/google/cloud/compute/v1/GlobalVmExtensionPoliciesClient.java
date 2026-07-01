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

package com.google.cloud.compute.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.GlobalVmExtensionPoliciesStub;
import com.google.cloud.compute.v1.stub.GlobalVmExtensionPoliciesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The GlobalVmExtensionPolicies API.
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
 * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
 *     GlobalVmExtensionPoliciesClient.create()) {
 *   String project = "project-309310695";
 *   String globalVmExtensionPolicy = "globalVmExtensionPolicy-869114569";
 *   GlobalVmExtensionPolicy response =
 *       globalVmExtensionPoliciesClient.get(project, globalVmExtensionPolicy);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the GlobalVmExtensionPoliciesClient object to clean up
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
 *      <td><p> AggregatedList</td>
 *      <td><p> Retrieves the list of all VM Extension Policy resources available to the specified project.
 * <p>  To prevent failure, it's recommended that you set the `returnPartialSuccess` parameter to `true`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> aggregatedList(AggregatedListGlobalVmExtensionPoliciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> aggregatedList(String project)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> aggregatedListPagedCallable()
 *           <li><p> aggregatedListCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Delete</td>
 *      <td><p> Purge scoped resources (zonal policies) from a global VM extension policy, and then delete the global VM extension policy. Purge of the scoped resources is a pre-condition of the global VM extension policy deletion. The deletion of the global VM extension policy happens after the purge rollout is done, so it's not a part of the LRO. It's an automatic process that triggers in the backend.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAsync(DeleteGlobalVmExtensionPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAsync(String project, String globalVmExtensionPolicy, GlobalVmExtensionPolicyRolloutOperationRolloutInput globalVmExtensionPolicyRolloutOperationRolloutInputResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteOperationCallable()
 *           <li><p> deleteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Get</td>
 *      <td><p> Gets details of a global VM extension policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetGlobalVmExtensionPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String globalVmExtensionPolicy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Insert</td>
 *      <td><p> Creates a new project level GlobalVmExtensionPolicy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertAsync(InsertGlobalVmExtensionPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> insertAsync(String project, GlobalVmExtensionPolicy globalVmExtensionPolicyResource)
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
 *      <td><p> Lists global VM extension policies.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(ListGlobalVmExtensionPoliciesRequest request)
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
 *      <td><p> Update</td>
 *      <td><p> Updates a global VM extension policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAsync(UpdateGlobalVmExtensionPolicyRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateAsync(String project, String globalVmExtensionPolicy, GlobalVmExtensionPolicy globalVmExtensionPolicyResource)
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
 * <p>This class can be customized by passing in a custom instance of
 * GlobalVmExtensionPoliciesSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * GlobalVmExtensionPoliciesSettings globalVmExtensionPoliciesSettings =
 *     GlobalVmExtensionPoliciesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
 *     GlobalVmExtensionPoliciesClient.create(globalVmExtensionPoliciesSettings);
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
 * GlobalVmExtensionPoliciesSettings globalVmExtensionPoliciesSettings =
 *     GlobalVmExtensionPoliciesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
 *     GlobalVmExtensionPoliciesClient.create(globalVmExtensionPoliciesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class GlobalVmExtensionPoliciesClient implements BackgroundResource {
  private final GlobalVmExtensionPoliciesSettings settings;
  private final GlobalVmExtensionPoliciesStub stub;

  /** Constructs an instance of GlobalVmExtensionPoliciesClient with default settings. */
  public static final GlobalVmExtensionPoliciesClient create() throws IOException {
    return create(GlobalVmExtensionPoliciesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of GlobalVmExtensionPoliciesClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final GlobalVmExtensionPoliciesClient create(
      GlobalVmExtensionPoliciesSettings settings) throws IOException {
    return new GlobalVmExtensionPoliciesClient(settings);
  }

  /**
   * Constructs an instance of GlobalVmExtensionPoliciesClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(GlobalVmExtensionPoliciesSettings).
   */
  public static final GlobalVmExtensionPoliciesClient create(GlobalVmExtensionPoliciesStub stub) {
    return new GlobalVmExtensionPoliciesClient(stub);
  }

  /**
   * Constructs an instance of GlobalVmExtensionPoliciesClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected GlobalVmExtensionPoliciesClient(GlobalVmExtensionPoliciesSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((GlobalVmExtensionPoliciesStubSettings) settings.getStubSettings()).createStub();
  }

  protected GlobalVmExtensionPoliciesClient(GlobalVmExtensionPoliciesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final GlobalVmExtensionPoliciesSettings getSettings() {
    return settings;
  }

  public GlobalVmExtensionPoliciesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all VM Extension Policy resources available to the specified project.
   *
   * <p>To prevent failure, it's recommended that you set the `returnPartialSuccess` parameter to
   * `true`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
   *     GlobalVmExtensionPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   for (Map.Entry<String, VmExtensionPoliciesScopedList> element :
   *       globalVmExtensionPoliciesClient.aggregatedList(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Name of the project scoping this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(String project) {
    AggregatedListGlobalVmExtensionPoliciesRequest request =
        AggregatedListGlobalVmExtensionPoliciesRequest.newBuilder().setProject(project).build();
    return aggregatedList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all VM Extension Policy resources available to the specified project.
   *
   * <p>To prevent failure, it's recommended that you set the `returnPartialSuccess` parameter to
   * `true`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
   *     GlobalVmExtensionPoliciesClient.create()) {
   *   AggregatedListGlobalVmExtensionPoliciesRequest request =
   *       AggregatedListGlobalVmExtensionPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setServiceProjectNumber(-1293855239)
   *           .build();
   *   for (Map.Entry<String, VmExtensionPoliciesScopedList> element :
   *       globalVmExtensionPoliciesClient.aggregatedList(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AggregatedListPagedResponse aggregatedList(
      AggregatedListGlobalVmExtensionPoliciesRequest request) {
    return aggregatedListPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all VM Extension Policy resources available to the specified project.
   *
   * <p>To prevent failure, it's recommended that you set the `returnPartialSuccess` parameter to
   * `true`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
   *     GlobalVmExtensionPoliciesClient.create()) {
   *   AggregatedListGlobalVmExtensionPoliciesRequest request =
   *       AggregatedListGlobalVmExtensionPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setServiceProjectNumber(-1293855239)
   *           .build();
   *   ApiFuture<Map.Entry<String, VmExtensionPoliciesScopedList>> future =
   *       globalVmExtensionPoliciesClient.aggregatedListPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Map.Entry<String, VmExtensionPoliciesScopedList> element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          AggregatedListGlobalVmExtensionPoliciesRequest, AggregatedListPagedResponse>
      aggregatedListPagedCallable() {
    return stub.aggregatedListPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all VM Extension Policy resources available to the specified project.
   *
   * <p>To prevent failure, it's recommended that you set the `returnPartialSuccess` parameter to
   * `true`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
   *     GlobalVmExtensionPoliciesClient.create()) {
   *   AggregatedListGlobalVmExtensionPoliciesRequest request =
   *       AggregatedListGlobalVmExtensionPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setIncludeAllScopes(true)
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .setServiceProjectNumber(-1293855239)
   *           .build();
   *   while (true) {
   *     VmExtensionPolicyAggregatedListResponse response =
   *         globalVmExtensionPoliciesClient.aggregatedListCallable().call(request);
   *     for (Map.Entry<String, VmExtensionPoliciesScopedList> element : response.getItemsList()) {
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
          AggregatedListGlobalVmExtensionPoliciesRequest, VmExtensionPolicyAggregatedListResponse>
      aggregatedListCallable() {
    return stub.aggregatedListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Purge scoped resources (zonal policies) from a global VM extension policy, and then delete the
   * global VM extension policy. Purge of the scoped resources is a pre-condition of the global VM
   * extension policy deletion. The deletion of the global VM extension policy happens after the
   * purge rollout is done, so it's not a part of the LRO. It's an automatic process that triggers
   * in the backend.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
   *     GlobalVmExtensionPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String globalVmExtensionPolicy = "globalVmExtensionPolicy-869114569";
   *   GlobalVmExtensionPolicyRolloutOperationRolloutInput
   *       globalVmExtensionPolicyRolloutOperationRolloutInputResource =
   *           GlobalVmExtensionPolicyRolloutOperationRolloutInput.newBuilder().build();
   *   Operation response =
   *       globalVmExtensionPoliciesClient
   *           .deleteAsync(
   *               project,
   *               globalVmExtensionPolicy,
   *               globalVmExtensionPolicyRolloutOperationRolloutInputResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param globalVmExtensionPolicy Name of the global VM extension policy to purge scoped resources
   *     for.
   * @param globalVmExtensionPolicyRolloutOperationRolloutInputResource The body resource for this
   *     request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project,
      String globalVmExtensionPolicy,
      GlobalVmExtensionPolicyRolloutOperationRolloutInput
          globalVmExtensionPolicyRolloutOperationRolloutInputResource) {
    DeleteGlobalVmExtensionPolicyRequest request =
        DeleteGlobalVmExtensionPolicyRequest.newBuilder()
            .setProject(project)
            .setGlobalVmExtensionPolicy(globalVmExtensionPolicy)
            .setGlobalVmExtensionPolicyRolloutOperationRolloutInputResource(
                globalVmExtensionPolicyRolloutOperationRolloutInputResource)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Purge scoped resources (zonal policies) from a global VM extension policy, and then delete the
   * global VM extension policy. Purge of the scoped resources is a pre-condition of the global VM
   * extension policy deletion. The deletion of the global VM extension policy happens after the
   * purge rollout is done, so it's not a part of the LRO. It's an automatic process that triggers
   * in the backend.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
   *     GlobalVmExtensionPoliciesClient.create()) {
   *   DeleteGlobalVmExtensionPolicyRequest request =
   *       DeleteGlobalVmExtensionPolicyRequest.newBuilder()
   *           .setGlobalVmExtensionPolicy("globalVmExtensionPolicy-869114569")
   *           .setGlobalVmExtensionPolicyRolloutOperationRolloutInputResource(
   *               GlobalVmExtensionPolicyRolloutOperationRolloutInput.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = globalVmExtensionPoliciesClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteGlobalVmExtensionPolicyRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Purge scoped resources (zonal policies) from a global VM extension policy, and then delete the
   * global VM extension policy. Purge of the scoped resources is a pre-condition of the global VM
   * extension policy deletion. The deletion of the global VM extension policy happens after the
   * purge rollout is done, so it's not a part of the LRO. It's an automatic process that triggers
   * in the backend.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
   *     GlobalVmExtensionPoliciesClient.create()) {
   *   DeleteGlobalVmExtensionPolicyRequest request =
   *       DeleteGlobalVmExtensionPolicyRequest.newBuilder()
   *           .setGlobalVmExtensionPolicy("globalVmExtensionPolicy-869114569")
   *           .setGlobalVmExtensionPolicyRolloutOperationRolloutInputResource(
   *               GlobalVmExtensionPolicyRolloutOperationRolloutInput.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       globalVmExtensionPoliciesClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteGlobalVmExtensionPolicyRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Purge scoped resources (zonal policies) from a global VM extension policy, and then delete the
   * global VM extension policy. Purge of the scoped resources is a pre-condition of the global VM
   * extension policy deletion. The deletion of the global VM extension policy happens after the
   * purge rollout is done, so it's not a part of the LRO. It's an automatic process that triggers
   * in the backend.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
   *     GlobalVmExtensionPoliciesClient.create()) {
   *   DeleteGlobalVmExtensionPolicyRequest request =
   *       DeleteGlobalVmExtensionPolicyRequest.newBuilder()
   *           .setGlobalVmExtensionPolicy("globalVmExtensionPolicy-869114569")
   *           .setGlobalVmExtensionPolicyRolloutOperationRolloutInputResource(
   *               GlobalVmExtensionPolicyRolloutOperationRolloutInput.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       globalVmExtensionPoliciesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteGlobalVmExtensionPolicyRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a global VM extension policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
   *     GlobalVmExtensionPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String globalVmExtensionPolicy = "globalVmExtensionPolicy-869114569";
   *   GlobalVmExtensionPolicy response =
   *       globalVmExtensionPoliciesClient.get(project, globalVmExtensionPolicy);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param globalVmExtensionPolicy Name of the GlobalVmExtensionPolicy resource to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlobalVmExtensionPolicy get(String project, String globalVmExtensionPolicy) {
    GetGlobalVmExtensionPolicyRequest request =
        GetGlobalVmExtensionPolicyRequest.newBuilder()
            .setProject(project)
            .setGlobalVmExtensionPolicy(globalVmExtensionPolicy)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a global VM extension policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
   *     GlobalVmExtensionPoliciesClient.create()) {
   *   GetGlobalVmExtensionPolicyRequest request =
   *       GetGlobalVmExtensionPolicyRequest.newBuilder()
   *           .setGlobalVmExtensionPolicy("globalVmExtensionPolicy-869114569")
   *           .setProject("project-309310695")
   *           .build();
   *   GlobalVmExtensionPolicy response = globalVmExtensionPoliciesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GlobalVmExtensionPolicy get(GetGlobalVmExtensionPolicyRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details of a global VM extension policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
   *     GlobalVmExtensionPoliciesClient.create()) {
   *   GetGlobalVmExtensionPolicyRequest request =
   *       GetGlobalVmExtensionPolicyRequest.newBuilder()
   *           .setGlobalVmExtensionPolicy("globalVmExtensionPolicy-869114569")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<GlobalVmExtensionPolicy> future =
   *       globalVmExtensionPoliciesClient.getCallable().futureCall(request);
   *   // Do something.
   *   GlobalVmExtensionPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetGlobalVmExtensionPolicyRequest, GlobalVmExtensionPolicy>
      getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new project level GlobalVmExtensionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
   *     GlobalVmExtensionPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   GlobalVmExtensionPolicy globalVmExtensionPolicyResource =
   *       GlobalVmExtensionPolicy.newBuilder().build();
   *   Operation response =
   *       globalVmExtensionPoliciesClient
   *           .insertAsync(project, globalVmExtensionPolicyResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param globalVmExtensionPolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, GlobalVmExtensionPolicy globalVmExtensionPolicyResource) {
    InsertGlobalVmExtensionPolicyRequest request =
        InsertGlobalVmExtensionPolicyRequest.newBuilder()
            .setProject(project)
            .setGlobalVmExtensionPolicyResource(globalVmExtensionPolicyResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new project level GlobalVmExtensionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
   *     GlobalVmExtensionPoliciesClient.create()) {
   *   InsertGlobalVmExtensionPolicyRequest request =
   *       InsertGlobalVmExtensionPolicyRequest.newBuilder()
   *           .setGlobalVmExtensionPolicyResource(GlobalVmExtensionPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = globalVmExtensionPoliciesClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertGlobalVmExtensionPolicyRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new project level GlobalVmExtensionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
   *     GlobalVmExtensionPoliciesClient.create()) {
   *   InsertGlobalVmExtensionPolicyRequest request =
   *       InsertGlobalVmExtensionPolicyRequest.newBuilder()
   *           .setGlobalVmExtensionPolicyResource(GlobalVmExtensionPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       globalVmExtensionPoliciesClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertGlobalVmExtensionPolicyRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new project level GlobalVmExtensionPolicy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
   *     GlobalVmExtensionPoliciesClient.create()) {
   *   InsertGlobalVmExtensionPolicyRequest request =
   *       InsertGlobalVmExtensionPolicyRequest.newBuilder()
   *           .setGlobalVmExtensionPolicyResource(GlobalVmExtensionPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       globalVmExtensionPoliciesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertGlobalVmExtensionPolicyRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists global VM extension policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
   *     GlobalVmExtensionPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   for (GlobalVmExtensionPolicy element :
   *       globalVmExtensionPoliciesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListGlobalVmExtensionPoliciesRequest request =
        ListGlobalVmExtensionPoliciesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists global VM extension policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
   *     GlobalVmExtensionPoliciesClient.create()) {
   *   ListGlobalVmExtensionPoliciesRequest request =
   *       ListGlobalVmExtensionPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (GlobalVmExtensionPolicy element :
   *       globalVmExtensionPoliciesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListGlobalVmExtensionPoliciesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists global VM extension policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
   *     GlobalVmExtensionPoliciesClient.create()) {
   *   ListGlobalVmExtensionPoliciesRequest request =
   *       ListGlobalVmExtensionPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<GlobalVmExtensionPolicy> future =
   *       globalVmExtensionPoliciesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (GlobalVmExtensionPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListGlobalVmExtensionPoliciesRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists global VM extension policies.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
   *     GlobalVmExtensionPoliciesClient.create()) {
   *   ListGlobalVmExtensionPoliciesRequest request =
   *       ListGlobalVmExtensionPoliciesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     GlobalVmExtensionPolicyList response =
   *         globalVmExtensionPoliciesClient.listCallable().call(request);
   *     for (GlobalVmExtensionPolicy element : response.getItemsList()) {
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
  public final UnaryCallable<ListGlobalVmExtensionPoliciesRequest, GlobalVmExtensionPolicyList>
      listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a global VM extension policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
   *     GlobalVmExtensionPoliciesClient.create()) {
   *   String project = "project-309310695";
   *   String globalVmExtensionPolicy = "globalVmExtensionPolicy-869114569";
   *   GlobalVmExtensionPolicy globalVmExtensionPolicyResource =
   *       GlobalVmExtensionPolicy.newBuilder().build();
   *   Operation response =
   *       globalVmExtensionPoliciesClient
   *           .updateAsync(project, globalVmExtensionPolicy, globalVmExtensionPolicyResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param globalVmExtensionPolicy Name of the global VM extension policy to update.
   * @param globalVmExtensionPolicyResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> updateAsync(
      String project,
      String globalVmExtensionPolicy,
      GlobalVmExtensionPolicy globalVmExtensionPolicyResource) {
    UpdateGlobalVmExtensionPolicyRequest request =
        UpdateGlobalVmExtensionPolicyRequest.newBuilder()
            .setProject(project)
            .setGlobalVmExtensionPolicy(globalVmExtensionPolicy)
            .setGlobalVmExtensionPolicyResource(globalVmExtensionPolicyResource)
            .build();
    return updateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a global VM extension policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
   *     GlobalVmExtensionPoliciesClient.create()) {
   *   UpdateGlobalVmExtensionPolicyRequest request =
   *       UpdateGlobalVmExtensionPolicyRequest.newBuilder()
   *           .setGlobalVmExtensionPolicy("globalVmExtensionPolicy-869114569")
   *           .setGlobalVmExtensionPolicyResource(GlobalVmExtensionPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = globalVmExtensionPoliciesClient.updateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> updateAsync(
      UpdateGlobalVmExtensionPolicyRequest request) {
    return updateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a global VM extension policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
   *     GlobalVmExtensionPoliciesClient.create()) {
   *   UpdateGlobalVmExtensionPolicyRequest request =
   *       UpdateGlobalVmExtensionPolicyRequest.newBuilder()
   *           .setGlobalVmExtensionPolicy("globalVmExtensionPolicy-869114569")
   *           .setGlobalVmExtensionPolicyResource(GlobalVmExtensionPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       globalVmExtensionPoliciesClient.updateOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateGlobalVmExtensionPolicyRequest, Operation, Operation>
      updateOperationCallable() {
    return stub.updateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a global VM extension policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (GlobalVmExtensionPoliciesClient globalVmExtensionPoliciesClient =
   *     GlobalVmExtensionPoliciesClient.create()) {
   *   UpdateGlobalVmExtensionPolicyRequest request =
   *       UpdateGlobalVmExtensionPolicyRequest.newBuilder()
   *           .setGlobalVmExtensionPolicy("globalVmExtensionPolicy-869114569")
   *           .setGlobalVmExtensionPolicyResource(GlobalVmExtensionPolicy.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       globalVmExtensionPoliciesClient.updateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateGlobalVmExtensionPolicyRequest, Operation> updateCallable() {
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

  public static class AggregatedListPagedResponse
      extends AbstractPagedListResponse<
          AggregatedListGlobalVmExtensionPoliciesRequest,
          VmExtensionPolicyAggregatedListResponse,
          Map.Entry<String, VmExtensionPoliciesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    public static ApiFuture<AggregatedListPagedResponse> createAsync(
        PageContext<
                AggregatedListGlobalVmExtensionPoliciesRequest,
                VmExtensionPolicyAggregatedListResponse,
                Map.Entry<String, VmExtensionPoliciesScopedList>>
            context,
        ApiFuture<VmExtensionPolicyAggregatedListResponse> futureResponse) {
      ApiFuture<AggregatedListPage> futurePage =
          AggregatedListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new AggregatedListPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private AggregatedListPagedResponse(AggregatedListPage page) {
      super(page, AggregatedListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class AggregatedListPage
      extends AbstractPage<
          AggregatedListGlobalVmExtensionPoliciesRequest,
          VmExtensionPolicyAggregatedListResponse,
          Map.Entry<String, VmExtensionPoliciesScopedList>,
          AggregatedListPage> {

    private AggregatedListPage(
        PageContext<
                AggregatedListGlobalVmExtensionPoliciesRequest,
                VmExtensionPolicyAggregatedListResponse,
                Map.Entry<String, VmExtensionPoliciesScopedList>>
            context,
        VmExtensionPolicyAggregatedListResponse response) {
      super(context, response);
    }

    private static AggregatedListPage createEmptyPage() {
      return new AggregatedListPage(null, null);
    }

    @Override
    protected AggregatedListPage createPage(
        PageContext<
                AggregatedListGlobalVmExtensionPoliciesRequest,
                VmExtensionPolicyAggregatedListResponse,
                Map.Entry<String, VmExtensionPoliciesScopedList>>
            context,
        VmExtensionPolicyAggregatedListResponse response) {
      return new AggregatedListPage(context, response);
    }

    @Override
    public ApiFuture<AggregatedListPage> createPageAsync(
        PageContext<
                AggregatedListGlobalVmExtensionPoliciesRequest,
                VmExtensionPolicyAggregatedListResponse,
                Map.Entry<String, VmExtensionPoliciesScopedList>>
            context,
        ApiFuture<VmExtensionPolicyAggregatedListResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class AggregatedListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          AggregatedListGlobalVmExtensionPoliciesRequest,
          VmExtensionPolicyAggregatedListResponse,
          Map.Entry<String, VmExtensionPoliciesScopedList>,
          AggregatedListPage,
          AggregatedListFixedSizeCollection> {

    private AggregatedListFixedSizeCollection(List<AggregatedListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static AggregatedListFixedSizeCollection createEmptyCollection() {
      return new AggregatedListFixedSizeCollection(null, 0);
    }

    @Override
    protected AggregatedListFixedSizeCollection createCollection(
        List<AggregatedListPage> pages, int collectionSize) {
      return new AggregatedListFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListGlobalVmExtensionPoliciesRequest,
          GlobalVmExtensionPolicyList,
          GlobalVmExtensionPolicy,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<
                ListGlobalVmExtensionPoliciesRequest,
                GlobalVmExtensionPolicyList,
                GlobalVmExtensionPolicy>
            context,
        ApiFuture<GlobalVmExtensionPolicyList> futureResponse) {
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
      extends AbstractPage<
          ListGlobalVmExtensionPoliciesRequest,
          GlobalVmExtensionPolicyList,
          GlobalVmExtensionPolicy,
          ListPage> {

    private ListPage(
        PageContext<
                ListGlobalVmExtensionPoliciesRequest,
                GlobalVmExtensionPolicyList,
                GlobalVmExtensionPolicy>
            context,
        GlobalVmExtensionPolicyList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<
                ListGlobalVmExtensionPoliciesRequest,
                GlobalVmExtensionPolicyList,
                GlobalVmExtensionPolicy>
            context,
        GlobalVmExtensionPolicyList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<
                ListGlobalVmExtensionPoliciesRequest,
                GlobalVmExtensionPolicyList,
                GlobalVmExtensionPolicy>
            context,
        ApiFuture<GlobalVmExtensionPolicyList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListGlobalVmExtensionPoliciesRequest,
          GlobalVmExtensionPolicyList,
          GlobalVmExtensionPolicy,
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
