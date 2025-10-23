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

package com.google.ads.admanager.v1;

import com.google.ads.admanager.v1.stub.CreativeTemplateServiceStub;
import com.google.ads.admanager.v1.stub.CreativeTemplateServiceStubSettings;
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
 * Service Description: Provides methods for handling `CreativeTemplate` objects.
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
 * try (CreativeTemplateServiceClient creativeTemplateServiceClient =
 *     CreativeTemplateServiceClient.create()) {
 *   CreativeTemplateName name = CreativeTemplateName.of("[NETWORK_CODE]", "[CREATIVE_TEMPLATE]");
 *   CreativeTemplate response = creativeTemplateServiceClient.getCreativeTemplate(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the CreativeTemplateServiceClient object to clean up
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
 *      <td><p> GetCreativeTemplate</td>
 *      <td><p> API to retrieve a `CreativeTemplate` object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCreativeTemplate(GetCreativeTemplateRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCreativeTemplate(CreativeTemplateName name)
 *           <li><p> getCreativeTemplate(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCreativeTemplateCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCreativeTemplates</td>
 *      <td><p> API to retrieve a list of `CreativeTemplate` objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCreativeTemplates(ListCreativeTemplatesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCreativeTemplates(NetworkName parent)
 *           <li><p> listCreativeTemplates(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCreativeTemplatesPagedCallable()
 *           <li><p> listCreativeTemplatesCallable()
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
 * <p>This class can be customized by passing in a custom instance of
 * CreativeTemplateServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * CreativeTemplateServiceSettings creativeTemplateServiceSettings =
 *     CreativeTemplateServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CreativeTemplateServiceClient creativeTemplateServiceClient =
 *     CreativeTemplateServiceClient.create(creativeTemplateServiceSettings);
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
 * CreativeTemplateServiceSettings creativeTemplateServiceSettings =
 *     CreativeTemplateServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CreativeTemplateServiceClient creativeTemplateServiceClient =
 *     CreativeTemplateServiceClient.create(creativeTemplateServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class CreativeTemplateServiceClient implements BackgroundResource {
  private final CreativeTemplateServiceSettings settings;
  private final CreativeTemplateServiceStub stub;

  /** Constructs an instance of CreativeTemplateServiceClient with default settings. */
  public static final CreativeTemplateServiceClient create() throws IOException {
    return create(CreativeTemplateServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CreativeTemplateServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CreativeTemplateServiceClient create(CreativeTemplateServiceSettings settings)
      throws IOException {
    return new CreativeTemplateServiceClient(settings);
  }

  /**
   * Constructs an instance of CreativeTemplateServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(CreativeTemplateServiceSettings).
   */
  public static final CreativeTemplateServiceClient create(CreativeTemplateServiceStub stub) {
    return new CreativeTemplateServiceClient(stub);
  }

  /**
   * Constructs an instance of CreativeTemplateServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected CreativeTemplateServiceClient(CreativeTemplateServiceSettings settings)
      throws IOException {
    this.settings = settings;
    this.stub = ((CreativeTemplateServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected CreativeTemplateServiceClient(CreativeTemplateServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final CreativeTemplateServiceSettings getSettings() {
    return settings;
  }

  public CreativeTemplateServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CreativeTemplate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeTemplateServiceClient creativeTemplateServiceClient =
   *     CreativeTemplateServiceClient.create()) {
   *   CreativeTemplateName name = CreativeTemplateName.of("[NETWORK_CODE]", "[CREATIVE_TEMPLATE]");
   *   CreativeTemplate response = creativeTemplateServiceClient.getCreativeTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CreativeTemplate. Format:
   *     `networks/{network_code}/creativeTemplates/{creative_template_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreativeTemplate getCreativeTemplate(CreativeTemplateName name) {
    GetCreativeTemplateRequest request =
        GetCreativeTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getCreativeTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CreativeTemplate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeTemplateServiceClient creativeTemplateServiceClient =
   *     CreativeTemplateServiceClient.create()) {
   *   String name = CreativeTemplateName.of("[NETWORK_CODE]", "[CREATIVE_TEMPLATE]").toString();
   *   CreativeTemplate response = creativeTemplateServiceClient.getCreativeTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the CreativeTemplate. Format:
   *     `networks/{network_code}/creativeTemplates/{creative_template_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreativeTemplate getCreativeTemplate(String name) {
    GetCreativeTemplateRequest request =
        GetCreativeTemplateRequest.newBuilder().setName(name).build();
    return getCreativeTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CreativeTemplate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeTemplateServiceClient creativeTemplateServiceClient =
   *     CreativeTemplateServiceClient.create()) {
   *   GetCreativeTemplateRequest request =
   *       GetCreativeTemplateRequest.newBuilder()
   *           .setName(CreativeTemplateName.of("[NETWORK_CODE]", "[CREATIVE_TEMPLATE]").toString())
   *           .build();
   *   CreativeTemplate response = creativeTemplateServiceClient.getCreativeTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CreativeTemplate getCreativeTemplate(GetCreativeTemplateRequest request) {
    return getCreativeTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a `CreativeTemplate` object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeTemplateServiceClient creativeTemplateServiceClient =
   *     CreativeTemplateServiceClient.create()) {
   *   GetCreativeTemplateRequest request =
   *       GetCreativeTemplateRequest.newBuilder()
   *           .setName(CreativeTemplateName.of("[NETWORK_CODE]", "[CREATIVE_TEMPLATE]").toString())
   *           .build();
   *   ApiFuture<CreativeTemplate> future =
   *       creativeTemplateServiceClient.getCreativeTemplateCallable().futureCall(request);
   *   // Do something.
   *   CreativeTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCreativeTemplateRequest, CreativeTemplate>
      getCreativeTemplateCallable() {
    return stub.getCreativeTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CreativeTemplate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeTemplateServiceClient creativeTemplateServiceClient =
   *     CreativeTemplateServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (CreativeTemplate element :
   *       creativeTemplateServiceClient.listCreativeTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CreativeTemplates. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCreativeTemplatesPagedResponse listCreativeTemplates(NetworkName parent) {
    ListCreativeTemplatesRequest request =
        ListCreativeTemplatesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCreativeTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CreativeTemplate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeTemplateServiceClient creativeTemplateServiceClient =
   *     CreativeTemplateServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (CreativeTemplate element :
   *       creativeTemplateServiceClient.listCreativeTemplates(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of CreativeTemplates. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCreativeTemplatesPagedResponse listCreativeTemplates(String parent) {
    ListCreativeTemplatesRequest request =
        ListCreativeTemplatesRequest.newBuilder().setParent(parent).build();
    return listCreativeTemplates(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CreativeTemplate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeTemplateServiceClient creativeTemplateServiceClient =
   *     CreativeTemplateServiceClient.create()) {
   *   ListCreativeTemplatesRequest request =
   *       ListCreativeTemplatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (CreativeTemplate element :
   *       creativeTemplateServiceClient.listCreativeTemplates(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCreativeTemplatesPagedResponse listCreativeTemplates(
      ListCreativeTemplatesRequest request) {
    return listCreativeTemplatesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CreativeTemplate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeTemplateServiceClient creativeTemplateServiceClient =
   *     CreativeTemplateServiceClient.create()) {
   *   ListCreativeTemplatesRequest request =
   *       ListCreativeTemplatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<CreativeTemplate> future =
   *       creativeTemplateServiceClient.listCreativeTemplatesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (CreativeTemplate element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCreativeTemplatesRequest, ListCreativeTemplatesPagedResponse>
      listCreativeTemplatesPagedCallable() {
    return stub.listCreativeTemplatesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of `CreativeTemplate` objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (CreativeTemplateServiceClient creativeTemplateServiceClient =
   *     CreativeTemplateServiceClient.create()) {
   *   ListCreativeTemplatesRequest request =
   *       ListCreativeTemplatesRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListCreativeTemplatesResponse response =
   *         creativeTemplateServiceClient.listCreativeTemplatesCallable().call(request);
   *     for (CreativeTemplate element : response.getCreativeTemplatesList()) {
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
  public final UnaryCallable<ListCreativeTemplatesRequest, ListCreativeTemplatesResponse>
      listCreativeTemplatesCallable() {
    return stub.listCreativeTemplatesCallable();
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

  public static class ListCreativeTemplatesPagedResponse
      extends AbstractPagedListResponse<
          ListCreativeTemplatesRequest,
          ListCreativeTemplatesResponse,
          CreativeTemplate,
          ListCreativeTemplatesPage,
          ListCreativeTemplatesFixedSizeCollection> {

    public static ApiFuture<ListCreativeTemplatesPagedResponse> createAsync(
        PageContext<ListCreativeTemplatesRequest, ListCreativeTemplatesResponse, CreativeTemplate>
            context,
        ApiFuture<ListCreativeTemplatesResponse> futureResponse) {
      ApiFuture<ListCreativeTemplatesPage> futurePage =
          ListCreativeTemplatesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCreativeTemplatesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCreativeTemplatesPagedResponse(ListCreativeTemplatesPage page) {
      super(page, ListCreativeTemplatesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCreativeTemplatesPage
      extends AbstractPage<
          ListCreativeTemplatesRequest,
          ListCreativeTemplatesResponse,
          CreativeTemplate,
          ListCreativeTemplatesPage> {

    private ListCreativeTemplatesPage(
        PageContext<ListCreativeTemplatesRequest, ListCreativeTemplatesResponse, CreativeTemplate>
            context,
        ListCreativeTemplatesResponse response) {
      super(context, response);
    }

    private static ListCreativeTemplatesPage createEmptyPage() {
      return new ListCreativeTemplatesPage(null, null);
    }

    @Override
    protected ListCreativeTemplatesPage createPage(
        PageContext<ListCreativeTemplatesRequest, ListCreativeTemplatesResponse, CreativeTemplate>
            context,
        ListCreativeTemplatesResponse response) {
      return new ListCreativeTemplatesPage(context, response);
    }

    @Override
    public ApiFuture<ListCreativeTemplatesPage> createPageAsync(
        PageContext<ListCreativeTemplatesRequest, ListCreativeTemplatesResponse, CreativeTemplate>
            context,
        ApiFuture<ListCreativeTemplatesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCreativeTemplatesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCreativeTemplatesRequest,
          ListCreativeTemplatesResponse,
          CreativeTemplate,
          ListCreativeTemplatesPage,
          ListCreativeTemplatesFixedSizeCollection> {

    private ListCreativeTemplatesFixedSizeCollection(
        List<ListCreativeTemplatesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCreativeTemplatesFixedSizeCollection createEmptyCollection() {
      return new ListCreativeTemplatesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCreativeTemplatesFixedSizeCollection createCollection(
        List<ListCreativeTemplatesPage> pages, int collectionSize) {
      return new ListCreativeTemplatesFixedSizeCollection(pages, collectionSize);
    }
  }
}
