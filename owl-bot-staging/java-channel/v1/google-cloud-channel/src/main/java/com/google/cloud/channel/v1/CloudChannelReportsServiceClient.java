/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.channel.v1;

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
import com.google.cloud.channel.v1.stub.CloudChannelReportsServiceStub;
import com.google.cloud.channel.v1.stub.CloudChannelReportsServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: CloudChannelReportsService lets Google Cloud resellers and distributors
 * retrieve and combine a variety of data in Cloud Channel for multiple products (Google Cloud
 * Platform (GCP), Google Voice, and Google Workspace.)
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
 * try (CloudChannelReportsServiceClient cloudChannelReportsServiceClient =
 *     CloudChannelReportsServiceClient.create()) {
 *   RunReportJobRequest request =
 *       RunReportJobRequest.newBuilder()
 *           .setName(ReportName.of("[ACCOUNT]", "[REPORT]").toString())
 *           .setDateRange(DateRange.newBuilder().build())
 *           .setFilter("filter-1274492040")
 *           .setLanguageCode("languageCode-2092349083")
 *           .build();
 *   RunReportJobResponse response =
 *       cloudChannelReportsServiceClient.runReportJobAsync(request).get();
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CloudChannelReportsServiceClient object to clean up
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
 * <p>This class can be customized by passing in a custom instance of
 * CloudChannelReportsServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CloudChannelReportsServiceSettings cloudChannelReportsServiceSettings =
 *     CloudChannelReportsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CloudChannelReportsServiceClient cloudChannelReportsServiceClient =
 *     CloudChannelReportsServiceClient.create(cloudChannelReportsServiceSettings);
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
 * CloudChannelReportsServiceSettings cloudChannelReportsServiceSettings =
 *     CloudChannelReportsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CloudChannelReportsServiceClient cloudChannelReportsServiceClient =
 *     CloudChannelReportsServiceClient.create(cloudChannelReportsServiceSettings);
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
 * CloudChannelReportsServiceSettings cloudChannelReportsServiceSettings =
 *     CloudChannelReportsServiceSettings.newHttpJsonBuilder().build();
 * CloudChannelReportsServiceClient cloudChannelReportsServiceClient =
 *     CloudChannelReportsServiceClient.create(cloudChannelReportsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CloudChannelReportsServiceClient implements BackgroundResource {
  private final CloudChannelReportsServiceSettings settings;
  private final CloudChannelReportsServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of CloudChannelReportsServiceClient with default settings. */
  public static final CloudChannelReportsServiceClient create() throws IOException {
    return create(CloudChannelReportsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CloudChannelReportsServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final CloudChannelReportsServiceClient create(
      CloudChannelReportsServiceSettings settings) throws IOException {
    return new CloudChannelReportsServiceClient(settings);
  }

  /**
   * Constructs an instance of CloudChannelReportsServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(CloudChannelReportsServiceSettings).
   */
  public static final CloudChannelReportsServiceClient create(CloudChannelReportsServiceStub stub) {
    return new CloudChannelReportsServiceClient(stub);
  }

  /**
   * Constructs an instance of CloudChannelReportsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected CloudChannelReportsServiceClient(CloudChannelReportsServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((CloudChannelReportsServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected CloudChannelReportsServiceClient(CloudChannelReportsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final CloudChannelReportsServiceSettings getSettings() {
    return settings;
  }

  public CloudChannelReportsServiceStub getStub() {
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
   * Begins generation of data for a given report. The report identifier is a UID (for example,
   * `613bf59q`).
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The user doesn't have access to this report.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: The report identifier was not found.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata contains an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>To get the results of report generation, call
   * [CloudChannelReportsService.FetchReportResults][google.cloud.channel.v1.CloudChannelReportsService.FetchReportResults]
   * with the
   * [RunReportJobResponse.report_job][google.cloud.channel.v1.RunReportJobResponse.report_job].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelReportsServiceClient cloudChannelReportsServiceClient =
   *     CloudChannelReportsServiceClient.create()) {
   *   RunReportJobRequest request =
   *       RunReportJobRequest.newBuilder()
   *           .setName(ReportName.of("[ACCOUNT]", "[REPORT]").toString())
   *           .setDateRange(DateRange.newBuilder().build())
   *           .setFilter("filter-1274492040")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   RunReportJobResponse response =
   *       cloudChannelReportsServiceClient.runReportJobAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<RunReportJobResponse, OperationMetadata> runReportJobAsync(
      RunReportJobRequest request) {
    return runReportJobOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Begins generation of data for a given report. The report identifier is a UID (for example,
   * `613bf59q`).
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The user doesn't have access to this report.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: The report identifier was not found.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata contains an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>To get the results of report generation, call
   * [CloudChannelReportsService.FetchReportResults][google.cloud.channel.v1.CloudChannelReportsService.FetchReportResults]
   * with the
   * [RunReportJobResponse.report_job][google.cloud.channel.v1.RunReportJobResponse.report_job].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelReportsServiceClient cloudChannelReportsServiceClient =
   *     CloudChannelReportsServiceClient.create()) {
   *   RunReportJobRequest request =
   *       RunReportJobRequest.newBuilder()
   *           .setName(ReportName.of("[ACCOUNT]", "[REPORT]").toString())
   *           .setDateRange(DateRange.newBuilder().build())
   *           .setFilter("filter-1274492040")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   OperationFuture<RunReportJobResponse, OperationMetadata> future =
   *       cloudChannelReportsServiceClient.runReportJobOperationCallable().futureCall(request);
   *   // Do something.
   *   RunReportJobResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<RunReportJobRequest, RunReportJobResponse, OperationMetadata>
      runReportJobOperationCallable() {
    return stub.runReportJobOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Begins generation of data for a given report. The report identifier is a UID (for example,
   * `613bf59q`).
   *
   * <p>Possible error codes:
   *
   * <ul>
   *   <li>PERMISSION_DENIED: The user doesn't have access to this report.
   *   <li>INVALID_ARGUMENT: Required request parameters are missing or invalid.
   *   <li>NOT_FOUND: The report identifier was not found.
   *   <li>INTERNAL: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   *   <li>UNKNOWN: Any non-user error related to a technical issue in the backend. Contact Cloud
   *       Channel support.
   * </ul>
   *
   * <p>Return value: The ID of a long-running operation.
   *
   * <p>To get the results of the operation, call the GetOperation method of
   * CloudChannelOperationsService. The Operation metadata contains an instance of
   * [OperationMetadata][google.cloud.channel.v1.OperationMetadata].
   *
   * <p>To get the results of report generation, call
   * [CloudChannelReportsService.FetchReportResults][google.cloud.channel.v1.CloudChannelReportsService.FetchReportResults]
   * with the
   * [RunReportJobResponse.report_job][google.cloud.channel.v1.RunReportJobResponse.report_job].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelReportsServiceClient cloudChannelReportsServiceClient =
   *     CloudChannelReportsServiceClient.create()) {
   *   RunReportJobRequest request =
   *       RunReportJobRequest.newBuilder()
   *           .setName(ReportName.of("[ACCOUNT]", "[REPORT]").toString())
   *           .setDateRange(DateRange.newBuilder().build())
   *           .setFilter("filter-1274492040")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<Operation> future =
   *       cloudChannelReportsServiceClient.runReportJobCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunReportJobRequest, Operation> runReportJobCallable() {
    return stub.runReportJobCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves data generated by
   * [CloudChannelReportsService.RunReportJob][google.cloud.channel.v1.CloudChannelReportsService.RunReportJob].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelReportsServiceClient cloudChannelReportsServiceClient =
   *     CloudChannelReportsServiceClient.create()) {
   *   ReportJobName reportJob = ReportJobName.of("[ACCOUNT]", "[REPORT_JOB]");
   *   for (Row element :
   *       cloudChannelReportsServiceClient.fetchReportResults(reportJob).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param reportJob Required. The report job created by
   *     [CloudChannelReportsService.RunReportJob][google.cloud.channel.v1.CloudChannelReportsService.RunReportJob].
   *     Report_job uses the format: accounts/{account_id}/reportJobs/{report_job_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchReportResultsPagedResponse fetchReportResults(ReportJobName reportJob) {
    FetchReportResultsRequest request =
        FetchReportResultsRequest.newBuilder()
            .setReportJob(reportJob == null ? null : reportJob.toString())
            .build();
    return fetchReportResults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves data generated by
   * [CloudChannelReportsService.RunReportJob][google.cloud.channel.v1.CloudChannelReportsService.RunReportJob].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelReportsServiceClient cloudChannelReportsServiceClient =
   *     CloudChannelReportsServiceClient.create()) {
   *   String reportJob = ReportJobName.of("[ACCOUNT]", "[REPORT_JOB]").toString();
   *   for (Row element :
   *       cloudChannelReportsServiceClient.fetchReportResults(reportJob).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param reportJob Required. The report job created by
   *     [CloudChannelReportsService.RunReportJob][google.cloud.channel.v1.CloudChannelReportsService.RunReportJob].
   *     Report_job uses the format: accounts/{account_id}/reportJobs/{report_job_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchReportResultsPagedResponse fetchReportResults(String reportJob) {
    FetchReportResultsRequest request =
        FetchReportResultsRequest.newBuilder().setReportJob(reportJob).build();
    return fetchReportResults(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves data generated by
   * [CloudChannelReportsService.RunReportJob][google.cloud.channel.v1.CloudChannelReportsService.RunReportJob].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelReportsServiceClient cloudChannelReportsServiceClient =
   *     CloudChannelReportsServiceClient.create()) {
   *   FetchReportResultsRequest request =
   *       FetchReportResultsRequest.newBuilder()
   *           .setReportJob(ReportJobName.of("[ACCOUNT]", "[REPORT_JOB]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Row element :
   *       cloudChannelReportsServiceClient.fetchReportResults(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FetchReportResultsPagedResponse fetchReportResults(
      FetchReportResultsRequest request) {
    return fetchReportResultsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves data generated by
   * [CloudChannelReportsService.RunReportJob][google.cloud.channel.v1.CloudChannelReportsService.RunReportJob].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelReportsServiceClient cloudChannelReportsServiceClient =
   *     CloudChannelReportsServiceClient.create()) {
   *   FetchReportResultsRequest request =
   *       FetchReportResultsRequest.newBuilder()
   *           .setReportJob(ReportJobName.of("[ACCOUNT]", "[REPORT_JOB]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Row> future =
   *       cloudChannelReportsServiceClient.fetchReportResultsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Row element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchReportResultsRequest, FetchReportResultsPagedResponse>
      fetchReportResultsPagedCallable() {
    return stub.fetchReportResultsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves data generated by
   * [CloudChannelReportsService.RunReportJob][google.cloud.channel.v1.CloudChannelReportsService.RunReportJob].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelReportsServiceClient cloudChannelReportsServiceClient =
   *     CloudChannelReportsServiceClient.create()) {
   *   FetchReportResultsRequest request =
   *       FetchReportResultsRequest.newBuilder()
   *           .setReportJob(ReportJobName.of("[ACCOUNT]", "[REPORT_JOB]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     FetchReportResultsResponse response =
   *         cloudChannelReportsServiceClient.fetchReportResultsCallable().call(request);
   *     for (Row element : response.getRowsList()) {
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
  public final UnaryCallable<FetchReportResultsRequest, FetchReportResultsResponse>
      fetchReportResultsCallable() {
    return stub.fetchReportResultsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the reports that RunReportJob can run. These reports include an ID, a description, and
   * the list of columns that will be in the result.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelReportsServiceClient cloudChannelReportsServiceClient =
   *     CloudChannelReportsServiceClient.create()) {
   *   String parent = "parent-995424086";
   *   for (Report element : cloudChannelReportsServiceClient.listReports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the partner account to list available reports for.
   *     Parent uses the format: accounts/{account_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReportsPagedResponse listReports(String parent) {
    ListReportsRequest request = ListReportsRequest.newBuilder().setParent(parent).build();
    return listReports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the reports that RunReportJob can run. These reports include an ID, a description, and
   * the list of columns that will be in the result.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelReportsServiceClient cloudChannelReportsServiceClient =
   *     CloudChannelReportsServiceClient.create()) {
   *   ListReportsRequest request =
   *       ListReportsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   for (Report element : cloudChannelReportsServiceClient.listReports(request).iterateAll()) {
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
   * Lists the reports that RunReportJob can run. These reports include an ID, a description, and
   * the list of columns that will be in the result.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelReportsServiceClient cloudChannelReportsServiceClient =
   *     CloudChannelReportsServiceClient.create()) {
   *   ListReportsRequest request =
   *       ListReportsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   ApiFuture<Report> future =
   *       cloudChannelReportsServiceClient.listReportsPagedCallable().futureCall(request);
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
   * Lists the reports that RunReportJob can run. These reports include an ID, a description, and
   * the list of columns that will be in the result.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CloudChannelReportsServiceClient cloudChannelReportsServiceClient =
   *     CloudChannelReportsServiceClient.create()) {
   *   ListReportsRequest request =
   *       ListReportsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setLanguageCode("languageCode-2092349083")
   *           .build();
   *   while (true) {
   *     ListReportsResponse response =
   *         cloudChannelReportsServiceClient.listReportsCallable().call(request);
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

  public static class FetchReportResultsPagedResponse
      extends AbstractPagedListResponse<
          FetchReportResultsRequest,
          FetchReportResultsResponse,
          Row,
          FetchReportResultsPage,
          FetchReportResultsFixedSizeCollection> {

    public static ApiFuture<FetchReportResultsPagedResponse> createAsync(
        PageContext<FetchReportResultsRequest, FetchReportResultsResponse, Row> context,
        ApiFuture<FetchReportResultsResponse> futureResponse) {
      ApiFuture<FetchReportResultsPage> futurePage =
          FetchReportResultsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new FetchReportResultsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private FetchReportResultsPagedResponse(FetchReportResultsPage page) {
      super(page, FetchReportResultsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class FetchReportResultsPage
      extends AbstractPage<
          FetchReportResultsRequest, FetchReportResultsResponse, Row, FetchReportResultsPage> {

    private FetchReportResultsPage(
        PageContext<FetchReportResultsRequest, FetchReportResultsResponse, Row> context,
        FetchReportResultsResponse response) {
      super(context, response);
    }

    private static FetchReportResultsPage createEmptyPage() {
      return new FetchReportResultsPage(null, null);
    }

    @Override
    protected FetchReportResultsPage createPage(
        PageContext<FetchReportResultsRequest, FetchReportResultsResponse, Row> context,
        FetchReportResultsResponse response) {
      return new FetchReportResultsPage(context, response);
    }

    @Override
    public ApiFuture<FetchReportResultsPage> createPageAsync(
        PageContext<FetchReportResultsRequest, FetchReportResultsResponse, Row> context,
        ApiFuture<FetchReportResultsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class FetchReportResultsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          FetchReportResultsRequest,
          FetchReportResultsResponse,
          Row,
          FetchReportResultsPage,
          FetchReportResultsFixedSizeCollection> {

    private FetchReportResultsFixedSizeCollection(
        List<FetchReportResultsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static FetchReportResultsFixedSizeCollection createEmptyCollection() {
      return new FetchReportResultsFixedSizeCollection(null, 0);
    }

    @Override
    protected FetchReportResultsFixedSizeCollection createCollection(
        List<FetchReportResultsPage> pages, int collectionSize) {
      return new FetchReportResultsFixedSizeCollection(pages, collectionSize);
    }
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
}
