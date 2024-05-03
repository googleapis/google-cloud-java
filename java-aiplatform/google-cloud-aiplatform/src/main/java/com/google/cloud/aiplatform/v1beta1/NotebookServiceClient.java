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
import com.google.cloud.aiplatform.v1beta1.stub.NotebookServiceStub;
import com.google.cloud.aiplatform.v1beta1.stub.NotebookServiceStubSettings;
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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The interface for Vertex Notebook service (a.k.a. Colab on Workbench).
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
 * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
 *   NotebookRuntimeTemplateName name =
 *       NotebookRuntimeTemplateName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]");
 *   NotebookRuntimeTemplate response = notebookServiceClient.getNotebookRuntimeTemplate(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the NotebookServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateNotebookRuntimeTemplate</td>
 *      <td><p> Creates a NotebookRuntimeTemplate.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createNotebookRuntimeTemplateAsync(CreateNotebookRuntimeTemplateRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createNotebookRuntimeTemplateAsync(LocationName parent, NotebookRuntimeTemplate notebookRuntimeTemplate, String notebookRuntimeTemplateId)
 *           <li><p> createNotebookRuntimeTemplateAsync(String parent, NotebookRuntimeTemplate notebookRuntimeTemplate, String notebookRuntimeTemplateId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createNotebookRuntimeTemplateOperationCallable()
 *           <li><p> createNotebookRuntimeTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetNotebookRuntimeTemplate</td>
 *      <td><p> Gets a NotebookRuntimeTemplate.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getNotebookRuntimeTemplate(GetNotebookRuntimeTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getNotebookRuntimeTemplate(NotebookRuntimeTemplateName name)
 *           <li><p> getNotebookRuntimeTemplate(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getNotebookRuntimeTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListNotebookRuntimeTemplates</td>
 *      <td><p> Lists NotebookRuntimeTemplates in a Location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listNotebookRuntimeTemplates(ListNotebookRuntimeTemplatesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listNotebookRuntimeTemplates(LocationName parent)
 *           <li><p> listNotebookRuntimeTemplates(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listNotebookRuntimeTemplatesPagedCallable()
 *           <li><p> listNotebookRuntimeTemplatesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteNotebookRuntimeTemplate</td>
 *      <td><p> Deletes a NotebookRuntimeTemplate.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteNotebookRuntimeTemplateAsync(DeleteNotebookRuntimeTemplateRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteNotebookRuntimeTemplateAsync(NotebookRuntimeTemplateName name)
 *           <li><p> deleteNotebookRuntimeTemplateAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteNotebookRuntimeTemplateOperationCallable()
 *           <li><p> deleteNotebookRuntimeTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AssignNotebookRuntime</td>
 *      <td><p> Assigns a NotebookRuntime to a user for a particular Notebook file. This method will either returns an existing assignment or generates a new one.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> assignNotebookRuntimeAsync(AssignNotebookRuntimeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> assignNotebookRuntimeAsync(LocationName parent, NotebookRuntimeTemplateName notebookRuntimeTemplate, NotebookRuntime notebookRuntime, String notebookRuntimeId)
 *           <li><p> assignNotebookRuntimeAsync(LocationName parent, String notebookRuntimeTemplate, NotebookRuntime notebookRuntime, String notebookRuntimeId)
 *           <li><p> assignNotebookRuntimeAsync(String parent, NotebookRuntimeTemplateName notebookRuntimeTemplate, NotebookRuntime notebookRuntime, String notebookRuntimeId)
 *           <li><p> assignNotebookRuntimeAsync(String parent, String notebookRuntimeTemplate, NotebookRuntime notebookRuntime, String notebookRuntimeId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> assignNotebookRuntimeOperationCallable()
 *           <li><p> assignNotebookRuntimeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetNotebookRuntime</td>
 *      <td><p> Gets a NotebookRuntime.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getNotebookRuntime(GetNotebookRuntimeRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getNotebookRuntime(NotebookRuntimeName name)
 *           <li><p> getNotebookRuntime(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getNotebookRuntimeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListNotebookRuntimes</td>
 *      <td><p> Lists NotebookRuntimes in a Location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listNotebookRuntimes(ListNotebookRuntimesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listNotebookRuntimes(LocationName parent)
 *           <li><p> listNotebookRuntimes(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listNotebookRuntimesPagedCallable()
 *           <li><p> listNotebookRuntimesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteNotebookRuntime</td>
 *      <td><p> Deletes a NotebookRuntime.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteNotebookRuntimeAsync(DeleteNotebookRuntimeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteNotebookRuntimeAsync(NotebookRuntimeName name)
 *           <li><p> deleteNotebookRuntimeAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteNotebookRuntimeOperationCallable()
 *           <li><p> deleteNotebookRuntimeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpgradeNotebookRuntime</td>
 *      <td><p> Upgrades a NotebookRuntime.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> upgradeNotebookRuntimeAsync(UpgradeNotebookRuntimeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> upgradeNotebookRuntimeAsync(NotebookRuntimeName name)
 *           <li><p> upgradeNotebookRuntimeAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> upgradeNotebookRuntimeOperationCallable()
 *           <li><p> upgradeNotebookRuntimeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> StartNotebookRuntime</td>
 *      <td><p> Starts a NotebookRuntime.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> startNotebookRuntimeAsync(StartNotebookRuntimeRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> startNotebookRuntimeAsync(NotebookRuntimeName name)
 *           <li><p> startNotebookRuntimeAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> startNotebookRuntimeOperationCallable()
 *           <li><p> startNotebookRuntimeCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetNotebookExecutionJob</td>
 *      <td><p> Gets a NotebookExecutionJob.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getNotebookExecutionJob(GetNotebookExecutionJobRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getNotebookExecutionJob(NotebookExecutionJobName name)
 *           <li><p> getNotebookExecutionJob(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getNotebookExecutionJobCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListNotebookExecutionJobs</td>
 *      <td><p> Lists NotebookExecutionJobs in a Location.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listNotebookExecutionJobs(ListNotebookExecutionJobsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listNotebookExecutionJobs(LocationName parent)
 *           <li><p> listNotebookExecutionJobs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listNotebookExecutionJobsPagedCallable()
 *           <li><p> listNotebookExecutionJobsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteNotebookExecutionJob</td>
 *      <td><p> Deletes a NotebookExecutionJob.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteNotebookExecutionJobAsync(DeleteNotebookExecutionJobRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteNotebookExecutionJobAsync(NotebookExecutionJobName name)
 *           <li><p> deleteNotebookExecutionJobAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteNotebookExecutionJobOperationCallable()
 *           <li><p> deleteNotebookExecutionJobCallable()
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
 * <p>This class can be customized by passing in a custom instance of NotebookServiceSettings to
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
 * NotebookServiceSettings notebookServiceSettings =
 *     NotebookServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NotebookServiceClient notebookServiceClient =
 *     NotebookServiceClient.create(notebookServiceSettings);
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
 * NotebookServiceSettings notebookServiceSettings =
 *     NotebookServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NotebookServiceClient notebookServiceClient =
 *     NotebookServiceClient.create(notebookServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class NotebookServiceClient implements BackgroundResource {
  private final NotebookServiceSettings settings;
  private final NotebookServiceStub stub;
  private final OperationsClient operationsClient;

  /** Constructs an instance of NotebookServiceClient with default settings. */
  public static final NotebookServiceClient create() throws IOException {
    return create(NotebookServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NotebookServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final NotebookServiceClient create(NotebookServiceSettings settings)
      throws IOException {
    return new NotebookServiceClient(settings);
  }

  /**
   * Constructs an instance of NotebookServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(NotebookServiceSettings).
   */
  public static final NotebookServiceClient create(NotebookServiceStub stub) {
    return new NotebookServiceClient(stub);
  }

  /**
   * Constructs an instance of NotebookServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected NotebookServiceClient(NotebookServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((NotebookServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  protected NotebookServiceClient(NotebookServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final NotebookServiceSettings getSettings() {
    return settings;
  }

  public NotebookServiceStub getStub() {
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
   * Creates a NotebookRuntimeTemplate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   NotebookRuntimeTemplate notebookRuntimeTemplate =
   *       NotebookRuntimeTemplate.newBuilder().build();
   *   String notebookRuntimeTemplateId = "notebookRuntimeTemplateId-633369454";
   *   NotebookRuntimeTemplate response =
   *       notebookServiceClient
   *           .createNotebookRuntimeTemplateAsync(
   *               parent, notebookRuntimeTemplate, notebookRuntimeTemplateId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the
   *     NotebookRuntimeTemplate. Format: `projects/{project}/locations/{location}`
   * @param notebookRuntimeTemplate Required. The NotebookRuntimeTemplate to create.
   * @param notebookRuntimeTemplateId Optional. User specified ID for the notebook runtime template.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          NotebookRuntimeTemplate, CreateNotebookRuntimeTemplateOperationMetadata>
      createNotebookRuntimeTemplateAsync(
          LocationName parent,
          NotebookRuntimeTemplate notebookRuntimeTemplate,
          String notebookRuntimeTemplateId) {
    CreateNotebookRuntimeTemplateRequest request =
        CreateNotebookRuntimeTemplateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setNotebookRuntimeTemplate(notebookRuntimeTemplate)
            .setNotebookRuntimeTemplateId(notebookRuntimeTemplateId)
            .build();
    return createNotebookRuntimeTemplateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a NotebookRuntimeTemplate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   NotebookRuntimeTemplate notebookRuntimeTemplate =
   *       NotebookRuntimeTemplate.newBuilder().build();
   *   String notebookRuntimeTemplateId = "notebookRuntimeTemplateId-633369454";
   *   NotebookRuntimeTemplate response =
   *       notebookServiceClient
   *           .createNotebookRuntimeTemplateAsync(
   *               parent, notebookRuntimeTemplate, notebookRuntimeTemplateId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to create the
   *     NotebookRuntimeTemplate. Format: `projects/{project}/locations/{location}`
   * @param notebookRuntimeTemplate Required. The NotebookRuntimeTemplate to create.
   * @param notebookRuntimeTemplateId Optional. User specified ID for the notebook runtime template.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          NotebookRuntimeTemplate, CreateNotebookRuntimeTemplateOperationMetadata>
      createNotebookRuntimeTemplateAsync(
          String parent,
          NotebookRuntimeTemplate notebookRuntimeTemplate,
          String notebookRuntimeTemplateId) {
    CreateNotebookRuntimeTemplateRequest request =
        CreateNotebookRuntimeTemplateRequest.newBuilder()
            .setParent(parent)
            .setNotebookRuntimeTemplate(notebookRuntimeTemplate)
            .setNotebookRuntimeTemplateId(notebookRuntimeTemplateId)
            .build();
    return createNotebookRuntimeTemplateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a NotebookRuntimeTemplate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   CreateNotebookRuntimeTemplateRequest request =
   *       CreateNotebookRuntimeTemplateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setNotebookRuntimeTemplate(NotebookRuntimeTemplate.newBuilder().build())
   *           .setNotebookRuntimeTemplateId("notebookRuntimeTemplateId-633369454")
   *           .build();
   *   NotebookRuntimeTemplate response =
   *       notebookServiceClient.createNotebookRuntimeTemplateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          NotebookRuntimeTemplate, CreateNotebookRuntimeTemplateOperationMetadata>
      createNotebookRuntimeTemplateAsync(CreateNotebookRuntimeTemplateRequest request) {
    return createNotebookRuntimeTemplateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a NotebookRuntimeTemplate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   CreateNotebookRuntimeTemplateRequest request =
   *       CreateNotebookRuntimeTemplateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setNotebookRuntimeTemplate(NotebookRuntimeTemplate.newBuilder().build())
   *           .setNotebookRuntimeTemplateId("notebookRuntimeTemplateId-633369454")
   *           .build();
   *   OperationFuture<NotebookRuntimeTemplate, CreateNotebookRuntimeTemplateOperationMetadata>
   *       future =
   *           notebookServiceClient
   *               .createNotebookRuntimeTemplateOperationCallable()
   *               .futureCall(request);
   *   // Do something.
   *   NotebookRuntimeTemplate response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateNotebookRuntimeTemplateRequest,
          NotebookRuntimeTemplate,
          CreateNotebookRuntimeTemplateOperationMetadata>
      createNotebookRuntimeTemplateOperationCallable() {
    return stub.createNotebookRuntimeTemplateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a NotebookRuntimeTemplate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   CreateNotebookRuntimeTemplateRequest request =
   *       CreateNotebookRuntimeTemplateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setNotebookRuntimeTemplate(NotebookRuntimeTemplate.newBuilder().build())
   *           .setNotebookRuntimeTemplateId("notebookRuntimeTemplateId-633369454")
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.createNotebookRuntimeTemplateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateNotebookRuntimeTemplateRequest, Operation>
      createNotebookRuntimeTemplateCallable() {
    return stub.createNotebookRuntimeTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a NotebookRuntimeTemplate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   NotebookRuntimeTemplateName name =
   *       NotebookRuntimeTemplateName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]");
   *   NotebookRuntimeTemplate response = notebookServiceClient.getNotebookRuntimeTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the NotebookRuntimeTemplate resource. Format:
   *     `projects/{project}/locations/{location}/notebookRuntimeTemplates/{notebook_runtime_template}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotebookRuntimeTemplate getNotebookRuntimeTemplate(
      NotebookRuntimeTemplateName name) {
    GetNotebookRuntimeTemplateRequest request =
        GetNotebookRuntimeTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getNotebookRuntimeTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a NotebookRuntimeTemplate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String name =
   *       NotebookRuntimeTemplateName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]")
   *           .toString();
   *   NotebookRuntimeTemplate response = notebookServiceClient.getNotebookRuntimeTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the NotebookRuntimeTemplate resource. Format:
   *     `projects/{project}/locations/{location}/notebookRuntimeTemplates/{notebook_runtime_template}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotebookRuntimeTemplate getNotebookRuntimeTemplate(String name) {
    GetNotebookRuntimeTemplateRequest request =
        GetNotebookRuntimeTemplateRequest.newBuilder().setName(name).build();
    return getNotebookRuntimeTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a NotebookRuntimeTemplate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   GetNotebookRuntimeTemplateRequest request =
   *       GetNotebookRuntimeTemplateRequest.newBuilder()
   *           .setName(
   *               NotebookRuntimeTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   NotebookRuntimeTemplate response = notebookServiceClient.getNotebookRuntimeTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotebookRuntimeTemplate getNotebookRuntimeTemplate(
      GetNotebookRuntimeTemplateRequest request) {
    return getNotebookRuntimeTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a NotebookRuntimeTemplate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   GetNotebookRuntimeTemplateRequest request =
   *       GetNotebookRuntimeTemplateRequest.newBuilder()
   *           .setName(
   *               NotebookRuntimeTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<NotebookRuntimeTemplate> future =
   *       notebookServiceClient.getNotebookRuntimeTemplateCallable().futureCall(request);
   *   // Do something.
   *   NotebookRuntimeTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNotebookRuntimeTemplateRequest, NotebookRuntimeTemplate>
      getNotebookRuntimeTemplateCallable() {
    return stub.getNotebookRuntimeTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists NotebookRuntimeTemplates in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (NotebookRuntimeTemplate element :
   *       notebookServiceClient.listNotebookRuntimeTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location from which to list the
   *     NotebookRuntimeTemplates. Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotebookRuntimeTemplatesPagedResponse listNotebookRuntimeTemplates(
      LocationName parent) {
    ListNotebookRuntimeTemplatesRequest request =
        ListNotebookRuntimeTemplatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listNotebookRuntimeTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists NotebookRuntimeTemplates in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (NotebookRuntimeTemplate element :
   *       notebookServiceClient.listNotebookRuntimeTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location from which to list the
   *     NotebookRuntimeTemplates. Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotebookRuntimeTemplatesPagedResponse listNotebookRuntimeTemplates(
      String parent) {
    ListNotebookRuntimeTemplatesRequest request =
        ListNotebookRuntimeTemplatesRequest.newBuilder().setParent(parent).build();
    return listNotebookRuntimeTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists NotebookRuntimeTemplates in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListNotebookRuntimeTemplatesRequest request =
   *       ListNotebookRuntimeTemplatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (NotebookRuntimeTemplate element :
   *       notebookServiceClient.listNotebookRuntimeTemplates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotebookRuntimeTemplatesPagedResponse listNotebookRuntimeTemplates(
      ListNotebookRuntimeTemplatesRequest request) {
    return listNotebookRuntimeTemplatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists NotebookRuntimeTemplates in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListNotebookRuntimeTemplatesRequest request =
   *       ListNotebookRuntimeTemplatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<NotebookRuntimeTemplate> future =
   *       notebookServiceClient.listNotebookRuntimeTemplatesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (NotebookRuntimeTemplate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListNotebookRuntimeTemplatesRequest, ListNotebookRuntimeTemplatesPagedResponse>
      listNotebookRuntimeTemplatesPagedCallable() {
    return stub.listNotebookRuntimeTemplatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists NotebookRuntimeTemplates in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListNotebookRuntimeTemplatesRequest request =
   *       ListNotebookRuntimeTemplatesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListNotebookRuntimeTemplatesResponse response =
   *         notebookServiceClient.listNotebookRuntimeTemplatesCallable().call(request);
   *     for (NotebookRuntimeTemplate element : response.getNotebookRuntimeTemplatesList()) {
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
          ListNotebookRuntimeTemplatesRequest, ListNotebookRuntimeTemplatesResponse>
      listNotebookRuntimeTemplatesCallable() {
    return stub.listNotebookRuntimeTemplatesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a NotebookRuntimeTemplate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   NotebookRuntimeTemplateName name =
   *       NotebookRuntimeTemplateName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]");
   *   notebookServiceClient.deleteNotebookRuntimeTemplateAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the NotebookRuntimeTemplate resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/notebookRuntimeTemplates/{notebook_runtime_template}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteNotebookRuntimeTemplateAsync(
      NotebookRuntimeTemplateName name) {
    DeleteNotebookRuntimeTemplateRequest request =
        DeleteNotebookRuntimeTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteNotebookRuntimeTemplateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a NotebookRuntimeTemplate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String name =
   *       NotebookRuntimeTemplateName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]")
   *           .toString();
   *   notebookServiceClient.deleteNotebookRuntimeTemplateAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the NotebookRuntimeTemplate resource to be deleted. Format:
   *     `projects/{project}/locations/{location}/notebookRuntimeTemplates/{notebook_runtime_template}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteNotebookRuntimeTemplateAsync(
      String name) {
    DeleteNotebookRuntimeTemplateRequest request =
        DeleteNotebookRuntimeTemplateRequest.newBuilder().setName(name).build();
    return deleteNotebookRuntimeTemplateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a NotebookRuntimeTemplate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   DeleteNotebookRuntimeTemplateRequest request =
   *       DeleteNotebookRuntimeTemplateRequest.newBuilder()
   *           .setName(
   *               NotebookRuntimeTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   notebookServiceClient.deleteNotebookRuntimeTemplateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteNotebookRuntimeTemplateAsync(
      DeleteNotebookRuntimeTemplateRequest request) {
    return deleteNotebookRuntimeTemplateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a NotebookRuntimeTemplate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   DeleteNotebookRuntimeTemplateRequest request =
   *       DeleteNotebookRuntimeTemplateRequest.newBuilder()
   *           .setName(
   *               NotebookRuntimeTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       notebookServiceClient
   *           .deleteNotebookRuntimeTemplateOperationCallable()
   *           .futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          DeleteNotebookRuntimeTemplateRequest, Empty, DeleteOperationMetadata>
      deleteNotebookRuntimeTemplateOperationCallable() {
    return stub.deleteNotebookRuntimeTemplateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a NotebookRuntimeTemplate.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   DeleteNotebookRuntimeTemplateRequest request =
   *       DeleteNotebookRuntimeTemplateRequest.newBuilder()
   *           .setName(
   *               NotebookRuntimeTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.deleteNotebookRuntimeTemplateCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteNotebookRuntimeTemplateRequest, Operation>
      deleteNotebookRuntimeTemplateCallable() {
    return stub.deleteNotebookRuntimeTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Assigns a NotebookRuntime to a user for a particular Notebook file. This method will either
   * returns an existing assignment or generates a new one.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   NotebookRuntimeTemplateName notebookRuntimeTemplate =
   *       NotebookRuntimeTemplateName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]");
   *   NotebookRuntime notebookRuntime = NotebookRuntime.newBuilder().build();
   *   String notebookRuntimeId = "notebookRuntimeId400795512";
   *   NotebookRuntime response =
   *       notebookServiceClient
   *           .assignNotebookRuntimeAsync(
   *               parent, notebookRuntimeTemplate, notebookRuntime, notebookRuntimeId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to get the NotebookRuntime
   *     assignment. Format: `projects/{project}/locations/{location}`
   * @param notebookRuntimeTemplate Required. The resource name of the NotebookRuntimeTemplate based
   *     on which a NotebookRuntime will be assigned (reuse or create a new one).
   * @param notebookRuntime Required. Provide runtime specific information (e.g. runtime owner,
   *     notebook id) used for NotebookRuntime assignment.
   * @param notebookRuntimeId Optional. User specified ID for the notebook runtime.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NotebookRuntime, AssignNotebookRuntimeOperationMetadata>
      assignNotebookRuntimeAsync(
          LocationName parent,
          NotebookRuntimeTemplateName notebookRuntimeTemplate,
          NotebookRuntime notebookRuntime,
          String notebookRuntimeId) {
    AssignNotebookRuntimeRequest request =
        AssignNotebookRuntimeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setNotebookRuntimeTemplate(
                notebookRuntimeTemplate == null ? null : notebookRuntimeTemplate.toString())
            .setNotebookRuntime(notebookRuntime)
            .setNotebookRuntimeId(notebookRuntimeId)
            .build();
    return assignNotebookRuntimeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Assigns a NotebookRuntime to a user for a particular Notebook file. This method will either
   * returns an existing assignment or generates a new one.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String notebookRuntimeTemplate =
   *       NotebookRuntimeTemplateName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]")
   *           .toString();
   *   NotebookRuntime notebookRuntime = NotebookRuntime.newBuilder().build();
   *   String notebookRuntimeId = "notebookRuntimeId400795512";
   *   NotebookRuntime response =
   *       notebookServiceClient
   *           .assignNotebookRuntimeAsync(
   *               parent, notebookRuntimeTemplate, notebookRuntime, notebookRuntimeId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to get the NotebookRuntime
   *     assignment. Format: `projects/{project}/locations/{location}`
   * @param notebookRuntimeTemplate Required. The resource name of the NotebookRuntimeTemplate based
   *     on which a NotebookRuntime will be assigned (reuse or create a new one).
   * @param notebookRuntime Required. Provide runtime specific information (e.g. runtime owner,
   *     notebook id) used for NotebookRuntime assignment.
   * @param notebookRuntimeId Optional. User specified ID for the notebook runtime.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NotebookRuntime, AssignNotebookRuntimeOperationMetadata>
      assignNotebookRuntimeAsync(
          LocationName parent,
          String notebookRuntimeTemplate,
          NotebookRuntime notebookRuntime,
          String notebookRuntimeId) {
    AssignNotebookRuntimeRequest request =
        AssignNotebookRuntimeRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setNotebookRuntimeTemplate(notebookRuntimeTemplate)
            .setNotebookRuntime(notebookRuntime)
            .setNotebookRuntimeId(notebookRuntimeId)
            .build();
    return assignNotebookRuntimeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Assigns a NotebookRuntime to a user for a particular Notebook file. This method will either
   * returns an existing assignment or generates a new one.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   NotebookRuntimeTemplateName notebookRuntimeTemplate =
   *       NotebookRuntimeTemplateName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]");
   *   NotebookRuntime notebookRuntime = NotebookRuntime.newBuilder().build();
   *   String notebookRuntimeId = "notebookRuntimeId400795512";
   *   NotebookRuntime response =
   *       notebookServiceClient
   *           .assignNotebookRuntimeAsync(
   *               parent, notebookRuntimeTemplate, notebookRuntime, notebookRuntimeId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to get the NotebookRuntime
   *     assignment. Format: `projects/{project}/locations/{location}`
   * @param notebookRuntimeTemplate Required. The resource name of the NotebookRuntimeTemplate based
   *     on which a NotebookRuntime will be assigned (reuse or create a new one).
   * @param notebookRuntime Required. Provide runtime specific information (e.g. runtime owner,
   *     notebook id) used for NotebookRuntime assignment.
   * @param notebookRuntimeId Optional. User specified ID for the notebook runtime.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NotebookRuntime, AssignNotebookRuntimeOperationMetadata>
      assignNotebookRuntimeAsync(
          String parent,
          NotebookRuntimeTemplateName notebookRuntimeTemplate,
          NotebookRuntime notebookRuntime,
          String notebookRuntimeId) {
    AssignNotebookRuntimeRequest request =
        AssignNotebookRuntimeRequest.newBuilder()
            .setParent(parent)
            .setNotebookRuntimeTemplate(
                notebookRuntimeTemplate == null ? null : notebookRuntimeTemplate.toString())
            .setNotebookRuntime(notebookRuntime)
            .setNotebookRuntimeId(notebookRuntimeId)
            .build();
    return assignNotebookRuntimeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Assigns a NotebookRuntime to a user for a particular Notebook file. This method will either
   * returns an existing assignment or generates a new one.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String notebookRuntimeTemplate =
   *       NotebookRuntimeTemplateName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]")
   *           .toString();
   *   NotebookRuntime notebookRuntime = NotebookRuntime.newBuilder().build();
   *   String notebookRuntimeId = "notebookRuntimeId400795512";
   *   NotebookRuntime response =
   *       notebookServiceClient
   *           .assignNotebookRuntimeAsync(
   *               parent, notebookRuntimeTemplate, notebookRuntime, notebookRuntimeId)
   *           .get();
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location to get the NotebookRuntime
   *     assignment. Format: `projects/{project}/locations/{location}`
   * @param notebookRuntimeTemplate Required. The resource name of the NotebookRuntimeTemplate based
   *     on which a NotebookRuntime will be assigned (reuse or create a new one).
   * @param notebookRuntime Required. Provide runtime specific information (e.g. runtime owner,
   *     notebook id) used for NotebookRuntime assignment.
   * @param notebookRuntimeId Optional. User specified ID for the notebook runtime.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NotebookRuntime, AssignNotebookRuntimeOperationMetadata>
      assignNotebookRuntimeAsync(
          String parent,
          String notebookRuntimeTemplate,
          NotebookRuntime notebookRuntime,
          String notebookRuntimeId) {
    AssignNotebookRuntimeRequest request =
        AssignNotebookRuntimeRequest.newBuilder()
            .setParent(parent)
            .setNotebookRuntimeTemplate(notebookRuntimeTemplate)
            .setNotebookRuntime(notebookRuntime)
            .setNotebookRuntimeId(notebookRuntimeId)
            .build();
    return assignNotebookRuntimeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Assigns a NotebookRuntime to a user for a particular Notebook file. This method will either
   * returns an existing assignment or generates a new one.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   AssignNotebookRuntimeRequest request =
   *       AssignNotebookRuntimeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setNotebookRuntimeTemplate(
   *               NotebookRuntimeTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]")
   *                   .toString())
   *           .setNotebookRuntime(NotebookRuntime.newBuilder().build())
   *           .setNotebookRuntimeId("notebookRuntimeId400795512")
   *           .build();
   *   NotebookRuntime response = notebookServiceClient.assignNotebookRuntimeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<NotebookRuntime, AssignNotebookRuntimeOperationMetadata>
      assignNotebookRuntimeAsync(AssignNotebookRuntimeRequest request) {
    return assignNotebookRuntimeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Assigns a NotebookRuntime to a user for a particular Notebook file. This method will either
   * returns an existing assignment or generates a new one.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   AssignNotebookRuntimeRequest request =
   *       AssignNotebookRuntimeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setNotebookRuntimeTemplate(
   *               NotebookRuntimeTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]")
   *                   .toString())
   *           .setNotebookRuntime(NotebookRuntime.newBuilder().build())
   *           .setNotebookRuntimeId("notebookRuntimeId400795512")
   *           .build();
   *   OperationFuture<NotebookRuntime, AssignNotebookRuntimeOperationMetadata> future =
   *       notebookServiceClient.assignNotebookRuntimeOperationCallable().futureCall(request);
   *   // Do something.
   *   NotebookRuntime response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          AssignNotebookRuntimeRequest, NotebookRuntime, AssignNotebookRuntimeOperationMetadata>
      assignNotebookRuntimeOperationCallable() {
    return stub.assignNotebookRuntimeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Assigns a NotebookRuntime to a user for a particular Notebook file. This method will either
   * returns an existing assignment or generates a new one.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   AssignNotebookRuntimeRequest request =
   *       AssignNotebookRuntimeRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setNotebookRuntimeTemplate(
   *               NotebookRuntimeTemplateName.of(
   *                       "[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME_TEMPLATE]")
   *                   .toString())
   *           .setNotebookRuntime(NotebookRuntime.newBuilder().build())
   *           .setNotebookRuntimeId("notebookRuntimeId400795512")
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.assignNotebookRuntimeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AssignNotebookRuntimeRequest, Operation>
      assignNotebookRuntimeCallable() {
    return stub.assignNotebookRuntimeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a NotebookRuntime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   NotebookRuntimeName name =
   *       NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]");
   *   NotebookRuntime response = notebookServiceClient.getNotebookRuntime(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the NotebookRuntime resource. Instead of checking whether the
   *     name is in valid NotebookRuntime resource name format, directly throw NotFound exception if
   *     there is no such NotebookRuntime in spanner.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotebookRuntime getNotebookRuntime(NotebookRuntimeName name) {
    GetNotebookRuntimeRequest request =
        GetNotebookRuntimeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getNotebookRuntime(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a NotebookRuntime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String name =
   *       NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]").toString();
   *   NotebookRuntime response = notebookServiceClient.getNotebookRuntime(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the NotebookRuntime resource. Instead of checking whether the
   *     name is in valid NotebookRuntime resource name format, directly throw NotFound exception if
   *     there is no such NotebookRuntime in spanner.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotebookRuntime getNotebookRuntime(String name) {
    GetNotebookRuntimeRequest request =
        GetNotebookRuntimeRequest.newBuilder().setName(name).build();
    return getNotebookRuntime(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a NotebookRuntime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   GetNotebookRuntimeRequest request =
   *       GetNotebookRuntimeRequest.newBuilder()
   *           .setName(
   *               NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]")
   *                   .toString())
   *           .build();
   *   NotebookRuntime response = notebookServiceClient.getNotebookRuntime(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotebookRuntime getNotebookRuntime(GetNotebookRuntimeRequest request) {
    return getNotebookRuntimeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a NotebookRuntime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   GetNotebookRuntimeRequest request =
   *       GetNotebookRuntimeRequest.newBuilder()
   *           .setName(
   *               NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]")
   *                   .toString())
   *           .build();
   *   ApiFuture<NotebookRuntime> future =
   *       notebookServiceClient.getNotebookRuntimeCallable().futureCall(request);
   *   // Do something.
   *   NotebookRuntime response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNotebookRuntimeRequest, NotebookRuntime>
      getNotebookRuntimeCallable() {
    return stub.getNotebookRuntimeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists NotebookRuntimes in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (NotebookRuntime element :
   *       notebookServiceClient.listNotebookRuntimes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location from which to list the
   *     NotebookRuntimes. Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotebookRuntimesPagedResponse listNotebookRuntimes(LocationName parent) {
    ListNotebookRuntimesRequest request =
        ListNotebookRuntimesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listNotebookRuntimes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists NotebookRuntimes in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (NotebookRuntime element :
   *       notebookServiceClient.listNotebookRuntimes(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location from which to list the
   *     NotebookRuntimes. Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotebookRuntimesPagedResponse listNotebookRuntimes(String parent) {
    ListNotebookRuntimesRequest request =
        ListNotebookRuntimesRequest.newBuilder().setParent(parent).build();
    return listNotebookRuntimes(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists NotebookRuntimes in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListNotebookRuntimesRequest request =
   *       ListNotebookRuntimesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (NotebookRuntime element :
   *       notebookServiceClient.listNotebookRuntimes(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotebookRuntimesPagedResponse listNotebookRuntimes(
      ListNotebookRuntimesRequest request) {
    return listNotebookRuntimesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists NotebookRuntimes in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListNotebookRuntimesRequest request =
   *       ListNotebookRuntimesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<NotebookRuntime> future =
   *       notebookServiceClient.listNotebookRuntimesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (NotebookRuntime element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNotebookRuntimesRequest, ListNotebookRuntimesPagedResponse>
      listNotebookRuntimesPagedCallable() {
    return stub.listNotebookRuntimesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists NotebookRuntimes in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListNotebookRuntimesRequest request =
   *       ListNotebookRuntimesRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListNotebookRuntimesResponse response =
   *         notebookServiceClient.listNotebookRuntimesCallable().call(request);
   *     for (NotebookRuntime element : response.getNotebookRuntimesList()) {
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
  public final UnaryCallable<ListNotebookRuntimesRequest, ListNotebookRuntimesResponse>
      listNotebookRuntimesCallable() {
    return stub.listNotebookRuntimesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a NotebookRuntime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   NotebookRuntimeName name =
   *       NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]");
   *   notebookServiceClient.deleteNotebookRuntimeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the NotebookRuntime resource to be deleted. Instead of
   *     checking whether the name is in valid NotebookRuntime resource name format, directly throw
   *     NotFound exception if there is no such NotebookRuntime in spanner.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteNotebookRuntimeAsync(
      NotebookRuntimeName name) {
    DeleteNotebookRuntimeRequest request =
        DeleteNotebookRuntimeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteNotebookRuntimeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a NotebookRuntime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String name =
   *       NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]").toString();
   *   notebookServiceClient.deleteNotebookRuntimeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the NotebookRuntime resource to be deleted. Instead of
   *     checking whether the name is in valid NotebookRuntime resource name format, directly throw
   *     NotFound exception if there is no such NotebookRuntime in spanner.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteNotebookRuntimeAsync(
      String name) {
    DeleteNotebookRuntimeRequest request =
        DeleteNotebookRuntimeRequest.newBuilder().setName(name).build();
    return deleteNotebookRuntimeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a NotebookRuntime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   DeleteNotebookRuntimeRequest request =
   *       DeleteNotebookRuntimeRequest.newBuilder()
   *           .setName(
   *               NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]")
   *                   .toString())
   *           .build();
   *   notebookServiceClient.deleteNotebookRuntimeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteNotebookRuntimeAsync(
      DeleteNotebookRuntimeRequest request) {
    return deleteNotebookRuntimeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a NotebookRuntime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   DeleteNotebookRuntimeRequest request =
   *       DeleteNotebookRuntimeRequest.newBuilder()
   *           .setName(
   *               NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       notebookServiceClient.deleteNotebookRuntimeOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteNotebookRuntimeRequest, Empty, DeleteOperationMetadata>
      deleteNotebookRuntimeOperationCallable() {
    return stub.deleteNotebookRuntimeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a NotebookRuntime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   DeleteNotebookRuntimeRequest request =
   *       DeleteNotebookRuntimeRequest.newBuilder()
   *           .setName(
   *               NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.deleteNotebookRuntimeCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteNotebookRuntimeRequest, Operation>
      deleteNotebookRuntimeCallable() {
    return stub.deleteNotebookRuntimeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades a NotebookRuntime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   NotebookRuntimeName name =
   *       NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]");
   *   UpgradeNotebookRuntimeResponse response =
   *       notebookServiceClient.upgradeNotebookRuntimeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the NotebookRuntime resource to be upgrade. Instead of
   *     checking whether the name is in valid NotebookRuntime resource name format, directly throw
   *     NotFound exception if there is no such NotebookRuntime in spanner.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          UpgradeNotebookRuntimeResponse, UpgradeNotebookRuntimeOperationMetadata>
      upgradeNotebookRuntimeAsync(NotebookRuntimeName name) {
    UpgradeNotebookRuntimeRequest request =
        UpgradeNotebookRuntimeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return upgradeNotebookRuntimeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades a NotebookRuntime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String name =
   *       NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]").toString();
   *   UpgradeNotebookRuntimeResponse response =
   *       notebookServiceClient.upgradeNotebookRuntimeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the NotebookRuntime resource to be upgrade. Instead of
   *     checking whether the name is in valid NotebookRuntime resource name format, directly throw
   *     NotFound exception if there is no such NotebookRuntime in spanner.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          UpgradeNotebookRuntimeResponse, UpgradeNotebookRuntimeOperationMetadata>
      upgradeNotebookRuntimeAsync(String name) {
    UpgradeNotebookRuntimeRequest request =
        UpgradeNotebookRuntimeRequest.newBuilder().setName(name).build();
    return upgradeNotebookRuntimeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades a NotebookRuntime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   UpgradeNotebookRuntimeRequest request =
   *       UpgradeNotebookRuntimeRequest.newBuilder()
   *           .setName(
   *               NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]")
   *                   .toString())
   *           .build();
   *   UpgradeNotebookRuntimeResponse response =
   *       notebookServiceClient.upgradeNotebookRuntimeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          UpgradeNotebookRuntimeResponse, UpgradeNotebookRuntimeOperationMetadata>
      upgradeNotebookRuntimeAsync(UpgradeNotebookRuntimeRequest request) {
    return upgradeNotebookRuntimeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades a NotebookRuntime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   UpgradeNotebookRuntimeRequest request =
   *       UpgradeNotebookRuntimeRequest.newBuilder()
   *           .setName(
   *               NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]")
   *                   .toString())
   *           .build();
   *   OperationFuture<UpgradeNotebookRuntimeResponse, UpgradeNotebookRuntimeOperationMetadata>
   *       future =
   *           notebookServiceClient.upgradeNotebookRuntimeOperationCallable().futureCall(request);
   *   // Do something.
   *   UpgradeNotebookRuntimeResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          UpgradeNotebookRuntimeRequest,
          UpgradeNotebookRuntimeResponse,
          UpgradeNotebookRuntimeOperationMetadata>
      upgradeNotebookRuntimeOperationCallable() {
    return stub.upgradeNotebookRuntimeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Upgrades a NotebookRuntime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   UpgradeNotebookRuntimeRequest request =
   *       UpgradeNotebookRuntimeRequest.newBuilder()
   *           .setName(
   *               NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.upgradeNotebookRuntimeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpgradeNotebookRuntimeRequest, Operation>
      upgradeNotebookRuntimeCallable() {
    return stub.upgradeNotebookRuntimeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a NotebookRuntime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   NotebookRuntimeName name =
   *       NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]");
   *   StartNotebookRuntimeResponse response =
   *       notebookServiceClient.startNotebookRuntimeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the NotebookRuntime resource to be started. Instead of
   *     checking whether the name is in valid NotebookRuntime resource name format, directly throw
   *     NotFound exception if there is no such NotebookRuntime in spanner.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StartNotebookRuntimeResponse, StartNotebookRuntimeOperationMetadata>
      startNotebookRuntimeAsync(NotebookRuntimeName name) {
    StartNotebookRuntimeRequest request =
        StartNotebookRuntimeRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return startNotebookRuntimeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a NotebookRuntime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String name =
   *       NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]").toString();
   *   StartNotebookRuntimeResponse response =
   *       notebookServiceClient.startNotebookRuntimeAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the NotebookRuntime resource to be started. Instead of
   *     checking whether the name is in valid NotebookRuntime resource name format, directly throw
   *     NotFound exception if there is no such NotebookRuntime in spanner.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StartNotebookRuntimeResponse, StartNotebookRuntimeOperationMetadata>
      startNotebookRuntimeAsync(String name) {
    StartNotebookRuntimeRequest request =
        StartNotebookRuntimeRequest.newBuilder().setName(name).build();
    return startNotebookRuntimeAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a NotebookRuntime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   StartNotebookRuntimeRequest request =
   *       StartNotebookRuntimeRequest.newBuilder()
   *           .setName(
   *               NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]")
   *                   .toString())
   *           .build();
   *   StartNotebookRuntimeResponse response =
   *       notebookServiceClient.startNotebookRuntimeAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<StartNotebookRuntimeResponse, StartNotebookRuntimeOperationMetadata>
      startNotebookRuntimeAsync(StartNotebookRuntimeRequest request) {
    return startNotebookRuntimeOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a NotebookRuntime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   StartNotebookRuntimeRequest request =
   *       StartNotebookRuntimeRequest.newBuilder()
   *           .setName(
   *               NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]")
   *                   .toString())
   *           .build();
   *   OperationFuture<StartNotebookRuntimeResponse, StartNotebookRuntimeOperationMetadata> future =
   *       notebookServiceClient.startNotebookRuntimeOperationCallable().futureCall(request);
   *   // Do something.
   *   StartNotebookRuntimeResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          StartNotebookRuntimeRequest,
          StartNotebookRuntimeResponse,
          StartNotebookRuntimeOperationMetadata>
      startNotebookRuntimeOperationCallable() {
    return stub.startNotebookRuntimeOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts a NotebookRuntime.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   StartNotebookRuntimeRequest request =
   *       StartNotebookRuntimeRequest.newBuilder()
   *           .setName(
   *               NotebookRuntimeName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_RUNTIME]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.startNotebookRuntimeCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartNotebookRuntimeRequest, Operation>
      startNotebookRuntimeCallable() {
    return stub.startNotebookRuntimeCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a NotebookExecutionJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   NotebookExecutionJobName name =
   *       NotebookExecutionJobName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_EXECUTION_JOB]");
   *   NotebookExecutionJob response = notebookServiceClient.getNotebookExecutionJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the NotebookExecutionJob resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotebookExecutionJob getNotebookExecutionJob(NotebookExecutionJobName name) {
    GetNotebookExecutionJobRequest request =
        GetNotebookExecutionJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getNotebookExecutionJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a NotebookExecutionJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String name =
   *       NotebookExecutionJobName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_EXECUTION_JOB]")
   *           .toString();
   *   NotebookExecutionJob response = notebookServiceClient.getNotebookExecutionJob(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the NotebookExecutionJob resource.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotebookExecutionJob getNotebookExecutionJob(String name) {
    GetNotebookExecutionJobRequest request =
        GetNotebookExecutionJobRequest.newBuilder().setName(name).build();
    return getNotebookExecutionJob(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a NotebookExecutionJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   GetNotebookExecutionJobRequest request =
   *       GetNotebookExecutionJobRequest.newBuilder()
   *           .setName(
   *               NotebookExecutionJobName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_EXECUTION_JOB]")
   *                   .toString())
   *           .setView(NotebookExecutionJobView.forNumber(0))
   *           .build();
   *   NotebookExecutionJob response = notebookServiceClient.getNotebookExecutionJob(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NotebookExecutionJob getNotebookExecutionJob(
      GetNotebookExecutionJobRequest request) {
    return getNotebookExecutionJobCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a NotebookExecutionJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   GetNotebookExecutionJobRequest request =
   *       GetNotebookExecutionJobRequest.newBuilder()
   *           .setName(
   *               NotebookExecutionJobName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_EXECUTION_JOB]")
   *                   .toString())
   *           .setView(NotebookExecutionJobView.forNumber(0))
   *           .build();
   *   ApiFuture<NotebookExecutionJob> future =
   *       notebookServiceClient.getNotebookExecutionJobCallable().futureCall(request);
   *   // Do something.
   *   NotebookExecutionJob response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNotebookExecutionJobRequest, NotebookExecutionJob>
      getNotebookExecutionJobCallable() {
    return stub.getNotebookExecutionJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists NotebookExecutionJobs in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (NotebookExecutionJob element :
   *       notebookServiceClient.listNotebookExecutionJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location from which to list the
   *     NotebookExecutionJobs. Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotebookExecutionJobsPagedResponse listNotebookExecutionJobs(
      LocationName parent) {
    ListNotebookExecutionJobsRequest request =
        ListNotebookExecutionJobsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listNotebookExecutionJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists NotebookExecutionJobs in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (NotebookExecutionJob element :
   *       notebookServiceClient.listNotebookExecutionJobs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the Location from which to list the
   *     NotebookExecutionJobs. Format: `projects/{project}/locations/{location}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotebookExecutionJobsPagedResponse listNotebookExecutionJobs(String parent) {
    ListNotebookExecutionJobsRequest request =
        ListNotebookExecutionJobsRequest.newBuilder().setParent(parent).build();
    return listNotebookExecutionJobs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists NotebookExecutionJobs in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListNotebookExecutionJobsRequest request =
   *       ListNotebookExecutionJobsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(NotebookExecutionJobView.forNumber(0))
   *           .build();
   *   for (NotebookExecutionJob element :
   *       notebookServiceClient.listNotebookExecutionJobs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNotebookExecutionJobsPagedResponse listNotebookExecutionJobs(
      ListNotebookExecutionJobsRequest request) {
    return listNotebookExecutionJobsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists NotebookExecutionJobs in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListNotebookExecutionJobsRequest request =
   *       ListNotebookExecutionJobsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(NotebookExecutionJobView.forNumber(0))
   *           .build();
   *   ApiFuture<NotebookExecutionJob> future =
   *       notebookServiceClient.listNotebookExecutionJobsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (NotebookExecutionJob element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListNotebookExecutionJobsRequest, ListNotebookExecutionJobsPagedResponse>
      listNotebookExecutionJobsPagedCallable() {
    return stub.listNotebookExecutionJobsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists NotebookExecutionJobs in a Location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListNotebookExecutionJobsRequest request =
   *       ListNotebookExecutionJobsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setView(NotebookExecutionJobView.forNumber(0))
   *           .build();
   *   while (true) {
   *     ListNotebookExecutionJobsResponse response =
   *         notebookServiceClient.listNotebookExecutionJobsCallable().call(request);
   *     for (NotebookExecutionJob element : response.getNotebookExecutionJobsList()) {
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
  public final UnaryCallable<ListNotebookExecutionJobsRequest, ListNotebookExecutionJobsResponse>
      listNotebookExecutionJobsCallable() {
    return stub.listNotebookExecutionJobsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a NotebookExecutionJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   NotebookExecutionJobName name =
   *       NotebookExecutionJobName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_EXECUTION_JOB]");
   *   notebookServiceClient.deleteNotebookExecutionJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the NotebookExecutionJob resource to be deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteNotebookExecutionJobAsync(
      NotebookExecutionJobName name) {
    DeleteNotebookExecutionJobRequest request =
        DeleteNotebookExecutionJobRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return deleteNotebookExecutionJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a NotebookExecutionJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   String name =
   *       NotebookExecutionJobName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_EXECUTION_JOB]")
   *           .toString();
   *   notebookServiceClient.deleteNotebookExecutionJobAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the NotebookExecutionJob resource to be deleted.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteNotebookExecutionJobAsync(
      String name) {
    DeleteNotebookExecutionJobRequest request =
        DeleteNotebookExecutionJobRequest.newBuilder().setName(name).build();
    return deleteNotebookExecutionJobAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a NotebookExecutionJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   DeleteNotebookExecutionJobRequest request =
   *       DeleteNotebookExecutionJobRequest.newBuilder()
   *           .setName(
   *               NotebookExecutionJobName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_EXECUTION_JOB]")
   *                   .toString())
   *           .build();
   *   notebookServiceClient.deleteNotebookExecutionJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, DeleteOperationMetadata> deleteNotebookExecutionJobAsync(
      DeleteNotebookExecutionJobRequest request) {
    return deleteNotebookExecutionJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a NotebookExecutionJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   DeleteNotebookExecutionJobRequest request =
   *       DeleteNotebookExecutionJobRequest.newBuilder()
   *           .setName(
   *               NotebookExecutionJobName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_EXECUTION_JOB]")
   *                   .toString())
   *           .build();
   *   OperationFuture<Empty, DeleteOperationMetadata> future =
   *       notebookServiceClient.deleteNotebookExecutionJobOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteNotebookExecutionJobRequest, Empty, DeleteOperationMetadata>
      deleteNotebookExecutionJobOperationCallable() {
    return stub.deleteNotebookExecutionJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a NotebookExecutionJob.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   DeleteNotebookExecutionJobRequest request =
   *       DeleteNotebookExecutionJobRequest.newBuilder()
   *           .setName(
   *               NotebookExecutionJobName.of("[PROJECT]", "[LOCATION]", "[NOTEBOOK_EXECUTION_JOB]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Operation> future =
   *       notebookServiceClient.deleteNotebookExecutionJobCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteNotebookExecutionJobRequest, Operation>
      deleteNotebookExecutionJobCallable() {
    return stub.deleteNotebookExecutionJobCallable();
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
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : notebookServiceClient.listLocations(request).iterateAll()) {
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
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       notebookServiceClient.listLocationsPagedCallable().futureCall(request);
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
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response =
   *         notebookServiceClient.listLocationsCallable().call(request);
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
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = notebookServiceClient.getLocation(request);
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
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = notebookServiceClient.getLocationCallable().futureCall(request);
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
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = notebookServiceClient.setIamPolicy(request);
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
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = notebookServiceClient.setIamPolicyCallable().futureCall(request);
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
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = notebookServiceClient.getIamPolicy(request);
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
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = notebookServiceClient.getIamPolicyCallable().futureCall(request);
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
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = notebookServiceClient.testIamPermissions(request);
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
   * try (NotebookServiceClient notebookServiceClient = NotebookServiceClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EndpointName.ofProjectLocationEndpointName(
   *                       "[PROJECT]", "[LOCATION]", "[ENDPOINT]")
   *                   .toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       notebookServiceClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListNotebookRuntimeTemplatesPagedResponse
      extends AbstractPagedListResponse<
          ListNotebookRuntimeTemplatesRequest,
          ListNotebookRuntimeTemplatesResponse,
          NotebookRuntimeTemplate,
          ListNotebookRuntimeTemplatesPage,
          ListNotebookRuntimeTemplatesFixedSizeCollection> {

    public static ApiFuture<ListNotebookRuntimeTemplatesPagedResponse> createAsync(
        PageContext<
                ListNotebookRuntimeTemplatesRequest,
                ListNotebookRuntimeTemplatesResponse,
                NotebookRuntimeTemplate>
            context,
        ApiFuture<ListNotebookRuntimeTemplatesResponse> futureResponse) {
      ApiFuture<ListNotebookRuntimeTemplatesPage> futurePage =
          ListNotebookRuntimeTemplatesPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListNotebookRuntimeTemplatesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListNotebookRuntimeTemplatesPagedResponse(ListNotebookRuntimeTemplatesPage page) {
      super(page, ListNotebookRuntimeTemplatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNotebookRuntimeTemplatesPage
      extends AbstractPage<
          ListNotebookRuntimeTemplatesRequest,
          ListNotebookRuntimeTemplatesResponse,
          NotebookRuntimeTemplate,
          ListNotebookRuntimeTemplatesPage> {

    private ListNotebookRuntimeTemplatesPage(
        PageContext<
                ListNotebookRuntimeTemplatesRequest,
                ListNotebookRuntimeTemplatesResponse,
                NotebookRuntimeTemplate>
            context,
        ListNotebookRuntimeTemplatesResponse response) {
      super(context, response);
    }

    private static ListNotebookRuntimeTemplatesPage createEmptyPage() {
      return new ListNotebookRuntimeTemplatesPage(null, null);
    }

    @Override
    protected ListNotebookRuntimeTemplatesPage createPage(
        PageContext<
                ListNotebookRuntimeTemplatesRequest,
                ListNotebookRuntimeTemplatesResponse,
                NotebookRuntimeTemplate>
            context,
        ListNotebookRuntimeTemplatesResponse response) {
      return new ListNotebookRuntimeTemplatesPage(context, response);
    }

    @Override
    public ApiFuture<ListNotebookRuntimeTemplatesPage> createPageAsync(
        PageContext<
                ListNotebookRuntimeTemplatesRequest,
                ListNotebookRuntimeTemplatesResponse,
                NotebookRuntimeTemplate>
            context,
        ApiFuture<ListNotebookRuntimeTemplatesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNotebookRuntimeTemplatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNotebookRuntimeTemplatesRequest,
          ListNotebookRuntimeTemplatesResponse,
          NotebookRuntimeTemplate,
          ListNotebookRuntimeTemplatesPage,
          ListNotebookRuntimeTemplatesFixedSizeCollection> {

    private ListNotebookRuntimeTemplatesFixedSizeCollection(
        List<ListNotebookRuntimeTemplatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNotebookRuntimeTemplatesFixedSizeCollection createEmptyCollection() {
      return new ListNotebookRuntimeTemplatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNotebookRuntimeTemplatesFixedSizeCollection createCollection(
        List<ListNotebookRuntimeTemplatesPage> pages, int collectionSize) {
      return new ListNotebookRuntimeTemplatesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNotebookRuntimesPagedResponse
      extends AbstractPagedListResponse<
          ListNotebookRuntimesRequest,
          ListNotebookRuntimesResponse,
          NotebookRuntime,
          ListNotebookRuntimesPage,
          ListNotebookRuntimesFixedSizeCollection> {

    public static ApiFuture<ListNotebookRuntimesPagedResponse> createAsync(
        PageContext<ListNotebookRuntimesRequest, ListNotebookRuntimesResponse, NotebookRuntime>
            context,
        ApiFuture<ListNotebookRuntimesResponse> futureResponse) {
      ApiFuture<ListNotebookRuntimesPage> futurePage =
          ListNotebookRuntimesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListNotebookRuntimesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListNotebookRuntimesPagedResponse(ListNotebookRuntimesPage page) {
      super(page, ListNotebookRuntimesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNotebookRuntimesPage
      extends AbstractPage<
          ListNotebookRuntimesRequest,
          ListNotebookRuntimesResponse,
          NotebookRuntime,
          ListNotebookRuntimesPage> {

    private ListNotebookRuntimesPage(
        PageContext<ListNotebookRuntimesRequest, ListNotebookRuntimesResponse, NotebookRuntime>
            context,
        ListNotebookRuntimesResponse response) {
      super(context, response);
    }

    private static ListNotebookRuntimesPage createEmptyPage() {
      return new ListNotebookRuntimesPage(null, null);
    }

    @Override
    protected ListNotebookRuntimesPage createPage(
        PageContext<ListNotebookRuntimesRequest, ListNotebookRuntimesResponse, NotebookRuntime>
            context,
        ListNotebookRuntimesResponse response) {
      return new ListNotebookRuntimesPage(context, response);
    }

    @Override
    public ApiFuture<ListNotebookRuntimesPage> createPageAsync(
        PageContext<ListNotebookRuntimesRequest, ListNotebookRuntimesResponse, NotebookRuntime>
            context,
        ApiFuture<ListNotebookRuntimesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNotebookRuntimesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNotebookRuntimesRequest,
          ListNotebookRuntimesResponse,
          NotebookRuntime,
          ListNotebookRuntimesPage,
          ListNotebookRuntimesFixedSizeCollection> {

    private ListNotebookRuntimesFixedSizeCollection(
        List<ListNotebookRuntimesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNotebookRuntimesFixedSizeCollection createEmptyCollection() {
      return new ListNotebookRuntimesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNotebookRuntimesFixedSizeCollection createCollection(
        List<ListNotebookRuntimesPage> pages, int collectionSize) {
      return new ListNotebookRuntimesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListNotebookExecutionJobsPagedResponse
      extends AbstractPagedListResponse<
          ListNotebookExecutionJobsRequest,
          ListNotebookExecutionJobsResponse,
          NotebookExecutionJob,
          ListNotebookExecutionJobsPage,
          ListNotebookExecutionJobsFixedSizeCollection> {

    public static ApiFuture<ListNotebookExecutionJobsPagedResponse> createAsync(
        PageContext<
                ListNotebookExecutionJobsRequest,
                ListNotebookExecutionJobsResponse,
                NotebookExecutionJob>
            context,
        ApiFuture<ListNotebookExecutionJobsResponse> futureResponse) {
      ApiFuture<ListNotebookExecutionJobsPage> futurePage =
          ListNotebookExecutionJobsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListNotebookExecutionJobsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListNotebookExecutionJobsPagedResponse(ListNotebookExecutionJobsPage page) {
      super(page, ListNotebookExecutionJobsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNotebookExecutionJobsPage
      extends AbstractPage<
          ListNotebookExecutionJobsRequest,
          ListNotebookExecutionJobsResponse,
          NotebookExecutionJob,
          ListNotebookExecutionJobsPage> {

    private ListNotebookExecutionJobsPage(
        PageContext<
                ListNotebookExecutionJobsRequest,
                ListNotebookExecutionJobsResponse,
                NotebookExecutionJob>
            context,
        ListNotebookExecutionJobsResponse response) {
      super(context, response);
    }

    private static ListNotebookExecutionJobsPage createEmptyPage() {
      return new ListNotebookExecutionJobsPage(null, null);
    }

    @Override
    protected ListNotebookExecutionJobsPage createPage(
        PageContext<
                ListNotebookExecutionJobsRequest,
                ListNotebookExecutionJobsResponse,
                NotebookExecutionJob>
            context,
        ListNotebookExecutionJobsResponse response) {
      return new ListNotebookExecutionJobsPage(context, response);
    }

    @Override
    public ApiFuture<ListNotebookExecutionJobsPage> createPageAsync(
        PageContext<
                ListNotebookExecutionJobsRequest,
                ListNotebookExecutionJobsResponse,
                NotebookExecutionJob>
            context,
        ApiFuture<ListNotebookExecutionJobsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNotebookExecutionJobsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNotebookExecutionJobsRequest,
          ListNotebookExecutionJobsResponse,
          NotebookExecutionJob,
          ListNotebookExecutionJobsPage,
          ListNotebookExecutionJobsFixedSizeCollection> {

    private ListNotebookExecutionJobsFixedSizeCollection(
        List<ListNotebookExecutionJobsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNotebookExecutionJobsFixedSizeCollection createEmptyCollection() {
      return new ListNotebookExecutionJobsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNotebookExecutionJobsFixedSizeCollection createCollection(
        List<ListNotebookExecutionJobsPage> pages, int collectionSize) {
      return new ListNotebookExecutionJobsFixedSizeCollection(pages, collectionSize);
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
