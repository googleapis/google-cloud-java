/*
 * Copyright 2018 Google LLC
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
package com.google.cloud.dialogflow.v2beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.v2beta1.stub.ContextsStub;
import com.google.cloud.dialogflow.v2beta1.stub.ContextsStubSettings;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Manages contexts.
 *
 * <p>Refer to the [Dialogflow documentation](https://dialogflow.com/docs/contexts) for more details
 * about contexts. #
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (ContextsClient contextsClient = ContextsClient.create()) {
 *   ContextName name = ContextName.of("[PROJECT]", "[SESSION]", "[CONTEXT]");
 *   Context response = contextsClient.getContext(name);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the contextsClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <p>The surface of this class includes several types of Java methods for each of the API's
 * methods:
 *
 * <ol>
 *   <li> A "flattened" method. With this type of method, the fields of the request type have been
 *       converted into function parameters. It may be the case that not all fields are available as
 *       parameters, and not every API method will have a flattened method entry point.
 *   <li> A "request object" method. This type of method only takes one parameter, a request object,
 *       which must be constructed before the call. Not every API method will have a request object
 *       method.
 *   <li> A "callable" method. This type of method takes no parameters and returns an immutable API
 *       callable object, which can be used to initiate calls to the service.
 * </ol>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of ContextsSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * ContextsSettings contextsSettings =
 *     ContextsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ContextsClient contextsClient =
 *     ContextsClient.create(contextsSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * ContextsSettings contextsSettings =
 *     ContextsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ContextsClient contextsClient =
 *     ContextsClient.create(contextsSettings);
 * </code>
 * </pre>
 */
@Generated("by GAPIC v0.0.5")
@BetaApi
public class ContextsClient implements BackgroundResource {
  private final ContextsSettings settings;
  private final ContextsStub stub;

  /** Constructs an instance of ContextsClient with default settings. */
  public static final ContextsClient create() throws IOException {
    return create(ContextsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ContextsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ContextsClient create(ContextsSettings settings) throws IOException {
    return new ContextsClient(settings);
  }

  /**
   * Constructs an instance of ContextsClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use ContextsSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final ContextsClient create(ContextsStub stub) {
    return new ContextsClient(stub);
  }

  /**
   * Constructs an instance of ContextsClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected ContextsClient(ContextsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ContextsStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected ContextsClient(ContextsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ContextsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public ContextsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the list of all contexts in the specified session.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   SessionName parent = SessionName.of("[PROJECT]", "[SESSION]");
   *   for (Context element : contextsClient.listContexts(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The session to list all contexts from. Format: `projects/&lt;Project
   *     ID&gt;/agent/sessions/&lt;Session ID&gt;` or `projects/&lt;Project
   *     ID&gt;/agent/runtimes/&lt;Runtime ID&gt;/sessions/&lt;Session ID&gt;`. Note: Runtimes are
   *     under construction and will be available soon. If &lt;Runtime ID&gt; is not specified, we
   *     assume default 'sandbox' runtime.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContextsPagedResponse listContexts(SessionName parent) {
    ListContextsRequest request =
        ListContextsRequest.newBuilder().setParent(parent.toString()).build();
    return listContexts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the list of all contexts in the specified session.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   SessionName parent = SessionName.of("[PROJECT]", "[SESSION]");
   *   ListContextsRequest request = ListContextsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   for (Context element : contextsClient.listContexts(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListContextsPagedResponse listContexts(ListContextsRequest request) {
    return listContextsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the list of all contexts in the specified session.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   SessionName parent = SessionName.of("[PROJECT]", "[SESSION]");
   *   ListContextsRequest request = ListContextsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;ListContextsPagedResponse&gt; future = contextsClient.listContextsPagedCallable().futureCall(request);
   *   // Do something
   *   for (Context element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListContextsRequest, ListContextsPagedResponse>
      listContextsPagedCallable() {
    return stub.listContextsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the list of all contexts in the specified session.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   SessionName parent = SessionName.of("[PROJECT]", "[SESSION]");
   *   ListContextsRequest request = ListContextsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   while (true) {
   *     ListContextsResponse response = contextsClient.listContextsCallable().call(request);
   *     for (Context element : response.getContextsList()) {
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
  public final UnaryCallable<ListContextsRequest, ListContextsResponse> listContextsCallable() {
    return stub.listContextsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified context.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   ContextName name = ContextName.of("[PROJECT]", "[SESSION]", "[CONTEXT]");
   *   Context response = contextsClient.getContext(name);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the context. Format: `projects/&lt;Project
   *     ID&gt;/agent/sessions/&lt;Session ID&gt;/contexts/&lt;Context ID&gt;` or
   *     `projects/&lt;Project ID&gt;/agent/runtimes/&lt;Runtime ID&gt;/sessions/&lt;Session
   *     ID&gt;/contexts/&lt;Context ID&gt;`. Note: Runtimes are under construction and will be
   *     available soon. If &lt;Runtime ID&gt; is not specified, we assume default 'sandbox'
   *     runtime.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Context getContext(ContextName name) {

    GetContextRequest request = GetContextRequest.newBuilder().setName(name.toString()).build();
    return getContext(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified context.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   ContextName name = ContextName.of("[PROJECT]", "[SESSION]", "[CONTEXT]");
   *   GetContextRequest request = GetContextRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   Context response = contextsClient.getContext(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final Context getContext(GetContextRequest request) {
    return getContextCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the specified context.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   ContextName name = ContextName.of("[PROJECT]", "[SESSION]", "[CONTEXT]");
   *   GetContextRequest request = GetContextRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Context&gt; future = contextsClient.getContextCallable().futureCall(request);
   *   // Do something
   *   Context response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetContextRequest, Context> getContextCallable() {
    return stub.getContextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a context.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   SessionName parent = SessionName.of("[PROJECT]", "[SESSION]");
   *   Context context = Context.newBuilder().build();
   *   Context response = contextsClient.createContext(parent, context);
   * }
   * </code></pre>
   *
   * @param parent Required. The session to create a context for. Format: `projects/&lt;Project
   *     ID&gt;/agent/sessions/&lt;Session ID&gt;` or `projects/&lt;Project
   *     ID&gt;/agent/runtimes/&lt;Runtime ID&gt;/sessions/&lt;Session ID&gt;`. Note: Runtimes are
   *     under construction and will be available soon. If &lt;Runtime ID&gt; is not specified, we
   *     assume default 'sandbox' runtime.
   * @param context Required. The context to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Context createContext(SessionName parent, Context context) {

    CreateContextRequest request =
        CreateContextRequest.newBuilder().setParent(parent.toString()).setContext(context).build();
    return createContext(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a context.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   SessionName parent = SessionName.of("[PROJECT]", "[SESSION]");
   *   Context context = Context.newBuilder().build();
   *   CreateContextRequest request = CreateContextRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setContext(context)
   *     .build();
   *   Context response = contextsClient.createContext(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Context createContext(CreateContextRequest request) {
    return createContextCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a context.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   SessionName parent = SessionName.of("[PROJECT]", "[SESSION]");
   *   Context context = Context.newBuilder().build();
   *   CreateContextRequest request = CreateContextRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .setContext(context)
   *     .build();
   *   ApiFuture&lt;Context&gt; future = contextsClient.createContextCallable().futureCall(request);
   *   // Do something
   *   Context response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateContextRequest, Context> createContextCallable() {
    return stub.createContextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified context.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   Context context = Context.newBuilder().build();
   *   Context response = contextsClient.updateContext(context);
   * }
   * </code></pre>
   *
   * @param context Required. The context to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Context updateContext(Context context) {

    UpdateContextRequest request = UpdateContextRequest.newBuilder().setContext(context).build();
    return updateContext(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified context.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   Context context = Context.newBuilder().build();
   *   UpdateContextRequest request = UpdateContextRequest.newBuilder()
   *     .setContext(context)
   *     .build();
   *   Context response = contextsClient.updateContext(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Context updateContext(UpdateContextRequest request) {
    return updateContextCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified context.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   Context context = Context.newBuilder().build();
   *   UpdateContextRequest request = UpdateContextRequest.newBuilder()
   *     .setContext(context)
   *     .build();
   *   ApiFuture&lt;Context&gt; future = contextsClient.updateContextCallable().futureCall(request);
   *   // Do something
   *   Context response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateContextRequest, Context> updateContextCallable() {
    return stub.updateContextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified context.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   ContextName name = ContextName.of("[PROJECT]", "[SESSION]", "[CONTEXT]");
   *   contextsClient.deleteContext(name);
   * }
   * </code></pre>
   *
   * @param name Required. The name of the context to delete. Format: `projects/&lt;Project
   *     ID&gt;/agent/sessions/&lt;Session ID&gt;/contexts/&lt;Context ID&gt;` or
   *     `projects/&lt;Project ID&gt;/agent/runtimes/&lt;Runtime ID&gt;/sessions/&lt;Session
   *     ID&gt;/contexts/&lt;Context ID&gt;`. Note: Runtimes are under construction and will be
   *     available soon. If &lt;Runtime ID&gt; is not specified, we assume default 'sandbox'
   *     runtime.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteContext(ContextName name) {

    DeleteContextRequest request =
        DeleteContextRequest.newBuilder().setName(name.toString()).build();
    deleteContext(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified context.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   ContextName name = ContextName.of("[PROJECT]", "[SESSION]", "[CONTEXT]");
   *   DeleteContextRequest request = DeleteContextRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   contextsClient.deleteContext(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final void deleteContext(DeleteContextRequest request) {
    deleteContextCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified context.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   ContextName name = ContextName.of("[PROJECT]", "[SESSION]", "[CONTEXT]");
   *   DeleteContextRequest request = DeleteContextRequest.newBuilder()
   *     .setName(name.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = contextsClient.deleteContextCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteContextRequest, Empty> deleteContextCallable() {
    return stub.deleteContextCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes all active contexts in the specified session.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   SessionName parent = SessionName.of("[PROJECT]", "[SESSION]");
   *   contextsClient.deleteAllContexts(parent);
   * }
   * </code></pre>
   *
   * @param parent Required. The name of the session to delete all contexts from. Format:
   *     `projects/&lt;Project ID&gt;/agent/sessions/&lt;Session ID&gt;` or `projects/&lt;Project
   *     ID&gt;/agent/runtimes/&lt;Runtime ID&gt;/sessions/&lt;Session ID&gt;`. Note: Runtimes are
   *     under construction and will be available soon. If &lt;Runtime ID&gt; is not specified we
   *     assume default 'sandbox' runtime.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteAllContexts(SessionName parent) {

    DeleteAllContextsRequest request =
        DeleteAllContextsRequest.newBuilder().setParent(parent.toString()).build();
    deleteAllContexts(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes all active contexts in the specified session.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   SessionName parent = SessionName.of("[PROJECT]", "[SESSION]");
   *   DeleteAllContextsRequest request = DeleteAllContextsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   contextsClient.deleteAllContexts(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  private final void deleteAllContexts(DeleteAllContextsRequest request) {
    deleteAllContextsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes all active contexts in the specified session.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (ContextsClient contextsClient = ContextsClient.create()) {
   *   SessionName parent = SessionName.of("[PROJECT]", "[SESSION]");
   *   DeleteAllContextsRequest request = DeleteAllContextsRequest.newBuilder()
   *     .setParent(parent.toString())
   *     .build();
   *   ApiFuture&lt;Void&gt; future = contextsClient.deleteAllContextsCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteAllContextsRequest, Empty> deleteAllContextsCallable() {
    return stub.deleteAllContextsCallable();
  }

  @Override
  public final void close() throws Exception {
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

  public static class ListContextsPagedResponse
      extends AbstractPagedListResponse<
          ListContextsRequest, ListContextsResponse, Context, ListContextsPage,
          ListContextsFixedSizeCollection> {

    public static ApiFuture<ListContextsPagedResponse> createAsync(
        PageContext<ListContextsRequest, ListContextsResponse, Context> context,
        ApiFuture<ListContextsResponse> futureResponse) {
      ApiFuture<ListContextsPage> futurePage =
          ListContextsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListContextsPage, ListContextsPagedResponse>() {
            @Override
            public ListContextsPagedResponse apply(ListContextsPage input) {
              return new ListContextsPagedResponse(input);
            }
          });
    }

    private ListContextsPagedResponse(ListContextsPage page) {
      super(page, ListContextsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListContextsPage
      extends AbstractPage<ListContextsRequest, ListContextsResponse, Context, ListContextsPage> {

    private ListContextsPage(
        PageContext<ListContextsRequest, ListContextsResponse, Context> context,
        ListContextsResponse response) {
      super(context, response);
    }

    private static ListContextsPage createEmptyPage() {
      return new ListContextsPage(null, null);
    }

    @Override
    protected ListContextsPage createPage(
        PageContext<ListContextsRequest, ListContextsResponse, Context> context,
        ListContextsResponse response) {
      return new ListContextsPage(context, response);
    }

    @Override
    public ApiFuture<ListContextsPage> createPageAsync(
        PageContext<ListContextsRequest, ListContextsResponse, Context> context,
        ApiFuture<ListContextsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListContextsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListContextsRequest, ListContextsResponse, Context, ListContextsPage,
          ListContextsFixedSizeCollection> {

    private ListContextsFixedSizeCollection(List<ListContextsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListContextsFixedSizeCollection createEmptyCollection() {
      return new ListContextsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListContextsFixedSizeCollection createCollection(
        List<ListContextsPage> pages, int collectionSize) {
      return new ListContextsFixedSizeCollection(pages, collectionSize);
    }
  }
}
