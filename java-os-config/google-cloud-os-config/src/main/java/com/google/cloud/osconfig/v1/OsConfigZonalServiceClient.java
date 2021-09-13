/*
 * Copyright 2021 Google LLC
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

package com.google.cloud.osconfig.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.osconfig.v1.stub.OsConfigZonalServiceStub;
import com.google.cloud.osconfig.v1.stub.OsConfigZonalServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Zonal OS Config API
 *
 * <p>The OS Config service is the server-side component that allows users to manage package
 * installations and patch jobs for Compute Engine VM instances.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
 *     OsConfigZonalServiceClient.create()) {
 *   InventoryName name = InventoryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   Inventory response = osConfigZonalServiceClient.getInventory(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the OsConfigZonalServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
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
 * <p>This class can be customized by passing in a custom instance of OsConfigZonalServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * OsConfigZonalServiceSettings osConfigZonalServiceSettings =
 *     OsConfigZonalServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * OsConfigZonalServiceClient osConfigZonalServiceClient =
 *     OsConfigZonalServiceClient.create(osConfigZonalServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * OsConfigZonalServiceSettings osConfigZonalServiceSettings =
 *     OsConfigZonalServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * OsConfigZonalServiceClient osConfigZonalServiceClient =
 *     OsConfigZonalServiceClient.create(osConfigZonalServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class OsConfigZonalServiceClient implements BackgroundResource {
  private final OsConfigZonalServiceSettings settings;
  private final OsConfigZonalServiceStub stub;

  /** Constructs an instance of OsConfigZonalServiceClient with default settings. */
  public static final OsConfigZonalServiceClient create() throws IOException {
    return create(OsConfigZonalServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of OsConfigZonalServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final OsConfigZonalServiceClient create(OsConfigZonalServiceSettings settings)
      throws IOException {
    return new OsConfigZonalServiceClient(settings);
  }

  /**
   * Constructs an instance of OsConfigZonalServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(OsConfigZonalServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final OsConfigZonalServiceClient create(OsConfigZonalServiceStub stub) {
    return new OsConfigZonalServiceClient(stub);
  }

  /**
   * Constructs an instance of OsConfigZonalServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected OsConfigZonalServiceClient(OsConfigZonalServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((OsConfigZonalServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected OsConfigZonalServiceClient(OsConfigZonalServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final OsConfigZonalServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public OsConfigZonalServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get inventory data for the specified VM instance. If the VM has no associated inventory, the
   * message `NOT_FOUND` is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   InventoryName name = InventoryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   Inventory response = osConfigZonalServiceClient.getInventory(name);
   * }
   * }</pre>
   *
   * @param name Required. API resource name for inventory resource.
   *     <p>Format: `projects/{project}/locations/{location}/instances/{instance}/inventory`
   *     <p>For `{project}`, either `project-number` or `project-id` can be provided. For
   *     `{instance}`, either Compute Engine `instance-id` or `instance-name` can be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Inventory getInventory(InventoryName name) {
    GetInventoryRequest request =
        GetInventoryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getInventory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get inventory data for the specified VM instance. If the VM has no associated inventory, the
   * message `NOT_FOUND` is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   String name = InventoryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   Inventory response = osConfigZonalServiceClient.getInventory(name);
   * }
   * }</pre>
   *
   * @param name Required. API resource name for inventory resource.
   *     <p>Format: `projects/{project}/locations/{location}/instances/{instance}/inventory`
   *     <p>For `{project}`, either `project-number` or `project-id` can be provided. For
   *     `{instance}`, either Compute Engine `instance-id` or `instance-name` can be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Inventory getInventory(String name) {
    GetInventoryRequest request = GetInventoryRequest.newBuilder().setName(name).build();
    return getInventory(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get inventory data for the specified VM instance. If the VM has no associated inventory, the
   * message `NOT_FOUND` is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   GetInventoryRequest request =
   *       GetInventoryRequest.newBuilder()
   *           .setName(InventoryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setView(InventoryView.forNumber(0))
   *           .build();
   *   Inventory response = osConfigZonalServiceClient.getInventory(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Inventory getInventory(GetInventoryRequest request) {
    return getInventoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get inventory data for the specified VM instance. If the VM has no associated inventory, the
   * message `NOT_FOUND` is returned.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   GetInventoryRequest request =
   *       GetInventoryRequest.newBuilder()
   *           .setName(InventoryName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setView(InventoryView.forNumber(0))
   *           .build();
   *   ApiFuture<Inventory> future =
   *       osConfigZonalServiceClient.getInventoryCallable().futureCall(request);
   *   // Do something.
   *   Inventory response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInventoryRequest, Inventory> getInventoryCallable() {
    return stub.getInventoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List inventory data for all VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   InstanceName parent =
   *       InstanceName.ofProjectZoneInstanceName("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   for (Inventory element : osConfigZonalServiceClient.listInventories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name.
   *     <p>Format: `projects/{project}/locations/{location}/instances/-`
   *     <p>For `{project}`, either `project-number` or `project-id` can be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInventoriesPagedResponse listInventories(InstanceName parent) {
    ListInventoriesRequest request =
        ListInventoriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listInventories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List inventory data for all VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   String parent =
   *       InstanceName.ofProjectZoneInstanceName("[PROJECT]", "[ZONE]", "[INSTANCE]").toString();
   *   for (Inventory element : osConfigZonalServiceClient.listInventories(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name.
   *     <p>Format: `projects/{project}/locations/{location}/instances/-`
   *     <p>For `{project}`, either `project-number` or `project-id` can be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInventoriesPagedResponse listInventories(String parent) {
    ListInventoriesRequest request = ListInventoriesRequest.newBuilder().setParent(parent).build();
    return listInventories(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List inventory data for all VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListInventoriesRequest request =
   *       ListInventoriesRequest.newBuilder()
   *           .setParent(
   *               InstanceName.ofProjectZoneInstanceName("[PROJECT]", "[ZONE]", "[INSTANCE]")
   *                   .toString())
   *           .setView(InventoryView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (Inventory element : osConfigZonalServiceClient.listInventories(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInventoriesPagedResponse listInventories(ListInventoriesRequest request) {
    return listInventoriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List inventory data for all VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListInventoriesRequest request =
   *       ListInventoriesRequest.newBuilder()
   *           .setParent(
   *               InstanceName.ofProjectZoneInstanceName("[PROJECT]", "[ZONE]", "[INSTANCE]")
   *                   .toString())
   *           .setView(InventoryView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<Inventory> future =
   *       osConfigZonalServiceClient.listInventoriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Inventory element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInventoriesRequest, ListInventoriesPagedResponse>
      listInventoriesPagedCallable() {
    return stub.listInventoriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List inventory data for all VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListInventoriesRequest request =
   *       ListInventoriesRequest.newBuilder()
   *           .setParent(
   *               InstanceName.ofProjectZoneInstanceName("[PROJECT]", "[ZONE]", "[INSTANCE]")
   *                   .toString())
   *           .setView(InventoryView.forNumber(0))
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListInventoriesResponse response =
   *         osConfigZonalServiceClient.listInventoriesCallable().call(request);
   *     for (Inventory element : response.getResponsesList()) {
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
  public final UnaryCallable<ListInventoriesRequest, ListInventoriesResponse>
      listInventoriesCallable() {
    return stub.listInventoriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the vulnerability report for the specified VM instance. Only VMs with inventory data have
   * vulnerability reports associated with them.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   VulnerabilityReportName name =
   *       VulnerabilityReportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   VulnerabilityReport response = osConfigZonalServiceClient.getVulnerabilityReport(name);
   * }
   * }</pre>
   *
   * @param name Required. API resource name for vulnerability resource.
   *     <p>Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/vulnerabilityReport`
   *     <p>For `{project}`, either `project-number` or `project-id` can be provided. For
   *     `{instance}`, either Compute Engine `instance-id` or `instance-name` can be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VulnerabilityReport getVulnerabilityReport(VulnerabilityReportName name) {
    GetVulnerabilityReportRequest request =
        GetVulnerabilityReportRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getVulnerabilityReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the vulnerability report for the specified VM instance. Only VMs with inventory data have
   * vulnerability reports associated with them.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   String name = VulnerabilityReportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   VulnerabilityReport response = osConfigZonalServiceClient.getVulnerabilityReport(name);
   * }
   * }</pre>
   *
   * @param name Required. API resource name for vulnerability resource.
   *     <p>Format:
   *     `projects/{project}/locations/{location}/instances/{instance}/vulnerabilityReport`
   *     <p>For `{project}`, either `project-number` or `project-id` can be provided. For
   *     `{instance}`, either Compute Engine `instance-id` or `instance-name` can be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VulnerabilityReport getVulnerabilityReport(String name) {
    GetVulnerabilityReportRequest request =
        GetVulnerabilityReportRequest.newBuilder().setName(name).build();
    return getVulnerabilityReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the vulnerability report for the specified VM instance. Only VMs with inventory data have
   * vulnerability reports associated with them.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   GetVulnerabilityReportRequest request =
   *       GetVulnerabilityReportRequest.newBuilder()
   *           .setName(
   *               VulnerabilityReportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   VulnerabilityReport response = osConfigZonalServiceClient.getVulnerabilityReport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final VulnerabilityReport getVulnerabilityReport(GetVulnerabilityReportRequest request) {
    return getVulnerabilityReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the vulnerability report for the specified VM instance. Only VMs with inventory data have
   * vulnerability reports associated with them.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   GetVulnerabilityReportRequest request =
   *       GetVulnerabilityReportRequest.newBuilder()
   *           .setName(
   *               VulnerabilityReportName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<VulnerabilityReport> future =
   *       osConfigZonalServiceClient.getVulnerabilityReportCallable().futureCall(request);
   *   // Do something.
   *   VulnerabilityReport response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetVulnerabilityReportRequest, VulnerabilityReport>
      getVulnerabilityReportCallable() {
    return stub.getVulnerabilityReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List vulnerability reports for all VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   InstanceName parent =
   *       InstanceName.ofProjectZoneInstanceName("[PROJECT]", "[ZONE]", "[INSTANCE]");
   *   for (VulnerabilityReport element :
   *       osConfigZonalServiceClient.listVulnerabilityReports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name.
   *     <p>Format: `projects/{project}/locations/{location}/instances/-`
   *     <p>For `{project}`, either `project-number` or `project-id` can be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVulnerabilityReportsPagedResponse listVulnerabilityReports(InstanceName parent) {
    ListVulnerabilityReportsRequest request =
        ListVulnerabilityReportsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listVulnerabilityReports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List vulnerability reports for all VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   String parent =
   *       InstanceName.ofProjectZoneInstanceName("[PROJECT]", "[ZONE]", "[INSTANCE]").toString();
   *   for (VulnerabilityReport element :
   *       osConfigZonalServiceClient.listVulnerabilityReports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource name.
   *     <p>Format: `projects/{project}/locations/{location}/instances/-`
   *     <p>For `{project}`, either `project-number` or `project-id` can be provided.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVulnerabilityReportsPagedResponse listVulnerabilityReports(String parent) {
    ListVulnerabilityReportsRequest request =
        ListVulnerabilityReportsRequest.newBuilder().setParent(parent).build();
    return listVulnerabilityReports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List vulnerability reports for all VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListVulnerabilityReportsRequest request =
   *       ListVulnerabilityReportsRequest.newBuilder()
   *           .setParent(
   *               InstanceName.ofProjectZoneInstanceName("[PROJECT]", "[ZONE]", "[INSTANCE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (VulnerabilityReport element :
   *       osConfigZonalServiceClient.listVulnerabilityReports(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListVulnerabilityReportsPagedResponse listVulnerabilityReports(
      ListVulnerabilityReportsRequest request) {
    return listVulnerabilityReportsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List vulnerability reports for all VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListVulnerabilityReportsRequest request =
   *       ListVulnerabilityReportsRequest.newBuilder()
   *           .setParent(
   *               InstanceName.ofProjectZoneInstanceName("[PROJECT]", "[ZONE]", "[INSTANCE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<VulnerabilityReport> future =
   *       osConfigZonalServiceClient.listVulnerabilityReportsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (VulnerabilityReport element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListVulnerabilityReportsRequest, ListVulnerabilityReportsPagedResponse>
      listVulnerabilityReportsPagedCallable() {
    return stub.listVulnerabilityReportsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List vulnerability reports for all VM instances in the specified zone.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (OsConfigZonalServiceClient osConfigZonalServiceClient =
   *     OsConfigZonalServiceClient.create()) {
   *   ListVulnerabilityReportsRequest request =
   *       ListVulnerabilityReportsRequest.newBuilder()
   *           .setParent(
   *               InstanceName.ofProjectZoneInstanceName("[PROJECT]", "[ZONE]", "[INSTANCE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListVulnerabilityReportsResponse response =
   *         osConfigZonalServiceClient.listVulnerabilityReportsCallable().call(request);
   *     for (VulnerabilityReport element : response.getResponsesList()) {
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
  public final UnaryCallable<ListVulnerabilityReportsRequest, ListVulnerabilityReportsResponse>
      listVulnerabilityReportsCallable() {
    return stub.listVulnerabilityReportsCallable();
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

  public static class ListInventoriesPagedResponse
      extends AbstractPagedListResponse<
          ListInventoriesRequest,
          ListInventoriesResponse,
          Inventory,
          ListInventoriesPage,
          ListInventoriesFixedSizeCollection> {

    public static ApiFuture<ListInventoriesPagedResponse> createAsync(
        PageContext<ListInventoriesRequest, ListInventoriesResponse, Inventory> context,
        ApiFuture<ListInventoriesResponse> futureResponse) {
      ApiFuture<ListInventoriesPage> futurePage =
          ListInventoriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListInventoriesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListInventoriesPagedResponse(ListInventoriesPage page) {
      super(page, ListInventoriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInventoriesPage
      extends AbstractPage<
          ListInventoriesRequest, ListInventoriesResponse, Inventory, ListInventoriesPage> {

    private ListInventoriesPage(
        PageContext<ListInventoriesRequest, ListInventoriesResponse, Inventory> context,
        ListInventoriesResponse response) {
      super(context, response);
    }

    private static ListInventoriesPage createEmptyPage() {
      return new ListInventoriesPage(null, null);
    }

    @Override
    protected ListInventoriesPage createPage(
        PageContext<ListInventoriesRequest, ListInventoriesResponse, Inventory> context,
        ListInventoriesResponse response) {
      return new ListInventoriesPage(context, response);
    }

    @Override
    public ApiFuture<ListInventoriesPage> createPageAsync(
        PageContext<ListInventoriesRequest, ListInventoriesResponse, Inventory> context,
        ApiFuture<ListInventoriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInventoriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInventoriesRequest,
          ListInventoriesResponse,
          Inventory,
          ListInventoriesPage,
          ListInventoriesFixedSizeCollection> {

    private ListInventoriesFixedSizeCollection(
        List<ListInventoriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInventoriesFixedSizeCollection createEmptyCollection() {
      return new ListInventoriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInventoriesFixedSizeCollection createCollection(
        List<ListInventoriesPage> pages, int collectionSize) {
      return new ListInventoriesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListVulnerabilityReportsPagedResponse
      extends AbstractPagedListResponse<
          ListVulnerabilityReportsRequest,
          ListVulnerabilityReportsResponse,
          VulnerabilityReport,
          ListVulnerabilityReportsPage,
          ListVulnerabilityReportsFixedSizeCollection> {

    public static ApiFuture<ListVulnerabilityReportsPagedResponse> createAsync(
        PageContext<
                ListVulnerabilityReportsRequest,
                ListVulnerabilityReportsResponse,
                VulnerabilityReport>
            context,
        ApiFuture<ListVulnerabilityReportsResponse> futureResponse) {
      ApiFuture<ListVulnerabilityReportsPage> futurePage =
          ListVulnerabilityReportsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListVulnerabilityReportsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListVulnerabilityReportsPagedResponse(ListVulnerabilityReportsPage page) {
      super(page, ListVulnerabilityReportsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListVulnerabilityReportsPage
      extends AbstractPage<
          ListVulnerabilityReportsRequest,
          ListVulnerabilityReportsResponse,
          VulnerabilityReport,
          ListVulnerabilityReportsPage> {

    private ListVulnerabilityReportsPage(
        PageContext<
                ListVulnerabilityReportsRequest,
                ListVulnerabilityReportsResponse,
                VulnerabilityReport>
            context,
        ListVulnerabilityReportsResponse response) {
      super(context, response);
    }

    private static ListVulnerabilityReportsPage createEmptyPage() {
      return new ListVulnerabilityReportsPage(null, null);
    }

    @Override
    protected ListVulnerabilityReportsPage createPage(
        PageContext<
                ListVulnerabilityReportsRequest,
                ListVulnerabilityReportsResponse,
                VulnerabilityReport>
            context,
        ListVulnerabilityReportsResponse response) {
      return new ListVulnerabilityReportsPage(context, response);
    }

    @Override
    public ApiFuture<ListVulnerabilityReportsPage> createPageAsync(
        PageContext<
                ListVulnerabilityReportsRequest,
                ListVulnerabilityReportsResponse,
                VulnerabilityReport>
            context,
        ApiFuture<ListVulnerabilityReportsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListVulnerabilityReportsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListVulnerabilityReportsRequest,
          ListVulnerabilityReportsResponse,
          VulnerabilityReport,
          ListVulnerabilityReportsPage,
          ListVulnerabilityReportsFixedSizeCollection> {

    private ListVulnerabilityReportsFixedSizeCollection(
        List<ListVulnerabilityReportsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListVulnerabilityReportsFixedSizeCollection createEmptyCollection() {
      return new ListVulnerabilityReportsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListVulnerabilityReportsFixedSizeCollection createCollection(
        List<ListVulnerabilityReportsPage> pages, int collectionSize) {
      return new ListVulnerabilityReportsFixedSizeCollection(pages, collectionSize);
    }
  }
}
