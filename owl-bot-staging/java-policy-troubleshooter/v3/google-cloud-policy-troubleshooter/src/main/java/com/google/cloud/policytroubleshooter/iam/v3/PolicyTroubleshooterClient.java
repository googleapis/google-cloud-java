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

package com.google.cloud.policytroubleshooter.iam.v3;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.policytroubleshooter.iam.v3.stub.PolicyTroubleshooterStub;
import com.google.cloud.policytroubleshooter.iam.v3.stub.PolicyTroubleshooterStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: IAM Policy Troubleshooter service.
 *
 * <p>This service helps you troubleshoot access issues for Google Cloud resources.
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
 * try (PolicyTroubleshooterClient policyTroubleshooterClient =
 *     PolicyTroubleshooterClient.create()) {
 *   TroubleshootIamPolicyRequest request =
 *       TroubleshootIamPolicyRequest.newBuilder()
 *           .setAccessTuple(AccessTuple.newBuilder().build())
 *           .build();
 *   TroubleshootIamPolicyResponse response =
 *       policyTroubleshooterClient.troubleshootIamPolicy(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PolicyTroubleshooterClient object to clean up
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
 *      <td><p> TroubleshootIamPolicy</td>
 *      <td><p> Checks whether a principal has a specific permission for a specific resource, and explains why the principal does or doesn't have that permission.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> troubleshootIamPolicy(TroubleshootIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> troubleshootIamPolicyCallable()
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
 * <p>This class can be customized by passing in a custom instance of PolicyTroubleshooterSettings
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
 * PolicyTroubleshooterSettings policyTroubleshooterSettings =
 *     PolicyTroubleshooterSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PolicyTroubleshooterClient policyTroubleshooterClient =
 *     PolicyTroubleshooterClient.create(policyTroubleshooterSettings);
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
 * PolicyTroubleshooterSettings policyTroubleshooterSettings =
 *     PolicyTroubleshooterSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PolicyTroubleshooterClient policyTroubleshooterClient =
 *     PolicyTroubleshooterClient.create(policyTroubleshooterSettings);
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
 * PolicyTroubleshooterSettings policyTroubleshooterSettings =
 *     PolicyTroubleshooterSettings.newHttpJsonBuilder().build();
 * PolicyTroubleshooterClient policyTroubleshooterClient =
 *     PolicyTroubleshooterClient.create(policyTroubleshooterSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class PolicyTroubleshooterClient implements BackgroundResource {
  private final PolicyTroubleshooterSettings settings;
  private final PolicyTroubleshooterStub stub;

  /** Constructs an instance of PolicyTroubleshooterClient with default settings. */
  public static final PolicyTroubleshooterClient create() throws IOException {
    return create(PolicyTroubleshooterSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PolicyTroubleshooterClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PolicyTroubleshooterClient create(PolicyTroubleshooterSettings settings)
      throws IOException {
    return new PolicyTroubleshooterClient(settings);
  }

  /**
   * Constructs an instance of PolicyTroubleshooterClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(PolicyTroubleshooterSettings).
   */
  public static final PolicyTroubleshooterClient create(PolicyTroubleshooterStub stub) {
    return new PolicyTroubleshooterClient(stub);
  }

  /**
   * Constructs an instance of PolicyTroubleshooterClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected PolicyTroubleshooterClient(PolicyTroubleshooterSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PolicyTroubleshooterStubSettings) settings.getStubSettings()).createStub();
  }

  protected PolicyTroubleshooterClient(PolicyTroubleshooterStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PolicyTroubleshooterSettings getSettings() {
    return settings;
  }

  public PolicyTroubleshooterStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Checks whether a principal has a specific permission for a specific resource, and explains why
   * the principal does or doesn't have that permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTroubleshooterClient policyTroubleshooterClient =
   *     PolicyTroubleshooterClient.create()) {
   *   TroubleshootIamPolicyRequest request =
   *       TroubleshootIamPolicyRequest.newBuilder()
   *           .setAccessTuple(AccessTuple.newBuilder().build())
   *           .build();
   *   TroubleshootIamPolicyResponse response =
   *       policyTroubleshooterClient.troubleshootIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TroubleshootIamPolicyResponse troubleshootIamPolicy(
      TroubleshootIamPolicyRequest request) {
    return troubleshootIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Checks whether a principal has a specific permission for a specific resource, and explains why
   * the principal does or doesn't have that permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PolicyTroubleshooterClient policyTroubleshooterClient =
   *     PolicyTroubleshooterClient.create()) {
   *   TroubleshootIamPolicyRequest request =
   *       TroubleshootIamPolicyRequest.newBuilder()
   *           .setAccessTuple(AccessTuple.newBuilder().build())
   *           .build();
   *   ApiFuture<TroubleshootIamPolicyResponse> future =
   *       policyTroubleshooterClient.troubleshootIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   TroubleshootIamPolicyResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TroubleshootIamPolicyRequest, TroubleshootIamPolicyResponse>
      troubleshootIamPolicyCallable() {
    return stub.troubleshootIamPolicyCallable();
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
