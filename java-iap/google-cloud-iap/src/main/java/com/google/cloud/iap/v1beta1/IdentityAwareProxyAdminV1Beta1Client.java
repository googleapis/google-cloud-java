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

package com.google.cloud.iap.v1beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.iap.v1beta1.stub.IdentityAwareProxyAdminV1Beta1Stub;
import com.google.cloud.iap.v1beta1.stub.IdentityAwareProxyAdminV1Beta1StubSettings;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import java.io.IOException;
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
 * try (IdentityAwareProxyAdminV1Beta1Client identityAwareProxyAdminV1Beta1Client =
 *     IdentityAwareProxyAdminV1Beta1Client.create()) {
 *   SetIamPolicyRequest request =
 *       SetIamPolicyRequest.newBuilder()
 *           .setResource("SetIamPolicyRequest1223629066".toString())
 *           .setPolicy(Policy.newBuilder().build())
 *           .setUpdateMask(FieldMask.newBuilder().build())
 *           .build();
 *   Policy response = identityAwareProxyAdminV1Beta1Client.setIamPolicy(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the IdentityAwareProxyAdminV1Beta1Client object to clean
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
 *      <td><p> Returns permissions that a caller has on the Identity-Aware Proxy protected resource. If the resource does not exist or the caller does not have Identity-Aware Proxy permissions a [google.rpc.Code.PERMISSION_DENIED] will be returned. More information about managing access via IAP can be found at: https://cloud.google.com/iap/docs/managing-access#managing_access_via_the_api</td>
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
 * IdentityAwareProxyAdminV1Beta1Settings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * IdentityAwareProxyAdminV1Beta1Settings identityAwareProxyAdminV1Beta1Settings =
 *     IdentityAwareProxyAdminV1Beta1Settings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * IdentityAwareProxyAdminV1Beta1Client identityAwareProxyAdminV1Beta1Client =
 *     IdentityAwareProxyAdminV1Beta1Client.create(identityAwareProxyAdminV1Beta1Settings);
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
 * IdentityAwareProxyAdminV1Beta1Settings identityAwareProxyAdminV1Beta1Settings =
 *     IdentityAwareProxyAdminV1Beta1Settings.newBuilder().setEndpoint(myEndpoint).build();
 * IdentityAwareProxyAdminV1Beta1Client identityAwareProxyAdminV1Beta1Client =
 *     IdentityAwareProxyAdminV1Beta1Client.create(identityAwareProxyAdminV1Beta1Settings);
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
 * IdentityAwareProxyAdminV1Beta1Settings identityAwareProxyAdminV1Beta1Settings =
 *     IdentityAwareProxyAdminV1Beta1Settings.newHttpJsonBuilder().build();
 * IdentityAwareProxyAdminV1Beta1Client identityAwareProxyAdminV1Beta1Client =
 *     IdentityAwareProxyAdminV1Beta1Client.create(identityAwareProxyAdminV1Beta1Settings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class IdentityAwareProxyAdminV1Beta1Client implements BackgroundResource {
  private final IdentityAwareProxyAdminV1Beta1Settings settings;
  private final IdentityAwareProxyAdminV1Beta1Stub stub;

  /** Constructs an instance of IdentityAwareProxyAdminV1Beta1Client with default settings. */
  public static final IdentityAwareProxyAdminV1Beta1Client create() throws IOException {
    return create(IdentityAwareProxyAdminV1Beta1Settings.newBuilder().build());
  }

  /**
   * Constructs an instance of IdentityAwareProxyAdminV1Beta1Client, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final IdentityAwareProxyAdminV1Beta1Client create(
      IdentityAwareProxyAdminV1Beta1Settings settings) throws IOException {
    return new IdentityAwareProxyAdminV1Beta1Client(settings);
  }

  /**
   * Constructs an instance of IdentityAwareProxyAdminV1Beta1Client, using the given stub for making
   * calls. This is for advanced usage - prefer using
   * create(IdentityAwareProxyAdminV1Beta1Settings).
   */
  public static final IdentityAwareProxyAdminV1Beta1Client create(
      IdentityAwareProxyAdminV1Beta1Stub stub) {
    return new IdentityAwareProxyAdminV1Beta1Client(stub);
  }

  /**
   * Constructs an instance of IdentityAwareProxyAdminV1Beta1Client, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected IdentityAwareProxyAdminV1Beta1Client(IdentityAwareProxyAdminV1Beta1Settings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((IdentityAwareProxyAdminV1Beta1StubSettings) settings.getStubSettings()).createStub();
  }

  protected IdentityAwareProxyAdminV1Beta1Client(IdentityAwareProxyAdminV1Beta1Stub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final IdentityAwareProxyAdminV1Beta1Settings getSettings() {
    return settings;
  }

  public IdentityAwareProxyAdminV1Beta1Stub getStub() {
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
   * try (IdentityAwareProxyAdminV1Beta1Client identityAwareProxyAdminV1Beta1Client =
   *     IdentityAwareProxyAdminV1Beta1Client.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource("SetIamPolicyRequest1223629066".toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = identityAwareProxyAdminV1Beta1Client.setIamPolicy(request);
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
   * try (IdentityAwareProxyAdminV1Beta1Client identityAwareProxyAdminV1Beta1Client =
   *     IdentityAwareProxyAdminV1Beta1Client.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource("SetIamPolicyRequest1223629066".toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       identityAwareProxyAdminV1Beta1Client.setIamPolicyCallable().futureCall(request);
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
   * try (IdentityAwareProxyAdminV1Beta1Client identityAwareProxyAdminV1Beta1Client =
   *     IdentityAwareProxyAdminV1Beta1Client.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource("GetIamPolicyRequest-1527610370".toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = identityAwareProxyAdminV1Beta1Client.getIamPolicy(request);
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
   * try (IdentityAwareProxyAdminV1Beta1Client identityAwareProxyAdminV1Beta1Client =
   *     IdentityAwareProxyAdminV1Beta1Client.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource("GetIamPolicyRequest-1527610370".toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future =
   *       identityAwareProxyAdminV1Beta1Client.getIamPolicyCallable().futureCall(request);
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
   * Returns permissions that a caller has on the Identity-Aware Proxy protected resource. If the
   * resource does not exist or the caller does not have Identity-Aware Proxy permissions a
   * [google.rpc.Code.PERMISSION_DENIED] will be returned. More information about managing access
   * via IAP can be found at:
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
   * try (IdentityAwareProxyAdminV1Beta1Client identityAwareProxyAdminV1Beta1Client =
   *     IdentityAwareProxyAdminV1Beta1Client.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource("TestIamPermissionsRequest942398222".toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response =
   *       identityAwareProxyAdminV1Beta1Client.testIamPermissions(request);
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
   * Returns permissions that a caller has on the Identity-Aware Proxy protected resource. If the
   * resource does not exist or the caller does not have Identity-Aware Proxy permissions a
   * [google.rpc.Code.PERMISSION_DENIED] will be returned. More information about managing access
   * via IAP can be found at:
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
   * try (IdentityAwareProxyAdminV1Beta1Client identityAwareProxyAdminV1Beta1Client =
   *     IdentityAwareProxyAdminV1Beta1Client.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource("TestIamPermissionsRequest942398222".toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       identityAwareProxyAdminV1Beta1Client.testIamPermissionsCallable().futureCall(request);
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
}
