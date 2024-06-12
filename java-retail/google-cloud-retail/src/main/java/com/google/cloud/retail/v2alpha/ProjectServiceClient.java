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

package com.google.cloud.retail.v2alpha;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.retail.v2alpha.stub.ProjectServiceStub;
import com.google.cloud.retail.v2alpha.stub.ProjectServiceStubSettings;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for settings at Project level.
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
 *   RetailProjectName name = RetailProjectName.of("[PROJECT]");
 *   Project response = projectServiceClient.getProject(name);
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
 *      <td><p> GetProject</td>
 *      <td><p> Gets the project.
 * <p>  Throws `NOT_FOUND` if the project wasn't initialized for the Retail API service.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getProject(GetProjectRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getProject(RetailProjectName name)
 *           <li><p> getProject(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getProjectCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AcceptTerms</td>
 *      <td><p> Accepts service terms for this project. By making requests to this API, you agree to the terms of service linked below. https://cloud.google.com/retail/data-use-terms</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> acceptTerms(AcceptTermsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> acceptTerms(RetailProjectName project)
 *           <li><p> acceptTerms(String project)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> acceptTermsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> EnrollSolution</td>
 *      <td><p> The method enrolls a solution of type [Retail Search][google.cloud.retail.v2alpha.SolutionType.SOLUTION_TYPE_SEARCH] into a project.
 * <p>  The [Recommendations AI solution type][google.cloud.retail.v2alpha.SolutionType.SOLUTION_TYPE_RECOMMENDATION] is enrolled by default when your project enables Retail API, so you don't need to call the enrollSolution method for recommendations.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> enrollSolutionAsync(EnrollSolutionRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> enrollSolutionOperationCallable()
 *           <li><p> enrollSolutionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListEnrolledSolutions</td>
 *      <td><p> Lists all the retail API solutions the project has enrolled.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listEnrolledSolutions(ListEnrolledSolutionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listEnrolledSolutions(ProjectName parent)
 *           <li><p> listEnrolledSolutions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listEnrolledSolutionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetLoggingConfig</td>
 *      <td><p> Gets the [LoggingConfig][google.cloud.retail.v2alpha.LoggingConfig] of the requested project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLoggingConfig(GetLoggingConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLoggingConfig(LoggingConfigName name)
 *           <li><p> getLoggingConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLoggingConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateLoggingConfig</td>
 *      <td><p> Updates the [LoggingConfig][google.cloud.retail.v2alpha.LoggingConfig] of the requested project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateLoggingConfig(UpdateLoggingConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateLoggingConfig(LoggingConfig loggingConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateLoggingConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAlertConfig</td>
 *      <td><p> Get the [AlertConfig][google.cloud.retail.v2alpha.AlertConfig] of the requested project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAlertConfig(GetAlertConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAlertConfig(AlertConfigName name)
 *           <li><p> getAlertConfig(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAlertConfigCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateAlertConfig</td>
 *      <td><p> Update the alert config of the requested project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAlertConfig(UpdateAlertConfigRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateAlertConfig(AlertConfig alertConfig, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateAlertConfigCallable()
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
   * Gets the project.
   *
   * <p>Throws `NOT_FOUND` if the project wasn't initialized for the Retail API service.
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
   *   RetailProjectName name = RetailProjectName.of("[PROJECT]");
   *   Project response = projectServiceClient.getProject(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of the project. Format:
   *     `projects/{project_number_or_id}/retailProject`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Project getProject(RetailProjectName name) {
    GetProjectRequest request =
        GetProjectRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the project.
   *
   * <p>Throws `NOT_FOUND` if the project wasn't initialized for the Retail API service.
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
   *   String name = RetailProjectName.of("[PROJECT]").toString();
   *   Project response = projectServiceClient.getProject(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of the project. Format:
   *     `projects/{project_number_or_id}/retailProject`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Project getProject(String name) {
    GetProjectRequest request = GetProjectRequest.newBuilder().setName(name).build();
    return getProject(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the project.
   *
   * <p>Throws `NOT_FOUND` if the project wasn't initialized for the Retail API service.
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
   *   GetProjectRequest request =
   *       GetProjectRequest.newBuilder()
   *           .setName(RetailProjectName.of("[PROJECT]").toString())
   *           .build();
   *   Project response = projectServiceClient.getProject(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Project getProject(GetProjectRequest request) {
    return getProjectCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the project.
   *
   * <p>Throws `NOT_FOUND` if the project wasn't initialized for the Retail API service.
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
   *   GetProjectRequest request =
   *       GetProjectRequest.newBuilder()
   *           .setName(RetailProjectName.of("[PROJECT]").toString())
   *           .build();
   *   ApiFuture<Project> future = projectServiceClient.getProjectCallable().futureCall(request);
   *   // Do something.
   *   Project response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProjectRequest, Project> getProjectCallable() {
    return stub.getProjectCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Accepts service terms for this project. By making requests to this API, you agree to the terms
   * of service linked below. https://cloud.google.com/retail/data-use-terms
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
   *   RetailProjectName project = RetailProjectName.of("[PROJECT]");
   *   Project response = projectServiceClient.acceptTerms(project);
   * }
   * }</pre>
   *
   * @param project Required. Full resource name of the project. Format:
   *     `projects/{project_number_or_id}/retailProject`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Project acceptTerms(RetailProjectName project) {
    AcceptTermsRequest request =
        AcceptTermsRequest.newBuilder()
            .setProject(project == null ? null : project.toString())
            .build();
    return acceptTerms(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Accepts service terms for this project. By making requests to this API, you agree to the terms
   * of service linked below. https://cloud.google.com/retail/data-use-terms
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
   *   String project = RetailProjectName.of("[PROJECT]").toString();
   *   Project response = projectServiceClient.acceptTerms(project);
   * }
   * }</pre>
   *
   * @param project Required. Full resource name of the project. Format:
   *     `projects/{project_number_or_id}/retailProject`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Project acceptTerms(String project) {
    AcceptTermsRequest request = AcceptTermsRequest.newBuilder().setProject(project).build();
    return acceptTerms(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Accepts service terms for this project. By making requests to this API, you agree to the terms
   * of service linked below. https://cloud.google.com/retail/data-use-terms
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
   *   AcceptTermsRequest request =
   *       AcceptTermsRequest.newBuilder()
   *           .setProject(RetailProjectName.of("[PROJECT]").toString())
   *           .build();
   *   Project response = projectServiceClient.acceptTerms(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Project acceptTerms(AcceptTermsRequest request) {
    return acceptTermsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Accepts service terms for this project. By making requests to this API, you agree to the terms
   * of service linked below. https://cloud.google.com/retail/data-use-terms
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
   *   AcceptTermsRequest request =
   *       AcceptTermsRequest.newBuilder()
   *           .setProject(RetailProjectName.of("[PROJECT]").toString())
   *           .build();
   *   ApiFuture<Project> future = projectServiceClient.acceptTermsCallable().futureCall(request);
   *   // Do something.
   *   Project response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AcceptTermsRequest, Project> acceptTermsCallable() {
    return stub.acceptTermsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * The method enrolls a solution of type [Retail
   * Search][google.cloud.retail.v2alpha.SolutionType.SOLUTION_TYPE_SEARCH] into a project.
   *
   * <p>The [Recommendations AI solution
   * type][google.cloud.retail.v2alpha.SolutionType.SOLUTION_TYPE_RECOMMENDATION] is enrolled by
   * default when your project enables Retail API, so you don't need to call the enrollSolution
   * method for recommendations.
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
   *   EnrollSolutionRequest request =
   *       EnrollSolutionRequest.newBuilder()
   *           .setProject(ProjectName.of("[PROJECT]").toString())
   *           .setSolution(SolutionType.forNumber(0))
   *           .build();
   *   EnrollSolutionResponse response = projectServiceClient.enrollSolutionAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<EnrollSolutionResponse, EnrollSolutionMetadata> enrollSolutionAsync(
      EnrollSolutionRequest request) {
    return enrollSolutionOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * The method enrolls a solution of type [Retail
   * Search][google.cloud.retail.v2alpha.SolutionType.SOLUTION_TYPE_SEARCH] into a project.
   *
   * <p>The [Recommendations AI solution
   * type][google.cloud.retail.v2alpha.SolutionType.SOLUTION_TYPE_RECOMMENDATION] is enrolled by
   * default when your project enables Retail API, so you don't need to call the enrollSolution
   * method for recommendations.
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
   *   EnrollSolutionRequest request =
   *       EnrollSolutionRequest.newBuilder()
   *           .setProject(ProjectName.of("[PROJECT]").toString())
   *           .setSolution(SolutionType.forNumber(0))
   *           .build();
   *   OperationFuture<EnrollSolutionResponse, EnrollSolutionMetadata> future =
   *       projectServiceClient.enrollSolutionOperationCallable().futureCall(request);
   *   // Do something.
   *   EnrollSolutionResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          EnrollSolutionRequest, EnrollSolutionResponse, EnrollSolutionMetadata>
      enrollSolutionOperationCallable() {
    return stub.enrollSolutionOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * The method enrolls a solution of type [Retail
   * Search][google.cloud.retail.v2alpha.SolutionType.SOLUTION_TYPE_SEARCH] into a project.
   *
   * <p>The [Recommendations AI solution
   * type][google.cloud.retail.v2alpha.SolutionType.SOLUTION_TYPE_RECOMMENDATION] is enrolled by
   * default when your project enables Retail API, so you don't need to call the enrollSolution
   * method for recommendations.
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
   *   EnrollSolutionRequest request =
   *       EnrollSolutionRequest.newBuilder()
   *           .setProject(ProjectName.of("[PROJECT]").toString())
   *           .setSolution(SolutionType.forNumber(0))
   *           .build();
   *   ApiFuture<Operation> future =
   *       projectServiceClient.enrollSolutionCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EnrollSolutionRequest, Operation> enrollSolutionCallable() {
    return stub.enrollSolutionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the retail API solutions the project has enrolled.
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
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   ListEnrolledSolutionsResponse response = projectServiceClient.listEnrolledSolutions(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Full resource name of parent. Format: `projects/{project_number_or_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEnrolledSolutionsResponse listEnrolledSolutions(ProjectName parent) {
    ListEnrolledSolutionsRequest request =
        ListEnrolledSolutionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEnrolledSolutions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the retail API solutions the project has enrolled.
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
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   ListEnrolledSolutionsResponse response = projectServiceClient.listEnrolledSolutions(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Full resource name of parent. Format: `projects/{project_number_or_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEnrolledSolutionsResponse listEnrolledSolutions(String parent) {
    ListEnrolledSolutionsRequest request =
        ListEnrolledSolutionsRequest.newBuilder().setParent(parent).build();
    return listEnrolledSolutions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the retail API solutions the project has enrolled.
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
   *   ListEnrolledSolutionsRequest request =
   *       ListEnrolledSolutionsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .build();
   *   ListEnrolledSolutionsResponse response = projectServiceClient.listEnrolledSolutions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEnrolledSolutionsResponse listEnrolledSolutions(
      ListEnrolledSolutionsRequest request) {
    return listEnrolledSolutionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all the retail API solutions the project has enrolled.
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
   *   ListEnrolledSolutionsRequest request =
   *       ListEnrolledSolutionsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .build();
   *   ApiFuture<ListEnrolledSolutionsResponse> future =
   *       projectServiceClient.listEnrolledSolutionsCallable().futureCall(request);
   *   // Do something.
   *   ListEnrolledSolutionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEnrolledSolutionsRequest, ListEnrolledSolutionsResponse>
      listEnrolledSolutionsCallable() {
    return stub.listEnrolledSolutionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the [LoggingConfig][google.cloud.retail.v2alpha.LoggingConfig] of the requested project.
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
   *   LoggingConfigName name = LoggingConfigName.of("[PROJECT]");
   *   LoggingConfig response = projectServiceClient.getLoggingConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Full LoggingConfig resource name. Format:
   *     projects/{project_number}/loggingConfig
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LoggingConfig getLoggingConfig(LoggingConfigName name) {
    GetLoggingConfigRequest request =
        GetLoggingConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getLoggingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the [LoggingConfig][google.cloud.retail.v2alpha.LoggingConfig] of the requested project.
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
   *   String name = LoggingConfigName.of("[PROJECT]").toString();
   *   LoggingConfig response = projectServiceClient.getLoggingConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Full LoggingConfig resource name. Format:
   *     projects/{project_number}/loggingConfig
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LoggingConfig getLoggingConfig(String name) {
    GetLoggingConfigRequest request = GetLoggingConfigRequest.newBuilder().setName(name).build();
    return getLoggingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the [LoggingConfig][google.cloud.retail.v2alpha.LoggingConfig] of the requested project.
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
   *   GetLoggingConfigRequest request =
   *       GetLoggingConfigRequest.newBuilder()
   *           .setName(LoggingConfigName.of("[PROJECT]").toString())
   *           .build();
   *   LoggingConfig response = projectServiceClient.getLoggingConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LoggingConfig getLoggingConfig(GetLoggingConfigRequest request) {
    return getLoggingConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the [LoggingConfig][google.cloud.retail.v2alpha.LoggingConfig] of the requested project.
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
   *   GetLoggingConfigRequest request =
   *       GetLoggingConfigRequest.newBuilder()
   *           .setName(LoggingConfigName.of("[PROJECT]").toString())
   *           .build();
   *   ApiFuture<LoggingConfig> future =
   *       projectServiceClient.getLoggingConfigCallable().futureCall(request);
   *   // Do something.
   *   LoggingConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLoggingConfigRequest, LoggingConfig> getLoggingConfigCallable() {
    return stub.getLoggingConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [LoggingConfig][google.cloud.retail.v2alpha.LoggingConfig] of the requested
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
   * try (ProjectServiceClient projectServiceClient = ProjectServiceClient.create()) {
   *   LoggingConfig loggingConfig = LoggingConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   LoggingConfig response = projectServiceClient.updateLoggingConfig(loggingConfig, updateMask);
   * }
   * }</pre>
   *
   * @param loggingConfig Required. The [LoggingConfig][google.cloud.retail.v2alpha.LoggingConfig]
   *     to update.
   *     <p>If the caller does not have permission to update the
   *     [LoggingConfig][google.cloud.retail.v2alpha.LoggingConfig], then a PERMISSION_DENIED error
   *     is returned.
   *     <p>If the [LoggingConfig][google.cloud.retail.v2alpha.LoggingConfig] to update does not
   *     exist, a NOT_FOUND error is returned.
   * @param updateMask Indicates which fields in the provided
   *     [LoggingConfig][google.cloud.retail.v2alpha.LoggingConfig] to update. The following are the
   *     only supported fields:
   *     <ul>
   *       <li>[LoggingConfig.default_log_generation_rule][google.cloud.retail.v2alpha.LoggingConfig.default_log_generation_rule]
   *       <li>[LoggingConfig.service_log_generation_rules][google.cloud.retail.v2alpha.LoggingConfig.service_log_generation_rules]
   *     </ul>
   *     <p>If not set, all supported fields are updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LoggingConfig updateLoggingConfig(
      LoggingConfig loggingConfig, FieldMask updateMask) {
    UpdateLoggingConfigRequest request =
        UpdateLoggingConfigRequest.newBuilder()
            .setLoggingConfig(loggingConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateLoggingConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [LoggingConfig][google.cloud.retail.v2alpha.LoggingConfig] of the requested
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
   * try (ProjectServiceClient projectServiceClient = ProjectServiceClient.create()) {
   *   UpdateLoggingConfigRequest request =
   *       UpdateLoggingConfigRequest.newBuilder()
   *           .setLoggingConfig(LoggingConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   LoggingConfig response = projectServiceClient.updateLoggingConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LoggingConfig updateLoggingConfig(UpdateLoggingConfigRequest request) {
    return updateLoggingConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the [LoggingConfig][google.cloud.retail.v2alpha.LoggingConfig] of the requested
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
   * try (ProjectServiceClient projectServiceClient = ProjectServiceClient.create()) {
   *   UpdateLoggingConfigRequest request =
   *       UpdateLoggingConfigRequest.newBuilder()
   *           .setLoggingConfig(LoggingConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<LoggingConfig> future =
   *       projectServiceClient.updateLoggingConfigCallable().futureCall(request);
   *   // Do something.
   *   LoggingConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateLoggingConfigRequest, LoggingConfig>
      updateLoggingConfigCallable() {
    return stub.updateLoggingConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the [AlertConfig][google.cloud.retail.v2alpha.AlertConfig] of the requested project.
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
   *   AlertConfigName name = AlertConfigName.of("[PROJECT]");
   *   AlertConfig response = projectServiceClient.getAlertConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Full AlertConfig resource name. Format:
   *     projects/{project_number}/alertConfig
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AlertConfig getAlertConfig(AlertConfigName name) {
    GetAlertConfigRequest request =
        GetAlertConfigRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getAlertConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the [AlertConfig][google.cloud.retail.v2alpha.AlertConfig] of the requested project.
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
   *   String name = AlertConfigName.of("[PROJECT]").toString();
   *   AlertConfig response = projectServiceClient.getAlertConfig(name);
   * }
   * }</pre>
   *
   * @param name Required. Full AlertConfig resource name. Format:
   *     projects/{project_number}/alertConfig
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AlertConfig getAlertConfig(String name) {
    GetAlertConfigRequest request = GetAlertConfigRequest.newBuilder().setName(name).build();
    return getAlertConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the [AlertConfig][google.cloud.retail.v2alpha.AlertConfig] of the requested project.
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
   *   GetAlertConfigRequest request =
   *       GetAlertConfigRequest.newBuilder()
   *           .setName(AlertConfigName.of("[PROJECT]").toString())
   *           .build();
   *   AlertConfig response = projectServiceClient.getAlertConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AlertConfig getAlertConfig(GetAlertConfigRequest request) {
    return getAlertConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the [AlertConfig][google.cloud.retail.v2alpha.AlertConfig] of the requested project.
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
   *   GetAlertConfigRequest request =
   *       GetAlertConfigRequest.newBuilder()
   *           .setName(AlertConfigName.of("[PROJECT]").toString())
   *           .build();
   *   ApiFuture<AlertConfig> future =
   *       projectServiceClient.getAlertConfigCallable().futureCall(request);
   *   // Do something.
   *   AlertConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAlertConfigRequest, AlertConfig> getAlertConfigCallable() {
    return stub.getAlertConfigCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the alert config of the requested project.
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
   *   AlertConfig alertConfig = AlertConfig.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   AlertConfig response = projectServiceClient.updateAlertConfig(alertConfig, updateMask);
   * }
   * }</pre>
   *
   * @param alertConfig Required. The [AlertConfig][google.cloud.retail.v2alpha.AlertConfig] to
   *     update.
   *     <p>If the caller does not have permission to update the
   *     [AlertConfig][google.cloud.retail.v2alpha.AlertConfig], then a PERMISSION_DENIED error is
   *     returned.
   *     <p>If the [AlertConfig][google.cloud.retail.v2alpha.AlertConfig] to update does not exist,
   *     a NOT_FOUND error is returned.
   * @param updateMask Indicates which fields in the provided
   *     [AlertConfig][google.cloud.retail.v2alpha.AlertConfig] to update. If not set, all supported
   *     fields are updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AlertConfig updateAlertConfig(AlertConfig alertConfig, FieldMask updateMask) {
    UpdateAlertConfigRequest request =
        UpdateAlertConfigRequest.newBuilder()
            .setAlertConfig(alertConfig)
            .setUpdateMask(updateMask)
            .build();
    return updateAlertConfig(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the alert config of the requested project.
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
   *   UpdateAlertConfigRequest request =
   *       UpdateAlertConfigRequest.newBuilder()
   *           .setAlertConfig(AlertConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   AlertConfig response = projectServiceClient.updateAlertConfig(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AlertConfig updateAlertConfig(UpdateAlertConfigRequest request) {
    return updateAlertConfigCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update the alert config of the requested project.
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
   *   UpdateAlertConfigRequest request =
   *       UpdateAlertConfigRequest.newBuilder()
   *           .setAlertConfig(AlertConfig.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<AlertConfig> future =
   *       projectServiceClient.updateAlertConfigCallable().futureCall(request);
   *   // Do something.
   *   AlertConfig response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateAlertConfigRequest, AlertConfig> updateAlertConfigCallable() {
    return stub.updateAlertConfigCallable();
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
