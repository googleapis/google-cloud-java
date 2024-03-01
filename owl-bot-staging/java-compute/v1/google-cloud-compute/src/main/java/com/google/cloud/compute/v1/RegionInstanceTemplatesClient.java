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
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.RegionInstanceTemplatesStub;
import com.google.cloud.compute.v1.stub.RegionInstanceTemplatesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The RegionInstanceTemplates API.
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
 * try (RegionInstanceTemplatesClient regionInstanceTemplatesClient =
 *     RegionInstanceTemplatesClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   String instanceTemplate = "instanceTemplate1009541167";
 *   InstanceTemplate response =
 *       regionInstanceTemplatesClient.get(project, region, instanceTemplate);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the RegionInstanceTemplatesClient object to clean up
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
 *      <td><p> Delete</td>
 *      <td><p> Deletes the specified instance template. Deleting an instance template is permanent and cannot be undone.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteAsync(DeleteRegionInstanceTemplateRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> deleteAsync(String project, String region, String instanceTemplate)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteOperationCallable()
 *           <li><p> deleteCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Get</td>
 *      <td><p> Returns the specified instance template.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetRegionInstanceTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String region, String instanceTemplate)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Insert</td>
 *      <td><p> Creates an instance template in the specified project and region using the global instance template whose URL is included in the request.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertAsync(InsertRegionInstanceTemplateRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> insertAsync(String project, String region, InstanceTemplate instanceTemplateResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> insertOperationCallable()
 *           <li><p> insertCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> List</td>
 *      <td><p> Retrieves a list of instance templates that are contained within the specified project and region.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(ListRegionInstanceTemplatesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> list(String project, String region)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPagedCallable()
 *           <li><p> listCallable()
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
 * RegionInstanceTemplatesSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * RegionInstanceTemplatesSettings regionInstanceTemplatesSettings =
 *     RegionInstanceTemplatesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * RegionInstanceTemplatesClient regionInstanceTemplatesClient =
 *     RegionInstanceTemplatesClient.create(regionInstanceTemplatesSettings);
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
 * RegionInstanceTemplatesSettings regionInstanceTemplatesSettings =
 *     RegionInstanceTemplatesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * RegionInstanceTemplatesClient regionInstanceTemplatesClient =
 *     RegionInstanceTemplatesClient.create(regionInstanceTemplatesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class RegionInstanceTemplatesClient implements BackgroundResource {
  private final RegionInstanceTemplatesSettings settings;
  private final RegionInstanceTemplatesStub stub;

  /** Constructs an instance of RegionInstanceTemplatesClient with default settings. */
  public static final RegionInstanceTemplatesClient create() throws IOException {
    return create(RegionInstanceTemplatesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of RegionInstanceTemplatesClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final RegionInstanceTemplatesClient create(RegionInstanceTemplatesSettings settings)
      throws IOException {
    return new RegionInstanceTemplatesClient(settings);
  }

  /**
   * Constructs an instance of RegionInstanceTemplatesClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(RegionInstanceTemplatesSettings).
   */
  public static final RegionInstanceTemplatesClient create(RegionInstanceTemplatesStub stub) {
    return new RegionInstanceTemplatesClient(stub);
  }

  /**
   * Constructs an instance of RegionInstanceTemplatesClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected RegionInstanceTemplatesClient(RegionInstanceTemplatesSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((RegionInstanceTemplatesStubSettings) settings.getStubSettings()).createStub();
  }

  protected RegionInstanceTemplatesClient(RegionInstanceTemplatesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final RegionInstanceTemplatesSettings getSettings() {
    return settings;
  }

  public RegionInstanceTemplatesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified instance template. Deleting an instance template is permanent and cannot
   * be undone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceTemplatesClient regionInstanceTemplatesClient =
   *     RegionInstanceTemplatesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String instanceTemplate = "instanceTemplate1009541167";
   *   Operation response =
   *       regionInstanceTemplatesClient.deleteAsync(project, region, instanceTemplate).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param instanceTemplate The name of the instance template to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      String project, String region, String instanceTemplate) {
    DeleteRegionInstanceTemplateRequest request =
        DeleteRegionInstanceTemplateRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceTemplate(instanceTemplate)
            .build();
    return deleteAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified instance template. Deleting an instance template is permanent and cannot
   * be undone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceTemplatesClient regionInstanceTemplatesClient =
   *     RegionInstanceTemplatesClient.create()) {
   *   DeleteRegionInstanceTemplateRequest request =
   *       DeleteRegionInstanceTemplateRequest.newBuilder()
   *           .setInstanceTemplate("instanceTemplate1009541167")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionInstanceTemplatesClient.deleteAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> deleteAsync(
      DeleteRegionInstanceTemplateRequest request) {
    return deleteOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified instance template. Deleting an instance template is permanent and cannot
   * be undone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceTemplatesClient regionInstanceTemplatesClient =
   *     RegionInstanceTemplatesClient.create()) {
   *   DeleteRegionInstanceTemplateRequest request =
   *       DeleteRegionInstanceTemplateRequest.newBuilder()
   *           .setInstanceTemplate("instanceTemplate1009541167")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionInstanceTemplatesClient.deleteOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteRegionInstanceTemplateRequest, Operation, Operation>
      deleteOperationCallable() {
    return stub.deleteOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified instance template. Deleting an instance template is permanent and cannot
   * be undone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceTemplatesClient regionInstanceTemplatesClient =
   *     RegionInstanceTemplatesClient.create()) {
   *   DeleteRegionInstanceTemplateRequest request =
   *       DeleteRegionInstanceTemplateRequest.newBuilder()
   *           .setInstanceTemplate("instanceTemplate1009541167")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionInstanceTemplatesClient.deleteCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRegionInstanceTemplateRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified instance template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceTemplatesClient regionInstanceTemplatesClient =
   *     RegionInstanceTemplatesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   String instanceTemplate = "instanceTemplate1009541167";
   *   InstanceTemplate response =
   *       regionInstanceTemplatesClient.get(project, region, instanceTemplate);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param instanceTemplate The name of the instance template.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstanceTemplate get(String project, String region, String instanceTemplate) {
    GetRegionInstanceTemplateRequest request =
        GetRegionInstanceTemplateRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceTemplate(instanceTemplate)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified instance template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceTemplatesClient regionInstanceTemplatesClient =
   *     RegionInstanceTemplatesClient.create()) {
   *   GetRegionInstanceTemplateRequest request =
   *       GetRegionInstanceTemplateRequest.newBuilder()
   *           .setInstanceTemplate("instanceTemplate1009541167")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   InstanceTemplate response = regionInstanceTemplatesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstanceTemplate get(GetRegionInstanceTemplateRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified instance template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceTemplatesClient regionInstanceTemplatesClient =
   *     RegionInstanceTemplatesClient.create()) {
   *   GetRegionInstanceTemplateRequest request =
   *       GetRegionInstanceTemplateRequest.newBuilder()
   *           .setInstanceTemplate("instanceTemplate1009541167")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<InstanceTemplate> future =
   *       regionInstanceTemplatesClient.getCallable().futureCall(request);
   *   // Do something.
   *   InstanceTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRegionInstanceTemplateRequest, InstanceTemplate> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an instance template in the specified project and region using the global instance
   * template whose URL is included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceTemplatesClient regionInstanceTemplatesClient =
   *     RegionInstanceTemplatesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   InstanceTemplate instanceTemplateResource = InstanceTemplate.newBuilder().build();
   *   Operation response =
   *       regionInstanceTemplatesClient
   *           .insertAsync(project, region, instanceTemplateResource)
   *           .get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the region for this request.
   * @param instanceTemplateResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      String project, String region, InstanceTemplate instanceTemplateResource) {
    InsertRegionInstanceTemplateRequest request =
        InsertRegionInstanceTemplateRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setInstanceTemplateResource(instanceTemplateResource)
            .build();
    return insertAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an instance template in the specified project and region using the global instance
   * template whose URL is included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceTemplatesClient regionInstanceTemplatesClient =
   *     RegionInstanceTemplatesClient.create()) {
   *   InsertRegionInstanceTemplateRequest request =
   *       InsertRegionInstanceTemplateRequest.newBuilder()
   *           .setInstanceTemplateResource(InstanceTemplate.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = regionInstanceTemplatesClient.insertAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> insertAsync(
      InsertRegionInstanceTemplateRequest request) {
    return insertOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an instance template in the specified project and region using the global instance
   * template whose URL is included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceTemplatesClient regionInstanceTemplatesClient =
   *     RegionInstanceTemplatesClient.create()) {
   *   InsertRegionInstanceTemplateRequest request =
   *       InsertRegionInstanceTemplateRequest.newBuilder()
   *           .setInstanceTemplateResource(InstanceTemplate.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       regionInstanceTemplatesClient.insertOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<InsertRegionInstanceTemplateRequest, Operation, Operation>
      insertOperationCallable() {
    return stub.insertOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an instance template in the specified project and region using the global instance
   * template whose URL is included in the request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceTemplatesClient regionInstanceTemplatesClient =
   *     RegionInstanceTemplatesClient.create()) {
   *   InsertRegionInstanceTemplateRequest request =
   *       InsertRegionInstanceTemplateRequest.newBuilder()
   *           .setInstanceTemplateResource(InstanceTemplate.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       regionInstanceTemplatesClient.insertCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertRegionInstanceTemplateRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of instance templates that are contained within the specified project and
   * region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceTemplatesClient regionInstanceTemplatesClient =
   *     RegionInstanceTemplatesClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   for (InstanceTemplate element :
   *       regionInstanceTemplatesClient.list(project, region).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region The name of the regions for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project, String region) {
    ListRegionInstanceTemplatesRequest request =
        ListRegionInstanceTemplatesRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of instance templates that are contained within the specified project and
   * region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceTemplatesClient regionInstanceTemplatesClient =
   *     RegionInstanceTemplatesClient.create()) {
   *   ListRegionInstanceTemplatesRequest request =
   *       ListRegionInstanceTemplatesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (InstanceTemplate element : regionInstanceTemplatesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListRegionInstanceTemplatesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of instance templates that are contained within the specified project and
   * region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceTemplatesClient regionInstanceTemplatesClient =
   *     RegionInstanceTemplatesClient.create()) {
   *   ListRegionInstanceTemplatesRequest request =
   *       ListRegionInstanceTemplatesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<InstanceTemplate> future =
   *       regionInstanceTemplatesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (InstanceTemplate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRegionInstanceTemplatesRequest, ListPagedResponse>
      listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a list of instance templates that are contained within the specified project and
   * region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (RegionInstanceTemplatesClient regionInstanceTemplatesClient =
   *     RegionInstanceTemplatesClient.create()) {
   *   ListRegionInstanceTemplatesRequest request =
   *       ListRegionInstanceTemplatesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     InstanceTemplateList response = regionInstanceTemplatesClient.listCallable().call(request);
   *     for (InstanceTemplate element : response.getItemsList()) {
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
  public final UnaryCallable<ListRegionInstanceTemplatesRequest, InstanceTemplateList>
      listCallable() {
    return stub.listCallable();
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

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListRegionInstanceTemplatesRequest,
          InstanceTemplateList,
          InstanceTemplate,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListRegionInstanceTemplatesRequest, InstanceTemplateList, InstanceTemplate>
            context,
        ApiFuture<InstanceTemplateList> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage
      extends AbstractPage<
          ListRegionInstanceTemplatesRequest, InstanceTemplateList, InstanceTemplate, ListPage> {

    private ListPage(
        PageContext<ListRegionInstanceTemplatesRequest, InstanceTemplateList, InstanceTemplate>
            context,
        InstanceTemplateList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListRegionInstanceTemplatesRequest, InstanceTemplateList, InstanceTemplate>
            context,
        InstanceTemplateList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListRegionInstanceTemplatesRequest, InstanceTemplateList, InstanceTemplate>
            context,
        ApiFuture<InstanceTemplateList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRegionInstanceTemplatesRequest,
          InstanceTemplateList,
          InstanceTemplate,
          ListPage,
          ListFixedSizeCollection> {

    private ListFixedSizeCollection(List<ListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFixedSizeCollection createEmptyCollection() {
      return new ListFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFixedSizeCollection createCollection(List<ListPage> pages, int collectionSize) {
      return new ListFixedSizeCollection(pages, collectionSize);
    }
  }
}
