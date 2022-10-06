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

package com.google.analytics.data.v1beta;

import com.google.analytics.data.v1beta.stub.BetaAnalyticsDataStub;
import com.google.analytics.data.v1beta.stub.BetaAnalyticsDataStubSettings;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import java.io.IOException;
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
 *     BetaAnalyticsDataSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             BetaAnalyticsDataSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
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
  }

  protected BetaAnalyticsDataClient(BetaAnalyticsDataStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final BetaAnalyticsDataSettings getSettings() {
    return settings;
  }

  public BetaAnalyticsDataStub getStub() {
    return stub;
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
