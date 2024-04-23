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

package com.google.ads.admanager.v1;

import com.google.ads.admanager.v1.stub.ReportServiceStub;
import com.google.ads.admanager.v1.stub.ReportServiceStubSettings;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for interacting with Reports.
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
 *   ReportName report = ReportName.of("[NETWORK_CODE]", "[REPORT]");
 *   ExportSavedReportResponse response = reportServiceClient.exportSavedReportAsync(report).get();
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
 *      <td><p> ExportSavedReport</td>
 *      <td><p> Initiates the execution and export of a report asynchronously. Users can get the report by polling this operation via OperationsService.GetOperation. Intervals of at least 2 seconds are recommended, with an exponential backoff. Once a report is complete, the operation will contain a ExportSavedReportResponse in its response field.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> exportSavedReportAsync(ExportSavedReportRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> exportSavedReportAsync(ReportName report)
 *           <li><p> exportSavedReportAsync(String report)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> exportSavedReportOperationCallable()
 *           <li><p> exportSavedReportCallable()
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
   * Initiates the execution and export of a report asynchronously. Users can get the report by
   * polling this operation via OperationsService.GetOperation. Intervals of at least 2 seconds are
   * recommended, with an exponential backoff. Once a report is complete, the operation will contain
   * a ExportSavedReportResponse in its response field.
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
   *   ReportName report = ReportName.of("[NETWORK_CODE]", "[REPORT]");
   *   ExportSavedReportResponse response = reportServiceClient.exportSavedReportAsync(report).get();
   * }
   * }</pre>
   *
   * @param report The name of a particular saved report resource.
   *     <p>A report will be run based on the specification of this saved report. It must have the
   *     format of "networks/{network_code}/reports/{report_id}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportSavedReportResponse, ExportSavedReportMetadata>
      exportSavedReportAsync(ReportName report) {
    ExportSavedReportRequest request =
        ExportSavedReportRequest.newBuilder()
            .setReport(report == null ? null : report.toString())
            .build();
    return exportSavedReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the execution and export of a report asynchronously. Users can get the report by
   * polling this operation via OperationsService.GetOperation. Intervals of at least 2 seconds are
   * recommended, with an exponential backoff. Once a report is complete, the operation will contain
   * a ExportSavedReportResponse in its response field.
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
   *   String report = ReportName.of("[NETWORK_CODE]", "[REPORT]").toString();
   *   ExportSavedReportResponse response = reportServiceClient.exportSavedReportAsync(report).get();
   * }
   * }</pre>
   *
   * @param report The name of a particular saved report resource.
   *     <p>A report will be run based on the specification of this saved report. It must have the
   *     format of "networks/{network_code}/reports/{report_id}"
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportSavedReportResponse, ExportSavedReportMetadata>
      exportSavedReportAsync(String report) {
    ExportSavedReportRequest request =
        ExportSavedReportRequest.newBuilder().setReport(report).build();
    return exportSavedReportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the execution and export of a report asynchronously. Users can get the report by
   * polling this operation via OperationsService.GetOperation. Intervals of at least 2 seconds are
   * recommended, with an exponential backoff. Once a report is complete, the operation will contain
   * a ExportSavedReportResponse in its response field.
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
   *   ExportSavedReportRequest request =
   *       ExportSavedReportRequest.newBuilder()
   *           .setReport(ReportName.of("[NETWORK_CODE]", "[REPORT]").toString())
   *           .setIncludeReportProperties(true)
   *           .setIncludeIds(true)
   *           .setIncludeTotalsRow(true)
   *           .setFileName("fileName-735721945")
   *           .build();
   *   ExportSavedReportResponse response =
   *       reportServiceClient.exportSavedReportAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportSavedReportResponse, ExportSavedReportMetadata>
      exportSavedReportAsync(ExportSavedReportRequest request) {
    return exportSavedReportOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the execution and export of a report asynchronously. Users can get the report by
   * polling this operation via OperationsService.GetOperation. Intervals of at least 2 seconds are
   * recommended, with an exponential backoff. Once a report is complete, the operation will contain
   * a ExportSavedReportResponse in its response field.
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
   *   ExportSavedReportRequest request =
   *       ExportSavedReportRequest.newBuilder()
   *           .setReport(ReportName.of("[NETWORK_CODE]", "[REPORT]").toString())
   *           .setIncludeReportProperties(true)
   *           .setIncludeIds(true)
   *           .setIncludeTotalsRow(true)
   *           .setFileName("fileName-735721945")
   *           .build();
   *   OperationFuture<ExportSavedReportResponse, ExportSavedReportMetadata> future =
   *       reportServiceClient.exportSavedReportOperationCallable().futureCall(request);
   *   // Do something.
   *   ExportSavedReportResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          ExportSavedReportRequest, ExportSavedReportResponse, ExportSavedReportMetadata>
      exportSavedReportOperationCallable() {
    return stub.exportSavedReportOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Initiates the execution and export of a report asynchronously. Users can get the report by
   * polling this operation via OperationsService.GetOperation. Intervals of at least 2 seconds are
   * recommended, with an exponential backoff. Once a report is complete, the operation will contain
   * a ExportSavedReportResponse in its response field.
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
   *   ExportSavedReportRequest request =
   *       ExportSavedReportRequest.newBuilder()
   *           .setReport(ReportName.of("[NETWORK_CODE]", "[REPORT]").toString())
   *           .setIncludeReportProperties(true)
   *           .setIncludeIds(true)
   *           .setIncludeTotalsRow(true)
   *           .setFileName("fileName-735721945")
   *           .build();
   *   ApiFuture<Operation> future =
   *       reportServiceClient.exportSavedReportCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ExportSavedReportRequest, Operation> exportSavedReportCallable() {
    return stub.exportSavedReportCallable();
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
