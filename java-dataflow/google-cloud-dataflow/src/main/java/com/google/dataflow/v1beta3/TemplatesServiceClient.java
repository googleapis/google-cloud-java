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

package com.google.dataflow.v1beta3;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.dataflow.v1beta3.stub.TemplatesServiceStub;
import com.google.dataflow.v1beta3.stub.TemplatesServiceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides a method to create Cloud Dataflow jobs from templates.
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
 * try (TemplatesServiceClient templatesServiceClient = TemplatesServiceClient.create()) {
 *   CreateJobFromTemplateRequest request =
 *       CreateJobFromTemplateRequest.newBuilder()
 *           .setProjectId("projectId-894832108")
 *           .setJobName("jobName-1438096408")
 *           .putAllParameters(new HashMap<String, String>())
 *           .setEnvironment(RuntimeEnvironment.newBuilder().build())
 *           .setLocation("location1901043637")
 *           .build();
 *   Job response = templatesServiceClient.createJobFromTemplate(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TemplatesServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
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
 * <p>This class can be customized by passing in a custom instance of TemplatesServiceSettings to
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
 * TemplatesServiceSettings templatesServiceSettings =
 *     TemplatesServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TemplatesServiceClient templatesServiceClient =
 *     TemplatesServiceClient.create(templatesServiceSettings);
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
 * TemplatesServiceSettings templatesServiceSettings =
 *     TemplatesServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TemplatesServiceClient templatesServiceClient =
 *     TemplatesServiceClient.create(templatesServiceSettings);
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
 * TemplatesServiceSettings templatesServiceSettings =
 *     TemplatesServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             TemplatesServiceSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * TemplatesServiceClient templatesServiceClient =
 *     TemplatesServiceClient.create(templatesServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class TemplatesServiceClient implements BackgroundResource {
  private final TemplatesServiceSettings settings;
  private final TemplatesServiceStub stub;

  /** Constructs an instance of TemplatesServiceClient with default settings. */
  public static final TemplatesServiceClient create() throws IOException {
    return create(TemplatesServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TemplatesServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TemplatesServiceClient create(TemplatesServiceSettings settings)
      throws IOException {
    return new TemplatesServiceClient(settings);
  }

  /**
   * Constructs an instance of TemplatesServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(TemplatesServiceSettings).
   */
  public static final TemplatesServiceClient create(TemplatesServiceStub stub) {
    return new TemplatesServiceClient(stub);
  }

  /**
   * Constructs an instance of TemplatesServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TemplatesServiceClient(TemplatesServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TemplatesServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected TemplatesServiceClient(TemplatesServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TemplatesServiceSettings getSettings() {
    return settings;
  }

  public TemplatesServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Cloud Dataflow job from a template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TemplatesServiceClient templatesServiceClient = TemplatesServiceClient.create()) {
   *   CreateJobFromTemplateRequest request =
   *       CreateJobFromTemplateRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setJobName("jobName-1438096408")
   *           .putAllParameters(new HashMap<String, String>())
   *           .setEnvironment(RuntimeEnvironment.newBuilder().build())
   *           .setLocation("location1901043637")
   *           .build();
   *   Job response = templatesServiceClient.createJobFromTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Job createJobFromTemplate(CreateJobFromTemplateRequest request) {
    return createJobFromTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a Cloud Dataflow job from a template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TemplatesServiceClient templatesServiceClient = TemplatesServiceClient.create()) {
   *   CreateJobFromTemplateRequest request =
   *       CreateJobFromTemplateRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setJobName("jobName-1438096408")
   *           .putAllParameters(new HashMap<String, String>())
   *           .setEnvironment(RuntimeEnvironment.newBuilder().build())
   *           .setLocation("location1901043637")
   *           .build();
   *   ApiFuture<Job> future =
   *       templatesServiceClient.createJobFromTemplateCallable().futureCall(request);
   *   // Do something.
   *   Job response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateJobFromTemplateRequest, Job> createJobFromTemplateCallable() {
    return stub.createJobFromTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Launch a template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TemplatesServiceClient templatesServiceClient = TemplatesServiceClient.create()) {
   *   LaunchTemplateRequest request =
   *       LaunchTemplateRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setValidateOnly(true)
   *           .setLaunchParameters(LaunchTemplateParameters.newBuilder().build())
   *           .setLocation("location1901043637")
   *           .build();
   *   LaunchTemplateResponse response = templatesServiceClient.launchTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LaunchTemplateResponse launchTemplate(LaunchTemplateRequest request) {
    return launchTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Launch a template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TemplatesServiceClient templatesServiceClient = TemplatesServiceClient.create()) {
   *   LaunchTemplateRequest request =
   *       LaunchTemplateRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setValidateOnly(true)
   *           .setLaunchParameters(LaunchTemplateParameters.newBuilder().build())
   *           .setLocation("location1901043637")
   *           .build();
   *   ApiFuture<LaunchTemplateResponse> future =
   *       templatesServiceClient.launchTemplateCallable().futureCall(request);
   *   // Do something.
   *   LaunchTemplateResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<LaunchTemplateRequest, LaunchTemplateResponse>
      launchTemplateCallable() {
    return stub.launchTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the template associated with a template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TemplatesServiceClient templatesServiceClient = TemplatesServiceClient.create()) {
   *   GetTemplateRequest request =
   *       GetTemplateRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setLocation("location1901043637")
   *           .build();
   *   GetTemplateResponse response = templatesServiceClient.getTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetTemplateResponse getTemplate(GetTemplateRequest request) {
    return getTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the template associated with a template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TemplatesServiceClient templatesServiceClient = TemplatesServiceClient.create()) {
   *   GetTemplateRequest request =
   *       GetTemplateRequest.newBuilder()
   *           .setProjectId("projectId-894832108")
   *           .setLocation("location1901043637")
   *           .build();
   *   ApiFuture<GetTemplateResponse> future =
   *       templatesServiceClient.getTemplateCallable().futureCall(request);
   *   // Do something.
   *   GetTemplateResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTemplateRequest, GetTemplateResponse> getTemplateCallable() {
    return stub.getTemplateCallable();
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
