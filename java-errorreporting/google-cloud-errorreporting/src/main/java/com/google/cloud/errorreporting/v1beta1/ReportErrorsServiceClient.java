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

package com.google.cloud.errorreporting.v1beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.errorreporting.v1beta1.stub.ReportErrorsServiceStub;
import com.google.cloud.errorreporting.v1beta1.stub.ReportErrorsServiceStubSettings;
import com.google.devtools.clouderrorreporting.v1beta1.ProjectName;
import com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventRequest;
import com.google.devtools.clouderrorreporting.v1beta1.ReportErrorEventResponse;
import com.google.devtools.clouderrorreporting.v1beta1.ReportedErrorEvent;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: An API for reporting error events.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the ReportErrorsServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of ReportErrorsServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * ReportErrorsServiceSettings reportErrorsServiceSettings =
 *     ReportErrorsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ReportErrorsServiceClient reportErrorsServiceClient =
 *     ReportErrorsServiceClient.create(reportErrorsServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * ReportErrorsServiceSettings reportErrorsServiceSettings =
 *     ReportErrorsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ReportErrorsServiceClient reportErrorsServiceClient =
 *     ReportErrorsServiceClient.create(reportErrorsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
public class ReportErrorsServiceClient implements BackgroundResource {
  private final ReportErrorsServiceSettings settings;
  private final ReportErrorsServiceStub stub;

  /** Constructs an instance of ReportErrorsServiceClient with default settings. */
  public static final ReportErrorsServiceClient create() throws IOException {
    return create(ReportErrorsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ReportErrorsServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ReportErrorsServiceClient create(ReportErrorsServiceSettings settings)
      throws IOException {
    return new ReportErrorsServiceClient(settings);
  }

  /**
   * Constructs an instance of ReportErrorsServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ReportErrorsServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ReportErrorsServiceClient create(ReportErrorsServiceStub stub) {
    return new ReportErrorsServiceClient(stub);
  }

  /**
   * Constructs an instance of ReportErrorsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ReportErrorsServiceClient(ReportErrorsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ReportErrorsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ReportErrorsServiceClient(ReportErrorsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ReportErrorsServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ReportErrorsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Report an individual error event.
   *
   * <p>This endpoint accepts &#42;&#42;either&#42;&#42; an OAuth token,
   *
   * <ul>
   *   <li>&#42;or&#42;&#42; an [API key](https://support.google.com/cloud/answer/6158862) for
   *       authentication. To use an API key, append it to the URL as the value of a `key`
   *       parameter. For example:
   * </ul>
   *
   * <p>`POST
   * https://clouderrorreporting.googleapis.com/v1beta1/projects/example-project/events:report?key=123ABC456`
   *
   * @param projectName Required. The resource name of the Google Cloud Platform project. Written as
   *     `projects/` plus the [Google Cloud Platform project
   *     ID](https://support.google.com/cloud/answer/6158840). Example: `projects/my-project-123`.
   * @param event Required. The error event to be reported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReportErrorEventResponse reportErrorEvent(
      ProjectName projectName, ReportedErrorEvent event) {
    ReportErrorEventRequest request =
        ReportErrorEventRequest.newBuilder()
            .setProjectName(projectName == null ? null : projectName.toString())
            .setEvent(event)
            .build();
    return reportErrorEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Report an individual error event.
   *
   * <p>This endpoint accepts &#42;&#42;either&#42;&#42; an OAuth token,
   *
   * <ul>
   *   <li>&#42;or&#42;&#42; an [API key](https://support.google.com/cloud/answer/6158862) for
   *       authentication. To use an API key, append it to the URL as the value of a `key`
   *       parameter. For example:
   * </ul>
   *
   * <p>`POST
   * https://clouderrorreporting.googleapis.com/v1beta1/projects/example-project/events:report?key=123ABC456`
   *
   * @param projectName Required. The resource name of the Google Cloud Platform project. Written as
   *     `projects/` plus the [Google Cloud Platform project
   *     ID](https://support.google.com/cloud/answer/6158840). Example: `projects/my-project-123`.
   * @param event Required. The error event to be reported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReportErrorEventResponse reportErrorEvent(
      String projectName, ReportedErrorEvent event) {
    ReportErrorEventRequest request =
        ReportErrorEventRequest.newBuilder().setProjectName(projectName).setEvent(event).build();
    return reportErrorEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Report an individual error event.
   *
   * <p>This endpoint accepts &#42;&#42;either&#42;&#42; an OAuth token,
   *
   * <ul>
   *   <li>&#42;or&#42;&#42; an [API key](https://support.google.com/cloud/answer/6158862) for
   *       authentication. To use an API key, append it to the URL as the value of a `key`
   *       parameter. For example:
   * </ul>
   *
   * <p>`POST
   * https://clouderrorreporting.googleapis.com/v1beta1/projects/example-project/events:report?key=123ABC456`
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReportErrorEventResponse reportErrorEvent(ReportErrorEventRequest request) {
    return reportErrorEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Report an individual error event.
   *
   * <p>This endpoint accepts &#42;&#42;either&#42;&#42; an OAuth token,
   *
   * <ul>
   *   <li>&#42;or&#42;&#42; an [API key](https://support.google.com/cloud/answer/6158862) for
   *       authentication. To use an API key, append it to the URL as the value of a `key`
   *       parameter. For example:
   * </ul>
   *
   * <p>`POST
   * https://clouderrorreporting.googleapis.com/v1beta1/projects/example-project/events:report?key=123ABC456`
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ReportErrorEventRequest, ReportErrorEventResponse>
      reportErrorEventCallable() {
    return stub.reportErrorEventCallable();
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
