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

package com.google.cloud.resourcemanager.v3;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.httpjson.longrunning.OperationsClient;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.resourcemanager.v3.stub.FoldersStub;
import com.google.cloud.resourcemanager.v3.stub.FoldersStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.longrunning.Operation;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Manages Cloud Platform folder resources. Folders can be used to organize the
 * resources under an organization and to control the policies applied to groups of resources.
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
 * try (FoldersClient foldersClient = FoldersClient.create()) {
 *   FolderName name = FolderName.of("[FOLDER]");
 *   Folder response = foldersClient.getFolder(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the FoldersClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of FoldersSettings to create().
 * For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * FoldersSettings foldersSettings =
 *     FoldersSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * FoldersClient foldersClient = FoldersClient.create(foldersSettings);
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
 * FoldersSettings foldersSettings = FoldersSettings.newBuilder().setEndpoint(myEndpoint).build();
 * FoldersClient foldersClient = FoldersClient.create(foldersSettings);
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
 * FoldersSettings foldersSettings = FoldersSettings.newHttpJsonBuilder().build();
 * FoldersClient foldersClient = FoldersClient.create(foldersSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class FoldersClient implements BackgroundResource {
  private final FoldersSettings settings;
  private final FoldersStub stub;
  private final OperationsClient httpJsonOperationsClient;
  private final com.google.longrunning.OperationsClient operationsClient;

  /** Constructs an instance of FoldersClient with default settings. */
  public static final FoldersClient create() throws IOException {
    return create(FoldersSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of FoldersClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final FoldersClient create(FoldersSettings settings) throws IOException {
    return new FoldersClient(settings);
  }

  /**
   * Constructs an instance of FoldersClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(FoldersSettings).
   */
  public static final FoldersClient create(FoldersStub stub) {
    return new FoldersClient(stub);
  }

  /**
   * Constructs an instance of FoldersClient, using the given settings. This is protected so that it
   * is easy to make a subclass, but otherwise, the static factory methods should be preferred.
   */
  protected FoldersClient(FoldersSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((FoldersStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  protected FoldersClient(FoldersStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient =
        com.google.longrunning.OperationsClient.create(this.stub.getOperationsStub());
    this.httpJsonOperationsClient = OperationsClient.create(this.stub.getHttpJsonOperationsStub());
  }

  public final FoldersSettings getSettings() {
    return settings;
  }

  public FoldersStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  public final com.google.longrunning.OperationsClient getOperationsClient() {
    return operationsClient;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi
  public final OperationsClient getHttpJsonOperationsClient() {
    return httpJsonOperationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a folder identified by the supplied resource name. Valid folder resource names have
   * the format `folders/{folder_id}` (for example, `folders/1234`). The caller must have
   * `resourcemanager.folders.get` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   FolderName name = FolderName.of("[FOLDER]");
   *   Folder response = foldersClient.getFolder(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the folder to retrieve. Must be of the form
   *     `folders/{folder_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Folder getFolder(FolderName name) {
    GetFolderRequest request =
        GetFolderRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a folder identified by the supplied resource name. Valid folder resource names have
   * the format `folders/{folder_id}` (for example, `folders/1234`). The caller must have
   * `resourcemanager.folders.get` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   String name = FolderName.of("[FOLDER]").toString();
   *   Folder response = foldersClient.getFolder(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the folder to retrieve. Must be of the form
   *     `folders/{folder_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Folder getFolder(String name) {
    GetFolderRequest request = GetFolderRequest.newBuilder().setName(name).build();
    return getFolder(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a folder identified by the supplied resource name. Valid folder resource names have
   * the format `folders/{folder_id}` (for example, `folders/1234`). The caller must have
   * `resourcemanager.folders.get` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   GetFolderRequest request =
   *       GetFolderRequest.newBuilder().setName(FolderName.of("[FOLDER]").toString()).build();
   *   Folder response = foldersClient.getFolder(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Folder getFolder(GetFolderRequest request) {
    return getFolderCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves a folder identified by the supplied resource name. Valid folder resource names have
   * the format `folders/{folder_id}` (for example, `folders/1234`). The caller must have
   * `resourcemanager.folders.get` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   GetFolderRequest request =
   *       GetFolderRequest.newBuilder().setName(FolderName.of("[FOLDER]").toString()).build();
   *   ApiFuture<Folder> future = foldersClient.getFolderCallable().futureCall(request);
   *   // Do something.
   *   Folder response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetFolderRequest, Folder> getFolderCallable() {
    return stub.getFolderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the folders that are direct descendants of supplied parent resource. `list()` provides a
   * strongly consistent view of the folders underneath the specified parent resource. `list()`
   * returns folders sorted based upon the (ascending) lexical ordering of their display_name. The
   * caller must have `resourcemanager.folders.list` permission on the identified parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   ResourceName parent = FolderName.of("[FOLDER]");
   *   for (Folder element : foldersClient.listFolders(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the organization or folder whose folders are being
   *     listed. Must be of the form `folders/{folder_id}` or `organizations/{org_id}`. Access to
   *     this method is controlled by checking the `resourcemanager.folders.list` permission on the
   *     `parent`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFoldersPagedResponse listFolders(ResourceName parent) {
    ListFoldersRequest request =
        ListFoldersRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listFolders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the folders that are direct descendants of supplied parent resource. `list()` provides a
   * strongly consistent view of the folders underneath the specified parent resource. `list()`
   * returns folders sorted based upon the (ascending) lexical ordering of their display_name. The
   * caller must have `resourcemanager.folders.list` permission on the identified parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   String parent = FolderName.of("[FOLDER]").toString();
   *   for (Folder element : foldersClient.listFolders(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource name of the organization or folder whose folders are being
   *     listed. Must be of the form `folders/{folder_id}` or `organizations/{org_id}`. Access to
   *     this method is controlled by checking the `resourcemanager.folders.list` permission on the
   *     `parent`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFoldersPagedResponse listFolders(String parent) {
    ListFoldersRequest request = ListFoldersRequest.newBuilder().setParent(parent).build();
    return listFolders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the folders that are direct descendants of supplied parent resource. `list()` provides a
   * strongly consistent view of the folders underneath the specified parent resource. `list()`
   * returns folders sorted based upon the (ascending) lexical ordering of their display_name. The
   * caller must have `resourcemanager.folders.list` permission on the identified parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   ListFoldersRequest request =
   *       ListFoldersRequest.newBuilder()
   *           .setParent(FolderName.of("[FOLDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   for (Folder element : foldersClient.listFolders(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListFoldersPagedResponse listFolders(ListFoldersRequest request) {
    return listFoldersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the folders that are direct descendants of supplied parent resource. `list()` provides a
   * strongly consistent view of the folders underneath the specified parent resource. `list()`
   * returns folders sorted based upon the (ascending) lexical ordering of their display_name. The
   * caller must have `resourcemanager.folders.list` permission on the identified parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   ListFoldersRequest request =
   *       ListFoldersRequest.newBuilder()
   *           .setParent(FolderName.of("[FOLDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   ApiFuture<Folder> future = foldersClient.listFoldersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Folder element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListFoldersRequest, ListFoldersPagedResponse>
      listFoldersPagedCallable() {
    return stub.listFoldersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the folders that are direct descendants of supplied parent resource. `list()` provides a
   * strongly consistent view of the folders underneath the specified parent resource. `list()`
   * returns folders sorted based upon the (ascending) lexical ordering of their display_name. The
   * caller must have `resourcemanager.folders.list` permission on the identified parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   ListFoldersRequest request =
   *       ListFoldersRequest.newBuilder()
   *           .setParent(FolderName.of("[FOLDER]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setShowDeleted(true)
   *           .build();
   *   while (true) {
   *     ListFoldersResponse response = foldersClient.listFoldersCallable().call(request);
   *     for (Folder element : response.getFoldersList()) {
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
  public final UnaryCallable<ListFoldersRequest, ListFoldersResponse> listFoldersCallable() {
    return stub.listFoldersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search for folders that match specific filter criteria. `search()` provides an eventually
   * consistent view of the folders a user has access to which meet the specified filter criteria.
   *
   * <p>This will only return folders on which the caller has the permission
   * `resourcemanager.folders.get`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   String query = "query107944136";
   *   for (Folder element : foldersClient.searchFolders(query).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param query Optional. Search criteria used to select the folders to return. If no search
   *     criteria is specified then all accessible folders will be returned.
   *     <p>Query expressions can be used to restrict results based upon displayName, state and
   *     parent, where the operators `=` (`:`) `NOT`, `AND` and `OR` can be used along with the
   *     suffix wildcard symbol `&#42;`.
   *     <p>The `displayName` field in a query expression should use escaped quotes for values that
   *     include whitespace to prevent unexpected behavior.
   *     <p>``` | Field | Description |
   *     |-------------------------|----------------------------------------| | displayName |
   *     Filters by displayName. | | parent | Filters by parent (for example: folders/123). | |
   *     state, lifecycleState | Filters by state. | ```
   *     <p>Some example queries are:
   *     <ul>
   *       <li>Query `displayName=Test&#42;` returns Folder resources whose display name starts with
   *           "Test".
   *       <li>Query `state=ACTIVE` returns Folder resources with `state` set to `ACTIVE`.
   *       <li>Query `parent=folders/123` returns Folder resources that have `folders/123` as a
   *           parent resource.
   *       <li>Query `parent=folders/123 AND state=ACTIVE` returns active Folder resources that have
   *           `folders/123` as a parent resource.
   *       <li>Query `displayName=\\\\"Test String\\\\"` returns Folder resources with display names
   *           that include both "Test" and "String".
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchFoldersPagedResponse searchFolders(String query) {
    SearchFoldersRequest request = SearchFoldersRequest.newBuilder().setQuery(query).build();
    return searchFolders(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search for folders that match specific filter criteria. `search()` provides an eventually
   * consistent view of the folders a user has access to which meet the specified filter criteria.
   *
   * <p>This will only return folders on which the caller has the permission
   * `resourcemanager.folders.get`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   SearchFoldersRequest request =
   *       SearchFoldersRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setQuery("query107944136")
   *           .build();
   *   for (Folder element : foldersClient.searchFolders(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchFoldersPagedResponse searchFolders(SearchFoldersRequest request) {
    return searchFoldersPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search for folders that match specific filter criteria. `search()` provides an eventually
   * consistent view of the folders a user has access to which meet the specified filter criteria.
   *
   * <p>This will only return folders on which the caller has the permission
   * `resourcemanager.folders.get`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   SearchFoldersRequest request =
   *       SearchFoldersRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setQuery("query107944136")
   *           .build();
   *   ApiFuture<Folder> future = foldersClient.searchFoldersPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Folder element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchFoldersRequest, SearchFoldersPagedResponse>
      searchFoldersPagedCallable() {
    return stub.searchFoldersPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Search for folders that match specific filter criteria. `search()` provides an eventually
   * consistent view of the folders a user has access to which meet the specified filter criteria.
   *
   * <p>This will only return folders on which the caller has the permission
   * `resourcemanager.folders.get`.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   SearchFoldersRequest request =
   *       SearchFoldersRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setQuery("query107944136")
   *           .build();
   *   while (true) {
   *     SearchFoldersResponse response = foldersClient.searchFoldersCallable().call(request);
   *     for (Folder element : response.getFoldersList()) {
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
  public final UnaryCallable<SearchFoldersRequest, SearchFoldersResponse> searchFoldersCallable() {
    return stub.searchFoldersCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a folder in the resource hierarchy. Returns an `Operation` which can be used to track
   * the progress of the folder creation workflow. Upon success, the `Operation.response` field will
   * be populated with the created Folder.
   *
   * <p>In order to succeed, the addition of this new folder must not violate the folder naming,
   * height, or fanout constraints.
   *
   * <p>+ The folder's `display_name` must be distinct from all other folders that share its parent.
   * + The addition of the folder must not cause the active folder hierarchy to exceed a height of
   * 10. Note, the full active + deleted folder hierarchy is allowed to reach a height of 20; this
   * provides additional headroom when moving folders that contain deleted folders. + The addition
   * of the folder must not cause the total number of folders under its parent to exceed 300.
   *
   * <p>If the operation fails due to a folder constraint violation, some errors may be returned by
   * the `CreateFolder` request, with status code `FAILED_PRECONDITION` and an error description.
   * Other folder constraint violations will be communicated in the `Operation`, with the specific
   * `PreconditionFailure` returned in the details list in the `Operation.error` field.
   *
   * <p>The caller must have `resourcemanager.folders.create` permission on the identified parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   Folder folder = Folder.newBuilder().build();
   *   Folder response = foldersClient.createFolderAsync(folder).get();
   * }
   * }</pre>
   *
   * @param folder Required. The folder being created, only the display name and parent will be
   *     consulted. All other fields will be ignored.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Folder, CreateFolderMetadata> createFolderAsync(Folder folder) {
    CreateFolderRequest request = CreateFolderRequest.newBuilder().setFolder(folder).build();
    return createFolderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a folder in the resource hierarchy. Returns an `Operation` which can be used to track
   * the progress of the folder creation workflow. Upon success, the `Operation.response` field will
   * be populated with the created Folder.
   *
   * <p>In order to succeed, the addition of this new folder must not violate the folder naming,
   * height, or fanout constraints.
   *
   * <p>+ The folder's `display_name` must be distinct from all other folders that share its parent.
   * + The addition of the folder must not cause the active folder hierarchy to exceed a height of
   * 10. Note, the full active + deleted folder hierarchy is allowed to reach a height of 20; this
   * provides additional headroom when moving folders that contain deleted folders. + The addition
   * of the folder must not cause the total number of folders under its parent to exceed 300.
   *
   * <p>If the operation fails due to a folder constraint violation, some errors may be returned by
   * the `CreateFolder` request, with status code `FAILED_PRECONDITION` and an error description.
   * Other folder constraint violations will be communicated in the `Operation`, with the specific
   * `PreconditionFailure` returned in the details list in the `Operation.error` field.
   *
   * <p>The caller must have `resourcemanager.folders.create` permission on the identified parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   CreateFolderRequest request =
   *       CreateFolderRequest.newBuilder().setFolder(Folder.newBuilder().build()).build();
   *   Folder response = foldersClient.createFolderAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Folder, CreateFolderMetadata> createFolderAsync(
      CreateFolderRequest request) {
    return createFolderOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a folder in the resource hierarchy. Returns an `Operation` which can be used to track
   * the progress of the folder creation workflow. Upon success, the `Operation.response` field will
   * be populated with the created Folder.
   *
   * <p>In order to succeed, the addition of this new folder must not violate the folder naming,
   * height, or fanout constraints.
   *
   * <p>+ The folder's `display_name` must be distinct from all other folders that share its parent.
   * + The addition of the folder must not cause the active folder hierarchy to exceed a height of
   * 10. Note, the full active + deleted folder hierarchy is allowed to reach a height of 20; this
   * provides additional headroom when moving folders that contain deleted folders. + The addition
   * of the folder must not cause the total number of folders under its parent to exceed 300.
   *
   * <p>If the operation fails due to a folder constraint violation, some errors may be returned by
   * the `CreateFolder` request, with status code `FAILED_PRECONDITION` and an error description.
   * Other folder constraint violations will be communicated in the `Operation`, with the specific
   * `PreconditionFailure` returned in the details list in the `Operation.error` field.
   *
   * <p>The caller must have `resourcemanager.folders.create` permission on the identified parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   CreateFolderRequest request =
   *       CreateFolderRequest.newBuilder().setFolder(Folder.newBuilder().build()).build();
   *   OperationFuture<Folder, CreateFolderMetadata> future =
   *       foldersClient.createFolderOperationCallable().futureCall(request);
   *   // Do something.
   *   Folder response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<CreateFolderRequest, Folder, CreateFolderMetadata>
      createFolderOperationCallable() {
    return stub.createFolderOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a folder in the resource hierarchy. Returns an `Operation` which can be used to track
   * the progress of the folder creation workflow. Upon success, the `Operation.response` field will
   * be populated with the created Folder.
   *
   * <p>In order to succeed, the addition of this new folder must not violate the folder naming,
   * height, or fanout constraints.
   *
   * <p>+ The folder's `display_name` must be distinct from all other folders that share its parent.
   * + The addition of the folder must not cause the active folder hierarchy to exceed a height of
   * 10. Note, the full active + deleted folder hierarchy is allowed to reach a height of 20; this
   * provides additional headroom when moving folders that contain deleted folders. + The addition
   * of the folder must not cause the total number of folders under its parent to exceed 300.
   *
   * <p>If the operation fails due to a folder constraint violation, some errors may be returned by
   * the `CreateFolder` request, with status code `FAILED_PRECONDITION` and an error description.
   * Other folder constraint violations will be communicated in the `Operation`, with the specific
   * `PreconditionFailure` returned in the details list in the `Operation.error` field.
   *
   * <p>The caller must have `resourcemanager.folders.create` permission on the identified parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   CreateFolderRequest request =
   *       CreateFolderRequest.newBuilder().setFolder(Folder.newBuilder().build()).build();
   *   ApiFuture<Operation> future = foldersClient.createFolderCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateFolderRequest, Operation> createFolderCallable() {
    return stub.createFolderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a folder, changing its `display_name`. Changes to the folder `display_name` will be
   * rejected if they violate either the `display_name` formatting rules or the naming constraints
   * described in the [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder]
   * documentation.
   *
   * <p>The folder's `display_name` must start and end with a letter or digit, may contain letters,
   * digits, spaces, hyphens and underscores and can be between 3 and 30 characters. This is
   * captured by the regular expression: `[\\p{L}\\p{N}][\\p{L}\\p{N}_- ]{1,28}[\\p{L}\\p{N}]`. The
   * caller must have `resourcemanager.folders.update` permission on the identified folder.
   *
   * <p>If the update fails due to the unique name constraint then a `PreconditionFailure`
   * explaining this violation will be returned in the Status.details field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   Folder folder = Folder.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Folder response = foldersClient.updateFolderAsync(folder, updateMask).get();
   * }
   * }</pre>
   *
   * @param folder Required. The new definition of the Folder. It must include the `name` field,
   *     which cannot be changed.
   * @param updateMask Required. Fields to be updated. Only the `display_name` can be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Folder, UpdateFolderMetadata> updateFolderAsync(
      Folder folder, FieldMask updateMask) {
    UpdateFolderRequest request =
        UpdateFolderRequest.newBuilder().setFolder(folder).setUpdateMask(updateMask).build();
    return updateFolderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a folder, changing its `display_name`. Changes to the folder `display_name` will be
   * rejected if they violate either the `display_name` formatting rules or the naming constraints
   * described in the [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder]
   * documentation.
   *
   * <p>The folder's `display_name` must start and end with a letter or digit, may contain letters,
   * digits, spaces, hyphens and underscores and can be between 3 and 30 characters. This is
   * captured by the regular expression: `[\\p{L}\\p{N}][\\p{L}\\p{N}_- ]{1,28}[\\p{L}\\p{N}]`. The
   * caller must have `resourcemanager.folders.update` permission on the identified folder.
   *
   * <p>If the update fails due to the unique name constraint then a `PreconditionFailure`
   * explaining this violation will be returned in the Status.details field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   UpdateFolderRequest request =
   *       UpdateFolderRequest.newBuilder()
   *           .setFolder(Folder.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Folder response = foldersClient.updateFolderAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Folder, UpdateFolderMetadata> updateFolderAsync(
      UpdateFolderRequest request) {
    return updateFolderOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a folder, changing its `display_name`. Changes to the folder `display_name` will be
   * rejected if they violate either the `display_name` formatting rules or the naming constraints
   * described in the [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder]
   * documentation.
   *
   * <p>The folder's `display_name` must start and end with a letter or digit, may contain letters,
   * digits, spaces, hyphens and underscores and can be between 3 and 30 characters. This is
   * captured by the regular expression: `[\\p{L}\\p{N}][\\p{L}\\p{N}_- ]{1,28}[\\p{L}\\p{N}]`. The
   * caller must have `resourcemanager.folders.update` permission on the identified folder.
   *
   * <p>If the update fails due to the unique name constraint then a `PreconditionFailure`
   * explaining this violation will be returned in the Status.details field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   UpdateFolderRequest request =
   *       UpdateFolderRequest.newBuilder()
   *           .setFolder(Folder.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   OperationFuture<Folder, UpdateFolderMetadata> future =
   *       foldersClient.updateFolderOperationCallable().futureCall(request);
   *   // Do something.
   *   Folder response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UpdateFolderRequest, Folder, UpdateFolderMetadata>
      updateFolderOperationCallable() {
    return stub.updateFolderOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a folder, changing its `display_name`. Changes to the folder `display_name` will be
   * rejected if they violate either the `display_name` formatting rules or the naming constraints
   * described in the [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder]
   * documentation.
   *
   * <p>The folder's `display_name` must start and end with a letter or digit, may contain letters,
   * digits, spaces, hyphens and underscores and can be between 3 and 30 characters. This is
   * captured by the regular expression: `[\\p{L}\\p{N}][\\p{L}\\p{N}_- ]{1,28}[\\p{L}\\p{N}]`. The
   * caller must have `resourcemanager.folders.update` permission on the identified folder.
   *
   * <p>If the update fails due to the unique name constraint then a `PreconditionFailure`
   * explaining this violation will be returned in the Status.details field.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   UpdateFolderRequest request =
   *       UpdateFolderRequest.newBuilder()
   *           .setFolder(Folder.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Operation> future = foldersClient.updateFolderCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateFolderRequest, Operation> updateFolderCallable() {
    return stub.updateFolderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves a folder under a new resource parent. Returns an `Operation` which can be used to track
   * the progress of the folder move workflow. Upon success, the `Operation.response` field will be
   * populated with the moved folder. Upon failure, a `FolderOperationError` categorizing the
   * failure cause will be returned - if the failure occurs synchronously then the
   * `FolderOperationError` will be returned in the `Status.details` field. If it occurs
   * asynchronously, then the FolderOperation will be returned in the `Operation.error` field. In
   * addition, the `Operation.metadata` field will be populated with a `FolderOperation` message as
   * an aid to stateless clients. Folder moves will be rejected if they violate either the naming,
   * height, or fanout constraints described in the
   * [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder] documentation. The caller
   * must have `resourcemanager.folders.move` permission on the folder's current and proposed new
   * parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   FolderName name = FolderName.of("[FOLDER]");
   *   ResourceName destinationParent = FolderName.of("[FOLDER]");
   *   Folder response = foldersClient.moveFolderAsync(name, destinationParent).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Folder to move. Must be of the form
   *     folders/{folder_id}
   * @param destinationParent Required. The resource name of the folder or organization which should
   *     be the folder's new parent. Must be of the form `folders/{folder_id}` or
   *     `organizations/{org_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Folder, MoveFolderMetadata> moveFolderAsync(
      FolderName name, ResourceName destinationParent) {
    MoveFolderRequest request =
        MoveFolderRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setDestinationParent(destinationParent == null ? null : destinationParent.toString())
            .build();
    return moveFolderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves a folder under a new resource parent. Returns an `Operation` which can be used to track
   * the progress of the folder move workflow. Upon success, the `Operation.response` field will be
   * populated with the moved folder. Upon failure, a `FolderOperationError` categorizing the
   * failure cause will be returned - if the failure occurs synchronously then the
   * `FolderOperationError` will be returned in the `Status.details` field. If it occurs
   * asynchronously, then the FolderOperation will be returned in the `Operation.error` field. In
   * addition, the `Operation.metadata` field will be populated with a `FolderOperation` message as
   * an aid to stateless clients. Folder moves will be rejected if they violate either the naming,
   * height, or fanout constraints described in the
   * [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder] documentation. The caller
   * must have `resourcemanager.folders.move` permission on the folder's current and proposed new
   * parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   FolderName name = FolderName.of("[FOLDER]");
   *   String destinationParent = FolderName.of("[FOLDER]").toString();
   *   Folder response = foldersClient.moveFolderAsync(name, destinationParent).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Folder to move. Must be of the form
   *     folders/{folder_id}
   * @param destinationParent Required. The resource name of the folder or organization which should
   *     be the folder's new parent. Must be of the form `folders/{folder_id}` or
   *     `organizations/{org_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Folder, MoveFolderMetadata> moveFolderAsync(
      FolderName name, String destinationParent) {
    MoveFolderRequest request =
        MoveFolderRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setDestinationParent(destinationParent)
            .build();
    return moveFolderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves a folder under a new resource parent. Returns an `Operation` which can be used to track
   * the progress of the folder move workflow. Upon success, the `Operation.response` field will be
   * populated with the moved folder. Upon failure, a `FolderOperationError` categorizing the
   * failure cause will be returned - if the failure occurs synchronously then the
   * `FolderOperationError` will be returned in the `Status.details` field. If it occurs
   * asynchronously, then the FolderOperation will be returned in the `Operation.error` field. In
   * addition, the `Operation.metadata` field will be populated with a `FolderOperation` message as
   * an aid to stateless clients. Folder moves will be rejected if they violate either the naming,
   * height, or fanout constraints described in the
   * [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder] documentation. The caller
   * must have `resourcemanager.folders.move` permission on the folder's current and proposed new
   * parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   String name = FolderName.of("[FOLDER]").toString();
   *   ResourceName destinationParent = FolderName.of("[FOLDER]");
   *   Folder response = foldersClient.moveFolderAsync(name, destinationParent).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Folder to move. Must be of the form
   *     folders/{folder_id}
   * @param destinationParent Required. The resource name of the folder or organization which should
   *     be the folder's new parent. Must be of the form `folders/{folder_id}` or
   *     `organizations/{org_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Folder, MoveFolderMetadata> moveFolderAsync(
      String name, ResourceName destinationParent) {
    MoveFolderRequest request =
        MoveFolderRequest.newBuilder()
            .setName(name)
            .setDestinationParent(destinationParent == null ? null : destinationParent.toString())
            .build();
    return moveFolderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves a folder under a new resource parent. Returns an `Operation` which can be used to track
   * the progress of the folder move workflow. Upon success, the `Operation.response` field will be
   * populated with the moved folder. Upon failure, a `FolderOperationError` categorizing the
   * failure cause will be returned - if the failure occurs synchronously then the
   * `FolderOperationError` will be returned in the `Status.details` field. If it occurs
   * asynchronously, then the FolderOperation will be returned in the `Operation.error` field. In
   * addition, the `Operation.metadata` field will be populated with a `FolderOperation` message as
   * an aid to stateless clients. Folder moves will be rejected if they violate either the naming,
   * height, or fanout constraints described in the
   * [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder] documentation. The caller
   * must have `resourcemanager.folders.move` permission on the folder's current and proposed new
   * parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   String name = FolderName.of("[FOLDER]").toString();
   *   String destinationParent = FolderName.of("[FOLDER]").toString();
   *   Folder response = foldersClient.moveFolderAsync(name, destinationParent).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the Folder to move. Must be of the form
   *     folders/{folder_id}
   * @param destinationParent Required. The resource name of the folder or organization which should
   *     be the folder's new parent. Must be of the form `folders/{folder_id}` or
   *     `organizations/{org_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Folder, MoveFolderMetadata> moveFolderAsync(
      String name, String destinationParent) {
    MoveFolderRequest request =
        MoveFolderRequest.newBuilder()
            .setName(name)
            .setDestinationParent(destinationParent)
            .build();
    return moveFolderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves a folder under a new resource parent. Returns an `Operation` which can be used to track
   * the progress of the folder move workflow. Upon success, the `Operation.response` field will be
   * populated with the moved folder. Upon failure, a `FolderOperationError` categorizing the
   * failure cause will be returned - if the failure occurs synchronously then the
   * `FolderOperationError` will be returned in the `Status.details` field. If it occurs
   * asynchronously, then the FolderOperation will be returned in the `Operation.error` field. In
   * addition, the `Operation.metadata` field will be populated with a `FolderOperation` message as
   * an aid to stateless clients. Folder moves will be rejected if they violate either the naming,
   * height, or fanout constraints described in the
   * [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder] documentation. The caller
   * must have `resourcemanager.folders.move` permission on the folder's current and proposed new
   * parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   MoveFolderRequest request =
   *       MoveFolderRequest.newBuilder()
   *           .setName(FolderName.of("[FOLDER]").toString())
   *           .setDestinationParent(FolderName.of("[FOLDER]").toString())
   *           .build();
   *   Folder response = foldersClient.moveFolderAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Folder, MoveFolderMetadata> moveFolderAsync(
      MoveFolderRequest request) {
    return moveFolderOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves a folder under a new resource parent. Returns an `Operation` which can be used to track
   * the progress of the folder move workflow. Upon success, the `Operation.response` field will be
   * populated with the moved folder. Upon failure, a `FolderOperationError` categorizing the
   * failure cause will be returned - if the failure occurs synchronously then the
   * `FolderOperationError` will be returned in the `Status.details` field. If it occurs
   * asynchronously, then the FolderOperation will be returned in the `Operation.error` field. In
   * addition, the `Operation.metadata` field will be populated with a `FolderOperation` message as
   * an aid to stateless clients. Folder moves will be rejected if they violate either the naming,
   * height, or fanout constraints described in the
   * [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder] documentation. The caller
   * must have `resourcemanager.folders.move` permission on the folder's current and proposed new
   * parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   MoveFolderRequest request =
   *       MoveFolderRequest.newBuilder()
   *           .setName(FolderName.of("[FOLDER]").toString())
   *           .setDestinationParent(FolderName.of("[FOLDER]").toString())
   *           .build();
   *   OperationFuture<Folder, MoveFolderMetadata> future =
   *       foldersClient.moveFolderOperationCallable().futureCall(request);
   *   // Do something.
   *   Folder response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<MoveFolderRequest, Folder, MoveFolderMetadata>
      moveFolderOperationCallable() {
    return stub.moveFolderOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Moves a folder under a new resource parent. Returns an `Operation` which can be used to track
   * the progress of the folder move workflow. Upon success, the `Operation.response` field will be
   * populated with the moved folder. Upon failure, a `FolderOperationError` categorizing the
   * failure cause will be returned - if the failure occurs synchronously then the
   * `FolderOperationError` will be returned in the `Status.details` field. If it occurs
   * asynchronously, then the FolderOperation will be returned in the `Operation.error` field. In
   * addition, the `Operation.metadata` field will be populated with a `FolderOperation` message as
   * an aid to stateless clients. Folder moves will be rejected if they violate either the naming,
   * height, or fanout constraints described in the
   * [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder] documentation. The caller
   * must have `resourcemanager.folders.move` permission on the folder's current and proposed new
   * parent.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   MoveFolderRequest request =
   *       MoveFolderRequest.newBuilder()
   *           .setName(FolderName.of("[FOLDER]").toString())
   *           .setDestinationParent(FolderName.of("[FOLDER]").toString())
   *           .build();
   *   ApiFuture<Operation> future = foldersClient.moveFolderCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<MoveFolderRequest, Operation> moveFolderCallable() {
    return stub.moveFolderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests deletion of a folder. The folder is moved into the
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Folder.State.DELETE_REQUESTED] state
   * immediately, and is deleted approximately 30 days later. This method may only be called on an
   * empty folder, where a folder is empty if it doesn't contain any folders or projects in the
   * [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE] state. If called on a folder in
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Folder.State.DELETE_REQUESTED] state the
   * operation will result in a no-op success. The caller must have `resourcemanager.folders.delete`
   * permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   FolderName name = FolderName.of("[FOLDER]");
   *   Folder response = foldersClient.deleteFolderAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the folder to be deleted. Must be of the form
   *     `folders/{folder_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Folder, DeleteFolderMetadata> deleteFolderAsync(FolderName name) {
    DeleteFolderRequest request =
        DeleteFolderRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteFolderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests deletion of a folder. The folder is moved into the
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Folder.State.DELETE_REQUESTED] state
   * immediately, and is deleted approximately 30 days later. This method may only be called on an
   * empty folder, where a folder is empty if it doesn't contain any folders or projects in the
   * [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE] state. If called on a folder in
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Folder.State.DELETE_REQUESTED] state the
   * operation will result in a no-op success. The caller must have `resourcemanager.folders.delete`
   * permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   String name = FolderName.of("[FOLDER]").toString();
   *   Folder response = foldersClient.deleteFolderAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the folder to be deleted. Must be of the form
   *     `folders/{folder_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Folder, DeleteFolderMetadata> deleteFolderAsync(String name) {
    DeleteFolderRequest request = DeleteFolderRequest.newBuilder().setName(name).build();
    return deleteFolderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests deletion of a folder. The folder is moved into the
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Folder.State.DELETE_REQUESTED] state
   * immediately, and is deleted approximately 30 days later. This method may only be called on an
   * empty folder, where a folder is empty if it doesn't contain any folders or projects in the
   * [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE] state. If called on a folder in
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Folder.State.DELETE_REQUESTED] state the
   * operation will result in a no-op success. The caller must have `resourcemanager.folders.delete`
   * permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   DeleteFolderRequest request =
   *       DeleteFolderRequest.newBuilder().setName(FolderName.of("[FOLDER]").toString()).build();
   *   Folder response = foldersClient.deleteFolderAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Folder, DeleteFolderMetadata> deleteFolderAsync(
      DeleteFolderRequest request) {
    return deleteFolderOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests deletion of a folder. The folder is moved into the
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Folder.State.DELETE_REQUESTED] state
   * immediately, and is deleted approximately 30 days later. This method may only be called on an
   * empty folder, where a folder is empty if it doesn't contain any folders or projects in the
   * [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE] state. If called on a folder in
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Folder.State.DELETE_REQUESTED] state the
   * operation will result in a no-op success. The caller must have `resourcemanager.folders.delete`
   * permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   DeleteFolderRequest request =
   *       DeleteFolderRequest.newBuilder().setName(FolderName.of("[FOLDER]").toString()).build();
   *   OperationFuture<Folder, DeleteFolderMetadata> future =
   *       foldersClient.deleteFolderOperationCallable().futureCall(request);
   *   // Do something.
   *   Folder response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<DeleteFolderRequest, Folder, DeleteFolderMetadata>
      deleteFolderOperationCallable() {
    return stub.deleteFolderOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Requests deletion of a folder. The folder is moved into the
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Folder.State.DELETE_REQUESTED] state
   * immediately, and is deleted approximately 30 days later. This method may only be called on an
   * empty folder, where a folder is empty if it doesn't contain any folders or projects in the
   * [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE] state. If called on a folder in
   * [DELETE_REQUESTED][google.cloud.resourcemanager.v3.Folder.State.DELETE_REQUESTED] state the
   * operation will result in a no-op success. The caller must have `resourcemanager.folders.delete`
   * permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   DeleteFolderRequest request =
   *       DeleteFolderRequest.newBuilder().setName(FolderName.of("[FOLDER]").toString()).build();
   *   ApiFuture<Operation> future = foldersClient.deleteFolderCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteFolderRequest, Operation> deleteFolderCallable() {
    return stub.deleteFolderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the deletion request for a folder. This method may be called on a folder in any state.
   * If the folder is in the [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE] state the
   * result will be a no-op success. In order to succeed, the folder's parent must be in the
   * [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE] state. In addition, reintroducing
   * the folder into the tree must not violate folder naming, height, and fanout constraints
   * described in the [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder]
   * documentation. The caller must have `resourcemanager.folders.undelete` permission on the
   * identified folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   FolderName name = FolderName.of("[FOLDER]");
   *   Folder response = foldersClient.undeleteFolderAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the folder to undelete. Must be of the form
   *     `folders/{folder_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Folder, UndeleteFolderMetadata> undeleteFolderAsync(
      FolderName name) {
    UndeleteFolderRequest request =
        UndeleteFolderRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return undeleteFolderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the deletion request for a folder. This method may be called on a folder in any state.
   * If the folder is in the [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE] state the
   * result will be a no-op success. In order to succeed, the folder's parent must be in the
   * [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE] state. In addition, reintroducing
   * the folder into the tree must not violate folder naming, height, and fanout constraints
   * described in the [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder]
   * documentation. The caller must have `resourcemanager.folders.undelete` permission on the
   * identified folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   String name = FolderName.of("[FOLDER]").toString();
   *   Folder response = foldersClient.undeleteFolderAsync(name).get();
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the folder to undelete. Must be of the form
   *     `folders/{folder_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Folder, UndeleteFolderMetadata> undeleteFolderAsync(String name) {
    UndeleteFolderRequest request = UndeleteFolderRequest.newBuilder().setName(name).build();
    return undeleteFolderAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the deletion request for a folder. This method may be called on a folder in any state.
   * If the folder is in the [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE] state the
   * result will be a no-op success. In order to succeed, the folder's parent must be in the
   * [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE] state. In addition, reintroducing
   * the folder into the tree must not violate folder naming, height, and fanout constraints
   * described in the [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder]
   * documentation. The caller must have `resourcemanager.folders.undelete` permission on the
   * identified folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   UndeleteFolderRequest request =
   *       UndeleteFolderRequest.newBuilder().setName(FolderName.of("[FOLDER]").toString()).build();
   *   Folder response = foldersClient.undeleteFolderAsync(request).get();
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final OperationFuture<Folder, UndeleteFolderMetadata> undeleteFolderAsync(
      UndeleteFolderRequest request) {
    return undeleteFolderOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the deletion request for a folder. This method may be called on a folder in any state.
   * If the folder is in the [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE] state the
   * result will be a no-op success. In order to succeed, the folder's parent must be in the
   * [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE] state. In addition, reintroducing
   * the folder into the tree must not violate folder naming, height, and fanout constraints
   * described in the [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder]
   * documentation. The caller must have `resourcemanager.folders.undelete` permission on the
   * identified folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   UndeleteFolderRequest request =
   *       UndeleteFolderRequest.newBuilder().setName(FolderName.of("[FOLDER]").toString()).build();
   *   OperationFuture<Folder, UndeleteFolderMetadata> future =
   *       foldersClient.undeleteFolderOperationCallable().futureCall(request);
   *   // Do something.
   *   Folder response = future.get();
   * }
   * }</pre>
   */
  public final OperationCallable<UndeleteFolderRequest, Folder, UndeleteFolderMetadata>
      undeleteFolderOperationCallable() {
    return stub.undeleteFolderOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Cancels the deletion request for a folder. This method may be called on a folder in any state.
   * If the folder is in the [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE] state the
   * result will be a no-op success. In order to succeed, the folder's parent must be in the
   * [ACTIVE][google.cloud.resourcemanager.v3.Folder.State.ACTIVE] state. In addition, reintroducing
   * the folder into the tree must not violate folder naming, height, and fanout constraints
   * described in the [CreateFolder][google.cloud.resourcemanager.v3.Folders.CreateFolder]
   * documentation. The caller must have `resourcemanager.folders.undelete` permission on the
   * identified folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   UndeleteFolderRequest request =
   *       UndeleteFolderRequest.newBuilder().setName(FolderName.of("[FOLDER]").toString()).build();
   *   ApiFuture<Operation> future = foldersClient.undeleteFolderCallable().futureCall(request);
   *   // Do something.
   *   Operation response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UndeleteFolderRequest, Operation> undeleteFolderCallable() {
    return stub.undeleteFolderCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a folder. The returned policy may be empty if no such policy
   * or resource exists. The `resource` field should be the folder's resource name, for example:
   * "folders/1234". The caller must have `resourcemanager.folders.getIamPolicy` permission on the
   * identified folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   ResourceName resource = FolderName.of("[FOLDER]");
   *   Policy response = foldersClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(ResourceName resource) {
    GetIamPolicyRequest request =
        GetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a folder. The returned policy may be empty if no such policy
   * or resource exists. The `resource` field should be the folder's resource name, for example:
   * "folders/1234". The caller must have `resourcemanager.folders.getIamPolicy` permission on the
   * identified folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   String resource = FolderName.of("[FOLDER]").toString();
   *   Policy response = foldersClient.getIamPolicy(resource);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(String resource) {
    GetIamPolicyRequest request = GetIamPolicyRequest.newBuilder().setResource(resource).build();
    return getIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a folder. The returned policy may be empty if no such policy
   * or resource exists. The `resource` field should be the folder's resource name, for example:
   * "folders/1234". The caller must have `resourcemanager.folders.getIamPolicy` permission on the
   * identified folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(FolderName.of("[FOLDER]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = foldersClient.getIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy getIamPolicy(GetIamPolicyRequest request) {
    return getIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the access control policy for a folder. The returned policy may be empty if no such policy
   * or resource exists. The `resource` field should be the folder's resource name, for example:
   * "folders/1234". The caller must have `resourcemanager.folders.getIamPolicy` permission on the
   * identified folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(FolderName.of("[FOLDER]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = foldersClient.getIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetIamPolicyRequest, Policy> getIamPolicyCallable() {
    return stub.getIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on a folder, replacing any existing policy. The `resource` field
   * should be the folder's resource name, for example: "folders/1234". The caller must have
   * `resourcemanager.folders.setIamPolicy` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   ResourceName resource = FolderName.of("[FOLDER]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = foldersClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(ResourceName resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .setPolicy(policy)
            .build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on a folder, replacing any existing policy. The `resource` field
   * should be the folder's resource name, for example: "folders/1234". The caller must have
   * `resourcemanager.folders.setIamPolicy` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   String resource = FolderName.of("[FOLDER]").toString();
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = foldersClient.setIamPolicy(resource, policy);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy is being specified. See the
   *     operation documentation for the appropriate value for this field.
   * @param policy REQUIRED: The complete policy to be applied to the `resource`. The size of the
   *     policy is limited to a few 10s of KB. An empty policy is a valid policy but certain Cloud
   *     Platform services (such as Projects) might reject them.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(String resource, Policy policy) {
    SetIamPolicyRequest request =
        SetIamPolicyRequest.newBuilder().setResource(resource).setPolicy(policy).build();
    return setIamPolicy(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on a folder, replacing any existing policy. The `resource` field
   * should be the folder's resource name, for example: "folders/1234". The caller must have
   * `resourcemanager.folders.setIamPolicy` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(FolderName.of("[FOLDER]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Policy response = foldersClient.setIamPolicy(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Policy setIamPolicy(SetIamPolicyRequest request) {
    return setIamPolicyCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy on a folder, replacing any existing policy. The `resource` field
   * should be the folder's resource name, for example: "folders/1234". The caller must have
   * `resourcemanager.folders.setIamPolicy` permission on the identified folder.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(FolderName.of("[FOLDER]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = foldersClient.setIamPolicyCallable().futureCall(request);
   *   // Do something.
   *   Policy response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<SetIamPolicyRequest, Policy> setIamPolicyCallable() {
    return stub.setIamPolicyCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified folder. The `resource` field should be
   * the folder's resource name, for example: "folders/1234".
   *
   * <p>There are no permissions required for making this API call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   ResourceName resource = FolderName.of("[FOLDER]");
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response = foldersClient.testIamPermissions(resource, permissions);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      ResourceName resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource == null ? null : resource.toString())
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified folder. The `resource` field should be
   * the folder's resource name, for example: "folders/1234".
   *
   * <p>There are no permissions required for making this API call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   String resource = FolderName.of("[FOLDER]").toString();
   *   List<String> permissions = new ArrayList<>();
   *   TestIamPermissionsResponse response = foldersClient.testIamPermissions(resource, permissions);
   * }
   * }</pre>
   *
   * @param resource REQUIRED: The resource for which the policy detail is being requested. See the
   *     operation documentation for the appropriate value for this field.
   * @param permissions The set of permissions to check for the `resource`. Permissions with
   *     wildcards (such as '&#42;' or 'storage.&#42;') are not allowed. For more information see
   *     [IAM Overview](https://cloud.google.com/iam/docs/overview#permissions).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(
      String resource, List<String> permissions) {
    TestIamPermissionsRequest request =
        TestIamPermissionsRequest.newBuilder()
            .setResource(resource)
            .addAllPermissions(permissions)
            .build();
    return testIamPermissions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified folder. The `resource` field should be
   * the folder's resource name, for example: "folders/1234".
   *
   * <p>There are no permissions required for making this API call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(FolderName.of("[FOLDER]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = foldersClient.testIamPermissions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TestIamPermissionsResponse testIamPermissions(TestIamPermissionsRequest request) {
    return testIamPermissionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Returns permissions that a caller has on the specified folder. The `resource` field should be
   * the folder's resource name, for example: "folders/1234".
   *
   * <p>There are no permissions required for making this API call.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (FoldersClient foldersClient = FoldersClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(FolderName.of("[FOLDER]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       foldersClient.testIamPermissionsCallable().futureCall(request);
   *   // Do something.
   *   TestIamPermissionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<TestIamPermissionsRequest, TestIamPermissionsResponse>
      testIamPermissionsCallable() {
    return stub.testIamPermissionsCallable();
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

  public static class ListFoldersPagedResponse
      extends AbstractPagedListResponse<
          ListFoldersRequest,
          ListFoldersResponse,
          Folder,
          ListFoldersPage,
          ListFoldersFixedSizeCollection> {

    public static ApiFuture<ListFoldersPagedResponse> createAsync(
        PageContext<ListFoldersRequest, ListFoldersResponse, Folder> context,
        ApiFuture<ListFoldersResponse> futureResponse) {
      ApiFuture<ListFoldersPage> futurePage =
          ListFoldersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListFoldersPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListFoldersPagedResponse(ListFoldersPage page) {
      super(page, ListFoldersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListFoldersPage
      extends AbstractPage<ListFoldersRequest, ListFoldersResponse, Folder, ListFoldersPage> {

    private ListFoldersPage(
        PageContext<ListFoldersRequest, ListFoldersResponse, Folder> context,
        ListFoldersResponse response) {
      super(context, response);
    }

    private static ListFoldersPage createEmptyPage() {
      return new ListFoldersPage(null, null);
    }

    @Override
    protected ListFoldersPage createPage(
        PageContext<ListFoldersRequest, ListFoldersResponse, Folder> context,
        ListFoldersResponse response) {
      return new ListFoldersPage(context, response);
    }

    @Override
    public ApiFuture<ListFoldersPage> createPageAsync(
        PageContext<ListFoldersRequest, ListFoldersResponse, Folder> context,
        ApiFuture<ListFoldersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListFoldersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListFoldersRequest,
          ListFoldersResponse,
          Folder,
          ListFoldersPage,
          ListFoldersFixedSizeCollection> {

    private ListFoldersFixedSizeCollection(List<ListFoldersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListFoldersFixedSizeCollection createEmptyCollection() {
      return new ListFoldersFixedSizeCollection(null, 0);
    }

    @Override
    protected ListFoldersFixedSizeCollection createCollection(
        List<ListFoldersPage> pages, int collectionSize) {
      return new ListFoldersFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class SearchFoldersPagedResponse
      extends AbstractPagedListResponse<
          SearchFoldersRequest,
          SearchFoldersResponse,
          Folder,
          SearchFoldersPage,
          SearchFoldersFixedSizeCollection> {

    public static ApiFuture<SearchFoldersPagedResponse> createAsync(
        PageContext<SearchFoldersRequest, SearchFoldersResponse, Folder> context,
        ApiFuture<SearchFoldersResponse> futureResponse) {
      ApiFuture<SearchFoldersPage> futurePage =
          SearchFoldersPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new SearchFoldersPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private SearchFoldersPagedResponse(SearchFoldersPage page) {
      super(page, SearchFoldersFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchFoldersPage
      extends AbstractPage<SearchFoldersRequest, SearchFoldersResponse, Folder, SearchFoldersPage> {

    private SearchFoldersPage(
        PageContext<SearchFoldersRequest, SearchFoldersResponse, Folder> context,
        SearchFoldersResponse response) {
      super(context, response);
    }

    private static SearchFoldersPage createEmptyPage() {
      return new SearchFoldersPage(null, null);
    }

    @Override
    protected SearchFoldersPage createPage(
        PageContext<SearchFoldersRequest, SearchFoldersResponse, Folder> context,
        SearchFoldersResponse response) {
      return new SearchFoldersPage(context, response);
    }

    @Override
    public ApiFuture<SearchFoldersPage> createPageAsync(
        PageContext<SearchFoldersRequest, SearchFoldersResponse, Folder> context,
        ApiFuture<SearchFoldersResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchFoldersFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchFoldersRequest,
          SearchFoldersResponse,
          Folder,
          SearchFoldersPage,
          SearchFoldersFixedSizeCollection> {

    private SearchFoldersFixedSizeCollection(List<SearchFoldersPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchFoldersFixedSizeCollection createEmptyCollection() {
      return new SearchFoldersFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchFoldersFixedSizeCollection createCollection(
        List<SearchFoldersPage> pages, int collectionSize) {
      return new SearchFoldersFixedSizeCollection(pages, collectionSize);
    }
  }
}
