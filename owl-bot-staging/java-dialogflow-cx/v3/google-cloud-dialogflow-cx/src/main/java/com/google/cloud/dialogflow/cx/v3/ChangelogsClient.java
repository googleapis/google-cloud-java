/*
 * Copyright 2022 Google LLC
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

package com.google.cloud.dialogflow.cx.v3;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.dialogflow.cx.v3.stub.ChangelogsStub;
import com.google.cloud.dialogflow.cx.v3.stub.ChangelogsStubSettings;
import com.google.cloud.location.GetLocationRequest;
import com.google.cloud.location.ListLocationsRequest;
import com.google.cloud.location.ListLocationsResponse;
import com.google.cloud.location.Location;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service for managing [Changelogs][google.cloud.dialogflow.cx.v3.Changelog].
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
 * try (ChangelogsClient changelogsClient = ChangelogsClient.create()) {
 *   ChangelogName name = ChangelogName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[CHANGELOG]");
 *   Changelog response = changelogsClient.getChangelog(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ChangelogsClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of ChangelogsSettings to
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
 * ChangelogsSettings changelogsSettings =
 *     ChangelogsSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ChangelogsClient changelogsClient = ChangelogsClient.create(changelogsSettings);
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
 * ChangelogsSettings changelogsSettings =
 *     ChangelogsSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ChangelogsClient changelogsClient = ChangelogsClient.create(changelogsSettings);
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
 * ChangelogsSettings changelogsSettings = ChangelogsSettings.newHttpJsonBuilder().build();
 * ChangelogsClient changelogsClient = ChangelogsClient.create(changelogsSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ChangelogsClient implements BackgroundResource {
  private final ChangelogsSettings settings;
  private final ChangelogsStub stub;

  /** Constructs an instance of ChangelogsClient with default settings. */
  public static final ChangelogsClient create() throws IOException {
    return create(ChangelogsSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ChangelogsClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ChangelogsClient create(ChangelogsSettings settings) throws IOException {
    return new ChangelogsClient(settings);
  }

  /**
   * Constructs an instance of ChangelogsClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(ChangelogsSettings).
   */
  public static final ChangelogsClient create(ChangelogsStub stub) {
    return new ChangelogsClient(stub);
  }

  /**
   * Constructs an instance of ChangelogsClient, using the given settings. This is protected so that
   * it is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected ChangelogsClient(ChangelogsSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ChangelogsStubSettings) settings.getStubSettings()).createStub();
  }

  protected ChangelogsClient(ChangelogsStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ChangelogsSettings getSettings() {
    return settings;
  }

  public ChangelogsStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of Changelogs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChangelogsClient changelogsClient = ChangelogsClient.create()) {
   *   AgentName parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]");
   *   for (Changelog element : changelogsClient.listChangelogs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The agent containing the changelogs. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChangelogsPagedResponse listChangelogs(AgentName parent) {
    ListChangelogsRequest request =
        ListChangelogsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listChangelogs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of Changelogs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChangelogsClient changelogsClient = ChangelogsClient.create()) {
   *   String parent = AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString();
   *   for (Changelog element : changelogsClient.listChangelogs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The agent containing the changelogs. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChangelogsPagedResponse listChangelogs(String parent) {
    ListChangelogsRequest request = ListChangelogsRequest.newBuilder().setParent(parent).build();
    return listChangelogs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of Changelogs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChangelogsClient changelogsClient = ChangelogsClient.create()) {
   *   ListChangelogsRequest request =
   *       ListChangelogsRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Changelog element : changelogsClient.listChangelogs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChangelogsPagedResponse listChangelogs(ListChangelogsRequest request) {
    return listChangelogsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of Changelogs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChangelogsClient changelogsClient = ChangelogsClient.create()) {
   *   ListChangelogsRequest request =
   *       ListChangelogsRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Changelog> future =
   *       changelogsClient.listChangelogsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Changelog element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListChangelogsRequest, ListChangelogsPagedResponse>
      listChangelogsPagedCallable() {
    return stub.listChangelogsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns the list of Changelogs.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChangelogsClient changelogsClient = ChangelogsClient.create()) {
   *   ListChangelogsRequest request =
   *       ListChangelogsRequest.newBuilder()
   *           .setParent(AgentName.of("[PROJECT]", "[LOCATION]", "[AGENT]").toString())
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListChangelogsResponse response = changelogsClient.listChangelogsCallable().call(request);
   *     for (Changelog element : response.getChangelogsList()) {
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
  public final UnaryCallable<ListChangelogsRequest, ListChangelogsResponse>
      listChangelogsCallable() {
    return stub.listChangelogsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified Changelog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChangelogsClient changelogsClient = ChangelogsClient.create()) {
   *   ChangelogName name = ChangelogName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[CHANGELOG]");
   *   Changelog response = changelogsClient.getChangelog(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the changelog to get. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/changelogs/&lt;Changelog
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Changelog getChangelog(ChangelogName name) {
    GetChangelogRequest request =
        GetChangelogRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getChangelog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified Changelog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChangelogsClient changelogsClient = ChangelogsClient.create()) {
   *   String name =
   *       ChangelogName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[CHANGELOG]").toString();
   *   Changelog response = changelogsClient.getChangelog(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the changelog to get. Format: `projects/&lt;Project
   *     ID&gt;/locations/&lt;Location ID&gt;/agents/&lt;Agent ID&gt;/changelogs/&lt;Changelog
   *     ID&gt;`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Changelog getChangelog(String name) {
    GetChangelogRequest request = GetChangelogRequest.newBuilder().setName(name).build();
    return getChangelog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified Changelog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChangelogsClient changelogsClient = ChangelogsClient.create()) {
   *   GetChangelogRequest request =
   *       GetChangelogRequest.newBuilder()
   *           .setName(
   *               ChangelogName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[CHANGELOG]").toString())
   *           .build();
   *   Changelog response = changelogsClient.getChangelog(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Changelog getChangelog(GetChangelogRequest request) {
    return getChangelogCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the specified Changelog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChangelogsClient changelogsClient = ChangelogsClient.create()) {
   *   GetChangelogRequest request =
   *       GetChangelogRequest.newBuilder()
   *           .setName(
   *               ChangelogName.of("[PROJECT]", "[LOCATION]", "[AGENT]", "[CHANGELOG]").toString())
   *           .build();
   *   ApiFuture<Changelog> future = changelogsClient.getChangelogCallable().futureCall(request);
   *   // Do something.
   *   Changelog response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetChangelogRequest, Changelog> getChangelogCallable() {
    return stub.getChangelogCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChangelogsClient changelogsClient = ChangelogsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Location element : changelogsClient.listLocations(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListLocationsPagedResponse listLocations(ListLocationsRequest request) {
    return listLocationsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChangelogsClient changelogsClient = ChangelogsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Location> future =
   *       changelogsClient.listLocationsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Location element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListLocationsRequest, ListLocationsPagedResponse>
      listLocationsPagedCallable() {
    return stub.listLocationsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists information about the supported locations for this service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChangelogsClient changelogsClient = ChangelogsClient.create()) {
   *   ListLocationsRequest request =
   *       ListLocationsRequest.newBuilder()
   *           .setName("name3373707")
   *           .setFilter("filter-1274492040")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListLocationsResponse response = changelogsClient.listLocationsCallable().call(request);
   *     for (Location element : response.getLocationsList()) {
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
  public final UnaryCallable<ListLocationsRequest, ListLocationsResponse> listLocationsCallable() {
    return stub.listLocationsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChangelogsClient changelogsClient = ChangelogsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   Location response = changelogsClient.getLocation(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Location getLocation(GetLocationRequest request) {
    return getLocationCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets information about a location.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChangelogsClient changelogsClient = ChangelogsClient.create()) {
   *   GetLocationRequest request = GetLocationRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Location> future = changelogsClient.getLocationCallable().futureCall(request);
   *   // Do something.
   *   Location response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetLocationRequest, Location> getLocationCallable() {
    return stub.getLocationCallable();
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

  public static class ListChangelogsPagedResponse
      extends AbstractPagedListResponse<
          ListChangelogsRequest,
          ListChangelogsResponse,
          Changelog,
          ListChangelogsPage,
          ListChangelogsFixedSizeCollection> {

    public static ApiFuture<ListChangelogsPagedResponse> createAsync(
        PageContext<ListChangelogsRequest, ListChangelogsResponse, Changelog> context,
        ApiFuture<ListChangelogsResponse> futureResponse) {
      ApiFuture<ListChangelogsPage> futurePage =
          ListChangelogsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListChangelogsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListChangelogsPagedResponse(ListChangelogsPage page) {
      super(page, ListChangelogsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListChangelogsPage
      extends AbstractPage<
          ListChangelogsRequest, ListChangelogsResponse, Changelog, ListChangelogsPage> {

    private ListChangelogsPage(
        PageContext<ListChangelogsRequest, ListChangelogsResponse, Changelog> context,
        ListChangelogsResponse response) {
      super(context, response);
    }

    private static ListChangelogsPage createEmptyPage() {
      return new ListChangelogsPage(null, null);
    }

    @Override
    protected ListChangelogsPage createPage(
        PageContext<ListChangelogsRequest, ListChangelogsResponse, Changelog> context,
        ListChangelogsResponse response) {
      return new ListChangelogsPage(context, response);
    }

    @Override
    public ApiFuture<ListChangelogsPage> createPageAsync(
        PageContext<ListChangelogsRequest, ListChangelogsResponse, Changelog> context,
        ApiFuture<ListChangelogsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListChangelogsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListChangelogsRequest,
          ListChangelogsResponse,
          Changelog,
          ListChangelogsPage,
          ListChangelogsFixedSizeCollection> {

    private ListChangelogsFixedSizeCollection(List<ListChangelogsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListChangelogsFixedSizeCollection createEmptyCollection() {
      return new ListChangelogsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListChangelogsFixedSizeCollection createCollection(
        List<ListChangelogsPage> pages, int collectionSize) {
      return new ListChangelogsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListLocationsPagedResponse
      extends AbstractPagedListResponse<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    public static ApiFuture<ListLocationsPagedResponse> createAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      ApiFuture<ListLocationsPage> futurePage =
          ListLocationsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListLocationsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListLocationsPagedResponse(ListLocationsPage page) {
      super(page, ListLocationsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListLocationsPage
      extends AbstractPage<
          ListLocationsRequest, ListLocationsResponse, Location, ListLocationsPage> {

    private ListLocationsPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      super(context, response);
    }

    private static ListLocationsPage createEmptyPage() {
      return new ListLocationsPage(null, null);
    }

    @Override
    protected ListLocationsPage createPage(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ListLocationsResponse response) {
      return new ListLocationsPage(context, response);
    }

    @Override
    public ApiFuture<ListLocationsPage> createPageAsync(
        PageContext<ListLocationsRequest, ListLocationsResponse, Location> context,
        ApiFuture<ListLocationsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListLocationsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListLocationsRequest,
          ListLocationsResponse,
          Location,
          ListLocationsPage,
          ListLocationsFixedSizeCollection> {

    private ListLocationsFixedSizeCollection(List<ListLocationsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListLocationsFixedSizeCollection createEmptyCollection() {
      return new ListLocationsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListLocationsFixedSizeCollection createCollection(
        List<ListLocationsPage> pages, int collectionSize) {
      return new ListLocationsFixedSizeCollection(pages, collectionSize);
    }
  }
}
