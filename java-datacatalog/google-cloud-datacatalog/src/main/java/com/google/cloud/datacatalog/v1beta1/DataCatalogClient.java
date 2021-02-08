/*
 * Copyright 2020 Google LLC
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

package com.google.cloud.datacatalog.v1beta1;

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
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.datacatalog.v1beta1.stub.DataCatalogStub;
import com.google.cloud.datacatalog.v1beta1.stub.DataCatalogStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.iam.v1.GetIamPolicyRequest;
import com.google.iam.v1.Policy;
import com.google.iam.v1.SetIamPolicyRequest;
import com.google.iam.v1.TestIamPermissionsRequest;
import com.google.iam.v1.TestIamPermissionsResponse;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Data Catalog API service allows clients to discover, understand, and manage
 * their data.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   String entryGroupId = "entryGroupId1228924712";
 *   EntryGroup entryGroup = EntryGroup.newBuilder().build();
 *   EntryGroup response = dataCatalogClient.createEntryGroup(parent, entryGroupId, entryGroup);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataCatalogClient object to clean up resources such as
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
 * <p>This class can be customized by passing in a custom instance of DataCatalogSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * DataCatalogSettings dataCatalogSettings =
 *     DataCatalogSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataCatalogClient dataCatalogClient = DataCatalogClient.create(dataCatalogSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * DataCatalogSettings dataCatalogSettings =
 *     DataCatalogSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataCatalogClient dataCatalogClient = DataCatalogClient.create(dataCatalogSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataCatalogClient implements BackgroundResource {
  private final DataCatalogSettings settings;
  private final DataCatalogStub stub;

  /** Constructs an instance of DataCatalogClient with default settings. */
  public static final DataCatalogClient create() throws IOException {
    return create(DataCatalogSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataCatalogClient, using the given settings. The channels are created
   * based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataCatalogClient create(DataCatalogSettings settings) throws IOException {
    return new DataCatalogClient(settings);
  }

  /**
   * Constructs an instance of DataCatalogClient, using the given stub for making calls. This is for
   * advanced usage - prefer using create(DataCatalogSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final DataCatalogClient create(DataCatalogStub stub) {
    return new DataCatalogClient(stub);
  }

  /**
   * Constructs an instance of DataCatalogClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DataCatalogClient(DataCatalogSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DataCatalogStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected DataCatalogClient(DataCatalogStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DataCatalogSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public DataCatalogStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches Data Catalog for multiple resources like entries, tags that match a query.
   *
   * <p>This is a custom method (https://cloud.google.com/apis/design/custom_methods) and does not
   * return the complete resource, only the resource identifier and high level fields. Clients can
   * subsequentally call `Get` methods.
   *
   * <p>Note that Data Catalog search queries do not guarantee full recall. Query results that match
   * your query may not be returned, even in subsequent result pages. Also note that results
   * returned (and not returned) can vary across repeated search queries.
   *
   * <p>See [Data Catalog Search
   * Syntax](https://cloud.google.com/data-catalog/docs/how-to/search-reference) for more
   * information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   SearchCatalogRequest.Scope scope = SearchCatalogRequest.Scope.newBuilder().build();
   *   String query = "query107944136";
   *   for (SearchCatalogResult element :
   *       dataCatalogClient.searchCatalog(scope, query).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param scope Required. The scope of this search request. A `scope` that has empty
   *     `include_org_ids`, `include_project_ids` AND false `include_gcp_public_datasets` is
   *     considered invalid. Data Catalog will return an error in such a case.
   * @param query Required. The query string in search query syntax. The query must be non-empty.
   *     <p>Query strings can be simple as "x" or more qualified as:
   *     <ul>
   *       <li>name:x
   *       <li>column:x
   *       <li>description:y
   *     </ul>
   *     <p>Note: Query tokens need to have a minimum of 3 characters for substring matching to work
   *     correctly. See [Data Catalog Search
   *     Syntax](https://cloud.google.com/data-catalog/docs/how-to/search-reference) for more
   *     information.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchCatalogPagedResponse searchCatalog(
      SearchCatalogRequest.Scope scope, String query) {
    SearchCatalogRequest request =
        SearchCatalogRequest.newBuilder().setScope(scope).setQuery(query).build();
    return searchCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches Data Catalog for multiple resources like entries, tags that match a query.
   *
   * <p>This is a custom method (https://cloud.google.com/apis/design/custom_methods) and does not
   * return the complete resource, only the resource identifier and high level fields. Clients can
   * subsequentally call `Get` methods.
   *
   * <p>Note that Data Catalog search queries do not guarantee full recall. Query results that match
   * your query may not be returned, even in subsequent result pages. Also note that results
   * returned (and not returned) can vary across repeated search queries.
   *
   * <p>See [Data Catalog Search
   * Syntax](https://cloud.google.com/data-catalog/docs/how-to/search-reference) for more
   * information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   SearchCatalogRequest request =
   *       SearchCatalogRequest.newBuilder()
   *           .setScope(SearchCatalogRequest.Scope.newBuilder().build())
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (SearchCatalogResult element : dataCatalogClient.searchCatalog(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final SearchCatalogPagedResponse searchCatalog(SearchCatalogRequest request) {
    return searchCatalogPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches Data Catalog for multiple resources like entries, tags that match a query.
   *
   * <p>This is a custom method (https://cloud.google.com/apis/design/custom_methods) and does not
   * return the complete resource, only the resource identifier and high level fields. Clients can
   * subsequentally call `Get` methods.
   *
   * <p>Note that Data Catalog search queries do not guarantee full recall. Query results that match
   * your query may not be returned, even in subsequent result pages. Also note that results
   * returned (and not returned) can vary across repeated search queries.
   *
   * <p>See [Data Catalog Search
   * Syntax](https://cloud.google.com/data-catalog/docs/how-to/search-reference) for more
   * information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   SearchCatalogRequest request =
   *       SearchCatalogRequest.newBuilder()
   *           .setScope(SearchCatalogRequest.Scope.newBuilder().build())
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<SearchCatalogResult> future =
   *       dataCatalogClient.searchCatalogPagedCallable().futureCall(request);
   *   // Do something.
   *   for (SearchCatalogResult element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<SearchCatalogRequest, SearchCatalogPagedResponse>
      searchCatalogPagedCallable() {
    return stub.searchCatalogPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches Data Catalog for multiple resources like entries, tags that match a query.
   *
   * <p>This is a custom method (https://cloud.google.com/apis/design/custom_methods) and does not
   * return the complete resource, only the resource identifier and high level fields. Clients can
   * subsequentally call `Get` methods.
   *
   * <p>Note that Data Catalog search queries do not guarantee full recall. Query results that match
   * your query may not be returned, even in subsequent result pages. Also note that results
   * returned (and not returned) can vary across repeated search queries.
   *
   * <p>See [Data Catalog Search
   * Syntax](https://cloud.google.com/data-catalog/docs/how-to/search-reference) for more
   * information.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   while (true) {
   *     SearchCatalogResponse response = dataCatalogClient.searchCatalogCallable().call(request);
   *     for (SearchCatalogResult element : response.getResponsesList()) {
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
  public final UnaryCallable<SearchCatalogRequest, SearchCatalogResponse> searchCatalogCallable() {
    return stub.searchCatalogCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * A maximum of 10,000 entry groups may be created per organization across all locations.
   *
   * <p>Users should enable the Data Catalog API in the project identified by the `parent` parameter
   * (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String entryGroupId = "entryGroupId1228924712";
   *   EntryGroup entryGroup = EntryGroup.newBuilder().build();
   *   EntryGroup response = dataCatalogClient.createEntryGroup(parent, entryGroupId, entryGroup);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project this entry group is in. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}
   *     </ul>
   *     <p>Note that this EntryGroup and its child resources may not actually be stored in the
   *     location in this name.
   * @param entryGroupId Required. The id of the entry group to create. The id must begin with a
   *     letter or underscore, contain only English letters, numbers and underscores, and be at most
   *     64 characters.
   * @param entryGroup The entry group to create. Defaults to an empty entry group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryGroup createEntryGroup(
      LocationName parent, String entryGroupId, EntryGroup entryGroup) {
    CreateEntryGroupRequest request =
        CreateEntryGroupRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEntryGroupId(entryGroupId)
            .setEntryGroup(entryGroup)
            .build();
    return createEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * A maximum of 10,000 entry groups may be created per organization across all locations.
   *
   * <p>Users should enable the Data Catalog API in the project identified by the `parent` parameter
   * (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString();
   *   String entryGroupId = "entryGroupId1228924712";
   *   EntryGroup entryGroup = EntryGroup.newBuilder().build();
   *   EntryGroup response = dataCatalogClient.createEntryGroup(parent, entryGroupId, entryGroup);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project this entry group is in. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}
   *     </ul>
   *     <p>Note that this EntryGroup and its child resources may not actually be stored in the
   *     location in this name.
   * @param entryGroupId Required. The id of the entry group to create. The id must begin with a
   *     letter or underscore, contain only English letters, numbers and underscores, and be at most
   *     64 characters.
   * @param entryGroup The entry group to create. Defaults to an empty entry group.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryGroup createEntryGroup(
      String parent, String entryGroupId, EntryGroup entryGroup) {
    CreateEntryGroupRequest request =
        CreateEntryGroupRequest.newBuilder()
            .setParent(parent)
            .setEntryGroupId(entryGroupId)
            .setEntryGroup(entryGroup)
            .build();
    return createEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * A maximum of 10,000 entry groups may be created per organization across all locations.
   *
   * <p>Users should enable the Data Catalog API in the project identified by the `parent` parameter
   * (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateEntryGroupRequest request =
   *       CreateEntryGroupRequest.newBuilder()
   *           .setParent(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setEntryGroupId("entryGroupId1228924712")
   *           .setEntryGroup(EntryGroup.newBuilder().build())
   *           .build();
   *   EntryGroup response = dataCatalogClient.createEntryGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryGroup createEntryGroup(CreateEntryGroupRequest request) {
    return createEntryGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * A maximum of 10,000 entry groups may be created per organization across all locations.
   *
   * <p>Users should enable the Data Catalog API in the project identified by the `parent` parameter
   * (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateEntryGroupRequest request =
   *       CreateEntryGroupRequest.newBuilder()
   *           .setParent(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setEntryGroupId("entryGroupId1228924712")
   *           .setEntryGroup(EntryGroup.newBuilder().build())
   *           .build();
   *   ApiFuture<EntryGroup> future =
   *       dataCatalogClient.createEntryGroupCallable().futureCall(request);
   *   // Do something.
   *   EntryGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEntryGroupRequest, EntryGroup> createEntryGroupCallable() {
    return stub.createEntryGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an EntryGroup. The user should enable the Data Catalog API in the project identified by
   * the `entry_group.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryGroup entryGroup = EntryGroup.newBuilder().build();
   *   EntryGroup response = dataCatalogClient.updateEntryGroup(entryGroup);
   * }
   * }</pre>
   *
   * @param entryGroup Required. The updated entry group. "name" field must be set.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryGroup updateEntryGroup(EntryGroup entryGroup) {
    UpdateEntryGroupRequest request =
        UpdateEntryGroupRequest.newBuilder().setEntryGroup(entryGroup).build();
    return updateEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an EntryGroup. The user should enable the Data Catalog API in the project identified by
   * the `entry_group.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryGroup entryGroup = EntryGroup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   EntryGroup response = dataCatalogClient.updateEntryGroup(entryGroup, updateMask);
   * }
   * }</pre>
   *
   * @param entryGroup Required. The updated entry group. "name" field must be set.
   * @param updateMask The fields to update on the entry group. If absent or empty, all modifiable
   *     fields are updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryGroup updateEntryGroup(EntryGroup entryGroup, FieldMask updateMask) {
    UpdateEntryGroupRequest request =
        UpdateEntryGroupRequest.newBuilder()
            .setEntryGroup(entryGroup)
            .setUpdateMask(updateMask)
            .build();
    return updateEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an EntryGroup. The user should enable the Data Catalog API in the project identified by
   * the `entry_group.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   UpdateEntryGroupRequest request =
   *       UpdateEntryGroupRequest.newBuilder()
   *           .setEntryGroup(EntryGroup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   EntryGroup response = dataCatalogClient.updateEntryGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryGroup updateEntryGroup(UpdateEntryGroupRequest request) {
    return updateEntryGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an EntryGroup. The user should enable the Data Catalog API in the project identified by
   * the `entry_group.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   UpdateEntryGroupRequest request =
   *       UpdateEntryGroupRequest.newBuilder()
   *           .setEntryGroup(EntryGroup.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<EntryGroup> future =
   *       dataCatalogClient.updateEntryGroupCallable().futureCall(request);
   *   // Do something.
   *   EntryGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEntryGroupRequest, EntryGroup> updateEntryGroupCallable() {
    return stub.updateEntryGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an EntryGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   EntryGroup response = dataCatalogClient.getEntryGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry group. For example,
   *     `projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryGroup getEntryGroup(EntryGroupName name) {
    GetEntryGroupRequest request =
        GetEntryGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an EntryGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString();
   *   EntryGroup response = dataCatalogClient.getEntryGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry group. For example,
   *     `projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryGroup getEntryGroup(String name) {
    GetEntryGroupRequest request = GetEntryGroupRequest.newBuilder().setName(name).build();
    return getEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an EntryGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   FieldMask readMask = FieldMask.newBuilder().build();
   *   EntryGroup response = dataCatalogClient.getEntryGroup(name, readMask);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry group. For example,
   *     `projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}`.
   * @param readMask The fields to return. If not set or empty, all fields are returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryGroup getEntryGroup(EntryGroupName name, FieldMask readMask) {
    GetEntryGroupRequest request =
        GetEntryGroupRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setReadMask(readMask)
            .build();
    return getEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an EntryGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString();
   *   FieldMask readMask = FieldMask.newBuilder().build();
   *   EntryGroup response = dataCatalogClient.getEntryGroup(name, readMask);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry group. For example,
   *     `projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}`.
   * @param readMask The fields to return. If not set or empty, all fields are returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryGroup getEntryGroup(String name, FieldMask readMask) {
    GetEntryGroupRequest request =
        GetEntryGroupRequest.newBuilder().setName(name).setReadMask(readMask).build();
    return getEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an EntryGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   GetEntryGroupRequest request =
   *       GetEntryGroupRequest.newBuilder()
   *           .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   EntryGroup response = dataCatalogClient.getEntryGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryGroup getEntryGroup(GetEntryGroupRequest request) {
    return getEntryGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an EntryGroup.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   GetEntryGroupRequest request =
   *       GetEntryGroupRequest.newBuilder()
   *           .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<EntryGroup> future = dataCatalogClient.getEntryGroupCallable().futureCall(request);
   *   // Do something.
   *   EntryGroup response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEntryGroupRequest, EntryGroup> getEntryGroupCallable() {
    return stub.getEntryGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an EntryGroup. Only entry groups that do not contain entries can be deleted. Users
   * should enable the Data Catalog API in the project identified by the `name` parameter (see [Data
   * Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   dataCatalogClient.deleteEntryGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry group. For example,
   *     `projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEntryGroup(EntryGroupName name) {
    DeleteEntryGroupRequest request =
        DeleteEntryGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an EntryGroup. Only entry groups that do not contain entries can be deleted. Users
   * should enable the Data Catalog API in the project identified by the `name` parameter (see [Data
   * Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString();
   *   dataCatalogClient.deleteEntryGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry group. For example,
   *     `projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEntryGroup(String name) {
    DeleteEntryGroupRequest request = DeleteEntryGroupRequest.newBuilder().setName(name).build();
    deleteEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an EntryGroup. Only entry groups that do not contain entries can be deleted. Users
   * should enable the Data Catalog API in the project identified by the `name` parameter (see [Data
   * Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   DeleteEntryGroupRequest request =
   *       DeleteEntryGroupRequest.newBuilder()
   *           .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setForce(true)
   *           .build();
   *   dataCatalogClient.deleteEntryGroup(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEntryGroup(DeleteEntryGroupRequest request) {
    deleteEntryGroupCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an EntryGroup. Only entry groups that do not contain entries can be deleted. Users
   * should enable the Data Catalog API in the project identified by the `name` parameter (see [Data
   * Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   DeleteEntryGroupRequest request =
   *       DeleteEntryGroupRequest.newBuilder()
   *           .setName(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future = dataCatalogClient.deleteEntryGroupCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEntryGroupRequest, Empty> deleteEntryGroupCallable() {
    return stub.deleteEntryGroupCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryGroupName parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   for (EntryGroup element : dataCatalogClient.listEntryGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the location that contains the entry groups, which can be
   *     provided in URL format. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntryGroupsPagedResponse listEntryGroups(EntryGroupName parent) {
    ListEntryGroupsRequest request =
        ListEntryGroupsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEntryGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString();
   *   for (EntryGroup element : dataCatalogClient.listEntryGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the location that contains the entry groups, which can be
   *     provided in URL format. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntryGroupsPagedResponse listEntryGroups(String parent) {
    ListEntryGroupsRequest request = ListEntryGroupsRequest.newBuilder().setParent(parent).build();
    return listEntryGroups(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ListEntryGroupsRequest request =
   *       ListEntryGroupsRequest.newBuilder()
   *           .setParent(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (EntryGroup element : dataCatalogClient.listEntryGroups(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntryGroupsPagedResponse listEntryGroups(ListEntryGroupsRequest request) {
    return listEntryGroupsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ListEntryGroupsRequest request =
   *       ListEntryGroupsRequest.newBuilder()
   *           .setParent(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<EntryGroup> future =
   *       dataCatalogClient.listEntryGroupsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (EntryGroup element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsPagedResponse>
      listEntryGroupsPagedCallable() {
    return stub.listEntryGroupsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   while (true) {
   *     ListEntryGroupsResponse response =
   *         dataCatalogClient.listEntryGroupsCallable().call(request);
   *     for (EntryGroup element : response.getResponsesList()) {
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
  public final UnaryCallable<ListEntryGroupsRequest, ListEntryGroupsResponse>
      listEntryGroupsCallable() {
    return stub.listEntryGroupsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an entry. Only entries of 'FILESET' type or user-specified type can be created.
   *
   * <p>Users should enable the Data Catalog API in the project identified by the `parent` parameter
   * (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>A maximum of 100,000 entries may be created per entry group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryGroupName parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   String entryId = "entryId-1591558867";
   *   Entry entry = Entry.newBuilder().build();
   *   Entry response = dataCatalogClient.createEntry(parent, entryId, entry);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the entry group this entry is in. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}
   *     </ul>
   *     <p>Note that this Entry and its child resources may not actually be stored in the location
   *     in this name.
   * @param entryId Required. The id of the entry to create.
   * @param entry Required. The entry to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry createEntry(EntryGroupName parent, String entryId, Entry entry) {
    CreateEntryRequest request =
        CreateEntryRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setEntryId(entryId)
            .setEntry(entry)
            .build();
    return createEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an entry. Only entries of 'FILESET' type or user-specified type can be created.
   *
   * <p>Users should enable the Data Catalog API in the project identified by the `parent` parameter
   * (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>A maximum of 100,000 entries may be created per entry group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString();
   *   String entryId = "entryId-1591558867";
   *   Entry entry = Entry.newBuilder().build();
   *   Entry response = dataCatalogClient.createEntry(parent, entryId, entry);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the entry group this entry is in. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}
   *     </ul>
   *     <p>Note that this Entry and its child resources may not actually be stored in the location
   *     in this name.
   * @param entryId Required. The id of the entry to create.
   * @param entry Required. The entry to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry createEntry(String parent, String entryId, Entry entry) {
    CreateEntryRequest request =
        CreateEntryRequest.newBuilder()
            .setParent(parent)
            .setEntryId(entryId)
            .setEntry(entry)
            .build();
    return createEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an entry. Only entries of 'FILESET' type or user-specified type can be created.
   *
   * <p>Users should enable the Data Catalog API in the project identified by the `parent` parameter
   * (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>A maximum of 100,000 entries may be created per entry group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateEntryRequest request =
   *       CreateEntryRequest.newBuilder()
   *           .setParent(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setEntryId("entryId-1591558867")
   *           .setEntry(Entry.newBuilder().build())
   *           .build();
   *   Entry response = dataCatalogClient.createEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry createEntry(CreateEntryRequest request) {
    return createEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates an entry. Only entries of 'FILESET' type or user-specified type can be created.
   *
   * <p>Users should enable the Data Catalog API in the project identified by the `parent` parameter
   * (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>A maximum of 100,000 entries may be created per entry group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateEntryRequest request =
   *       CreateEntryRequest.newBuilder()
   *           .setParent(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setEntryId("entryId-1591558867")
   *           .setEntry(Entry.newBuilder().build())
   *           .build();
   *   ApiFuture<Entry> future = dataCatalogClient.createEntryCallable().futureCall(request);
   *   // Do something.
   *   Entry response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateEntryRequest, Entry> createEntryCallable() {
    return stub.createEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing entry. Users should enable the Data Catalog API in the project identified
   * by the `entry.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   Entry entry = Entry.newBuilder().build();
   *   Entry response = dataCatalogClient.updateEntry(entry);
   * }
   * }</pre>
   *
   * @param entry Required. The updated entry. The "name" field must be set.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry updateEntry(Entry entry) {
    UpdateEntryRequest request = UpdateEntryRequest.newBuilder().setEntry(entry).build();
    return updateEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing entry. Users should enable the Data Catalog API in the project identified
   * by the `entry.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   Entry entry = Entry.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Entry response = dataCatalogClient.updateEntry(entry, updateMask);
   * }
   * }</pre>
   *
   * @param entry Required. The updated entry. The "name" field must be set.
   * @param updateMask The fields to update on the entry. If absent or empty, all modifiable fields
   *     are updated.
   *     <p>The following fields are modifiable:
   *     <ul>
   *       <li>For entries with type `DATA_STREAM`: &#42; `schema`
   *       <li>For entries with type `FILESET` &#42; `schema` &#42; `display_name` &#42;
   *           `description` &#42; `gcs_fileset_spec` &#42; `gcs_fileset_spec.file_patterns`
   *       <li>For entries with `user_specified_type` &#42; `schema` &#42; `display_name` &#42;
   *           `description` &#42; user_specified_type &#42; user_specified_system &#42;
   *           linked_resource &#42; source_system_timestamps
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry updateEntry(Entry entry, FieldMask updateMask) {
    UpdateEntryRequest request =
        UpdateEntryRequest.newBuilder().setEntry(entry).setUpdateMask(updateMask).build();
    return updateEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing entry. Users should enable the Data Catalog API in the project identified
   * by the `entry.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   UpdateEntryRequest request =
   *       UpdateEntryRequest.newBuilder()
   *           .setEntry(Entry.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Entry response = dataCatalogClient.updateEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry updateEntry(UpdateEntryRequest request) {
    return updateEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing entry. Users should enable the Data Catalog API in the project identified
   * by the `entry.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   UpdateEntryRequest request =
   *       UpdateEntryRequest.newBuilder()
   *           .setEntry(Entry.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Entry> future = dataCatalogClient.updateEntryCallable().futureCall(request);
   *   // Do something.
   *   Entry response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateEntryRequest, Entry> updateEntryCallable() {
    return stub.updateEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing entry. Only entries created through
   * [CreateEntry][google.cloud.datacatalog.v1beta1.DataCatalog.CreateEntry] method can be deleted.
   * Users should enable the Data Catalog API in the project identified by the `name` parameter (see
   * [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   dataCatalogClient.deleteEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEntry(EntryName name) {
    DeleteEntryRequest request =
        DeleteEntryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing entry. Only entries created through
   * [CreateEntry][google.cloud.datacatalog.v1beta1.DataCatalog.CreateEntry] method can be deleted.
   * Users should enable the Data Catalog API in the project identified by the `name` parameter (see
   * [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString();
   *   dataCatalogClient.deleteEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEntry(String name) {
    DeleteEntryRequest request = DeleteEntryRequest.newBuilder().setName(name).build();
    deleteEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing entry. Only entries created through
   * [CreateEntry][google.cloud.datacatalog.v1beta1.DataCatalog.CreateEntry] method can be deleted.
   * Users should enable the Data Catalog API in the project identified by the `name` parameter (see
   * [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   DeleteEntryRequest request =
   *       DeleteEntryRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .build();
   *   dataCatalogClient.deleteEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEntry(DeleteEntryRequest request) {
    deleteEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing entry. Only entries created through
   * [CreateEntry][google.cloud.datacatalog.v1beta1.DataCatalog.CreateEntry] method can be deleted.
   * Users should enable the Data Catalog API in the project identified by the `name` parameter (see
   * [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   DeleteEntryRequest request =
   *       DeleteEntryRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .build();
   *   ApiFuture<Empty> future = dataCatalogClient.deleteEntryCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteEntryRequest, Empty> deleteEntryCallable() {
    return stub.deleteEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   Entry response = dataCatalogClient.getEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry getEntry(EntryName name) {
    GetEntryRequest request =
        GetEntryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString();
   *   Entry response = dataCatalogClient.getEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry getEntry(String name) {
    GetEntryRequest request = GetEntryRequest.newBuilder().setName(name).build();
    return getEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   GetEntryRequest request =
   *       GetEntryRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .build();
   *   Entry response = dataCatalogClient.getEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry getEntry(GetEntryRequest request) {
    return getEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   GetEntryRequest request =
   *       GetEntryRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .build();
   *   ApiFuture<Entry> future = dataCatalogClient.getEntryCallable().futureCall(request);
   *   // Do something.
   *   Entry response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetEntryRequest, Entry> getEntryCallable() {
    return stub.getEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an entry by target resource name. This method allows clients to use the resource name from
   * the source Google Cloud Platform service to get the Data Catalog Entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   LookupEntryRequest request = LookupEntryRequest.newBuilder().build();
   *   Entry response = dataCatalogClient.lookupEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry lookupEntry(LookupEntryRequest request) {
    return lookupEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get an entry by target resource name. This method allows clients to use the resource name from
   * the source Google Cloud Platform service to get the Data Catalog Entry.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   LookupEntryRequest request = LookupEntryRequest.newBuilder().build();
   *   ApiFuture<Entry> future = dataCatalogClient.lookupEntryCallable().futureCall(request);
   *   // Do something.
   *   Entry response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<LookupEntryRequest, Entry> lookupEntryCallable() {
    return stub.lookupEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryGroupName parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   for (Entry element : dataCatalogClient.listEntries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the entry group that contains the entries, which can be
   *     provided in URL format. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntriesPagedResponse listEntries(EntryGroupName parent) {
    ListEntriesRequest request =
        ListEntriesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listEntries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString();
   *   for (Entry element : dataCatalogClient.listEntries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the entry group that contains the entries, which can be
   *     provided in URL format. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntriesPagedResponse listEntries(String parent) {
    ListEntriesRequest request = ListEntriesRequest.newBuilder().setParent(parent).build();
    return listEntries(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ListEntriesRequest request =
   *       ListEntriesRequest.newBuilder()
   *           .setParent(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   for (Entry element : dataCatalogClient.listEntries(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntriesPagedResponse listEntries(ListEntriesRequest request) {
    return listEntriesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ListEntriesRequest request =
   *       ListEntriesRequest.newBuilder()
   *           .setParent(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Entry> future = dataCatalogClient.listEntriesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Entry element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListEntriesRequest, ListEntriesPagedResponse>
      listEntriesPagedCallable() {
    return stub.listEntriesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists entries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   while (true) {
   *     ListEntriesResponse response = dataCatalogClient.listEntriesCallable().call(request);
   *     for (Entry element : response.getResponsesList()) {
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
  public final UnaryCallable<ListEntriesRequest, ListEntriesResponse> listEntriesCallable() {
    return stub.listEntriesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tag template. The user should enable the Data Catalog API in the project identified
   * by the `parent` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String tagTemplateId = "tagTemplateId-1438776721";
   *   TagTemplate tagTemplate = TagTemplate.newBuilder().build();
   *   TagTemplate response =
   *       dataCatalogClient.createTagTemplate(parent, tagTemplateId, tagTemplate);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project and the template location
   *     [region](https://cloud.google.com/data-catalog/docs/concepts/regions.
   *     <p>Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/us-central1
   *     </ul>
   *
   * @param tagTemplateId Required. The id of the tag template to create.
   * @param tagTemplate Required. The tag template to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplate createTagTemplate(
      LocationName parent, String tagTemplateId, TagTemplate tagTemplate) {
    CreateTagTemplateRequest request =
        CreateTagTemplateRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTagTemplateId(tagTemplateId)
            .setTagTemplate(tagTemplate)
            .build();
    return createTagTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tag template. The user should enable the Data Catalog API in the project identified
   * by the `parent` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String parent = TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString();
   *   String tagTemplateId = "tagTemplateId-1438776721";
   *   TagTemplate tagTemplate = TagTemplate.newBuilder().build();
   *   TagTemplate response =
   *       dataCatalogClient.createTagTemplate(parent, tagTemplateId, tagTemplate);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project and the template location
   *     [region](https://cloud.google.com/data-catalog/docs/concepts/regions.
   *     <p>Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/us-central1
   *     </ul>
   *
   * @param tagTemplateId Required. The id of the tag template to create.
   * @param tagTemplate Required. The tag template to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplate createTagTemplate(
      String parent, String tagTemplateId, TagTemplate tagTemplate) {
    CreateTagTemplateRequest request =
        CreateTagTemplateRequest.newBuilder()
            .setParent(parent)
            .setTagTemplateId(tagTemplateId)
            .setTagTemplate(tagTemplate)
            .build();
    return createTagTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tag template. The user should enable the Data Catalog API in the project identified
   * by the `parent` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateTagTemplateRequest request =
   *       CreateTagTemplateRequest.newBuilder()
   *           .setParent(TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString())
   *           .setTagTemplateId("tagTemplateId-1438776721")
   *           .setTagTemplate(TagTemplate.newBuilder().build())
   *           .build();
   *   TagTemplate response = dataCatalogClient.createTagTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplate createTagTemplate(CreateTagTemplateRequest request) {
    return createTagTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tag template. The user should enable the Data Catalog API in the project identified
   * by the `parent` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateTagTemplateRequest request =
   *       CreateTagTemplateRequest.newBuilder()
   *           .setParent(TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString())
   *           .setTagTemplateId("tagTemplateId-1438776721")
   *           .setTagTemplate(TagTemplate.newBuilder().build())
   *           .build();
   *   ApiFuture<TagTemplate> future =
   *       dataCatalogClient.createTagTemplateCallable().futureCall(request);
   *   // Do something.
   *   TagTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTagTemplateRequest, TagTemplate> createTagTemplateCallable() {
    return stub.createTagTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a tag template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplateName name = TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   TagTemplate response = dataCatalogClient.getTagTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplate getTagTemplate(TagTemplateName name) {
    GetTagTemplateRequest request =
        GetTagTemplateRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTagTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a tag template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString();
   *   TagTemplate response = dataCatalogClient.getTagTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplate getTagTemplate(String name) {
    GetTagTemplateRequest request = GetTagTemplateRequest.newBuilder().setName(name).build();
    return getTagTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a tag template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   GetTagTemplateRequest request =
   *       GetTagTemplateRequest.newBuilder()
   *           .setName(TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString())
   *           .build();
   *   TagTemplate response = dataCatalogClient.getTagTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplate getTagTemplate(GetTagTemplateRequest request) {
    return getTagTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a tag template.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   GetTagTemplateRequest request =
   *       GetTagTemplateRequest.newBuilder()
   *           .setName(TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString())
   *           .build();
   *   ApiFuture<TagTemplate> future =
   *       dataCatalogClient.getTagTemplateCallable().futureCall(request);
   *   // Do something.
   *   TagTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTagTemplateRequest, TagTemplate> getTagTemplateCallable() {
    return stub.getTagTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a tag template. This method cannot be used to update the fields of a template. The tag
   * template fields are represented as separate resources and should be updated using their own
   * create/update/delete methods. Users should enable the Data Catalog API in the project
   * identified by the `tag_template.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplate tagTemplate = TagTemplate.newBuilder().build();
   *   TagTemplate response = dataCatalogClient.updateTagTemplate(tagTemplate);
   * }
   * }</pre>
   *
   * @param tagTemplate Required. The template to update. The "name" field must be set.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplate updateTagTemplate(TagTemplate tagTemplate) {
    UpdateTagTemplateRequest request =
        UpdateTagTemplateRequest.newBuilder().setTagTemplate(tagTemplate).build();
    return updateTagTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a tag template. This method cannot be used to update the fields of a template. The tag
   * template fields are represented as separate resources and should be updated using their own
   * create/update/delete methods. Users should enable the Data Catalog API in the project
   * identified by the `tag_template.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplate tagTemplate = TagTemplate.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TagTemplate response = dataCatalogClient.updateTagTemplate(tagTemplate, updateMask);
   * }
   * }</pre>
   *
   * @param tagTemplate Required. The template to update. The "name" field must be set.
   * @param updateMask The field mask specifies the parts of the template to overwrite.
   *     <p>Allowed fields:
   *     <p>&#42; `display_name`
   *     <p>If absent or empty, all of the allowed fields above will be updated.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplate updateTagTemplate(TagTemplate tagTemplate, FieldMask updateMask) {
    UpdateTagTemplateRequest request =
        UpdateTagTemplateRequest.newBuilder()
            .setTagTemplate(tagTemplate)
            .setUpdateMask(updateMask)
            .build();
    return updateTagTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a tag template. This method cannot be used to update the fields of a template. The tag
   * template fields are represented as separate resources and should be updated using their own
   * create/update/delete methods. Users should enable the Data Catalog API in the project
   * identified by the `tag_template.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   UpdateTagTemplateRequest request =
   *       UpdateTagTemplateRequest.newBuilder()
   *           .setTagTemplate(TagTemplate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   TagTemplate response = dataCatalogClient.updateTagTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplate updateTagTemplate(UpdateTagTemplateRequest request) {
    return updateTagTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a tag template. This method cannot be used to update the fields of a template. The tag
   * template fields are represented as separate resources and should be updated using their own
   * create/update/delete methods. Users should enable the Data Catalog API in the project
   * identified by the `tag_template.name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   UpdateTagTemplateRequest request =
   *       UpdateTagTemplateRequest.newBuilder()
   *           .setTagTemplate(TagTemplate.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<TagTemplate> future =
   *       dataCatalogClient.updateTagTemplateCallable().futureCall(request);
   *   // Do something.
   *   TagTemplate response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTagTemplateRequest, TagTemplate> updateTagTemplateCallable() {
    return stub.updateTagTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tag template and all tags using the template. Users should enable the Data Catalog
   * API in the project identified by the `name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplateName name = TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   boolean force = true;
   *   dataCatalogClient.deleteTagTemplate(name, force);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template to delete. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}
   *     </ul>
   *
   * @param force Required. Currently, this field must always be set to `true`. This confirms the
   *     deletion of any possible tags using this template. `force = false` will be supported in the
   *     future.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTagTemplate(TagTemplateName name, boolean force) {
    DeleteTagTemplateRequest request =
        DeleteTagTemplateRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setForce(force)
            .build();
    deleteTagTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tag template and all tags using the template. Users should enable the Data Catalog
   * API in the project identified by the `name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString();
   *   boolean force = true;
   *   dataCatalogClient.deleteTagTemplate(name, force);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template to delete. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}
   *     </ul>
   *
   * @param force Required. Currently, this field must always be set to `true`. This confirms the
   *     deletion of any possible tags using this template. `force = false` will be supported in the
   *     future.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTagTemplate(String name, boolean force) {
    DeleteTagTemplateRequest request =
        DeleteTagTemplateRequest.newBuilder().setName(name).setForce(force).build();
    deleteTagTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tag template and all tags using the template. Users should enable the Data Catalog
   * API in the project identified by the `name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   DeleteTagTemplateRequest request =
   *       DeleteTagTemplateRequest.newBuilder()
   *           .setName(TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString())
   *           .setForce(true)
   *           .build();
   *   dataCatalogClient.deleteTagTemplate(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTagTemplate(DeleteTagTemplateRequest request) {
    deleteTagTemplateCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tag template and all tags using the template. Users should enable the Data Catalog
   * API in the project identified by the `name` parameter (see [Data Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   DeleteTagTemplateRequest request =
   *       DeleteTagTemplateRequest.newBuilder()
   *           .setName(TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future = dataCatalogClient.deleteTagTemplateCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTagTemplateRequest, Empty> deleteTagTemplateCallable() {
    return stub.deleteTagTemplateCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a field in a tag template. The user should enable the Data Catalog API in the project
   * identified by the `parent` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplateName parent = TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   String tagTemplateFieldId = "tagTemplateFieldId-1556835615";
   *   TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
   *   TagTemplateField response =
   *       dataCatalogClient.createTagTemplateField(parent, tagTemplateFieldId, tagTemplateField);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project and the template location
   *     [region](https://cloud.google.com/data-catalog/docs/concepts/regions).
   *     <p>Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/us-central1/tagTemplates/{tag_template_id}
   *     </ul>
   *
   * @param tagTemplateFieldId Required. The ID of the tag template field to create. Field ids can
   *     contain letters (both uppercase and lowercase), numbers (0-9), underscores (_) and dashes
   *     (-). Field IDs must be at least 1 character long and at most 128 characters long. Field IDs
   *     must also be unique within their template.
   * @param tagTemplateField Required. The tag template field to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplateField createTagTemplateField(
      TagTemplateName parent, String tagTemplateFieldId, TagTemplateField tagTemplateField) {
    CreateTagTemplateFieldRequest request =
        CreateTagTemplateFieldRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTagTemplateFieldId(tagTemplateFieldId)
            .setTagTemplateField(tagTemplateField)
            .build();
    return createTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a field in a tag template. The user should enable the Data Catalog API in the project
   * identified by the `parent` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String parent = TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString();
   *   String tagTemplateFieldId = "tagTemplateFieldId-1556835615";
   *   TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
   *   TagTemplateField response =
   *       dataCatalogClient.createTagTemplateField(parent, tagTemplateFieldId, tagTemplateField);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project and the template location
   *     [region](https://cloud.google.com/data-catalog/docs/concepts/regions).
   *     <p>Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/us-central1/tagTemplates/{tag_template_id}
   *     </ul>
   *
   * @param tagTemplateFieldId Required. The ID of the tag template field to create. Field ids can
   *     contain letters (both uppercase and lowercase), numbers (0-9), underscores (_) and dashes
   *     (-). Field IDs must be at least 1 character long and at most 128 characters long. Field IDs
   *     must also be unique within their template.
   * @param tagTemplateField Required. The tag template field to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplateField createTagTemplateField(
      String parent, String tagTemplateFieldId, TagTemplateField tagTemplateField) {
    CreateTagTemplateFieldRequest request =
        CreateTagTemplateFieldRequest.newBuilder()
            .setParent(parent)
            .setTagTemplateFieldId(tagTemplateFieldId)
            .setTagTemplateField(tagTemplateField)
            .build();
    return createTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a field in a tag template. The user should enable the Data Catalog API in the project
   * identified by the `parent` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateTagTemplateFieldRequest request =
   *       CreateTagTemplateFieldRequest.newBuilder()
   *           .setParent(TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString())
   *           .setTagTemplateFieldId("tagTemplateFieldId-1556835615")
   *           .setTagTemplateField(TagTemplateField.newBuilder().build())
   *           .build();
   *   TagTemplateField response = dataCatalogClient.createTagTemplateField(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplateField createTagTemplateField(CreateTagTemplateFieldRequest request) {
    return createTagTemplateFieldCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a field in a tag template. The user should enable the Data Catalog API in the project
   * identified by the `parent` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateTagTemplateFieldRequest request =
   *       CreateTagTemplateFieldRequest.newBuilder()
   *           .setParent(TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString())
   *           .setTagTemplateFieldId("tagTemplateFieldId-1556835615")
   *           .setTagTemplateField(TagTemplateField.newBuilder().build())
   *           .build();
   *   ApiFuture<TagTemplateField> future =
   *       dataCatalogClient.createTagTemplateFieldCallable().futureCall(request);
   *   // Do something.
   *   TagTemplateField response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTagTemplateFieldRequest, TagTemplateField>
      createTagTemplateFieldCallable() {
    return stub.createTagTemplateFieldCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a field in a tag template. This method cannot be used to update the field type. Users
   * should enable the Data Catalog API in the project identified by the `name` parameter (see [Data
   * Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplateFieldName name =
   *       TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
   *   TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
   *   TagTemplateField response = dataCatalogClient.updateTagTemplateField(name, tagTemplateField);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template field. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}/fields/{tag_template_field_id}
   *     </ul>
   *
   * @param tagTemplateField Required. The template to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplateField updateTagTemplateField(
      TagTemplateFieldName name, TagTemplateField tagTemplateField) {
    UpdateTagTemplateFieldRequest request =
        UpdateTagTemplateFieldRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setTagTemplateField(tagTemplateField)
            .build();
    return updateTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a field in a tag template. This method cannot be used to update the field type. Users
   * should enable the Data Catalog API in the project identified by the `name` parameter (see [Data
   * Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name =
   *       TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
   *           .toString();
   *   TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
   *   TagTemplateField response = dataCatalogClient.updateTagTemplateField(name, tagTemplateField);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template field. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}/fields/{tag_template_field_id}
   *     </ul>
   *
   * @param tagTemplateField Required. The template to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplateField updateTagTemplateField(
      String name, TagTemplateField tagTemplateField) {
    UpdateTagTemplateFieldRequest request =
        UpdateTagTemplateFieldRequest.newBuilder()
            .setName(name)
            .setTagTemplateField(tagTemplateField)
            .build();
    return updateTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a field in a tag template. This method cannot be used to update the field type. Users
   * should enable the Data Catalog API in the project identified by the `name` parameter (see [Data
   * Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplateFieldName name =
   *       TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
   *   TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TagTemplateField response =
   *       dataCatalogClient.updateTagTemplateField(name, tagTemplateField, updateMask);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template field. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}/fields/{tag_template_field_id}
   *     </ul>
   *
   * @param tagTemplateField Required. The template to update.
   * @param updateMask Optional. The field mask specifies the parts of the template to be updated.
   *     Allowed fields:
   *     <p>&#42; `display_name` &#42; `type.enum_type` &#42; `is_required`
   *     <p>If `update_mask` is not set or empty, all of the allowed fields above will be updated.
   *     <p>When updating an enum type, the provided values will be merged with the existing values.
   *     Therefore, enum values can only be added, existing enum values cannot be deleted nor
   *     renamed. Updating a template field from optional to required is NOT allowed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplateField updateTagTemplateField(
      TagTemplateFieldName name, TagTemplateField tagTemplateField, FieldMask updateMask) {
    UpdateTagTemplateFieldRequest request =
        UpdateTagTemplateFieldRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setTagTemplateField(tagTemplateField)
            .setUpdateMask(updateMask)
            .build();
    return updateTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a field in a tag template. This method cannot be used to update the field type. Users
   * should enable the Data Catalog API in the project identified by the `name` parameter (see [Data
   * Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name =
   *       TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
   *           .toString();
   *   TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TagTemplateField response =
   *       dataCatalogClient.updateTagTemplateField(name, tagTemplateField, updateMask);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template field. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}/fields/{tag_template_field_id}
   *     </ul>
   *
   * @param tagTemplateField Required. The template to update.
   * @param updateMask Optional. The field mask specifies the parts of the template to be updated.
   *     Allowed fields:
   *     <p>&#42; `display_name` &#42; `type.enum_type` &#42; `is_required`
   *     <p>If `update_mask` is not set or empty, all of the allowed fields above will be updated.
   *     <p>When updating an enum type, the provided values will be merged with the existing values.
   *     Therefore, enum values can only be added, existing enum values cannot be deleted nor
   *     renamed. Updating a template field from optional to required is NOT allowed.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplateField updateTagTemplateField(
      String name, TagTemplateField tagTemplateField, FieldMask updateMask) {
    UpdateTagTemplateFieldRequest request =
        UpdateTagTemplateFieldRequest.newBuilder()
            .setName(name)
            .setTagTemplateField(tagTemplateField)
            .setUpdateMask(updateMask)
            .build();
    return updateTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a field in a tag template. This method cannot be used to update the field type. Users
   * should enable the Data Catalog API in the project identified by the `name` parameter (see [Data
   * Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   UpdateTagTemplateFieldRequest request =
   *       UpdateTagTemplateFieldRequest.newBuilder()
   *           .setName(
   *               TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
   *                   .toString())
   *           .setTagTemplateField(TagTemplateField.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   TagTemplateField response = dataCatalogClient.updateTagTemplateField(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplateField updateTagTemplateField(UpdateTagTemplateFieldRequest request) {
    return updateTagTemplateFieldCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a field in a tag template. This method cannot be used to update the field type. Users
   * should enable the Data Catalog API in the project identified by the `name` parameter (see [Data
   * Catalog Resource Project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   UpdateTagTemplateFieldRequest request =
   *       UpdateTagTemplateFieldRequest.newBuilder()
   *           .setName(
   *               TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
   *                   .toString())
   *           .setTagTemplateField(TagTemplateField.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<TagTemplateField> future =
   *       dataCatalogClient.updateTagTemplateFieldCallable().futureCall(request);
   *   // Do something.
   *   TagTemplateField response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTagTemplateFieldRequest, TagTemplateField>
      updateTagTemplateFieldCallable() {
    return stub.updateTagTemplateFieldCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames a field in a tag template. The user should enable the Data Catalog API in the project
   * identified by the `name` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplateFieldName name =
   *       TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
   *   String newTagTemplateFieldId = "newTagTemplateFieldId2008993953";
   *   TagTemplateField response =
   *       dataCatalogClient.renameTagTemplateField(name, newTagTemplateFieldId);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}/fields/{tag_template_field_id}
   *     </ul>
   *
   * @param newTagTemplateFieldId Required. The new ID of this tag template field. For example,
   *     `my_new_field`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplateField renameTagTemplateField(
      TagTemplateFieldName name, String newTagTemplateFieldId) {
    RenameTagTemplateFieldRequest request =
        RenameTagTemplateFieldRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setNewTagTemplateFieldId(newTagTemplateFieldId)
            .build();
    return renameTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames a field in a tag template. The user should enable the Data Catalog API in the project
   * identified by the `name` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name =
   *       TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
   *           .toString();
   *   String newTagTemplateFieldId = "newTagTemplateFieldId2008993953";
   *   TagTemplateField response =
   *       dataCatalogClient.renameTagTemplateField(name, newTagTemplateFieldId);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}/fields/{tag_template_field_id}
   *     </ul>
   *
   * @param newTagTemplateFieldId Required. The new ID of this tag template field. For example,
   *     `my_new_field`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplateField renameTagTemplateField(String name, String newTagTemplateFieldId) {
    RenameTagTemplateFieldRequest request =
        RenameTagTemplateFieldRequest.newBuilder()
            .setName(name)
            .setNewTagTemplateFieldId(newTagTemplateFieldId)
            .build();
    return renameTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames a field in a tag template. The user should enable the Data Catalog API in the project
   * identified by the `name` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   RenameTagTemplateFieldRequest request =
   *       RenameTagTemplateFieldRequest.newBuilder()
   *           .setName(
   *               TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
   *                   .toString())
   *           .setNewTagTemplateFieldId("newTagTemplateFieldId2008993953")
   *           .build();
   *   TagTemplateField response = dataCatalogClient.renameTagTemplateField(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplateField renameTagTemplateField(RenameTagTemplateFieldRequest request) {
    return renameTagTemplateFieldCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames a field in a tag template. The user should enable the Data Catalog API in the project
   * identified by the `name` parameter (see [Data Catalog Resource
   * Project](https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   RenameTagTemplateFieldRequest request =
   *       RenameTagTemplateFieldRequest.newBuilder()
   *           .setName(
   *               TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
   *                   .toString())
   *           .setNewTagTemplateFieldId("newTagTemplateFieldId2008993953")
   *           .build();
   *   ApiFuture<TagTemplateField> future =
   *       dataCatalogClient.renameTagTemplateFieldCallable().futureCall(request);
   *   // Do something.
   *   TagTemplateField response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RenameTagTemplateFieldRequest, TagTemplateField>
      renameTagTemplateFieldCallable() {
    return stub.renameTagTemplateFieldCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a field in a tag template and all uses of that field. Users should enable the Data
   * Catalog API in the project identified by the `name` parameter (see [Data Catalog Resource
   * Project] (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplateFieldName name =
   *       TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
   *   boolean force = true;
   *   dataCatalogClient.deleteTagTemplateField(name, force);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template field to delete. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}/fields/{tag_template_field_id}
   *     </ul>
   *
   * @param force Required. Currently, this field must always be set to `true`. This confirms the
   *     deletion of this field from any tags using this field. `force = false` will be supported in
   *     the future.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTagTemplateField(TagTemplateFieldName name, boolean force) {
    DeleteTagTemplateFieldRequest request =
        DeleteTagTemplateFieldRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setForce(force)
            .build();
    deleteTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a field in a tag template and all uses of that field. Users should enable the Data
   * Catalog API in the project identified by the `name` parameter (see [Data Catalog Resource
   * Project] (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name =
   *       TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
   *           .toString();
   *   boolean force = true;
   *   dataCatalogClient.deleteTagTemplateField(name, force);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template field to delete. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/tagTemplates/{tag_template_id}/fields/{tag_template_field_id}
   *     </ul>
   *
   * @param force Required. Currently, this field must always be set to `true`. This confirms the
   *     deletion of this field from any tags using this field. `force = false` will be supported in
   *     the future.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTagTemplateField(String name, boolean force) {
    DeleteTagTemplateFieldRequest request =
        DeleteTagTemplateFieldRequest.newBuilder().setName(name).setForce(force).build();
    deleteTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a field in a tag template and all uses of that field. Users should enable the Data
   * Catalog API in the project identified by the `name` parameter (see [Data Catalog Resource
   * Project] (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   DeleteTagTemplateFieldRequest request =
   *       DeleteTagTemplateFieldRequest.newBuilder()
   *           .setName(
   *               TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   dataCatalogClient.deleteTagTemplateField(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTagTemplateField(DeleteTagTemplateFieldRequest request) {
    deleteTagTemplateFieldCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a field in a tag template and all uses of that field. Users should enable the Data
   * Catalog API in the project identified by the `name` parameter (see [Data Catalog Resource
   * Project] (https://cloud.google.com/data-catalog/docs/concepts/resource-project) for more
   * information).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   DeleteTagTemplateFieldRequest request =
   *       DeleteTagTemplateFieldRequest.newBuilder()
   *           .setName(
   *               TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future =
   *       dataCatalogClient.deleteTagTemplateFieldCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTagTemplateFieldRequest, Empty>
      deleteTagTemplateFieldCallable() {
    return stub.deleteTagTemplateFieldCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tag on an [Entry][google.cloud.datacatalog.v1beta1.Entry]. Note: The project
   * identified by the `parent` parameter for the
   * [tag](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.entryGroups.entries.tags/create#path-parameters)
   * and the [tag
   * template](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.tagTemplates/create#path-parameters)
   * used to create the tag must be from the same organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagName parent = TagName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]", "[TAG]");
   *   Tag tag = Tag.newBuilder().build();
   *   Tag response = dataCatalogClient.createTag(parent, tag);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the resource to attach this tag to. Tags can be attached to
   *     Entries. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}
   *     </ul>
   *     <p>Note that this Tag and its child resources may not actually be stored in the location in
   *     this name.
   * @param tag Required. The tag to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tag createTag(TagName parent, Tag tag) {
    CreateTagRequest request =
        CreateTagRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTag(tag)
            .build();
    return createTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tag on an [Entry][google.cloud.datacatalog.v1beta1.Entry]. Note: The project
   * identified by the `parent` parameter for the
   * [tag](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.entryGroups.entries.tags/create#path-parameters)
   * and the [tag
   * template](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.tagTemplates/create#path-parameters)
   * used to create the tag must be from the same organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String parent =
   *       TagName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]", "[TAG]").toString();
   *   Tag tag = Tag.newBuilder().build();
   *   Tag response = dataCatalogClient.createTag(parent, tag);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the resource to attach this tag to. Tags can be attached to
   *     Entries. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}
   *     </ul>
   *     <p>Note that this Tag and its child resources may not actually be stored in the location in
   *     this name.
   * @param tag Required. The tag to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tag createTag(String parent, Tag tag) {
    CreateTagRequest request = CreateTagRequest.newBuilder().setParent(parent).setTag(tag).build();
    return createTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tag on an [Entry][google.cloud.datacatalog.v1beta1.Entry]. Note: The project
   * identified by the `parent` parameter for the
   * [tag](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.entryGroups.entries.tags/create#path-parameters)
   * and the [tag
   * template](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.tagTemplates/create#path-parameters)
   * used to create the tag must be from the same organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateTagRequest request =
   *       CreateTagRequest.newBuilder()
   *           .setParent(
   *               TagName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]", "[TAG]")
   *                   .toString())
   *           .setTag(Tag.newBuilder().build())
   *           .build();
   *   Tag response = dataCatalogClient.createTag(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tag createTag(CreateTagRequest request) {
    return createTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tag on an [Entry][google.cloud.datacatalog.v1beta1.Entry]. Note: The project
   * identified by the `parent` parameter for the
   * [tag](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.entryGroups.entries.tags/create#path-parameters)
   * and the [tag
   * template](https://cloud.google.com/data-catalog/docs/reference/rest/v1beta1/projects.locations.tagTemplates/create#path-parameters)
   * used to create the tag must be from the same organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateTagRequest request =
   *       CreateTagRequest.newBuilder()
   *           .setParent(
   *               TagName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]", "[TAG]")
   *                   .toString())
   *           .setTag(Tag.newBuilder().build())
   *           .build();
   *   ApiFuture<Tag> future = dataCatalogClient.createTagCallable().futureCall(request);
   *   // Do something.
   *   Tag response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTagRequest, Tag> createTagCallable() {
    return stub.createTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   Tag tag = Tag.newBuilder().build();
   *   Tag response = dataCatalogClient.updateTag(tag);
   * }
   * }</pre>
   *
   * @param tag Required. The updated tag. The "name" field must be set.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tag updateTag(Tag tag) {
    UpdateTagRequest request = UpdateTagRequest.newBuilder().setTag(tag).build();
    return updateTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   Tag tag = Tag.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Tag response = dataCatalogClient.updateTag(tag, updateMask);
   * }
   * }</pre>
   *
   * @param tag Required. The updated tag. The "name" field must be set.
   * @param updateMask The fields to update on the Tag. If absent or empty, all modifiable fields
   *     are updated. Currently the only modifiable field is the field `fields`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tag updateTag(Tag tag, FieldMask updateMask) {
    UpdateTagRequest request =
        UpdateTagRequest.newBuilder().setTag(tag).setUpdateMask(updateMask).build();
    return updateTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   UpdateTagRequest request =
   *       UpdateTagRequest.newBuilder()
   *           .setTag(Tag.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Tag response = dataCatalogClient.updateTag(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tag updateTag(UpdateTagRequest request) {
    return updateTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   UpdateTagRequest request =
   *       UpdateTagRequest.newBuilder()
   *           .setTag(Tag.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Tag> future = dataCatalogClient.updateTagCallable().futureCall(request);
   *   // Do something.
   *   Tag response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTagRequest, Tag> updateTagCallable() {
    return stub.updateTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   dataCatalogClient.deleteTag(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag to delete. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}/tags/{tag_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTag(EntryName name) {
    DeleteTagRequest request =
        DeleteTagRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name =
   *       TagName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]", "[TAG]").toString();
   *   dataCatalogClient.deleteTag(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag to delete. Example:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}/tags/{tag_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTag(String name) {
    DeleteTagRequest request = DeleteTagRequest.newBuilder().setName(name).build();
    deleteTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   DeleteTagRequest request =
   *       DeleteTagRequest.newBuilder()
   *           .setName(
   *               TagName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]", "[TAG]")
   *                   .toString())
   *           .build();
   *   dataCatalogClient.deleteTag(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTag(DeleteTagRequest request) {
    deleteTagCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tag.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   DeleteTagRequest request =
   *       DeleteTagRequest.newBuilder()
   *           .setName(
   *               TagName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]", "[TAG]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future = dataCatalogClient.deleteTagCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTagRequest, Empty> deleteTagCallable() {
    return stub.deleteTagCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the tags on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryName parent = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   for (Tag element : dataCatalogClient.listTags(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the Data Catalog resource to list the tags of. The resource
   *     could be an [Entry][google.cloud.datacatalog.v1beta1.Entry] or an
   *     [EntryGroup][google.cloud.datacatalog.v1beta1.EntryGroup].
   *     <p>Examples:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTagsPagedResponse listTags(EntryName parent) {
    ListTagsRequest request =
        ListTagsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listTags(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the tags on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String parent =
   *       TagName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]", "[TAG]").toString();
   *   for (Tag element : dataCatalogClient.listTags(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the Data Catalog resource to list the tags of. The resource
   *     could be an [Entry][google.cloud.datacatalog.v1beta1.Entry] or an
   *     [EntryGroup][google.cloud.datacatalog.v1beta1.EntryGroup].
   *     <p>Examples:
   *     <ul>
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}
   *       <li>projects/{project_id}/locations/{location}/entryGroups/{entry_group_id}/entries/{entry_id}
   *     </ul>
   *
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTagsPagedResponse listTags(String parent) {
    ListTagsRequest request = ListTagsRequest.newBuilder().setParent(parent).build();
    return listTags(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the tags on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ListTagsRequest request =
   *       ListTagsRequest.newBuilder()
   *           .setParent(
   *               TagName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]", "[TAG]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Tag element : dataCatalogClient.listTags(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTagsPagedResponse listTags(ListTagsRequest request) {
    return listTagsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the tags on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ListTagsRequest request =
   *       ListTagsRequest.newBuilder()
   *           .setParent(
   *               TagName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]", "[TAG]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Tag> future = dataCatalogClient.listTagsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Tag element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTagsRequest, ListTagsPagedResponse> listTagsPagedCallable() {
    return stub.listTagsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the tags on an [Entry][google.cloud.datacatalog.v1beta1.Entry].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   while (true) {
   *     ListTagsResponse response = dataCatalogClient.listTagsCallable().call(request);
   *     for (Tag element : response.getResponsesList()) {
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
  public final UnaryCallable<ListTagsRequest, ListTagsResponse> listTagsCallable() {
    return stub.listTagsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets the access control policy for a resource. Replaces any existing policy. Supported
   * resources are: - Tag templates. - Entries. - Entry groups. Note, this method cannot be used to
   * manage policies for BigQuery, Pub/Sub and any external Google Cloud Platform resources synced
   * to Data Catalog.
   *
   * <p>Callers must have following Google IAM permission - `datacatalog.tagTemplates.setIamPolicy`
   * to set policies on tag templates. - `datacatalog.entries.setIamPolicy` to set policies on
   * entries. - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ResourceName resource = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = dataCatalogClient.setIamPolicy(resource, policy);
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
   * Sets the access control policy for a resource. Replaces any existing policy. Supported
   * resources are: - Tag templates. - Entries. - Entry groups. Note, this method cannot be used to
   * manage policies for BigQuery, Pub/Sub and any external Google Cloud Platform resources synced
   * to Data Catalog.
   *
   * <p>Callers must have following Google IAM permission - `datacatalog.tagTemplates.setIamPolicy`
   * to set policies on tag templates. - `datacatalog.entries.setIamPolicy` to set policies on
   * entries. - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String resource = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString();
   *   Policy policy = Policy.newBuilder().build();
   *   Policy response = dataCatalogClient.setIamPolicy(resource, policy);
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
   * Sets the access control policy for a resource. Replaces any existing policy. Supported
   * resources are: - Tag templates. - Entries. - Entry groups. Note, this method cannot be used to
   * manage policies for BigQuery, Pub/Sub and any external Google Cloud Platform resources synced
   * to Data Catalog.
   *
   * <p>Callers must have following Google IAM permission - `datacatalog.tagTemplates.setIamPolicy`
   * to set policies on tag templates. - `datacatalog.entries.setIamPolicy` to set policies on
   * entries. - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .build();
   *   Policy response = dataCatalogClient.setIamPolicy(request);
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
   * Sets the access control policy for a resource. Replaces any existing policy. Supported
   * resources are: - Tag templates. - Entries. - Entry groups. Note, this method cannot be used to
   * manage policies for BigQuery, Pub/Sub and any external Google Cloud Platform resources synced
   * to Data Catalog.
   *
   * <p>Callers must have following Google IAM permission - `datacatalog.tagTemplates.setIamPolicy`
   * to set policies on tag templates. - `datacatalog.entries.setIamPolicy` to set policies on
   * entries. - `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = dataCatalogClient.setIamPolicyCallable().futureCall(request);
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
   * Gets the access control policy for a resource. A `NOT_FOUND` error is returned if the resource
   * does not exist. An empty policy is returned if the resource exists but does not have a policy
   * set on it.
   *
   * <p>Supported resources are: - Tag templates. - Entries. - Entry groups. Note, this method
   * cannot be used to manage policies for BigQuery, Pub/Sub and any external Google Cloud Platform
   * resources synced to Data Catalog.
   *
   * <p>Callers must have following Google IAM permission - `datacatalog.tagTemplates.getIamPolicy`
   * to get policies on tag templates. - `datacatalog.entries.getIamPolicy` to get policies on
   * entries. - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ResourceName resource = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]");
   *   Policy response = dataCatalogClient.getIamPolicy(resource);
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
   * Gets the access control policy for a resource. A `NOT_FOUND` error is returned if the resource
   * does not exist. An empty policy is returned if the resource exists but does not have a policy
   * set on it.
   *
   * <p>Supported resources are: - Tag templates. - Entries. - Entry groups. Note, this method
   * cannot be used to manage policies for BigQuery, Pub/Sub and any external Google Cloud Platform
   * resources synced to Data Catalog.
   *
   * <p>Callers must have following Google IAM permission - `datacatalog.tagTemplates.getIamPolicy`
   * to get policies on tag templates. - `datacatalog.entries.getIamPolicy` to get policies on
   * entries. - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String resource = TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString();
   *   Policy response = dataCatalogClient.getIamPolicy(resource);
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
   * Gets the access control policy for a resource. A `NOT_FOUND` error is returned if the resource
   * does not exist. An empty policy is returned if the resource exists but does not have a policy
   * set on it.
   *
   * <p>Supported resources are: - Tag templates. - Entries. - Entry groups. Note, this method
   * cannot be used to manage policies for BigQuery, Pub/Sub and any external Google Cloud Platform
   * resources synced to Data Catalog.
   *
   * <p>Callers must have following Google IAM permission - `datacatalog.tagTemplates.getIamPolicy`
   * to get policies on tag templates. - `datacatalog.entries.getIamPolicy` to get policies on
   * entries. - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   Policy response = dataCatalogClient.getIamPolicy(request);
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
   * Gets the access control policy for a resource. A `NOT_FOUND` error is returned if the resource
   * does not exist. An empty policy is returned if the resource exists but does not have a policy
   * set on it.
   *
   * <p>Supported resources are: - Tag templates. - Entries. - Entry groups. Note, this method
   * cannot be used to manage policies for BigQuery, Pub/Sub and any external Google Cloud Platform
   * resources synced to Data Catalog.
   *
   * <p>Callers must have following Google IAM permission - `datacatalog.tagTemplates.getIamPolicy`
   * to get policies on tag templates. - `datacatalog.entries.getIamPolicy` to get policies on
   * entries. - `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
   *           .setOptions(GetPolicyOptions.newBuilder().build())
   *           .build();
   *   ApiFuture<Policy> future = dataCatalogClient.getIamPolicyCallable().futureCall(request);
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
   * Returns the caller's permissions on a resource. If the resource does not exist, an empty set of
   * permissions is returned (We don't return a `NOT_FOUND` error).
   *
   * <p>Supported resources are: - Tag templates. - Entries. - Entry groups. Note, this method
   * cannot be used to manage policies for BigQuery, Pub/Sub and any external Google Cloud Platform
   * resources synced to Data Catalog.
   *
   * <p>A caller is not required to have Google IAM permission to make this request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   TestIamPermissionsResponse response = dataCatalogClient.testIamPermissions(request);
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
   * Returns the caller's permissions on a resource. If the resource does not exist, an empty set of
   * permissions is returned (We don't return a `NOT_FOUND` error).
   *
   * <p>Supported resources are: - Tag templates. - Entries. - Entry groups. Note, this method
   * cannot be used to manage policies for BigQuery, Pub/Sub and any external Google Cloud Platform
   * resources synced to Data Catalog.
   *
   * <p>A caller is not required to have Google IAM permission to make this request.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(TaxonomyName.of("[PROJECT]", "[LOCATION]", "[TAXONOMY]").toString())
   *           .addAllPermissions(new ArrayList<String>())
   *           .build();
   *   ApiFuture<TestIamPermissionsResponse> future =
   *       dataCatalogClient.testIamPermissionsCallable().futureCall(request);
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

  public static class SearchCatalogPagedResponse
      extends AbstractPagedListResponse<
          SearchCatalogRequest,
          SearchCatalogResponse,
          SearchCatalogResult,
          SearchCatalogPage,
          SearchCatalogFixedSizeCollection> {

    public static ApiFuture<SearchCatalogPagedResponse> createAsync(
        PageContext<SearchCatalogRequest, SearchCatalogResponse, SearchCatalogResult> context,
        ApiFuture<SearchCatalogResponse> futureResponse) {
      ApiFuture<SearchCatalogPage> futurePage =
          SearchCatalogPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<SearchCatalogPage, SearchCatalogPagedResponse>() {
            @Override
            public SearchCatalogPagedResponse apply(SearchCatalogPage input) {
              return new SearchCatalogPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private SearchCatalogPagedResponse(SearchCatalogPage page) {
      super(page, SearchCatalogFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class SearchCatalogPage
      extends AbstractPage<
          SearchCatalogRequest, SearchCatalogResponse, SearchCatalogResult, SearchCatalogPage> {

    private SearchCatalogPage(
        PageContext<SearchCatalogRequest, SearchCatalogResponse, SearchCatalogResult> context,
        SearchCatalogResponse response) {
      super(context, response);
    }

    private static SearchCatalogPage createEmptyPage() {
      return new SearchCatalogPage(null, null);
    }

    @Override
    protected SearchCatalogPage createPage(
        PageContext<SearchCatalogRequest, SearchCatalogResponse, SearchCatalogResult> context,
        SearchCatalogResponse response) {
      return new SearchCatalogPage(context, response);
    }

    @Override
    public ApiFuture<SearchCatalogPage> createPageAsync(
        PageContext<SearchCatalogRequest, SearchCatalogResponse, SearchCatalogResult> context,
        ApiFuture<SearchCatalogResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class SearchCatalogFixedSizeCollection
      extends AbstractFixedSizeCollection<
          SearchCatalogRequest,
          SearchCatalogResponse,
          SearchCatalogResult,
          SearchCatalogPage,
          SearchCatalogFixedSizeCollection> {

    private SearchCatalogFixedSizeCollection(List<SearchCatalogPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static SearchCatalogFixedSizeCollection createEmptyCollection() {
      return new SearchCatalogFixedSizeCollection(null, 0);
    }

    @Override
    protected SearchCatalogFixedSizeCollection createCollection(
        List<SearchCatalogPage> pages, int collectionSize) {
      return new SearchCatalogFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEntryGroupsPagedResponse
      extends AbstractPagedListResponse<
          ListEntryGroupsRequest,
          ListEntryGroupsResponse,
          EntryGroup,
          ListEntryGroupsPage,
          ListEntryGroupsFixedSizeCollection> {

    public static ApiFuture<ListEntryGroupsPagedResponse> createAsync(
        PageContext<ListEntryGroupsRequest, ListEntryGroupsResponse, EntryGroup> context,
        ApiFuture<ListEntryGroupsResponse> futureResponse) {
      ApiFuture<ListEntryGroupsPage> futurePage =
          ListEntryGroupsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListEntryGroupsPage, ListEntryGroupsPagedResponse>() {
            @Override
            public ListEntryGroupsPagedResponse apply(ListEntryGroupsPage input) {
              return new ListEntryGroupsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListEntryGroupsPagedResponse(ListEntryGroupsPage page) {
      super(page, ListEntryGroupsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEntryGroupsPage
      extends AbstractPage<
          ListEntryGroupsRequest, ListEntryGroupsResponse, EntryGroup, ListEntryGroupsPage> {

    private ListEntryGroupsPage(
        PageContext<ListEntryGroupsRequest, ListEntryGroupsResponse, EntryGroup> context,
        ListEntryGroupsResponse response) {
      super(context, response);
    }

    private static ListEntryGroupsPage createEmptyPage() {
      return new ListEntryGroupsPage(null, null);
    }

    @Override
    protected ListEntryGroupsPage createPage(
        PageContext<ListEntryGroupsRequest, ListEntryGroupsResponse, EntryGroup> context,
        ListEntryGroupsResponse response) {
      return new ListEntryGroupsPage(context, response);
    }

    @Override
    public ApiFuture<ListEntryGroupsPage> createPageAsync(
        PageContext<ListEntryGroupsRequest, ListEntryGroupsResponse, EntryGroup> context,
        ApiFuture<ListEntryGroupsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEntryGroupsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEntryGroupsRequest,
          ListEntryGroupsResponse,
          EntryGroup,
          ListEntryGroupsPage,
          ListEntryGroupsFixedSizeCollection> {

    private ListEntryGroupsFixedSizeCollection(
        List<ListEntryGroupsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEntryGroupsFixedSizeCollection createEmptyCollection() {
      return new ListEntryGroupsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEntryGroupsFixedSizeCollection createCollection(
        List<ListEntryGroupsPage> pages, int collectionSize) {
      return new ListEntryGroupsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListEntriesPagedResponse
      extends AbstractPagedListResponse<
          ListEntriesRequest,
          ListEntriesResponse,
          Entry,
          ListEntriesPage,
          ListEntriesFixedSizeCollection> {

    public static ApiFuture<ListEntriesPagedResponse> createAsync(
        PageContext<ListEntriesRequest, ListEntriesResponse, Entry> context,
        ApiFuture<ListEntriesResponse> futureResponse) {
      ApiFuture<ListEntriesPage> futurePage =
          ListEntriesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListEntriesPage, ListEntriesPagedResponse>() {
            @Override
            public ListEntriesPagedResponse apply(ListEntriesPage input) {
              return new ListEntriesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListEntriesPagedResponse(ListEntriesPage page) {
      super(page, ListEntriesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListEntriesPage
      extends AbstractPage<ListEntriesRequest, ListEntriesResponse, Entry, ListEntriesPage> {

    private ListEntriesPage(
        PageContext<ListEntriesRequest, ListEntriesResponse, Entry> context,
        ListEntriesResponse response) {
      super(context, response);
    }

    private static ListEntriesPage createEmptyPage() {
      return new ListEntriesPage(null, null);
    }

    @Override
    protected ListEntriesPage createPage(
        PageContext<ListEntriesRequest, ListEntriesResponse, Entry> context,
        ListEntriesResponse response) {
      return new ListEntriesPage(context, response);
    }

    @Override
    public ApiFuture<ListEntriesPage> createPageAsync(
        PageContext<ListEntriesRequest, ListEntriesResponse, Entry> context,
        ApiFuture<ListEntriesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListEntriesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListEntriesRequest,
          ListEntriesResponse,
          Entry,
          ListEntriesPage,
          ListEntriesFixedSizeCollection> {

    private ListEntriesFixedSizeCollection(List<ListEntriesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListEntriesFixedSizeCollection createEmptyCollection() {
      return new ListEntriesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListEntriesFixedSizeCollection createCollection(
        List<ListEntriesPage> pages, int collectionSize) {
      return new ListEntriesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTagsPagedResponse
      extends AbstractPagedListResponse<
          ListTagsRequest, ListTagsResponse, Tag, ListTagsPage, ListTagsFixedSizeCollection> {

    public static ApiFuture<ListTagsPagedResponse> createAsync(
        PageContext<ListTagsRequest, ListTagsResponse, Tag> context,
        ApiFuture<ListTagsResponse> futureResponse) {
      ApiFuture<ListTagsPage> futurePage =
          ListTagsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListTagsPage, ListTagsPagedResponse>() {
            @Override
            public ListTagsPagedResponse apply(ListTagsPage input) {
              return new ListTagsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListTagsPagedResponse(ListTagsPage page) {
      super(page, ListTagsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTagsPage
      extends AbstractPage<ListTagsRequest, ListTagsResponse, Tag, ListTagsPage> {

    private ListTagsPage(
        PageContext<ListTagsRequest, ListTagsResponse, Tag> context, ListTagsResponse response) {
      super(context, response);
    }

    private static ListTagsPage createEmptyPage() {
      return new ListTagsPage(null, null);
    }

    @Override
    protected ListTagsPage createPage(
        PageContext<ListTagsRequest, ListTagsResponse, Tag> context, ListTagsResponse response) {
      return new ListTagsPage(context, response);
    }

    @Override
    public ApiFuture<ListTagsPage> createPageAsync(
        PageContext<ListTagsRequest, ListTagsResponse, Tag> context,
        ApiFuture<ListTagsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTagsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTagsRequest, ListTagsResponse, Tag, ListTagsPage, ListTagsFixedSizeCollection> {

    private ListTagsFixedSizeCollection(List<ListTagsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTagsFixedSizeCollection createEmptyCollection() {
      return new ListTagsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTagsFixedSizeCollection createCollection(
        List<ListTagsPage> pages, int collectionSize) {
      return new ListTagsFixedSizeCollection(pages, collectionSize);
    }
  }
}
