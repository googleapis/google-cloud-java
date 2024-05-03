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

package com.google.ads.admanager.v1;

import com.google.ads.admanager.v1.stub.LabelServiceStub;
import com.google.ads.admanager.v1.stub.LabelServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling Label objects.
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
 * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
 *   LabelName name = LabelName.of("[NETWORK_CODE]", "[LABEL]");
 *   Label response = labelServiceClient.getLabel(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the LabelServiceClient object to clean up resources such
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
 *      <td><p> GetLabel</td>
 *      <td><p> API to retrieve a Label object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getLabel(GetLabelRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getLabel(LabelName name)
 *           <li><p> getLabel(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getLabelCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListLabels</td>
 *      <td><p> API to retrieve a list of Label objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listLabels(ListLabelsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listLabels(NetworkName parent)
 *           <li><p> listLabels(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listLabelsPagedCallable()
 *           <li><p> listLabelsCallable()
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
 * <p>This class can be customized by passing in a custom instance of LabelServiceSettings to
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
 * LabelServiceSettings labelServiceSettings =
 *     LabelServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * LabelServiceClient labelServiceClient = LabelServiceClient.create(labelServiceSettings);
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
 * LabelServiceSettings labelServiceSettings =
 *     LabelServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * LabelServiceClient labelServiceClient = LabelServiceClient.create(labelServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class LabelServiceClient implements BackgroundResource {
  private final LabelServiceSettings settings;
  private final LabelServiceStub stub;

  /** Constructs an instance of LabelServiceClient with default settings. */
  public static final LabelServiceClient create() throws IOException {
    return create(LabelServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of LabelServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final LabelServiceClient create(LabelServiceSettings settings) throws IOException {
    return new LabelServiceClient(settings);
  }

  /**
   * Constructs an instance of LabelServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(LabelServiceSettings).
   */
  public static final LabelServiceClient create(LabelServiceStub stub) {
    return new LabelServiceClient(stub);
  }

  /**
   * Constructs an instance of LabelServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected LabelServiceClient(LabelServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((LabelServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected LabelServiceClient(LabelServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final LabelServiceSettings getSettings() {
    return settings;
  }

  public LabelServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a Label object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   LabelName name = LabelName.of("[NETWORK_CODE]", "[LABEL]");
   *   Label response = labelServiceClient.getLabel(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Label. Format:
   *     `networks/{network_code}/labels/{label_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Label getLabel(LabelName name) {
    GetLabelRequest request =
        GetLabelRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a Label object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   String name = LabelName.of("[NETWORK_CODE]", "[LABEL]").toString();
   *   Label response = labelServiceClient.getLabel(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Label. Format:
   *     `networks/{network_code}/labels/{label_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Label getLabel(String name) {
    GetLabelRequest request = GetLabelRequest.newBuilder().setName(name).build();
    return getLabel(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a Label object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   GetLabelRequest request =
   *       GetLabelRequest.newBuilder()
   *           .setName(LabelName.of("[NETWORK_CODE]", "[LABEL]").toString())
   *           .build();
   *   Label response = labelServiceClient.getLabel(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Label getLabel(GetLabelRequest request) {
    return getLabelCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a Label object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   GetLabelRequest request =
   *       GetLabelRequest.newBuilder()
   *           .setName(LabelName.of("[NETWORK_CODE]", "[LABEL]").toString())
   *           .build();
   *   ApiFuture<Label> future = labelServiceClient.getLabelCallable().futureCall(request);
   *   // Do something.
   *   Label response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLabelRequest, Label> getLabelCallable() {
    return stub.getLabelCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of Label objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (Label element : labelServiceClient.listLabels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Labels. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLabelsPagedResponse listLabels(NetworkName parent) {
    ListLabelsRequest request =
        ListLabelsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of Label objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (Label element : labelServiceClient.listLabels(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Labels. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLabelsPagedResponse listLabels(String parent) {
    ListLabelsRequest request = ListLabelsRequest.newBuilder().setParent(parent).build();
    return listLabels(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of Label objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   ListLabelsRequest request =
   *       ListLabelsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (Label element : labelServiceClient.listLabels(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLabelsPagedResponse listLabels(ListLabelsRequest request) {
    return listLabelsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of Label objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   ListLabelsRequest request =
   *       ListLabelsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<Label> future = labelServiceClient.listLabelsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Label element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLabelsRequest, ListLabelsPagedResponse> listLabelsPagedCallable() {
    return stub.listLabelsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of Label objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (LabelServiceClient labelServiceClient = LabelServiceClient.create()) {
   *   ListLabelsRequest request =
   *       ListLabelsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListLabelsResponse response = labelServiceClient.listLabelsCallable().call(request);
   *     for (Label element : response.getLabelsList()) {
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
  public final UnaryCallable<ListLabelsRequest, ListLabelsResponse> listLabelsCallable() {
    return stub.listLabelsCallable();
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

  public static class ListLabelsPagedResponse
      extends AbstractPagedListResponse<
          ListLabelsRequest,
          ListLabelsResponse,
          Label,
          ListLabelsPage,
          ListLabelsFixedSizeCollection> {

    public static ApiFuture<ListLabelsPagedResponse> createAsync(
        PageContext<ListLabelsRequest, ListLabelsResponse, Label> context,
        ApiFuture<ListLabelsResponse> futureResponse) {
      ApiFuture<ListLabelsPage> futurePage =
          ListLabelsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListLabelsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListLabelsPagedResponse(ListLabelsPage page) {
      super(page, ListLabelsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLabelsPage
      extends AbstractPage<ListLabelsRequest, ListLabelsResponse, Label, ListLabelsPage> {

    private ListLabelsPage(
        PageContext<ListLabelsRequest, ListLabelsResponse, Label> context,
        ListLabelsResponse response) {
      super(context, response);
    }

    private static ListLabelsPage createEmptyPage() {
      return new ListLabelsPage(null, null);
    }

    @Override
    protected ListLabelsPage createPage(
        PageContext<ListLabelsRequest, ListLabelsResponse, Label> context,
        ListLabelsResponse response) {
      return new ListLabelsPage(context, response);
    }

    @Override
    public ApiFuture<ListLabelsPage> createPageAsync(
        PageContext<ListLabelsRequest, ListLabelsResponse, Label> context,
        ApiFuture<ListLabelsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLabelsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLabelsRequest,
          ListLabelsResponse,
          Label,
          ListLabelsPage,
          ListLabelsFixedSizeCollection> {

    private ListLabelsFixedSizeCollection(List<ListLabelsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLabelsFixedSizeCollection createEmptyCollection() {
      return new ListLabelsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLabelsFixedSizeCollection createCollection(
        List<ListLabelsPage> pages, int collectionSize) {
      return new ListLabelsFixedSizeCollection(pages, collectionSize);
    }
  }
}
