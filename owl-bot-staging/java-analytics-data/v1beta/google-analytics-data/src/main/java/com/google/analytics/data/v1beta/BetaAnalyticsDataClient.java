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

package com.google.analytics.data.v1beta;

import com.google.analytics.data.v1beta.stub.BetaAnalyticsDataStub;
import com.google.analytics.data.v1beta.stub.BetaAnalyticsDataStubSettings;
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
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Google Analytics reporting data service.
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
 * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
 *   RunReportRequest request =
 *       RunReportRequest.newBuilder()
 *           .setProperty("property-993141291")
 *           .addAllDimensions(new ArrayList<Dimension>())
 *           .addAllMetrics(new ArrayList<Metric>())
 *           .addAllDateRanges(new ArrayList<DateRange>())
 *           .setDimensionFilter(FilterExpression.newBuilder().build())
 *           .setMetricFilter(FilterExpression.newBuilder().build())
 *           .setOffset(-1019779949)
 *           .setLimit(102976443)
 *           .addAllMetricAggregations(new ArrayList<MetricAggregation>())
 *           .addAllOrderBys(new ArrayList<OrderBy>())
 *           .setCurrencyCode("currencyCode1004773790")
 *           .setCohortSpec(CohortSpec.newBuilder().build())
 *           .setKeepEmptyRows(true)
 *           .setReturnPropertyQuota(true)
 *           .build();
 *   RunReportResponse response = betaAnalyticsDataClient.runReport(request);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the BetaAnalyticsDataClient object to clean up resources
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
 *      <td><p> RunReport</td>
 *      <td><p> Returns a customized report of your Google Analytics event data. Reports contain statistics derived from data collected by the Google Analytics tracking code. The data returned from the API is as a table with columns for the requested dimensions and metrics. Metrics are individual measurements of user activity on your property, such as active users or event count. Dimensions break down metrics across some common criteria, such as country or event name.
 * <p>  For a guide to constructing requests &amp; understanding responses, see [Creating a Report](https://developers.google.com/analytics/devguides/reporting/data/v1/basics).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> runReport(RunReportRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> runReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RunPivotReport</td>
 *      <td><p> Returns a customized pivot report of your Google Analytics event data. Pivot reports are more advanced and expressive formats than regular reports. In a pivot report, dimensions are only visible if they are included in a pivot. Multiple pivots can be specified to further dissect your data.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> runPivotReport(RunPivotReportRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> runPivotReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchRunReports</td>
 *      <td><p> Returns multiple reports in a batch. All reports must be for the same GA4 Property.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchRunReports(BatchRunReportsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchRunReportsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchRunPivotReports</td>
 *      <td><p> Returns multiple pivot reports in a batch. All reports must be for the same GA4 Property.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchRunPivotReports(BatchRunPivotReportsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchRunPivotReportsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetMetadata</td>
 *      <td><p> Returns metadata for dimensions and metrics available in reporting methods. Used to explore the dimensions and metrics. In this method, a Google Analytics GA4 Property Identifier is specified in the request, and the metadata response includes Custom dimensions and metrics as well as Universal metadata.
 * <p>  For example if a custom metric with parameter name `levels_unlocked` is registered to a property, the Metadata response will contain `customEvent:levels_unlocked`. Universal metadata are dimensions and metrics applicable to any property such as `country` and `totalUsers`.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMetadata(GetMetadataRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMetadata(MetadataName name)
 *           <li><p> getMetadata(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMetadataCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RunRealtimeReport</td>
 *      <td><p> Returns a customized report of realtime event data for your property. Events appear in realtime reports seconds after they have been sent to the Google Analytics. Realtime reports show events and usage data for the periods of time ranging from the present moment to 30 minutes ago (up to 60 minutes for Google Analytics 360 properties).
 * <p>  For a guide to constructing realtime requests &amp; understanding responses, see [Creating a Realtime Report](https://developers.google.com/analytics/devguides/reporting/data/v1/realtime-basics).</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> runRealtimeReport(RunRealtimeReportRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> runRealtimeReportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CheckCompatibility</td>
 *      <td><p> This compatibility method lists dimensions and metrics that can be added to a report request and maintain compatibility. This method fails if the request's dimensions and metrics are incompatible.
 * <p>  In Google Analytics, reports fail if they request incompatible dimensions and/or metrics; in that case, you will need to remove dimensions and/or metrics from the incompatible report until the report is compatible.
 * <p>  The Realtime and Core reports have different compatibility rules. This method checks compatibility for Core reports.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> checkCompatibility(CheckCompatibilityRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> checkCompatibilityCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateAudienceExport</td>
 *      <td><p> Creates an audience export for later retrieval. This method quickly returns the audience export's resource name and initiates a long running asynchronous request to form an audience export. To export the users in an audience export, first create the audience export through this method and then send the audience resource name to the `QueryAudienceExport` method.
 * <p>  See [Creating an Audience Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics) for an introduction to Audience Exports with examples.
 * <p>  An audience export is a snapshot of the users currently in the audience at the time of audience export creation. Creating audience exports for one audience on different days will return different results as users enter and exit the audience.
 * <p>  Audiences in Google Analytics 4 allow you to segment your users in the ways that are important to your business. To learn more, see https://support.google.com/analytics/answer/9267572. Audience exports contain the users in each audience.
 * <p>  Audience Export APIs have some methods at alpha and other methods at beta stability. The intention is to advance methods to beta stability after some feedback and adoption. To give your feedback on this API, complete the [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createAudienceExportAsync(CreateAudienceExportRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> createAudienceExportAsync(PropertyName parent, AudienceExport audienceExport)
 *           <li><p> createAudienceExportAsync(String parent, AudienceExport audienceExport)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createAudienceExportOperationCallable()
 *           <li><p> createAudienceExportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> QueryAudienceExport</td>
 *      <td><p> Retrieves an audience export of users. After creating an audience, the users are not immediately available for exporting. First, a request to `CreateAudienceExport` is necessary to create an audience export of users, and then second, this method is used to retrieve the users in the audience export.
 * <p>  See [Creating an Audience Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics) for an introduction to Audience Exports with examples.
 * <p>  Audiences in Google Analytics 4 allow you to segment your users in the ways that are important to your business. To learn more, see https://support.google.com/analytics/answer/9267572.
 * <p>  Audience Export APIs have some methods at alpha and other methods at beta stability. The intention is to advance methods to beta stability after some feedback and adoption. To give your feedback on this API, complete the [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> queryAudienceExport(QueryAudienceExportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> queryAudienceExport(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> queryAudienceExportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetAudienceExport</td>
 *      <td><p> Gets configuration metadata about a specific audience export. This method can be used to understand an audience export after it has been created.
 * <p>  See [Creating an Audience Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics) for an introduction to Audience Exports with examples.
 * <p>  Audience Export APIs have some methods at alpha and other methods at beta stability. The intention is to advance methods to beta stability after some feedback and adoption. To give your feedback on this API, complete the [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAudienceExport(GetAudienceExportRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAudienceExport(AudienceExportName name)
 *           <li><p> getAudienceExport(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAudienceExportCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAudienceExports</td>
 *      <td><p> Lists all audience exports for a property. This method can be used for you to find and reuse existing audience exports rather than creating unnecessary new audience exports. The same audience can have multiple audience exports that represent the export of users that were in an audience on different days.
 * <p>  See [Creating an Audience Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics) for an introduction to Audience Exports with examples.
 * <p>  Audience Export APIs have some methods at alpha and other methods at beta stability. The intention is to advance methods to beta stability after some feedback and adoption. To give your feedback on this API, complete the [Google Analytics Audience Export API Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAudienceExports(ListAudienceExportsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAudienceExports(PropertyName parent)
 *           <li><p> listAudienceExports(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAudienceExportsPagedCallable()
 *           <li><p> listAudienceExportsCallable()
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
 * <p>This class can be customized by passing in a custom instance of BetaAnalyticsDataSettings to
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
 * BetaAnalyticsDataSettings betaAnalyticsDataSettings =
 *     BetaAnalyticsDataSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * BetaAnalyticsDataClient betaAnalyticsDataClient =
 *     BetaAnalyticsDataClient.create(betaAnalyticsDataSettings);
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
 * BetaAnalyticsDataSettings betaAnalyticsDataSettings =
 *     BetaAnalyticsDataSettings.newBuilder().setEndpoint(myEndpoint).build();
 * BetaAnalyticsDataClient betaAnalyticsDataClient =
 *     BetaAnalyticsDataClient.create(betaAnalyticsDataSettings);
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
 * BetaAnalyticsDataSettings betaAnalyticsDataSettings =
 *     BetaAnalyticsDataSettings.newHttpJsonBuilder().build();
 * BetaAnalyticsDataClient betaAnalyticsDataClient =
 *     BetaAnalyticsDataClient.create(betaAnalyticsDataSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class BetaAnalyticsDataClient implements BackgroundResource {
  private final BetaAnalyticsDataSettings settings;
  private final BetaAnalyticsDataStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of BetaAnalyticsDataClient with default settings. */
  public static final BetaAnalyticsDataClient create() throws IOException {
    return create(BetaAnalyticsDataSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of BetaAnalyticsDataClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final BetaAnalyticsDataClient create(BetaAnalyticsDataSettings settings)
      throws IOException {
    return new BetaAnalyticsDataClient(settings);
  }

  /**
   * Constructs an instance of BetaAnalyticsDataClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(BetaAnalyticsDataSettings).
   */
  public static final BetaAnalyticsDataClient create(BetaAnalyticsDataStub stub) {
    return new BetaAnalyticsDataClient(stub);
  }

  /**
   * Constructs an instance of BetaAnalyticsDataClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected BetaAnalyticsDataClient(BetaAnalyticsDataSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((BetaAnalyticsDataStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected BetaAnalyticsDataClient(BetaAnalyticsDataStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final BetaAnalyticsDataSettings getSettings() {
    return settings;
  }

  public BetaAnalyticsDataStub getStub() {
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
   * Returns a customized report of your Google Analytics event data. Reports contain statistics
   * derived from data collected by the Google Analytics tracking code. The data returned from the
   * API is as a table with columns for the requested dimensions and metrics. Metrics are individual
   * measurements of user activity on your property, such as active users or event count. Dimensions
   * break down metrics across some common criteria, such as country or event name.
   *
   * <p>For a guide to constructing requests &amp; understanding responses, see [Creating a
   * Report](https://developers.google.com/analytics/devguides/reporting/data/v1/basics).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   RunReportRequest request =
   *       RunReportRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .addAllDimensions(new ArrayList<Dimension>())
   *           .addAllMetrics(new ArrayList<Metric>())
   *           .addAllDateRanges(new ArrayList<DateRange>())
   *           .setDimensionFilter(FilterExpression.newBuilder().build())
   *           .setMetricFilter(FilterExpression.newBuilder().build())
   *           .setOffset(-1019779949)
   *           .setLimit(102976443)
   *           .addAllMetricAggregations(new ArrayList<MetricAggregation>())
   *           .addAllOrderBys(new ArrayList<OrderBy>())
   *           .setCurrencyCode("currencyCode1004773790")
   *           .setCohortSpec(CohortSpec.newBuilder().build())
   *           .setKeepEmptyRows(true)
   *           .setReturnPropertyQuota(true)
   *           .build();
   *   RunReportResponse response = betaAnalyticsDataClient.runReport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunReportResponse runReport(RunReportRequest request) {
    return runReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a customized report of your Google Analytics event data. Reports contain statistics
   * derived from data collected by the Google Analytics tracking code. The data returned from the
   * API is as a table with columns for the requested dimensions and metrics. Metrics are individual
   * measurements of user activity on your property, such as active users or event count. Dimensions
   * break down metrics across some common criteria, such as country or event name.
   *
   * <p>For a guide to constructing requests &amp; understanding responses, see [Creating a
   * Report](https://developers.google.com/analytics/devguides/reporting/data/v1/basics).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   RunReportRequest request =
   *       RunReportRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .addAllDimensions(new ArrayList<Dimension>())
   *           .addAllMetrics(new ArrayList<Metric>())
   *           .addAllDateRanges(new ArrayList<DateRange>())
   *           .setDimensionFilter(FilterExpression.newBuilder().build())
   *           .setMetricFilter(FilterExpression.newBuilder().build())
   *           .setOffset(-1019779949)
   *           .setLimit(102976443)
   *           .addAllMetricAggregations(new ArrayList<MetricAggregation>())
   *           .addAllOrderBys(new ArrayList<OrderBy>())
   *           .setCurrencyCode("currencyCode1004773790")
   *           .setCohortSpec(CohortSpec.newBuilder().build())
   *           .setKeepEmptyRows(true)
   *           .setReturnPropertyQuota(true)
   *           .build();
   *   ApiFuture<RunReportResponse> future =
   *       betaAnalyticsDataClient.runReportCallable().futureCall(request);
   *   // Do something.
   *   RunReportResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunReportRequest, RunReportResponse> runReportCallable() {
    return stub.runReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a customized pivot report of your Google Analytics event data. Pivot reports are more
   * advanced and expressive formats than regular reports. In a pivot report, dimensions are only
   * visible if they are included in a pivot. Multiple pivots can be specified to further dissect
   * your data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   RunPivotReportRequest request =
   *       RunPivotReportRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .addAllDimensions(new ArrayList<Dimension>())
   *           .addAllMetrics(new ArrayList<Metric>())
   *           .addAllDateRanges(new ArrayList<DateRange>())
   *           .addAllPivots(new ArrayList<Pivot>())
   *           .setDimensionFilter(FilterExpression.newBuilder().build())
   *           .setMetricFilter(FilterExpression.newBuilder().build())
   *           .setCurrencyCode("currencyCode1004773790")
   *           .setCohortSpec(CohortSpec.newBuilder().build())
   *           .setKeepEmptyRows(true)
   *           .setReturnPropertyQuota(true)
   *           .build();
   *   RunPivotReportResponse response = betaAnalyticsDataClient.runPivotReport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunPivotReportResponse runPivotReport(RunPivotReportRequest request) {
    return runPivotReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a customized pivot report of your Google Analytics event data. Pivot reports are more
   * advanced and expressive formats than regular reports. In a pivot report, dimensions are only
   * visible if they are included in a pivot. Multiple pivots can be specified to further dissect
   * your data.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   RunPivotReportRequest request =
   *       RunPivotReportRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .addAllDimensions(new ArrayList<Dimension>())
   *           .addAllMetrics(new ArrayList<Metric>())
   *           .addAllDateRanges(new ArrayList<DateRange>())
   *           .addAllPivots(new ArrayList<Pivot>())
   *           .setDimensionFilter(FilterExpression.newBuilder().build())
   *           .setMetricFilter(FilterExpression.newBuilder().build())
   *           .setCurrencyCode("currencyCode1004773790")
   *           .setCohortSpec(CohortSpec.newBuilder().build())
   *           .setKeepEmptyRows(true)
   *           .setReturnPropertyQuota(true)
   *           .build();
   *   ApiFuture<RunPivotReportResponse> future =
   *       betaAnalyticsDataClient.runPivotReportCallable().futureCall(request);
   *   // Do something.
   *   RunPivotReportResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunPivotReportRequest, RunPivotReportResponse>
      runPivotReportCallable() {
    return stub.runPivotReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns multiple reports in a batch. All reports must be for the same GA4 Property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   BatchRunReportsRequest request =
   *       BatchRunReportsRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .addAllRequests(new ArrayList<RunReportRequest>())
   *           .build();
   *   BatchRunReportsResponse response = betaAnalyticsDataClient.batchRunReports(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRunReportsResponse batchRunReports(BatchRunReportsRequest request) {
    return batchRunReportsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns multiple reports in a batch. All reports must be for the same GA4 Property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   BatchRunReportsRequest request =
   *       BatchRunReportsRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .addAllRequests(new ArrayList<RunReportRequest>())
   *           .build();
   *   ApiFuture<BatchRunReportsResponse> future =
   *       betaAnalyticsDataClient.batchRunReportsCallable().futureCall(request);
   *   // Do something.
   *   BatchRunReportsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchRunReportsRequest, BatchRunReportsResponse>
      batchRunReportsCallable() {
    return stub.batchRunReportsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns multiple pivot reports in a batch. All reports must be for the same GA4 Property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   BatchRunPivotReportsRequest request =
   *       BatchRunPivotReportsRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .addAllRequests(new ArrayList<RunPivotReportRequest>())
   *           .build();
   *   BatchRunPivotReportsResponse response = betaAnalyticsDataClient.batchRunPivotReports(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRunPivotReportsResponse batchRunPivotReports(
      BatchRunPivotReportsRequest request) {
    return batchRunPivotReportsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns multiple pivot reports in a batch. All reports must be for the same GA4 Property.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   BatchRunPivotReportsRequest request =
   *       BatchRunPivotReportsRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .addAllRequests(new ArrayList<RunPivotReportRequest>())
   *           .build();
   *   ApiFuture<BatchRunPivotReportsResponse> future =
   *       betaAnalyticsDataClient.batchRunPivotReportsCallable().futureCall(request);
   *   // Do something.
   *   BatchRunPivotReportsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>
      batchRunPivotReportsCallable() {
    return stub.batchRunPivotReportsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for dimensions and metrics available in reporting methods. Used to explore the
   * dimensions and metrics. In this method, a Google Analytics GA4 Property Identifier is specified
   * in the request, and the metadata response includes Custom dimensions and metrics as well as
   * Universal metadata.
   *
   * <p>For example if a custom metric with parameter name `levels_unlocked` is registered to a
   * property, the Metadata response will contain `customEvent:levels_unlocked`. Universal metadata
   * are dimensions and metrics applicable to any property such as `country` and `totalUsers`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   MetadataName name = MetadataName.of("[PROPERTY]");
   *   Metadata response = betaAnalyticsDataClient.getMetadata(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the metadata to retrieve. This name field is
   *     specified in the URL path and not URL parameters. Property is a numeric Google Analytics
   *     GA4 Property identifier. To learn more, see [where to find your Property
   *     ID](https://developers.google.com/analytics/devguides/reporting/data/v1/property-id).
   *     <p>Example: properties/1234/metadata
   *     <p>Set the Property ID to 0 for dimensions and metrics common to all properties. In this
   *     special mode, this method will not return custom dimensions and metrics.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Metadata getMetadata(MetadataName name) {
    GetMetadataRequest request =
        GetMetadataRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getMetadata(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for dimensions and metrics available in reporting methods. Used to explore the
   * dimensions and metrics. In this method, a Google Analytics GA4 Property Identifier is specified
   * in the request, and the metadata response includes Custom dimensions and metrics as well as
   * Universal metadata.
   *
   * <p>For example if a custom metric with parameter name `levels_unlocked` is registered to a
   * property, the Metadata response will contain `customEvent:levels_unlocked`. Universal metadata
   * are dimensions and metrics applicable to any property such as `country` and `totalUsers`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   String name = MetadataName.of("[PROPERTY]").toString();
   *   Metadata response = betaAnalyticsDataClient.getMetadata(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the metadata to retrieve. This name field is
   *     specified in the URL path and not URL parameters. Property is a numeric Google Analytics
   *     GA4 Property identifier. To learn more, see [where to find your Property
   *     ID](https://developers.google.com/analytics/devguides/reporting/data/v1/property-id).
   *     <p>Example: properties/1234/metadata
   *     <p>Set the Property ID to 0 for dimensions and metrics common to all properties. In this
   *     special mode, this method will not return custom dimensions and metrics.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Metadata getMetadata(String name) {
    GetMetadataRequest request = GetMetadataRequest.newBuilder().setName(name).build();
    return getMetadata(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for dimensions and metrics available in reporting methods. Used to explore the
   * dimensions and metrics. In this method, a Google Analytics GA4 Property Identifier is specified
   * in the request, and the metadata response includes Custom dimensions and metrics as well as
   * Universal metadata.
   *
   * <p>For example if a custom metric with parameter name `levels_unlocked` is registered to a
   * property, the Metadata response will contain `customEvent:levels_unlocked`. Universal metadata
   * are dimensions and metrics applicable to any property such as `country` and `totalUsers`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   GetMetadataRequest request =
   *       GetMetadataRequest.newBuilder().setName(MetadataName.of("[PROPERTY]").toString()).build();
   *   Metadata response = betaAnalyticsDataClient.getMetadata(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Metadata getMetadata(GetMetadataRequest request) {
    return getMetadataCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns metadata for dimensions and metrics available in reporting methods. Used to explore the
   * dimensions and metrics. In this method, a Google Analytics GA4 Property Identifier is specified
   * in the request, and the metadata response includes Custom dimensions and metrics as well as
   * Universal metadata.
   *
   * <p>For example if a custom metric with parameter name `levels_unlocked` is registered to a
   * property, the Metadata response will contain `customEvent:levels_unlocked`. Universal metadata
   * are dimensions and metrics applicable to any property such as `country` and `totalUsers`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   GetMetadataRequest request =
   *       GetMetadataRequest.newBuilder().setName(MetadataName.of("[PROPERTY]").toString()).build();
   *   ApiFuture<Metadata> future =
   *       betaAnalyticsDataClient.getMetadataCallable().futureCall(request);
   *   // Do something.
   *   Metadata response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMetadataRequest, Metadata> getMetadataCallable() {
    return stub.getMetadataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a customized report of realtime event data for your property. Events appear in realtime
   * reports seconds after they have been sent to the Google Analytics. Realtime reports show events
   * and usage data for the periods of time ranging from the present moment to 30 minutes ago (up to
   * 60 minutes for Google Analytics 360 properties).
   *
   * <p>For a guide to constructing realtime requests &amp; understanding responses, see [Creating a
   * Realtime
   * Report](https://developers.google.com/analytics/devguides/reporting/data/v1/realtime-basics).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   RunRealtimeReportRequest request =
   *       RunRealtimeReportRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .addAllDimensions(new ArrayList<Dimension>())
   *           .addAllMetrics(new ArrayList<Metric>())
   *           .setDimensionFilter(FilterExpression.newBuilder().build())
   *           .setMetricFilter(FilterExpression.newBuilder().build())
   *           .setLimit(102976443)
   *           .addAllMetricAggregations(new ArrayList<MetricAggregation>())
   *           .addAllOrderBys(new ArrayList<OrderBy>())
   *           .setReturnPropertyQuota(true)
   *           .addAllMinuteRanges(new ArrayList<MinuteRange>())
   *           .build();
   *   RunRealtimeReportResponse response = betaAnalyticsDataClient.runRealtimeReport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunRealtimeReportResponse runRealtimeReport(RunRealtimeReportRequest request) {
    return runRealtimeReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a customized report of realtime event data for your property. Events appear in realtime
   * reports seconds after they have been sent to the Google Analytics. Realtime reports show events
   * and usage data for the periods of time ranging from the present moment to 30 minutes ago (up to
   * 60 minutes for Google Analytics 360 properties).
   *
   * <p>For a guide to constructing realtime requests &amp; understanding responses, see [Creating a
   * Realtime
   * Report](https://developers.google.com/analytics/devguides/reporting/data/v1/realtime-basics).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   RunRealtimeReportRequest request =
   *       RunRealtimeReportRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .addAllDimensions(new ArrayList<Dimension>())
   *           .addAllMetrics(new ArrayList<Metric>())
   *           .setDimensionFilter(FilterExpression.newBuilder().build())
   *           .setMetricFilter(FilterExpression.newBuilder().build())
   *           .setLimit(102976443)
   *           .addAllMetricAggregations(new ArrayList<MetricAggregation>())
   *           .addAllOrderBys(new ArrayList<OrderBy>())
   *           .setReturnPropertyQuota(true)
   *           .addAllMinuteRanges(new ArrayList<MinuteRange>())
   *           .build();
   *   ApiFuture<RunRealtimeReportResponse> future =
   *       betaAnalyticsDataClient.runRealtimeReportCallable().futureCall(request);
   *   // Do something.
   *   RunRealtimeReportResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunRealtimeReportRequest, RunRealtimeReportResponse>
      runRealtimeReportCallable() {
    return stub.runRealtimeReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This compatibility method lists dimensions and metrics that can be added to a report request
   * and maintain compatibility. This method fails if the request's dimensions and metrics are
   * incompatible.
   *
   * <p>In Google Analytics, reports fail if they request incompatible dimensions and/or metrics; in
   * that case, you will need to remove dimensions and/or metrics from the incompatible report until
   * the report is compatible.
   *
   * <p>The Realtime and Core reports have different compatibility rules. This method checks
   * compatibility for Core reports.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   CheckCompatibilityRequest request =
   *       CheckCompatibilityRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .addAllDimensions(new ArrayList<Dimension>())
   *           .addAllMetrics(new ArrayList<Metric>())
   *           .setDimensionFilter(FilterExpression.newBuilder().build())
   *           .setMetricFilter(FilterExpression.newBuilder().build())
   *           .setCompatibilityFilter(Compatibility.forNumber(0))
   *           .build();
   *   CheckCompatibilityResponse response = betaAnalyticsDataClient.checkCompatibility(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CheckCompatibilityResponse checkCompatibility(CheckCompatibilityRequest request) {
    return checkCompatibilityCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * This compatibility method lists dimensions and metrics that can be added to a report request
   * and maintain compatibility. This method fails if the request's dimensions and metrics are
   * incompatible.
   *
   * <p>In Google Analytics, reports fail if they request incompatible dimensions and/or metrics; in
   * that case, you will need to remove dimensions and/or metrics from the incompatible report until
   * the report is compatible.
   *
   * <p>The Realtime and Core reports have different compatibility rules. This method checks
   * compatibility for Core reports.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   CheckCompatibilityRequest request =
   *       CheckCompatibilityRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .addAllDimensions(new ArrayList<Dimension>())
   *           .addAllMetrics(new ArrayList<Metric>())
   *           .setDimensionFilter(FilterExpression.newBuilder().build())
   *           .setMetricFilter(FilterExpression.newBuilder().build())
   *           .setCompatibilityFilter(Compatibility.forNumber(0))
   *           .build();
   *   ApiFuture<CheckCompatibilityResponse> future =
   *       betaAnalyticsDataClient.checkCompatibilityCallable().futureCall(request);
   *   // Do something.
   *   CheckCompatibilityResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CheckCompatibilityRequest, CheckCompatibilityResponse>
      checkCompatibilityCallable() {
    return stub.checkCompatibilityCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an audience export for later retrieval. This method quickly returns the audience
   * export's resource name and initiates a long running asynchronous request to form an audience
   * export. To export the users in an audience export, first create the audience export through
   * this method and then send the audience resource name to the `QueryAudienceExport` method.
   *
   * <p>See [Creating an Audience
   * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Exports with examples.
   *
   * <p>An audience export is a snapshot of the users currently in the audience at the time of
   * audience export creation. Creating audience exports for one audience on different days will
   * return different results as users enter and exit the audience.
   *
   * <p>Audiences in Google Analytics 4 allow you to segment your users in the ways that are
   * important to your business. To learn more, see
   * https://support.google.com/analytics/answer/9267572. Audience exports contain the users in each
   * audience.
   *
   * <p>Audience Export APIs have some methods at alpha and other methods at beta stability. The
   * intention is to advance methods to beta stability after some feedback and adoption. To give
   * your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   AudienceExport audienceExport = AudienceExport.newBuilder().build();
   *   AudienceExport response =
   *       betaAnalyticsDataClient.createAudienceExportAsync(parent, audienceExport).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this audience export will be created. Format:
   *     `properties/{property}`
   * @param audienceExport Required. The audience export to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AudienceExport, AudienceExportMetadata> createAudienceExportAsync(
      PropertyName parent, AudienceExport audienceExport) {
    CreateAudienceExportRequest request =
        CreateAudienceExportRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setAudienceExport(audienceExport)
            .build();
    return createAudienceExportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an audience export for later retrieval. This method quickly returns the audience
   * export's resource name and initiates a long running asynchronous request to form an audience
   * export. To export the users in an audience export, first create the audience export through
   * this method and then send the audience resource name to the `QueryAudienceExport` method.
   *
   * <p>See [Creating an Audience
   * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Exports with examples.
   *
   * <p>An audience export is a snapshot of the users currently in the audience at the time of
   * audience export creation. Creating audience exports for one audience on different days will
   * return different results as users enter and exit the audience.
   *
   * <p>Audiences in Google Analytics 4 allow you to segment your users in the ways that are
   * important to your business. To learn more, see
   * https://support.google.com/analytics/answer/9267572. Audience exports contain the users in each
   * audience.
   *
   * <p>Audience Export APIs have some methods at alpha and other methods at beta stability. The
   * intention is to advance methods to beta stability after some feedback and adoption. To give
   * your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   AudienceExport audienceExport = AudienceExport.newBuilder().build();
   *   AudienceExport response =
   *       betaAnalyticsDataClient.createAudienceExportAsync(parent, audienceExport).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this audience export will be created. Format:
   *     `properties/{property}`
   * @param audienceExport Required. The audience export to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AudienceExport, AudienceExportMetadata> createAudienceExportAsync(
      String parent, AudienceExport audienceExport) {
    CreateAudienceExportRequest request =
        CreateAudienceExportRequest.newBuilder()
            .setParent(parent)
            .setAudienceExport(audienceExport)
            .build();
    return createAudienceExportAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an audience export for later retrieval. This method quickly returns the audience
   * export's resource name and initiates a long running asynchronous request to form an audience
   * export. To export the users in an audience export, first create the audience export through
   * this method and then send the audience resource name to the `QueryAudienceExport` method.
   *
   * <p>See [Creating an Audience
   * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Exports with examples.
   *
   * <p>An audience export is a snapshot of the users currently in the audience at the time of
   * audience export creation. Creating audience exports for one audience on different days will
   * return different results as users enter and exit the audience.
   *
   * <p>Audiences in Google Analytics 4 allow you to segment your users in the ways that are
   * important to your business. To learn more, see
   * https://support.google.com/analytics/answer/9267572. Audience exports contain the users in each
   * audience.
   *
   * <p>Audience Export APIs have some methods at alpha and other methods at beta stability. The
   * intention is to advance methods to beta stability after some feedback and adoption. To give
   * your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   CreateAudienceExportRequest request =
   *       CreateAudienceExportRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setAudienceExport(AudienceExport.newBuilder().build())
   *           .build();
   *   AudienceExport response = betaAnalyticsDataClient.createAudienceExportAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<AudienceExport, AudienceExportMetadata> createAudienceExportAsync(
      CreateAudienceExportRequest request) {
    return createAudienceExportOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an audience export for later retrieval. This method quickly returns the audience
   * export's resource name and initiates a long running asynchronous request to form an audience
   * export. To export the users in an audience export, first create the audience export through
   * this method and then send the audience resource name to the `QueryAudienceExport` method.
   *
   * <p>See [Creating an Audience
   * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Exports with examples.
   *
   * <p>An audience export is a snapshot of the users currently in the audience at the time of
   * audience export creation. Creating audience exports for one audience on different days will
   * return different results as users enter and exit the audience.
   *
   * <p>Audiences in Google Analytics 4 allow you to segment your users in the ways that are
   * important to your business. To learn more, see
   * https://support.google.com/analytics/answer/9267572. Audience exports contain the users in each
   * audience.
   *
   * <p>Audience Export APIs have some methods at alpha and other methods at beta stability. The
   * intention is to advance methods to beta stability after some feedback and adoption. To give
   * your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   CreateAudienceExportRequest request =
   *       CreateAudienceExportRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setAudienceExport(AudienceExport.newBuilder().build())
   *           .build();
   *   OperationFuture<AudienceExport, AudienceExportMetadata> future =
   *       betaAnalyticsDataClient.createAudienceExportOperationCallable().futureCall(request);
   *   // Do something.
   *   AudienceExport response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<
          CreateAudienceExportRequest, AudienceExport, AudienceExportMetadata>
      createAudienceExportOperationCallable() {
    return stub.createAudienceExportOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an audience export for later retrieval. This method quickly returns the audience
   * export's resource name and initiates a long running asynchronous request to form an audience
   * export. To export the users in an audience export, first create the audience export through
   * this method and then send the audience resource name to the `QueryAudienceExport` method.
   *
   * <p>See [Creating an Audience
   * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Exports with examples.
   *
   * <p>An audience export is a snapshot of the users currently in the audience at the time of
   * audience export creation. Creating audience exports for one audience on different days will
   * return different results as users enter and exit the audience.
   *
   * <p>Audiences in Google Analytics 4 allow you to segment your users in the ways that are
   * important to your business. To learn more, see
   * https://support.google.com/analytics/answer/9267572. Audience exports contain the users in each
   * audience.
   *
   * <p>Audience Export APIs have some methods at alpha and other methods at beta stability. The
   * intention is to advance methods to beta stability after some feedback and adoption. To give
   * your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   CreateAudienceExportRequest request =
   *       CreateAudienceExportRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setAudienceExport(AudienceExport.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future =
   *       betaAnalyticsDataClient.createAudienceExportCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateAudienceExportRequest, Operation>
      createAudienceExportCallable() {
    return stub.createAudienceExportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an audience export of users. After creating an audience, the users are not
   * immediately available for exporting. First, a request to `CreateAudienceExport` is necessary to
   * create an audience export of users, and then second, this method is used to retrieve the users
   * in the audience export.
   *
   * <p>See [Creating an Audience
   * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Exports with examples.
   *
   * <p>Audiences in Google Analytics 4 allow you to segment your users in the ways that are
   * important to your business. To learn more, see
   * https://support.google.com/analytics/answer/9267572.
   *
   * <p>Audience Export APIs have some methods at alpha and other methods at beta stability. The
   * intention is to advance methods to beta stability after some feedback and adoption. To give
   * your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   String name = "name3373707";
   *   QueryAudienceExportResponse response = betaAnalyticsDataClient.queryAudienceExport(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the audience export to retrieve users from. Format:
   *     `properties/{property}/audienceExports/{audience_export}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryAudienceExportResponse queryAudienceExport(String name) {
    QueryAudienceExportRequest request =
        QueryAudienceExportRequest.newBuilder().setName(name).build();
    return queryAudienceExport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an audience export of users. After creating an audience, the users are not
   * immediately available for exporting. First, a request to `CreateAudienceExport` is necessary to
   * create an audience export of users, and then second, this method is used to retrieve the users
   * in the audience export.
   *
   * <p>See [Creating an Audience
   * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Exports with examples.
   *
   * <p>Audiences in Google Analytics 4 allow you to segment your users in the ways that are
   * important to your business. To learn more, see
   * https://support.google.com/analytics/answer/9267572.
   *
   * <p>Audience Export APIs have some methods at alpha and other methods at beta stability. The
   * intention is to advance methods to beta stability after some feedback and adoption. To give
   * your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   QueryAudienceExportRequest request =
   *       QueryAudienceExportRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOffset(-1019779949)
   *           .setLimit(102976443)
   *           .build();
   *   QueryAudienceExportResponse response = betaAnalyticsDataClient.queryAudienceExport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final QueryAudienceExportResponse queryAudienceExport(QueryAudienceExportRequest request) {
    return queryAudienceExportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves an audience export of users. After creating an audience, the users are not
   * immediately available for exporting. First, a request to `CreateAudienceExport` is necessary to
   * create an audience export of users, and then second, this method is used to retrieve the users
   * in the audience export.
   *
   * <p>See [Creating an Audience
   * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Exports with examples.
   *
   * <p>Audiences in Google Analytics 4 allow you to segment your users in the ways that are
   * important to your business. To learn more, see
   * https://support.google.com/analytics/answer/9267572.
   *
   * <p>Audience Export APIs have some methods at alpha and other methods at beta stability. The
   * intention is to advance methods to beta stability after some feedback and adoption. To give
   * your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   QueryAudienceExportRequest request =
   *       QueryAudienceExportRequest.newBuilder()
   *           .setName("name3373707")
   *           .setOffset(-1019779949)
   *           .setLimit(102976443)
   *           .build();
   *   ApiFuture<QueryAudienceExportResponse> future =
   *       betaAnalyticsDataClient.queryAudienceExportCallable().futureCall(request);
   *   // Do something.
   *   QueryAudienceExportResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<QueryAudienceExportRequest, QueryAudienceExportResponse>
      queryAudienceExportCallable() {
    return stub.queryAudienceExportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets configuration metadata about a specific audience export. This method can be used to
   * understand an audience export after it has been created.
   *
   * <p>See [Creating an Audience
   * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Exports with examples.
   *
   * <p>Audience Export APIs have some methods at alpha and other methods at beta stability. The
   * intention is to advance methods to beta stability after some feedback and adoption. To give
   * your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   AudienceExportName name = AudienceExportName.of("[PROPERTY]", "[AUDIENCE_EXPORT]");
   *   AudienceExport response = betaAnalyticsDataClient.getAudienceExport(name);
   * }
   * }</pre>
   *
   * @param name Required. The audience export resource name. Format:
   *     `properties/{property}/audienceExports/{audience_export}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AudienceExport getAudienceExport(AudienceExportName name) {
    GetAudienceExportRequest request =
        GetAudienceExportRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAudienceExport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets configuration metadata about a specific audience export. This method can be used to
   * understand an audience export after it has been created.
   *
   * <p>See [Creating an Audience
   * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Exports with examples.
   *
   * <p>Audience Export APIs have some methods at alpha and other methods at beta stability. The
   * intention is to advance methods to beta stability after some feedback and adoption. To give
   * your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   String name = AudienceExportName.of("[PROPERTY]", "[AUDIENCE_EXPORT]").toString();
   *   AudienceExport response = betaAnalyticsDataClient.getAudienceExport(name);
   * }
   * }</pre>
   *
   * @param name Required. The audience export resource name. Format:
   *     `properties/{property}/audienceExports/{audience_export}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AudienceExport getAudienceExport(String name) {
    GetAudienceExportRequest request = GetAudienceExportRequest.newBuilder().setName(name).build();
    return getAudienceExport(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets configuration metadata about a specific audience export. This method can be used to
   * understand an audience export after it has been created.
   *
   * <p>See [Creating an Audience
   * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Exports with examples.
   *
   * <p>Audience Export APIs have some methods at alpha and other methods at beta stability. The
   * intention is to advance methods to beta stability after some feedback and adoption. To give
   * your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   GetAudienceExportRequest request =
   *       GetAudienceExportRequest.newBuilder()
   *           .setName(AudienceExportName.of("[PROPERTY]", "[AUDIENCE_EXPORT]").toString())
   *           .build();
   *   AudienceExport response = betaAnalyticsDataClient.getAudienceExport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AudienceExport getAudienceExport(GetAudienceExportRequest request) {
    return getAudienceExportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets configuration metadata about a specific audience export. This method can be used to
   * understand an audience export after it has been created.
   *
   * <p>See [Creating an Audience
   * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Exports with examples.
   *
   * <p>Audience Export APIs have some methods at alpha and other methods at beta stability. The
   * intention is to advance methods to beta stability after some feedback and adoption. To give
   * your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   GetAudienceExportRequest request =
   *       GetAudienceExportRequest.newBuilder()
   *           .setName(AudienceExportName.of("[PROPERTY]", "[AUDIENCE_EXPORT]").toString())
   *           .build();
   *   ApiFuture<AudienceExport> future =
   *       betaAnalyticsDataClient.getAudienceExportCallable().futureCall(request);
   *   // Do something.
   *   AudienceExport response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAudienceExportRequest, AudienceExport> getAudienceExportCallable() {
    return stub.getAudienceExportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all audience exports for a property. This method can be used for you to find and reuse
   * existing audience exports rather than creating unnecessary new audience exports. The same
   * audience can have multiple audience exports that represent the export of users that were in an
   * audience on different days.
   *
   * <p>See [Creating an Audience
   * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Exports with examples.
   *
   * <p>Audience Export APIs have some methods at alpha and other methods at beta stability. The
   * intention is to advance methods to beta stability after some feedback and adoption. To give
   * your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   PropertyName parent = PropertyName.of("[PROPERTY]");
   *   for (AudienceExport element :
   *       betaAnalyticsDataClient.listAudienceExports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. All audience exports for this property will be listed in the response.
   *     Format: `properties/{property}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAudienceExportsPagedResponse listAudienceExports(PropertyName parent) {
    ListAudienceExportsRequest request =
        ListAudienceExportsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAudienceExports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all audience exports for a property. This method can be used for you to find and reuse
   * existing audience exports rather than creating unnecessary new audience exports. The same
   * audience can have multiple audience exports that represent the export of users that were in an
   * audience on different days.
   *
   * <p>See [Creating an Audience
   * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Exports with examples.
   *
   * <p>Audience Export APIs have some methods at alpha and other methods at beta stability. The
   * intention is to advance methods to beta stability after some feedback and adoption. To give
   * your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   String parent = PropertyName.of("[PROPERTY]").toString();
   *   for (AudienceExport element :
   *       betaAnalyticsDataClient.listAudienceExports(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. All audience exports for this property will be listed in the response.
   *     Format: `properties/{property}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAudienceExportsPagedResponse listAudienceExports(String parent) {
    ListAudienceExportsRequest request =
        ListAudienceExportsRequest.newBuilder().setParent(parent).build();
    return listAudienceExports(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all audience exports for a property. This method can be used for you to find and reuse
   * existing audience exports rather than creating unnecessary new audience exports. The same
   * audience can have multiple audience exports that represent the export of users that were in an
   * audience on different days.
   *
   * <p>See [Creating an Audience
   * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Exports with examples.
   *
   * <p>Audience Export APIs have some methods at alpha and other methods at beta stability. The
   * intention is to advance methods to beta stability after some feedback and adoption. To give
   * your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   ListAudienceExportsRequest request =
   *       ListAudienceExportsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (AudienceExport element :
   *       betaAnalyticsDataClient.listAudienceExports(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAudienceExportsPagedResponse listAudienceExports(
      ListAudienceExportsRequest request) {
    return listAudienceExportsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all audience exports for a property. This method can be used for you to find and reuse
   * existing audience exports rather than creating unnecessary new audience exports. The same
   * audience can have multiple audience exports that represent the export of users that were in an
   * audience on different days.
   *
   * <p>See [Creating an Audience
   * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Exports with examples.
   *
   * <p>Audience Export APIs have some methods at alpha and other methods at beta stability. The
   * intention is to advance methods to beta stability after some feedback and adoption. To give
   * your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   ListAudienceExportsRequest request =
   *       ListAudienceExportsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<AudienceExport> future =
   *       betaAnalyticsDataClient.listAudienceExportsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AudienceExport element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAudienceExportsRequest, ListAudienceExportsPagedResponse>
      listAudienceExportsPagedCallable() {
    return stub.listAudienceExportsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all audience exports for a property. This method can be used for you to find and reuse
   * existing audience exports rather than creating unnecessary new audience exports. The same
   * audience can have multiple audience exports that represent the export of users that were in an
   * audience on different days.
   *
   * <p>See [Creating an Audience
   * Export](https://developers.google.com/analytics/devguides/reporting/data/v1/audience-list-basics)
   * for an introduction to Audience Exports with examples.
   *
   * <p>Audience Export APIs have some methods at alpha and other methods at beta stability. The
   * intention is to advance methods to beta stability after some feedback and adoption. To give
   * your feedback on this API, complete the [Google Analytics Audience Export API
   * Feedback](https://forms.gle/EeA5u5LW6PEggtCEA) form.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (BetaAnalyticsDataClient betaAnalyticsDataClient = BetaAnalyticsDataClient.create()) {
   *   ListAudienceExportsRequest request =
   *       ListAudienceExportsRequest.newBuilder()
   *           .setParent(PropertyName.of("[PROPERTY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListAudienceExportsResponse response =
   *         betaAnalyticsDataClient.listAudienceExportsCallable().call(request);
   *     for (AudienceExport element : response.getAudienceExportsList()) {
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
  public final UnaryCallable<ListAudienceExportsRequest, ListAudienceExportsResponse>
      listAudienceExportsCallable() {
    return stub.listAudienceExportsCallable();
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

  public static class ListAudienceExportsPagedResponse
      extends AbstractPagedListResponse<
          ListAudienceExportsRequest,
          ListAudienceExportsResponse,
          AudienceExport,
          ListAudienceExportsPage,
          ListAudienceExportsFixedSizeCollection> {

    public static ApiFuture<ListAudienceExportsPagedResponse> createAsync(
        PageContext<ListAudienceExportsRequest, ListAudienceExportsResponse, AudienceExport>
            context,
        ApiFuture<ListAudienceExportsResponse> futureResponse) {
      ApiFuture<ListAudienceExportsPage> futurePage =
          ListAudienceExportsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAudienceExportsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAudienceExportsPagedResponse(ListAudienceExportsPage page) {
      super(page, ListAudienceExportsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAudienceExportsPage
      extends AbstractPage<
          ListAudienceExportsRequest,
          ListAudienceExportsResponse,
          AudienceExport,
          ListAudienceExportsPage> {

    private ListAudienceExportsPage(
        PageContext<ListAudienceExportsRequest, ListAudienceExportsResponse, AudienceExport>
            context,
        ListAudienceExportsResponse response) {
      super(context, response);
    }

    private static ListAudienceExportsPage createEmptyPage() {
      return new ListAudienceExportsPage(null, null);
    }

    @Override
    protected ListAudienceExportsPage createPage(
        PageContext<ListAudienceExportsRequest, ListAudienceExportsResponse, AudienceExport>
            context,
        ListAudienceExportsResponse response) {
      return new ListAudienceExportsPage(context, response);
    }

    @Override
    public ApiFuture<ListAudienceExportsPage> createPageAsync(
        PageContext<ListAudienceExportsRequest, ListAudienceExportsResponse, AudienceExport>
            context,
        ApiFuture<ListAudienceExportsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAudienceExportsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAudienceExportsRequest,
          ListAudienceExportsResponse,
          AudienceExport,
          ListAudienceExportsPage,
          ListAudienceExportsFixedSizeCollection> {

    private ListAudienceExportsFixedSizeCollection(
        List<ListAudienceExportsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAudienceExportsFixedSizeCollection createEmptyCollection() {
      return new ListAudienceExportsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAudienceExportsFixedSizeCollection createCollection(
        List<ListAudienceExportsPage> pages, int collectionSize) {
      return new ListAudienceExportsFixedSizeCollection(pages, collectionSize);
    }
  }
}
