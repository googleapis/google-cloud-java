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
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.compute.v1.stub.ManagedRulesetsStub;
import com.google.cloud.compute.v1.stub.ManagedRulesetsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The ManagedRulesets API.
 *
 * <p>This client uses ManagedRulesets version 2026-09-01.
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
 * try (ManagedRulesetsClient managedRulesetsClient = ManagedRulesetsClient.create()) {
 *   String project = "project-309310695";
 *   String managedRuleset = "managedRuleset1612348231";
 *   ManagedRuleset response = managedRulesetsClient.get(project, managedRuleset);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ManagedRulesetsClient object to clean up resources
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
 *      <td><p> Gets the details for the specified managed ruleset name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> get(GetManagedRulesetRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> get(String project, String managedRuleset)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> List</td>
 *      <td><p> Retrieves the list of all the managed rulesets available.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> list(ListManagedRulesetsRequest request)
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
 *  </table>
 *
 * <p>See the individual methods for example code.
 *
 * <p>Many parameters require resource names to be formatted in a particular way. To assist with
 * these names, this class includes a format method for each type of name, and additionally a parse
 * method to extract the individual identifiers contained within names that are returned.
 *
 * <p>This class can be customized by passing in a custom instance of ManagedRulesetsSettings to
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
 * ManagedRulesetsSettings managedRulesetsSettings =
 *     ManagedRulesetsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ManagedRulesetsClient managedRulesetsClient =
 *     ManagedRulesetsClient.create(managedRulesetsSettings);
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
 * ManagedRulesetsSettings managedRulesetsSettings =
 *     ManagedRulesetsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ManagedRulesetsClient managedRulesetsClient =
 *     ManagedRulesetsClient.create(managedRulesetsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class ManagedRulesetsClient implements BackgroundResource {
  private final @Nullable ManagedRulesetsSettings settings;
  private final ManagedRulesetsStub stub;

  /** Constructs an instance of ManagedRulesetsClient with default settings. */
  public static final ManagedRulesetsClient create() throws IOException {
    return create(ManagedRulesetsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ManagedRulesetsClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ManagedRulesetsClient create(ManagedRulesetsSettings settings)
      throws IOException {
    return new ManagedRulesetsClient(settings);
  }

  /**
   * Constructs an instance of ManagedRulesetsClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(ManagedRulesetsSettings).
   */
  public static final ManagedRulesetsClient create(ManagedRulesetsStub stub) {
    return new ManagedRulesetsClient(stub);
  }

  /**
   * Constructs an instance of ManagedRulesetsClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected ManagedRulesetsClient(ManagedRulesetsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ManagedRulesetsStubSettings) settings.getStubSettings()).createStub();
  }

  protected ManagedRulesetsClient(ManagedRulesetsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable ManagedRulesetsSettings getSettings() {
    return settings;
  }

  public ManagedRulesetsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details for the specified managed ruleset name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedRulesetsClient managedRulesetsClient = ManagedRulesetsClient.create()) {
   *   String project = "project-309310695";
   *   String managedRuleset = "managedRuleset1612348231";
   *   ManagedRuleset response = managedRulesetsClient.get(project, managedRuleset);
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @param managedRuleset Name of the managed ruleset to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ManagedRuleset get(String project, String managedRuleset) {
    GetManagedRulesetRequest request =
        GetManagedRulesetRequest.newBuilder()
            .setProject(project)
            .setManagedRuleset(managedRuleset)
            .build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details for the specified managed ruleset name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedRulesetsClient managedRulesetsClient = ManagedRulesetsClient.create()) {
   *   GetManagedRulesetRequest request =
   *       GetManagedRulesetRequest.newBuilder()
   *           .setManagedRuleset("managedRuleset1612348231")
   *           .setProject("project-309310695")
   *           .build();
   *   ManagedRuleset response = managedRulesetsClient.get(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ManagedRuleset get(GetManagedRulesetRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the details for the specified managed ruleset name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedRulesetsClient managedRulesetsClient = ManagedRulesetsClient.create()) {
   *   GetManagedRulesetRequest request =
   *       GetManagedRulesetRequest.newBuilder()
   *           .setManagedRuleset("managedRuleset1612348231")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<ManagedRuleset> future = managedRulesetsClient.getCallable().futureCall(request);
   *   // Do something.
   *   ManagedRuleset response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetManagedRulesetRequest, ManagedRuleset> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all the managed rulesets available.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedRulesetsClient managedRulesetsClient = ManagedRulesetsClient.create()) {
   *   String project = "project-309310695";
   *   for (ManagedRuleset element : managedRulesetsClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListManagedRulesetsRequest request =
        ListManagedRulesetsRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all the managed rulesets available.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedRulesetsClient managedRulesetsClient = ManagedRulesetsClient.create()) {
   *   ListManagedRulesetsRequest request =
   *       ListManagedRulesetsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .build();
   *   for (ManagedRuleset element : managedRulesetsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListManagedRulesetsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all the managed rulesets available.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedRulesetsClient managedRulesetsClient = ManagedRulesetsClient.create()) {
   *   ListManagedRulesetsRequest request =
   *       ListManagedRulesetsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .build();
   *   ApiFuture<ManagedRuleset> future =
   *       managedRulesetsClient.listPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ManagedRuleset element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListManagedRulesetsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the list of all the managed rulesets available.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ManagedRulesetsClient managedRulesetsClient = ManagedRulesetsClient.create()) {
   *   ListManagedRulesetsRequest request =
   *       ListManagedRulesetsRequest.newBuilder()
   *           .setFilter("filter-1274492040")
   *           .setMaxResults(1128457243)
   *           .setOrderBy("orderBy-1207110587")
   *           .setPageToken("pageToken873572522")
   *           .setProject("project-309310695")
   *           .build();
   *   while (true) {
   *     ManagedRulesetList response = managedRulesetsClient.listCallable().call(request);
   *     for (ManagedRuleset element : response.getItemsList()) {
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
  public final UnaryCallable<ListManagedRulesetsRequest, ManagedRulesetList> listCallable() {
    return stub.listCallable();
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
          ListManagedRulesetsRequest,
          ManagedRulesetList,
          ManagedRuleset,
          ListPage,
          ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListManagedRulesetsRequest, ManagedRulesetList, ManagedRuleset> context,
        ApiFuture<ManagedRulesetList> futureResponse) {
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
          ListManagedRulesetsRequest, ManagedRulesetList, ManagedRuleset, ListPage> {

    private ListPage(
        @Nullable PageContext<ListManagedRulesetsRequest, ManagedRulesetList, ManagedRuleset>
            context,
        @Nullable ManagedRulesetList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        @Nullable PageContext<ListManagedRulesetsRequest, ManagedRulesetList, ManagedRuleset>
            context,
        @Nullable ManagedRulesetList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        @Nullable PageContext<ListManagedRulesetsRequest, ManagedRulesetList, ManagedRuleset>
            context,
        ApiFuture<ManagedRulesetList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListManagedRulesetsRequest,
          ManagedRulesetList,
          ManagedRuleset,
          ListPage,
          ListFixedSizeCollection> {

    private ListFixedSizeCollection(@Nullable List<ListPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFixedSizeCollection createEmptyCollection() {
      return new ListFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFixedSizeCollection createCollection(
        @Nullable List<ListPage> pages, int collectionSize) {
      return new ListFixedSizeCollection(pages, collectionSize);
    }
  }
}
