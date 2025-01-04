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

package com.google.shopping.merchant.reviews.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.shopping.merchant.reviews.v1beta.stub.MerchantReviewsServiceStub;
import com.google.shopping.merchant.reviews.v1beta.stub.MerchantReviewsServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to manage merchant reviews.
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
 * try (MerchantReviewsServiceClient merchantReviewsServiceClient =
 *     MerchantReviewsServiceClient.create()) {
 *   MerchantReviewName name = MerchantReviewName.of("[ACCOUNT]", "[NAME]");
 *   MerchantReview response = merchantReviewsServiceClient.getMerchantReview(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MerchantReviewsServiceClient object to clean up
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
 *      <td><p> GetMerchantReview</td>
 *      <td><p> Gets a merchant review.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getMerchantReview(GetMerchantReviewRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getMerchantReview(MerchantReviewName name)
 *           <li><p> getMerchantReview(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getMerchantReviewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListMerchantReviews</td>
 *      <td><p> Lists merchant reviews.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listMerchantReviews(ListMerchantReviewsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listMerchantReviews(AccountName parent)
 *           <li><p> listMerchantReviews(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listMerchantReviewsPagedCallable()
 *           <li><p> listMerchantReviewsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> InsertMerchantReview</td>
 *      <td><p> Inserts a review for your Merchant Center account. If the review already exists, then the review is replaced with the new instance.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> insertMerchantReview(InsertMerchantReviewRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> insertMerchantReviewCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteMerchantReview</td>
 *      <td><p> Deletes merchant review.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteMerchantReview(DeleteMerchantReviewRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteMerchantReview(MerchantReviewName name)
 *           <li><p> deleteMerchantReview(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteMerchantReviewCallable()
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
 * <p>This class can be customized by passing in a custom instance of MerchantReviewsServiceSettings
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
 * MerchantReviewsServiceSettings merchantReviewsServiceSettings =
 *     MerchantReviewsServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MerchantReviewsServiceClient merchantReviewsServiceClient =
 *     MerchantReviewsServiceClient.create(merchantReviewsServiceSettings);
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
 * MerchantReviewsServiceSettings merchantReviewsServiceSettings =
 *     MerchantReviewsServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MerchantReviewsServiceClient merchantReviewsServiceClient =
 *     MerchantReviewsServiceClient.create(merchantReviewsServiceSettings);
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
 * MerchantReviewsServiceSettings merchantReviewsServiceSettings =
 *     MerchantReviewsServiceSettings.newHttpJsonBuilder().build();
 * MerchantReviewsServiceClient merchantReviewsServiceClient =
 *     MerchantReviewsServiceClient.create(merchantReviewsServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class MerchantReviewsServiceClient implements BackgroundResource {
  private final MerchantReviewsServiceSettings settings;
  private final MerchantReviewsServiceStub stub;

  /** Constructs an instance of MerchantReviewsServiceClient with default settings. */
  public static final MerchantReviewsServiceClient create() throws IOException {
    return create(MerchantReviewsServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MerchantReviewsServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final MerchantReviewsServiceClient create(MerchantReviewsServiceSettings settings)
      throws IOException {
    return new MerchantReviewsServiceClient(settings);
  }

  /**
   * Constructs an instance of MerchantReviewsServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(MerchantReviewsServiceSettings).
   */
  public static final MerchantReviewsServiceClient create(MerchantReviewsServiceStub stub) {
    return new MerchantReviewsServiceClient(stub);
  }

  /**
   * Constructs an instance of MerchantReviewsServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected MerchantReviewsServiceClient(MerchantReviewsServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((MerchantReviewsServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected MerchantReviewsServiceClient(MerchantReviewsServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final MerchantReviewsServiceSettings getSettings() {
    return settings;
  }

  public MerchantReviewsServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a merchant review.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantReviewsServiceClient merchantReviewsServiceClient =
   *     MerchantReviewsServiceClient.create()) {
   *   MerchantReviewName name = MerchantReviewName.of("[ACCOUNT]", "[NAME]");
   *   MerchantReview response = merchantReviewsServiceClient.getMerchantReview(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the merchant review. Format:
   *     accounts/{account}/merchantReviews/{merchantReview}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MerchantReview getMerchantReview(MerchantReviewName name) {
    GetMerchantReviewRequest request =
        GetMerchantReviewRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getMerchantReview(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a merchant review.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantReviewsServiceClient merchantReviewsServiceClient =
   *     MerchantReviewsServiceClient.create()) {
   *   String name = MerchantReviewName.of("[ACCOUNT]", "[NAME]").toString();
   *   MerchantReview response = merchantReviewsServiceClient.getMerchantReview(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the merchant review. Format:
   *     accounts/{account}/merchantReviews/{merchantReview}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MerchantReview getMerchantReview(String name) {
    GetMerchantReviewRequest request = GetMerchantReviewRequest.newBuilder().setName(name).build();
    return getMerchantReview(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a merchant review.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantReviewsServiceClient merchantReviewsServiceClient =
   *     MerchantReviewsServiceClient.create()) {
   *   GetMerchantReviewRequest request =
   *       GetMerchantReviewRequest.newBuilder()
   *           .setName(MerchantReviewName.of("[ACCOUNT]", "[NAME]").toString())
   *           .build();
   *   MerchantReview response = merchantReviewsServiceClient.getMerchantReview(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MerchantReview getMerchantReview(GetMerchantReviewRequest request) {
    return getMerchantReviewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a merchant review.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantReviewsServiceClient merchantReviewsServiceClient =
   *     MerchantReviewsServiceClient.create()) {
   *   GetMerchantReviewRequest request =
   *       GetMerchantReviewRequest.newBuilder()
   *           .setName(MerchantReviewName.of("[ACCOUNT]", "[NAME]").toString())
   *           .build();
   *   ApiFuture<MerchantReview> future =
   *       merchantReviewsServiceClient.getMerchantReviewCallable().futureCall(request);
   *   // Do something.
   *   MerchantReview response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetMerchantReviewRequest, MerchantReview> getMerchantReviewCallable() {
    return stub.getMerchantReviewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists merchant reviews.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantReviewsServiceClient merchantReviewsServiceClient =
   *     MerchantReviewsServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (MerchantReview element :
   *       merchantReviewsServiceClient.listMerchantReviews(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The account to list merchant reviews for. Format: accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMerchantReviewsPagedResponse listMerchantReviews(AccountName parent) {
    ListMerchantReviewsRequest request =
        ListMerchantReviewsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listMerchantReviews(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists merchant reviews.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantReviewsServiceClient merchantReviewsServiceClient =
   *     MerchantReviewsServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (MerchantReview element :
   *       merchantReviewsServiceClient.listMerchantReviews(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The account to list merchant reviews for. Format: accounts/{account}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMerchantReviewsPagedResponse listMerchantReviews(String parent) {
    ListMerchantReviewsRequest request =
        ListMerchantReviewsRequest.newBuilder().setParent(parent).build();
    return listMerchantReviews(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists merchant reviews.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantReviewsServiceClient merchantReviewsServiceClient =
   *     MerchantReviewsServiceClient.create()) {
   *   ListMerchantReviewsRequest request =
   *       ListMerchantReviewsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (MerchantReview element :
   *       merchantReviewsServiceClient.listMerchantReviews(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListMerchantReviewsPagedResponse listMerchantReviews(
      ListMerchantReviewsRequest request) {
    return listMerchantReviewsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists merchant reviews.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantReviewsServiceClient merchantReviewsServiceClient =
   *     MerchantReviewsServiceClient.create()) {
   *   ListMerchantReviewsRequest request =
   *       ListMerchantReviewsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<MerchantReview> future =
   *       merchantReviewsServiceClient.listMerchantReviewsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (MerchantReview element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListMerchantReviewsRequest, ListMerchantReviewsPagedResponse>
      listMerchantReviewsPagedCallable() {
    return stub.listMerchantReviewsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists merchant reviews.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantReviewsServiceClient merchantReviewsServiceClient =
   *     MerchantReviewsServiceClient.create()) {
   *   ListMerchantReviewsRequest request =
   *       ListMerchantReviewsRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListMerchantReviewsResponse response =
   *         merchantReviewsServiceClient.listMerchantReviewsCallable().call(request);
   *     for (MerchantReview element : response.getMerchantReviewsList()) {
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
  public final UnaryCallable<ListMerchantReviewsRequest, ListMerchantReviewsResponse>
      listMerchantReviewsCallable() {
    return stub.listMerchantReviewsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a review for your Merchant Center account. If the review already exists, then the
   * review is replaced with the new instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantReviewsServiceClient merchantReviewsServiceClient =
   *     MerchantReviewsServiceClient.create()) {
   *   InsertMerchantReviewRequest request =
   *       InsertMerchantReviewRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setMerchantReview(MerchantReview.newBuilder().build())
   *           .setDataSource("dataSource1272470629")
   *           .build();
   *   MerchantReview response = merchantReviewsServiceClient.insertMerchantReview(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final MerchantReview insertMerchantReview(InsertMerchantReviewRequest request) {
    return insertMerchantReviewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Inserts a review for your Merchant Center account. If the review already exists, then the
   * review is replaced with the new instance.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantReviewsServiceClient merchantReviewsServiceClient =
   *     MerchantReviewsServiceClient.create()) {
   *   InsertMerchantReviewRequest request =
   *       InsertMerchantReviewRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setMerchantReview(MerchantReview.newBuilder().build())
   *           .setDataSource("dataSource1272470629")
   *           .build();
   *   ApiFuture<MerchantReview> future =
   *       merchantReviewsServiceClient.insertMerchantReviewCallable().futureCall(request);
   *   // Do something.
   *   MerchantReview response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<InsertMerchantReviewRequest, MerchantReview>
      insertMerchantReviewCallable() {
    return stub.insertMerchantReviewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes merchant review.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantReviewsServiceClient merchantReviewsServiceClient =
   *     MerchantReviewsServiceClient.create()) {
   *   MerchantReviewName name = MerchantReviewName.of("[ACCOUNT]", "[NAME]");
   *   merchantReviewsServiceClient.deleteMerchantReview(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the merchant review. Format:
   *     accounts/{account}/merchantReviews/{merchantReview}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMerchantReview(MerchantReviewName name) {
    DeleteMerchantReviewRequest request =
        DeleteMerchantReviewRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteMerchantReview(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes merchant review.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantReviewsServiceClient merchantReviewsServiceClient =
   *     MerchantReviewsServiceClient.create()) {
   *   String name = MerchantReviewName.of("[ACCOUNT]", "[NAME]").toString();
   *   merchantReviewsServiceClient.deleteMerchantReview(name);
   * }
   * }</pre>
   *
   * @param name Required. The ID of the merchant review. Format:
   *     accounts/{account}/merchantReviews/{merchantReview}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMerchantReview(String name) {
    DeleteMerchantReviewRequest request =
        DeleteMerchantReviewRequest.newBuilder().setName(name).build();
    deleteMerchantReview(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes merchant review.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantReviewsServiceClient merchantReviewsServiceClient =
   *     MerchantReviewsServiceClient.create()) {
   *   DeleteMerchantReviewRequest request =
   *       DeleteMerchantReviewRequest.newBuilder()
   *           .setName(MerchantReviewName.of("[ACCOUNT]", "[NAME]").toString())
   *           .build();
   *   merchantReviewsServiceClient.deleteMerchantReview(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteMerchantReview(DeleteMerchantReviewRequest request) {
    deleteMerchantReviewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes merchant review.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MerchantReviewsServiceClient merchantReviewsServiceClient =
   *     MerchantReviewsServiceClient.create()) {
   *   DeleteMerchantReviewRequest request =
   *       DeleteMerchantReviewRequest.newBuilder()
   *           .setName(MerchantReviewName.of("[ACCOUNT]", "[NAME]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       merchantReviewsServiceClient.deleteMerchantReviewCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteMerchantReviewRequest, Empty> deleteMerchantReviewCallable() {
    return stub.deleteMerchantReviewCallable();
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

  public static class ListMerchantReviewsPagedResponse
      extends AbstractPagedListResponse<
          ListMerchantReviewsRequest,
          ListMerchantReviewsResponse,
          MerchantReview,
          ListMerchantReviewsPage,
          ListMerchantReviewsFixedSizeCollection> {

    public static ApiFuture<ListMerchantReviewsPagedResponse> createAsync(
        PageContext<ListMerchantReviewsRequest, ListMerchantReviewsResponse, MerchantReview>
            context,
        ApiFuture<ListMerchantReviewsResponse> futureResponse) {
      ApiFuture<ListMerchantReviewsPage> futurePage =
          ListMerchantReviewsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListMerchantReviewsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListMerchantReviewsPagedResponse(ListMerchantReviewsPage page) {
      super(page, ListMerchantReviewsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListMerchantReviewsPage
      extends AbstractPage<
          ListMerchantReviewsRequest,
          ListMerchantReviewsResponse,
          MerchantReview,
          ListMerchantReviewsPage> {

    private ListMerchantReviewsPage(
        PageContext<ListMerchantReviewsRequest, ListMerchantReviewsResponse, MerchantReview>
            context,
        ListMerchantReviewsResponse response) {
      super(context, response);
    }

    private static ListMerchantReviewsPage createEmptyPage() {
      return new ListMerchantReviewsPage(null, null);
    }

    @Override
    protected ListMerchantReviewsPage createPage(
        PageContext<ListMerchantReviewsRequest, ListMerchantReviewsResponse, MerchantReview>
            context,
        ListMerchantReviewsResponse response) {
      return new ListMerchantReviewsPage(context, response);
    }

    @Override
    public ApiFuture<ListMerchantReviewsPage> createPageAsync(
        PageContext<ListMerchantReviewsRequest, ListMerchantReviewsResponse, MerchantReview>
            context,
        ApiFuture<ListMerchantReviewsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListMerchantReviewsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListMerchantReviewsRequest,
          ListMerchantReviewsResponse,
          MerchantReview,
          ListMerchantReviewsPage,
          ListMerchantReviewsFixedSizeCollection> {

    private ListMerchantReviewsFixedSizeCollection(
        List<ListMerchantReviewsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListMerchantReviewsFixedSizeCollection createEmptyCollection() {
      return new ListMerchantReviewsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListMerchantReviewsFixedSizeCollection createCollection(
        List<ListMerchantReviewsPage> pages, int collectionSize) {
      return new ListMerchantReviewsFixedSizeCollection(pages, collectionSize);
    }
  }
}
