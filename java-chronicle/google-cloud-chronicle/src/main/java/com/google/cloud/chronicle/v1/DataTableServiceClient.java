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
import com.google.cloud.chronicle.v1.stub.DataTableServiceStub;
import com.google.cloud.chronicle.v1.stub.DataTableServiceStubSettings;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: DataTableManager provides an interface for managing data tables.
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
 * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
 *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
 *   DataTable dataTable = DataTable.newBuilder().build();
 *   String dataTableId = "dataTableId1260854911";
 *   DataTable response = dataTableServiceClient.createDataTable(parent, dataTable, dataTableId);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataTableServiceClient object to clean up resources
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
 *      <td><p> CreateDataTable</td>
 *      <td><p> Create a new data table.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDataTable(CreateDataTableRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createDataTable(InstanceName parent, DataTable dataTable, String dataTableId)
 *           <li><p> createDataTable(String parent, DataTable dataTable, String dataTableId)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDataTableCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDataTables</td>
 *      <td><p> List data tables.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDataTables(ListDataTablesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDataTables(InstanceName parent)
 *           <li><p> listDataTables(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDataTablesPagedCallable()
 *           <li><p> listDataTablesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDataTable</td>
 *      <td><p> Get data table info.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDataTable(GetDataTableRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDataTable(DataTableName name)
 *           <li><p> getDataTable(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDataTableCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDataTable</td>
 *      <td><p> Update data table.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDataTable(UpdateDataTableRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDataTable(DataTable dataTable, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDataTableCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDataTable</td>
 *      <td><p> Delete data table.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDataTable(DeleteDataTableRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteDataTable(DataTableName name, boolean force)
 *           <li><p> deleteDataTable(String name, boolean force)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDataTableCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDataTableRow</td>
 *      <td><p> Create a new data table row.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDataTableRow(CreateDataTableRowRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createDataTableRow(DataTableName parent, DataTableRow dataTableRow)
 *           <li><p> createDataTableRow(String parent, DataTableRow dataTableRow)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDataTableRowCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDataTableRow</td>
 *      <td><p> Update data table row</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDataTableRow(UpdateDataTableRowRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDataTableRow(DataTableRow dataTableRow, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDataTableRowCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDataTableRows</td>
 *      <td><p> List data table rows.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDataTableRows(ListDataTableRowsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDataTableRows(DataTableName parent)
 *           <li><p> listDataTableRows(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDataTableRowsPagedCallable()
 *           <li><p> listDataTableRowsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDataTableRow</td>
 *      <td><p> Get data table row</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDataTableRow(GetDataTableRowRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDataTableRow(DataTableRowName name)
 *           <li><p> getDataTableRow(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDataTableRowCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDataTableRow</td>
 *      <td><p> Delete data table row.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDataTableRow(DeleteDataTableRowRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteDataTableRow(DataTableRowName name)
 *           <li><p> deleteDataTableRow(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDataTableRowCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BulkCreateDataTableRows</td>
 *      <td><p> Create data table rows in bulk.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> bulkCreateDataTableRows(DataTableName parent, List&lt;CreateDataTableRowRequest&gt; requests)
 *           <li><p> bulkCreateDataTableRows(String parent, List&lt;CreateDataTableRowRequest&gt; requests)
 *           <li><p> bulkCreateDataTableRows(BulkCreateDataTableRowsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> bulkCreateDataTableRowsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BulkGetDataTableRows</td>
 *      <td><p> Get data table rows in bulk.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> bulkGetDataTableRows(DataTableName parent, List&lt;GetDataTableRowRequest&gt; requests)
 *           <li><p> bulkGetDataTableRows(String parent, List&lt;GetDataTableRowRequest&gt; requests)
 *           <li><p> bulkGetDataTableRows(BulkGetDataTableRowsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> bulkGetDataTableRowsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BulkReplaceDataTableRows</td>
 *      <td><p> Replace all existing data table rows with new data table rows.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> bulkReplaceDataTableRows(DataTableName parent, List&lt;CreateDataTableRowRequest&gt; requests)
 *           <li><p> bulkReplaceDataTableRows(String parent, List&lt;CreateDataTableRowRequest&gt; requests)
 *           <li><p> bulkReplaceDataTableRows(BulkReplaceDataTableRowsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> bulkReplaceDataTableRowsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> BulkUpdateDataTableRows</td>
 *      <td><p> Update data table rows in bulk.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> bulkUpdateDataTableRows(DataTableName parent, List&lt;UpdateDataTableRowRequest&gt; requests)
 *           <li><p> bulkUpdateDataTableRows(String parent, List&lt;UpdateDataTableRowRequest&gt; requests)
 *           <li><p> bulkUpdateDataTableRows(BulkUpdateDataTableRowsRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> bulkUpdateDataTableRowsCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> GetDataTableOperationErrors</td>
 *      <td><p> Get the error for a data table operation.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDataTableOperationErrors(GetDataTableOperationErrorsRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDataTableOperationErrors(DataTableOperationErrorsName name)
 *           <li><p> getDataTableOperationErrors(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDataTableOperationErrorsCallable()
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
 * <p>This class can be customized by passing in a custom instance of DataTableServiceSettings to
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
 * DataTableServiceSettings dataTableServiceSettings =
 *     DataTableServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataTableServiceClient dataTableServiceClient =
 *     DataTableServiceClient.create(dataTableServiceSettings);
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
 * DataTableServiceSettings dataTableServiceSettings =
 *     DataTableServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataTableServiceClient dataTableServiceClient =
 *     DataTableServiceClient.create(dataTableServiceSettings);
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
 * DataTableServiceSettings dataTableServiceSettings =
 *     DataTableServiceSettings.newHttpJsonBuilder().build();
 * DataTableServiceClient dataTableServiceClient =
 *     DataTableServiceClient.create(dataTableServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@Generated("by gapic-generator-java")
public class DataTableServiceClient implements BackgroundResource {
  private final DataTableServiceSettings settings;
  private final DataTableServiceStub stub;

  /** Constructs an instance of DataTableServiceClient with default settings. */
  public static final DataTableServiceClient create() throws IOException {
    return create(DataTableServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataTableServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataTableServiceClient create(DataTableServiceSettings settings)
      throws IOException {
    return new DataTableServiceClient(settings);
  }

  /**
   * Constructs an instance of DataTableServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(DataTableServiceSettings).
   */
  public static final DataTableServiceClient create(DataTableServiceStub stub) {
    return new DataTableServiceClient(stub);
  }

  /**
   * Constructs an instance of DataTableServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DataTableServiceClient(DataTableServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DataTableServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected DataTableServiceClient(DataTableServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DataTableServiceSettings getSettings() {
    return settings;
  }

  public DataTableServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new data table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   DataTable dataTable = DataTable.newBuilder().build();
   *   String dataTableId = "dataTableId1260854911";
   *   DataTable response = dataTableServiceClient.createDataTable(parent, dataTable, dataTableId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this data table will be created. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @param dataTable Required. The data table being created.
   * @param dataTableId Required. The ID to use for the data table. This is also the display name
   *     for the data table. It must satisfy the following requirements: - Starts with letter. -
   *     Contains only letters, numbers and underscore. - Must be unique and has length &lt; 256.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataTable createDataTable(
      InstanceName parent, DataTable dataTable, String dataTableId) {
    CreateDataTableRequest request =
        CreateDataTableRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataTable(dataTable)
            .setDataTableId(dataTableId)
            .build();
    return createDataTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new data table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   DataTable dataTable = DataTable.newBuilder().build();
   *   String dataTableId = "dataTableId1260854911";
   *   DataTable response = dataTableServiceClient.createDataTable(parent, dataTable, dataTableId);
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this data table will be created. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @param dataTable Required. The data table being created.
   * @param dataTableId Required. The ID to use for the data table. This is also the display name
   *     for the data table. It must satisfy the following requirements: - Starts with letter. -
   *     Contains only letters, numbers and underscore. - Must be unique and has length &lt; 256.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataTable createDataTable(String parent, DataTable dataTable, String dataTableId) {
    CreateDataTableRequest request =
        CreateDataTableRequest.newBuilder()
            .setParent(parent)
            .setDataTable(dataTable)
            .setDataTableId(dataTableId)
            .build();
    return createDataTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new data table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   CreateDataTableRequest request =
   *       CreateDataTableRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setDataTable(DataTable.newBuilder().build())
   *           .setDataTableId("dataTableId1260854911")
   *           .build();
   *   DataTable response = dataTableServiceClient.createDataTable(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataTable createDataTable(CreateDataTableRequest request) {
    return createDataTableCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new data table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   CreateDataTableRequest request =
   *       CreateDataTableRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setDataTable(DataTable.newBuilder().build())
   *           .setDataTableId("dataTableId1260854911")
   *           .build();
   *   ApiFuture<DataTable> future =
   *       dataTableServiceClient.createDataTableCallable().futureCall(request);
   *   // Do something.
   *   DataTable response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDataTableRequest, DataTable> createDataTableCallable() {
    return stub.createDataTableCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List data tables.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   InstanceName parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]");
   *   for (DataTable element : dataTableServiceClient.listDataTables(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this data table will be created. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataTablesPagedResponse listDataTables(InstanceName parent) {
    ListDataTablesRequest request =
        ListDataTablesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataTables(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List data tables.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   String parent = InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString();
   *   for (DataTable element : dataTableServiceClient.listDataTables(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The parent resource where this data table will be created. Format:
   *     projects/{project}/locations/{location}/instances/{instance}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataTablesPagedResponse listDataTables(String parent) {
    ListDataTablesRequest request = ListDataTablesRequest.newBuilder().setParent(parent).build();
    return listDataTables(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List data tables.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   ListDataTablesRequest request =
   *       ListDataTablesRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   for (DataTable element : dataTableServiceClient.listDataTables(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataTablesPagedResponse listDataTables(ListDataTablesRequest request) {
    return listDataTablesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List data tables.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   ListDataTablesRequest request =
   *       ListDataTablesRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   ApiFuture<DataTable> future =
   *       dataTableServiceClient.listDataTablesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataTable element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDataTablesRequest, ListDataTablesPagedResponse>
      listDataTablesPagedCallable() {
    return stub.listDataTablesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List data tables.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   ListDataTablesRequest request =
   *       ListDataTablesRequest.newBuilder()
   *           .setParent(InstanceName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .build();
   *   while (true) {
   *     ListDataTablesResponse response =
   *         dataTableServiceClient.listDataTablesCallable().call(request);
   *     for (DataTable element : response.getDataTablesList()) {
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
  public final UnaryCallable<ListDataTablesRequest, ListDataTablesResponse>
      listDataTablesCallable() {
    return stub.listDataTablesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get data table info.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   DataTableName name =
   *       DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
   *   DataTable response = dataTableServiceClient.getDataTable(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the data table to retrieve. Format:
   *     projects/{project}/locations/{location}/instances/{instances}/dataTables/{data_table}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataTable getDataTable(DataTableName name) {
    GetDataTableRequest request =
        GetDataTableRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get data table info.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   String name =
   *       DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]").toString();
   *   DataTable response = dataTableServiceClient.getDataTable(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the data table to retrieve. Format:
   *     projects/{project}/locations/{location}/instances/{instances}/dataTables/{data_table}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataTable getDataTable(String name) {
    GetDataTableRequest request = GetDataTableRequest.newBuilder().setName(name).build();
    return getDataTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get data table info.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   GetDataTableRequest request =
   *       GetDataTableRequest.newBuilder()
   *           .setName(
   *               DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]")
   *                   .toString())
   *           .build();
   *   DataTable response = dataTableServiceClient.getDataTable(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataTable getDataTable(GetDataTableRequest request) {
    return getDataTableCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get data table info.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   GetDataTableRequest request =
   *       GetDataTableRequest.newBuilder()
   *           .setName(
   *               DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DataTable> future =
   *       dataTableServiceClient.getDataTableCallable().futureCall(request);
   *   // Do something.
   *   DataTable response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataTableRequest, DataTable> getDataTableCallable() {
    return stub.getDataTableCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update data table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   DataTable dataTable = DataTable.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DataTable response = dataTableServiceClient.updateDataTable(dataTable, updateMask);
   * }
   * }</pre>
   *
   * @param dataTable Required. This field is used to identify the datatable to update. Format:
   *     projects/{project}/locations/{locations}/instances/{instance}/dataTables/{data_table}
   * @param updateMask Optional. The list of metadata fields to update. Currently data tables only
   *     support updating the `description`, `row_time_to_live` and `scope_info` fields. When no
   *     field mask is supplied, all non-empty fields will be updated. A field mask of "&#42;" will
   *     update all fields, whether empty or not.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataTable updateDataTable(DataTable dataTable, FieldMask updateMask) {
    UpdateDataTableRequest request =
        UpdateDataTableRequest.newBuilder()
            .setDataTable(dataTable)
            .setUpdateMask(updateMask)
            .build();
    return updateDataTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update data table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   UpdateDataTableRequest request =
   *       UpdateDataTableRequest.newBuilder()
   *           .setDataTable(DataTable.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   DataTable response = dataTableServiceClient.updateDataTable(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataTable updateDataTable(UpdateDataTableRequest request) {
    return updateDataTableCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update data table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   UpdateDataTableRequest request =
   *       UpdateDataTableRequest.newBuilder()
   *           .setDataTable(DataTable.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<DataTable> future =
   *       dataTableServiceClient.updateDataTableCallable().futureCall(request);
   *   // Do something.
   *   DataTable response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDataTableRequest, DataTable> updateDataTableCallable() {
    return stub.updateDataTableCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete data table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   DataTableName name =
   *       DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
   *   boolean force = true;
   *   dataTableServiceClient.deleteDataTable(name, force);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the data table to delete. Format
   *     projects/{project}/locations/{location}/instances/{instances}/dataTables/{data_table}
   * @param force Optional. If set to true, any rows under this data table will also be deleted.
   *     (Otherwise, the request will only work if the data table has no rows.)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataTable(DataTableName name, boolean force) {
    DeleteDataTableRequest request =
        DeleteDataTableRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .setForce(force)
            .build();
    deleteDataTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete data table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   String name =
   *       DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]").toString();
   *   boolean force = true;
   *   dataTableServiceClient.deleteDataTable(name, force);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the data table to delete. Format
   *     projects/{project}/locations/{location}/instances/{instances}/dataTables/{data_table}
   * @param force Optional. If set to true, any rows under this data table will also be deleted.
   *     (Otherwise, the request will only work if the data table has no rows.)
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataTable(String name, boolean force) {
    DeleteDataTableRequest request =
        DeleteDataTableRequest.newBuilder().setName(name).setForce(force).build();
    deleteDataTable(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete data table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   DeleteDataTableRequest request =
   *       DeleteDataTableRequest.newBuilder()
   *           .setName(
   *               DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   dataTableServiceClient.deleteDataTable(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataTable(DeleteDataTableRequest request) {
    deleteDataTableCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete data table.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   DeleteDataTableRequest request =
   *       DeleteDataTableRequest.newBuilder()
   *           .setName(
   *               DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]")
   *                   .toString())
   *           .setForce(true)
   *           .build();
   *   ApiFuture<Empty> future =
   *       dataTableServiceClient.deleteDataTableCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDataTableRequest, Empty> deleteDataTableCallable() {
    return stub.deleteDataTableCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new data table row.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   DataTableName parent =
   *       DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
   *   DataTableRow dataTableRow = DataTableRow.newBuilder().build();
   *   DataTableRow response = dataTableServiceClient.createDataTableRow(parent, dataTableRow);
   * }
   * }</pre>
   *
   * @param parent Required. The resource id of the data table. Format:
   *     /projects/{project}/locations/{location}/instances/{instance}/dataTables/{data_table}
   * @param dataTableRow Required. The data table row to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataTableRow createDataTableRow(DataTableName parent, DataTableRow dataTableRow) {
    CreateDataTableRowRequest request =
        CreateDataTableRowRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataTableRow(dataTableRow)
            .build();
    return createDataTableRow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new data table row.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   String parent =
   *       DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]").toString();
   *   DataTableRow dataTableRow = DataTableRow.newBuilder().build();
   *   DataTableRow response = dataTableServiceClient.createDataTableRow(parent, dataTableRow);
   * }
   * }</pre>
   *
   * @param parent Required. The resource id of the data table. Format:
   *     /projects/{project}/locations/{location}/instances/{instance}/dataTables/{data_table}
   * @param dataTableRow Required. The data table row to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataTableRow createDataTableRow(String parent, DataTableRow dataTableRow) {
    CreateDataTableRowRequest request =
        CreateDataTableRowRequest.newBuilder()
            .setParent(parent)
            .setDataTableRow(dataTableRow)
            .build();
    return createDataTableRow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new data table row.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   CreateDataTableRowRequest request =
   *       CreateDataTableRowRequest.newBuilder()
   *           .setParent(
   *               DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]")
   *                   .toString())
   *           .setDataTableRow(DataTableRow.newBuilder().build())
   *           .build();
   *   DataTableRow response = dataTableServiceClient.createDataTableRow(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataTableRow createDataTableRow(CreateDataTableRowRequest request) {
    return createDataTableRowCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create a new data table row.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   CreateDataTableRowRequest request =
   *       CreateDataTableRowRequest.newBuilder()
   *           .setParent(
   *               DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]")
   *                   .toString())
   *           .setDataTableRow(DataTableRow.newBuilder().build())
   *           .build();
   *   ApiFuture<DataTableRow> future =
   *       dataTableServiceClient.createDataTableRowCallable().futureCall(request);
   *   // Do something.
   *   DataTableRow response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDataTableRowRequest, DataTableRow> createDataTableRowCallable() {
    return stub.createDataTableRowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update data table row
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   DataTableRow dataTableRow = DataTableRow.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DataTableRow response = dataTableServiceClient.updateDataTableRow(dataTableRow, updateMask);
   * }
   * }</pre>
   *
   * @param dataTableRow Required. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/dataTables/{data_table}/dataTableRows/{data_table_row}
   * @param updateMask Optional. The list of fields to update. Currently data table rows only
   *     support updating the `values` field. When no field mask is supplied, all non-empty fields
   *     will be updated. A field mask of "&#42;" will update all fields, whether empty or not.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataTableRow updateDataTableRow(DataTableRow dataTableRow, FieldMask updateMask) {
    UpdateDataTableRowRequest request =
        UpdateDataTableRowRequest.newBuilder()
            .setDataTableRow(dataTableRow)
            .setUpdateMask(updateMask)
            .build();
    return updateDataTableRow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update data table row
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   UpdateDataTableRowRequest request =
   *       UpdateDataTableRowRequest.newBuilder()
   *           .setDataTableRow(DataTableRow.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   DataTableRow response = dataTableServiceClient.updateDataTableRow(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataTableRow updateDataTableRow(UpdateDataTableRowRequest request) {
    return updateDataTableRowCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update data table row
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   UpdateDataTableRowRequest request =
   *       UpdateDataTableRowRequest.newBuilder()
   *           .setDataTableRow(DataTableRow.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<DataTableRow> future =
   *       dataTableServiceClient.updateDataTableRowCallable().futureCall(request);
   *   // Do something.
   *   DataTableRow response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDataTableRowRequest, DataTableRow> updateDataTableRowCallable() {
    return stub.updateDataTableRowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List data table rows.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   DataTableName parent =
   *       DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
   *   for (DataTableRow element : dataTableServiceClient.listDataTableRows(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource id of the data table. Format:
   *     projects/{project}/locations/{locations}/instances/{instance}/dataTables/{data_table}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataTableRowsPagedResponse listDataTableRows(DataTableName parent) {
    ListDataTableRowsRequest request =
        ListDataTableRowsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataTableRows(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List data table rows.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   String parent =
   *       DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]").toString();
   *   for (DataTableRow element : dataTableServiceClient.listDataTableRows(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The resource id of the data table. Format:
   *     projects/{project}/locations/{locations}/instances/{instance}/dataTables/{data_table}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataTableRowsPagedResponse listDataTableRows(String parent) {
    ListDataTableRowsRequest request =
        ListDataTableRowsRequest.newBuilder().setParent(parent).build();
    return listDataTableRows(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List data table rows.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   ListDataTableRowsRequest request =
   *       ListDataTableRowsRequest.newBuilder()
   *           .setParent(
   *               DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   for (DataTableRow element : dataTableServiceClient.listDataTableRows(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataTableRowsPagedResponse listDataTableRows(ListDataTableRowsRequest request) {
    return listDataTableRowsPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List data table rows.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   ListDataTableRowsRequest request =
   *       ListDataTableRowsRequest.newBuilder()
   *           .setParent(
   *               DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   ApiFuture<DataTableRow> future =
   *       dataTableServiceClient.listDataTableRowsPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataTableRow element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDataTableRowsRequest, ListDataTableRowsPagedResponse>
      listDataTableRowsPagedCallable() {
    return stub.listDataTableRowsPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * List data table rows.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   ListDataTableRowsRequest request =
   *       ListDataTableRowsRequest.newBuilder()
   *           .setParent(
   *               DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]")
   *                   .toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .setOrderBy("orderBy-1207110587")
   *           .setFilter("filter-1274492040")
   *           .build();
   *   while (true) {
   *     ListDataTableRowsResponse response =
   *         dataTableServiceClient.listDataTableRowsCallable().call(request);
   *     for (DataTableRow element : response.getDataTableRowsList()) {
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
  public final UnaryCallable<ListDataTableRowsRequest, ListDataTableRowsResponse>
      listDataTableRowsCallable() {
    return stub.listDataTableRowsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get data table row
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   DataTableRowName name =
   *       DataTableRowName.of(
   *           "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]", "[DATA_TABLE_ROW]");
   *   DataTableRow response = dataTableServiceClient.getDataTableRow(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the data table row i,e row_id. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/dataTables/{data_table}/dataTableRows/{data_table_row}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataTableRow getDataTableRow(DataTableRowName name) {
    GetDataTableRowRequest request =
        GetDataTableRowRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataTableRow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get data table row
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   String name =
   *       DataTableRowName.of(
   *               "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]", "[DATA_TABLE_ROW]")
   *           .toString();
   *   DataTableRow response = dataTableServiceClient.getDataTableRow(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the data table row i,e row_id. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/dataTables/{data_table}/dataTableRows/{data_table_row}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataTableRow getDataTableRow(String name) {
    GetDataTableRowRequest request = GetDataTableRowRequest.newBuilder().setName(name).build();
    return getDataTableRow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get data table row
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   GetDataTableRowRequest request =
   *       GetDataTableRowRequest.newBuilder()
   *           .setName(
   *               DataTableRowName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[INSTANCE]",
   *                       "[DATA_TABLE]",
   *                       "[DATA_TABLE_ROW]")
   *                   .toString())
   *           .build();
   *   DataTableRow response = dataTableServiceClient.getDataTableRow(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataTableRow getDataTableRow(GetDataTableRowRequest request) {
    return getDataTableRowCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get data table row
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   GetDataTableRowRequest request =
   *       GetDataTableRowRequest.newBuilder()
   *           .setName(
   *               DataTableRowName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[INSTANCE]",
   *                       "[DATA_TABLE]",
   *                       "[DATA_TABLE_ROW]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DataTableRow> future =
   *       dataTableServiceClient.getDataTableRowCallable().futureCall(request);
   *   // Do something.
   *   DataTableRow response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataTableRowRequest, DataTableRow> getDataTableRowCallable() {
    return stub.getDataTableRowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete data table row.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   DataTableRowName name =
   *       DataTableRowName.of(
   *           "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]", "[DATA_TABLE_ROW]");
   *   dataTableServiceClient.deleteDataTableRow(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the data table row i,e row_id. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/dataTables/{data_table}/dataTableRows/{data_table_row}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataTableRow(DataTableRowName name) {
    DeleteDataTableRowRequest request =
        DeleteDataTableRowRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    deleteDataTableRow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete data table row.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   String name =
   *       DataTableRowName.of(
   *               "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]", "[DATA_TABLE_ROW]")
   *           .toString();
   *   dataTableServiceClient.deleteDataTableRow(name);
   * }
   * }</pre>
   *
   * @param name Required. The resource name of the data table row i,e row_id. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/dataTables/{data_table}/dataTableRows/{data_table_row}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataTableRow(String name) {
    DeleteDataTableRowRequest request =
        DeleteDataTableRowRequest.newBuilder().setName(name).build();
    deleteDataTableRow(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete data table row.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   DeleteDataTableRowRequest request =
   *       DeleteDataTableRowRequest.newBuilder()
   *           .setName(
   *               DataTableRowName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[INSTANCE]",
   *                       "[DATA_TABLE]",
   *                       "[DATA_TABLE_ROW]")
   *                   .toString())
   *           .build();
   *   dataTableServiceClient.deleteDataTableRow(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataTableRow(DeleteDataTableRowRequest request) {
    deleteDataTableRowCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Delete data table row.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   DeleteDataTableRowRequest request =
   *       DeleteDataTableRowRequest.newBuilder()
   *           .setName(
   *               DataTableRowName.of(
   *                       "[PROJECT]",
   *                       "[LOCATION]",
   *                       "[INSTANCE]",
   *                       "[DATA_TABLE]",
   *                       "[DATA_TABLE_ROW]")
   *                   .toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       dataTableServiceClient.deleteDataTableRowCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDataTableRowRequest, Empty> deleteDataTableRowCallable() {
    return stub.deleteDataTableRowCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create data table rows in bulk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   DataTableName parent =
   *       DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
   *   List<CreateDataTableRowRequest> requests = new ArrayList<>();
   *   BulkCreateDataTableRowsResponse response =
   *       dataTableServiceClient.bulkCreateDataTableRows(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The resource id of the data table. Format:
   *     /projects/{project}/locations/{location}/instances/{instance}/dataTables/{data_table}
   * @param requests Required. Data table rows to create. A maximum of 1000 rows (for sync requests)
   *     or 2000 rows (for async requests) can be created in a single request. Total size of the
   *     rows should be less than 4MB.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BulkCreateDataTableRowsResponse bulkCreateDataTableRows(
      DataTableName parent, List<CreateDataTableRowRequest> requests) {
    BulkCreateDataTableRowsRequest request =
        BulkCreateDataTableRowsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return bulkCreateDataTableRows(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create data table rows in bulk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   String parent =
   *       DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]").toString();
   *   List<CreateDataTableRowRequest> requests = new ArrayList<>();
   *   BulkCreateDataTableRowsResponse response =
   *       dataTableServiceClient.bulkCreateDataTableRows(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The resource id of the data table. Format:
   *     /projects/{project}/locations/{location}/instances/{instance}/dataTables/{data_table}
   * @param requests Required. Data table rows to create. A maximum of 1000 rows (for sync requests)
   *     or 2000 rows (for async requests) can be created in a single request. Total size of the
   *     rows should be less than 4MB.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BulkCreateDataTableRowsResponse bulkCreateDataTableRows(
      String parent, List<CreateDataTableRowRequest> requests) {
    BulkCreateDataTableRowsRequest request =
        BulkCreateDataTableRowsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return bulkCreateDataTableRows(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create data table rows in bulk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   BulkCreateDataTableRowsRequest request =
   *       BulkCreateDataTableRowsRequest.newBuilder()
   *           .setParent(
   *               DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]")
   *                   .toString())
   *           .addAllRequests(new ArrayList<CreateDataTableRowRequest>())
   *           .build();
   *   BulkCreateDataTableRowsResponse response =
   *       dataTableServiceClient.bulkCreateDataTableRows(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BulkCreateDataTableRowsResponse bulkCreateDataTableRows(
      BulkCreateDataTableRowsRequest request) {
    return bulkCreateDataTableRowsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Create data table rows in bulk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   BulkCreateDataTableRowsRequest request =
   *       BulkCreateDataTableRowsRequest.newBuilder()
   *           .setParent(
   *               DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]")
   *                   .toString())
   *           .addAllRequests(new ArrayList<CreateDataTableRowRequest>())
   *           .build();
   *   ApiFuture<BulkCreateDataTableRowsResponse> future =
   *       dataTableServiceClient.bulkCreateDataTableRowsCallable().futureCall(request);
   *   // Do something.
   *   BulkCreateDataTableRowsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BulkCreateDataTableRowsRequest, BulkCreateDataTableRowsResponse>
      bulkCreateDataTableRowsCallable() {
    return stub.bulkCreateDataTableRowsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get data table rows in bulk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   DataTableName parent =
   *       DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
   *   List<GetDataTableRowRequest> requests = new ArrayList<>();
   *   BulkGetDataTableRowsResponse response =
   *       dataTableServiceClient.bulkGetDataTableRows(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The resource id of the data table. Format:
   *     /projects/{project}/locations/{location}/instances/{instance}/dataTables/{data_table}
   * @param requests Required. Data table rows to get. At max 1,000 rows can be there in a request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BulkGetDataTableRowsResponse bulkGetDataTableRows(
      DataTableName parent, List<GetDataTableRowRequest> requests) {
    BulkGetDataTableRowsRequest request =
        BulkGetDataTableRowsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return bulkGetDataTableRows(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get data table rows in bulk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   String parent =
   *       DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]").toString();
   *   List<GetDataTableRowRequest> requests = new ArrayList<>();
   *   BulkGetDataTableRowsResponse response =
   *       dataTableServiceClient.bulkGetDataTableRows(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The resource id of the data table. Format:
   *     /projects/{project}/locations/{location}/instances/{instance}/dataTables/{data_table}
   * @param requests Required. Data table rows to get. At max 1,000 rows can be there in a request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BulkGetDataTableRowsResponse bulkGetDataTableRows(
      String parent, List<GetDataTableRowRequest> requests) {
    BulkGetDataTableRowsRequest request =
        BulkGetDataTableRowsRequest.newBuilder().setParent(parent).addAllRequests(requests).build();
    return bulkGetDataTableRows(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get data table rows in bulk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   BulkGetDataTableRowsRequest request =
   *       BulkGetDataTableRowsRequest.newBuilder()
   *           .setParent(
   *               DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]")
   *                   .toString())
   *           .addAllRequests(new ArrayList<GetDataTableRowRequest>())
   *           .build();
   *   BulkGetDataTableRowsResponse response = dataTableServiceClient.bulkGetDataTableRows(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BulkGetDataTableRowsResponse bulkGetDataTableRows(
      BulkGetDataTableRowsRequest request) {
    return bulkGetDataTableRowsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get data table rows in bulk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   BulkGetDataTableRowsRequest request =
   *       BulkGetDataTableRowsRequest.newBuilder()
   *           .setParent(
   *               DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]")
   *                   .toString())
   *           .addAllRequests(new ArrayList<GetDataTableRowRequest>())
   *           .build();
   *   ApiFuture<BulkGetDataTableRowsResponse> future =
   *       dataTableServiceClient.bulkGetDataTableRowsCallable().futureCall(request);
   *   // Do something.
   *   BulkGetDataTableRowsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BulkGetDataTableRowsRequest, BulkGetDataTableRowsResponse>
      bulkGetDataTableRowsCallable() {
    return stub.bulkGetDataTableRowsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Replace all existing data table rows with new data table rows.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   DataTableName parent =
   *       DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
   *   List<CreateDataTableRowRequest> requests = new ArrayList<>();
   *   BulkReplaceDataTableRowsResponse response =
   *       dataTableServiceClient.bulkReplaceDataTableRows(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The resource id of the data table. Format:
   *     /projects/{project}/locations/{location}/instances/{instance}/dataTables/{data_table}
   * @param requests Required. Data table rows to replace the existing data table rows. A maximum of
   *     1000 rows (for sync requests) or 2000 rows (for async requests) can be replaced in a single
   *     request. Total size of the rows should be less than 4MB.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BulkReplaceDataTableRowsResponse bulkReplaceDataTableRows(
      DataTableName parent, List<CreateDataTableRowRequest> requests) {
    BulkReplaceDataTableRowsRequest request =
        BulkReplaceDataTableRowsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return bulkReplaceDataTableRows(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Replace all existing data table rows with new data table rows.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   String parent =
   *       DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]").toString();
   *   List<CreateDataTableRowRequest> requests = new ArrayList<>();
   *   BulkReplaceDataTableRowsResponse response =
   *       dataTableServiceClient.bulkReplaceDataTableRows(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The resource id of the data table. Format:
   *     /projects/{project}/locations/{location}/instances/{instance}/dataTables/{data_table}
   * @param requests Required. Data table rows to replace the existing data table rows. A maximum of
   *     1000 rows (for sync requests) or 2000 rows (for async requests) can be replaced in a single
   *     request. Total size of the rows should be less than 4MB.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BulkReplaceDataTableRowsResponse bulkReplaceDataTableRows(
      String parent, List<CreateDataTableRowRequest> requests) {
    BulkReplaceDataTableRowsRequest request =
        BulkReplaceDataTableRowsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return bulkReplaceDataTableRows(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Replace all existing data table rows with new data table rows.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   BulkReplaceDataTableRowsRequest request =
   *       BulkReplaceDataTableRowsRequest.newBuilder()
   *           .setParent(
   *               DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]")
   *                   .toString())
   *           .addAllRequests(new ArrayList<CreateDataTableRowRequest>())
   *           .build();
   *   BulkReplaceDataTableRowsResponse response =
   *       dataTableServiceClient.bulkReplaceDataTableRows(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BulkReplaceDataTableRowsResponse bulkReplaceDataTableRows(
      BulkReplaceDataTableRowsRequest request) {
    return bulkReplaceDataTableRowsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Replace all existing data table rows with new data table rows.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   BulkReplaceDataTableRowsRequest request =
   *       BulkReplaceDataTableRowsRequest.newBuilder()
   *           .setParent(
   *               DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]")
   *                   .toString())
   *           .addAllRequests(new ArrayList<CreateDataTableRowRequest>())
   *           .build();
   *   ApiFuture<BulkReplaceDataTableRowsResponse> future =
   *       dataTableServiceClient.bulkReplaceDataTableRowsCallable().futureCall(request);
   *   // Do something.
   *   BulkReplaceDataTableRowsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BulkReplaceDataTableRowsRequest, BulkReplaceDataTableRowsResponse>
      bulkReplaceDataTableRowsCallable() {
    return stub.bulkReplaceDataTableRowsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update data table rows in bulk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   DataTableName parent =
   *       DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]");
   *   List<UpdateDataTableRowRequest> requests = new ArrayList<>();
   *   BulkUpdateDataTableRowsResponse response =
   *       dataTableServiceClient.bulkUpdateDataTableRows(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The resource id of the data table. Format:
   *     /projects/{project}/locations/{location}/instances/{instance}/dataTables/{data_table}
   * @param requests Required. Data table rows to update. At max 1,000 rows (or rows with size less
   *     than 2MB) can be there in a request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BulkUpdateDataTableRowsResponse bulkUpdateDataTableRows(
      DataTableName parent, List<UpdateDataTableRowRequest> requests) {
    BulkUpdateDataTableRowsRequest request =
        BulkUpdateDataTableRowsRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .addAllRequests(requests)
            .build();
    return bulkUpdateDataTableRows(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update data table rows in bulk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   String parent =
   *       DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]").toString();
   *   List<UpdateDataTableRowRequest> requests = new ArrayList<>();
   *   BulkUpdateDataTableRowsResponse response =
   *       dataTableServiceClient.bulkUpdateDataTableRows(parent, requests);
   * }
   * }</pre>
   *
   * @param parent Required. The resource id of the data table. Format:
   *     /projects/{project}/locations/{location}/instances/{instance}/dataTables/{data_table}
   * @param requests Required. Data table rows to update. At max 1,000 rows (or rows with size less
   *     than 2MB) can be there in a request.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BulkUpdateDataTableRowsResponse bulkUpdateDataTableRows(
      String parent, List<UpdateDataTableRowRequest> requests) {
    BulkUpdateDataTableRowsRequest request =
        BulkUpdateDataTableRowsRequest.newBuilder()
            .setParent(parent)
            .addAllRequests(requests)
            .build();
    return bulkUpdateDataTableRows(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update data table rows in bulk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   BulkUpdateDataTableRowsRequest request =
   *       BulkUpdateDataTableRowsRequest.newBuilder()
   *           .setParent(
   *               DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]")
   *                   .toString())
   *           .addAllRequests(new ArrayList<UpdateDataTableRowRequest>())
   *           .build();
   *   BulkUpdateDataTableRowsResponse response =
   *       dataTableServiceClient.bulkUpdateDataTableRows(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final BulkUpdateDataTableRowsResponse bulkUpdateDataTableRows(
      BulkUpdateDataTableRowsRequest request) {
    return bulkUpdateDataTableRowsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Update data table rows in bulk.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   BulkUpdateDataTableRowsRequest request =
   *       BulkUpdateDataTableRowsRequest.newBuilder()
   *           .setParent(
   *               DataTableName.of("[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE]")
   *                   .toString())
   *           .addAllRequests(new ArrayList<UpdateDataTableRowRequest>())
   *           .build();
   *   ApiFuture<BulkUpdateDataTableRowsResponse> future =
   *       dataTableServiceClient.bulkUpdateDataTableRowsCallable().futureCall(request);
   *   // Do something.
   *   BulkUpdateDataTableRowsResponse response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<BulkUpdateDataTableRowsRequest, BulkUpdateDataTableRowsResponse>
      bulkUpdateDataTableRowsCallable() {
    return stub.bulkUpdateDataTableRowsCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the error for a data table operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   DataTableOperationErrorsName name =
   *       DataTableOperationErrorsName.of(
   *           "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE_OPERATION_ERRORS]");
   *   DataTableOperationErrors response = dataTableServiceClient.getDataTableOperationErrors(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name for the data table operation errors. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/dataTableOperationErrors/{data_table_operation_errors}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataTableOperationErrors getDataTableOperationErrors(
      DataTableOperationErrorsName name) {
    GetDataTableOperationErrorsRequest request =
        GetDataTableOperationErrorsRequest.newBuilder()
            .setName(name == null ? null : name.toString())
            .build();
    return getDataTableOperationErrors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the error for a data table operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   String name =
   *       DataTableOperationErrorsName.of(
   *               "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE_OPERATION_ERRORS]")
   *           .toString();
   *   DataTableOperationErrors response = dataTableServiceClient.getDataTableOperationErrors(name);
   * }
   * }</pre>
   *
   * @param name Required. Resource name for the data table operation errors. Format:
   *     projects/{project}/locations/{location}/instances/{instance}/dataTableOperationErrors/{data_table_operation_errors}
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataTableOperationErrors getDataTableOperationErrors(String name) {
    GetDataTableOperationErrorsRequest request =
        GetDataTableOperationErrorsRequest.newBuilder().setName(name).build();
    return getDataTableOperationErrors(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the error for a data table operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   GetDataTableOperationErrorsRequest request =
   *       GetDataTableOperationErrorsRequest.newBuilder()
   *           .setName(
   *               DataTableOperationErrorsName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE_OPERATION_ERRORS]")
   *                   .toString())
   *           .build();
   *   DataTableOperationErrors response =
   *       dataTableServiceClient.getDataTableOperationErrors(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataTableOperationErrors getDataTableOperationErrors(
      GetDataTableOperationErrorsRequest request) {
    return getDataTableOperationErrorsCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Get the error for a data table operation.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataTableServiceClient dataTableServiceClient = DataTableServiceClient.create()) {
   *   GetDataTableOperationErrorsRequest request =
   *       GetDataTableOperationErrorsRequest.newBuilder()
   *           .setName(
   *               DataTableOperationErrorsName.of(
   *                       "[PROJECT]", "[LOCATION]", "[INSTANCE]", "[DATA_TABLE_OPERATION_ERRORS]")
   *                   .toString())
   *           .build();
   *   ApiFuture<DataTableOperationErrors> future =
   *       dataTableServiceClient.getDataTableOperationErrorsCallable().futureCall(request);
   *   // Do something.
   *   DataTableOperationErrors response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataTableOperationErrorsRequest, DataTableOperationErrors>
      getDataTableOperationErrorsCallable() {
    return stub.getDataTableOperationErrorsCallable();
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

  public static class ListDataTablesPagedResponse
      extends AbstractPagedListResponse<
          ListDataTablesRequest,
          ListDataTablesResponse,
          DataTable,
          ListDataTablesPage,
          ListDataTablesFixedSizeCollection> {

    public static ApiFuture<ListDataTablesPagedResponse> createAsync(
        PageContext<ListDataTablesRequest, ListDataTablesResponse, DataTable> context,
        ApiFuture<ListDataTablesResponse> futureResponse) {
      ApiFuture<ListDataTablesPage> futurePage =
          ListDataTablesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDataTablesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDataTablesPagedResponse(ListDataTablesPage page) {
      super(page, ListDataTablesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataTablesPage
      extends AbstractPage<
          ListDataTablesRequest, ListDataTablesResponse, DataTable, ListDataTablesPage> {

    private ListDataTablesPage(
        PageContext<ListDataTablesRequest, ListDataTablesResponse, DataTable> context,
        ListDataTablesResponse response) {
      super(context, response);
    }

    private static ListDataTablesPage createEmptyPage() {
      return new ListDataTablesPage(null, null);
    }

    @Override
    protected ListDataTablesPage createPage(
        PageContext<ListDataTablesRequest, ListDataTablesResponse, DataTable> context,
        ListDataTablesResponse response) {
      return new ListDataTablesPage(context, response);
    }

    @Override
    public ApiFuture<ListDataTablesPage> createPageAsync(
        PageContext<ListDataTablesRequest, ListDataTablesResponse, DataTable> context,
        ApiFuture<ListDataTablesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataTablesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataTablesRequest,
          ListDataTablesResponse,
          DataTable,
          ListDataTablesPage,
          ListDataTablesFixedSizeCollection> {

    private ListDataTablesFixedSizeCollection(List<ListDataTablesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataTablesFixedSizeCollection createEmptyCollection() {
      return new ListDataTablesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataTablesFixedSizeCollection createCollection(
        List<ListDataTablesPage> pages, int collectionSize) {
      return new ListDataTablesFixedSizeCollection(pages, collectionSize);
    }
  }

  public static class ListDataTableRowsPagedResponse
      extends AbstractPagedListResponse<
          ListDataTableRowsRequest,
          ListDataTableRowsResponse,
          DataTableRow,
          ListDataTableRowsPage,
          ListDataTableRowsFixedSizeCollection> {

    public static ApiFuture<ListDataTableRowsPagedResponse> createAsync(
        PageContext<ListDataTableRowsRequest, ListDataTableRowsResponse, DataTableRow> context,
        ApiFuture<ListDataTableRowsResponse> futureResponse) {
      ApiFuture<ListDataTableRowsPage> futurePage =
          ListDataTableRowsPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDataTableRowsPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDataTableRowsPagedResponse(ListDataTableRowsPage page) {
      super(page, ListDataTableRowsFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataTableRowsPage
      extends AbstractPage<
          ListDataTableRowsRequest,
          ListDataTableRowsResponse,
          DataTableRow,
          ListDataTableRowsPage> {

    private ListDataTableRowsPage(
        PageContext<ListDataTableRowsRequest, ListDataTableRowsResponse, DataTableRow> context,
        ListDataTableRowsResponse response) {
      super(context, response);
    }

    private static ListDataTableRowsPage createEmptyPage() {
      return new ListDataTableRowsPage(null, null);
    }

    @Override
    protected ListDataTableRowsPage createPage(
        PageContext<ListDataTableRowsRequest, ListDataTableRowsResponse, DataTableRow> context,
        ListDataTableRowsResponse response) {
      return new ListDataTableRowsPage(context, response);
    }

    @Override
    public ApiFuture<ListDataTableRowsPage> createPageAsync(
        PageContext<ListDataTableRowsRequest, ListDataTableRowsResponse, DataTableRow> context,
        ApiFuture<ListDataTableRowsResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataTableRowsFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataTableRowsRequest,
          ListDataTableRowsResponse,
          DataTableRow,
          ListDataTableRowsPage,
          ListDataTableRowsFixedSizeCollection> {

    private ListDataTableRowsFixedSizeCollection(
        List<ListDataTableRowsPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataTableRowsFixedSizeCollection createEmptyCollection() {
      return new ListDataTableRowsFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataTableRowsFixedSizeCollection createCollection(
        List<ListDataTableRowsPage> pages, int collectionSize) {
      return new ListDataTableRowsFixedSizeCollection(pages, collectionSize);
    }
  }
}
