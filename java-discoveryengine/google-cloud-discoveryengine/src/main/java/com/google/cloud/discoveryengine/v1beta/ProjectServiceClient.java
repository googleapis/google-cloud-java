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

package com.google.cloud.discoveryengine.v1beta;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1beta.stub.ProjectServiceStub;
import com.google.cloud.discoveryengine.v1beta.stub.ProjectServiceStubSettings;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for operations on the
 * [Project][google.cloud.discoveryengine.v1beta.Project].
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
 * try (ProjectServiceClient projectServiceClient = ProjectServiceClient.create()) {
 *   ProjectName name = ProjectName.of("[PROJECT]");
 *   Project response = projectServiceClient.provisionProjectAsync(name).get();
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ProjectServiceClient object to clean up resources such
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
 *      <td><p> ProvisionProject</td>
 *      <td><p> Provisions the project resource. During the process, related systems will get prepared and initialized.
 * <p>  Caller must read the [Terms for data use](https://cloud.google.com/retail/data-use-terms), and optionally specify in request to provide consent to that service terms.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> provisionProjectAsync(ProvisionProjectRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> provisionProjectAsync(ProjectName name)
 *           <li><p> provisionProjectAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> provisionProjectOperationCallable()
 *           <li><p> provisionProjectCallable()
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
 * <p>This class can be customized by passing in a custom instance of ProjectServiceSettings to
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
 * ProjectServiceSettings projectServiceSettings =
 *     ProjectServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ProjectServiceClient projectServiceClient = ProjectServiceClient.create(projectServiceSettings);
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
 * ProjectServiceSettings projectServiceSettings =
 *     ProjectServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ProjectServiceClient projectServiceClient = ProjectServiceClient.create(projectServiceSettings);
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
 * ProjectServiceSettings projectServiceSettings =
 *     ProjectServiceSettings.newHttpJsonBuilder().build();
 * ProjectServiceClient projectServiceClient = ProjectServiceClient.create(projectServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ProjectServiceClient implements BackgroundResource {
  private final ProjectServiceSettings settings;
  private final ProjectServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of ProjectServiceClient with default settings. */
  public static final ProjectServiceClient create() throws IOException {
    return create(ProjectServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ProjectServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ProjectServiceClient create(ProjectServiceSettings settings)
      throws IOException {
    return new ProjectServiceClient(settings);
  }

  /**
   * Constructs an instance of ProjectServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ProjectServiceSettings).
   */
  public static final ProjectServiceClient create(ProjectServiceStub stub) {
    return new ProjectServiceClient(stub);
  }

  /**
   * Constructs an instance of ProjectServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ProjectServiceClient(ProjectServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ProjectServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ProjectServiceClient(ProjectServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ProjectServiceSettings getSettings() {
    return settings;
  }

  public ProjectServiceStub getStub() {
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
   * Provisions the project resource. During the process, related systems will get prepared and
   * initialized.
   *
   * <p>Caller must read the [Terms for data use](https://cloud.google.com/retail/data-use-terms),
   * and optionally specify in request to provide consent to that service terms.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectServiceClient projectServiceClient = ProjectServiceClient.create()) {
   *   ProjectName name = ProjectName.of("[PROJECT]");
   *   Project response = projectServiceClient.provisionProjectAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of a
   *     [Project][google.cloud.discoveryengine.v1beta.Project], such as
   *     `projects/{project_id_or_number}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Project, ProvisionProjectMetadata> provisionProjectAsync(
      ProjectName name) {
    ProvisionProjectRequest request =
        ProvisionProjectRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return provisionProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provisions the project resource. During the process, related systems will get prepared and
   * initialized.
   *
   * <p>Caller must read the [Terms for data use](https://cloud.google.com/retail/data-use-terms),
   * and optionally specify in request to provide consent to that service terms.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectServiceClient projectServiceClient = ProjectServiceClient.create()) {
   *   String name = ProjectName.of("[PROJECT]").toString();
   *   Project response = projectServiceClient.provisionProjectAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of a
   *     [Project][google.cloud.discoveryengine.v1beta.Project], such as
   *     `projects/{project_id_or_number}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Project, ProvisionProjectMetadata> provisionProjectAsync(
      String name) {
    ProvisionProjectRequest request = ProvisionProjectRequest.newBuilder().setName(name).build();
    return provisionProjectAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provisions the project resource. During the process, related systems will get prepared and
   * initialized.
   *
   * <p>Caller must read the [Terms for data use](https://cloud.google.com/retail/data-use-terms),
   * and optionally specify in request to provide consent to that service terms.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectServiceClient projectServiceClient = ProjectServiceClient.create()) {
   *   ProvisionProjectRequest request =
   *       ProvisionProjectRequest.newBuilder()
   *           .setName(ProjectName.of("[PROJECT]").toString())
   *           .setAcceptDataUseTerms(true)
   *           .setDataUseTermsVersion("dataUseTermsVersion-1913570450")
   *           .build();
   *   Project response = projectServiceClient.provisionProjectAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Project, ProvisionProjectMetadata> provisionProjectAsync(
      ProvisionProjectRequest request) {
    return provisionProjectOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provisions the project resource. During the process, related systems will get prepared and
   * initialized.
   *
   * <p>Caller must read the [Terms for data use](https://cloud.google.com/retail/data-use-terms),
   * and optionally specify in request to provide consent to that service terms.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectServiceClient projectServiceClient = ProjectServiceClient.create()) {
   *   ProvisionProjectRequest request =
   *       ProvisionProjectRequest.newBuilder()
   *           .setName(ProjectName.of("[PROJECT]").toString())
   *           .setAcceptDataUseTerms(true)
   *           .setDataUseTermsVersion("dataUseTermsVersion-1913570450")
   *           .build();
   *   OperationFuture<Project, ProvisionProjectMetadata> future =
   *       projectServiceClient.provisionProjectOperationCallable().futureCall(request);
   *   // Do something.
   *   Project response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<ProvisionProjectRequest, Project, ProvisionProjectMetadata>
      provisionProjectOperationCallable() {
    return stub.provisionProjectOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Provisions the project resource. During the process, related systems will get prepared and
   * initialized.
   *
   * <p>Caller must read the [Terms for data use](https://cloud.google.com/retail/data-use-terms),
   * and optionally specify in request to provide consent to that service terms.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectServiceClient projectServiceClient = ProjectServiceClient.create()) {
   *   ProvisionProjectRequest request =
   *       ProvisionProjectRequest.newBuilder()
   *           .setName(ProjectName.of("[PROJECT]").toString())
   *           .setAcceptDataUseTerms(true)
   *           .setDataUseTermsVersion("dataUseTermsVersion-1913570450")
   *           .build();
   *   ApiFuture<Operation> future =
   *       projectServiceClient.provisionProjectCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ProvisionProjectRequest, Operation> provisionProjectCallable() {
    return stub.provisionProjectCallable();
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
