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

package com.google.cloud.appoptimize.v1beta;

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
import com.google.cloud.appoptimize.v1beta.stub.AppOptimizeStub;
import com.google.cloud.appoptimize.v1beta.stub.AppOptimizeStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.ListValue;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing and querying optimization reports.
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
 * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
 *   ReportName name = ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]");
 *   Report response = appOptimizeClient.getReport(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AppOptimizeClient object to clean up resources such as
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
 *      <td><p> CreateReport</td>
 *      <td><p> Creates a new report.
 * <p>  This initiates a long-running operation that, upon completion, results in a report resource. Once the report is created, its results can be read via `ReadReport`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createReportAsync(CreateReportRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createReportAsync(LocationName parent, Report report, String reportId)
 *           <li><p> createReportAsync(String parent, Report report, String reportId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createReportOperationCallable()
 *           <li><p> createReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetReport</td>
 *      <td><p> Retrieves the details of a report configuration.</td>
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
 *      <td><p> Lists reports within a given project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listReports(ListReportsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listReports(LocationName parent)
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
 *      <td><p> DeleteReport</td>
 *      <td><p> Deletes the specified report.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteReport(DeleteReportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteReport(ReportName name)
 *           <li><p> deleteReport(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ReadReport</td>
 *      <td><p> Reads data within a specified report.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> readReport(ReadReportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> readReport(ReportName name)
 *           <li><p> readReport(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> readReportPagedCallable()
 *           <li><p> readReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLocations</td>
 *      <td><p> Lists information about the supported locations for this service.
 * <p> This method lists locations based on the resource scope provided inthe [ListLocationsRequest.name] field:
 * <p> &#42; &#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If `name` follows the format`projects/{project}`, the method lists locations visible to thatspecific project. This includes public, private, or otherproject-specific locations enabled for the project.
 * <p> For gRPC and client library implementations, the resource name ispassed as the `name` field. For direct service calls, the resourcename isincorporated into the request path based on the specific serviceimplementation and version.</td>
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
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of AppOptimizeSettings to
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
 * AppOptimizeSettings appOptimizeSettings =
 *     AppOptimizeSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AppOptimizeClient appOptimizeClient = AppOptimizeClient.create(appOptimizeSettings);
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
 * AppOptimizeSettings appOptimizeSettings =
 *     AppOptimizeSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AppOptimizeClient appOptimizeClient = AppOptimizeClient.create(appOptimizeSettings);
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
 * AppOptimizeSettings appOptimizeSettings = AppOptimizeSettings.newHttpJsonBuilder().build();
 * AppOptimizeClient appOptimizeClient = AppOptimizeClient.create(appOptimizeSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class AppOptimizeClient implements BackgroundResource {
  private final AppOptimizeSettings settings;
  private final AppOptimizeStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of AppOptimizeClient with default settings. */
  public static final AppOptimizeClient create() throws IOException {
    return create(AppOptimizeSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AppOptimizeClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AppOptimizeClient create(AppOptimizeSettings settings) throws IOException {
    return new AppOptimizeClient(settings);
  }

  /**
   * Constructs an instance of AppOptimizeClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(AppOptimizeSettings).
   */
  public static final AppOptimizeClient create(AppOptimizeStub stub) {
    return new AppOptimizeClient(stub);
  }

  /**
   * Constructs an instance of AppOptimizeClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AppOptimizeClient(AppOptimizeSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AppOptimizeStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected AppOptimizeClient(AppOptimizeStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final AppOptimizeSettings getSettings() {
    return settings;
  }

  public AppOptimizeStub getStub() {
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
   * Creates a new report.
   *
   * <p>This initiates a long-running operation that, upon completion, results in a report resource.
   * Once the report is created, its results can be read via `ReadReport`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Report report = Report.newBuilder().build();
   *   String reportId = "reportId-427040401";
   *   Report response = appOptimizeClient.createReportAsync(parent, report, reportId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent Google Cloud project that will own the report.
   *     <p>This value does not define the scope of the report data. See `Report.scope` for setting
   *     the data scope.
   *     <p>Format: `projects/{project}/locations/{location}`.
   * @param report Required. The report resource to create.
   * @param reportId Required. The ID to use for this report. This ID must be unique within the
   *     parent project and should comply with RFC 1034 restrictions (letters, numbers, and hyphen,
   *     with the first character a letter, the last a letter or a number, and a 63 character
   *     maximum).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Report, OperationMetadata> createReportAsync(
      LocationName parent, Report report, String reportId) {
    CreateReportRequest request =
        CreateReportRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setReport(report)
            .setReportId(reportId)
            .build();
    return createReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new report.
   *
   * <p>This initiates a long-running operation that, upon completion, results in a report resource.
   * Once the report is created, its results can be read via `ReadReport`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Report report = Report.newBuilder().build();
   *   String reportId = "reportId-427040401";
   *   Report response = appOptimizeClient.createReportAsync(parent, report, reportId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent Google Cloud project that will own the report.
   *     <p>This value does not define the scope of the report data. See `Report.scope` for setting
   *     the data scope.
   *     <p>Format: `projects/{project}/locations/{location}`.
   * @param report Required. The report resource to create.
   * @param reportId Required. The ID to use for this report. This ID must be unique within the
   *     parent project and should comply with RFC 1034 restrictions (letters, numbers, and hyphen,
   *     with the first character a letter, the last a letter or a number, and a 63 character
   *     maximum).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Report, OperationMetadata> createReportAsync(
      String parent, Report report, String reportId) {
    CreateReportRequest request =
        CreateReportRequest.newBuilder()
            .setParent(parent)
            .setReport(report)
            .setReportId(reportId)
            .build();
    return createReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new report.
   *
   * <p>This initiates a long-running operation that, upon completion, results in a report resource.
   * Once the report is created, its results can be read via `ReadReport`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   CreateReportRequest request =
   *       CreateReportRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setReportId("reportId-427040401")
   *           .setReport(Report.newBuilder().build())
   *           .build();
   *   Report response = appOptimizeClient.createReportAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Report, OperationMetadata> createReportAsync(
      CreateReportRequest request) {
    return createReportOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new report.
   *
   * <p>This initiates a long-running operation that, upon completion, results in a report resource.
   * Once the report is created, its results can be read via `ReadReport`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   CreateReportRequest request =
   *       CreateReportRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setReportId("reportId-427040401")
   *           .setReport(Report.newBuilder().build())
   *           .build();
   *   OperationFuture<Report, OperationMetadata> future =
   *       appOptimizeClient.createReportOperationCallable().futureCall(request);
   *   // Do something.
   *   Report response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateReportRequest, Report, OperationMetadata>
      createReportOperationCallable() {
    return stub.createReportOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new report.
   *
   * <p>This initiates a long-running operation that, upon completion, results in a report resource.
   * Once the report is created, its results can be read via `ReadReport`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   CreateReportRequest request =
   *       CreateReportRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setReportId("reportId-427040401")
   *           .setReport(Report.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = appOptimizeClient.createReportCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateReportRequest, Operation> createReportCallable() {
    return stub.createReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the details of a report configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   ReportName name = ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]");
   *   Report response = appOptimizeClient.getReport(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the report to retrieve.
   *     <p>Format: `projects/{project}/locations/{location}/reports/{report_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Report getReport(ReportName name) {
    GetReportRequest request =
        GetReportRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the details of a report configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   String name = ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]").toString();
   *   Report response = appOptimizeClient.getReport(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the report to retrieve.
   *     <p>Format: `projects/{project}/locations/{location}/reports/{report_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Report getReport(String name) {
    GetReportRequest request = GetReportRequest.newBuilder().setName(name).build();
    return getReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the details of a report configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   GetReportRequest request =
   *       GetReportRequest.newBuilder()
   *           .setName(ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]").toString())
   *           .build();
   *   Report response = appOptimizeClient.getReport(request);
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
   * Retrieves the details of a report configuration.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   GetReportRequest request =
   *       GetReportRequest.newBuilder()
   *           .setName(ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]").toString())
   *           .build();
   *   ApiFuture<Report> future = appOptimizeClient.getReportCallable().futureCall(request);
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
   * Lists reports within a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Report element : appOptimizeClient.listReports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent project whose reports are to be listed.
   *     <p>Format: `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReportsPagedResponse listReports(LocationName parent) {
    ListReportsRequest request =
        ListReportsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists reports within a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Report element : appOptimizeClient.listReports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent project whose reports are to be listed.
   *     <p>Format: `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReportsPagedResponse listReports(String parent) {
    ListReportsRequest request = ListReportsRequest.newBuilder().setParent(parent).build();
    return listReports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists reports within a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   ListReportsRequest request =
   *       ListReportsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Report element : appOptimizeClient.listReports(request).iterateAll()) {
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
   * Lists reports within a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   ListReportsRequest request =
   *       ListReportsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Report> future = appOptimizeClient.listReportsPagedCallable().futureCall(request);
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
   * Lists reports within a given project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   ListReportsRequest request =
   *       ListReportsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListReportsResponse response = appOptimizeClient.listReportsCallable().call(request);
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
   * Deletes the specified report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   ReportName name = ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]");
   *   appOptimizeClient.deleteReport(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the report to delete.
   *     <p>Format: `projects/{project}/locations/{location}/reports/{report_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReport(ReportName name) {
    DeleteReportRequest request =
        DeleteReportRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   String name = ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]").toString();
   *   appOptimizeClient.deleteReport(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the report to delete.
   *     <p>Format: `projects/{project}/locations/{location}/reports/{report_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReport(String name) {
    DeleteReportRequest request = DeleteReportRequest.newBuilder().setName(name).build();
    deleteReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   DeleteReportRequest request =
   *       DeleteReportRequest.newBuilder()
   *           .setName(ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]").toString())
   *           .setAllowMissing(true)
   *           .build();
   *   appOptimizeClient.deleteReport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteReport(DeleteReportRequest request) {
    deleteReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   DeleteReportRequest request =
   *       DeleteReportRequest.newBuilder()
   *           .setName(ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]").toString())
   *           .setAllowMissing(true)
   *           .build();
   *   ApiFuture<Empty> future = appOptimizeClient.deleteReportCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteReportRequest, Empty> deleteReportCallable() {
    return stub.deleteReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads data within a specified report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   ReportName name = ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]");
   *   for (ListValue element : appOptimizeClient.readReport(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the report to query.
   *     <p>Format: `projects/{project}/locations/{location}/reports/{report_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReadReportPagedResponse readReport(ReportName name) {
    ReadReportRequest request =
        ReadReportRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return readReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads data within a specified report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   String name = ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]").toString();
   *   for (ListValue element : appOptimizeClient.readReport(name).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the report to query.
   *     <p>Format: `projects/{project}/locations/{location}/reports/{report_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReadReportPagedResponse readReport(String name) {
    ReadReportRequest request = ReadReportRequest.newBuilder().setName(name).build();
    return readReport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads data within a specified report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   ReadReportRequest request =
   *       ReadReportRequest.newBuilder()
   *           .setName(ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (ListValue element : appOptimizeClient.readReport(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReadReportPagedResponse readReport(ReadReportRequest request) {
    return readReportPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads data within a specified report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   ReadReportRequest request =
   *       ReadReportRequest.newBuilder()
   *           .setName(ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<ListValue> future = appOptimizeClient.readReportPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ListValue element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ReadReportRequest, ReadReportPagedResponse> readReportPagedCallable() {
    return stub.readReportPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Reads data within a specified report.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   ReadReportRequest request =
   *       ReadReportRequest.newBuilder()
   *           .setName(ReportName.of("[PROJECT]", "[LOCATION]", "[REPORT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ReadReportResponse response = appOptimizeClient.readReportCallable().call(request);
   *     for (ListValue element : response.getRowsList()) {
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
  public final UnaryCallable<ReadReportRequest, ReadReportResponse> readReportCallable() {
    return stub.readReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name] field:
   *
   * <p>&#42; &#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : appOptimizeClient.listLocations(request).iterateAll()) {
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
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name] field:
   *
   * <p>&#42; &#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       appOptimizeClient.listLocationsPagedCallable().futureCall(request);
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
   * <p>This method lists locations based on the resource scope provided inthe
   * [ListLocationsRequest.name] field:
   *
   * <p>&#42; &#42;&#42;Global locations&#42;&#42;: If `name` is empty, the method lists thepublic
   * locations available to all projects. &#42; &#42;&#42;Project-specificlocations&#42;&#42;: If
   * `name` follows the format`projects/{project}`, the method lists locations visible to
   * thatspecific project. This includes public, private, or otherproject-specific locations enabled
   * for the project.
   *
   * <p>For gRPC and client library implementations, the resource name ispassed as the `name` field.
   * For direct service calls, the resourcename isincorporated into the request path based on the
   * specific serviceimplementation and version.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = appOptimizeClient.listLocationsCallable().call(request);
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
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = appOptimizeClient.getLocation(request);
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
   * try (AppOptimizeClient appOptimizeClient = AppOptimizeClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = appOptimizeClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class ReadReportPagedResponse
      extends AbstractPagedListResponse<
          ReadReportRequest,
          ReadReportResponse,
          ListValue,
          ReadReportPage,
          ReadReportFixedSizeCollection> {

    public static ApiFuture<ReadReportPagedResponse> createAsync(
        PageContext<ReadReportRequest, ReadReportResponse, ListValue> context,
        ApiFuture<ReadReportResponse> futureResponse) {
      ApiFuture<ReadReportPage> futurePage =
          ReadReportPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ReadReportPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ReadReportPagedResponse(ReadReportPage page) {
      super(page, ReadReportFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ReadReportPage
      extends AbstractPage<ReadReportRequest, ReadReportResponse, ListValue, ReadReportPage> {

    private ReadReportPage(
        PageContext<ReadReportRequest, ReadReportResponse, ListValue> context,
        ReadReportResponse response) {
      super(context, response);
    }

    private static ReadReportPage createEmptyPage() {
      return new ReadReportPage(null, null);
    }

    @Override
    protected ReadReportPage createPage(
        PageContext<ReadReportRequest, ReadReportResponse, ListValue> context,
        ReadReportResponse response) {
      return new ReadReportPage(context, response);
    }

    @Override
    public ApiFuture<ReadReportPage> createPageAsync(
        PageContext<ReadReportRequest, ReadReportResponse, ListValue> context,
        ApiFuture<ReadReportResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ReadReportFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ReadReportRequest,
          ReadReportResponse,
          ListValue,
          ReadReportPage,
          ReadReportFixedSizeCollection> {

    private ReadReportFixedSizeCollection(List<ReadReportPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ReadReportFixedSizeCollection createEmptyCollection() {
      return new ReadReportFixedSizeCollection(null, 0);
    }

    @Override
    protected ReadReportFixedSizeCollection createCollection(
        List<ReadReportPage> pages, int collectionSize) {
      return new ReadReportFixedSizeCollection(pages, collectionSize);
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
