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

import com.google.ads.admanager.v1.stub.TeamServiceStub;
import com.google.ads.admanager.v1.stub.TeamServiceStubSettings;
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
 * Service Description: Provides methods for handling Team objects.
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
 * try (TeamServiceClient teamServiceClient = TeamServiceClient.create()) {
 *   TeamName name = TeamName.of("[NETWORK_CODE]", "[TEAM]");
 *   Team response = teamServiceClient.getTeam(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TeamServiceClient object to clean up resources such as
 * threads. In the example above, try-with-resources is used, which automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetTeam</td>
 *      <td><p> API to retrieve a Team object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTeam(GetTeamRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTeam(TeamName name)
 *           <li><p> getTeam(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTeamCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTeams</td>
 *      <td><p> API to retrieve a list of Team objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTeams(ListTeamsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTeams(NetworkName parent)
 *           <li><p> listTeams(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTeamsPagedCallable()
 *           <li><p> listTeamsCallable()
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
 * <p>This class can be customized by passing in a custom instance of TeamServiceSettings to
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
 * TeamServiceSettings teamServiceSettings =
 *     TeamServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TeamServiceClient teamServiceClient = TeamServiceClient.create(teamServiceSettings);
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
 * TeamServiceSettings teamServiceSettings =
 *     TeamServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TeamServiceClient teamServiceClient = TeamServiceClient.create(teamServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class TeamServiceClient implements BackgroundResource {
  private final TeamServiceSettings settings;
  private final TeamServiceStub stub;

  /** Constructs an instance of TeamServiceClient with default settings. */
  public static final TeamServiceClient create() throws IOException {
    return create(TeamServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TeamServiceClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TeamServiceClient create(TeamServiceSettings settings) throws IOException {
    return new TeamServiceClient(settings);
  }

  /**
   * Constructs an instance of TeamServiceClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(TeamServiceSettings).
   */
  public static final TeamServiceClient create(TeamServiceStub stub) {
    return new TeamServiceClient(stub);
  }

  /**
   * Constructs an instance of TeamServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TeamServiceClient(TeamServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TeamServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected TeamServiceClient(TeamServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TeamServiceSettings getSettings() {
    return settings;
  }

  public TeamServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a Team object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TeamServiceClient teamServiceClient = TeamServiceClient.create()) {
   *   TeamName name = TeamName.of("[NETWORK_CODE]", "[TEAM]");
   *   Team response = teamServiceClient.getTeam(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Team. Format:
   *     `networks/{network_code}/teams/{team_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Team getTeam(TeamName name) {
    GetTeamRequest request =
        GetTeamRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTeam(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a Team object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TeamServiceClient teamServiceClient = TeamServiceClient.create()) {
   *   String name = TeamName.of("[NETWORK_CODE]", "[TEAM]").toString();
   *   Team response = teamServiceClient.getTeam(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Team. Format:
   *     `networks/{network_code}/teams/{team_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Team getTeam(String name) {
    GetTeamRequest request = GetTeamRequest.newBuilder().setName(name).build();
    return getTeam(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a Team object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TeamServiceClient teamServiceClient = TeamServiceClient.create()) {
   *   GetTeamRequest request =
   *       GetTeamRequest.newBuilder()
   *           .setName(TeamName.of("[NETWORK_CODE]", "[TEAM]").toString())
   *           .build();
   *   Team response = teamServiceClient.getTeam(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Team getTeam(GetTeamRequest request) {
    return getTeamCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a Team object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TeamServiceClient teamServiceClient = TeamServiceClient.create()) {
   *   GetTeamRequest request =
   *       GetTeamRequest.newBuilder()
   *           .setName(TeamName.of("[NETWORK_CODE]", "[TEAM]").toString())
   *           .build();
   *   ApiFuture<Team> future = teamServiceClient.getTeamCallable().futureCall(request);
   *   // Do something.
   *   Team response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTeamRequest, Team> getTeamCallable() {
    return stub.getTeamCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of Team objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TeamServiceClient teamServiceClient = TeamServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (Team element : teamServiceClient.listTeams(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Teams. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTeamsPagedResponse listTeams(NetworkName parent) {
    ListTeamsRequest request =
        ListTeamsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listTeams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of Team objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TeamServiceClient teamServiceClient = TeamServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (Team element : teamServiceClient.listTeams(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of Teams. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTeamsPagedResponse listTeams(String parent) {
    ListTeamsRequest request = ListTeamsRequest.newBuilder().setParent(parent).build();
    return listTeams(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of Team objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TeamServiceClient teamServiceClient = TeamServiceClient.create()) {
   *   ListTeamsRequest request =
   *       ListTeamsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (Team element : teamServiceClient.listTeams(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTeamsPagedResponse listTeams(ListTeamsRequest request) {
    return listTeamsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of Team objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TeamServiceClient teamServiceClient = TeamServiceClient.create()) {
   *   ListTeamsRequest request =
   *       ListTeamsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<Team> future = teamServiceClient.listTeamsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Team element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTeamsRequest, ListTeamsPagedResponse> listTeamsPagedCallable() {
    return stub.listTeamsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * API to retrieve a list of Team objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (TeamServiceClient teamServiceClient = TeamServiceClient.create()) {
   *   ListTeamsRequest request =
   *       ListTeamsRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListTeamsResponse response = teamServiceClient.listTeamsCallable().call(request);
   *     for (Team element : response.getTeamsList()) {
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
  public final UnaryCallable<ListTeamsRequest, ListTeamsResponse> listTeamsCallable() {
    return stub.listTeamsCallable();
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

  public static class ListTeamsPagedResponse
      extends AbstractPagedListResponse<
          ListTeamsRequest, ListTeamsResponse, Team, ListTeamsPage, ListTeamsFixedSizeCollection> {

    public static ApiFuture<ListTeamsPagedResponse> createAsync(
        PageContext<ListTeamsRequest, ListTeamsResponse, Team> context,
        ApiFuture<ListTeamsResponse> futureResponse) {
      ApiFuture<ListTeamsPage> futurePage =
          ListTeamsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListTeamsPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListTeamsPagedResponse(ListTeamsPage page) {
      super(page, ListTeamsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTeamsPage
      extends AbstractPage<ListTeamsRequest, ListTeamsResponse, Team, ListTeamsPage> {

    private ListTeamsPage(
        PageContext<ListTeamsRequest, ListTeamsResponse, Team> context,
        ListTeamsResponse response) {
      super(context, response);
    }

    private static ListTeamsPage createEmptyPage() {
      return new ListTeamsPage(null, null);
    }

    @Override
    protected ListTeamsPage createPage(
        PageContext<ListTeamsRequest, ListTeamsResponse, Team> context,
        ListTeamsResponse response) {
      return new ListTeamsPage(context, response);
    }

    @Override
    public ApiFuture<ListTeamsPage> createPageAsync(
        PageContext<ListTeamsRequest, ListTeamsResponse, Team> context,
        ApiFuture<ListTeamsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTeamsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTeamsRequest, ListTeamsResponse, Team, ListTeamsPage, ListTeamsFixedSizeCollection> {

    private ListTeamsFixedSizeCollection(List<ListTeamsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTeamsFixedSizeCollection createEmptyCollection() {
      return new ListTeamsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTeamsFixedSizeCollection createCollection(
        List<ListTeamsPage> pages, int collectionSize) {
      return new ListTeamsFixedSizeCollection(pages, collectionSize);
    }
  }
}
