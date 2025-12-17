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

package com.google.cloud.compute.v1;

import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.AdviceStub;
import com.google.cloud.compute.v1.stub.AdviceStubSettings;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Advice API.
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
 * try (AdviceClient adviceClient = AdviceClient.create()) {
 *   String project = "project-309310695";
 *   String region = "region-934795532";
 *   CalendarModeAdviceRequest calendarModeAdviceRequestResource =
 *       CalendarModeAdviceRequest.newBuilder().build();
 *   CalendarModeAdviceResponse response =
 *       adviceClient.calendarMode(project, region, calendarModeAdviceRequestResource);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AdviceClient object to clean up resources such as
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
 *      <td><p> CalendarMode</td>
 *      <td><p> Advise how, where and when to create the requested amount of instances with specified accelerators, within the specified time and location limits. The method recommends creating future reservations for the requested resources.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> calendarMode(CalendarModeAdviceRpcRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> calendarMode(String project, String region, CalendarModeAdviceRequest calendarModeAdviceRequestResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> calendarModeCallable()
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
 * <p>This class can be customized by passing in a custom instance of AdviceSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AdviceSettings adviceSettings =
 *     AdviceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AdviceClient adviceClient = AdviceClient.create(adviceSettings);
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
 * AdviceSettings adviceSettings = AdviceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AdviceClient adviceClient = AdviceClient.create(adviceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AdviceClient implements BackgroundResource {
  private final AdviceSettings settings;
  private final AdviceStub stub;

  /** Constructs an instance of AdviceClient with default settings. */
  public static final AdviceClient create() throws IOException {
    return create(AdviceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AdviceClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AdviceClient create(AdviceSettings settings) throws IOException {
    return new AdviceClient(settings);
  }

  /**
   * Constructs an instance of AdviceClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(AdviceSettings).
   */
  public static final AdviceClient create(AdviceStub stub) {
    return new AdviceClient(stub);
  }

  /**
   * Constructs an instance of AdviceClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected AdviceClient(AdviceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AdviceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AdviceClient(AdviceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AdviceSettings getSettings() {
    return settings;
  }

  public AdviceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Advise how, where and when to create the requested amount of instances with specified
   * accelerators, within the specified time and location limits. The method recommends creating
   * future reservations for the requested resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdviceClient adviceClient = AdviceClient.create()) {
   *   String project = "project-309310695";
   *   String region = "region-934795532";
   *   CalendarModeAdviceRequest calendarModeAdviceRequestResource =
   *       CalendarModeAdviceRequest.newBuilder().build();
   *   CalendarModeAdviceResponse response =
   *       adviceClient.calendarMode(project, region, calendarModeAdviceRequestResource);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param region Name of the region for this request.
   * @param calendarModeAdviceRequestResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CalendarModeAdviceResponse calendarMode(
      String project, String region, CalendarModeAdviceRequest calendarModeAdviceRequestResource) {
    CalendarModeAdviceRpcRequest request =
        CalendarModeAdviceRpcRequest.newBuilder()
            .setProject(project)
            .setRegion(region)
            .setCalendarModeAdviceRequestResource(calendarModeAdviceRequestResource)
            .build();
    return calendarMode(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Advise how, where and when to create the requested amount of instances with specified
   * accelerators, within the specified time and location limits. The method recommends creating
   * future reservations for the requested resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdviceClient adviceClient = AdviceClient.create()) {
   *   CalendarModeAdviceRpcRequest request =
   *       CalendarModeAdviceRpcRequest.newBuilder()
   *           .setCalendarModeAdviceRequestResource(CalendarModeAdviceRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   CalendarModeAdviceResponse response = adviceClient.calendarMode(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CalendarModeAdviceResponse calendarMode(CalendarModeAdviceRpcRequest request) {
    return calendarModeCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Advise how, where and when to create the requested amount of instances with specified
   * accelerators, within the specified time and location limits. The method recommends creating
   * future reservations for the requested resources.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AdviceClient adviceClient = AdviceClient.create()) {
   *   CalendarModeAdviceRpcRequest request =
   *       CalendarModeAdviceRpcRequest.newBuilder()
   *           .setCalendarModeAdviceRequestResource(CalendarModeAdviceRequest.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRegion("region-934795532")
   *           .build();
   *   ApiFuture<CalendarModeAdviceResponse> future =
   *       adviceClient.calendarModeCallable().futureCall(request);
   *   // Do something.
   *   CalendarModeAdviceResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CalendarModeAdviceRpcRequest, CalendarModeAdviceResponse>
      calendarModeCallable() {
    return stub.calendarModeCallable();
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
