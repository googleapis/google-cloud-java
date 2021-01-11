/*
 * Copyright 2020 Google LLC
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
package com.google.cloud.compute.v1;

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
import com.google.cloud.compute.v1.stub.FirewallsStub;
import com.google.cloud.compute.v1.stub.FirewallsStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: The Firewalls API.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (FirewallsClient firewallsClient = FirewallsClient.create()) {
 *   String project = "";
 *   String firewall = "";
 *   Operation response = firewallsClient.delete(project, firewall);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the firewallsClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of FirewallsSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * FirewallsSettings firewallsSettings =
 *     FirewallsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * FirewallsClient firewallsClient =
 *     FirewallsClient.create(firewallsSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * FirewallsSettings firewallsSettings =
 *     FirewallsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * FirewallsClient firewallsClient =
 *     FirewallsClient.create(firewallsSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class FirewallsClient implements BackgroundResource {
  private final FirewallsSettings settings;
  private final FirewallsStub stub;

  /** Constructs an instance of FirewallsClient with default settings. */
  public static final FirewallsClient create() throws IOException {
    return create(FirewallsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of FirewallsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final FirewallsClient create(FirewallsSettings settings) throws IOException {
    return new FirewallsClient(settings);
  }

  /**
   * Constructs an instance of FirewallsClient, using the given stub for making calls. This is for
   * advanced usage - prefer to use FirewallsSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final FirewallsClient create(FirewallsStub stub) {
    return new FirewallsClient(stub);
  }

  /**
   * Constructs an instance of FirewallsClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected FirewallsClient(FirewallsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((FirewallsStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected FirewallsClient(FirewallsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final FirewallsSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public FirewallsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified firewall.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallsClient firewallsClient = FirewallsClient.create()) {
   *   String project = "";
   *   String firewall = "";
   *   Operation response = firewallsClient.delete(project, firewall);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param firewall Name of the firewall rule to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(String project, String firewall) {
    DeleteFirewallRequest request =
        DeleteFirewallRequest.newBuilder().setProject(project).setFirewall(firewall).build();
    return delete(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified firewall.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallsClient firewallsClient = FirewallsClient.create()) {
   *   String firewall = "";
   *   String project = "";
   *   DeleteFirewallRequest request = DeleteFirewallRequest.newBuilder()
   *     .setFirewall(firewall)
   *     .setProject(project)
   *     .build();
   *   Operation response = firewallsClient.delete(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation delete(DeleteFirewallRequest request) {
    return deleteCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes the specified firewall.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallsClient firewallsClient = FirewallsClient.create()) {
   *   String firewall = "";
   *   String project = "";
   *   DeleteFirewallRequest request = DeleteFirewallRequest.newBuilder()
   *     .setFirewall(firewall)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = firewallsClient.deleteCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteFirewallRequest, Operation> deleteCallable() {
    return stub.deleteCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified firewall.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallsClient firewallsClient = FirewallsClient.create()) {
   *   String project = "";
   *   String firewall = "";
   *   Firewall response = firewallsClient.get(project, firewall);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param firewall Name of the firewall rule to return.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Firewall get(String project, String firewall) {
    GetFirewallRequest request =
        GetFirewallRequest.newBuilder().setProject(project).setFirewall(firewall).build();
    return get(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified firewall.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallsClient firewallsClient = FirewallsClient.create()) {
   *   String firewall = "";
   *   String project = "";
   *   GetFirewallRequest request = GetFirewallRequest.newBuilder()
   *     .setFirewall(firewall)
   *     .setProject(project)
   *     .build();
   *   Firewall response = firewallsClient.get(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Firewall get(GetFirewallRequest request) {
    return getCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Returns the specified firewall.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallsClient firewallsClient = FirewallsClient.create()) {
   *   String firewall = "";
   *   String project = "";
   *   GetFirewallRequest request = GetFirewallRequest.newBuilder()
   *     .setFirewall(firewall)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Firewall&gt; future = firewallsClient.getCallable().futureCall(request);
   *   // Do something
   *   Firewall response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetFirewallRequest, Firewall> getCallable() {
    return stub.getCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a firewall rule in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallsClient firewallsClient = FirewallsClient.create()) {
   *   String project = "";
   *   Firewall firewallResource = Firewall.newBuilder().build();
   *   Operation response = firewallsClient.insert(project, firewallResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param firewallResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(String project, Firewall firewallResource) {
    InsertFirewallRequest request =
        InsertFirewallRequest.newBuilder()
            .setProject(project)
            .setFirewallResource(firewallResource)
            .build();
    return insert(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a firewall rule in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallsClient firewallsClient = FirewallsClient.create()) {
   *   Firewall firewallResource = Firewall.newBuilder().build();
   *   String project = "";
   *   InsertFirewallRequest request = InsertFirewallRequest.newBuilder()
   *     .setFirewallResource(firewallResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = firewallsClient.insert(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation insert(InsertFirewallRequest request) {
    return insertCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a firewall rule in the specified project using the data included in the request.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallsClient firewallsClient = FirewallsClient.create()) {
   *   Firewall firewallResource = Firewall.newBuilder().build();
   *   String project = "";
   *   InsertFirewallRequest request = InsertFirewallRequest.newBuilder()
   *     .setFirewallResource(firewallResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = firewallsClient.insertCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<InsertFirewallRequest, Operation> insertCallable() {
    return stub.insertCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of firewall rules available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallsClient firewallsClient = FirewallsClient.create()) {
   *   String project = "";
   *   for (Firewall element : firewallsClient.list(project).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(String project) {
    ListFirewallsRequest request = ListFirewallsRequest.newBuilder().setProject(project).build();
    return list(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of firewall rules available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallsClient firewallsClient = FirewallsClient.create()) {
   *   String project = "";
   *   ListFirewallsRequest request = ListFirewallsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   for (Firewall element : firewallsClient.list(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListPagedResponse list(ListFirewallsRequest request) {
    return listPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of firewall rules available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallsClient firewallsClient = FirewallsClient.create()) {
   *   String project = "";
   *   ListFirewallsRequest request = ListFirewallsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;ListPagedResponse&gt; future = firewallsClient.listPagedCallable().futureCall(request);
   *   // Do something
   *   for (Firewall element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListFirewallsRequest, ListPagedResponse> listPagedCallable() {
    return stub.listPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Retrieves the list of firewall rules available to the specified project.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallsClient firewallsClient = FirewallsClient.create()) {
   *   String project = "";
   *   ListFirewallsRequest request = ListFirewallsRequest.newBuilder()
   *     .setProject(project)
   *     .build();
   *   while (true) {
   *     FirewallList response = firewallsClient.listCallable().call(request);
   *     for (Firewall element : response.getItemsList()) {
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
  public final UnaryCallable<ListFirewallsRequest, FirewallList> listCallable() {
    return stub.listCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified firewall rule with the data included in the request. This method supports
   * PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallsClient firewallsClient = FirewallsClient.create()) {
   *   String project = "";
   *   String firewall = "";
   *   Firewall firewallResource = Firewall.newBuilder().build();
   *   Operation response = firewallsClient.patch(project, firewall, firewallResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param firewall Name of the firewall rule to patch.
   * @param firewallResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(String project, String firewall, Firewall firewallResource) {
    PatchFirewallRequest request =
        PatchFirewallRequest.newBuilder()
            .setProject(project)
            .setFirewall(firewall)
            .setFirewallResource(firewallResource)
            .build();
    return patch(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified firewall rule with the data included in the request. This method supports
   * PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallsClient firewallsClient = FirewallsClient.create()) {
   *   String firewall = "";
   *   Firewall firewallResource = Firewall.newBuilder().build();
   *   String project = "";
   *   PatchFirewallRequest request = PatchFirewallRequest.newBuilder()
   *     .setFirewall(firewall)
   *     .setFirewallResource(firewallResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = firewallsClient.patch(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation patch(PatchFirewallRequest request) {
    return patchCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified firewall rule with the data included in the request. This method supports
   * PATCH semantics and uses the JSON merge patch format and processing rules.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallsClient firewallsClient = FirewallsClient.create()) {
   *   String firewall = "";
   *   Firewall firewallResource = Firewall.newBuilder().build();
   *   String project = "";
   *   PatchFirewallRequest request = PatchFirewallRequest.newBuilder()
   *     .setFirewall(firewall)
   *     .setFirewallResource(firewallResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = firewallsClient.patchCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<PatchFirewallRequest, Operation> patchCallable() {
    return stub.patchCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified firewall rule with the data included in the request. Note that all fields
   * will be updated if using PUT, even fields that are not specified. To update individual fields,
   * please use PATCH instead.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallsClient firewallsClient = FirewallsClient.create()) {
   *   String project = "";
   *   String firewall = "";
   *   Firewall firewallResource = Firewall.newBuilder().build();
   *   Operation response = firewallsClient.update(project, firewall, firewallResource);
   * }
   * </code></pre>
   *
   * @param project Project ID for this request.
   * @param firewall Name of the firewall rule to update.
   * @param firewallResource The body resource for this request
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(String project, String firewall, Firewall firewallResource) {
    UpdateFirewallRequest request =
        UpdateFirewallRequest.newBuilder()
            .setProject(project)
            .setFirewall(firewall)
            .setFirewallResource(firewallResource)
            .build();
    return update(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified firewall rule with the data included in the request. Note that all fields
   * will be updated if using PUT, even fields that are not specified. To update individual fields,
   * please use PATCH instead.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallsClient firewallsClient = FirewallsClient.create()) {
   *   String firewall = "";
   *   Firewall firewallResource = Firewall.newBuilder().build();
   *   String project = "";
   *   UpdateFirewallRequest request = UpdateFirewallRequest.newBuilder()
   *     .setFirewall(firewall)
   *     .setFirewallResource(firewallResource)
   *     .setProject(project)
   *     .build();
   *   Operation response = firewallsClient.update(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Operation update(UpdateFirewallRequest request) {
    return updateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates the specified firewall rule with the data included in the request. Note that all fields
   * will be updated if using PUT, even fields that are not specified. To update individual fields,
   * please use PATCH instead.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (FirewallsClient firewallsClient = FirewallsClient.create()) {
   *   String firewall = "";
   *   Firewall firewallResource = Firewall.newBuilder().build();
   *   String project = "";
   *   UpdateFirewallRequest request = UpdateFirewallRequest.newBuilder()
   *     .setFirewall(firewall)
   *     .setFirewallResource(firewallResource)
   *     .setProject(project)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = firewallsClient.updateCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateFirewallRequest, Operation> updateCallable() {
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
          ListFirewallsRequest, FirewallList, Firewall, ListPage, ListFixedSizeCollection> {

    public static ApiFuture<ListPagedResponse> createAsync(
        PageContext<ListFirewallsRequest, FirewallList, Firewall> context,
        ApiFuture<FirewallList> futureResponse) {
      ApiFuture<ListPage> futurePage =
          ListPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListPage, ListPagedResponse>() {
            @Override
            public ListPagedResponse apply(ListPage input) {
              return new ListPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListPagedResponse(ListPage page) {
      super(page, ListFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListPage
      extends AbstractPage<ListFirewallsRequest, FirewallList, Firewall, ListPage> {

    private ListPage(
        PageContext<ListFirewallsRequest, FirewallList, Firewall> context, FirewallList response) {
      super(context, response);
    }

    private static ListPage createEmptyPage() {
      return new ListPage(null, null);
    }

    @Override
    protected ListPage createPage(
        PageContext<ListFirewallsRequest, FirewallList, Firewall> context, FirewallList response) {
      return new ListPage(context, response);
    }

    @Override
    public ApiFuture<ListPage> createPageAsync(
        PageContext<ListFirewallsRequest, FirewallList, Firewall> context,
        ApiFuture<FirewallList> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFirewallsRequest, FirewallList, Firewall, ListPage, ListFixedSizeCollection> {

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
