/*
 * Copyright 2025 Google LLC
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

package com.google.ads.admanager.v1;

import com.google.ads.admanager.v1.stub.ReportServiceStub;
import com.google.ads.admanager.v1.stub.ReportServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for interacting with reports.
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
 * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
 *   ReportName name = ReportName.of("[NETWORK_CODE]", "[REPORT]");
 *   Report response = reportServiceClient.getReport(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ReportServiceClient object to clean up resources such
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
 *      <td><p> GetReport</td>
 *      <td><p> API to retrieve a `Report` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getReport(GetReportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getReport(ReportName name)
 *           <li><p> getReport(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListReports</td>
 *      <td><p> API to retrieve a list of `Report` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listReports(ListReportsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listReports(NetworkName parent)
 *           <li><p> listReports(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listReportsPagedCallable()
 *           <li><p> listReportsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateReport</td>
 *      <td><p> API to create a `Report` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createReport(CreateReportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createReport(NetworkName parent, Report report)
 *           <li><p> createReport(String parent, Report report)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateReport</td>
 *      <td><p> API to update a `Report` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateReport(UpdateReportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateReport(Report report, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RunReport</td>
 *      <td><p> Initiates the execution of an existing report asynchronously. Users can get the report by polling this operation via `OperationsService.GetOperation`. Poll every 5 seconds initially, with an exponential backoff. Once a report is complete, the operation will contain a `RunReportResponse` in its response field containing a report_result that can be passed to the `FetchReportResultRows` method to retrieve the report data.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> runReportAsync(RunReportRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> runReportAsync(ReportName name)
 *           <li><p> runReportAsync(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> runReportOperationCallable()
 *           <li><p> runReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchReportResultRows</td>
 *      <td><p> Returns the result rows from a completed report. The caller must have previously called `RunReport` and waited for that operation to complete. The rows will be returned according to the order specified by the `sorts` member of the report definition.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchReportResultRows(FetchReportResultRowsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> fetchReportResultRows(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchReportResultRowsPagedCallable()
 *           <li><p> fetchReportResultRowsCallable()
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
 * <p>This class can be customized by passing in a custom instance of ReportServiceSettings to
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
 * ReportServiceSettings reportServiceSettings =
 *     ReportServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ReportServiceClient reportServiceClient = ReportServiceClient.create(reportServiceSettings);
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
 * ReportServiceSettings reportServiceSettings =
 *     ReportServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ReportServiceClient reportServiceClient = ReportServiceClient.create(reportServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ReportServiceClient implements BackgroundResource {
  private final ReportServiceSettings settings;
  private final ReportServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;

  /** Constructs an instance of ReportServiceClient with default settings. */
  public static final ReportServiceClient create() throws IOException {
    return create(ReportServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ReportServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ReportServiceClient create(ReportServiceSettings settings)
      throws IOException {
    return new ReportServiceClient(settings);
  }

  /**
   * Constructs an instance of ReportServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ReportServiceSettings).
   */
  public static final ReportServiceClient create(ReportServiceStub stub) {
    return new ReportServiceClient(stub);
  }

  /**
   * Constructs an instance of ReportServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ReportServiceClient(ReportServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ReportServiceStubSettings) settings.getStubSettings()).createStub();
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected ReportServiceClient(ReportServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final ReportServiceSettings getSettings() {
    return settings;
  }

  public ReportServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Report` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   ReportName name = ReportName.of("[NETWORK_CODE]", "[REPORT]");
   *   Report response = reportServiceClient.getReport(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the report. Format:
   *     `networks/{network_code}/reports/{report_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Report getReport(ReportName name) {
    GetReportRequest request =
        GetReportRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Report` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   String name = ReportName.of("[NETWORK_CODE]", "[REPORT]").toString();
   *   Report response = reportServiceClient.getReport(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the report. Format:
   *     `networks/{network_code}/reports/{report_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Report getReport(String name) {
    GetReportRequest request = GetReportRequest.newBuilder().setName(name).build();
    return getReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Report` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   GetReportRequest request =
   *       GetReportRequest.newBuilder()
   *           .setName(ReportName.of("[NETWORK_CODE]", "[REPORT]").toString())
   *           .build();
   *   Report response = reportServiceClient.getReport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Report getReport(GetReportRequest request) {
    return getReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `Report` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   GetReportRequest request =
   *       GetReportRequest.newBuilder()
   *           .setName(ReportName.of("[NETWORK_CODE]", "[REPORT]").toString())
   *           .build();
   *   ApiFuture<Report> future = reportServiceClient.getReportCallable().futureCall(request);
   *   // Do something.
   *   Report response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReportRequest, Report> getReportCallable() {
    return stub.getReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Report` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (Report element : reportServiceClient.listReports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of reports. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReportsPagedResponse listReports(NetworkName parent) {
    ListReportsRequest request =
        ListReportsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Report` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (Report element : reportServiceClient.listReports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of reports. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReportsPagedResponse listReports(String parent) {
    ListReportsRequest request = ListReportsRequest.newBuilder().setParent(parent).build();
    return listReports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Report` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   ListReportsRequest request =
   *       ListReportsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (Report element : reportServiceClient.listReports(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReportsPagedResponse listReports(ListReportsRequest request) {
    return listReportsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Report` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   ListReportsRequest request =
   *       ListReportsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<Report> future = reportServiceClient.listReportsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Report element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReportsRequest, ListReportsPagedResponse>
      listReportsPagedCallable() {
    return stub.listReportsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `Report` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   ListReportsRequest request =
   *       ListReportsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListReportsResponse response = reportServiceClient.listReportsCallable().call(request);
   *     for (Report element : response.getReportsList()) {
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
  public final UnaryCallable<ListReportsRequest, ListReportsResponse> listReportsCallable() {
    return stub.listReportsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `Report` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   Report report = Report.newBuilder().build();
   *   Report response = reportServiceClient.createReport(parent, report);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `Report` will be created. Format:
   *     `networks/{network_code}`
   * @param report Required. The `Report` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Report createReport(NetworkName parent, Report report) {
    CreateReportRequest request =
        CreateReportRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setReport(report)
            .build();
    return createReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `Report` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   Report report = Report.newBuilder().build();
   *   Report response = reportServiceClient.createReport(parent, report);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `Report` will be created. Format:
   *     `networks/{network_code}`
   * @param report Required. The `Report` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Report createReport(String parent, Report report) {
    CreateReportRequest request =
        CreateReportRequest.newBuilder().setParent(parent).setReport(report).build();
    return createReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `Report` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   CreateReportRequest request =
   *       CreateReportRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setReport(Report.newBuilder().build())
   *           .build();
   *   Report response = reportServiceClient.createReport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Report createReport(CreateReportRequest request) {
    return createReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to create a `Report` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   CreateReportRequest request =
   *       CreateReportRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setReport(Report.newBuilder().build())
   *           .build();
   *   ApiFuture<Report> future = reportServiceClient.createReportCallable().futureCall(request);
   *   // Do something.
   *   Report response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateReportRequest, Report> createReportCallable() {
    return stub.createReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update a `Report` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   Report report = Report.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Report response = reportServiceClient.updateReport(report, updateMask);
   * }
   * }</pre>
   *
   * @param report Required. The `Report` to update.
   * @param updateMask Required. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Report updateReport(Report report, FieldMask updateMask) {
    UpdateReportRequest request =
        UpdateReportRequest.newBuilder().setReport(report).setUpdateMask(updateMask).build();
    return updateReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update a `Report` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   UpdateReportRequest request =
   *       UpdateReportRequest.newBuilder()
   *           .setReport(Report.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Report response = reportServiceClient.updateReport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Report updateReport(UpdateReportRequest request) {
    return updateReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to update a `Report` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   UpdateReportRequest request =
   *       UpdateReportRequest.newBuilder()
   *           .setReport(Report.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Report> future = reportServiceClient.updateReportCallable().futureCall(request);
   *   // Do something.
   *   Report response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateReportRequest, Report> updateReportCallable() {
    return stub.updateReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the execution of an existing report asynchronously. Users can get the report by
   * polling this operation via `OperationsService.GetOperation`. Poll every 5 seconds initially,
   * with an exponential backoff. Once a report is complete, the operation will contain a
   * `RunReportResponse` in its response field containing a report_result that can be passed to the
   * `FetchReportResultRows` method to retrieve the report data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   ReportName name = ReportName.of("[NETWORK_CODE]", "[REPORT]");
   *   RunReportResponse response = reportServiceClient.runReportAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The report to run. Format: `networks/{network_code}/reports/{report_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RunReportResponse, RunReportMetadata> runReportAsync(
      ReportName name) {
    RunReportRequest request =
        RunReportRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return runReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the execution of an existing report asynchronously. Users can get the report by
   * polling this operation via `OperationsService.GetOperation`. Poll every 5 seconds initially,
   * with an exponential backoff. Once a report is complete, the operation will contain a
   * `RunReportResponse` in its response field containing a report_result that can be passed to the
   * `FetchReportResultRows` method to retrieve the report data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   String name = ReportName.of("[NETWORK_CODE]", "[REPORT]").toString();
   *   RunReportResponse response = reportServiceClient.runReportAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The report to run. Format: `networks/{network_code}/reports/{report_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RunReportResponse, RunReportMetadata> runReportAsync(String name) {
    RunReportRequest request = RunReportRequest.newBuilder().setName(name).build();
    return runReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the execution of an existing report asynchronously. Users can get the report by
   * polling this operation via `OperationsService.GetOperation`. Poll every 5 seconds initially,
   * with an exponential backoff. Once a report is complete, the operation will contain a
   * `RunReportResponse` in its response field containing a report_result that can be passed to the
   * `FetchReportResultRows` method to retrieve the report data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   RunReportRequest request =
   *       RunReportRequest.newBuilder()
   *           .setName(ReportName.of("[NETWORK_CODE]", "[REPORT]").toString())
   *           .build();
   *   RunReportResponse response = reportServiceClient.runReportAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RunReportResponse, RunReportMetadata> runReportAsync(
      RunReportRequest request) {
    return runReportOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the execution of an existing report asynchronously. Users can get the report by
   * polling this operation via `OperationsService.GetOperation`. Poll every 5 seconds initially,
   * with an exponential backoff. Once a report is complete, the operation will contain a
   * `RunReportResponse` in its response field containing a report_result that can be passed to the
   * `FetchReportResultRows` method to retrieve the report data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   RunReportRequest request =
   *       RunReportRequest.newBuilder()
   *           .setName(ReportName.of("[NETWORK_CODE]", "[REPORT]").toString())
   *           .build();
   *   OperationFuture<RunReportResponse, RunReportMetadata> future =
   *       reportServiceClient.runReportOperationCallable().futureCall(request);
   *   // Do something.
   *   RunReportResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RunReportRequest, RunReportResponse, RunReportMetadata>
      runReportOperationCallable() {
    return stub.runReportOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the execution of an existing report asynchronously. Users can get the report by
   * polling this operation via `OperationsService.GetOperation`. Poll every 5 seconds initially,
   * with an exponential backoff. Once a report is complete, the operation will contain a
   * `RunReportResponse` in its response field containing a report_result that can be passed to the
   * `FetchReportResultRows` method to retrieve the report data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   RunReportRequest request =
   *       RunReportRequest.newBuilder()
   *           .setName(ReportName.of("[NETWORK_CODE]", "[REPORT]").toString())
   *           .build();
   *   ApiFuture<Operation> future = reportServiceClient.runReportCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunReportRequest, Operation> runReportCallable() {
    return stub.runReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the result rows from a completed report. The caller must have previously called
   * `RunReport` and waited for that operation to complete. The rows will be returned according to
   * the order specified by the `sorts` member of the report definition.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   String name = "name3373707";
   *   for (Report.DataTable.Row element :
   *       reportServiceClient.fetchReportResultRows(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name The report result being fetched. Format:
   *     `networks/{network_code}/reports/{report_id}/results/{report_result_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchReportResultRowsPagedResponse fetchReportResultRows(String name) {
    FetchReportResultRowsRequest request =
        FetchReportResultRowsRequest.newBuilder().setName(name).build();
    return fetchReportResultRows(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the result rows from a completed report. The caller must have previously called
   * `RunReport` and waited for that operation to complete. The rows will be returned according to
   * the order specified by the `sorts` member of the report definition.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   FetchReportResultRowsRequest request =
   *       FetchReportResultRowsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Report.DataTable.Row element :
   *       reportServiceClient.fetchReportResultRows(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchReportResultRowsPagedResponse fetchReportResultRows(
      FetchReportResultRowsRequest request) {
    return fetchReportResultRowsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the result rows from a completed report. The caller must have previously called
   * `RunReport` and waited for that operation to complete. The rows will be returned according to
   * the order specified by the `sorts` member of the report definition.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   FetchReportResultRowsRequest request =
   *       FetchReportResultRowsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Report.DataTable.Row> future =
   *       reportServiceClient.fetchReportResultRowsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Report.DataTable.Row element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchReportResultRowsRequest, FetchReportResultRowsPagedResponse>
      fetchReportResultRowsPagedCallable() {
    return stub.fetchReportResultRowsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the result rows from a completed report. The caller must have previously called
   * `RunReport` and waited for that operation to complete. The rows will be returned according to
   * the order specified by the `sorts` member of the report definition.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReportServiceClient reportServiceClient = ReportServiceClient.create()) {
   *   FetchReportResultRowsRequest request =
   *       FetchReportResultRowsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     FetchReportResultRowsResponse response =
   *         reportServiceClient.fetchReportResultRowsCallable().call(request);
   *     for (Report.DataTable.Row element : response.getRowsList()) {
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
  public final UnaryCallable<FetchReportResultRowsRequest, FetchReportResultRowsResponse>
      fetchReportResultRowsCallable() {
    return stub.fetchReportResultRowsCallable();
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

  public static class ListReportsPagedResponse
      extends AbstractPagedListResponse<
          ListReportsRequest,
          ListReportsResponse,
          Report,
          ListReportsPage,
          ListReportsFixedSizeCollection> {

    public static ApiFuture<ListReportsPagedResponse> createAsync(
        PageContext<ListReportsRequest, ListReportsResponse, Report> context,
        ApiFuture<ListReportsResponse> futureResponse) {
      ApiFuture<ListReportsPage> futurePage =
          ListReportsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListReportsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListReportsPagedResponse(ListReportsPage page) {
      super(page, ListReportsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReportsPage
      extends AbstractPage<ListReportsRequest, ListReportsResponse, Report, ListReportsPage> {

    private ListReportsPage(
        PageContext<ListReportsRequest, ListReportsResponse, Report> context,
        ListReportsResponse response) {
      super(context, response);
    }

    private static ListReportsPage createEmptyPage() {
      return new ListReportsPage(null, null);
    }

    @Override
    protected ListReportsPage createPage(
        PageContext<ListReportsRequest, ListReportsResponse, Report> context,
        ListReportsResponse response) {
      return new ListReportsPage(context, response);
    }

    @Override
    public ApiFuture<ListReportsPage> createPageAsync(
        PageContext<ListReportsRequest, ListReportsResponse, Report> context,
        ApiFuture<ListReportsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReportsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReportsRequest,
          ListReportsResponse,
          Report,
          ListReportsPage,
          ListReportsFixedSizeCollection> {

    private ListReportsFixedSizeCollection(List<ListReportsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReportsFixedSizeCollection createEmptyCollection() {
      return new ListReportsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReportsFixedSizeCollection createCollection(
        List<ListReportsPage> pages, int collectionSize) {
      return new ListReportsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class FetchReportResultRowsPagedResponse
      extends AbstractPagedListResponse<
          FetchReportResultRowsRequest,
          FetchReportResultRowsResponse,
          Report.DataTable.Row,
          FetchReportResultRowsPage,
          FetchReportResultRowsFixedSizeCollection> {

    public static ApiFuture<FetchReportResultRowsPagedResponse> createAsync(
        PageContext<
                FetchReportResultRowsRequest, FetchReportResultRowsResponse, Report.DataTable.Row>
            context,
        ApiFuture<FetchReportResultRowsResponse> futureResponse) {
      ApiFuture<FetchReportResultRowsPage> futurePage =
          FetchReportResultRowsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new FetchReportResultRowsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private FetchReportResultRowsPagedResponse(FetchReportResultRowsPage page) {
      super(page, FetchReportResultRowsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class FetchReportResultRowsPage
      extends AbstractPage<
          FetchReportResultRowsRequest,
          FetchReportResultRowsResponse,
          Report.DataTable.Row,
          FetchReportResultRowsPage> {

    private FetchReportResultRowsPage(
        PageContext<
                FetchReportResultRowsRequest, FetchReportResultRowsResponse, Report.DataTable.Row>
            context,
        FetchReportResultRowsResponse response) {
      super(context, response);
    }

    private static FetchReportResultRowsPage createEmptyPage() {
      return new FetchReportResultRowsPage(null, null);
    }

    @Override
    protected FetchReportResultRowsPage createPage(
        PageContext<
                FetchReportResultRowsRequest, FetchReportResultRowsResponse, Report.DataTable.Row>
            context,
        FetchReportResultRowsResponse response) {
      return new FetchReportResultRowsPage(context, response);
    }

    @Override
    public ApiFuture<FetchReportResultRowsPage> createPageAsync(
        PageContext<
                FetchReportResultRowsRequest, FetchReportResultRowsResponse, Report.DataTable.Row>
            context,
        ApiFuture<FetchReportResultRowsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class FetchReportResultRowsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          FetchReportResultRowsRequest,
          FetchReportResultRowsResponse,
          Report.DataTable.Row,
          FetchReportResultRowsPage,
          FetchReportResultRowsFixedSizeCollection> {

    private FetchReportResultRowsFixedSizeCollection(
        List<FetchReportResultRowsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FetchReportResultRowsFixedSizeCollection createEmptyCollection() {
      return new FetchReportResultRowsFixedSizeCollection(null, 0);
    }

    @Override
    protected FetchReportResultRowsFixedSizeCollection createCollection(
        List<FetchReportResultRowsPage> pages, int collectionSize) {
      return new FetchReportResultRowsFixedSizeCollection(pages, collectionSize);
    }
  }
}
