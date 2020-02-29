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
package com.google.cloud.asset.v1p2beta1;

import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.asset.v1p2beta1.stub.AssetServiceStub;
import com.google.cloud.asset.v1p2beta1.stub.AssetServiceStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Asset service definition.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
 *   String parent = "";
 *   Feed response = assetServiceClient.createFeed(parent);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the assetServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of AssetServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * AssetServiceSettings assetServiceSettings =
 *     AssetServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AssetServiceClient assetServiceClient =
 *     AssetServiceClient.create(assetServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * AssetServiceSettings assetServiceSettings =
 *     AssetServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AssetServiceClient assetServiceClient =
 *     AssetServiceClient.create(assetServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class AssetServiceClient implements BackgroundResource {
  private final AssetServiceSettings settings;
  private final AssetServiceStub stub;

  private static final PathTemplate FEED_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding("projects/{project}/feeds/{feed}");

  /**
   * Formats a string containing the fully-qualified path to represent a feed resource.
   *
   * @deprecated Use the {@link FeedName} class instead.
   */
  @Deprecated
  public static final String formatFeedName(String project, String feed) {
    return FEED_PATH_TEMPLATE.instantiate(
        "project", project,
        "feed", feed);
  }

  /**
   * Parses the project from the given fully-qualified path which represents a feed resource.
   *
   * @deprecated Use the {@link FeedName} class instead.
   */
  @Deprecated
  public static final String parseProjectFromFeedName(String feedName) {
    return FEED_PATH_TEMPLATE.parse(feedName).get("project");
  }

  /**
   * Parses the feed from the given fully-qualified path which represents a feed resource.
   *
   * @deprecated Use the {@link FeedName} class instead.
   */
  @Deprecated
  public static final String parseFeedFromFeedName(String feedName) {
    return FEED_PATH_TEMPLATE.parse(feedName).get("feed");
  }

  /** Constructs an instance of AssetServiceClient with default settings. */
  public static final AssetServiceClient create() throws IOException {
    return create(AssetServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of AssetServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final AssetServiceClient create(AssetServiceSettings settings) throws IOException {
    return new AssetServiceClient(settings);
  }

  /**
   * Constructs an instance of AssetServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use AssetServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final AssetServiceClient create(AssetServiceStub stub) {
    return new AssetServiceClient(stub);
  }

  /**
   * Constructs an instance of AssetServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected AssetServiceClient(AssetServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((AssetServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected AssetServiceClient(AssetServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final AssetServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public AssetServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a feed in a parent project/folder/organization to listen to its asset updates.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String parent = "";
   *   Feed response = assetServiceClient.createFeed(parent);
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the project/folder/organization where this feed should be
   *     created in. It can only be an organization number (such as "organizations/123"), a folder
   *     number (such as "folders/123"), a project ID (such as "projects/my-project-id")", or a
   *     project number (such as "projects/12345").
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed createFeed(String parent) {
    CreateFeedRequest request = CreateFeedRequest.newBuilder().setParent(parent).build();
    return createFeed(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a feed in a parent project/folder/organization to listen to its asset updates.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String parent = "";
   *   String feedId = "";
   *   Feed feed = Feed.newBuilder().build();
   *   CreateFeedRequest request = CreateFeedRequest.newBuilder()
   *     .setParent(parent)
   *     .setFeedId(feedId)
   *     .setFeed(feed)
   *     .build();
   *   Feed response = assetServiceClient.createFeed(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed createFeed(CreateFeedRequest request) {
    return createFeedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a feed in a parent project/folder/organization to listen to its asset updates.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String parent = "";
   *   String feedId = "";
   *   Feed feed = Feed.newBuilder().build();
   *   CreateFeedRequest request = CreateFeedRequest.newBuilder()
   *     .setParent(parent)
   *     .setFeedId(feedId)
   *     .setFeed(feed)
   *     .build();
   *   ApiFuture&lt;Feed&gt; future = assetServiceClient.createFeedCallable().futureCall(request);
   *   // Do something
   *   Feed response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateFeedRequest, Feed> createFeedCallable() {
    return stub.createFeedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets details about an asset feed.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String formattedName = AssetServiceClient.formatFeedName("[PROJECT]", "[FEED]");
   *   Feed response = assetServiceClient.getFeed(formattedName);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the Feed and it must be in the format of:
   *     projects/project_number/feeds/feed_id folders/folder_number/feeds/feed_id
   *     organizations/organization_number/feeds/feed_id
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed getFeed(String name) {
    FEED_PATH_TEMPLATE.validate(name, "getFeed");
    GetFeedRequest request = GetFeedRequest.newBuilder().setName(name).build();
    return getFeed(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets details about an asset feed.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String formattedName = AssetServiceClient.formatFeedName("[PROJECT]", "[FEED]");
   *   GetFeedRequest request = GetFeedRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   Feed response = assetServiceClient.getFeed(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed getFeed(GetFeedRequest request) {
    return getFeedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets details about an asset feed.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String formattedName = AssetServiceClient.formatFeedName("[PROJECT]", "[FEED]");
   *   GetFeedRequest request = GetFeedRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Feed&gt; future = assetServiceClient.getFeedCallable().futureCall(request);
   *   // Do something
   *   Feed response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetFeedRequest, Feed> getFeedCallable() {
    return stub.getFeedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all asset feeds in a parent project/folder/organization.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String parent = "";
   *   ListFeedsResponse response = assetServiceClient.listFeeds(parent);
   * }
   * </code></pre>
   *
   * @param parent Required. The parent project/folder/organization whose feeds are to be listed. It
   *     can only be using project/folder/organization number (such as "folders/12345")", or a
   *     project ID (such as "projects/my-project-id").
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeedsResponse listFeeds(String parent) {
    ListFeedsRequest request = ListFeedsRequest.newBuilder().setParent(parent).build();
    return listFeeds(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all asset feeds in a parent project/folder/organization.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String parent = "";
   *   ListFeedsRequest request = ListFeedsRequest.newBuilder()
   *     .setParent(parent)
   *     .build();
   *   ListFeedsResponse response = assetServiceClient.listFeeds(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeedsResponse listFeeds(ListFeedsRequest request) {
    return listFeedsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Lists all asset feeds in a parent project/folder/organization.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String parent = "";
   *   ListFeedsRequest request = ListFeedsRequest.newBuilder()
   *     .setParent(parent)
   *     .build();
   *   ApiFuture&lt;ListFeedsResponse&gt; future = assetServiceClient.listFeedsCallable().futureCall(request);
   *   // Do something
   *   ListFeedsResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListFeedsRequest, ListFeedsResponse> listFeedsCallable() {
    return stub.listFeedsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an asset feed configuration.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   Feed feed = Feed.newBuilder().build();
   *   Feed response = assetServiceClient.updateFeed(feed);
   * }
   * </code></pre>
   *
   * @param feed Required. The new values of feed details. It must match an existing feed and the
   *     field `name` must be in the format of: projects/project_number/feeds/feed_id or
   *     folders/folder_number/feeds/feed_id or organizations/organization_number/feeds/feed_id.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed updateFeed(Feed feed) {
    UpdateFeedRequest request = UpdateFeedRequest.newBuilder().setFeed(feed).build();
    return updateFeed(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an asset feed configuration.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   Feed feed = Feed.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateFeedRequest request = UpdateFeedRequest.newBuilder()
   *     .setFeed(feed)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   Feed response = assetServiceClient.updateFeed(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed updateFeed(UpdateFeedRequest request) {
    return updateFeedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates an asset feed configuration.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   Feed feed = Feed.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   UpdateFeedRequest request = UpdateFeedRequest.newBuilder()
   *     .setFeed(feed)
   *     .setUpdateMask(updateMask)
   *     .build();
   *   ApiFuture&lt;Feed&gt; future = assetServiceClient.updateFeedCallable().futureCall(request);
   *   // Do something
   *   Feed response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateFeedRequest, Feed> updateFeedCallable() {
    return stub.updateFeedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes an asset feed.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String formattedName = AssetServiceClient.formatFeedName("[PROJECT]", "[FEED]");
   *   assetServiceClient.deleteFeed(formattedName);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the feed and it must be in the format of:
   *     projects/project_number/feeds/feed_id folders/folder_number/feeds/feed_id
   *     organizations/organization_number/feeds/feed_id
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteFeed(String name) {
    FEED_PATH_TEMPLATE.validate(name, "deleteFeed");
    DeleteFeedRequest request = DeleteFeedRequest.newBuilder().setName(name).build();
    deleteFeed(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes an asset feed.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String formattedName = AssetServiceClient.formatFeedName("[PROJECT]", "[FEED]");
   *   DeleteFeedRequest request = DeleteFeedRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   assetServiceClient.deleteFeed(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteFeed(DeleteFeedRequest request) {
    deleteFeedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes an asset feed.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String formattedName = AssetServiceClient.formatFeedName("[PROJECT]", "[FEED]");
   *   DeleteFeedRequest request = DeleteFeedRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = assetServiceClient.deleteFeedCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteFeedRequest, Empty> deleteFeedCallable() {
    return stub.deleteFeedCallable();
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
