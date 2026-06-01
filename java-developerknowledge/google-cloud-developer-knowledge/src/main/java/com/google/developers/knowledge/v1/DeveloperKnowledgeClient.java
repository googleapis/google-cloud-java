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

package com.google.developers.knowledge.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.developers.knowledge.v1.stub.DeveloperKnowledgeStub;
import com.google.developers.knowledge.v1.stub.DeveloperKnowledgeStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Developer Knowledge API provides programmatic access to Google's public
 * developer documentation, enabling you to integrate this knowledge base into your own applications
 * and workflows.
 *
 * <p>The API is designed to be the canonical source for machine-readable access to Google's
 * developer documentation.
 *
 * <p>A typical use case is to first use
 * [DeveloperKnowledge.SearchDocumentChunks][google.developers.knowledge.v1.DeveloperKnowledge.SearchDocumentChunks]
 * to find relevant page URIs based on a query, and then use
 * [DeveloperKnowledge.GetDocument][google.developers.knowledge.v1.DeveloperKnowledge.GetDocument]
 * or
 * [DeveloperKnowledge.BatchGetDocuments][google.developers.knowledge.v1.DeveloperKnowledge.BatchGetDocuments]
 * to fetch the full content of the top results.
 *
 * <p>All document content is provided in Markdown format.
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
 * try (DeveloperKnowledgeClient developerKnowledgeClient = DeveloperKnowledgeClient.create()) {
 *   DocumentName name = DocumentName.of("[DOCUMENT]");
 *   Document response = developerKnowledgeClient.getDocument(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DeveloperKnowledgeClient object to clean up resources
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
 *      <td><p> SearchDocumentChunks</td>
 *      <td><p> Searches for developer knowledge across Google's developer documentation. Returns [DocumentChunk][google.developers.knowledge.v1.DocumentChunk]s based on the user's query. There may be many chunks from the same [Document][google.developers.knowledge.v1.Document].  To retrieve full documents, use [DeveloperKnowledge.GetDocument][google.developers.knowledge.v1.DeveloperKnowledge.GetDocument] or [DeveloperKnowledge.BatchGetDocuments][google.developers.knowledge.v1.DeveloperKnowledge.BatchGetDocuments] with the [DocumentChunk.parent][google.developers.knowledge.v1.DocumentChunk.parent] returned in the [SearchDocumentChunksResponse.results][google.developers.knowledge.v1.SearchDocumentChunksResponse.results].</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> searchDocumentChunks(SearchDocumentChunksRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> searchDocumentChunksPagedCallable()
 *           <li><p> searchDocumentChunksCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDocument</td>
 *      <td><p> Retrieves a single document with its full Markdown content.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDocument(GetDocumentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDocument(DocumentName name)
 *           <li><p> getDocument(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDocumentCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchGetDocuments</td>
 *      <td><p> Retrieves multiple documents, each with its full Markdown content.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchGetDocuments(BatchGetDocumentsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchGetDocumentsCallable()
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
 * <p>This class can be customized by passing in a custom instance of DeveloperKnowledgeSettings to
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
 * DeveloperKnowledgeSettings developerKnowledgeSettings =
 *     DeveloperKnowledgeSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DeveloperKnowledgeClient developerKnowledgeClient =
 *     DeveloperKnowledgeClient.create(developerKnowledgeSettings);
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
 * DeveloperKnowledgeSettings developerKnowledgeSettings =
 *     DeveloperKnowledgeSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DeveloperKnowledgeClient developerKnowledgeClient =
 *     DeveloperKnowledgeClient.create(developerKnowledgeSettings);
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
 * DeveloperKnowledgeSettings developerKnowledgeSettings =
 *     DeveloperKnowledgeSettings.newHttpJsonBuilder().build();
 * DeveloperKnowledgeClient developerKnowledgeClient =
 *     DeveloperKnowledgeClient.create(developerKnowledgeSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DeveloperKnowledgeClient implements BackgroundResource {
  private final DeveloperKnowledgeSettings settings;
  private final DeveloperKnowledgeStub stub;

  /** Constructs an instance of DeveloperKnowledgeClient with default settings. */
  public static final DeveloperKnowledgeClient create() throws IOException {
    return create(DeveloperKnowledgeSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DeveloperKnowledgeClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DeveloperKnowledgeClient create(DeveloperKnowledgeSettings settings)
      throws IOException {
    return new DeveloperKnowledgeClient(settings);
  }

  /**
   * Constructs an instance of DeveloperKnowledgeClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(DeveloperKnowledgeSettings).
   */
  public static final DeveloperKnowledgeClient create(DeveloperKnowledgeStub stub) {
    return new DeveloperKnowledgeClient(stub);
  }

  /**
   * Constructs an instance of DeveloperKnowledgeClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DeveloperKnowledgeClient(DeveloperKnowledgeSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DeveloperKnowledgeStubSettings) settings.getStubSettings()).createStub();
  }

  protected DeveloperKnowledgeClient(DeveloperKnowledgeStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DeveloperKnowledgeSettings getSettings() {
    return settings;
  }

  public DeveloperKnowledgeStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for developer knowledge across Google's developer documentation. Returns
   * [DocumentChunk][google.developers.knowledge.v1.DocumentChunk]s based on the user's query. There
   * may be many chunks from the same [Document][google.developers.knowledge.v1.Document]. To
   * retrieve full documents, use
   * [DeveloperKnowledge.GetDocument][google.developers.knowledge.v1.DeveloperKnowledge.GetDocument]
   * or
   * [DeveloperKnowledge.BatchGetDocuments][google.developers.knowledge.v1.DeveloperKnowledge.BatchGetDocuments]
   * with the [DocumentChunk.parent][google.developers.knowledge.v1.DocumentChunk.parent] returned
   * in the
   * [SearchDocumentChunksResponse.results][google.developers.knowledge.v1.SearchDocumentChunksResponse.results].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperKnowledgeClient developerKnowledgeClient = DeveloperKnowledgeClient.create()) {
   *   SearchDocumentChunksRequest request =
   *       SearchDocumentChunksRequest.newBuilder()
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (DocumentChunk element :
   *       developerKnowledgeClient.searchDocumentChunks(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchDocumentChunksPagedResponse searchDocumentChunks(
      SearchDocumentChunksRequest request) {
    return searchDocumentChunksPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for developer knowledge across Google's developer documentation. Returns
   * [DocumentChunk][google.developers.knowledge.v1.DocumentChunk]s based on the user's query. There
   * may be many chunks from the same [Document][google.developers.knowledge.v1.Document]. To
   * retrieve full documents, use
   * [DeveloperKnowledge.GetDocument][google.developers.knowledge.v1.DeveloperKnowledge.GetDocument]
   * or
   * [DeveloperKnowledge.BatchGetDocuments][google.developers.knowledge.v1.DeveloperKnowledge.BatchGetDocuments]
   * with the [DocumentChunk.parent][google.developers.knowledge.v1.DocumentChunk.parent] returned
   * in the
   * [SearchDocumentChunksResponse.results][google.developers.knowledge.v1.SearchDocumentChunksResponse.results].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperKnowledgeClient developerKnowledgeClient = DeveloperKnowledgeClient.create()) {
   *   SearchDocumentChunksRequest request =
   *       SearchDocumentChunksRequest.newBuilder()
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<DocumentChunk> future =
   *       developerKnowledgeClient.searchDocumentChunksPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DocumentChunk element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchDocumentChunksRequest, SearchDocumentChunksPagedResponse>
      searchDocumentChunksPagedCallable() {
    return stub.searchDocumentChunksPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches for developer knowledge across Google's developer documentation. Returns
   * [DocumentChunk][google.developers.knowledge.v1.DocumentChunk]s based on the user's query. There
   * may be many chunks from the same [Document][google.developers.knowledge.v1.Document]. To
   * retrieve full documents, use
   * [DeveloperKnowledge.GetDocument][google.developers.knowledge.v1.DeveloperKnowledge.GetDocument]
   * or
   * [DeveloperKnowledge.BatchGetDocuments][google.developers.knowledge.v1.DeveloperKnowledge.BatchGetDocuments]
   * with the [DocumentChunk.parent][google.developers.knowledge.v1.DocumentChunk.parent] returned
   * in the
   * [SearchDocumentChunksResponse.results][google.developers.knowledge.v1.SearchDocumentChunksResponse.results].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperKnowledgeClient developerKnowledgeClient = DeveloperKnowledgeClient.create()) {
   *   SearchDocumentChunksRequest request =
   *       SearchDocumentChunksRequest.newBuilder()
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     SearchDocumentChunksResponse response =
   *         developerKnowledgeClient.searchDocumentChunksCallable().call(request);
   *     for (DocumentChunk element : response.getResultsList()) {
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
  public final UnaryCallable<SearchDocumentChunksRequest, SearchDocumentChunksResponse>
      searchDocumentChunksCallable() {
    return stub.searchDocumentChunksCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a single document with its full Markdown content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperKnowledgeClient developerKnowledgeClient = DeveloperKnowledgeClient.create()) {
   *   DocumentName name = DocumentName.of("[DOCUMENT]");
   *   Document response = developerKnowledgeClient.getDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. Specifies the name of the document to retrieve. Format:
   *     `documents/{uri_without_scheme}` Example:
   *     `documents/docs.cloud.google.com/storage/docs/creating-buckets`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Document getDocument(DocumentName name) {
    GetDocumentRequest request =
        GetDocumentRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a single document with its full Markdown content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperKnowledgeClient developerKnowledgeClient = DeveloperKnowledgeClient.create()) {
   *   String name = DocumentName.of("[DOCUMENT]").toString();
   *   Document response = developerKnowledgeClient.getDocument(name);
   * }
   * }</pre>
   *
   * @param name Required. Specifies the name of the document to retrieve. Format:
   *     `documents/{uri_without_scheme}` Example:
   *     `documents/docs.cloud.google.com/storage/docs/creating-buckets`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Document getDocument(String name) {
    GetDocumentRequest request = GetDocumentRequest.newBuilder().setName(name).build();
    return getDocument(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a single document with its full Markdown content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperKnowledgeClient developerKnowledgeClient = DeveloperKnowledgeClient.create()) {
   *   GetDocumentRequest request =
   *       GetDocumentRequest.newBuilder()
   *           .setName(DocumentName.of("[DOCUMENT]").toString())
   *           .setView(DocumentView.forNumber(0))
   *           .build();
   *   Document response = developerKnowledgeClient.getDocument(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Document getDocument(GetDocumentRequest request) {
    return getDocumentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a single document with its full Markdown content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperKnowledgeClient developerKnowledgeClient = DeveloperKnowledgeClient.create()) {
   *   GetDocumentRequest request =
   *       GetDocumentRequest.newBuilder()
   *           .setName(DocumentName.of("[DOCUMENT]").toString())
   *           .setView(DocumentView.forNumber(0))
   *           .build();
   *   ApiFuture<Document> future =
   *       developerKnowledgeClient.getDocumentCallable().futureCall(request);
   *   // Do something.
   *   Document response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDocumentRequest, Document> getDocumentCallable() {
    return stub.getDocumentCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves multiple documents, each with its full Markdown content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperKnowledgeClient developerKnowledgeClient = DeveloperKnowledgeClient.create()) {
   *   BatchGetDocumentsRequest request =
   *       BatchGetDocumentsRequest.newBuilder()
   *           .addAllNames(new ArrayList<String>())
   *           .setView(DocumentView.forNumber(0))
   *           .build();
   *   BatchGetDocumentsResponse response = developerKnowledgeClient.batchGetDocuments(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchGetDocumentsResponse batchGetDocuments(BatchGetDocumentsRequest request) {
    return batchGetDocumentsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves multiple documents, each with its full Markdown content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DeveloperKnowledgeClient developerKnowledgeClient = DeveloperKnowledgeClient.create()) {
   *   BatchGetDocumentsRequest request =
   *       BatchGetDocumentsRequest.newBuilder()
   *           .addAllNames(new ArrayList<String>())
   *           .setView(DocumentView.forNumber(0))
   *           .build();
   *   ApiFuture<BatchGetDocumentsResponse> future =
   *       developerKnowledgeClient.batchGetDocumentsCallable().futureCall(request);
   *   // Do something.
   *   BatchGetDocumentsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchGetDocumentsRequest, BatchGetDocumentsResponse>
      batchGetDocumentsCallable() {
    return stub.batchGetDocumentsCallable();
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

  public static class SearchDocumentChunksPagedResponse
      extends AbstractPagedListResponse<
          SearchDocumentChunksRequest,
          SearchDocumentChunksResponse,
          DocumentChunk,
          SearchDocumentChunksPage,
          SearchDocumentChunksFixedSizeCollection> {

    public static ApiFuture<SearchDocumentChunksPagedResponse> createAsync(
        PageContext<SearchDocumentChunksRequest, SearchDocumentChunksResponse, DocumentChunk>
            context,
        ApiFuture<SearchDocumentChunksResponse> futureResponse) {
      ApiFuture<SearchDocumentChunksPage> futurePage =
          SearchDocumentChunksPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchDocumentChunksPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchDocumentChunksPagedResponse(SearchDocumentChunksPage page) {
      super(page, SearchDocumentChunksFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchDocumentChunksPage
      extends AbstractPage<
          SearchDocumentChunksRequest,
          SearchDocumentChunksResponse,
          DocumentChunk,
          SearchDocumentChunksPage> {

    private SearchDocumentChunksPage(
        PageContext<SearchDocumentChunksRequest, SearchDocumentChunksResponse, DocumentChunk>
            context,
        SearchDocumentChunksResponse response) {
      super(context, response);
    }

    private static SearchDocumentChunksPage createEmptyPage() {
      return new SearchDocumentChunksPage(null, null);
    }

    @Override
    protected SearchDocumentChunksPage createPage(
        PageContext<SearchDocumentChunksRequest, SearchDocumentChunksResponse, DocumentChunk>
            context,
        SearchDocumentChunksResponse response) {
      return new SearchDocumentChunksPage(context, response);
    }

    @Override
    public ApiFuture<SearchDocumentChunksPage> createPageAsync(
        PageContext<SearchDocumentChunksRequest, SearchDocumentChunksResponse, DocumentChunk>
            context,
        ApiFuture<SearchDocumentChunksResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchDocumentChunksFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchDocumentChunksRequest,
          SearchDocumentChunksResponse,
          DocumentChunk,
          SearchDocumentChunksPage,
          SearchDocumentChunksFixedSizeCollection> {

    private SearchDocumentChunksFixedSizeCollection(
        List<SearchDocumentChunksPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchDocumentChunksFixedSizeCollection createEmptyCollection() {
      return new SearchDocumentChunksFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchDocumentChunksFixedSizeCollection createCollection(
        List<SearchDocumentChunksPage> pages, int collectionSize) {
      return new SearchDocumentChunksFixedSizeCollection(pages, collectionSize);
    }
  }
}
