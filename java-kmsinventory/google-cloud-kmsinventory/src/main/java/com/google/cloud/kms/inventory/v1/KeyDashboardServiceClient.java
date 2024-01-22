/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.kms.inventory.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.kms.inventory.v1.stub.KeyDashboardServiceStub;
import com.google.cloud.kms.inventory.v1.stub.KeyDashboardServiceStubSettings;
import com.google.cloud.kms.v1.CryptoKey;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides a cross-region view of all Cloud KMS keys in a given Cloud project.
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
 * try (KeyDashboardServiceClient keyDashboardServiceClient = KeyDashboardServiceClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   for (CryptoKey element : keyDashboardServiceClient.listCryptoKeys(parent).iterateAll()) {
 *     // doThingsWith(element);
 *   }
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the KeyDashboardServiceClient object to clean up resources
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
 *      <td><p> ListCryptoKeys</td>
 *      <td><p> Returns cryptographic keys managed by Cloud KMS in a given Cloud project. Note that this data is sourced from snapshots, meaning it may not completely reflect the actual state of key metadata at call time.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCryptoKeys(ListCryptoKeysRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCryptoKeys(ProjectName parent)
 *           <li><p> listCryptoKeys(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCryptoKeysPagedCallable()
 *           <li><p> listCryptoKeysCallable()
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
 * <p>This class can be customized by passing in a custom instance of KeyDashboardServiceSettings to
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
 * KeyDashboardServiceSettings keyDashboardServiceSettings =
 *     KeyDashboardServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * KeyDashboardServiceClient keyDashboardServiceClient =
 *     KeyDashboardServiceClient.create(keyDashboardServiceSettings);
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
 * KeyDashboardServiceSettings keyDashboardServiceSettings =
 *     KeyDashboardServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * KeyDashboardServiceClient keyDashboardServiceClient =
 *     KeyDashboardServiceClient.create(keyDashboardServiceSettings);
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
 * KeyDashboardServiceSettings keyDashboardServiceSettings =
 *     KeyDashboardServiceSettings.newHttpJsonBuilder().build();
 * KeyDashboardServiceClient keyDashboardServiceClient =
 *     KeyDashboardServiceClient.create(keyDashboardServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class KeyDashboardServiceClient implements BackgroundResource {
  private final KeyDashboardServiceSettings settings;
  private final KeyDashboardServiceStub stub;

  /** Constructs an instance of KeyDashboardServiceClient with default settings. */
  public static final KeyDashboardServiceClient create() throws IOException {
    return create(KeyDashboardServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of KeyDashboardServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final KeyDashboardServiceClient create(KeyDashboardServiceSettings settings)
      throws IOException {
    return new KeyDashboardServiceClient(settings);
  }

  /**
   * Constructs an instance of KeyDashboardServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(KeyDashboardServiceSettings).
   */
  public static final KeyDashboardServiceClient create(KeyDashboardServiceStub stub) {
    return new KeyDashboardServiceClient(stub);
  }

  /**
   * Constructs an instance of KeyDashboardServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected KeyDashboardServiceClient(KeyDashboardServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((KeyDashboardServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected KeyDashboardServiceClient(KeyDashboardServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final KeyDashboardServiceSettings getSettings() {
    return settings;
  }

  public KeyDashboardServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns cryptographic keys managed by Cloud KMS in a given Cloud project. Note that this data
   * is sourced from snapshots, meaning it may not completely reflect the actual state of key
   * metadata at call time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyDashboardServiceClient keyDashboardServiceClient = KeyDashboardServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (CryptoKey element : keyDashboardServiceClient.listCryptoKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Google Cloud project for which to retrieve key metadata, in the
   *     format `projects/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCryptoKeysPagedResponse listCryptoKeys(ProjectName parent) {
    ListCryptoKeysRequest request =
        ListCryptoKeysRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCryptoKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns cryptographic keys managed by Cloud KMS in a given Cloud project. Note that this data
   * is sourced from snapshots, meaning it may not completely reflect the actual state of key
   * metadata at call time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyDashboardServiceClient keyDashboardServiceClient = KeyDashboardServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (CryptoKey element : keyDashboardServiceClient.listCryptoKeys(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The Google Cloud project for which to retrieve key metadata, in the
   *     format `projects/&#42;`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCryptoKeysPagedResponse listCryptoKeys(String parent) {
    ListCryptoKeysRequest request = ListCryptoKeysRequest.newBuilder().setParent(parent).build();
    return listCryptoKeys(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns cryptographic keys managed by Cloud KMS in a given Cloud project. Note that this data
   * is sourced from snapshots, meaning it may not completely reflect the actual state of key
   * metadata at call time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyDashboardServiceClient keyDashboardServiceClient = KeyDashboardServiceClient.create()) {
   *   ListCryptoKeysRequest request =
   *       ListCryptoKeysRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (CryptoKey element : keyDashboardServiceClient.listCryptoKeys(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCryptoKeysPagedResponse listCryptoKeys(ListCryptoKeysRequest request) {
    return listCryptoKeysPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns cryptographic keys managed by Cloud KMS in a given Cloud project. Note that this data
   * is sourced from snapshots, meaning it may not completely reflect the actual state of key
   * metadata at call time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyDashboardServiceClient keyDashboardServiceClient = KeyDashboardServiceClient.create()) {
   *   ListCryptoKeysRequest request =
   *       ListCryptoKeysRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<CryptoKey> future =
   *       keyDashboardServiceClient.listCryptoKeysPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CryptoKey element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCryptoKeysRequest, ListCryptoKeysPagedResponse>
      listCryptoKeysPagedCallable() {
    return stub.listCryptoKeysPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns cryptographic keys managed by Cloud KMS in a given Cloud project. Note that this data
   * is sourced from snapshots, meaning it may not completely reflect the actual state of key
   * metadata at call time.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (KeyDashboardServiceClient keyDashboardServiceClient = KeyDashboardServiceClient.create()) {
   *   ListCryptoKeysRequest request =
   *       ListCryptoKeysRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListCryptoKeysResponse response =
   *         keyDashboardServiceClient.listCryptoKeysCallable().call(request);
   *     for (CryptoKey element : response.getCryptoKeysList()) {
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
  public final UnaryCallable<ListCryptoKeysRequest, ListCryptoKeysResponse>
      listCryptoKeysCallable() {
    return stub.listCryptoKeysCallable();
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

  public static class ListCryptoKeysPagedResponse
      extends AbstractPagedListResponse<
          ListCryptoKeysRequest,
          ListCryptoKeysResponse,
          CryptoKey,
          ListCryptoKeysPage,
          ListCryptoKeysFixedSizeCollection> {

    public static ApiFuture<ListCryptoKeysPagedResponse> createAsync(
        PageContext<ListCryptoKeysRequest, ListCryptoKeysResponse, CryptoKey> context,
        ApiFuture<ListCryptoKeysResponse> futureResponse) {
      ApiFuture<ListCryptoKeysPage> futurePage =
          ListCryptoKeysPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCryptoKeysPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCryptoKeysPagedResponse(ListCryptoKeysPage page) {
      super(page, ListCryptoKeysFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCryptoKeysPage
      extends AbstractPage<
          ListCryptoKeysRequest, ListCryptoKeysResponse, CryptoKey, ListCryptoKeysPage> {

    private ListCryptoKeysPage(
        PageContext<ListCryptoKeysRequest, ListCryptoKeysResponse, CryptoKey> context,
        ListCryptoKeysResponse response) {
      super(context, response);
    }

    private static ListCryptoKeysPage createEmptyPage() {
      return new ListCryptoKeysPage(null, null);
    }

    @Override
    protected ListCryptoKeysPage createPage(
        PageContext<ListCryptoKeysRequest, ListCryptoKeysResponse, CryptoKey> context,
        ListCryptoKeysResponse response) {
      return new ListCryptoKeysPage(context, response);
    }

    @Override
    public ApiFuture<ListCryptoKeysPage> createPageAsync(
        PageContext<ListCryptoKeysRequest, ListCryptoKeysResponse, CryptoKey> context,
        ApiFuture<ListCryptoKeysResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCryptoKeysFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCryptoKeysRequest,
          ListCryptoKeysResponse,
          CryptoKey,
          ListCryptoKeysPage,
          ListCryptoKeysFixedSizeCollection> {

    private ListCryptoKeysFixedSizeCollection(List<ListCryptoKeysPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCryptoKeysFixedSizeCollection createEmptyCollection() {
      return new ListCryptoKeysFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCryptoKeysFixedSizeCollection createCollection(
        List<ListCryptoKeysPage> pages, int collectionSize) {
      return new ListCryptoKeysFixedSizeCollection(pages, collectionSize);
    }
  }
}
