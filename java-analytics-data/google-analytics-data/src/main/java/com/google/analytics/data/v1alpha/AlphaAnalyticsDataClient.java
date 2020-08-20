/*
 * Copyright 2020 Google LLC
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
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

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Google Analytics reporting data service.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
 *   RunReportRequest request = RunReportRequest.newBuilder().build();
 *   RunReportResponse response = alphaAnalyticsDataClient.runReport(request);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the alphaAnalyticsDataClient object to clean up resources
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
 * <pre>
 * <code>
 * AlphaAnalyticsDataSettings alphaAnalyticsDataSettings =
 *     AlphaAnalyticsDataSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AlphaAnalyticsDataClient alphaAnalyticsDataClient =
 *     AlphaAnalyticsDataClient.create(alphaAnalyticsDataSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * AlphaAnalyticsDataSettings alphaAnalyticsDataSettings =
 *     AlphaAnalyticsDataSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AlphaAnalyticsDataClient alphaAnalyticsDataClient =
 *     AlphaAnalyticsDataClient.create(alphaAnalyticsDataSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
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
   * is for advanced usage - prefer to use AlphaAnalyticsDataSettings}.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns a customized report of your Google Analytics event data. Reports contain statistics
   * derived from data collected by the Google Analytics tracking code. The data returned from the
   * API is as a table with columns for the requested dimensions and metrics. Metrics are individual
   * measurements of user activity on your property, such as active users or event count. Dimensions
   * break down metrics across some common criteria, such as country or event name.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   RunReportRequest request = RunReportRequest.newBuilder().build();
   *   RunReportResponse response = alphaAnalyticsDataClient.runReport(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunReportResponse runReport(RunReportRequest request) {
    return runReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns a customized report of your Google Analytics event data. Reports contain statistics
   * derived from data collected by the Google Analytics tracking code. The data returned from the
   * API is as a table with columns for the requested dimensions and metrics. Metrics are individual
   * measurements of user activity on your property, such as active users or event count. Dimensions
   * break down metrics across some common criteria, such as country or event name.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   RunReportRequest request = RunReportRequest.newBuilder().build();
   *   ApiFuture&lt;RunReportResponse&gt; future = alphaAnalyticsDataClient.runReportCallable().futureCall(request);
   *   // Do something
   *   RunReportResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RunReportRequest, RunReportResponse> runReportCallable() {
    return stub.runReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns a customized pivot report of your Google Analytics event data. Pivot reports are more
   * advanced and expressive formats than regular reports. In a pivot report, dimensions are only
   * visible if they are included in a pivot. Multiple pivots can be specified to further dissect
   * your data.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   RunPivotReportRequest request = RunPivotReportRequest.newBuilder().build();
   *   RunPivotReportResponse response = alphaAnalyticsDataClient.runPivotReport(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final RunPivotReportResponse runPivotReport(RunPivotReportRequest request) {
    return runPivotReportCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns a customized pivot report of your Google Analytics event data. Pivot reports are more
   * advanced and expressive formats than regular reports. In a pivot report, dimensions are only
   * visible if they are included in a pivot. Multiple pivots can be specified to further dissect
   * your data.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   RunPivotReportRequest request = RunPivotReportRequest.newBuilder().build();
   *   ApiFuture&lt;RunPivotReportResponse&gt; future = alphaAnalyticsDataClient.runPivotReportCallable().futureCall(request);
   *   // Do something
   *   RunPivotReportResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<RunPivotReportRequest, RunPivotReportResponse>
      runPivotReportCallable() {
    return stub.runPivotReportCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns multiple reports in a batch. All reports must be for the same Entity.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   BatchRunReportsRequest request = BatchRunReportsRequest.newBuilder().build();
   *   BatchRunReportsResponse response = alphaAnalyticsDataClient.batchRunReports(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRunReportsResponse batchRunReports(BatchRunReportsRequest request) {
    return batchRunReportsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns multiple reports in a batch. All reports must be for the same Entity.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   BatchRunReportsRequest request = BatchRunReportsRequest.newBuilder().build();
   *   ApiFuture&lt;BatchRunReportsResponse&gt; future = alphaAnalyticsDataClient.batchRunReportsCallable().futureCall(request);
   *   // Do something
   *   BatchRunReportsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<BatchRunReportsRequest, BatchRunReportsResponse>
      batchRunReportsCallable() {
    return stub.batchRunReportsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns multiple pivot reports in a batch. All reports must be for the same Entity.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   BatchRunPivotReportsRequest request = BatchRunPivotReportsRequest.newBuilder().build();
   *   BatchRunPivotReportsResponse response = alphaAnalyticsDataClient.batchRunPivotReports(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRunPivotReportsResponse batchRunPivotReports(
      BatchRunPivotReportsRequest request) {
    return batchRunPivotReportsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns multiple pivot reports in a batch. All reports must be for the same Entity.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AlphaAnalyticsDataClient alphaAnalyticsDataClient = AlphaAnalyticsDataClient.create()) {
   *   BatchRunPivotReportsRequest request = BatchRunPivotReportsRequest.newBuilder().build();
   *   ApiFuture&lt;BatchRunPivotReportsResponse&gt; future = alphaAnalyticsDataClient.batchRunPivotReportsCallable().futureCall(request);
   *   // Do something
   *   BatchRunPivotReportsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<BatchRunPivotReportsRequest, BatchRunPivotReportsResponse>
      batchRunPivotReportsCallable() {
    return stub.batchRunPivotReportsCallable();
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
