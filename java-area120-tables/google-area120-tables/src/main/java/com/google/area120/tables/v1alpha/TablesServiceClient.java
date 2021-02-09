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

package com.google.area120.tables.v1alpha;

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
import com.google.area120.tables.v1alpha.stub.TablesServiceStub;
import com.google.area120.tables.v1alpha.stub.TablesServiceStubSettings;
import com.google.area120.tables.v1alpha1.BatchCreateRowsRequest;
import com.google.area120.tables.v1alpha1.BatchCreateRowsResponse;
import com.google.area120.tables.v1alpha1.BatchUpdateRowsRequest;
import com.google.area120.tables.v1alpha1.BatchUpdateRowsResponse;
import com.google.area120.tables.v1alpha1.CreateRowRequest;
import com.google.area120.tables.v1alpha1.DeleteRowRequest;
import com.google.area120.tables.v1alpha1.GetRowRequest;
import com.google.area120.tables.v1alpha1.GetTableRequest;
import com.google.area120.tables.v1alpha1.ListRowsRequest;
import com.google.area120.tables.v1alpha1.ListRowsResponse;
import com.google.area120.tables.v1alpha1.ListTablesRequest;
import com.google.area120.tables.v1alpha1.ListTablesResponse;
import com.google.area120.tables.v1alpha1.Row;
import com.google.area120.tables.v1alpha1.RowName;
import com.google.area120.tables.v1alpha1.Table;
import com.google.area120.tables.v1alpha1.UpdateRowRequest;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: The Tables Service provides an API for reading and updating tables. It
 * defines the following resource model:
 *
 * <p>- The API has a collection of [Table][google.area120.tables.v1alpha1.Table] resources, named
 * `tables/&#42;`
 *
 * <p>- Each Table has a collection of [Row][google.area120.tables.v1alpha1.Row] resources, named
 * `tables/&#42;/rows/&#42;`
 *
 * <p>This class provides the ability to make remote calls to the backing service through method
 * calls that map to API methods. Sample code to get started:
 *
 * <pre>{@code
 * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
 *   String name = "name3373707";
 *   Table response = tablesServiceClient.getTable(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the TablesServiceClient object to clean up resources such
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
 * <p>This class can be customized by passing in a custom instance of TablesServiceSettings to
 * create(). For example:
 *
 * <p>To customize credentials:
 *
 * <pre>{@code
 * TablesServiceSettings tablesServiceSettings =
 *     TablesServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * TablesServiceClient tablesServiceClient = TablesServiceClient.create(tablesServiceSettings);
 * }</pre>
 *
 * <p>To customize the endpoint:
 *
 * <pre>{@code
 * TablesServiceSettings tablesServiceSettings =
 *     TablesServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * TablesServiceClient tablesServiceClient = TablesServiceClient.create(tablesServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class TablesServiceClient implements BackgroundResource {
  private final TablesServiceSettings settings;
  private final TablesServiceStub stub;

  /** Constructs an instance of TablesServiceClient with default settings. */
  public static final TablesServiceClient create() throws IOException {
    return create(TablesServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of TablesServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final TablesServiceClient create(TablesServiceSettings settings)
      throws IOException {
    return new TablesServiceClient(settings);
  }

  /**
   * Constructs an instance of TablesServiceClient, using the given stub for making calls. This is
   * for advanced usage - prefer using create(TablesServiceSettings).
   */
  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public static final TablesServiceClient create(TablesServiceStub stub) {
    return new TablesServiceClient(stub);
  }

  /**
   * Constructs an instance of TablesServiceClient, using the given settings. This is protected so
   * that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected TablesServiceClient(TablesServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((TablesServiceStubSettings) settings.getStubSettings()).createStub();
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  protected TablesServiceClient(TablesServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final TablesServiceSettings getSettings() {
    return settings;
  }

  @BetaApi("A restructuring of stub classes is planned, so this may break in the future")
  public TablesServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a table. Returns NOT_FOUND if the table does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   String name = "name3373707";
   *   Table response = tablesServiceClient.getTable(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the table to retrieve. Format: tables/{table}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Table getTable(String name) {
    GetTableRequest request = GetTableRequest.newBuilder().setName(name).build();
    return getTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a table. Returns NOT_FOUND if the table does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   GetTableRequest request = GetTableRequest.newBuilder().setName("name3373707").build();
   *   Table response = tablesServiceClient.getTable(request);
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
   * Gets a table. Returns NOT_FOUND if the table does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   GetTableRequest request = GetTableRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Table> future = tablesServiceClient.getTableCallable().futureCall(request);
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
   * Lists tables for the user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   ListTablesRequest request =
   *       ListTablesRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Table element : tablesServiceClient.listTables(request).iterateAll()) {
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
   * Lists tables for the user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   ListTablesRequest request =
   *       ListTablesRequest.newBuilder()
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Table> future = tablesServiceClient.listTablesPagedCallable().futureCall(request);
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
   * Lists tables for the user.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   while (true) {
   *     ListTablesResponse response = tablesServiceClient.listTablesCallable().call(request);
   *     for (Table element : response.getResponsesList()) {
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

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a row. Returns NOT_FOUND if the row does not exist in the table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   String name = "name3373707";
   *   Row response = tablesServiceClient.getRow(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the row to retrieve. Format: tables/{table}/rows/{row}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Row getRow(String name) {
    GetRowRequest request = GetRowRequest.newBuilder().setName(name).build();
    return getRow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a row. Returns NOT_FOUND if the row does not exist in the table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   GetRowRequest request = GetRowRequest.newBuilder().setName("name3373707").build();
   *   Row response = tablesServiceClient.getRow(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Row getRow(GetRowRequest request) {
    return getRowCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Gets a row. Returns NOT_FOUND if the row does not exist in the table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   GetRowRequest request = GetRowRequest.newBuilder().setName("name3373707").build();
   *   ApiFuture<Row> future = tablesServiceClient.getRowCallable().futureCall(request);
   *   // Do something.
   *   Row response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetRowRequest, Row> getRowCallable() {
    return stub.getRowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists rows in a table. Returns NOT_FOUND if the table does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   String parent = "parent-995424086";
   *   for (Row element : tablesServiceClient.listRows(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent table. Format: tables/{table}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRowsPagedResponse listRows(String parent) {
    ListRowsRequest request = ListRowsRequest.newBuilder().setParent(parent).build();
    return listRows(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists rows in a table. Returns NOT_FOUND if the table does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   ListRowsRequest request =
   *       ListRowsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (Row element : tablesServiceClient.listRows(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListRowsPagedResponse listRows(ListRowsRequest request) {
    return listRowsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists rows in a table. Returns NOT_FOUND if the table does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   ListRowsRequest request =
   *       ListRowsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<Row> future = tablesServiceClient.listRowsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (Row element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListRowsRequest, ListRowsPagedResponse> listRowsPagedCallable() {
    return stub.listRowsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists rows in a table. Returns NOT_FOUND if the table does not exist.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   while (true) {
   *     ListRowsResponse response = tablesServiceClient.listRowsCallable().call(request);
   *     for (Row element : response.getResponsesList()) {
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
  public final UnaryCallable<ListRowsRequest, ListRowsResponse> listRowsCallable() {
    return stub.listRowsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a row.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   String parent = "parent-995424086";
   *   Row row = Row.newBuilder().build();
   *   Row response = tablesServiceClient.createRow(parent, row);
   * }
   * }</pre>
   *
   * @param parent Required. The parent table where this row will be created. Format: tables/{table}
   * @param row Required. The row to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Row createRow(String parent, Row row) {
    CreateRowRequest request = CreateRowRequest.newBuilder().setParent(parent).setRow(row).build();
    return createRow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a row.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   CreateRowRequest request =
   *       CreateRowRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setRow(Row.newBuilder().build())
   *           .build();
   *   Row response = tablesServiceClient.createRow(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Row createRow(CreateRowRequest request) {
    return createRowCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates a row.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   CreateRowRequest request =
   *       CreateRowRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .setRow(Row.newBuilder().build())
   *           .build();
   *   ApiFuture<Row> future = tablesServiceClient.createRowCallable().futureCall(request);
   *   // Do something.
   *   Row response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateRowRequest, Row> createRowCallable() {
    return stub.createRowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates multiple rows.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   BatchCreateRowsRequest request =
   *       BatchCreateRowsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllRequests(new ArrayList<CreateRowRequest>())
   *           .build();
   *   BatchCreateRowsResponse response = tablesServiceClient.batchCreateRows(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchCreateRowsResponse batchCreateRows(BatchCreateRowsRequest request) {
    return batchCreateRowsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates multiple rows.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   BatchCreateRowsRequest request =
   *       BatchCreateRowsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllRequests(new ArrayList<CreateRowRequest>())
   *           .build();
   *   ApiFuture<BatchCreateRowsResponse> future =
   *       tablesServiceClient.batchCreateRowsCallable().futureCall(request);
   *   // Do something.
   *   BatchCreateRowsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchCreateRowsRequest, BatchCreateRowsResponse>
      batchCreateRowsCallable() {
    return stub.batchCreateRowsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a row.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   Row row = Row.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   Row response = tablesServiceClient.updateRow(row, updateMask);
   * }
   * }</pre>
   *
   * @param row Required. The row to update.
   * @param updateMask The list of fields to update.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Row updateRow(Row row, FieldMask updateMask) {
    UpdateRowRequest request =
        UpdateRowRequest.newBuilder().setRow(row).setUpdateMask(updateMask).build();
    return updateRow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a row.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   UpdateRowRequest request =
   *       UpdateRowRequest.newBuilder()
   *           .setRow(Row.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   Row response = tablesServiceClient.updateRow(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final Row updateRow(UpdateRowRequest request) {
    return updateRowCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates a row.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   UpdateRowRequest request =
   *       UpdateRowRequest.newBuilder()
   *           .setRow(Row.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<Row> future = tablesServiceClient.updateRowCallable().futureCall(request);
   *   // Do something.
   *   Row response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateRowRequest, Row> updateRowCallable() {
    return stub.updateRowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates multiple rows.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   BatchUpdateRowsRequest request =
   *       BatchUpdateRowsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllRequests(new ArrayList<UpdateRowRequest>())
   *           .build();
   *   BatchUpdateRowsResponse response = tablesServiceClient.batchUpdateRows(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BatchUpdateRowsResponse batchUpdateRows(BatchUpdateRowsRequest request) {
    return batchUpdateRowsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates multiple rows.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   BatchUpdateRowsRequest request =
   *       BatchUpdateRowsRequest.newBuilder()
   *           .setParent("parent-995424086")
   *           .addAllRequests(new ArrayList<UpdateRowRequest>())
   *           .build();
   *   ApiFuture<BatchUpdateRowsResponse> future =
   *       tablesServiceClient.batchUpdateRowsCallable().futureCall(request);
   *   // Do something.
   *   BatchUpdateRowsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BatchUpdateRowsRequest, BatchUpdateRowsResponse>
      batchUpdateRowsCallable() {
    return stub.batchUpdateRowsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a row.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   RowName name = RowName.of("[TABLE]", "[ROW]");
   *   tablesServiceClient.deleteRow(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the row to delete. Format: tables/{table}/rows/{row}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRow(RowName name) {
    DeleteRowRequest request =
        DeleteRowRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteRow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a row.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   String name = RowName.of("[TABLE]", "[ROW]").toString();
   *   tablesServiceClient.deleteRow(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the row to delete. Format: tables/{table}/rows/{row}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRow(String name) {
    DeleteRowRequest request = DeleteRowRequest.newBuilder().setName(name).build();
    deleteRow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a row.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   DeleteRowRequest request =
   *       DeleteRowRequest.newBuilder().setName(RowName.of("[TABLE]", "[ROW]").toString()).build();
   *   tablesServiceClient.deleteRow(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteRow(DeleteRowRequest request) {
    deleteRowCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a row.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * try (TablesServiceClient tablesServiceClient = TablesServiceClient.create()) {
   *   DeleteRowRequest request =
   *       DeleteRowRequest.newBuilder().setName(RowName.of("[TABLE]", "[ROW]").toString()).build();
   *   ApiFuture<Empty> future = tablesServiceClient.deleteRowCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteRowRequest, Empty> deleteRowCallable() {
    return stub.deleteRowCallable();
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
          futurePage,
          new ApiFunction<ListTablesPage, ListTablesPagedResponse>() {
            @Override
            public ListTablesPagedResponse apply(ListTablesPage input) {
              return new ListTablesPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
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

  public static class ListRowsPagedResponse
      extends AbstractPagedListResponse<
          ListRowsRequest, ListRowsResponse, Row, ListRowsPage, ListRowsFixedSizeCollection> {

    public static ApiFuture<ListRowsPagedResponse> createAsync(
        PageContext<ListRowsRequest, ListRowsResponse, Row> context,
        ApiFuture<ListRowsResponse> futureResponse) {
      ApiFuture<ListRowsPage> futurePage =
          ListRowsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          new ApiFunction<ListRowsPage, ListRowsPagedResponse>() {
            @Override
            public ListRowsPagedResponse apply(ListRowsPage input) {
              return new ListRowsPagedResponse(input);
            }
          },
          MoreExecutors.directExecutor());
    }

    private ListRowsPagedResponse(ListRowsPage page) {
      super(page, ListRowsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListRowsPage
      extends AbstractPage<ListRowsRequest, ListRowsResponse, Row, ListRowsPage> {

    private ListRowsPage(
        PageContext<ListRowsRequest, ListRowsResponse, Row> context, ListRowsResponse response) {
      super(context, response);
    }

    private static ListRowsPage createEmptyPage() {
      return new ListRowsPage(null, null);
    }

    @Override
    protected ListRowsPage createPage(
        PageContext<ListRowsRequest, ListRowsResponse, Row> context, ListRowsResponse response) {
      return new ListRowsPage(context, response);
    }

    @Override
    public ApiFuture<ListRowsPage> createPageAsync(
        PageContext<ListRowsRequest, ListRowsResponse, Row> context,
        ApiFuture<ListRowsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListRowsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListRowsRequest, ListRowsResponse, Row, ListRowsPage, ListRowsFixedSizeCollection> {

    private ListRowsFixedSizeCollection(List<ListRowsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListRowsFixedSizeCollection createEmptyCollection() {
      return new ListRowsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListRowsFixedSizeCollection createCollection(
        List<ListRowsPage> pages, int collectionSize) {
      return new ListRowsFixedSizeCollection(pages, collectionSize);
    }
  }
}
