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
package com.google.cloud.recommendationengine.v1beta1;

import com.google.api.core.ApiFunction;
import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.longrunning.OperationFuture;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.OperationCallable;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.api.pathtemplate.PathTemplate;
import com.google.cloud.recommendationengine.v1beta1.stub.CatalogServiceStub;
import com.google.cloud.recommendationengine.v1beta1.stub.CatalogServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.longrunning.Operation;
import com.google.longrunning.OperationsClient;
import com.google.protobuf.Empty;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND SERVICE
/**
 * Service Description: Service for ingesting catalog information of the customer's website.
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>
 * <code>
 * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
 *   String formattedParent = CatalogServiceClient.formatCatalogName("[PROJECT]", "[LOCATION]", "[CATALOG]");
 *   CatalogItem catalogItem = CatalogItem.newBuilder().build();
 *   CatalogItem response = catalogServiceClient.createCatalogItem(formattedParent, catalogItem);
 * }
 * </code>
 * </pre>
 *
 * <p>Note: close() needs to be called on the catalogServiceClient object to clean up resources such
 * as threads. In the example above, try-with-resources is used, which automatically calls close().
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
 * <p>This class can be customized by passing in a custom instance of CatalogServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>
 * <code>
 * CatalogServiceSettings catalogServiceSettings =
 *     CatalogServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * CatalogServiceClient catalogServiceClient =
 *     CatalogServiceClient.create(catalogServiceSettings);
 * </code>
 * </pre>
 *
 * To customize the endpoint:
 *
 * <pre>
 * <code>
 * CatalogServiceSettings catalogServiceSettings =
 *     CatalogServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * CatalogServiceClient catalogServiceClient =
 *     CatalogServiceClient.create(catalogServiceSettings);
 * </code>
 * </pre>
 */
@Generated("by gapic-generator")
@BetaApi
public class CatalogServiceClient implements BackgroundResource {
  private final CatalogServiceSettings settings;
  private final CatalogServiceStub stub;
  private final OperationsClient operationsClient;

  private static final PathTemplate CATALOG_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/catalogs/{catalog}");

  private static final PathTemplate CATALOG_ITEM_PATH_PATH_TEMPLATE =
      PathTemplate.createWithoutUrlEncoding(
          "projects/{project}/locations/{location}/catalogs/{catalog}/catalogItems/{catalog_item_path=**}");

  /**
   * Formats a string containing the fully-qualified path to represent a catalog resource.
   *
   * @deprecated Use the {@link CatalogName} class instead.
   */
  @Deprecated
  public static final String formatCatalogName(String project, String location, String catalog) {
    return CATALOG_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "catalog", catalog);
  }

  /**
   * Formats a string containing the fully-qualified path to represent a catalog_item_path resource.
   *
   * @deprecated Use the {@link CatalogItemPathName} class instead.
   */
  @Deprecated
  public static final String formatCatalogItemPathName(
      String project, String location, String catalog, String catalogItemPath) {
    return CATALOG_ITEM_PATH_PATH_TEMPLATE.instantiate(
        "project", project,
        "location", location,
        "catalog", catalog,
        "catalog_item_path", catalogItemPath);
  }

  /**
   * Parses the project from the given fully-qualified path which represents a catalog resource.
   *
   * @deprecated Use the {@link CatalogName} class instead.
   */
  @Deprecated
  public static final String parseProjectFromCatalogName(String catalogName) {
    return CATALOG_PATH_TEMPLATE.parse(catalogName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a catalog resource.
   *
   * @deprecated Use the {@link CatalogName} class instead.
   */
  @Deprecated
  public static final String parseLocationFromCatalogName(String catalogName) {
    return CATALOG_PATH_TEMPLATE.parse(catalogName).get("location");
  }

  /**
   * Parses the catalog from the given fully-qualified path which represents a catalog resource.
   *
   * @deprecated Use the {@link CatalogName} class instead.
   */
  @Deprecated
  public static final String parseCatalogFromCatalogName(String catalogName) {
    return CATALOG_PATH_TEMPLATE.parse(catalogName).get("catalog");
  }

  /**
   * Parses the project from the given fully-qualified path which represents a catalog_item_path
   * resource.
   *
   * @deprecated Use the {@link CatalogItemPathName} class instead.
   */
  @Deprecated
  public static final String parseProjectFromCatalogItemPathName(String catalogItemPathName) {
    return CATALOG_ITEM_PATH_PATH_TEMPLATE.parse(catalogItemPathName).get("project");
  }

  /**
   * Parses the location from the given fully-qualified path which represents a catalog_item_path
   * resource.
   *
   * @deprecated Use the {@link CatalogItemPathName} class instead.
   */
  @Deprecated
  public static final String parseLocationFromCatalogItemPathName(String catalogItemPathName) {
    return CATALOG_ITEM_PATH_PATH_TEMPLATE.parse(catalogItemPathName).get("location");
  }

  /**
   * Parses the catalog from the given fully-qualified path which represents a catalog_item_path
   * resource.
   *
   * @deprecated Use the {@link CatalogItemPathName} class instead.
   */
  @Deprecated
  public static final String parseCatalogFromCatalogItemPathName(String catalogItemPathName) {
    return CATALOG_ITEM_PATH_PATH_TEMPLATE.parse(catalogItemPathName).get("catalog");
  }

  /**
   * Parses the catalog_item_path from the given fully-qualified path which represents a
   * catalog_item_path resource.
   *
   * @deprecated Use the {@link CatalogItemPathName} class instead.
   */
  @Deprecated
  public static final String parseCatalogItemPathFromCatalogItemPathName(
      String catalogItemPathName) {
    return CATALOG_ITEM_PATH_PATH_TEMPLATE.parse(catalogItemPathName).get("catalog_item_path");
  }

  /** Constructs an instance of CatalogServiceClient with default settings. */
  public static final CatalogServiceClient create() throws IOException {
    return create(CatalogServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of CatalogServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final CatalogServiceClient create(CatalogServiceSettings settings)
      throws IOException {
    return new CatalogServiceClient(settings);
  }

  /**
   * Constructs an instance of CatalogServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer to use CatalogServiceSettings}.
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final CatalogServiceClient create(CatalogServiceStub stub) {
    return new CatalogServiceClient(stub);
  }

  /**
   * Constructs an instance of CatalogServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected CatalogServiceClient(CatalogServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((CatalogServiceStubSettings) settings.getStubSettings()).createStub();
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected CatalogServiceClient(CatalogServiceStub stub) {
    this.settings = null;
    this.stub = stub;
    this.operationsClient = OperationsClient.create(this.stub.getOperationsStub());
  }

  public final CatalogServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public CatalogServiceStub getStub() {
    return stub;
  }

  /**
   * Returns the OperationsClient that can be used to query the status of a long-running operation
   * returned by another API method call.
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationsClient getOperationsClient() {
    return operationsClient;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a catalog item.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String formattedParent = CatalogServiceClient.formatCatalogName("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   CatalogItem catalogItem = CatalogItem.newBuilder().build();
   *   CatalogItem response = catalogServiceClient.createCatalogItem(formattedParent, catalogItem);
   * }
   * </code></pre>
   *
   * @param parent Required. The parent catalog resource name, such as
   *     "projects/&#42;/locations/global/catalogs/default_catalog".
   * @param catalogItem Required. The catalog item to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CatalogItem createCatalogItem(String parent, CatalogItem catalogItem) {
    CATALOG_PATH_TEMPLATE.validate(parent, "createCatalogItem");
    CreateCatalogItemRequest request =
        CreateCatalogItemRequest.newBuilder().setParent(parent).setCatalogItem(catalogItem).build();
    return createCatalogItem(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a catalog item.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String formattedParent = CatalogServiceClient.formatCatalogName("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   CatalogItem catalogItem = CatalogItem.newBuilder().build();
   *   CreateCatalogItemRequest request = CreateCatalogItemRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setCatalogItem(catalogItem)
   *     .build();
   *   CatalogItem response = catalogServiceClient.createCatalogItem(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CatalogItem createCatalogItem(CreateCatalogItemRequest request) {
    return createCatalogItemCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Creates a catalog item.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String formattedParent = CatalogServiceClient.formatCatalogName("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   CatalogItem catalogItem = CatalogItem.newBuilder().build();
   *   CreateCatalogItemRequest request = CreateCatalogItemRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setCatalogItem(catalogItem)
   *     .build();
   *   ApiFuture&lt;CatalogItem&gt; future = catalogServiceClient.createCatalogItemCallable().futureCall(request);
   *   // Do something
   *   CatalogItem response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<CreateCatalogItemRequest, CatalogItem> createCatalogItemCallable() {
    return stub.createCatalogItemCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a specific catalog item.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String formattedName = CatalogServiceClient.formatCatalogItemPathName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");
   *   CatalogItem response = catalogServiceClient.getCatalogItem(formattedName);
   * }
   * </code></pre>
   *
   * @param name Required. Full resource name of catalog item, such as
   *     "projects/&#42;/locations/global/catalogs/default_catalog/catalogitems/some_catalog_item_id".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CatalogItem getCatalogItem(String name) {
    CATALOG_ITEM_PATH_PATH_TEMPLATE.validate(name, "getCatalogItem");
    GetCatalogItemRequest request = GetCatalogItemRequest.newBuilder().setName(name).build();
    return getCatalogItem(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a specific catalog item.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String formattedName = CatalogServiceClient.formatCatalogItemPathName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");
   *   GetCatalogItemRequest request = GetCatalogItemRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   CatalogItem response = catalogServiceClient.getCatalogItem(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CatalogItem getCatalogItem(GetCatalogItemRequest request) {
    return getCatalogItemCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a specific catalog item.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String formattedName = CatalogServiceClient.formatCatalogItemPathName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");
   *   GetCatalogItemRequest request = GetCatalogItemRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;CatalogItem&gt; future = catalogServiceClient.getCatalogItemCallable().futureCall(request);
   *   // Do something
   *   CatalogItem response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<GetCatalogItemRequest, CatalogItem> getCatalogItemCallable() {
    return stub.getCatalogItemCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a list of catalog items.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String formattedParent = CatalogServiceClient.formatCatalogName("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   String filter = "";
   *   for (CatalogItem element : catalogServiceClient.listCatalogItems(formattedParent, filter).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param parent Required. The parent catalog resource name, such as
   *     "projects/&#42;/locations/global/catalogs/default_catalog".
   * @param filter Optional. A filter to apply on the list results.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCatalogItemsPagedResponse listCatalogItems(String parent, String filter) {
    CATALOG_PATH_TEMPLATE.validate(parent, "listCatalogItems");
    ListCatalogItemsRequest request =
        ListCatalogItemsRequest.newBuilder().setParent(parent).setFilter(filter).build();
    return listCatalogItems(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a list of catalog items.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String formattedParent = CatalogServiceClient.formatCatalogName("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   ListCatalogItemsRequest request = ListCatalogItemsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   for (CatalogItem element : catalogServiceClient.listCatalogItems(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCatalogItemsPagedResponse listCatalogItems(ListCatalogItemsRequest request) {
    return listCatalogItemsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a list of catalog items.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String formattedParent = CatalogServiceClient.formatCatalogName("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   ListCatalogItemsRequest request = ListCatalogItemsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   ApiFuture&lt;ListCatalogItemsPagedResponse&gt; future = catalogServiceClient.listCatalogItemsPagedCallable().futureCall(request);
   *   // Do something
   *   for (CatalogItem element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * </code></pre>
   */
  public final UnaryCallable<ListCatalogItemsRequest, ListCatalogItemsPagedResponse>
      listCatalogItemsPagedCallable() {
    return stub.listCatalogItemsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Gets a list of catalog items.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String formattedParent = CatalogServiceClient.formatCatalogName("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   ListCatalogItemsRequest request = ListCatalogItemsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .build();
   *   while (true) {
   *     ListCatalogItemsResponse response = catalogServiceClient.listCatalogItemsCallable().call(request);
   *     for (CatalogItem element : response.getCatalogItemsList()) {
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
  public final UnaryCallable<ListCatalogItemsRequest, ListCatalogItemsResponse>
      listCatalogItemsCallable() {
    return stub.listCatalogItemsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a catalog item. Partial updating is supported. Non-existing items will be created.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String formattedName = CatalogServiceClient.formatCatalogItemPathName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");
   *   CatalogItem catalogItem = CatalogItem.newBuilder().build();
   *   CatalogItem response = catalogServiceClient.updateCatalogItem(formattedName, catalogItem);
   * }
   * </code></pre>
   *
   * @param name Required. Full resource name of catalog item, such as
   *     "projects/&#42;/locations/global/catalogs/default_catalog/catalogItems/some_catalog_item_id".
   * @param catalogItem Required. The catalog item to update/create. The 'catalog_item_id' field has
   *     to match that in the 'name'.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CatalogItem updateCatalogItem(String name, CatalogItem catalogItem) {
    CATALOG_ITEM_PATH_PATH_TEMPLATE.validate(name, "updateCatalogItem");
    UpdateCatalogItemRequest request =
        UpdateCatalogItemRequest.newBuilder().setName(name).setCatalogItem(catalogItem).build();
    return updateCatalogItem(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a catalog item. Partial updating is supported. Non-existing items will be created.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String formattedName = CatalogServiceClient.formatCatalogItemPathName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");
   *   CatalogItem catalogItem = CatalogItem.newBuilder().build();
   *   UpdateCatalogItemRequest request = UpdateCatalogItemRequest.newBuilder()
   *     .setName(formattedName)
   *     .setCatalogItem(catalogItem)
   *     .build();
   *   CatalogItem response = catalogServiceClient.updateCatalogItem(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final CatalogItem updateCatalogItem(UpdateCatalogItemRequest request) {
    return updateCatalogItemCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Updates a catalog item. Partial updating is supported. Non-existing items will be created.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String formattedName = CatalogServiceClient.formatCatalogItemPathName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");
   *   CatalogItem catalogItem = CatalogItem.newBuilder().build();
   *   UpdateCatalogItemRequest request = UpdateCatalogItemRequest.newBuilder()
   *     .setName(formattedName)
   *     .setCatalogItem(catalogItem)
   *     .build();
   *   ApiFuture&lt;CatalogItem&gt; future = catalogServiceClient.updateCatalogItemCallable().futureCall(request);
   *   // Do something
   *   CatalogItem response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<UpdateCatalogItemRequest, CatalogItem> updateCatalogItemCallable() {
    return stub.updateCatalogItemCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a catalog item.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String formattedName = CatalogServiceClient.formatCatalogItemPathName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");
   *   catalogServiceClient.deleteCatalogItem(formattedName);
   * }
   * </code></pre>
   *
   * @param name Required. Full resource name of catalog item, such as
   *     "projects/&#42;/locations/global/catalogs/default_catalog/catalogItems/some_catalog_item_id".
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCatalogItem(String name) {
    CATALOG_ITEM_PATH_PATH_TEMPLATE.validate(name, "deleteCatalogItem");
    DeleteCatalogItemRequest request = DeleteCatalogItemRequest.newBuilder().setName(name).build();
    deleteCatalogItem(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a catalog item.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String formattedName = CatalogServiceClient.formatCatalogItemPathName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");
   *   DeleteCatalogItemRequest request = DeleteCatalogItemRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   catalogServiceClient.deleteCatalogItem(request);
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteCatalogItem(DeleteCatalogItemRequest request) {
    deleteCatalogItemCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Deletes a catalog item.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String formattedName = CatalogServiceClient.formatCatalogItemPathName("[PROJECT]", "[LOCATION]", "[CATALOG]", "[CATALOG_ITEM_PATH]");
   *   DeleteCatalogItemRequest request = DeleteCatalogItemRequest.newBuilder()
   *     .setName(formattedName)
   *     .build();
   *   ApiFuture&lt;Void&gt; future = catalogServiceClient.deleteCatalogItemCallable().futureCall(request);
   *   // Do something
   *   future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<DeleteCatalogItemRequest, Empty> deleteCatalogItemCallable() {
    return stub.deleteCatalogItemCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Bulk import of multiple catalog items. Request processing may be synchronous. No partial
   * updating supported. Non-existing items will be created.
   *
   * <p>Operation.response is of type ImportResponse. Note that it is possible for a subset of the
   * items to be successfully updated.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String formattedParent = CatalogServiceClient.formatCatalogName("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   String requestId = "";
   *   InputConfig inputConfig = InputConfig.newBuilder().build();
   *   ImportErrorsConfig errorsConfig = ImportErrorsConfig.newBuilder().build();
   *   ImportCatalogItemsResponse response = catalogServiceClient.importCatalogItemsAsync(formattedParent, requestId, inputConfig, errorsConfig).get();
   * }
   * </code></pre>
   *
   * @param parent Required. "projects/1234/locations/global/catalogs/default_catalog"
   * @param requestId Optional. Unique identifier provided by client, within the ancestor dataset
   *     scope. Ensures idempotency and used for request deduplication. Server-generated if
   *     unspecified. Up to 128 characters long. This is returned as
   *     google.longrunning.Operation.name in the response.
   * @param inputConfig Required. The desired input location of the data.
   * @param errorsConfig Optional. The desired location of errors incurred during the Import.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<ImportCatalogItemsResponse, ImportMetadata> importCatalogItemsAsync(
      String parent, String requestId, InputConfig inputConfig, ImportErrorsConfig errorsConfig) {
    CATALOG_PATH_TEMPLATE.validate(parent, "importCatalogItems");
    ImportCatalogItemsRequest request =
        ImportCatalogItemsRequest.newBuilder()
            .setParent(parent)
            .setRequestId(requestId)
            .setInputConfig(inputConfig)
            .setErrorsConfig(errorsConfig)
            .build();
    return importCatalogItemsAsync(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Bulk import of multiple catalog items. Request processing may be synchronous. No partial
   * updating supported. Non-existing items will be created.
   *
   * <p>Operation.response is of type ImportResponse. Note that it is possible for a subset of the
   * items to be successfully updated.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String formattedParent = CatalogServiceClient.formatCatalogName("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   InputConfig inputConfig = InputConfig.newBuilder().build();
   *   ImportCatalogItemsRequest request = ImportCatalogItemsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setInputConfig(inputConfig)
   *     .build();
   *   ImportCatalogItemsResponse response = catalogServiceClient.importCatalogItemsAsync(request).get();
   * }
   * </code></pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  @BetaApi(
      "The surface for long-running operations is not stable yet and may change in the future.")
  public final OperationFuture<ImportCatalogItemsResponse, ImportMetadata> importCatalogItemsAsync(
      ImportCatalogItemsRequest request) {
    return importCatalogItemsOperationCallable().futureCall(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Bulk import of multiple catalog items. Request processing may be synchronous. No partial
   * updating supported. Non-existing items will be created.
   *
   * <p>Operation.response is of type ImportResponse. Note that it is possible for a subset of the
   * items to be successfully updated.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String formattedParent = CatalogServiceClient.formatCatalogName("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   InputConfig inputConfig = InputConfig.newBuilder().build();
   *   ImportCatalogItemsRequest request = ImportCatalogItemsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setInputConfig(inputConfig)
   *     .build();
   *   OperationFuture&lt;ImportCatalogItemsResponse, ImportMetadata&gt; future = catalogServiceClient.importCatalogItemsOperationCallable().futureCall(request);
   *   // Do something
   *   ImportCatalogItemsResponse response = future.get();
   * }
   * </code></pre>
   */
  @BetaApi("The surface for use by generated code is not stable yet and may change in the future.")
  public final OperationCallable<
          ImportCatalogItemsRequest, ImportCatalogItemsResponse, ImportMetadata>
      importCatalogItemsOperationCallable() {
    return stub.importCatalogItemsOperationCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD
  /**
   * Bulk import of multiple catalog items. Request processing may be synchronous. No partial
   * updating supported. Non-existing items will be created.
   *
   * <p>Operation.response is of type ImportResponse. Note that it is possible for a subset of the
   * items to be successfully updated.
   *
   * <p>Sample code:
   *
   * <pre><code>
   * try (CatalogServiceClient catalogServiceClient = CatalogServiceClient.create()) {
   *   String formattedParent = CatalogServiceClient.formatCatalogName("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   InputConfig inputConfig = InputConfig.newBuilder().build();
   *   ImportCatalogItemsRequest request = ImportCatalogItemsRequest.newBuilder()
   *     .setParent(formattedParent)
   *     .setInputConfig(inputConfig)
   *     .build();
   *   ApiFuture&lt;Operation&gt; future = catalogServiceClient.importCatalogItemsCallable().futureCall(request);
   *   // Do something
   *   Operation response = future.get();
   * }
   * </code></pre>
   */
  public final UnaryCallable<ImportCatalogItemsRequest, Operation> importCatalogItemsCallable() {
    return stub.importCatalogItemsCallable();
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

  public static class ListCatalogItemsPagedResponse
      extends AbstractPagedListResponse<
          ListCatalogItemsRequest,
          ListCatalogItemsResponse,
          CatalogItem,
          ListCatalogItemsPage,
          ListCatalogItemsFixedSizeCollection> {

    public static ApiFuture<ListCatalogItemsPagedResponse> createAsync(
        PageContext<ListCatalogItemsRequest, ListCatalogItemsResponse, CatalogItem> context,
        ApiFuture<ListCatalogItemsResponse> futureResponse) {
      ApiFuture<ListCatalogItemsPage> futurePage =
          ListCatalogItemsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListCatalogItemsPage, ListCatalogItemsPagedResponse>() {
            @Override
            public ListCatalogItemsPagedResponse apply(ListCatalogItemsPage input) {
              return new ListCatalogItemsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListCatalogItemsPagedResponse(ListCatalogItemsPage page) {
      super(page, ListCatalogItemsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCatalogItemsPage
      extends AbstractPage<
          ListCatalogItemsRequest, ListCatalogItemsResponse, CatalogItem, ListCatalogItemsPage> {

    private ListCatalogItemsPage(
        PageContext<ListCatalogItemsRequest, ListCatalogItemsResponse, CatalogItem> context,
        ListCatalogItemsResponse response) {
      super(context, response);
    }

    private static ListCatalogItemsPage createEmptyPage() {
      return new ListCatalogItemsPage(null, null);
    }

    @Override
    protected ListCatalogItemsPage createPage(
        PageContext<ListCatalogItemsRequest, ListCatalogItemsResponse, CatalogItem> context,
        ListCatalogItemsResponse response) {
      return new ListCatalogItemsPage(context, response);
    }

    @Override
    public ApiFuture<ListCatalogItemsPage> createPageAsync(
        PageContext<ListCatalogItemsRequest, ListCatalogItemsResponse, CatalogItem> context,
        ApiFuture<ListCatalogItemsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCatalogItemsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCatalogItemsRequest,
          ListCatalogItemsResponse,
          CatalogItem,
          ListCatalogItemsPage,
          ListCatalogItemsFixedSizeCollection> {

    private ListCatalogItemsFixedSizeCollection(
        List<ListCatalogItemsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCatalogItemsFixedSizeCollection createEmptyCollection() {
      return new ListCatalogItemsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCatalogItemsFixedSizeCollection createCollection(
        List<ListCatalogItemsPage> pages, int collectionSize) {
      return new ListCatalogItemsFixedSizeCollection(pages, collectionSize);
    }
  }
}
