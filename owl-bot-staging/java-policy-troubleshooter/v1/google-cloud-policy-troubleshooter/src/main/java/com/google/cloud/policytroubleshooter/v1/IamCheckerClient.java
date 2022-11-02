/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.policytroubleshooter.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.policytroubleshooter.v1.stub.IamCheckerStub;
import com.google.cloud.policytroubleshooter.v1.stub.IamCheckerStubSettings;
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
 * try (IamCheckerClient iamCheckerClient = IamCheckerClient.create()) {
 *   TroubleshootIamPolicyRequest request =
 *       TroubleshootIamPolicyRequest.newBuilder()
 *           .setAccessTuple(Explanations.AccessTuple.newBuilder().build())
 *           .build();
 *   TroubleshootIamPolicyResponse response = iamCheckerClient.troubleshootIamPolicy(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the IamCheckerClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li>A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li>A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li>A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of IamCheckerSettings to
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
 * IamCheckerSettings iamCheckerSettings =
 *     IamCheckerSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * IamCheckerClient iamCheckerClient = IamCheckerClient.create(iamCheckerSettings);
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
 * IamCheckerSettings iamCheckerSettings =
 *     IamCheckerSettings.newBuilder().setEndpoint(myEndpoint).build();
 * IamCheckerClient iamCheckerClient = IamCheckerClient.create(iamCheckerSettings);
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
 * IamCheckerSettings iamCheckerSettings = IamCheckerSettings.newHttpJsonBuilder().build();
 * IamCheckerClient iamCheckerClient = IamCheckerClient.create(iamCheckerSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class IamCheckerClient implements BackgroundResource {
  private final IamCheckerSettings settings;
  private final IamCheckerStub stub;

  /** Constructs an instance of IamCheckerClient with default settings. */
  public static final IamCheckerClient create() throws IOException {
    return create(IamCheckerSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of IamCheckerClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final IamCheckerClient create(IamCheckerSettings settings) throws IOException {
    return new IamCheckerClient(settings);
  }

  /**
   * Constructs an instance of IamCheckerClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(IamCheckerSettings).
   */
  public static final IamCheckerClient create(IamCheckerStub stub) {
    return new IamCheckerClient(stub);
  }

  /**
   * Constructs an instance of IamCheckerClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected IamCheckerClient(IamCheckerSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((IamCheckerStubSettings) settings.getStubSettings()).createStub();
  }

  protected IamCheckerClient(IamCheckerStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final IamCheckerSettings getSettings() {
    return settings;
  }

  public IamCheckerStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Checks whether a member has a specific permission for a specific resource, and explains why the
   * member does or does not have that permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IamCheckerClient iamCheckerClient = IamCheckerClient.create()) {
   *   TroubleshootIamPolicyRequest request =
   *       TroubleshootIamPolicyRequest.newBuilder()
   *           .setAccessTuple(Explanations.AccessTuple.newBuilder().build())
   *           .build();
   *   TroubleshootIamPolicyResponse response = iamCheckerClient.troubleshootIamPolicy(request);
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
   * Checks whether a member has a specific permission for a specific resource, and explains why the
   * member does or does not have that permission.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (IamCheckerClient iamCheckerClient = IamCheckerClient.create()) {
   *   TroubleshootIamPolicyRequest request =
   *       TroubleshootIamPolicyRequest.newBuilder()
   *           .setAccessTuple(Explanations.AccessTuple.newBuilder().build())
   *           .build();
   *   ApiFuture<TroubleshootIamPolicyResponse> future =
   *       iamCheckerClient.troubleshootIamPolicyCallable().futureCall(request);
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
