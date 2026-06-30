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

package com.google.cloud.biglake.hive.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.ServerStreamingCallable;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.cloud.biglake.hive.v1beta.stub.HiveMetastoreServiceStub;
import com.google.cloud.biglake.hive.v1beta.stub.HiveMetastoreServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Hive Metastore Service is a biglake service that allows users to manage
 * their external Hive catalogs. Full API compatibility with OSS Hive Metastore APIs is not
 * supported. The methods match the Hive Metastore API spec mostly except for a few exceptions.
 * These include listing resources with pattern, environment context which are combined in a single
 * List API, return of ListResponse object instead of a list of resources, transactions, locks, etc.
 *
 * <p>The BigLake Hive Metastore API defines the following resources:
 *
 * <ul>
 *   <li>A collection of Google Cloud projects: `/projects/&#42;`
 *   <li>Each project has a collection of catalogs: `/catalogs/&#42;`
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
 * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
 *     HiveMetastoreServiceClient.create()) {
 *   ProjectName parent = ProjectName.of("[PROJECT]");
 *   HiveCatalog hiveCatalog = HiveCatalog.newBuilder().build();
 *   String hiveCatalogId = "hiveCatalogId-575314556";
 *   HiveCatalog response =
 *       hiveMetastoreServiceClient.createHiveCatalog(parent, hiveCatalog, hiveCatalogId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the HiveMetastoreServiceClient object to clean up
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
 *      <td><p> CreateHiveCatalog</td>
 *      <td><p> Creates a new hive catalog.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createHiveCatalog(CreateHiveCatalogRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createHiveCatalog(ProjectName parent, HiveCatalog hiveCatalog, String hiveCatalogId)
 *           <li><p> createHiveCatalog(String parent, HiveCatalog hiveCatalog, String hiveCatalogId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createHiveCatalogCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetHiveCatalog</td>
 *      <td><p> Gets the catalog specified by the resource name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getHiveCatalog(GetHiveCatalogRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getHiveCatalog(CatalogName name)
 *           <li><p> getHiveCatalog(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getHiveCatalogCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListHiveCatalogs</td>
 *      <td><p> List all catalogs in a specified project.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listHiveCatalogs(ListHiveCatalogsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listHiveCatalogs(ProjectName parent)
 *           <li><p> listHiveCatalogs(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listHiveCatalogsPagedCallable()
 *           <li><p> listHiveCatalogsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateHiveCatalog</td>
 *      <td><p> Updates an existing catalog.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateHiveCatalog(UpdateHiveCatalogRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateHiveCatalog(HiveCatalog hiveCatalog, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateHiveCatalogCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteHiveCatalog</td>
 *      <td><p> Deletes an existing catalog specified by the catalog ID. Delete will fail if the catalog is not empty.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteHiveCatalog(DeleteHiveCatalogRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteHiveCatalog(CatalogName name)
 *           <li><p> deleteHiveCatalog(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteHiveCatalogCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateHiveDatabase</td>
 *      <td><p> Creates a new database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createHiveDatabase(CreateHiveDatabaseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createHiveDatabase(CatalogName parent, HiveDatabase hiveDatabase, String hiveDatabaseId)
 *           <li><p> createHiveDatabase(String parent, HiveDatabase hiveDatabase, String hiveDatabaseId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createHiveDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetHiveDatabase</td>
 *      <td><p> Gets the database specified by the resource name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getHiveDatabase(GetHiveDatabaseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getHiveDatabase(NamespaceName name)
 *           <li><p> getHiveDatabase(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getHiveDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListHiveDatabases</td>
 *      <td><p> List all databases in a specified catalog.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listHiveDatabases(ListHiveDatabasesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listHiveDatabases(CatalogName parent)
 *           <li><p> listHiveDatabases(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listHiveDatabasesPagedCallable()
 *           <li><p> listHiveDatabasesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateHiveDatabase</td>
 *      <td><p> Updates an existing database specified by the database name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateHiveDatabase(UpdateHiveDatabaseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateHiveDatabase(HiveDatabase hiveDatabase, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateHiveDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteHiveDatabase</td>
 *      <td><p> Deletes an existing database specified by the database name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteHiveDatabase(DeleteHiveDatabaseRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteHiveDatabase(NamespaceName name)
 *           <li><p> deleteHiveDatabase(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteHiveDatabaseCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateHiveTable</td>
 *      <td><p> Creates a new hive table.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createHiveTable(CreateHiveTableRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createHiveTable(NamespaceName parent, HiveTable hiveTable, String hiveTableId)
 *           <li><p> createHiveTable(String parent, HiveTable hiveTable, String hiveTableId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createHiveTableCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetHiveTable</td>
 *      <td><p> Gets the table specified by the resource name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getHiveTable(GetHiveTableRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getHiveTable(TableName name)
 *           <li><p> getHiveTable(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getHiveTableCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListHiveTables</td>
 *      <td><p> List all hive tables in a specified project under the hive catalog and database.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listHiveTables(ListHiveTablesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listHiveTables(NamespaceName parent)
 *           <li><p> listHiveTables(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listHiveTablesPagedCallable()
 *           <li><p> listHiveTablesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateHiveTable</td>
 *      <td><p> Updates an existing table specified by the table name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateHiveTable(UpdateHiveTableRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateHiveTable(HiveTable hiveTable, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateHiveTableCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteHiveTable</td>
 *      <td><p> Deletes an existing table specified by the table name.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteHiveTable(DeleteHiveTableRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteHiveTable(TableName name)
 *           <li><p> deleteHiveTable(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteHiveTableCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchCreatePartitions</td>
 *      <td><p> Adds partitions to a table.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchCreatePartitions(BatchCreatePartitionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchCreatePartitions(TableName parent)
 *           <li><p> batchCreatePartitions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchCreatePartitionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchDeletePartitions</td>
 *      <td><p> Deletes partitions from a table.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchDeletePartitions(BatchDeletePartitionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchDeletePartitions(TableName parent)
 *           <li><p> batchDeletePartitions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchDeletePartitionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BatchUpdatePartitions</td>
 *      <td><p> Updates partitions in a table.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> batchUpdatePartitions(BatchUpdatePartitionsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> batchUpdatePartitions(TableName parent)
 *           <li><p> batchUpdatePartitions(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> batchUpdatePartitionsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListPartitions</td>
 *      <td><p> Streams list of partitions from a table.</td>
 *      <td>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listPartitionsCallable()
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
 * <p>This class can be customized by passing in a custom instance of HiveMetastoreServiceSettings
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
 * HiveMetastoreServiceSettings hiveMetastoreServiceSettings =
 *     HiveMetastoreServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * HiveMetastoreServiceClient hiveMetastoreServiceClient =
 *     HiveMetastoreServiceClient.create(hiveMetastoreServiceSettings);
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
 * HiveMetastoreServiceSettings hiveMetastoreServiceSettings =
 *     HiveMetastoreServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * HiveMetastoreServiceClient hiveMetastoreServiceClient =
 *     HiveMetastoreServiceClient.create(hiveMetastoreServiceSettings);
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
 * HiveMetastoreServiceSettings hiveMetastoreServiceSettings =
 *     HiveMetastoreServiceSettings.newHttpJsonBuilder().build();
 * HiveMetastoreServiceClient hiveMetastoreServiceClient =
 *     HiveMetastoreServiceClient.create(hiveMetastoreServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class HiveMetastoreServiceClient implements BackgroundResource {
  private final HiveMetastoreServiceSettings settings;
  private final HiveMetastoreServiceStub stub;

  /** Constructs an instance of HiveMetastoreServiceClient with default settings. */
  public static final HiveMetastoreServiceClient create() throws IOException {
    return create(HiveMetastoreServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of HiveMetastoreServiceClient, using the given settings. The channels
   * are created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final HiveMetastoreServiceClient create(HiveMetastoreServiceSettings settings)
      throws IOException {
    return new HiveMetastoreServiceClient(settings);
  }

  /**
   * Constructs an instance of HiveMetastoreServiceClient, using the given stub for making calls.
   * This is for advanced usage - prefer using create(HiveMetastoreServiceSettings).
   */
  public static final HiveMetastoreServiceClient create(HiveMetastoreServiceStub stub) {
    return new HiveMetastoreServiceClient(stub);
  }

  /**
   * Constructs an instance of HiveMetastoreServiceClient, using the given settings. This is
   * protected so that it is easy to make a subclass, but otherwise, the static factory methods
   * should be preferred.
   */
  protected HiveMetastoreServiceClient(HiveMetastoreServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((HiveMetastoreServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected HiveMetastoreServiceClient(HiveMetastoreServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final HiveMetastoreServiceSettings getSettings() {
    return settings;
  }

  public HiveMetastoreServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new hive catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   HiveCatalog hiveCatalog = HiveCatalog.newBuilder().build();
   *   String hiveCatalogId = "hiveCatalogId-575314556";
   *   HiveCatalog response =
   *       hiveMetastoreServiceClient.createHiveCatalog(parent, hiveCatalog, hiveCatalogId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this catalog will be created. Format:
   *     projects/{project_id_or_number}
   * @param hiveCatalog Required. The catalog to create. The `name` field does not need to be
   *     provided. Gets copied over from catalog_id.
   * @param hiveCatalogId Required. The Hive Catalog ID to use for the catalog that will become the
   *     final component of the catalog's resource name. The maximum length is 256 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveCatalog createHiveCatalog(
      ProjectName parent, HiveCatalog hiveCatalog, String hiveCatalogId) {
    CreateHiveCatalogRequest request =
        CreateHiveCatalogRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setHiveCatalog(hiveCatalog)
            .setHiveCatalogId(hiveCatalogId)
            .build();
    return createHiveCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new hive catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   HiveCatalog hiveCatalog = HiveCatalog.newBuilder().build();
   *   String hiveCatalogId = "hiveCatalogId-575314556";
   *   HiveCatalog response =
   *       hiveMetastoreServiceClient.createHiveCatalog(parent, hiveCatalog, hiveCatalogId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this catalog will be created. Format:
   *     projects/{project_id_or_number}
   * @param hiveCatalog Required. The catalog to create. The `name` field does not need to be
   *     provided. Gets copied over from catalog_id.
   * @param hiveCatalogId Required. The Hive Catalog ID to use for the catalog that will become the
   *     final component of the catalog's resource name. The maximum length is 256 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveCatalog createHiveCatalog(
      String parent, HiveCatalog hiveCatalog, String hiveCatalogId) {
    CreateHiveCatalogRequest request =
        CreateHiveCatalogRequest.newBuilder()
            .setParent(parent)
            .setHiveCatalog(hiveCatalog)
            .setHiveCatalogId(hiveCatalogId)
            .build();
    return createHiveCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new hive catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   CreateHiveCatalogRequest request =
   *       CreateHiveCatalogRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setHiveCatalog(HiveCatalog.newBuilder().build())
   *           .setHiveCatalogId("hiveCatalogId-575314556")
   *           .setPrimaryLocation("primaryLocation-1140723753")
   *           .build();
   *   HiveCatalog response = hiveMetastoreServiceClient.createHiveCatalog(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveCatalog createHiveCatalog(CreateHiveCatalogRequest request) {
    return createHiveCatalogCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new hive catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   CreateHiveCatalogRequest request =
   *       CreateHiveCatalogRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setHiveCatalog(HiveCatalog.newBuilder().build())
   *           .setHiveCatalogId("hiveCatalogId-575314556")
   *           .setPrimaryLocation("primaryLocation-1140723753")
   *           .build();
   *   ApiFuture<HiveCatalog> future =
   *       hiveMetastoreServiceClient.createHiveCatalogCallable().futureCall(request);
   *   // Do something.
   *   HiveCatalog response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateHiveCatalogRequest, HiveCatalog> createHiveCatalogCallable() {
    return stub.createHiveCatalogCallable();
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   CatalogName name = CatalogName.of("[PROJECT]", "[CATALOG]");
   *   HiveCatalog response = hiveMetastoreServiceClient.getHiveCatalog(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the catalog to retrieve. Format:
   *     projects/{project_id_or_number}/catalogs/{catalog_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveCatalog getHiveCatalog(CatalogName name) {
    GetHiveCatalogRequest request =
        GetHiveCatalogRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getHiveCatalog(request);
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   String name = CatalogName.of("[PROJECT]", "[CATALOG]").toString();
   *   HiveCatalog response = hiveMetastoreServiceClient.getHiveCatalog(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the catalog to retrieve. Format:
   *     projects/{project_id_or_number}/catalogs/{catalog_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveCatalog getHiveCatalog(String name) {
    GetHiveCatalogRequest request = GetHiveCatalogRequest.newBuilder().setName(name).build();
    return getHiveCatalog(request);
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   GetHiveCatalogRequest request =
   *       GetHiveCatalogRequest.newBuilder()
   *           .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
   *           .build();
   *   HiveCatalog response = hiveMetastoreServiceClient.getHiveCatalog(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveCatalog getHiveCatalog(GetHiveCatalogRequest request) {
    return getHiveCatalogCallable().call(request);
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   GetHiveCatalogRequest request =
   *       GetHiveCatalogRequest.newBuilder()
   *           .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
   *           .build();
   *   ApiFuture<HiveCatalog> future =
   *       hiveMetastoreServiceClient.getHiveCatalogCallable().futureCall(request);
   *   // Do something.
   *   HiveCatalog response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetHiveCatalogRequest, HiveCatalog> getHiveCatalogCallable() {
    return stub.getHiveCatalogCallable();
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   ProjectName parent = ProjectName.of("[PROJECT]");
   *   for (HiveCatalog element : hiveMetastoreServiceClient.listHiveCatalogs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project to list catalogs from. Format:
   *     projects/{project_id_or_number}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHiveCatalogsPagedResponse listHiveCatalogs(ProjectName parent) {
    ListHiveCatalogsRequest request =
        ListHiveCatalogsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listHiveCatalogs(request);
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   String parent = ProjectName.of("[PROJECT]").toString();
   *   for (HiveCatalog element : hiveMetastoreServiceClient.listHiveCatalogs(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The project to list catalogs from. Format:
   *     projects/{project_id_or_number}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHiveCatalogsPagedResponse listHiveCatalogs(String parent) {
    ListHiveCatalogsRequest request =
        ListHiveCatalogsRequest.newBuilder().setParent(parent).build();
    return listHiveCatalogs(request);
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   ListHiveCatalogsRequest request =
   *       ListHiveCatalogsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (HiveCatalog element :
   *       hiveMetastoreServiceClient.listHiveCatalogs(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHiveCatalogsPagedResponse listHiveCatalogs(ListHiveCatalogsRequest request) {
    return listHiveCatalogsPagedCallable().call(request);
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   ListHiveCatalogsRequest request =
   *       ListHiveCatalogsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<HiveCatalog> future =
   *       hiveMetastoreServiceClient.listHiveCatalogsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (HiveCatalog element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListHiveCatalogsRequest, ListHiveCatalogsPagedResponse>
      listHiveCatalogsPagedCallable() {
    return stub.listHiveCatalogsPagedCallable();
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   ListHiveCatalogsRequest request =
   *       ListHiveCatalogsRequest.newBuilder()
   *           .setParent(ProjectName.of("[PROJECT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListHiveCatalogsResponse response =
   *         hiveMetastoreServiceClient.listHiveCatalogsCallable().call(request);
   *     for (HiveCatalog element : response.getCatalogsList()) {
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
  public final UnaryCallable<ListHiveCatalogsRequest, ListHiveCatalogsResponse>
      listHiveCatalogsCallable() {
    return stub.listHiveCatalogsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   HiveCatalog hiveCatalog = HiveCatalog.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   HiveCatalog response = hiveMetastoreServiceClient.updateHiveCatalog(hiveCatalog, updateMask);
   * }
   * }</pre>
   *
   * @param hiveCatalog Required. The hive catalog to update. The name under the catalog is used to
   *     identify the catalog. Format: projects/{project_id_or_number}/catalogs/{catalog_id}
   * @param updateMask Optional. The list of fields to update.
   *     <p>For the `FieldMask` definition, see
   *     https://developers.google.com/protocol-buffers/docs/reference/google.protobuf#fieldmask If
   *     not set, defaults to all of the fields that are allowed to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveCatalog updateHiveCatalog(HiveCatalog hiveCatalog, FieldMask updateMask) {
    UpdateHiveCatalogRequest request =
        UpdateHiveCatalogRequest.newBuilder()
            .setHiveCatalog(hiveCatalog)
            .setUpdateMask(updateMask)
            .build();
    return updateHiveCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   UpdateHiveCatalogRequest request =
   *       UpdateHiveCatalogRequest.newBuilder()
   *           .setHiveCatalog(HiveCatalog.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   HiveCatalog response = hiveMetastoreServiceClient.updateHiveCatalog(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveCatalog updateHiveCatalog(UpdateHiveCatalogRequest request) {
    return updateHiveCatalogCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing catalog.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   UpdateHiveCatalogRequest request =
   *       UpdateHiveCatalogRequest.newBuilder()
   *           .setHiveCatalog(HiveCatalog.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<HiveCatalog> future =
   *       hiveMetastoreServiceClient.updateHiveCatalogCallable().futureCall(request);
   *   // Do something.
   *   HiveCatalog response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateHiveCatalogRequest, HiveCatalog> updateHiveCatalogCallable() {
    return stub.updateHiveCatalogCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing catalog specified by the catalog ID. Delete will fail if the catalog is not
   * empty.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   CatalogName name = CatalogName.of("[PROJECT]", "[CATALOG]");
   *   hiveMetastoreServiceClient.deleteHiveCatalog(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the catalog to delete. Format:
   *     projects/{project_id_or_number}/catalogs/{catalog_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteHiveCatalog(CatalogName name) {
    DeleteHiveCatalogRequest request =
        DeleteHiveCatalogRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteHiveCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing catalog specified by the catalog ID. Delete will fail if the catalog is not
   * empty.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   String name = CatalogName.of("[PROJECT]", "[CATALOG]").toString();
   *   hiveMetastoreServiceClient.deleteHiveCatalog(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the catalog to delete. Format:
   *     projects/{project_id_or_number}/catalogs/{catalog_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteHiveCatalog(String name) {
    DeleteHiveCatalogRequest request = DeleteHiveCatalogRequest.newBuilder().setName(name).build();
    deleteHiveCatalog(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing catalog specified by the catalog ID. Delete will fail if the catalog is not
   * empty.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   DeleteHiveCatalogRequest request =
   *       DeleteHiveCatalogRequest.newBuilder()
   *           .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
   *           .build();
   *   hiveMetastoreServiceClient.deleteHiveCatalog(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteHiveCatalog(DeleteHiveCatalogRequest request) {
    deleteHiveCatalogCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing catalog specified by the catalog ID. Delete will fail if the catalog is not
   * empty.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   DeleteHiveCatalogRequest request =
   *       DeleteHiveCatalogRequest.newBuilder()
   *           .setName(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       hiveMetastoreServiceClient.deleteHiveCatalogCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteHiveCatalogRequest, Empty> deleteHiveCatalogCallable() {
    return stub.deleteHiveCatalogCallable();
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   CatalogName parent = CatalogName.of("[PROJECT]", "[CATALOG]");
   *   HiveDatabase hiveDatabase = HiveDatabase.newBuilder().build();
   *   String hiveDatabaseId = "hiveDatabaseId-1150232698";
   *   HiveDatabase response =
   *       hiveMetastoreServiceClient.createHiveDatabase(parent, hiveDatabase, hiveDatabaseId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this database will be created. Format:
   *     projects/{project_id_or_number}/catalogs/{catalog_id}
   * @param hiveDatabase Required. The database to create. The `name` field does not need to be
   *     provided.
   * @param hiveDatabaseId Required. The ID to use for the Hive Database. The maximum length is 128
   *     characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveDatabase createHiveDatabase(
      CatalogName parent, HiveDatabase hiveDatabase, String hiveDatabaseId) {
    CreateHiveDatabaseRequest request =
        CreateHiveDatabaseRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setHiveDatabase(hiveDatabase)
            .setHiveDatabaseId(hiveDatabaseId)
            .build();
    return createHiveDatabase(request);
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   String parent = CatalogName.of("[PROJECT]", "[CATALOG]").toString();
   *   HiveDatabase hiveDatabase = HiveDatabase.newBuilder().build();
   *   String hiveDatabaseId = "hiveDatabaseId-1150232698";
   *   HiveDatabase response =
   *       hiveMetastoreServiceClient.createHiveDatabase(parent, hiveDatabase, hiveDatabaseId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this database will be created. Format:
   *     projects/{project_id_or_number}/catalogs/{catalog_id}
   * @param hiveDatabase Required. The database to create. The `name` field does not need to be
   *     provided.
   * @param hiveDatabaseId Required. The ID to use for the Hive Database. The maximum length is 128
   *     characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveDatabase createHiveDatabase(
      String parent, HiveDatabase hiveDatabase, String hiveDatabaseId) {
    CreateHiveDatabaseRequest request =
        CreateHiveDatabaseRequest.newBuilder()
            .setParent(parent)
            .setHiveDatabase(hiveDatabase)
            .setHiveDatabaseId(hiveDatabaseId)
            .build();
    return createHiveDatabase(request);
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   CreateHiveDatabaseRequest request =
   *       CreateHiveDatabaseRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
   *           .setHiveDatabase(HiveDatabase.newBuilder().build())
   *           .setHiveDatabaseId("hiveDatabaseId-1150232698")
   *           .build();
   *   HiveDatabase response = hiveMetastoreServiceClient.createHiveDatabase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveDatabase createHiveDatabase(CreateHiveDatabaseRequest request) {
    return createHiveDatabaseCallable().call(request);
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   CreateHiveDatabaseRequest request =
   *       CreateHiveDatabaseRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
   *           .setHiveDatabase(HiveDatabase.newBuilder().build())
   *           .setHiveDatabaseId("hiveDatabaseId-1150232698")
   *           .build();
   *   ApiFuture<HiveDatabase> future =
   *       hiveMetastoreServiceClient.createHiveDatabaseCallable().futureCall(request);
   *   // Do something.
   *   HiveDatabase response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateHiveDatabaseRequest, HiveDatabase> createHiveDatabaseCallable() {
    return stub.createHiveDatabaseCallable();
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   NamespaceName name = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]");
   *   HiveDatabase response = hiveMetastoreServiceClient.getHiveDatabase(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the database to retrieve. Format:
   *     projects/{project_id_or_number}/catalogs/{catalog_id}/databases/{database_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveDatabase getHiveDatabase(NamespaceName name) {
    GetHiveDatabaseRequest request =
        GetHiveDatabaseRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getHiveDatabase(request);
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   String name = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString();
   *   HiveDatabase response = hiveMetastoreServiceClient.getHiveDatabase(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the database to retrieve. Format:
   *     projects/{project_id_or_number}/catalogs/{catalog_id}/databases/{database_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveDatabase getHiveDatabase(String name) {
    GetHiveDatabaseRequest request = GetHiveDatabaseRequest.newBuilder().setName(name).build();
    return getHiveDatabase(request);
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   GetHiveDatabaseRequest request =
   *       GetHiveDatabaseRequest.newBuilder()
   *           .setName(NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString())
   *           .build();
   *   HiveDatabase response = hiveMetastoreServiceClient.getHiveDatabase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveDatabase getHiveDatabase(GetHiveDatabaseRequest request) {
    return getHiveDatabaseCallable().call(request);
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   GetHiveDatabaseRequest request =
   *       GetHiveDatabaseRequest.newBuilder()
   *           .setName(NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString())
   *           .build();
   *   ApiFuture<HiveDatabase> future =
   *       hiveMetastoreServiceClient.getHiveDatabaseCallable().futureCall(request);
   *   // Do something.
   *   HiveDatabase response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetHiveDatabaseRequest, HiveDatabase> getHiveDatabaseCallable() {
    return stub.getHiveDatabaseCallable();
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   CatalogName parent = CatalogName.of("[PROJECT]", "[CATALOG]");
   *   for (HiveDatabase element :
   *       hiveMetastoreServiceClient.listHiveDatabases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The hive catalog to list databases from. Format:
   *     projects/{project_id_or_number}/catalogs/{catalog_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHiveDatabasesPagedResponse listHiveDatabases(CatalogName parent) {
    ListHiveDatabasesRequest request =
        ListHiveDatabasesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listHiveDatabases(request);
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   String parent = CatalogName.of("[PROJECT]", "[CATALOG]").toString();
   *   for (HiveDatabase element :
   *       hiveMetastoreServiceClient.listHiveDatabases(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The hive catalog to list databases from. Format:
   *     projects/{project_id_or_number}/catalogs/{catalog_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHiveDatabasesPagedResponse listHiveDatabases(String parent) {
    ListHiveDatabasesRequest request =
        ListHiveDatabasesRequest.newBuilder().setParent(parent).build();
    return listHiveDatabases(request);
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   ListHiveDatabasesRequest request =
   *       ListHiveDatabasesRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (HiveDatabase element :
   *       hiveMetastoreServiceClient.listHiveDatabases(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHiveDatabasesPagedResponse listHiveDatabases(ListHiveDatabasesRequest request) {
    return listHiveDatabasesPagedCallable().call(request);
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   ListHiveDatabasesRequest request =
   *       ListHiveDatabasesRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<HiveDatabase> future =
   *       hiveMetastoreServiceClient.listHiveDatabasesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (HiveDatabase element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListHiveDatabasesRequest, ListHiveDatabasesPagedResponse>
      listHiveDatabasesPagedCallable() {
    return stub.listHiveDatabasesPagedCallable();
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   ListHiveDatabasesRequest request =
   *       ListHiveDatabasesRequest.newBuilder()
   *           .setParent(CatalogName.of("[PROJECT]", "[CATALOG]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListHiveDatabasesResponse response =
   *         hiveMetastoreServiceClient.listHiveDatabasesCallable().call(request);
   *     for (HiveDatabase element : response.getDatabasesList()) {
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
  public final UnaryCallable<ListHiveDatabasesRequest, ListHiveDatabasesResponse>
      listHiveDatabasesCallable() {
    return stub.listHiveDatabasesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing database specified by the database name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   HiveDatabase hiveDatabase = HiveDatabase.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   HiveDatabase response =
   *       hiveMetastoreServiceClient.updateHiveDatabase(hiveDatabase, updateMask);
   * }
   * }</pre>
   *
   * @param hiveDatabase Required. The database to update.
   *     <p>The database's `name` field is used to identify the database to update. Format:
   *     projects/{project_id_or_number}/catalogs/{catalog_id}/databases/{database_id}
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveDatabase updateHiveDatabase(HiveDatabase hiveDatabase, FieldMask updateMask) {
    UpdateHiveDatabaseRequest request =
        UpdateHiveDatabaseRequest.newBuilder()
            .setHiveDatabase(hiveDatabase)
            .setUpdateMask(updateMask)
            .build();
    return updateHiveDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing database specified by the database name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   UpdateHiveDatabaseRequest request =
   *       UpdateHiveDatabaseRequest.newBuilder()
   *           .setHiveDatabase(HiveDatabase.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   HiveDatabase response = hiveMetastoreServiceClient.updateHiveDatabase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveDatabase updateHiveDatabase(UpdateHiveDatabaseRequest request) {
    return updateHiveDatabaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing database specified by the database name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   UpdateHiveDatabaseRequest request =
   *       UpdateHiveDatabaseRequest.newBuilder()
   *           .setHiveDatabase(HiveDatabase.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<HiveDatabase> future =
   *       hiveMetastoreServiceClient.updateHiveDatabaseCallable().futureCall(request);
   *   // Do something.
   *   HiveDatabase response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateHiveDatabaseRequest, HiveDatabase> updateHiveDatabaseCallable() {
    return stub.updateHiveDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing database specified by the database name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   NamespaceName name = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]");
   *   hiveMetastoreServiceClient.deleteHiveDatabase(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the database to delete. Format:
   *     projects/{project_id_or_number}/catalogs/{catalog_id}/databases/{database_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteHiveDatabase(NamespaceName name) {
    DeleteHiveDatabaseRequest request =
        DeleteHiveDatabaseRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteHiveDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing database specified by the database name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   String name = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString();
   *   hiveMetastoreServiceClient.deleteHiveDatabase(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the database to delete. Format:
   *     projects/{project_id_or_number}/catalogs/{catalog_id}/databases/{database_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteHiveDatabase(String name) {
    DeleteHiveDatabaseRequest request =
        DeleteHiveDatabaseRequest.newBuilder().setName(name).build();
    deleteHiveDatabase(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing database specified by the database name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   DeleteHiveDatabaseRequest request =
   *       DeleteHiveDatabaseRequest.newBuilder()
   *           .setName(NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString())
   *           .build();
   *   hiveMetastoreServiceClient.deleteHiveDatabase(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteHiveDatabase(DeleteHiveDatabaseRequest request) {
    deleteHiveDatabaseCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing database specified by the database name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   DeleteHiveDatabaseRequest request =
   *       DeleteHiveDatabaseRequest.newBuilder()
   *           .setName(NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       hiveMetastoreServiceClient.deleteHiveDatabaseCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteHiveDatabaseRequest, Empty> deleteHiveDatabaseCallable() {
    return stub.deleteHiveDatabaseCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new hive table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   NamespaceName parent = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]");
   *   HiveTable hiveTable = HiveTable.newBuilder().build();
   *   String hiveTableId = "hiveTableId152241145";
   *   HiveTable response =
   *       hiveMetastoreServiceClient.createHiveTable(parent, hiveTable, hiveTableId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for the table to be created. Format:
   *     projects/{project_id_or_number}/catalogs/{catalog_id}/databases/{database_id}
   * @param hiveTable Required. The Hive Table to create. The `name` field does not need to be
   *     provided.
   * @param hiveTableId Required. The Hive Table ID to use for the table that will become the final
   *     component of the table's resource name. The maximum length is 256 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveTable createHiveTable(
      NamespaceName parent, HiveTable hiveTable, String hiveTableId) {
    CreateHiveTableRequest request =
        CreateHiveTableRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setHiveTable(hiveTable)
            .setHiveTableId(hiveTableId)
            .build();
    return createHiveTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new hive table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   String parent = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString();
   *   HiveTable hiveTable = HiveTable.newBuilder().build();
   *   String hiveTableId = "hiveTableId152241145";
   *   HiveTable response =
   *       hiveMetastoreServiceClient.createHiveTable(parent, hiveTable, hiveTableId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource for the table to be created. Format:
   *     projects/{project_id_or_number}/catalogs/{catalog_id}/databases/{database_id}
   * @param hiveTable Required. The Hive Table to create. The `name` field does not need to be
   *     provided.
   * @param hiveTableId Required. The Hive Table ID to use for the table that will become the final
   *     component of the table's resource name. The maximum length is 256 characters.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveTable createHiveTable(String parent, HiveTable hiveTable, String hiveTableId) {
    CreateHiveTableRequest request =
        CreateHiveTableRequest.newBuilder()
            .setParent(parent)
            .setHiveTable(hiveTable)
            .setHiveTableId(hiveTableId)
            .build();
    return createHiveTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new hive table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   CreateHiveTableRequest request =
   *       CreateHiveTableRequest.newBuilder()
   *           .setParent(NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString())
   *           .setHiveTable(HiveTable.newBuilder().build())
   *           .setHiveTableId("hiveTableId152241145")
   *           .build();
   *   HiveTable response = hiveMetastoreServiceClient.createHiveTable(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveTable createHiveTable(CreateHiveTableRequest request) {
    return createHiveTableCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a new hive table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   CreateHiveTableRequest request =
   *       CreateHiveTableRequest.newBuilder()
   *           .setParent(NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString())
   *           .setHiveTable(HiveTable.newBuilder().build())
   *           .setHiveTableId("hiveTableId152241145")
   *           .build();
   *   ApiFuture<HiveTable> future =
   *       hiveMetastoreServiceClient.createHiveTableCallable().futureCall(request);
   *   // Do something.
   *   HiveTable response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateHiveTableRequest, HiveTable> createHiveTableCallable() {
    return stub.createHiveTableCallable();
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");
   *   HiveTable response = hiveMetastoreServiceClient.getHiveTable(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the table to retrieve. Format:
   *     projects/{project_id_or_number}/catalogs/{catalog_id}/databases/{database_id}/tables/{table_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveTable getHiveTable(TableName name) {
    GetHiveTableRequest request =
        GetHiveTableRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getHiveTable(request);
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   String name = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString();
   *   HiveTable response = hiveMetastoreServiceClient.getHiveTable(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the table to retrieve. Format:
   *     projects/{project_id_or_number}/catalogs/{catalog_id}/databases/{database_id}/tables/{table_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveTable getHiveTable(String name) {
    GetHiveTableRequest request = GetHiveTableRequest.newBuilder().setName(name).build();
    return getHiveTable(request);
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   GetHiveTableRequest request =
   *       GetHiveTableRequest.newBuilder()
   *           .setName(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
   *           .build();
   *   HiveTable response = hiveMetastoreServiceClient.getHiveTable(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveTable getHiveTable(GetHiveTableRequest request) {
    return getHiveTableCallable().call(request);
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
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   GetHiveTableRequest request =
   *       GetHiveTableRequest.newBuilder()
   *           .setName(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
   *           .build();
   *   ApiFuture<HiveTable> future =
   *       hiveMetastoreServiceClient.getHiveTableCallable().futureCall(request);
   *   // Do something.
   *   HiveTable response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetHiveTableRequest, HiveTable> getHiveTableCallable() {
    return stub.getHiveTableCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all hive tables in a specified project under the hive catalog and database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   NamespaceName parent = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]");
   *   for (HiveTable element : hiveMetastoreServiceClient.listHiveTables(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The database to list tables from. Format:
   *     projects/{project_id_or_number}/catalogs/{catalog_id}/databases/{database_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHiveTablesPagedResponse listHiveTables(NamespaceName parent) {
    ListHiveTablesRequest request =
        ListHiveTablesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listHiveTables(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all hive tables in a specified project under the hive catalog and database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   String parent = NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString();
   *   for (HiveTable element : hiveMetastoreServiceClient.listHiveTables(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The database to list tables from. Format:
   *     projects/{project_id_or_number}/catalogs/{catalog_id}/databases/{database_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHiveTablesPagedResponse listHiveTables(String parent) {
    ListHiveTablesRequest request = ListHiveTablesRequest.newBuilder().setParent(parent).build();
    return listHiveTables(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all hive tables in a specified project under the hive catalog and database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   ListHiveTablesRequest request =
   *       ListHiveTablesRequest.newBuilder()
   *           .setParent(NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (HiveTable element : hiveMetastoreServiceClient.listHiveTables(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListHiveTablesPagedResponse listHiveTables(ListHiveTablesRequest request) {
    return listHiveTablesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all hive tables in a specified project under the hive catalog and database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   ListHiveTablesRequest request =
   *       ListHiveTablesRequest.newBuilder()
   *           .setParent(NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<HiveTable> future =
   *       hiveMetastoreServiceClient.listHiveTablesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (HiveTable element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListHiveTablesRequest, ListHiveTablesPagedResponse>
      listHiveTablesPagedCallable() {
    return stub.listHiveTablesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List all hive tables in a specified project under the hive catalog and database.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   ListHiveTablesRequest request =
   *       ListHiveTablesRequest.newBuilder()
   *           .setParent(NamespaceName.of("[PROJECT]", "[CATALOG]", "[DATABASE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListHiveTablesResponse response =
   *         hiveMetastoreServiceClient.listHiveTablesCallable().call(request);
   *     for (HiveTable element : response.getTablesList()) {
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
  public final UnaryCallable<ListHiveTablesRequest, ListHiveTablesResponse>
      listHiveTablesCallable() {
    return stub.listHiveTablesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing table specified by the table name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   HiveTable hiveTable = HiveTable.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   HiveTable response = hiveMetastoreServiceClient.updateHiveTable(hiveTable, updateMask);
   * }
   * }</pre>
   *
   * @param hiveTable Required. The table to update.
   *     <p>The table's `name` field is used to identify the table to update. Format:
   *     projects/{project_id_or_number}/catalogs/{catalog_id}/databases/{database_id}/tables/{table_id}
   * @param updateMask Optional. The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveTable updateHiveTable(HiveTable hiveTable, FieldMask updateMask) {
    UpdateHiveTableRequest request =
        UpdateHiveTableRequest.newBuilder()
            .setHiveTable(hiveTable)
            .setUpdateMask(updateMask)
            .build();
    return updateHiveTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing table specified by the table name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   UpdateHiveTableRequest request =
   *       UpdateHiveTableRequest.newBuilder()
   *           .setHiveTable(HiveTable.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   HiveTable response = hiveMetastoreServiceClient.updateHiveTable(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final HiveTable updateHiveTable(UpdateHiveTableRequest request) {
    return updateHiveTableCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates an existing table specified by the table name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   UpdateHiveTableRequest request =
   *       UpdateHiveTableRequest.newBuilder()
   *           .setHiveTable(HiveTable.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<HiveTable> future =
   *       hiveMetastoreServiceClient.updateHiveTableCallable().futureCall(request);
   *   // Do something.
   *   HiveTable response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateHiveTableRequest, HiveTable> updateHiveTableCallable() {
    return stub.updateHiveTableCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing table specified by the table name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   TableName name = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");
   *   hiveMetastoreServiceClient.deleteHiveTable(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the database to delete. Format:
   *     projects/{project_id_or_number}/catalogs/{catalog_id}/databases/{database_id}/tables/{table_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteHiveTable(TableName name) {
    DeleteHiveTableRequest request =
        DeleteHiveTableRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteHiveTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing table specified by the table name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   String name = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString();
   *   hiveMetastoreServiceClient.deleteHiveTable(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the database to delete. Format:
   *     projects/{project_id_or_number}/catalogs/{catalog_id}/databases/{database_id}/tables/{table_id}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteHiveTable(String name) {
    DeleteHiveTableRequest request = DeleteHiveTableRequest.newBuilder().setName(name).build();
    deleteHiveTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing table specified by the table name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   DeleteHiveTableRequest request =
   *       DeleteHiveTableRequest.newBuilder()
   *           .setName(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
   *           .build();
   *   hiveMetastoreServiceClient.deleteHiveTable(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteHiveTable(DeleteHiveTableRequest request) {
    deleteHiveTableCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes an existing table specified by the table name.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   DeleteHiveTableRequest request =
   *       DeleteHiveTableRequest.newBuilder()
   *           .setName(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       hiveMetastoreServiceClient.deleteHiveTableCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteHiveTableRequest, Empty> deleteHiveTableCallable() {
    return stub.deleteHiveTableCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds partitions to a table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   TableName parent = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");
   *   BatchCreatePartitionsResponse response =
   *       hiveMetastoreServiceClient.batchCreatePartitions(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Reference to the table to where the partitions to be added, in the
   *     format of projects/{project}/catalogs/{catalogs}/databases/{database}/tables/{table}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreatePartitionsResponse batchCreatePartitions(TableName parent) {
    BatchCreatePartitionsRequest request =
        BatchCreatePartitionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return batchCreatePartitions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds partitions to a table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   String parent = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString();
   *   BatchCreatePartitionsResponse response =
   *       hiveMetastoreServiceClient.batchCreatePartitions(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Reference to the table to where the partitions to be added, in the
   *     format of projects/{project}/catalogs/{catalogs}/databases/{database}/tables/{table}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreatePartitionsResponse batchCreatePartitions(String parent) {
    BatchCreatePartitionsRequest request =
        BatchCreatePartitionsRequest.newBuilder().setParent(parent).build();
    return batchCreatePartitions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds partitions to a table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   BatchCreatePartitionsRequest request =
   *       BatchCreatePartitionsRequest.newBuilder()
   *           .setParent(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
   *           .addAllRequests(new ArrayList<CreatePartitionRequest>())
   *           .setSkipExistingPartitions(true)
   *           .build();
   *   BatchCreatePartitionsResponse response =
   *       hiveMetastoreServiceClient.batchCreatePartitions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreatePartitionsResponse batchCreatePartitions(
      BatchCreatePartitionsRequest request) {
    return batchCreatePartitionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Adds partitions to a table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   BatchCreatePartitionsRequest request =
   *       BatchCreatePartitionsRequest.newBuilder()
   *           .setParent(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
   *           .addAllRequests(new ArrayList<CreatePartitionRequest>())
   *           .setSkipExistingPartitions(true)
   *           .build();
   *   ApiFuture<BatchCreatePartitionsResponse> future =
   *       hiveMetastoreServiceClient.batchCreatePartitionsCallable().futureCall(request);
   *   // Do something.
   *   BatchCreatePartitionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreatePartitionsRequest, BatchCreatePartitionsResponse>
      batchCreatePartitionsCallable() {
    return stub.batchCreatePartitionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes partitions from a table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   TableName parent = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");
   *   hiveMetastoreServiceClient.batchDeletePartitions(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Reference to the table to which these partitions belong, in the format
   *     of projects/{project}/catalogs/{catalogs}/databases/{database}/tables/{table}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeletePartitions(TableName parent) {
    BatchDeletePartitionsRequest request =
        BatchDeletePartitionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    batchDeletePartitions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes partitions from a table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   String parent = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString();
   *   hiveMetastoreServiceClient.batchDeletePartitions(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Reference to the table to which these partitions belong, in the format
   *     of projects/{project}/catalogs/{catalogs}/databases/{database}/tables/{table}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeletePartitions(String parent) {
    BatchDeletePartitionsRequest request =
        BatchDeletePartitionsRequest.newBuilder().setParent(parent).build();
    batchDeletePartitions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes partitions from a table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   BatchDeletePartitionsRequest request =
   *       BatchDeletePartitionsRequest.newBuilder()
   *           .setParent(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
   *           .addAllPartitionValues(new ArrayList<PartitionValues>())
   *           .build();
   *   hiveMetastoreServiceClient.batchDeletePartitions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void batchDeletePartitions(BatchDeletePartitionsRequest request) {
    batchDeletePartitionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes partitions from a table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   BatchDeletePartitionsRequest request =
   *       BatchDeletePartitionsRequest.newBuilder()
   *           .setParent(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
   *           .addAllPartitionValues(new ArrayList<PartitionValues>())
   *           .build();
   *   ApiFuture<Empty> future =
   *       hiveMetastoreServiceClient.batchDeletePartitionsCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchDeletePartitionsRequest, Empty> batchDeletePartitionsCallable() {
    return stub.batchDeletePartitionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates partitions in a table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   TableName parent = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]");
   *   BatchUpdatePartitionsResponse response =
   *       hiveMetastoreServiceClient.batchUpdatePartitions(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Reference to the table to which these partitions belong, in the format
   *     of projects/{project}/catalogs/{catalogs}/databases/{database}/tables/{table}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdatePartitionsResponse batchUpdatePartitions(TableName parent) {
    BatchUpdatePartitionsRequest request =
        BatchUpdatePartitionsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return batchUpdatePartitions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates partitions in a table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   String parent = TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString();
   *   BatchUpdatePartitionsResponse response =
   *       hiveMetastoreServiceClient.batchUpdatePartitions(parent);
   * }
   * }</pre>
   *
   * @param parent Required. Reference to the table to which these partitions belong, in the format
   *     of projects/{project}/catalogs/{catalogs}/databases/{database}/tables/{table}.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdatePartitionsResponse batchUpdatePartitions(String parent) {
    BatchUpdatePartitionsRequest request =
        BatchUpdatePartitionsRequest.newBuilder().setParent(parent).build();
    return batchUpdatePartitions(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates partitions in a table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   BatchUpdatePartitionsRequest request =
   *       BatchUpdatePartitionsRequest.newBuilder()
   *           .setParent(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
   *           .addAllRequests(new ArrayList<UpdatePartitionRequest>())
   *           .build();
   *   BatchUpdatePartitionsResponse response =
   *       hiveMetastoreServiceClient.batchUpdatePartitions(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdatePartitionsResponse batchUpdatePartitions(
      BatchUpdatePartitionsRequest request) {
    return batchUpdatePartitionsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates partitions in a table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   BatchUpdatePartitionsRequest request =
   *       BatchUpdatePartitionsRequest.newBuilder()
   *           .setParent(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
   *           .addAllRequests(new ArrayList<UpdatePartitionRequest>())
   *           .build();
   *   ApiFuture<BatchUpdatePartitionsResponse> future =
   *       hiveMetastoreServiceClient.batchUpdatePartitionsCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdatePartitionsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdatePartitionsRequest, BatchUpdatePartitionsResponse>
      batchUpdatePartitionsCallable() {
    return stub.batchUpdatePartitionsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Streams list of partitions from a table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (HiveMetastoreServiceClient hiveMetastoreServiceClient =
   *     HiveMetastoreServiceClient.create()) {
   *   ListPartitionsRequest request =
   *       ListPartitionsRequest.newBuilder()
   *           .setParent(TableName.of("[PROJECT]", "[CATALOG]", "[DATABASE]", "[TABLE]").toString())
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ServerStream<ListPartitionsResponse> stream =
   *       hiveMetastoreServiceClient.listPartitionsCallable().call(request);
   *   for (ListPartitionsResponse response : stream) {
   *     // Do something when a response is received.
   *   }
   * }
   * }</pre>
   */
  public final ServerStreamingCallable<ListPartitionsRequest, ListPartitionsResponse>
      listPartitionsCallable() {
    return stub.listPartitionsCallable();
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

  public static class ListHiveCatalogsPagedResponse
      extends AbstractPagedListResponse<
          ListHiveCatalogsRequest,
          ListHiveCatalogsResponse,
          HiveCatalog,
          ListHiveCatalogsPage,
          ListHiveCatalogsFixedSizeCollection> {

    public static ApiFuture<ListHiveCatalogsPagedResponse> createAsync(
        PageContext<ListHiveCatalogsRequest, ListHiveCatalogsResponse, HiveCatalog> context,
        ApiFuture<ListHiveCatalogsResponse> futureResponse) {
      ApiFuture<ListHiveCatalogsPage> futurePage =
          ListHiveCatalogsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListHiveCatalogsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListHiveCatalogsPagedResponse(ListHiveCatalogsPage page) {
      super(page, ListHiveCatalogsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListHiveCatalogsPage
      extends AbstractPage<
          ListHiveCatalogsRequest, ListHiveCatalogsResponse, HiveCatalog, ListHiveCatalogsPage> {

    private ListHiveCatalogsPage(
        PageContext<ListHiveCatalogsRequest, ListHiveCatalogsResponse, HiveCatalog> context,
        ListHiveCatalogsResponse response) {
      super(context, response);
    }

    private static ListHiveCatalogsPage createEmptyPage() {
      return new ListHiveCatalogsPage(null, null);
    }

    @Override
    protected ListHiveCatalogsPage createPage(
        PageContext<ListHiveCatalogsRequest, ListHiveCatalogsResponse, HiveCatalog> context,
        ListHiveCatalogsResponse response) {
      return new ListHiveCatalogsPage(context, response);
    }

    @Override
    public ApiFuture<ListHiveCatalogsPage> createPageAsync(
        PageContext<ListHiveCatalogsRequest, ListHiveCatalogsResponse, HiveCatalog> context,
        ApiFuture<ListHiveCatalogsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListHiveCatalogsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListHiveCatalogsRequest,
          ListHiveCatalogsResponse,
          HiveCatalog,
          ListHiveCatalogsPage,
          ListHiveCatalogsFixedSizeCollection> {

    private ListHiveCatalogsFixedSizeCollection(
        List<ListHiveCatalogsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListHiveCatalogsFixedSizeCollection createEmptyCollection() {
      return new ListHiveCatalogsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListHiveCatalogsFixedSizeCollection createCollection(
        List<ListHiveCatalogsPage> pages, int collectionSize) {
      return new ListHiveCatalogsFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListHiveDatabasesPagedResponse
      extends AbstractPagedListResponse<
          ListHiveDatabasesRequest,
          ListHiveDatabasesResponse,
          HiveDatabase,
          ListHiveDatabasesPage,
          ListHiveDatabasesFixedSizeCollection> {

    public static ApiFuture<ListHiveDatabasesPagedResponse> createAsync(
        PageContext<ListHiveDatabasesRequest, ListHiveDatabasesResponse, HiveDatabase> context,
        ApiFuture<ListHiveDatabasesResponse> futureResponse) {
      ApiFuture<ListHiveDatabasesPage> futurePage =
          ListHiveDatabasesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListHiveDatabasesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListHiveDatabasesPagedResponse(ListHiveDatabasesPage page) {
      super(page, ListHiveDatabasesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListHiveDatabasesPage
      extends AbstractPage<
          ListHiveDatabasesRequest,
          ListHiveDatabasesResponse,
          HiveDatabase,
          ListHiveDatabasesPage> {

    private ListHiveDatabasesPage(
        PageContext<ListHiveDatabasesRequest, ListHiveDatabasesResponse, HiveDatabase> context,
        ListHiveDatabasesResponse response) {
      super(context, response);
    }

    private static ListHiveDatabasesPage createEmptyPage() {
      return new ListHiveDatabasesPage(null, null);
    }

    @Override
    protected ListHiveDatabasesPage createPage(
        PageContext<ListHiveDatabasesRequest, ListHiveDatabasesResponse, HiveDatabase> context,
        ListHiveDatabasesResponse response) {
      return new ListHiveDatabasesPage(context, response);
    }

    @Override
    public ApiFuture<ListHiveDatabasesPage> createPageAsync(
        PageContext<ListHiveDatabasesRequest, ListHiveDatabasesResponse, HiveDatabase> context,
        ApiFuture<ListHiveDatabasesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListHiveDatabasesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListHiveDatabasesRequest,
          ListHiveDatabasesResponse,
          HiveDatabase,
          ListHiveDatabasesPage,
          ListHiveDatabasesFixedSizeCollection> {

    private ListHiveDatabasesFixedSizeCollection(
        List<ListHiveDatabasesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListHiveDatabasesFixedSizeCollection createEmptyCollection() {
      return new ListHiveDatabasesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListHiveDatabasesFixedSizeCollection createCollection(
        List<ListHiveDatabasesPage> pages, int collectionSize) {
      return new ListHiveDatabasesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListHiveTablesPagedResponse
      extends AbstractPagedListResponse<
          ListHiveTablesRequest,
          ListHiveTablesResponse,
          HiveTable,
          ListHiveTablesPage,
          ListHiveTablesFixedSizeCollection> {

    public static ApiFuture<ListHiveTablesPagedResponse> createAsync(
        PageContext<ListHiveTablesRequest, ListHiveTablesResponse, HiveTable> context,
        ApiFuture<ListHiveTablesResponse> futureResponse) {
      ApiFuture<ListHiveTablesPage> futurePage =
          ListHiveTablesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListHiveTablesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListHiveTablesPagedResponse(ListHiveTablesPage page) {
      super(page, ListHiveTablesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListHiveTablesPage
      extends AbstractPage<
          ListHiveTablesRequest, ListHiveTablesResponse, HiveTable, ListHiveTablesPage> {

    private ListHiveTablesPage(
        PageContext<ListHiveTablesRequest, ListHiveTablesResponse, HiveTable> context,
        ListHiveTablesResponse response) {
      super(context, response);
    }

    private static ListHiveTablesPage createEmptyPage() {
      return new ListHiveTablesPage(null, null);
    }

    @Override
    protected ListHiveTablesPage createPage(
        PageContext<ListHiveTablesRequest, ListHiveTablesResponse, HiveTable> context,
        ListHiveTablesResponse response) {
      return new ListHiveTablesPage(context, response);
    }

    @Override
    public ApiFuture<ListHiveTablesPage> createPageAsync(
        PageContext<ListHiveTablesRequest, ListHiveTablesResponse, HiveTable> context,
        ApiFuture<ListHiveTablesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListHiveTablesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListHiveTablesRequest,
          ListHiveTablesResponse,
          HiveTable,
          ListHiveTablesPage,
          ListHiveTablesFixedSizeCollection> {

    private ListHiveTablesFixedSizeCollection(List<ListHiveTablesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListHiveTablesFixedSizeCollection createEmptyCollection() {
      return new ListHiveTablesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListHiveTablesFixedSizeCollection createCollection(
        List<ListHiveTablesPage> pages, int collectionSize) {
      return new ListHiveTablesFixedSizeCollection(pages, collectionSize);
    }
  }
}
