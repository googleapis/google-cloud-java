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

package com.google.cloud.support.v2;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.support.v2.stub.CommentServiceStub;
import com.google.cloud.support.v2.stub.CommentServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: A service to manage comments on cases.
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
 * try (CommentServiceClient commentServiceClient = CommentServiceClient.create()) {
 *   CaseName parent = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");
 *   Comment comment = Comment.newBuilder().build();
 *   Comment response = commentServiceClient.createComment(parent, comment);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CommentServiceClient object to clean up resources such
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
 *      <td><p> ListComments</td>
 *      <td><p> Retrieve all Comments associated with the Case object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listComments(ListCommentsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listComments(CaseName parent)
 *           <li><p> listComments(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCommentsPagedCallable()
 *           <li><p> listCommentsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateComment</td>
 *      <td><p> Add a new comment to the specified Case. The comment object must have the following fields set: body.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createComment(CreateCommentRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createComment(CaseName parent, Comment comment)
 *           <li><p> createComment(String parent, Comment comment)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCommentCallable()
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
 * <p>This class can be customized by passing in a custom instance of CommentServiceSettings to
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
 * CommentServiceSettings commentServiceSettings =
 *     CommentServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CommentServiceClient commentServiceClient = CommentServiceClient.create(commentServiceSettings);
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
 * CommentServiceSettings commentServiceSettings =
 *     CommentServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CommentServiceClient commentServiceClient = CommentServiceClient.create(commentServiceSettings);
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
 * CommentServiceSettings commentServiceSettings =
 *     CommentServiceSettings.newHttpJsonBuilder().build();
 * CommentServiceClient commentServiceClient = CommentServiceClient.create(commentServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CommentServiceClient implements BackgroundResource {
  private final CommentServiceSettings settings;
  private final CommentServiceStub stub;

  /** Constructs an instance of CommentServiceClient with default settings. */
  public static final CommentServiceClient create() throws IOException {
    return create(CommentServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CommentServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CommentServiceClient create(CommentServiceSettings settings)
      throws IOException {
    return new CommentServiceClient(settings);
  }

  /**
   * Constructs an instance of CommentServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(CommentServiceSettings).
   */
  public static final CommentServiceClient create(CommentServiceStub stub) {
    return new CommentServiceClient(stub);
  }

  /**
   * Constructs an instance of CommentServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CommentServiceClient(CommentServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CommentServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected CommentServiceClient(CommentServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CommentServiceSettings getSettings() {
    return settings;
  }

  public CommentServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve all Comments associated with the Case object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommentServiceClient commentServiceClient = CommentServiceClient.create()) {
   *   CaseName parent = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");
   *   for (Comment element : commentServiceClient.listComments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of Case object for which comments should be listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCommentsPagedResponse listComments(CaseName parent) {
    ListCommentsRequest request =
        ListCommentsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listComments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve all Comments associated with the Case object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommentServiceClient commentServiceClient = CommentServiceClient.create()) {
   *   String parent = CaseName.ofOrganizationCaseName("[ORGANIZATION]", "[CASE]").toString();
   *   for (Comment element : commentServiceClient.listComments(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of Case object for which comments should be listed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCommentsPagedResponse listComments(String parent) {
    ListCommentsRequest request = ListCommentsRequest.newBuilder().setParent(parent).build();
    return listComments(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve all Comments associated with the Case object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommentServiceClient commentServiceClient = CommentServiceClient.create()) {
   *   ListCommentsRequest request =
   *       ListCommentsRequest.newBuilder()
   *           .setParent(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Comment element : commentServiceClient.listComments(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCommentsPagedResponse listComments(ListCommentsRequest request) {
    return listCommentsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve all Comments associated with the Case object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommentServiceClient commentServiceClient = CommentServiceClient.create()) {
   *   ListCommentsRequest request =
   *       ListCommentsRequest.newBuilder()
   *           .setParent(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Comment> future =
   *       commentServiceClient.listCommentsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Comment element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCommentsRequest, ListCommentsPagedResponse>
      listCommentsPagedCallable() {
    return stub.listCommentsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieve all Comments associated with the Case object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommentServiceClient commentServiceClient = CommentServiceClient.create()) {
   *   ListCommentsRequest request =
   *       ListCommentsRequest.newBuilder()
   *           .setParent(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListCommentsResponse response = commentServiceClient.listCommentsCallable().call(request);
   *     for (Comment element : response.getCommentsList()) {
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
  public final UnaryCallable<ListCommentsRequest, ListCommentsResponse> listCommentsCallable() {
    return stub.listCommentsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Add a new comment to the specified Case. The comment object must have the following fields set:
   * body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommentServiceClient commentServiceClient = CommentServiceClient.create()) {
   *   CaseName parent = CaseName.ofProjectCaseName("[PROJECT]", "[CASE]");
   *   Comment comment = Comment.newBuilder().build();
   *   Comment response = commentServiceClient.createComment(parent, comment);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of Case to which this comment should be added.
   * @param comment Required. The Comment object to be added to this Case.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Comment createComment(CaseName parent, Comment comment) {
    CreateCommentRequest request =
        CreateCommentRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setComment(comment)
            .build();
    return createComment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Add a new comment to the specified Case. The comment object must have the following fields set:
   * body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommentServiceClient commentServiceClient = CommentServiceClient.create()) {
   *   String parent = CaseName.ofOrganizationCaseName("[ORGANIZATION]", "[CASE]").toString();
   *   Comment comment = Comment.newBuilder().build();
   *   Comment response = commentServiceClient.createComment(parent, comment);
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of Case to which this comment should be added.
   * @param comment Required. The Comment object to be added to this Case.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Comment createComment(String parent, Comment comment) {
    CreateCommentRequest request =
        CreateCommentRequest.newBuilder().setParent(parent).setComment(comment).build();
    return createComment(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Add a new comment to the specified Case. The comment object must have the following fields set:
   * body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommentServiceClient commentServiceClient = CommentServiceClient.create()) {
   *   CreateCommentRequest request =
   *       CreateCommentRequest.newBuilder()
   *           .setParent(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
   *           .setComment(Comment.newBuilder().build())
   *           .build();
   *   Comment response = commentServiceClient.createComment(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Comment createComment(CreateCommentRequest request) {
    return createCommentCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Add a new comment to the specified Case. The comment object must have the following fields set:
   * body.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CommentServiceClient commentServiceClient = CommentServiceClient.create()) {
   *   CreateCommentRequest request =
   *       CreateCommentRequest.newBuilder()
   *           .setParent(CaseName.ofProjectCaseName("[PROJECT]", "[CASE]").toString())
   *           .setComment(Comment.newBuilder().build())
   *           .build();
   *   ApiFuture<Comment> future = commentServiceClient.createCommentCallable().futureCall(request);
   *   // Do something.
   *   Comment response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCommentRequest, Comment> createCommentCallable() {
    return stub.createCommentCallable();
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

  public static class ListCommentsPagedResponse
      extends AbstractPagedListResponse<
          ListCommentsRequest,
          ListCommentsResponse,
          Comment,
          ListCommentsPage,
          ListCommentsFixedSizeCollection> {

    public static ApiFuture<ListCommentsPagedResponse> createAsync(
        PageContext<ListCommentsRequest, ListCommentsResponse, Comment> context,
        ApiFuture<ListCommentsResponse> futureResponse) {
      ApiFuture<ListCommentsPage> futurePage =
          ListCommentsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCommentsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCommentsPagedResponse(ListCommentsPage page) {
      super(page, ListCommentsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCommentsPage
      extends AbstractPage<ListCommentsRequest, ListCommentsResponse, Comment, ListCommentsPage> {

    private ListCommentsPage(
        PageContext<ListCommentsRequest, ListCommentsResponse, Comment> context,
        ListCommentsResponse response) {
      super(context, response);
    }

    private static ListCommentsPage createEmptyPage() {
      return new ListCommentsPage(null, null);
    }

    @Override
    protected ListCommentsPage createPage(
        PageContext<ListCommentsRequest, ListCommentsResponse, Comment> context,
        ListCommentsResponse response) {
      return new ListCommentsPage(context, response);
    }

    @Override
    public ApiFuture<ListCommentsPage> createPageAsync(
        PageContext<ListCommentsRequest, ListCommentsResponse, Comment> context,
        ApiFuture<ListCommentsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCommentsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCommentsRequest,
          ListCommentsResponse,
          Comment,
          ListCommentsPage,
          ListCommentsFixedSizeCollection> {

    private ListCommentsFixedSizeCollection(List<ListCommentsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCommentsFixedSizeCollection createEmptyCollection() {
      return new ListCommentsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCommentsFixedSizeCollection createCollection(
        List<ListCommentsPage> pages, int collectionSize) {
      return new ListCommentsFixedSizeCollection(pages, collectionSize);
    }
  }
}
