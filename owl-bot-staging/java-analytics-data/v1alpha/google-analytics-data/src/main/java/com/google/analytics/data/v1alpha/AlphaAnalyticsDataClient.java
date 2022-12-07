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
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
 *   RunFunnelReportRequest request =
 *       RunFunnelReportRequest.newBuilder()
 *           .setProperty("property-993141291")
 *           .addAllDateRanges(new ArrayList<DateRange>())
 *           .setFunnel(Funnel.newBuilder().build())
 *           .setFunnelBreakdown(FunnelBreakdown.newBuilder().build())
 *           .setFunnelNextAction(FunnelNextAction.newBuilder().build())
 *           .addAllSegments(new ArrayList<Segment>())
 *           .setLimit(102976443)
 *           .setDimensionFilter(FilterExpression.newBuilder().build())
 *           .setReturnPropertyQuota(true)
 *           .build();
 *   RunFunnelReportResponse response = alphaAnalyticsDataClient.runFunnelReport(request);
 * }
 * }</pre>
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AlphaAnalyticsDataSettings alphaAnalyticsDataSettings =
 *     AlphaAnalyticsDataSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AlphaAnalyticsDataClient alphaAnalyticsDataClient =
 *     AlphaAnalyticsDataClient.create(alphaAnalyticsDataSettings);
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
 * AlphaAnalyticsDataSettings alphaAnalyticsDataSettings =
 *     AlphaAnalyticsDataSettings.newHttpJsonBuilder().build();
 * AlphaAnalyticsDataClient alphaAnalyticsDataClient =
 *     AlphaAnalyticsDataClient.create(alphaAnalyticsDataSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
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

  protected AlphaAnalyticsDataClient(AlphaAnalyticsDataStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AlphaAnalyticsDataSettings getSettings() {
    return settings;
  }

  public AlphaAnalyticsDataStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a customized funnel report of your Google Analytics event data. The data returned from
   * the API is as a table with columns for the requested dimensions and metrics.
   *
   * <p>Funnel exploration lets you visualize the steps your users take to complete a task and
   * quickly see how well they are succeeding or failing at each step. For example, how do prospects
   * become shoppers and then become buyers? How do one time buyers become repeat buyers? With this
   * information, you can improve inefficient or abandoned customer journeys. To learn more, see
   * [GA4 Funnel Explorations](https://support.google.com/analytics/answer/9327974).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   RunFunnelReportRequest request =
   *       RunFunnelReportRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .addAllDateRanges(new ArrayList<DateRange>())
   *           .setFunnel(Funnel.newBuilder().build())
   *           .setFunnelBreakdown(FunnelBreakdown.newBuilder().build())
   *           .setFunnelNextAction(FunnelNextAction.newBuilder().build())
   *           .addAllSegments(new ArrayList<Segment>())
   *           .setLimit(102976443)
   *           .setDimensionFilter(FilterExpression.newBuilder().build())
   *           .setReturnPropertyQuota(true)
   *           .build();
   *   RunFunnelReportResponse response = alphaAnalyticsDataClient.runFunnelReport(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunFunnelReportResponse runFunnelReport(RunFunnelReportRequest request) {
    return runFunnelReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a customized funnel report of your Google Analytics event data. The data returned from
   * the API is as a table with columns for the requested dimensions and metrics.
   *
   * <p>Funnel exploration lets you visualize the steps your users take to complete a task and
   * quickly see how well they are succeeding or failing at each step. For example, how do prospects
   * become shoppers and then become buyers? How do one time buyers become repeat buyers? With this
   * information, you can improve inefficient or abandoned customer journeys. To learn more, see
   * [GA4 Funnel Explorations](https://support.google.com/analytics/answer/9327974).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   RunFunnelReportRequest request =
   *       RunFunnelReportRequest.newBuilder()
   *           .setProperty("property-993141291")
   *           .addAllDateRanges(new ArrayList<DateRange>())
   *           .setFunnel(Funnel.newBuilder().build())
   *           .setFunnelBreakdown(FunnelBreakdown.newBuilder().build())
   *           .setFunnelNextAction(FunnelNextAction.newBuilder().build())
   *           .addAllSegments(new ArrayList<Segment>())
   *           .setLimit(102976443)
   *           .setDimensionFilter(FilterExpression.newBuilder().build())
   *           .setReturnPropertyQuota(true)
   *           .build();
   *   ApiFuture<RunFunnelReportResponse> future =
   *       alphaAnalyticsDataClient.runFunnelReportCallable().futureCall(request);
   *   // Do something.
   *   RunFunnelReportResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RunFunnelReportRequest, RunFunnelReportResponse>
      runFunnelReportCallable() {
    return stub.runFunnelReportCallable();
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
