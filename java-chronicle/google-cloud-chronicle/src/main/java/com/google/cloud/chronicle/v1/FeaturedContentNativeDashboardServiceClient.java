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

package com.google.cloud.chronicle.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.stub.FeaturedContentNativeDashboardServiceStub;
import com.google.cloud.chronicle.v1.stub.FeaturedContentNativeDashboardServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: This service provides functionality for managing
 * FeaturedContentNativeDashboard.
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
 * try (FeaturedContentNativeDashboardServiceClient featuredContentNativeDashboardServiceClient =
 *     FeaturedContentNativeDashboardServiceClient.create()) {
 *   FeaturedContentNativeDashboardName name =
 *       FeaturedContentNativeDashboardName.of(
 *           "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEATURED_CONTENT_NATIVE_DASHBOARD]");
 *   FeaturedContentNativeDashboard response =
 *       featuredContentNativeDashboardServiceClient.getFeaturedContentNativeDashboard(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the FeaturedContentNativeDashboardServiceClient object to
 * clean up resources such as threads. In the example above, try-with-resources is used, which
 * automatically calls close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> GetFeaturedContentNativeDashboard</td>
 *      <td><p> Get a native dashboard featured content.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getFeaturedContentNativeDashboard(GetFeaturedContentNativeDashboardRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getFeaturedContentNativeDashboard(FeaturedContentNativeDashboardName name)
 *           <li><p> getFeaturedContentNativeDashboard(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getFeaturedContentNativeDashboardCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListFeaturedContentNativeDashboards</td>
 *      <td><p> List all native dashboards featured content.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listFeaturedContentNativeDashboards(ListFeaturedContentNativeDashboardsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listFeaturedContentNativeDashboards(ContentHubName parent)
 *           <li><p> listFeaturedContentNativeDashboards(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listFeaturedContentNativeDashboardsPagedCallable()
 *           <li><p> listFeaturedContentNativeDashboardsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> InstallFeaturedContentNativeDashboard</td>
 *      <td><p> Install a native dashboard featured content.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> installFeaturedContentNativeDashboard(InstallFeaturedContentNativeDashboardRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> installFeaturedContentNativeDashboard(FeaturedContentNativeDashboardName name)
 *           <li><p> installFeaturedContentNativeDashboard(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> installFeaturedContentNativeDashboardCallable()
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
 * FeaturedContentNativeDashboardServiceSettings to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FeaturedContentNativeDashboardServiceSettings featuredContentNativeDashboardServiceSettings =
 *     FeaturedContentNativeDashboardServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * FeaturedContentNativeDashboardServiceClient featuredContentNativeDashboardServiceClient =
 *     FeaturedContentNativeDashboardServiceClient.create(
 *         featuredContentNativeDashboardServiceSettings);
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
 * FeaturedContentNativeDashboardServiceSettings featuredContentNativeDashboardServiceSettings =
 *     FeaturedContentNativeDashboardServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * FeaturedContentNativeDashboardServiceClient featuredContentNativeDashboardServiceClient =
 *     FeaturedContentNativeDashboardServiceClient.create(
 *         featuredContentNativeDashboardServiceSettings);
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
 * FeaturedContentNativeDashboardServiceSettings featuredContentNativeDashboardServiceSettings =
 *     FeaturedContentNativeDashboardServiceSettings.newHttpJsonBuilder().build();
 * FeaturedContentNativeDashboardServiceClient featuredContentNativeDashboardServiceClient =
 *     FeaturedContentNativeDashboardServiceClient.create(
 *         featuredContentNativeDashboardServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class FeaturedContentNativeDashboardServiceClient implements BackgroundResource {
  private final FeaturedContentNativeDashboardServiceSettings settings;
  private final FeaturedContentNativeDashboardServiceStub stub;

  /**
   * Constructs an instance of FeaturedContentNativeDashboardServiceClient with default settings.
   */
  public static final FeaturedContentNativeDashboardServiceClient create() throws IOException {
    return create(FeaturedContentNativeDashboardServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of FeaturedContentNativeDashboardServiceClient, using the given
   * settings. The channels are created based on the settings passed in, or defaults for any
   * settings that are not set.
   */
  public static final FeaturedContentNativeDashboardServiceClient create(
      FeaturedContentNativeDashboardServiceSettings settings) throws IOException {
    return new FeaturedContentNativeDashboardServiceClient(settings);
  }

  /**
   * Constructs an instance of FeaturedContentNativeDashboardServiceClient, using the given stub for
   * making calls. This is for advanced usage - prefer using
   * create(FeaturedContentNativeDashboardServiceSettings).
   */
  public static final FeaturedContentNativeDashboardServiceClient create(
      FeaturedContentNativeDashboardServiceStub stub) {
    return new FeaturedContentNativeDashboardServiceClient(stub);
  }

  /**
   * Constructs an instance of FeaturedContentNativeDashboardServiceClient, using the given
   * settings. This is protected so that it is easy to make a subclass, but otherwise, the static
   * factory methods should be preferred.
   */
  protected FeaturedContentNativeDashboardServiceClient(
      FeaturedContentNativeDashboardServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub =
        ((FeaturedContentNativeDashboardServiceStubSettings) settings.getStubSettings())
            .createStub();
  }

  protected FeaturedContentNativeDashboardServiceClient(
      FeaturedContentNativeDashboardServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final FeaturedContentNativeDashboardServiceSettings getSettings() {
    return settings;
  }

  public FeaturedContentNativeDashboardServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a native dashboard featured content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturedContentNativeDashboardServiceClient featuredContentNativeDashboardServiceClient =
   *     FeaturedContentNativeDashboardServiceClient.create()) {
   *   FeaturedContentNativeDashboardName name =
   *       FeaturedContentNativeDashboardName.of(
   *           "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEATURED_CONTENT_NATIVE_DASHBOARD]");
   *   FeaturedContentNativeDashboard response =
   *       featuredContentNativeDashboardServiceClient.getFeaturedContentNativeDashboard(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the FeaturedContentNativeDashboard to retrieve.
   *     Format:
   *     projects/{project}/locations/{location}/instances/{instance}/contentHub/featuredContentNativeDashboards/{featured_content_native_dashboard}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeaturedContentNativeDashboard getFeaturedContentNativeDashboard(
      FeaturedContentNativeDashboardName name) {
    GetFeaturedContentNativeDashboardRequest request =
        GetFeaturedContentNativeDashboardRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getFeaturedContentNativeDashboard(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a native dashboard featured content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturedContentNativeDashboardServiceClient featuredContentNativeDashboardServiceClient =
   *     FeaturedContentNativeDashboardServiceClient.create()) {
   *   String name =
   *       FeaturedContentNativeDashboardName.of(
   *               "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEATURED_CONTENT_NATIVE_DASHBOARD]")
   *           .toString();
   *   FeaturedContentNativeDashboard response =
   *       featuredContentNativeDashboardServiceClient.getFeaturedContentNativeDashboard(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the FeaturedContentNativeDashboard to retrieve.
   *     Format:
   *     projects/{project}/locations/{location}/instances/{instance}/contentHub/featuredContentNativeDashboards/{featured_content_native_dashboard}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeaturedContentNativeDashboard getFeaturedContentNativeDashboard(String name) {
    GetFeaturedContentNativeDashboardRequest request =
        GetFeaturedContentNativeDashboardRequest.newBuilder().setName(name).build();
    return getFeaturedContentNativeDashboard(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a native dashboard featured content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturedContentNativeDashboardServiceClient featuredContentNativeDashboardServiceClient =
   *     FeaturedContentNativeDashboardServiceClient.create()) {
   *   GetFeaturedContentNativeDashboardRequest request =
   *       GetFeaturedContentNativeDashboardRequest.newBuilder()
   *           .setName(
   *               FeaturedContentNativeDashboardName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[INSTANCE]",
   *                       "[FEATURED_CONTENT_NATIVE_DASHBOARD]")
   *                   .toString())
   *           .build();
   *   FeaturedContentNativeDashboard response =
   *       featuredContentNativeDashboardServiceClient.getFeaturedContentNativeDashboard(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final FeaturedContentNativeDashboard getFeaturedContentNativeDashboard(
      GetFeaturedContentNativeDashboardRequest request) {
    return getFeaturedContentNativeDashboardCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get a native dashboard featured content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturedContentNativeDashboardServiceClient featuredContentNativeDashboardServiceClient =
   *     FeaturedContentNativeDashboardServiceClient.create()) {
   *   GetFeaturedContentNativeDashboardRequest request =
   *       GetFeaturedContentNativeDashboardRequest.newBuilder()
   *           .setName(
   *               FeaturedContentNativeDashboardName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[INSTANCE]",
   *                       "[FEATURED_CONTENT_NATIVE_DASHBOARD]")
   *                   .toString())
   *           .build();
   *   ApiFuture<FeaturedContentNativeDashboard> future =
   *       featuredContentNativeDashboardServiceClient
   *           .getFeaturedContentNativeDashboardCallable()
   *           .futureCall(request);
   *   // Do something.
   *   FeaturedContentNativeDashboard response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          GetFeaturedContentNativeDashboardRequest, FeaturedContentNativeDashboard>
      getFeaturedContentNativeDashboardCallable() {
    return stub.getFeaturedContentNativeDashboardCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all native dashboards featured content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturedContentNativeDashboardServiceClient featuredContentNativeDashboardServiceClient =
   *     FeaturedContentNativeDashboardServiceClient.create()) {
   *   ContentHubName parent = ContentHubName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (FeaturedContentNativeDashboard element :
   *       featuredContentNativeDashboardServiceClient
   *           .listFeaturedContentNativeDashboards(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of
   *     FeaturedContentNativeDashboards. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/contentHub
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeaturedContentNativeDashboardsPagedResponse listFeaturedContentNativeDashboards(
      ContentHubName parent) {
    ListFeaturedContentNativeDashboardsRequest request =
        ListFeaturedContentNativeDashboardsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFeaturedContentNativeDashboards(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all native dashboards featured content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturedContentNativeDashboardServiceClient featuredContentNativeDashboardServiceClient =
   *     FeaturedContentNativeDashboardServiceClient.create()) {
   *   String parent = ContentHubName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (FeaturedContentNativeDashboard element :
   *       featuredContentNativeDashboardServiceClient
   *           .listFeaturedContentNativeDashboards(parent)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of
   *     FeaturedContentNativeDashboards. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/contentHub
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeaturedContentNativeDashboardsPagedResponse listFeaturedContentNativeDashboards(
      String parent) {
    ListFeaturedContentNativeDashboardsRequest request =
        ListFeaturedContentNativeDashboardsRequest.newBuilder().setParent(parent).build();
    return listFeaturedContentNativeDashboards(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all native dashboards featured content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturedContentNativeDashboardServiceClient featuredContentNativeDashboardServiceClient =
   *     FeaturedContentNativeDashboardServiceClient.create()) {
   *   ListFeaturedContentNativeDashboardsRequest request =
   *       ListFeaturedContentNativeDashboardsRequest.newBuilder()
   *           .setParent(ContentHubName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (FeaturedContentNativeDashboard element :
   *       featuredContentNativeDashboardServiceClient
   *           .listFeaturedContentNativeDashboards(request)
   *           .iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFeaturedContentNativeDashboardsPagedResponse listFeaturedContentNativeDashboards(
      ListFeaturedContentNativeDashboardsRequest request) {
    return listFeaturedContentNativeDashboardsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all native dashboards featured content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturedContentNativeDashboardServiceClient featuredContentNativeDashboardServiceClient =
   *     FeaturedContentNativeDashboardServiceClient.create()) {
   *   ListFeaturedContentNativeDashboardsRequest request =
   *       ListFeaturedContentNativeDashboardsRequest.newBuilder()
   *           .setParent(ContentHubName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<FeaturedContentNativeDashboard> future =
   *       featuredContentNativeDashboardServiceClient
   *           .listFeaturedContentNativeDashboardsPagedCallable()
   *           .futureCall(request);
   *   // Do something.
   *   for (FeaturedContentNativeDashboard element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<
          ListFeaturedContentNativeDashboardsRequest,
          ListFeaturedContentNativeDashboardsPagedResponse>
      listFeaturedContentNativeDashboardsPagedCallable() {
    return stub.listFeaturedContentNativeDashboardsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all native dashboards featured content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturedContentNativeDashboardServiceClient featuredContentNativeDashboardServiceClient =
   *     FeaturedContentNativeDashboardServiceClient.create()) {
   *   ListFeaturedContentNativeDashboardsRequest request =
   *       ListFeaturedContentNativeDashboardsRequest.newBuilder()
   *           .setParent(ContentHubName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListFeaturedContentNativeDashboardsResponse response =
   *         featuredContentNativeDashboardServiceClient
   *             .listFeaturedContentNativeDashboardsCallable()
   *             .call(request);
   *     for (FeaturedContentNativeDashboard element :
   *         response.getFeaturedContentNativeDashboardsList()) {
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
  public final UnaryCallable<
          ListFeaturedContentNativeDashboardsRequest, ListFeaturedContentNativeDashboardsResponse>
      listFeaturedContentNativeDashboardsCallable() {
    return stub.listFeaturedContentNativeDashboardsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Install a native dashboard featured content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturedContentNativeDashboardServiceClient featuredContentNativeDashboardServiceClient =
   *     FeaturedContentNativeDashboardServiceClient.create()) {
   *   FeaturedContentNativeDashboardName name =
   *       FeaturedContentNativeDashboardName.of(
   *           "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEATURED_CONTENT_NATIVE_DASHBOARD]");
   *   InstallFeaturedContentNativeDashboardResponse response =
   *       featuredContentNativeDashboardServiceClient.installFeaturedContentNativeDashboard(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the FeaturedContentNativeDashboard to install.
   *     Format:
   *     projects/{project}/locations/{location}/instances/{instance}/contentHub/featuredContentNativeDashboards/{featured_content_native_dashboard}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstallFeaturedContentNativeDashboardResponse installFeaturedContentNativeDashboard(
      FeaturedContentNativeDashboardName name) {
    InstallFeaturedContentNativeDashboardRequest request =
        InstallFeaturedContentNativeDashboardRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return installFeaturedContentNativeDashboard(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Install a native dashboard featured content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturedContentNativeDashboardServiceClient featuredContentNativeDashboardServiceClient =
   *     FeaturedContentNativeDashboardServiceClient.create()) {
   *   String name =
   *       FeaturedContentNativeDashboardName.of(
   *               "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[FEATURED_CONTENT_NATIVE_DASHBOARD]")
   *           .toString();
   *   InstallFeaturedContentNativeDashboardResponse response =
   *       featuredContentNativeDashboardServiceClient.installFeaturedContentNativeDashboard(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the FeaturedContentNativeDashboard to install.
   *     Format:
   *     projects/{project}/locations/{location}/instances/{instance}/contentHub/featuredContentNativeDashboards/{featured_content_native_dashboard}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstallFeaturedContentNativeDashboardResponse installFeaturedContentNativeDashboard(
      String name) {
    InstallFeaturedContentNativeDashboardRequest request =
        InstallFeaturedContentNativeDashboardRequest.newBuilder().setName(name).build();
    return installFeaturedContentNativeDashboard(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Install a native dashboard featured content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturedContentNativeDashboardServiceClient featuredContentNativeDashboardServiceClient =
   *     FeaturedContentNativeDashboardServiceClient.create()) {
   *   InstallFeaturedContentNativeDashboardRequest request =
   *       InstallFeaturedContentNativeDashboardRequest.newBuilder()
   *           .setName(
   *               FeaturedContentNativeDashboardName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[INSTANCE]",
   *                       "[FEATURED_CONTENT_NATIVE_DASHBOARD]")
   *                   .toString())
   *           .setFeaturedContentNativeDashboard(
   *               FeaturedContentNativeDashboard.newBuilder().build())
   *           .build();
   *   InstallFeaturedContentNativeDashboardResponse response =
   *       featuredContentNativeDashboardServiceClient.installFeaturedContentNativeDashboard(
   *           request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final InstallFeaturedContentNativeDashboardResponse installFeaturedContentNativeDashboard(
      InstallFeaturedContentNativeDashboardRequest request) {
    return installFeaturedContentNativeDashboardCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Install a native dashboard featured content.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FeaturedContentNativeDashboardServiceClient featuredContentNativeDashboardServiceClient =
   *     FeaturedContentNativeDashboardServiceClient.create()) {
   *   InstallFeaturedContentNativeDashboardRequest request =
   *       InstallFeaturedContentNativeDashboardRequest.newBuilder()
   *           .setName(
   *               FeaturedContentNativeDashboardName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[INSTANCE]",
   *                       "[FEATURED_CONTENT_NATIVE_DASHBOARD]")
   *                   .toString())
   *           .setFeaturedContentNativeDashboard(
   *               FeaturedContentNativeDashboard.newBuilder().build())
   *           .build();
   *   ApiFuture<InstallFeaturedContentNativeDashboardResponse> future =
   *       featuredContentNativeDashboardServiceClient
   *           .installFeaturedContentNativeDashboardCallable()
   *           .futureCall(request);
   *   // Do something.
   *   InstallFeaturedContentNativeDashboardResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<
          InstallFeaturedContentNativeDashboardRequest,
          InstallFeaturedContentNativeDashboardResponse>
      installFeaturedContentNativeDashboardCallable() {
    return stub.installFeaturedContentNativeDashboardCallable();
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

  public static class ListFeaturedContentNativeDashboardsPagedResponse
      extends AbstractPagedListResponse<
          ListFeaturedContentNativeDashboardsRequest,
          ListFeaturedContentNativeDashboardsResponse,
          FeaturedContentNativeDashboard,
          ListFeaturedContentNativeDashboardsPage,
          ListFeaturedContentNativeDashboardsFixedSizeCollection> {

    public static ApiFuture<ListFeaturedContentNativeDashboardsPagedResponse> createAsync(
        PageContext<
                ListFeaturedContentNativeDashboardsRequest,
                ListFeaturedContentNativeDashboardsResponse,
                FeaturedContentNativeDashboard>
            context,
        ApiFuture<ListFeaturedContentNativeDashboardsResponse> futureResponse) {
      ApiFuture<ListFeaturedContentNativeDashboardsPage> futurePage =
          ListFeaturedContentNativeDashboardsPage.createEmptyPage()
              .createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListFeaturedContentNativeDashboardsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListFeaturedContentNativeDashboardsPagedResponse(
        ListFeaturedContentNativeDashboardsPage page) {
      super(page, ListFeaturedContentNativeDashboardsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFeaturedContentNativeDashboardsPage
      extends AbstractPage<
          ListFeaturedContentNativeDashboardsRequest,
          ListFeaturedContentNativeDashboardsResponse,
          FeaturedContentNativeDashboard,
          ListFeaturedContentNativeDashboardsPage> {

    private ListFeaturedContentNativeDashboardsPage(
        PageContext<
                ListFeaturedContentNativeDashboardsRequest,
                ListFeaturedContentNativeDashboardsResponse,
                FeaturedContentNativeDashboard>
            context,
        ListFeaturedContentNativeDashboardsResponse response) {
      super(context, response);
    }

    private static ListFeaturedContentNativeDashboardsPage createEmptyPage() {
      return new ListFeaturedContentNativeDashboardsPage(null, null);
    }

    @Override
    protected ListFeaturedContentNativeDashboardsPage createPage(
        PageContext<
                ListFeaturedContentNativeDashboardsRequest,
                ListFeaturedContentNativeDashboardsResponse,
                FeaturedContentNativeDashboard>
            context,
        ListFeaturedContentNativeDashboardsResponse response) {
      return new ListFeaturedContentNativeDashboardsPage(context, response);
    }

    @Override
    public ApiFuture<ListFeaturedContentNativeDashboardsPage> createPageAsync(
        PageContext<
                ListFeaturedContentNativeDashboardsRequest,
                ListFeaturedContentNativeDashboardsResponse,
                FeaturedContentNativeDashboard>
            context,
        ApiFuture<ListFeaturedContentNativeDashboardsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFeaturedContentNativeDashboardsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFeaturedContentNativeDashboardsRequest,
          ListFeaturedContentNativeDashboardsResponse,
          FeaturedContentNativeDashboard,
          ListFeaturedContentNativeDashboardsPage,
          ListFeaturedContentNativeDashboardsFixedSizeCollection> {

    private ListFeaturedContentNativeDashboardsFixedSizeCollection(
        List<ListFeaturedContentNativeDashboardsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFeaturedContentNativeDashboardsFixedSizeCollection createEmptyCollection() {
      return new ListFeaturedContentNativeDashboardsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFeaturedContentNativeDashboardsFixedSizeCollection createCollection(
        List<ListFeaturedContentNativeDashboardsPage> pages, int collectionSize) {
      return new ListFeaturedContentNativeDashboardsFixedSizeCollection(pages, collectionSize);
    }
  }
}
