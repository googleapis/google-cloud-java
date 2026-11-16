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

package com.google.ads.admanager.v1;

import com.google.ads.admanager.v1.stub.TrafficForecastSegmentServiceStub;
import com.google.ads.admanager.v1.stub.TrafficForecastSegmentServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `TrafficForecastSegment` objects.
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
 * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
 *     TrafficForecastSegmentServiceClient.create()) {
 *   TrafficForecastSegmentName name =
 *       TrafficForecastSegmentName.of("[NETWORK_CODE]", "[TRAFFIC_FORECAST_SEGMENT]");
 *   TrafficForecastSegment response =
 *       trafficForecastSegmentServiceClient.getTrafficForecastSegment(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TrafficForecastSegmentServiceClient object to clean up
 * resources such as threads. In the example above, try-with-resources is used, which automatically
 * calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetTrafficForecastSegment</td>
 *      <td><p> Retrieves a `TrafficForecastSegment` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTrafficForecastSegment(GetTrafficForecastSegmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTrafficForecastSegment(TrafficForecastSegmentName name)
 *           <li><p> getTrafficForecastSegment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTrafficForecastSegmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTrafficForecastSegments</td>
 *      <td><p> Lists `TrafficForecastSegment` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTrafficForecastSegments(ListTrafficForecastSegmentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTrafficForecastSegments(NetworkName parent)
 *           <li><p> listTrafficForecastSegments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTrafficForecastSegmentsPagedCallable()
 *           <li><p> listTrafficForecastSegmentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTrafficForecastSegment</td>
 *      <td><p> Creates a `TrafficForecastSegment` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTrafficForecastSegment(CreateTrafficForecastSegmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createTrafficForecastSegment(NetworkName parent, TrafficForecastSegment trafficForecastSegment)
 *           <li><p> createTrafficForecastSegment(String parent, TrafficForecastSegment trafficForecastSegment)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTrafficForecastSegmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateTrafficForecastSegments</td>
 *      <td><p> Creates `TrafficForecastSegment` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateTrafficForecastSegments(NetworkName parent, List&lt;CreateTrafficForecastSegmentRequest&gt; requests)
 *           <li><p> batchCreateTrafficForecastSegments(String parent, List&lt;CreateTrafficForecastSegmentRequest&gt; requests)
 *           <li><p> batchCreateTrafficForecastSegments(BatchCreateTrafficForecastSegmentsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateTrafficForecastSegmentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTrafficForecastSegment</td>
 *      <td><p> Updates a `TrafficForecastSegment` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTrafficForecastSegment(UpdateTrafficForecastSegmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateTrafficForecastSegment(TrafficForecastSegment trafficForecastSegment, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateTrafficForecastSegmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateTrafficForecastSegments</td>
 *      <td><p> Batch updates `TrafficForecastSegment` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateTrafficForecastSegments(NetworkName parent, List&lt;UpdateTrafficForecastSegmentRequest&gt; requests)
 *           <li><p> batchUpdateTrafficForecastSegments(String parent, List&lt;UpdateTrafficForecastSegmentRequest&gt; requests)
 *           <li><p> batchUpdateTrafficForecastSegments(BatchUpdateTrafficForecastSegmentsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateTrafficForecastSegmentsCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * TrafficForecastSegmentServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * TrafficForecastSegmentServiceSettings trafficForecastSegmentServiceSettings =
 *     TrafficForecastSegmentServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
 *     TrafficForecastSegmentServiceClient.create(trafficForecastSegmentServiceSettings);
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
 * TrafficForecastSegmentServiceSettings trafficForecastSegmentServiceSettings =
 *     TrafficForecastSegmentServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
 *     TrafficForecastSegmentServiceClient.create(trafficForecastSegmentServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class TrafficForecastSegmentServiceClient implements BackgroundResource {
  private final @Nullable TrafficForecastSegmentServiceSettings settings;
  private final TrafficForecastSegmentServiceStub stub;

  /** Constructs an instance of TrafficForecastSegmentServiceClient with default settings. */
  public static final TrafficForecastSegmentServiceClient create() throws IOException {
    return create(TrafficForecastSegmentServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TrafficForecastSegmentServiceClient, using the given settings. The
   * channels are created based on the settings passed in, or defaults for any settings that are not
   * set.
   */
  public static final TrafficForecastSegmentServiceClient create(
      TrafficForecastSegmentServiceSettings settings) throws IOException {
    return new TrafficForecastSegmentServiceClient(settings);
  }

  /**
   * Constructs an instance of TrafficForecastSegmentServiceClient, using the given stub for making
   * calls. This is for advanced usage - prefer using create(TrafficForecastSegmentServiceSettings).
   */
  public static final TrafficForecastSegmentServiceClient create(
      TrafficForecastSegmentServiceStub stub) {
    return new TrafficForecastSegmentServiceClient(stub);
  }

  /**
   * Constructs an instance of TrafficForecastSegmentServiceClient, using the given settings. This
   * is protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected TrafficForecastSegmentServiceClient(TrafficForecastSegmentServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub =
        ((TrafficForecastSegmentServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected TrafficForecastSegmentServiceClient(TrafficForecastSegmentServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable TrafficForecastSegmentServiceSettings getSettings() {
    return settings;
  }

  public TrafficForecastSegmentServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `TrafficForecastSegment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   TrafficForecastSegmentName name =
   *       TrafficForecastSegmentName.of("[NETWORK_CODE]", "[TRAFFIC_FORECAST_SEGMENT]");
   *   TrafficForecastSegment response =
   *       trafficForecastSegmentServiceClient.getTrafficForecastSegment(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the TrafficForecastSegment. Format:
   *     `networks/{network_code}/trafficForecastSegments/{trafficForecastSegmentId}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TrafficForecastSegment getTrafficForecastSegment(
      @Nullable TrafficForecastSegmentName name) {
    GetTrafficForecastSegmentRequest request =
        GetTrafficForecastSegmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getTrafficForecastSegment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `TrafficForecastSegment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   String name =
   *       TrafficForecastSegmentName.of("[NETWORK_CODE]", "[TRAFFIC_FORECAST_SEGMENT]").toString();
   *   TrafficForecastSegment response =
   *       trafficForecastSegmentServiceClient.getTrafficForecastSegment(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the TrafficForecastSegment. Format:
   *     `networks/{network_code}/trafficForecastSegments/{trafficForecastSegmentId}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TrafficForecastSegment getTrafficForecastSegment(String name) {
    GetTrafficForecastSegmentRequest request =
        GetTrafficForecastSegmentRequest.newBuilder().setName(name).build();
    return getTrafficForecastSegment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `TrafficForecastSegment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   GetTrafficForecastSegmentRequest request =
   *       GetTrafficForecastSegmentRequest.newBuilder()
   *           .setName(
   *               TrafficForecastSegmentName.of("[NETWORK_CODE]", "[TRAFFIC_FORECAST_SEGMENT]")
   *                   .toString())
   *           .build();
   *   TrafficForecastSegment response =
   *       trafficForecastSegmentServiceClient.getTrafficForecastSegment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TrafficForecastSegment getTrafficForecastSegment(
      GetTrafficForecastSegmentRequest request) {
    return getTrafficForecastSegmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `TrafficForecastSegment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   GetTrafficForecastSegmentRequest request =
   *       GetTrafficForecastSegmentRequest.newBuilder()
   *           .setName(
   *               TrafficForecastSegmentName.of("[NETWORK_CODE]", "[TRAFFIC_FORECAST_SEGMENT]")
   *                   .toString())
   *           .build();
   *   ApiFuture<TrafficForecastSegment> future =
   *       trafficForecastSegmentServiceClient
   *           .getTrafficForecastSegmentCallable()
   *           .futureCall(request);
   *   // Do something.
   *   TrafficForecastSegment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTrafficForecastSegmentRequest, TrafficForecastSegment>
      getTrafficForecastSegmentCallable() {
    return stub.getTrafficForecastSegmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `TrafficForecastSegment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (TrafficForecastSegment element :
   *       trafficForecastSegmentServiceClient.listTrafficForecastSegments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of TrafficForecastSegments.
   *     Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTrafficForecastSegmentsPagedResponse listTrafficForecastSegments(
      @Nullable NetworkName parent) {
    ListTrafficForecastSegmentsRequest request =
        ListTrafficForecastSegmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listTrafficForecastSegments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `TrafficForecastSegment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (TrafficForecastSegment element :
   *       trafficForecastSegmentServiceClient.listTrafficForecastSegments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of TrafficForecastSegments.
   *     Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTrafficForecastSegmentsPagedResponse listTrafficForecastSegments(String parent) {
    ListTrafficForecastSegmentsRequest request =
        ListTrafficForecastSegmentsRequest.newBuilder().setParent(parent).build();
    return listTrafficForecastSegments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `TrafficForecastSegment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   ListTrafficForecastSegmentsRequest request =
   *       ListTrafficForecastSegmentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (TrafficForecastSegment element :
   *       trafficForecastSegmentServiceClient.listTrafficForecastSegments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTrafficForecastSegmentsPagedResponse listTrafficForecastSegments(
      ListTrafficForecastSegmentsRequest request) {
    return listTrafficForecastSegmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `TrafficForecastSegment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   ListTrafficForecastSegmentsRequest request =
   *       ListTrafficForecastSegmentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<TrafficForecastSegment> future =
   *       trafficForecastSegmentServiceClient
   *           .listTrafficForecastSegmentsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (TrafficForecastSegment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListTrafficForecastSegmentsRequest, ListTrafficForecastSegmentsPagedResponse>
      listTrafficForecastSegmentsPagedCallable() {
    return stub.listTrafficForecastSegmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `TrafficForecastSegment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   ListTrafficForecastSegmentsRequest request =
   *       ListTrafficForecastSegmentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListTrafficForecastSegmentsResponse response =
   *         trafficForecastSegmentServiceClient.listTrafficForecastSegmentsCallable().call(request);
   *     for (TrafficForecastSegment element : response.getTrafficForecastSegmentsList()) {
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
  public final UnaryCallable<
          ListTrafficForecastSegmentsRequest, ListTrafficForecastSegmentsResponse>
      listTrafficForecastSegmentsCallable() {
    return stub.listTrafficForecastSegmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `TrafficForecastSegment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   TrafficForecastSegment trafficForecastSegment = TrafficForecastSegment.newBuilder().build();
   *   TrafficForecastSegment response =
   *       trafficForecastSegmentServiceClient.createTrafficForecastSegment(
   *           parent, trafficForecastSegment);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `TrafficForecastSegment` will be
   *     created. Format: `networks/{network_code}`
   * @param trafficForecastSegment Required. The `TrafficForecastSegment` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TrafficForecastSegment createTrafficForecastSegment(
      @Nullable NetworkName parent, TrafficForecastSegment trafficForecastSegment) {
    CreateTrafficForecastSegmentRequest request =
        CreateTrafficForecastSegmentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTrafficForecastSegment(trafficForecastSegment)
            .build();
    return createTrafficForecastSegment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `TrafficForecastSegment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   TrafficForecastSegment trafficForecastSegment = TrafficForecastSegment.newBuilder().build();
   *   TrafficForecastSegment response =
   *       trafficForecastSegmentServiceClient.createTrafficForecastSegment(
   *           parent, trafficForecastSegment);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `TrafficForecastSegment` will be
   *     created. Format: `networks/{network_code}`
   * @param trafficForecastSegment Required. The `TrafficForecastSegment` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TrafficForecastSegment createTrafficForecastSegment(
      String parent, TrafficForecastSegment trafficForecastSegment) {
    CreateTrafficForecastSegmentRequest request =
        CreateTrafficForecastSegmentRequest.newBuilder()
            .setParent(parent)
            .setTrafficForecastSegment(trafficForecastSegment)
            .build();
    return createTrafficForecastSegment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `TrafficForecastSegment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   CreateTrafficForecastSegmentRequest request =
   *       CreateTrafficForecastSegmentRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setTrafficForecastSegment(TrafficForecastSegment.newBuilder().build())
   *           .build();
   *   TrafficForecastSegment response =
   *       trafficForecastSegmentServiceClient.createTrafficForecastSegment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TrafficForecastSegment createTrafficForecastSegment(
      CreateTrafficForecastSegmentRequest request) {
    return createTrafficForecastSegmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `TrafficForecastSegment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   CreateTrafficForecastSegmentRequest request =
   *       CreateTrafficForecastSegmentRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setTrafficForecastSegment(TrafficForecastSegment.newBuilder().build())
   *           .build();
   *   ApiFuture<TrafficForecastSegment> future =
   *       trafficForecastSegmentServiceClient
   *           .createTrafficForecastSegmentCallable()
   *           .futureCall(request);
   *   // Do something.
   *   TrafficForecastSegment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTrafficForecastSegmentRequest, TrafficForecastSegment>
      createTrafficForecastSegmentCallable() {
    return stub.createTrafficForecastSegmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `TrafficForecastSegment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateTrafficForecastSegmentRequest> requests = new ArrayList<>();
   *   BatchCreateTrafficForecastSegmentsResponse response =
   *       trafficForecastSegmentServiceClient.batchCreateTrafficForecastSegments(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `TrafficForecastSegments` will be created.
   *     Format: `networks/{network_code}` The parent field in the
   *     CreateTrafficForecastSegmentRequest must match this field.
   * @param requests Required. The `TrafficForecastSegment` objects to create. A maximum of 100
   *     objects can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateTrafficForecastSegmentsResponse batchCreateTrafficForecastSegments(
      @Nullable NetworkName parent, List<CreateTrafficForecastSegmentRequest> requests) {
    BatchCreateTrafficForecastSegmentsRequest request =
        BatchCreateTrafficForecastSegmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateTrafficForecastSegments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `TrafficForecastSegment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateTrafficForecastSegmentRequest> requests = new ArrayList<>();
   *   BatchCreateTrafficForecastSegmentsResponse response =
   *       trafficForecastSegmentServiceClient.batchCreateTrafficForecastSegments(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `TrafficForecastSegments` will be created.
   *     Format: `networks/{network_code}` The parent field in the
   *     CreateTrafficForecastSegmentRequest must match this field.
   * @param requests Required. The `TrafficForecastSegment` objects to create. A maximum of 100
   *     objects can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateTrafficForecastSegmentsResponse batchCreateTrafficForecastSegments(
      String parent, List<CreateTrafficForecastSegmentRequest> requests) {
    BatchCreateTrafficForecastSegmentsRequest request =
        BatchCreateTrafficForecastSegmentsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchCreateTrafficForecastSegments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `TrafficForecastSegment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   BatchCreateTrafficForecastSegmentsRequest request =
   *       BatchCreateTrafficForecastSegmentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateTrafficForecastSegmentRequest>())
   *           .build();
   *   BatchCreateTrafficForecastSegmentsResponse response =
   *       trafficForecastSegmentServiceClient.batchCreateTrafficForecastSegments(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateTrafficForecastSegmentsResponse batchCreateTrafficForecastSegments(
      BatchCreateTrafficForecastSegmentsRequest request) {
    return batchCreateTrafficForecastSegmentsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates `TrafficForecastSegment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   BatchCreateTrafficForecastSegmentsRequest request =
   *       BatchCreateTrafficForecastSegmentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateTrafficForecastSegmentRequest>())
   *           .build();
   *   ApiFuture<BatchCreateTrafficForecastSegmentsResponse> future =
   *       trafficForecastSegmentServiceClient
   *           .batchCreateTrafficForecastSegmentsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchCreateTrafficForecastSegmentsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchCreateTrafficForecastSegmentsRequest, BatchCreateTrafficForecastSegmentsResponse>
      batchCreateTrafficForecastSegmentsCallable() {
    return stub.batchCreateTrafficForecastSegmentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `TrafficForecastSegment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   TrafficForecastSegment trafficForecastSegment = TrafficForecastSegment.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TrafficForecastSegment response =
   *       trafficForecastSegmentServiceClient.updateTrafficForecastSegment(
   *           trafficForecastSegment, updateMask);
   * }
   * }</pre>
   *
   * @param trafficForecastSegment Required. The `TrafficForecastSegment` to update.
   *     <p>The `TrafficForecastSegment`'s `name` is used to identify the `TrafficForecastSegment`
   *     to update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TrafficForecastSegment updateTrafficForecastSegment(
      TrafficForecastSegment trafficForecastSegment, FieldMask updateMask) {
    UpdateTrafficForecastSegmentRequest request =
        UpdateTrafficForecastSegmentRequest.newBuilder()
            .setTrafficForecastSegment(trafficForecastSegment)
            .setUpdateMask(updateMask)
            .build();
    return updateTrafficForecastSegment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `TrafficForecastSegment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   UpdateTrafficForecastSegmentRequest request =
   *       UpdateTrafficForecastSegmentRequest.newBuilder()
   *           .setTrafficForecastSegment(TrafficForecastSegment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   TrafficForecastSegment response =
   *       trafficForecastSegmentServiceClient.updateTrafficForecastSegment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TrafficForecastSegment updateTrafficForecastSegment(
      UpdateTrafficForecastSegmentRequest request) {
    return updateTrafficForecastSegmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `TrafficForecastSegment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   UpdateTrafficForecastSegmentRequest request =
   *       UpdateTrafficForecastSegmentRequest.newBuilder()
   *           .setTrafficForecastSegment(TrafficForecastSegment.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<TrafficForecastSegment> future =
   *       trafficForecastSegmentServiceClient
   *           .updateTrafficForecastSegmentCallable()
   *           .futureCall(request);
   *   // Do something.
   *   TrafficForecastSegment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTrafficForecastSegmentRequest, TrafficForecastSegment>
      updateTrafficForecastSegmentCallable() {
    return stub.updateTrafficForecastSegmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `TrafficForecastSegment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateTrafficForecastSegmentRequest> requests = new ArrayList<>();
   *   BatchUpdateTrafficForecastSegmentsResponse response =
   *       trafficForecastSegmentServiceClient.batchUpdateTrafficForecastSegments(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `TrafficForecastSegments` will be updated.
   *     Format: `networks/{network_code}` The parent field in the
   *     UpdateTrafficForecastSegmentRequest must match this field.
   * @param requests Required. The `TrafficForecastSegment` objects to update. A maximum of 100
   *     objects can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateTrafficForecastSegmentsResponse batchUpdateTrafficForecastSegments(
      @Nullable NetworkName parent, List<UpdateTrafficForecastSegmentRequest> requests) {
    BatchUpdateTrafficForecastSegmentsRequest request =
        BatchUpdateTrafficForecastSegmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateTrafficForecastSegments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `TrafficForecastSegment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateTrafficForecastSegmentRequest> requests = new ArrayList<>();
   *   BatchUpdateTrafficForecastSegmentsResponse response =
   *       trafficForecastSegmentServiceClient.batchUpdateTrafficForecastSegments(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `TrafficForecastSegments` will be updated.
   *     Format: `networks/{network_code}` The parent field in the
   *     UpdateTrafficForecastSegmentRequest must match this field.
   * @param requests Required. The `TrafficForecastSegment` objects to update. A maximum of 100
   *     objects can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateTrafficForecastSegmentsResponse batchUpdateTrafficForecastSegments(
      String parent, List<UpdateTrafficForecastSegmentRequest> requests) {
    BatchUpdateTrafficForecastSegmentsRequest request =
        BatchUpdateTrafficForecastSegmentsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchUpdateTrafficForecastSegments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `TrafficForecastSegment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   BatchUpdateTrafficForecastSegmentsRequest request =
   *       BatchUpdateTrafficForecastSegmentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateTrafficForecastSegmentRequest>())
   *           .build();
   *   BatchUpdateTrafficForecastSegmentsResponse response =
   *       trafficForecastSegmentServiceClient.batchUpdateTrafficForecastSegments(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateTrafficForecastSegmentsResponse batchUpdateTrafficForecastSegments(
      BatchUpdateTrafficForecastSegmentsRequest request) {
    return batchUpdateTrafficForecastSegmentsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `TrafficForecastSegment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TrafficForecastSegmentServiceClient trafficForecastSegmentServiceClient =
   *     TrafficForecastSegmentServiceClient.create()) {
   *   BatchUpdateTrafficForecastSegmentsRequest request =
   *       BatchUpdateTrafficForecastSegmentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateTrafficForecastSegmentRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateTrafficForecastSegmentsResponse> future =
   *       trafficForecastSegmentServiceClient
   *           .batchUpdateTrafficForecastSegmentsCallable()
   *           .futureCall(request);
   *   // Do something.
   *   BatchUpdateTrafficForecastSegmentsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchUpdateTrafficForecastSegmentsRequest, BatchUpdateTrafficForecastSegmentsResponse>
      batchUpdateTrafficForecastSegmentsCallable() {
    return stub.batchUpdateTrafficForecastSegmentsCallable();
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

  public static class ListTrafficForecastSegmentsPagedResponse
      extends AbstractPagedListResponse<
          ListTrafficForecastSegmentsRequest,
          ListTrafficForecastSegmentsResponse,
          TrafficForecastSegment,
          ListTrafficForecastSegmentsPage,
          ListTrafficForecastSegmentsFixedSizeCollection> {

    public static ApiFuture<ListTrafficForecastSegmentsPagedResponse> createAsync(
        PageContext<
                ListTrafficForecastSegmentsRequest,
                ListTrafficForecastSegmentsResponse,
                TrafficForecastSegment>
            context,
        ApiFuture<ListTrafficForecastSegmentsResponse> futureResponse) {
      ApiFuture<ListTrafficForecastSegmentsPage> futurePage =
          ListTrafficForecastSegmentsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListTrafficForecastSegmentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListTrafficForecastSegmentsPagedResponse(ListTrafficForecastSegmentsPage page) {
      super(page, ListTrafficForecastSegmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTrafficForecastSegmentsPage
      extends AbstractPage<
          ListTrafficForecastSegmentsRequest,
          ListTrafficForecastSegmentsResponse,
          TrafficForecastSegment,
          ListTrafficForecastSegmentsPage> {

    private ListTrafficForecastSegmentsPage(
        @Nullable
            PageContext<
                ListTrafficForecastSegmentsRequest,
                ListTrafficForecastSegmentsResponse,
                TrafficForecastSegment>
            context,
        @Nullable ListTrafficForecastSegmentsResponse response) {
      super(context, response);
    }

    private static ListTrafficForecastSegmentsPage createEmptyPage() {
      return new ListTrafficForecastSegmentsPage(null, null);
    }

    @Override
    protected ListTrafficForecastSegmentsPage createPage(
        @Nullable
            PageContext<
                ListTrafficForecastSegmentsRequest,
                ListTrafficForecastSegmentsResponse,
                TrafficForecastSegment>
            context,
        @Nullable ListTrafficForecastSegmentsResponse response) {
      return new ListTrafficForecastSegmentsPage(context, response);
    }

    @Override
    public ApiFuture<ListTrafficForecastSegmentsPage> createPageAsync(
        @Nullable
            PageContext<
                ListTrafficForecastSegmentsRequest,
                ListTrafficForecastSegmentsResponse,
                TrafficForecastSegment>
            context,
        ApiFuture<ListTrafficForecastSegmentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTrafficForecastSegmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTrafficForecastSegmentsRequest,
          ListTrafficForecastSegmentsResponse,
          TrafficForecastSegment,
          ListTrafficForecastSegmentsPage,
          ListTrafficForecastSegmentsFixedSizeCollection> {

    private ListTrafficForecastSegmentsFixedSizeCollection(
        @Nullable List<ListTrafficForecastSegmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTrafficForecastSegmentsFixedSizeCollection createEmptyCollection() {
      return new ListTrafficForecastSegmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTrafficForecastSegmentsFixedSizeCollection createCollection(
        @Nullable List<ListTrafficForecastSegmentsPage> pages, int collectionSize) {
      return new ListTrafficForecastSegmentsFixedSizeCollection(pages, collectionSize);
    }
  }
}
