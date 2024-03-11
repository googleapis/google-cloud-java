/*
 * Copyright 2024 Google LLC
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

package com.google.cloud.discoveryengine.v1alpha;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.discoveryengine.v1alpha.stub.ChunkServiceStub;
import com.google.cloud.discoveryengine.v1alpha.stub.ChunkServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for displaying processed
 * [Chunk][google.cloud.discoveryengine.v1alpha.Chunk] information of the customer's unstructured
 * data.
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
 * try (ChunkServiceClient chunkServiceClient = ChunkServiceClient.create()) {
 *   ChunkName name =
 *       ChunkName.ofProjectLocationDataStoreBranchDocumentChunkName(
 *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]", "[CHUNK]");
 *   Chunk response = chunkServiceClient.getChunk(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ChunkServiceClient object to clean up resources such
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
 *      <td><p> GetChunk</td>
 *      <td><p> Gets a [Document][google.cloud.discoveryengine.v1alpha.Document].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getChunk(GetChunkRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getChunk(ChunkName name)
 *           <li><p> getChunk(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getChunkCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListChunks</td>
 *      <td><p> Gets a list of [Chunk][google.cloud.discoveryengine.v1alpha.Chunk]s.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listChunks(ListChunksRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listChunks(DocumentName parent)
 *           <li><p> listChunks(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listChunksPagedCallable()
 *           <li><p> listChunksCallable()
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
 * <p>This class can be customized by passing in a custom instance of ChunkServiceSettings to
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
 * ChunkServiceSettings chunkServiceSettings =
 *     ChunkServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ChunkServiceClient chunkServiceClient = ChunkServiceClient.create(chunkServiceSettings);
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
 * ChunkServiceSettings chunkServiceSettings =
 *     ChunkServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ChunkServiceClient chunkServiceClient = ChunkServiceClient.create(chunkServiceSettings);
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
 * ChunkServiceSettings chunkServiceSettings = ChunkServiceSettings.newHttpJsonBuilder().build();
 * ChunkServiceClient chunkServiceClient = ChunkServiceClient.create(chunkServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class ChunkServiceClient implements BackgroundResource {
  private final ChunkServiceSettings settings;
  private final ChunkServiceStub stub;

  /** Constructs an instance of ChunkServiceClient with default settings. */
  public static final ChunkServiceClient create() throws IOException {
    return create(ChunkServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ChunkServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ChunkServiceClient create(ChunkServiceSettings settings) throws IOException {
    return new ChunkServiceClient(settings);
  }

  /**
   * Constructs an instance of ChunkServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ChunkServiceSettings).
   */
  public static final ChunkServiceClient create(ChunkServiceStub stub) {
    return new ChunkServiceClient(stub);
  }

  /**
   * Constructs an instance of ChunkServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ChunkServiceClient(ChunkServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ChunkServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ChunkServiceClient(ChunkServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ChunkServiceSettings getSettings() {
    return settings;
  }

  public ChunkServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [Document][google.cloud.discoveryengine.v1alpha.Document].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChunkServiceClient chunkServiceClient = ChunkServiceClient.create()) {
   *   ChunkName name =
   *       ChunkName.ofProjectLocationDataStoreBranchDocumentChunkName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]", "[CHUNK]");
   *   Chunk response = chunkServiceClient.getChunk(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [Chunk][google.cloud.discoveryengine.v1alpha.Chunk], such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}/documents/{document}/chunks/{chunk}`.
   *     <p>If the caller does not have permission to access the
   *     [Chunk][google.cloud.discoveryengine.v1alpha.Chunk], regardless of whether or not it
   *     exists, a `PERMISSION_DENIED` error is returned.
   *     <p>If the requested [Chunk][google.cloud.discoveryengine.v1alpha.Chunk] does not exist, a
   *     `NOT_FOUND` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Chunk getChunk(ChunkName name) {
    GetChunkRequest request =
        GetChunkRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getChunk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [Document][google.cloud.discoveryengine.v1alpha.Document].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChunkServiceClient chunkServiceClient = ChunkServiceClient.create()) {
   *   String name =
   *       ChunkName.ofProjectLocationDataStoreBranchDocumentChunkName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]", "[CHUNK]")
   *           .toString();
   *   Chunk response = chunkServiceClient.getChunk(name);
   * }
   * }</pre>
   *
   * @param name Required. Full resource name of
   *     [Chunk][google.cloud.discoveryengine.v1alpha.Chunk], such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}/documents/{document}/chunks/{chunk}`.
   *     <p>If the caller does not have permission to access the
   *     [Chunk][google.cloud.discoveryengine.v1alpha.Chunk], regardless of whether or not it
   *     exists, a `PERMISSION_DENIED` error is returned.
   *     <p>If the requested [Chunk][google.cloud.discoveryengine.v1alpha.Chunk] does not exist, a
   *     `NOT_FOUND` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Chunk getChunk(String name) {
    GetChunkRequest request = GetChunkRequest.newBuilder().setName(name).build();
    return getChunk(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [Document][google.cloud.discoveryengine.v1alpha.Document].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChunkServiceClient chunkServiceClient = ChunkServiceClient.create()) {
   *   GetChunkRequest request =
   *       GetChunkRequest.newBuilder()
   *           .setName(
   *               ChunkName.ofProjectLocationDataStoreBranchDocumentChunkName(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DATA_STORE]",
   *                       "[BRANCH]",
   *                       "[DOCUMENT]",
   *                       "[CHUNK]")
   *                   .toString())
   *           .build();
   *   Chunk response = chunkServiceClient.getChunk(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Chunk getChunk(GetChunkRequest request) {
    return getChunkCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a [Document][google.cloud.discoveryengine.v1alpha.Document].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChunkServiceClient chunkServiceClient = ChunkServiceClient.create()) {
   *   GetChunkRequest request =
   *       GetChunkRequest.newBuilder()
   *           .setName(
   *               ChunkName.ofProjectLocationDataStoreBranchDocumentChunkName(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[DATA_STORE]",
   *                       "[BRANCH]",
   *                       "[DOCUMENT]",
   *                       "[CHUNK]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Chunk> future = chunkServiceClient.getChunkCallable().futureCall(request);
   *   // Do something.
   *   Chunk response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetChunkRequest, Chunk> getChunkCallable() {
    return stub.getChunkCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [Chunk][google.cloud.discoveryengine.v1alpha.Chunk]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChunkServiceClient chunkServiceClient = ChunkServiceClient.create()) {
   *   DocumentName parent =
   *       DocumentName.ofProjectLocationDataStoreBranchDocumentName(
   *           "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]");
   *   for (Chunk element : chunkServiceClient.listChunks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent document resource name, such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}/documents/{document}`.
   *     <p>If the caller does not have permission to list
   *     [Chunk][google.cloud.discoveryengine.v1alpha.Chunk]s under this document, regardless of
   *     whether or not this document exists, a `PERMISSION_DENIED` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChunksPagedResponse listChunks(DocumentName parent) {
    ListChunksRequest request =
        ListChunksRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listChunks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [Chunk][google.cloud.discoveryengine.v1alpha.Chunk]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChunkServiceClient chunkServiceClient = ChunkServiceClient.create()) {
   *   String parent =
   *       DocumentName.ofProjectLocationDataStoreBranchDocumentName(
   *               "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]")
   *           .toString();
   *   for (Chunk element : chunkServiceClient.listChunks(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent document resource name, such as
   *     `projects/{project}/locations/{location}/collections/{collection}/dataStores/{data_store}/branches/{branch}/documents/{document}`.
   *     <p>If the caller does not have permission to list
   *     [Chunk][google.cloud.discoveryengine.v1alpha.Chunk]s under this document, regardless of
   *     whether or not this document exists, a `PERMISSION_DENIED` error is returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChunksPagedResponse listChunks(String parent) {
    ListChunksRequest request = ListChunksRequest.newBuilder().setParent(parent).build();
    return listChunks(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [Chunk][google.cloud.discoveryengine.v1alpha.Chunk]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChunkServiceClient chunkServiceClient = ChunkServiceClient.create()) {
   *   ListChunksRequest request =
   *       ListChunksRequest.newBuilder()
   *           .setParent(
   *               DocumentName.ofProjectLocationDataStoreBranchDocumentName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Chunk element : chunkServiceClient.listChunks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChunksPagedResponse listChunks(ListChunksRequest request) {
    return listChunksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [Chunk][google.cloud.discoveryengine.v1alpha.Chunk]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChunkServiceClient chunkServiceClient = ChunkServiceClient.create()) {
   *   ListChunksRequest request =
   *       ListChunksRequest.newBuilder()
   *           .setParent(
   *               DocumentName.ofProjectLocationDataStoreBranchDocumentName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Chunk> future = chunkServiceClient.listChunksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Chunk element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListChunksRequest, ListChunksPagedResponse> listChunksPagedCallable() {
    return stub.listChunksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a list of [Chunk][google.cloud.discoveryengine.v1alpha.Chunk]s.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChunkServiceClient chunkServiceClient = ChunkServiceClient.create()) {
   *   ListChunksRequest request =
   *       ListChunksRequest.newBuilder()
   *           .setParent(
   *               DocumentName.ofProjectLocationDataStoreBranchDocumentName(
   *                       "[PROJECT]", "[LOCATION]", "[DATA_STORE]", "[BRANCH]", "[DOCUMENT]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListChunksResponse response = chunkServiceClient.listChunksCallable().call(request);
   *     for (Chunk element : response.getChunksList()) {
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
  public final UnaryCallable<ListChunksRequest, ListChunksResponse> listChunksCallable() {
    return stub.listChunksCallable();
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

  public static class ListChunksPagedResponse
      extends AbstractPagedListResponse<
          ListChunksRequest,
          ListChunksResponse,
          Chunk,
          ListChunksPage,
          ListChunksFixedSizeCollection> {

    public static ApiFuture<ListChunksPagedResponse> createAsync(
        PageContext<ListChunksRequest, ListChunksResponse, Chunk> context,
        ApiFuture<ListChunksResponse> futureResponse) {
      ApiFuture<ListChunksPage> futurePage =
          ListChunksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListChunksPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListChunksPagedResponse(ListChunksPage page) {
      super(page, ListChunksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListChunksPage
      extends AbstractPage<ListChunksRequest, ListChunksResponse, Chunk, ListChunksPage> {

    private ListChunksPage(
        PageContext<ListChunksRequest, ListChunksResponse, Chunk> context,
        ListChunksResponse response) {
      super(context, response);
    }

    private static ListChunksPage createEmptyPage() {
      return new ListChunksPage(null, null);
    }

    @Override
    protected ListChunksPage createPage(
        PageContext<ListChunksRequest, ListChunksResponse, Chunk> context,
        ListChunksResponse response) {
      return new ListChunksPage(context, response);
    }

    @Override
    public ApiFuture<ListChunksPage> createPageAsync(
        PageContext<ListChunksRequest, ListChunksResponse, Chunk> context,
        ApiFuture<ListChunksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListChunksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListChunksRequest,
          ListChunksResponse,
          Chunk,
          ListChunksPage,
          ListChunksFixedSizeCollection> {

    private ListChunksFixedSizeCollection(List<ListChunksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListChunksFixedSizeCollection createEmptyCollection() {
      return new ListChunksFixedSizeCollection(null, 0);
    }

    @Override
    protected ListChunksFixedSizeCollection createCollection(
        List<ListChunksPage> pages, int collectionSize) {
      return new ListChunksFixedSizeCollection(pages, collectionSize);
    }
  }
}
