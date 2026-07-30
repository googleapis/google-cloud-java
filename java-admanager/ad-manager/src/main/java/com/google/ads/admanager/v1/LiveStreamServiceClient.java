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

import com.google.ads.admanager.v1.stub.LiveStreamServiceStub;
import com.google.ads.admanager.v1.stub.LiveStreamServiceStubSettings;
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
 * Service Description: Provides methods for handling `LiveStream` objects.
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
 * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
 *   LiveStreamName name = LiveStreamName.of("[NETWORK_CODE]", "[LIVE_STREAM]");
 *   LiveStream response = liveStreamServiceClient.getLiveStream(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LiveStreamServiceClient object to clean up resources
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
 *      <td><p> GetLiveStream</td>
 *      <td><p> Retrieves a `LiveStream` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLiveStream(GetLiveStreamRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLiveStream(LiveStreamName name)
 *           <li><p> getLiveStream(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLiveStreamCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLiveStreams</td>
 *      <td><p> Lists `LiveStream` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLiveStreams(ListLiveStreamsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLiveStreams(NetworkName parent)
 *           <li><p> listLiveStreams(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLiveStreamsPagedCallable()
 *           <li><p> listLiveStreamsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateLiveStream</td>
 *      <td><p> Creates a `LiveStream` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createLiveStream(CreateLiveStreamRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createLiveStream(NetworkName parent, LiveStream liveStream)
 *           <li><p> createLiveStream(String parent, LiveStream liveStream)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createLiveStreamCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateLiveStreams</td>
 *      <td><p> Batch creates `LiveStream` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateLiveStreams(NetworkName parent, List&lt;CreateLiveStreamRequest&gt; requests)
 *           <li><p> batchCreateLiveStreams(String parent, List&lt;CreateLiveStreamRequest&gt; requests)
 *           <li><p> batchCreateLiveStreams(BatchCreateLiveStreamsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateLiveStreamsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateLiveStream</td>
 *      <td><p> Updates a `LiveStream` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateLiveStream(UpdateLiveStreamRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateLiveStream(LiveStream liveStream, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateLiveStreamCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateLiveStreams</td>
 *      <td><p> Batch updates `LiveStream` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateLiveStreams(NetworkName parent, List&lt;UpdateLiveStreamRequest&gt; requests)
 *           <li><p> batchUpdateLiveStreams(String parent, List&lt;UpdateLiveStreamRequest&gt; requests)
 *           <li><p> batchUpdateLiveStreams(BatchUpdateLiveStreamsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateLiveStreamsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchActivateLiveStreams</td>
 *      <td><p> Batch activates `LiveStream` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchActivateLiveStreams(BatchActivateLiveStreamsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchActivateLiveStreams(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchActivateLiveStreams(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchActivateLiveStreamsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchPauseLiveStreams</td>
 *      <td><p> Batch pauses `LiveStream` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchPauseLiveStreams(BatchPauseLiveStreamsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchPauseLiveStreams(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchPauseLiveStreams(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchPauseLiveStreamsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchArchiveLiveStreams</td>
 *      <td><p> Batch archives `LiveStream` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchArchiveLiveStreams(BatchArchiveLiveStreamsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchArchiveLiveStreams(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchArchiveLiveStreams(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchArchiveLiveStreamsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchPauseAdsLiveStreams</td>
 *      <td><p> Batch pauses ads on `LiveStream` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchPauseAdsLiveStreams(BatchPauseAdsLiveStreamsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchPauseAdsLiveStreams(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchPauseAdsLiveStreams(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchPauseAdsLiveStreamsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchRefreshMasterPlaylists</td>
 *      <td><p> Batch refreshes master playlists on `LiveStream` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchRefreshMasterPlaylists(BatchRefreshMasterPlaylistsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchRefreshMasterPlaylists(NetworkName parent, List&lt;String&gt; names)
 *           <li><p> batchRefreshMasterPlaylists(String parent, List&lt;String&gt; names)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchRefreshMasterPlaylistsCallable()
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
 * <p>This class can be customized by passing in a custom instance of LiveStreamServiceSettings to
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
 * LiveStreamServiceSettings liveStreamServiceSettings =
 *     LiveStreamServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LiveStreamServiceClient liveStreamServiceClient =
 *     LiveStreamServiceClient.create(liveStreamServiceSettings);
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
 * LiveStreamServiceSettings liveStreamServiceSettings =
 *     LiveStreamServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LiveStreamServiceClient liveStreamServiceClient =
 *     LiveStreamServiceClient.create(liveStreamServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class LiveStreamServiceClient implements BackgroundResource {
  private final @Nullable LiveStreamServiceSettings settings;
  private final LiveStreamServiceStub stub;

  /** Constructs an instance of LiveStreamServiceClient with default settings. */
  public static final LiveStreamServiceClient create() throws IOException {
    return create(LiveStreamServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LiveStreamServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LiveStreamServiceClient create(LiveStreamServiceSettings settings)
      throws IOException {
    return new LiveStreamServiceClient(settings);
  }

  /**
   * Constructs an instance of LiveStreamServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(LiveStreamServiceSettings).
   */
  public static final LiveStreamServiceClient create(LiveStreamServiceStub stub) {
    return new LiveStreamServiceClient(stub);
  }

  /**
   * Constructs an instance of LiveStreamServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected LiveStreamServiceClient(LiveStreamServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LiveStreamServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected LiveStreamServiceClient(LiveStreamServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable LiveStreamServiceSettings getSettings() {
    return settings;
  }

  public LiveStreamServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `LiveStream` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   LiveStreamName name = LiveStreamName.of("[NETWORK_CODE]", "[LIVE_STREAM]");
   *   LiveStream response = liveStreamServiceClient.getLiveStream(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the LiveStream. Format:
   *     `networks/{network_code}/liveStreams/{live_stream_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveStream getLiveStream(@Nullable LiveStreamName name) {
    GetLiveStreamRequest request =
        GetLiveStreamRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getLiveStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `LiveStream` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   String name = LiveStreamName.of("[NETWORK_CODE]", "[LIVE_STREAM]").toString();
   *   LiveStream response = liveStreamServiceClient.getLiveStream(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the LiveStream. Format:
   *     `networks/{network_code}/liveStreams/{live_stream_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveStream getLiveStream(String name) {
    GetLiveStreamRequest request = GetLiveStreamRequest.newBuilder().setName(name).build();
    return getLiveStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `LiveStream` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   GetLiveStreamRequest request =
   *       GetLiveStreamRequest.newBuilder()
   *           .setName(LiveStreamName.of("[NETWORK_CODE]", "[LIVE_STREAM]").toString())
   *           .build();
   *   LiveStream response = liveStreamServiceClient.getLiveStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveStream getLiveStream(GetLiveStreamRequest request) {
    return getLiveStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a `LiveStream` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   GetLiveStreamRequest request =
   *       GetLiveStreamRequest.newBuilder()
   *           .setName(LiveStreamName.of("[NETWORK_CODE]", "[LIVE_STREAM]").toString())
   *           .build();
   *   ApiFuture<LiveStream> future =
   *       liveStreamServiceClient.getLiveStreamCallable().futureCall(request);
   *   // Do something.
   *   LiveStream response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLiveStreamRequest, LiveStream> getLiveStreamCallable() {
    return stub.getLiveStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (LiveStream element : liveStreamServiceClient.listLiveStreams(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of LiveStreams. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLiveStreamsPagedResponse listLiveStreams(@Nullable NetworkName parent) {
    ListLiveStreamsRequest request =
        ListLiveStreamsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listLiveStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (LiveStream element : liveStreamServiceClient.listLiveStreams(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of LiveStreams. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLiveStreamsPagedResponse listLiveStreams(String parent) {
    ListLiveStreamsRequest request = ListLiveStreamsRequest.newBuilder().setParent(parent).build();
    return listLiveStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   ListLiveStreamsRequest request =
   *       ListLiveStreamsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (LiveStream element : liveStreamServiceClient.listLiveStreams(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLiveStreamsPagedResponse listLiveStreams(ListLiveStreamsRequest request) {
    return listLiveStreamsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   ListLiveStreamsRequest request =
   *       ListLiveStreamsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<LiveStream> future =
   *       liveStreamServiceClient.listLiveStreamsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LiveStream element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLiveStreamsRequest, ListLiveStreamsPagedResponse>
      listLiveStreamsPagedCallable() {
    return stub.listLiveStreamsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   ListLiveStreamsRequest request =
   *       ListLiveStreamsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListLiveStreamsResponse response =
   *         liveStreamServiceClient.listLiveStreamsCallable().call(request);
   *     for (LiveStream element : response.getLiveStreamsList()) {
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
  public final UnaryCallable<ListLiveStreamsRequest, ListLiveStreamsResponse>
      listLiveStreamsCallable() {
    return stub.listLiveStreamsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `LiveStream` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   LiveStream liveStream = LiveStream.newBuilder().build();
   *   LiveStream response = liveStreamServiceClient.createLiveStream(parent, liveStream);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `LiveStream` will be created. Format:
   *     `networks/{network_code}`
   * @param liveStream Required. The `LiveStream` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveStream createLiveStream(@Nullable NetworkName parent, LiveStream liveStream) {
    CreateLiveStreamRequest request =
        CreateLiveStreamRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setLiveStream(liveStream)
            .build();
    return createLiveStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `LiveStream` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   LiveStream liveStream = LiveStream.newBuilder().build();
   *   LiveStream response = liveStreamServiceClient.createLiveStream(parent, liveStream);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this `LiveStream` will be created. Format:
   *     `networks/{network_code}`
   * @param liveStream Required. The `LiveStream` to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveStream createLiveStream(String parent, LiveStream liveStream) {
    CreateLiveStreamRequest request =
        CreateLiveStreamRequest.newBuilder().setParent(parent).setLiveStream(liveStream).build();
    return createLiveStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `LiveStream` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   CreateLiveStreamRequest request =
   *       CreateLiveStreamRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setLiveStream(LiveStream.newBuilder().build())
   *           .build();
   *   LiveStream response = liveStreamServiceClient.createLiveStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveStream createLiveStream(CreateLiveStreamRequest request) {
    return createLiveStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a `LiveStream` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   CreateLiveStreamRequest request =
   *       CreateLiveStreamRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setLiveStream(LiveStream.newBuilder().build())
   *           .build();
   *   ApiFuture<LiveStream> future =
   *       liveStreamServiceClient.createLiveStreamCallable().futureCall(request);
   *   // Do something.
   *   LiveStream response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateLiveStreamRequest, LiveStream> createLiveStreamCallable() {
    return stub.createLiveStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateLiveStreamRequest> requests = new ArrayList<>();
   *   BatchCreateLiveStreamsResponse response =
   *       liveStreamServiceClient.batchCreateLiveStreams(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LiveStreams` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateLiveStreamRequest must match this
   *     field.
   * @param requests Required. The `LiveStream` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateLiveStreamsResponse batchCreateLiveStreams(
      @Nullable NetworkName parent, List<CreateLiveStreamRequest> requests) {
    BatchCreateLiveStreamsRequest request =
        BatchCreateLiveStreamsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateLiveStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateLiveStreamRequest> requests = new ArrayList<>();
   *   BatchCreateLiveStreamsResponse response =
   *       liveStreamServiceClient.batchCreateLiveStreams(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LiveStreams` will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateLiveStreamRequest must match this
   *     field.
   * @param requests Required. The `LiveStream` objects to create. A maximum of 100 objects can be
   *     created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateLiveStreamsResponse batchCreateLiveStreams(
      String parent, List<CreateLiveStreamRequest> requests) {
    BatchCreateLiveStreamsRequest request =
        BatchCreateLiveStreamsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchCreateLiveStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   BatchCreateLiveStreamsRequest request =
   *       BatchCreateLiveStreamsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateLiveStreamRequest>())
   *           .build();
   *   BatchCreateLiveStreamsResponse response =
   *       liveStreamServiceClient.batchCreateLiveStreams(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateLiveStreamsResponse batchCreateLiveStreams(
      BatchCreateLiveStreamsRequest request) {
    return batchCreateLiveStreamsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch creates `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   BatchCreateLiveStreamsRequest request =
   *       BatchCreateLiveStreamsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateLiveStreamRequest>())
   *           .build();
   *   ApiFuture<BatchCreateLiveStreamsResponse> future =
   *       liveStreamServiceClient.batchCreateLiveStreamsCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateLiveStreamsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateLiveStreamsRequest, BatchCreateLiveStreamsResponse>
      batchCreateLiveStreamsCallable() {
    return stub.batchCreateLiveStreamsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `LiveStream` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   LiveStream liveStream = LiveStream.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   LiveStream response = liveStreamServiceClient.updateLiveStream(liveStream, updateMask);
   * }
   * }</pre>
   *
   * @param liveStream Required. The `LiveStream` to update.
   *     <p>The `LiveStream`'s `name` is used to identify the `LiveStream` to update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveStream updateLiveStream(LiveStream liveStream, FieldMask updateMask) {
    UpdateLiveStreamRequest request =
        UpdateLiveStreamRequest.newBuilder()
            .setLiveStream(liveStream)
            .setUpdateMask(updateMask)
            .build();
    return updateLiveStream(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `LiveStream` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   UpdateLiveStreamRequest request =
   *       UpdateLiveStreamRequest.newBuilder()
   *           .setLiveStream(LiveStream.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   LiveStream response = liveStreamServiceClient.updateLiveStream(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final LiveStream updateLiveStream(UpdateLiveStreamRequest request) {
    return updateLiveStreamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a `LiveStream` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   UpdateLiveStreamRequest request =
   *       UpdateLiveStreamRequest.newBuilder()
   *           .setLiveStream(LiveStream.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<LiveStream> future =
   *       liveStreamServiceClient.updateLiveStreamCallable().futureCall(request);
   *   // Do something.
   *   LiveStream response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateLiveStreamRequest, LiveStream> updateLiveStreamCallable() {
    return stub.updateLiveStreamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateLiveStreamRequest> requests = new ArrayList<>();
   *   BatchUpdateLiveStreamsResponse response =
   *       liveStreamServiceClient.batchUpdateLiveStreams(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LiveStreams` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateLiveStreamRequest must match this
   *     field.
   * @param requests Required. The `LiveStream` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateLiveStreamsResponse batchUpdateLiveStreams(
      @Nullable NetworkName parent, List<UpdateLiveStreamRequest> requests) {
    BatchUpdateLiveStreamsRequest request =
        BatchUpdateLiveStreamsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateLiveStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateLiveStreamRequest> requests = new ArrayList<>();
   *   BatchUpdateLiveStreamsResponse response =
   *       liveStreamServiceClient.batchUpdateLiveStreams(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where `LiveStreams` will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateLiveStreamRequest must match this
   *     field.
   * @param requests Required. The `LiveStream` objects to update. A maximum of 100 objects can be
   *     updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateLiveStreamsResponse batchUpdateLiveStreams(
      String parent, List<UpdateLiveStreamRequest> requests) {
    BatchUpdateLiveStreamsRequest request =
        BatchUpdateLiveStreamsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchUpdateLiveStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   BatchUpdateLiveStreamsRequest request =
   *       BatchUpdateLiveStreamsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateLiveStreamRequest>())
   *           .build();
   *   BatchUpdateLiveStreamsResponse response =
   *       liveStreamServiceClient.batchUpdateLiveStreams(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateLiveStreamsResponse batchUpdateLiveStreams(
      BatchUpdateLiveStreamsRequest request) {
    return batchUpdateLiveStreamsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   BatchUpdateLiveStreamsRequest request =
   *       BatchUpdateLiveStreamsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateLiveStreamRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateLiveStreamsResponse> future =
   *       liveStreamServiceClient.batchUpdateLiveStreamsCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateLiveStreamsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateLiveStreamsRequest, BatchUpdateLiveStreamsResponse>
      batchUpdateLiveStreamsCallable() {
    return stub.batchUpdateLiveStreamsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch activates `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchActivateLiveStreamsResponse response =
   *       liveStreamServiceClient.batchActivateLiveStreams(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `LiveStream`s to activate. Format:
   *     `networks/{network_code}/liveStreams/{live_stream_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateLiveStreamsResponse batchActivateLiveStreams(
      @Nullable NetworkName parent, List<String> names) {
    BatchActivateLiveStreamsRequest request =
        BatchActivateLiveStreamsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchActivateLiveStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch activates `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchActivateLiveStreamsResponse response =
   *       liveStreamServiceClient.batchActivateLiveStreams(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `LiveStream`s to activate. Format:
   *     `networks/{network_code}/liveStreams/{live_stream_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateLiveStreamsResponse batchActivateLiveStreams(
      String parent, List<String> names) {
    BatchActivateLiveStreamsRequest request =
        BatchActivateLiveStreamsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchActivateLiveStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch activates `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   BatchActivateLiveStreamsRequest request =
   *       BatchActivateLiveStreamsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchActivateLiveStreamsResponse response =
   *       liveStreamServiceClient.batchActivateLiveStreams(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchActivateLiveStreamsResponse batchActivateLiveStreams(
      BatchActivateLiveStreamsRequest request) {
    return batchActivateLiveStreamsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch activates `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   BatchActivateLiveStreamsRequest request =
   *       BatchActivateLiveStreamsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchActivateLiveStreamsResponse> future =
   *       liveStreamServiceClient.batchActivateLiveStreamsCallable().futureCall(request);
   *   // Do something.
   *   BatchActivateLiveStreamsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchActivateLiveStreamsRequest, BatchActivateLiveStreamsResponse>
      batchActivateLiveStreamsCallable() {
    return stub.batchActivateLiveStreamsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch pauses `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchPauseLiveStreamsResponse response =
   *       liveStreamServiceClient.batchPauseLiveStreams(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `LiveStream`s to pause. Format:
   *     `networks/{network_code}/liveStreams/{live_stream_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPauseLiveStreamsResponse batchPauseLiveStreams(
      @Nullable NetworkName parent, List<String> names) {
    BatchPauseLiveStreamsRequest request =
        BatchPauseLiveStreamsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchPauseLiveStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch pauses `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchPauseLiveStreamsResponse response =
   *       liveStreamServiceClient.batchPauseLiveStreams(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `LiveStream`s to pause. Format:
   *     `networks/{network_code}/liveStreams/{live_stream_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPauseLiveStreamsResponse batchPauseLiveStreams(
      String parent, List<String> names) {
    BatchPauseLiveStreamsRequest request =
        BatchPauseLiveStreamsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchPauseLiveStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch pauses `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   BatchPauseLiveStreamsRequest request =
   *       BatchPauseLiveStreamsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchPauseLiveStreamsResponse response =
   *       liveStreamServiceClient.batchPauseLiveStreams(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPauseLiveStreamsResponse batchPauseLiveStreams(
      BatchPauseLiveStreamsRequest request) {
    return batchPauseLiveStreamsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch pauses `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   BatchPauseLiveStreamsRequest request =
   *       BatchPauseLiveStreamsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchPauseLiveStreamsResponse> future =
   *       liveStreamServiceClient.batchPauseLiveStreamsCallable().futureCall(request);
   *   // Do something.
   *   BatchPauseLiveStreamsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchPauseLiveStreamsRequest, BatchPauseLiveStreamsResponse>
      batchPauseLiveStreamsCallable() {
    return stub.batchPauseLiveStreamsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch archives `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchArchiveLiveStreamsResponse response =
   *       liveStreamServiceClient.batchArchiveLiveStreams(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `LiveStream`s to archive. Format:
   *     `networks/{network_code}/liveStreams/{live_stream_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveLiveStreamsResponse batchArchiveLiveStreams(
      @Nullable NetworkName parent, List<String> names) {
    BatchArchiveLiveStreamsRequest request =
        BatchArchiveLiveStreamsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchArchiveLiveStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch archives `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchArchiveLiveStreamsResponse response =
   *       liveStreamServiceClient.batchArchiveLiveStreams(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `LiveStream`s to archive. Format:
   *     `networks/{network_code}/liveStreams/{live_stream_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveLiveStreamsResponse batchArchiveLiveStreams(
      String parent, List<String> names) {
    BatchArchiveLiveStreamsRequest request =
        BatchArchiveLiveStreamsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchArchiveLiveStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch archives `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   BatchArchiveLiveStreamsRequest request =
   *       BatchArchiveLiveStreamsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchArchiveLiveStreamsResponse response =
   *       liveStreamServiceClient.batchArchiveLiveStreams(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchArchiveLiveStreamsResponse batchArchiveLiveStreams(
      BatchArchiveLiveStreamsRequest request) {
    return batchArchiveLiveStreamsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch archives `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   BatchArchiveLiveStreamsRequest request =
   *       BatchArchiveLiveStreamsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchArchiveLiveStreamsResponse> future =
   *       liveStreamServiceClient.batchArchiveLiveStreamsCallable().futureCall(request);
   *   // Do something.
   *   BatchArchiveLiveStreamsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchArchiveLiveStreamsRequest, BatchArchiveLiveStreamsResponse>
      batchArchiveLiveStreamsCallable() {
    return stub.batchArchiveLiveStreamsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch pauses ads on `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchPauseAdsLiveStreamsResponse response =
   *       liveStreamServiceClient.batchPauseAdsLiveStreams(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `LiveStream`s to pause ads on. Format:
   *     `networks/{network_code}/liveStreams/{live_stream_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPauseAdsLiveStreamsResponse batchPauseAdsLiveStreams(
      @Nullable NetworkName parent, List<String> names) {
    BatchPauseAdsLiveStreamsRequest request =
        BatchPauseAdsLiveStreamsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchPauseAdsLiveStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch pauses ads on `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchPauseAdsLiveStreamsResponse response =
   *       liveStreamServiceClient.batchPauseAdsLiveStreams(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `LiveStream`s to pause ads on. Format:
   *     `networks/{network_code}/liveStreams/{live_stream_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPauseAdsLiveStreamsResponse batchPauseAdsLiveStreams(
      String parent, List<String> names) {
    BatchPauseAdsLiveStreamsRequest request =
        BatchPauseAdsLiveStreamsRequest.newBuilder().setParent(parent).addAllNames(names).build();
    return batchPauseAdsLiveStreams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch pauses ads on `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   BatchPauseAdsLiveStreamsRequest request =
   *       BatchPauseAdsLiveStreamsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchPauseAdsLiveStreamsResponse response =
   *       liveStreamServiceClient.batchPauseAdsLiveStreams(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchPauseAdsLiveStreamsResponse batchPauseAdsLiveStreams(
      BatchPauseAdsLiveStreamsRequest request) {
    return batchPauseAdsLiveStreamsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch pauses ads on `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   BatchPauseAdsLiveStreamsRequest request =
   *       BatchPauseAdsLiveStreamsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchPauseAdsLiveStreamsResponse> future =
   *       liveStreamServiceClient.batchPauseAdsLiveStreamsCallable().futureCall(request);
   *   // Do something.
   *   BatchPauseAdsLiveStreamsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchPauseAdsLiveStreamsRequest, BatchPauseAdsLiveStreamsResponse>
      batchPauseAdsLiveStreamsCallable() {
    return stub.batchPauseAdsLiveStreamsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch refreshes master playlists on `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<String> names = new ArrayList<>();
   *   BatchRefreshMasterPlaylistsResponse response =
   *       liveStreamServiceClient.batchRefreshMasterPlaylists(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `LiveStream`s to refresh master playlists on.
   *     Format: `networks/{network_code}/liveStreams/{live_stream_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRefreshMasterPlaylistsResponse batchRefreshMasterPlaylists(
      @Nullable NetworkName parent, List<String> names) {
    BatchRefreshMasterPlaylistsRequest request =
        BatchRefreshMasterPlaylistsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllNames(names)
            .build();
    return batchRefreshMasterPlaylists(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch refreshes master playlists on `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<String> names = new ArrayList<>();
   *   BatchRefreshMasterPlaylistsResponse response =
   *       liveStreamServiceClient.batchRefreshMasterPlaylists(parent, names);
   * }
   * }</pre>
   *
   * @param parent Required. Format: `networks/{network_code}`
   * @param names Required. The resource names of the `LiveStream`s to refresh master playlists on.
   *     Format: `networks/{network_code}/liveStreams/{live_stream_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRefreshMasterPlaylistsResponse batchRefreshMasterPlaylists(
      String parent, List<String> names) {
    BatchRefreshMasterPlaylistsRequest request =
        BatchRefreshMasterPlaylistsRequest.newBuilder()
            .setParent(parent)
            .addAllNames(names)
            .build();
    return batchRefreshMasterPlaylists(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch refreshes master playlists on `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   BatchRefreshMasterPlaylistsRequest request =
   *       BatchRefreshMasterPlaylistsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   BatchRefreshMasterPlaylistsResponse response =
   *       liveStreamServiceClient.batchRefreshMasterPlaylists(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchRefreshMasterPlaylistsResponse batchRefreshMasterPlaylists(
      BatchRefreshMasterPlaylistsRequest request) {
    return batchRefreshMasterPlaylistsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch refreshes master playlists on `LiveStream` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LiveStreamServiceClient liveStreamServiceClient = LiveStreamServiceClient.create()) {
   *   BatchRefreshMasterPlaylistsRequest request =
   *       BatchRefreshMasterPlaylistsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllNames(new ArrayList<String>())
   *           .build();
   *   ApiFuture<BatchRefreshMasterPlaylistsResponse> future =
   *       liveStreamServiceClient.batchRefreshMasterPlaylistsCallable().futureCall(request);
   *   // Do something.
   *   BatchRefreshMasterPlaylistsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          BatchRefreshMasterPlaylistsRequest, BatchRefreshMasterPlaylistsResponse>
      batchRefreshMasterPlaylistsCallable() {
    return stub.batchRefreshMasterPlaylistsCallable();
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

  public static class ListLiveStreamsPagedResponse
      extends AbstractPagedListResponse<
          ListLiveStreamsRequest,
          ListLiveStreamsResponse,
          LiveStream,
          ListLiveStreamsPage,
          ListLiveStreamsFixedSizeCollection> {

    public static ApiFuture<ListLiveStreamsPagedResponse> createAsync(
        PageContext<ListLiveStreamsRequest, ListLiveStreamsResponse, LiveStream> context,
        ApiFuture<ListLiveStreamsResponse> futureResponse) {
      ApiFuture<ListLiveStreamsPage> futurePage =
          ListLiveStreamsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLiveStreamsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLiveStreamsPagedResponse(ListLiveStreamsPage page) {
      super(page, ListLiveStreamsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLiveStreamsPage
      extends AbstractPage<
          ListLiveStreamsRequest, ListLiveStreamsResponse, LiveStream, ListLiveStreamsPage> {

    private ListLiveStreamsPage(
        @Nullable PageContext<ListLiveStreamsRequest, ListLiveStreamsResponse, LiveStream> context,
        @Nullable ListLiveStreamsResponse response) {
      super(context, response);
    }

    private static ListLiveStreamsPage createEmptyPage() {
      return new ListLiveStreamsPage(null, null);
    }

    @Override
    protected ListLiveStreamsPage createPage(
        @Nullable PageContext<ListLiveStreamsRequest, ListLiveStreamsResponse, LiveStream> context,
        @Nullable ListLiveStreamsResponse response) {
      return new ListLiveStreamsPage(context, response);
    }

    @Override
    public ApiFuture<ListLiveStreamsPage> createPageAsync(
        @Nullable PageContext<ListLiveStreamsRequest, ListLiveStreamsResponse, LiveStream> context,
        ApiFuture<ListLiveStreamsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLiveStreamsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLiveStreamsRequest,
          ListLiveStreamsResponse,
          LiveStream,
          ListLiveStreamsPage,
          ListLiveStreamsFixedSizeCollection> {

    private ListLiveStreamsFixedSizeCollection(
        @Nullable List<ListLiveStreamsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLiveStreamsFixedSizeCollection createEmptyCollection() {
      return new ListLiveStreamsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLiveStreamsFixedSizeCollection createCollection(
        @Nullable List<ListLiveStreamsPage> pages, int collectionSize) {
      return new ListLiveStreamsFixedSizeCollection(pages, collectionSize);
    }
  }
}
