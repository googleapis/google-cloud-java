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

package com.google.cloud.iap.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.iap.v1.stub.IdentityAwareProxyAdminServiceStub;
import com.google.cloud.iap.v1.stub.IdentityAwareProxyAdminServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: APIs for Identity-Aware Proxy Admin configurations.
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
 * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
 *     IdentityAwareProxyAdminServiceClient.create()) {
 *   SetIamPolicyRequest request =
 *       SetIamPolicyRequest.newBuilder()
 *           .setResource(
 *               TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
 *           .setPolicy(Policy.newBuilder().build())
 *           .setUpdateMask(FieldMask.newBuilder().build())
 *           .build();
 *   Policy response = identityAwareProxyAdminServiceClient.setIamPolicy(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the IdentityAwareProxyAdminServiceClient object to clean
 * up resources such as threads. In the example above, try-with-resources is used, which
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
 *      <td><p> SetIamPolicy</td>
 *      <td><p> Sets the access control policy for an Identity-Aware Proxy protected resource. Replaces any existing policy. More information about managing access via IAP can be found at: https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api</td>
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
 *      <td><p> Gets the access control policy for an Identity-Aware Proxy protected resource. More information about managing access via IAP can be found at: https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api</td>
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
 *      <td><p> Returns permissions that a caller has on the Identity-Aware Proxy protected resource. More information about managing access via IAP can be found at: https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api</td>
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
 *    <tr>
 *      <td><p> GetIapSettings</td>
 *      <td><p> Gets the IAP settings on a particular IAP protected resource.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getIapSettings(GetIapSettingsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getIapSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateIapSettings</td>
 *      <td><p> Updates the IAP settings on a particular IAP protected resource. It replaces all fields unless the `update_mask` is set.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateIapSettings(UpdateIapSettingsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateIapSettingsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTunnelDestGroups</td>
 *      <td><p> Lists the existing TunnelDestGroups. To group across all locations, use a `-` as the location ID. For example: `/v1/projects/123/iap_tunnel/locations/-/destGroups`</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTunnelDestGroups(ListTunnelDestGroupsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTunnelDestGroups(TunnelLocationName parent)
 *           <li><p> listTunnelDestGroups(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTunnelDestGroupsPagedCallable()
 *           <li><p> listTunnelDestGroupsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTunnelDestGroup</td>
 *      <td><p> Creates a new TunnelDestGroup.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTunnelDestGroup(CreateTunnelDestGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createTunnelDestGroup(TunnelLocationName parent, TunnelDestGroup tunnelDestGroup, String tunnelDestGroupId)
 *           <li><p> createTunnelDestGroup(String parent, TunnelDestGroup tunnelDestGroup, String tunnelDestGroupId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTunnelDestGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTunnelDestGroup</td>
 *      <td><p> Retrieves an existing TunnelDestGroup.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTunnelDestGroup(GetTunnelDestGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTunnelDestGroup(TunnelDestGroupName name)
 *           <li><p> getTunnelDestGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTunnelDestGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTunnelDestGroup</td>
 *      <td><p> Deletes a TunnelDestGroup.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTunnelDestGroup(DeleteTunnelDestGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteTunnelDestGroup(TunnelDestGroupName name)
 *           <li><p> deleteTunnelDestGroup(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteTunnelDestGroupCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTunnelDestGroup</td>
 *      <td><p> Updates a TunnelDestGroup.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTunnelDestGroup(UpdateTunnelDestGroupRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateTunnelDestGroup(TunnelDestGroup tunnelDestGroup, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateTunnelDestGroupCallable()
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
 * IdentityAwareProxyAdminServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IdentityAwareProxyAdminServiceSettings identityAwareProxyAdminServiceSettings =
 *     IdentityAwareProxyAdminServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
 *     IdentityAwareProxyAdminServiceClient.create(identityAwareProxyAdminServiceSettings);
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
 * IdentityAwareProxyAdminServiceSettings identityAwareProxyAdminServiceSettings =
 *     IdentityAwareProxyAdminServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
 *     IdentityAwareProxyAdminServiceClient.create(identityAwareProxyAdminServiceSettings);
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
 * IdentityAwareProxyAdminServiceSettings identityAwareProxyAdminServiceSettings =
 *     IdentityAwareProxyAdminServiceSettings.newHttpJsonBuilder().build();
 * IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
 *     IdentityAwareProxyAdminServiceClient.create(identityAwareProxyAdminServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class IdentityAwareProxyAdminServiceClient implements BackgroundResource {
  private final IdentityAwareProxyAdminServiceSettings settings;
  private final IdentityAwareProxyAdminServiceStub stub;

  /** Constructs an instance of IdentityAwareProxyAdminServiceClient with default settings. */
  public static final IdentityAwareProxyAdminServiceClient create() throws IOException {
    return create(IdentityAwareProxyAdminServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of IdentityAwareProxyAdminServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final IdentityAwareProxyAdminServiceClient create(
      IdentityAwareProxyAdminServiceSettings settings) throws IOException {
    return new IdentityAwareProxyAdminServiceClient(settings);
  }

  /**
   * Constructs an instance of IdentityAwareProxyAdminServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using
   * create(IdentityAwareProxyAdminServiceSettings).
   */
  public static final IdentityAwareProxyAdminServiceClient create(
      IdentityAwareProxyAdminServiceStub stub) {
    return new IdentityAwareProxyAdminServiceClient(stub);
  }

  /**
   * Constructs an instance of IdentityAwareProxyAdminServiceClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected IdentityAwareProxyAdminServiceClient(IdentityAwareProxyAdminServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((IdentityAwareProxyAdminServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected IdentityAwareProxyAdminServiceClient(IdentityAwareProxyAdminServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final IdentityAwareProxyAdminServiceSettings getSettings() {
    return settings;
  }

  public IdentityAwareProxyAdminServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy for an Identity-Aware Proxy protected resource. Replaces any
   * existing policy. More information about managing access via IAP can be found at:
   * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = identityAwareProxyAdminServiceClient.setIamPolicy(request);
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
   * Sets the access control policy for an Identity-Aware Proxy protected resource. Replaces any
   * existing policy. More information about managing access via IAP can be found at:
   * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       identityAwareProxyAdminServiceClient.setIamPolicyCallable().futureCall(request);
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
   * Gets the access control policy for an Identity-Aware Proxy protected resource. More information
   * about managing access via IAP can be found at:
   * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = identityAwareProxyAdminServiceClient.getIamPolicy(request);
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
   * Gets the access control policy for an Identity-Aware Proxy protected resource. More information
   * about managing access via IAP can be found at:
   * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       identityAwareProxyAdminServiceClient.getIamPolicyCallable().futureCall(request);
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
   * Returns permissions that a caller has on the Identity-Aware Proxy protected resource. More
   * information about managing access via IAP can be found at:
   * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response =
   *       identityAwareProxyAdminServiceClient.testIamPermissions(request);
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
   * Returns permissions that a caller has on the Identity-Aware Proxy protected resource. More
   * information about managing access via IAP can be found at:
   * https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       identityAwareProxyAdminServiceClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAP settings on a particular IAP protected resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   GetIapSettingsRequest request =
   *       GetIapSettingsRequest.newBuilder().setName("name3373707").build();
   *   IapSettings response = identityAwareProxyAdminServiceClient.getIapSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IapSettings getIapSettings(GetIapSettingsRequest request) {
    return getIapSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the IAP settings on a particular IAP protected resource.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   GetIapSettingsRequest request =
   *       GetIapSettingsRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<IapSettings> future =
   *       identityAwareProxyAdminServiceClient.getIapSettingsCallable().futureCall(request);
   *   // Do something.
   *   IapSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIapSettingsRequest, IapSettings> getIapSettingsCallable() {
    return stub.getIapSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the IAP settings on a particular IAP protected resource. It replaces all fields unless
   * the `update_mask` is set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   UpdateIapSettingsRequest request =
   *       UpdateIapSettingsRequest.newBuilder()
   *           .setIapSettings(IapSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   IapSettings response = identityAwareProxyAdminServiceClient.updateIapSettings(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final IapSettings updateIapSettings(UpdateIapSettingsRequest request) {
    return updateIapSettingsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the IAP settings on a particular IAP protected resource. It replaces all fields unless
   * the `update_mask` is set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   UpdateIapSettingsRequest request =
   *       UpdateIapSettingsRequest.newBuilder()
   *           .setIapSettings(IapSettings.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<IapSettings> future =
   *       identityAwareProxyAdminServiceClient.updateIapSettingsCallable().futureCall(request);
   *   // Do something.
   *   IapSettings response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateIapSettingsRequest, IapSettings> updateIapSettingsCallable() {
    return stub.updateIapSettingsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing TunnelDestGroups. To group across all locations, use a `-` as the location
   * ID. For example: `/v1/projects/123/iap_tunnel/locations/-/destGroups`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   TunnelLocationName parent = TunnelLocationName.of("[PROJECT]", "[LOCATION]");
   *   for (TunnelDestGroup element :
   *       identityAwareProxyAdminServiceClient.listTunnelDestGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Google Cloud Project ID and location. In the following format:
   *     `projects/{project_number/id}/iap_tunnel/locations/{location}`. A `-` can be used for the
   *     location to group across all locations.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTunnelDestGroupsPagedResponse listTunnelDestGroups(TunnelLocationName parent) {
    ListTunnelDestGroupsRequest request =
        ListTunnelDestGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTunnelDestGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing TunnelDestGroups. To group across all locations, use a `-` as the location
   * ID. For example: `/v1/projects/123/iap_tunnel/locations/-/destGroups`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   String parent = TunnelLocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (TunnelDestGroup element :
   *       identityAwareProxyAdminServiceClient.listTunnelDestGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. Google Cloud Project ID and location. In the following format:
   *     `projects/{project_number/id}/iap_tunnel/locations/{location}`. A `-` can be used for the
   *     location to group across all locations.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTunnelDestGroupsPagedResponse listTunnelDestGroups(String parent) {
    ListTunnelDestGroupsRequest request =
        ListTunnelDestGroupsRequest.newBuilder().setParent(parent).build();
    return listTunnelDestGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing TunnelDestGroups. To group across all locations, use a `-` as the location
   * ID. For example: `/v1/projects/123/iap_tunnel/locations/-/destGroups`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   ListTunnelDestGroupsRequest request =
   *       ListTunnelDestGroupsRequest.newBuilder()
   *           .setParent(TunnelLocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (TunnelDestGroup element :
   *       identityAwareProxyAdminServiceClient.listTunnelDestGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTunnelDestGroupsPagedResponse listTunnelDestGroups(
      ListTunnelDestGroupsRequest request) {
    return listTunnelDestGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing TunnelDestGroups. To group across all locations, use a `-` as the location
   * ID. For example: `/v1/projects/123/iap_tunnel/locations/-/destGroups`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   ListTunnelDestGroupsRequest request =
   *       ListTunnelDestGroupsRequest.newBuilder()
   *           .setParent(TunnelLocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<TunnelDestGroup> future =
   *       identityAwareProxyAdminServiceClient
   *           .listTunnelDestGroupsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (TunnelDestGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTunnelDestGroupsRequest, ListTunnelDestGroupsPagedResponse>
      listTunnelDestGroupsPagedCallable() {
    return stub.listTunnelDestGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the existing TunnelDestGroups. To group across all locations, use a `-` as the location
   * ID. For example: `/v1/projects/123/iap_tunnel/locations/-/destGroups`
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   ListTunnelDestGroupsRequest request =
   *       ListTunnelDestGroupsRequest.newBuilder()
   *           .setParent(TunnelLocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListTunnelDestGroupsResponse response =
   *         identityAwareProxyAdminServiceClient.listTunnelDestGroupsCallable().call(request);
   *     for (TunnelDestGroup element : response.getTunnelDestGroupsList()) {
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
  public final UnaryCallable<ListTunnelDestGroupsRequest, ListTunnelDestGroupsResponse>
      listTunnelDestGroupsCallable() {
    return stub.listTunnelDestGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TunnelDestGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   TunnelLocationName parent = TunnelLocationName.of("[PROJECT]", "[LOCATION]");
   *   TunnelDestGroup tunnelDestGroup = TunnelDestGroup.newBuilder().build();
   *   String tunnelDestGroupId = "tunnelDestGroupId-1240473232";
   *   TunnelDestGroup response =
   *       identityAwareProxyAdminServiceClient.createTunnelDestGroup(
   *           parent, tunnelDestGroup, tunnelDestGroupId);
   * }
   * }</pre>
   *
   * @param parent Required. Google Cloud Project ID and location. In the following format:
   *     `projects/{project_number/id}/iap_tunnel/locations/{location}`.
   * @param tunnelDestGroup Required. The TunnelDestGroup to create.
   * @param tunnelDestGroupId Required. The ID to use for the TunnelDestGroup, which becomes the
   *     final component of the resource name.
   *     <p>This value must be 4-63 characters, and valid characters are `[a-z]-`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TunnelDestGroup createTunnelDestGroup(
      TunnelLocationName parent, TunnelDestGroup tunnelDestGroup, String tunnelDestGroupId) {
    CreateTunnelDestGroupRequest request =
        CreateTunnelDestGroupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTunnelDestGroup(tunnelDestGroup)
            .setTunnelDestGroupId(tunnelDestGroupId)
            .build();
    return createTunnelDestGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TunnelDestGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   String parent = TunnelLocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   TunnelDestGroup tunnelDestGroup = TunnelDestGroup.newBuilder().build();
   *   String tunnelDestGroupId = "tunnelDestGroupId-1240473232";
   *   TunnelDestGroup response =
   *       identityAwareProxyAdminServiceClient.createTunnelDestGroup(
   *           parent, tunnelDestGroup, tunnelDestGroupId);
   * }
   * }</pre>
   *
   * @param parent Required. Google Cloud Project ID and location. In the following format:
   *     `projects/{project_number/id}/iap_tunnel/locations/{location}`.
   * @param tunnelDestGroup Required. The TunnelDestGroup to create.
   * @param tunnelDestGroupId Required. The ID to use for the TunnelDestGroup, which becomes the
   *     final component of the resource name.
   *     <p>This value must be 4-63 characters, and valid characters are `[a-z]-`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TunnelDestGroup createTunnelDestGroup(
      String parent, TunnelDestGroup tunnelDestGroup, String tunnelDestGroupId) {
    CreateTunnelDestGroupRequest request =
        CreateTunnelDestGroupRequest.newBuilder()
            .setParent(parent)
            .setTunnelDestGroup(tunnelDestGroup)
            .setTunnelDestGroupId(tunnelDestGroupId)
            .build();
    return createTunnelDestGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TunnelDestGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   CreateTunnelDestGroupRequest request =
   *       CreateTunnelDestGroupRequest.newBuilder()
   *           .setParent(TunnelLocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTunnelDestGroup(TunnelDestGroup.newBuilder().build())
   *           .setTunnelDestGroupId("tunnelDestGroupId-1240473232")
   *           .build();
   *   TunnelDestGroup response =
   *       identityAwareProxyAdminServiceClient.createTunnelDestGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TunnelDestGroup createTunnelDestGroup(CreateTunnelDestGroupRequest request) {
    return createTunnelDestGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new TunnelDestGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   CreateTunnelDestGroupRequest request =
   *       CreateTunnelDestGroupRequest.newBuilder()
   *           .setParent(TunnelLocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setTunnelDestGroup(TunnelDestGroup.newBuilder().build())
   *           .setTunnelDestGroupId("tunnelDestGroupId-1240473232")
   *           .build();
   *   ApiFuture<TunnelDestGroup> future =
   *       identityAwareProxyAdminServiceClient.createTunnelDestGroupCallable().futureCall(request);
   *   // Do something.
   *   TunnelDestGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTunnelDestGroupRequest, TunnelDestGroup>
      createTunnelDestGroupCallable() {
    return stub.createTunnelDestGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an existing TunnelDestGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   TunnelDestGroupName name = TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]");
   *   TunnelDestGroup response = identityAwareProxyAdminServiceClient.getTunnelDestGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the TunnelDestGroup to be fetched. In the following format:
   *     `projects/{project_number/id}/iap_tunnel/locations/{location}/destGroups/{dest_group}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TunnelDestGroup getTunnelDestGroup(TunnelDestGroupName name) {
    GetTunnelDestGroupRequest request =
        GetTunnelDestGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getTunnelDestGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an existing TunnelDestGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   String name = TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString();
   *   TunnelDestGroup response = identityAwareProxyAdminServiceClient.getTunnelDestGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the TunnelDestGroup to be fetched. In the following format:
   *     `projects/{project_number/id}/iap_tunnel/locations/{location}/destGroups/{dest_group}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TunnelDestGroup getTunnelDestGroup(String name) {
    GetTunnelDestGroupRequest request =
        GetTunnelDestGroupRequest.newBuilder().setName(name).build();
    return getTunnelDestGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an existing TunnelDestGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   GetTunnelDestGroupRequest request =
   *       GetTunnelDestGroupRequest.newBuilder()
   *           .setName(TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
   *           .build();
   *   TunnelDestGroup response = identityAwareProxyAdminServiceClient.getTunnelDestGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TunnelDestGroup getTunnelDestGroup(GetTunnelDestGroupRequest request) {
    return getTunnelDestGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an existing TunnelDestGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   GetTunnelDestGroupRequest request =
   *       GetTunnelDestGroupRequest.newBuilder()
   *           .setName(TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
   *           .build();
   *   ApiFuture<TunnelDestGroup> future =
   *       identityAwareProxyAdminServiceClient.getTunnelDestGroupCallable().futureCall(request);
   *   // Do something.
   *   TunnelDestGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTunnelDestGroupRequest, TunnelDestGroup>
      getTunnelDestGroupCallable() {
    return stub.getTunnelDestGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TunnelDestGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   TunnelDestGroupName name = TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]");
   *   identityAwareProxyAdminServiceClient.deleteTunnelDestGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the TunnelDestGroup to delete. In the following format:
   *     `projects/{project_number/id}/iap_tunnel/locations/{location}/destGroups/{dest_group}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTunnelDestGroup(TunnelDestGroupName name) {
    DeleteTunnelDestGroupRequest request =
        DeleteTunnelDestGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteTunnelDestGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TunnelDestGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   String name = TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString();
   *   identityAwareProxyAdminServiceClient.deleteTunnelDestGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. Name of the TunnelDestGroup to delete. In the following format:
   *     `projects/{project_number/id}/iap_tunnel/locations/{location}/destGroups/{dest_group}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTunnelDestGroup(String name) {
    DeleteTunnelDestGroupRequest request =
        DeleteTunnelDestGroupRequest.newBuilder().setName(name).build();
    deleteTunnelDestGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TunnelDestGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   DeleteTunnelDestGroupRequest request =
   *       DeleteTunnelDestGroupRequest.newBuilder()
   *           .setName(TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
   *           .build();
   *   identityAwareProxyAdminServiceClient.deleteTunnelDestGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTunnelDestGroup(DeleteTunnelDestGroupRequest request) {
    deleteTunnelDestGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a TunnelDestGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   DeleteTunnelDestGroupRequest request =
   *       DeleteTunnelDestGroupRequest.newBuilder()
   *           .setName(TunnelDestGroupName.of("[PROJECT]", "[LOCATION]", "[DEST_GROUP]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       identityAwareProxyAdminServiceClient.deleteTunnelDestGroupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTunnelDestGroupRequest, Empty> deleteTunnelDestGroupCallable() {
    return stub.deleteTunnelDestGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a TunnelDestGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   TunnelDestGroup tunnelDestGroup = TunnelDestGroup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TunnelDestGroup response =
   *       identityAwareProxyAdminServiceClient.updateTunnelDestGroup(tunnelDestGroup, updateMask);
   * }
   * }</pre>
   *
   * @param tunnelDestGroup Required. The new values for the TunnelDestGroup.
   * @param updateMask A field mask that specifies which IAP settings to update. If omitted, then
   *     all of the settings are updated. See
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TunnelDestGroup updateTunnelDestGroup(
      TunnelDestGroup tunnelDestGroup, FieldMask updateMask) {
    UpdateTunnelDestGroupRequest request =
        UpdateTunnelDestGroupRequest.newBuilder()
            .setTunnelDestGroup(tunnelDestGroup)
            .setUpdateMask(updateMask)
            .build();
    return updateTunnelDestGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a TunnelDestGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   UpdateTunnelDestGroupRequest request =
   *       UpdateTunnelDestGroupRequest.newBuilder()
   *           .setTunnelDestGroup(TunnelDestGroup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   TunnelDestGroup response =
   *       identityAwareProxyAdminServiceClient.updateTunnelDestGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TunnelDestGroup updateTunnelDestGroup(UpdateTunnelDestGroupRequest request) {
    return updateTunnelDestGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a TunnelDestGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IdentityAwareProxyAdminServiceClient identityAwareProxyAdminServiceClient =
   *     IdentityAwareProxyAdminServiceClient.create()) {
   *   UpdateTunnelDestGroupRequest request =
   *       UpdateTunnelDestGroupRequest.newBuilder()
   *           .setTunnelDestGroup(TunnelDestGroup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<TunnelDestGroup> future =
   *       identityAwareProxyAdminServiceClient.updateTunnelDestGroupCallable().futureCall(request);
   *   // Do something.
   *   TunnelDestGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTunnelDestGroupRequest, TunnelDestGroup>
      updateTunnelDestGroupCallable() {
    return stub.updateTunnelDestGroupCallable();
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

  public static class ListTunnelDestGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListTunnelDestGroupsRequest,
          ListTunnelDestGroupsResponse,
          TunnelDestGroup,
          ListTunnelDestGroupsPage,
          ListTunnelDestGroupsFixedSizeCollection> {

    public static ApiFuture<ListTunnelDestGroupsPagedResponse> createAsync(
        PageContext<ListTunnelDestGroupsRequest, ListTunnelDestGroupsResponse, TunnelDestGroup>
            context,
        ApiFuture<ListTunnelDestGroupsResponse> futureResponse) {
      ApiFuture<ListTunnelDestGroupsPage> futurePage =
          ListTunnelDestGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTunnelDestGroupsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTunnelDestGroupsPagedResponse(ListTunnelDestGroupsPage page) {
      super(page, ListTunnelDestGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTunnelDestGroupsPage
      extends AbstractPage<
          ListTunnelDestGroupsRequest,
          ListTunnelDestGroupsResponse,
          TunnelDestGroup,
          ListTunnelDestGroupsPage> {

    private ListTunnelDestGroupsPage(
        PageContext<ListTunnelDestGroupsRequest, ListTunnelDestGroupsResponse, TunnelDestGroup>
            context,
        ListTunnelDestGroupsResponse response) {
      super(context, response);
    }

    private static ListTunnelDestGroupsPage createEmptyPage() {
      return new ListTunnelDestGroupsPage(null, null);
    }

    @Override
    protected ListTunnelDestGroupsPage createPage(
        PageContext<ListTunnelDestGroupsRequest, ListTunnelDestGroupsResponse, TunnelDestGroup>
            context,
        ListTunnelDestGroupsResponse response) {
      return new ListTunnelDestGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListTunnelDestGroupsPage> createPageAsync(
        PageContext<ListTunnelDestGroupsRequest, ListTunnelDestGroupsResponse, TunnelDestGroup>
            context,
        ApiFuture<ListTunnelDestGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTunnelDestGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTunnelDestGroupsRequest,
          ListTunnelDestGroupsResponse,
          TunnelDestGroup,
          ListTunnelDestGroupsPage,
          ListTunnelDestGroupsFixedSizeCollection> {

    private ListTunnelDestGroupsFixedSizeCollection(
        List<ListTunnelDestGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTunnelDestGroupsFixedSizeCollection createEmptyCollection() {
      return new ListTunnelDestGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTunnelDestGroupsFixedSizeCollection createCollection(
        List<ListTunnelDestGroupsPage> pages, int collectionSize) {
      return new ListTunnelDestGroupsFixedSizeCollection(pages, collectionSize);
    }
  }
}
