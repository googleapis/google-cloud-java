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

package com.google.cloud.compute.v1;

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
import com.google.cloud.compute.v1.stub.ProjectsStub;
import com.google.cloud.compute.v1.stub.ProjectsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Projects API.
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
 * try (ProjectsClient projectsClient = ProjectsClient.create()) {
 *   String project = "project-309310695";
 *   Project response = projectsClient.get(project);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ProjectsClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> DisableXpnHost</td>
 *      <td><p> Disable this project as a shared VPC host project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> disableXpnHostAsync(DisableXpnHostProjectRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> disableXpnHostAsync(String project)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> disableXpnHostOperationCallable()
 *           <li><p> disableXpnHostCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DisableXpnResource</td>
 *      <td><p> Disable a service resource (also known as service project) associated with this host project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> disableXpnResourceAsync(DisableXpnResourceProjectRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> disableXpnResourceAsync(String project, ProjectsDisableXpnResourceRequest projectsDisableXpnResourceRequestResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> disableXpnResourceOperationCallable()
 *           <li><p> disableXpnResourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> EnableXpnHost</td>
 *      <td><p> Enable this project as a shared VPC host project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> enableXpnHostAsync(EnableXpnHostProjectRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> enableXpnHostAsync(String project)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> enableXpnHostOperationCallable()
 *           <li><p> enableXpnHostCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> EnableXpnResource</td>
 *      <td><p> Enable service resource (a.k.a service project) for a host project, so that subnets in the host project can be used by instances in the service project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> enableXpnResourceAsync(EnableXpnResourceProjectRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> enableXpnResourceAsync(String project, ProjectsEnableXpnResourceRequest projectsEnableXpnResourceRequestResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> enableXpnResourceOperationCallable()
 *           <li><p> enableXpnResourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Get</td>
 *      <td><p> Returns the specified Project resource. To decrease latency for this method, you can optionally omit any unneeded information from the response by using a field mask. This practice is especially recommended for unused quota information (the `quotas` field). To exclude one or more fields, set your request's `fields` query parameter to only include the fields you need. For example, to only include the `id` and `selfLink` fields, add the query parameter `?fields=id,selfLink` to your request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetProjectRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetXpnHost</td>
 *      <td><p> Gets the shared VPC host project that this project links to. May be empty if no link exists.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getXpnHost(GetXpnHostProjectRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getXpnHost(String project)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getXpnHostCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetXpnResources</td>
 *      <td><p> Gets service resources (a.k.a service project) associated with this host project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getXpnResources(GetXpnResourcesProjectsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getXpnResources(String project)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getXpnResourcesPagedCallable()
 *           <li><p> getXpnResourcesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListXpnHosts</td>
 *      <td><p> Lists all shared VPC host projects visible to the user in an organization.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listXpnHosts(ListXpnHostsProjectsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listXpnHosts(String project, ProjectsListXpnHostsRequest projectsListXpnHostsRequestResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listXpnHostsPagedCallable()
 *           <li><p> listXpnHostsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> MoveDisk</td>
 *      <td><p> Moves a persistent disk from one zone to another.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> moveDiskAsync(MoveDiskProjectRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> moveDiskAsync(String project, DiskMoveRequest diskMoveRequestResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> moveDiskOperationCallable()
 *           <li><p> moveDiskCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> MoveInstance</td>
 *      <td><p> Moves an instance and its attached persistent disks from one zone to another. &#42;Note&#42;: Moving VMs or disks by using this method might cause unexpected behavior. For more information, see the [known issue](/compute/docs/troubleshooting/known-issues#moving_vms_or_disks_using_the_moveinstance_api_or_the_causes_unexpected_behavior). [Deprecated] This method is deprecated. See [moving instance across zones](/compute/docs/instances/moving-instance-across-zones) instead.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> moveInstanceAsync(MoveInstanceProjectRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> moveInstanceAsync(String project, InstanceMoveRequest instanceMoveRequestResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> moveInstanceOperationCallable()
 *           <li><p> moveInstanceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetCloudArmorTier</td>
 *      <td><p> Sets the Cloud Armor tier of the project. To set ENTERPRISE or above the billing account of the project must be subscribed to Cloud Armor Enterprise. See Subscribing to Cloud Armor Enterprise for more information.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setCloudArmorTierAsync(SetCloudArmorTierProjectRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> setCloudArmorTierAsync(String project, ProjectsSetCloudArmorTierRequest projectsSetCloudArmorTierRequestResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setCloudArmorTierOperationCallable()
 *           <li><p> setCloudArmorTierCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetCommonInstanceMetadata</td>
 *      <td><p> Sets metadata common to all instances within the specified project using the data included in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setCommonInstanceMetadataAsync(SetCommonInstanceMetadataProjectRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> setCommonInstanceMetadataAsync(String project, Metadata metadataResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setCommonInstanceMetadataOperationCallable()
 *           <li><p> setCommonInstanceMetadataCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetDefaultNetworkTier</td>
 *      <td><p> Sets the default network tier of the project. The default network tier is used when an address/forwardingRule/instance is created without specifying the network tier field.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setDefaultNetworkTierAsync(SetDefaultNetworkTierProjectRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> setDefaultNetworkTierAsync(String project, ProjectsSetDefaultNetworkTierRequest projectsSetDefaultNetworkTierRequestResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setDefaultNetworkTierOperationCallable()
 *           <li><p> setDefaultNetworkTierCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> SetUsageExportBucket</td>
 *      <td><p> Enables the usage export feature and sets the usage export bucket where reports are stored. If you provide an empty request body using this method, the usage export feature will be disabled.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> setUsageExportBucketAsync(SetUsageExportBucketProjectRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> setUsageExportBucketAsync(String project, UsageExportLocation usageExportLocationResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> setUsageExportBucketOperationCallable()
 *           <li><p> setUsageExportBucketCallable()
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
 * <p>This class can be customized by passing in a custom instance of ProjectsSettings to create().
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
 * ProjectsSettings projectsSettings =
 *     ProjectsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ProjectsClient projectsClient = ProjectsClient.create(projectsSettings);
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
 * ProjectsSettings projectsSettings =
 *     ProjectsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ProjectsClient projectsClient = ProjectsClient.create(projectsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ProjectsClient implements BackgroundResource {
  private final ProjectsSettings settings;
  private final ProjectsStub stub;

  /** Constructs an instance of ProjectsClient with default settings. */
  public static final ProjectsClient create() throws IOException {
    return create(ProjectsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ProjectsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ProjectsClient create(ProjectsSettings settings) throws IOException {
    return new ProjectsClient(settings);
  }

  /**
   * Constructs an instance of ProjectsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(ProjectsSettings).
   */
  public static final ProjectsClient create(ProjectsStub stub) {
    return new ProjectsClient(stub);
  }

  /**
   * Constructs an instance of ProjectsClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected ProjectsClient(ProjectsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ProjectsStubSettings) settings.getStubSettings()).createStub();
  }

  protected ProjectsClient(ProjectsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ProjectsSettings getSettings() {
    return settings;
  }

  public ProjectsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable this project as a shared VPC host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "project-309310695";
   *   Operation response = projectsClient.disableXpnHostAsync(project).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> disableXpnHostAsync(String project) {
    DisableXpnHostProjectRequest request =
        DisableXpnHostProjectRequest.newBuilder().setProject(project).build();
    return disableXpnHostAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable this project as a shared VPC host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   DisableXpnHostProjectRequest request =
   *       DisableXpnHostProjectRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = projectsClient.disableXpnHostAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> disableXpnHostAsync(
      DisableXpnHostProjectRequest request) {
    return disableXpnHostOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable this project as a shared VPC host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   DisableXpnHostProjectRequest request =
   *       DisableXpnHostProjectRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       projectsClient.disableXpnHostOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DisableXpnHostProjectRequest, Operation, Operation>
      disableXpnHostOperationCallable() {
    return stub.disableXpnHostOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable this project as a shared VPC host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   DisableXpnHostProjectRequest request =
   *       DisableXpnHostProjectRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = projectsClient.disableXpnHostCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DisableXpnHostProjectRequest, Operation> disableXpnHostCallable() {
    return stub.disableXpnHostCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable a service resource (also known as service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "project-309310695";
   *   ProjectsDisableXpnResourceRequest projectsDisableXpnResourceRequestResource =
   *       ProjectsDisableXpnResourceRequest.newBuilder().build();
   *   Operation response =
   *       projectsClient
   *           .disableXpnResourceAsync(project, projectsDisableXpnResourceRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param projectsDisableXpnResourceRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> disableXpnResourceAsync(
      String project, ProjectsDisableXpnResourceRequest projectsDisableXpnResourceRequestResource) {
    DisableXpnResourceProjectRequest request =
        DisableXpnResourceProjectRequest.newBuilder()
            .setProject(project)
            .setProjectsDisableXpnResourceRequestResource(projectsDisableXpnResourceRequestResource)
            .build();
    return disableXpnResourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable a service resource (also known as service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   DisableXpnResourceProjectRequest request =
   *       DisableXpnResourceProjectRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setProjectsDisableXpnResourceRequestResource(
   *               ProjectsDisableXpnResourceRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = projectsClient.disableXpnResourceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> disableXpnResourceAsync(
      DisableXpnResourceProjectRequest request) {
    return disableXpnResourceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable a service resource (also known as service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   DisableXpnResourceProjectRequest request =
   *       DisableXpnResourceProjectRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setProjectsDisableXpnResourceRequestResource(
   *               ProjectsDisableXpnResourceRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       projectsClient.disableXpnResourceOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DisableXpnResourceProjectRequest, Operation, Operation>
      disableXpnResourceOperationCallable() {
    return stub.disableXpnResourceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable a service resource (also known as service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   DisableXpnResourceProjectRequest request =
   *       DisableXpnResourceProjectRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setProjectsDisableXpnResourceRequestResource(
   *               ProjectsDisableXpnResourceRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = projectsClient.disableXpnResourceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DisableXpnResourceProjectRequest, Operation>
      disableXpnResourceCallable() {
    return stub.disableXpnResourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable this project as a shared VPC host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "project-309310695";
   *   Operation response = projectsClient.enableXpnHostAsync(project).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> enableXpnHostAsync(String project) {
    EnableXpnHostProjectRequest request =
        EnableXpnHostProjectRequest.newBuilder().setProject(project).build();
    return enableXpnHostAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable this project as a shared VPC host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   EnableXpnHostProjectRequest request =
   *       EnableXpnHostProjectRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = projectsClient.enableXpnHostAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> enableXpnHostAsync(
      EnableXpnHostProjectRequest request) {
    return enableXpnHostOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable this project as a shared VPC host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   EnableXpnHostProjectRequest request =
   *       EnableXpnHostProjectRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       projectsClient.enableXpnHostOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<EnableXpnHostProjectRequest, Operation, Operation>
      enableXpnHostOperationCallable() {
    return stub.enableXpnHostOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable this project as a shared VPC host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   EnableXpnHostProjectRequest request =
   *       EnableXpnHostProjectRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = projectsClient.enableXpnHostCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EnableXpnHostProjectRequest, Operation> enableXpnHostCallable() {
    return stub.enableXpnHostCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable service resource (a.k.a service project) for a host project, so that subnets in the host
   * project can be used by instances in the service project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "project-309310695";
   *   ProjectsEnableXpnResourceRequest projectsEnableXpnResourceRequestResource =
   *       ProjectsEnableXpnResourceRequest.newBuilder().build();
   *   Operation response =
   *       projectsClient
   *           .enableXpnResourceAsync(project, projectsEnableXpnResourceRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param projectsEnableXpnResourceRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> enableXpnResourceAsync(
      String project, ProjectsEnableXpnResourceRequest projectsEnableXpnResourceRequestResource) {
    EnableXpnResourceProjectRequest request =
        EnableXpnResourceProjectRequest.newBuilder()
            .setProject(project)
            .setProjectsEnableXpnResourceRequestResource(projectsEnableXpnResourceRequestResource)
            .build();
    return enableXpnResourceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable service resource (a.k.a service project) for a host project, so that subnets in the host
   * project can be used by instances in the service project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   EnableXpnResourceProjectRequest request =
   *       EnableXpnResourceProjectRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setProjectsEnableXpnResourceRequestResource(
   *               ProjectsEnableXpnResourceRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = projectsClient.enableXpnResourceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> enableXpnResourceAsync(
      EnableXpnResourceProjectRequest request) {
    return enableXpnResourceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable service resource (a.k.a service project) for a host project, so that subnets in the host
   * project can be used by instances in the service project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   EnableXpnResourceProjectRequest request =
   *       EnableXpnResourceProjectRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setProjectsEnableXpnResourceRequestResource(
   *               ProjectsEnableXpnResourceRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       projectsClient.enableXpnResourceOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<EnableXpnResourceProjectRequest, Operation, Operation>
      enableXpnResourceOperationCallable() {
    return stub.enableXpnResourceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable service resource (a.k.a service project) for a host project, so that subnets in the host
   * project can be used by instances in the service project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   EnableXpnResourceProjectRequest request =
   *       EnableXpnResourceProjectRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setProjectsEnableXpnResourceRequestResource(
   *               ProjectsEnableXpnResourceRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = projectsClient.enableXpnResourceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EnableXpnResourceProjectRequest, Operation>
      enableXpnResourceCallable() {
    return stub.enableXpnResourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified Project resource. To decrease latency for this method, you can optionally
   * omit any unneeded information from the response by using a field mask. This practice is
   * especially recommended for unused quota information (the `quotas` field). To exclude one or
   * more fields, set your request's `fields` query parameter to only include the fields you need.
   * For example, to only include the `id` and `selfLink` fields, add the query parameter
   * `?fields=id,selfLink` to your request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "project-309310695";
   *   Project response = projectsClient.get(project);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Project get(String project) {
    GetProjectRequest request = GetProjectRequest.newBuilder().setProject(project).build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified Project resource. To decrease latency for this method, you can optionally
   * omit any unneeded information from the response by using a field mask. This practice is
   * especially recommended for unused quota information (the `quotas` field). To exclude one or
   * more fields, set your request's `fields` query parameter to only include the fields you need.
   * For example, to only include the `id` and `selfLink` fields, add the query parameter
   * `?fields=id,selfLink` to your request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   GetProjectRequest request =
   *       GetProjectRequest.newBuilder().setProject("project-309310695").build();
   *   Project response = projectsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Project get(GetProjectRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified Project resource. To decrease latency for this method, you can optionally
   * omit any unneeded information from the response by using a field mask. This practice is
   * especially recommended for unused quota information (the `quotas` field). To exclude one or
   * more fields, set your request's `fields` query parameter to only include the fields you need.
   * For example, to only include the `id` and `selfLink` fields, add the query parameter
   * `?fields=id,selfLink` to your request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   GetProjectRequest request =
   *       GetProjectRequest.newBuilder().setProject("project-309310695").build();
   *   ApiFuture<Project> future = projectsClient.getCallable().futureCall(request);
   *   // Do something.
   *   Project response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetProjectRequest, Project> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the shared VPC host project that this project links to. May be empty if no link exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "project-309310695";
   *   Project response = projectsClient.getXpnHost(project);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Project getXpnHost(String project) {
    GetXpnHostProjectRequest request =
        GetXpnHostProjectRequest.newBuilder().setProject(project).build();
    return getXpnHost(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the shared VPC host project that this project links to. May be empty if no link exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   GetXpnHostProjectRequest request =
   *       GetXpnHostProjectRequest.newBuilder().setProject("project-309310695").build();
   *   Project response = projectsClient.getXpnHost(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Project getXpnHost(GetXpnHostProjectRequest request) {
    return getXpnHostCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the shared VPC host project that this project links to. May be empty if no link exists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   GetXpnHostProjectRequest request =
   *       GetXpnHostProjectRequest.newBuilder().setProject("project-309310695").build();
   *   ApiFuture<Project> future = projectsClient.getXpnHostCallable().futureCall(request);
   *   // Do something.
   *   Project response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetXpnHostProjectRequest, Project> getXpnHostCallable() {
    return stub.getXpnHostCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets service resources (a.k.a service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "project-309310695";
   *   for (XpnResourceId element : projectsClient.getXpnResources(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetXpnResourcesPagedResponse getXpnResources(String project) {
    GetXpnResourcesProjectsRequest request =
        GetXpnResourcesProjectsRequest.newBuilder().setProject(project).build();
    return getXpnResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets service resources (a.k.a service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   GetXpnResourcesProjectsRequest request =
   *       GetXpnResourcesProjectsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (XpnResourceId element : projectsClient.getXpnResources(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GetXpnResourcesPagedResponse getXpnResources(
      GetXpnResourcesProjectsRequest request) {
    return getXpnResourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets service resources (a.k.a service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   GetXpnResourcesProjectsRequest request =
   *       GetXpnResourcesProjectsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<XpnResourceId> future =
   *       projectsClient.getXpnResourcesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (XpnResourceId element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<GetXpnResourcesProjectsRequest, GetXpnResourcesPagedResponse>
      getXpnResourcesPagedCallable() {
    return stub.getXpnResourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets service resources (a.k.a service project) associated with this host project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   GetXpnResourcesProjectsRequest request =
   *       GetXpnResourcesProjectsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     ProjectsGetXpnResources response = projectsClient.getXpnResourcesCallable().call(request);
   *     for (XpnResourceId element : response.getResourcesList()) {
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
  public final UnaryCallable<GetXpnResourcesProjectsRequest, ProjectsGetXpnResources>
      getXpnResourcesCallable() {
    return stub.getXpnResourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all shared VPC host projects visible to the user in an organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "project-309310695";
   *   ProjectsListXpnHostsRequest projectsListXpnHostsRequestResource =
   *       ProjectsListXpnHostsRequest.newBuilder().build();
   *   for (Project element :
   *       projectsClient.listXpnHosts(project, projectsListXpnHostsRequestResource).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param projectsListXpnHostsRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListXpnHostsPagedResponse listXpnHosts(
      String project, ProjectsListXpnHostsRequest projectsListXpnHostsRequestResource) {
    ListXpnHostsProjectsRequest request =
        ListXpnHostsProjectsRequest.newBuilder()
            .setProject(project)
            .setProjectsListXpnHostsRequestResource(projectsListXpnHostsRequestResource)
            .build();
    return listXpnHosts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all shared VPC host projects visible to the user in an organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   ListXpnHostsProjectsRequest request =
   *       ListXpnHostsProjectsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setProjectsListXpnHostsRequestResource(
   *               ProjectsListXpnHostsRequest.newBuilder().build())
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (Project element : projectsClient.listXpnHosts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListXpnHostsPagedResponse listXpnHosts(ListXpnHostsProjectsRequest request) {
    return listXpnHostsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all shared VPC host projects visible to the user in an organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   ListXpnHostsProjectsRequest request =
   *       ListXpnHostsProjectsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setProjectsListXpnHostsRequestResource(
   *               ProjectsListXpnHostsRequest.newBuilder().build())
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<Project> future = projectsClient.listXpnHostsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Project element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListXpnHostsProjectsRequest, ListXpnHostsPagedResponse>
      listXpnHostsPagedCallable() {
    return stub.listXpnHostsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all shared VPC host projects visible to the user in an organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   ListXpnHostsProjectsRequest request =
   *       ListXpnHostsProjectsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setProjectsListXpnHostsRequestResource(
   *               ProjectsListXpnHostsRequest.newBuilder().build())
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     XpnHostList response = projectsClient.listXpnHostsCallable().call(request);
   *     for (Project element : response.getItemsList()) {
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
  public final UnaryCallable<ListXpnHostsProjectsRequest, XpnHostList> listXpnHostsCallable() {
    return stub.listXpnHostsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves a persistent disk from one zone to another.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "project-309310695";
   *   DiskMoveRequest diskMoveRequestResource = DiskMoveRequest.newBuilder().build();
   *   Operation response = projectsClient.moveDiskAsync(project, diskMoveRequestResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param diskMoveRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> moveDiskAsync(
      String project, DiskMoveRequest diskMoveRequestResource) {
    MoveDiskProjectRequest request =
        MoveDiskProjectRequest.newBuilder()
            .setProject(project)
            .setDiskMoveRequestResource(diskMoveRequestResource)
            .build();
    return moveDiskAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves a persistent disk from one zone to another.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   MoveDiskProjectRequest request =
   *       MoveDiskProjectRequest.newBuilder()
   *           .setDiskMoveRequestResource(DiskMoveRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = projectsClient.moveDiskAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> moveDiskAsync(MoveDiskProjectRequest request) {
    return moveDiskOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves a persistent disk from one zone to another.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   MoveDiskProjectRequest request =
   *       MoveDiskProjectRequest.newBuilder()
   *           .setDiskMoveRequestResource(DiskMoveRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       projectsClient.moveDiskOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<MoveDiskProjectRequest, Operation, Operation>
      moveDiskOperationCallable() {
    return stub.moveDiskOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves a persistent disk from one zone to another.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   MoveDiskProjectRequest request =
   *       MoveDiskProjectRequest.newBuilder()
   *           .setDiskMoveRequestResource(DiskMoveRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = projectsClient.moveDiskCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<MoveDiskProjectRequest, Operation> moveDiskCallable() {
    return stub.moveDiskCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves an instance and its attached persistent disks from one zone to another. &#42;Note&#42;:
   * Moving VMs or disks by using this method might cause unexpected behavior. For more information,
   * see the [known
   * issue](/compute/docs/troubleshooting/known-issues#moving_vms_or_disks_using_the_moveinstance_api_or_the_causes_unexpected_behavior).
   * [Deprecated] This method is deprecated. See [moving instance across
   * zones](/compute/docs/instances/moving-instance-across-zones) instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "project-309310695";
   *   InstanceMoveRequest instanceMoveRequestResource = InstanceMoveRequest.newBuilder().build();
   *   Operation response =
   *       projectsClient.moveInstanceAsync(project, instanceMoveRequestResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param instanceMoveRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> moveInstanceAsync(
      String project, InstanceMoveRequest instanceMoveRequestResource) {
    MoveInstanceProjectRequest request =
        MoveInstanceProjectRequest.newBuilder()
            .setProject(project)
            .setInstanceMoveRequestResource(instanceMoveRequestResource)
            .build();
    return moveInstanceAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves an instance and its attached persistent disks from one zone to another. &#42;Note&#42;:
   * Moving VMs or disks by using this method might cause unexpected behavior. For more information,
   * see the [known
   * issue](/compute/docs/troubleshooting/known-issues#moving_vms_or_disks_using_the_moveinstance_api_or_the_causes_unexpected_behavior).
   * [Deprecated] This method is deprecated. See [moving instance across
   * zones](/compute/docs/instances/moving-instance-across-zones) instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   MoveInstanceProjectRequest request =
   *       MoveInstanceProjectRequest.newBuilder()
   *           .setInstanceMoveRequestResource(InstanceMoveRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = projectsClient.moveInstanceAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> moveInstanceAsync(
      MoveInstanceProjectRequest request) {
    return moveInstanceOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves an instance and its attached persistent disks from one zone to another. &#42;Note&#42;:
   * Moving VMs or disks by using this method might cause unexpected behavior. For more information,
   * see the [known
   * issue](/compute/docs/troubleshooting/known-issues#moving_vms_or_disks_using_the_moveinstance_api_or_the_causes_unexpected_behavior).
   * [Deprecated] This method is deprecated. See [moving instance across
   * zones](/compute/docs/instances/moving-instance-across-zones) instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   MoveInstanceProjectRequest request =
   *       MoveInstanceProjectRequest.newBuilder()
   *           .setInstanceMoveRequestResource(InstanceMoveRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       projectsClient.moveInstanceOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<MoveInstanceProjectRequest, Operation, Operation>
      moveInstanceOperationCallable() {
    return stub.moveInstanceOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves an instance and its attached persistent disks from one zone to another. &#42;Note&#42;:
   * Moving VMs or disks by using this method might cause unexpected behavior. For more information,
   * see the [known
   * issue](/compute/docs/troubleshooting/known-issues#moving_vms_or_disks_using_the_moveinstance_api_or_the_causes_unexpected_behavior).
   * [Deprecated] This method is deprecated. See [moving instance across
   * zones](/compute/docs/instances/moving-instance-across-zones) instead.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   MoveInstanceProjectRequest request =
   *       MoveInstanceProjectRequest.newBuilder()
   *           .setInstanceMoveRequestResource(InstanceMoveRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = projectsClient.moveInstanceCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<MoveInstanceProjectRequest, Operation> moveInstanceCallable() {
    return stub.moveInstanceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the Cloud Armor tier of the project. To set ENTERPRISE or above the billing account of the
   * project must be subscribed to Cloud Armor Enterprise. See Subscribing to Cloud Armor Enterprise
   * for more information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "project-309310695";
   *   ProjectsSetCloudArmorTierRequest projectsSetCloudArmorTierRequestResource =
   *       ProjectsSetCloudArmorTierRequest.newBuilder().build();
   *   Operation response =
   *       projectsClient
   *           .setCloudArmorTierAsync(project, projectsSetCloudArmorTierRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param projectsSetCloudArmorTierRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setCloudArmorTierAsync(
      String project, ProjectsSetCloudArmorTierRequest projectsSetCloudArmorTierRequestResource) {
    SetCloudArmorTierProjectRequest request =
        SetCloudArmorTierProjectRequest.newBuilder()
            .setProject(project)
            .setProjectsSetCloudArmorTierRequestResource(projectsSetCloudArmorTierRequestResource)
            .build();
    return setCloudArmorTierAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the Cloud Armor tier of the project. To set ENTERPRISE or above the billing account of the
   * project must be subscribed to Cloud Armor Enterprise. See Subscribing to Cloud Armor Enterprise
   * for more information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   SetCloudArmorTierProjectRequest request =
   *       SetCloudArmorTierProjectRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setProjectsSetCloudArmorTierRequestResource(
   *               ProjectsSetCloudArmorTierRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = projectsClient.setCloudArmorTierAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setCloudArmorTierAsync(
      SetCloudArmorTierProjectRequest request) {
    return setCloudArmorTierOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the Cloud Armor tier of the project. To set ENTERPRISE or above the billing account of the
   * project must be subscribed to Cloud Armor Enterprise. See Subscribing to Cloud Armor Enterprise
   * for more information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   SetCloudArmorTierProjectRequest request =
   *       SetCloudArmorTierProjectRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setProjectsSetCloudArmorTierRequestResource(
   *               ProjectsSetCloudArmorTierRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       projectsClient.setCloudArmorTierOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetCloudArmorTierProjectRequest, Operation, Operation>
      setCloudArmorTierOperationCallable() {
    return stub.setCloudArmorTierOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the Cloud Armor tier of the project. To set ENTERPRISE or above the billing account of the
   * project must be subscribed to Cloud Armor Enterprise. See Subscribing to Cloud Armor Enterprise
   * for more information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   SetCloudArmorTierProjectRequest request =
   *       SetCloudArmorTierProjectRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setProjectsSetCloudArmorTierRequestResource(
   *               ProjectsSetCloudArmorTierRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = projectsClient.setCloudArmorTierCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetCloudArmorTierProjectRequest, Operation>
      setCloudArmorTierCallable() {
    return stub.setCloudArmorTierCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets metadata common to all instances within the specified project using the data included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "project-309310695";
   *   Metadata metadataResource = Metadata.newBuilder().build();
   *   Operation response =
   *       projectsClient.setCommonInstanceMetadataAsync(project, metadataResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param metadataResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setCommonInstanceMetadataAsync(
      String project, Metadata metadataResource) {
    SetCommonInstanceMetadataProjectRequest request =
        SetCommonInstanceMetadataProjectRequest.newBuilder()
            .setProject(project)
            .setMetadataResource(metadataResource)
            .build();
    return setCommonInstanceMetadataAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets metadata common to all instances within the specified project using the data included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   SetCommonInstanceMetadataProjectRequest request =
   *       SetCommonInstanceMetadataProjectRequest.newBuilder()
   *           .setMetadataResource(Metadata.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = projectsClient.setCommonInstanceMetadataAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setCommonInstanceMetadataAsync(
      SetCommonInstanceMetadataProjectRequest request) {
    return setCommonInstanceMetadataOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets metadata common to all instances within the specified project using the data included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   SetCommonInstanceMetadataProjectRequest request =
   *       SetCommonInstanceMetadataProjectRequest.newBuilder()
   *           .setMetadataResource(Metadata.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       projectsClient.setCommonInstanceMetadataOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetCommonInstanceMetadataProjectRequest, Operation, Operation>
      setCommonInstanceMetadataOperationCallable() {
    return stub.setCommonInstanceMetadataOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets metadata common to all instances within the specified project using the data included in
   * the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   SetCommonInstanceMetadataProjectRequest request =
   *       SetCommonInstanceMetadataProjectRequest.newBuilder()
   *           .setMetadataResource(Metadata.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       projectsClient.setCommonInstanceMetadataCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetCommonInstanceMetadataProjectRequest, Operation>
      setCommonInstanceMetadataCallable() {
    return stub.setCommonInstanceMetadataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the default network tier of the project. The default network tier is used when an
   * address/forwardingRule/instance is created without specifying the network tier field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "project-309310695";
   *   ProjectsSetDefaultNetworkTierRequest projectsSetDefaultNetworkTierRequestResource =
   *       ProjectsSetDefaultNetworkTierRequest.newBuilder().build();
   *   Operation response =
   *       projectsClient
   *           .setDefaultNetworkTierAsync(project, projectsSetDefaultNetworkTierRequestResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param projectsSetDefaultNetworkTierRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setDefaultNetworkTierAsync(
      String project,
      ProjectsSetDefaultNetworkTierRequest projectsSetDefaultNetworkTierRequestResource) {
    SetDefaultNetworkTierProjectRequest request =
        SetDefaultNetworkTierProjectRequest.newBuilder()
            .setProject(project)
            .setProjectsSetDefaultNetworkTierRequestResource(
                projectsSetDefaultNetworkTierRequestResource)
            .build();
    return setDefaultNetworkTierAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the default network tier of the project. The default network tier is used when an
   * address/forwardingRule/instance is created without specifying the network tier field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   SetDefaultNetworkTierProjectRequest request =
   *       SetDefaultNetworkTierProjectRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setProjectsSetDefaultNetworkTierRequestResource(
   *               ProjectsSetDefaultNetworkTierRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = projectsClient.setDefaultNetworkTierAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setDefaultNetworkTierAsync(
      SetDefaultNetworkTierProjectRequest request) {
    return setDefaultNetworkTierOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the default network tier of the project. The default network tier is used when an
   * address/forwardingRule/instance is created without specifying the network tier field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   SetDefaultNetworkTierProjectRequest request =
   *       SetDefaultNetworkTierProjectRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setProjectsSetDefaultNetworkTierRequestResource(
   *               ProjectsSetDefaultNetworkTierRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       projectsClient.setDefaultNetworkTierOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetDefaultNetworkTierProjectRequest, Operation, Operation>
      setDefaultNetworkTierOperationCallable() {
    return stub.setDefaultNetworkTierOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the default network tier of the project. The default network tier is used when an
   * address/forwardingRule/instance is created without specifying the network tier field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   SetDefaultNetworkTierProjectRequest request =
   *       SetDefaultNetworkTierProjectRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setProjectsSetDefaultNetworkTierRequestResource(
   *               ProjectsSetDefaultNetworkTierRequest.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       projectsClient.setDefaultNetworkTierCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetDefaultNetworkTierProjectRequest, Operation>
      setDefaultNetworkTierCallable() {
    return stub.setDefaultNetworkTierCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables the usage export feature and sets the usage export bucket where reports are stored. If
   * you provide an empty request body using this method, the usage export feature will be disabled.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   String project = "project-309310695";
   *   UsageExportLocation usageExportLocationResource = UsageExportLocation.newBuilder().build();
   *   Operation response =
   *       projectsClient.setUsageExportBucketAsync(project, usageExportLocationResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param usageExportLocationResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> setUsageExportBucketAsync(
      String project, UsageExportLocation usageExportLocationResource) {
    SetUsageExportBucketProjectRequest request =
        SetUsageExportBucketProjectRequest.newBuilder()
            .setProject(project)
            .setUsageExportLocationResource(usageExportLocationResource)
            .build();
    return setUsageExportBucketAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables the usage export feature and sets the usage export bucket where reports are stored. If
   * you provide an empty request body using this method, the usage export feature will be disabled.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   SetUsageExportBucketProjectRequest request =
   *       SetUsageExportBucketProjectRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUsageExportLocationResource(UsageExportLocation.newBuilder().build())
   *           .build();
   *   Operation response = projectsClient.setUsageExportBucketAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<Operation, Operation> setUsageExportBucketAsync(
      SetUsageExportBucketProjectRequest request) {
    return setUsageExportBucketOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables the usage export feature and sets the usage export bucket where reports are stored. If
   * you provide an empty request body using this method, the usage export feature will be disabled.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   SetUsageExportBucketProjectRequest request =
   *       SetUsageExportBucketProjectRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUsageExportLocationResource(UsageExportLocation.newBuilder().build())
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       projectsClient.setUsageExportBucketOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<SetUsageExportBucketProjectRequest, Operation, Operation>
      setUsageExportBucketOperationCallable() {
    return stub.setUsageExportBucketOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enables the usage export feature and sets the usage export bucket where reports are stored. If
   * you provide an empty request body using this method, the usage export feature will be disabled.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ProjectsClient projectsClient = ProjectsClient.create()) {
   *   SetUsageExportBucketProjectRequest request =
   *       SetUsageExportBucketProjectRequest.newBuilder()
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .setUsageExportLocationResource(UsageExportLocation.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       projectsClient.setUsageExportBucketCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetUsageExportBucketProjectRequest, Operation>
      setUsageExportBucketCallable() {
    return stub.setUsageExportBucketCallable();
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

  public static class GetXpnResourcesPagedResponse
      extends AbstractPagedListResponse<
          GetXpnResourcesProjectsRequest,
          ProjectsGetXpnResources,
          XpnResourceId,
          GetXpnResourcesPage,
          GetXpnResourcesFixedSizeCollection> {

    public static ApiFuture<GetXpnResourcesPagedResponse> createAsync(
        PageContext<GetXpnResourcesProjectsRequest, ProjectsGetXpnResources, XpnResourceId> context,
        ApiFuture<ProjectsGetXpnResources> futureResponse) {
      ApiFuture<GetXpnResourcesPage> futurePage =
          GetXpnResourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new GetXpnResourcesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private GetXpnResourcesPagedResponse(GetXpnResourcesPage page) {
      super(page, GetXpnResourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class GetXpnResourcesPage
      extends AbstractPage<
          GetXpnResourcesProjectsRequest,
          ProjectsGetXpnResources,
          XpnResourceId,
          GetXpnResourcesPage> {

    private GetXpnResourcesPage(
        PageContext<GetXpnResourcesProjectsRequest, ProjectsGetXpnResources, XpnResourceId> context,
        ProjectsGetXpnResources response) {
      super(context, response);
    }

    private static GetXpnResourcesPage createEmptyPage() {
      return new GetXpnResourcesPage(null, null);
    }

    @Override
    protected GetXpnResourcesPage createPage(
        PageContext<GetXpnResourcesProjectsRequest, ProjectsGetXpnResources, XpnResourceId> context,
        ProjectsGetXpnResources response) {
      return new GetXpnResourcesPage(context, response);
    }

    @Override
    public ApiFuture<GetXpnResourcesPage> createPageAsync(
        PageContext<GetXpnResourcesProjectsRequest, ProjectsGetXpnResources, XpnResourceId> context,
        ApiFuture<ProjectsGetXpnResources> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class GetXpnResourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          GetXpnResourcesProjectsRequest,
          ProjectsGetXpnResources,
          XpnResourceId,
          GetXpnResourcesPage,
          GetXpnResourcesFixedSizeCollection> {

    private GetXpnResourcesFixedSizeCollection(
        List<GetXpnResourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static GetXpnResourcesFixedSizeCollection createEmptyCollection() {
      return new GetXpnResourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected GetXpnResourcesFixedSizeCollection createCollection(
        List<GetXpnResourcesPage> pages, int collectionSize) {
      return new GetXpnResourcesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListXpnHostsPagedResponse
      extends AbstractPagedListResponse<
          ListXpnHostsProjectsRequest,
          XpnHostList,
          Project,
          ListXpnHostsPage,
          ListXpnHostsFixedSizeCollection> {

    public static ApiFuture<ListXpnHostsPagedResponse> createAsync(
        PageContext<ListXpnHostsProjectsRequest, XpnHostList, Project> context,
        ApiFuture<XpnHostList> futureResponse) {
      ApiFuture<ListXpnHostsPage> futurePage =
          ListXpnHostsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListXpnHostsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListXpnHostsPagedResponse(ListXpnHostsPage page) {
      super(page, ListXpnHostsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListXpnHostsPage
      extends AbstractPage<ListXpnHostsProjectsRequest, XpnHostList, Project, ListXpnHostsPage> {

    private ListXpnHostsPage(
        PageContext<ListXpnHostsProjectsRequest, XpnHostList, Project> context,
        XpnHostList response) {
      super(context, response);
    }

    private static ListXpnHostsPage createEmptyPage() {
      return new ListXpnHostsPage(null, null);
    }

    @Override
    protected ListXpnHostsPage createPage(
        PageContext<ListXpnHostsProjectsRequest, XpnHostList, Project> context,
        XpnHostList response) {
      return new ListXpnHostsPage(context, response);
    }

    @Override
    public ApiFuture<ListXpnHostsPage> createPageAsync(
        PageContext<ListXpnHostsProjectsRequest, XpnHostList, Project> context,
        ApiFuture<XpnHostList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListXpnHostsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListXpnHostsProjectsRequest,
          XpnHostList,
          Project,
          ListXpnHostsPage,
          ListXpnHostsFixedSizeCollection> {

    private ListXpnHostsFixedSizeCollection(List<ListXpnHostsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListXpnHostsFixedSizeCollection createEmptyCollection() {
      return new ListXpnHostsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListXpnHostsFixedSizeCollection createCollection(
        List<ListXpnHostsPage> pages, int collectionSize) {
      return new ListXpnHostsFixedSizeCollection(pages, collectionSize);
    }
  }
}
