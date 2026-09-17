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

package com.google.cloud.chronicle.v1;

import com.google.api.HttpBody;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.stub.FeedsServiceStub;
import com.google.cloud.chronicle.v1.stub.FeedsServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: FeedsService contains procedures for managing Chronicle third-party feeds.
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
 * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
 *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   FeedServiceAccount response = feedsServiceClient.fetchServiceAccountForCustomer(parent);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the FeedsServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> FetchServiceAccountForCustomer</td>
 *      <td><p> Fetch Chronicle's service account used for ingesting data from Cloud Storage buckets.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchServiceAccountForCustomer(FetchServiceAccountForCustomerRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> fetchServiceAccountForCustomer(InstanceName parent)
 *           <li><p> fetchServiceAccountForCustomer(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchServiceAccountForCustomerCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateFeed</td>
 *      <td><p> Creates a feed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createFeed(CreateFeedRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createFeed(InstanceName parent, Feed feed)
 *           <li><p> createFeed(String parent, Feed feed)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createFeedCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetFeed</td>
 *      <td><p> Gets a feed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getFeed(GetFeedRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getFeed(FeedName name)
 *           <li><p> getFeed(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getFeedCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteFeed</td>
 *      <td><p> Deletes a feed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteFeed(DeleteFeedRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteFeed(FeedName name)
 *           <li><p> deleteFeed(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteFeedCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> EnableFeed</td>
 *      <td><p> Enable feed for ingestion.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> enableFeed(EnableFeedRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> enableFeed(FeedName name)
 *           <li><p> enableFeed(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> enableFeedCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DisableFeed</td>
 *      <td><p> Disable feed for ingestion. Make FeedState ARCHIVED.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> disableFeed(DisableFeedRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> disableFeed(FeedName name)
 *           <li><p> disableFeed(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> disableFeedCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListFeeds</td>
 *      <td><p> Lists all feeds for the customer.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listFeeds(ListFeedsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listFeeds(InstanceName parent)
 *           <li><p> listFeeds(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listFeedsPagedCallable()
 *           <li><p> listFeedsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListFeedPacks</td>
 *      <td><p> Lists Packs for which feeds can be configured.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listFeedPacks(ListFeedPacksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listFeedPacks(InstanceName parent)
 *           <li><p> listFeedPacks(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listFeedPacksPagedCallable()
 *           <li><p> listFeedPacksCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetFeedPack</td>
 *      <td><p> Gets a feed pack.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getFeedPack(GetFeedPackRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getFeedPack(FeedPackName name)
 *           <li><p> getFeedPack(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getFeedPackCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateFeed</td>
 *      <td><p> Updates the full feed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateFeed(UpdateFeedRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateFeed(Feed feed, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateFeedCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListFeedSourceTypeSchemas</td>
 *      <td><p> List all FeedSourceTypeSchemas.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listFeedSourceTypeSchemas(ListFeedSourceTypeSchemasRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listFeedSourceTypeSchemas(InstanceName parent)
 *           <li><p> listFeedSourceTypeSchemas(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listFeedSourceTypeSchemasPagedCallable()
 *           <li><p> listFeedSourceTypeSchemasCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLogTypeSchemas</td>
 *      <td><p> List all LogTypeSchemas compatible with a given FeedSourceType.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLogTypeSchemas(ListLogTypeSchemasRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLogTypeSchemas(FeedSourceTypeSchemaName parent)
 *           <li><p> listLogTypeSchemas(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLogTypeSchemasPagedCallable()
 *           <li><p> listLogTypeSchemasCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ImportPushLogs</td>
 *      <td><p> Import logs coming from https push feeds. All log entries must be valid UTF-8. A single invalid event will cause the entire request to be rejected.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> importPushLogs(ImportPushLogsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> importPushLogs(FeedName parent)
 *           <li><p> importPushLogs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> importPushLogsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GenerateSecret</td>
 *      <td><p> Generates a new secret for https push feeds which do not support jwt tokens. Secrets once generated should be copied and stored in safe place to be used while configuring https push feeds.Please note that you can always generate a new secret again for a feed using this API but it will invalidate the previously generated secret for the feed.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> generateSecret(GenerateSecretRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> generateSecret(FeedName name)
 *           <li><p> generateSecret(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> generateSecretCallable()
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
 * <p>This class can be customized by passing in a custom instance of FeedsServiceSettings to
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
 * FeedsServiceSettings feedsServiceSettings =
 *     FeedsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * FeedsServiceClient feedsServiceClient = FeedsServiceClient.create(feedsServiceSettings);
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
 * FeedsServiceSettings feedsServiceSettings =
 *     FeedsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * FeedsServiceClient feedsServiceClient = FeedsServiceClient.create(feedsServiceSettings);
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
 * FeedsServiceSettings feedsServiceSettings = FeedsServiceSettings.newHttpJsonBuilder().build();
 * FeedsServiceClient feedsServiceClient = FeedsServiceClient.create(feedsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class FeedsServiceClient implements BackgroundResource {
  private final @Nullable FeedsServiceSettings settings;
  private final FeedsServiceStub stub;

  /** Constructs an instance of FeedsServiceClient with default settings. */
  public static final FeedsServiceClient create() throws IOException {
    return create(FeedsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of FeedsServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final FeedsServiceClient create(FeedsServiceSettings settings) throws IOException {
    return new FeedsServiceClient(settings);
  }

  /**
   * Constructs an instance of FeedsServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(FeedsServiceSettings).
   */
  public static final FeedsServiceClient create(FeedsServiceStub stub) {
    return new FeedsServiceClient(stub);
  }

  /**
   * Constructs an instance of FeedsServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected FeedsServiceClient(FeedsServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((FeedsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected FeedsServiceClient(FeedsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable FeedsServiceSettings getSettings() {
    return settings;
  }

  public FeedsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch Chronicle's service account used for ingesting data from Cloud Storage buckets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   FeedServiceAccount response = feedsServiceClient.fetchServiceAccountForCustomer(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this FeedServiceAccount will be created.
   *     Format: projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeedServiceAccount fetchServiceAccountForCustomer(@Nullable InstanceName parent) {
    FetchServiceAccountForCustomerRequest request =
        FetchServiceAccountForCustomerRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return fetchServiceAccountForCustomer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch Chronicle's service account used for ingesting data from Cloud Storage buckets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   FeedServiceAccount response = feedsServiceClient.fetchServiceAccountForCustomer(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this FeedServiceAccount will be created.
   *     Format: projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeedServiceAccount fetchServiceAccountForCustomer(String parent) {
    FetchServiceAccountForCustomerRequest request =
        FetchServiceAccountForCustomerRequest.newBuilder().setParent(parent).build();
    return fetchServiceAccountForCustomer(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch Chronicle's service account used for ingesting data from Cloud Storage buckets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   FetchServiceAccountForCustomerRequest request =
   *       FetchServiceAccountForCustomerRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   FeedServiceAccount response = feedsServiceClient.fetchServiceAccountForCustomer(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeedServiceAccount fetchServiceAccountForCustomer(
      FetchServiceAccountForCustomerRequest request) {
    return fetchServiceAccountForCustomerCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Fetch Chronicle's service account used for ingesting data from Cloud Storage buckets.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   FetchServiceAccountForCustomerRequest request =
   *       FetchServiceAccountForCustomerRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .build();
   *   ApiFuture<FeedServiceAccount> future =
   *       feedsServiceClient.fetchServiceAccountForCustomerCallable().futureCall(request);
   *   // Do something.
   *   FeedServiceAccount response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchServiceAccountForCustomerRequest, FeedServiceAccount>
      fetchServiceAccountForCustomerCallable() {
    return stub.fetchServiceAccountForCustomerCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a feed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   Feed feed = Feed.newBuilder().build();
   *   Feed response = feedsServiceClient.createFeed(parent, feed);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this Feed will be created. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @param feed Required. Feed to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed createFeed(@Nullable InstanceName parent, Feed feed) {
    CreateFeedRequest request =
        CreateFeedRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setFeed(feed)
            .build();
    return createFeed(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a feed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   Feed feed = Feed.newBuilder().build();
   *   Feed response = feedsServiceClient.createFeed(parent, feed);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this Feed will be created. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @param feed Required. Feed to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed createFeed(String parent, Feed feed) {
    CreateFeedRequest request =
        CreateFeedRequest.newBuilder().setParent(parent).setFeed(feed).build();
    return createFeed(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a feed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   CreateFeedRequest request =
   *       CreateFeedRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setFeed(Feed.newBuilder().build())
   *           .build();
   *   Feed response = feedsServiceClient.createFeed(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed createFeed(CreateFeedRequest request) {
    return createFeedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a feed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   CreateFeedRequest request =
   *       CreateFeedRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setFeed(Feed.newBuilder().build())
   *           .build();
   *   ApiFuture<Feed> future = feedsServiceClient.createFeedCallable().futureCall(request);
   *   // Do something.
   *   Feed response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateFeedRequest, Feed> createFeedCallable() {
    return stub.createFeedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a feed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   FeedName name = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]");
   *   Feed response = feedsServiceClient.getFeed(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the feed to retrieve. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/feeds/{feed}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed getFeed(@Nullable FeedName name) {
    GetFeedRequest request =
        GetFeedRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getFeed(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a feed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   String name = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString();
   *   Feed response = feedsServiceClient.getFeed(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the feed to retrieve. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/feeds/{feed}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed getFeed(String name) {
    GetFeedRequest request = GetFeedRequest.newBuilder().setName(name).build();
    return getFeed(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a feed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   GetFeedRequest request =
   *       GetFeedRequest.newBuilder()
   *           .setName(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
   *           .build();
   *   Feed response = feedsServiceClient.getFeed(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed getFeed(GetFeedRequest request) {
    return getFeedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a feed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   GetFeedRequest request =
   *       GetFeedRequest.newBuilder()
   *           .setName(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
   *           .build();
   *   ApiFuture<Feed> future = feedsServiceClient.getFeedCallable().futureCall(request);
   *   // Do something.
   *   Feed response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFeedRequest, Feed> getFeedCallable() {
    return stub.getFeedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a feed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   FeedName name = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]");
   *   feedsServiceClient.deleteFeed(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the feed to retrieve. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/feeds/{feed}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteFeed(@Nullable FeedName name) {
    DeleteFeedRequest request =
        DeleteFeedRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteFeed(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a feed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   String name = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString();
   *   feedsServiceClient.deleteFeed(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the feed to retrieve. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/feeds/{feed}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteFeed(String name) {
    DeleteFeedRequest request = DeleteFeedRequest.newBuilder().setName(name).build();
    deleteFeed(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a feed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   DeleteFeedRequest request =
   *       DeleteFeedRequest.newBuilder()
   *           .setName(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
   *           .setDeleteBacklog(true)
   *           .build();
   *   feedsServiceClient.deleteFeed(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteFeed(DeleteFeedRequest request) {
    deleteFeedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a feed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   DeleteFeedRequest request =
   *       DeleteFeedRequest.newBuilder()
   *           .setName(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
   *           .setDeleteBacklog(true)
   *           .build();
   *   ApiFuture<Empty> future = feedsServiceClient.deleteFeedCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteFeedRequest, Empty> deleteFeedCallable() {
    return stub.deleteFeedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable feed for ingestion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   FeedName name = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]");
   *   Feed response = feedsServiceClient.enableFeed(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the feed to enable. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/feeds/{feed}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed enableFeed(@Nullable FeedName name) {
    EnableFeedRequest request =
        EnableFeedRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return enableFeed(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable feed for ingestion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   String name = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString();
   *   Feed response = feedsServiceClient.enableFeed(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the feed to enable. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/feeds/{feed}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed enableFeed(String name) {
    EnableFeedRequest request = EnableFeedRequest.newBuilder().setName(name).build();
    return enableFeed(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable feed for ingestion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   EnableFeedRequest request =
   *       EnableFeedRequest.newBuilder()
   *           .setName(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
   *           .build();
   *   Feed response = feedsServiceClient.enableFeed(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed enableFeed(EnableFeedRequest request) {
    return enableFeedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Enable feed for ingestion.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   EnableFeedRequest request =
   *       EnableFeedRequest.newBuilder()
   *           .setName(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
   *           .build();
   *   ApiFuture<Feed> future = feedsServiceClient.enableFeedCallable().futureCall(request);
   *   // Do something.
   *   Feed response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<EnableFeedRequest, Feed> enableFeedCallable() {
    return stub.enableFeedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable feed for ingestion. Make FeedState ARCHIVED.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   FeedName name = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]");
   *   Feed response = feedsServiceClient.disableFeed(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the feed to disable. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/feeds/{feed}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed disableFeed(@Nullable FeedName name) {
    DisableFeedRequest request =
        DisableFeedRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return disableFeed(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable feed for ingestion. Make FeedState ARCHIVED.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   String name = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString();
   *   Feed response = feedsServiceClient.disableFeed(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the feed to disable. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/feeds/{feed}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed disableFeed(String name) {
    DisableFeedRequest request = DisableFeedRequest.newBuilder().setName(name).build();
    return disableFeed(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable feed for ingestion. Make FeedState ARCHIVED.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   DisableFeedRequest request =
   *       DisableFeedRequest.newBuilder()
   *           .setName(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
   *           .build();
   *   Feed response = feedsServiceClient.disableFeed(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed disableFeed(DisableFeedRequest request) {
    return disableFeedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Disable feed for ingestion. Make FeedState ARCHIVED.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   DisableFeedRequest request =
   *       DisableFeedRequest.newBuilder()
   *           .setName(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
   *           .build();
   *   ApiFuture<Feed> future = feedsServiceClient.disableFeedCallable().futureCall(request);
   *   // Do something.
   *   Feed response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DisableFeedRequest, Feed> disableFeedCallable() {
    return stub.disableFeedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all feeds for the customer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (Feed element : feedsServiceClient.listFeeds(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this Feed will be created. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeedsPagedResponse listFeeds(@Nullable InstanceName parent) {
    ListFeedsRequest request =
        ListFeedsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listFeeds(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all feeds for the customer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (Feed element : feedsServiceClient.listFeeds(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this Feed will be created. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeedsPagedResponse listFeeds(String parent) {
    ListFeedsRequest request = ListFeedsRequest.newBuilder().setParent(parent).build();
    return listFeeds(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all feeds for the customer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   ListFeedsRequest request =
   *       ListFeedsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Feed element : feedsServiceClient.listFeeds(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeedsPagedResponse listFeeds(ListFeedsRequest request) {
    return listFeedsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all feeds for the customer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   ListFeedsRequest request =
   *       ListFeedsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Feed> future = feedsServiceClient.listFeedsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Feed element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFeedsRequest, ListFeedsPagedResponse> listFeedsPagedCallable() {
    return stub.listFeedsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists all feeds for the customer.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   ListFeedsRequest request =
   *       ListFeedsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListFeedsResponse response = feedsServiceClient.listFeedsCallable().call(request);
   *     for (Feed element : response.getFeedsList()) {
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
  public final UnaryCallable<ListFeedsRequest, ListFeedsResponse> listFeedsCallable() {
    return stub.listFeedsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Packs for which feeds can be configured.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (FeedPack element : feedsServiceClient.listFeedPacks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this content pack will be created. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeedPacksPagedResponse listFeedPacks(@Nullable InstanceName parent) {
    ListFeedPacksRequest request =
        ListFeedPacksRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFeedPacks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Packs for which feeds can be configured.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (FeedPack element : feedsServiceClient.listFeedPacks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this content pack will be created. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeedPacksPagedResponse listFeedPacks(String parent) {
    ListFeedPacksRequest request = ListFeedPacksRequest.newBuilder().setParent(parent).build();
    return listFeedPacks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Packs for which feeds can be configured.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   ListFeedPacksRequest request =
   *       ListFeedPacksRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (FeedPack element : feedsServiceClient.listFeedPacks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeedPacksPagedResponse listFeedPacks(ListFeedPacksRequest request) {
    return listFeedPacksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Packs for which feeds can be configured.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   ListFeedPacksRequest request =
   *       ListFeedPacksRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<FeedPack> future =
   *       feedsServiceClient.listFeedPacksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (FeedPack element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFeedPacksRequest, ListFeedPacksPagedResponse>
      listFeedPacksPagedCallable() {
    return stub.listFeedPacksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists Packs for which feeds can be configured.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   ListFeedPacksRequest request =
   *       ListFeedPacksRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListFeedPacksResponse response = feedsServiceClient.listFeedPacksCallable().call(request);
   *     for (FeedPack element : response.getFeedPacksList()) {
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
  public final UnaryCallable<ListFeedPacksRequest, ListFeedPacksResponse> listFeedPacksCallable() {
    return stub.listFeedPacksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a feed pack.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   FeedPackName name = FeedPackName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED_PACK]");
   *   FeedPack response = feedsServiceClient.getFeedPack(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the feed pack to retrieve. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/feedPacks/{feedPack}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeedPack getFeedPack(@Nullable FeedPackName name) {
    GetFeedPackRequest request =
        GetFeedPackRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getFeedPack(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a feed pack.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   String name =
   *       FeedPackName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED_PACK]").toString();
   *   FeedPack response = feedsServiceClient.getFeedPack(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the feed pack to retrieve. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/feedPacks/{feedPack}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeedPack getFeedPack(String name) {
    GetFeedPackRequest request = GetFeedPackRequest.newBuilder().setName(name).build();
    return getFeedPack(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a feed pack.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   GetFeedPackRequest request =
   *       GetFeedPackRequest.newBuilder()
   *           .setName(
   *               FeedPackName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED_PACK]")
   *                   .toString())
   *           .build();
   *   FeedPack response = feedsServiceClient.getFeedPack(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeedPack getFeedPack(GetFeedPackRequest request) {
    return getFeedPackCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a feed pack.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   GetFeedPackRequest request =
   *       GetFeedPackRequest.newBuilder()
   *           .setName(
   *               FeedPackName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED_PACK]")
   *                   .toString())
   *           .build();
   *   ApiFuture<FeedPack> future = feedsServiceClient.getFeedPackCallable().futureCall(request);
   *   // Do something.
   *   FeedPack response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFeedPackRequest, FeedPack> getFeedPackCallable() {
    return stub.getFeedPackCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the full feed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   Feed feed = Feed.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Feed response = feedsServiceClient.updateFeed(feed, updateMask);
   * }
   * }</pre>
   *
   * @param feed Required. Feed to update. Updates full feed object.
   * @param updateMask Optional. Specifies which fields to update. If empty, update the full feed.
   *     To update the display name, pass only `displayName` and no other fields. To update other
   *     fields, pass a comma-separated list of fields to update and omit `displayName`. The update
   *     fails if an existing `displayName` is sent in the update request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed updateFeed(Feed feed, FieldMask updateMask) {
    UpdateFeedRequest request =
        UpdateFeedRequest.newBuilder().setFeed(feed).setUpdateMask(updateMask).build();
    return updateFeed(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the full feed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   UpdateFeedRequest request =
   *       UpdateFeedRequest.newBuilder()
   *           .setFeed(Feed.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Feed response = feedsServiceClient.updateFeed(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Feed updateFeed(UpdateFeedRequest request) {
    return updateFeedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the full feed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   UpdateFeedRequest request =
   *       UpdateFeedRequest.newBuilder()
   *           .setFeed(Feed.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Feed> future = feedsServiceClient.updateFeedCallable().futureCall(request);
   *   // Do something.
   *   Feed response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateFeedRequest, Feed> updateFeedCallable() {
    return stub.updateFeedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all FeedSourceTypeSchemas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (FeedSourceTypeSchema element :
   *       feedsServiceClient.listFeedSourceTypeSchemas(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of FeedSourceTypeSchemas.
   *     Format: projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeedSourceTypeSchemasPagedResponse listFeedSourceTypeSchemas(
      @Nullable InstanceName parent) {
    ListFeedSourceTypeSchemasRequest request =
        ListFeedSourceTypeSchemasRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFeedSourceTypeSchemas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all FeedSourceTypeSchemas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (FeedSourceTypeSchema element :
   *       feedsServiceClient.listFeedSourceTypeSchemas(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of FeedSourceTypeSchemas.
   *     Format: projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeedSourceTypeSchemasPagedResponse listFeedSourceTypeSchemas(String parent) {
    ListFeedSourceTypeSchemasRequest request =
        ListFeedSourceTypeSchemasRequest.newBuilder().setParent(parent).build();
    return listFeedSourceTypeSchemas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all FeedSourceTypeSchemas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   ListFeedSourceTypeSchemasRequest request =
   *       ListFeedSourceTypeSchemasRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (FeedSourceTypeSchema element :
   *       feedsServiceClient.listFeedSourceTypeSchemas(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeedSourceTypeSchemasPagedResponse listFeedSourceTypeSchemas(
      ListFeedSourceTypeSchemasRequest request) {
    return listFeedSourceTypeSchemasPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all FeedSourceTypeSchemas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   ListFeedSourceTypeSchemasRequest request =
   *       ListFeedSourceTypeSchemasRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<FeedSourceTypeSchema> future =
   *       feedsServiceClient.listFeedSourceTypeSchemasPagedCallable().futureCall(request);
   *   // Do something.
   *   for (FeedSourceTypeSchema element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListFeedSourceTypeSchemasRequest, ListFeedSourceTypeSchemasPagedResponse>
      listFeedSourceTypeSchemasPagedCallable() {
    return stub.listFeedSourceTypeSchemasPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all FeedSourceTypeSchemas.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   ListFeedSourceTypeSchemasRequest request =
   *       ListFeedSourceTypeSchemasRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListFeedSourceTypeSchemasResponse response =
   *         feedsServiceClient.listFeedSourceTypeSchemasCallable().call(request);
   *     for (FeedSourceTypeSchema element : response.getFeedSourceTypeSchemasList()) {
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
  public final UnaryCallable<ListFeedSourceTypeSchemasRequest, ListFeedSourceTypeSchemasResponse>
      listFeedSourceTypeSchemasCallable() {
    return stub.listFeedSourceTypeSchemasCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all LogTypeSchemas compatible with a given FeedSourceType.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   FeedSourceTypeSchemaName parent =
   *       FeedSourceTypeSchemaName.of(
   *           "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED_SOURCE_TYPE]");
   *   for (LogTypeSchema element : feedsServiceClient.listLogTypeSchemas(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of LogTypeSchemas. Format:
   *     Format:
   *     projects/{project}/locations/{location}/instances/{instance}/feedSourceTypeSchemas/{feed_source_type}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLogTypeSchemasPagedResponse listLogTypeSchemas(
      @Nullable FeedSourceTypeSchemaName parent) {
    ListLogTypeSchemasRequest request =
        ListLogTypeSchemasRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listLogTypeSchemas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all LogTypeSchemas compatible with a given FeedSourceType.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   String parent =
   *       FeedSourceTypeSchemaName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED_SOURCE_TYPE]")
   *           .toString();
   *   for (LogTypeSchema element : feedsServiceClient.listLogTypeSchemas(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of LogTypeSchemas. Format:
   *     Format:
   *     projects/{project}/locations/{location}/instances/{instance}/feedSourceTypeSchemas/{feed_source_type}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLogTypeSchemasPagedResponse listLogTypeSchemas(String parent) {
    ListLogTypeSchemasRequest request =
        ListLogTypeSchemasRequest.newBuilder().setParent(parent).build();
    return listLogTypeSchemas(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all LogTypeSchemas compatible with a given FeedSourceType.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   ListLogTypeSchemasRequest request =
   *       ListLogTypeSchemasRequest.newBuilder()
   *           .setParent(
   *               FeedSourceTypeSchemaName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED_SOURCE_TYPE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (LogTypeSchema element : feedsServiceClient.listLogTypeSchemas(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLogTypeSchemasPagedResponse listLogTypeSchemas(
      ListLogTypeSchemasRequest request) {
    return listLogTypeSchemasPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all LogTypeSchemas compatible with a given FeedSourceType.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   ListLogTypeSchemasRequest request =
   *       ListLogTypeSchemasRequest.newBuilder()
   *           .setParent(
   *               FeedSourceTypeSchemaName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED_SOURCE_TYPE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<LogTypeSchema> future =
   *       feedsServiceClient.listLogTypeSchemasPagedCallable().futureCall(request);
   *   // Do something.
   *   for (LogTypeSchema element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLogTypeSchemasRequest, ListLogTypeSchemasPagedResponse>
      listLogTypeSchemasPagedCallable() {
    return stub.listLogTypeSchemasPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all LogTypeSchemas compatible with a given FeedSourceType.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   ListLogTypeSchemasRequest request =
   *       ListLogTypeSchemasRequest.newBuilder()
   *           .setParent(
   *               FeedSourceTypeSchemaName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED_SOURCE_TYPE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLogTypeSchemasResponse response =
   *         feedsServiceClient.listLogTypeSchemasCallable().call(request);
   *     for (LogTypeSchema element : response.getLogTypeSchemasList()) {
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
  public final UnaryCallable<ListLogTypeSchemasRequest, ListLogTypeSchemasResponse>
      listLogTypeSchemasCallable() {
    return stub.listLogTypeSchemasCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import logs coming from https push feeds. All log entries must be valid UTF-8. A single invalid
   * event will cause the entire request to be rejected.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   FeedName parent = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]");
   *   HttpBody response = feedsServiceClient.importPushLogs(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of logs. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/feeds/{feed}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpBody importPushLogs(@Nullable FeedName parent) {
    ImportPushLogsRequest request =
        ImportPushLogsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return importPushLogs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import logs coming from https push feeds. All log entries must be valid UTF-8. A single invalid
   * event will cause the entire request to be rejected.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   String parent = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString();
   *   HttpBody response = feedsServiceClient.importPushLogs(parent);
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of logs. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/feeds/{feed}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpBody importPushLogs(String parent) {
    ImportPushLogsRequest request = ImportPushLogsRequest.newBuilder().setParent(parent).build();
    return importPushLogs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import logs coming from https push feeds. All log entries must be valid UTF-8. A single invalid
   * event will cause the entire request to be rejected.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   ImportPushLogsRequest request =
   *       ImportPushLogsRequest.newBuilder()
   *           .setParent(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
   *           .setHttpBody(HttpBody.newBuilder().build())
   *           .setSecret("secret-906277200")
   *           .build();
   *   HttpBody response = feedsServiceClient.importPushLogs(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HttpBody importPushLogs(ImportPushLogsRequest request) {
    return importPushLogsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Import logs coming from https push feeds. All log entries must be valid UTF-8. A single invalid
   * event will cause the entire request to be rejected.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   ImportPushLogsRequest request =
   *       ImportPushLogsRequest.newBuilder()
   *           .setParent(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
   *           .setHttpBody(HttpBody.newBuilder().build())
   *           .setSecret("secret-906277200")
   *           .build();
   *   ApiFuture<HttpBody> future = feedsServiceClient.importPushLogsCallable().futureCall(request);
   *   // Do something.
   *   HttpBody response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ImportPushLogsRequest, HttpBody> importPushLogsCallable() {
    return stub.importPushLogsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a new secret for https push feeds which do not support jwt tokens. Secrets once
   * generated should be copied and stored in safe place to be used while configuring https push
   * feeds.Please note that you can always generate a new secret again for a feed using this API but
   * it will invalidate the previously generated secret for the feed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   FeedName name = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]");
   *   GenerateSecretResponse response = feedsServiceClient.generateSecret(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the feed to for which to generate secret. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/feeds/{feed}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateSecretResponse generateSecret(@Nullable FeedName name) {
    GenerateSecretRequest request =
        GenerateSecretRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return generateSecret(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a new secret for https push feeds which do not support jwt tokens. Secrets once
   * generated should be copied and stored in safe place to be used while configuring https push
   * feeds.Please note that you can always generate a new secret again for a feed using this API but
   * it will invalidate the previously generated secret for the feed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   String name = FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString();
   *   GenerateSecretResponse response = feedsServiceClient.generateSecret(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the feed to for which to generate secret. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/feeds/{feed}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateSecretResponse generateSecret(String name) {
    GenerateSecretRequest request = GenerateSecretRequest.newBuilder().setName(name).build();
    return generateSecret(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a new secret for https push feeds which do not support jwt tokens. Secrets once
   * generated should be copied and stored in safe place to be used while configuring https push
   * feeds.Please note that you can always generate a new secret again for a feed using this API but
   * it will invalidate the previously generated secret for the feed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   GenerateSecretRequest request =
   *       GenerateSecretRequest.newBuilder()
   *           .setName(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
   *           .build();
   *   GenerateSecretResponse response = feedsServiceClient.generateSecret(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final GenerateSecretResponse generateSecret(GenerateSecretRequest request) {
    return generateSecretCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Generates a new secret for https push feeds which do not support jwt tokens. Secrets once
   * generated should be copied and stored in safe place to be used while configuring https push
   * feeds.Please note that you can always generate a new secret again for a feed using this API but
   * it will invalidate the previously generated secret for the feed.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeedsServiceClient feedsServiceClient = FeedsServiceClient.create()) {
   *   GenerateSecretRequest request =
   *       GenerateSecretRequest.newBuilder()
   *           .setName(FeedName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEED]").toString())
   *           .build();
   *   ApiFuture<GenerateSecretResponse> future =
   *       feedsServiceClient.generateSecretCallable().futureCall(request);
   *   // Do something.
   *   GenerateSecretResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GenerateSecretRequest, GenerateSecretResponse>
      generateSecretCallable() {
    return stub.generateSecretCallable();
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

  public static class ListFeedsPagedResponse
      extends AbstractPagedListResponse<
          ListFeedsRequest, ListFeedsResponse, Feed, ListFeedsPage, ListFeedsFixedSizeCollection> {

    public static ApiFuture<ListFeedsPagedResponse> createAsync(
        PageContext<ListFeedsRequest, ListFeedsResponse, Feed> context,
        ApiFuture<ListFeedsResponse> futureResponse) {
      ApiFuture<ListFeedsPage> futurePage =
          ListFeedsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListFeedsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListFeedsPagedResponse(ListFeedsPage page) {
      super(page, ListFeedsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFeedsPage
      extends AbstractPage<ListFeedsRequest, ListFeedsResponse, Feed, ListFeedsPage> {

    private ListFeedsPage(
        @Nullable PageContext<ListFeedsRequest, ListFeedsResponse, Feed> context,
        @Nullable ListFeedsResponse response) {
      super(context, response);
    }

    private static ListFeedsPage createEmptyPage() {
      return new ListFeedsPage(null, null);
    }

    @Override
    protected ListFeedsPage createPage(
        @Nullable PageContext<ListFeedsRequest, ListFeedsResponse, Feed> context,
        @Nullable ListFeedsResponse response) {
      return new ListFeedsPage(context, response);
    }

    @Override
    public ApiFuture<ListFeedsPage> createPageAsync(
        @Nullable PageContext<ListFeedsRequest, ListFeedsResponse, Feed> context,
        ApiFuture<ListFeedsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFeedsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFeedsRequest, ListFeedsResponse, Feed, ListFeedsPage, ListFeedsFixedSizeCollection> {

    private ListFeedsFixedSizeCollection(@Nullable List<ListFeedsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFeedsFixedSizeCollection createEmptyCollection() {
      return new ListFeedsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFeedsFixedSizeCollection createCollection(
        @Nullable List<ListFeedsPage> pages, int collectionSize) {
      return new ListFeedsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListFeedPacksPagedResponse
      extends AbstractPagedListResponse<
          ListFeedPacksRequest,
          ListFeedPacksResponse,
          FeedPack,
          ListFeedPacksPage,
          ListFeedPacksFixedSizeCollection> {

    public static ApiFuture<ListFeedPacksPagedResponse> createAsync(
        PageContext<ListFeedPacksRequest, ListFeedPacksResponse, FeedPack> context,
        ApiFuture<ListFeedPacksResponse> futureResponse) {
      ApiFuture<ListFeedPacksPage> futurePage =
          ListFeedPacksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListFeedPacksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListFeedPacksPagedResponse(ListFeedPacksPage page) {
      super(page, ListFeedPacksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFeedPacksPage
      extends AbstractPage<
          ListFeedPacksRequest, ListFeedPacksResponse, FeedPack, ListFeedPacksPage> {

    private ListFeedPacksPage(
        @Nullable PageContext<ListFeedPacksRequest, ListFeedPacksResponse, FeedPack> context,
        @Nullable ListFeedPacksResponse response) {
      super(context, response);
    }

    private static ListFeedPacksPage createEmptyPage() {
      return new ListFeedPacksPage(null, null);
    }

    @Override
    protected ListFeedPacksPage createPage(
        @Nullable PageContext<ListFeedPacksRequest, ListFeedPacksResponse, FeedPack> context,
        @Nullable ListFeedPacksResponse response) {
      return new ListFeedPacksPage(context, response);
    }

    @Override
    public ApiFuture<ListFeedPacksPage> createPageAsync(
        @Nullable PageContext<ListFeedPacksRequest, ListFeedPacksResponse, FeedPack> context,
        ApiFuture<ListFeedPacksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFeedPacksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFeedPacksRequest,
          ListFeedPacksResponse,
          FeedPack,
          ListFeedPacksPage,
          ListFeedPacksFixedSizeCollection> {

    private ListFeedPacksFixedSizeCollection(
        @Nullable List<ListFeedPacksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFeedPacksFixedSizeCollection createEmptyCollection() {
      return new ListFeedPacksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFeedPacksFixedSizeCollection createCollection(
        @Nullable List<ListFeedPacksPage> pages, int collectionSize) {
      return new ListFeedPacksFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListFeedSourceTypeSchemasPagedResponse
      extends AbstractPagedListResponse<
          ListFeedSourceTypeSchemasRequest,
          ListFeedSourceTypeSchemasResponse,
          FeedSourceTypeSchema,
          ListFeedSourceTypeSchemasPage,
          ListFeedSourceTypeSchemasFixedSizeCollection> {

    public static ApiFuture<ListFeedSourceTypeSchemasPagedResponse> createAsync(
        PageContext<
                ListFeedSourceTypeSchemasRequest,
                ListFeedSourceTypeSchemasResponse,
                FeedSourceTypeSchema>
            context,
        ApiFuture<ListFeedSourceTypeSchemasResponse> futureResponse) {
      ApiFuture<ListFeedSourceTypeSchemasPage> futurePage =
          ListFeedSourceTypeSchemasPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListFeedSourceTypeSchemasPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListFeedSourceTypeSchemasPagedResponse(ListFeedSourceTypeSchemasPage page) {
      super(page, ListFeedSourceTypeSchemasFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFeedSourceTypeSchemasPage
      extends AbstractPage<
          ListFeedSourceTypeSchemasRequest,
          ListFeedSourceTypeSchemasResponse,
          FeedSourceTypeSchema,
          ListFeedSourceTypeSchemasPage> {

    private ListFeedSourceTypeSchemasPage(
        @Nullable
            PageContext<
                ListFeedSourceTypeSchemasRequest,
                ListFeedSourceTypeSchemasResponse,
                FeedSourceTypeSchema>
            context,
        @Nullable ListFeedSourceTypeSchemasResponse response) {
      super(context, response);
    }

    private static ListFeedSourceTypeSchemasPage createEmptyPage() {
      return new ListFeedSourceTypeSchemasPage(null, null);
    }

    @Override
    protected ListFeedSourceTypeSchemasPage createPage(
        @Nullable
            PageContext<
                ListFeedSourceTypeSchemasRequest,
                ListFeedSourceTypeSchemasResponse,
                FeedSourceTypeSchema>
            context,
        @Nullable ListFeedSourceTypeSchemasResponse response) {
      return new ListFeedSourceTypeSchemasPage(context, response);
    }

    @Override
    public ApiFuture<ListFeedSourceTypeSchemasPage> createPageAsync(
        @Nullable
            PageContext<
                ListFeedSourceTypeSchemasRequest,
                ListFeedSourceTypeSchemasResponse,
                FeedSourceTypeSchema>
            context,
        ApiFuture<ListFeedSourceTypeSchemasResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFeedSourceTypeSchemasFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFeedSourceTypeSchemasRequest,
          ListFeedSourceTypeSchemasResponse,
          FeedSourceTypeSchema,
          ListFeedSourceTypeSchemasPage,
          ListFeedSourceTypeSchemasFixedSizeCollection> {

    private ListFeedSourceTypeSchemasFixedSizeCollection(
        @Nullable List<ListFeedSourceTypeSchemasPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFeedSourceTypeSchemasFixedSizeCollection createEmptyCollection() {
      return new ListFeedSourceTypeSchemasFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFeedSourceTypeSchemasFixedSizeCollection createCollection(
        @Nullable List<ListFeedSourceTypeSchemasPage> pages, int collectionSize) {
      return new ListFeedSourceTypeSchemasFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLogTypeSchemasPagedResponse
      extends AbstractPagedListResponse<
          ListLogTypeSchemasRequest,
          ListLogTypeSchemasResponse,
          LogTypeSchema,
          ListLogTypeSchemasPage,
          ListLogTypeSchemasFixedSizeCollection> {

    public static ApiFuture<ListLogTypeSchemasPagedResponse> createAsync(
        PageContext<ListLogTypeSchemasRequest, ListLogTypeSchemasResponse, LogTypeSchema> context,
        ApiFuture<ListLogTypeSchemasResponse> futureResponse) {
      ApiFuture<ListLogTypeSchemasPage> futurePage =
          ListLogTypeSchemasPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLogTypeSchemasPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLogTypeSchemasPagedResponse(ListLogTypeSchemasPage page) {
      super(page, ListLogTypeSchemasFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLogTypeSchemasPage
      extends AbstractPage<
          ListLogTypeSchemasRequest,
          ListLogTypeSchemasResponse,
          LogTypeSchema,
          ListLogTypeSchemasPage> {

    private ListLogTypeSchemasPage(
        @Nullable PageContext<ListLogTypeSchemasRequest, ListLogTypeSchemasResponse, LogTypeSchema>
            context,
        @Nullable ListLogTypeSchemasResponse response) {
      super(context, response);
    }

    private static ListLogTypeSchemasPage createEmptyPage() {
      return new ListLogTypeSchemasPage(null, null);
    }

    @Override
    protected ListLogTypeSchemasPage createPage(
        @Nullable PageContext<ListLogTypeSchemasRequest, ListLogTypeSchemasResponse, LogTypeSchema>
            context,
        @Nullable ListLogTypeSchemasResponse response) {
      return new ListLogTypeSchemasPage(context, response);
    }

    @Override
    public ApiFuture<ListLogTypeSchemasPage> createPageAsync(
        @Nullable PageContext<ListLogTypeSchemasRequest, ListLogTypeSchemasResponse, LogTypeSchema>
            context,
        ApiFuture<ListLogTypeSchemasResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLogTypeSchemasFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLogTypeSchemasRequest,
          ListLogTypeSchemasResponse,
          LogTypeSchema,
          ListLogTypeSchemasPage,
          ListLogTypeSchemasFixedSizeCollection> {

    private ListLogTypeSchemasFixedSizeCollection(
        @Nullable List<ListLogTypeSchemasPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLogTypeSchemasFixedSizeCollection createEmptyCollection() {
      return new ListLogTypeSchemasFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLogTypeSchemasFixedSizeCollection createCollection(
        @Nullable List<ListLogTypeSchemasPage> pages, int collectionSize) {
      return new ListLogTypeSchemasFixedSizeCollection(pages, collectionSize);
    }
  }
}
