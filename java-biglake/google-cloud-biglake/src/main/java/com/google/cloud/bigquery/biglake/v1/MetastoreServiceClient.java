/*
 * Copyright 2023 Google LLC
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

package com.google.cloud.bigquery.biglake.v1;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.bigquery.biglake.v1.stub.MetastoreServiceStub;
import com.google.cloud.bigquery.biglake.v1.stub.MetastoreServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: BigLake Metastore is a serverless, highly available, multi-tenant runtime
 * metastore for Google Cloud Data Analytics products.
 *
 * <p>The BigLake Metastore API defines the following resource model:
 *
 * <ul>
 *   <li>A collection of Google Cloud projects: `/projects/&#42;`
 *   <li>Each project has a collection of available locations: `/locations/&#42;`
 *   <li>Each location has a collection of catalogs: `/catalogs/&#42;`
 *   <li>Each catalog has a collection of databases: `/databases/&#42;`
 *   <li>Each database has a collection of tables: `/tables/&#42;`
 * </ul>
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
 * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
 *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
 *   Catalog catalog = Catalog.newBuilder().build();
 *   String catalogId = "catalogId1455933204";
 *   Catalog response = metastoreServiceClient.createCatalog(parent, catalog, catalogId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the MetastoreServiceClient object to clean up resources
 * such as threads. In the example above, try-with-resources is used, which automatically calls
 * close().
 *
 * <table>
 *    <caption>Methods</caption>
 *    <tr>
 *      <th>Method</th>
 *      <th>Description</th>
 *      <th>Method Variants</th>
 *    </tr>
 *    <tr>
 *      <td><p> CreateCatalog</td>
 *      <td><p> Creates a new catalog.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createCatalog(CreateCatalogRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createCatalog(LocationName parent, Catalog catalog, String catalogId)
 *           <li><p> createCatalog(String parent, Catalog catalog, String catalogId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createCatalogCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteCatalog</td>
 *      <td><p> Deletes an existing catalog specified by the catalog ID.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteCatalog(DeleteCatalogRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteCatalog(CatalogName name)
 *           <li><p> deleteCatalog(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteCatalogCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetCatalog</td>
 *      <td><p> Gets the catalog specified by the resource name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getCatalog(GetCatalogRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getCatalog(CatalogName name)
 *           <li><p> getCatalog(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getCatalogCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListCatalogs</td>
 *      <td><p> List all catalogs in a specified project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listCatalogs(ListCatalogsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listCatalogs(LocationName parent)
 *           <li><p> listCatalogs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listCatalogsPagedCallable()
 *           <li><p> listCatalogsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDatabase</td>
 *      <td><p> Creates a new database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDatabase(CreateDatabaseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createDatabase(CatalogName parent, Database database, String databaseId)
 *           <li><p> createDatabase(String parent, Database database, String databaseId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDatabase</td>
 *      <td><p> Deletes an existing database specified by the database ID.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDatabase(DeleteDatabaseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteDatabase(DatabaseName name)
 *           <li><p> deleteDatabase(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDatabase</td>
 *      <td><p> Updates an existing database specified by the database ID.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDatabase(UpdateDatabaseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDatabase(Database database, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDatabase</td>
 *      <td><p> Gets the database specified by the resource name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDatabase(GetDatabaseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDatabase(DatabaseName name)
 *           <li><p> getDatabase(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDatabases</td>
 *      <td><p> List all databases in a specified catalog.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDatabases(ListDatabasesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDatabases(CatalogName parent)
 *           <li><p> listDatabases(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDatabasesPagedCallable()
 *           <li><p> listDatabasesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateTable</td>
 *      <td><p> Creates a new table.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createTable(CreateTableRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createTable(DatabaseName parent, Table table, String tableId)
 *           <li><p> createTable(String parent, Table table, String tableId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createTableCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteTable</td>
 *      <td><p> Deletes an existing table specified by the table ID.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteTable(DeleteTableRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteTable(TableName name)
 *           <li><p> deleteTable(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteTableCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateTable</td>
 *      <td><p> Updates an existing table specified by the table ID.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateTable(UpdateTableRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateTable(Table table, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateTableCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> RenameTable</td>
 *      <td><p> Renames an existing table specified by the table ID.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> renameTable(RenameTableRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> renameTable(TableName name, TableName newName)
 *           <li><p> renameTable(TableName name, String newName)
 *           <li><p> renameTable(String name, TableName newName)
 *           <li><p> renameTable(String name, String newName)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> renameTableCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetTable</td>
 *      <td><p> Gets the table specified by the resource name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getTable(GetTableRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getTable(TableName name)
 *           <li><p> getTable(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getTableCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListTables</td>
 *      <td><p> List all tables in a specified database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listTables(ListTablesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listTables(DatabaseName parent)
 *           <li><p> listTables(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listTablesPagedCallable()
 *           <li><p> listTablesCallable()
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
 * <p>This class can be customized by passing in a custom instance of MetastoreServiceSettings to
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
 * MetastoreServiceSettings metastoreServiceSettings =
 *     MetastoreServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * MetastoreServiceClient metastoreServiceClient =
 *     MetastoreServiceClient.create(metastoreServiceSettings);
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
 * MetastoreServiceSettings metastoreServiceSettings =
 *     MetastoreServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * MetastoreServiceClient metastoreServiceClient =
 *     MetastoreServiceClient.create(metastoreServiceSettings);
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
 * MetastoreServiceSettings metastoreServiceSettings =
 *     MetastoreServiceSettings.newHttpJsonBuilder().build();
 * MetastoreServiceClient metastoreServiceClient =
 *     MetastoreServiceClient.create(metastoreServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class MetastoreServiceClient implements BackgroundResource {
  private final MetastoreServiceSettings settings;
  private final MetastoreServiceStub stub;

  /** Constructs an instance of MetastoreServiceClient with default settings. */
  public static final MetastoreServiceClient create() throws IOException {
    return create(MetastoreServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of MetastoreServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final MetastoreServiceClient create(MetastoreServiceSettings settings)
      throws IOException {
    return new MetastoreServiceClient(settings);
  }

  /**
   * Constructs an instance of MetastoreServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(MetastoreServiceSettings).
   */
  public static final MetastoreServiceClient create(MetastoreServiceStub stub) {
    return new MetastoreServiceClient(stub);
  }

  /**
   * Constructs an instance of MetastoreServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected MetastoreServiceClient(MetastoreServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((MetastoreServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected MetastoreServiceClient(MetastoreServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final MetastoreServiceSettings getSettings() {
    return settings;
  }

  public MetastoreServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   Catalog catalog = Catalog.newBuilder().build();
   *   String catalogId = "catalogId1455933204";
   *   Catalog response = metastoreServiceClient.createCatalog(parent, catalog, catalogId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this catalog will be created. Format:
   *     projects/{project_id_or_number}/locations/{location_id}
   * @param catalog Required. The catalog to create. The `name` field does not need to be provided.
   * @param catalogId Required. The ID to use for the catalog, which will become the final component
   *     of the catalog's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Catalog createCatalog(LocationName parent, Catalog catalog, String catalogId) {
    CreateCatalogRequest request =
        CreateCatalogRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setCatalog(catalog)
            .setCatalogId(catalogId)
            .build();
    return createCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   Catalog catalog = Catalog.newBuilder().build();
   *   String catalogId = "catalogId1455933204";
   *   Catalog response = metastoreServiceClient.createCatalog(parent, catalog, catalogId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this catalog will be created. Format:
   *     projects/{project_id_or_number}/locations/{location_id}
   * @param catalog Required. The catalog to create. The `name` field does not need to be provided.
   * @param catalogId Required. The ID to use for the catalog, which will become the final component
   *     of the catalog's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Catalog createCatalog(String parent, Catalog catalog, String catalogId) {
    CreateCatalogRequest request =
        CreateCatalogRequest.newBuilder()
            .setParent(parent)
            .setCatalog(catalog)
            .setCatalogId(catalogId)
            .build();
    return createCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   CreateCatalogRequest request =
   *       CreateCatalogRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCatalog(Catalog.newBuilder().build())
   *           .setCatalogId("catalogId1455933204")
   *           .build();
   *   Catalog response = metastoreServiceClient.createCatalog(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Catalog createCatalog(CreateCatalogRequest request) {
    return createCatalogCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   CreateCatalogRequest request =
   *       CreateCatalogRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setCatalog(Catalog.newBuilder().build())
   *           .setCatalogId("catalogId1455933204")
   *           .build();
   *   ApiFuture<Catalog> future =
   *       metastoreServiceClient.createCatalogCallable().futureCall(request);
   *   // Do something.
   *   Catalog response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateCatalogRequest, Catalog> createCatalogCallable() {
    return stub.createCatalogCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing catalog specified by the catalog ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   CatalogName name = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   Catalog response = metastoreServiceClient.deleteCatalog(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the catalog to delete. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Catalog deleteCatalog(CatalogName name) {
    DeleteCatalogRequest request =
        DeleteCatalogRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing catalog specified by the catalog ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   String name = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString();
   *   Catalog response = metastoreServiceClient.deleteCatalog(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the catalog to delete. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Catalog deleteCatalog(String name) {
    DeleteCatalogRequest request = DeleteCatalogRequest.newBuilder().setName(name).build();
    return deleteCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing catalog specified by the catalog ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   DeleteCatalogRequest request =
   *       DeleteCatalogRequest.newBuilder()
   *           .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .build();
   *   Catalog response = metastoreServiceClient.deleteCatalog(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Catalog deleteCatalog(DeleteCatalogRequest request) {
    return deleteCatalogCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing catalog specified by the catalog ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   DeleteCatalogRequest request =
   *       DeleteCatalogRequest.newBuilder()
   *           .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .build();
   *   ApiFuture<Catalog> future =
   *       metastoreServiceClient.deleteCatalogCallable().futureCall(request);
   *   // Do something.
   *   Catalog response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteCatalogRequest, Catalog> deleteCatalogCallable() {
    return stub.deleteCatalogCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the catalog specified by the resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   CatalogName name = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   Catalog response = metastoreServiceClient.getCatalog(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the catalog to retrieve. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Catalog getCatalog(CatalogName name) {
    GetCatalogRequest request =
        GetCatalogRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the catalog specified by the resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   String name = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString();
   *   Catalog response = metastoreServiceClient.getCatalog(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the catalog to retrieve. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Catalog getCatalog(String name) {
    GetCatalogRequest request = GetCatalogRequest.newBuilder().setName(name).build();
    return getCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the catalog specified by the resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   GetCatalogRequest request =
   *       GetCatalogRequest.newBuilder()
   *           .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .build();
   *   Catalog response = metastoreServiceClient.getCatalog(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Catalog getCatalog(GetCatalogRequest request) {
    return getCatalogCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the catalog specified by the resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   GetCatalogRequest request =
   *       GetCatalogRequest.newBuilder()
   *           .setName(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .build();
   *   ApiFuture<Catalog> future = metastoreServiceClient.getCatalogCallable().futureCall(request);
   *   // Do something.
   *   Catalog response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetCatalogRequest, Catalog> getCatalogCallable() {
    return stub.getCatalogCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all catalogs in a specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   LocationName parent = LocationName.of("[PROJECT]", "[LOCATION]");
   *   for (Catalog element : metastoreServiceClient.listCatalogs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of catalogs. Format:
   *     projects/{project_id_or_number}/locations/{location_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCatalogsPagedResponse listCatalogs(LocationName parent) {
    ListCatalogsRequest request =
        ListCatalogsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listCatalogs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all catalogs in a specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   String parent = LocationName.of("[PROJECT]", "[LOCATION]").toString();
   *   for (Catalog element : metastoreServiceClient.listCatalogs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of catalogs. Format:
   *     projects/{project_id_or_number}/locations/{location_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCatalogsPagedResponse listCatalogs(String parent) {
    ListCatalogsRequest request = ListCatalogsRequest.newBuilder().setParent(parent).build();
    return listCatalogs(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all catalogs in a specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   ListCatalogsRequest request =
   *       ListCatalogsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Catalog element : metastoreServiceClient.listCatalogs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListCatalogsPagedResponse listCatalogs(ListCatalogsRequest request) {
    return listCatalogsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all catalogs in a specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   ListCatalogsRequest request =
   *       ListCatalogsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Catalog> future =
   *       metastoreServiceClient.listCatalogsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Catalog element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListCatalogsRequest, ListCatalogsPagedResponse>
      listCatalogsPagedCallable() {
    return stub.listCatalogsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all catalogs in a specified project.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   ListCatalogsRequest request =
   *       ListCatalogsRequest.newBuilder()
   *           .setParent(LocationName.of("[PROJECT]", "[LOCATION]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListCatalogsResponse response = metastoreServiceClient.listCatalogsCallable().call(request);
   *     for (Catalog element : response.getCatalogsList()) {
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
  public final UnaryCallable<ListCatalogsRequest, ListCatalogsResponse> listCatalogsCallable() {
    return stub.listCatalogsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   Database database = Database.newBuilder().build();
   *   String databaseId = "databaseId1688905718";
   *   Database response = metastoreServiceClient.createDatabase(parent, database, databaseId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this database will be created. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}
   * @param database Required. The database to create. The `name` field does not need to be
   *     provided.
   * @param databaseId Required. The ID to use for the database, which will become the final
   *     component of the database's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Database createDatabase(CatalogName parent, Database database, String databaseId) {
    CreateDatabaseRequest request =
        CreateDatabaseRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDatabase(database)
            .setDatabaseId(databaseId)
            .build();
    return createDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   String parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString();
   *   Database database = Database.newBuilder().build();
   *   String databaseId = "databaseId1688905718";
   *   Database response = metastoreServiceClient.createDatabase(parent, database, databaseId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this database will be created. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}
   * @param database Required. The database to create. The `name` field does not need to be
   *     provided.
   * @param databaseId Required. The ID to use for the database, which will become the final
   *     component of the database's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Database createDatabase(String parent, Database database, String databaseId) {
    CreateDatabaseRequest request =
        CreateDatabaseRequest.newBuilder()
            .setParent(parent)
            .setDatabase(database)
            .setDatabaseId(databaseId)
            .build();
    return createDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   CreateDatabaseRequest request =
   *       CreateDatabaseRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setDatabase(Database.newBuilder().build())
   *           .setDatabaseId("databaseId1688905718")
   *           .build();
   *   Database response = metastoreServiceClient.createDatabase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Database createDatabase(CreateDatabaseRequest request) {
    return createDatabaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   CreateDatabaseRequest request =
   *       CreateDatabaseRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setDatabase(Database.newBuilder().build())
   *           .setDatabaseId("databaseId1688905718")
   *           .build();
   *   ApiFuture<Database> future =
   *       metastoreServiceClient.createDatabaseCallable().futureCall(request);
   *   // Do something.
   *   Database response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDatabaseRequest, Database> createDatabaseCallable() {
    return stub.createDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing database specified by the database ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   DatabaseName name = DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]");
   *   Database response = metastoreServiceClient.deleteDatabase(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the database to delete. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Database deleteDatabase(DatabaseName name) {
    DeleteDatabaseRequest request =
        DeleteDatabaseRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing database specified by the database ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   String name =
   *       DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]").toString();
   *   Database response = metastoreServiceClient.deleteDatabase(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the database to delete. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Database deleteDatabase(String name) {
    DeleteDatabaseRequest request = DeleteDatabaseRequest.newBuilder().setName(name).build();
    return deleteDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing database specified by the database ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   DeleteDatabaseRequest request =
   *       DeleteDatabaseRequest.newBuilder()
   *           .setName(
   *               DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]").toString())
   *           .build();
   *   Database response = metastoreServiceClient.deleteDatabase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Database deleteDatabase(DeleteDatabaseRequest request) {
    return deleteDatabaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing database specified by the database ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   DeleteDatabaseRequest request =
   *       DeleteDatabaseRequest.newBuilder()
   *           .setName(
   *               DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]").toString())
   *           .build();
   *   ApiFuture<Database> future =
   *       metastoreServiceClient.deleteDatabaseCallable().futureCall(request);
   *   // Do something.
   *   Database response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDatabaseRequest, Database> deleteDatabaseCallable() {
    return stub.deleteDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing database specified by the database ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   Database database = Database.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Database response = metastoreServiceClient.updateDatabase(database, updateMask);
   * }
   * }</pre>
   *
   * @param database Required. The database to update.
   *     <p>The database's `name` field is used to identify the database to update. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}
   * @param updateMask The list of fields to update.
   *     <p>For the `FieldMask` definition, see
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask If
   *     not set, defaults to all of the fields that are allowed to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Database updateDatabase(Database database, FieldMask updateMask) {
    UpdateDatabaseRequest request =
        UpdateDatabaseRequest.newBuilder().setDatabase(database).setUpdateMask(updateMask).build();
    return updateDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing database specified by the database ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   UpdateDatabaseRequest request =
   *       UpdateDatabaseRequest.newBuilder()
   *           .setDatabase(Database.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Database response = metastoreServiceClient.updateDatabase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Database updateDatabase(UpdateDatabaseRequest request) {
    return updateDatabaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing database specified by the database ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   UpdateDatabaseRequest request =
   *       UpdateDatabaseRequest.newBuilder()
   *           .setDatabase(Database.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Database> future =
   *       metastoreServiceClient.updateDatabaseCallable().futureCall(request);
   *   // Do something.
   *   Database response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDatabaseRequest, Database> updateDatabaseCallable() {
    return stub.updateDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the database specified by the resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   DatabaseName name = DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]");
   *   Database response = metastoreServiceClient.getDatabase(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the database to retrieve. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Database getDatabase(DatabaseName name) {
    GetDatabaseRequest request =
        GetDatabaseRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the database specified by the resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   String name =
   *       DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]").toString();
   *   Database response = metastoreServiceClient.getDatabase(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the database to retrieve. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Database getDatabase(String name) {
    GetDatabaseRequest request = GetDatabaseRequest.newBuilder().setName(name).build();
    return getDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the database specified by the resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   GetDatabaseRequest request =
   *       GetDatabaseRequest.newBuilder()
   *           .setName(
   *               DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]").toString())
   *           .build();
   *   Database response = metastoreServiceClient.getDatabase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Database getDatabase(GetDatabaseRequest request) {
    return getDatabaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the database specified by the resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   GetDatabaseRequest request =
   *       GetDatabaseRequest.newBuilder()
   *           .setName(
   *               DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]").toString())
   *           .build();
   *   ApiFuture<Database> future = metastoreServiceClient.getDatabaseCallable().futureCall(request);
   *   // Do something.
   *   Database response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDatabaseRequest, Database> getDatabaseCallable() {
    return stub.getDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all databases in a specified catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   CatalogName parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]");
   *   for (Database element : metastoreServiceClient.listDatabases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of databases. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabasesPagedResponse listDatabases(CatalogName parent) {
    ListDatabasesRequest request =
        ListDatabasesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDatabases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all databases in a specified catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   String parent = CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString();
   *   for (Database element : metastoreServiceClient.listDatabases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of databases. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabasesPagedResponse listDatabases(String parent) {
    ListDatabasesRequest request = ListDatabasesRequest.newBuilder().setParent(parent).build();
    return listDatabases(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all databases in a specified catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   ListDatabasesRequest request =
   *       ListDatabasesRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Database element : metastoreServiceClient.listDatabases(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDatabasesPagedResponse listDatabases(ListDatabasesRequest request) {
    return listDatabasesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all databases in a specified catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   ListDatabasesRequest request =
   *       ListDatabasesRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Database> future =
   *       metastoreServiceClient.listDatabasesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Database element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDatabasesRequest, ListDatabasesPagedResponse>
      listDatabasesPagedCallable() {
    return stub.listDatabasesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all databases in a specified catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   ListDatabasesRequest request =
   *       ListDatabasesRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[LOCATION]", "[CATALOG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDatabasesResponse response =
   *         metastoreServiceClient.listDatabasesCallable().call(request);
   *     for (Database element : response.getDatabasesList()) {
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
  public final UnaryCallable<ListDatabasesRequest, ListDatabasesResponse> listDatabasesCallable() {
    return stub.listDatabasesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   DatabaseName parent = DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]");
   *   Table table = Table.newBuilder().build();
   *   String tableId = "tableId-1552905847";
   *   Table response = metastoreServiceClient.createTable(parent, table, tableId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this table will be created. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}
   * @param table Required. The table to create. The `name` field does not need to be provided for
   *     the table creation.
   * @param tableId Required. The ID to use for the table, which will become the final component of
   *     the table's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table createTable(DatabaseName parent, Table table, String tableId) {
    CreateTableRequest request =
        CreateTableRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setTable(table)
            .setTableId(tableId)
            .build();
    return createTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   String parent =
   *       DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]").toString();
   *   Table table = Table.newBuilder().build();
   *   String tableId = "tableId-1552905847";
   *   Table response = metastoreServiceClient.createTable(parent, table, tableId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this table will be created. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}
   * @param table Required. The table to create. The `name` field does not need to be provided for
   *     the table creation.
   * @param tableId Required. The ID to use for the table, which will become the final component of
   *     the table's resource name.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table createTable(String parent, Table table, String tableId) {
    CreateTableRequest request =
        CreateTableRequest.newBuilder()
            .setParent(parent)
            .setTable(table)
            .setTableId(tableId)
            .build();
    return createTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   CreateTableRequest request =
   *       CreateTableRequest.newBuilder()
   *           .setParent(
   *               DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]").toString())
   *           .setTable(Table.newBuilder().build())
   *           .setTableId("tableId-1552905847")
   *           .build();
   *   Table response = metastoreServiceClient.createTable(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table createTable(CreateTableRequest request) {
    return createTableCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   CreateTableRequest request =
   *       CreateTableRequest.newBuilder()
   *           .setParent(
   *               DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]").toString())
   *           .setTable(Table.newBuilder().build())
   *           .setTableId("tableId-1552905847")
   *           .build();
   *   ApiFuture<Table> future = metastoreServiceClient.createTableCallable().futureCall(request);
   *   // Do something.
   *   Table response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateTableRequest, Table> createTableCallable() {
    return stub.createTableCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing table specified by the table ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   TableName name =
   *       TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]");
   *   Table response = metastoreServiceClient.deleteTable(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the table to delete. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}/tables/{table_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table deleteTable(TableName name) {
    DeleteTableRequest request =
        DeleteTableRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return deleteTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing table specified by the table ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   String name =
   *       TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString();
   *   Table response = metastoreServiceClient.deleteTable(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the table to delete. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}/tables/{table_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table deleteTable(String name) {
    DeleteTableRequest request = DeleteTableRequest.newBuilder().setName(name).build();
    return deleteTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing table specified by the table ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   DeleteTableRequest request =
   *       DeleteTableRequest.newBuilder()
   *           .setName(
   *               TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]")
   *                   .toString())
   *           .build();
   *   Table response = metastoreServiceClient.deleteTable(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table deleteTable(DeleteTableRequest request) {
    return deleteTableCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing table specified by the table ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   DeleteTableRequest request =
   *       DeleteTableRequest.newBuilder()
   *           .setName(
   *               TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Table> future = metastoreServiceClient.deleteTableCallable().futureCall(request);
   *   // Do something.
   *   Table response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteTableRequest, Table> deleteTableCallable() {
    return stub.deleteTableCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing table specified by the table ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   Table table = Table.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Table response = metastoreServiceClient.updateTable(table, updateMask);
   * }
   * }</pre>
   *
   * @param table Required. The table to update.
   *     <p>The table's `name` field is used to identify the table to update. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}/tables/{table_id}
   * @param updateMask The list of fields to update.
   *     <p>For the `FieldMask` definition, see
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask If
   *     not set, defaults to all of the fields that are allowed to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table updateTable(Table table, FieldMask updateMask) {
    UpdateTableRequest request =
        UpdateTableRequest.newBuilder().setTable(table).setUpdateMask(updateMask).build();
    return updateTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing table specified by the table ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   UpdateTableRequest request =
   *       UpdateTableRequest.newBuilder()
   *           .setTable(Table.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Table response = metastoreServiceClient.updateTable(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table updateTable(UpdateTableRequest request) {
    return updateTableCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing table specified by the table ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   UpdateTableRequest request =
   *       UpdateTableRequest.newBuilder()
   *           .setTable(Table.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Table> future = metastoreServiceClient.updateTableCallable().futureCall(request);
   *   // Do something.
   *   Table response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateTableRequest, Table> updateTableCallable() {
    return stub.updateTableCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames an existing table specified by the table ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   TableName name =
   *       TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]");
   *   TableName newName =
   *       TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]");
   *   Table response = metastoreServiceClient.renameTable(name, newName);
   * }
   * }</pre>
   *
   * @param name Required. The table's `name` field is used to identify the table to rename. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}/tables/{table_id}
   * @param newName Required. The new `name` for the specified table, must be in the same database.
   *     Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}/tables/{table_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table renameTable(TableName name, TableName newName) {
    RenameTableRequest request =
        RenameTableRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setNewName(newName == null ? null : newName.toString())
            .build();
    return renameTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames an existing table specified by the table ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   TableName name =
   *       TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]");
   *   String newName =
   *       TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString();
   *   Table response = metastoreServiceClient.renameTable(name, newName);
   * }
   * }</pre>
   *
   * @param name Required. The table's `name` field is used to identify the table to rename. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}/tables/{table_id}
   * @param newName Required. The new `name` for the specified table, must be in the same database.
   *     Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}/tables/{table_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table renameTable(TableName name, String newName) {
    RenameTableRequest request =
        RenameTableRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setNewName(newName)
            .build();
    return renameTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames an existing table specified by the table ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   String name =
   *       TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString();
   *   TableName newName =
   *       TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]");
   *   Table response = metastoreServiceClient.renameTable(name, newName);
   * }
   * }</pre>
   *
   * @param name Required. The table's `name` field is used to identify the table to rename. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}/tables/{table_id}
   * @param newName Required. The new `name` for the specified table, must be in the same database.
   *     Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}/tables/{table_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table renameTable(String name, TableName newName) {
    RenameTableRequest request =
        RenameTableRequest.newBuilder()
            .setName(name)
            .setNewName(newName == null ? null : newName.toString())
            .build();
    return renameTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames an existing table specified by the table ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   String name =
   *       TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString();
   *   String newName =
   *       TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString();
   *   Table response = metastoreServiceClient.renameTable(name, newName);
   * }
   * }</pre>
   *
   * @param name Required. The table's `name` field is used to identify the table to rename. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}/tables/{table_id}
   * @param newName Required. The new `name` for the specified table, must be in the same database.
   *     Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}/tables/{table_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table renameTable(String name, String newName) {
    RenameTableRequest request =
        RenameTableRequest.newBuilder().setName(name).setNewName(newName).build();
    return renameTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames an existing table specified by the table ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   RenameTableRequest request =
   *       RenameTableRequest.newBuilder()
   *           .setName(
   *               TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]")
   *                   .toString())
   *           .setNewName(
   *               TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]")
   *                   .toString())
   *           .build();
   *   Table response = metastoreServiceClient.renameTable(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table renameTable(RenameTableRequest request) {
    return renameTableCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Renames an existing table specified by the table ID.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   RenameTableRequest request =
   *       RenameTableRequest.newBuilder()
   *           .setName(
   *               TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]")
   *                   .toString())
   *           .setNewName(
   *               TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Table> future = metastoreServiceClient.renameTableCallable().futureCall(request);
   *   // Do something.
   *   Table response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<RenameTableRequest, Table> renameTableCallable() {
    return stub.renameTableCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the table specified by the resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   TableName name =
   *       TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]");
   *   Table response = metastoreServiceClient.getTable(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the table to retrieve. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}/tables/{table_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table getTable(TableName name) {
    GetTableRequest request =
        GetTableRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the table specified by the resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   String name =
   *       TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString();
   *   Table response = metastoreServiceClient.getTable(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the table to retrieve. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}/tables/{table_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table getTable(String name) {
    GetTableRequest request = GetTableRequest.newBuilder().setName(name).build();
    return getTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the table specified by the resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   GetTableRequest request =
   *       GetTableRequest.newBuilder()
   *           .setName(
   *               TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]")
   *                   .toString())
   *           .build();
   *   Table response = metastoreServiceClient.getTable(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table getTable(GetTableRequest request) {
    return getTableCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets the table specified by the resource name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   GetTableRequest request =
   *       GetTableRequest.newBuilder()
   *           .setName(
   *               TableName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]", "[TABLE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Table> future = metastoreServiceClient.getTableCallable().futureCall(request);
   *   // Do something.
   *   Table response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetTableRequest, Table> getTableCallable() {
    return stub.getTableCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all tables in a specified database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   DatabaseName parent = DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]");
   *   for (Table element : metastoreServiceClient.listTables(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of tables. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTablesPagedResponse listTables(DatabaseName parent) {
    ListTablesRequest request =
        ListTablesRequest.newBuilder().setParent(parent == null ? null : parent.toString()).build();
    return listTables(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all tables in a specified database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   String parent =
   *       DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]").toString();
   *   for (Table element : metastoreServiceClient.listTables(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent, which owns this collection of tables. Format:
   *     projects/{project_id_or_number}/locations/{location_id}/catalogs/{catalog_id}/databases/{database_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTablesPagedResponse listTables(String parent) {
    ListTablesRequest request = ListTablesRequest.newBuilder().setParent(parent).build();
    return listTables(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all tables in a specified database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   ListTablesRequest request =
   *       ListTablesRequest.newBuilder()
   *           .setParent(
   *               DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(TableView.forNumber(0))
   *           .build();
   *   for (Table element : metastoreServiceClient.listTables(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListTablesPagedResponse listTables(ListTablesRequest request) {
    return listTablesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all tables in a specified database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   ListTablesRequest request =
   *       ListTablesRequest.newBuilder()
   *           .setParent(
   *               DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(TableView.forNumber(0))
   *           .build();
   *   ApiFuture<Table> future =
   *       metastoreServiceClient.listTablesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Table element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListTablesRequest, ListTablesPagedResponse> listTablesPagedCallable() {
    return stub.listTablesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all tables in a specified database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (MetastoreServiceClient metastoreServiceClient = MetastoreServiceClient.create()) {
   *   ListTablesRequest request =
   *       ListTablesRequest.newBuilder()
   *           .setParent(
   *               DatabaseName.of("[PROJECT]", "[LOCATION]", "[CATALOG]", "[DATABASE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setView(TableView.forNumber(0))
   *           .build();
   *   while (true) {
   *     ListTablesResponse response = metastoreServiceClient.listTablesCallable().call(request);
   *     for (Table element : response.getTablesList()) {
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
  public final UnaryCallable<ListTablesRequest, ListTablesResponse> listTablesCallable() {
    return stub.listTablesCallable();
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

  public static class ListCatalogsPagedResponse
      extends AbstractPagedListResponse<
          ListCatalogsRequest,
          ListCatalogsResponse,
          Catalog,
          ListCatalogsPage,
          ListCatalogsFixedSizeCollection> {

    public static ApiFuture<ListCatalogsPagedResponse> createAsync(
        PageContext<ListCatalogsRequest, ListCatalogsResponse, Catalog> context,
        ApiFuture<ListCatalogsResponse> futureResponse) {
      ApiFuture<ListCatalogsPage> futurePage =
          ListCatalogsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListCatalogsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListCatalogsPagedResponse(ListCatalogsPage page) {
      super(page, ListCatalogsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListCatalogsPage
      extends AbstractPage<ListCatalogsRequest, ListCatalogsResponse, Catalog, ListCatalogsPage> {

    private ListCatalogsPage(
        PageContext<ListCatalogsRequest, ListCatalogsResponse, Catalog> context,
        ListCatalogsResponse response) {
      super(context, response);
    }

    private static ListCatalogsPage createEmptyPage() {
      return new ListCatalogsPage(null, null);
    }

    @Override
    protected ListCatalogsPage createPage(
        PageContext<ListCatalogsRequest, ListCatalogsResponse, Catalog> context,
        ListCatalogsResponse response) {
      return new ListCatalogsPage(context, response);
    }

    @Override
    public ApiFuture<ListCatalogsPage> createPageAsync(
        PageContext<ListCatalogsRequest, ListCatalogsResponse, Catalog> context,
        ApiFuture<ListCatalogsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListCatalogsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListCatalogsRequest,
          ListCatalogsResponse,
          Catalog,
          ListCatalogsPage,
          ListCatalogsFixedSizeCollection> {

    private ListCatalogsFixedSizeCollection(List<ListCatalogsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListCatalogsFixedSizeCollection createEmptyCollection() {
      return new ListCatalogsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListCatalogsFixedSizeCollection createCollection(
        List<ListCatalogsPage> pages, int collectionSize) {
      return new ListCatalogsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDatabasesPagedResponse
      extends AbstractPagedListResponse<
          ListDatabasesRequest,
          ListDatabasesResponse,
          Database,
          ListDatabasesPage,
          ListDatabasesFixedSizeCollection> {

    public static ApiFuture<ListDatabasesPagedResponse> createAsync(
        PageContext<ListDatabasesRequest, ListDatabasesResponse, Database> context,
        ApiFuture<ListDatabasesResponse> futureResponse) {
      ApiFuture<ListDatabasesPage> futurePage =
          ListDatabasesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDatabasesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDatabasesPagedResponse(ListDatabasesPage page) {
      super(page, ListDatabasesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDatabasesPage
      extends AbstractPage<
          ListDatabasesRequest, ListDatabasesResponse, Database, ListDatabasesPage> {

    private ListDatabasesPage(
        PageContext<ListDatabasesRequest, ListDatabasesResponse, Database> context,
        ListDatabasesResponse response) {
      super(context, response);
    }

    private static ListDatabasesPage createEmptyPage() {
      return new ListDatabasesPage(null, null);
    }

    @Override
    protected ListDatabasesPage createPage(
        PageContext<ListDatabasesRequest, ListDatabasesResponse, Database> context,
        ListDatabasesResponse response) {
      return new ListDatabasesPage(context, response);
    }

    @Override
    public ApiFuture<ListDatabasesPage> createPageAsync(
        PageContext<ListDatabasesRequest, ListDatabasesResponse, Database> context,
        ApiFuture<ListDatabasesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDatabasesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDatabasesRequest,
          ListDatabasesResponse,
          Database,
          ListDatabasesPage,
          ListDatabasesFixedSizeCollection> {

    private ListDatabasesFixedSizeCollection(List<ListDatabasesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDatabasesFixedSizeCollection createEmptyCollection() {
      return new ListDatabasesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDatabasesFixedSizeCollection createCollection(
        List<ListDatabasesPage> pages, int collectionSize) {
      return new ListDatabasesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListTablesPagedResponse
      extends AbstractPagedListResponse<
          ListTablesRequest,
          ListTablesResponse,
          Table,
          ListTablesPage,
          ListTablesFixedSizeCollection> {

    public static ApiFuture<ListTablesPagedResponse> createAsync(
        PageContext<ListTablesRequest, ListTablesResponse, Table> context,
        ApiFuture<ListTablesResponse> futureResponse) {
      ApiFuture<ListTablesPage> futurePage =
          ListTablesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage, input -> new ListTablesPagedResponse(input), MoreExecutors.directExecutor());
    }

    private ListTablesPagedResponse(ListTablesPage page) {
      super(page, ListTablesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListTablesPage
      extends AbstractPage<ListTablesRequest, ListTablesResponse, Table, ListTablesPage> {

    private ListTablesPage(
        PageContext<ListTablesRequest, ListTablesResponse, Table> context,
        ListTablesResponse response) {
      super(context, response);
    }

    private static ListTablesPage createEmptyPage() {
      return new ListTablesPage(null, null);
    }

    @Override
    protected ListTablesPage createPage(
        PageContext<ListTablesRequest, ListTablesResponse, Table> context,
        ListTablesResponse response) {
      return new ListTablesPage(context, response);
    }

    @Override
    public ApiFuture<ListTablesPage> createPageAsync(
        PageContext<ListTablesRequest, ListTablesResponse, Table> context,
        ApiFuture<ListTablesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListTablesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListTablesRequest,
          ListTablesResponse,
          Table,
          ListTablesPage,
          ListTablesFixedSizeCollection> {

    private ListTablesFixedSizeCollection(List<ListTablesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListTablesFixedSizeCollection createEmptyCollection() {
      return new ListTablesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListTablesFixedSizeCollection createCollection(
        List<ListTablesPage> pages, int collectionSize) {
      return new ListTablesFixedSizeCollection(pages, collectionSize);
    }
  }
}
