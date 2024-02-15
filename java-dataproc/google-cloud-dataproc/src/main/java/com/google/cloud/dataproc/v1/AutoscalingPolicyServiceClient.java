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

package com.google.cloud.dataproc.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dataproc.v1.stub.AutoscalingPolicyServiceStub;
import com.google.cloud.dataproc.v1.stub.AutoscalingPolicyServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The API interface for managing autoscaling policies in the Dataproc API.
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
 * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
 *     AutoscalingPolicyServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();
 *   AutoscalingPolicy response =
 *       autoscalingPolicyServiceClient.createAutoscalingPolicy(parent, policy);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AutoscalingPolicyServiceClient object to clean up
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
 *      <td><p> CreateAutoscalingPolicy</td>
 *      <td><p> Creates new autoscaling policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAutoscalingPolicy(CreateAutoscalingPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createAutoscalingPolicy(LocationName parent, AutoscalingPolicy policy)
 *           <li><p> createAutoscalingPolicy(RegionName parent, AutoscalingPolicy policy)
 *           <li><p> createAutoscalingPolicy(String parent, AutoscalingPolicy policy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAutoscalingPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAutoscalingPolicy</td>
 *      <td><p> Updates (replaces) autoscaling policy.
 * <p>  Disabled check for update_mask, because all updates will be full replacements.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAutoscalingPolicy(UpdateAutoscalingPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateAutoscalingPolicy(AutoscalingPolicy policy)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAutoscalingPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAutoscalingPolicy</td>
 *      <td><p> Retrieves autoscaling policy.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAutoscalingPolicy(GetAutoscalingPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAutoscalingPolicy(AutoscalingPolicyName name)
 *           <li><p> getAutoscalingPolicy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAutoscalingPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAutoscalingPolicies</td>
 *      <td><p> Lists autoscaling policies in the project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAutoscalingPolicies(ListAutoscalingPoliciesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAutoscalingPolicies(LocationName parent)
 *           <li><p> listAutoscalingPolicies(RegionName parent)
 *           <li><p> listAutoscalingPolicies(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAutoscalingPoliciesPagedCallable()
 *           <li><p> listAutoscalingPoliciesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteAutoscalingPolicy</td>
 *      <td><p> Deletes an autoscaling policy. It is an error to delete an autoscaling policy that is in use by one or more clusters.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAutoscalingPolicy(DeleteAutoscalingPolicyRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteAutoscalingPolicy(AutoscalingPolicyName name)
 *           <li><p> deleteAutoscalingPolicy(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteAutoscalingPolicyCallable()
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
 * AutoscalingPolicyServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AutoscalingPolicyServiceSettings autoscalingPolicyServiceSettings =
 *     AutoscalingPolicyServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
 *     AutoscalingPolicyServiceClient.create(autoscalingPolicyServiceSettings);
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
 * AutoscalingPolicyServiceSettings autoscalingPolicyServiceSettings =
 *     AutoscalingPolicyServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
 *     AutoscalingPolicyServiceClient.create(autoscalingPolicyServiceSettings);
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
 * AutoscalingPolicyServiceSettings autoscalingPolicyServiceSettings =
 *     AutoscalingPolicyServiceSettings.newHttpJsonBuilder().build();
 * AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
 *     AutoscalingPolicyServiceClient.create(autoscalingPolicyServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AutoscalingPolicyServiceClient implements BackgroundResource {
  private final AutoscalingPolicyServiceSettings settings;
  private final AutoscalingPolicyServiceStub stub;

  /** Constructs an instance of AutoscalingPolicyServiceClient with default settings. */
  public static final AutoscalingPolicyServiceClient create() throws IOException {
    return create(AutoscalingPolicyServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AutoscalingPolicyServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final AutoscalingPolicyServiceClient create(
      AutoscalingPolicyServiceSettings settings) throws IOException {
    return new AutoscalingPolicyServiceClient(settings);
  }

  /**
   * Constructs an instance of AutoscalingPolicyServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(AutoscalingPolicyServiceSettings).
   */
  public static final AutoscalingPolicyServiceClient create(AutoscalingPolicyServiceStub stub) {
    return new AutoscalingPolicyServiceClient(stub);
  }

  /**
   * Constructs an instance of AutoscalingPolicyServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AutoscalingPolicyServiceClient(AutoscalingPolicyServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((AutoscalingPolicyServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AutoscalingPolicyServiceClient(AutoscalingPolicyServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AutoscalingPolicyServiceSettings getSettings() {
    return settings;
  }

  public AutoscalingPolicyServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new autoscaling policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();
   *   AutoscalingPolicy response =
   *       autoscalingPolicyServiceClient.createAutoscalingPolicy(parent, policy);
   * }
   * }</pre>
   *
   * @param parent Required. The "resource name" of the region or location, as described in
   *     https://cloud.google.com/apis/design/resource_names.
   *     <ul>
   *       <li>For `projects.regions.autoscalingPolicies.create`, the resource name of the region
   *           has the following format: `projects/{project_id}/regions/{region}`
   *     </ul>
   *     <ul>
   *       <li>For `projects.locations.autoscalingPolicies.create`, the resource name of the
   *           location has the following format: `projects/{project_id}/locations/{location}`
   *     </ul>
   *
   * @param policy Required. The autoscaling policy to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutoscalingPolicy createAutoscalingPolicy(
      LocationName parent, AutoscalingPolicy policy) {
    CreateAutoscalingPolicyRequest request =
        CreateAutoscalingPolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPolicy(policy)
            .build();
    return createAutoscalingPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new autoscaling policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   RegionName parent = RegionName.of("[PROJECT]", "[REGION]");
   *   AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();
   *   AutoscalingPolicy response =
   *       autoscalingPolicyServiceClient.createAutoscalingPolicy(parent, policy);
   * }
   * }</pre>
   *
   * @param parent Required. The "resource name" of the region or location, as described in
   *     https://cloud.google.com/apis/design/resource_names.
   *     <ul>
   *       <li>For `projects.regions.autoscalingPolicies.create`, the resource name of the region
   *           has the following format: `projects/{project_id}/regions/{region}`
   *     </ul>
   *     <ul>
   *       <li>For `projects.locations.autoscalingPolicies.create`, the resource name of the
   *           location has the following format: `projects/{project_id}/locations/{location}`
   *     </ul>
   *
   * @param policy Required. The autoscaling policy to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutoscalingPolicy createAutoscalingPolicy(
      RegionName parent, AutoscalingPolicy policy) {
    CreateAutoscalingPolicyRequest request =
        CreateAutoscalingPolicyRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setPolicy(policy)
            .build();
    return createAutoscalingPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new autoscaling policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();
   *   AutoscalingPolicy response =
   *       autoscalingPolicyServiceClient.createAutoscalingPolicy(parent, policy);
   * }
   * }</pre>
   *
   * @param parent Required. The "resource name" of the region or location, as described in
   *     https://cloud.google.com/apis/design/resource_names.
   *     <ul>
   *       <li>For `projects.regions.autoscalingPolicies.create`, the resource name of the region
   *           has the following format: `projects/{project_id}/regions/{region}`
   *     </ul>
   *     <ul>
   *       <li>For `projects.locations.autoscalingPolicies.create`, the resource name of the
   *           location has the following format: `projects/{project_id}/locations/{location}`
   *     </ul>
   *
   * @param policy Required. The autoscaling policy to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutoscalingPolicy createAutoscalingPolicy(String parent, AutoscalingPolicy policy) {
    CreateAutoscalingPolicyRequest request =
        CreateAutoscalingPolicyRequest.newBuilder().setParent(parent).setPolicy(policy).build();
    return createAutoscalingPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new autoscaling policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   CreateAutoscalingPolicyRequest request =
   *       CreateAutoscalingPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPolicy(AutoscalingPolicy.newBuilder().build())
   *           .build();
   *   AutoscalingPolicy response = autoscalingPolicyServiceClient.createAutoscalingPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutoscalingPolicy createAutoscalingPolicy(CreateAutoscalingPolicyRequest request) {
    return createAutoscalingPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates new autoscaling policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   CreateAutoscalingPolicyRequest request =
   *       CreateAutoscalingPolicyRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPolicy(AutoscalingPolicy.newBuilder().build())
   *           .build();
   *   ApiFuture<AutoscalingPolicy> future =
   *       autoscalingPolicyServiceClient.createAutoscalingPolicyCallable().futureCall(request);
   *   // Do something.
   *   AutoscalingPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAutoscalingPolicyRequest, AutoscalingPolicy>
      createAutoscalingPolicyCallable() {
    return stub.createAutoscalingPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates (replaces) autoscaling policy.
   *
   * <p>Disabled check for update_mask, because all updates will be full replacements.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   AutoscalingPolicy policy = AutoscalingPolicy.newBuilder().build();
   *   AutoscalingPolicy response = autoscalingPolicyServiceClient.updateAutoscalingPolicy(policy);
   * }
   * }</pre>
   *
   * @param policy Required. The updated autoscaling policy.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutoscalingPolicy updateAutoscalingPolicy(AutoscalingPolicy policy) {
    UpdateAutoscalingPolicyRequest request =
        UpdateAutoscalingPolicyRequest.newBuilder().setPolicy(policy).build();
    return updateAutoscalingPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates (replaces) autoscaling policy.
   *
   * <p>Disabled check for update_mask, because all updates will be full replacements.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   UpdateAutoscalingPolicyRequest request =
   *       UpdateAutoscalingPolicyRequest.newBuilder()
   *           .setPolicy(AutoscalingPolicy.newBuilder().build())
   *           .build();
   *   AutoscalingPolicy response = autoscalingPolicyServiceClient.updateAutoscalingPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutoscalingPolicy updateAutoscalingPolicy(UpdateAutoscalingPolicyRequest request) {
    return updateAutoscalingPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates (replaces) autoscaling policy.
   *
   * <p>Disabled check for update_mask, because all updates will be full replacements.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   UpdateAutoscalingPolicyRequest request =
   *       UpdateAutoscalingPolicyRequest.newBuilder()
   *           .setPolicy(AutoscalingPolicy.newBuilder().build())
   *           .build();
   *   ApiFuture<AutoscalingPolicy> future =
   *       autoscalingPolicyServiceClient.updateAutoscalingPolicyCallable().futureCall(request);
   *   // Do something.
   *   AutoscalingPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAutoscalingPolicyRequest, AutoscalingPolicy>
      updateAutoscalingPolicyCallable() {
    return stub.updateAutoscalingPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves autoscaling policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   AutoscalingPolicyName name =
   *       AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
   *           "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]");
   *   AutoscalingPolicy response = autoscalingPolicyServiceClient.getAutoscalingPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The "resource name" of the autoscaling policy, as described in
   *     https://cloud.google.com/apis/design/resource_names.
   *     <ul>
   *       <li>For `projects.regions.autoscalingPolicies.get`, the resource name of the policy has
   *           the following format:
   *           `projects/{project_id}/regions/{region}/autoscalingPolicies/{policy_id}`
   *     </ul>
   *     <ul>
   *       <li>For `projects.locations.autoscalingPolicies.get`, the resource name of the policy has
   *           the following format:
   *           `projects/{project_id}/locations/{location}/autoscalingPolicies/{policy_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutoscalingPolicy getAutoscalingPolicy(AutoscalingPolicyName name) {
    GetAutoscalingPolicyRequest request =
        GetAutoscalingPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAutoscalingPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves autoscaling policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   String name =
   *       AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
   *               "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]")
   *           .toString();
   *   AutoscalingPolicy response = autoscalingPolicyServiceClient.getAutoscalingPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The "resource name" of the autoscaling policy, as described in
   *     https://cloud.google.com/apis/design/resource_names.
   *     <ul>
   *       <li>For `projects.regions.autoscalingPolicies.get`, the resource name of the policy has
   *           the following format:
   *           `projects/{project_id}/regions/{region}/autoscalingPolicies/{policy_id}`
   *     </ul>
   *     <ul>
   *       <li>For `projects.locations.autoscalingPolicies.get`, the resource name of the policy has
   *           the following format:
   *           `projects/{project_id}/locations/{location}/autoscalingPolicies/{policy_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutoscalingPolicy getAutoscalingPolicy(String name) {
    GetAutoscalingPolicyRequest request =
        GetAutoscalingPolicyRequest.newBuilder().setName(name).build();
    return getAutoscalingPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves autoscaling policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   GetAutoscalingPolicyRequest request =
   *       GetAutoscalingPolicyRequest.newBuilder()
   *           .setName(
   *               AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
   *                       "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .build();
   *   AutoscalingPolicy response = autoscalingPolicyServiceClient.getAutoscalingPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AutoscalingPolicy getAutoscalingPolicy(GetAutoscalingPolicyRequest request) {
    return getAutoscalingPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves autoscaling policy.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   GetAutoscalingPolicyRequest request =
   *       GetAutoscalingPolicyRequest.newBuilder()
   *           .setName(
   *               AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
   *                       "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<AutoscalingPolicy> future =
   *       autoscalingPolicyServiceClient.getAutoscalingPolicyCallable().futureCall(request);
   *   // Do something.
   *   AutoscalingPolicy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAutoscalingPolicyRequest, AutoscalingPolicy>
      getAutoscalingPolicyCallable() {
    return stub.getAutoscalingPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists autoscaling policies in the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (AutoscalingPolicy element :
   *       autoscalingPolicyServiceClient.listAutoscalingPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The "resource name" of the region or location, as described in
   *     https://cloud.google.com/apis/design/resource_names.
   *     <ul>
   *       <li>For `projects.regions.autoscalingPolicies.list`, the resource name of the region has
   *           the following format: `projects/{project_id}/regions/{region}`
   *     </ul>
   *     <ul>
   *       <li>For `projects.locations.autoscalingPolicies.list`, the resource name of the location
   *           has the following format: `projects/{project_id}/locations/{location}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutoscalingPoliciesPagedResponse listAutoscalingPolicies(LocationName parent) {
    ListAutoscalingPoliciesRequest request =
        ListAutoscalingPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAutoscalingPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists autoscaling policies in the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   RegionName parent = RegionName.of("[PROJECT]", "[REGION]");
   *   for (AutoscalingPolicy element :
   *       autoscalingPolicyServiceClient.listAutoscalingPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The "resource name" of the region or location, as described in
   *     https://cloud.google.com/apis/design/resource_names.
   *     <ul>
   *       <li>For `projects.regions.autoscalingPolicies.list`, the resource name of the region has
   *           the following format: `projects/{project_id}/regions/{region}`
   *     </ul>
   *     <ul>
   *       <li>For `projects.locations.autoscalingPolicies.list`, the resource name of the location
   *           has the following format: `projects/{project_id}/locations/{location}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutoscalingPoliciesPagedResponse listAutoscalingPolicies(RegionName parent) {
    ListAutoscalingPoliciesRequest request =
        ListAutoscalingPoliciesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAutoscalingPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists autoscaling policies in the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (AutoscalingPolicy element :
   *       autoscalingPolicyServiceClient.listAutoscalingPolicies(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The "resource name" of the region or location, as described in
   *     https://cloud.google.com/apis/design/resource_names.
   *     <ul>
   *       <li>For `projects.regions.autoscalingPolicies.list`, the resource name of the region has
   *           the following format: `projects/{project_id}/regions/{region}`
   *     </ul>
   *     <ul>
   *       <li>For `projects.locations.autoscalingPolicies.list`, the resource name of the location
   *           has the following format: `projects/{project_id}/locations/{location}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutoscalingPoliciesPagedResponse listAutoscalingPolicies(String parent) {
    ListAutoscalingPoliciesRequest request =
        ListAutoscalingPoliciesRequest.newBuilder().setParent(parent).build();
    return listAutoscalingPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists autoscaling policies in the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   ListAutoscalingPoliciesRequest request =
   *       ListAutoscalingPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AutoscalingPolicy element :
   *       autoscalingPolicyServiceClient.listAutoscalingPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAutoscalingPoliciesPagedResponse listAutoscalingPolicies(
      ListAutoscalingPoliciesRequest request) {
    return listAutoscalingPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists autoscaling policies in the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   ListAutoscalingPoliciesRequest request =
   *       ListAutoscalingPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AutoscalingPolicy> future =
   *       autoscalingPolicyServiceClient.listAutoscalingPoliciesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AutoscalingPolicy element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesPagedResponse>
      listAutoscalingPoliciesPagedCallable() {
    return stub.listAutoscalingPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists autoscaling policies in the project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   ListAutoscalingPoliciesRequest request =
   *       ListAutoscalingPoliciesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAutoscalingPoliciesResponse response =
   *         autoscalingPolicyServiceClient.listAutoscalingPoliciesCallable().call(request);
   *     for (AutoscalingPolicy element : response.getPoliciesList()) {
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
  public final UnaryCallable<ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse>
      listAutoscalingPoliciesCallable() {
    return stub.listAutoscalingPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an autoscaling policy. It is an error to delete an autoscaling policy that is in use by
   * one or more clusters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   AutoscalingPolicyName name =
   *       AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
   *           "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]");
   *   autoscalingPolicyServiceClient.deleteAutoscalingPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The "resource name" of the autoscaling policy, as described in
   *     https://cloud.google.com/apis/design/resource_names.
   *     <ul>
   *       <li>For `projects.regions.autoscalingPolicies.delete`, the resource name of the policy
   *           has the following format:
   *           `projects/{project_id}/regions/{region}/autoscalingPolicies/{policy_id}`
   *     </ul>
   *     <ul>
   *       <li>For `projects.locations.autoscalingPolicies.delete`, the resource name of the policy
   *           has the following format:
   *           `projects/{project_id}/locations/{location}/autoscalingPolicies/{policy_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAutoscalingPolicy(AutoscalingPolicyName name) {
    DeleteAutoscalingPolicyRequest request =
        DeleteAutoscalingPolicyRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteAutoscalingPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an autoscaling policy. It is an error to delete an autoscaling policy that is in use by
   * one or more clusters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   String name =
   *       AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
   *               "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]")
   *           .toString();
   *   autoscalingPolicyServiceClient.deleteAutoscalingPolicy(name);
   * }
   * }</pre>
   *
   * @param name Required. The "resource name" of the autoscaling policy, as described in
   *     https://cloud.google.com/apis/design/resource_names.
   *     <ul>
   *       <li>For `projects.regions.autoscalingPolicies.delete`, the resource name of the policy
   *           has the following format:
   *           `projects/{project_id}/regions/{region}/autoscalingPolicies/{policy_id}`
   *     </ul>
   *     <ul>
   *       <li>For `projects.locations.autoscalingPolicies.delete`, the resource name of the policy
   *           has the following format:
   *           `projects/{project_id}/locations/{location}/autoscalingPolicies/{policy_id}`
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAutoscalingPolicy(String name) {
    DeleteAutoscalingPolicyRequest request =
        DeleteAutoscalingPolicyRequest.newBuilder().setName(name).build();
    deleteAutoscalingPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an autoscaling policy. It is an error to delete an autoscaling policy that is in use by
   * one or more clusters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   DeleteAutoscalingPolicyRequest request =
   *       DeleteAutoscalingPolicyRequest.newBuilder()
   *           .setName(
   *               AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
   *                       "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .build();
   *   autoscalingPolicyServiceClient.deleteAutoscalingPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAutoscalingPolicy(DeleteAutoscalingPolicyRequest request) {
    deleteAutoscalingPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an autoscaling policy. It is an error to delete an autoscaling policy that is in use by
   * one or more clusters.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   DeleteAutoscalingPolicyRequest request =
   *       DeleteAutoscalingPolicyRequest.newBuilder()
   *           .setName(
   *               AutoscalingPolicyName.ofProjectLocationAutoscalingPolicyName(
   *                       "[PROJECT]", "[LOCATION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       autoscalingPolicyServiceClient.deleteAutoscalingPolicyCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteAutoscalingPolicyRequest, Empty>
      deleteAutoscalingPolicyCallable() {
    return stub.deleteAutoscalingPolicyCallable();
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
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = autoscalingPolicyServiceClient.setIamPolicy(request);
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
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       autoscalingPolicyServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = autoscalingPolicyServiceClient.getIamPolicy(request);
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
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       autoscalingPolicyServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response =
   *       autoscalingPolicyServiceClient.testIamPermissions(request);
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
   * try (AutoscalingPolicyServiceClient autoscalingPolicyServiceClient =
   *     AutoscalingPolicyServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               AutoscalingPolicyName.ofProjectRegionAutoscalingPolicyName(
   *                       "[PROJECT]", "[REGION]", "[AUTOSCALING_POLICY]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       autoscalingPolicyServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListAutoscalingPoliciesPagedResponse
      extends AbstractPagedListResponse<
          ListAutoscalingPoliciesRequest,
          ListAutoscalingPoliciesResponse,
          AutoscalingPolicy,
          ListAutoscalingPoliciesPage,
          ListAutoscalingPoliciesFixedSizeCollection> {

    public static ApiFuture<ListAutoscalingPoliciesPagedResponse> createAsync(
        PageContext<
                ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse, AutoscalingPolicy>
            context,
        ApiFuture<ListAutoscalingPoliciesResponse> futureResponse) {
      ApiFuture<ListAutoscalingPoliciesPage> futurePage =
          ListAutoscalingPoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAutoscalingPoliciesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAutoscalingPoliciesPagedResponse(ListAutoscalingPoliciesPage page) {
      super(page, ListAutoscalingPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAutoscalingPoliciesPage
      extends AbstractPage<
          ListAutoscalingPoliciesRequest,
          ListAutoscalingPoliciesResponse,
          AutoscalingPolicy,
          ListAutoscalingPoliciesPage> {

    private ListAutoscalingPoliciesPage(
        PageContext<
                ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse, AutoscalingPolicy>
            context,
        ListAutoscalingPoliciesResponse response) {
      super(context, response);
    }

    private static ListAutoscalingPoliciesPage createEmptyPage() {
      return new ListAutoscalingPoliciesPage(null, null);
    }

    @Override
    protected ListAutoscalingPoliciesPage createPage(
        PageContext<
                ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse, AutoscalingPolicy>
            context,
        ListAutoscalingPoliciesResponse response) {
      return new ListAutoscalingPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<ListAutoscalingPoliciesPage> createPageAsync(
        PageContext<
                ListAutoscalingPoliciesRequest, ListAutoscalingPoliciesResponse, AutoscalingPolicy>
            context,
        ApiFuture<ListAutoscalingPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAutoscalingPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAutoscalingPoliciesRequest,
          ListAutoscalingPoliciesResponse,
          AutoscalingPolicy,
          ListAutoscalingPoliciesPage,
          ListAutoscalingPoliciesFixedSizeCollection> {

    private ListAutoscalingPoliciesFixedSizeCollection(
        List<ListAutoscalingPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAutoscalingPoliciesFixedSizeCollection createEmptyCollection() {
      return new ListAutoscalingPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAutoscalingPoliciesFixedSizeCollection createCollection(
        List<ListAutoscalingPoliciesPage> pages, int collectionSize) {
      return new ListAutoscalingPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }
}
