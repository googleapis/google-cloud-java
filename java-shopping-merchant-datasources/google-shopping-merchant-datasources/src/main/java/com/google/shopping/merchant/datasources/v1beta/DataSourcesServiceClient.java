/*
 * Copyright 2024 Google LLC
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

package com.google.shopping.merchant.datasources.v1beta;

import com.google.api.core.ApiFuture;
import com.google.api.core.ApiFutures;
import com.google.api.core.BetaApi;
import com.google.api.gax.core.BackgroundResource;
import com.google.api.gax.paging.AbstractFixedSizeCollection;
import com.google.api.gax.paging.AbstractPage;
import com.google.api.gax.paging.AbstractPagedListResponse;
import com.google.api.gax.rpc.PageContext;
import com.google.api.gax.rpc.UnaryCallable;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.protobuf.Empty;
import com.google.protobuf.FieldMask;
import com.google.shopping.merchant.datasources.v1beta.stub.DataSourcesServiceStub;
import com.google.shopping.merchant.datasources.v1beta.stub.DataSourcesServiceStubSettings;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Generated;

// AUTO-GENERATED DOCUMENTATION AND CLASS.
/**
 * Service Description: Service to manage primary, supplemental, inventory and other data sources.
 * See more in the [Merchant Center](https://support.google.com/merchants/answer/7439058) help
 * article.
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
 * try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
 *   DataSourceName name = DataSourceName.of("[ACCOUNT]", "[DATASOURCE]");
 *   DataSource response = dataSourcesServiceClient.getDataSource(name);
 * }
 * }</pre>
 *
 * <p>Note: close() needs to be called on the DataSourcesServiceClient object to clean up resources
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
 *      <td><p> GetDataSource</td>
 *      <td><p> Retrieves the data source configuration for the given account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> getDataSource(GetDataSourceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> getDataSource(DataSourceName name)
 *           <li><p> getDataSource(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> getDataSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> ListDataSources</td>
 *      <td><p> Lists the configurations for data sources for the given account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> listDataSources(ListDataSourcesRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> listDataSources(AccountName parent)
 *           <li><p> listDataSources(String parent)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> listDataSourcesPagedCallable()
 *           <li><p> listDataSourcesCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> CreateDataSource</td>
 *      <td><p> Creates the new data source configuration for the given account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> createDataSource(CreateDataSourceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> createDataSource(AccountName parent, DataSource dataSource)
 *           <li><p> createDataSource(String parent, DataSource dataSource)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> createDataSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> UpdateDataSource</td>
 *      <td><p> Updates the existing data source configuration. The fields that are set in the update mask but not provided in the resource will be deleted.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> updateDataSource(UpdateDataSourceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> updateDataSource(DataSource dataSource, FieldMask updateMask)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> updateDataSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> DeleteDataSource</td>
 *      <td><p> Deletes a data source from your Merchant Center account.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> deleteDataSource(DeleteDataSourceRequest request)
 *      </ul>
 *      <p>"Flattened" method variants have converted the fields of the request object into function parameters to enable multiple ways to call the same method.</p>
 *      <ul>
 *           <li><p> deleteDataSource(DataSourceName name)
 *           <li><p> deleteDataSource(String name)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> deleteDataSourceCallable()
 *      </ul>
 *       </td>
 *    </tr>
 *    <tr>
 *      <td><p> FetchDataSource</td>
 *      <td><p> Performs the data fetch immediately (even outside fetch schedule) on a data source from your Merchant Center Account. If you need to call this method more than once per day, you should use the Products service to update your product data instead. This method only works on data sources with a file input set.</td>
 *      <td>
 *      <p>Request object method variants only take one parameter, a request object, which must be constructed before the call.</p>
 *      <ul>
 *           <li><p> fetchDataSource(FetchDataSourceRequest request)
 *      </ul>
 *      <p>Callable method variants take no parameters and return an immutable API callable object, which can be used to initiate calls to the service.</p>
 *      <ul>
 *           <li><p> fetchDataSourceCallable()
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
 * <p>This class can be customized by passing in a custom instance of DataSourcesServiceSettings to
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
 * DataSourcesServiceSettings dataSourcesServiceSettings =
 *     DataSourcesServiceSettings.newBuilder()
 *         .setCredentialsProvider(FixedCredentialsProvider.create(myCredentials))
 *         .build();
 * DataSourcesServiceClient dataSourcesServiceClient =
 *     DataSourcesServiceClient.create(dataSourcesServiceSettings);
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
 * DataSourcesServiceSettings dataSourcesServiceSettings =
 *     DataSourcesServiceSettings.newBuilder().setEndpoint(myEndpoint).build();
 * DataSourcesServiceClient dataSourcesServiceClient =
 *     DataSourcesServiceClient.create(dataSourcesServiceSettings);
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
 * DataSourcesServiceSettings dataSourcesServiceSettings =
 *     DataSourcesServiceSettings.newHttpJsonBuilder().build();
 * DataSourcesServiceClient dataSourcesServiceClient =
 *     DataSourcesServiceClient.create(dataSourcesServiceSettings);
 * }</pre>
 *
 * <p>Please refer to the GitHub repository's samples for more quickstart code snippets.
 */
@BetaApi
@Generated("by gapic-generator-java")
public class DataSourcesServiceClient implements BackgroundResource {
  private final DataSourcesServiceSettings settings;
  private final DataSourcesServiceStub stub;

  /** Constructs an instance of DataSourcesServiceClient with default settings. */
  public static final DataSourcesServiceClient create() throws IOException {
    return create(DataSourcesServiceSettings.newBuilder().build());
  }

  /**
   * Constructs an instance of DataSourcesServiceClient, using the given settings. The channels are
   * created based on the settings passed in, or defaults for any settings that are not set.
   */
  public static final DataSourcesServiceClient create(DataSourcesServiceSettings settings)
      throws IOException {
    return new DataSourcesServiceClient(settings);
  }

  /**
   * Constructs an instance of DataSourcesServiceClient, using the given stub for making calls. This
   * is for advanced usage - prefer using create(DataSourcesServiceSettings).
   */
  public static final DataSourcesServiceClient create(DataSourcesServiceStub stub) {
    return new DataSourcesServiceClient(stub);
  }

  /**
   * Constructs an instance of DataSourcesServiceClient, using the given settings. This is protected
   * so that it is easy to make a subclass, but otherwise, the static factory methods should be
   * preferred.
   */
  protected DataSourcesServiceClient(DataSourcesServiceSettings settings) throws IOException {
    this.settings = settings;
    this.stub = ((DataSourcesServiceStubSettings) settings.getStubSettings()).createStub();
  }

  protected DataSourcesServiceClient(DataSourcesServiceStub stub) {
    this.settings = null;
    this.stub = stub;
  }

  public final DataSourcesServiceSettings getSettings() {
    return settings;
  }

  public DataSourcesServiceStub getStub() {
    return stub;
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the data source configuration for the given account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
   *   DataSourceName name = DataSourceName.of("[ACCOUNT]", "[DATASOURCE]");
   *   DataSource response = dataSourcesServiceClient.getDataSource(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the data source to retrieve. Format:
   *     `accounts/{account}/dataSources/{datasource}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSource getDataSource(DataSourceName name) {
    GetDataSourceRequest request =
        GetDataSourceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    return getDataSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the data source configuration for the given account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
   *   String name = DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString();
   *   DataSource response = dataSourcesServiceClient.getDataSource(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the data source to retrieve. Format:
   *     `accounts/{account}/dataSources/{datasource}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSource getDataSource(String name) {
    GetDataSourceRequest request = GetDataSourceRequest.newBuilder().setName(name).build();
    return getDataSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the data source configuration for the given account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
   *   GetDataSourceRequest request =
   *       GetDataSourceRequest.newBuilder()
   *           .setName(DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString())
   *           .build();
   *   DataSource response = dataSourcesServiceClient.getDataSource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSource getDataSource(GetDataSourceRequest request) {
    return getDataSourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Retrieves the data source configuration for the given account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
   *   GetDataSourceRequest request =
   *       GetDataSourceRequest.newBuilder()
   *           .setName(DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString())
   *           .build();
   *   ApiFuture<DataSource> future =
   *       dataSourcesServiceClient.getDataSourceCallable().futureCall(request);
   *   // Do something.
   *   DataSource response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<GetDataSourceRequest, DataSource> getDataSourceCallable() {
    return stub.getDataSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the configurations for data sources for the given account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   for (DataSource element : dataSourcesServiceClient.listDataSources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The account to list data sources for. Format: `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataSourcesPagedResponse listDataSources(AccountName parent) {
    ListDataSourcesRequest request =
        ListDataSourcesRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .build();
    return listDataSources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the configurations for data sources for the given account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   for (DataSource element : dataSourcesServiceClient.listDataSources(parent).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param parent Required. The account to list data sources for. Format: `accounts/{account}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataSourcesPagedResponse listDataSources(String parent) {
    ListDataSourcesRequest request = ListDataSourcesRequest.newBuilder().setParent(parent).build();
    return listDataSources(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the configurations for data sources for the given account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
   *   ListDataSourcesRequest request =
   *       ListDataSourcesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   for (DataSource element : dataSourcesServiceClient.listDataSources(request).iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final ListDataSourcesPagedResponse listDataSources(ListDataSourcesRequest request) {
    return listDataSourcesPagedCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the configurations for data sources for the given account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
   *   ListDataSourcesRequest request =
   *       ListDataSourcesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   ApiFuture<DataSource> future =
   *       dataSourcesServiceClient.listDataSourcesPagedCallable().futureCall(request);
   *   // Do something.
   *   for (DataSource element : future.get().iterateAll()) {
   *     // doThingsWith(element);
   *   }
   * }
   * }</pre>
   */
  public final UnaryCallable<ListDataSourcesRequest, ListDataSourcesPagedResponse>
      listDataSourcesPagedCallable() {
    return stub.listDataSourcesPagedCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Lists the configurations for data sources for the given account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
   *   ListDataSourcesRequest request =
   *       ListDataSourcesRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setPageSize(883849137)
   *           .setPageToken("pageToken873572522")
   *           .build();
   *   while (true) {
   *     ListDataSourcesResponse response =
   *         dataSourcesServiceClient.listDataSourcesCallable().call(request);
   *     for (DataSource element : response.getDataSourcesList()) {
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
  public final UnaryCallable<ListDataSourcesRequest, ListDataSourcesResponse>
      listDataSourcesCallable() {
    return stub.listDataSourcesCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates the new data source configuration for the given account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
   *   AccountName parent = AccountName.of("[ACCOUNT]");
   *   DataSource dataSource = DataSource.newBuilder().build();
   *   DataSource response = dataSourcesServiceClient.createDataSource(parent, dataSource);
   * }
   * }</pre>
   *
   * @param parent Required. The account where this data source will be created. Format:
   *     `accounts/{account}`
   * @param dataSource Required. The data source to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSource createDataSource(AccountName parent, DataSource dataSource) {
    CreateDataSourceRequest request =
        CreateDataSourceRequest.newBuilder()
            .setParent(parent == null ? null : parent.toString())
            .setDataSource(dataSource)
            .build();
    return createDataSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates the new data source configuration for the given account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
   *   String parent = AccountName.of("[ACCOUNT]").toString();
   *   DataSource dataSource = DataSource.newBuilder().build();
   *   DataSource response = dataSourcesServiceClient.createDataSource(parent, dataSource);
   * }
   * }</pre>
   *
   * @param parent Required. The account where this data source will be created. Format:
   *     `accounts/{account}`
   * @param dataSource Required. The data source to create.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSource createDataSource(String parent, DataSource dataSource) {
    CreateDataSourceRequest request =
        CreateDataSourceRequest.newBuilder().setParent(parent).setDataSource(dataSource).build();
    return createDataSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates the new data source configuration for the given account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
   *   CreateDataSourceRequest request =
   *       CreateDataSourceRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setDataSource(DataSource.newBuilder().build())
   *           .build();
   *   DataSource response = dataSourcesServiceClient.createDataSource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSource createDataSource(CreateDataSourceRequest request) {
    return createDataSourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Creates the new data source configuration for the given account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
   *   CreateDataSourceRequest request =
   *       CreateDataSourceRequest.newBuilder()
   *           .setParent(AccountName.of("[ACCOUNT]").toString())
   *           .setDataSource(DataSource.newBuilder().build())
   *           .build();
   *   ApiFuture<DataSource> future =
   *       dataSourcesServiceClient.createDataSourceCallable().futureCall(request);
   *   // Do something.
   *   DataSource response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<CreateDataSourceRequest, DataSource> createDataSourceCallable() {
    return stub.createDataSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the existing data source configuration. The fields that are set in the update mask but
   * not provided in the resource will be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
   *   DataSource dataSource = DataSource.newBuilder().build();
   *   FieldMask updateMask = FieldMask.newBuilder().build();
   *   DataSource response = dataSourcesServiceClient.updateDataSource(dataSource, updateMask);
   * }
   * }</pre>
   *
   * @param dataSource Required. The data source resource to update.
   * @param updateMask Required. The list of data source fields to be updated.
   *     <p>Fields specified in the update mask without a value specified in the body will be
   *     deleted from the data source.
   *     <p>Providing special "&#42;" value for full data source replacement is not supported.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSource updateDataSource(DataSource dataSource, FieldMask updateMask) {
    UpdateDataSourceRequest request =
        UpdateDataSourceRequest.newBuilder()
            .setDataSource(dataSource)
            .setUpdateMask(updateMask)
            .build();
    return updateDataSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the existing data source configuration. The fields that are set in the update mask but
   * not provided in the resource will be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
   *   UpdateDataSourceRequest request =
   *       UpdateDataSourceRequest.newBuilder()
   *           .setDataSource(DataSource.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   DataSource response = dataSourcesServiceClient.updateDataSource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final DataSource updateDataSource(UpdateDataSourceRequest request) {
    return updateDataSourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Updates the existing data source configuration. The fields that are set in the update mask but
   * not provided in the resource will be deleted.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
   *   UpdateDataSourceRequest request =
   *       UpdateDataSourceRequest.newBuilder()
   *           .setDataSource(DataSource.newBuilder().build())
   *           .setUpdateMask(FieldMask.newBuilder().build())
   *           .build();
   *   ApiFuture<DataSource> future =
   *       dataSourcesServiceClient.updateDataSourceCallable().futureCall(request);
   *   // Do something.
   *   DataSource response = future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<UpdateDataSourceRequest, DataSource> updateDataSourceCallable() {
    return stub.updateDataSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a data source from your Merchant Center account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
   *   DataSourceName name = DataSourceName.of("[ACCOUNT]", "[DATASOURCE]");
   *   dataSourcesServiceClient.deleteDataSource(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the data source to delete. Format:
   *     `accounts/{account}/dataSources/{datasource}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataSource(DataSourceName name) {
    DeleteDataSourceRequest request =
        DeleteDataSourceRequest.newBuilder().setName(name == null ? null : name.toString()).build();
    deleteDataSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a data source from your Merchant Center account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
   *   String name = DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString();
   *   dataSourcesServiceClient.deleteDataSource(name);
   * }
   * }</pre>
   *
   * @param name Required. The name of the data source to delete. Format:
   *     `accounts/{account}/dataSources/{datasource}`
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataSource(String name) {
    DeleteDataSourceRequest request = DeleteDataSourceRequest.newBuilder().setName(name).build();
    deleteDataSource(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a data source from your Merchant Center account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
   *   DeleteDataSourceRequest request =
   *       DeleteDataSourceRequest.newBuilder()
   *           .setName(DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString())
   *           .build();
   *   dataSourcesServiceClient.deleteDataSource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void deleteDataSource(DeleteDataSourceRequest request) {
    deleteDataSourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Deletes a data source from your Merchant Center account.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
   *   DeleteDataSourceRequest request =
   *       DeleteDataSourceRequest.newBuilder()
   *           .setName(DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       dataSourcesServiceClient.deleteDataSourceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<DeleteDataSourceRequest, Empty> deleteDataSourceCallable() {
    return stub.deleteDataSourceCallable();
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs the data fetch immediately (even outside fetch schedule) on a data source from your
   * Merchant Center Account. If you need to call this method more than once per day, you should use
   * the Products service to update your product data instead. This method only works on data
   * sources with a file input set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
   *   FetchDataSourceRequest request =
   *       FetchDataSourceRequest.newBuilder()
   *           .setName(DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString())
   *           .build();
   *   dataSourcesServiceClient.fetchDataSource(request);
   * }
   * }</pre>
   *
   * @param request The request object containing all of the parameters for the API call.
   * @throws com.google.api.gax.rpc.ApiException if the remote call fails
   */
  public final void fetchDataSource(FetchDataSourceRequest request) {
    fetchDataSourceCallable().call(request);
  }

  // AUTO-GENERATED DOCUMENTATION AND METHOD.
  /**
   * Performs the data fetch immediately (even outside fetch schedule) on a data source from your
   * Merchant Center Account. If you need to call this method more than once per day, you should use
   * the Products service to update your product data instead. This method only works on data
   * sources with a file input set.
   *
   * <p>Sample code:
   *
   * <pre>{@code
   * // This snippet has been automatically generated and should be regarded as a code template only.
   * // It will require modifications to work:
   * // - It may require correct/in-range values for request initialization.
   * // - It may require specifying regional endpoints when creating the service client as shown in
   * // https://cloud.google.com/java/docs/setup#configure_endpoints_for_the_client_library
   * try (DataSourcesServiceClient dataSourcesServiceClient = DataSourcesServiceClient.create()) {
   *   FetchDataSourceRequest request =
   *       FetchDataSourceRequest.newBuilder()
   *           .setName(DataSourceName.of("[ACCOUNT]", "[DATASOURCE]").toString())
   *           .build();
   *   ApiFuture<Empty> future =
   *       dataSourcesServiceClient.fetchDataSourceCallable().futureCall(request);
   *   // Do something.
   *   future.get();
   * }
   * }</pre>
   */
  public final UnaryCallable<FetchDataSourceRequest, Empty> fetchDataSourceCallable() {
    return stub.fetchDataSourceCallable();
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

  public static class ListDataSourcesPagedResponse
      extends AbstractPagedListResponse<
          ListDataSourcesRequest,
          ListDataSourcesResponse,
          DataSource,
          ListDataSourcesPage,
          ListDataSourcesFixedSizeCollection> {

    public static ApiFuture<ListDataSourcesPagedResponse> createAsync(
        PageContext<ListDataSourcesRequest, ListDataSourcesResponse, DataSource> context,
        ApiFuture<ListDataSourcesResponse> futureResponse) {
      ApiFuture<ListDataSourcesPage> futurePage =
          ListDataSourcesPage.createEmptyPage().createPageAsync(context, futureResponse);
      return ApiFutures.transform(
          futurePage,
          input -> new ListDataSourcesPagedResponse(input),
          MoreExecutors.directExecutor());
    }

    private ListDataSourcesPagedResponse(ListDataSourcesPage page) {
      super(page, ListDataSourcesFixedSizeCollection.createEmptyCollection());
    }
  }

  public static class ListDataSourcesPage
      extends AbstractPage<
          ListDataSourcesRequest, ListDataSourcesResponse, DataSource, ListDataSourcesPage> {

    private ListDataSourcesPage(
        PageContext<ListDataSourcesRequest, ListDataSourcesResponse, DataSource> context,
        ListDataSourcesResponse response) {
      super(context, response);
    }

    private static ListDataSourcesPage createEmptyPage() {
      return new ListDataSourcesPage(null, null);
    }

    @Override
    protected ListDataSourcesPage createPage(
        PageContext<ListDataSourcesRequest, ListDataSourcesResponse, DataSource> context,
        ListDataSourcesResponse response) {
      return new ListDataSourcesPage(context, response);
    }

    @Override
    public ApiFuture<ListDataSourcesPage> createPageAsync(
        PageContext<ListDataSourcesRequest, ListDataSourcesResponse, DataSource> context,
        ApiFuture<ListDataSourcesResponse> futureResponse) {
      return super.createPageAsync(context, futureResponse);
    }
  }

  public static class ListDataSourcesFixedSizeCollection
      extends AbstractFixedSizeCollection<
          ListDataSourcesRequest,
          ListDataSourcesResponse,
          DataSource,
          ListDataSourcesPage,
          ListDataSourcesFixedSizeCollection> {

    private ListDataSourcesFixedSizeCollection(
        List<ListDataSourcesPage> pages, int collectionSize) {
      super(pages, collectionSize);
    }

    private static ListDataSourcesFixedSizeCollection createEmptyCollection() {
      return new ListDataSourcesFixedSizeCollection(null, 0);
    }

    @Override
    protected ListDataSourcesFixedSizeCollection createCollection(
        List<ListDataSourcesPage> pages, int collectionSize) {
      return new ListDataSourcesFixedSizeCollection(pages, collectionSize);
    }
  }
}
