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

package com.google.cloud.datacatalog.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.resourcenames.ResourceName;
import com.google.cloud.datacatalog.v1.stub.DataCatalogStub;
import com.google.cloud.datacatalog.v1.stub.DataCatalogStubSettings;
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
 * Service Description: Data Catalog API service allows you to discover, understand, and manage your
 * data.
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
 * // This snippet has been automatically generated and should be regarded as a code template only.
 * // It will require modifications to work:
 * // - It may require correct/in-range values for request initialization.
 * // - It may require specifying regional endpoints when creating the service client as shown in
 * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
 * DataCatalogSettings dataCatalogSettings =
 *     DataCatalogSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataCatalogClient dataCatalogClient = DataCatalogClient.create(dataCatalogSettings);
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
 * DataCatalogSettings dataCatalogSettings = DataCatalogSettings.newHttpJsonBuilder().build();
 * DataCatalogClient dataCatalogClient = DataCatalogClient.create(dataCatalogSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
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

  protected DataCatalogClient(DataCatalogStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DataCatalogSettings getSettings() {
    return settings;
  }

  public DataCatalogStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Searches Data Catalog for multiple resources like entries and tags that match a query.
   *
   * <p>This is a [Custom Method] (https://cloud.google.com/apis/design/custom_methods) that doesn't
   * return all information on a resource, only its ID and high level fields. To get more
   * information, you can subsequently call specific get methods.
   *
   * <p>Note: Data Catalog search queries don't guarantee full recall. Results that match your query
   * might not be returned, even in subsequent result pages. Additionally, returned (and not
   * returned) results can vary if you repeat search queries.
   *
   * <p>For more information, see [Data Catalog search syntax]
   * (https://cloud.google.com/data-catalog/docs/how-to/search-reference).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * @param scope Required. The scope of this search request.
   *     <p>The `scope` is invalid if `include_org_ids`, `include_project_ids` are empty AND
   *     `include_gcp_public_datasets` is set to `false`. In this case, the request returns an
   *     error.
   * @param query Optional. The query string with a minimum of 3 characters and specific syntax. For
   *     more information, see [Data Catalog search
   *     syntax](https://cloud.google.com/data-catalog/docs/how-to/search-reference).
   *     <p>An empty query string returns all data assets (in the specified scope) that you have
   *     access to.
   *     <p>A query string can be a simple `xyz` or qualified by predicates:
   *     <ul>
   *       <li>`name:x`
   *       <li>`column:y`
   *       <li>`description:z`
   *     </ul>
   *
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
   * Searches Data Catalog for multiple resources like entries and tags that match a query.
   *
   * <p>This is a [Custom Method] (https://cloud.google.com/apis/design/custom_methods) that doesn't
   * return all information on a resource, only its ID and high level fields. To get more
   * information, you can subsequently call specific get methods.
   *
   * <p>Note: Data Catalog search queries don't guarantee full recall. Results that match your query
   * might not be returned, even in subsequent result pages. Additionally, returned (and not
   * returned) results can vary if you repeat search queries.
   *
   * <p>For more information, see [Data Catalog search syntax]
   * (https://cloud.google.com/data-catalog/docs/how-to/search-reference).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Searches Data Catalog for multiple resources like entries and tags that match a query.
   *
   * <p>This is a [Custom Method] (https://cloud.google.com/apis/design/custom_methods) that doesn't
   * return all information on a resource, only its ID and high level fields. To get more
   * information, you can subsequently call specific get methods.
   *
   * <p>Note: Data Catalog search queries don't guarantee full recall. Results that match your query
   * might not be returned, even in subsequent result pages. Additionally, returned (and not
   * returned) results can vary if you repeat search queries.
   *
   * <p>For more information, see [Data Catalog search syntax]
   * (https://cloud.google.com/data-catalog/docs/how-to/search-reference).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Searches Data Catalog for multiple resources like entries and tags that match a query.
   *
   * <p>This is a [Custom Method] (https://cloud.google.com/apis/design/custom_methods) that doesn't
   * return all information on a resource, only its ID and high level fields. To get more
   * information, you can subsequently call specific get methods.
   *
   * <p>Note: Data Catalog search queries don't guarantee full recall. Results that match your query
   * might not be returned, even in subsequent result pages. Additionally, returned (and not
   * returned) results can vary if you repeat search queries.
   *
   * <p>For more information, see [Data Catalog search syntax]
   * (https://cloud.google.com/data-catalog/docs/how-to/search-reference).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   SearchCatalogRequest request =
   *       SearchCatalogRequest.newBuilder()
   *           .setScope(SearchCatalogRequest.Scope.newBuilder().build())
   *           .setQuery("query107944136")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     SearchCatalogResponse response = dataCatalogClient.searchCatalogCallable().call(request);
   *     for (SearchCatalogResult element : response.getResultsList()) {
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
   * Creates an entry group.
   *
   * <p>An entry group contains logically related entries together with [Cloud Identity and Access
   * Management](/data-catalog/docs/concepts/iam) policies. These policies specify users who can
   * create, edit, and view entries within entry groups.
   *
   * <p>Data Catalog automatically creates entry groups with names that start with the
   * `{@literal @}` symbol for the following resources:
   *
   * <ul>
   *   <li>BigQuery entries (`{@literal @}bigquery`)
   *   <li>Pub/Sub topics (`{@literal @}pubsub`)
   *   <li>Dataproc Metastore services (`{@literal @}dataproc_metastore_{SERVICE_NAME_HASH}`)
   * </ul>
   *
   * <p>You can create your own entry groups for Cloud Storage fileset entries and custom entries
   * together with the corresponding IAM policies. User-created entry groups can't contain the
   * `{@literal @}` symbol, it is reserved for automatically created groups.
   *
   * <p>Entry groups, like entries, can be searched.
   *
   * <p>A maximum of 10,000 entry groups may be created per organization across all locations.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `parent` parameter.
   * For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   String entryGroupId = "entryGroupId1228924712";
   *   EntryGroup entryGroup = EntryGroup.newBuilder().build();
   *   EntryGroup response = dataCatalogClient.createEntryGroup(parent, entryGroupId, entryGroup);
   * }
   * }</pre>
   *
   * @param parent Required. The names of the project and location that the new entry group belongs
   *     to.
   *     <p>Note: The entry group itself and its child resources might not be stored in the location
   *     specified in its name.
   * @param entryGroupId Required. The ID of the entry group to create.
   *     <p>The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and must
   *     start with a letter or underscore. The maximum size is 64 bytes when encoded in UTF-8.
   * @param entryGroup The entry group to create. Defaults to empty.
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
   * Creates an entry group.
   *
   * <p>An entry group contains logically related entries together with [Cloud Identity and Access
   * Management](/data-catalog/docs/concepts/iam) policies. These policies specify users who can
   * create, edit, and view entries within entry groups.
   *
   * <p>Data Catalog automatically creates entry groups with names that start with the
   * `{@literal @}` symbol for the following resources:
   *
   * <ul>
   *   <li>BigQuery entries (`{@literal @}bigquery`)
   *   <li>Pub/Sub topics (`{@literal @}pubsub`)
   *   <li>Dataproc Metastore services (`{@literal @}dataproc_metastore_{SERVICE_NAME_HASH}`)
   * </ul>
   *
   * <p>You can create your own entry groups for Cloud Storage fileset entries and custom entries
   * together with the corresponding IAM policies. User-created entry groups can't contain the
   * `{@literal @}` symbol, it is reserved for automatically created groups.
   *
   * <p>Entry groups, like entries, can be searched.
   *
   * <p>A maximum of 10,000 entry groups may be created per organization across all locations.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `parent` parameter.
   * For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String entryGroupId = "entryGroupId1228924712";
   *   EntryGroup entryGroup = EntryGroup.newBuilder().build();
   *   EntryGroup response = dataCatalogClient.createEntryGroup(parent, entryGroupId, entryGroup);
   * }
   * }</pre>
   *
   * @param parent Required. The names of the project and location that the new entry group belongs
   *     to.
   *     <p>Note: The entry group itself and its child resources might not be stored in the location
   *     specified in its name.
   * @param entryGroupId Required. The ID of the entry group to create.
   *     <p>The ID must contain only letters (a-z, A-Z), numbers (0-9), underscores (_), and must
   *     start with a letter or underscore. The maximum size is 64 bytes when encoded in UTF-8.
   * @param entryGroup The entry group to create. Defaults to empty.
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
   * Creates an entry group.
   *
   * <p>An entry group contains logically related entries together with [Cloud Identity and Access
   * Management](/data-catalog/docs/concepts/iam) policies. These policies specify users who can
   * create, edit, and view entries within entry groups.
   *
   * <p>Data Catalog automatically creates entry groups with names that start with the
   * `{@literal @}` symbol for the following resources:
   *
   * <ul>
   *   <li>BigQuery entries (`{@literal @}bigquery`)
   *   <li>Pub/Sub topics (`{@literal @}pubsub`)
   *   <li>Dataproc Metastore services (`{@literal @}dataproc_metastore_{SERVICE_NAME_HASH}`)
   * </ul>
   *
   * <p>You can create your own entry groups for Cloud Storage fileset entries and custom entries
   * together with the corresponding IAM policies. User-created entry groups can't contain the
   * `{@literal @}` symbol, it is reserved for automatically created groups.
   *
   * <p>Entry groups, like entries, can be searched.
   *
   * <p>A maximum of 10,000 entry groups may be created per organization across all locations.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `parent` parameter.
   * For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateEntryGroupRequest request =
   *       CreateEntryGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
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
   * Creates an entry group.
   *
   * <p>An entry group contains logically related entries together with [Cloud Identity and Access
   * Management](/data-catalog/docs/concepts/iam) policies. These policies specify users who can
   * create, edit, and view entries within entry groups.
   *
   * <p>Data Catalog automatically creates entry groups with names that start with the
   * `{@literal @}` symbol for the following resources:
   *
   * <ul>
   *   <li>BigQuery entries (`{@literal @}bigquery`)
   *   <li>Pub/Sub topics (`{@literal @}pubsub`)
   *   <li>Dataproc Metastore services (`{@literal @}dataproc_metastore_{SERVICE_NAME_HASH}`)
   * </ul>
   *
   * <p>You can create your own entry groups for Cloud Storage fileset entries and custom entries
   * together with the corresponding IAM policies. User-created entry groups can't contain the
   * `{@literal @}` symbol, it is reserved for automatically created groups.
   *
   * <p>Entry groups, like entries, can be searched.
   *
   * <p>A maximum of 10,000 entry groups may be created per organization across all locations.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `parent` parameter.
   * For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateEntryGroupRequest request =
   *       CreateEntryGroupRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
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
   * Gets an entry group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   EntryGroup response = dataCatalogClient.getEntryGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry group to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryGroup getEntryGroup(EntryGroupName name) {
    GetEntryGroupRequest request =
        GetEntryGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an entry group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString();
   *   EntryGroup response = dataCatalogClient.getEntryGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry group to get.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryGroup getEntryGroup(String name) {
    GetEntryGroupRequest request = GetEntryGroupRequest.newBuilder().setName(name).build();
    return getEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an entry group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   FieldMask readMask = FieldMask.newBuilder().build();
   *   EntryGroup response = dataCatalogClient.getEntryGroup(name, readMask);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry group to get.
   * @param readMask The fields to return. If empty or omitted, all fields are returned.
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
   * Gets an entry group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString();
   *   FieldMask readMask = FieldMask.newBuilder().build();
   *   EntryGroup response = dataCatalogClient.getEntryGroup(name, readMask);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry group to get.
   * @param readMask The fields to return. If empty or omitted, all fields are returned.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryGroup getEntryGroup(String name, FieldMask readMask) {
    GetEntryGroupRequest request =
        GetEntryGroupRequest.newBuilder().setName(name).setReadMask(readMask).build();
    return getEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets an entry group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Gets an entry group.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Updates an entry group.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `entry_group.name`
   * parameter. For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryGroup entryGroup = EntryGroup.newBuilder().build();
   *   EntryGroup response = dataCatalogClient.updateEntryGroup(entryGroup);
   * }
   * }</pre>
   *
   * @param entryGroup Required. Updates for the entry group. The `name` field must be set.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryGroup updateEntryGroup(EntryGroup entryGroup) {
    UpdateEntryGroupRequest request =
        UpdateEntryGroupRequest.newBuilder().setEntryGroup(entryGroup).build();
    return updateEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an entry group.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `entry_group.name`
   * parameter. For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryGroup entryGroup = EntryGroup.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   EntryGroup response = dataCatalogClient.updateEntryGroup(entryGroup, updateMask);
   * }
   * }</pre>
   *
   * @param entryGroup Required. Updates for the entry group. The `name` field must be set.
   * @param updateMask Names of fields whose values to overwrite on an entry group.
   *     <p>If this parameter is absent or empty, all modifiable fields are overwritten. If such
   *     fields are non-required and omitted in the request body, their values are emptied.
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
   * Updates an entry group.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `entry_group.name`
   * parameter. For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Updates an entry group.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `entry_group.name`
   * parameter. For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Deletes an entry group.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryGroupName name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   dataCatalogClient.deleteEntryGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry group to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEntryGroup(EntryGroupName name) {
    DeleteEntryGroupRequest request =
        DeleteEntryGroupRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an entry group.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString();
   *   dataCatalogClient.deleteEntryGroup(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry group to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEntryGroup(String name) {
    DeleteEntryGroupRequest request = DeleteEntryGroupRequest.newBuilder().setName(name).build();
    deleteEntryGroup(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an entry group.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Deletes an entry group.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (EntryGroup element : dataCatalogClient.listEntryGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the location that contains the entry groups to list.
   *     <p>Can be provided as a URL.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListEntryGroupsPagedResponse listEntryGroups(LocationName parent) {
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (EntryGroup element : dataCatalogClient.listEntryGroups(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the location that contains the entry groups to list.
   *     <p>Can be provided as a URL.
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ListEntryGroupsRequest request =
   *       ListEntryGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ListEntryGroupsRequest request =
   *       ListEntryGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ListEntryGroupsRequest request =
   *       ListEntryGroupsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListEntryGroupsResponse response =
   *         dataCatalogClient.listEntryGroupsCallable().call(request);
   *     for (EntryGroup element : response.getEntryGroupsList()) {
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
   * Creates an entry.
   *
   * <p>You can create entries only with 'FILESET', 'CLUSTER', 'DATA_STREAM', or custom types. Data
   * Catalog automatically creates entries with other types during metadata ingestion from
   * integrated systems.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `parent` parameter.
   * For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>An entry group can have a maximum of 100,000 entries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryGroupName parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   String entryId = "entryId-1591558867";
   *   Entry entry = Entry.newBuilder().build();
   *   Entry response = dataCatalogClient.createEntry(parent, entryId, entry);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the entry group this entry belongs to.
   *     <p>Note: The entry itself and its child resources might not be stored in the location
   *     specified in its name.
   * @param entryId Required. The ID of the entry to create.
   *     <p>The ID must contain only letters (a-z, A-Z), numbers (0-9), and underscores (_). The
   *     maximum size is 64 bytes when encoded in UTF-8.
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
   * Creates an entry.
   *
   * <p>You can create entries only with 'FILESET', 'CLUSTER', 'DATA_STREAM', or custom types. Data
   * Catalog automatically creates entries with other types during metadata ingestion from
   * integrated systems.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `parent` parameter.
   * For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>An entry group can have a maximum of 100,000 entries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString();
   *   String entryId = "entryId-1591558867";
   *   Entry entry = Entry.newBuilder().build();
   *   Entry response = dataCatalogClient.createEntry(parent, entryId, entry);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the entry group this entry belongs to.
   *     <p>Note: The entry itself and its child resources might not be stored in the location
   *     specified in its name.
   * @param entryId Required. The ID of the entry to create.
   *     <p>The ID must contain only letters (a-z, A-Z), numbers (0-9), and underscores (_). The
   *     maximum size is 64 bytes when encoded in UTF-8.
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
   * Creates an entry.
   *
   * <p>You can create entries only with 'FILESET', 'CLUSTER', 'DATA_STREAM', or custom types. Data
   * Catalog automatically creates entries with other types during metadata ingestion from
   * integrated systems.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `parent` parameter.
   * For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>An entry group can have a maximum of 100,000 entries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Creates an entry.
   *
   * <p>You can create entries only with 'FILESET', 'CLUSTER', 'DATA_STREAM', or custom types. Data
   * Catalog automatically creates entries with other types during metadata ingestion from
   * integrated systems.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `parent` parameter.
   * For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>An entry group can have a maximum of 100,000 entries.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Updates an existing entry.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `entry.name`
   * parameter. For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   Entry entry = Entry.newBuilder().build();
   *   Entry response = dataCatalogClient.updateEntry(entry);
   * }
   * }</pre>
   *
   * @param entry Required. Updates for the entry. The `name` field must be set.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Entry updateEntry(Entry entry) {
    UpdateEntryRequest request = UpdateEntryRequest.newBuilder().setEntry(entry).build();
    return updateEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing entry.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `entry.name`
   * parameter. For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   Entry entry = Entry.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Entry response = dataCatalogClient.updateEntry(entry, updateMask);
   * }
   * }</pre>
   *
   * @param entry Required. Updates for the entry. The `name` field must be set.
   * @param updateMask Names of fields whose values to overwrite on an entry.
   *     <p>If this parameter is absent or empty, all modifiable fields are overwritten. If such
   *     fields are non-required and omitted in the request body, their values are emptied.
   *     <p>You can modify only the fields listed below.
   *     <p>For entries with type `DATA_STREAM`:
   *     <ul>
   *       <li>`schema`
   *     </ul>
   *     <p>For entries with type `FILESET`:
   *     <ul>
   *       <li>`schema`
   *       <li>`display_name`
   *       <li>`description`
   *       <li>`gcs_fileset_spec`
   *       <li>`gcs_fileset_spec.file_patterns`
   *     </ul>
   *     <p>For entries with `user_specified_type`:
   *     <ul>
   *       <li>`schema`
   *       <li>`display_name`
   *       <li>`description`
   *       <li>`user_specified_type`
   *       <li>`user_specified_system`
   *       <li>`linked_resource`
   *       <li>`source_system_timestamps`
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
   * Updates an existing entry.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `entry.name`
   * parameter. For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Updates an existing entry.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `entry.name`
   * parameter. For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Deletes an existing entry.
   *
   * <p>You can delete only the entries created by the
   * [CreateEntry][google.cloud.datacatalog.v1.DataCatalog.CreateEntry] method.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   dataCatalogClient.deleteEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEntry(EntryName name) {
    DeleteEntryRequest request =
        DeleteEntryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing entry.
   *
   * <p>You can delete only the entries created by the
   * [CreateEntry][google.cloud.datacatalog.v1.DataCatalog.CreateEntry] method.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString();
   *   dataCatalogClient.deleteEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry to delete.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteEntry(String name) {
    DeleteEntryRequest request = DeleteEntryRequest.newBuilder().setName(name).build();
    deleteEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing entry.
   *
   * <p>You can delete only the entries created by the
   * [CreateEntry][google.cloud.datacatalog.v1.DataCatalog.CreateEntry] method.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Deletes an existing entry.
   *
   * <p>You can delete only the entries created by the
   * [CreateEntry][google.cloud.datacatalog.v1.DataCatalog.CreateEntry] method.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   Entry response = dataCatalogClient.getEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry to get.
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString();
   *   Entry response = dataCatalogClient.getEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry to get.
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Gets an entry by its target resource name.
   *
   * <p>The resource name comes from the source Google Cloud Platform service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Gets an entry by its target resource name.
   *
   * <p>The resource name comes from the source Google Cloud Platform service.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * <p>Note: Currently, this method can list only custom entries. To get a list of both custom and
   * automatically created entries, use
   * [SearchCatalog][google.cloud.datacatalog.v1.DataCatalog.SearchCatalog].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryGroupName parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
   *   for (Entry element : dataCatalogClient.listEntries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the entry group that contains the entries to list.
   *     <p>Can be provided in URL format.
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
   * <p>Note: Currently, this method can list only custom entries. To get a list of both custom and
   * automatically created entries, use
   * [SearchCatalog][google.cloud.datacatalog.v1.DataCatalog.SearchCatalog].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String parent = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString();
   *   for (Entry element : dataCatalogClient.listEntries(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the entry group that contains the entries to list.
   *     <p>Can be provided in URL format.
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
   * <p>Note: Currently, this method can list only custom entries. To get a list of both custom and
   * automatically created entries, use
   * [SearchCatalog][google.cloud.datacatalog.v1.DataCatalog.SearchCatalog].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * <p>Note: Currently, this method can list only custom entries. To get a list of both custom and
   * automatically created entries, use
   * [SearchCatalog][google.cloud.datacatalog.v1.DataCatalog.SearchCatalog].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * <p>Note: Currently, this method can list only custom entries. To get a list of both custom and
   * automatically created entries, use
   * [SearchCatalog][google.cloud.datacatalog.v1.DataCatalog.SearchCatalog].
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ListEntriesRequest request =
   *       ListEntriesRequest.newBuilder()
   *           .setParent(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setReadMask(FieldMask.newBuilder().build())
   *           .build();
   *   while (true) {
   *     ListEntriesResponse response = dataCatalogClient.listEntriesCallable().call(request);
   *     for (Entry element : response.getEntriesList()) {
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
   * Modifies entry overview, part of the business context of an
   * [Entry][google.cloud.datacatalog.v1.Entry].
   *
   * <p>To call this method, you must have the `datacatalog.entries.updateOverview` IAM permission
   * on the corresponding project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ModifyEntryOverviewRequest request =
   *       ModifyEntryOverviewRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .setEntryOverview(EntryOverview.newBuilder().build())
   *           .build();
   *   EntryOverview response = dataCatalogClient.modifyEntryOverview(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final EntryOverview modifyEntryOverview(ModifyEntryOverviewRequest request) {
    return modifyEntryOverviewCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies entry overview, part of the business context of an
   * [Entry][google.cloud.datacatalog.v1.Entry].
   *
   * <p>To call this method, you must have the `datacatalog.entries.updateOverview` IAM permission
   * on the corresponding project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ModifyEntryOverviewRequest request =
   *       ModifyEntryOverviewRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .setEntryOverview(EntryOverview.newBuilder().build())
   *           .build();
   *   ApiFuture<EntryOverview> future =
   *       dataCatalogClient.modifyEntryOverviewCallable().futureCall(request);
   *   // Do something.
   *   EntryOverview response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ModifyEntryOverviewRequest, EntryOverview>
      modifyEntryOverviewCallable() {
    return stub.modifyEntryOverviewCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies contacts, part of the business context of an
   * [Entry][google.cloud.datacatalog.v1.Entry].
   *
   * <p>To call this method, you must have the `datacatalog.entries.updateContacts` IAM permission
   * on the corresponding project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ModifyEntryContactsRequest request =
   *       ModifyEntryContactsRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .setContacts(Contacts.newBuilder().build())
   *           .build();
   *   Contacts response = dataCatalogClient.modifyEntryContacts(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Contacts modifyEntryContacts(ModifyEntryContactsRequest request) {
    return modifyEntryContactsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Modifies contacts, part of the business context of an
   * [Entry][google.cloud.datacatalog.v1.Entry].
   *
   * <p>To call this method, you must have the `datacatalog.entries.updateContacts` IAM permission
   * on the corresponding project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ModifyEntryContactsRequest request =
   *       ModifyEntryContactsRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .setContacts(Contacts.newBuilder().build())
   *           .build();
   *   ApiFuture<Contacts> future =
   *       dataCatalogClient.modifyEntryContactsCallable().futureCall(request);
   *   // Do something.
   *   Contacts response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<ModifyEntryContactsRequest, Contacts> modifyEntryContactsCallable() {
    return stub.modifyEntryContactsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tag template.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `parent` parameter.
   * For more information, see [Data Catalog resource project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   *     [region](https://cloud.google.com/data-catalog/docs/concepts/regions).
   * @param tagTemplateId Required. The ID of the tag template to create.
   *     <p>The ID must contain only lowercase letters (a-z), numbers (0-9), or underscores (_), and
   *     must start with a letter or underscore. The maximum size is 64 bytes when encoded in UTF-8.
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
   * Creates a tag template.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `parent` parameter.
   * For more information, see [Data Catalog resource project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   String tagTemplateId = "tagTemplateId-1438776721";
   *   TagTemplate tagTemplate = TagTemplate.newBuilder().build();
   *   TagTemplate response =
   *       dataCatalogClient.createTagTemplate(parent, tagTemplateId, tagTemplate);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the project and the template location
   *     [region](https://cloud.google.com/data-catalog/docs/concepts/regions).
   * @param tagTemplateId Required. The ID of the tag template to create.
   *     <p>The ID must contain only lowercase letters (a-z), numbers (0-9), or underscores (_), and
   *     must start with a letter or underscore. The maximum size is 64 bytes when encoded in UTF-8.
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
   * Creates a tag template.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `parent` parameter.
   * For more information, see [Data Catalog resource project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateTagTemplateRequest request =
   *       CreateTagTemplateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
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
   * Creates a tag template.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `parent` parameter.
   * For more information, see [Data Catalog resource project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateTagTemplateRequest request =
   *       CreateTagTemplateRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplateName name = TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   TagTemplate response = dataCatalogClient.getTagTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template to get.
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString();
   *   TagTemplate response = dataCatalogClient.getTagTemplate(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template to get.
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Updates a tag template.
   *
   * <p>You can't update template fields with this method. These fields are separate resources with
   * their own create, update, and delete methods.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `tag_template.name`
   * parameter. For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplate tagTemplate = TagTemplate.newBuilder().build();
   *   TagTemplate response = dataCatalogClient.updateTagTemplate(tagTemplate);
   * }
   * }</pre>
   *
   * @param tagTemplate Required. The template to update. The `name` field must be set.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplate updateTagTemplate(TagTemplate tagTemplate) {
    UpdateTagTemplateRequest request =
        UpdateTagTemplateRequest.newBuilder().setTagTemplate(tagTemplate).build();
    return updateTagTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a tag template.
   *
   * <p>You can't update template fields with this method. These fields are separate resources with
   * their own create, update, and delete methods.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `tag_template.name`
   * parameter. For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplate tagTemplate = TagTemplate.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   TagTemplate response = dataCatalogClient.updateTagTemplate(tagTemplate, updateMask);
   * }
   * }</pre>
   *
   * @param tagTemplate Required. The template to update. The `name` field must be set.
   * @param updateMask Names of fields whose values to overwrite on a tag template. Currently, only
   *     `display_name` and `is_publicly_readable` can be overwritten.
   *     <p>If this parameter is absent or empty, all modifiable fields are overwritten. If such
   *     fields are non-required and omitted in the request body, their values are emptied.
   *     <p>Note: Updating the `is_publicly_readable` field may require up to 12 hours to take
   *     effect in search results.
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
   * Updates a tag template.
   *
   * <p>You can't update template fields with this method. These fields are separate resources with
   * their own create, update, and delete methods.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `tag_template.name`
   * parameter. For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Updates a tag template.
   *
   * <p>You can't update template fields with this method. These fields are separate resources with
   * their own create, update, and delete methods.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `tag_template.name`
   * parameter. For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Deletes a tag template and all tags that use it.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplateName name = TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]");
   *   boolean force = true;
   *   dataCatalogClient.deleteTagTemplate(name, force);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template to delete.
   * @param force Required. If true, deletes all tags that use this template.
   *     <p>Currently, `true` is the only supported value.
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
   * Deletes a tag template and all tags that use it.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = TagTemplateName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]").toString();
   *   boolean force = true;
   *   dataCatalogClient.deleteTagTemplate(name, force);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template to delete.
   * @param force Required. If true, deletes all tags that use this template.
   *     <p>Currently, `true` is the only supported value.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTagTemplate(String name, boolean force) {
    DeleteTagTemplateRequest request =
        DeleteTagTemplateRequest.newBuilder().setName(name).setForce(force).build();
    deleteTagTemplate(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a tag template and all tags that use it.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Deletes a tag template and all tags that use it.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Creates a field in a tag template.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `parent` parameter.
   * For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * @param tagTemplateFieldId Required. The ID of the tag template field to create.
   *     <p>Note: Adding a required field to an existing template is &#42;not&#42; allowed.
   *     <p>Field IDs can contain letters (both uppercase and lowercase), numbers (0-9), underscores
   *     (_) and dashes (-). Field IDs must be at least 1 character long and at most 128 characters
   *     long. Field IDs must also be unique within their template.
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
   * Creates a field in a tag template.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `parent` parameter.
   * For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * @param tagTemplateFieldId Required. The ID of the tag template field to create.
   *     <p>Note: Adding a required field to an existing template is &#42;not&#42; allowed.
   *     <p>Field IDs can contain letters (both uppercase and lowercase), numbers (0-9), underscores
   *     (_) and dashes (-). Field IDs must be at least 1 character long and at most 128 characters
   *     long. Field IDs must also be unique within their template.
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
   * Creates a field in a tag template.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `parent` parameter.
   * For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Creates a field in a tag template.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `parent` parameter.
   * For more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Updates a field in a tag template.
   *
   * <p>You can't update the field type with this method.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplateFieldName name =
   *       TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
   *   TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
   *   TagTemplateField response = dataCatalogClient.updateTagTemplateField(name, tagTemplateField);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template field.
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
   * Updates a field in a tag template.
   *
   * <p>You can't update the field type with this method.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name =
   *       TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
   *           .toString();
   *   TagTemplateField tagTemplateField = TagTemplateField.newBuilder().build();
   *   TagTemplateField response = dataCatalogClient.updateTagTemplateField(name, tagTemplateField);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template field.
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
   * Updates a field in a tag template.
   *
   * <p>You can't update the field type with this method.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * @param name Required. The name of the tag template field.
   * @param tagTemplateField Required. The template to update.
   * @param updateMask Optional. Names of fields whose values to overwrite on an individual field of
   *     a tag template. The following fields are modifiable:
   *     <ul>
   *       <li>`display_name`
   *       <li>`type.enum_type`
   *       <li>`is_required`
   *     </ul>
   *     <p>If this parameter is absent or empty, all modifiable fields are overwritten. If such
   *     fields are non-required and omitted in the request body, their values are emptied with one
   *     exception: when updating an enum type, the provided values are merged with the existing
   *     values. Therefore, enum values can only be added, existing enum values cannot be deleted or
   *     renamed.
   *     <p>Additionally, updating a template field from optional to required is
   *     <ul>
   *       <li>not&#42; allowed.
   *     </ul>
   *
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
   * Updates a field in a tag template.
   *
   * <p>You can't update the field type with this method.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * @param name Required. The name of the tag template field.
   * @param tagTemplateField Required. The template to update.
   * @param updateMask Optional. Names of fields whose values to overwrite on an individual field of
   *     a tag template. The following fields are modifiable:
   *     <ul>
   *       <li>`display_name`
   *       <li>`type.enum_type`
   *       <li>`is_required`
   *     </ul>
   *     <p>If this parameter is absent or empty, all modifiable fields are overwritten. If such
   *     fields are non-required and omitted in the request body, their values are emptied with one
   *     exception: when updating an enum type, the provided values are merged with the existing
   *     values. Therefore, enum values can only be added, existing enum values cannot be deleted or
   *     renamed.
   *     <p>Additionally, updating a template field from optional to required is
   *     <ul>
   *       <li>not&#42; allowed.
   *     </ul>
   *
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
   * Updates a field in a tag template.
   *
   * <p>You can't update the field type with this method.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Updates a field in a tag template.
   *
   * <p>You can't update the field type with this method.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Renames a field in a tag template.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplateFieldName name =
   *       TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
   *   String newTagTemplateFieldId = "newTagTemplateFieldId2008993953";
   *   TagTemplateField response =
   *       dataCatalogClient.renameTagTemplateField(name, newTagTemplateFieldId);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template field.
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
   * Renames a field in a tag template.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * @param name Required. The name of the tag template field.
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
   * Renames a field in a tag template.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Renames a field in a tag template.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource project]
   * (https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Renames an enum value in a tag template.
   *
   * <p>Within a single enum field, enum values must be unique.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplateFieldEnumValueName name =
   *       TagTemplateFieldEnumValueName.of(
   *           "[PROJECT]",
   *           "[LOCATION]",
   *           "[TAG_TEMPLATE]",
   *           "[TAG_TEMPLATE_FIELD_ID]",
   *           "[ENUM_VALUE_DISPLAY_NAME]");
   *   String newEnumValueDisplayName = "newEnumValueDisplayName-1119629027";
   *   TagTemplateField response =
   *       dataCatalogClient.renameTagTemplateFieldEnumValue(name, newEnumValueDisplayName);
   * }
   * }</pre>
   *
   * @param name Required. The name of the enum field value.
   * @param newEnumValueDisplayName Required. The new display name of the enum value. For example,
   *     `my_new_enum_value`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplateField renameTagTemplateFieldEnumValue(
      TagTemplateFieldEnumValueName name, String newEnumValueDisplayName) {
    RenameTagTemplateFieldEnumValueRequest request =
        RenameTagTemplateFieldEnumValueRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setNewEnumValueDisplayName(newEnumValueDisplayName)
            .build();
    return renameTagTemplateFieldEnumValue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames an enum value in a tag template.
   *
   * <p>Within a single enum field, enum values must be unique.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name =
   *       TagTemplateFieldEnumValueName.of(
   *               "[PROJECT]",
   *               "[LOCATION]",
   *               "[TAG_TEMPLATE]",
   *               "[TAG_TEMPLATE_FIELD_ID]",
   *               "[ENUM_VALUE_DISPLAY_NAME]")
   *           .toString();
   *   String newEnumValueDisplayName = "newEnumValueDisplayName-1119629027";
   *   TagTemplateField response =
   *       dataCatalogClient.renameTagTemplateFieldEnumValue(name, newEnumValueDisplayName);
   * }
   * }</pre>
   *
   * @param name Required. The name of the enum field value.
   * @param newEnumValueDisplayName Required. The new display name of the enum value. For example,
   *     `my_new_enum_value`.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplateField renameTagTemplateFieldEnumValue(
      String name, String newEnumValueDisplayName) {
    RenameTagTemplateFieldEnumValueRequest request =
        RenameTagTemplateFieldEnumValueRequest.newBuilder()
            .setName(name)
            .setNewEnumValueDisplayName(newEnumValueDisplayName)
            .build();
    return renameTagTemplateFieldEnumValue(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames an enum value in a tag template.
   *
   * <p>Within a single enum field, enum values must be unique.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   RenameTagTemplateFieldEnumValueRequest request =
   *       RenameTagTemplateFieldEnumValueRequest.newBuilder()
   *           .setName(
   *               TagTemplateFieldEnumValueName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[TAG_TEMPLATE]",
   *                       "[TAG_TEMPLATE_FIELD_ID]",
   *                       "[ENUM_VALUE_DISPLAY_NAME]")
   *                   .toString())
   *           .setNewEnumValueDisplayName("newEnumValueDisplayName-1119629027")
   *           .build();
   *   TagTemplateField response = dataCatalogClient.renameTagTemplateFieldEnumValue(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final TagTemplateField renameTagTemplateFieldEnumValue(
      RenameTagTemplateFieldEnumValueRequest request) {
    return renameTagTemplateFieldEnumValueCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames an enum value in a tag template.
   *
   * <p>Within a single enum field, enum values must be unique.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   RenameTagTemplateFieldEnumValueRequest request =
   *       RenameTagTemplateFieldEnumValueRequest.newBuilder()
   *           .setName(
   *               TagTemplateFieldEnumValueName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[TAG_TEMPLATE]",
   *                       "[TAG_TEMPLATE_FIELD_ID]",
   *                       "[ENUM_VALUE_DISPLAY_NAME]")
   *                   .toString())
   *           .setNewEnumValueDisplayName("newEnumValueDisplayName-1119629027")
   *           .build();
   *   ApiFuture<TagTemplateField> future =
   *       dataCatalogClient.renameTagTemplateFieldEnumValueCallable().futureCall(request);
   *   // Do something.
   *   TagTemplateField response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RenameTagTemplateFieldEnumValueRequest, TagTemplateField>
      renameTagTemplateFieldEnumValueCallable() {
    return stub.renameTagTemplateFieldEnumValueCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a field in a tag template and all uses of this field from the tags based on this
   * template.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TagTemplateFieldName name =
   *       TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]");
   *   boolean force = true;
   *   dataCatalogClient.deleteTagTemplateField(name, force);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template field to delete.
   * @param force Required. If true, deletes this field from any tags that use it.
   *     <p>Currently, `true` is the only supported value.
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
   * Deletes a field in a tag template and all uses of this field from the tags based on this
   * template.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name =
   *       TagTemplateFieldName.of("[PROJECT]", "[LOCATION]", "[TAG_TEMPLATE]", "[FIELD]")
   *           .toString();
   *   boolean force = true;
   *   dataCatalogClient.deleteTagTemplateField(name, force);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag template field to delete.
   * @param force Required. If true, deletes this field from any tags that use it.
   *     <p>Currently, `true` is the only supported value.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteTagTemplateField(String name, boolean force) {
    DeleteTagTemplateFieldRequest request =
        DeleteTagTemplateFieldRequest.newBuilder().setName(name).setForce(force).build();
    deleteTagTemplateField(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a field in a tag template and all uses of this field from the tags based on this
   * template.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Deletes a field in a tag template and all uses of this field from the tags based on this
   * template.
   *
   * <p>You must enable the Data Catalog API in the project identified by the `name` parameter. For
   * more information, see [Data Catalog resource
   * project](https://cloud.google.com/data-catalog/docs/concepts/resource-project).
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * Creates a tag and assigns it to:
   *
   * <ul>
   *   <li>An [Entry][google.cloud.datacatalog.v1.Entry] if the method name is
   *       `projects.locations.entryGroups.entries.tags.create`.
   *   <li>Or [EntryGroup][google.cloud.datacatalog.v1.EntryGroup]if the method name is
   *       `projects.locations.entryGroups.tags.create`.
   * </ul>
   *
   * <p>Note: The project identified by the `parent` parameter for the [tag]
   * (https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries.tags/create#path-parameters)
   * and the [tag template]
   * (https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.tagTemplates/create#path-parameters)
   * used to create the tag must be in the same organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryName parent = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   Tag tag = Tag.newBuilder().build();
   *   Tag response = dataCatalogClient.createTag(parent, tag);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the resource to attach this tag to.
   *     <p>Tags can be attached to entries or entry groups. An entry can have up to 1000 attached
   *     tags.
   *     <p>Note: The tag and its child resources might not be stored in the location specified in
   *     its name.
   * @param tag Required. The tag to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tag createTag(EntryName parent, Tag tag) {
    CreateTagRequest request =
        CreateTagRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTag(tag)
            .build();
    return createTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tag and assigns it to:
   *
   * <ul>
   *   <li>An [Entry][google.cloud.datacatalog.v1.Entry] if the method name is
   *       `projects.locations.entryGroups.entries.tags.create`.
   *   <li>Or [EntryGroup][google.cloud.datacatalog.v1.EntryGroup]if the method name is
   *       `projects.locations.entryGroups.tags.create`.
   * </ul>
   *
   * <p>Note: The project identified by the `parent` parameter for the [tag]
   * (https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries.tags/create#path-parameters)
   * and the [tag template]
   * (https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.tagTemplates/create#path-parameters)
   * used to create the tag must be in the same organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String parent =
   *       EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString();
   *   Tag tag = Tag.newBuilder().build();
   *   Tag response = dataCatalogClient.createTag(parent, tag);
   * }
   * }</pre>
   *
   * @param parent Required. The name of the resource to attach this tag to.
   *     <p>Tags can be attached to entries or entry groups. An entry can have up to 1000 attached
   *     tags.
   *     <p>Note: The tag and its child resources might not be stored in the location specified in
   *     its name.
   * @param tag Required. The tag to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Tag createTag(String parent, Tag tag) {
    CreateTagRequest request = CreateTagRequest.newBuilder().setParent(parent).setTag(tag).build();
    return createTag(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a tag and assigns it to:
   *
   * <ul>
   *   <li>An [Entry][google.cloud.datacatalog.v1.Entry] if the method name is
   *       `projects.locations.entryGroups.entries.tags.create`.
   *   <li>Or [EntryGroup][google.cloud.datacatalog.v1.EntryGroup]if the method name is
   *       `projects.locations.entryGroups.tags.create`.
   * </ul>
   *
   * <p>Note: The project identified by the `parent` parameter for the [tag]
   * (https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries.tags/create#path-parameters)
   * and the [tag template]
   * (https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.tagTemplates/create#path-parameters)
   * used to create the tag must be in the same organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateTagRequest request =
   *       CreateTagRequest.newBuilder()
   *           .setParent(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
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
   * Creates a tag and assigns it to:
   *
   * <ul>
   *   <li>An [Entry][google.cloud.datacatalog.v1.Entry] if the method name is
   *       `projects.locations.entryGroups.entries.tags.create`.
   *   <li>Or [EntryGroup][google.cloud.datacatalog.v1.EntryGroup]if the method name is
   *       `projects.locations.entryGroups.tags.create`.
   * </ul>
   *
   * <p>Note: The project identified by the `parent` parameter for the [tag]
   * (https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.entryGroups.entries.tags/create#path-parameters)
   * and the [tag template]
   * (https://cloud.google.com/data-catalog/docs/reference/rest/v1/projects.locations.tagTemplates/create#path-parameters)
   * used to create the tag must be in the same organization.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   CreateTagRequest request =
   *       CreateTagRequest.newBuilder()
   *           .setParent(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   Tag tag = Tag.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Tag response = dataCatalogClient.updateTag(tag, updateMask);
   * }
   * }</pre>
   *
   * @param tag Required. The updated tag. The "name" field must be set.
   * @param updateMask Names of fields whose values to overwrite on a tag. Currently, a tag has the
   *     only modifiable field with the name `fields`.
   *     <p>In general, if this parameter is absent or empty, all modifiable fields are overwritten.
   *     If such fields are non-required and omitted in the request body, their values are emptied.
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   dataCatalogClient.deleteTag(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag to delete.
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString();
   *   dataCatalogClient.deleteTag(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the tag to delete.
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   DeleteTagRequest request =
   *       DeleteTagRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
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
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   DeleteTagRequest request =
   *       DeleteTagRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
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
   * Lists tags assigned to an [Entry][google.cloud.datacatalog.v1.Entry]. The
   * [columns][google.cloud.datacatalog.v1.Tag.column] in the response are lowercased.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryName parent = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   for (Tag element : dataCatalogClient.listTags(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the Data Catalog resource to list the tags of.
   *     <p>The resource can be an [Entry][google.cloud.datacatalog.v1.Entry] or an
   *     [EntryGroup][google.cloud.datacatalog.v1.EntryGroup] (without `/entries/{entries}` at the
   *     end).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTagsPagedResponse listTags(EntryName parent) {
    ListTagsRequest request =
        ListTagsRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listTags(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tags assigned to an [Entry][google.cloud.datacatalog.v1.Entry]. The
   * [columns][google.cloud.datacatalog.v1.Tag.column] in the response are lowercased.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String parent =
   *       EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString();
   *   for (Tag element : dataCatalogClient.listTags(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The name of the Data Catalog resource to list the tags of.
   *     <p>The resource can be an [Entry][google.cloud.datacatalog.v1.Entry] or an
   *     [EntryGroup][google.cloud.datacatalog.v1.EntryGroup] (without `/entries/{entries}` at the
   *     end).
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTagsPagedResponse listTags(String parent) {
    ListTagsRequest request = ListTagsRequest.newBuilder().setParent(parent).build();
    return listTags(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists tags assigned to an [Entry][google.cloud.datacatalog.v1.Entry]. The
   * [columns][google.cloud.datacatalog.v1.Tag.column] in the response are lowercased.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ListTagsRequest request =
   *       ListTagsRequest.newBuilder()
   *           .setParent(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
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
   * Lists tags assigned to an [Entry][google.cloud.datacatalog.v1.Entry]. The
   * [columns][google.cloud.datacatalog.v1.Tag.column] in the response are lowercased.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ListTagsRequest request =
   *       ListTagsRequest.newBuilder()
   *           .setParent(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
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
   * Lists tags assigned to an [Entry][google.cloud.datacatalog.v1.Entry]. The
   * [columns][google.cloud.datacatalog.v1.Tag.column] in the response are lowercased.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ListTagsRequest request =
   *       ListTagsRequest.newBuilder()
   *           .setParent(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListTagsResponse response = dataCatalogClient.listTagsCallable().call(request);
   *     for (Tag element : response.getTagsList()) {
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
   * Marks an [Entry][google.cloud.datacatalog.v1.Entry] as starred by the current user. Starring
   * information is private to each user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   StarEntryResponse response = dataCatalogClient.starEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry to mark as starred.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StarEntryResponse starEntry(EntryName name) {
    StarEntryRequest request =
        StarEntryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return starEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks an [Entry][google.cloud.datacatalog.v1.Entry] as starred by the current user. Starring
   * information is private to each user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString();
   *   StarEntryResponse response = dataCatalogClient.starEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry to mark as starred.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StarEntryResponse starEntry(String name) {
    StarEntryRequest request = StarEntryRequest.newBuilder().setName(name).build();
    return starEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks an [Entry][google.cloud.datacatalog.v1.Entry] as starred by the current user. Starring
   * information is private to each user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   StarEntryRequest request =
   *       StarEntryRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .build();
   *   StarEntryResponse response = dataCatalogClient.starEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final StarEntryResponse starEntry(StarEntryRequest request) {
    return starEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks an [Entry][google.cloud.datacatalog.v1.Entry] as starred by the current user. Starring
   * information is private to each user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   StarEntryRequest request =
   *       StarEntryRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .build();
   *   ApiFuture<StarEntryResponse> future =
   *       dataCatalogClient.starEntryCallable().futureCall(request);
   *   // Do something.
   *   StarEntryResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<StarEntryRequest, StarEntryResponse> starEntryCallable() {
    return stub.starEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks an [Entry][google.cloud.datacatalog.v1.Entry] as NOT starred by the current user.
   * Starring information is private to each user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   EntryName name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
   *   UnstarEntryResponse response = dataCatalogClient.unstarEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry to mark as &#42;&#42;not&#42;&#42; starred.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnstarEntryResponse unstarEntry(EntryName name) {
    UnstarEntryRequest request =
        UnstarEntryRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return unstarEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks an [Entry][google.cloud.datacatalog.v1.Entry] as NOT starred by the current user.
   * Starring information is private to each user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String name = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString();
   *   UnstarEntryResponse response = dataCatalogClient.unstarEntry(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the entry to mark as &#42;&#42;not&#42;&#42; starred.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnstarEntryResponse unstarEntry(String name) {
    UnstarEntryRequest request = UnstarEntryRequest.newBuilder().setName(name).build();
    return unstarEntry(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks an [Entry][google.cloud.datacatalog.v1.Entry] as NOT starred by the current user.
   * Starring information is private to each user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   UnstarEntryRequest request =
   *       UnstarEntryRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .build();
   *   UnstarEntryResponse response = dataCatalogClient.unstarEntry(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final UnstarEntryResponse unstarEntry(UnstarEntryRequest request) {
    return unstarEntryCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Marks an [Entry][google.cloud.datacatalog.v1.Entry] as NOT starred by the current user.
   * Starring information is private to each user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   UnstarEntryRequest request =
   *       UnstarEntryRequest.newBuilder()
   *           .setName(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
   *           .build();
   *   ApiFuture<UnstarEntryResponse> future =
   *       dataCatalogClient.unstarEntryCallable().futureCall(request);
   *   // Do something.
   *   UnstarEntryResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UnstarEntryRequest, UnstarEntryResponse> unstarEntryCallable() {
    return stub.unstarEntryCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Sets an access control policy for a resource. Replaces any existing policy.
   *
   * <p>Supported resources are:
   *
   * <p>- Tag templates - Entry groups
   *
   * <p>Note: This method sets policies only within Data Catalog and can't be used to manage
   * policies in BigQuery, Pub/Sub, Dataproc Metastore, and any external Google Cloud Platform
   * resources synced with the Data Catalog.
   *
   * <p>To call this method, you must have the following Google IAM permissions:
   *
   * <p>- `datacatalog.tagTemplates.setIamPolicy` to set policies on tag templates. -
   * `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ResourceName resource = EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]");
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
   * Sets an access control policy for a resource. Replaces any existing policy.
   *
   * <p>Supported resources are:
   *
   * <p>- Tag templates - Entry groups
   *
   * <p>Note: This method sets policies only within Data Catalog and can't be used to manage
   * policies in BigQuery, Pub/Sub, Dataproc Metastore, and any external Google Cloud Platform
   * resources synced with the Data Catalog.
   *
   * <p>To call this method, you must have the following Google IAM permissions:
   *
   * <p>- `datacatalog.tagTemplates.setIamPolicy` to set policies on tag templates. -
   * `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String resource =
   *       EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString();
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
   * Sets an access control policy for a resource. Replaces any existing policy.
   *
   * <p>Supported resources are:
   *
   * <p>- Tag templates - Entry groups
   *
   * <p>Note: This method sets policies only within Data Catalog and can't be used to manage
   * policies in BigQuery, Pub/Sub, Dataproc Metastore, and any external Google Cloud Platform
   * resources synced with the Data Catalog.
   *
   * <p>To call this method, you must have the following Google IAM permissions:
   *
   * <p>- `datacatalog.tagTemplates.setIamPolicy` to set policies on tag templates. -
   * `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
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
   * Sets an access control policy for a resource. Replaces any existing policy.
   *
   * <p>Supported resources are:
   *
   * <p>- Tag templates - Entry groups
   *
   * <p>Note: This method sets policies only within Data Catalog and can't be used to manage
   * policies in BigQuery, Pub/Sub, Dataproc Metastore, and any external Google Cloud Platform
   * resources synced with the Data Catalog.
   *
   * <p>To call this method, you must have the following Google IAM permissions:
   *
   * <p>- `datacatalog.tagTemplates.setIamPolicy` to set policies on tag templates. -
   * `datacatalog.entryGroups.setIamPolicy` to set policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   SetIamPolicyRequest request =
   *       SetIamPolicyRequest.newBuilder()
   *           .setResource(EntryGroupName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]").toString())
   *           .setPolicy(Policy.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
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
   * Gets the access control policy for a resource.
   *
   * <p>May return:
   *
   * <ul>
   *   <li>A`NOT_FOUND` error if the resource doesn't exist or you don't have the permission to view
   *       it.
   *   <li>An empty policy if the resource exists but doesn't have a set policy.
   * </ul>
   *
   * <p>Supported resources are:
   *
   * <p>- Tag templates - Entry groups
   *
   * <p>Note: This method doesn't get policies from Google Cloud Platform resources ingested into
   * Data Catalog.
   *
   * <p>To call this method, you must have the following Google IAM permissions:
   *
   * <p>- `datacatalog.tagTemplates.getIamPolicy` to get policies on tag templates. -
   * `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   ResourceName resource = EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]");
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
   * Gets the access control policy for a resource.
   *
   * <p>May return:
   *
   * <ul>
   *   <li>A`NOT_FOUND` error if the resource doesn't exist or you don't have the permission to view
   *       it.
   *   <li>An empty policy if the resource exists but doesn't have a set policy.
   * </ul>
   *
   * <p>Supported resources are:
   *
   * <p>- Tag templates - Entry groups
   *
   * <p>Note: This method doesn't get policies from Google Cloud Platform resources ingested into
   * Data Catalog.
   *
   * <p>To call this method, you must have the following Google IAM permissions:
   *
   * <p>- `datacatalog.tagTemplates.getIamPolicy` to get policies on tag templates. -
   * `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   String resource =
   *       EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString();
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
   * Gets the access control policy for a resource.
   *
   * <p>May return:
   *
   * <ul>
   *   <li>A`NOT_FOUND` error if the resource doesn't exist or you don't have the permission to view
   *       it.
   *   <li>An empty policy if the resource exists but doesn't have a set policy.
   * </ul>
   *
   * <p>Supported resources are:
   *
   * <p>- Tag templates - Entry groups
   *
   * <p>Note: This method doesn't get policies from Google Cloud Platform resources ingested into
   * Data Catalog.
   *
   * <p>To call this method, you must have the following Google IAM permissions:
   *
   * <p>- `datacatalog.tagTemplates.getIamPolicy` to get policies on tag templates. -
   * `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
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
   * Gets the access control policy for a resource.
   *
   * <p>May return:
   *
   * <ul>
   *   <li>A`NOT_FOUND` error if the resource doesn't exist or you don't have the permission to view
   *       it.
   *   <li>An empty policy if the resource exists but doesn't have a set policy.
   * </ul>
   *
   * <p>Supported resources are:
   *
   * <p>- Tag templates - Entry groups
   *
   * <p>Note: This method doesn't get policies from Google Cloud Platform resources ingested into
   * Data Catalog.
   *
   * <p>To call this method, you must have the following Google IAM permissions:
   *
   * <p>- `datacatalog.tagTemplates.getIamPolicy` to get policies on tag templates. -
   * `datacatalog.entryGroups.getIamPolicy` to get policies on entry groups.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   GetIamPolicyRequest request =
   *       GetIamPolicyRequest.newBuilder()
   *           .setResource(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
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
   * Gets your permissions on a resource.
   *
   * <p>Returns an empty set of permissions if the resource doesn't exist.
   *
   * <p>Supported resources are:
   *
   * <p>- Tag templates - Entry groups
   *
   * <p>Note: This method gets policies only within Data Catalog and can't be used to get policies
   * from BigQuery, Pub/Sub, Dataproc Metastore, and any external Google Cloud Platform resources
   * ingested into Data Catalog.
   *
   * <p>No Google IAM permissions are required to call this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
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
   * Gets your permissions on a resource.
   *
   * <p>Returns an empty set of permissions if the resource doesn't exist.
   *
   * <p>Supported resources are:
   *
   * <p>- Tag templates - Entry groups
   *
   * <p>Note: This method gets policies only within Data Catalog and can't be used to get policies
   * from BigQuery, Pub/Sub, Dataproc Metastore, and any external Google Cloud Platform resources
   * ingested into Data Catalog.
   *
   * <p>No Google IAM permissions are required to call this method.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataCatalogClient dataCatalogClient = DataCatalogClient.create()) {
   *   TestIamPermissionsRequest request =
   *       TestIamPermissionsRequest.newBuilder()
   *           .setResource(
   *               EntryName.of("[PROJECT]", "[LOCATION]", "[ENTRY_GROUP]", "[ENTRY]").toString())
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
          input -> new SearchCatalogPagedResponse(input),
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
          input -> new ListEntryGroupsPagedResponse(input),
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
          futurePage, input -> new ListEntriesPagedResponse(input), MoreExecutors.directExecutor());
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
          futurePage, input -> new ListTagsPagedResponse(input), MoreExecutors.directExecutor());
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
