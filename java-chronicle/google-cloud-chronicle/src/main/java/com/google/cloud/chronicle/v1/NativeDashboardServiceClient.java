/*
 * Copyright 2026 Google LLC
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

package com.google.cloud.chronicle.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.stub.NativeDashboardServiceStub;
import com.google.cloud.chronicle.v1.stub.NativeDashboardServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service providing functionality for managing native dashboards.
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
 * try (NativeDashboardServiceClient nativeDashboardServiceClient =
 *     NativeDashboardServiceClient.create()) {
 *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   NativeDashboard nativeDashboard = NativeDashboard.newBuilder().build();
 *   NativeDashboard response =
 *       nativeDashboardServiceClient.createNativeDashboard(parent, nativeDashboard);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the NativeDashboardServiceClient object to clean up
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
 *      <td><p> CreateNativeDashboard</td>
 *      <td><p> Create a dashboard.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createNativeDashboard(CreateNativeDashboardRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createNativeDashboard(InstanceName parent, NativeDashboard nativeDashboard)
 *           <li><p> createNativeDashboard(String parent, NativeDashboard nativeDashboard)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createNativeDashboardCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetNativeDashboard</td>
 *      <td><p> Get a dashboard.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getNativeDashboard(GetNativeDashboardRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getNativeDashboard(NativeDashboardName name)
 *           <li><p> getNativeDashboard(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getNativeDashboardCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListNativeDashboards</td>
 *      <td><p> List all dashboards.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listNativeDashboards(ListNativeDashboardsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listNativeDashboards(InstanceName parent)
 *           <li><p> listNativeDashboards(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listNativeDashboardsPagedCallable()
 *           <li><p> listNativeDashboardsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateNativeDashboard</td>
 *      <td><p> Update a dashboard.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateNativeDashboard(UpdateNativeDashboardRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateNativeDashboard(NativeDashboard nativeDashboard, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateNativeDashboardCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DuplicateNativeDashboard</td>
 *      <td><p> Duplicate a dashboard.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> duplicateNativeDashboard(DuplicateNativeDashboardRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> duplicateNativeDashboard(NativeDashboardName name, NativeDashboard nativeDashboard)
 *           <li><p> duplicateNativeDashboard(String name, NativeDashboard nativeDashboard)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> duplicateNativeDashboardCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteNativeDashboard</td>
 *      <td><p> Delete a dashboard.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteNativeDashboard(DeleteNativeDashboardRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteNativeDashboard(NativeDashboardName name)
 *           <li><p> deleteNativeDashboard(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteNativeDashboardCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> AddChart</td>
 *      <td><p> Add chart in a dashboard.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> addChart(AddChartRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> addChart(NativeDashboardName name, DashboardQuery dashboardQuery, DashboardChart dashboardChart)
 *           <li><p> addChart(String name, DashboardQuery dashboardQuery, DashboardChart dashboardChart)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> addChartCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RemoveChart</td>
 *      <td><p> Remove chart from a dashboard.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> removeChart(RemoveChartRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> removeChart(NativeDashboardName name)
 *           <li><p> removeChart(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> removeChartCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> EditChart</td>
 *      <td><p> Edit chart in a dashboard.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> editChart(EditChartRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> editChart(NativeDashboardName name, DashboardQuery dashboardQuery, DashboardChart dashboardChart, FieldMask editMask)
 *           <li><p> editChart(String name, DashboardQuery dashboardQuery, DashboardChart dashboardChart, FieldMask editMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> editChartCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DuplicateChart</td>
 *      <td><p> Duplicate chart in a dashboard.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> duplicateChart(DuplicateChartRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> duplicateChart(NativeDashboardName name)
 *           <li><p> duplicateChart(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> duplicateChartCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ExportNativeDashboards</td>
 *      <td><p> Exports the dashboards.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportNativeDashboards(ExportNativeDashboardsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> exportNativeDashboards(InstanceName parent, List&lt;String&gt; names)
 *           <li><p> exportNativeDashboards(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportNativeDashboardsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportNativeDashboards</td>
 *      <td><p> Imports the dashboards.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importNativeDashboards(ImportNativeDashboardsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> importNativeDashboards(InstanceName parent, ImportNativeDashboardsInlineSource source)
 *           <li><p> importNativeDashboards(String parent, ImportNativeDashboardsInlineSource source)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importNativeDashboardsCallable()
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
 * <p>This class can be customized by passing in a custom instance of NativeDashboardServiceSettings
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
 * NativeDashboardServiceSettings nativeDashboardServiceSettings =
 *     NativeDashboardServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * NativeDashboardServiceClient nativeDashboardServiceClient =
 *     NativeDashboardServiceClient.create(nativeDashboardServiceSettings);
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
 * NativeDashboardServiceSettings nativeDashboardServiceSettings =
 *     NativeDashboardServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * NativeDashboardServiceClient nativeDashboardServiceClient =
 *     NativeDashboardServiceClient.create(nativeDashboardServiceSettings);
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
 * NativeDashboardServiceSettings nativeDashboardServiceSettings =
 *     NativeDashboardServiceSettings.newHttpJsonBuilder().build();
 * NativeDashboardServiceClient nativeDashboardServiceClient =
 *     NativeDashboardServiceClient.create(nativeDashboardServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class NativeDashboardServiceClient implements BackgroundResource {
  private final NativeDashboardServiceSettings settings;
  private final NativeDashboardServiceStub stub;

  /** Constructs an instance of NativeDashboardServiceClient with default settings. */
  public static final NativeDashboardServiceClient create() throws IOException {
    return create(NativeDashboardServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of NativeDashboardServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final NativeDashboardServiceClient create(NativeDashboardServiceSettings settings)
      throws IOException {
    return new NativeDashboardServiceClient(settings);
  }

  /**
   * Constructs an instance of NativeDashboardServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(NativeDashboardServiceSettings).
   */
  public static final NativeDashboardServiceClient create(NativeDashboardServiceStub stub) {
    return new NativeDashboardServiceClient(stub);
  }

  /**
   * Constructs an instance of NativeDashboardServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected NativeDashboardServiceClient(NativeDashboardServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((NativeDashboardServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected NativeDashboardServiceClient(NativeDashboardServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final NativeDashboardServiceSettings getSettings() {
    return settings;
  }

  public NativeDashboardServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   NativeDashboard nativeDashboard = NativeDashboard.newBuilder().build();
   *   NativeDashboard response =
   *       nativeDashboardServiceClient.createNativeDashboard(parent, nativeDashboard);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this dashboard will be created. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @param nativeDashboard Required. The dashboard to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NativeDashboard createNativeDashboard(
      InstanceName parent, NativeDashboard nativeDashboard) {
    CreateNativeDashboardRequest request =
        CreateNativeDashboardRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setNativeDashboard(nativeDashboard)
            .build();
    return createNativeDashboard(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   NativeDashboard nativeDashboard = NativeDashboard.newBuilder().build();
   *   NativeDashboard response =
   *       nativeDashboardServiceClient.createNativeDashboard(parent, nativeDashboard);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this dashboard will be created. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @param nativeDashboard Required. The dashboard to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NativeDashboard createNativeDashboard(
      String parent, NativeDashboard nativeDashboard) {
    CreateNativeDashboardRequest request =
        CreateNativeDashboardRequest.newBuilder()
            .setParent(parent)
            .setNativeDashboard(nativeDashboard)
            .build();
    return createNativeDashboard(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   CreateNativeDashboardRequest request =
   *       CreateNativeDashboardRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setNativeDashboard(NativeDashboard.newBuilder().build())
   *           .build();
   *   NativeDashboard response = nativeDashboardServiceClient.createNativeDashboard(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NativeDashboard createNativeDashboard(CreateNativeDashboardRequest request) {
    return createNativeDashboardCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   CreateNativeDashboardRequest request =
   *       CreateNativeDashboardRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setNativeDashboard(NativeDashboard.newBuilder().build())
   *           .build();
   *   ApiFuture<NativeDashboard> future =
   *       nativeDashboardServiceClient.createNativeDashboardCallable().futureCall(request);
   *   // Do something.
   *   NativeDashboard response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateNativeDashboardRequest, NativeDashboard>
      createNativeDashboardCallable() {
    return stub.createNativeDashboardCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   NativeDashboardName name =
   *       NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");
   *   NativeDashboard response = nativeDashboardServiceClient.getNativeDashboard(name);
   * }
   * }</pre>
   *
   * @param name Required. The dashboard name to fetch. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/nativeDashboards/{dashboard}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NativeDashboard getNativeDashboard(NativeDashboardName name) {
    GetNativeDashboardRequest request =
        GetNativeDashboardRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getNativeDashboard(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   String name =
   *       NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]").toString();
   *   NativeDashboard response = nativeDashboardServiceClient.getNativeDashboard(name);
   * }
   * }</pre>
   *
   * @param name Required. The dashboard name to fetch. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/nativeDashboards/{dashboard}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NativeDashboard getNativeDashboard(String name) {
    GetNativeDashboardRequest request =
        GetNativeDashboardRequest.newBuilder().setName(name).build();
    return getNativeDashboard(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   GetNativeDashboardRequest request =
   *       GetNativeDashboardRequest.newBuilder()
   *           .setName(
   *               NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
   *                   .toString())
   *           .setView(NativeDashboardView.forNumber(0))
   *           .build();
   *   NativeDashboard response = nativeDashboardServiceClient.getNativeDashboard(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NativeDashboard getNativeDashboard(GetNativeDashboardRequest request) {
    return getNativeDashboardCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   GetNativeDashboardRequest request =
   *       GetNativeDashboardRequest.newBuilder()
   *           .setName(
   *               NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
   *                   .toString())
   *           .setView(NativeDashboardView.forNumber(0))
   *           .build();
   *   ApiFuture<NativeDashboard> future =
   *       nativeDashboardServiceClient.getNativeDashboardCallable().futureCall(request);
   *   // Do something.
   *   NativeDashboard response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetNativeDashboardRequest, NativeDashboard>
      getNativeDashboardCallable() {
    return stub.getNativeDashboardCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all dashboards.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (NativeDashboard element :
   *       nativeDashboardServiceClient.listNativeDashboards(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent owning this dashboard collection. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNativeDashboardsPagedResponse listNativeDashboards(InstanceName parent) {
    ListNativeDashboardsRequest request =
        ListNativeDashboardsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listNativeDashboards(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all dashboards.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (NativeDashboard element :
   *       nativeDashboardServiceClient.listNativeDashboards(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent owning this dashboard collection. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNativeDashboardsPagedResponse listNativeDashboards(String parent) {
    ListNativeDashboardsRequest request =
        ListNativeDashboardsRequest.newBuilder().setParent(parent).build();
    return listNativeDashboards(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all dashboards.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   ListNativeDashboardsRequest request =
   *       ListNativeDashboardsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(NativeDashboardView.forNumber(0))
   *           .build();
   *   for (NativeDashboard element :
   *       nativeDashboardServiceClient.listNativeDashboards(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListNativeDashboardsPagedResponse listNativeDashboards(
      ListNativeDashboardsRequest request) {
    return listNativeDashboardsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all dashboards.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   ListNativeDashboardsRequest request =
   *       ListNativeDashboardsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(NativeDashboardView.forNumber(0))
   *           .build();
   *   ApiFuture<NativeDashboard> future =
   *       nativeDashboardServiceClient.listNativeDashboardsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (NativeDashboard element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListNativeDashboardsRequest, ListNativeDashboardsPagedResponse>
      listNativeDashboardsPagedCallable() {
    return stub.listNativeDashboardsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all dashboards.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   ListNativeDashboardsRequest request =
   *       ListNativeDashboardsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(NativeDashboardView.forNumber(0))
   *           .build();
   *   while (true) {
   *     ListNativeDashboardsResponse response =
   *         nativeDashboardServiceClient.listNativeDashboardsCallable().call(request);
   *     for (NativeDashboard element : response.getNativeDashboardsList()) {
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
  public final UnaryCallable<ListNativeDashboardsRequest, ListNativeDashboardsResponse>
      listNativeDashboardsCallable() {
    return stub.listNativeDashboardsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   NativeDashboard nativeDashboard = NativeDashboard.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   NativeDashboard response =
   *       nativeDashboardServiceClient.updateNativeDashboard(nativeDashboard, updateMask);
   * }
   * }</pre>
   *
   * @param nativeDashboard Required. The dashboard to update.
   *     <p>The dashboard's `name` field is used to identify the dashboard to update. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/nativeDashboards/{dashboard}
   * @param updateMask Required. LINT.IfChange(update_mask_values) The list of fields to update.
   *     Supported paths are - display_name description definition.filters definition.charts type
   *     access dashboard_user_data.is_pinned
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NativeDashboard updateNativeDashboard(
      NativeDashboard nativeDashboard, FieldMask updateMask) {
    UpdateNativeDashboardRequest request =
        UpdateNativeDashboardRequest.newBuilder()
            .setNativeDashboard(nativeDashboard)
            .setUpdateMask(updateMask)
            .build();
    return updateNativeDashboard(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   UpdateNativeDashboardRequest request =
   *       UpdateNativeDashboardRequest.newBuilder()
   *           .setNativeDashboard(NativeDashboard.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   NativeDashboard response = nativeDashboardServiceClient.updateNativeDashboard(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NativeDashboard updateNativeDashboard(UpdateNativeDashboardRequest request) {
    return updateNativeDashboardCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   UpdateNativeDashboardRequest request =
   *       UpdateNativeDashboardRequest.newBuilder()
   *           .setNativeDashboard(NativeDashboard.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<NativeDashboard> future =
   *       nativeDashboardServiceClient.updateNativeDashboardCallable().futureCall(request);
   *   // Do something.
   *   NativeDashboard response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateNativeDashboardRequest, NativeDashboard>
      updateNativeDashboardCallable() {
    return stub.updateNativeDashboardCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Duplicate a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   NativeDashboardName name =
   *       NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");
   *   NativeDashboard nativeDashboard = NativeDashboard.newBuilder().build();
   *   NativeDashboard response =
   *       nativeDashboardServiceClient.duplicateNativeDashboard(name, nativeDashboard);
   * }
   * }</pre>
   *
   * @param name Required. The dashboard name to duplicate. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/nativeDashboards/{dashboard}
   * @param nativeDashboard Required. Any fields that need modification can be passed through this
   *     like name, description etc.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NativeDashboard duplicateNativeDashboard(
      NativeDashboardName name, NativeDashboard nativeDashboard) {
    DuplicateNativeDashboardRequest request =
        DuplicateNativeDashboardRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setNativeDashboard(nativeDashboard)
            .build();
    return duplicateNativeDashboard(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Duplicate a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   String name =
   *       NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]").toString();
   *   NativeDashboard nativeDashboard = NativeDashboard.newBuilder().build();
   *   NativeDashboard response =
   *       nativeDashboardServiceClient.duplicateNativeDashboard(name, nativeDashboard);
   * }
   * }</pre>
   *
   * @param name Required. The dashboard name to duplicate. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/nativeDashboards/{dashboard}
   * @param nativeDashboard Required. Any fields that need modification can be passed through this
   *     like name, description etc.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NativeDashboard duplicateNativeDashboard(
      String name, NativeDashboard nativeDashboard) {
    DuplicateNativeDashboardRequest request =
        DuplicateNativeDashboardRequest.newBuilder()
            .setName(name)
            .setNativeDashboard(nativeDashboard)
            .build();
    return duplicateNativeDashboard(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Duplicate a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   DuplicateNativeDashboardRequest request =
   *       DuplicateNativeDashboardRequest.newBuilder()
   *           .setName(
   *               NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
   *                   .toString())
   *           .setNativeDashboard(NativeDashboard.newBuilder().build())
   *           .build();
   *   NativeDashboard response = nativeDashboardServiceClient.duplicateNativeDashboard(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NativeDashboard duplicateNativeDashboard(DuplicateNativeDashboardRequest request) {
    return duplicateNativeDashboardCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Duplicate a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   DuplicateNativeDashboardRequest request =
   *       DuplicateNativeDashboardRequest.newBuilder()
   *           .setName(
   *               NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
   *                   .toString())
   *           .setNativeDashboard(NativeDashboard.newBuilder().build())
   *           .build();
   *   ApiFuture<NativeDashboard> future =
   *       nativeDashboardServiceClient.duplicateNativeDashboardCallable().futureCall(request);
   *   // Do something.
   *   NativeDashboard response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DuplicateNativeDashboardRequest, NativeDashboard>
      duplicateNativeDashboardCallable() {
    return stub.duplicateNativeDashboardCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   NativeDashboardName name =
   *       NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");
   *   nativeDashboardServiceClient.deleteNativeDashboard(name);
   * }
   * }</pre>
   *
   * @param name Required. The dashboard name to delete. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/nativeDashboards/{dashboard}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteNativeDashboard(NativeDashboardName name) {
    DeleteNativeDashboardRequest request =
        DeleteNativeDashboardRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteNativeDashboard(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   String name =
   *       NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]").toString();
   *   nativeDashboardServiceClient.deleteNativeDashboard(name);
   * }
   * }</pre>
   *
   * @param name Required. The dashboard name to delete. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/nativeDashboards/{dashboard}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteNativeDashboard(String name) {
    DeleteNativeDashboardRequest request =
        DeleteNativeDashboardRequest.newBuilder().setName(name).build();
    deleteNativeDashboard(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   DeleteNativeDashboardRequest request =
   *       DeleteNativeDashboardRequest.newBuilder()
   *           .setName(
   *               NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
   *                   .toString())
   *           .build();
   *   nativeDashboardServiceClient.deleteNativeDashboard(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteNativeDashboard(DeleteNativeDashboardRequest request) {
    deleteNativeDashboardCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   DeleteNativeDashboardRequest request =
   *       DeleteNativeDashboardRequest.newBuilder()
   *           .setName(
   *               NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       nativeDashboardServiceClient.deleteNativeDashboardCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteNativeDashboardRequest, Empty> deleteNativeDashboardCallable() {
    return stub.deleteNativeDashboardCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Add chart in a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   NativeDashboardName name =
   *       NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");
   *   DashboardQuery dashboardQuery = DashboardQuery.newBuilder().build();
   *   DashboardChart dashboardChart = DashboardChart.newBuilder().build();
   *   AddChartResponse response =
   *       nativeDashboardServiceClient.addChart(name, dashboardQuery, dashboardChart);
   * }
   * }</pre>
   *
   * @param name Required. The dashboard name to add chart in. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/nativeDashboards/{dashboard}
   * @param dashboardQuery Optional. Query used to create the chart.
   * @param dashboardChart Required. Chart to be added to the dashboard.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddChartResponse addChart(
      NativeDashboardName name, DashboardQuery dashboardQuery, DashboardChart dashboardChart) {
    AddChartRequest request =
        AddChartRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setDashboardQuery(dashboardQuery)
            .setDashboardChart(dashboardChart)
            .build();
    return addChart(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Add chart in a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   String name =
   *       NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]").toString();
   *   DashboardQuery dashboardQuery = DashboardQuery.newBuilder().build();
   *   DashboardChart dashboardChart = DashboardChart.newBuilder().build();
   *   AddChartResponse response =
   *       nativeDashboardServiceClient.addChart(name, dashboardQuery, dashboardChart);
   * }
   * }</pre>
   *
   * @param name Required. The dashboard name to add chart in. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/nativeDashboards/{dashboard}
   * @param dashboardQuery Optional. Query used to create the chart.
   * @param dashboardChart Required. Chart to be added to the dashboard.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddChartResponse addChart(
      String name, DashboardQuery dashboardQuery, DashboardChart dashboardChart) {
    AddChartRequest request =
        AddChartRequest.newBuilder()
            .setName(name)
            .setDashboardQuery(dashboardQuery)
            .setDashboardChart(dashboardChart)
            .build();
    return addChart(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Add chart in a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   AddChartRequest request =
   *       AddChartRequest.newBuilder()
   *           .setName(
   *               NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
   *                   .toString())
   *           .setDashboardQuery(DashboardQuery.newBuilder().build())
   *           .setDashboardChart(DashboardChart.newBuilder().build())
   *           .setChartLayout(DashboardDefinition.ChartConfig.ChartLayout.newBuilder().build())
   *           .build();
   *   AddChartResponse response = nativeDashboardServiceClient.addChart(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AddChartResponse addChart(AddChartRequest request) {
    return addChartCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Add chart in a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   AddChartRequest request =
   *       AddChartRequest.newBuilder()
   *           .setName(
   *               NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
   *                   .toString())
   *           .setDashboardQuery(DashboardQuery.newBuilder().build())
   *           .setDashboardChart(DashboardChart.newBuilder().build())
   *           .setChartLayout(DashboardDefinition.ChartConfig.ChartLayout.newBuilder().build())
   *           .build();
   *   ApiFuture<AddChartResponse> future =
   *       nativeDashboardServiceClient.addChartCallable().futureCall(request);
   *   // Do something.
   *   AddChartResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<AddChartRequest, AddChartResponse> addChartCallable() {
    return stub.addChartCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove chart from a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   NativeDashboardName name =
   *       NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");
   *   NativeDashboard response = nativeDashboardServiceClient.removeChart(name);
   * }
   * }</pre>
   *
   * @param name Required. The dashboard name to remove chart from. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/nativeDashboards/{dashboard}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NativeDashboard removeChart(NativeDashboardName name) {
    RemoveChartRequest request =
        RemoveChartRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return removeChart(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove chart from a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   String name =
   *       NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]").toString();
   *   NativeDashboard response = nativeDashboardServiceClient.removeChart(name);
   * }
   * }</pre>
   *
   * @param name Required. The dashboard name to remove chart from. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/nativeDashboards/{dashboard}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NativeDashboard removeChart(String name) {
    RemoveChartRequest request = RemoveChartRequest.newBuilder().setName(name).build();
    return removeChart(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove chart from a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   RemoveChartRequest request =
   *       RemoveChartRequest.newBuilder()
   *           .setName(
   *               NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
   *                   .toString())
   *           .setDashboardChart(
   *               DashboardChartName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[CHART]")
   *                   .toString())
   *           .build();
   *   NativeDashboard response = nativeDashboardServiceClient.removeChart(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final NativeDashboard removeChart(RemoveChartRequest request) {
    return removeChartCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Remove chart from a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   RemoveChartRequest request =
   *       RemoveChartRequest.newBuilder()
   *           .setName(
   *               NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
   *                   .toString())
   *           .setDashboardChart(
   *               DashboardChartName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[CHART]")
   *                   .toString())
   *           .build();
   *   ApiFuture<NativeDashboard> future =
   *       nativeDashboardServiceClient.removeChartCallable().futureCall(request);
   *   // Do something.
   *   NativeDashboard response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RemoveChartRequest, NativeDashboard> removeChartCallable() {
    return stub.removeChartCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Edit chart in a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   NativeDashboardName name =
   *       NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");
   *   DashboardQuery dashboardQuery = DashboardQuery.newBuilder().build();
   *   DashboardChart dashboardChart = DashboardChart.newBuilder().build();
   *   FieldMask editMask = FieldMask.newBuilder().build();
   *   EditChartResponse response =
   *       nativeDashboardServiceClient.editChart(name, dashboardQuery, dashboardChart, editMask);
   * }
   * }</pre>
   *
   * @param name Required. The dashboard name to edit chart in. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/nativeDashboards/{dashboard}
   * @param dashboardQuery Optional. Query for the edited chart.
   * @param dashboardChart Optional. Edited chart.
   * @param editMask Required. The list of fields to edit for chart and query. Supported paths in
   *     chart are - dashboard_chart.display_name dashboard_chart.description
   *     dashboard_chart.chart_datasource.data_sources dashboard_chart.visualization
   *     dashboard_chart.visualization.button dashboard_chart.visualization.markdown
   *     dashboard_chart.drill_down_config Supported paths in query are - dashboard_query.query
   *     dashboard_query.input
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EditChartResponse editChart(
      NativeDashboardName name,
      DashboardQuery dashboardQuery,
      DashboardChart dashboardChart,
      FieldMask editMask) {
    EditChartRequest request =
        EditChartRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setDashboardQuery(dashboardQuery)
            .setDashboardChart(dashboardChart)
            .setEditMask(editMask)
            .build();
    return editChart(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Edit chart in a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   String name =
   *       NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]").toString();
   *   DashboardQuery dashboardQuery = DashboardQuery.newBuilder().build();
   *   DashboardChart dashboardChart = DashboardChart.newBuilder().build();
   *   FieldMask editMask = FieldMask.newBuilder().build();
   *   EditChartResponse response =
   *       nativeDashboardServiceClient.editChart(name, dashboardQuery, dashboardChart, editMask);
   * }
   * }</pre>
   *
   * @param name Required. The dashboard name to edit chart in. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/nativeDashboards/{dashboard}
   * @param dashboardQuery Optional. Query for the edited chart.
   * @param dashboardChart Optional. Edited chart.
   * @param editMask Required. The list of fields to edit for chart and query. Supported paths in
   *     chart are - dashboard_chart.display_name dashboard_chart.description
   *     dashboard_chart.chart_datasource.data_sources dashboard_chart.visualization
   *     dashboard_chart.visualization.button dashboard_chart.visualization.markdown
   *     dashboard_chart.drill_down_config Supported paths in query are - dashboard_query.query
   *     dashboard_query.input
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EditChartResponse editChart(
      String name,
      DashboardQuery dashboardQuery,
      DashboardChart dashboardChart,
      FieldMask editMask) {
    EditChartRequest request =
        EditChartRequest.newBuilder()
            .setName(name)
            .setDashboardQuery(dashboardQuery)
            .setDashboardChart(dashboardChart)
            .setEditMask(editMask)
            .build();
    return editChart(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Edit chart in a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   EditChartRequest request =
   *       EditChartRequest.newBuilder()
   *           .setName(
   *               NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
   *                   .toString())
   *           .setDashboardQuery(DashboardQuery.newBuilder().build())
   *           .setDashboardChart(DashboardChart.newBuilder().build())
   *           .setEditMask(FieldMask.newBuilder().build())
   *           .addAllLanguageFeatures(new ArrayList<LanguageFeature>())
   *           .build();
   *   EditChartResponse response = nativeDashboardServiceClient.editChart(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EditChartResponse editChart(EditChartRequest request) {
    return editChartCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Edit chart in a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   EditChartRequest request =
   *       EditChartRequest.newBuilder()
   *           .setName(
   *               NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
   *                   .toString())
   *           .setDashboardQuery(DashboardQuery.newBuilder().build())
   *           .setDashboardChart(DashboardChart.newBuilder().build())
   *           .setEditMask(FieldMask.newBuilder().build())
   *           .addAllLanguageFeatures(new ArrayList<LanguageFeature>())
   *           .build();
   *   ApiFuture<EditChartResponse> future =
   *       nativeDashboardServiceClient.editChartCallable().futureCall(request);
   *   // Do something.
   *   EditChartResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EditChartRequest, EditChartResponse> editChartCallable() {
    return stub.editChartCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Duplicate chart in a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   NativeDashboardName name =
   *       NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]");
   *   DuplicateChartResponse response = nativeDashboardServiceClient.duplicateChart(name);
   * }
   * }</pre>
   *
   * @param name Required. The dashboard name that involves chart duplication. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/nativeDashboards/{dashboard}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DuplicateChartResponse duplicateChart(NativeDashboardName name) {
    DuplicateChartRequest request =
        DuplicateChartRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return duplicateChart(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Duplicate chart in a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   String name =
   *       NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]").toString();
   *   DuplicateChartResponse response = nativeDashboardServiceClient.duplicateChart(name);
   * }
   * }</pre>
   *
   * @param name Required. The dashboard name that involves chart duplication. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/nativeDashboards/{dashboard}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DuplicateChartResponse duplicateChart(String name) {
    DuplicateChartRequest request = DuplicateChartRequest.newBuilder().setName(name).build();
    return duplicateChart(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Duplicate chart in a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   DuplicateChartRequest request =
   *       DuplicateChartRequest.newBuilder()
   *           .setName(
   *               NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
   *                   .toString())
   *           .setDashboardChart(
   *               DashboardChartName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[CHART]")
   *                   .toString())
   *           .build();
   *   DuplicateChartResponse response = nativeDashboardServiceClient.duplicateChart(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DuplicateChartResponse duplicateChart(DuplicateChartRequest request) {
    return duplicateChartCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Duplicate chart in a dashboard.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   DuplicateChartRequest request =
   *       DuplicateChartRequest.newBuilder()
   *           .setName(
   *               NativeDashboardName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DASHBOARD]")
   *                   .toString())
   *           .setDashboardChart(
   *               DashboardChartName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[CHART]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DuplicateChartResponse> future =
   *       nativeDashboardServiceClient.duplicateChartCallable().futureCall(request);
   *   // Do something.
   *   DuplicateChartResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DuplicateChartRequest, DuplicateChartResponse>
      duplicateChartCallable() {
    return stub.duplicateChartCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the dashboards.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   List<String> names = new ArrayList<>();
   *   ExportNativeDashboardsResponse response =
   *       nativeDashboardServiceClient.exportNativeDashboards(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource that the dashboards to be exported belong to.
   *     Format: projects/{project}/locations/{location}/instances/{instance}
   * @param names Required. The resource names of the dashboards to export.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExportNativeDashboardsResponse exportNativeDashboards(
      InstanceName parent, List<String> names) {
    ExportNativeDashboardsRequest request =
        ExportNativeDashboardsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return exportNativeDashboards(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the dashboards.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   List<String> names = new ArrayList<>();
   *   ExportNativeDashboardsResponse response =
   *       nativeDashboardServiceClient.exportNativeDashboards(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource that the dashboards to be exported belong to.
   *     Format: projects/{project}/locations/{location}/instances/{instance}
   * @param names Required. The resource names of the dashboards to export.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExportNativeDashboardsResponse exportNativeDashboards(
      String parent, List<String> names) {
    ExportNativeDashboardsRequest request =
        ExportNativeDashboardsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return exportNativeDashboards(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the dashboards.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   ExportNativeDashboardsRequest request =
   *       ExportNativeDashboardsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ExportNativeDashboardsResponse response =
   *       nativeDashboardServiceClient.exportNativeDashboards(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ExportNativeDashboardsResponse exportNativeDashboards(
      ExportNativeDashboardsRequest request) {
    return exportNativeDashboardsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Exports the dashboards.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   ExportNativeDashboardsRequest request =
   *       ExportNativeDashboardsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<ExportNativeDashboardsResponse> future =
   *       nativeDashboardServiceClient.exportNativeDashboardsCallable().futureCall(request);
   *   // Do something.
   *   ExportNativeDashboardsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportNativeDashboardsRequest, ExportNativeDashboardsResponse>
      exportNativeDashboardsCallable() {
    return stub.exportNativeDashboardsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports the dashboards.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   ImportNativeDashboardsInlineSource source =
   *       ImportNativeDashboardsInlineSource.newBuilder().build();
   *   ImportNativeDashboardsResponse response =
   *       nativeDashboardServiceClient.importNativeDashboards(parent, source);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this dashboard will be created. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @param source Required. The data will imported from this proto.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportNativeDashboardsResponse importNativeDashboards(
      InstanceName parent, ImportNativeDashboardsInlineSource source) {
    ImportNativeDashboardsRequest request =
        ImportNativeDashboardsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setSource(source)
            .build();
    return importNativeDashboards(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports the dashboards.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   ImportNativeDashboardsInlineSource source =
   *       ImportNativeDashboardsInlineSource.newBuilder().build();
   *   ImportNativeDashboardsResponse response =
   *       nativeDashboardServiceClient.importNativeDashboards(parent, source);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this dashboard will be created. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @param source Required. The data will imported from this proto.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportNativeDashboardsResponse importNativeDashboards(
      String parent, ImportNativeDashboardsInlineSource source) {
    ImportNativeDashboardsRequest request =
        ImportNativeDashboardsRequest.newBuilder().setParent(parent).setSource(source).build();
    return importNativeDashboards(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports the dashboards.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   ImportNativeDashboardsRequest request =
   *       ImportNativeDashboardsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setSource(ImportNativeDashboardsInlineSource.newBuilder().build())
   *           .build();
   *   ImportNativeDashboardsResponse response =
   *       nativeDashboardServiceClient.importNativeDashboards(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ImportNativeDashboardsResponse importNativeDashboards(
      ImportNativeDashboardsRequest request) {
    return importNativeDashboardsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Imports the dashboards.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (NativeDashboardServiceClient nativeDashboardServiceClient =
   *     NativeDashboardServiceClient.create()) {
   *   ImportNativeDashboardsRequest request =
   *       ImportNativeDashboardsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setSource(ImportNativeDashboardsInlineSource.newBuilder().build())
   *           .build();
   *   ApiFuture<ImportNativeDashboardsResponse> future =
   *       nativeDashboardServiceClient.importNativeDashboardsCallable().futureCall(request);
   *   // Do something.
   *   ImportNativeDashboardsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportNativeDashboardsRequest, ImportNativeDashboardsResponse>
      importNativeDashboardsCallable() {
    return stub.importNativeDashboardsCallable();
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

  public static class ListNativeDashboardsPagedResponse
      extends AbstractPagedListResponse<
          ListNativeDashboardsRequest,
          ListNativeDashboardsResponse,
          NativeDashboard,
          ListNativeDashboardsPage,
          ListNativeDashboardsFixedSizeCollection> {

    public static ApiFuture<ListNativeDashboardsPagedResponse> createAsync(
        PageContext<ListNativeDashboardsRequest, ListNativeDashboardsResponse, NativeDashboard>
            context,
        ApiFuture<ListNativeDashboardsResponse> futureResponse) {
      ApiFuture<ListNativeDashboardsPage> futurePage =
          ListNativeDashboardsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListNativeDashboardsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListNativeDashboardsPagedResponse(ListNativeDashboardsPage page) {
      super(page, ListNativeDashboardsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListNativeDashboardsPage
      extends AbstractPage<
          ListNativeDashboardsRequest,
          ListNativeDashboardsResponse,
          NativeDashboard,
          ListNativeDashboardsPage> {

    private ListNativeDashboardsPage(
        PageContext<ListNativeDashboardsRequest, ListNativeDashboardsResponse, NativeDashboard>
            context,
        ListNativeDashboardsResponse response) {
      super(context, response);
    }

    private static ListNativeDashboardsPage createEmptyPage() {
      return new ListNativeDashboardsPage(null, null);
    }

    @Override
    protected ListNativeDashboardsPage createPage(
        PageContext<ListNativeDashboardsRequest, ListNativeDashboardsResponse, NativeDashboard>
            context,
        ListNativeDashboardsResponse response) {
      return new ListNativeDashboardsPage(context, response);
    }

    @Override
    public ApiFuture<ListNativeDashboardsPage> createPageAsync(
        PageContext<ListNativeDashboardsRequest, ListNativeDashboardsResponse, NativeDashboard>
            context,
        ApiFuture<ListNativeDashboardsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListNativeDashboardsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListNativeDashboardsRequest,
          ListNativeDashboardsResponse,
          NativeDashboard,
          ListNativeDashboardsPage,
          ListNativeDashboardsFixedSizeCollection> {

    private ListNativeDashboardsFixedSizeCollection(
        List<ListNativeDashboardsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListNativeDashboardsFixedSizeCollection createEmptyCollection() {
      return new ListNativeDashboardsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListNativeDashboardsFixedSizeCollection createCollection(
        List<ListNativeDashboardsPage> pages, int collectionSize) {
      return new ListNativeDashboardsFixedSizeCollection(pages, collectionSize);
    }
  }
}
