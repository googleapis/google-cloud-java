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

package com.google.ads.admanager.v1;

import com.google.ads.admanager.v1.stub.AudienceSegmentServiceStub;
import com.google.ads.admanager.v1.stub.AudienceSegmentServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling `AudienceSegment` objects.
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
 * try (AudienceSegmentServiceClient audienceSegmentServiceClient =
 *     AudienceSegmentServiceClient.create()) {
 *   AudienceSegmentName name = AudienceSegmentName.of("[NETWORK_CODE]", "[AUDIENCE_SEGMENT]");
 *   AudienceSegment response = audienceSegmentServiceClient.getAudienceSegment(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the AudienceSegmentServiceClient object to clean up
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
 *      <td><p> GetAudienceSegment</td>
 *      <td><p> API to retrieve an `AudienceSegment` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getAudienceSegment(GetAudienceSegmentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getAudienceSegment(AudienceSegmentName name)
 *           <li><p> getAudienceSegment(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getAudienceSegmentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListAudienceSegments</td>
 *      <td><p> API to retrieve a list of `AudienceSegment` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listAudienceSegments(ListAudienceSegmentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listAudienceSegments(NetworkName parent)
 *           <li><p> listAudienceSegments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listAudienceSegmentsPagedCallable()
 *           <li><p> listAudienceSegmentsCallable()
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
 * <p>This class can be customized by passing in a custom instance of AudienceSegmentServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * AudienceSegmentServiceSettings audienceSegmentServiceSettings =
 *     AudienceSegmentServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AudienceSegmentServiceClient audienceSegmentServiceClient =
 *     AudienceSegmentServiceClient.create(audienceSegmentServiceSettings);
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
 * AudienceSegmentServiceSettings audienceSegmentServiceSettings =
 *     AudienceSegmentServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AudienceSegmentServiceClient audienceSegmentServiceClient =
 *     AudienceSegmentServiceClient.create(audienceSegmentServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class AudienceSegmentServiceClient implements BackgroundResource {
  private final AudienceSegmentServiceSettings settings;
  private final AudienceSegmentServiceStub stub;

  /** Constructs an instance of AudienceSegmentServiceClient with default settings. */
  public static final AudienceSegmentServiceClient create() throws IOException {
    return create(AudienceSegmentServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AudienceSegmentServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AudienceSegmentServiceClient create(AudienceSegmentServiceSettings settings)
      throws IOException {
    return new AudienceSegmentServiceClient(settings);
  }

  /**
   * Constructs an instance of AudienceSegmentServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(AudienceSegmentServiceSettings).
   */
  public static final AudienceSegmentServiceClient create(AudienceSegmentServiceStub stub) {
    return new AudienceSegmentServiceClient(stub);
  }

  /**
   * Constructs an instance of AudienceSegmentServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected AudienceSegmentServiceClient(AudienceSegmentServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((AudienceSegmentServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected AudienceSegmentServiceClient(AudienceSegmentServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AudienceSegmentServiceSettings getSettings() {
    return settings;
  }

  public AudienceSegmentServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve an `AudienceSegment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AudienceSegmentServiceClient audienceSegmentServiceClient =
   *     AudienceSegmentServiceClient.create()) {
   *   AudienceSegmentName name = AudienceSegmentName.of("[NETWORK_CODE]", "[AUDIENCE_SEGMENT]");
   *   AudienceSegment response = audienceSegmentServiceClient.getAudienceSegment(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the AudienceSegment. Format:
   *     `networks/{network_code}/audienceSegments/{audience_segment_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AudienceSegment getAudienceSegment(AudienceSegmentName name) {
    GetAudienceSegmentRequest request =
        GetAudienceSegmentRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getAudienceSegment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve an `AudienceSegment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AudienceSegmentServiceClient audienceSegmentServiceClient =
   *     AudienceSegmentServiceClient.create()) {
   *   String name = AudienceSegmentName.of("[NETWORK_CODE]", "[AUDIENCE_SEGMENT]").toString();
   *   AudienceSegment response = audienceSegmentServiceClient.getAudienceSegment(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the AudienceSegment. Format:
   *     `networks/{network_code}/audienceSegments/{audience_segment_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AudienceSegment getAudienceSegment(String name) {
    GetAudienceSegmentRequest request =
        GetAudienceSegmentRequest.newBuilder().setName(name).build();
    return getAudienceSegment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve an `AudienceSegment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AudienceSegmentServiceClient audienceSegmentServiceClient =
   *     AudienceSegmentServiceClient.create()) {
   *   GetAudienceSegmentRequest request =
   *       GetAudienceSegmentRequest.newBuilder()
   *           .setName(AudienceSegmentName.of("[NETWORK_CODE]", "[AUDIENCE_SEGMENT]").toString())
   *           .build();
   *   AudienceSegment response = audienceSegmentServiceClient.getAudienceSegment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AudienceSegment getAudienceSegment(GetAudienceSegmentRequest request) {
    return getAudienceSegmentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve an `AudienceSegment` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AudienceSegmentServiceClient audienceSegmentServiceClient =
   *     AudienceSegmentServiceClient.create()) {
   *   GetAudienceSegmentRequest request =
   *       GetAudienceSegmentRequest.newBuilder()
   *           .setName(AudienceSegmentName.of("[NETWORK_CODE]", "[AUDIENCE_SEGMENT]").toString())
   *           .build();
   *   ApiFuture<AudienceSegment> future =
   *       audienceSegmentServiceClient.getAudienceSegmentCallable().futureCall(request);
   *   // Do something.
   *   AudienceSegment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetAudienceSegmentRequest, AudienceSegment>
      getAudienceSegmentCallable() {
    return stub.getAudienceSegmentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `AudienceSegment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AudienceSegmentServiceClient audienceSegmentServiceClient =
   *     AudienceSegmentServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (AudienceSegment element :
   *       audienceSegmentServiceClient.listAudienceSegments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent publisher network associated with these audience segments.
   *     Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAudienceSegmentsPagedResponse listAudienceSegments(NetworkName parent) {
    ListAudienceSegmentsRequest request =
        ListAudienceSegmentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listAudienceSegments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `AudienceSegment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AudienceSegmentServiceClient audienceSegmentServiceClient =
   *     AudienceSegmentServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (AudienceSegment element :
   *       audienceSegmentServiceClient.listAudienceSegments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent publisher network associated with these audience segments.
   *     Format: `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAudienceSegmentsPagedResponse listAudienceSegments(String parent) {
    ListAudienceSegmentsRequest request =
        ListAudienceSegmentsRequest.newBuilder().setParent(parent).build();
    return listAudienceSegments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `AudienceSegment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AudienceSegmentServiceClient audienceSegmentServiceClient =
   *     AudienceSegmentServiceClient.create()) {
   *   ListAudienceSegmentsRequest request =
   *       ListAudienceSegmentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (AudienceSegment element :
   *       audienceSegmentServiceClient.listAudienceSegments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListAudienceSegmentsPagedResponse listAudienceSegments(
      ListAudienceSegmentsRequest request) {
    return listAudienceSegmentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `AudienceSegment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AudienceSegmentServiceClient audienceSegmentServiceClient =
   *     AudienceSegmentServiceClient.create()) {
   *   ListAudienceSegmentsRequest request =
   *       ListAudienceSegmentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<AudienceSegment> future =
   *       audienceSegmentServiceClient.listAudienceSegmentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (AudienceSegment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListAudienceSegmentsRequest, ListAudienceSegmentsPagedResponse>
      listAudienceSegmentsPagedCallable() {
    return stub.listAudienceSegmentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `AudienceSegment` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (AudienceSegmentServiceClient audienceSegmentServiceClient =
   *     AudienceSegmentServiceClient.create()) {
   *   ListAudienceSegmentsRequest request =
   *       ListAudienceSegmentsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListAudienceSegmentsResponse response =
   *         audienceSegmentServiceClient.listAudienceSegmentsCallable().call(request);
   *     for (AudienceSegment element : response.getAudienceSegmentsList()) {
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
  public final UnaryCallable<ListAudienceSegmentsRequest, ListAudienceSegmentsResponse>
      listAudienceSegmentsCallable() {
    return stub.listAudienceSegmentsCallable();
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

  public static class ListAudienceSegmentsPagedResponse
      extends AbstractPagedListResponse<
          ListAudienceSegmentsRequest,
          ListAudienceSegmentsResponse,
          AudienceSegment,
          ListAudienceSegmentsPage,
          ListAudienceSegmentsFixedSizeCollection> {

    public static ApiFuture<ListAudienceSegmentsPagedResponse> createAsync(
        PageContext<ListAudienceSegmentsRequest, ListAudienceSegmentsResponse, AudienceSegment>
            context,
        ApiFuture<ListAudienceSegmentsResponse> futureResponse) {
      ApiFuture<ListAudienceSegmentsPage> futurePage =
          ListAudienceSegmentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListAudienceSegmentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListAudienceSegmentsPagedResponse(ListAudienceSegmentsPage page) {
      super(page, ListAudienceSegmentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListAudienceSegmentsPage
      extends AbstractPage<
          ListAudienceSegmentsRequest,
          ListAudienceSegmentsResponse,
          AudienceSegment,
          ListAudienceSegmentsPage> {

    private ListAudienceSegmentsPage(
        PageContext<ListAudienceSegmentsRequest, ListAudienceSegmentsResponse, AudienceSegment>
            context,
        ListAudienceSegmentsResponse response) {
      super(context, response);
    }

    private static ListAudienceSegmentsPage createEmptyPage() {
      return new ListAudienceSegmentsPage(null, null);
    }

    @Override
    protected ListAudienceSegmentsPage createPage(
        PageContext<ListAudienceSegmentsRequest, ListAudienceSegmentsResponse, AudienceSegment>
            context,
        ListAudienceSegmentsResponse response) {
      return new ListAudienceSegmentsPage(context, response);
    }

    @Override
    public ApiFuture<ListAudienceSegmentsPage> createPageAsync(
        PageContext<ListAudienceSegmentsRequest, ListAudienceSegmentsResponse, AudienceSegment>
            context,
        ApiFuture<ListAudienceSegmentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListAudienceSegmentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListAudienceSegmentsRequest,
          ListAudienceSegmentsResponse,
          AudienceSegment,
          ListAudienceSegmentsPage,
          ListAudienceSegmentsFixedSizeCollection> {

    private ListAudienceSegmentsFixedSizeCollection(
        List<ListAudienceSegmentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListAudienceSegmentsFixedSizeCollection createEmptyCollection() {
      return new ListAudienceSegmentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListAudienceSegmentsFixedSizeCollection createCollection(
        List<ListAudienceSegmentsPage> pages, int collectionSize) {
      return new ListAudienceSegmentsFixedSizeCollection(pages, collectionSize);
    }
  }
}
