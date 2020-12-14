/*
 * Copyright 2020 Google LLC
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

package com.google.analytics.data.v1alpha;

import com.google.analytics.data.v1alpha.stub.AlphaAnalyticsDataStub;
import com.google.analytics.data.v1alpha.stub.AlphaAnalyticsDataStubSettings;
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
 * <p>Note: close() needs to be called on the AlphaAnalyticsDataClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of AlphaAnalyticsDataSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * AlphaAnalyticsDataSettings alphaAnalyticsDataSettings =
 *     AlphaAnalyticsDataSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AlphaAnalyticsDataClient alphaAnalyticsDataClient =
 *     AlphaAnalyticsDataClient.create(alphaAnalyticsDataSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * AlphaAnalyticsDataSettings alphaAnalyticsDataSettings =
 *     AlphaAnalyticsDataSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AlphaAnalyticsDataClient alphaAnalyticsDataClient =
 *     AlphaAnalyticsDataClient.create(alphaAnalyticsDataSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
public class AlphaAnalyticsDataClient implements BackgroundResource {
  private final AlphaAnalyticsDataSettings settings;
  private final AlphaAnalyticsDataStub stub;

  /** Constructs an instance of AlphaAnalyticsDataClient with default settings. */
  public static final AlphaAnalyticsDataClient create() throws IOException {
    return create(AlphaAnalyticsDataSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AlphaAnalyticsDataClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AlphaAnalyticsDataClient create(AlphaAnalyticsDataSettings settings)
      throws IOException {
    return new AlphaAnalyticsDataClient(settings);
  }

  /**
   * Constructs an instance of AlphaAnalyticsDataClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(AlphaAnalyticsDataSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final AlphaAnalyticsDataClient create(AlphaAnalyticsDataStub stub) {
    return new AlphaAnalyticsDataClient(stub);
  }

  /**
   * Constructs an instance of AlphaAnalyticsDataClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AlphaAnalyticsDataClient(AlphaAnalyticsDataSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AlphaAnalyticsDataStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected AlphaAnalyticsDataClient(AlphaAnalyticsDataStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AlphaAnalyticsDataSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public AlphaAnalyticsDataStub getStub() {
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
   * <p>Sample code:
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
   */
  public final UnaryCallable<RunPivotReportRequest, RunPivotReportResponse>
      runPivotReportCallable() {
    return stub.runPivotReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns multiple reports in a batch. All reports must be for the same Entity.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRunReportsResponse batchRunReports(BatchRunReportsRequest request) {
    return batchRunReportsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns multiple reports in a batch. All reports must be for the same Entity.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<BatchRunReportsRequest, BatchRunReportsResponse>
      batchRunReportsCallable() {
    return stub.batchRunReportsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns multiple pivot reports in a batch. All reports must be for the same Entity.
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
   * Returns multiple pivot reports in a batch. All reports must be for the same Entity.
   *
   * <p>Sample code:
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
   */
  public final UnaryCallable<GetMetadataRequest, Metadata> getMetadataCallable() {
    return stub.getMetadataCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * The Google Analytics Realtime API returns a customized report of realtime event data for your
   * property. These reports show events and usage from the last 30 minutes.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunRealtimeReportResponse runRealtimeReport(RunRealtimeReportRequest request) {
    return runRealtimeReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * The Google Analytics Realtime API returns a customized report of realtime event data for your
   * property. These reports show events and usage from the last 30 minutes.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<RunRealtimeReportRequest, RunRealtimeReportResponse>
      runRealtimeReportCallable() {
    return stub.runRealtimeReportCallable();
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
