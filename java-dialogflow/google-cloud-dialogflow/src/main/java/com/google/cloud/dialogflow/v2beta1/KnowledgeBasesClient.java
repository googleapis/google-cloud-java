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
import com.google.cloud.dialogflow.v2beta1.stub.KnowledgeBasesStub;
import com.google.cloud.dialogflow.v2beta1.stub.KnowledgeBasesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing
 * [KnowledgeBases][google.cloud.dialogflow.v2beta1.KnowledgeBase].
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <p>Note: close() needs to be called on the KnowledgeBasesClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of KnowledgeBasesSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * KnowledgeBasesSettings knowledgeBasesSettings =
 *     KnowledgeBasesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create(knowledgeBasesSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * KnowledgeBasesSettings knowledgeBasesSettings =
 *     KnowledgeBasesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * KnowledgeBasesClient knowledgeBasesClient = KnowledgeBasesClient.create(knowledgeBasesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator")
public class KnowledgeBasesClient implements BackgroundResource {
  private final KnowledgeBasesSettings settings;
  private final KnowledgeBasesStub stub;

  /** Constructs an instance of KnowledgeBasesClient with default settings. */
  public static final KnowledgeBasesClient create() throws IOException {
    return create(KnowledgeBasesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of KnowledgeBasesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final KnowledgeBasesClient create(KnowledgeBasesSettings settings)
      throws IOException {
    return new KnowledgeBasesClient(settings);
  }

  /**
   * Constructs an instance of KnowledgeBasesClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(KnowledgeBasesSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final KnowledgeBasesClient create(KnowledgeBasesStub stub) {
    return new KnowledgeBasesClient(stub);
  }

  /**
   * Constructs an instance of KnowledgeBasesClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected KnowledgeBasesClient(KnowledgeBasesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((KnowledgeBasesStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected KnowledgeBasesClient(KnowledgeBasesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final KnowledgeBasesSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public KnowledgeBasesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all knowledge bases of the specified agent.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * @param parent Required. The project to list of knowledge bases for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListKnowledgeBasesPagedResponse listKnowledgeBases(LocationName parent) {
    ListKnowledgeBasesRequest request =
        ListKnowledgeBasesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listKnowledgeBases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all knowledge bases of the specified agent.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * @param parent Required. The project to list of knowledge bases for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListKnowledgeBasesPagedResponse listKnowledgeBases(ProjectName parent) {
    ListKnowledgeBasesRequest request =
        ListKnowledgeBasesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listKnowledgeBases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all knowledge bases of the specified agent.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * @param parent Required. The project to list of knowledge bases for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListKnowledgeBasesPagedResponse listKnowledgeBases(String parent) {
    ListKnowledgeBasesRequest request =
        ListKnowledgeBasesRequest.newBuilder().setParent(parent).build();
    return listKnowledgeBases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all knowledge bases of the specified agent.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListKnowledgeBasesPagedResponse listKnowledgeBases(
      ListKnowledgeBasesRequest request) {
    return listKnowledgeBasesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all knowledge bases of the specified agent.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListKnowledgeBasesRequest, ListKnowledgeBasesPagedResponse>
      listKnowledgeBasesPagedCallable() {
    return stub.listKnowledgeBasesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of all knowledge bases of the specified agent.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<ListKnowledgeBasesRequest, ListKnowledgeBasesResponse>
      listKnowledgeBasesCallable() {
    return stub.listKnowledgeBasesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * @param name Required. The name of the knowledge base to retrieve. Format `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/knowledgeBases/&lt;Knowledge Base ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KnowledgeBase getKnowledgeBase(KnowledgeBaseName name) {
    GetKnowledgeBaseRequest request =
        GetKnowledgeBaseRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getKnowledgeBase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * @param name Required. The name of the knowledge base to retrieve. Format `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/knowledgeBases/&lt;Knowledge Base ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KnowledgeBase getKnowledgeBase(String name) {
    GetKnowledgeBaseRequest request = GetKnowledgeBaseRequest.newBuilder().setName(name).build();
    return getKnowledgeBase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KnowledgeBase getKnowledgeBase(GetKnowledgeBaseRequest request) {
    return getKnowledgeBaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<GetKnowledgeBaseRequest, KnowledgeBase> getKnowledgeBaseCallable() {
    return stub.getKnowledgeBaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * @param parent Required. The project to create a knowledge base for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @param knowledgeBase Required. The knowledge base to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KnowledgeBase createKnowledgeBase(LocationName parent, KnowledgeBase knowledgeBase) {
    CreateKnowledgeBaseRequest request =
        CreateKnowledgeBaseRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setKnowledgeBase(knowledgeBase)
            .build();
    return createKnowledgeBase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * @param parent Required. The project to create a knowledge base for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @param knowledgeBase Required. The knowledge base to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KnowledgeBase createKnowledgeBase(ProjectName parent, KnowledgeBase knowledgeBase) {
    CreateKnowledgeBaseRequest request =
        CreateKnowledgeBaseRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setKnowledgeBase(knowledgeBase)
            .build();
    return createKnowledgeBase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * @param parent Required. The project to create a knowledge base for. Format:
   *     `projects/&lt;Project ID&gt;/locations/&lt;Location ID&gt;`.
   * @param knowledgeBase Required. The knowledge base to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KnowledgeBase createKnowledgeBase(String parent, KnowledgeBase knowledgeBase) {
    CreateKnowledgeBaseRequest request =
        CreateKnowledgeBaseRequest.newBuilder()
            .setParent(parent)
            .setKnowledgeBase(knowledgeBase)
            .build();
    return createKnowledgeBase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KnowledgeBase createKnowledgeBase(CreateKnowledgeBaseRequest request) {
    return createKnowledgeBaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<CreateKnowledgeBaseRequest, KnowledgeBase>
      createKnowledgeBaseCallable() {
    return stub.createKnowledgeBaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * @param name Required. The name of the knowledge base to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/knowledgeBases/&lt;Knowledge Base ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteKnowledgeBase(KnowledgeBaseName name) {
    DeleteKnowledgeBaseRequest request =
        DeleteKnowledgeBaseRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteKnowledgeBase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * @param name Required. The name of the knowledge base to delete. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/knowledgeBases/&lt;Knowledge Base ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteKnowledgeBase(String name) {
    DeleteKnowledgeBaseRequest request =
        DeleteKnowledgeBaseRequest.newBuilder().setName(name).build();
    deleteKnowledgeBase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteKnowledgeBase(DeleteKnowledgeBaseRequest request) {
    deleteKnowledgeBaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<DeleteKnowledgeBaseRequest, Empty> deleteKnowledgeBaseCallable() {
    return stub.deleteKnowledgeBaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * @param knowledgeBase Required. The knowledge base to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KnowledgeBase updateKnowledgeBase(KnowledgeBase knowledgeBase) {
    UpdateKnowledgeBaseRequest request =
        UpdateKnowledgeBaseRequest.newBuilder().setKnowledgeBase(knowledgeBase).build();
    return updateKnowledgeBase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * @param knowledgeBase Required. The knowledge base to update.
   * @param updateMask Optional. Not specified means `update all`. Currently, only `display_name`
   *     can be updated, an InvalidArgument will be returned for attempting to update other fields.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KnowledgeBase updateKnowledgeBase(
      KnowledgeBase knowledgeBase, FieldMask updateMask) {
    UpdateKnowledgeBaseRequest request =
        UpdateKnowledgeBaseRequest.newBuilder()
            .setKnowledgeBase(knowledgeBase)
            .setUpdateMask(updateMask)
            .build();
    return updateKnowledgeBase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final KnowledgeBase updateKnowledgeBase(UpdateKnowledgeBaseRequest request) {
    return updateKnowledgeBaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the specified knowledge base.
   *
   * <p>Note: The `projects.agent.knowledgeBases` resource is deprecated; only use
   * `projects.knowledgeBases`.
   *
   * <p>Sample code:
   */
  public final UnaryCallable<UpdateKnowledgeBaseRequest, KnowledgeBase>
      updateKnowledgeBaseCallable() {
    return stub.updateKnowledgeBaseCallable();
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

  public static class ListKnowledgeBasesPagedResponse
      extends AbstractPagedListResponse<
          ListKnowledgeBasesRequest,
          ListKnowledgeBasesResponse,
          KnowledgeBase,
          ListKnowledgeBasesPage,
          ListKnowledgeBasesFixedSizeCollection> {

    public static ApiFuture<ListKnowledgeBasesPagedResponse> createAsync(
        PageContext<ListKnowledgeBasesRequest, ListKnowledgeBasesResponse, KnowledgeBase> context,
        ApiFuture<ListKnowledgeBasesResponse> futureResponse) {
      ApiFuture<ListKnowledgeBasesPage> futurePage =
          ListKnowledgeBasesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListKnowledgeBasesPage, ListKnowledgeBasesPagedResponse>() {
            @Override
            public ListKnowledgeBasesPagedResponse apply(ListKnowledgeBasesPage input) {
              return new ListKnowledgeBasesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListKnowledgeBasesPagedResponse(ListKnowledgeBasesPage page) {
      super(page, ListKnowledgeBasesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListKnowledgeBasesPage
      extends AbstractPage<
          ListKnowledgeBasesRequest,
          ListKnowledgeBasesResponse,
          KnowledgeBase,
          ListKnowledgeBasesPage> {

    private ListKnowledgeBasesPage(
        PageContext<ListKnowledgeBasesRequest, ListKnowledgeBasesResponse, KnowledgeBase> context,
        ListKnowledgeBasesResponse response) {
      super(context, response);
    }

    private static ListKnowledgeBasesPage createEmptyPage() {
      return new ListKnowledgeBasesPage(null, null);
    }

    @Override
    protected ListKnowledgeBasesPage createPage(
        PageContext<ListKnowledgeBasesRequest, ListKnowledgeBasesResponse, KnowledgeBase> context,
        ListKnowledgeBasesResponse response) {
      return new ListKnowledgeBasesPage(context, response);
    }

    @Override
    public ApiFuture<ListKnowledgeBasesPage> createPageAsync(
        PageContext<ListKnowledgeBasesRequest, ListKnowledgeBasesResponse, KnowledgeBase> context,
        ApiFuture<ListKnowledgeBasesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListKnowledgeBasesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListKnowledgeBasesRequest,
          ListKnowledgeBasesResponse,
          KnowledgeBase,
          ListKnowledgeBasesPage,
          ListKnowledgeBasesFixedSizeCollection> {

    private ListKnowledgeBasesFixedSizeCollection(
        List<ListKnowledgeBasesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListKnowledgeBasesFixedSizeCollection createEmptyCollection() {
      return new ListKnowledgeBasesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListKnowledgeBasesFixedSizeCollection createCollection(
        List<ListKnowledgeBasesPage> pages, int collectionSize) {
      return new ListKnowledgeBasesFixedSizeCollection(pages, collectionSize);
    }
  }
}
