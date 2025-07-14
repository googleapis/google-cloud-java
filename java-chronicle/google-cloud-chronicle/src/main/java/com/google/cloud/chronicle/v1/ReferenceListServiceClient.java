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

package com.google.cloud.chronicle.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.chronicle.v1.stub.ReferenceListServiceStub;
import com.google.cloud.chronicle.v1.stub.ReferenceListServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: ReferenceListService provides an interface for managing reference lists.
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
 * try (ReferenceListServiceClient referenceListServiceClient =
 *     ReferenceListServiceClient.create()) {
 *   ReferenceListName name =
 *       ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]");
 *   ReferenceList response = referenceListServiceClient.getReferenceList(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the ReferenceListServiceClient object to clean up
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
 *      <td><p> GetReferenceList</td>
 *      <td><p> Gets a single reference list.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getReferenceList(GetReferenceListRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getReferenceList(ReferenceListName name)
 *           <li><p> getReferenceList(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getReferenceListCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListReferenceLists</td>
 *      <td><p> Lists a collection of reference lists.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listReferenceLists(ListReferenceListsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listReferenceLists(InstanceName parent)
 *           <li><p> listReferenceLists(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listReferenceListsPagedCallable()
 *           <li><p> listReferenceListsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateReferenceList</td>
 *      <td><p> Creates a new reference list.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createReferenceList(CreateReferenceListRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createReferenceList(InstanceName parent, ReferenceList referenceList, String referenceListId)
 *           <li><p> createReferenceList(String parent, ReferenceList referenceList, String referenceListId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createReferenceListCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateReferenceList</td>
 *      <td><p> Updates an existing reference list.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateReferenceList(UpdateReferenceListRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateReferenceList(ReferenceList referenceList, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateReferenceListCallable()
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
 * <p>This class can be customized by passing in a custom instance of ReferenceListServiceSettings
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
 * ReferenceListServiceSettings referenceListServiceSettings =
 *     ReferenceListServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * ReferenceListServiceClient referenceListServiceClient =
 *     ReferenceListServiceClient.create(referenceListServiceSettings);
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
 * ReferenceListServiceSettings referenceListServiceSettings =
 *     ReferenceListServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * ReferenceListServiceClient referenceListServiceClient =
 *     ReferenceListServiceClient.create(referenceListServiceSettings);
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
 * ReferenceListServiceSettings referenceListServiceSettings =
 *     ReferenceListServiceSettings.newHttpJsonBuilder().build();
 * ReferenceListServiceClient referenceListServiceClient =
 *     ReferenceListServiceClient.create(referenceListServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class ReferenceListServiceClient implements BackgroundResource {
  private final ReferenceListServiceSettings settings;
  private final ReferenceListServiceStub stub;

  /** Constructs an instance of ReferenceListServiceClient with default settings. */
  public static final ReferenceListServiceClient create() throws IOException {
    return create(ReferenceListServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of ReferenceListServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final ReferenceListServiceClient create(ReferenceListServiceSettings settings)
      throws IOException {
    return new ReferenceListServiceClient(settings);
  }

  /**
   * Constructs an instance of ReferenceListServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(ReferenceListServiceSettings).
   */
  public static final ReferenceListServiceClient create(ReferenceListServiceStub stub) {
    return new ReferenceListServiceClient(stub);
  }

  /**
   * Constructs an instance of ReferenceListServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected ReferenceListServiceClient(ReferenceListServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((ReferenceListServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected ReferenceListServiceClient(ReferenceListServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final ReferenceListServiceSettings getSettings() {
    return settings;
  }

  public ReferenceListServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single reference list.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReferenceListServiceClient referenceListServiceClient =
   *     ReferenceListServiceClient.create()) {
   *   ReferenceListName name =
   *       ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]");
   *   ReferenceList response = referenceListServiceClient.getReferenceList(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the reference list to retrieve. Format:
   *     `projects/{project}/locations/{locations}/instances/{instance}/referenceLists/{reference_list}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReferenceList getReferenceList(ReferenceListName name) {
    GetReferenceListRequest request =
        GetReferenceListRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getReferenceList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single reference list.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReferenceListServiceClient referenceListServiceClient =
   *     ReferenceListServiceClient.create()) {
   *   String name =
   *       ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]")
   *           .toString();
   *   ReferenceList response = referenceListServiceClient.getReferenceList(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the reference list to retrieve. Format:
   *     `projects/{project}/locations/{locations}/instances/{instance}/referenceLists/{reference_list}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReferenceList getReferenceList(String name) {
    GetReferenceListRequest request = GetReferenceListRequest.newBuilder().setName(name).build();
    return getReferenceList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single reference list.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReferenceListServiceClient referenceListServiceClient =
   *     ReferenceListServiceClient.create()) {
   *   GetReferenceListRequest request =
   *       GetReferenceListRequest.newBuilder()
   *           .setName(
   *               ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]")
   *                   .toString())
   *           .setView(ReferenceListView.forNumber(0))
   *           .build();
   *   ReferenceList response = referenceListServiceClient.getReferenceList(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReferenceList getReferenceList(GetReferenceListRequest request) {
    return getReferenceListCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a single reference list.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReferenceListServiceClient referenceListServiceClient =
   *     ReferenceListServiceClient.create()) {
   *   GetReferenceListRequest request =
   *       GetReferenceListRequest.newBuilder()
   *           .setName(
   *               ReferenceListName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[REFERENCE_LIST]")
   *                   .toString())
   *           .setView(ReferenceListView.forNumber(0))
   *           .build();
   *   ApiFuture<ReferenceList> future =
   *       referenceListServiceClient.getReferenceListCallable().futureCall(request);
   *   // Do something.
   *   ReferenceList response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetReferenceListRequest, ReferenceList> getReferenceListCallable() {
    return stub.getReferenceListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a collection of reference lists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReferenceListServiceClient referenceListServiceClient =
   *     ReferenceListServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (ReferenceList element :
   *       referenceListServiceClient.listReferenceLists(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of reference lists. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReferenceListsPagedResponse listReferenceLists(InstanceName parent) {
    ListReferenceListsRequest request =
        ListReferenceListsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listReferenceLists(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a collection of reference lists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReferenceListServiceClient referenceListServiceClient =
   *     ReferenceListServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (ReferenceList element :
   *       referenceListServiceClient.listReferenceLists(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of reference lists. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReferenceListsPagedResponse listReferenceLists(String parent) {
    ListReferenceListsRequest request =
        ListReferenceListsRequest.newBuilder().setParent(parent).build();
    return listReferenceLists(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a collection of reference lists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReferenceListServiceClient referenceListServiceClient =
   *     ReferenceListServiceClient.create()) {
   *   ListReferenceListsRequest request =
   *       ListReferenceListsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(ReferenceListView.forNumber(0))
   *           .build();
   *   for (ReferenceList element :
   *       referenceListServiceClient.listReferenceLists(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListReferenceListsPagedResponse listReferenceLists(
      ListReferenceListsRequest request) {
    return listReferenceListsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a collection of reference lists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReferenceListServiceClient referenceListServiceClient =
   *     ReferenceListServiceClient.create()) {
   *   ListReferenceListsRequest request =
   *       ListReferenceListsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(ReferenceListView.forNumber(0))
   *           .build();
   *   ApiFuture<ReferenceList> future =
   *       referenceListServiceClient.listReferenceListsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (ReferenceList element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListReferenceListsRequest, ListReferenceListsPagedResponse>
      listReferenceListsPagedCallable() {
    return stub.listReferenceListsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists a collection of reference lists.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReferenceListServiceClient referenceListServiceClient =
   *     ReferenceListServiceClient.create()) {
   *   ListReferenceListsRequest request =
   *       ListReferenceListsRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(ReferenceListView.forNumber(0))
   *           .build();
   *   while (true) {
   *     ListReferenceListsResponse response =
   *         referenceListServiceClient.listReferenceListsCallable().call(request);
   *     for (ReferenceList element : response.getReferenceListsList()) {
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
  public final UnaryCallable<ListReferenceListsRequest, ListReferenceListsResponse>
      listReferenceListsCallable() {
    return stub.listReferenceListsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new reference list.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReferenceListServiceClient referenceListServiceClient =
   *     ReferenceListServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   ReferenceList referenceList = ReferenceList.newBuilder().build();
   *   String referenceListId = "referenceListId676417924";
   *   ReferenceList response =
   *       referenceListServiceClient.createReferenceList(parent, referenceList, referenceListId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this reference list will be created. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}`
   * @param referenceList Required. The reference list to create.
   * @param referenceListId Required. The ID to use for the reference list. This is also the display
   *     name for the reference list. It must satisfy the following requirements: - Starts with
   *     letter. - Contains only letters, numbers and underscore. - Has length less than 256. - Must
   *     be unique.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReferenceList createReferenceList(
      InstanceName parent, ReferenceList referenceList, String referenceListId) {
    CreateReferenceListRequest request =
        CreateReferenceListRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setReferenceList(referenceList)
            .setReferenceListId(referenceListId)
            .build();
    return createReferenceList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new reference list.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReferenceListServiceClient referenceListServiceClient =
   *     ReferenceListServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   ReferenceList referenceList = ReferenceList.newBuilder().build();
   *   String referenceListId = "referenceListId676417924";
   *   ReferenceList response =
   *       referenceListServiceClient.createReferenceList(parent, referenceList, referenceListId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this reference list will be created. Format:
   *     `projects/{project}/locations/{location}/instances/{instance}`
   * @param referenceList Required. The reference list to create.
   * @param referenceListId Required. The ID to use for the reference list. This is also the display
   *     name for the reference list. It must satisfy the following requirements: - Starts with
   *     letter. - Contains only letters, numbers and underscore. - Has length less than 256. - Must
   *     be unique.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReferenceList createReferenceList(
      String parent, ReferenceList referenceList, String referenceListId) {
    CreateReferenceListRequest request =
        CreateReferenceListRequest.newBuilder()
            .setParent(parent)
            .setReferenceList(referenceList)
            .setReferenceListId(referenceListId)
            .build();
    return createReferenceList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new reference list.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReferenceListServiceClient referenceListServiceClient =
   *     ReferenceListServiceClient.create()) {
   *   CreateReferenceListRequest request =
   *       CreateReferenceListRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setReferenceList(ReferenceList.newBuilder().build())
   *           .setReferenceListId("referenceListId676417924")
   *           .build();
   *   ReferenceList response = referenceListServiceClient.createReferenceList(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReferenceList createReferenceList(CreateReferenceListRequest request) {
    return createReferenceListCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new reference list.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReferenceListServiceClient referenceListServiceClient =
   *     ReferenceListServiceClient.create()) {
   *   CreateReferenceListRequest request =
   *       CreateReferenceListRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setReferenceList(ReferenceList.newBuilder().build())
   *           .setReferenceListId("referenceListId676417924")
   *           .build();
   *   ApiFuture<ReferenceList> future =
   *       referenceListServiceClient.createReferenceListCallable().futureCall(request);
   *   // Do something.
   *   ReferenceList response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateReferenceListRequest, ReferenceList>
      createReferenceListCallable() {
    return stub.createReferenceListCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing reference list.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReferenceListServiceClient referenceListServiceClient =
   *     ReferenceListServiceClient.create()) {
   *   ReferenceList referenceList = ReferenceList.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   ReferenceList response =
   *       referenceListServiceClient.updateReferenceList(referenceList, updateMask);
   * }
   * }</pre>
   *
   * @param referenceList Required. The reference list to update.
   *     <p>The reference list's `name` field is used to identify the reference list to update.
   *     Format:
   *     `projects/{project}/locations/{locations}/instances/{instance}/referenceLists/{reference_list}`
   * @param updateMask The list of fields to update. When no field mask is supplied, all non-empty
   *     fields will be updated. A field mask of "&#42;" will update all fields, whether empty or
   *     not.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReferenceList updateReferenceList(
      ReferenceList referenceList, FieldMask updateMask) {
    UpdateReferenceListRequest request =
        UpdateReferenceListRequest.newBuilder()
            .setReferenceList(referenceList)
            .setUpdateMask(updateMask)
            .build();
    return updateReferenceList(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing reference list.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReferenceListServiceClient referenceListServiceClient =
   *     ReferenceListServiceClient.create()) {
   *   UpdateReferenceListRequest request =
   *       UpdateReferenceListRequest.newBuilder()
   *           .setReferenceList(ReferenceList.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ReferenceList response = referenceListServiceClient.updateReferenceList(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ReferenceList updateReferenceList(UpdateReferenceListRequest request) {
    return updateReferenceListCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing reference list.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (ReferenceListServiceClient referenceListServiceClient =
   *     ReferenceListServiceClient.create()) {
   *   UpdateReferenceListRequest request =
   *       UpdateReferenceListRequest.newBuilder()
   *           .setReferenceList(ReferenceList.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<ReferenceList> future =
   *       referenceListServiceClient.updateReferenceListCallable().futureCall(request);
   *   // Do something.
   *   ReferenceList response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateReferenceListRequest, ReferenceList>
      updateReferenceListCallable() {
    return stub.updateReferenceListCallable();
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

  public static class ListReferenceListsPagedResponse
      extends AbstractPagedListResponse<
          ListReferenceListsRequest,
          ListReferenceListsResponse,
          ReferenceList,
          ListReferenceListsPage,
          ListReferenceListsFixedSizeCollection> {

    public static ApiFuture<ListReferenceListsPagedResponse> createAsync(
        PageContext<ListReferenceListsRequest, ListReferenceListsResponse, ReferenceList> context,
        ApiFuture<ListReferenceListsResponse> futureResponse) {
      ApiFuture<ListReferenceListsPage> futurePage =
          ListReferenceListsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListReferenceListsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListReferenceListsPagedResponse(ListReferenceListsPage page) {
      super(page, ListReferenceListsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListReferenceListsPage
      extends AbstractPage<
          ListReferenceListsRequest,
          ListReferenceListsResponse,
          ReferenceList,
          ListReferenceListsPage> {

    private ListReferenceListsPage(
        PageContext<ListReferenceListsRequest, ListReferenceListsResponse, ReferenceList> context,
        ListReferenceListsResponse response) {
      super(context, response);
    }

    private static ListReferenceListsPage createEmptyPage() {
      return new ListReferenceListsPage(null, null);
    }

    @Override
    protected ListReferenceListsPage createPage(
        PageContext<ListReferenceListsRequest, ListReferenceListsResponse, ReferenceList> context,
        ListReferenceListsResponse response) {
      return new ListReferenceListsPage(context, response);
    }

    @Override
    public ApiFuture<ListReferenceListsPage> createPageAsync(
        PageContext<ListReferenceListsRequest, ListReferenceListsResponse, ReferenceList> context,
        ApiFuture<ListReferenceListsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListReferenceListsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListReferenceListsRequest,
          ListReferenceListsResponse,
          ReferenceList,
          ListReferenceListsPage,
          ListReferenceListsFixedSizeCollection> {

    private ListReferenceListsFixedSizeCollection(
        List<ListReferenceListsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListReferenceListsFixedSizeCollection createEmptyCollection() {
      return new ListReferenceListsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListReferenceListsFixedSizeCollection createCollection(
        List<ListReferenceListsPage> pages, int collectionSize) {
      return new ListReferenceListsFixedSizeCollection(pages, collectionSize);
    }
  }
}
