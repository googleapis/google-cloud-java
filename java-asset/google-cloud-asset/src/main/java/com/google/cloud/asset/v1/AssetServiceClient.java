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
package com.google.cloud.asset.v1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.asset.v1.stub.AssetServiceStub;
import com.google.cloud.asset.v1.stub.AssetServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
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
  private final OperationsClient operationsClient;

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
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected AssetServiceClient(AssetServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final AssetServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public AssetServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Exports assets with time and resource types to a given Cloud Storage location/BigQuery table.
   * For Cloud Storage location destinations, the output format is newline-delimited JSON. Each line
   * represents a [google.cloud.asset.v1.Asset][google.cloud.asset.v1.Asset] in the JSON format; for
   * BigQuery table destinations, the output table stores the fields in asset proto as columns. This
   * API implements the [google.longrunning.Operation][google.longrunning.Operation] API , which
   * allows you to keep track of the export. We recommend intervals of at least 2 seconds with
   * exponential retry to poll the export operation result. For regular-size resource parent, the
   * export operation usually finishes within 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String parent = "";
   *   OutputConfig outputConfig = OutputConfig.newBuilder().build();
   *   ExportAssetsRequest request = ExportAssetsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setOutputConfig(outputConfig)
   *     .build();
   *   ExportAssetsResponse response = assetServiceClient.exportAssetsAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<ExportAssetsResponse, ExportAssetsRequest> exportAssetsAsync(
      ExportAssetsRequest request) {
    return exportAssetsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Exports assets with time and resource types to a given Cloud Storage location/BigQuery table.
   * For Cloud Storage location destinations, the output format is newline-delimited JSON. Each line
   * represents a [google.cloud.asset.v1.Asset][google.cloud.asset.v1.Asset] in the JSON format; for
   * BigQuery table destinations, the output table stores the fields in asset proto as columns. This
   * API implements the [google.longrunning.Operation][google.longrunning.Operation] API , which
   * allows you to keep track of the export. We recommend intervals of at least 2 seconds with
   * exponential retry to poll the export operation result. For regular-size resource parent, the
   * export operation usually finishes within 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String parent = "";
   *   OutputConfig outputConfig = OutputConfig.newBuilder().build();
   *   ExportAssetsRequest request = ExportAssetsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setOutputConfig(outputConfig)
   *     .build();
   *   OperationFuture&lt;ExportAssetsResponse, ExportAssetsRequest&gt; future = assetServiceClient.exportAssetsOperationCallable().futureCall(request);
   *   // Do something
   *   ExportAssetsResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<ExportAssetsRequest, ExportAssetsResponse, ExportAssetsRequest>
      exportAssetsOperationCallable() {
    return stub.exportAssetsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Exports assets with time and resource types to a given Cloud Storage location/BigQuery table.
   * For Cloud Storage location destinations, the output format is newline-delimited JSON. Each line
   * represents a [google.cloud.asset.v1.Asset][google.cloud.asset.v1.Asset] in the JSON format; for
   * BigQuery table destinations, the output table stores the fields in asset proto as columns. This
   * API implements the [google.longrunning.Operation][google.longrunning.Operation] API , which
   * allows you to keep track of the export. We recommend intervals of at least 2 seconds with
   * exponential retry to poll the export operation result. For regular-size resource parent, the
   * export operation usually finishes within 5 minutes.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String parent = "";
   *   OutputConfig outputConfig = OutputConfig.newBuilder().build();
   *   ExportAssetsRequest request = ExportAssetsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setOutputConfig(outputConfig)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = assetServiceClient.exportAssetsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ExportAssetsRequest, Operation> exportAssetsCallable() {
    return stub.exportAssetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Batch gets the update history of assets that overlap a time window. For IAM_POLICY content,
   * this API outputs history when the asset and its attached IAM POLICY both exist. This can create
   * gaps in the output history. Otherwise, this API outputs history with asset in both non-delete
   * or deleted status. If a specified asset does not exist, this API returns an INVALID_ARGUMENT
   * error.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String parent = "";
   *   BatchGetAssetsHistoryRequest request = BatchGetAssetsHistoryRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   BatchGetAssetsHistoryResponse response = assetServiceClient.batchGetAssetsHistory(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchGetAssetsHistoryResponse batchGetAssetsHistory(
      BatchGetAssetsHistoryRequest request) {
    return batchGetAssetsHistoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Batch gets the update history of assets that overlap a time window. For IAM_POLICY content,
   * this API outputs history when the asset and its attached IAM POLICY both exist. This can create
   * gaps in the output history. Otherwise, this API outputs history with asset in both non-delete
   * or deleted status. If a specified asset does not exist, this API returns an INVALID_ARGUMENT
   * error.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String parent = "";
   *   BatchGetAssetsHistoryRequest request = BatchGetAssetsHistoryRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;BatchGetAssetsHistoryResponse&gt; future = assetServiceClient.batchGetAssetsHistoryCallable().futureCall(request);
   *   // Do something
   *   BatchGetAssetsHistoryResponse response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<BatchGetAssetsHistoryRequest, BatchGetAssetsHistoryResponse>
      batchGetAssetsHistoryCallable() {
    return stub.batchGetAssetsHistoryCallable();
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
   *   FeedName name = FeedName.ofProjectFeedName("[PROJECT]", "[FEED]");
   *   Feed response = assetServiceClient.getFeed(name);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the Feed and it must be in the format of:
   *     projects/project_number/feeds/feed_id folders/folder_number/feeds/feed_id
   *     organizations/organization_number/feeds/feed_id
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed getFeed(FeedName name) {
    GetFeedRequest request =
        GetFeedRequest.newBuilder().setName(name == null ? null : name.toString()).build();
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
   *   FeedName name = FeedName.ofProjectFeedName("[PROJECT]", "[FEED]");
   *   Feed response = assetServiceClient.getFeed(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required. The name of the Feed and it must be in the format of:
   *     projects/project_number/feeds/feed_id folders/folder_number/feeds/feed_id
   *     organizations/organization_number/feeds/feed_id
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed getFeed(String name) {
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
   *   FeedName name = FeedName.ofProjectFeedName("[PROJECT]", "[FEED]");
   *   GetFeedRequest request = GetFeedRequest.newBuilder()
   *     .setName(name.toString())
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
   *   FeedName name = FeedName.ofProjectFeedName("[PROJECT]", "[FEED]");
   *   GetFeedRequest request = GetFeedRequest.newBuilder()
   *     .setName(name.toString())
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
   *   FeedName name = FeedName.ofProjectFeedName("[PROJECT]", "[FEED]");
   *   assetServiceClient.deleteFeed(name);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the feed and it must be in the format of:
   *     projects/project_number/feeds/feed_id folders/folder_number/feeds/feed_id
   *     organizations/organization_number/feeds/feed_id
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteFeed(FeedName name) {
    DeleteFeedRequest request =
        DeleteFeedRequest.newBuilder().setName(name == null ? null : name.toString()).build();
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
   *   FeedName name = FeedName.ofProjectFeedName("[PROJECT]", "[FEED]");
   *   assetServiceClient.deleteFeed(name.toString());
   * }
   * </code></pre>
   *
   * @param name Required. The name of the feed and it must be in the format of:
   *     projects/project_number/feeds/feed_id folders/folder_number/feeds/feed_id
   *     organizations/organization_number/feeds/feed_id
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteFeed(String name) {
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
   *   FeedName name = FeedName.ofProjectFeedName("[PROJECT]", "[FEED]");
   *   DeleteFeedRequest request = DeleteFeedRequest.newBuilder()
   *     .setName(name.toString())
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
   *   FeedName name = FeedName.ofProjectFeedName("[PROJECT]", "[FEED]");
   *   DeleteFeedRequest request = DeleteFeedRequest.newBuilder()
   *     .setName(name.toString())
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches all the resources within the given accessible scope (e.g., a project, a folder or an
   * organization). Callers should have cloud.assets.SearchAllResources permission upon the
   * requested scope, otherwise the request will be rejected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   String query = "";
   *   List&lt;String&gt; assetTypes = new ArrayList&lt;&gt;();
   *   for (ResourceSearchResult element : assetServiceClient.searchAllResources(scope, query, assetTypes).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param scope Required. A scope can be a project, a folder or an organization. The search is
   *     limited to the resources within the `scope`.
   *     <p>The allowed values are:
   *     <p>&#42; projects/{PROJECT_ID} &#42; projects/{PROJECT_NUMBER} &#42;
   *     folders/{FOLDER_NUMBER} &#42; organizations/{ORGANIZATION_NUMBER}
   * @param query Optional. The query statement. An empty query can be specified to search all the
   *     resources of certain `asset_types` within the given `scope`.
   *     <p>Examples:
   *     <p>&#42; `name : "Important"` to find Cloud resources whose name contains "Important" as a
   *     word. &#42; `displayName : "Impor&#42;"` to find Cloud resources whose display name
   *     contains "Impor" as a word prefix. &#42; `description : "&#42;por&#42;"` to find Cloud
   *     resources whose description contains "por" as a substring. &#42; `location :
   *     "us-west&#42;"` to find Cloud resources whose location is prefixed with "us-west". &#42;
   *     `labels : "prod"` to find Cloud resources whose labels contain "prod" as a key or value.
   *     &#42; `labels.env : "prod"` to find Cloud resources which have a label "env" and its value
   *     is "prod". &#42; `labels.env : &#42;` to find Cloud resources which have a label "env".
   *     &#42; `"Important"` to find Cloud resources which contain "Important" as a word in any of
   *     the searchable fields. &#42; `"Impor&#42;"` to find Cloud resources which contain "Impor"
   *     as a word prefix in any of the searchable fields. &#42; `"&#42;por&#42;"` to find Cloud
   *     resources which contain "por" as a substring in any of the searchable fields. &#42;
   *     `("Important" AND location : ("us-west1" OR "global"))` to find Cloud resources which
   *     contain "Important" as a word in any of the searchable fields and are also located in the
   *     "us-west1" region or the "global" location.
   *     <p>See [how to construct a
   *     query](https://cloud.google.com/asset-inventory/docs/searching-resources#how_to_construct_a_query)
   *     for more details.
   * @param assetTypes Optional. A list of asset types that this request searches for. If empty, it
   *     will search all the [searchable asset
   *     types](https://cloud.google.com/asset-inventory/docs/supported-asset-types#searchable_asset_types).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAllResourcesPagedResponse searchAllResources(
      String scope, String query, List<String> assetTypes) {
    SearchAllResourcesRequest request =
        SearchAllResourcesRequest.newBuilder()
            .setScope(scope)
            .setQuery(query)
            .addAllAssetTypes(assetTypes)
            .build();
    return searchAllResources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches all the resources within the given accessible scope (e.g., a project, a folder or an
   * organization). Callers should have cloud.assets.SearchAllResources permission upon the
   * requested scope, otherwise the request will be rejected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   SearchAllResourcesRequest request = SearchAllResourcesRequest.newBuilder()
   *     .setScope(scope)
   *     .build();
   *   for (ResourceSearchResult element : assetServiceClient.searchAllResources(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAllResourcesPagedResponse searchAllResources(
      SearchAllResourcesRequest request) {
    return searchAllResourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches all the resources within the given accessible scope (e.g., a project, a folder or an
   * organization). Callers should have cloud.assets.SearchAllResources permission upon the
   * requested scope, otherwise the request will be rejected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   SearchAllResourcesRequest request = SearchAllResourcesRequest.newBuilder()
   *     .setScope(scope)
   *     .build();
   *   ApiFuture&lt;SearchAllResourcesPagedResponse&gt; future = assetServiceClient.searchAllResourcesPagedCallable().futureCall(request);
   *   // Do something
   *   for (ResourceSearchResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<SearchAllResourcesRequest, SearchAllResourcesPagedResponse>
      searchAllResourcesPagedCallable() {
    return stub.searchAllResourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches all the resources within the given accessible scope (e.g., a project, a folder or an
   * organization). Callers should have cloud.assets.SearchAllResources permission upon the
   * requested scope, otherwise the request will be rejected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   SearchAllResourcesRequest request = SearchAllResourcesRequest.newBuilder()
   *     .setScope(scope)
   *     .build();
   *   while (true) {
   *     SearchAllResourcesResponse response = assetServiceClient.searchAllResourcesCallable().call(request);
   *     for (ResourceSearchResult element : response.getResultsList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<SearchAllResourcesRequest, SearchAllResourcesResponse>
      searchAllResourcesCallable() {
    return stub.searchAllResourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches all the IAM policies within the given accessible scope (e.g., a project, a folder or
   * an organization). Callers should have cloud.assets.SearchAllIamPolicies permission upon the
   * requested scope, otherwise the request will be rejected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   String query = "";
   *   for (IamPolicySearchResult element : assetServiceClient.searchAllIamPolicies(scope, query).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param scope Required. A scope can be a project, a folder or an organization. The search is
   *     limited to the IAM policies within the `scope`.
   *     <p>The allowed values are:
   *     <p>&#42; projects/{PROJECT_ID} &#42; projects/{PROJECT_NUMBER} &#42;
   *     folders/{FOLDER_NUMBER} &#42; organizations/{ORGANIZATION_NUMBER}
   * @param query Optional. The query statement. An empty query can be specified to search all the
   *     IAM policies within the given `scope`.
   *     <p>Examples:
   *     <p>&#42; `policy : "amy{@literal @}gmail.com"` to find Cloud IAM policy bindings that
   *     specify user "amy{@literal @}gmail.com". &#42; `policy : "roles/compute.admin"` to find
   *     Cloud IAM policy bindings that specify the Compute Admin role. &#42;
   *     `policy.role.permissions : "storage.buckets.update"` to find Cloud IAM policy bindings that
   *     specify a role containing "storage.buckets.update" permission. &#42; `resource :
   *     "organizations/123"` to find Cloud IAM policy bindings that are set on "organizations/123".
   *     &#42; `(resource : ("organizations/123" OR "folders/1234") AND policy : "amy")` to find
   *     Cloud IAM policy bindings that are set on "organizations/123" or "folders/1234", and also
   *     specify user "amy".
   *     <p>See [how to construct a
   *     query](https://cloud.google.com/asset-inventory/docs/searching-iam-policies#how_to_construct_a_query)
   *     for more details.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAllIamPoliciesPagedResponse searchAllIamPolicies(String scope, String query) {
    SearchAllIamPoliciesRequest request =
        SearchAllIamPoliciesRequest.newBuilder().setScope(scope).setQuery(query).build();
    return searchAllIamPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches all the IAM policies within the given accessible scope (e.g., a project, a folder or
   * an organization). Callers should have cloud.assets.SearchAllIamPolicies permission upon the
   * requested scope, otherwise the request will be rejected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   SearchAllIamPoliciesRequest request = SearchAllIamPoliciesRequest.newBuilder()
   *     .setScope(scope)
   *     .build();
   *   for (IamPolicySearchResult element : assetServiceClient.searchAllIamPolicies(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAllIamPoliciesPagedResponse searchAllIamPolicies(
      SearchAllIamPoliciesRequest request) {
    return searchAllIamPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches all the IAM policies within the given accessible scope (e.g., a project, a folder or
   * an organization). Callers should have cloud.assets.SearchAllIamPolicies permission upon the
   * requested scope, otherwise the request will be rejected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   SearchAllIamPoliciesRequest request = SearchAllIamPoliciesRequest.newBuilder()
   *     .setScope(scope)
   *     .build();
   *   ApiFuture&lt;SearchAllIamPoliciesPagedResponse&gt; future = assetServiceClient.searchAllIamPoliciesPagedCallable().futureCall(request);
   *   // Do something
   *   for (IamPolicySearchResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<SearchAllIamPoliciesRequest, SearchAllIamPoliciesPagedResponse>
      searchAllIamPoliciesPagedCallable() {
    return stub.searchAllIamPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Searches all the IAM policies within the given accessible scope (e.g., a project, a folder or
   * an organization). Callers should have cloud.assets.SearchAllIamPolicies permission upon the
   * requested scope, otherwise the request will be rejected.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (AssetServiceClient assetServiceClient = AssetServiceClient.create()) {
   *   String scope = "";
   *   SearchAllIamPoliciesRequest request = SearchAllIamPoliciesRequest.newBuilder()
   *     .setScope(scope)
   *     .build();
   *   while (true) {
   *     SearchAllIamPoliciesResponse response = assetServiceClient.searchAllIamPoliciesCallable().call(request);
   *     for (IamPolicySearchResult element : response.getResultsList()) {
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
   * </code></pre>
   */
  public final UnaryCallable<SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse>
      searchAllIamPoliciesCallable() {
    return stub.searchAllIamPoliciesCallable();
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

  public static class SearchAllResourcesPagedResponse
      extends AbstractPagedListResponse<
          SearchAllResourcesRequest,
          SearchAllResourcesResponse,
          ResourceSearchResult,
          SearchAllResourcesPage,
          SearchAllResourcesFixedSizeCollection> {

    public static ApiFuture<SearchAllResourcesPagedResponse> createAsync(
        PageContext<SearchAllResourcesRequest, SearchAllResourcesResponse, ResourceSearchResult>
            context,
        ApiFuture<SearchAllResourcesResponse> futureResponse) {
      ApiFuture<SearchAllResourcesPage> futurePage =
          SearchAllResourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<SearchAllResourcesPage, SearchAllResourcesPagedResponse>() {
            @Override
            public SearchAllResourcesPagedResponse apply(SearchAllResourcesPage input) {
              return new SearchAllResourcesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private SearchAllResourcesPagedResponse(SearchAllResourcesPage page) {
      super(page, SearchAllResourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchAllResourcesPage
      extends AbstractPage<
          SearchAllResourcesRequest,
          SearchAllResourcesResponse,
          ResourceSearchResult,
          SearchAllResourcesPage> {

    private SearchAllResourcesPage(
        PageContext<SearchAllResourcesRequest, SearchAllResourcesResponse, ResourceSearchResult>
            context,
        SearchAllResourcesResponse response) {
      super(context, response);
    }

    private static SearchAllResourcesPage createEmptyPage() {
      return new SearchAllResourcesPage(null, null);
    }

    @Override
    protected SearchAllResourcesPage createPage(
        PageContext<SearchAllResourcesRequest, SearchAllResourcesResponse, ResourceSearchResult>
            context,
        SearchAllResourcesResponse response) {
      return new SearchAllResourcesPage(context, response);
    }

    @Override
    public ApiFuture<SearchAllResourcesPage> createPageAsync(
        PageContext<SearchAllResourcesRequest, SearchAllResourcesResponse, ResourceSearchResult>
            context,
        ApiFuture<SearchAllResourcesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchAllResourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchAllResourcesRequest,
          SearchAllResourcesResponse,
          ResourceSearchResult,
          SearchAllResourcesPage,
          SearchAllResourcesFixedSizeCollection> {

    private SearchAllResourcesFixedSizeCollection(
        List<SearchAllResourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchAllResourcesFixedSizeCollection createEmptyCollection() {
      return new SearchAllResourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchAllResourcesFixedSizeCollection createCollection(
        List<SearchAllResourcesPage> pages, int collectionSize) {
      return new SearchAllResourcesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchAllIamPoliciesPagedResponse
      extends AbstractPagedListResponse<
          SearchAllIamPoliciesRequest,
          SearchAllIamPoliciesResponse,
          IamPolicySearchResult,
          SearchAllIamPoliciesPage,
          SearchAllIamPoliciesFixedSizeCollection> {

    public static ApiFuture<SearchAllIamPoliciesPagedResponse> createAsync(
        PageContext<
                SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse, IamPolicySearchResult>
            context,
        ApiFuture<SearchAllIamPoliciesResponse> futureResponse) {
      ApiFuture<SearchAllIamPoliciesPage> futurePage =
          SearchAllIamPoliciesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<SearchAllIamPoliciesPage, SearchAllIamPoliciesPagedResponse>() {
            @Override
            public SearchAllIamPoliciesPagedResponse apply(SearchAllIamPoliciesPage input) {
              return new SearchAllIamPoliciesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private SearchAllIamPoliciesPagedResponse(SearchAllIamPoliciesPage page) {
      super(page, SearchAllIamPoliciesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchAllIamPoliciesPage
      extends AbstractPage<
          SearchAllIamPoliciesRequest,
          SearchAllIamPoliciesResponse,
          IamPolicySearchResult,
          SearchAllIamPoliciesPage> {

    private SearchAllIamPoliciesPage(
        PageContext<
                SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse, IamPolicySearchResult>
            context,
        SearchAllIamPoliciesResponse response) {
      super(context, response);
    }

    private static SearchAllIamPoliciesPage createEmptyPage() {
      return new SearchAllIamPoliciesPage(null, null);
    }

    @Override
    protected SearchAllIamPoliciesPage createPage(
        PageContext<
                SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse, IamPolicySearchResult>
            context,
        SearchAllIamPoliciesResponse response) {
      return new SearchAllIamPoliciesPage(context, response);
    }

    @Override
    public ApiFuture<SearchAllIamPoliciesPage> createPageAsync(
        PageContext<
                SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse, IamPolicySearchResult>
            context,
        ApiFuture<SearchAllIamPoliciesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchAllIamPoliciesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchAllIamPoliciesRequest,
          SearchAllIamPoliciesResponse,
          IamPolicySearchResult,
          SearchAllIamPoliciesPage,
          SearchAllIamPoliciesFixedSizeCollection> {

    private SearchAllIamPoliciesFixedSizeCollection(
        List<SearchAllIamPoliciesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchAllIamPoliciesFixedSizeCollection createEmptyCollection() {
      return new SearchAllIamPoliciesFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchAllIamPoliciesFixedSizeCollection createCollection(
        List<SearchAllIamPoliciesPage> pages, int collectionSize) {
      return new SearchAllIamPoliciesFixedSizeCollection(pages, collectionSize);
    }
  }
}
