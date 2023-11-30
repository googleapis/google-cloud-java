/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.config.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.config.v1.stub.ConfigStub;
import com.google.cloud.config.v1.stub.ConfigStubSettings;
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
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Infrastructure Manager is a managed service that automates the deployment
 * and management of Google Cloud infrastructure resources.
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
 * try (ConfigClient configClient = ConfigClient.create()) {
 *   DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
 *   Deployment response = configClient.getDeployment(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ConfigClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    <tr>
 *      <td>ListDeployments</td>
 *      <td><p>Lists [Deployment][google.cloud.config.v1.Deployment]s in a given project
 *  and location.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listDeployments(ListDeploymentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listDeployments(LocationName parent)
 *           <li>listDeployments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listDeploymentsPagedCallable()
 *           <li>listDeploymentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetDeployment</td>
 *      <td><p>Gets details about a [Deployment][google.cloud.config.v1.Deployment].</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getDeployment(GetDeploymentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getDeployment(DeploymentName name)
 *           <li>getDeployment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>CreateDeployment</td>
 *      <td><p>Creates a [Deployment][google.cloud.config.v1.Deployment].</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>createDeploymentAsync(CreateDeploymentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>createDeploymentAsync(LocationName parent, Deployment deployment, String deploymentId)
 *           <li>createDeploymentAsync(String parent, Deployment deployment, String deploymentId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>createDeploymentOperationCallable()
 *           <li>createDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UpdateDeployment</td>
 *      <td><p>Updates a [Deployment][google.cloud.config.v1.Deployment].</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>updateDeploymentAsync(UpdateDeploymentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>updateDeploymentAsync(Deployment deployment, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>updateDeploymentOperationCallable()
 *           <li>updateDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteDeployment</td>
 *      <td><p>Deletes a [Deployment][google.cloud.config.v1.Deployment].</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteDeploymentAsync(DeleteDeploymentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>deleteDeploymentAsync(DeploymentName name)
 *           <li>deleteDeploymentAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteDeploymentOperationCallable()
 *           <li>deleteDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListRevisions</td>
 *      <td><p>Lists [Revision][google.cloud.config.v1.Revision]s of a deployment.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listRevisions(ListRevisionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listRevisions(DeploymentName parent)
 *           <li>listRevisions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listRevisionsPagedCallable()
 *           <li>listRevisionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetRevision</td>
 *      <td><p>Gets details about a [Revision][google.cloud.config.v1.Revision].</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getRevision(GetRevisionRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getRevision(RevisionName name)
 *           <li>getRevision(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getRevisionCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetResource</td>
 *      <td><p>Gets details about a [Resource][google.cloud.config.v1.Resource] deployed
 *  by Infra Manager.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getResource(GetResourceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>getResource(ResourceName name)
 *           <li>getResource(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getResourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListResources</td>
 *      <td><p>Lists [Resource][google.cloud.config.v1.Resource]s in a given revision.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listResources(ListResourcesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>listResources(RevisionName parent)
 *           <li>listResources(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listResourcesPagedCallable()
 *           <li>listResourcesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ExportDeploymentStatefile</td>
 *      <td><p>Exports Terraform state file from a given deployment.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>exportDeploymentStatefile(ExportDeploymentStatefileRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>exportDeploymentStatefileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ExportRevisionStatefile</td>
 *      <td><p>Exports Terraform state file from a given revision.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>exportRevisionStatefile(ExportRevisionStatefileRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>exportRevisionStatefileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ImportStatefile</td>
 *      <td><p>Imports Terraform state file in a given deployment. The state file does not
 *  take effect until the Deployment has been unlocked.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>importStatefile(ImportStatefileRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>importStatefile(DeploymentName parent, long lockId)
 *           <li>importStatefile(String parent, long lockId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>importStatefileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>DeleteStatefile</td>
 *      <td><p>Deletes Terraform state file in a given deployment.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>deleteStatefile(DeleteStatefileRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>deleteStatefile(DeploymentName name)
 *           <li>deleteStatefile(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>deleteStatefileCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>LockDeployment</td>
 *      <td><p>Locks a deployment.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>lockDeploymentAsync(LockDeploymentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>lockDeploymentAsync(DeploymentName name)
 *           <li>lockDeploymentAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>lockDeploymentOperationCallable()
 *           <li>lockDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>UnlockDeployment</td>
 *      <td><p>Unlocks a locked deployment.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>unlockDeploymentAsync(UnlockDeploymentRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li>unlockDeploymentAsync(DeploymentName name, long lockId)
 *           <li>unlockDeploymentAsync(String name, long lockId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>unlockDeploymentOperationCallable()
 *           <li>unlockDeploymentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ExportLockInfo</td>
 *      <td><p>Exports the lock info on a locked deployment.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>exportLockInfo(ExportLockInfoRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li>exportLockInfo(DeploymentName name)
 *           <li>exportLockInfo(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>exportLockInfoCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>ListLocations</td>
 *      <td><p>Lists information about the supported locations for this service.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>listLocations(ListLocationsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>listLocationsPagedCallable()
 *           <li>listLocationsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetLocation</td>
 *      <td><p>Gets information about a location.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getLocation(GetLocationRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getLocationCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>SetIamPolicy</td>
 *      <td><p>Sets the access control policy on the specified resource. Replaces
 * any existing policy.
 *
 * Can return `NOT_FOUND`, `INVALID_ARGUMENT`, and `PERMISSION_DENIED`
 * errors.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>setIamPolicy(SetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>setIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>GetIamPolicy</td>
 *      <td><p>Gets the access control policy for a resource. Returns an empty policy
 * if the resource exists and does not have a policy set.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>getIamPolicy(GetIamPolicyRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>getIamPolicyCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td>TestIamPermissions</td>
 *      <td><p>Returns permissions that a caller has on the specified resource. If the
 * resource does not exist, this will return an empty set of
 * permissions, not a `NOT_FOUND` error.
 *
 * Note: This operation is designed to be used for building
 * permission-aware UIs and command-line tools, not for authorization
 * checking. This operation may "fail open" without warning.</p></td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li>testIamPermissions(TestIamPermissionsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li>testIamPermissionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    </tr>
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of ConfigSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ConfigSettings configSettings =
 *     ConfigSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ConfigClient configClient = ConfigClient.create(configSettings);
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
 * ConfigSettings configSettings = ConfigSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ConfigClient configClient = ConfigClient.create(configSettings);
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
 * ConfigSettings configSettings = ConfigSettings.newHttpJsonBuilder().build();
 * ConfigClient configClient = ConfigClient.create(configSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ConfigClient implements BackgroundResource {
  private final ConfigSettings settings;
  private final ConfigStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of ConfigClient with default settings. */
  public static final ConfigClient create() throws IOException {
    return create(ConfigSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ConfigClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ConfigClient create(ConfigSettings settings) throws IOException {
    return new ConfigClient(settings);
  }

  /**
   * Constructs an instance of ConfigClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(ConfigSettings).
   */
  public static final ConfigClient create(ConfigStub stub) {
    return new ConfigClient(stub);
  }

  /**
   * Constructs an instance of ConfigClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected ConfigClient(ConfigSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ConfigStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ConfigClient(ConfigStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ConfigSettings getSettings() {
    return settings;
  }

  public ConfigStub getStub() {
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
   * Lists [Deployment][google.cloud.config.v1.Deployment]s in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Deployment element : configClient.listDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the Deployments are listed. The parent
   *     value is in the format: 'projects/{project_id}/locations/{location}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeploymentsPagedResponse listDeployments(LocationName parent) {
    ListDeploymentsRequest request =
        ListDeploymentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Deployment][google.cloud.config.v1.Deployment]s in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Deployment element : configClient.listDeployments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the Deployments are listed. The parent
   *     value is in the format: 'projects/{project_id}/locations/{location}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeploymentsPagedResponse listDeployments(String parent) {
    ListDeploymentsRequest request = ListDeploymentsRequest.newBuilder().setParent(parent).build();
    return listDeployments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Deployment][google.cloud.config.v1.Deployment]s in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListDeploymentsRequest request =
   *       ListDeploymentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Deployment element : configClient.listDeployments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDeploymentsPagedResponse listDeployments(ListDeploymentsRequest request) {
    return listDeploymentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Deployment][google.cloud.config.v1.Deployment]s in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListDeploymentsRequest request =
   *       ListDeploymentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Deployment> future =
   *       configClient.listDeploymentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Deployment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDeploymentsRequest, ListDeploymentsPagedResponse>
      listDeploymentsPagedCallable() {
    return stub.listDeploymentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Deployment][google.cloud.config.v1.Deployment]s in a given project and location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListDeploymentsRequest request =
   *       ListDeploymentsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDeploymentsResponse response = configClient.listDeploymentsCallable().call(request);
   *     for (Deployment element : response.getDeploymentsList()) {
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
  public final UnaryCallable<ListDeploymentsRequest, ListDeploymentsResponse>
      listDeploymentsCallable() {
    return stub.listDeploymentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
   *   Deployment response = configClient.getDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment. Format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment getDeployment(DeploymentName name) {
    GetDeploymentRequest request =
        GetDeploymentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString();
   *   Deployment response = configClient.getDeployment(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment. Format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment getDeployment(String name) {
    GetDeploymentRequest request = GetDeploymentRequest.newBuilder().setName(name).build();
    return getDeployment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetDeploymentRequest request =
   *       GetDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   Deployment response = configClient.getDeployment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Deployment getDeployment(GetDeploymentRequest request) {
    return getDeploymentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetDeploymentRequest request =
   *       GetDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   ApiFuture<Deployment> future = configClient.getDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDeploymentRequest, Deployment> getDeploymentCallable() {
    return stub.getDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Deployment deployment = Deployment.newBuilder().build();
   *   String deploymentId = "deploymentId-136894784";
   *   Deployment response =
   *       configClient.createDeploymentAsync(parent, deployment, deploymentId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the Deployment is created. The parent value
   *     is in the format: 'projects/{project_id}/locations/{location}'.
   * @param deployment Required. [Deployment][google.cloud.config.v1.Deployment] resource to be
   *     created.
   * @param deploymentId Required. The Deployment ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> createDeploymentAsync(
      LocationName parent, Deployment deployment, String deploymentId) {
    CreateDeploymentRequest request =
        CreateDeploymentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDeployment(deployment)
            .setDeploymentId(deploymentId)
            .build();
    return createDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Deployment deployment = Deployment.newBuilder().build();
   *   String deploymentId = "deploymentId-136894784";
   *   Deployment response =
   *       configClient.createDeploymentAsync(parent, deployment, deploymentId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the Deployment is created. The parent value
   *     is in the format: 'projects/{project_id}/locations/{location}'.
   * @param deployment Required. [Deployment][google.cloud.config.v1.Deployment] resource to be
   *     created.
   * @param deploymentId Required. The Deployment ID.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> createDeploymentAsync(
      String parent, Deployment deployment, String deploymentId) {
    CreateDeploymentRequest request =
        CreateDeploymentRequest.newBuilder()
            .setParent(parent)
            .setDeployment(deployment)
            .setDeploymentId(deploymentId)
            .build();
    return createDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateDeploymentRequest request =
   *       CreateDeploymentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDeploymentId("deploymentId-136894784")
   *           .setDeployment(Deployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Deployment response = configClient.createDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> createDeploymentAsync(
      CreateDeploymentRequest request) {
    return createDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateDeploymentRequest request =
   *       CreateDeploymentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDeploymentId("deploymentId-136894784")
   *           .setDeployment(Deployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Deployment, OperationMetadata> future =
   *       configClient.createDeploymentOperationCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateDeploymentRequest, Deployment, OperationMetadata>
      createDeploymentOperationCallable() {
    return stub.createDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   CreateDeploymentRequest request =
   *       CreateDeploymentRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setDeploymentId("deploymentId-136894784")
   *           .setDeployment(Deployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = configClient.createDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDeploymentRequest, Operation> createDeploymentCallable() {
    return stub.createDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   Deployment deployment = Deployment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Deployment response = configClient.updateDeploymentAsync(deployment, updateMask).get();
   * }
   * }</pre>
   *
   * @param deployment Required. [Deployment][google.cloud.config.v1.Deployment] to update.
   *     <p>The deployment's `name` field is used to identify the resource to be updated. Format:
   *     `projects/{project}/locations/{location}/deployments/{deployment}`
   * @param updateMask Optional. Field mask used to specify the fields to be overwritten in the
   *     Deployment resource by the update.
   *     <p>The fields specified in the update_mask are relative to the resource, not the full
   *     request. A field will be overwritten if it is in the mask. If the user does not provide a
   *     mask then all fields will be overwritten.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> updateDeploymentAsync(
      Deployment deployment, FieldMask updateMask) {
    UpdateDeploymentRequest request =
        UpdateDeploymentRequest.newBuilder()
            .setDeployment(deployment)
            .setUpdateMask(updateMask)
            .build();
    return updateDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateDeploymentRequest request =
   *       UpdateDeploymentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDeployment(Deployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Deployment response = configClient.updateDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> updateDeploymentAsync(
      UpdateDeploymentRequest request) {
    return updateDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateDeploymentRequest request =
   *       UpdateDeploymentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDeployment(Deployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Deployment, OperationMetadata> future =
   *       configClient.updateDeploymentOperationCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateDeploymentRequest, Deployment, OperationMetadata>
      updateDeploymentOperationCallable() {
    return stub.updateDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UpdateDeploymentRequest request =
   *       UpdateDeploymentRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setDeployment(Deployment.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = configClient.updateDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDeploymentRequest, Operation> updateDeploymentCallable() {
    return stub.updateDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
   *   Deployment response = configClient.deleteDeploymentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Deployment in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> deleteDeploymentAsync(
      DeploymentName name) {
    DeleteDeploymentRequest request =
        DeleteDeploymentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString();
   *   Deployment response = configClient.deleteDeploymentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the Deployment in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> deleteDeploymentAsync(String name) {
    DeleteDeploymentRequest request = DeleteDeploymentRequest.newBuilder().setName(name).build();
    return deleteDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteDeploymentRequest request =
   *       DeleteDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   Deployment response = configClient.deleteDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> deleteDeploymentAsync(
      DeleteDeploymentRequest request) {
    return deleteDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteDeploymentRequest request =
   *       DeleteDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Deployment, OperationMetadata> future =
   *       configClient.deleteDeploymentOperationCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteDeploymentRequest, Deployment, OperationMetadata>
      deleteDeploymentOperationCallable() {
    return stub.deleteDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a [Deployment][google.cloud.config.v1.Deployment].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteDeploymentRequest request =
   *       DeleteDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future = configClient.deleteDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDeploymentRequest, Operation> deleteDeploymentCallable() {
    return stub.deleteDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Revision][google.cloud.config.v1.Revision]s of a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeploymentName parent = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
   *   for (Revision element : configClient.listRevisions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the Revisions are listed. The parent value
   *     is in the format: 'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRevisionsPagedResponse listRevisions(DeploymentName parent) {
    ListRevisionsRequest request =
        ListRevisionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Revision][google.cloud.config.v1.Revision]s of a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString();
   *   for (Revision element : configClient.listRevisions(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the Revisions are listed. The parent value
   *     is in the format: 'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRevisionsPagedResponse listRevisions(String parent) {
    ListRevisionsRequest request = ListRevisionsRequest.newBuilder().setParent(parent).build();
    return listRevisions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Revision][google.cloud.config.v1.Revision]s of a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListRevisionsRequest request =
   *       ListRevisionsRequest.newBuilder()
   *           .setParent(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Revision element : configClient.listRevisions(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRevisionsPagedResponse listRevisions(ListRevisionsRequest request) {
    return listRevisionsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Revision][google.cloud.config.v1.Revision]s of a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListRevisionsRequest request =
   *       ListRevisionsRequest.newBuilder()
   *           .setParent(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Revision> future = configClient.listRevisionsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Revision element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRevisionsRequest, ListRevisionsPagedResponse>
      listRevisionsPagedCallable() {
    return stub.listRevisionsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Revision][google.cloud.config.v1.Revision]s of a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListRevisionsRequest request =
   *       ListRevisionsRequest.newBuilder()
   *           .setParent(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListRevisionsResponse response = configClient.listRevisionsCallable().call(request);
   *     for (Revision element : response.getRevisionsList()) {
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
  public final UnaryCallable<ListRevisionsRequest, ListRevisionsResponse> listRevisionsCallable() {
    return stub.listRevisionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Revision][google.cloud.config.v1.Revision].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   RevisionName name = RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]");
   *   Revision response = configClient.getRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Revision in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}/revisions/{revision}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Revision getRevision(RevisionName name) {
    GetRevisionRequest request =
        GetRevisionRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Revision][google.cloud.config.v1.Revision].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name =
   *       RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]").toString();
   *   Revision response = configClient.getRevision(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Revision in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}/revisions/{revision}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Revision getRevision(String name) {
    GetRevisionRequest request = GetRevisionRequest.newBuilder().setName(name).build();
    return getRevision(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Revision][google.cloud.config.v1.Revision].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetRevisionRequest request =
   *       GetRevisionRequest.newBuilder()
   *           .setName(
   *               RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]")
   *                   .toString())
   *           .build();
   *   Revision response = configClient.getRevision(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Revision getRevision(GetRevisionRequest request) {
    return getRevisionCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Revision][google.cloud.config.v1.Revision].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetRevisionRequest request =
   *       GetRevisionRequest.newBuilder()
   *           .setName(
   *               RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Revision> future = configClient.getRevisionCallable().futureCall(request);
   *   // Do something.
   *   Revision response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRevisionRequest, Revision> getRevisionCallable() {
    return stub.getRevisionCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Resource][google.cloud.config.v1.Resource] deployed by Infra Manager.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ResourceName name =
   *       ResourceName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]", "[RESOURCE]");
   *   Resource response = configClient.getResource(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Resource in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}/revisions/{revision}/resource/{resource}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Resource getResource(ResourceName name) {
    GetResourceRequest request =
        GetResourceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getResource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Resource][google.cloud.config.v1.Resource] deployed by Infra Manager.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name =
   *       ResourceName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]", "[RESOURCE]")
   *           .toString();
   *   Resource response = configClient.getResource(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the Resource in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}/revisions/{revision}/resource/{resource}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Resource getResource(String name) {
    GetResourceRequest request = GetResourceRequest.newBuilder().setName(name).build();
    return getResource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Resource][google.cloud.config.v1.Resource] deployed by Infra Manager.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetResourceRequest request =
   *       GetResourceRequest.newBuilder()
   *           .setName(
   *               ResourceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]", "[RESOURCE]")
   *                   .toString())
   *           .build();
   *   Resource response = configClient.getResource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Resource getResource(GetResourceRequest request) {
    return getResourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about a [Resource][google.cloud.config.v1.Resource] deployed by Infra Manager.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetResourceRequest request =
   *       GetResourceRequest.newBuilder()
   *           .setName(
   *               ResourceName.of(
   *                       "[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]", "[RESOURCE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Resource> future = configClient.getResourceCallable().futureCall(request);
   *   // Do something.
   *   Resource response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetResourceRequest, Resource> getResourceCallable() {
    return stub.getResourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Resource][google.cloud.config.v1.Resource]s in a given revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   RevisionName parent =
   *       RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]");
   *   for (Resource element : configClient.listResources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the Resources are listed. The parent value
   *     is in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}/revisions/{revision}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourcesPagedResponse listResources(RevisionName parent) {
    ListResourcesRequest request =
        ListResourcesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Resource][google.cloud.config.v1.Resource]s in a given revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent =
   *       RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]").toString();
   *   for (Resource element : configClient.listResources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the Resources are listed. The parent value
   *     is in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}/revisions/{revision}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourcesPagedResponse listResources(String parent) {
    ListResourcesRequest request = ListResourcesRequest.newBuilder().setParent(parent).build();
    return listResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Resource][google.cloud.config.v1.Resource]s in a given revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListResourcesRequest request =
   *       ListResourcesRequest.newBuilder()
   *           .setParent(
   *               RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Resource element : configClient.listResources(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListResourcesPagedResponse listResources(ListResourcesRequest request) {
    return listResourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Resource][google.cloud.config.v1.Resource]s in a given revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListResourcesRequest request =
   *       ListResourcesRequest.newBuilder()
   *           .setParent(
   *               RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Resource> future = configClient.listResourcesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Resource element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListResourcesRequest, ListResourcesPagedResponse>
      listResourcesPagedCallable() {
    return stub.listResourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [Resource][google.cloud.config.v1.Resource]s in a given revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListResourcesRequest request =
   *       ListResourcesRequest.newBuilder()
   *           .setParent(
   *               RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListResourcesResponse response = configClient.listResourcesCallable().call(request);
   *     for (Resource element : response.getResourcesList()) {
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
  public final UnaryCallable<ListResourcesRequest, ListResourcesResponse> listResourcesCallable() {
    return stub.listResourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports Terraform state file from a given deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ExportDeploymentStatefileRequest request =
   *       ExportDeploymentStatefileRequest.newBuilder()
   *           .setParent(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setDraft(true)
   *           .build();
   *   Statefile response = configClient.exportDeploymentStatefile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Statefile exportDeploymentStatefile(ExportDeploymentStatefileRequest request) {
    return exportDeploymentStatefileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports Terraform state file from a given deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ExportDeploymentStatefileRequest request =
   *       ExportDeploymentStatefileRequest.newBuilder()
   *           .setParent(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setDraft(true)
   *           .build();
   *   ApiFuture<Statefile> future =
   *       configClient.exportDeploymentStatefileCallable().futureCall(request);
   *   // Do something.
   *   Statefile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportDeploymentStatefileRequest, Statefile>
      exportDeploymentStatefileCallable() {
    return stub.exportDeploymentStatefileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports Terraform state file from a given revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ExportRevisionStatefileRequest request =
   *       ExportRevisionStatefileRequest.newBuilder()
   *           .setParent(
   *               RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]")
   *                   .toString())
   *           .build();
   *   Statefile response = configClient.exportRevisionStatefile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Statefile exportRevisionStatefile(ExportRevisionStatefileRequest request) {
    return exportRevisionStatefileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports Terraform state file from a given revision.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ExportRevisionStatefileRequest request =
   *       ExportRevisionStatefileRequest.newBuilder()
   *           .setParent(
   *               RevisionName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]", "[REVISION]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Statefile> future =
   *       configClient.exportRevisionStatefileCallable().futureCall(request);
   *   // Do something.
   *   Statefile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportRevisionStatefileRequest, Statefile>
      exportRevisionStatefileCallable() {
    return stub.exportRevisionStatefileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports Terraform state file in a given deployment. The state file does not take effect until
   * the Deployment has been unlocked.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeploymentName parent = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
   *   long lockId = 338696367;
   *   Statefile response = configClient.importStatefile(parent, lockId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the statefile is listed. The parent value
   *     is in the format: 'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @param lockId Required. Lock ID of the lock file to verify that the user who is importing the
   *     state file previously locked the Deployment.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Statefile importStatefile(DeploymentName parent, long lockId) {
    ImportStatefileRequest request =
        ImportStatefileRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setLockId(lockId)
            .build();
    return importStatefile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports Terraform state file in a given deployment. The state file does not take effect until
   * the Deployment has been unlocked.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String parent = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString();
   *   long lockId = 338696367;
   *   Statefile response = configClient.importStatefile(parent, lockId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent in whose context the statefile is listed. The parent value
   *     is in the format: 'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @param lockId Required. Lock ID of the lock file to verify that the user who is importing the
   *     state file previously locked the Deployment.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Statefile importStatefile(String parent, long lockId) {
    ImportStatefileRequest request =
        ImportStatefileRequest.newBuilder().setParent(parent).setLockId(lockId).build();
    return importStatefile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports Terraform state file in a given deployment. The state file does not take effect until
   * the Deployment has been unlocked.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ImportStatefileRequest request =
   *       ImportStatefileRequest.newBuilder()
   *           .setParent(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setLockId(338696367)
   *           .setSkipDraft(true)
   *           .build();
   *   Statefile response = configClient.importStatefile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Statefile importStatefile(ImportStatefileRequest request) {
    return importStatefileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports Terraform state file in a given deployment. The state file does not take effect until
   * the Deployment has been unlocked.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ImportStatefileRequest request =
   *       ImportStatefileRequest.newBuilder()
   *           .setParent(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setLockId(338696367)
   *           .setSkipDraft(true)
   *           .build();
   *   ApiFuture<Statefile> future = configClient.importStatefileCallable().futureCall(request);
   *   // Do something.
   *   Statefile response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportStatefileRequest, Statefile> importStatefileCallable() {
    return stub.importStatefileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes Terraform state file in a given deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
   *   configClient.deleteStatefile(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteStatefile(DeploymentName name) {
    DeleteStatefileRequest request =
        DeleteStatefileRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteStatefile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes Terraform state file in a given deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString();
   *   configClient.deleteStatefile(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteStatefile(String name) {
    DeleteStatefileRequest request = DeleteStatefileRequest.newBuilder().setName(name).build();
    deleteStatefile(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes Terraform state file in a given deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteStatefileRequest request =
   *       DeleteStatefileRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setLockId(338696367)
   *           .build();
   *   configClient.deleteStatefile(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteStatefile(DeleteStatefileRequest request) {
    deleteStatefileCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes Terraform state file in a given deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeleteStatefileRequest request =
   *       DeleteStatefileRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setLockId(338696367)
   *           .build();
   *   ApiFuture<Empty> future = configClient.deleteStatefileCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteStatefileRequest, Empty> deleteStatefileCallable() {
    return stub.deleteStatefileCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Locks a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
   *   Deployment response = configClient.lockDeploymentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> lockDeploymentAsync(
      DeploymentName name) {
    LockDeploymentRequest request =
        LockDeploymentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return lockDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Locks a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString();
   *   Deployment response = configClient.lockDeploymentAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> lockDeploymentAsync(String name) {
    LockDeploymentRequest request = LockDeploymentRequest.newBuilder().setName(name).build();
    return lockDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Locks a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LockDeploymentRequest request =
   *       LockDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   Deployment response = configClient.lockDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> lockDeploymentAsync(
      LockDeploymentRequest request) {
    return lockDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Locks a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LockDeploymentRequest request =
   *       LockDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   OperationFuture<Deployment, OperationMetadata> future =
   *       configClient.lockDeploymentOperationCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<LockDeploymentRequest, Deployment, OperationMetadata>
      lockDeploymentOperationCallable() {
    return stub.lockDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Locks a deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   LockDeploymentRequest request =
   *       LockDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   ApiFuture<Operation> future = configClient.lockDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<LockDeploymentRequest, Operation> lockDeploymentCallable() {
    return stub.lockDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unlocks a locked deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
   *   long lockId = 338696367;
   *   Deployment response = configClient.unlockDeploymentAsync(name, lockId).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @param lockId Required. Lock ID of the lock file to be unlocked.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> unlockDeploymentAsync(
      DeploymentName name, long lockId) {
    UnlockDeploymentRequest request =
        UnlockDeploymentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setLockId(lockId)
            .build();
    return unlockDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unlocks a locked deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString();
   *   long lockId = 338696367;
   *   Deployment response = configClient.unlockDeploymentAsync(name, lockId).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @param lockId Required. Lock ID of the lock file to be unlocked.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> unlockDeploymentAsync(
      String name, long lockId) {
    UnlockDeploymentRequest request =
        UnlockDeploymentRequest.newBuilder().setName(name).setLockId(lockId).build();
    return unlockDeploymentAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unlocks a locked deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UnlockDeploymentRequest request =
   *       UnlockDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setLockId(338696367)
   *           .build();
   *   Deployment response = configClient.unlockDeploymentAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Deployment, OperationMetadata> unlockDeploymentAsync(
      UnlockDeploymentRequest request) {
    return unlockDeploymentOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unlocks a locked deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UnlockDeploymentRequest request =
   *       UnlockDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setLockId(338696367)
   *           .build();
   *   OperationFuture<Deployment, OperationMetadata> future =
   *       configClient.unlockDeploymentOperationCallable().futureCall(request);
   *   // Do something.
   *   Deployment response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UnlockDeploymentRequest, Deployment, OperationMetadata>
      unlockDeploymentOperationCallable() {
    return stub.unlockDeploymentOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Unlocks a locked deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   UnlockDeploymentRequest request =
   *       UnlockDeploymentRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setLockId(338696367)
   *           .build();
   *   ApiFuture<Operation> future = configClient.unlockDeploymentCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UnlockDeploymentRequest, Operation> unlockDeploymentCallable() {
    return stub.unlockDeploymentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the lock info on a locked deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   DeploymentName name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]");
   *   LockInfo response = configClient.exportLockInfo(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LockInfo exportLockInfo(DeploymentName name) {
    ExportLockInfoRequest request =
        ExportLockInfoRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return exportLockInfo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the lock info on a locked deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   String name = DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString();
   *   LockInfo response = configClient.exportLockInfo(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the deployment in the format:
   *     'projects/{project_id}/locations/{location}/deployments/{deployment}'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LockInfo exportLockInfo(String name) {
    ExportLockInfoRequest request = ExportLockInfoRequest.newBuilder().setName(name).build();
    return exportLockInfo(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the lock info on a locked deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ExportLockInfoRequest request =
   *       ExportLockInfoRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   LockInfo response = configClient.exportLockInfo(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LockInfo exportLockInfo(ExportLockInfoRequest request) {
    return exportLockInfoCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the lock info on a locked deployment.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ExportLockInfoRequest request =
   *       ExportLockInfoRequest.newBuilder()
   *           .setName(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .build();
   *   ApiFuture<LockInfo> future = configClient.exportLockInfoCallable().futureCall(request);
   *   // Do something.
   *   LockInfo response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportLockInfoRequest, LockInfo> exportLockInfoCallable() {
    return stub.exportLockInfoCallable();
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : configClient.listLocations(request).iterateAll()) {
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future = configClient.listLocationsPagedCallable().futureCall(request);
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = configClient.listLocationsCallable().call(request);
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = configClient.getLocation(request);
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = configClient.getLocationCallable().futureCall(request);
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = configClient.setIamPolicy(request);
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = configClient.setIamPolicyCallable().futureCall(request);
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = configClient.getIamPolicy(request);
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = configClient.getIamPolicyCallable().futureCall(request);
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = configClient.testIamPermissions(request);
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
   * try (ConfigClient configClient = ConfigClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(DeploymentName.of("[PROJECT]", "[LOCATION]", "[DEPLOYMENT]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       configClient.testIamPermissionsCallable().futureCall(request);
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

  public static class ListDeploymentsPagedResponse
      extends AbstractPagedListResponse<
          ListDeploymentsRequest,
          ListDeploymentsResponse,
          Deployment,
          ListDeploymentsPage,
          ListDeploymentsFixedSizeCollection> {

    public static ApiFuture<ListDeploymentsPagedResponse> createAsync(
        PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> context,
        ApiFuture<ListDeploymentsResponse> futureResponse) {
      ApiFuture<ListDeploymentsPage> futurePage =
          ListDeploymentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDeploymentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDeploymentsPagedResponse(ListDeploymentsPage page) {
      super(page, ListDeploymentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDeploymentsPage
      extends AbstractPage<
          ListDeploymentsRequest, ListDeploymentsResponse, Deployment, ListDeploymentsPage> {

    private ListDeploymentsPage(
        PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> context,
        ListDeploymentsResponse response) {
      super(context, response);
    }

    private static ListDeploymentsPage createEmptyPage() {
      return new ListDeploymentsPage(null, null);
    }

    @Override
    protected ListDeploymentsPage createPage(
        PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> context,
        ListDeploymentsResponse response) {
      return new ListDeploymentsPage(context, response);
    }

    @Override
    public ApiFuture<ListDeploymentsPage> createPageAsync(
        PageContext<ListDeploymentsRequest, ListDeploymentsResponse, Deployment> context,
        ApiFuture<ListDeploymentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDeploymentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDeploymentsRequest,
          ListDeploymentsResponse,
          Deployment,
          ListDeploymentsPage,
          ListDeploymentsFixedSizeCollection> {

    private ListDeploymentsFixedSizeCollection(
        List<ListDeploymentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDeploymentsFixedSizeCollection createEmptyCollection() {
      return new ListDeploymentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDeploymentsFixedSizeCollection createCollection(
        List<ListDeploymentsPage> pages, int collectionSize) {
      return new ListDeploymentsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListRevisionsPagedResponse
      extends AbstractPagedListResponse<
          ListRevisionsRequest,
          ListRevisionsResponse,
          Revision,
          ListRevisionsPage,
          ListRevisionsFixedSizeCollection> {

    public static ApiFuture<ListRevisionsPagedResponse> createAsync(
        PageContext<ListRevisionsRequest, ListRevisionsResponse, Revision> context,
        ApiFuture<ListRevisionsResponse> futureResponse) {
      ApiFuture<ListRevisionsPage> futurePage =
          ListRevisionsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListRevisionsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListRevisionsPagedResponse(ListRevisionsPage page) {
      super(page, ListRevisionsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRevisionsPage
      extends AbstractPage<
          ListRevisionsRequest, ListRevisionsResponse, Revision, ListRevisionsPage> {

    private ListRevisionsPage(
        PageContext<ListRevisionsRequest, ListRevisionsResponse, Revision> context,
        ListRevisionsResponse response) {
      super(context, response);
    }

    private static ListRevisionsPage createEmptyPage() {
      return new ListRevisionsPage(null, null);
    }

    @Override
    protected ListRevisionsPage createPage(
        PageContext<ListRevisionsRequest, ListRevisionsResponse, Revision> context,
        ListRevisionsResponse response) {
      return new ListRevisionsPage(context, response);
    }

    @Override
    public ApiFuture<ListRevisionsPage> createPageAsync(
        PageContext<ListRevisionsRequest, ListRevisionsResponse, Revision> context,
        ApiFuture<ListRevisionsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRevisionsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRevisionsRequest,
          ListRevisionsResponse,
          Revision,
          ListRevisionsPage,
          ListRevisionsFixedSizeCollection> {

    private ListRevisionsFixedSizeCollection(List<ListRevisionsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRevisionsFixedSizeCollection createEmptyCollection() {
      return new ListRevisionsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRevisionsFixedSizeCollection createCollection(
        List<ListRevisionsPage> pages, int collectionSize) {
      return new ListRevisionsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListResourcesPagedResponse
      extends AbstractPagedListResponse<
          ListResourcesRequest,
          ListResourcesResponse,
          Resource,
          ListResourcesPage,
          ListResourcesFixedSizeCollection> {

    public static ApiFuture<ListResourcesPagedResponse> createAsync(
        PageContext<ListResourcesRequest, ListResourcesResponse, Resource> context,
        ApiFuture<ListResourcesResponse> futureResponse) {
      ApiFuture<ListResourcesPage> futurePage =
          ListResourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListResourcesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListResourcesPagedResponse(ListResourcesPage page) {
      super(page, ListResourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListResourcesPage
      extends AbstractPage<
          ListResourcesRequest, ListResourcesResponse, Resource, ListResourcesPage> {

    private ListResourcesPage(
        PageContext<ListResourcesRequest, ListResourcesResponse, Resource> context,
        ListResourcesResponse response) {
      super(context, response);
    }

    private static ListResourcesPage createEmptyPage() {
      return new ListResourcesPage(null, null);
    }

    @Override
    protected ListResourcesPage createPage(
        PageContext<ListResourcesRequest, ListResourcesResponse, Resource> context,
        ListResourcesResponse response) {
      return new ListResourcesPage(context, response);
    }

    @Override
    public ApiFuture<ListResourcesPage> createPageAsync(
        PageContext<ListResourcesRequest, ListResourcesResponse, Resource> context,
        ApiFuture<ListResourcesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListResourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListResourcesRequest,
          ListResourcesResponse,
          Resource,
          ListResourcesPage,
          ListResourcesFixedSizeCollection> {

    private ListResourcesFixedSizeCollection(List<ListResourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListResourcesFixedSizeCollection createEmptyCollection() {
      return new ListResourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListResourcesFixedSizeCollection createCollection(
        List<ListResourcesPage> pages, int collectionSize) {
      return new ListResourcesFixedSizeCollection(pages, collectionSize);
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
