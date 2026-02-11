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

package com.google.cloud.compute.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.PreviewFeaturesStub;
import com.google.cloud.compute.v1.stub.PreviewFeaturesStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The PreviewFeatures API.
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
 * try (PreviewFeaturesClient previewFeaturesClient = PreviewFeaturesClient.create()) {
 *   String project = "project-309310695";
 *   String previewFeature = "previewFeature-712516082";
 *   PreviewFeature response = previewFeaturesClient.get(project, previewFeature);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the PreviewFeaturesClient object to clean up resources
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
 *      <td><p> Get</td>
 *      <td><p> Returns the details of the given PreviewFeature.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetPreviewFeatureRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String previewFeature)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> List</td>
 *      <td><p> Returns the details of the given PreviewFeature.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(ListPreviewFeaturesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> list(String project)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPagedCallable()
 *           <li><p> listCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> Update</td>
 *      <td><p> Patches the given PreviewFeature. This method is used to enable or disable a PreviewFeature.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateAsync(UpdatePreviewFeatureRequest request)
 *      </ul>
 *      <p>Methods that return long-running operations have "Async" method variants that return `OperationFuture`, which is used to track polling of the service.</p>
 *      <ul>
 *           <li><p> updateAsync(String project, String previewFeature, PreviewFeature previewFeatureResource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateOperationCallable()
 *           <li><p> updateCallable()
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
 * <p>This class can be customized by passing in a custom instance of PreviewFeaturesSettings to
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
 * PreviewFeaturesSettings previewFeaturesSettings =
 *     PreviewFeaturesSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * PreviewFeaturesClient previewFeaturesClient =
 *     PreviewFeaturesClient.create(previewFeaturesSettings);
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
 * PreviewFeaturesSettings previewFeaturesSettings =
 *     PreviewFeaturesSettings.newBuilder().setEndpoint(myEndpoint).build();
 * PreviewFeaturesClient previewFeaturesClient =
 *     PreviewFeaturesClient.create(previewFeaturesSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class PreviewFeaturesClient implements BackgroundResource {
  private final PreviewFeaturesSettings settings;
  private final PreviewFeaturesStub stub;

  /** Constructs an instance of PreviewFeaturesClient with default settings. */
  public static final PreviewFeaturesClient create() throws IOException {
    return create(PreviewFeaturesSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of PreviewFeaturesClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final PreviewFeaturesClient create(PreviewFeaturesSettings settings)
      throws IOException {
    return new PreviewFeaturesClient(settings);
  }

  /**
   * Constructs an instance of PreviewFeaturesClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(PreviewFeaturesSettings).
   */
  public static final PreviewFeaturesClient create(PreviewFeaturesStub stub) {
    return new PreviewFeaturesClient(stub);
  }

  /**
   * Constructs an instance of PreviewFeaturesClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected PreviewFeaturesClient(PreviewFeaturesSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((PreviewFeaturesStubSettings) settings.getStubSettings()).createStub();
  }

  protected PreviewFeaturesClient(PreviewFeaturesStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final PreviewFeaturesSettings getSettings() {
    return settings;
  }

  public PreviewFeaturesStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of the given PreviewFeature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PreviewFeaturesClient previewFeaturesClient = PreviewFeaturesClient.create()) {
   *   String project = "project-309310695";
   *   String previewFeature = "previewFeature-712516082";
   *   PreviewFeature response = previewFeaturesClient.get(project, previewFeature);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param previewFeature Name of the PreviewFeature for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PreviewFeature get(String project, String previewFeature) {
    GetPreviewFeatureRequest request =
        GetPreviewFeatureRequest.newBuilder()
            .setProject(project)
            .setPreviewFeature(previewFeature)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of the given PreviewFeature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PreviewFeaturesClient previewFeaturesClient = PreviewFeaturesClient.create()) {
   *   GetPreviewFeatureRequest request =
   *       GetPreviewFeatureRequest.newBuilder()
   *           .setPreviewFeature("previewFeature-712516082")
   *           .setProject("project-309310695")
   *           .build();
   *   PreviewFeature response = previewFeaturesClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final PreviewFeature get(GetPreviewFeatureRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of the given PreviewFeature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PreviewFeaturesClient previewFeaturesClient = PreviewFeaturesClient.create()) {
   *   GetPreviewFeatureRequest request =
   *       GetPreviewFeatureRequest.newBuilder()
   *           .setPreviewFeature("previewFeature-712516082")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<PreviewFeature> future = previewFeaturesClient.getCallable().futureCall(request);
   *   // Do something.
   *   PreviewFeature response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetPreviewFeatureRequest, PreviewFeature> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of the given PreviewFeature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PreviewFeaturesClient previewFeaturesClient = PreviewFeaturesClient.create()) {
   *   String project = "project-309310695";
   *   for (PreviewFeature element : previewFeaturesClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListPreviewFeaturesRequest request =
        ListPreviewFeaturesRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of the given PreviewFeature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PreviewFeaturesClient previewFeaturesClient = PreviewFeaturesClient.create()) {
   *   ListPreviewFeaturesRequest request =
   *       ListPreviewFeaturesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   for (PreviewFeature element : previewFeaturesClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListPreviewFeaturesRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of the given PreviewFeature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PreviewFeaturesClient previewFeaturesClient = PreviewFeaturesClient.create()) {
   *   ListPreviewFeaturesRequest request =
   *       ListPreviewFeaturesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   ApiFuture<PreviewFeature> future =
   *       previewFeaturesClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (PreviewFeature element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListPreviewFeaturesRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the details of the given PreviewFeature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PreviewFeaturesClient previewFeaturesClient = PreviewFeaturesClient.create()) {
   *   ListPreviewFeaturesRequest request =
   *       ListPreviewFeaturesRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .setReturnPartialSuccess(true)
   *           .build();
   *   while (true) {
   *     PreviewFeatureList response = previewFeaturesClient.listCallable().call(request);
   *     for (PreviewFeature element : response.getItemsList()) {
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
  public final UnaryCallable<ListPreviewFeaturesRequest, PreviewFeatureList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the given PreviewFeature. This method is used to enable or disable a PreviewFeature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PreviewFeaturesClient previewFeaturesClient = PreviewFeaturesClient.create()) {
   *   String project = "project-309310695";
   *   String previewFeature = "previewFeature-712516082";
   *   PreviewFeature previewFeatureResource = PreviewFeature.newBuilder().build();
   *   Operation response =
   *       previewFeaturesClient.updateAsync(project, previewFeature, previewFeatureResource).get();
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param previewFeature Name of the PreviewFeature for this request.
   * @param previewFeatureResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> updateAsync(
      String project, String previewFeature, PreviewFeature previewFeatureResource) {
    UpdatePreviewFeatureRequest request =
        UpdatePreviewFeatureRequest.newBuilder()
            .setProject(project)
            .setPreviewFeature(previewFeature)
            .setPreviewFeatureResource(previewFeatureResource)
            .build();
    return updateAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the given PreviewFeature. This method is used to enable or disable a PreviewFeature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PreviewFeaturesClient previewFeaturesClient = PreviewFeaturesClient.create()) {
   *   UpdatePreviewFeatureRequest request =
   *       UpdatePreviewFeatureRequest.newBuilder()
   *           .setPreviewFeature("previewFeature-712516082")
   *           .setPreviewFeatureResource(PreviewFeature.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   Operation response = previewFeaturesClient.updateAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Operation, Operation> updateAsync(
      UpdatePreviewFeatureRequest request) {
    return updateOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the given PreviewFeature. This method is used to enable or disable a PreviewFeature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PreviewFeaturesClient previewFeaturesClient = PreviewFeaturesClient.create()) {
   *   UpdatePreviewFeatureRequest request =
   *       UpdatePreviewFeatureRequest.newBuilder()
   *           .setPreviewFeature("previewFeature-712516082")
   *           .setPreviewFeatureResource(PreviewFeature.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   OperationFuture<Operation, Operation> future =
   *       previewFeaturesClient.updateOperationCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdatePreviewFeatureRequest, Operation, Operation>
      updateOperationCallable() {
    return stub.updateOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Patches the given PreviewFeature. This method is used to enable or disable a PreviewFeature.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (PreviewFeaturesClient previewFeaturesClient = PreviewFeaturesClient.create()) {
   *   UpdatePreviewFeatureRequest request =
   *       UpdatePreviewFeatureRequest.newBuilder()
   *           .setPreviewFeature("previewFeature-712516082")
   *           .setPreviewFeatureResource(PreviewFeature.newBuilder().build())
   *           .setProject("project-309310695")
   *           .setRequestId("requestId693933066")
   *           .build();
   *   ApiFuture<Operation> future = previewFeaturesClient.updateCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdatePreviewFeatureRequest, Operation> updateCallable() {
    return stub.updateCallable();
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

  public static class ListPagedResponse
      extends AbstractPagedListResponse<
          ListPreviewFeaturesRequest,
          PreviewFeatureList,
          PreviewFeature,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListPreviewFeaturesRequest, PreviewFeatureList, PreviewFeature> context,
        ApiFuture<PreviewFeatureList> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage
      extends AbstractPage<
          ListPreviewFeaturesRequest, PreviewFeatureList, PreviewFeature, ListPage> {

    private ListPage(
        PageContext<ListPreviewFeaturesRequest, PreviewFeatureList, PreviewFeature> context,
        PreviewFeatureList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListPreviewFeaturesRequest, PreviewFeatureList, PreviewFeature> context,
        PreviewFeatureList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListPreviewFeaturesRequest, PreviewFeatureList, PreviewFeature> context,
        ApiFuture<PreviewFeatureList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListPreviewFeaturesRequest,
          PreviewFeatureList,
          PreviewFeature,
          ListPage,
          ListFixedSizeCollection> {

    private ListFixedSizeCollection(List<ListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFixedSizeCollection createEmptyCollection() {
      return new ListFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFixedSizeCollection createCollection(List<ListPage> pages, int collectionSize) {
      return new ListFixedSizeCollection(pages, collectionSize);
    }
  }
}
