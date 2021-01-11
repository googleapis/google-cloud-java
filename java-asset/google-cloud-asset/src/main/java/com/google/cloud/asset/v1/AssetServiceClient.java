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

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Asset service definition.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the AssetServiceClient object to clean up resources such
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
 * <pre>{@code
 * AssetServiceSettings assetServiceSettings =
 *     AssetServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * AssetServiceClient assetServiceClient = AssetServiceClient.create(assetServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * AssetServiceSettings assetServiceSettings =
 *     AssetServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * AssetServiceClient assetServiceClient = AssetServiceClient.create(assetServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
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
   * for advanced usage - prefer using create(AssetServiceSettings).
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
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
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
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<ExportAssetsResponse, ExportAssetsRequest> exportAssetsAsync(
      ExportAssetsRequest request) {
    return exportAssetsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
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
   */
  public final OperationCallable<ExportAssetsRequest, ExportAssetsResponse, ExportAssetsRequest>
      exportAssetsOperationCallable() {
    return stub.exportAssetsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
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
   */
  public final UnaryCallable<ExportAssetsRequest, Operation> exportAssetsCallable() {
    return stub.exportAssetsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch gets the update history of assets that overlap a time window. For IAM_POLICY content,
   * this API outputs history when the asset and its attached IAM POLICY both exist. This can create
   * gaps in the output history. Otherwise, this API outputs history with asset in both non-delete
   * or deleted status. If a specified asset does not exist, this API returns an INVALID_ARGUMENT
   * error.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchGetAssetsHistoryResponse batchGetAssetsHistory(
      BatchGetAssetsHistoryRequest request) {
    return batchGetAssetsHistoryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch gets the update history of assets that overlap a time window. For IAM_POLICY content,
   * this API outputs history when the asset and its attached IAM POLICY both exist. This can create
   * gaps in the output history. Otherwise, this API outputs history with asset in both non-delete
   * or deleted status. If a specified asset does not exist, this API returns an INVALID_ARGUMENT
   * error.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<BatchGetAssetsHistoryRequest, BatchGetAssetsHistoryResponse>
      batchGetAssetsHistoryCallable() {
    return stub.batchGetAssetsHistoryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a feed in a parent project/folder/organization to listen to its asset updates.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a feed in a parent project/folder/organization to listen to its asset updates.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed createFeed(CreateFeedRequest request) {
    return createFeedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a feed in a parent project/folder/organization to listen to its asset updates.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateFeedRequest, Feed> createFeedCallable() {
    return stub.createFeedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about an asset feed.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about an asset feed.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about an asset feed.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed getFeed(GetFeedRequest request) {
    return getFeedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets details about an asset feed.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetFeedRequest, Feed> getFeedCallable() {
    return stub.getFeedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all asset feeds in a parent project/folder/organization.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all asset feeds in a parent project/folder/organization.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeedsResponse listFeeds(ListFeedsRequest request) {
    return listFeedsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all asset feeds in a parent project/folder/organization.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListFeedsRequest, ListFeedsResponse> listFeedsCallable() {
    return stub.listFeedsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an asset feed configuration.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an asset feed configuration.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed updateFeed(UpdateFeedRequest request) {
    return updateFeedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an asset feed configuration.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateFeedRequest, Feed> updateFeedCallable() {
    return stub.updateFeedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an asset feed.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an asset feed.
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an asset feed.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteFeed(DeleteFeedRequest request) {
    deleteFeedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an asset feed.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteFeedRequest, Empty> deleteFeedCallable() {
    return stub.deleteFeedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches all Cloud resources within the specified scope, such as a project, folder, or
   * organization. The caller must be granted the `cloudasset.assets.searchAllResources` permission
   * on the desired scope, otherwise the request will be rejected.
   *
   * @param scope Required. A scope can be a project, a folder, or an organization. The search is
   *     limited to the resources within the `scope`. The caller must be granted the
   *     [`cloudasset.assets.searchAllResources`](http://cloud.google.com/asset-inventory/docs/access-control#required_permissions)
   *     permission on the desired scope.
   *     <p>The allowed values are:
   *     <ul>
   *       <li>projects/{PROJECT_ID} (e.g., "projects/foo-bar")
   *       <li>projects/{PROJECT_NUMBER} (e.g., "projects/12345678")
   *       <li>folders/{FOLDER_NUMBER} (e.g., "folders/1234567")
   *       <li>organizations/{ORGANIZATION_NUMBER} (e.g., "organizations/123456")
   *     </ul>
   *
   * @param query Optional. The query statement. See [how to construct a
   *     query](http://cloud.google.com/asset-inventory/docs/searching-resources#how_to_construct_a_query)
   *     for more information. If not specified or empty, it will search all the resources within
   *     the specified `scope`. Note that the query string is compared against each Cloud IAM policy
   *     binding, including its members, roles, and Cloud IAM conditions. The returned Cloud IAM
   *     policies will only contain the bindings that match your query. To learn more about the IAM
   *     policy structure, see [IAM policy
   *     doc](https://cloud.google.com/iam/docs/policies#structure).
   *     <p>Examples:
   *     <ul>
   *       <li>`name:Important` to find Cloud resources whose name contains "Important" as a word.
   *       <li>`displayName:Impor&#42;` to find Cloud resources whose display name contains "Impor"
   *           as a prefix.
   *       <li>`description:&#42;por&#42;` to find Cloud resources whose description contains "por"
   *           as a substring.
   *       <li>`location:us-west&#42;` to find Cloud resources whose location is prefixed with
   *           "us-west".
   *       <li>`labels:prod` to find Cloud resources whose labels contain "prod" as a key or value.
   *       <li>`labels.env:prod` to find Cloud resources that have a label "env" and its value is
   *           "prod".
   *       <li>`labels.env:&#42;` to find Cloud resources that have a label "env".
   *       <li>`Important` to find Cloud resources that contain "Important" as a word in any of the
   *           searchable fields.
   *       <li>`Impor&#42;` to find Cloud resources that contain "Impor" as a prefix in any of the
   *           searchable fields.
   *       <li>`&#42;por&#42;` to find Cloud resources that contain "por" as a substring in any of
   *           the searchable fields.
   *       <li>`Important location:(us-west1 OR global)` to find Cloud resources that contain
   *           "Important" as a word in any of the searchable fields and are also located in the
   *           "us-west1" region or the "global" location.
   *     </ul>
   *
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches all Cloud resources within the specified scope, such as a project, folder, or
   * organization. The caller must be granted the `cloudasset.assets.searchAllResources` permission
   * on the desired scope, otherwise the request will be rejected.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAllResourcesPagedResponse searchAllResources(
      SearchAllResourcesRequest request) {
    return searchAllResourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches all Cloud resources within the specified scope, such as a project, folder, or
   * organization. The caller must be granted the `cloudasset.assets.searchAllResources` permission
   * on the desired scope, otherwise the request will be rejected.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SearchAllResourcesRequest, SearchAllResourcesPagedResponse>
      searchAllResourcesPagedCallable() {
    return stub.searchAllResourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches all Cloud resources within the specified scope, such as a project, folder, or
   * organization. The caller must be granted the `cloudasset.assets.searchAllResources` permission
   * on the desired scope, otherwise the request will be rejected.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SearchAllResourcesRequest, SearchAllResourcesResponse>
      searchAllResourcesCallable() {
    return stub.searchAllResourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches all IAM policies within the specified scope, such as a project, folder, or
   * organization. The caller must be granted the `cloudasset.assets.searchAllIamPolicies`
   * permission on the desired scope, otherwise the request will be rejected.
   *
   * @param scope Required. A scope can be a project, a folder, or an organization. The search is
   *     limited to the IAM policies within the `scope`. The caller must be granted the
   *     [`cloudasset.assets.searchAllIamPolicies`](http://cloud.google.com/asset-inventory/docs/access-control#required_permissions)
   *     permission on the desired scope.
   *     <p>The allowed values are:
   *     <ul>
   *       <li>projects/{PROJECT_ID} (e.g., "projects/foo-bar")
   *       <li>projects/{PROJECT_NUMBER} (e.g., "projects/12345678")
   *       <li>folders/{FOLDER_NUMBER} (e.g., "folders/1234567")
   *       <li>organizations/{ORGANIZATION_NUMBER} (e.g., "organizations/123456")
   *     </ul>
   *
   * @param query Optional. The query statement. See [how to construct a
   *     query](https://cloud.google.com/asset-inventory/docs/searching-iam-policies#how_to_construct_a_query)
   *     for more information. If not specified or empty, it will search all the IAM policies within
   *     the specified `scope`.
   *     <p>Examples:
   *     <ul>
   *       <li>`policy:amy{@literal @}gmail.com` to find IAM policy bindings that specify user
   *           "amy{@literal @}gmail.com".
   *       <li>`policy:roles/compute.admin` to find IAM policy bindings that specify the Compute
   *           Admin role.
   *       <li>`policy.role.permissions:storage.buckets.update` to find IAM policy bindings that
   *           specify a role containing "storage.buckets.update" permission. Note that if callers
   *           don't have `iam.roles.get` access to a role's included permissions, policy bindings
   *           that specify this role will be dropped from the search results.
   *       <li>`resource:organizations/123456` to find IAM policy bindings that are set on
   *           "organizations/123456".
   *       <li>`Important` to find IAM policy bindings that contain "Important" as a word in any of
   *           the searchable fields (except for the included permissions).
   *       <li>`&#42;por&#42;` to find IAM policy bindings that contain "por" as a substring in any
   *           of the searchable fields (except for the included permissions).
   *       <li>`resource:(instance1 OR instance2) policy:amy` to find IAM policy bindings that are
   *           set on resources "instance1" or "instance2" and also specify user "amy".
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAllIamPoliciesPagedResponse searchAllIamPolicies(String scope, String query) {
    SearchAllIamPoliciesRequest request =
        SearchAllIamPoliciesRequest.newBuilder().setScope(scope).setQuery(query).build();
    return searchAllIamPolicies(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches all IAM policies within the specified scope, such as a project, folder, or
   * organization. The caller must be granted the `cloudasset.assets.searchAllIamPolicies`
   * permission on the desired scope, otherwise the request will be rejected.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchAllIamPoliciesPagedResponse searchAllIamPolicies(
      SearchAllIamPoliciesRequest request) {
    return searchAllIamPoliciesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches all IAM policies within the specified scope, such as a project, folder, or
   * organization. The caller must be granted the `cloudasset.assets.searchAllIamPolicies`
   * permission on the desired scope, otherwise the request will be rejected.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SearchAllIamPoliciesRequest, SearchAllIamPoliciesPagedResponse>
      searchAllIamPoliciesPagedCallable() {
    return stub.searchAllIamPoliciesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches all IAM policies within the specified scope, such as a project, folder, or
   * organization. The caller must be granted the `cloudasset.assets.searchAllIamPolicies`
   * permission on the desired scope, otherwise the request will be rejected.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<SearchAllIamPoliciesRequest, SearchAllIamPoliciesResponse>
      searchAllIamPoliciesCallable() {
    return stub.searchAllIamPoliciesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyzes IAM policies to answer which identities have what accesses on which resources.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final AnalyzeIamPolicyResponse analyzeIamPolicy(AnalyzeIamPolicyRequest request) {
    return analyzeIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyzes IAM policies to answer which identities have what accesses on which resources.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<AnalyzeIamPolicyRequest, AnalyzeIamPolicyResponse>
      analyzeIamPolicyCallable() {
    return stub.analyzeIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyzes IAM policies asynchronously to answer which identities have what accesses on which
   * resources, and writes the analysis results to a Google Cloud Storage or a BigQuery destination.
   * For Cloud Storage destination, the output format is the JSON format that represents a
   * [AnalyzeIamPolicyResponse][google.cloud.asset.v1.AnalyzeIamPolicyResponse]. This method
   * implements the [google.longrunning.Operation][google.longrunning.Operation], which allows you
   * to track the operation status. We recommend intervals of at least 2 seconds with exponential
   * backoff retry to poll the operation result. The metadata contains the request to help callers
   * to map responses to requests.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<
          AnalyzeIamPolicyLongrunningResponse, AnalyzeIamPolicyLongrunningRequest>
      analyzeIamPolicyLongrunningAsync(AnalyzeIamPolicyLongrunningRequest request) {
    return analyzeIamPolicyLongrunningOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyzes IAM policies asynchronously to answer which identities have what accesses on which
   * resources, and writes the analysis results to a Google Cloud Storage or a BigQuery destination.
   * For Cloud Storage destination, the output format is the JSON format that represents a
   * [AnalyzeIamPolicyResponse][google.cloud.asset.v1.AnalyzeIamPolicyResponse]. This method
   * implements the [google.longrunning.Operation][google.longrunning.Operation], which allows you
   * to track the operation status. We recommend intervals of at least 2 seconds with exponential
   * backoff retry to poll the operation result. The metadata contains the request to help callers
   * to map responses to requests.
   *
   * <p>Sample code:
   */
  public final OperationCallable<
          AnalyzeIamPolicyLongrunningRequest,
          AnalyzeIamPolicyLongrunningResponse,
          AnalyzeIamPolicyLongrunningRequest>
      analyzeIamPolicyLongrunningOperationCallable() {
    return stub.analyzeIamPolicyLongrunningOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Analyzes IAM policies asynchronously to answer which identities have what accesses on which
   * resources, and writes the analysis results to a Google Cloud Storage or a BigQuery destination.
   * For Cloud Storage destination, the output format is the JSON format that represents a
   * [AnalyzeIamPolicyResponse][google.cloud.asset.v1.AnalyzeIamPolicyResponse]. This method
   * implements the [google.longrunning.Operation][google.longrunning.Operation], which allows you
   * to track the operation status. We recommend intervals of at least 2 seconds with exponential
   * backoff retry to poll the operation result. The metadata contains the request to help callers
   * to map responses to requests.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<AnalyzeIamPolicyLongrunningRequest, Operation>
      analyzeIamPolicyLongrunningCallable() {
    return stub.analyzeIamPolicyLongrunningCallable();
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
