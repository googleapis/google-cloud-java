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

package com.google.cloud.video.livestream.v1;

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
import com.google.cloud.video.livestream.v1.stub.LivestreamServiceStub;
import com.google.cloud.video.livestream.v1.stub.LivestreamServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Using Live Stream API, you can generate live streams in the various
 * renditions and streaming formats. The streaming format include HTTP Live Streaming (HLS) and
 * Dynamic Adaptive Streaming over HTTP (DASH). You can send a source stream in the various ways,
 * including Real-Time Messaging Protocol (RTMP) and Secure Reliable Transport (SRT).
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
 * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
 *   ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
 *   Channel response = livestreamServiceClient.getChannel(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LivestreamServiceClient object to clean up resources
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
 * <p>This class can be customized by passing in a custom instance of LivestreamServiceSettings to
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
 * LivestreamServiceSettings livestreamServiceSettings =
 *     LivestreamServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LivestreamServiceClient livestreamServiceClient =
 *     LivestreamServiceClient.create(livestreamServiceSettings);
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
 * LivestreamServiceSettings livestreamServiceSettings =
 *     LivestreamServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LivestreamServiceClient livestreamServiceClient =
 *     LivestreamServiceClient.create(livestreamServiceSettings);
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
 * LivestreamServiceSettings livestreamServiceSettings =
 *     LivestreamServiceSettings.newBuilder()
 *         .setTransportChannelProvider(
 *             LivestreamServiceSettings.defaultHttpJsonTransportProviderBuilder().build())
 *         .build();
 * LivestreamServiceClient livestreamServiceClient =
 *     LivestreamServiceClient.create(livestreamServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class LivestreamServiceClient implements BackgroundResource {
  private final LivestreamServiceSettings settings;
  private final LivestreamServiceStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of LivestreamServiceClient with default settings. */
  public static final LivestreamServiceClient create() throws IOException {
    return create(LivestreamServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LivestreamServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LivestreamServiceClient create(LivestreamServiceSettings settings)
      throws IOException {
    return new LivestreamServiceClient(settings);
  }

  /**
   * Constructs an instance of LivestreamServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(LivestreamServiceSettings).
   */
  public static final LivestreamServiceClient create(LivestreamServiceStub stub) {
    return new LivestreamServiceClient(stub);
  }

  /**
   * Constructs an instance of LivestreamServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected LivestreamServiceClient(LivestreamServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LivestreamServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected LivestreamServiceClient(LivestreamServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final LivestreamServiceSettings getSettings() {
    return settings;
  }

  public LivestreamServiceStub getStub() {
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
   * Creates a channel with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Channel channel = Channel.newBuilder().build();
   *   String channelId = "channelId1461735806";
   *   Channel response =
   *       livestreamServiceClient.createChannelAsync(parent, channel, channelId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location for the resource, in the form of:
   *     `projects/{project}/locations/{location}`.
   * @param channel Required. The channel resource to be created.
   * @param channelId Required. The ID of the channel resource to be created. This value must be
   *     1-63 characters, begin and end with `[a-z0-9]`, could contain dashes (-) in between.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> createChannelAsync(
      LocationName parent, Channel channel, String channelId) {
    CreateChannelRequest request =
        CreateChannelRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setChannel(channel)
            .setChannelId(channelId)
            .build();
    return createChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a channel with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Channel channel = Channel.newBuilder().build();
   *   String channelId = "channelId1461735806";
   *   Channel response =
   *       livestreamServiceClient.createChannelAsync(parent, channel, channelId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location for the resource, in the form of:
   *     `projects/{project}/locations/{location}`.
   * @param channel Required. The channel resource to be created.
   * @param channelId Required. The ID of the channel resource to be created. This value must be
   *     1-63 characters, begin and end with `[a-z0-9]`, could contain dashes (-) in between.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> createChannelAsync(
      String parent, Channel channel, String channelId) {
    CreateChannelRequest request =
        CreateChannelRequest.newBuilder()
            .setParent(parent)
            .setChannel(channel)
            .setChannelId(channelId)
            .build();
    return createChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a channel with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateChannelRequest request =
   *       CreateChannelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setChannel(Channel.newBuilder().build())
   *           .setChannelId("channelId1461735806")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Channel response = livestreamServiceClient.createChannelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> createChannelAsync(
      CreateChannelRequest request) {
    return createChannelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a channel with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateChannelRequest request =
   *       CreateChannelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setChannel(Channel.newBuilder().build())
   *           .setChannelId("channelId1461735806")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Channel, OperationMetadata> future =
   *       livestreamServiceClient.createChannelOperationCallable().futureCall(request);
   *   // Do something.
   *   Channel response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateChannelRequest, Channel, OperationMetadata>
      createChannelOperationCallable() {
    return stub.createChannelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a channel with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateChannelRequest request =
   *       CreateChannelRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setChannel(Channel.newBuilder().build())
   *           .setChannelId("channelId1461735806")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.createChannelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateChannelRequest, Operation> createChannelCallable() {
    return stub.createChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all channels in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Channel element : livestreamServiceClient.listChannels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location for the resource, in the form of:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChannelsPagedResponse listChannels(LocationName parent) {
    ListChannelsRequest request =
        ListChannelsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listChannels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all channels in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Channel element : livestreamServiceClient.listChannels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location for the resource, in the form of:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChannelsPagedResponse listChannels(String parent) {
    ListChannelsRequest request = ListChannelsRequest.newBuilder().setParent(parent).build();
    return listChannels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all channels in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListChannelsRequest request =
   *       ListChannelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Channel element : livestreamServiceClient.listChannels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChannelsPagedResponse listChannels(ListChannelsRequest request) {
    return listChannelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all channels in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListChannelsRequest request =
   *       ListChannelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Channel> future =
   *       livestreamServiceClient.listChannelsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Channel element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListChannelsRequest, ListChannelsPagedResponse>
      listChannelsPagedCallable() {
    return stub.listChannelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all channels in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListChannelsRequest request =
   *       ListChannelsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListChannelsResponse response =
   *         livestreamServiceClient.listChannelsCallable().call(request);
   *     for (Channel element : response.getChannelsList()) {
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
  public final UnaryCallable<ListChannelsRequest, ListChannelsResponse> listChannelsCallable() {
    return stub.listChannelsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
   *   Channel response = livestreamServiceClient.getChannel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Channel getChannel(ChannelName name) {
    GetChannelRequest request =
        GetChannelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getChannel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString();
   *   Channel response = livestreamServiceClient.getChannel(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Channel getChannel(String name) {
    GetChannelRequest request = GetChannelRequest.newBuilder().setName(name).build();
    return getChannel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   GetChannelRequest request =
   *       GetChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .build();
   *   Channel response = livestreamServiceClient.getChannel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Channel getChannel(GetChannelRequest request) {
    return getChannelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   GetChannelRequest request =
   *       GetChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .build();
   *   ApiFuture<Channel> future = livestreamServiceClient.getChannelCallable().futureCall(request);
   *   // Do something.
   *   Channel response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetChannelRequest, Channel> getChannelCallable() {
    return stub.getChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
   *   livestreamServiceClient.deleteChannelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteChannelAsync(ChannelName name) {
    DeleteChannelRequest request =
        DeleteChannelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString();
   *   livestreamServiceClient.deleteChannelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteChannelAsync(String name) {
    DeleteChannelRequest request = DeleteChannelRequest.newBuilder().setName(name).build();
    return deleteChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteChannelRequest request =
   *       DeleteChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   livestreamServiceClient.deleteChannelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteChannelAsync(
      DeleteChannelRequest request) {
    return deleteChannelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteChannelRequest request =
   *       DeleteChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       livestreamServiceClient.deleteChannelOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteChannelRequest, Empty, OperationMetadata>
      deleteChannelOperationCallable() {
    return stub.deleteChannelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteChannelRequest request =
   *       DeleteChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setRequestId("requestId693933066")
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.deleteChannelCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteChannelRequest, Operation> deleteChannelCallable() {
    return stub.deleteChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   Channel channel = Channel.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Channel response = livestreamServiceClient.updateChannelAsync(channel, updateMask).get();
   * }
   * }</pre>
   *
   * @param channel Required. The channel resource to be updated.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the Channel
   *     resource by the update. You can only update the following fields:
   *     <ul>
   *       <li>[`inputAttachments`](https://cloud.google.com/livestream/docs/reference/rest/v1/projects.locations.channels#inputattachment)
   *       <li>[`output`](https://cloud.google.com/livestream/docs/reference/rest/v1/projects.locations.channels#output)
   *       <li>[`elementaryStreams`](https://cloud.google.com/livestream/docs/reference/rest/v1/projects.locations.channels#ElementaryStream)
   *       <li>[`muxStreams`](https://cloud.google.com/livestream/docs/reference/rest/v1/projects.locations.channels#muxstream)
   *       <li>[`manifests`](https://cloud.google.com/livestream/docs/reference/rest/v1/projects.locations.channels#Manifest)
   *       <li>[`spritesheets`](https://cloud.google.com/livestream/docs/reference/rest/v1/projects.locations.channels#spritesheet)
   *     </ul>
   *     <p>The fields specified in the update_mask are relative to the resource, not the full
   *     request. A field will be overwritten if it is in the mask.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> updateChannelAsync(
      Channel channel, FieldMask updateMask) {
    UpdateChannelRequest request =
        UpdateChannelRequest.newBuilder().setChannel(channel).setUpdateMask(updateMask).build();
    return updateChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   UpdateChannelRequest request =
   *       UpdateChannelRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setChannel(Channel.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Channel response = livestreamServiceClient.updateChannelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Channel, OperationMetadata> updateChannelAsync(
      UpdateChannelRequest request) {
    return updateChannelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   UpdateChannelRequest request =
   *       UpdateChannelRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setChannel(Channel.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Channel, OperationMetadata> future =
   *       livestreamServiceClient.updateChannelOperationCallable().futureCall(request);
   *   // Do something.
   *   Channel response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateChannelRequest, Channel, OperationMetadata>
      updateChannelOperationCallable() {
    return stub.updateChannelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   UpdateChannelRequest request =
   *       UpdateChannelRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setChannel(Channel.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.updateChannelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateChannelRequest, Operation> updateChannelCallable() {
    return stub.updateChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts the specified channel. Part of the video pipeline will be created only when the
   * StartChannel request is received by the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
   *   ChannelOperationResponse response = livestreamServiceClient.startChannelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelOperationResponse, OperationMetadata> startChannelAsync(
      ChannelName name) {
    StartChannelRequest request =
        StartChannelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return startChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts the specified channel. Part of the video pipeline will be created only when the
   * StartChannel request is received by the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString();
   *   ChannelOperationResponse response = livestreamServiceClient.startChannelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelOperationResponse, OperationMetadata> startChannelAsync(
      String name) {
    StartChannelRequest request = StartChannelRequest.newBuilder().setName(name).build();
    return startChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts the specified channel. Part of the video pipeline will be created only when the
   * StartChannel request is received by the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   StartChannelRequest request =
   *       StartChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ChannelOperationResponse response = livestreamServiceClient.startChannelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelOperationResponse, OperationMetadata> startChannelAsync(
      StartChannelRequest request) {
    return startChannelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts the specified channel. Part of the video pipeline will be created only when the
   * StartChannel request is received by the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   StartChannelRequest request =
   *       StartChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ChannelOperationResponse, OperationMetadata> future =
   *       livestreamServiceClient.startChannelOperationCallable().futureCall(request);
   *   // Do something.
   *   ChannelOperationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StartChannelRequest, ChannelOperationResponse, OperationMetadata>
      startChannelOperationCallable() {
    return stub.startChannelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Starts the specified channel. Part of the video pipeline will be created only when the
   * StartChannel request is received by the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   StartChannelRequest request =
   *       StartChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.startChannelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StartChannelRequest, Operation> startChannelCallable() {
    return stub.startChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the specified channel. Part of the video pipeline will be released when the StopChannel
   * request is received by the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ChannelName name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
   *   ChannelOperationResponse response = livestreamServiceClient.stopChannelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelOperationResponse, OperationMetadata> stopChannelAsync(
      ChannelName name) {
    StopChannelRequest request =
        StopChannelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return stopChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the specified channel. Part of the video pipeline will be released when the StopChannel
   * request is received by the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString();
   *   ChannelOperationResponse response = livestreamServiceClient.stopChannelAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the channel resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelOperationResponse, OperationMetadata> stopChannelAsync(
      String name) {
    StopChannelRequest request = StopChannelRequest.newBuilder().setName(name).build();
    return stopChannelAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the specified channel. Part of the video pipeline will be released when the StopChannel
   * request is received by the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   StopChannelRequest request =
   *       StopChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ChannelOperationResponse response = livestreamServiceClient.stopChannelAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ChannelOperationResponse, OperationMetadata> stopChannelAsync(
      StopChannelRequest request) {
    return stopChannelOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the specified channel. Part of the video pipeline will be released when the StopChannel
   * request is received by the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   StopChannelRequest request =
   *       StopChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<ChannelOperationResponse, OperationMetadata> future =
   *       livestreamServiceClient.stopChannelOperationCallable().futureCall(request);
   *   // Do something.
   *   ChannelOperationResponse response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<StopChannelRequest, ChannelOperationResponse, OperationMetadata>
      stopChannelOperationCallable() {
    return stub.stopChannelOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Stops the specified channel. Part of the video pipeline will be released when the StopChannel
   * request is received by the server.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   StopChannelRequest request =
   *       StopChannelRequest.newBuilder()
   *           .setName(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.stopChannelCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StopChannelRequest, Operation> stopChannelCallable() {
    return stub.stopChannelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an input with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Input input = Input.newBuilder().build();
   *   String inputId = "inputId1954846341";
   *   Input response = livestreamServiceClient.createInputAsync(parent, input, inputId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location for the resource, in the form of:
   *     `projects/{project}/locations/{location}`.
   * @param input Required. The input resource to be created.
   * @param inputId Required. The ID of the input resource to be created. This value must be 1-63
   *     characters, begin and end with `[a-z0-9]`, could contain dashes (-) in between.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Input, OperationMetadata> createInputAsync(
      LocationName parent, Input input, String inputId) {
    CreateInputRequest request =
        CreateInputRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setInput(input)
            .setInputId(inputId)
            .build();
    return createInputAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an input with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Input input = Input.newBuilder().build();
   *   String inputId = "inputId1954846341";
   *   Input response = livestreamServiceClient.createInputAsync(parent, input, inputId).get();
   * }
   * }</pre>
   *
   * @param parent Required. The parent location for the resource, in the form of:
   *     `projects/{project}/locations/{location}`.
   * @param input Required. The input resource to be created.
   * @param inputId Required. The ID of the input resource to be created. This value must be 1-63
   *     characters, begin and end with `[a-z0-9]`, could contain dashes (-) in between.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Input, OperationMetadata> createInputAsync(
      String parent, Input input, String inputId) {
    CreateInputRequest request =
        CreateInputRequest.newBuilder()
            .setParent(parent)
            .setInput(input)
            .setInputId(inputId)
            .build();
    return createInputAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an input with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateInputRequest request =
   *       CreateInputRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInput(Input.newBuilder().build())
   *           .setInputId("inputId1954846341")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Input response = livestreamServiceClient.createInputAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Input, OperationMetadata> createInputAsync(
      CreateInputRequest request) {
    return createInputOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an input with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateInputRequest request =
   *       CreateInputRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInput(Input.newBuilder().build())
   *           .setInputId("inputId1954846341")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Input, OperationMetadata> future =
   *       livestreamServiceClient.createInputOperationCallable().futureCall(request);
   *   // Do something.
   *   Input response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateInputRequest, Input, OperationMetadata>
      createInputOperationCallable() {
    return stub.createInputOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an input with the provided unique ID in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateInputRequest request =
   *       CreateInputRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setInput(Input.newBuilder().build())
   *           .setInputId("inputId1954846341")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.createInputCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateInputRequest, Operation> createInputCallable() {
    return stub.createInputCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all inputs in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Input element : livestreamServiceClient.listInputs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location for the resource, in the form of:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInputsPagedResponse listInputs(LocationName parent) {
    ListInputsRequest request =
        ListInputsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listInputs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all inputs in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Input element : livestreamServiceClient.listInputs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent location for the resource, in the form of:
   *     `projects/{project}/locations/{location}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInputsPagedResponse listInputs(String parent) {
    ListInputsRequest request = ListInputsRequest.newBuilder().setParent(parent).build();
    return listInputs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all inputs in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListInputsRequest request =
   *       ListInputsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Input element : livestreamServiceClient.listInputs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListInputsPagedResponse listInputs(ListInputsRequest request) {
    return listInputsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all inputs in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListInputsRequest request =
   *       ListInputsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Input> future =
   *       livestreamServiceClient.listInputsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Input element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListInputsRequest, ListInputsPagedResponse> listInputsPagedCallable() {
    return stub.listInputsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all inputs in the specified region.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListInputsRequest request =
   *       ListInputsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListInputsResponse response = livestreamServiceClient.listInputsCallable().call(request);
   *     for (Input element : response.getInputsList()) {
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
  public final UnaryCallable<ListInputsRequest, ListInputsResponse> listInputsCallable() {
    return stub.listInputsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   InputName name = InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]");
   *   Input response = livestreamServiceClient.getInput(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the input resource, in the form of:
   *     `projects/{project}/locations/{location}/inputs/{inputId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Input getInput(InputName name) {
    GetInputRequest request =
        GetInputRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getInput(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString();
   *   Input response = livestreamServiceClient.getInput(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the input resource, in the form of:
   *     `projects/{project}/locations/{location}/inputs/{inputId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Input getInput(String name) {
    GetInputRequest request = GetInputRequest.newBuilder().setName(name).build();
    return getInput(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   GetInputRequest request =
   *       GetInputRequest.newBuilder()
   *           .setName(InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString())
   *           .build();
   *   Input response = livestreamServiceClient.getInput(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Input getInput(GetInputRequest request) {
    return getInputCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   GetInputRequest request =
   *       GetInputRequest.newBuilder()
   *           .setName(InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString())
   *           .build();
   *   ApiFuture<Input> future = livestreamServiceClient.getInputCallable().futureCall(request);
   *   // Do something.
   *   Input response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetInputRequest, Input> getInputCallable() {
    return stub.getInputCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   InputName name = InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]");
   *   livestreamServiceClient.deleteInputAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the input resource, in the form of:
   *     `projects/{project}/locations/{location}/inputs/{inputId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInputAsync(InputName name) {
    DeleteInputRequest request =
        DeleteInputRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteInputAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString();
   *   livestreamServiceClient.deleteInputAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The name of the input resource, in the form of:
   *     `projects/{project}/locations/{location}/inputs/{inputId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInputAsync(String name) {
    DeleteInputRequest request = DeleteInputRequest.newBuilder().setName(name).build();
    return deleteInputAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteInputRequest request =
   *       DeleteInputRequest.newBuilder()
   *           .setName(InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   livestreamServiceClient.deleteInputAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Empty, OperationMetadata> deleteInputAsync(
      DeleteInputRequest request) {
    return deleteInputOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteInputRequest request =
   *       DeleteInputRequest.newBuilder()
   *           .setName(InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Empty, OperationMetadata> future =
   *       livestreamServiceClient.deleteInputOperationCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteInputRequest, Empty, OperationMetadata>
      deleteInputOperationCallable() {
    return stub.deleteInputOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteInputRequest request =
   *       DeleteInputRequest.newBuilder()
   *           .setName(InputName.of("[PROJECT]", "[LOCATION]", "[INPUT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.deleteInputCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteInputRequest, Operation> deleteInputCallable() {
    return stub.deleteInputCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   Input input = Input.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Input response = livestreamServiceClient.updateInputAsync(input, updateMask).get();
   * }
   * }</pre>
   *
   * @param input Required. The input resource to be updated.
   * @param updateMask Field mask is used to specify the fields to be overwritten in the Input
   *     resource by the update. You can only update the following fields:
   *     <ul>
   *       <li>[`preprocessingConfig`](https://cloud.google.com/livestream/docs/reference/rest/v1/projects.locations.inputs#PreprocessingConfig)
   *       <li>[`securityRules`](https://cloud.google.com/livestream/docs/reference/rest/v1/projects.locations.inputs#SecurityRule)
   *     </ul>
   *     <p>The fields specified in the update_mask are relative to the resource, not the full
   *     request. A field will be overwritten if it is in the mask.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Input, OperationMetadata> updateInputAsync(
      Input input, FieldMask updateMask) {
    UpdateInputRequest request =
        UpdateInputRequest.newBuilder().setInput(input).setUpdateMask(updateMask).build();
    return updateInputAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   UpdateInputRequest request =
   *       UpdateInputRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInput(Input.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Input response = livestreamServiceClient.updateInputAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Input, OperationMetadata> updateInputAsync(
      UpdateInputRequest request) {
    return updateInputOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   UpdateInputRequest request =
   *       UpdateInputRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInput(Input.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Input, OperationMetadata> future =
   *       livestreamServiceClient.updateInputOperationCallable().futureCall(request);
   *   // Do something.
   *   Input response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateInputRequest, Input, OperationMetadata>
      updateInputOperationCallable() {
    return stub.updateInputOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified input.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   UpdateInputRequest request =
   *       UpdateInputRequest.newBuilder()
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .setInput(Input.newBuilder().build())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future =
   *       livestreamServiceClient.updateInputCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateInputRequest, Operation> updateInputCallable() {
    return stub.updateInputCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an event with the provided unique ID in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
   *   Event event = Event.newBuilder().build();
   *   String eventId = "eventId-1376502443";
   *   Event response = livestreamServiceClient.createEvent(parent, event, eventId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent channel for the resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @param event Required. The event resource to be created.
   * @param eventId Required. The ID of the event resource to be created. This value must be 1-63
   *     characters, begin and end with `[a-z0-9]`, could contain dashes (-) in between.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Event createEvent(ChannelName parent, Event event, String eventId) {
    CreateEventRequest request =
        CreateEventRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEvent(event)
            .setEventId(eventId)
            .build();
    return createEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an event with the provided unique ID in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString();
   *   Event event = Event.newBuilder().build();
   *   String eventId = "eventId-1376502443";
   *   Event response = livestreamServiceClient.createEvent(parent, event, eventId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent channel for the resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @param event Required. The event resource to be created.
   * @param eventId Required. The ID of the event resource to be created. This value must be 1-63
   *     characters, begin and end with `[a-z0-9]`, could contain dashes (-) in between.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Event createEvent(String parent, Event event, String eventId) {
    CreateEventRequest request =
        CreateEventRequest.newBuilder()
            .setParent(parent)
            .setEvent(event)
            .setEventId(eventId)
            .build();
    return createEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an event with the provided unique ID in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateEventRequest request =
   *       CreateEventRequest.newBuilder()
   *           .setParent(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setEvent(Event.newBuilder().build())
   *           .setEventId("eventId-1376502443")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Event response = livestreamServiceClient.createEvent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Event createEvent(CreateEventRequest request) {
    return createEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an event with the provided unique ID in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   CreateEventRequest request =
   *       CreateEventRequest.newBuilder()
   *           .setParent(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setEvent(Event.newBuilder().build())
   *           .setEventId("eventId-1376502443")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Event> future = livestreamServiceClient.createEventCallable().futureCall(request);
   *   // Do something.
   *   Event response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEventRequest, Event> createEventCallable() {
    return stub.createEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all events in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ChannelName parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]");
   *   for (Event element : livestreamServiceClient.listEvents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent channel for the resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventsPagedResponse listEvents(ChannelName parent) {
    ListEventsRequest request =
        ListEventsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all events in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String parent = ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString();
   *   for (Event element : livestreamServiceClient.listEvents(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent channel for the resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventsPagedResponse listEvents(String parent) {
    ListEventsRequest request = ListEventsRequest.newBuilder().setParent(parent).build();
    return listEvents(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all events in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListEventsRequest request =
   *       ListEventsRequest.newBuilder()
   *           .setParent(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (Event element : livestreamServiceClient.listEvents(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEventsPagedResponse listEvents(ListEventsRequest request) {
    return listEventsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all events in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListEventsRequest request =
   *       ListEventsRequest.newBuilder()
   *           .setParent(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<Event> future =
   *       livestreamServiceClient.listEventsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Event element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEventsRequest, ListEventsPagedResponse> listEventsPagedCallable() {
    return stub.listEventsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns a list of all events in the specified channel.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   ListEventsRequest request =
   *       ListEventsRequest.newBuilder()
   *           .setParent(ChannelName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListEventsResponse response = livestreamServiceClient.listEventsCallable().call(request);
   *     for (Event element : response.getEventsList()) {
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
  public final UnaryCallable<ListEventsRequest, ListEventsResponse> listEventsCallable() {
    return stub.listEventsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   EventName name = EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]");
   *   Event response = livestreamServiceClient.getEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the event resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}/events/{eventId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Event getEvent(EventName name) {
    GetEventRequest request =
        GetEventRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]").toString();
   *   Event response = livestreamServiceClient.getEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the event resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}/events/{eventId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Event getEvent(String name) {
    GetEventRequest request = GetEventRequest.newBuilder().setName(name).build();
    return getEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   GetEventRequest request =
   *       GetEventRequest.newBuilder()
   *           .setName(EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]").toString())
   *           .build();
   *   Event response = livestreamServiceClient.getEvent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Event getEvent(GetEventRequest request) {
    return getEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the specified event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   GetEventRequest request =
   *       GetEventRequest.newBuilder()
   *           .setName(EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]").toString())
   *           .build();
   *   ApiFuture<Event> future = livestreamServiceClient.getEventCallable().futureCall(request);
   *   // Do something.
   *   Event response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEventRequest, Event> getEventCallable() {
    return stub.getEventCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   EventName name = EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]");
   *   livestreamServiceClient.deleteEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the event resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}/events/{eventId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEvent(EventName name) {
    DeleteEventRequest request =
        DeleteEventRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   String name = EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]").toString();
   *   livestreamServiceClient.deleteEvent(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the event resource, in the form of:
   *     `projects/{project}/locations/{location}/channels/{channelId}/events/{eventId}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEvent(String name) {
    DeleteEventRequest request = DeleteEventRequest.newBuilder().setName(name).build();
    deleteEvent(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteEventRequest request =
   *       DeleteEventRequest.newBuilder()
   *           .setName(EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   livestreamServiceClient.deleteEvent(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEvent(DeleteEventRequest request) {
    deleteEventCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified event.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LivestreamServiceClient livestreamServiceClient = LivestreamServiceClient.create()) {
   *   DeleteEventRequest request =
   *       DeleteEventRequest.newBuilder()
   *           .setName(EventName.of("[PROJECT]", "[LOCATION]", "[CHANNEL]", "[EVENT]").toString())
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Empty> future = livestreamServiceClient.deleteEventCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEventRequest, Empty> deleteEventCallable() {
    return stub.deleteEventCallable();
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

  public static class ListChannelsPagedResponse
      extends AbstractPagedListResponse<
          ListChannelsRequest,
          ListChannelsResponse,
          Channel,
          ListChannelsPage,
          ListChannelsFixedSizeCollection> {

    public static ApiFuture<ListChannelsPagedResponse> createAsync(
        PageContext<ListChannelsRequest, ListChannelsResponse, Channel> context,
        ApiFuture<ListChannelsResponse> futureResponse) {
      ApiFuture<ListChannelsPage> futurePage =
          ListChannelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListChannelsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListChannelsPagedResponse(ListChannelsPage page) {
      super(page, ListChannelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListChannelsPage
      extends AbstractPage<ListChannelsRequest, ListChannelsResponse, Channel, ListChannelsPage> {

    private ListChannelsPage(
        PageContext<ListChannelsRequest, ListChannelsResponse, Channel> context,
        ListChannelsResponse response) {
      super(context, response);
    }

    private static ListChannelsPage createEmptyPage() {
      return new ListChannelsPage(null, null);
    }

    @Override
    protected ListChannelsPage createPage(
        PageContext<ListChannelsRequest, ListChannelsResponse, Channel> context,
        ListChannelsResponse response) {
      return new ListChannelsPage(context, response);
    }

    @Override
    public ApiFuture<ListChannelsPage> createPageAsync(
        PageContext<ListChannelsRequest, ListChannelsResponse, Channel> context,
        ApiFuture<ListChannelsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListChannelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListChannelsRequest,
          ListChannelsResponse,
          Channel,
          ListChannelsPage,
          ListChannelsFixedSizeCollection> {

    private ListChannelsFixedSizeCollection(List<ListChannelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListChannelsFixedSizeCollection createEmptyCollection() {
      return new ListChannelsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListChannelsFixedSizeCollection createCollection(
        List<ListChannelsPage> pages, int collectionSize) {
      return new ListChannelsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListInputsPagedResponse
      extends AbstractPagedListResponse<
          ListInputsRequest,
          ListInputsResponse,
          Input,
          ListInputsPage,
          ListInputsFixedSizeCollection> {

    public static ApiFuture<ListInputsPagedResponse> createAsync(
        PageContext<ListInputsRequest, ListInputsResponse, Input> context,
        ApiFuture<ListInputsResponse> futureResponse) {
      ApiFuture<ListInputsPage> futurePage =
          ListInputsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListInputsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListInputsPagedResponse(ListInputsPage page) {
      super(page, ListInputsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListInputsPage
      extends AbstractPage<ListInputsRequest, ListInputsResponse, Input, ListInputsPage> {

    private ListInputsPage(
        PageContext<ListInputsRequest, ListInputsResponse, Input> context,
        ListInputsResponse response) {
      super(context, response);
    }

    private static ListInputsPage createEmptyPage() {
      return new ListInputsPage(null, null);
    }

    @Override
    protected ListInputsPage createPage(
        PageContext<ListInputsRequest, ListInputsResponse, Input> context,
        ListInputsResponse response) {
      return new ListInputsPage(context, response);
    }

    @Override
    public ApiFuture<ListInputsPage> createPageAsync(
        PageContext<ListInputsRequest, ListInputsResponse, Input> context,
        ApiFuture<ListInputsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListInputsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListInputsRequest,
          ListInputsResponse,
          Input,
          ListInputsPage,
          ListInputsFixedSizeCollection> {

    private ListInputsFixedSizeCollection(List<ListInputsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListInputsFixedSizeCollection createEmptyCollection() {
      return new ListInputsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListInputsFixedSizeCollection createCollection(
        List<ListInputsPage> pages, int collectionSize) {
      return new ListInputsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEventsPagedResponse
      extends AbstractPagedListResponse<
          ListEventsRequest,
          ListEventsResponse,
          Event,
          ListEventsPage,
          ListEventsFixedSizeCollection> {

    public static ApiFuture<ListEventsPagedResponse> createAsync(
        PageContext<ListEventsRequest, ListEventsResponse, Event> context,
        ApiFuture<ListEventsResponse> futureResponse) {
      ApiFuture<ListEventsPage> futurePage =
          ListEventsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListEventsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListEventsPagedResponse(ListEventsPage page) {
      super(page, ListEventsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEventsPage
      extends AbstractPage<ListEventsRequest, ListEventsResponse, Event, ListEventsPage> {

    private ListEventsPage(
        PageContext<ListEventsRequest, ListEventsResponse, Event> context,
        ListEventsResponse response) {
      super(context, response);
    }

    private static ListEventsPage createEmptyPage() {
      return new ListEventsPage(null, null);
    }

    @Override
    protected ListEventsPage createPage(
        PageContext<ListEventsRequest, ListEventsResponse, Event> context,
        ListEventsResponse response) {
      return new ListEventsPage(context, response);
    }

    @Override
    public ApiFuture<ListEventsPage> createPageAsync(
        PageContext<ListEventsRequest, ListEventsResponse, Event> context,
        ApiFuture<ListEventsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEventsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEventsRequest,
          ListEventsResponse,
          Event,
          ListEventsPage,
          ListEventsFixedSizeCollection> {

    private ListEventsFixedSizeCollection(List<ListEventsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEventsFixedSizeCollection createEmptyCollection() {
      return new ListEventsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEventsFixedSizeCollection createCollection(
        List<ListEventsPage> pages, int collectionSize) {
      return new ListEventsFixedSizeCollection(pages, collectionSize);
    }
  }
}
