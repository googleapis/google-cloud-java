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

package com.google.ads.admanager.v1;

import com.google.ads.admanager.v1.stub.ChildPublisherServiceStub;
import com.google.ads.admanager.v1.stub.ChildPublisherServiceStubSettings;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;
import org.jspecify.annotations.NullMarked;
import org.jspecify.annotations.Nullable;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Provides methods for handling
 * [ChildPublisher][google.ads.admanager.v1.ChildPublisher] objects.
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
 * try (ChildPublisherServiceClient childPublisherServiceClient =
 *     ChildPublisherServiceClient.create()) {
 *   ChildPublisherName name = ChildPublisherName.of("[NETWORK_CODE]", "[CHILD_PUBLISHER]");
 *   ChildPublisher response = childPublisherServiceClient.getChildPublisher(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ChildPublisherServiceClient object to clean up
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
 *      <td><p> GetChildPublisher</td>
 *      <td><p> Retrieves a [ChildPublisher][google.ads.admanager.v1.ChildPublisher] object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getChildPublisher(GetChildPublisherRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getChildPublisher(ChildPublisherName name)
 *           <li><p> getChildPublisher(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getChildPublisherCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListChildPublishers</td>
 *      <td><p> Lists [ChildPublisher][google.ads.admanager.v1.ChildPublisher] objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listChildPublishers(ListChildPublishersRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listChildPublishers(NetworkName parent)
 *           <li><p> listChildPublishers(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listChildPublishersPagedCallable()
 *           <li><p> listChildPublishersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateChildPublisher</td>
 *      <td><p> Creates a [ChildPublisher][google.ads.admanager.v1.ChildPublisher] object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createChildPublisher(CreateChildPublisherRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createChildPublisher(NetworkName parent, ChildPublisher childPublisher)
 *           <li><p> createChildPublisher(String parent, ChildPublisher childPublisher)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createChildPublisherCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreateChildPublishers</td>
 *      <td><p> Creates [ChildPublisher][google.ads.admanager.v1.ChildPublisher] objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreateChildPublishers(NetworkName parent, List&lt;CreateChildPublisherRequest&gt; requests)
 *           <li><p> batchCreateChildPublishers(String parent, List&lt;CreateChildPublisherRequest&gt; requests)
 *           <li><p> batchCreateChildPublishers(BatchCreateChildPublishersRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreateChildPublishersCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateChildPublisher</td>
 *      <td><p> Updates a [ChildPublisher][google.ads.admanager.v1.ChildPublisher] object.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateChildPublisher(UpdateChildPublisherRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateChildPublisher(ChildPublisher childPublisher, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateChildPublisherCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdateChildPublishers</td>
 *      <td><p> Batch updates [ChildPublisher][google.ads.admanager.v1.ChildPublisher] objects.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdateChildPublishers(NetworkName parent, List&lt;UpdateChildPublisherRequest&gt; requests)
 *           <li><p> batchUpdateChildPublishers(String parent, List&lt;UpdateChildPublisherRequest&gt; requests)
 *           <li><p> batchUpdateChildPublishers(BatchUpdateChildPublishersRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdateChildPublishersCallable()
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
 * <p>This class can be customized by passing in a custom instance of ChildPublisherServiceSettings
 * to create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * ChildPublisherServiceSettings childPublisherServiceSettings =
 *     ChildPublisherServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ChildPublisherServiceClient childPublisherServiceClient =
 *     ChildPublisherServiceClient.create(childPublisherServiceSettings);
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
 * ChildPublisherServiceSettings childPublisherServiceSettings =
 *     ChildPublisherServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ChildPublisherServiceClient childPublisherServiceClient =
 *     ChildPublisherServiceClient.create(childPublisherServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@NullMarked
@Generated("by gapic-generator-java")
public class ChildPublisherServiceClient implements BackgroundResource {
  private final @Nullable ChildPublisherServiceSettings settings;
  private final ChildPublisherServiceStub stub;

  /** Constructs an instance of ChildPublisherServiceClient with default settings. */
  public static final ChildPublisherServiceClient create() throws IOException {
    return create(ChildPublisherServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ChildPublisherServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ChildPublisherServiceClient create(ChildPublisherServiceSettings settings)
      throws IOException {
    return new ChildPublisherServiceClient(settings);
  }

  /**
   * Constructs an instance of ChildPublisherServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ChildPublisherServiceSettings).
   */
  public static final ChildPublisherServiceClient create(ChildPublisherServiceStub stub) {
    return new ChildPublisherServiceClient(stub);
  }

  /**
   * Constructs an instance of ChildPublisherServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ChildPublisherServiceClient(ChildPublisherServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ChildPublisherServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ChildPublisherServiceClient(ChildPublisherServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final @Nullable ChildPublisherServiceSettings getSettings() {
    return settings;
  }

  public ChildPublisherServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a [ChildPublisher][google.ads.admanager.v1.ChildPublisher] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   ChildPublisherName name = ChildPublisherName.of("[NETWORK_CODE]", "[CHILD_PUBLISHER]");
   *   ChildPublisher response = childPublisherServiceClient.getChildPublisher(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [ChildPublisher][google.ads.admanager.v1.ChildPublisher]. Format:
   *     `networks/{network_code}/childPublishers/{child_publisher_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChildPublisher getChildPublisher(@Nullable ChildPublisherName name) {
    GetChildPublisherRequest request =
        GetChildPublisherRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getChildPublisher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a [ChildPublisher][google.ads.admanager.v1.ChildPublisher] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   String name = ChildPublisherName.of("[NETWORK_CODE]", "[CHILD_PUBLISHER]").toString();
   *   ChildPublisher response = childPublisherServiceClient.getChildPublisher(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the
   *     [ChildPublisher][google.ads.admanager.v1.ChildPublisher]. Format:
   *     `networks/{network_code}/childPublishers/{child_publisher_id}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChildPublisher getChildPublisher(String name) {
    GetChildPublisherRequest request = GetChildPublisherRequest.newBuilder().setName(name).build();
    return getChildPublisher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a [ChildPublisher][google.ads.admanager.v1.ChildPublisher] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   GetChildPublisherRequest request =
   *       GetChildPublisherRequest.newBuilder()
   *           .setName(ChildPublisherName.of("[NETWORK_CODE]", "[CHILD_PUBLISHER]").toString())
   *           .build();
   *   ChildPublisher response = childPublisherServiceClient.getChildPublisher(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChildPublisher getChildPublisher(GetChildPublisherRequest request) {
    return getChildPublisherCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a [ChildPublisher][google.ads.admanager.v1.ChildPublisher] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   GetChildPublisherRequest request =
   *       GetChildPublisherRequest.newBuilder()
   *           .setName(ChildPublisherName.of("[NETWORK_CODE]", "[CHILD_PUBLISHER]").toString())
   *           .build();
   *   ApiFuture<ChildPublisher> future =
   *       childPublisherServiceClient.getChildPublisherCallable().futureCall(request);
   *   // Do something.
   *   ChildPublisher response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetChildPublisherRequest, ChildPublisher> getChildPublisherCallable() {
    return stub.getChildPublisherCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [ChildPublisher][google.ads.admanager.v1.ChildPublisher] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   for (ChildPublisher element :
   *       childPublisherServiceClient.listChildPublishers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of
   *     [ChildPublisher][google.ads.admanager.v1.ChildPublisher]s. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChildPublishersPagedResponse listChildPublishers(@Nullable NetworkName parent) {
    ListChildPublishersRequest request =
        ListChildPublishersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listChildPublishers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [ChildPublisher][google.ads.admanager.v1.ChildPublisher] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   for (ChildPublisher element :
   *       childPublisherServiceClient.listChildPublishers(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of
   *     [ChildPublisher][google.ads.admanager.v1.ChildPublisher]s. Format:
   *     `networks/{network_code}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChildPublishersPagedResponse listChildPublishers(String parent) {
    ListChildPublishersRequest request =
        ListChildPublishersRequest.newBuilder().setParent(parent).build();
    return listChildPublishers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [ChildPublisher][google.ads.admanager.v1.ChildPublisher] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   ListChildPublishersRequest request =
   *       ListChildPublishersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   for (ChildPublisher element :
   *       childPublisherServiceClient.listChildPublishers(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListChildPublishersPagedResponse listChildPublishers(
      ListChildPublishersRequest request) {
    return listChildPublishersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [ChildPublisher][google.ads.admanager.v1.ChildPublisher] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   ListChildPublishersRequest request =
   *       ListChildPublishersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   ApiFuture<ChildPublisher> future =
   *       childPublisherServiceClient.listChildPublishersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ChildPublisher element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListChildPublishersRequest, ListChildPublishersPagedResponse>
      listChildPublishersPagedCallable() {
    return stub.listChildPublishersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists [ChildPublisher][google.ads.admanager.v1.ChildPublisher] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   ListChildPublishersRequest request =
   *       ListChildPublishersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setFilter("filter-1274492040")
   *           .setOrderBy("orderBy-1207110587")
   *           .setSkip(3532159)
   *           .build();
   *   while (true) {
   *     ListChildPublishersResponse response =
   *         childPublisherServiceClient.listChildPublishersCallable().call(request);
   *     for (ChildPublisher element : response.getChildPublishersList()) {
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
  public final UnaryCallable<ListChildPublishersRequest, ListChildPublishersResponse>
      listChildPublishersCallable() {
    return stub.listChildPublishersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [ChildPublisher][google.ads.admanager.v1.ChildPublisher] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   ChildPublisher childPublisher = ChildPublisher.newBuilder().build();
   *   ChildPublisher response =
   *       childPublisherServiceClient.createChildPublisher(parent, childPublisher);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this
   *     [ChildPublisher][google.ads.admanager.v1.ChildPublisher] will be created. Format:
   *     `networks/{network_code}`
   * @param childPublisher Required. The [ChildPublisher][google.ads.admanager.v1.ChildPublisher] to
   *     create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChildPublisher createChildPublisher(
      @Nullable NetworkName parent, ChildPublisher childPublisher) {
    CreateChildPublisherRequest request =
        CreateChildPublisherRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setChildPublisher(childPublisher)
            .build();
    return createChildPublisher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [ChildPublisher][google.ads.admanager.v1.ChildPublisher] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   ChildPublisher childPublisher = ChildPublisher.newBuilder().build();
   *   ChildPublisher response =
   *       childPublisherServiceClient.createChildPublisher(parent, childPublisher);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this
   *     [ChildPublisher][google.ads.admanager.v1.ChildPublisher] will be created. Format:
   *     `networks/{network_code}`
   * @param childPublisher Required. The [ChildPublisher][google.ads.admanager.v1.ChildPublisher] to
   *     create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChildPublisher createChildPublisher(String parent, ChildPublisher childPublisher) {
    CreateChildPublisherRequest request =
        CreateChildPublisherRequest.newBuilder()
            .setParent(parent)
            .setChildPublisher(childPublisher)
            .build();
    return createChildPublisher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [ChildPublisher][google.ads.admanager.v1.ChildPublisher] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   CreateChildPublisherRequest request =
   *       CreateChildPublisherRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setChildPublisher(ChildPublisher.newBuilder().build())
   *           .build();
   *   ChildPublisher response = childPublisherServiceClient.createChildPublisher(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChildPublisher createChildPublisher(CreateChildPublisherRequest request) {
    return createChildPublisherCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a [ChildPublisher][google.ads.admanager.v1.ChildPublisher] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   CreateChildPublisherRequest request =
   *       CreateChildPublisherRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .setChildPublisher(ChildPublisher.newBuilder().build())
   *           .build();
   *   ApiFuture<ChildPublisher> future =
   *       childPublisherServiceClient.createChildPublisherCallable().futureCall(request);
   *   // Do something.
   *   ChildPublisher response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateChildPublisherRequest, ChildPublisher>
      createChildPublisherCallable() {
    return stub.createChildPublisherCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates [ChildPublisher][google.ads.admanager.v1.ChildPublisher] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<CreateChildPublisherRequest> requests = new ArrayList<>();
   *   BatchCreateChildPublishersResponse response =
   *       childPublisherServiceClient.batchCreateChildPublishers(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where
   *     [ChildPublisher][google.ads.admanager.v1.ChildPublisher]s will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateChildPublisherRequest must match
   *     this field.
   * @param requests Required. The [ChildPublisher][google.ads.admanager.v1.ChildPublisher] objects
   *     to create. A maximum of 100 objects can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateChildPublishersResponse batchCreateChildPublishers(
      @Nullable NetworkName parent, List<CreateChildPublisherRequest> requests) {
    BatchCreateChildPublishersRequest request =
        BatchCreateChildPublishersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchCreateChildPublishers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates [ChildPublisher][google.ads.admanager.v1.ChildPublisher] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<CreateChildPublisherRequest> requests = new ArrayList<>();
   *   BatchCreateChildPublishersResponse response =
   *       childPublisherServiceClient.batchCreateChildPublishers(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where
   *     [ChildPublisher][google.ads.admanager.v1.ChildPublisher]s will be created. Format:
   *     `networks/{network_code}` The parent field in the CreateChildPublisherRequest must match
   *     this field.
   * @param requests Required. The [ChildPublisher][google.ads.admanager.v1.ChildPublisher] objects
   *     to create. A maximum of 100 objects can be created in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateChildPublishersResponse batchCreateChildPublishers(
      String parent, List<CreateChildPublisherRequest> requests) {
    BatchCreateChildPublishersRequest request =
        BatchCreateChildPublishersRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchCreateChildPublishers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates [ChildPublisher][google.ads.admanager.v1.ChildPublisher] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   BatchCreateChildPublishersRequest request =
   *       BatchCreateChildPublishersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateChildPublisherRequest>())
   *           .build();
   *   BatchCreateChildPublishersResponse response =
   *       childPublisherServiceClient.batchCreateChildPublishers(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateChildPublishersResponse batchCreateChildPublishers(
      BatchCreateChildPublishersRequest request) {
    return batchCreateChildPublishersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates [ChildPublisher][google.ads.admanager.v1.ChildPublisher] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   BatchCreateChildPublishersRequest request =
   *       BatchCreateChildPublishersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<CreateChildPublisherRequest>())
   *           .build();
   *   ApiFuture<BatchCreateChildPublishersResponse> future =
   *       childPublisherServiceClient.batchCreateChildPublishersCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateChildPublishersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateChildPublishersRequest, BatchCreateChildPublishersResponse>
      batchCreateChildPublishersCallable() {
    return stub.batchCreateChildPublishersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [ChildPublisher][google.ads.admanager.v1.ChildPublisher] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   ChildPublisher childPublisher = ChildPublisher.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ChildPublisher response =
   *       childPublisherServiceClient.updateChildPublisher(childPublisher, updateMask);
   * }
   * }</pre>
   *
   * @param childPublisher Required. The [ChildPublisher][google.ads.admanager.v1.ChildPublisher] to
   *     update.
   *     <p>The [ChildPublisher][google.ads.admanager.v1.ChildPublisher]'s `name` is used to
   *     identify the [ChildPublisher][google.ads.admanager.v1.ChildPublisher] to update.
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChildPublisher updateChildPublisher(
      ChildPublisher childPublisher, FieldMask updateMask) {
    UpdateChildPublisherRequest request =
        UpdateChildPublisherRequest.newBuilder()
            .setChildPublisher(childPublisher)
            .setUpdateMask(updateMask)
            .build();
    return updateChildPublisher(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [ChildPublisher][google.ads.admanager.v1.ChildPublisher] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   UpdateChildPublisherRequest request =
   *       UpdateChildPublisherRequest.newBuilder()
   *           .setChildPublisher(ChildPublisher.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ChildPublisher response = childPublisherServiceClient.updateChildPublisher(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ChildPublisher updateChildPublisher(UpdateChildPublisherRequest request) {
    return updateChildPublisherCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a [ChildPublisher][google.ads.admanager.v1.ChildPublisher] object.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   UpdateChildPublisherRequest request =
   *       UpdateChildPublisherRequest.newBuilder()
   *           .setChildPublisher(ChildPublisher.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ChildPublisher> future =
   *       childPublisherServiceClient.updateChildPublisherCallable().futureCall(request);
   *   // Do something.
   *   ChildPublisher response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateChildPublisherRequest, ChildPublisher>
      updateChildPublisherCallable() {
    return stub.updateChildPublisherCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates [ChildPublisher][google.ads.admanager.v1.ChildPublisher] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   NetworkName parent = NetworkName.of("[NETWORK_CODE]");
   *   List<UpdateChildPublisherRequest> requests = new ArrayList<>();
   *   BatchUpdateChildPublishersResponse response =
   *       childPublisherServiceClient.batchUpdateChildPublishers(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where
   *     [ChildPublisher][google.ads.admanager.v1.ChildPublisher]s will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateChildPublisherRequest must match
   *     this field.
   * @param requests Required. The [ChildPublisher][google.ads.admanager.v1.ChildPublisher] objects
   *     to update. A maximum of 100 objects can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateChildPublishersResponse batchUpdateChildPublishers(
      @Nullable NetworkName parent, List<UpdateChildPublisherRequest> requests) {
    BatchUpdateChildPublishersRequest request =
        BatchUpdateChildPublishersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return batchUpdateChildPublishers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates [ChildPublisher][google.ads.admanager.v1.ChildPublisher] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   String parent = NetworkName.of("[NETWORK_CODE]").toString();
   *   List<UpdateChildPublisherRequest> requests = new ArrayList<>();
   *   BatchUpdateChildPublishersResponse response =
   *       childPublisherServiceClient.batchUpdateChildPublishers(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where
   *     [ChildPublisher][google.ads.admanager.v1.ChildPublisher]s will be updated. Format:
   *     `networks/{network_code}` The parent field in the UpdateChildPublisherRequest must match
   *     this field.
   * @param requests Required. The [ChildPublisher][google.ads.admanager.v1.ChildPublisher] objects
   *     to update. A maximum of 100 objects can be updated in a batch.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateChildPublishersResponse batchUpdateChildPublishers(
      String parent, List<UpdateChildPublisherRequest> requests) {
    BatchUpdateChildPublishersRequest request =
        BatchUpdateChildPublishersRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return batchUpdateChildPublishers(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates [ChildPublisher][google.ads.admanager.v1.ChildPublisher] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   BatchUpdateChildPublishersRequest request =
   *       BatchUpdateChildPublishersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateChildPublisherRequest>())
   *           .build();
   *   BatchUpdateChildPublishersResponse response =
   *       childPublisherServiceClient.batchUpdateChildPublishers(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateChildPublishersResponse batchUpdateChildPublishers(
      BatchUpdateChildPublishersRequest request) {
    return batchUpdateChildPublishersCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Batch updates [ChildPublisher][google.ads.admanager.v1.ChildPublisher] objects.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ChildPublisherServiceClient childPublisherServiceClient =
   *     ChildPublisherServiceClient.create()) {
   *   BatchUpdateChildPublishersRequest request =
   *       BatchUpdateChildPublishersRequest.newBuilder()
   *           .setParent(NetworkName.of("[NETWORK_CODE]").toString())
   *           .addAllRequests(new ArrayList<UpdateChildPublisherRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateChildPublishersResponse> future =
   *       childPublisherServiceClient.batchUpdateChildPublishersCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateChildPublishersResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateChildPublishersRequest, BatchUpdateChildPublishersResponse>
      batchUpdateChildPublishersCallable() {
    return stub.batchUpdateChildPublishersCallable();
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

  public static class ListChildPublishersPagedResponse
      extends AbstractPagedListResponse<
          ListChildPublishersRequest,
          ListChildPublishersResponse,
          ChildPublisher,
          ListChildPublishersPage,
          ListChildPublishersFixedSizeCollection> {

    public static ApiFuture<ListChildPublishersPagedResponse> createAsync(
        PageContext<ListChildPublishersRequest, ListChildPublishersResponse, ChildPublisher>
            context,
        ApiFuture<ListChildPublishersResponse> futureResponse) {
      ApiFuture<ListChildPublishersPage> futurePage =
          ListChildPublishersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListChildPublishersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListChildPublishersPagedResponse(ListChildPublishersPage page) {
      super(page, ListChildPublishersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListChildPublishersPage
      extends AbstractPage<
          ListChildPublishersRequest,
          ListChildPublishersResponse,
          ChildPublisher,
          ListChildPublishersPage> {

    private ListChildPublishersPage(
        @Nullable
            PageContext<ListChildPublishersRequest, ListChildPublishersResponse, ChildPublisher>
            context,
        @Nullable ListChildPublishersResponse response) {
      super(context, response);
    }

    private static ListChildPublishersPage createEmptyPage() {
      return new ListChildPublishersPage(null, null);
    }

    @Override
    protected ListChildPublishersPage createPage(
        @Nullable
            PageContext<ListChildPublishersRequest, ListChildPublishersResponse, ChildPublisher>
            context,
        @Nullable ListChildPublishersResponse response) {
      return new ListChildPublishersPage(context, response);
    }

    @Override
    public ApiFuture<ListChildPublishersPage> createPageAsync(
        @Nullable
            PageContext<ListChildPublishersRequest, ListChildPublishersResponse, ChildPublisher>
            context,
        ApiFuture<ListChildPublishersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListChildPublishersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListChildPublishersRequest,
          ListChildPublishersResponse,
          ChildPublisher,
          ListChildPublishersPage,
          ListChildPublishersFixedSizeCollection> {

    private ListChildPublishersFixedSizeCollection(
        @Nullable List<ListChildPublishersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListChildPublishersFixedSizeCollection createEmptyCollection() {
      return new ListChildPublishersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListChildPublishersFixedSizeCollection createCollection(
        @Nullable List<ListChildPublishersPage> pages, int collectionSize) {
      return new ListChildPublishersFixedSizeCollection(pages, collectionSize);
    }
  }
}
